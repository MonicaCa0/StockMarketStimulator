<template>
  <div>
      Your balance is: {{portfolio}}
  </div>
</template>

<script>
import PortfolioService from '../services/PortfolioService.js'
export default {
    name: "portfolio-balance",
    props:["portfolio"],
    data(){
        return{
            balance:0
        }
    },

    created(){
        PortfolioService.getPortfolioBalance(3,1).then(response =>{
            this.balance = response.data;
            alert(response.data);
        })
            .catch(error =>{
                if(error.response){
                    alert("ERROR GETTING BALANCE")
                }
            })
        
    }

}
</script>

<style>

</style>
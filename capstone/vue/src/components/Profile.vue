<template>
  <div class="background">
      <div class="container">
          <h1 class="header">Portfolio</h1>
          <div class="content">
              <h2>Stocks</h2>
              <li v-for="stocks in stock" :key="stocks.id">
                    {{stocks.stock_name}}
              </li>
              </div>

        </div>
  </div>
</template>

<script >
import stockService from '../services/StockService'
export default{
        data(){
            return{
            stock: [],
        };
    },
    created(){
        stockService.getAllStock().then(response =>{
            this.stock = response.data;
        })
    }
    }

</script>

<style>
.background{
  background-color:#AFB2ED;
    height:100vh;
    background-repeat: no-repeat;
    background-size: cover;
    background-image:linear-gradient(-45deg,#AFB2ED 10%,#FFACBD,#AFB2ED );
}

.container{
   display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.content{
    display: flex;
    justify-content: flex-start;
}

h2{
    font-size:50px;
     text-align: center;
      color:white;
    text-shadow:2px 2px#6A6EBD;
}

.header{
     padding-top: 20px;
    font-size:50px;
     text-align: center;
    color:white;
    text-shadow:2px 2px#6A6EBD;
   
}


</style>
<template>
  <div id="about">
      <div class="content">
          <h1> Welcome to Apricot Stocks!</h1>
          <div class="container">
              
              <div class ="text">
            <p>Have fear about using your own money in the stock market? We have a solution! Apricot is a virtual stock market stimulator where you can hone your stock market skills
                 and invite/challenge others to show off your trading abilities with no risk!</p>
                </div>

                
          </div>
      </div>
         <div class ="buttons">
                <router-link v-bind:to="{name:'landing'}"><Button  class="lowerButtons" :title="'Back Home'"></Button></router-link>
                <router-link v-bind:to="{name:'register'}"> <Button class="lowerButtons" :title="'Join Today!'"></Button></router-link>

                 </div>
      </div>
    
     
</template>

<script>
import Button from '../components/Button.vue'
export default {
components:{
    Button
}
}
</script>

<style scoped>

#about{
height: 100vh; 
background-image:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9)),
url("../assets/stocks.webp");
background-repeat: no-repeat;
background-position: center;
background-size: cover;
color: #3e309c;
display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;


}
h1{
    font-size:50px;
    text-align: center;
    color:#EAFF45;
    text-shadow:1px 1px#6A6EBD;
    
    
}
.container{

}




.text{
    font-size:23px;
    padding-left:250px;
    padding-right: 250px;
    text-align: center;
    padding-bottom: 15px;
    
}


.content{
    font-family: Cambria, Cochin;
}

.body{
    padding: 20px;
    text-align: center;
}

.lowerButtons{
    cursor: pointer;
    background:none;
    border-color:#EAFF45;
    border-radius: 5px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    color: #EAFF45;
}

.buttons{
    display:flex;
    justify-content: space-between;
    column-gap: 30px;
offset: none;
}





</style>
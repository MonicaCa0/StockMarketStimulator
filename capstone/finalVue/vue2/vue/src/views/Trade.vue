<template>
<div class="container">
       <Header></Header>
  <div class="Main">
    <div class="top">
      <div class=" Stock-header">  Founder's Choice</div>
      <input id="searchbar" v-on:keyup.enter="onSubmit" type="text" v-model="search" placeholder="Search for a stock"/>
      </div>
      <div class="Stocks">
          <div class="stock-block">
              <div class="stock-name"><b> Microsoft </b>
          <span class="price">(Price: 261.20)</span>
          </div>
           <div class="body" style="display: flex;">
               <div class="input"><input type="text" placeholder="Quantity">
           </div> 
           <button  class= "buy-button"> Buy</button>
           <button class="sell-button"> Sell </button>
        </div>
        </div>
        
        <div class="stock-block">
            <div class="stock-name"><b> Disney </b>
        <span class="price">(Price: 95.02)</span>
        </div> 
        <div class="body" style="display: flex;"><div class="input"><input type="text" placeholder="Quantity">
        </div>
         <button  class="buy-button"> Buy </button>
         <button class="sell-button"> Sell </button>
        </div>
        </div>

        <div class="stock-block">
            <div class="stock-name"><b> Peloton </b>
        <span class="price">(Price: 11.88)</span>
        </div> 
        <div class="body" style="display: flex;"><div class="input"><input type="text" placeholder="Quantity">
        </div>
         <button  class="buy-button"> Buy </button>
         <button class="sell-button"> Sell </button>
        </div>
        </div>

        <div class="stock-block">
            <div class="stock-name"><b> Stride </b>
        <span class="price">(Price: 32.50)</span
        ></div>
         <div class="body" style="display: flex;"><div class="input"><input type="text" placeholder="Quantity">
         </div> 
         <button  class="buy-button"> Buy </button>
         <button class="sell-button"> Sell </button>

         </div>
         </div>

         <div class="stock-block">
             <div class="stock-name"><b> Intel </b>
         <span class="price">(Price: 28.82)</span>
         </div> 
         <div class="body" style="display: flex;"><div class="input"><input type="text" placeholder="Quantity">
         </div> 
         <button class="buy-button"> Buy </button>
         <button class="sell-button"> Sell </button>
         </div>
        <stock-display></stock-display>
         <div class="holdings">
             <h1 class="holdings-header">Holdings</h1>
            <select >
         <option disabled value="">Select Stock</option>
             <option>Microsoft</option>
             <option>Disney</option>
             <option>Peloton</option>  
             <option>Stride</option> 
             <option>Intel</option> 
                
            </select>
            

         </div>


         </div>
     
         </div>
      

  </div>
</div>
</template>

<style scoped>

.container{
     height: 100vh; 
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;


}

.Stock-header{
    font-size: 40px;
    padding-bottom: 5px;
    margin-left: 10px;
   border-bottom: 2px solid #AFB2ED;
      color: white;
      font-size: 45px;
      text-shadow: 1.5px 1.5px #6A6EBD;
  
   
}

.Stocks{
    display: grid; 
    grid-template-columns: 1fr 1fr; 
  
    
    padding-left: 15px;
   

}

.stock-block{
    padding-top: 5px;
    padding-bottom: 5px;
      color: #5c60a0;
    text-shadow: .4px .1px white;
      
    
}

.price{
    font-size: 14px;
     margin-left: 2.5px;
      color: white;
      text-shadow: 1px 1px #6A6EBD;
  
}
.top{
  display: flex;
  column-gap: 50px;
}
.buy-button{
    margin-left: 20px;
       cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 6px;
    border-style:solid;
     color: #5359c3;
     padding: 2px 6px;
}

.sell-button{
    margin-left: 20px;
        cursor: pointer;
    background:#5359c3;
    border-color:#5359c3;
    border-radius: 6px;
    border-style:solid;
     color: white;
     padding: 2px 6px;
}

.holdings{
    display: grid; 

}

.holdings-header{
    font-size: 40px;
    font-weight: 100;
    
      color: white;
     
      text-shadow: 1.5px 1.5px #6A6EBD;
  
    padding-bottom: 5px;
    margin-left: 10px;
   border-bottom: 2px solid #AFB2ED;
   
}

input{
  margin-top:5px;
   width: 60%;
    border-radius:6px;
    border-style:solid; 
}

select{
   width: 100%;
    border-radius:6px;
    border-style:solid; 
}
#searchbar{
  width: 60%;
  height: 45px;
  border-radius: 20px;
}
input::placeholder#searchbar{
  margin-right: 100px;
}

</style>

<script>
import StockDisplay from '../components/StockDisplay.vue';
import StockService from '../services/StockService.js'
import Header from '../components/Header.vue'

export default {
  name: "Trade",
  data(){
    return{
    search: '',
    stock: {}
    }
  },
  components:{
    Header,
    StockDisplay
  
  
  },
  methods:{
  onSubmit(){
    StockService.searchForAStock(this.search).then(res => {
      this.$store.commit('SET_STOCKS', res.data)
    })  
  
  }
  }

}
</script>

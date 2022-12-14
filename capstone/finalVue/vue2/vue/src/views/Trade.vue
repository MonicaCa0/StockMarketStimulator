<template>
<div class="container">
       <Header></Header>
  <div class="Main">
      <div class=" Stock-header">  Founder's Choice</div>
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

<style >

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
   
}

.Stocks{
    display: grid; 
    grid-template-columns: 1fr 1fr; 
  
    
    padding-left: 15px;
   

}

.stock-block{
    padding-top: 5px;
    padding-bottom: 5px;
}

.price{
    font-size: 14px;
     margin-left: 2.5px;

}

.buy-button{
    margin-left: 20px;
}

.sell-button{
    margin-left: 20px;
}

.holdings{
    display: grid; 

}

.holdings-header{
    font-size: 40px;
    font-weight: 100;
    
    padding-bottom: 5px;
    margin-left: 10px;
   border-bottom: 2px solid #AFB2ED;
   
}


</style>

<script>


import Header from '../components/Header.vue'

export default {
  name: "Trade",
  components:{
    Header,
 
  
  }
}
</script>

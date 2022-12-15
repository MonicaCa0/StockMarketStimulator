<template>
<div>
    <div class="stock-block" v-for="stock in stocks" v-bind:key="stock.id">
            <div class="stock-name"><b> {{stock.stockName}} </b>
        <span class="price">({{stock.currentStockPrice}})</span >
        </div>
         <div class="body" style="display: flex;"><div class="input"><input type="text" placeholder="Quantity">
         </div> 
         <button  class="buy-button"> Buy </button>
         <button class="sell-button"> Sell </button>
         </div>
         </div>
         </div>
</template>

<script>
export default {
props:['stocks']
}
</script>

<style>

</style>
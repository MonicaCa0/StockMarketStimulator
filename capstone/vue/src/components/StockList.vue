<template>
  <div class=stockList>
      <div class="test">
          <ul>
              <li v-for="stock in stocks" v-bind:key="stock.stockId">
                  {{stock.stockName}}
                  {{stock.currentStockPrice}}
              </li>
          </ul>
      </div>
  </div>
</template>

<script>

export default {
   name: 'stock-list',
   props:['stocks']


    }
</script>

<style lang="scss">
*{
    box-sizing: border-box;
}

li{
    list-style: none;
}


p{
    color: white;
}
</style>
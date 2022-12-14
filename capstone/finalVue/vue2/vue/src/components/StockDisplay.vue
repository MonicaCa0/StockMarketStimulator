<template>
  <stock-list :stocks="$store.state.stocks"></stock-list>
</template>

<script>
import StockList from './StockList.vue'
import StockServices from '../services/StockService.js'
export default {
  components: { StockList },
  
  created(){
      StockServices.getAllStocks().then(response =>{
          this.$store.commit('SET_STOCKS', response.data)
      })
  }

}

</script>

<style>

</style>
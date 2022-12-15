<template>
  <stock-component :stocks="$store.state.stocks"></stock-component>
</template>

<script>
// import StockList from './StockList.vue'
// import StockServices from '../services/StockService.js'
import StockComponent from './StockComponent.vue'
export default {
  components: { StockComponent  },
  
  // created(){
    
  //    StockServices.getAllStocks().then(response =>{
  //         this.$store.commit('SET_STOCKS', response.data)
  //     })
  // }

}

</script>

<style>

</style>
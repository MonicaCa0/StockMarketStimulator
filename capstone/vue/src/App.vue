

<template>
  <div class="app">
    <SelectGameName></SelectGameName>
    <router-view />
  </div>
</template>
<script >
import SelectGameName from './components/SelectGameName.vue'
export default {
components:{
SelectGameName
}
}
</script>

<style lang="scss" scoped>
*{
  margin:0;
  padding:0;
  box-sizing: border-box;
  
}


</style>


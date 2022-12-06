<template>
<div class="container">
<div class="beginning">
  
  <nav>
  <Button :title="Home" v-bind:to=" {name: 'home'}"></Button>
  </nav>
  </div>
  <div class="left">

  </div>
  </div>
</template>

<script>
import Button from  './Button.vue'
export default {
components:{
    Button
}
}
</script>

<style scoped>

</style>

<template>
<div class="background">
  <div class="gradient">
    <div class="container">
  <div>
    <sidebar></sidebar>

  </div>
  <h1>
    
  </h1>

  </div>
  </div>
</div> 
</template>




<script >
import Sidebar from '@/components/sidebar/sidebar.vue'
import { sidebarWidth } from '@/components/sidebar/state.js'
export default {
  components: { Sidebar },
  setup() {
    return { sidebarWidth }
  }
}
</script>



<style scoped>


.background{
  background-color:#AFB2ED;
    height:100vh;
}

.container{
    height: 100vh;
    background-image: url('../assets/yellowObjects.svg');
    background-repeat: no-repeat;
    background-size: cover;
   
   
    
}

.gradient{
   background-image:linear-gradient(-45deg,#AFB2ED 10%,#FFACBD,#AFB2ED );
}

</style>
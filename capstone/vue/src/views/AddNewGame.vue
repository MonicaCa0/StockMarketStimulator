<template>
<div class="background">
  <div class="main">
    <sidebar />
    <add-new-game />
  </div>
  </div>
</template>

<script>
import Sidebar from '@/components/sidebar/sidebar.vue'
import AddNewGame from '@/components/AddNewGame.vue'
export default {
components:{
    AddNewGame,
    Sidebar
}
}
</script>

<style scoped>
*{
    box-sizing: border-box;
}

 .main{
display: flex;
justify-content: center;
align-items: center;
color: #3e309c; 
  top: 0;
height: 100vh;
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;

}

</style>
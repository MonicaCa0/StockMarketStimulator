<template>
<div class="main">
  <div class="container">
  <pending-invites-list class="display" :invites="$store.state.invites"></pending-invites-list>
  </div>
  </div>
</template>

<script>
import PendingInvitesList from '../components/PendingInvitesList.vue'

export default {
components:{
    PendingInvitesList
},



}
</script>

<style scoped>
  
    .container{
         width: 400px;
        height: 400px;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        font-size: 18px;
        row-gap: 20px;
        overflow: auto;
        background-color:rgba(255, 255, 255, 0.829) ;
        border-radius: 14px;
    }

    .display{
        row-gap: 10px;
         display: flex;
        flex-direction: column;
        align-items: center;

    }
 
   
  
   
  
</style>
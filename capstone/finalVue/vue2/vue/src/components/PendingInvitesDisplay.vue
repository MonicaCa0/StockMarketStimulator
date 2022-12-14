<template>
<div class="main">
  <div class="container">
  <pending-invites-list class="display" :games="$store.state.invites"></pending-invites-list>
  </div>
  </div>
</template>

<script>
import PendingInvitesList from '../components/PendingInvitesList.vue'
 import GameService from '@/services/GameService.js'
export default {

components:{
    PendingInvitesList
},
created(){
    GameService.getPendingInvites().then( res => {
        this.$store.commit('SET_INVITES', res.data)
    })
}

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
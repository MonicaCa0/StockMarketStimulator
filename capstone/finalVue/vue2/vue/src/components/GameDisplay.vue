<template>
<div class="main">
  <div class="container">
  <game-list class="display" :games="$store.state.games"></game-list>
  </div>
  </div>
</template>

<script>
import GameList from '../components/GameList.vue'
 import GameServices from '@/services/GameService.js'
export default {

components:{
    GameList
},
 created(){
        GameServices.viewAllGames().then(response => {
              this.$store.commit('SET_GAMES', response.data);
        });

}

}
</script>

<style  scoped>
  
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
        background-color:rgba(255, 255, 255) ;
        border-radius: 14px;
    }

    .display{
        row-gap: 10px;
         display: flex;
        flex-direction: column;
        align-items: center;

    }
 
   
  
   
  
</style>
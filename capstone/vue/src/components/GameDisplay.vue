<template>
<div class="Main">
  <div class="container">
  <game-list class="display" :games="$store.state.games"></game-list>
  </div>
  </div>
</template>

<script>
import GameList from '../components/GameList.vue'
 import GameServices from '@/services/GameServices.js'
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

<style lang= "scss" scoped>
  
    .container{
      width: 100%;
        display: flex;
        flex-direction: row;
        align-items: center;
        justify-content: center;
        row-gap: 20px;
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
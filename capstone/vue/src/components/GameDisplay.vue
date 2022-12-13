<template>
  <game-list :games="$store.state.games"></game-list>
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
            alert('view all gm')
              this.$store.commit('SET_GAMES', response.data);
         
        });

}

}
</script>

<style>

</style>
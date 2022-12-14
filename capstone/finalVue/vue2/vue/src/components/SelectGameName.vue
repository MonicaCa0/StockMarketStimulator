
<template>
            <select v-model="game.gameName">
                <option value="">Please Select A Game</option>
                <option value="game.gameName" v-for="game in $store.state.games" v-bind:key="game.gameId" >{{game.gameName}}</option>
            </select>
   
</template>
<script>
import GameService from '../services/GameService.js'
export default {
    data(){
        return{
            game:{
                gameName: ''
            }
        }
    },
    created(){

        GameService.viewAllGames().then(response => {
              this.$store.commit('SET_GAMES', response.data);
        });
    }
}
</script>

<style scoped>

</style>
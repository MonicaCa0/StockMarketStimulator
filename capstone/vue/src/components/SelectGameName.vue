
<template>
            <select v-model="game.gameName">
                <option value="">Please Select A Game</option>
                <option value="game.gameName" v-for="game in $store.state.games" v-bind:key="game.gameId" >{{game.gameName}}</option>
            </select>
   
</template>
<script>
import GameServices from '@/services/GameServices.js'
export default {
    data(){
        return{
            game:{
                gameName: ''
            }
        }
    },
    created(){

        GameServices.viewAllGames().then(response => {
              this.$store.commit('SET_GAMES', response.data);
        });
    }
}
</script>

<style scoped>

</style>
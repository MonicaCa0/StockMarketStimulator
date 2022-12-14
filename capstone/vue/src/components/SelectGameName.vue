
<template>
            <select v-model="game.gameName">
                <option value="game.gameName" v-for="game in $store.state.games" v-bind:key="game.gameId" >{{game.gameName}}</option>
            </select>
   
</template>
<script>
import GameServices from '@/services/GameServices.js'
export default {
    created(){

        GameServices.viewAllGames().then(response => {
              this.$store.commit('SET_GAMES', response.data);
        });
    }
}
</script>

<style scoped>
select{
    background: chartreuse;
}
option{
    background: chocolate;
    width: 30%;
    height: 30%;
}
</style>
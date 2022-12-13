<template>
 <section class="main">
      <h3>Games {{$store.state.user.username}} Created</h3>
      <ul>
          <li v-for="game in games" v-bind:key="game.gameId" >
              <h4>{{game.gameId}}</h4>
              <p>{{game.gameName}}</p>
          </li>
      </ul>
    </section>
</template>

<script>
export default {
    name: 'game-list',
    props:['games'],
   
}


</script>

<style scoped>

.main{
    background-color: black;
}
p{
    color: purple;
}
h4{
    color: red;
}
</style>
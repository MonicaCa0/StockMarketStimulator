<template>
 <section class="main">
      <h3>Games {{$store.state.user.username}} Created</h3>
      <ul>
          <li v-for="game in games" v-bind:key="game.id" >
              <h4>{{game.gameName}}</h4>
              <p>{{game.dateFinished}</p>
          </li>
      </ul>
    </section>
</template>

<script>
export default {
    name: 'game-list',
    props: ['games']
    
}


</script>

<style scoped>


</style>
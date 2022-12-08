<template>
  <div id="app">
    <div id="nav">

      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
      <router-link></router-link>

    </div>
    <router-view />
  </div>
</template>

<style scoped>
body{
  margin: 0px
}
</style>


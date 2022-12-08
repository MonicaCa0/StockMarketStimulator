<template>
  <div id="app">
    <div id="nav">
      <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
    </div>
    <router-view />
  </div>
</template>

<style scoped>
body{
  margin: 0px
}
<<<<<<< HEAD
</style>

=======

#nav{
  background:ivory;
  margin:20px
}
</style>
>>>>>>> f28a51e3bcd92b0ba908b91755a2423812d9bbb9

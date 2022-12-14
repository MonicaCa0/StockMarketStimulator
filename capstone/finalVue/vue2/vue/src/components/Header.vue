<template>
  <div class="Header">
      <div class="logo">
      <h1>Apricot Stocks</h1>
      </div>
       <div id="nav">
    
      <router-link class="link" v-bind:to="{ name: 'home' }">Home</router-link>&nbsp;|&nbsp;
      <router-link  class="link" v-bind:to="{ name: 'games' }">Games</router-link>&nbsp;|&nbsp;
       <router-link class="link" v-bind:to="{ name: 'portfolio' }">Portfolio</router-link>&nbsp;|&nbsp;
       <router-link class="link" v-bind:to="{ name: 'trade' }">Trade</router-link>&nbsp;|&nbsp;
       <router-link class="link" v-bind:to="{ name: 'research' }">Research</router-link>&nbsp;|&nbsp;
      <router-link  class="link" v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link>
      
    </div>
  </div>
</template>

<script>
export default {

}
</script>

<style scoped>


.Header{
    height: 90px;
    display: flex;
    align-items: center;
    justify-content: space-between;
    background: #AFB2ED;
}
.image{
    width: 100px;
    height: auto;
}
.logo{
    margin-left: 20px;
    color: white;
    column-gap: 10px;
}
.link{
  text-decoration: none;
  color: white;
}
</style>
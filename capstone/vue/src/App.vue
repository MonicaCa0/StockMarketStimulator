<template>
  <div id="app">
    <div id="nav">
      <!-- <router-link v-bind:to="{ name: 'logout' }" v-if="$store.state.token != ''">Logout</router-link> -->
       <sidebar v-if="$store.state.user.username"></sidebar>
      <router-link>
       
      </router-link>

    </div>
    <router-view />
  </div>
</template>
<script >
import Sidebar from '@/components/sidebar/sidebar.vue'
import { sidebarWidth } from '@/components/sidebar/state.js'

export default {
  components: {
     Sidebar,
  
      },
  setup() {
    return { sidebarWidth }
  }
}
</script>

<style scoped>
body{
  margin: 0px
}
</style>


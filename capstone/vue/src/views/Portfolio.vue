<template>
 <div>
       <sidebar v-f="$store.state.user.username"></sidebar>
  <profile />
  </div>
</template>

<script>
import Profile from '../components/Profile.vue'
import Sidebar from '@/components/sidebar/sidebar.vue'
export default {
  components: { Profile
   , Sidebar },

}
</script>

<style>

</style>
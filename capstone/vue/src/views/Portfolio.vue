<template>
 <div class="main">
       <sidebar v-f="$store.state.user.username"></sidebar>
       
  <Profile><stock-list></stock-list> </Profile>
  </div>
</template>

<script>
import Profile from '../components/Profile.vue'
import Sidebar from '@/components/sidebar/sidebar.vue'
import StockList from '../components/StockList.vue'
export default {
  components: { Profile
   , Sidebar, StockList,
  },

}
</script>

<style lang="scss" scoped>

</style>
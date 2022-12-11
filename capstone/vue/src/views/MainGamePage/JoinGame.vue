<template>
  <div>
       <sidebar v-if="$store.state.user.username"></sidebar>
  </div>
</template>

<script>
import Sidebar from '@/components/sidebar/sidebar.vue'
export default {
components:{
    Sidebar
}
}
</script>

<style>

</style>
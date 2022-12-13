<template>
   <sidebar v-if="$store.state.user.username"></sidebar>
</template>

<script>
import Sidebar from '@/components/sidebar/sidebar.vue'
export default {
components:{
    Sidebar
}
}
</script>

<style scoped>

</style>
<template>
<div>
         <sidebar v-if="$store.state.user.username"></sidebar>
           <about />
</div>
</template>

<script>
import About from '../components/About.vue'
import Sidebar from '@/components/sidebar/sidebar.vue'
export default {
    components:{
        About,
        Sidebar
    }

}
</script>

<style>

</style>
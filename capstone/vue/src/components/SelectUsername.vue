
<template>
            <select v-model="user.username">
                  <option value="">Please Select A Player</option>
                <option value="user.username" v-for="user in $store.state.users" v-bind:key="user.id" >{{user.username}}</option>
            </select>
   
</template>
<script>
import UserService from '@/services/UserService.js'
export default {
    data(){
        return{
            user:{
                username: ''
            }
        }
    },
    created(){
        UserService.getAllUsers(response => {
               this.$store.commit('SET_USERS', response.data);
        });
    }
}
</script>

<style scoped>

</style>
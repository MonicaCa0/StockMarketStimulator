
<template>
            <select v-model="user.username">
                  <option value="">Please Select A Player</option>
                  <option value="">Katie</option>
               <option value="">Annnnnneeeee</option>
                <option value="user.id" v-for="user in $store.state.users" v-bind:key="user.id" >{{user.username}}</option>
            </select>
   
</template>
<script>
import userService from "@/services/UserService.js"
export default {
    data(){
        return{
            user:{
                username: ''
            }
        }
    },
    create(){
        userService.getAllUsers().then(response => {
               this.$store.commit('SET_USERS', response.data);
        });
    }
}
</script>

<style scoped>

</style>
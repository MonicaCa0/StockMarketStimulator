<template>
      <div class="container">
          <h1>Leader Board</h1>
          <p>Good Luck!</p>
          <div class="content">
              <li v-for="leader in $store.state.leaders" v-bind:key="leader.username">
                    <p>{{leader.username}}</p>
                    <p>{{leader.portfolioBalance}}</p>
                    <span></span>
              </li>
              
              </div>

        </div>
</template>

<script>
import userService from "@/services/UserService.js"
export default {
data(){
            return{
            users: [],
        };
    },
created(){
    userService.getLeaderBoard().then(response =>{
        //this.leaders = response.data;
        this.$store.commit('SET_LEADERS', response.data)
    })
}
}
</script>

<style scoped>
.container{
    height: auto;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 20px 100px 10px 40px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    list-style: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.content{
    display: flex;
    justify-content: flex-start;
}
h1{
    font-size:50px;
    text-align: center;
    color:#AFB2ED;
    text-shadow:2px 2px#6A6EBD;
}
h2{
    font-size:50px;
    text-align: center;
    color:#AFB2ED;
    text-shadow:2px 2px#6A6EBD;
}

.header{
    padding-top: 20px;
    font-size:50px;
    text-align: center;
    text-shadow:2px 2px#6A6EBD;
   
}
li {
    margin: 10px;
}
</style>
<template>
      <div class="container">
         <h1>Leaderboard</h1>
          <p>Good Luck!</p>
          <div class="content">
              <li>Rank 1: Player2 $534,382</li>
              <li>Rank 2: test $302,320</li>
              <li>Rank 3: greg $233,241</li>
              <li>Rank 4: Katie $223,231</li>
              <li>Rank 5: Player1 $203,139</li>
              <li>Rank 6: Player2 $534,382</li>
              <li>Rank 7: test $302,320</li>
              <li>Rank 8: greg $233,241</li>
              <li>Rank 9: Katie $223,231</li>
              <li>Rank 10: Player1 $203,139</li>
              <li>Rank 11: test1 $200,342</li>
              <li>Rank 12: test2 $197,039</li>
              </div>
              <div></div>
  <div class="buttons">
<router-link
      v-bind:to="{name: 'addNewGame', params:{id: $store.state.user.id}}">
      <Button :title="'Create Game'">Create Game</Button>
    </router-link>
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
*{
    
}
.container{
    height: auto;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 20px 100px 10px 40px;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    list-style: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.content{
    justify-content: flex-start;
}
h1{
    font-size:50px;
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

.buttons{
  display: flex;
  justify-content: space-evenly;
  column-gap: 40px;
}
 button,.updated{
         cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 6px;
    border-style:solid;
    padding:12px 30px 12px 30px;
    color: #5359c3;
  }
  button:hover{
        color:white;
        background-color:  #6A6EBD;
         border-color:#6A6EBD;
    }
</style>
<template>
<div class="container">
  <Header></Header>
  <div class="main1">
        <h1> Current Games </h1>
               <div class="inner-display">
           <GameDisplay />
           <PendingInvitesDisplay></PendingInvitesDisplay>
           </div>
<div class="buttons">
<router-link
      v-bind:to="{name: 'addNewGame', params:{id: $store.state.user.id}}">
      <Button :title="'Create Game'">Create Game</Button>
    </router-link>
  <router-link v-bind:to="{name:'addUser', params:{id: $store.state.user.id}}">
      <Button :title="'Add a Player'">  Add a Player</Button>
  </router-link>
  </div>
  </div>
  
</div>
</template>
<script>
import Header from '../components/Header.vue'
import GameDisplay from '../components/GameDisplay.vue'
import PendingInvitesDisplay from '../components/PendingInvitesDisplay.vue'
export default {
  name: "games",
  props:['gameId'],
  components:{
    Header,
    GameDisplay,
    PendingInvitesDisplay

  }
}
</script>

<style scoped>
.main1{
height: 100vh; 
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;
color: #3e309c;
display: flex;
flex-direction: column;
align-items: center;
justify-content: space-around;
row-gap: 20px;
text-align: left;
}
.inner-display {
  display: flex;
   column-gap: 25px;
  
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
    h1{
      color: white;
      font-size: 45px;
      text-shadow: 1.5px 1.5px #6A6EBD;
    }
</style>
<template>
<div class="container">
  <Header></Header>
  <div class="Main">
    <h1>Welcome {{ $store.state.user.username }}!</h1>
     <div class=leaderboard>
    <Leaderboard></Leaderboard>
    <DisplayPortfolios></DisplayPortfolios>
  </div>
  <div class="buttons">
<router-link
      v-bind:to="{name: 'addNewGame', params:{id: $store.state.user.id}}">
      <Button :title="'Create Game'">Create Game</Button>
    </router-link>
    </div>
    
 
  </div>
</div>
</template>

<script>
import Header from '../components/Header.vue'
import Leaderboard from '../components/Leaderboard.vue'
import DisplayPortfolios from '../components/DisplayPortfolios.vue'
export default {
  name: "home",
  components:{
    Header,
    Leaderboard,
    DisplayPortfolios
  }
};
</script>

<style scoped>
.Main{
 height: 100vh; 
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;
color: #3e309c;
display: flex;
flex-direction: column;
align-items: center;
row-gap: 20px;
text-align: left;
}

.leaderboard{
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

</style>
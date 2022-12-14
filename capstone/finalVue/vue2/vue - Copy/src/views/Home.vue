<template>
<div class="container">
  <Header></Header>
  <div class="Main">
    <h1>Home</h1>
     <div class=leaderboard>
    <Leaderboard></Leaderboard>
  </div>
  </div>
</div>
</template>

<script>
import Header from '../components/Header.vue'
import Leaderboard from '../components/Leaderboard.vue'

export default {
  name: "home",
  components:{
    Header,
    Leaderboard
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
    text-align: left;
    

}

</style>
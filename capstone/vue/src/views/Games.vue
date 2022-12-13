<template>
<div class="background">
         <sidebar v-if="$store.state.user.username"></sidebar>
  <div class="gradient">
  <div class="Gamecontainer">
    <div class="Gamegame-page">
        <h1 class="game-page-header"> Games Page</h1>
      <div class="all-buttons">
        <div class="create-button">
          <router-link
      v-bind:to="{name: 'addNewGame', params:{id: $store.state.user.id}}"
      
    >
      <button

      >
       Create Game
      </button>
    </router-link>
    </div>

    <div class="join-button">
          <router-link
      to="/join"
      custom
      v-slot="{ navigate }"
    >
      <button
        @click="navigate"
        role="link"
      >
       Join Game
      </button>
    </router-link>
    </div>

    <div class="view-button">
         <router-link
      to="/view"
      custom
      v-slot="{ navigate }"
    >
      <button
        @click="navigate"
        role="link"
      >
       View Games
      </button>
    </router-link>
    </div>
    </div>
    </div>
    </div>
  </div>
    </div>
</template>


<script>
import userService from '../services/UserService'
import Sidebar from '@/components/sidebar/sidebar.vue'
export default {
  data(){
    return{
      users:[],
      id: 0,
    }
  },
components:{
  Sidebar
}, methods:{
  created(){
    userService.getAllUsers().then(res =>{
       this.users = res.data;   
    } ).catch(error =>  {
        if (error.res.status == 404){
            // this.$router.push('/home')
        }
    })
}, 
methods:{
  userId(){
    let user = this.users.filter(user => {
      return user.username === this.$store.state.user.username;
    })

   return user.id;
   
  }
}
}
}
</script>

<style scoped>

.background{
    background-color:#AFB2ED;
    height:100vh;
    justify-content: center;
}

.Gamecontainer{
    height: 100vh;
    background-image: url('../assets/yellowObjects.svg');
    background-repeat: no-repeat;
    background-size: cover;
   
   
    
}

.gradient{
   background-image:linear-gradient(-45deg,#AFB2ED 10%,#FFACBD,#AFB2ED );
}

.Gamegame-page{
    font-family: Roboto;
    display: flex;
    flex-direction: column;
    align-items: center;
    column-gap: 50px;
    

}

.game-page-header{
  display: flex;
font-size: 60px;
font-family: Roboto;
justify-content: center;
color: white;
text-shadow:2px 2px#6A6EBD ;

}

.all-buttons{
  font: inherit;
  display: flex;
  justify-content: space-around;
  align-items: center;
  align-content: center;
  flex-direction: column;
   background: #ffffffcc;
   border-color:#EAFF45;
    border-radius: 60px;
    border-style:solid;
    padding:30px 60px 30px 30px;
    height: 200px;
}

button{
  border: none;
  background: transparent;
  font: inherit;

} 

.create-button{
  display: flex;
  justify-content: center;
  font-size: 18px ;
   background:#EAFF45;
 
    border-radius: 30px;
    padding:20px 60px 20px 60px;

   
}

.join-button{
  display: flex;
  justify-content: center;
  font-size: 18px ;
   background:#EAFF45;

    border-radius: 30px;
    padding:20px 60px 20px 60px;

   
}

.view-button{
  display: flex;
  justify-content: center;
  font-size: 18px ;
   background:#EAFF45;
   
    border-radius: 30px;
    padding:20px 60px 20px 60px;

   
}


  

</style>
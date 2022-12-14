<template>
<div class="background">
  <h1 class="game-page-header"> Games Page</h1>
         <div class="inner-content">
          <sidebar /> 
               <div class="inner-display">
           <GameDisplay class="game-display" />
           </div>
          </div>
<div class="buttons">
<router-link
      v-bind:to="{name: 'addNewGame', params:{id: $store.state.user.id}}">
      <Button :title="'Create Game'"></Button>
    </router-link>
  <router-link v-bind:to="{name:'addUser', params:{id: $store.state.user.id}}">
      <Button :title="'Add a Player'"> >
       Add Players
      </Button>
  </router-link>
   <router-link  v-bind:to="{name:'acceptOrDeny'}">
      <Button :title="'Accept or Deny Invite'"> >
       Add Players
      </Button>
  </router-link>
  </div>
</div>
</template>


<script>
import GameDisplay from '@/components/GameDisplay.vue'
import Sidebar from '@/components/sidebar/sidebar.vue'
import Button from '@/components/Button.vue'
export default {
  data(){
    return{
      users:[],
      id: 0,
    }
  },
components:{
  Sidebar,
  GameDisplay,
  Button
}, methods:{
  created(){
 
}, 
methods:{
   
  }
}
}
</script>

<style lang="scss" scoped>
  
.background{
    height:100vh;
    display: flex;
    flex-direction: column;
   align-items: center;
   justify-content: space-between;
   
}
.inner-display{
  display: flex;
}
h1{
  text-align: center;
font-size:50px;
    text-align: center;
    color:white;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    text-shadow:2px 2px#6A6EBD
}
.buttons{
  display: flex;
  align-items: center;
align-items: center;
  justify-items: center;
  justify-content: center;
  column-gap: 10px;
  margin-top: 5px;
  margin-bottom: 20px;
   button{
    cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 6px;
    border-style:solid;
    padding:12px 30px 12px 30px;
    color: #5359c3;
    font-size: 15px;
    text-align: center;
    &:hover{
        color:white;
        background-color:  #6A6EBD;
         border-color:#6A6EBD;
    }
  }
  
}







  

</style>
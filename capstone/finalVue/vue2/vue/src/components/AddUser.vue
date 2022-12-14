<template>
    <div class="formContainer">
        <form  v-on:submit.prevent>
            <h1>Add a Player</h1>
            <p>Use this form to create add a player to your game.</p>
            <div class="display">
        <label for="gameName"><span>Game Name</span></label>
        <select-game-name class="input"></select-game-name>
        <label for="userId"><span>Username</span></label>
        <select-username class="input" />
       <div class="buttons">
        <button @click="onSubmit" type="submit" >Submit</button>
        <button @click="cancel">Cancel</button>
        </div>
        </div>
        </form>
    </div>
</template>

<script>
 import GameService from '../services/GameService.js'
import SelectGameName from '../components/SelectGameName.vue'
import SelectUsername from '../components/SelectUsername.vue'
export default {
data(){
    return{
            gameName: '',
            playerUserId: "",
        errorMsg:"",
    }
},
components:{
SelectGameName,
SelectUsername
},
methods: {
    onSubmit(){
        const newPlayer ={
                gameName: this.game.gameName,
                playerUserId: this.game.playerUserId
                 };
         alert(newPlayer.gameName + " "+ newPlayer.gameName)
        let id = this.$route.params.id;
       GameService.addUser(id, newPlayer).then(res => {
           alert("newGame")
            if(res.status === 201){
                this.gameName=''
                this.dateFinished=''
                this.router.push('/games')
        }  
        }).catch(error => {
            alert(error)
        })
       
}, cancel(){
    this.$router.push('/games');
}
}
}
</script>

<style scoped>
*{
    box-sizing: border-box;
}
    .formContainer{
        height: 100vh;
        display: flex;
        align-items: center;
    }
    form{
        height: 500px;
        width: 500px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        row-gap: 20px;
        background-color:rgba(255, 255, 255, 0.829) ;
     
        border-radius: 14px;
    }
    .display{
        width: 100%;
        row-gap: 10px;
         display: flex;
        flex-direction: column;
        align-items: center;
     
    }
 
    .buttons{
        display: flex;
        column-gap: 15px;
        margin-top: 10px;
    }
    h1{
        border-bottom: 1.2px dotted #FFACBD;
        outline: #FFACBD;
       color: #6A6EBD;
        padding: 13px 25px 20px 25px; 
        
        margin-bottom:0;
        margin-top: 0;
    }
    p{
        margin-top: 0;
        color: #6A6EBD;
      text-shadow: 1px 1.55px white ;   
    }
   .input{
    width: 60%;
    border-color: #EAFF45;
    border-radius:10px;
    border-style:solid;
    padding: 10px 10px;
    margin-bottom: 20px;
   }
   
   label{
       color:#6A6EBD ;
       font-size: 15px;
       font-family: Cochin, Georgia, Times, 'Times New Roman', serif;
      
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
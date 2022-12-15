<template>
   <div class="formContainer">
        <form  v-on:submit.prevent>
            <h1>Invitation Response</h1>
            <p>Use this form to Accept or Deny a game invitation.</p>
            <div class="display">
        <label for="gameName"><span>Response</span></label>
            <select  class="input" name="" id="">
                <option value="">Please Select One</option>
                <option value="">Accept</option>
                <option value="">Deny</option>
            </select>
      
       <div class="buttons">
        <button @click="onSubmit" type="submit" >Submit</button>
        <button @click="cancel">Cancel</button>
        </div>
        </div>
        </form>
    </div>
</template>

<script>
 import GameService from '@/services/GameService.js'
export default {
data(){
    return{
             username: '',
            approvalId:0    
    }
},
methods: {
    onSubmit(){
        let id = this.$store.state.user.id
        let gameId = this.$route.params.id;
       GameService. approveOrDeny(id, gameId, this.approvalId).then(res => {
            if(res.status === 201){
                this.gameName=''
                this.dateFinished=''    
                this.router.push('/games')
        }  
        }).catch(error => {
            alert(error)
        })
       
}, 
cancel(){
    this.$router.push('/games');
}
}
}

</script>

<style scoped>
*{
    box-sizing: border-box;
}
    .main12{
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
        row-gap: 30px;
        background-color:rgba(255, 255, 255) ;
     
        border-radius: 14px;
    }
    .display{
        width: 100%;
        row-gap: 15px;
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
    input[type=date]{

    color: #6A6EBD;
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
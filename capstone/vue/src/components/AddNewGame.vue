<template>
    <div class="Main">
        <div class="GameDisplay">

        </div>

        <form action="">
            <h1>Create A New Game</h1>
            <p>Use this form to create a new game.</p>
            <div class="display">
        <label for="gameName"><span>Game Name</span></label>
         <input class="input" type="text" v-model="gameName" required>
        <label for="dateFinished"><span>Date Game Finishes</span></label>
         <input  class="input" id="dateFinished" placeholder="Date Finished" type="date" required>
       <div class="buttons">
        <input type="submit" value="Submit">
        <button>Cancel</button>
        </div>
        </div>
        </form>
    </div>
</template>

<script>
export default {
data(){
    return{
        game:{
            gameName: '',
            dateFinished: ''
        }
    }
}
}
</script>

<style lang="scss" scoped>
*{
    box-sizing: border-box;
}
    .main{
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
   input[type=submit]{
             cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 6px;
    border-style:solid;
    padding:12px 30px 12px 30px;
    color: #5359c3;
    &:hover{
        color:white;
        background-color:  #6A6EBD;
         border-color:#6A6EBD;
    }

   }
    input[type=date]{

    color: #6A6EBD;
   }
  button{
         cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 6px;
    border-style:solid;
    padding:12px 30px 12px 30px;
    color: #5359c3;
    &:hover{
        color:white;
        background-color:  #6A6EBD;
         border-color:#6A6EBD;
    }
  }
</style>
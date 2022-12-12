<template>
    <div class="Main">
        <div class="GameDisplay">

        </div>

        <form action="">
        <label for="gameName">Game Name</label>
         <input class="input" placeholder="Game Name" type="text" v-model="gameName" required>
        <label for="dateFinished">Date Game Finishes</label>
         <input  class="input" id="dateFinished" placeholder="Date Finished" type="date" required>
       <div class="buttons">
        <input type="submit" value="Submit">
        <button>Cancel</button>
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

<style scoped>
*{
    box-sizing: border-box;
}
    .main{
        height: 100vh;
        display: flex;
        align-items: center;
    }
    form{
        height: 450px;
        width: 450px;
        display: flex;
        flex-direction: column;
        align-items: center;
        justify-content: center;
        row-gap: 20px;
        background-color:rgba(255, 255, 255, 0.829) ;
        border-radius: 25px;
    }
    .buttons{
        display: flex;
        column-gap: 10px;
    }

   .input{
       width: 35%;
   }
   
   label{
       font-size: 22px;
       font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
   }
   input[type=submit]{
             cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 5px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    color: #6A6EBD;
   }
  button{
         cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 5px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    color: #6A6EBD;
  }
</style>
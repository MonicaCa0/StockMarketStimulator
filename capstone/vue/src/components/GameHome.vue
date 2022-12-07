<template>
    <div class="Background">
        <div class="Container">
            <h1>Select Game Type</h1>
           <button class="button">
               <router-link class="link" :to="{name: 'creating'}">
                   <img src="../assets/startGame.png" class="game-buttons"/> </router-link>
           </button>
           <button class="button">
               <router-link class="link" :to="{name: 'join'}">
            <img src="../assets/joinGame.png" class="game-buttons"/> </router-link>
          </button> 
          <button class="button">
              <router-link class="link" :to="{name: 'view'}">
            <img src="../assets/viewGame.png" class="game-buttons"/> </router-link>
          </button>   
          <div>
                
            </div>

            

        </div>
 
    </div>
</template>

<style scoped>

.Background{
    background: linear-gradient(-45deg, #d199c0, #be58b9, #e19ee4, #e95fe2);
    animation: gradient 20s ease infinite;
  width: 100%;
  height: 100vh;
  display: flex;
  align-items: center;
  justify-content: center;
  background-size: 300% 300%;

    
}

@keyframes gradient {
0% {
background-position: 0% 50%;
}
50% {
background-position: 100% 50%;
}
100% {
background-position: 0% 50%;
}
}

h1{
    font-style: italic; 
    font-size: 60px;
    text-align: center;
    color: white;
    text-shadow: rgb(242, 247, 0) 1px 0 10px;
}

.button{
    justify-content: center;
    background: transparent;
    border: none;
    outline: none;
    display: block;
    width: 100%;
    padding: 14px 28px;
   font-size: 16px;
   cursor: pointer;
   text-align: center;

}

.game-buttons{
    background: transparent;
    border: none;
    outline: none;
    width: auto;
}

</style>


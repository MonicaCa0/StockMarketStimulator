<template>
    <div class="Background">
        <div class="Container">
            <h1>Select Game Type</h1>
           <button>
               <img src="http://127.0.0.1:5500/src/assets/yellowStart.svg" aria-hidden="true">
           </button>
           <button>
            <img src="http://127.0.0.1:5500/src/assets/YellowJoinb.svg" aria-hidden="true">
          </button>  
          <div>
                
            </div>

            

        </div>
 
    </div>
</template>

<style scoped>

.Background{
    background: linear-gradient(-45deg, #d199c0, #be58b9, #e19ee4, #e95fe2);
    background-size: 400% 400%;
    animation: gradient 15s ease infinite;
    height: 100vh;

    
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

button{
    justify-content: center;
    border: none !important;
    background: transparent !important;
    outline: none;

}

</style>


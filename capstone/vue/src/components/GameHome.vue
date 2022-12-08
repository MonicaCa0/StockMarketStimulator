<template>
    <div class="Background">
        <div class="Buttons">
        <h1>
            Apricot Stocks Simulator
        </h1>
    <div class="portfolio-button">
          <router-link
      to="/portfolio"
      custom
      v-slot="{ navigate }"
    >
      <button
        @click="navigate"
        role="link"
      >
       Portfolio
      </button>
          </router-link>
    </div>

    <div class="trade-button">
          <router-link
      to="/trade/stocks"
      custom
      v-slot="{ navigate }"
    >
      <button
        @click="navigate"
        role="link"
      >
       Trade
      </button>
          </router-link>
</div>

        <button>
            Research
        </button>


       <div class="games-button">
          <router-link
      to="/games"
      custom
      v-slot="{ navigate }"
    >
      <button
        @click="navigate"
        role="link"
      >
       Games
      </button>
          </router-link>
</div>

        <form action="">
            <div>
                

            </div>



        </form>
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
    font-style: Roboto;
    font-size: 50px;
    position: absolute;
    top: 0px;
    left: 10px;
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


<template>
      <div class="container">
          <h1>Current Games</h1>
          <div class="content">
              <li>
                  Game 1: $105,000
                  <p> <img src="../assets/graph1.png"/></p>
                 
              </li>
              <li>Game 2: $180,000</li>
              <p> <img src="../assets/graph2.png" /> </p>
              
              </div>

        </div>
</template>

<script>
import portfolioService from '../services/PortfolioService'
export default {
data(){
    return{
        portfolio: [],
    }
},
    created(){
        portfolioService.getAllPortfolios().then(response =>{
            this.$store.commit('SET_PORTFOLIOS', response.data)
        })
    }
}
</script>

<style scoped>
.container{
    background-repeat: repeat;
    overflow: auto;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 20px 100px 10px 40px;
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    list-style: none;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.content{
    justify-content: flex-start;
}
h1{
    font-size:50px;
    text-align: center;
    color:#AFB2ED;
    text-shadow:2px 2px#6A6EBD;
}
h2{
    font-size:50px;
    text-align: center;
    color:#AFB2ED;
    text-shadow:2px 2px#6A6EBD;
}

.header{
    padding-top: 20px;
    font-size:50px;
    text-align: center;
    text-shadow:2px 2px#6A6EBD;
   
}
li {
    margin: 10px;
}

img{
width: 400px;
height: auto
}
</style>
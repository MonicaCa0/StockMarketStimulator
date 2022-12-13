<template>
 <section class="main">
      <h3>Games {{$store.state.user.username}} Created</h3>
      <span></span>
      <ul>
            <li v-for="game in games" v-bind:key="game.gameId" >
                 <router-link class="link" :to="{name: 'viewGame', params:{gameId: game.gameId}}" >
              <h4>{{game.gameId + "."}}</h4>
              <p>{{game.gameName}}</p>  
                    </router-link>
          </li>
      </ul>
    </section>
</template>

<script>
export default {
    name: 'game-list',
    props:['games'],
   
}

</script>

<style lang="scss" scoped>
.main{
        height: 200px;
        width: 300px;
        display: flex;
        align-items: center;
      overflow: scroll;
    }
ul{
    display: flex;
    flex-direction: column;

}
.link{
    text-decoration: none;
        font-size: 18px;
display: flex;
align-items: center;
list-style: none;
  border-bottom: 1.2px dotted #FFACBD;

  &:hover{
      background-color:#6A6EBD ;
    color: white;
  }
}
li{
    display: inline-block;
list-style: none;
 color: #6A6EBD;
}
span{
        display: inline-block;
        width: 90%;
        border-bottom: 1.2px solid #EAFF45;
}
  h3{
        /* border-bottom: 1.2px solid #EAFF45; */
        outline: #FFACBD;
        color: #6A6EBD;
        padding: 13px 25px 20px 25px; 
        margin-bottom:0;
        margin-top: 0;
    }
p{
    color: #6A6EBD; 
    margin-left: 15px;
}

</style>
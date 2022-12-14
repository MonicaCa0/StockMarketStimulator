<template>
 <section class="main">
      <h3>Games  Created</h3>
      <span></span>
          <tr  v-for="game in games" v-bind:key="game.gameId">
            <td >
                 <!-- <router-link class="link" :to="{name: 'viewGame', params:{gameId: game.gameId}}" > -->
              <p>  {{game.gameId + ".   " + game.gameName}}</p>  
                    <!-- </router-link> -->
          </td>
        </tr>
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
        height: 300px;
        width: 320px;
        display: flex;
        align-items: center;
    
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
tr{
  display: flex;
  justify-content: center;
  border-bottom: 1.2px dotted #FFACBD ;
  width: 90%;
  text-align: center;
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
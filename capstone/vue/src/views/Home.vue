<template>
  <div id="Homeabout">

        <sidebar v-if="$store.state.user.username"></sidebar>
       <h2>How To Play</h2>
          <h1> Leaderboard</h1>
           <div class="Homecontainer">
               <div class="Homecontent">
               <table>
                   <tr class="user">
                       <th>Username</th>
                   </tr>
                    <td>
                    <li v-for="user in users" :key="user.id">
                    {{user.username}}
                    </li>
                    </td>
                   
                   </table>
                   </div>
                    
      </div>
     
      <div>

      </div>
  
      </div>
    
     
</template>

<script >
import userService from '../services/UserService'
import Sidebar from '@/components/sidebar/sidebar.vue'

    export default{
        components:{
            Sidebar,
           
        },
       
        data(){
            return{
            users: [],
        };
    },
    created(){
        userService.getAllUsers().then(response =>{
            this.users = response.data;
            this.$store.commit('SET_USERS', this.users)
        })
    }
    }
</script>

<style scoped>

#Homeabout{
height: 100vh; 
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;
color: #3e309c;
display: flex;
    flex-direction: column;
    align-items: center;
    text-align: left;
    

}
.user{
    font-size: 25px;
  
}


h2{
    padding-top: 20px;
    font-size:50px;
     text-align: center;
    color:white;
    text-shadow:2px 2px#6A6EBD;
}



.Homecontainer{
    height: 30vh;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 20px 100px 10px 40px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    list-style: none;
}

.stockcontainer{
     height: 30vh;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 20px 225px 10px 40px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
    list-style: none;
}



h1{
    font-size:50px;
    text-align: center;
    color:white;
    text-shadow:2px 2px#6A6EBD;
    
    
}


.lowerButtons{
    cursor: pointer;
    background:none;
    border-color:#EAFF45;
    border-radius: 5px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    color: #EAFF45;
}

.buttons{
    display:flex;
    justify-content: space-between;
    column-gap: 30px;
offset: none;
}





</style>
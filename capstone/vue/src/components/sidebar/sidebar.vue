
<template>
<div >
    <div class="sidebar " :class="{isExpanded: isExpanded ? 'true': ''}">

  
     <div class="menu-toggle-wrap" >
       <h1 class="text logo">Apricot Stocks</h1>
       <button class="menu-toggle" @click="ToggleMenu">
         <span class="material-icons">
           <span class="material-symbols-rounded">
menu
</span>
         </span>
       </button>
     </div>
    <div class="menu" >
      <h3 >Menu</h3>
    <router-link class="button links" to="/home"  > 
    <span class="material-icons">
      <span class="material-symbols-rounded" title="Home">
home
</span></span> 
<span class="text">Home</span></router-link>
    <router-link  to="/portfolio" class=" button links"> <span class="material-icons"><span class="material-symbols-rounded" title="Portfolio">
account_balance_wallet
</span></span> <span class="text">Portfolio</span></router-link>
    <router-link class="button links " to="/games" > <span class="material-icons"><span class="material-symbols-rounded" title="Games">
gamepad
</span></span><span class="text">Games</span></router-link>
    <router-link class="button links" to="/trade">
    <span class="material-icons">
      <span class="material-symbols-rounded" title="Trade">
currency_exchange
</span></span><span class="text">Trade</span></router-link>
    <router-link class="button links " to="/research" ><span class="material-icons">
      <span class="material-symbols-rounded" title="Research">
library_books
</span></span><span class="text">Research</span></router-link> 
    <router-link class="button links" to="/logout"><span class="material-icons">
      <span class="material-symbols-rounded" title="Logout">
logout
</span></span><span class="text">Logout</span></router-link>

    </div>
</div>
    </div>
</template>
<script >
export default {
  data(){
    return{
      isExpanded: localStorage.getItem("isExpanded") === "true",
    }
  },
  methods:{
    ToggleMenu(){
      this.isExpanded = !this.isExpanded;
      localStorage.setItem("isExpanded", this.isExpanded)
    }
  }
}
</script>
<style>
:root{
  --sidebar-bg-color: #AFB2ED;
  --sidebar-item-hover: #f8ed86;
  --sidebar-item-active: #f5f844;
  --sidebar-width: 290px;
}
</style>

<style lang="scss" scoped>
*{
  box-sizing: border-box;
}
.links{
  height: 50px;
  margin-bottom: 20px;
  text-decoration: none;
}

h1{
   white-space: nowrap;
}
h3{
  font-size: 1.3rem;
  margin-bottom: 2rem;
 margin-left: 30px;
 margin-right: 10px;
  font-family: Cochin, Georgia, Times, 'Times New Roman', serif;
  color:rgb(255, 255, 255, 0.87);
 margin-top: 0;
}
.links:hover{
 height: 50px;
 padding-top: 15px;

}
.menu{
  margin:0 -1rem;
  .button{
    display: flex;
    align-items: center;
    padding: 0.5rem 1rem;
    transition: 0.2s ease-out;
    .material-icons{
      font-size: 2rem;
      color:#6A6EBD;
      margin-right: 2rem;
      transition: 0.2s ease-out;
    }
    .text{
      transition: 0.2s ease-out;
   
    }
    
  }
  .router-link-exact-active, .router-link-active{
    background-color: #f1eaaa;
    border-right:6px solid rgba(255, 172, 189);
  }
}

.sidebar {
  text-shadow: 0.4px .5px #6A6EBD;
  color: white;
  background-color: var(--sidebar-bg-color);
  width: calc(2rem + 32px);
  position: fixed;
  overflow: hidden;
  height: 100vh;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.8em;
  transition: 0.2s ease-out;
  display: flex;
  flex-direction: column;
  .logo{
  margin-bottom: 1rem;
  .material-symbols-rounded{
    width: 2rem;
  }
}
}
  h3, .text{
    opacity: 0;
    transition: 0.3s ease-out;

  } 
  .button{
    transition: 0.3s ease-out;
  }

.material-icons{
  opacity: 1;
}

.isExpanded{
  width: var(--sidebar-width);
 .menu-toggle-wrap{
    top: -2rem;
   
  }

    h3,.button, .text{
    opacity: 1;
  } 
  .button{
    .material-icons{
      margin-right: 1rem;
    }
  }
  .material-icons{
    font-size:2rem;
      transition: 0.2s ease-out;
    }
    .text{
        transition: 0.2s ease-out;
    }

}

.menu-toggle-wrap{
display: flex;
justify-content: flex-end;
align-items: center;
padding-top: 25px;
position: relative;
top: 0px;
margin-left:50px;
transition: 0.2s ease-out;
.menu-toggle{
  transition: 0.2s ease-out;
.material-icons{
    font-size:2rem;
    margin-left: 15px;
    color:#6A6EBD;
    transition:0.2s ease-out;
  }
&:hover {
  .material-icons{
  color: #f8ed86;
  transform: translateX(0.5rem);
  }
}
}

}

.menu{
  margin: 0 -1rem;
  .button{
    display: flex;
    align-items: center;
    text-decoration: none;
    padding: 0.5rem 1rem;
    transition: 0.2s ease-out;
  
  .material-icons{
    font-size: 2rem;
    color: #6A6EBD;
    transition:0.2s ease-out;
  }
  .text{
    transition:0.2s ease-out;
  }

  &:hover{
    background-color:#f8ed86;
  }
  }
}


span.text{
  color: white;
  font-size:20px ;
  font-family: Cochin, Georgia, Times, 'Times New Roman', serif;
  transition: 0.3s ease-out;
}
button{
  border: none;
  background: none;
}

</style>
<script >
import sidebarlink from './sidebarlink.vue'
import { collapsed, toggleSidebar } from './state'
export default {
  data(){
    return{
      isExpanded:false,
      isExpandedForText:false
    }
  },
  components: { sidebarlink },
  setup() {
    return { collapsed, toggleSidebar }
  },
  methods:{
    ToggleMenu(){
      this.isExpanded = !this.isExpanded;
    }
  }
}
</script>




<template>
    <div class="sidebar " :class="{isExpanded: isExpanded ? 'true': ''}">
  
     <!-- <div class="menu-toggle-wrap" >
       <h1 class="text">Apricot Stocks</h1>
       <button class="menu-toggle" @click="ToggleMenu">
         <span class="material-icons">
           <span class="material-symbols-rounded">
menu
</span>
         </span>
       </button>
     </div> -->
         <!-- <h1>
      <span v-if="collapsed">
        <div>V</div>
        <div>S</div>
      </span>
      <span class="text" v-else>Apricot Stocks</span>
    </h1> -->
   
     <div class="menu-toggle-wrap" >
       <h1 class="text">Apricot Stocks</h1>
       <button class="menu-toggle" @click="ToggleMenu">
         <span class="material-icons">
           <span class="material-symbols-rounded">
menu
</span>
         </span>
       </button>
     </div>
    <div class="menu" >
    <sidebarlink class="button links" to="/home" font-awesome-icon icon="fa-solid fa-house" ><span class="text">Home</span></sidebarlink>
    <sidebarlink  to="/portfolio" i class="fa-solid fa-file button links"> <span class="text">Portfolio</span></sidebarlink>
    <sidebarlink class="button links links" to="/games" icon="fa-solid fa-gamepad"><span class="text">Games</span></sidebarlink>
    <sidebarlink class="button links" to="/trade" icon="fas fa-users"><span class="text">Trade</span></sidebarlink>
    <sidebarlink class="button links " to="/image" icon="fas fa-image"><span class="text">Research</span></sidebarlink> 
    <sidebarlink class="button links" to="/logout"><span class="text">Logout</span></sidebarlink>

    <span
      class="collapse-icon"
      :class="{ 'rotate-180': collapsed }"
      @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
    </div>
</div>
    
</template>

<style>
:root{
  --sidebar-bg-color: #AFB2ED;
  --sidebar-item-hover: #f8ed86;
  --sidebar-item-active: #f5f844;
  --sidebar-width: 300px;
}
</style>

<style lang="scss" scoped>
*{
  box-sizing: border-box;
}
menu{
  margin:0 -1rem;
  .button{
    display: flex;
    align-items: center;
   
  }
}
.sidebar {
  text-shadow: 0.4px .5px #6A6EBD;
  color: white;
  background-color: var(--sidebar-bg-color);
  width: calc(2rem + 32px);
  float: left;
  position: fixed;
  overflow: hidden;
  min-height: 100vh;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease-out;
  display: flex;
  flex-direction: column;
  @media(max-width:768px){
    position:fixed;
    z-index: 99;
  }
}
   .button, .text{
    opacity: 0;
    transition: 0.3 ease-out;

  } 
.isExpanded{
  width: var(--sidebar-width);
 .menu-toggle-wrap{
    top: -2rem;
   
  }
    .button, .text{
    opacity: 1;
  } 
  &.material-icons{
    font-size:2rem;
    color:var(--light);
      transition: 0.2 ease-out;
    }
    .text{
      color: var(-light);
        transition: 0.2 ease-out;
    }

}

 
.menu-toggle-wrap{
display: flex;
justify-content: flex-end;
align-items: center;
padding-top: 25px;
position: relative;
top: 0px;
margin-left: 4px;
transition: 0.2s ease-out;

.menu-toggle{
  transition: 0.2s ease-out;
.material-icons{
    font-size:2rem;
    color:rgba(106, 110, 189, 1);
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
    
  }
  .material-icons{
    font-size: 2rem;
    color: var(--light);
    transition: ease-out;
  }
  

  
}


 

sidebar h1 {
  height: 2.5em;
}
.collapse-icon {
  position: absolute;
  bottom: 0;
  padding: 0.75em;
  color: rgba(255, 255, 255, 0.7);
  transition: 0.2s linear;
}
.rotate-180 {
  transform: rotate(180deg);
  transition: 0.2s linear;
}
.text{
  text-align: center;
  display: flex;
  justify-content: center;
  align-content: center;
  white-space: nowrap;
  padding: 0 9px 0 9px;
  
}
span.text{
  opacity: 1;
  display: inline-block;
  width: 100%;
  font-size:20px ;
  margin-bottom: 4px;
  padding-bottom: 10px;
  text-align: center;
  font-family: sans-serif;
}
button{
  border: none;
  background: none;
}
.links{
  padding:19px;
  
}
</style>
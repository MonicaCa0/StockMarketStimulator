<script >
import sidebarlink from './sidebarlink.vue'
import { collapsed, toggleSidebar, sidebarWidth } from './state'
export default {
  props: {},
  components: { sidebarlink },
  setup() {
    return { collapsed, toggleSidebar, sidebarWidth }
  }
}
</script>




<template>
    <div class="sidebar" :style="{width: sidebarWidth}">
     
         <h1>
      <span v-if="collapsed">
        <div>V</div>
        <div>S</div>
      </span>
      <span class="text" v-else>Apricot Stocks</span>
    </h1>
   

    <sidebarlink to="/home" font-awesome-icon icon="fa-solid fa-house" >Home</sidebarlink>
    <sidebarlink to="/portfolio" i class="fa-solid fa-file">Portfolio</sidebarlink>
    <sidebarlink to="/games" icon="fa-solid fa-gamepad">Games</sidebarlink>
    <sidebarlink to="/trade" icon="fas fa-users">Trade</sidebarlink>
    <sidebarlink to="/image" icon="fas fa-image">Research</sidebarlink> 
    <sidebarlink to="/logout">Logout</sidebarlink>

    <span
      class="collapse-icon"
      :class="{ 'rotate-180': collapsed }"
      @click="toggleSidebar"
    >
      <i class="fas fa-angle-double-left" />
    </span>
</div>
    
</template>

<style >
:root{
  --sidebar-bg-color: #AFB2ED;
  --sidebar-item-hover: #f8ed86;
  --sidebar-item-active: #f5f844;
}

</style>

<style scoped>
.sidebar {
  color: white;
  background-color: var(--sidebar-bg-color);
  
  float: left;
  position: fixed;
  z-index: 1;
  top: 0;
  left: 0;
  bottom: 0;
  padding: 0.5em;
  transition: 0.3s ease;
  display: flex;
  flex-direction: column;
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
/* .text{
  text-align: center;
  display: flex;
  justify-content: center;
  align-content: center;
  white-space: nowrap;
  
} */
</style>
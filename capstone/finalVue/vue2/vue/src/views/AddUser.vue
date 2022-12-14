<template>
<div class="container">
    <Header></Header>
  <div class="Main">
    <add-user></add-user>
  </div>
</div>
</template>

<script>
import Header from '@/components/Header.vue'
import AddUser from  '../components/AddUser.vue'

export default {

components:{
    AddUser,
    Header
}
}
</script>

<style scoped>

.Main{
height: 100vh; 
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;
color: #3e309c;
display: flex;
flex-direction: column;
align-items: center;
justify-content: space-around;
/* row-gap: 20px; */
text-align: left;
}
</style>
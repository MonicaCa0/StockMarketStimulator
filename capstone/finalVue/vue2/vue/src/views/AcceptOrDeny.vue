<template>
<div class="background">
  <div class="main">
    <accept-or-deny />
  </div>
  </div>
</template>

<script>
import AcceptOrDeny from '@/components/AcceptOrDeny.vue'
export default {
components:{
    AcceptOrDeny,
}
}
</script>

<style scoped>
*{
    box-sizing: border-box;
}

 .main{
display: flex;
justify-content: center;
align-items: center;
color: #3e309c; 
  top: 0;
height: 100vh;
background:linear-gradient(0.25turn, rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9));
background-repeat: no-repeat;
background-position: center;
background-size: cover;

}

</style>
<template>
  <div class="background">
      <div class="container">
          <h1>Portfolio</h1>
          <div class="content">
              <p>content goes here</p>
              <p>more content</p>
              </div>

        </div>
       <div>
    <sidebar></sidebar>
  </div>
  </div>
</template>

<script >


</script>

<style>
.background{
  background-color:#AFB2ED;
    height:100vh;
    background-image: url('../assets/yellowObjects.svg');
    background-repeat: no-repeat;
    background-size: cover;
    background-image:linear-gradient(-45deg,#AFB2ED 10%,#FFACBD,#AFB2ED );
}

.container{
   display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
}
.content{
    display: flex;
    justify-content: flex-start;
}

h1{
   
}


</style>
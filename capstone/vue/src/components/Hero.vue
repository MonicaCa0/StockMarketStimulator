<template>
  <div class="background">
      <div class="gradient">
          <div class="container">
              <div class="content">
             <h1 id="h">Navigate the Stock Market the right way.</h1>

             <router-link to ="/about"><Button class="upperButtons" title="Learn More"></Button></router-link>
                <div class='buttons'> 
                <router-link v-bind:to="{name:'home'}"><Button  class="lowerButtons" :title="'Login'"></Button></router-link>
                <router-link v-bind:to="{name:'register'}"> <Button class="lowerButtons" :title="'Register'"></Button></router-link>
        
                </div>
                </div>
            </div> 
     
    </div>
  </div>
</template>

<script>
import Button from '../components/Button.vue'
export default {
components:{
    Button
}
}
</script>

<style scoped>
.background{
    background-color:#AFB2ED;
    height:100vh;
}
.container{
    height: 100vh;
    background-image: url('../assets/yellowObjects.svg');
    background-repeat: no-repeat;
    background-size: cover;
     
}
.content{
    height: 100%;
    width: 100%;
    display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    row-gap: 35px;
     font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
.gradient{
    height: 100vh;
    background-image:linear-gradient(-45deg,#AFB2ED 10%,#FFACBD,#AFB2ED );
    background-repeat: no-repeat;
    background-size: cover;
     
}
h1, p{
color:#EAFF45;
}
h1{
    font-size: 60px;
    width: 30%;
    text-align: center;
    margin-bottom:0;
    text-shadow:2px 2px#6A6EBD ;
    }
p.learn{
    display: inline-block;
    border:5px solid hsl(67, 100%, 64%) ;
    margin-bottom:20px;

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
.upperButtons{
    cursor: pointer;
    background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 30px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    color: #6A6EBD;
    
}
.buttons{
    display:flex;
    justify-content: space-between;
    column-gap: 10px;
offset: none;
}

</style>
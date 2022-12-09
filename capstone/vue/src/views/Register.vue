<template>
  <div id="register" class="text-center">
    <form class="form-register" @submit.prevent="register">
      <div class="containerReg">
        <div class="contentReg">
      <h1 class="h3 mb-3 font-weight-normal">Create Account</h1>
      <div class="alert alert-danger" role="alert" v-if="registrationErrors">
        {{ registrationErrorMsg }}
      </div>
      <label for="username" class="sr-only">Username</label>
      <input
        type="text"
        id="username"
        class="form-control"
        placeholder="Username"
        v-model="user.username"
        required
        autofocus
      />
      <label for="password" class="sr-only">Password</label>
      <input
        type="password"
        id="password"
        class="form-control"
        placeholder="Password"
        v-model="user.password"
        required
      />
      <input
        type="password"
        id="confirmPassword"
        class="form-control"
        placeholder="Confirm Password"
        v-model="user.confirmPassword"
        required
      />
      <router-link class="link" :to="{ name: 'login' }">Have an account?</router-link>
      <button v-on:click="transferBack">Cancel</button>
      <button class="btn btn-lg btn-primary btn-block" type="submit">
        Create Account
      </button>
      </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from '../services/AuthService';

export default {
  name: 'register',
  data() {
    return {
      user: {
        username: '',
        password: '',
        confirmPassword: '',
        role: 'user',
      },
      registrationErrors: false,
      registrationErrorMsg: 'There were problems registering this user.',
    };
  },
  methods: {
    register() {
      if (this.user.password != this.user.confirmPassword) {
        this.registrationErrors = true;
        this.registrationErrorMsg = 'Password & Confirm Password do not match.';
      } else {
        authService
          .register(this.user)
          .then((response) => {
            if (response.status == 201) {
              this.$router.push({
                path: '/login',
                query: { registration: 'success' },
              });
            }
          })
          .catch((error) => {
            const response = error.response;
            this.registrationErrors = true;
            if (response.status === 400) {
              this.registrationErrorMsg = 'Bad Request: Validation Errors';
            }
          });
      }
    },
    clearErrors() {
      this.registrationErrors = false;
      this.registrationErrorMsg = 'There were problems registering this user.';
    },
      transferBack(){
      this.$router.push("/")
    }
  },
};
</script>

<style scoped>

#register{
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
 background-image:linear-gradient(to bottom,rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9)), 
 url("../assets/backgroundStockV3.png");
  
}

.containerReg{
    height: 50vh;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 30px 70px 170px 70px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
.contentReg{
  display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    row-gap: 20px;
   padding-top: 60px;
  width: 100%;
  height: 100%;
}
.sr-only{
    font-size:1.2rem;
    color:#6A6EBD;
}
h1{
  color:#6A6EBD;
  font-size: 40px;
  margin-bottom: 16px;
}.link{
  text-decoration: none;
color:#6A6EBD;
}
.link:hover{
  color: rgba(255, 172, 189);
}
.link:active{
  color: #EAFF45;
}
button{
  cursor: pointer;
   background:#EAFF45;
    border-color:#EAFF45;
    border-radius: 30px;
    border-style:solid;
    padding:12px 24px 12px 24px;
    width: 65%;
    color: #6A6EBD;
    margin-bottom: 22px;
  font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;
}
input{
  border-color:#EAFF45;
  border-style: solid;
  border-radius: 10px;
  text-align: left;
  padding: 5px 10px;
    margin-top: -2px;
}
input:focus{
  border-color: rgba(255, 172, 189);
   border-style: solid;
  border-radius: 10px;
  text-align: left;
  padding: 5px 10px;

}

input::placeholder{
padding-left: 5px;
color:#9699c7;

}
@media screen and (max-width: 1096px) {
 .container{
    height: 50vh;
    row-gap: 10px;
    width: 70%;
    border-radius: 8px;
    box-shadow: 20px 15px 40px rgba(96, 109, 2, 0.5);
    
 
}
  .content{
  display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    row-gap: 20px;
  padding-top: 50px;
  width: 100%;
  height: 100%;
}h1{
  color:#6A6EBD;
  font-size: 30px;
}

}
@media screen and (max-width: 900px) {
 .container{
    height: 40vh;
    row-gap: 10px;
    padding-top: 65px;
    width: 70%;
    border-radius: 8px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    
 
}
  .content{
  display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
    row-gap: 20px;
   
    
}h1{
  color:#6A6EBD;
  font-size: 30px;
  margin-top: 0px;
  
}
}
</style>

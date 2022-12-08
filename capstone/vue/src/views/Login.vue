<template>
  <div id="login" class="text-center">
    <form class="form-signin" @submit.prevent="login">
        <div class="container">
          <div class="content">
      <h1 class="h3 mb-3 font-weight-normal">Please Sign In</h1>
      <div
        class="alert alert-danger"
        role="alert"
        v-if="invalidCredentials"
      >Invalid username and password!</div>
      <div
        class="alert alert-success"
        role="alert"
        v-if="this.$route.query.registration"
      >Thank you for registering, please sign in.</div>
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
      <router-link class="link" :to="{ name: 'register' }">Need an account?</router-link>
      <button type="submit">Sign in</button>
      <button v-on:click="transferBack">Cancel</button>
      </div>
      </div>
    </form>
  </div>
</template>

<script>
import authService from "../services/AuthService";

export default {
  name: "login",
  components: {},
  data() {
    return {
      user: {
        username: "",
        password: ""
      },
      invalidCredentials: false
    };
  },
  methods: {
    login() {
      authService
        .login(this.user)
        .then(response => {
          if (response.status == 200) {
            this.$store.commit("SET_AUTH_TOKEN", response.data.token);
            this.$store.commit("SET_USER", response.data.user);
            this.$router.push("/home");
          }
        })
        .catch(error => {
          const response = error.response;

          if (response.status === 401) {
            this.invalidCredentials = true;
          }
        });
    },
    transferBack(){
      this.$router.push("/")
    }
  }
};
</script>
<style scoped>
#login{
  height: 100vh;
  display: flex;
  justify-content: center;
  align-items: center;
 background-image:linear-gradient(to bottom,rgba(175, 178, 237, .9) 0%,rgba(255, 172, 189, .9),rgba(175, 178, 237, .9)), 
 url("../assets/backgroundStock.png");
  
}

.container{
  height: 50vh;
    background-color: rgba(255,255,255,1) ;
    border-radius: 8px;
    padding: 30px 70px 150px 70px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
    font-family: Cambria, Cochin, Georgia, Times, 'Times New Roman', serif;   
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
}
.sr-only{
    font-size:1.2rem;
    color:#6A6EBD;
}
h1{
  color:#6A6EBD;
  font-size: 40px;
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
    padding: 40px 70px 120px 70px;
    row-gap: 10px;
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
}
#login{
  height: 100vh;
}
}
@media screen and (max-width: 900px) {
 .container{
    height: 50vh;
    padding: 40px 70px 120px 70px;
    row-gap: 10px;
    width: 60%;
    border-radius: 8px;
    box-shadow: 20px 15px 40px rgba(234, 255, 69, .5);
 
}
  .content{
  display: flex;
    flex-direction: column;
    align-items: center;
    justify-content: center;
     padding-top: 50px;
  width: 100%;
  height: 100%;
}h1{
  color:#6A6EBD;
  font-size: 30px;
}

}

</style>
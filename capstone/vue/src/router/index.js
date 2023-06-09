import Vue from 'vue'
import Router from 'vue-router'
import Home from '../views/Home.vue'
import Login from '../views/Login.vue'
import Logout from '../views/Logout.vue'
import Register from '../views/Register.vue'
import Trade from '../views/Trade.vue'
import Research from '../views/Research.vue'
import LandingPage from '../views/LandingPage.vue'
import CreateGame from '../views/MainGamePage/CreateGame.vue'
import JoinGame from '../views/MainGamePage/JoinGame.vue'
import ViewCurrentGames from '../views/MainGamePage/ViewCurrentGames.vue'
import ViewGame from '../views/ViewGame.vue'
import Portfolio from '../views/Portfolio.vue'
import AddNewGame from '../views/AddNewGame.vue'
import AddUser from '../views/AddUser.vue'
import Games from '../views/Games.vue'
import store from '../store/index'
import About from '../views/About.vue'

Vue.use(Router)

/**
 * The Vue Router is used to "direct" the browser to render a specific view component
 * inside of App.vue depending on the URL.
 *
 * It also is used to detect whether or not a route requires the user to have first authenticated.
 * If the user has not yet authenticated (and needs to) they are redirected to /login
 * If they have (or don't need to) they're allowed to go about their way.
 */

const router = new Router({
  mode: 'history',
  base: process.env.BASE_URL,
  routes: [
    {
      path: '/home',
      name: 'home',
      component: Home,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/login",
      name: "login",
      component: Login,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/logout",
      name: "logout",
      component: Logout,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/register",
      name: "register",
      component: Register,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/",
      name: "landing",
      component: LandingPage,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/create",
      name: "create",
      component: CreateGame,
      meta:{
        requiresAuth: true
      }
    },
    {
      path: "/join",
      name: "join",
      component: JoinGame,
      meta:{
        requiresAuth: true
      }
    },
    {
      path: "/games/:gameId/response",
      name: "acceptOrDeny",
      component: ViewCurrentGames,
      meta:{
        requiresAuth: true
      }
    },
    {
      path: "/portfolio",
      name: "portfolio",
      component: Portfolio ,
      meta:{
        requiresAuth: true
      }
    },
    {
      path: "/games",
      name: "games",
      component: Games,
      meta:{
        requiresAuth: true
      }
    },
      {
      path: "/about",
      name: "about",
      component: About,
      meta: {
        requiresAuth: false
      }
    },
    {
      path: "/trade",
      name: "trade",
      component: Trade,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/research",
      name: "research",
      component: Research,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/games/:id/addNewGame",
      name: "addNewGame",
      component: AddNewGame,
      meta: {
        requiresAuth: true
      }
    },
    {
      path: "/games/:id/addUser",
      name: "addUser",
      component: AddUser,
      meta: {
        requiresAuth: true
      }
    }
    ,
    {
      path: "/games/:gameId",
      name: "viewGame",
      component: ViewGame,
      meta: {
        requiresAuth: true
      }
    }
  ]
})

router.beforeEach((to, from, next) => {
  // Determine if the route requires Authentication
  const requiresAuth = to.matched.some(x => x.meta.requiresAuth);

  // If it does and they are not logged in, send the user to "/login"
  if (requiresAuth && store.state.token === '') {
    next("/login");
  } else {
    // Else let them go to their next destination
    next();
  }
});

export default router;

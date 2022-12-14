<template>
<div class="containerForButtons">
  <div class="buttons">
    <router-link v-bind:to="{name:'addNewGame', params:{id: $store.state.user.id}}">
      <Button :title="'Add a Game'"> 
       Add Players
      </Button>
  </router-link>
<router-link v-bind:to="{name:'addUser', params:{id: $store.state.user.id}}">
      <Button :title="'Add a Player'"> 
       Add Players
      </Button>
  </router-link>
  <router-link v-bind:to="{name:'addUser', params:{id: $store.state.user.id}}">
      <Button :title="'Add a Player'"> 
       Add Players
      </Button>
  </router-link>
</div>
</template>

<script>
export default {

}
</script>

<style scoped>

</style>
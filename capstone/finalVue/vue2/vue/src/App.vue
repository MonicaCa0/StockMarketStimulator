<template>
  <div id="app">
    <!-- <router-view /> -->
    <router-view v-bind:key="$route.fullPath" />
  </div>
</template>

<style scoped>

</style>
<template>
  <div id="app">
    <Header></Header>
    <div id="nav">
      <router-view/>
    </div>
  </div>
</template>

<script>
import Header from './components/Header'
export default {
  components:{
    Header
  }
  
}
</script>>
<style>

</style>

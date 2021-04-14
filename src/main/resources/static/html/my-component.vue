<template>
  <div class="hello">Hello1 {{who}}</div>
</template>

<script>
module.exports = {
  data: function() {
    return {
      who: 'world'
    }
  }
}
</script>

<style>
.hello {
  background-color: #ffe;
}
</style>
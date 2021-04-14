<template>
  <div className="hello">Hello1 {{ who }}</div>
</template>

<script type="module">
import { provinceAndCityData } from 'element-china-area-data'
module.exports = {
  data: function () {
    return {
      who: 'world',
      options: provinceAndCityData,
      selectedOptions: [],
    }
  }
}
</script>
<style>
.hello {
  background-color: #ffe;
}
</style>
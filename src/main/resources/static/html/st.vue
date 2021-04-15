<template>
  <div id="app">
    <el-cascader
        size="large"
        :options="options"
        v-model="selectedOptions"
        @change="handleChange">
    </el-cascader>
  </div>
</template>

<script>

import { provinceAndCityData } from 'element-china-area-data'
export default {
  name: 'st',
  data () {
    return {
      options: provinceAndCityData,
      selectedOptions: []
    }
  },
  methods: {
    handleChange (value) {
      console.log(value)
    }
  },
}
</script>
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
import { regionData,CodeToText } from 'element-china-area-data'



export default {
  name:'st',
  data () {
    return {
      options: regionData,
      selectedOptions: []
    }
  },
  methods: {
    handleChange (value) {
      sessionStorage.setItem("sheng",CodeToText[value[0]]);
      sessionStorage.setItem("shi",CodeToText[value[1]]);
      sessionStorage.setItem("qu",CodeToText[value[2]]);
    }
  }
}
</script>
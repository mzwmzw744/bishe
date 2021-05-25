<template>
  <div id="app" style="width: 100%;background-color: white; padding:10px;box-shadow: 0 2px 4px rgba(0, 0, 0, .12), 0 0 6px rgba(0, 0, 0, .04)">
    <div style="overflow: hidden;margin: 50px auto;width: 330px;">
      <div style="float: left;line-height: 30px;color: red;margin-right: 5px">*</div>
      <div style="float: left;line-height: 40px;margin-right: 10px">地址信息:</div>
      <div style="float: left"><st ref="progressTwo"></st></div>
    </div>

    <div style="background: bisque;width: 330px;margin: 0 auto">
      <div style="float: left;line-height: 30px;color: red;margin-right: 5px">*</div>
      <div style="margin-left: 10px">详情地址信息</div>
      <div><el-input
          type="textarea"
          :rows="2"
          placeholder="请输入详情地址信息"
          v-model="info.addressDetail">
      </el-input></div>
      
    </div>
    <div style="background: bisque;width: 330px;margin: 50px auto">
      <div style="margin-left: 10px">邮政编码</div>
      <el-input v-model="info.postCode" placeholder="请输入邮政编码"></el-input>
    </div>

    <div style="background: bisque;width: 330px;margin: 50px auto">
      <div style="float: left;line-height: 30px;color: red;margin-right: 5px">*</div>
      <div style="margin-left: 10px">收货人姓名</div>
      <el-input v-model="info.name" placeholder="请输入收货人姓名"></el-input>
    </div>

    <div style="background: bisque;width: 330px;margin: 50px auto">
      <div style="float: left;line-height: 30px;color: red;margin-right: 5px">*</div>
      <div style="margin-left: 10px">手机号码</div>
      <el-input v-model="info.phone" placeholder="请输入手机号码"></el-input>
    </div>


    <div style="width: 70px;margin: 50px auto">
      <div style="margin-left: 10px"> <el-button v-on:click="bc"    type="primary" size="small">保存</el-button></div>
    </div>

  </div>
</template>

<style>
 *{
   padding: 0;
   margin: 0;
 }
</style>

<script>
import st from '@/components/st.vue'

window.onmessage=function(e){
  if(e.data.sheng !=null && e.data.shi !=null){
    vm.$refs.progressTwo.selectMessage.push(e.data.sheng);
    if(e.data.shi !=null){
      vm.$refs.progressTwo.selectMessage.push(e.data.shi.code);
    }
    vm.$refs.progressTwo.selectMessage.push(e.data.qu.code);
  }
}


var vm = null;

export default {
  name: 'test',
  data() {
    return {
      info:{
        addressDetail:'',
        phone:'',
        name:'',
        postCode:'',
        sheng:'',
        shi:'',
        qu:''
      },
    }
  },
  components: {
    st
  },
  created: function() {
    vm = this
  },
  methods:{
    bc(){
      this.info.sheng = sessionStorage.getItem("sheng")
      this.info.shi = sessionStorage.getItem("shi")
      this.info.qu =sessionStorage.getItem("qu")
      window.parent.postMessage(this.info, '*');
    }
  },

}
</script>
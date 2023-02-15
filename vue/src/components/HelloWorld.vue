<template>
  <div class="common-layout">

    <el-card class="box-card">
      <el-divider content-position="left"><el-link type="primary" disabled>自用项目 ，禁止商用 ！！！</el-link></el-divider>
      <el-divider content-position="right"><el-link>
        <a href="https://ap1.storj.io/new-project-dashboard" target="_blank" style="text-decoration: none">
          前往
        </a>
      </el-link></el-divider>
      <div class="input">
        <el-input
            style="width: 400px"
            v-model="data.url" placeholder="网址" />
        <el-input
            style="width: 400px"
            v-model="data.newName" placeholder="转换后名称" />
        <el-button color="#626aef" plain @click="convert()">转换</el-button>
        <el-button color="#626aef" plain @click="btn()">一键复制</el-button>
      </div>
    </el-card>
  </div>
</template>


<script setup>
import useClipboard from 'vue-clipboard3'
import {reactive} from 'vue'
import { ElMessage } from 'element-plus'
import {convert_List} from "../api/user";
const data = reactive({
  url: '',
  newName: '',
  returnUrl:''
})


//转换
const convert=()=>{
  convert_List({
    url: data.url,
    newName:data.newName
  }).then(res=>{
    data.returnUrl= res.msg
    ElMessage({
      message: '转换成功 ，请复制',
      type: 'success',
    })
  })
}
const btn=()=>{
  copy(data.returnUrl)
}

//一键复制
const { toClipboard } = useClipboard()
const copy = async (Msg) => {
  try {
    await toClipboard(Msg)
    ElMessage({
      message: '复制成功',
      type: 'success',
    })
  } catch (e) {
    ElMessage.error('复制失败')
  }
}
</script>

<style scoped>
.common-layout{
  width: 100%;
}
.text {
  font-size: 14px;
}

.item {
  padding: 18px 0;
}

.box-card {
  width: 75%;
  height: 450px;
  margin: 30px auto;
}
.input{
  display: flex;
  margin-top: 100px;
  justify-content: center;
}
</style>

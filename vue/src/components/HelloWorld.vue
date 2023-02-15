<template>
  <div class="common-layout">

    <el-card class="box-card">
      <el-divider content-position="left"><el-link type="primary" disabled>自用项目 ，禁止商用 ！！！</el-link></el-divider>
      <div class="input">
        <el-input
            style="width: 400px"
            v-model="input" placeholder="请输入" />
        <el-button color="#626aef" plain @click="convert">转换</el-button>
        <el-button color="#626aef" plain @click="btn(input)">一键复制</el-button>
      </div>
    </el-card>
  </div>
</template>


<script setup>
import useClipboard from 'vue-clipboard3'
import {ref} from 'vue'
import { ElMessage } from 'element-plus'
let input = ref()
//转换
const convert=()=>{
alert("fdjd")
}
const btn=(input)=>{
  copy(input)
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

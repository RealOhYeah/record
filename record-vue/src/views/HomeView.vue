<!--
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-02 20:21:40
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-04 17:44:57
 * @FilePath: \record-vue\src\views\HomeView.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<script setup> 

import { reactive, ref } from 'vue'
import { recordGenerateService } from '@/api/record.js' 
import { recordDownloadService } from '@/api/record.js' 

import { ElMessage } from 'element-plus'
const dialogFormVisible = ref(false) 


const form = ref({
    name: '笔录',
    type: 'docx',
    content: '测试文本',
    status: '0',
    delFlag: '0'

})
 

const onSubmit = async () => {
    dialogFormVisible.value = false;
  
    if (!form) return
 
    const res  = await recordGenerateService(form.value)
 
    
    if (res.data.code === "0x200") {
 
        ElMessage.success({
            message: '文档生成成功',
            type: 'success',
            plain: true,
        })  
    } else {
        ElMessage.error({
            message: '文档生成失败',
            type: 'error',
            plain: true,
        })
    }
  
    const resDownload = await recordDownloadService(form.value.name + "." + form.value.type).then(response => {
        if (response.status === 200) {
            download(response)
            ElMessage.success({
                message: '文档下载成功',
                type: 'success',
                plain: true,
            })  
        }

    });
 
      
    form.value.name = ''  
    form.value.content = '' 

    
   

}

const download  =  (response) => {
    const fileName = response.headers["content-disposition"].split(";")[2].split("=")[1]
    const newName = decodeURIComponent(fileName.substring(1, fileName.length - 1))
    
 
    let link = document.createElement('a')
    let url = null
    const binaryData = [];
    binaryData.push(response.data);
    url = window.URL.createObjectURL(new Blob(binaryData, { type: 'application/vnd.openxmlformats-officedocument.wordprocessingml.document;chartset=UTF-8' }));
    link.href = url;
    //设置下载文件名
    link.download = decodeURIComponent(newName);
    //模拟点击
    link.click();
    //释放资源并删除创建的a标签
    URL.revokeObjectURL(link.href);
    link.remove()

}


const resetForm = () => {
    dialogFormVisible.value = false;
   
    if (!form || form.value.name == '笔录') return

    form.value.name = ''
    form.value.content = ''
    form.value.status = ''
    form.value.delFlag = ''
 
}
 

</script>

<template >
    <div style="text-align: center; padding-top: 8.3%;line-height: 50px;">
        <div>
            <h1 class="tool_header_title">
                一键生成你需要的Word文档
            </h1>
            <h3 class="tool_header_subtitle">
                通过指定需要生成文档的名字、类型和内容来生成您需要的Word文档。
            </h3>
            <span class="tool_header_small">
                我们采用的Vue3+SpringBoot+poi-tl的前后端分离技术。
            </span>
        </div>

        <el-button @click="dialogFormVisible = true" style=" font-size: 30px;width: 260px;height: 70px;"
            type="primary">点击生成</el-button>

        <el-dialog v-model="dialogFormVisible" title="请填写文档的基本信息" width="500">
            <el-form :model="form">
                <el-form-item label="文档名字：" placeholder="请填写文档名">
                    <el-input v-model="form.name" />
                </el-form-item>
                <el-form-item label="文档类型：" placeholder="目前支持docx类型文档">
                    <el-input readonly v-model="form.type" />
                </el-form-item>
                <el-form-item label="文档内容：" placeholder="请填写文档内文本内容">
                    <el-input v-model="form.content" />
                </el-form-item>
                <el-form-item label="文档状态：">
                    <el-select v-model="form.status" placeholder="文档的状态">
                        <el-option label="正常状态" value="0" />
                        <el-option label="异常状态" value="1" />
                    </el-select>
                </el-form-item>
                <el-form-item label="逻辑删除：">
                    <el-select v-model="form.delFlag" placeholder="是否逻辑删除">
                        <el-option label="未删除" value="0" />
                        <el-option label="已删除" value="1" />
                    </el-select>
                </el-form-item>

            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="resetForm()">
                        取消
                    </el-button>
                    <el-button type="primary" @click="onSubmit()">
                        确定
                    </el-button>
                </div>
            </template>
        </el-dialog>
    </div>
</template>

<style lang="scss">
 

.tool_header_small {
    padding-bottom: 10px;
    margin-top: 10px;
    line-height: 28px;
    font-size: 16px;
    font-weight: 400;
    display: block;
}
 .tool_header_subtitle{
    padding-left: 50px;
    max-width: 800px;
    margin: 8px auto 0;
    line-height: 32px;
    font-size: 22px;
    font-weight: 400;
    color: #47474f;
 }
 

</style>

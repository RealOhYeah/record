<!--
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-02 20:21:40
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-03 17:16:50
 * @FilePath: \record-vue\src\views\HomeView.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<script setup> 

import { reactive, ref } from 'vue'

const dialogFormVisible = ref(false)
const formLabelWidth = '140px'


const form = reactive({
    name: '',
    region: '',
    date1: '',
    date2: '',
    delivery: false,
    type: [],
    resource: '',
    desc: '',
})


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
                <el-form-item label="文档名字：" required prop="name">
                    <el-input v-model="form.name" />
                </el-form-item>
                <el-form-item label="文档类型："  required prop="type">
                    <el-input v-model="form.type"  />
                </el-form-item>
                <el-form-item label="文档内容：" required prop="content">
                    <el-input v-model="form.content" />
                </el-form-item>

                <el-form-item label="创建时间：" required prop="createTime">
                    <el-col :span="11">
                        <el-form-item prop="date1">
                            <el-date-picker v-model="form.date1" type="date" aria-label="Pick a date"
                                placeholder="Pick a date" style="width: 100%" />
                        </el-form-item>
                    </el-col>
                    <el-col class="text-center" :span="2">
                        <span class="text-gray-500">-</span>
                    </el-col>
                    <el-col :span="11">
                        <el-form-item prop="date2">
                            <el-time-picker v-model="form.date2" aria-label="Pick a time" placeholder="Pick a time"
                                style="width: 100%" />
                        </el-form-item>
                    </el-col>
                </el-form-item>
                <el-form-item label="文档状态：" required prop="status">
                    <el-select v-model="form.status" placeholder="文档的状态">
                        <el-option label="正常状态" value="0" />
                        <el-option label="异常状态" value="1" />
                    </el-select>
                </el-form-item>
                <el-form-item label="逻辑删除：" required prop="delFlag">
                    <el-select v-model="form.delFlag" placeholder="是否逻辑删除">
                        <el-option label="未删除" value="0" />
                        <el-option label="已删除" value="1" />
                    </el-select>
                </el-form-item>

            </el-form>
            <template #footer>
                <div class="dialog-footer">
                    <el-button @click="dialogFormVisible = false">
                        取消
                    </el-button>
                    <el-button type="primary" @click="dialogFormVisible = false">
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

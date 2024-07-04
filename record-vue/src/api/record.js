/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-03 20:21:12
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-04 15:53:45
 * @FilePath: \record-vue\src\api\record.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import http from '@/utils/request'

// 生成文档
export const recordGenerateService = (data) => http.post('/api/record/generate',data)

// 下载生成的文档
export const recordDownloadService = (wordUrl) => 
    http.get('/api/record/download',{
        params: { wordUrl } 
    }       
)   


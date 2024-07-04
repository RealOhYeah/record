/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-03 19:53:44
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-04 17:28:48
 * @FilePath: \record-vue\src\utils\request.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
 
/* 封装axios用于发送请求 */
import axios from 'axios'
 
const http = axios.create({
  baseURL: '', 
  withCredentials: true,
  timeout: 10000,
  headers: {
        'Content-Type': 'application/json; charset=utf-8'
    }
})

// 添加请求拦截器
http.interceptors.request.use(
  (config) => {
    
    console.log(666666666666666) 
   
    if (config.method === 'get') {
      //请求加上responseType
      config.responseType = 'blob'; 
          
   }
    return config;
  },
  // 对请求错误做些什么
  (err) => Promise.reject(err)
)

// 添加响应拦截器
http.interceptors.response.use(
  // 对响应数据做点什么
  (res) => { 
     return res;
  },
  (err) => {
    console.log(res)   
    return Promise.reject(err)
  }
)

  
export default http 

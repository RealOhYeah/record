/*
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-02 20:21:40
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-02 23:21:39
 * @FilePath: \record-vue\vite.config.js
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
 */
import { fileURLToPath, URL } from 'node:url'

import { defineConfig } from 'vite';
import vue from '@vitejs/plugin-vue';


// https://vitejs.dev/config/
export default defineConfig({
  server: {
    proxy: {
      '/api': {
        target: 'https://127.0.0.1:8081',
        changeOrigin: true, 
        rewrite: (path) => path.replace(/^\/api/, '')
      }
    }
  },
  base: '/',
  plugins: [
    vue()
  ],
  resolve: {
    // 设置文件./src路径为 @
     alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  }
});
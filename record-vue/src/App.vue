<!--
 * @Author: Oh...Yeah!!! 614988210@qq.com
 * @Date: 2024-07-02 20:21:40
 * @LastEditors: Oh...Yeah!!! 614988210@qq.com
 * @LastEditTime: 2024-07-03 11:04:25
 * @FilePath: \record-vue\src\App.vue
 * @Description: 这是默认设置,请设置`customMade`, 打开koroFileHeader查看配置 进行设置: https://github.com/OBKoro1/koro1FileHeader/wiki/%E9%85%8D%E7%BD%AE
-->
<template>
  <div id="app" >
    <router-view />
  </div>
</template>

<style lang="scss">
 @media (min-width: 1024px) {
   #app {
     padding-top: 8%;
     display: inline-block;
     grid-template-columns: none;
   }
 }
* {
  padding: 0;
  margin: 0;
  box-sizing: border-box;
}
 

a {
  color: black;
}

html {
  height: 100%;
  width: 100%;
}

body {
  width: 100%;
  height: 100%;
  background-color: #f5f5fa;
}

#app { 
  width: 100%;
  height: 100%;
  margin: 0;
  padding: 0;
  box-sizing: border-box;
}
</style>

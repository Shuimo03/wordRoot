<template>
    <div>      
        <label>邮箱登录</label>
        <input type="email" class="form-control"   placeholder="Enter email" v-model="loginFrom.email">
        <label>密码</label>
        <input type="password" class="form-control" placeholder="Password" v-model="loginFrom.password">
        <button class="btn btn-primary" v-on:click="login">登录</button>
    </div>
</template>

<!--
  template是一个写html的标签，script是使用js的标签，methods中定义了登录按钮的点击方法，
  即向后端/logn接口发送数据，成功获得响应200后，页面跳到指定位置(这里写的是/index)  
  因为设置了默认的URL，所以请求发到了http://localhost:8443/api/login
  这个位置在main.js中可以修改。
-->
<script>
export default {
    name: 'Login',
    data() {
        return {
            loginFrom:{
                email:'',
                password:''
            },
            responseResult:[]
        }
    },
    methods: {
        login(){
            this.$axios
            .post('/login',{
                email:this.loginFrom.email,
                password:this.loginFrom.password
            })
            .then(successResponse => {
                if(successResponse.data.code == 200){
                    this.$router.replace({path:'/index'})
                }
            })
            .catch(failResponse => {
            })
        }
    }
}
</script>
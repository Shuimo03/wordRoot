<template>
<div class="container">
    <div class="row">
        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto">
                    <div class="card rounded shadow shadow-sm">
                        <div class="card-header">
                            <h3 class="mb-0">登录</h3>
                        </div>
                        <div class="card-body">
                                <div class="form-group">
                                    <label for="uname1">电子邮箱</label>
                                    <input type="email" class="form-control form-control-lg rounded-0" v-model="loginFrom.email">
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" v-model="loginFrom.password">
                                </div>
                        <router-link target="_blank" :to="{path:'/signup'}">
                        <button type="submit" class="btn btn-success btn-lg float-right">没有账号？注册</button>
                        </router-link>
                        </div>
                         <button type="submit" class="btn btn-success btn-lg float-right" v-on:click = "login">登录</button>
                    </div>
                </div>
            </div>
        </div> 
    </div>
</div>
<!--/container-->
</template>

<!--
  template是一个写html的标签，script是使用js的标签，methods中定义了登录按钮的点击方法，
  即向后端/logn接口发送数据，成功获得响应200后，页面跳到指定位置(这里写的是/index)  
  因为设置了默认的URL，所以请求发到了http://localhost:8443/api/login
  这个位置在main.js中可以修改。
-->
<script lang = "ts">
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
                    this.$router.replace({path:'/'})
                }
            })
            .catch(failResponse => {
            })
        }
    }
}
</script>
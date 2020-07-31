<template>
<div class="container">
    <div class="row">
        <div class="col-md-12 min-vh-100 d-flex flex-column justify-content-center">
            <div class="row">
                <div class="col-lg-6 col-md-8 mx-auto">

                    <!-- form card login -->
                    <div class="card rounded shadow shadow-sm">
                        <div class="card-header">
                            <h3 class="mb-0">注册</h3>
                        </div>
                        <div class="card-body">
                                <div class="form-group">
                                    <label for="uname1">用户名</label>
                                    <input type="text" class="form-control form-control-lg rounded-0" v-model="signUpForm.username">
                                </div>
                                <div class="form-group">
                                    <label for="uname1">电子邮箱</label>
                                    <input type="email" class="form-control form-control-lg rounded-0" v-model="signUpForm.email">
                                </div>
                                <div class="form-group">
                                    <label>密码</label>
                                    <input type="password" class="form-control form-control-lg rounded-0" v-model="signUpForm.password" >
                                </div>
                        </div>
                        <button type="submit" class="btn btn-success btn-lg float-right" v-on:click = "signup">注册</button>
                        <!--/card-block-->
                    </div>
                    <!-- /form card login -->
                
                </div>


            </div>
            <!--/row-->

        </div>
        <!--/col-->
    </div>
    <!--/row-->
</div>
<!--/container-->
</template>

<script>
export default {
    data(){
        return{
            signUpForm:{
                username:'',
                email:'',
                password:''
            },
            responseResult:[]
        }
    },
    methods:{
      signup () {
        var _this = this
        this.$axios
          .post('/signup', {
            username: this.signUpForm.username,
            password: this.signUpForm.password,
            email: this.signUpForm.email
          })
          .then(resp => {
            if (resp.data.code === 200) {
              this.$alert('注册成功', '提示', {
                confirmButtonText: '确定'
              })
              _this.$router.replace('/login')
            } else {
              this.$alert(resp.data.message, '提示', {
                confirmButtonText: '确定'
              })
            }
          })
          .catch(failResponse => {})
      }
    }
}
</script>

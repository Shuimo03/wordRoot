<template>
  <div>
<nav class="navbar navbar-expand-lg navbar-dark bg-dark"> <a class="navbar-brand" href="#">wordRoot</a>
      <button class="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarColor01" aria-controls="navbarColor01" aria-expanded="false" aria-label="Toggle navigation"> <span class="navbar-toggler-icon"></span> </button>
      <div class="collapse navbar-collapse" id="navbarColor01">
        <ul class="navbar-nav mr-auto">
           <!--target = "_blank是打开一个新的tab页并且跳转过去"-->
           <router-link target = "_blank" :to="{path:'/login'}"> 
          <li class="nav-item"><a class="nav-link">主页</a></li>
          </router-link>
           <router-link target = "_blank" :to="{path:'/login'}"> 
          <li class="nav-item"><a class="nav-link">登录</a></li>
          </router-link>
          <router-link target = "_blank" :to="{path:'/login'}"> 
          <li class="nav-item"><a class="nav-link">注册</a></li>
          </router-link>
           <router-link target = "_blank" :to="{path:'/login'}"> 
          <li class="nav-item"><a class="nav-link">语法检查</a></li>
          </router-link>
          <router-link target = "_blank" :to="{path:'/login'}"> 
          <li class="nav-item"><a class="nav-link">关于</a></li>
          </router-link>
        </ul>
      </div>
    </nav>
     <form class="form-inline">
       <div class="col-center-block">
          <input class="form-control mr-sm-2" type="search" placeholder="Search" aria-label="Search">
          <button class="btn btn-outline-info my-2 my-sm-0" type="submit">Search</button>
       </div>
        </form>
  </div>
</template>

<style>
.col-center-block{
  float: none;
  display: block;
  margin-left: auto;
  margin-right: auto;
}
</style>
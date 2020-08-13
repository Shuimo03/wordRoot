<template>
   <div>
       <div class="scoreLanguage">
            <div class="btn-group">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               自动识别
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item" type="button">中文</button>
                <button class="dropdown-item" type="button">英语</button>
                <button class="dropdown-item" type="button">德语</button>
                <button class="dropdown-item" type="button">法语</button>
                <button class="dropdown-item" type="button">西班牙语</button>
                <button class="dropdown-item" type="button">意大利语</button>
            </div>
        </div>
    </div>
        <div class="left">
        <label for="exampleFormControlTextarea1">源语言</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" placeholder ="请输入要翻译的文字" rows="10"></textarea>
       </div>

   <div class="aimLanguage">
        <div class="btn-group">
            <button type="button" class="btn btn-secondary dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
               自动识别
            </button>
            <div class="dropdown-menu dropdown-menu-right">
                <button class="dropdown-item" type="button">中文</button>
                <button class="dropdown-item" type="button">英语</button>
                <button class="dropdown-item" type="button">德语</button>
                <button class="dropdown-item" type="button">法语</button>
                <button class="dropdown-item" type="button">西班牙语</button>
                <button class="dropdown-item" type="button">意大利语</button>
            </div>
        </div>
   </div>

       <div class="right">
          <label for="exampleFormControlTextarea1">目标语言</label>
        <textarea class="form-control" id="exampleFormControlTextarea1" rows="10"></textarea>
       </div>
   </div>
</template>

<style>
    .left{
        float: left;
        width: 50%;

    }

    .right{
        float: right;
        width: 50%;
    }
    
    /**去掉textarea右下角三角形 */
    textarea{
        resize: none;
    }

    /**语言框选择 */
    .scoreLanguage{
        width: fit-content;
    }

    .aimLanguage{
        right:600em;
        bottom: 200em;
    }

</style>
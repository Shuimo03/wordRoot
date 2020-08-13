<template>
    <div class="editor">
     <quill-editor 
      v-model="content" 
      ref="myQuillEditor" 
      :options="editorOption" 
      @blur="onEditorBlur($event)" @focus="onEditorFocus($event)"
      @change="onEditorChange($event)">
    </quill-editor>
     <button type="button" class="btn btn-light">检查</button>
    </div>
</template> 

<script>
import {quillEditor} from 'vue-quill-editor'
export default {
        data(){
        return {
            content: null,
            editorOption: {
                modules: {
                    toolbar:['bold','italic','underline']
                }
            }
        }
    },

     methods:{
            onEditorBlur(){//失去焦点事件
            },
            onEditorFocus(){//获得焦点事件
            },
            onEditorChange(){//内容改变事件
            }
        }
}
</script>

<style>
  .editor{
    width: 65em;
    height: 45em;
    position: absolute;
    top: 0;
    left: 0;
    right: 0;
    bottom: 0;
    margin: auto;
    text-align: center;
  }

</style>
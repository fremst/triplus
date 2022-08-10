<!--
  220810 김주현
  Vue Quill Editor를 사용한 텍스트 에디터입니다.
  높이는 600px로 잡혀있습니다.

  [ 이벤트 ]
  onChangeContent(html :String)
    텍스트 에디터 내 값이 바뀔 때마다 Trigger 됩니다.
    html 변수를 통해 에디터 내 값을 취득할 수 있습니다.
    사용 예시는 CommonBoard.vue 컴포넌트를 참고해주시기 바랍니다람쥐
-->

<template>
  <div class="texteditor">
    <quill-editor
      ref="textEditor"
      :toolbar="'full'"
      :placeholder="placeholder"
      @textChange="onTextChange">
    </quill-editor>
  </div>
</template>
<script>
  import { QuillEditor } from '@vueup/vue-quill'
  import '@vueup/vue-quill/dist/vue-quill.snow.css';

  export default
  {
    name: 'TextEditor',
    components: {
      QuillEditor
    },
    props: {
      placeholder: String
    },
    methods: {
      onTextChange() {
        let html = this.$refs.textEditor.getHTML();
        this.$emit('onChangeContent', html);
      }
    }
  }
</script>

<style scope>
  .texteditor {
    display: flex;
    flex-direction: column;
    width: 100%;
    height: 600px;
    border: 1px solid black;
  }

</style>
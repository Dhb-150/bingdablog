<template>
  <v-sheet width="300" class="mx-auto">
    <v-form @submit.prevent>
      <v-text-field
        v-model="username"
        :rules="rules.username"
        label="用户名"
      ></v-text-field>
      <v-text-field
            v-model="password"
            :append-icon="show1 ? 'mdi-eye' : 'mdi-eye-off'"
            :rules="[rules.password.required, rules.password.min]"
            :type="show1 ? 'text' : 'password'"
            name="input-10-1"
            label="Normal with hint text"
            hint="At least 8 characters"
            counter
            @click:append="show1 = !show1"
          ></v-text-field>
      <v-btn type="submit" block class="mt-2">登录</v-btn>
    </v-form>
  </v-sheet>
</template>
<script setup>
/**
 * 能在改变时触发更新的状态被称作是响应式的
 * ref()声明的变量是响应式的， v-model可以双向绑定，而普通变量不行，
 * 普通变量可以通过set方法实现双线绑定
 */
import { ref } from 'vue';
const username = ref('')
const password = ref('Password')
//密码是否可见变量
const show1 = ref(false)
const show2 = ref(true)


const rules = [
  {
    username:value => {
      if(value) return true
      return '必须输入用户名！'
    },
    password:{
      required: value => value || '密码必填!',
      min: v => v.length >=8 || 'Min 8 characters',
    }
  }
]
function submit(){
  return null
}
</script>
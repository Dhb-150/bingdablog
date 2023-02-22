import { createApp } from 'vue'
import App from './App.vue'
import router from './router'
// Vuetify
import vuetify from './plugins/vuetify'
import global from './js/globaldate'

const app = createApp(App)

app
.use(router)
.use(vuetify)
.config.globalProperties.global = global
app.mount('#app')
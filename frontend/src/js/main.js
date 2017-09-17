import Vue from 'vue';
import axios from 'axios';
import Hello from 'Hello.vue'
Vue.prototype.$http = axios;

const app = new Vue({
    components: {
        hello: Hello
    }
}).$mount('#app');
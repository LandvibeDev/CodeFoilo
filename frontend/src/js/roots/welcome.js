import Vue from 'vue';
import Vuetify from 'vuetify'
import axios from 'axios';
import Welcome from 'Welcome.vue'

Vue.use(Vuetify);
Vue.prototype.$http = axios;

new Vue({
    components: {
        welcome: Welcome
    }
}).$mount('#welcome');
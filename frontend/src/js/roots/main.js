import Vue from 'vue';
import Vuetify from 'vuetify'
import axios from 'axios';

Vue.use(Vuetify);
Vue.prototype.$http = axios;

new Vue({

}).$mount('#main');
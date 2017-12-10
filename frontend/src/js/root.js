import Vue from 'vue';
import VueRouter from 'vue-router'
import Vuetify from 'vuetify'
import axios from 'axios';
import VueSwal from 'vue-swal'
import VueMoment from 'vue-moment';
import { Progress, Form, Button, Loading } from 'element-ui'

import Welcome from 'Welcome.vue';
import Signup from 'auth/Signup.vue';
import Main from 'Main.vue';
import Portfolio from 'portfolio/Portfolio.vue'
import Github from 'portfolio/Github.vue';

Vue.use(Progress);
Vue.use(Form);
Vue.use(Button);
Vue.use(Loading.directive);
Vue.prototype.$loading = Loading.service;

Vue.use(VueSwal);
Vue.use(Vuetify);
Vue.use(VueMoment);
Vue.prototype.$http = axios;

Vue.use(VueRouter);
const router = new VueRouter({
    mode: 'history',
    base: __dirname,
    routes: [
        {path: '/', name: 'welcome', component: Welcome},
        {path: '/github', name: 'github', component: Github},
        {path: '/signup', name: 'signup', component: Signup},
        {path: '/main', name: 'main', component: Main},
        {path: '/portfolio', name: 'portfolio', component: Portfolio}
    ]
});


new Vue({
    router,
}).$mount('#app');
<template>
    <div class="parallax-container">
        <div class="container row">
            <div class="col s10 offset-s1">
                <div class="cf-img-margin center">
                    <img src="/img/code.png" height="50">
                </div>
                <div class="col s12 m8 offset-m2 l6 offset-l3">
                    <div class="cf-label-container">
                        <a href="/login" class="cf-label-login">LOGIN</a>
                        <span class="cf-slash"> / </span>
                        <span class="cf-label-signup"> SIGNUP</span>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="email" type="email" class="validate" v-model="username">
                            <label for="email">Email Address</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password" type="password" class="validate" v-model="password1">
                            <label for="password">Password</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="password-cfm" type="password" class="validate" v-model="password2">
                            <label for="password-cfm">Confirm Password</label>
                        </div>
                    </div>
                    <div class="row cf-btn-padding">
                        <button class="btn-large waves-effect waves-light col s12" name="action" @click="signup">
                            SIGNUP
                        </button>
                    </div>
                </div>
                <div class="parallax">
                    <img src="img/bluegreen.jpg" style="display: block;">
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Signup extends Base {

        username = '';
        password1 = '';
        password2 = '';

        mounted() {
            const username = this.$route.params.username;
            this.loadUser(username);
        }

        loadUser(username) {
            if (!username) {
                return;
            }

            this.$http.get(`/api/user?username=${username}`)
                .then(res => {
                    this.username = res.data.username;
                })
                .catch(err => {
                    console.log(err);
                });
        }

        signup() {

        }


    }
</script>
<style scoped lang="less">
    .parallax-container {
        min-height: 100vh;

        .cf-img-margin {
            margin-top: 130px;
            margin-bottom: 50px;
        }

        .cf-label-container {
            text-align: right;

            .cf-label-login {
                color: white;
            }

            .cf-slash {
                color: white;
            }

            .cf-label-signup {
                color: #26a69a;
                font-weight: bold;
                font-size: 21px;
            }
        }

        .cf-btn-padding {
            padding-top: 25px;
            padding-left: 10px;
            padding-right: 10px;
        }
    }


</style>
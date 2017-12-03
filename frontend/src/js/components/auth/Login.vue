<template>
    <div class="parallax-container">
        <div class="container row">
            <div class="col s10 offset-s1">
                <div class="cf-img-margin center">
                    <img src="/img/code.png" height="50">
                </div>
                <div class="col s12 m8 offset-m2 l6 offset-l3">
                    <div>
                        <h6 align="right">
                            <span style="color: #26a69a; font-weight: bold; font-size: 21px;">LOGIN</span>
                            <span style="color: white;"> / </span>
                            <a href="/signup" style="color: white;">SIGNUP</a>
                        </h6>
                    </div>
                    <form class="row">
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="email" type="email" class="validate">
                                <label for="email">Email Address</label>
                            </div>
                        </div>
                        <div class="row">
                            <div class="input-field col s12">
                                <input id="password" type="password" class="validate">
                                <label for="password">Password</label>
                            </div>
                        </div>
                        <div class="row cf-btn-padding">
                            <button class="btn-large waves-effect waves-light col s12" name="action"
                                    @click="submit">LOGIN
                            </button>
                        </div>
                    </form>
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

    export default{

        data() {
            return {
                email: '',
                password: ''
            }
        },

        methods: {
            submit() {
                let url = '/api/login';
                axios.post(url, {
                    email: this.email,
                    password: this.password
                })
                    .then(function (response) {
                        location.href="/signup";
                        console.log(response);
                    })
            }
        }

    }

</script>
<style>
    .parallax-container {
        min-height: 100vh;
    }

    .cf-img-margin {
        margin-top: 130px;
        margin-bottom: 50px;
    }

    .cf-btn-padding {
        padding-top: 25px;
        padding-left: 10px;
        padding-right: 10px;
    }
</style>
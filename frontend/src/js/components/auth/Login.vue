<template>
    <div class="parallax-container">
        <div class="container row">
            <div class="cf-margin col s10 offset-s1">
                <div class="row center">
                    <img src="/img/icon2.png" height="50">
                </div>
                <div class="cf-form-margin">
                    <form class="col s12 m8 offset-m2 l6 offset-l3">
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
                            <button class="btn-large waves-effect waves-light col s12" name="action" @click="submit"> Login
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

    @Component
    export default class Login extends Base {

        email='';
        password='';

        submit() {
            if (!this.$refs.form.validate()) {
                return;
            }
            const postData = {
                username: this.email,
                password: this.password
            };
            this.$http.post("/api/login", postData)
                .then(res => {
                    const statusCode = res.status;
                    if (statusCode === 200) {
                        this.$router.push("/signup")
                    }
                }).catch(err => {
                this.$router.push("/signup")
            });

        }
    }

    //    import Component from 'vue-class-component'
    //    import Base from 'Base.vue'
    //
    //    @Component
    //    export default class Login extends Base {
    //        form= {
    //            name: '',
    //            region: '',
    //            date1: '',
    //            date2: '',
    //            delivery: false,
    //            type: [],
    //            resource: '',
    //            desc: ''
    //        };
    //
    //        onSubmit() {
    //            console.log('submit!');
    //        }
    //    }
</script>
<style>
    .parallax-container {
        min-height: 100vh;
    }

    .cf-margin {
        margin-top: 140px;
    }
    .cf-form-margin {
        margin-top: 130px;
    }
    .cf-btn-padding {
        padding-top: 25px;
        padding-left: 10px;
        padding-right: 10px;
    }
</style>
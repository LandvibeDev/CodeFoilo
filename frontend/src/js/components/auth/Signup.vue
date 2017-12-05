<template>
    <div class="parallax-container">
        <div class="container row">
            <div class="col s10 offset-s1">
                <div class="cf-logo-img center">
                    <img src="/img/code.png" height="50">
                </div>
                <div class="cf-user-info col s12 m8 offset-m2 l6 offset-l3">
                    <div class="cf-label-container">
                        <span class="cf-label-signup">회원정보입력</span>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input disabled id="id" type="text" class="validate" v-model="username">
                            <label for="id">Github ID</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="name" type="text" class="validate">
                            <label for="name">User Name</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="birth" type="text" class="datepicker">
                            <label for="birth">Birthday</label>
                        </div>
                    </div>
                    <div class="row">
                        <div class="input-field col s12">
                            <input id="job" type="text" class="validate">
                            <label for="job">Job</label>
                        </div>
                    </div>
                    <div class="row cf-btn-padding">
                        <button class="btn-large waves-effect waves-light col s12" name="action" @click="signup">
                            가입완료
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

        mounted() {
            this.loadUser();

            $('.datepicker').pickadate({
                selectMonths: true, // Creates a dropdown to control month
                selectYears: 120, // Creates a dropdown of 15 years to control year,
                today: 'Today',
                clear: 'Clear',
                close: 'Ok',
                closeOnSelect: false // Close upon selecting a date,
            });
        }

        loadUser() {
            // 유저정보 받아오는 call
            this.$http.get(`/api/me`)
                .then(res => {
                    // res.data에 담김
                    this.username = res.data.username;
                })
                .catch(err => {
                    if (err.response.status === 403) {
                        // 현재 세션에 로그인된 사용자가 없음
                        this.$router.push("/");
                    }

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

        .cf-logo-img {
            margin-top: 70px;
            margin-bottom: 30px;
        }

        .cf-user-info {
            color: white;
        }

        .cf-label-container {
            text-align: left;

            .cf-label-signup {
                color: #26a69a;
                font-weight: bold;
                font-size: 40px;
            }
        }

        .cf-btn-padding {
            padding-top: 25px;
            padding-left: 10px;
            padding-right: 10px;
        }
    }


</style>
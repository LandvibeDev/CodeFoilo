<template>
    <div class="parallax-container">
        <nav class="cf-nav">
            <div class="nav-wrapper">
                <div class="row">
                    <div class="cf-nav-padding">
                        <a href="#" class="cf-logo"><img src="/img/code.png" height="30"> CodeFolio</a>
                        <ul id="nav-mobile" class="cf-menu right hide-on-med-and-down">
                            <li><a href="/">HOME</a></li>
                            <li><a href="/github">MyGitHub</a></li>
                            <li><a href="/portfolio">PORTFOLIO</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container row">
            <div class="cf-title">
                <h1>
                    WE'RE
                    <span> CODEFOLIO </span>
                </h1>
                <h2>
                    WE PROVIDES A PORTFOLIO FOR DEVELOPERS
                </h2>
                <div v-if="hasAuthenticated">
                    <a class="cf-start-btn btn-large waves-effect waves-light col s2 offset-s5" href="/github">
                        나만의 포트폴리오 만들기
                    </a>
                </div>
                <div v-else="">
                    <a class="cf-start-btn btn-large waves-effect waves-light col s2 offset-s5" href="/login/github" @click="loading">
                        GitHub으로 시작하기
                    </a>
                </div>
            </div>
            <div class="parallax">
                <img src="img/mac.jpg" style="display: block;">
            </div>
        </div>
    </div>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Welcome extends Base {

        hasAuthenticated = false;

        mounted() {
            this.$http.get("/api/auth")
                .then(res => {
                    if (res.status === 200) {
                        this.hasAuthenticated = true;
                    } else {
                        this.hasAuthenticated = false;
                    }
                }).catch(err => this.hasAuthenticated = false);
        }

        loading() {
            const loading = this.$loading({
                lock: true,
                text: '로그인 요청중...',
                spinner: 'el-icon-loading',
                background: 'rgba(0, 0, 0, 0.7)'
            });
        }
    }
</script>
<style scoped lang="less">

    .cf-nav {
        background: none;
    }

    .cf-nav-padding {
        padding-left: 150px;
        padding-right: 150px;
    }

    .cf-logo {
        font-size: 30px;
    }

    .cf-menu {
        margin-right: 100px;
    }

    .cf-title {
        margin-top: 240px;
        text-align: center;

        h1 {
            font-family: 'Roboto Regular', sans-serif;
            font-size: 80px;
            color: white;
            letter-spacing: 5px;

            span {
                color: #1ABBAC;
            }
        }

        h2 {
            font-size: 20px;
            color: white;
            margin-bottom: 40px;
        }

    }

    .parallax-container {
        min-height: 100vh;
    }

    .cf-start-btn {
        font-size: 13px;
    }

</style>
<style lang="less">
    .el-loading-spinner {
        .el-icon-loading {
            color: aqua;
        }
        .el-loading-text {
            color: aqua;
        }
    }

</style>
<template>
    <div class="parallax-container">
        <nav class="cf-nav">
            <div class="nav-wrapper">
                <!-- 왜 div가 nav밖으로 튀어나가는지?? -->
                <div class="row">
                    <div class="cf-nav-padding">
                        <a href="#" class="cf-logo"><img src="/img/code.png" height="30"> CodeFolio</a>
                        <ul id="nav-mobile" class="cf-menu right hide-on-med-and-down">
                            <li><a href="/">HOME</a></li>
                            <li><a href="/portfolio">PORTFOLIO</a></li>
                            <li><a href="/login">BLOG</a></li>
                            <li><a href="/login">LOGIN</a></li>
                        </ul>
                    </div>
                </div>
            </div>
        </nav>
        <div class="container row">
            <div class="cf-title">
                <h1>
                    WEL'CM
                    <span> CODEFOLIO </span>
                </h1>
                <h2>
                    WE PROVIDES A PORTFOLIO FOR DEVELOPERS
                </h2>
                <button class="btn-large waves-effect waves-light col s2 offset-s5" @click="submit">
                    Login
                </button>
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
        submit() {
            this.$router.push("/login");
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

</style>
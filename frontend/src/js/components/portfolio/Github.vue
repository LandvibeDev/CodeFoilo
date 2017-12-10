<template>
    <div class="row">
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
        <div class="cf-full-container container row">
            <div class="cf-left-container col s12 m5 l3">
                <div class="card">
                    <div class="cf-card-img card-image">
                        <img src="img/plane.jpg">
                    </div>
                    <div class="card-content">
                        <div class="collection">
                            <ul>
                                <li class="collection-item">
                                    <div>
                                        <h4>김건희</h4>
                                        <h5>Geon Hee</h5>
                                    </div>
                                </li>
                                <li class="collection-item">
                                    <div>
                                        <h6> Korea </h6>
                                        <h6> kimkh6554@gmail.com </h6>
                                        <h6> https://keonhee.github.io/ </h6>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="card">
                    <div class="card-content">
                        <div class="collection">
                            <div class="collection-item">
                                <h5>Organizations</h5>
                            </div>
                        </div>
                        <div class="collection">
                            <ul>
                                <li class="cf-group-outline collection-item" v-for="org in organizations">
                                    <div class="row">
                                        <div class="col s10">
                                            <h6 class="cf-group-name"> {{ org.title }} </h6>
                                        </div>
                                        <div class="cf-left-chkbox col s1">
                                            <p>
                                                <input type="checkbox" class="filled-in" v-bind:id="org.idx"
                                                       checked="checked"/>
                                                <label v-bind:for="org.idx"></label>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
            </div>
            <div class="cf-right-container col s12 m7 l9">
                <div class="card">
                    <div class="card-content">
                        <div class="collection">
                            <ul>
                                <li class="collection-item" v-for="item in items">
                                    <div class="row">
                                        <div class="col s11">
                                            <h5 class="cf-repo-title"> {{ item.title }} </h5>
                                            <h6 class="cf-repo-contents"> {{ item.contents }} </h6>
                                            <h6 class="cf-repo-lang"> {{ item.lang }} </h6>
                                            <h6 class="cf-repo-period"> {{ item.start }} ~ {{ item.end}} </h6>
                                        </div>
                                        <div class="cf-right-chkbox col s1">
                                            <p>
                                                <input type="checkbox" class="filled-in" v-bind:id="item.idx"
                                                       checked="checked"/>
                                                <label v-bind:for="item.idx"></label>
                                            </p>
                                        </div>
                                    </div>
                                </li>
                            </ul>
                        </div>
                    </div>
                </div>
                <div class="cf-make-btn row">
                    <a class="waves-effect waves-light btn-large">포트폴리오 생성</a>
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

        items = [];
        organizations = [];

        mounted() {
            this.items =
                [{
                    title: "incubator-openwhisk-package-alarms",
                    contents: "Apache OpenWhisk package that can be used to create periodic, time-based alarms",
                    lang: "Javascript",
                    idx: "filled-in-box1",
                    start: "2017-12-08",
                    end: ""
                }, {
                    title: "incubator-openwhisk",
                    contents: "Apache OpenWhisk is a serverless event-based programming service and an Apache Incubator project.",
                    lang: "Scala",
                    idx: "filled-in-box2",
                    start: "2017-11-01",
                    end: ""
                }, {
                    title: "Handicraft-Android",
                    contents: "반쪽이 공방 안드로이드 앱",
                    lang: "Java",
                    idx: "filled-in-box3",
                    start: "2017-07-15",
                    end: "2017-10-15"
                }, {
                    title: "dstagram",
                    contents: "땅울림 파이썬 스터디 코드랩 코드입니다",
                    lang: "python",
                    idx: "filled-in-box4",
                    start: "2017-04-28",
                    end: "2017-04-30"
                }, {
                    title: "Udacity-Android-Exercise",
                    contents: "Udacity Android Course Exercise",
                    lang: "java",
                    idx: "filled-in-box5",
                    start: "2016-12-28",
                    end: "2017-01-15"
                }, {
                    title: "inohack-android",
                    contents: "inohack-android",
                    lang: "java",
                    idx: "filled-in-box6",
                    start: "2016-09-26",
                    end: "2016-09-27"
                }];

            this.organizations =
                [{
                    title: "AlgorithmSolving",
                    idx: 1
                }, {
                    title: "LandvibeDev",
                    idx: 2
                }, {
                    title: "CodeFolio",
                    idx: 3
                }];
        }
    }

</script>
<style scoped lang="less">
    .cf-nav {
        background: black;
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

    .cf-full-container {
        width: 80%;
    }

    .cf-left-container {
        .cf-group-outline {
            height: 50px;
        }
    }

    .cf-make-btn {
        text-align: center;
        margin-top: 50px;
        a {
            width: 910px;
        }
    }

    .cf-left-chkbox {
        margin-top: 4px;
    }

    .cf-right-chkbox {
        margin-top: 50px;
    }

    .cf-card-img {
        height: 300px;
        img {
            height: 100%;
        }
    }

    .cf-repo-title {
        font-weight: 600;
    }

    .cf-repo-lang {
        margin-top: 20px;
    }

    .card {
        .card-content {
            padding: 0px;
            .collection {
                margin: 0px;
            }
        }
    }

</style>
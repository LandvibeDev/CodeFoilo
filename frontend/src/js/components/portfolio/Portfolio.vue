<template>
    <div class="container row">
        <div class="cf-left-container col s12 m6 l4">
            <div class="card hoverable">
                <div class="card-image">
                    <img src="img/ki.jpg">
                    <span class="card-title">기성용</span>
                </div>
                <div class="card-content">
                    <div class="cf-job cf-content-margin">
                        <i class="fa fa-briefcase fa-lg cf-info-icon blue-text text-darken-1"
                           aria-hidden="true"></i>
                        <span class="grey-text text-darken-3">Developer</span>
                    </div>
                    <div class="cf-home cf-content-margin">
                        <i class="fa fa-home fa-lg cf-info-icon blue-text text-darken-1" aria-hidden="true"></i>
                        <span class="grey-text text-darken-3">Seoul</span>
                    </div>
                    <div class="cf-email cf-content-margin">
                        <i class="fa fa-envelope fa-lg cf-info-icon blue-text text-darken-1"
                           aria-hidden="true"></i>
                        <span class="grey-text text-darken-3">ki@naver.com</span>
                    </div>
                    <div class="cf-phone cf-content-margin">
                        <i class="fa fa-phone fa-lg cf-info-icon blue-text text-darken-1"
                           aria-hidden="true"></i>
                        <span class="grey-text text-darken-3">010-1234-5678</span>
                    </div>
                </div>
                <div class="divider"></div>
                <div class="card-content">
                    <span class="card-title grey-text text-darken-4">
                        <i class="fa fa-asterisk fa-fw cf-info-icon blue-text text-darken-1" aria-hidden="true"></i>
                        Skills
                    </span>
                    <div class="cf-skills-contents" v-for="skill in skillSet">
                        <div class="cf-skills-name">
                            <span class="grey-text text-darken-3">{{ skill.name }}</span>
                        </div>
                        <el-progress :text-inside="true" :stroke-width="18"
                                     :percentage="skill.percentage"></el-progress>
                    </div>
                </div>
            </div>
        </div>
        <div class="cf-right-container col s12 m6 l8">
            <div class="cf-project card">
                <div class="card-content">
                     <span class="card-title grey-text text-darken-4">
                         <i class="fa fa-code fa-fw cf-info-icon blue-text text-darken-1" aria-hidden="true"></i>
                         Projects
                     </span>
                    <div id="cf-timeline" style="width: 100%; height: 500px"></div>
                </div>
            </div>
            <div class="cf-graph card">
                <div class="card-content">
                     <span class="card-title grey-text text-darken-4">
                         <i class="fa fa-braille fa-fw cf-info-icon blue-text text-darken-1" aria-hidden="true"></i>
                         Recent Activity
                     </span>
                    <div id="ScatterPlot"></div>

                </div>
            </div>
        </div>
        <div class="parallax">
            <img src="img/bluegreen.jpg" style="display: block;">
        </div>
    </div>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'
    import {bb} from "billboard.js";

    @Component
    export default class Portfolio extends Base {
        title = 'Portfolio';

        skillSet = [
            {
                name: "Java",
                percentage: 70
            },
            {
                name: "JavaScript",
                percentage: 50
            },
            {
                name: "Docker",
                percentage: 30
            },
            {
                name: "Scala",
                percentage: 30
            }
        ];

        timelineDateSet = [
            {
                "start_date": {
                    "year": "2017",
                    "month": "11",
                    "day": "1",
                    "hour": "",
                    "minute": "",
                    "second": "",
                    "millisecond": "",
                    "format": ""
                },
                "media": {
                    "url": "",
                    "credit": ""
                },
                "text": {
                    "headline": "테스트 제목",
                    "text": "테스트 내용"
                },
                "autolink": "true"
            },
            {
                "start_date": {
                    "year": "2017",
                    "month": "11",
                    "day": "3",
                    "hour": "",
                    "minute": "",
                    "second": "",
                    "millisecond": "",
                    "format": ""
                },
                "media": {
                    "url": "",
                    "credit": ""
                },
                "text": {
                    "headline": "테스트 제목",
                    "text": "테스트 내용"
                },
                "autolink": "true"
            },
            {
                "start_date": {
                    "year": "2017",
                    "month": "11",
                    "day": "4",
                    "hour": "",
                    "minute": "",
                    "second": "",
                    "millisecond": "",
                    "format": ""
                },
                "media": {
                    "url": "",
                    "credit": ""
                },
                "text": {
                    "headline": "테스트 제목",
                    "text": "테스트 내용"
                },
                "autolink": "true"
            }
        ];

        timelineOptions = {
            "eras": {
                "start_date": {
                    "year": "2010",
                    "month": "1",
                    "day": "1",
                    "hour": "0",
                    "minute": "0",
                    "second": "0",
                    "millisecond": "",
                    "format": ""
                },
                "end_date": {
                    "year": "2020",
                    "month": "12",
                    "day": "31",
                    "hour": "11",
                    "minute": "59",
                    "second": "59",
                    "millisecond": "",
                    "format": ""
                },
                "text": {
                    "headline": "The Code Folio??"
                }

            },
            "scale": "human",
            "events": this.timelineDateSet
        };

        timelineAdditionalOptions = {
            start_at_end: false,
            default_bg_color: {r: 255, g: 255, b: 255},
            language: "ko"
        };

        timeline = '';

        mounted() {
            this.timeline = new TL.Timeline("cf-timeline", this.timelineOptions, this.timelineAdditionalOptions);

            const chart = bb.generate({
                "data": {
                    "xs": {
                        "setosa": "setosa_x",
                        "versicolor": "versicolor_x"
                    },
                    "columns": [
                        ["setosa_x", 1, 2, 2, 2, 3, 4, 5, 6, 7], // 월
                        ["versicolor_x", 3, 4, 8, 6, 7, 9], // 월
                        ["setosa", 3, 4, 1, 2, 3, 4], // 일 (1~5일 => 1, 6~10일 =>2, ...)
                        ["versicolor", 5, 2, 6, 1, 2, 3], // 일
                    ],
                    "type": "scatter"
                },
                "axis": {
                    "x": {
                        "label": "Month",
                        "tick": {
                            fit: false
                        },
                        "min": 1,
                        "max": 12
                    },
                    "y": {
                        "label": "Day",
                        "tick": {
                            fit: false,
                            "ratio" : 1
                        },
                    }
                },
                "bindto": "#ScatterPlot"
            });

        }
    }
</script>
<style scoped lang="less">
    .card {
        .cf-content-margin {
            margin-bottom: 20px;
        }

        .cf-info-icon {
            margin-right: 15px;
        }

        .cf-skills-contents {
            margin-bottom: 10px;

            .cf-skills-name {
                margin-bottom: 10px;
            }
        }

    }
</style>
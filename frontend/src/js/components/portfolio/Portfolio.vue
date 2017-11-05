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
                        ["setosa_x", 3.5, 3, 3.2, 3.1, 3.6, 3.9, 3.4, 3.4, 2.9, 3.1, 3.7, 3.4, 3, 3, 4, 4.4, 3.9, 3.5, 3.8, 3.8, 3.4, 3.7, 3.6, 3.3, 3.4, 3, 3.4, 3.5, 3.4, 3.2, 3.1, 3.4, 4.1, 4.2, 3.1, 3.2, 3.5, 3.6, 3, 3.4, 3.5, 2.3, 3.2, 3.5, 3.8, 3, 3.8, 3.2, 3.7, 3.3],
                        ["versicolor_x", 3.2, 3.2, 3.1, 2.3, 2.8, 2.8, 3.3, 2.4, 2.9, 2.7, 2, 3, 2.2, 2.9, 2.9, 3.1, 3, 2.7, 2.2, 2.5, 3.2, 2.8, 2.5, 2.8, 2.9, 3, 2.8, 3, 2.9, 2.6, 2.4, 2.4, 2.7, 2.7, 3, 3.4, 3.1, 2.3, 3, 2.5, 2.6, 3, 2.6, 2.3, 2.7, 3, 2.9, 2.9, 2.5, 2.8],
                        ["setosa", 0.2, 0.2, 0.2, 0.2, 0.2, 0.4, 0.3, 0.2, 0.2, 0.1, 0.2, 0.2, 0.1, 0.1, 0.2, 0.4, 0.4, 0.3, 0.3, 0.3, 0.2, 0.4, 0.2, 0.5, 0.2, 0.2, 0.4, 0.2, 0.2, 0.2, 0.2, 0.4, 0.1, 0.2, 0.2, 0.2, 0.2, 0.1, 0.2, 0.2, 0.3, 0.3, 0.2, 0.6, 0.4, 0.3, 0.2, 0.2, 0.2, 0.2],
                        ["versicolor", 1.4, 1.5, 1.5, 1.3, 1.5, 1.3, 1.6, 1, 1.3, 1.4, 1, 1.5, 1, 1.4, 1.3, 1.4, 1.5, 1, 1.5, 1.1, 1.8, 1.3, 1.5, 1.2, 1.3, 1.4, 1.4, 1.7, 1.5, 1, 1.1, 1, 1.2, 1.6, 1.5, 1.6, 1.5, 1.3, 1.3, 1.3, 1.2, 1.4, 1.2, 1, 1.3, 1.2, 1.3, 1.3, 1.1, 1.3]
                    ],
                    "type": "scatter"
                },
                "axis": {
                    "x": {
                        "label": "Sepal.Width",
                        "tick": {
                            "fit": false
                        }
                    },
                    "y": {
                        "label": "Petal.Width"
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
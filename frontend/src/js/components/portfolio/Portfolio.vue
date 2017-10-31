<template>
    <div class="container">
        <div class="row">
            <div class="cf-left-container col s12 m6 l4">
                <div class="card">
                    <div class="card-image">
                        <img src="img/ki.jpg">
                        <span class="card-title">기성용</span>
                    </div>
                    <div class="card-content">
                        <div class="cf-job">
                            <i class="fa fa-briefcase" aria-hidden="true"></i> Developer
                        </div>
                    </div>
                    <div class="card-action">
                        <a href="#">This is a link</a>
                    </div>
                </div>
            </div>
            <div class="cf-right-container col s12 m6 l8">
                <div class="cf-timeline">
                    <div class="card-panel teal">
          <span class="white-text">I am a very simple card. I am good at containing small bits of information.
          I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.
          </span>
                    </div>
                </div>
                <div class="cf-graph">
                    <div class="card-panel teal">
          <span class="white-text">I am a very simple card. I am good at containing small bits of information.
          I am convenient because I require little markup to use effectively. I am similar to what is called a panel in other frameworks.
          </span>
                    </div>
                </div>
            </div>
        </div>
    </div>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Portfolio extends Base {
        title = 'Portfolio';

    }
</script>
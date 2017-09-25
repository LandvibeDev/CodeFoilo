<template>
    <v-app light>
        <h1>Hello {{ title }}</h1>
    </v-app>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Main extends Base{
        title = 'CodeFolio';

    }
</script>
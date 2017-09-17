<template>
    <h1>{{ hello }} Codefolio</h1>
</template>
<script>
    import Component from 'vue-class-component'

    @Component
    export default class Hello {
        hello = '';

        mounted() {
            this.hello = "Hello";
        }
    }
</script>
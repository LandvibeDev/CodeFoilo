<template>
    <v-app light>
        <v-parallax src="/img/bluegreen.jpg" height="733">
            <v-layout align-center justify-center>
                <v-flex xs12 sm8 md3>
                    <img class="center-image" src="/img/icon2.png" height="50">
                    <v-form v-model="valid" ref="form">
                        <v-text-field
                                label="E-mail"
                                v-model="email"
                                :rules="emailRules"
                                dark
                                required
                        ></v-text-field>
                        <v-text-field
                                label="Enter your password"
                                hint="At least 8 characters"
                                v-model="password"
                                min="8"
                                :append-icon="pwdHidden ? 'visibility' : 'visibility_off'"
                                :append-icon-cb="() => (pwdHidden = !pwdHidden)"
                                :type="pwdHidden ? 'password' : 'text'"
                                :rules="passwordRule"
                                dark
                                counter
                        ></v-text-field>
                        <v-card-actions align-center>
                            <v-btn block :disabled="!valid"  @click="submit">
                                Submit
                            </v-btn>
                        </v-card-actions>
                    </v-form>
                </v-flex>
            </v-layout>
        </v-parallax>
    </v-app>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Login extends Base {
        valid = false;
        pwdHidden=false;
        email = '';
        emailRules = [
            (v) => !!v || 'E-mail is required',
            (v) => /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
        ];
        passwordRule = [
            (v) => v.length >= 8 || "Password must be at least 8 characters."
        ];
        password = '';

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
                        console.log(res)
                        window.location.href = '/';
                    }
                }).catch(err => {
                // swal 띄우기
            });

        }

        clear() {
            this.$refs.form.reset()
        }

        mounted() {
            this.pwdHidden=true;
        }
    }
</script>
<style lang="less" scoped>
    .center-image {
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 130px;
        display: block;
    }
</style>
<template>
    <v-app light>
        <v-parallax src="/img/bluegreen.jpg" height="733">
            <v-layout align-center justify-center>
                <v-flex xs12 sm9 md5>
                    <img class="center-image" src="/img/icon2.png" height="50">
                    <v-card>
                        <v-card-title
                                class="cyan darken-3 white--text"
                        >
                            <v-container fill-height fluid>
                                <v-flex xs12 align-center flexbox>
                                    <span class="headline">Sign Up</span>
                                </v-flex>
                            </v-container>
                        </v-card-title>
                        <v-card-title>
                            <v-container fill-height fluid>
                                <v-layout fill-height>
                                    <v-flex xs12 align-end flexbox>
                                        <v-form v-model="valid" ref="form">
                                            <v-text-field
                                                    label="E-mail"
                                                    v-model="email"
                                                    :rules="emailRules"
                                                    required
                                            ></v-text-field>
                                            <v-text-field
                                                    label="Password"
                                                    hint="At least 8 characters"
                                                    v-model="password"
                                                    min="8"
                                                    :append-icon="pwdHidden ? 'visibility' : 'visibility_off'"
                                                    :append-icon-cb="() => (pwdHidden = !pwdHidden)"
                                                    :type="pwdHidden ? 'password' : 'text'"
                                                    :rules="passwordRule"
                                                    counter
                                            ></v-text-field>
                                            <v-text-field
                                                    label="Confirm Password"
                                                    hint="At least 8 characters"
                                                    v-model="passwordCfm"
                                                    min="8"
                                                    :append-icon="cfmHidden ? 'visibility' : 'visibility_off'"
                                                    :append-icon-cb="() => (cfmHidden = !cfmHidden)"
                                                    :type="cfmHidden ? 'password' : 'text'"
                                                    :rules="confirmRule"
                                                    counter
                                            ></v-text-field>
                                        </v-form>
                                    </v-flex>
                                </v-layout>
                            </v-container>
                        </v-card-title>
                        <v-card-actions align-center>
                            <v-btn block :disabled="!valid" @click="submit">
                                Submit
                            </v-btn>
                        </v-card-actions>
                    </v-card>
                </v-flex>
            </v-layout>
        </v-parallax>
    </v-app>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Signup extends Base {
        valid = false;
        pwdHidden = false;
        cfmHidden = false;
        email = '';
        password = '';
        passwordCfm = '';

        emailRules = [
            (v) => !!v || 'E-mail is required',
            (v) => /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
        ];
        passwordRule = [
            (v) => v.length >= 8 || "Password must be at least 8 characters."
        ];
        confirmRule = [];   // init at mounted

        mounted() {
            this.pwdHidden=true;
            this.cfmHidden=true;
            this.confirmRule = [
                (v) => this.password === this.passwordCfm || "Password not correct"
            ];
        }

        submit() {
            if (!this.$refs.form.validate()) {
                return;
            }
            const postData = {
                username: this.email,
                password: this.password
            };
            this.$http.post("/api/signup", postData)
                .then(res => {
                    const statusCode = res.status;
                    if (statusCode === 200) {
                        this.$router.push("/login")
                    }
                }).catch(err => {
                // swal 띄우기
            });
        }

        clear() {
            this.$refs.form.reset()
        }


    }
</script>
<style lang="less" scoped>
    .center-image {
        margin-left: auto;
        margin-right: auto;
        margin-bottom: 70px;
        display: block;
    }
</style>
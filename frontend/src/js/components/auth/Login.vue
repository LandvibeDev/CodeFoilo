<template>
    <v-app light>
        <v-layout>
            <v-flex xs12 sm6 offset-sm3>
                <v-card>
                    <v-card-title
                            class="blue-grey darken-2 white--text"
                    >
                        <v-container fill-height fluid>
                            <v-layout fill-height>
                                <v-flex xs12 align-end flexbox>
                                    <span class="headline">Login</span>
                                </v-flex>
                            </v-layout>
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
                                                label="Enter your password"
                                                hint="At least 8 characters"
                                                v-model="password"
                                                min="8"
                                                :append-icon="e1 ? 'visibility' : 'visibility_off'"
                                                :append-icon-cb="() => (e1 = !e1)"
                                                :type="e1 ? 'password' : 'text'"
                                                counter
                                        ></v-text-field>
                                    </v-form>
                                </v-flex>
                            </v-layout>
                        </v-container>
                    </v-card-title>
                    <v-card-actions>
                        <v-btn @click="submit" :class="{ green: valid, red: !valid }">submit</v-btn>
                        <v-btn @click="clear">clear</v-btn>
                    </v-card-actions>
                </v-card>
            </v-flex>
        </v-layout>
    </v-app>
</template>
<script>
    import Component from 'vue-class-component'
    import Base from 'Base.vue'

    @Component
    export default class Login extends Base {
        valid = false;
        email = '';
        emailRules = [
            (v) => !!v || 'E-mail is required',
            (v) => /^\w+([\.-]?\w+)*@\w+([\.-]?\w+)*(\.\w{2,3})+$/.test(v) || 'E-mail must be valid'
        ];
        password = '';

        submit() {
            if (!this.$refs.form.validate()) {
                return;
            }

            const postData = {
                email: this.email,
                password: this.password
            };

            this.$http.post("/api/login", postData)
                .then(res => {
                    const statusCode = res.status;
                    if (statusCode === 200) {
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

        }
    }
</script>
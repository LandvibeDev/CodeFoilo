var path = require('path');
var CopyWebpackPlugin = require('copy-webpack-plugin');
var ExtractTextPlugin = require("extract-text-webpack-plugin");
var webpack = require("webpack");

var outputDir = path.resolve("../server/build/classes/main");


var argv = require('yargs').argv;
var productionBuild = argv.p || false;
if (productionBuild) {
    console.log("### production build is enabled. ga is included and javascript is optmized\r");
} else {
    console.log("### production build is disabled.\r");
}

if (argv.w || argv.watch) {
    console.log("### watch is enabled");
}
// If we omit the following line, the env var for module.exports will be undefined. It's weired.
console.log("### passed env is " + JSON.stringify(argv.env));

module.exports = function (env) {

    var sampleVersion = "default";
    if (env !== undefined && env.sampleVersion !== undefined) {
        sampleVersion = env.sampleVersion;
    }
    console.log("### frontend version is " + sampleVersion + "\r");

    var webpackConfig = {
        entry: {
            'app': 'entries/app.js'
        },
        output: {
            path: outputDir,
            publicPath: "/",
            filename: "./static/js/[name].js"
        }, resolve: {
            modules: [
                path.join(__dirname, "src/js"),
                "./src/js/components",
                "./src/js/modules",
                "node_modules",
                "./src/less",
                path.join(__dirname, "./../server/src/main/resources")
            ],
            alias: {
                'vue$': 'vue/dist/vue.esm.js'
            }
        },
        resolveLoader: {
            alias: {
                'scss-loader': 'sass-loader'
            }
        },
        module: {
            rules: [
                {
                    test: /\.vue$/,
                    loader: 'vue-loader',
                    options: {
                        loaders: {
                            scss: 'vue-style-loader!css-loader!sass-loader'
                        }
                    }
                },
                {
                    test: /.properties$/,
                    loader: "java-properties-flat-loader"
                },
                {
                    test: /\/js\/[^\/]+\/.*\.js$/,
                    loader: 'babel-loader',
                    query: {
                        presets: ['es2015'],
                    }
                },
                {
                    test: /\.(less|css|scss)$/,
                    use: ExtractTextPlugin.extract({
                        fallback: 'style-loader',
                        use: [
                            {loader: 'css-loader', options: {sourceMap: !productionBuild, importLoaders: 1}},
                            {loader: 'less-loader', options: {sourceMap: !productionBuild}},
                        ]
                    })
                },
                {
                    test: /\.(woff|woff2|ttf|eot|svg)(\?]?.*)?$/,
                    loader: 'file-loader?name=fonts/[name].[ext]'
                },
                {
                    test: /\.js$/,
                    exclude: [/node_modules/, /3rd-party/],
                    loader: 'babel-loader',
                    query: {
                        presets: ['es2015', 'es2017', "stage-0"],
                        plugins: ['transform-decorators-legacy']
                    }
                },
            ]
        },
        plugins: [
            new ExtractTextPlugin('./static/css/[name].css'),
            new CopyWebpackPlugin([
                {
                    context: 'src/html',
                    from: '**/*',
                    to: 'templates'
                },
                {
                    context: 'src/js/library',
                    from: '**/*',
                    to: 'static/js/library'
                },
                {
                    context: 'src/js',
                    from: '*',
                    to: 'static/js'
                },
                {
                    context: 'src/css',
                    from: '**/*',
                    to: 'static/css'
                },
                {
                    context: 'src/img',
                    from: '**/*',
                    to: 'static/img'
                }
            ]),
            new webpack.LoaderOptionsPlugin({
                debug: !productionBuild,
                options: {
                    context: __dirname,
                    htmlLoader: {
                        ignoreCustomFragments: "[/\{\{.*?}}/]"
                    }
                }
            })
        ]
    };

    if (!productionBuild) {
        console.log("### sourcemap is enabled.\r");
        webpackConfig.devtool = "#inline-source-map";
    } else {
        console.log("### sourcemap is disabled.\r");
    }

    return webpackConfig;
};
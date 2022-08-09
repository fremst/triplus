const {defineConfig} = require('@vue/cli-service')
module.exports = defineConfig({
    transpileDependencies: true,
    publicPath: "/resources/",

    configureWebpack: {
        performance: {
            hints: false
        }
    },
    pluginOptions: {
        vuetify: {
            // https://github.com/vuetifyjs/vuetify-loader/tree/next/packages/vuetify-loader
        }
    }
})

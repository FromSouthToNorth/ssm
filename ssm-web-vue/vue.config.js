// 'use strict'
module.export = {
  productionSourceMap: false,
  devServer: {
    host: '0.0.0.0',
    port: 80,
    open: true,
    proxy: {
      [process.env.VUE_APP_BASE_API]: {
        target: 'http://localhost:8888',
        changeOrigin: true,
        pathRewrite: {
          ['^' + process.env.VUE_APP_BASE_API]: ''
        }
      }
    },
    disableHostCheck: true
  }
}
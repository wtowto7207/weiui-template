// You can see all the config in `./configs`.
let webpackConfig;
module.exports = env => {
    switch (env.NODE_ENV) {
        case 'serve':
            webpackConfig = require('./configs/webpack.serve.conf');
            break;

        case 'build':
            webpackConfig = require('./configs/webpack.build.conf');
            break;

        case 'common':
            webpackConfig = require('./configs/webpack.common.conf');
            break;

        case 'prod':
            webpackConfig = require('./configs/webpack.prod.conf');
            break;

        case 'release':
            webpackConfig = require('./configs/webpack.release.conf');
            break;

        case 'dev':
        default:
            webpackConfig = require('./configs/webpack.dev.conf');
    }
    return webpackConfig;
};

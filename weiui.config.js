module.exports = {

    homePage: "",   //主页的JS地址（build使用，留空自动生成）

    appkey: "3TRWyttKzxRBtmHc004sJMjjyAxOf08l",     //（可选）用于云平台管理
    version: "1.0.0",                               //（可选）用于云平台热更新

    rongim: {       //融云模块配置
        ios: {
            enabled: false,
            appKey: "",
            appSecret: "",
        },
        android: {
            enabled: false,
            appKey: "",
            appSecret: "",
        },
    },

    umeng: {        //友盟模块配置
        ios: {
            enabled: false,
            appKey: "",
            appSecret: "",
            channel: "",
        },
        android: {
            enabled: false,
            appKey: "",
            appSecret: "",
            channel: "",
        }
    },

};

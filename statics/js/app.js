import {runNum} from "./global";

let weiui = weex.requireModule('weiui');

let app = {

    openViewCode(str) {
        weiui.openPage({
            url: "http://weiui.cc/#/" + str,
            pageType: 'web'
        });
    },

    checkVersion(compareVersion) {
        if (typeof weiui.getVersion !== "function") {
            return false;
        }
        return runNum(weiui.getVersion()) >= runNum(compareVersion);
    },

};

module.exports = app;

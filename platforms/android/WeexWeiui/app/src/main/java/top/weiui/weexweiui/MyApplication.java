package top.weiui.weexweiui;

import android.app.Application;
import android.content.Context;
import android.support.multidex.MultiDex;

import com.alibaba.fastjson.JSONObject;
import com.lljjcoder.weiui.ui.weiui_citypicker;
import com.luck.picture.lib.weiui.ui.weiui_picture;
import com.taobao.weex.WXEnvironment;
import com.taobao.weex.WXSDKEngine;

import io.rong.imlib.weiui.ui.weiui_rongim;
import vip.kuaifan.weiui.extend.module.weiui;
import vip.kuaifan.weiui.extend.module.weiuiCommon;
import vip.kuaifan.weiui.extend.module.weiuiJson;
import vip.kuaifan.weiui.umeng.ui.weiui_umeng;

public class MyApplication extends Application {

    protected void attachBaseContext(Context ctx) {
        super.attachBaseContext(ctx);
        MultiDex.install(this);
    }

    @Override
    public void onCreate() {
        super.onCreate();
        //
        WXEnvironment.setOpenDebugLog(true);
        WXEnvironment.setApkDebugable(true);
        WXSDKEngine.addCustomOptions("appName", "WEIUI");
        WXSDKEngine.addCustomOptions("appGroup", "WEIUI");
        //
        weiui.init(this);
        weiui_citypicker.init();
        weiui_picture.init();
        //
        JSONObject jsonData = weiuiJson.parseObject(weiuiCommon.getAssetsJson("weiui/config.json", this));
        JSONObject rongim = weiuiJson.parseObject(weiuiJson.parseObject(jsonData.get("rongim")).get("android"));
        if (weiuiJson.getBoolean(rongim, "enabled")) {
            weiui_rongim.init(weiuiJson.getString(rongim, "appKey"), weiuiJson.getString(rongim, "appSecret"));
        }
        JSONObject umeng = weiuiJson.parseObject(weiuiJson.parseObject(jsonData.get("umeng")).get("android"));
        if (weiuiJson.getBoolean(umeng, "enabled")) {
            weiui_umeng.init(weiuiJson.getString(umeng, "appKey"), weiuiJson.getString(umeng, "appSecret"), weiuiJson.getString(umeng, "channel"));
        }
    }
}

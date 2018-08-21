package top.weiui.weexweiui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.alibaba.fastjson.JSONObject;

import vip.kuaifan.weiui.extend.bean.PageBean;
import vip.kuaifan.weiui.extend.module.weiuiCommon;
import vip.kuaifan.weiui.extend.module.weiuiJson;
import vip.kuaifan.weiui.extend.module.weiuiPage;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //
        JSONObject jsonData = weiuiJson.parseObject(weiuiCommon.getAssetsJson("weiui/config.json", this));
        String homePage = weiuiJson.getString(jsonData, "homePage");
        if (homePage.length() == 0) {
            homePage = "file://assets/weiui/index.js";
        }
        //
        PageBean mPageBean = new PageBean();
        mPageBean.setUrl(homePage);
        mPageBean.setPageType("weex");
        new Handler().postDelayed(() -> {
            weiuiPage.openWin(WelcomeActivity.this, mPageBean);
            finish();
        }, 200);
    }
}

package cc.weiui.app;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import com.taobao.weex.bridge.JSCallback;

import java.util.Map;

import cc.weiui.framework.extend.bean.PageBean;
import cc.weiui.framework.extend.module.weiuiMap;
import cc.weiui.framework.extend.module.weiuiPage;
import cc.weiui.framework.extend.module.weiuiParse;
import cc.weiui.playground.R;

public class WelcomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //
        new Handler().postDelayed(() -> {
            PageBean mPageBean = new PageBean();
            mPageBean.setUrl(Base.config.getHome());
            mPageBean.setPageType("weex");
            mPageBean.setCallback(new JSCallback() {
                @Override
                public void invoke(Object data) {

                }

                @Override
                public void invokeAndKeepAlive(Object data) {
                    Map<String, Object> retData = weiuiMap.objectToMap(data);
                    String status = weiuiParse.parseStr(retData.get("status"));
                    if (status.equals("create")) {
                        Base.cloud.appData();
                    }
                }
            });
            weiuiPage.openWin(WelcomeActivity.this, mPageBean);
            finish();
        }, Base.cloud.welcome(this));
    }
}

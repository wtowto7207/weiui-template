package top.weiui.weexweiui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;

import vip.kuaifan.weiui.extend.bean.PageBean;
import vip.kuaifan.weiui.extend.module.weiuiPage;

public class WelcomeActivity extends AppCompatActivity {

    private int delayMillis = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        //
        delayMillis+= Base.cloud.init(this);
        //
        PageBean mPageBean = new PageBean();
        mPageBean.setUrl(Base.config.getHome());
        mPageBean.setPageType("weex");
        new Handler().postDelayed(() -> {
            weiuiPage.openWin(WelcomeActivity.this, mPageBean);
            finish();
        }, delayMillis);
    }
}

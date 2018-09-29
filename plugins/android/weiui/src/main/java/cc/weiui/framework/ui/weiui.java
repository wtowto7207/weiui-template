package cc.weiui.framework.ui;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.os.Bundle;

import com.taobao.weex.InitConfig.Builder;
import com.taobao.weex.WXSDKEngine;
import com.taobao.weex.common.WXException;

import cc.weiui.framework.extend.adapter.ImageAdapter;
import cc.weiui.framework.extend.integration.iconify.Iconify;
import cc.weiui.framework.extend.integration.iconify.fonts.IoniconsModule;

import java.util.LinkedList;

import cc.weiui.framework.extend.integration.iconify.fonts.TbIconfontModule;
import cc.weiui.framework.extend.integration.swipebacklayout.BGASwipeBackHelper;
import cc.weiui.framework.extend.module.weiuiIhttp;
import cc.weiui.framework.ui.component.banner.Banner;
import cc.weiui.framework.ui.component.button.Button;
import cc.weiui.framework.ui.component.grid.Grid;
import cc.weiui.framework.ui.component.icon.Icon;
import cc.weiui.framework.ui.component.marquee.Marquee;
import cc.weiui.framework.ui.component.navbar.Navbar;
import cc.weiui.framework.ui.component.navbar.NavbarItem;
import cc.weiui.framework.ui.component.recyler.Recyler;
import cc.weiui.framework.ui.component.ripple.Ripple;
import cc.weiui.framework.ui.component.scrollText.ScrollText;
import cc.weiui.framework.ui.component.sidePanel.SidePanel;
import cc.weiui.framework.ui.component.sidePanel.SidePanelMenu;
import cc.weiui.framework.ui.component.tabbar.Tabbar;
import cc.weiui.framework.ui.component.tabbar.TabbarPage;
import cc.weiui.framework.ui.component.webView.WebView;
import cc.weiui.framework.ui.module.weiuiModule;

/**
 * Created by WDM on 2018/3/27.
 */

public class weiui {

    public static boolean debug = true;

    private static Application application;

    private static LinkedList<Activity> mActivityList = new LinkedList<>();

    public static Application getApplication() {
        return application;
    }

    public static LinkedList<Activity> getActivityList() {
        return mActivityList;
    }

    public static void init(Application application) {
        register(application);
    }

    public static void init(Application application, boolean debug) {
        register(application);
        setDebug(debug);
    }

    public static void setDebug(boolean debug) {
        weiui.debug = debug;
    }

    public static void reboot() {
        LinkedList<Activity> activityList = weiui.getActivityList();
        for (int i = 0; i < activityList.size() - 1; i++) {
            activityList.get(i).finish();
        }
        Activity lastActivity = activityList.getLast();
        Intent intent = lastActivity.getPackageManager().getLaunchIntentForPackage(lastActivity.getPackageName());
        if (intent != null) {
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
            lastActivity.startActivity(intent);
            lastActivity.finish();
        }
    }

    private static void setTopActivity(final Activity activity) {
        if (mActivityList.contains(activity)) {
            if (!mActivityList.getLast().equals(activity)) {
                mActivityList.remove(activity);
                mActivityList.addLast(activity);
            }
        } else {
            mActivityList.addLast(activity);
        }
    }

    private static void register(Application app) {
        weiui.application = app;
        weiui.application.registerActivityLifecycleCallbacks(mCallbacks);

        weiuiIhttp.init(application);

        Iconify.with(new IoniconsModule()).with(new TbIconfontModule());

        BGASwipeBackHelper.init(application, null);

        Builder mBuilder = new Builder();
        mBuilder.setImgAdapter(new ImageAdapter());
        WXSDKEngine.initialize(application, mBuilder.build());

        try {
            WXSDKEngine.registerModule("weiui", weiuiModule.class);
            WXSDKEngine.registerComponent("weiui_banner", Banner.class);
            WXSDKEngine.registerComponent("weiui_button", Button.class);
            WXSDKEngine.registerComponent("weiui_grid", Grid.class);
            WXSDKEngine.registerComponent("weiui_icon", Icon.class);
            WXSDKEngine.registerComponent("weiui_marquee", Marquee.class);
            WXSDKEngine.registerComponent("weiui_navbar", Navbar.class);
            WXSDKEngine.registerComponent("weiui_navbar_item", NavbarItem.class);
            WXSDKEngine.registerComponent("weiui_recyler", Recyler.class);
            WXSDKEngine.registerComponent("weiui_list", Recyler.class);
            WXSDKEngine.registerComponent("weiui_ripple", Ripple.class);
            WXSDKEngine.registerComponent("ripple", Ripple.class);
            WXSDKEngine.registerComponent("weiui_scroll_text", ScrollText.class);
            WXSDKEngine.registerComponent("weiui_side_panel", SidePanel.class);
            WXSDKEngine.registerComponent("weiui_side_panel_menu", SidePanelMenu.class);
            WXSDKEngine.registerComponent("weiui_tabbar", Tabbar.class);
            WXSDKEngine.registerComponent("weiui_tabbar_page", TabbarPage.class);
            WXSDKEngine.registerComponent("weiui_webview", WebView.class);
        } catch (WXException e) {
            e.printStackTrace();
        }
    }

    private static Application.ActivityLifecycleCallbacks mCallbacks = new Application.ActivityLifecycleCallbacks() {
        @Override
        public void onActivityCreated(Activity activity, Bundle bundle) {
            setTopActivity(activity);
        }

        @Override
        public void onActivityStarted(Activity activity) {
            setTopActivity(activity);
        }

        @Override
        public void onActivityResumed(Activity activity) {
            setTopActivity(activity);
        }

        @Override
        public void onActivityPaused(Activity activity) {

        }

        @Override
        public void onActivityStopped(Activity activity) {

        }

        @Override
        public void onActivitySaveInstanceState(Activity activity, Bundle bundle) {

        }

        @Override
        public void onActivityDestroyed(Activity activity) {
            mActivityList.remove(activity);
        }
    };
}

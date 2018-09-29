package cc.weiui.framework.extend.module.rxtools.tool;

import android.app.Application;

import cc.weiui.framework.extend.module.weiui;

/**
 * Created by WDM on 2018/3/24.
 */

public class RxTool {

    public static Application getContext() {
        return weiui.getApplication();
    }
}

package cc.weiui.framework.extend.integration.iconify.fonts;

import cc.weiui.framework.extend.integration.iconify.Icon;
import cc.weiui.framework.extend.integration.iconify.IconFontDescriptor;

public class TbIconfontModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconify/android-iconify-taobao-iconfont.ttf";
    }

    @Override
    public Icon[] characters() {
        return TbIconfontIcons.values();
    }
}

package cc.weiui.framework.extend.integration.iconify.fonts;

import cc.weiui.framework.extend.integration.iconify.Icon;
import cc.weiui.framework.extend.integration.iconify.IconFontDescriptor;

public class IoniconsModule implements IconFontDescriptor {

    @Override
    public String ttfFileName() {
        return "iconify/android-iconify-ionicons.ttf";
    }

    @Override
    public Icon[] characters() {
        return cc.weiui.framework.extend.integration.iconify.fonts.IoniconsIcons.values();
    }
}

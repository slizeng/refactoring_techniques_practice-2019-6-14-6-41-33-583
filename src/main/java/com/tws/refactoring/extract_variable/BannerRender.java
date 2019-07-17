package com.tws.refactoring.extract_variable;

import com.sun.istack.internal.NotNull;

public class BannerRender {
    String renderBanner(@NotNull String platform, @NotNull String browser) {
        if ((platform.toUpperCase().indexOf("MAC") > -1) &&
                (browser.toUpperCase().indexOf("IE") > -1)) {
            return "IE on Mac?";
        }
        return "banner";
    }
}

package com.tws.refactoring.extract_variable;

import com.sun.istack.internal.NotNull;

public class BannerRender {
    private static final String MAC = "MAC";
    private static final String IE = "IE";
    private static final String IE_ON_MAC = "IE on Mac?";
    private static final String BANNER = "banner";

    String renderBanner(@NotNull String platform, @NotNull String browser) {
        return containsIgnoreCase(platform, MAC) && containsIgnoreCase(browser, IE)
                ? IE_ON_MAC
                : BANNER;
    }

    private boolean containsIgnoreCase(String string, String target) {
        return string.toUpperCase().contains(target.toUpperCase());
    }
}

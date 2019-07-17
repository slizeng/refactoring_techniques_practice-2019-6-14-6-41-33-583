package com.tws.refactoring.extract_variable;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BannerRenderTest {

    private BannerRender bannerRender;

    @BeforeEach
    void setUp() {
        bannerRender = new BannerRender();
    }

    @Test
    void should_return_IE_on_Mac_when_render_banner_given_platform_is_mac_and_browser_is_ie() {
        String banner = bannerRender.renderBanner("mac", "ie");

        assertEquals("IE on Mac?", banner);
    }

    @Test
    void should_return_IE_on_Mac_when_render_banner_given_platform_contains_mac_and_browser_contains_ie() {
        String banner = bannerRender.renderBanner("xxmacxx", "xxiexx");

        assertEquals("IE on Mac?", banner);
    }

    @Test
    void should_return_IE_on_Mac_when_render_banner_given_platform_contains_mac_and_browser_contains_ie_no_mater_case() {
        String banner = bannerRender.renderBanner("xxmAcxx", "xxiExx");

        assertEquals("IE on Mac?", banner);
    }


    @Test
    void should_return_banner_when_render_banner_given_platform_does_not_contain_mac_and_browser_does_not_contains_ie() {
        String banner = bannerRender.renderBanner("mc", "i");

        assertEquals("banner", banner);
    }

    @Test
    void should_throw_NPE_when_render_banner_given_platform_or_browser_as_null() {
        assertThrows(NullPointerException.class, () -> bannerRender.renderBanner(null, "ie"));
        assertThrows(NullPointerException.class, () -> bannerRender.renderBanner("mac", null));
    }
}
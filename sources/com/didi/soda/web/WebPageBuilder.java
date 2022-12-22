package com.didi.soda.web;

import com.didi.app.nova.skeleton.Page;
import com.didi.app.nova.skeleton.PageInstrument;
import com.didi.soda.web.config.WebConfig;
import com.didi.soda.web.page.WebPage;
import java.util.HashMap;

public class WebPageBuilder {

    /* renamed from: a */
    private Page f43872a;

    /* renamed from: b */
    private PageInstrument f43873b;

    /* renamed from: c */
    private WebConfig f43874c = new WebConfig();

    private WebPageBuilder() {
    }

    public static WebPageBuilder with(Page page) {
        WebPageBuilder webPageBuilder = new WebPageBuilder();
        webPageBuilder.f43872a = page;
        return webPageBuilder;
    }

    public static WebPageBuilder with(PageInstrument pageInstrument) {
        WebPageBuilder webPageBuilder = new WebPageBuilder();
        webPageBuilder.f43873b = pageInstrument;
        return webPageBuilder;
    }

    public WebPageBuilder setUrl(String str) {
        this.f43874c.url = str;
        return this;
    }

    public WebPageBuilder setTitle(String str) {
        this.f43874c.title = str;
        return this;
    }

    public WebPageBuilder canChangeTitle(boolean z) {
        this.f43874c.canChangeTitle = z;
        return this;
    }

    public WebPageBuilder isSupportCache(boolean z) {
        this.f43874c.isSupportCache = z;
        return this;
    }

    @Deprecated
    public WebPageBuilder addCustomerParameters(HashMap hashMap) {
        this.f43874c.mCustomerParameters = hashMap;
        return this;
    }

    /* renamed from: go */
    public WebPage mo109238go() {
        WebPage webPage = new WebPage(this.f43874c);
        PageInstrument pageInstrument = this.f43873b;
        if (pageInstrument == null || pageInstrument.hasRootPage()) {
            Page page = this.f43872a;
            if (page != null) {
                page.push(new WebPage(this.f43874c));
            }
        } else {
            this.f43873b.setRootPage(webPage);
        }
        return webPage;
    }
}

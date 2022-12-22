package com.didi.soda.customer.app;

import com.didi.sdk.app.BusinessContext;

public class TitleAndBizBarManager {

    /* renamed from: a */
    private BusinessContext f40340a;

    public void attachBusinessContext(BusinessContext businessContext) {
        this.f40340a = businessContext;
    }

    public void showTitleBarAndBizBar() {
        BusinessContext businessContext = this.f40340a;
        if (businessContext != null) {
            businessContext.restoreTitleBar();
            this.f40340a.showBizBar();
        }
    }

    public void hideTitleBarAndBizBar() {
        BusinessContext businessContext = this.f40340a;
        if (businessContext != null) {
            businessContext.hideTitleBar();
            this.f40340a.hideBizBar();
        }
    }

    public void hideTitleBar() {
        BusinessContext businessContext = this.f40340a;
        if (businessContext != null) {
            businessContext.hideTitleBar();
        }
    }

    public int getBizBarHeight() {
        BusinessContext businessContext = this.f40340a;
        if (businessContext != null) {
            return businessContext.getBizBarHeight();
        }
        return 0;
    }

    public void offsetTitleBar(float f, float f2) {
        BusinessContext businessContext = this.f40340a;
        if (businessContext != null) {
            businessContext.resetTitleBarYPosition((int) f);
            this.f40340a.resetTitleBarAlpha(f2);
        }
    }
}

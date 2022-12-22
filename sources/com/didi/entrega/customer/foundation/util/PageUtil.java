package com.didi.entrega.customer.foundation.util;

import com.didi.app.nova.skeleton.ScopeContext;

public final class PageUtil {
    private PageUtil() {
    }

    public static boolean isSamePage(ScopeContext scopeContext, ScopeContext scopeContext2) {
        return ObjectUtil.isObjectEquals(scopeContext.getObject("ScopeContextPageIdentification"), scopeContext2.getObject("ScopeContextPageIdentification"));
    }

    public static String getIdentify(ScopeContext scopeContext) {
        return scopeContext.getObject("ScopeContextPageIdentification").toString();
    }
}

package com.didi.soda.customer.animation.transitions.compat;

import android.os.Build;
import android.os.Bundle;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.sdk.util.TextUtil;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.app.constant.Const;

public final class SearchSharedElementCompat {
    private SearchSharedElementCompat() {
    }

    public static boolean supportSharedElementTransition(ScopeContext scopeContext) {
        if (scopeContext != null && !GlobalContext.isEmbed()) {
            Bundle bundle = scopeContext.getBundle();
            if (Build.VERSION.SDK_INT >= 23 && bundle != null) {
                return !TextUtil.isEmpty(bundle.getString(Const.PageParams.TRANSITION_NAMES));
            }
        }
        return false;
    }
}

package com.didi.component.operationpanel;

import android.os.Bundle;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.xpanel.sdk.component.InflateController;
import com.didi.component.core.ComponentParams;

/* renamed from: com.didi.component.operationpanel.a */
/* compiled from: OperationPanelController */
class C6388a implements InflateController {
    public boolean isVisible(ComponentParams componentParams) {
        return true;
    }

    C6388a() {
    }

    public boolean shouldInflate(ComponentParams componentParams) {
        Bundle bundle = componentParams.extras;
        if (bundle != null) {
            int i = bundle.getInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 0);
            boolean z = bundle.getBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_DETAIL, false);
            if (bundle.getBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, false) || i == 1 || z) {
                return !GlobalApolloUtil.usingCustomerServiceCardOnCancelOrder();
            }
        }
        return true;
    }
}

package com.didi.component.common;

import android.os.Bundle;
import com.didi.component.base.AbsBaseBizFragment;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.BusinessUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.core.PresenterGroup;
import com.didi.sdk.app.BusinessContext;
import com.didi.travel.psnger.model.response.CarOrder;

public abstract class AbsNormalFragment<P extends PresenterGroup> extends AbsBaseBizFragment<P> {
    /* access modifiers changed from: protected */
    public int currentVersionCode() {
        return 1;
    }

    /* access modifiers changed from: protected */
    public void onBIDPopulated(int i) {
    }

    /* access modifiers changed from: protected */
    public int getBidFromBundle(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt(BaseExtras.Common.EXTRA_CURRENT_BID);
    }

    /* access modifiers changed from: protected */
    public int getBidFromBusinessContext(BusinessContext businessContext) {
        return BusinessUtils.getCurrentBID(businessContext);
    }

    /* access modifiers changed from: protected */
    public int getComboTypeFromBundle(Bundle bundle) {
        if (bundle == null) {
            return 0;
        }
        return bundle.getInt(BaseExtras.Common.EXTRA_CURRENT_COMBOTYPE);
    }

    /* access modifiers changed from: protected */
    public int getComboTypeFromBusinessContext(BusinessContext businessContext) {
        return currentComboType();
    }

    /* access modifiers changed from: protected */
    public int currentComboType() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            return order.comboType;
        }
        return FormStore.getInstance().getCurrentComboType();
    }
}

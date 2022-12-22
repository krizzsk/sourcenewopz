package com.didi.component.framework.template.endservice;

import android.content.Intent;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.framework.template.common.CommonTemplatePresenter;
import com.didi.sdk.app.BusinessContext;

public class EndServiceTemplatePresenter extends CommonTemplatePresenter {

    /* renamed from: a */
    private Bundle f13966a;

    public EndServiceTemplatePresenter(BusinessContext businessContext, Bundle bundle) {
        super(businessContext, bundle);
        this.f13966a = bundle;
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 103) {
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Pay.CATEGORY, BaseEventKeys.Pay.EVENT_PAYENTANCE_REFRESH);
        }
    }

    public void setArguments(Bundle bundle) {
        if (bundle != null) {
            this.f13966a.putAll(bundle);
        }
    }
}

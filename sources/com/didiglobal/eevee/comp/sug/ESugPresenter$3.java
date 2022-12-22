package com.didiglobal.eevee.comp.sug;

import android.text.TextUtils;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.sdk.apm.SystemUtils;
import com.didiglobal.common.common.constant.ECompConstant;
import java.io.Serializable;

class ESugPresenter$3 extends GlobalSugCallback {
    final /* synthetic */ C16782a this$0;

    ESugPresenter$3(C16782a aVar) {
        this.this$0 = aVar;
    }

    public void setResult(AddressResult addressResult) {
        if (this.this$0.f50069b == null || TextUtils.isEmpty(this.this$0.f50069b.select_address_link)) {
            SystemUtils.log(6, "ESugPresenter", "select_address_link error", (Throwable) null, "com.didiglobal.eevee.comp.sug.ESugPresenter$3", 128);
        } else {
            ((Request) DRouter.build(this.this$0.f50069b.select_address_link).putExtra(ECompConstant.E_SUG_RESULT_PARAMS, (Serializable) addressResult)).start(this.this$0.mContext);
        }
    }

    public void onCloseButtonClick() {
        if (this.this$0.f50069b == null) {
            SystemUtils.log(6, "ESugPresenter", "model error", (Throwable) null, "com.didiglobal.eevee.comp.sug.ESugPresenter$3", 137);
        } else if (TextUtils.isEmpty(this.this$0.f50069b.cancel_link)) {
            super.onCloseButtonClick();
        } else {
            DRouter.build(this.this$0.f50069b.cancel_link).start(this.this$0.mContext);
        }
    }
}

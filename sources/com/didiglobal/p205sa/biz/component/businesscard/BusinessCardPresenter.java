package com.didiglobal.p205sa.biz.component.businesscard;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\r\u001a\u0010\u0012\u0004\u0012\u00020\u000f\u0012\u0004\u0012\u00020\u0010\u0018\u00010\u000eH\u0004J\u0010\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u000fH\u0002J\u0012\u0010\u0014\u001a\u00020\u00122\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u0017\u001a\u00020\u0012H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/businesscard/BusinessCardPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/businesscard/BusinessCardView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "callback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "reqParams", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getParams", "", "", "", "log", "", "msg", "onAdd", "arguments", "Landroid/os/Bundle;", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.businesscard.BusinessCardPresenter */
/* compiled from: BusinessCardPresenter.kt */
public final class BusinessCardPresenter extends ComponentPresenterImpl<BusinessCardView> {

    /* renamed from: a */
    private final Logger f50807a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private XEReqJSONParamsCallbackImpl f50808b = new BusinessCardPresenter$reqParams$1(this);

    /* renamed from: c */
    private final XEResponseCallback f50809c = new BusinessCardPresenter$callback$1(this);

    public BusinessCardPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36471a(String str) {
        this.f50807a.info(str, new Object[0]);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_BUSINESS_CARD, "sa_home", this.f50809c);
        xERegisterModel.requestParams = this.f50808b;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getParams() {
        Map<String, Object> hashMap = new HashMap<>();
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("lat", Double.valueOf(lastKnownLocation.getLatitude()));
            hashMap.put("lng", Double.valueOf(lastKnownLocation.getLongitude()));
        }
        return hashMap;
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_BUSINESS_CARD);
    }
}

package com.didiglobal.p205sa.biz.component.ridecard;

import android.os.Bundle;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.util.SystemUtil;
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
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000R\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\u0016\u0010\u000f\u001a\u0010\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\u0011\u0018\u00010\u0010H\u0004J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\fH\u0002J\u0012\u0010\u0015\u001a\u00020\u00132\b\u0010\u0016\u001a\u0004\u0018\u00010\u0017H\u0016J\u0010\u0010\u0018\u001a\u00020\u00132\u0006\u0010\u0019\u001a\u00020\u001aH\u0016J\b\u0010\u001b\u001a\u00020\u0013H\u0016J\b\u0010\u001c\u001a\u00020\u0013H\u0016J\b\u0010\u001d\u001a\u00020\u0013H\u0016J\b\u0010\u001e\u001a\u00020\u0013H\u0016J\b\u0010\u001f\u001a\u00020\u0013H\u0016R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u000e¢\u0006\u0002\n\u0000¨\u0006 "}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/ridecard/RideCardPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/ridecard/RideCardView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "callback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "productId", "", "reqParams", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "getParams", "", "", "log", "", "msg", "onAdd", "arguments", "Landroid/os/Bundle;", "onPageHiddenChanged", "hidden", "", "onPagePause", "onPageResume", "onPageStart", "onPageStop", "onRemove", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.ridecard.RideCardPresenter */
/* compiled from: RideCardPresenter.kt */
public final class RideCardPresenter extends ComponentPresenterImpl<RideCardView> {

    /* renamed from: a */
    private final Logger f51050a = LoggerFactory.getLogger("dongxt-RideCardPresenter");

    /* renamed from: b */
    private XEReqJSONParamsCallbackImpl f51051b = new RideCardPresenter$reqParams$1(this);
    /* access modifiers changed from: private */

    /* renamed from: c */
    public String f51052c = "30008";

    /* renamed from: d */
    private final XEResponseCallback f51053d = new RideCardPresenter$callback$1(this);

    public RideCardPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36576a(String str) {
        this.f51050a.info(str, new Object[0]);
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_RIDE_CARD, "sa_home", this.f51053d);
        xERegisterModel.requestParams = this.f51051b;
        XERegister.registerTemplate(xERegisterModel);
        ((RideCardView) this.mView).onAdd();
    }

    public void onRemove() {
        ((RideCardView) this.mView).onRemove();
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_RIDE_CARD);
    }

    public void onPagePause() {
        super.onPagePause();
        ((RideCardView) this.mView).onPagePause();
    }

    public void onPageResume() {
        super.onPageResume();
        ((RideCardView) this.mView).onPageResume();
    }

    public void onPageStop() {
        super.onPageStop();
        ((RideCardView) this.mView).onPageStop();
    }

    public void onPageStart() {
        super.onPageStart();
        ((RideCardView) this.mView).onPageStart();
    }

    public void onPageHiddenChanged(boolean z) {
        super.onPageHiddenChanged(z);
        ((RideCardView) this.mView).onPageHiddenChanged(z);
    }

    /* access modifiers changed from: protected */
    public final Map<String, Object> getParams() {
        Map<String, Object> hashMap = new HashMap<>();
        hashMap.put("platform", 2);
        String localeCode = NationTypeUtil.getNationComponentData().getLocaleCode();
        Intrinsics.checkNotNullExpressionValue(localeCode, "getNationComponentData().localeCode");
        hashMap.put("lang", localeCode);
        String str = this.mContext.getApplicationInfo().packageName;
        Intrinsics.checkNotNullExpressionValue(str, "mContext.applicationInfo.packageName");
        hashMap.put("app_id", str);
        DIDILocation lastKnownLocation = DIDILocationManager.getInstance(this.mContext).getLastKnownLocation();
        if (lastKnownLocation != null) {
            hashMap.put("user_loc_lng", Double.valueOf(lastKnownLocation.getLongitude()));
            hashMap.put("user_loc_lat", Double.valueOf(lastKnownLocation.getLatitude()));
        }
        hashMap.put("requester_type", 1);
        String mapTypeString = NationTypeUtil.getNationComponentData().getMapTypeString();
        Intrinsics.checkNotNullExpressionValue(mapTypeString, "getNationComponentData().getMapTypeString()");
        hashMap.put("coordinate_type", mapTypeString);
        hashMap.put("map_type", "gmap");
        String networkType = SystemUtil.getNetworkType();
        Intrinsics.checkNotNullExpressionValue(networkType, "getNetworkType()");
        hashMap.put("networky_type", networkType);
        hashMap.put("product_id", this.f51052c);
        return hashMap;
    }
}

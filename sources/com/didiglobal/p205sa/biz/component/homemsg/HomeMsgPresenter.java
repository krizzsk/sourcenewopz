package com.didiglobal.p205sa.biz.component.homemsg;

import android.app.Activity;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import androidx.core.app.ActivityCompat;
import com.didi.commoninterfacelib.permission.PermissionCallback;
import com.didi.commoninterfacelib.permission.PermissionContext;
import com.didi.commoninterfacelib.permission.PermissionUtil;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p173dp.locsdk.Utils;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestManager;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.xengine.SAXEngineReqUtil;
import com.didiglobal.p205sa.biz.util.BaseEventKeys;
import com.yanzhenjie.permission.runtime.Permission;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u000f\u0012\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004¢\u0006\u0002\u0010\u0005J\b\u0010\u0010\u001a\u00020\u0011H\u0002J\u0012\u0010\u0012\u001a\u00020\u00112\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0016J\b\u0010\u0015\u001a\u00020\u0011H\u0016J\b\u0010\u0016\u001a\u00020\u0011H\u0002J\b\u0010\u0017\u001a\u00020\u0011H\u0002R\u000e\u0010\u0006\u001a\u00020\u0007X\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\b\u001a\n \n*\u0004\u0018\u00010\t0\tX\u0004¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\r0\fX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0004¢\u0006\u0002\n\u0000¨\u0006\u0018"}, mo175978d2 = {"Lcom/didiglobal/sa/biz/component/homemsg/HomeMsgPresenter;", "Lcom/didi/component/never/core/ComponentPresenterImpl;", "Lcom/didiglobal/sa/biz/component/homemsg/HomeMsgView;", "params", "Lcom/didi/component/never/core/ComponentParams;", "(Lcom/didi/component/never/core/ComponentParams;)V", "callback", "Lcom/didiglobal/enginecore/callback/XEResponseCallback;", "logger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "mLoactionListener", "Lcom/didi/component/never/core/event/BaseEventPublisher$OnEventListener;", "Lcom/didi/component/never/core/event/BaseEventPublisher$NullEvent;", "paramCallback", "Lcom/didi/xengine/callback/XEReqJSONParamsCallbackImpl;", "doRefresh", "", "onAdd", "arguments", "Landroid/os/Bundle;", "onRemove", "showOpenPermissionDialog", "showOpenSystemLocationDialog", "biz-library_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didiglobal.sa.biz.component.homemsg.HomeMsgPresenter */
/* compiled from: HomeMsgPresenter.kt */
public final class HomeMsgPresenter extends ComponentPresenterImpl<HomeMsgView> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final Logger f50996a = LoggerFactory.getLogger(getClass().getName());

    /* renamed from: b */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f50997b = new HomeMsgPresenter$mLoactionListener$1(this);

    /* renamed from: c */
    private final XEResponseCallback f50998c = new HomeMsgPresenter$callback$1(this);

    /* renamed from: d */
    private final XEReqJSONParamsCallbackImpl f50999d = new HomeMsgPresenter$paramCallback$1(this);

    public HomeMsgPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m36538a() {
        if (!Utils.isLocationPermissionGranted(this.mContext) && Build.VERSION.SDK_INT >= 23) {
            Context context = this.mContext;
            if (context == null) {
                throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
            } else if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) context, Permission.ACCESS_FINE_LOCATION) && !PermissionUtil.checkPermissionAllGranted(this.mContext, Permission.ACCESS_FINE_LOCATION)) {
                Context context2 = this.mContext;
                if (context2 != null) {
                    PermissionUtil.requestPermissions((PermissionContext) context2, (PermissionCallback) new HomeMsgPresenter$showOpenPermissionDialog$1(this), Permission.ACCESS_FINE_LOCATION, false);
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type com.didi.commoninterfacelib.permission.PermissionContext");
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final void m36539b() {
        if (Utils.isLocationPermissionGranted(this.mContext)) {
            LocationSettingRequestManager instance = LocationSettingRequestManager.getInstance();
            Context context = this.mContext;
            if (context != null) {
                instance.checkSettingRequest((Activity) context, new HomeMsgPresenter$showOpenSystemLocationDialog$1(this));
                return;
            }
            throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public final void m36540c() {
        SAXEngineReqUtil.INSTANCE.pageRequest("sa_home");
    }

    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(ComponentType.COMPONENT_HOME_MSG, "sa_home", this.f50998c);
        xERegisterModel.requestParams = this.f50999d;
        XERegister.registerTemplate(xERegisterModel);
        subscribe(BaseEventKeys.MSG_CARD.EVENT_OPEN_SYS_LOCATION_SETTING, this.f50997b);
    }

    public void onRemove() {
        super.onRemove();
        XERegister.unregisterTemplate(ComponentType.COMPONENT_HOME_MSG);
        unsubscribe(BaseEventKeys.MSG_CARD.EVENT_OPEN_SYS_LOCATION_SETTING, this.f50997b);
    }
}

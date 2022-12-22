package com.didi.component.driverbar.presenter;

import android.content.Intent;
import android.os.Bundle;
import android.view.ViewGroup;
import androidx.fragment.app.Fragment;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.business.xpanelnew.XpNewAdapter;
import com.didi.component.common.base.ComponentType;
import com.didi.component.common.model.DataFieldWrapper;
import com.didi.component.common.model.PermissionResults;
import com.didi.component.common.util.GLog;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarNormalData;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.map.global.flow.model.EtaEda;
import com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.core.model.response.DTSDKCarModel;
import com.didi.travel.psnger.core.model.response.DTSDKDriverModel;
import com.didi.travel.psnger.core.model.response.DTSDKUpgradeModel;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.unifylogin.api.OneLoginFacade;
import com.didi.unifylogin.listener.LoginListeners;
import com.didiglobal.travel.infra.rxjava2.CompletableKt;
import com.didiglobal.travel.infra.rxjava2.DisposableKt;
import com.didiglobal.travel.infra.rxjava2.SingleKt;
import java.util.HashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import p242io.reactivex.Completable;
import p242io.reactivex.Single;
import p242io.reactivex.disposables.Disposable;
import p242io.reactivex.schedulers.Schedulers;

@Metadata(mo175977d1 = {"\u0000¼\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002B\r\u0012\u0006\u0010\u0003\u001a\u00020\u0004¢\u0006\u0002\u0010\u0005J\b\u0010#\u001a\u00020$H\u0016J\u001c\u0010%\u001a\u00020$2\b\u0010&\u001a\u0004\u0018\u00010'2\b\u0010(\u001a\u0004\u0018\u00010)H\u0014J0\u0010*\u001a\u00020$2\b\u0010+\u001a\u0004\u0018\u00010,2\b\u0010-\u001a\u0004\u0018\u00010,2\b\u0010.\u001a\u0004\u0018\u00010,2\b\u0010/\u001a\u0004\u0018\u000100H\u0016J\b\u00101\u001a\u00020\tH\u0002J\n\u00102\u001a\u0004\u0018\u00010,H\u0014J\u0006\u00103\u001a\u00020$J \u00104\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109J\u0015\u0010:\u001a\u00020$2\b\u0010;\u001a\u0004\u0018\u00010\t¢\u0006\u0002\u0010<J\u0006\u0010=\u001a\u00020$J\u000e\u0010>\u001a\u00020$2\u0006\u0010?\u001a\u00020\u0010J\u0006\u0010@\u001a\u00020\tJ\b\u0010A\u001a\u00020$H\u0016J\"\u0010B\u001a\u00020$2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002062\b\u00108\u001a\u0004\u0018\u000109H\u0014J\u0012\u0010C\u001a\u00020$2\b\u0010D\u001a\u0004\u0018\u000100H\u0014J\u0012\u0010E\u001a\u00020\t2\b\u0010F\u001a\u0004\u0018\u00010GH\u0014J\b\u0010H\u001a\u00020$H\u0014J\u001c\u0010I\u001a\u00020$2\b\u00108\u001a\u0004\u0018\u00010J2\b\u0010K\u001a\u0004\u0018\u00010LH\u0016J\b\u0010M\u001a\u00020$H\u0002J\f\u0010N\u001a\u00020$*\u00020OH\u0002J\u0014\u0010P\u001a\u00020Q*\u00020J2\u0006\u0010R\u001a\u00020OH\u0002R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\u000bX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u001c\u0010\u0016\u001a\n \u0018*\u0004\u0018\u00010\u00170\u0017X\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u000e\u0010\u001b\u001a\u00020\u001cX\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\t0\u000bX\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00070\u000bX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u000e¢\u0006\u0002\n\u0000¨\u0006S"}, mo175978d2 = {"Lcom/didi/component/driverbar/presenter/DriverBarV2Presenter;", "Lcom/didi/component/driverbar/AbsDriverBarPresenter;", "Lcom/didi/component/business/xpanelnew/XpNewAdapter;", "params", "Lcom/didi/component/core/ComponentParams;", "(Lcom/didi/component/core/ComponentParams;)V", "etaEda", "Lcom/didi/map/global/flow/model/EtaEda;", "isShowNearPickup", "", "mBlueToothEntranceShowListener", "Lcom/didi/component/core/event/BaseEventPublisher$OnEventListener;", "mBlueToothIMReddotListener", "mBlueToothOnserviceListener", "Lcom/didi/component/core/event/BaseEventPublisher$NullEvent;", "mBlueToothPermissionListener", "Lcom/didi/component/common/model/PermissionResults;", "mCardInfo", "Lcom/didi/component/driverbar/model/DriverBarCardInfo;", "mContainer", "Landroid/view/ViewGroup;", "mDriverArrivalListener", "mLogger", "Lcom/didi/sdk/logging/Logger;", "kotlin.jvm.PlatformType", "getMLogger", "()Lcom/didi/sdk/logging/Logger;", "mLoginOutListener", "Lcom/didi/unifylogin/listener/LoginListeners$LoginOutListener;", "mNewsglListener", "mViewStyle", "Lcom/didi/component/driverbar/model/DriverBarStyle;", "nearPickupListener", "sctxBTMView", "Lcom/didi/map/global/flow/scene/order/bluetooth_meet/SctxBTMView;", "bluetoothMeetClick", "", "buildDriverCarInfo", "driverModel", "Lcom/didi/travel/psnger/core/model/response/DTSDKDriverModel;", "carModel", "Lcom/didi/travel/psnger/core/model/response/DTSDKCarModel;", "buildInnerComponent", "imOption", "", "phoneOption", "source", "options", "Landroid/os/Bundle;", "checkSwitchNearEnable", "getIMGuideText", "handleBlueToothMeetBackPressed", "handleBlueToothMeetPermissionCallbak", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "handleBluetoothMeetIMRedDot", "isShow", "(Ljava/lang/Boolean;)V", "handleBluetoothMeetOnservice", "handleBluetoothPermissionRequestResult", "permissonResults", "isBlueToothMeetSurfaceShowing", "nearPickUpSwitch", "onActivityResult", "onAdd", "arguments", "onBackPressed", "backType", "Lcom/didi/component/core/IPresenter$BackType;", "onRemove", "setViewWithData", "Lorg/json/JSONObject;", "callback", "Lcom/didi/component/business/xpanelnew/IXpCardBindDataReadyCallback;", "traceBlueMeetClickvent", "checkCarUpdateInfo", "Lcom/didi/component/driverbar/IDriverBarView;", "process", "Lio/reactivex/Completable;", "view", "comp-driverbar_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DriverBarV2Presenter.kt */
public final class DriverBarV2Presenter extends AbsDriverBarPresenter implements XpNewAdapter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public boolean f13002a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public EtaEda f13003b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public DriverBarCardInfo f13004c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DriverBarStyle f13005d = DriverBarStyle.DEFAULT_STYLE;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SctxBTMView f13006e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ViewGroup f13007f;

    /* renamed from: g */
    private final Logger f13008g = LoggerFactory.getLogger(getClass());

    /* renamed from: h */
    private final BaseEventPublisher.OnEventListener<EtaEda> f13009h = new DriverBarV2Presenter$nearPickupListener$1(this);

    /* renamed from: i */
    private final BaseEventPublisher.OnEventListener<Boolean> f13010i = new DriverBarV2Presenter$mDriverArrivalListener$1(this);

    /* renamed from: j */
    private final BaseEventPublisher.OnEventListener<Boolean> f13011j = new DriverBarV2Presenter$mNewsglListener$1(this);

    /* renamed from: k */
    private final BaseEventPublisher.OnEventListener<PermissionResults> f13012k = new DriverBarV2Presenter$mBlueToothPermissionListener$1(this);

    /* renamed from: l */
    private final BaseEventPublisher.OnEventListener<Boolean> f13013l = new DriverBarV2Presenter$mBlueToothIMReddotListener$1(this);

    /* renamed from: m */
    private final BaseEventPublisher.OnEventListener<Boolean> f13014m = new DriverBarV2Presenter$mBlueToothEntranceShowListener$1(this);

    /* renamed from: n */
    private final BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f13015n = new DriverBarV2Presenter$mBlueToothOnserviceListener$1(this);

    /* renamed from: p */
    private final LoginListeners.LoginOutListener f13016p = new DriverBarV2Presenter$mLoginOutListener$1(this);

    /* access modifiers changed from: protected */
    public void buildDriverCarInfo(DTSDKDriverModel dTSDKDriverModel, DTSDKCarModel dTSDKCarModel) {
    }

    /* access modifiers changed from: protected */
    public String getIMGuideText() {
        return null;
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public DriverBarV2Presenter(ComponentParams componentParams) {
        super(componentParams);
        Intrinsics.checkNotNullParameter(componentParams, "params");
    }

    /* access modifiers changed from: protected */
    public final Logger getMLogger() {
        return this.f13008g;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK, this.f13009h);
        subscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f13010i);
        subscribe(BaseEventKeys.C4621IM.EVENT_IM_MESSAGE_BUBBLE_SHOW, this.f13011j);
        subscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_PERMISSION_RESULT, this.f13012k);
        subscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_IM_REDDOT, this.f13013l);
        subscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ENTRANCE_SHOW, this.f13014m);
        subscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ONSERVICE, this.f13015n);
        OneLoginFacade.getFunction().addLoginOutListener(this.f13016p);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK, this.f13009h);
        unsubscribe(BaseEventKeys.OnService.EVENT_STATUS_DRIVER_ARRIVAL, this.f13010i);
        unsubscribe(BaseEventKeys.C4621IM.EVENT_IM_MESSAGE_BUBBLE_SHOW, this.f13011j);
        unsubscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_PERMISSION_RESULT, this.f13012k);
        unsubscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_IM_REDDOT, this.f13013l);
        unsubscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ENTRANCE_SHOW, this.f13014m);
        unsubscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_ONSERVICE, this.f13015n);
        OneLoginFacade.getFunction().removeLoginOutListener(this.f13016p);
    }

    public void setViewWithData(JSONObject jSONObject, IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        Disposable subscribeBy;
        IDriverBarView iDriverBarView = (IDriverBarView) this.mView;
        if (iDriverBarView != null) {
            if (!(jSONObject == null || (subscribeBy = CompletableKt.subscribeBy(m8815a(jSONObject, iDriverBarView), new DriverBarV2Presenter$setViewWithData$1$1(iXpCardBindDataReadyCallback, this))) == null)) {
                Fragment host = getHost();
                Intrinsics.checkNotNullExpressionValue(host, "host");
                DisposableKt.bindLifecycle(subscribeBy, host);
            }
            m8816a(iDriverBarView);
        }
    }

    public void nearPickUpSwitch() {
        super.nearPickUpSwitch();
        doPublish(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK_SWITCH);
    }

    public void buildInnerComponent(String str, String str2, String str3, Bundle bundle) {
        StringBuilder sb = new StringBuilder();
        sb.append("build inner component with source: ");
        String str4 = "";
        sb.append(str3 == null ? str4 : str3);
        sb.append("\nim-option: ");
        sb.append(str == null ? str4 : str);
        sb.append("\nphone-option: ");
        if (str2 != null) {
            str4 = str2;
        }
        sb.append(str4);
        GLog.m7965d(ComponentType.DRIVER_BAR, sb.toString());
        super.buildInnerComponent(str, str2, str3, bundle);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public final boolean m8817b() {
        boolean z;
        DriverBarCardInfo driverBarCardInfo = this.f13004c;
        if (driverBarCardInfo != null) {
            DataFieldWrapper<DriverBarNormalData> normal = driverBarCardInfo.getNormal();
            DriverBarNormalData data = normal == null ? null : normal.getData();
            if (data != null && data.getSwitchNearEnable() == 1) {
                z = true;
            } else {
                z = false;
            }
            if (z) {
                return true;
            }
        }
        return false;
    }

    /* renamed from: a */
    private final Completable m8815a(JSONObject jSONObject, IDriverBarView iDriverBarView) {
        Single subscribeOn = Single.fromCallable(new DriverBarV2Presenter$process$1(jSONObject)).subscribeOn(Schedulers.computation());
        Intrinsics.checkNotNullExpressionValue(subscribeOn, "JSONObject.process(view:…Schedulers.computation())");
        Completable flatMapCompletable = SingleKt.observeOnMain(subscribeOn).flatMapCompletable(new DriverBarV2Presenter$process$2(this, iDriverBarView));
        Intrinsics.checkNotNullExpressionValue(flatMapCompletable, "private fun JSONObject.p…    }\n            }\n    }");
        return flatMapCompletable;
    }

    /* renamed from: a */
    private final void m8816a(IDriverBarView iDriverBarView) {
        DTSDKUpgradeModel dTSDKUpgradeModel;
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && (dTSDKUpgradeModel = order.upgradeInfo) != null) {
            iDriverBarView.showCarUpdateInfo(dTSDKUpgradeModel.icon, dTSDKUpgradeModel.text, dTSDKUpgradeModel.bgColorFrom, dTSDKUpgradeModel.bgColorTo);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == SctxBTMView.Companion.getBTM_SETTING_REQUEST_CODE()) {
            handleBlueToothMeetPermissionCallbak(i, i2, intent);
        }
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed(IPresenter.BackType backType) {
        if (!isBlueToothMeetSurfaceShowing()) {
            return super.onBackPressed(backType);
        }
        handleBlueToothMeetBackPressed();
        return true;
    }

    /* JADX WARNING: Removed duplicated region for block: B:114:0x0181  */
    /* JADX WARNING: Removed duplicated region for block: B:131:0x01cd  */
    /* JADX WARNING: Removed duplicated region for block: B:30:0x006c  */
    /* JADX WARNING: Removed duplicated region for block: B:48:0x00a1  */
    /* JADX WARNING: Removed duplicated region for block: B:64:0x00cf  */
    /* JADX WARNING: Removed duplicated region for block: B:82:0x0104  */
    /* JADX WARNING: Removed duplicated region for block: B:98:0x0132  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bluetoothMeetClick() {
        /*
            r11 = this;
            super.bluetoothMeetClick()
            com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView r0 = r11.f13006e
            if (r0 == 0) goto L_0x0008
            return
        L_0x0008:
            com.didi.component.core.IView r0 = r11.mView
            com.didi.component.driverbar.IDriverBarView r0 = (com.didi.component.driverbar.IDriverBarView) r0
            r0.hideBlueMeetGuide()
            r11.m8818c()
            com.didi.component.business.util.OrderComManager r0 = com.didi.component.business.util.OrderComManager.getInstance()
            com.didi.travel.psnger.model.response.OrderCom r0 = r0.getOrderCom()
            if (r0 == 0) goto L_0x01d5
            java.lang.String r1 = r0.getOid()
            java.lang.CharSequence r1 = (java.lang.CharSequence) r1
            boolean r1 = android.text.TextUtils.isEmpty(r1)
            if (r1 != 0) goto L_0x01d5
            android.content.Context r1 = r11.mContext
            boolean r1 = r1 instanceof androidx.fragment.app.FragmentActivity
            if (r1 == 0) goto L_0x01d5
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            r2 = 0
            java.lang.String r3 = ""
            if (r1 != 0) goto L_0x0037
        L_0x0035:
            r5 = r3
            goto L_0x0066
        L_0x0037:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x003f
            r1 = r2
            goto L_0x0045
        L_0x003f:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x0045:
            if (r1 != 0) goto L_0x0049
            r1 = r2
            goto L_0x004d
        L_0x0049:
            com.didi.component.driverbar.model.DriverBarFieldInfo r1 = r1.getNearInfo()
        L_0x004d:
            if (r1 != 0) goto L_0x0050
            goto L_0x0035
        L_0x0050:
            com.didi.component.driverbar.model.DriverCarInfo2 r1 = r1.getCarInfo()
            if (r1 != 0) goto L_0x0057
            goto L_0x0035
        L_0x0057:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r1 = r1.getLicenseNum()
            if (r1 != 0) goto L_0x005e
            goto L_0x0035
        L_0x005e:
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto L_0x0065
            goto L_0x0035
        L_0x0065:
            r5 = r1
        L_0x0066:
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            if (r1 != 0) goto L_0x006c
        L_0x006a:
            r6 = r3
            goto L_0x009b
        L_0x006c:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x0074
            r1 = r2
            goto L_0x007a
        L_0x0074:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x007a:
            if (r1 != 0) goto L_0x007e
            r1 = r2
            goto L_0x0082
        L_0x007e:
            com.didi.component.driverbar.model.DriverBarFieldInfo r1 = r1.getNearInfo()
        L_0x0082:
            if (r1 != 0) goto L_0x0085
            goto L_0x006a
        L_0x0085:
            com.didi.component.driverbar.model.DriverCarInfo2 r1 = r1.getCarInfo()
            if (r1 != 0) goto L_0x008c
            goto L_0x006a
        L_0x008c:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r1 = r1.getCarTypeInfo()
            if (r1 != 0) goto L_0x0093
            goto L_0x006a
        L_0x0093:
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto L_0x009a
            goto L_0x006a
        L_0x009a:
            r6 = r1
        L_0x009b:
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            if (r1 != 0) goto L_0x00a1
        L_0x009f:
            r7 = r3
            goto L_0x00c9
        L_0x00a1:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x00a9
            r1 = r2
            goto L_0x00af
        L_0x00a9:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x00af:
            if (r1 != 0) goto L_0x00b3
            r1 = r2
            goto L_0x00b7
        L_0x00b3:
            com.didi.component.driverbar.model.DriverBarFieldInfo r1 = r1.getNearInfo()
        L_0x00b7:
            if (r1 != 0) goto L_0x00ba
            goto L_0x009f
        L_0x00ba:
            com.didi.component.driverbar.model.DriverPersonalInfo r1 = r1.getDriverInfo()
            if (r1 != 0) goto L_0x00c1
            goto L_0x009f
        L_0x00c1:
            java.lang.String r1 = r1.getAvatar()
            if (r1 != 0) goto L_0x00c8
            goto L_0x009f
        L_0x00c8:
            r7 = r1
        L_0x00c9:
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            if (r1 != 0) goto L_0x00cf
        L_0x00cd:
            r8 = r3
            goto L_0x00fe
        L_0x00cf:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x00d7
            r1 = r2
            goto L_0x00dd
        L_0x00d7:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x00dd:
            if (r1 != 0) goto L_0x00e1
            r1 = r2
            goto L_0x00e5
        L_0x00e1:
            com.didi.component.driverbar.model.DriverBarFieldInfo r1 = r1.getNearInfo()
        L_0x00e5:
            if (r1 != 0) goto L_0x00e8
            goto L_0x00cd
        L_0x00e8:
            com.didi.component.driverbar.model.DriverCarInfo2 r1 = r1.getCarInfo()
            if (r1 != 0) goto L_0x00ef
            goto L_0x00cd
        L_0x00ef:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r1 = r1.getCarColorInfo()
            if (r1 != 0) goto L_0x00f6
            goto L_0x00cd
        L_0x00f6:
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto L_0x00fd
            goto L_0x00cd
        L_0x00fd:
            r8 = r1
        L_0x00fe:
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            if (r1 != 0) goto L_0x0104
        L_0x0102:
            r9 = r3
            goto L_0x012c
        L_0x0104:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x010c
            r1 = r2
            goto L_0x0112
        L_0x010c:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x0112:
            if (r1 != 0) goto L_0x0116
            r1 = r2
            goto L_0x011a
        L_0x0116:
            com.didi.component.driverbar.model.DriverBarFieldInfo r1 = r1.getNearInfo()
        L_0x011a:
            if (r1 != 0) goto L_0x011d
            goto L_0x0102
        L_0x011d:
            com.didi.component.driverbar.model.DriverCarInfo2 r1 = r1.getCarInfo()
            if (r1 != 0) goto L_0x0124
            goto L_0x0102
        L_0x0124:
            java.lang.String r1 = r1.getIcon()
            if (r1 != 0) goto L_0x012b
            goto L_0x0102
        L_0x012b:
            r9 = r1
        L_0x012c:
            com.didi.component.driverbar.model.DriverBarCardInfo r1 = r11.f13004c
            if (r1 != 0) goto L_0x0132
        L_0x0130:
            r10 = r3
            goto L_0x0160
        L_0x0132:
            com.didi.component.common.model.DataFieldWrapper r1 = r1.getNormal()
            if (r1 != 0) goto L_0x013a
            r1 = r2
            goto L_0x0140
        L_0x013a:
            java.lang.Object r1 = r1.getData()
            com.didi.component.driverbar.model.DriverBarNormalData r1 = (com.didi.component.driverbar.model.DriverBarNormalData) r1
        L_0x0140:
            if (r1 != 0) goto L_0x0143
            goto L_0x0147
        L_0x0143:
            com.didi.component.driverbar.model.DriverBarFieldInfo r2 = r1.getNearInfo()
        L_0x0147:
            if (r2 != 0) goto L_0x014a
            goto L_0x0130
        L_0x014a:
            com.didi.component.driverbar.model.DriverPersonalInfo r1 = r2.getDriverInfo()
            if (r1 != 0) goto L_0x0151
            goto L_0x0130
        L_0x0151:
            com.didi.global.globaluikit.richinfo.LEGORichInfo r1 = r1.getName()
            if (r1 != 0) goto L_0x0158
            goto L_0x0130
        L_0x0158:
            java.lang.String r1 = r1.getContent()
            if (r1 != 0) goto L_0x015f
            goto L_0x0130
        L_0x015f:
            r10 = r1
        L_0x0160:
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMDriverParam r1 = new com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMDriverParam
            r4 = r1
            r4.<init>(r5, r6, r7, r8, r9, r10)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMParam r2 = new com.didi.map.global.flow.scene.order.bluetooth_meet.model.SctxBTMParam
            java.lang.String r0 = r0.getOid()
            java.lang.String r3 = "orderCom.oid"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r0, r3)
            com.didi.component.driverbar.presenter.DriverBarV2Presenter$bluetoothMeetClick$sctxBTMParam$1 r3 = new com.didi.component.driverbar.presenter.DriverBarV2Presenter$bluetoothMeetClick$sctxBTMParam$1
            r3.<init>(r11)
            com.didi.map.global.flow.scene.order.bluetooth_meet.model.IBTMHandler r3 = (com.didi.map.global.flow.scene.order.bluetooth_meet.model.IBTMHandler) r3
            r2.<init>(r0, r1, r3)
            com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView r0 = new com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView
            android.content.Context r1 = r11.mContext
            if (r1 == 0) goto L_0x01cd
            androidx.fragment.app.FragmentActivity r1 = (androidx.fragment.app.FragmentActivity) r1
            r0.<init>(r1, r2)
            r11.f13006e = r0
            android.content.Context r0 = r11.mContext
            boolean r0 = r0 instanceof android.app.Activity
            if (r0 == 0) goto L_0x019d
            android.content.Context r0 = r11.mContext
            if (r0 == 0) goto L_0x0195
            android.app.Activity r0 = (android.app.Activity) r0
            goto L_0x01a5
        L_0x0195:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type android.app.Activity"
            r0.<init>(r1)
            throw r0
        L_0x019d:
            com.didi.sdk.app.ActivityLifecycleManager r0 = com.didi.sdk.app.ActivityLifecycleManager.getInstance()
            android.app.Activity r0 = r0.getCurrentActivity()
        L_0x01a5:
            if (r0 == 0) goto L_0x01d5
            com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView r1 = r11.f13006e
            if (r1 == 0) goto L_0x01d5
            r1 = 16908290(0x1020002, float:2.3877235E-38)
            android.view.View r0 = r0.findViewById(r1)
            android.view.ViewGroup r0 = (android.view.ViewGroup) r0
            r11.f13007f = r0
            if (r0 != 0) goto L_0x01b9
            goto L_0x01c0
        L_0x01b9:
            com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView r1 = r11.f13006e
            android.view.View r1 = (android.view.View) r1
            r0.removeView(r1)
        L_0x01c0:
            android.view.ViewGroup r0 = r11.f13007f
            if (r0 != 0) goto L_0x01c5
            goto L_0x01d5
        L_0x01c5:
            com.didi.map.global.flow.scene.order.bluetooth_meet.SctxBTMView r1 = r11.f13006e
            android.view.View r1 = (android.view.View) r1
            r0.addView(r1)
            goto L_0x01d5
        L_0x01cd:
            java.lang.NullPointerException r0 = new java.lang.NullPointerException
            java.lang.String r1 = "null cannot be cast to non-null type androidx.fragment.app.FragmentActivity"
            r0.<init>(r1)
            throw r0
        L_0x01d5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.component.driverbar.presenter.DriverBarV2Presenter.bluetoothMeetClick():void");
    }

    /* renamed from: c */
    private final void m8818c() {
        Map hashMap = new HashMap();
        if (CarOrderHelper.getOrder() != null) {
            String str = CarOrderHelper.getOrder().oid;
            Intrinsics.checkNotNullExpressionValue(str, "getOrder().oid");
            hashMap.put("order_id", str);
        }
        GlobalOmegaUtils.trackEvent("map_btnavi_paxbt_ck", (Map<String, Object>) hashMap);
    }

    public final void handleBluetoothPermissionRequestResult(PermissionResults permissionResults) {
        Intrinsics.checkNotNullParameter(permissionResults, "permissonResults");
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            int i = permissionResults.requestCode;
            String[] strArr = permissionResults.permissions;
            Intrinsics.checkNotNullExpressionValue(strArr, "permissonResults.permissions");
            int[] iArr = permissionResults.results;
            Intrinsics.checkNotNullExpressionValue(iArr, "permissonResults.results");
            sctxBTMView.handleBluetoothPermissionRequestResult(i, strArr, iArr);
        }
    }

    public final void handleBluetoothMeetIMRedDot(Boolean bool) {
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            Intrinsics.checkNotNull(bool);
            sctxBTMView.setNewIMMsgCome(bool.booleanValue());
        }
    }

    public final void handleBluetoothMeetOnservice() {
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            sctxBTMView.setPassengerOnboard();
        }
    }

    public final void handleBlueToothMeetPermissionCallbak(int i, int i2, Intent intent) {
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            sctxBTMView.handleBluetoothPermissionSettingBack(i, i2, intent);
        }
    }

    public final void handleBlueToothMeetBackPressed() {
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            sctxBTMView.onBackPress();
        }
    }

    public final boolean isBlueToothMeetSurfaceShowing() {
        SctxBTMView sctxBTMView = this.f13006e;
        if (sctxBTMView != null) {
            Intrinsics.checkNotNull(sctxBTMView);
            if (sctxBTMView.isAttachedToWindow()) {
                return true;
            }
        }
        return false;
    }
}

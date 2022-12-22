package com.didi.component.home_exception;

import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import androidx.core.app.ActivityCompat;
import androidx.fragment.app.FragmentActivity;
import com.didi.component.business.constant.NEveREventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.common.util.GsonUtils;
import com.didi.component.common.util.LocationUtils;
import com.didi.component.home_exception.widget.ExceptionCardModel;
import com.didi.component.never.core.ComponentParams;
import com.didi.component.never.core.ComponentPresenterImpl;
import com.didi.component.never.core.event.BaseEventPublisher;
import com.didi.component.never.core.node.Node;
import com.didi.component.never.core.node.NodePresenter;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.permission.PermissionActivity;
import com.didi.sdk.util.permission.PermissionCallback;
import com.didi.xengine.callback.XEReqJSONParamsCallbackImpl;
import com.didi.xengine.register.XERegister;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestCallback;
import com.didichuxing.bigdata.p173dp.locsdk.setting.LocationSettingRequestManager;
import com.didiglobal.common.common.never.node.EeveeNodePresenterImpl;
import com.didiglobal.common.common.xengine.XEngineReq;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.didiglobal.privacy.disclosure.PositiveResultReason;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureBaseDialog;
import com.didiglobal.privacy.disclosure.PrivacyDisclosureManager;
import com.didiglobal.privacy.disclosure.PrivacyTypeEnum;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;
import org.json.JSONObject;

public abstract class AbsExceptionPresenter extends ComponentPresenterImpl<AbsExceptionView> {

    /* renamed from: a */
    private final String f14078a = getClass().getSimpleName();

    /* renamed from: b */
    private XEReqJSONParamsCallbackImpl f14079b = new XEReqJSONParamsCallbackImpl() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("no_location_permission", Integer.valueOf(LocationUtils.parseLocation(AbsExceptionPresenter.this.mContext) != 0 ? 1 : 0));
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: c */
    private XEResponseCallback f14080c = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            XEComponent xEComponent;
            JSONObject data;
            if (xEngineData != null && xEngineData.jsonObject != null && list != null && list.size() != 0 && (xEComponent = list.get(0)) != null && (data = xEComponent.getData()) != null) {
                GsonUtils.fromJsonAsync(data.toString(), ExceptionCardModel.class, new GsonUtils.OnFromJsonListener<ExceptionCardModel>() {
                    public void onFail() {
                    }

                    public void onSuccess(ExceptionCardModel exceptionCardModel) {
                        if (exceptionCardModel != null && exceptionCardModel.normal != null && exceptionCardModel.normal.data != null) {
                            ((AbsExceptionView) AbsExceptionPresenter.this.mView).bindData(exceptionCardModel.normal.data);
                        }
                    }
                });
            }
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14081d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            AbsExceptionPresenter.this.onMainBtnClick();
        }
    };

    public AbsExceptionPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    public void onAdd(Bundle bundle) {
        FormStore.getInstance().clear();
        super.onAdd(bundle);
        m9813b();
        showOpenPositionDialog();
        GlobalOmegaUtils.trackEvent("ibt_gp_minibus_page_sw");
    }

    public void onRemove() {
        super.onRemove();
        m9811a();
        FormStore.getInstance().clear();
    }

    /* renamed from: a */
    private void m9811a() {
        XERegister.unregisterTemplate("eevee_enable_location");
        EventBus.getDefault().unregister(this);
        unsubscribe(NEveREventKeys.BusEvent.OPEN_LOCATION_SERVICE, this.f14081d);
    }

    /* renamed from: b */
    private void m9813b() {
        XERegisterModel xERegisterModel = new XERegisterModel("eevee_enable_location", XERequestKey.SingeMinibus.SCENE_HOME, this.f14080c);
        xERegisterModel.requestParams = this.f14079b;
        XERegister.registerTemplate(xERegisterModel);
        EventBus.getDefault().register(this);
        subscribe(NEveREventKeys.BusEvent.OPEN_LOCATION_SERVICE, this.f14081d);
    }

    public void onMainBtnClick() {
        if (this.mContext instanceof FragmentActivity) {
            PrivacyDisclosureManager.getInstance().openPrivacyDisclosureDialog((FragmentActivity) this.mContext, PrivacyTypeEnum.LOCATION, new PrivacyDisclosureBaseDialog.Callback() {
                public void onNegativeResult() {
                }

                public void onPositiveResult(PositiveResultReason positiveResultReason) {
                    AbsExceptionPresenter.this.m9814c();
                }
            });
        } else {
            m9814c();
        }
        HashMap hashMap = new HashMap();
        hashMap.put("action", 1);
        GlobalOmegaUtils.trackEvent("map_loc_home_page_card_ck", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m9814c() {
        if (!LocationUtils.isLocationPermissionGranted(this.mContext) && Build.VERSION.SDK_INT >= 23 && ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.mContext, Permission.ACCESS_FINE_LOCATION)) {
            PermissionActivity.request(this.mContext, new String[]{Permission.ACCESS_FINE_LOCATION}, new PermissionCallback() {
                public void onPermissionGranted() {
                    AbsExceptionPresenter.this.m9816d();
                    AbsExceptionPresenter.this.showOpenPositionDialog();
                    HashMap hashMap = new HashMap();
                    hashMap.put("action", 1);
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }

                public void onPermissionReject(String str) {
                    HashMap hashMap = new HashMap();
                    if (ActivityCompat.shouldShowRequestPermissionRationale((Activity) AbsExceptionPresenter.this.mContext, Permission.ACCESS_FINE_LOCATION)) {
                        hashMap.put("action", 0);
                    } else {
                        hashMap.put("action", -1);
                    }
                    hashMap.put("type", 1);
                    GlobalOmegaUtils.trackEvent("map_loc_permission_ck", (Map<String, Object>) hashMap);
                }
            });
        } else if (!LocationUtils.isLocationPermissionGranted(this.mContext) && Build.VERSION.SDK_INT >= 23 && !ActivityCompat.shouldShowRequestPermissionRationale((Activity) this.mContext, Permission.ACCESS_FINE_LOCATION)) {
            DRouter.build("taxis99onetravel://one/syssettings?permission=android.permission.ACCESS_FINE_LOCATION&type=2").start(this.mContext);
        } else if (LocationUtils.isLocationPermissionGranted(this.mContext)) {
            showOpenPositionDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void showOpenPositionDialog() {
        if (LocationUtils.isLocationPermissionGranted(this.mContext)) {
            LocationSettingRequestManager.getInstance().checkSettingRequest((Activity) this.mContext, new LocationSettingRequestCallback() {
                public void onFailed() {
                }

                public /* synthetic */ void onFailed(boolean z) {
                    LocationSettingRequestCallback.CC.$default$onFailed(this, z);
                }

                public void onSuccess() {
                }
            });
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.MIS_DATA_FROM_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag) && carInfoUpdateEvent.result == 1) {
            m9816d();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m9816d() {
        Node nodeParent = getNodeParent();
        if (nodeParent != null) {
            NodePresenter presenter = nodeParent.getPresenter();
            if (presenter instanceof EeveeNodePresenterImpl) {
                String eeveeNodeId = ((EeveeNodePresenterImpl) presenter).getEeveeNodeId();
                if (!TextUtils.isEmpty(eeveeNodeId)) {
                    XEngineReq.pageRequest(eeveeNodeId);
                }
            }
        }
    }
}

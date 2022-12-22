package com.didi.safetoolkit.business.emergency.store;

import android.content.Intent;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.emergency.model.SfEmgInfo;
import com.didi.safetoolkit.business.emergency.model.SfEmgStatus;
import com.didi.safetoolkit.business.emergency.model.SfGetEmergencyInfo;
import com.didi.safetoolkit.business.emergency.request.SfEmergencyInfoRequest;
import com.didi.safetoolkit.business.emergency.request.SfEmergencyStatusRequest;
import com.didi.safetoolkit.business.emergency.request.SfStartEmergencyCallRequest;
import com.didi.safetoolkit.business.emergency.request.SfStopEmergencyCallRequest;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfBaseObject;
import com.didi.safetoolkit.net.SfHttpManager;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.net.SfRpcCallback;
import com.didi.safetoolkit.net.SfUrls;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import java.io.IOException;
import java.util.HashMap;

public class SfEmergencyAssistanceStore {

    /* renamed from: a */
    private static volatile SfEmergencyAssistanceStore f34345a;

    public static SfEmergencyAssistanceStore getInstance() {
        if (f34345a == null) {
            synchronized (SfEmergencyAssistanceStore.class) {
                if (f34345a == null) {
                    f34345a = new SfEmergencyAssistanceStore();
                }
            }
        }
        return f34345a;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24298a(boolean z) {
        Intent intent = new Intent();
        intent.setAction(z ? SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_ON : SfConstant.SfAction.ACTION_EMERGENCY_ASSIST_OFF);
        LocalBroadcastManager.getInstance(SfContextHelper.getContext()).sendBroadcast(intent);
    }

    /* renamed from: a */
    private String m24296a() {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfInfoService != null) {
            return iSfInfoService.getCarOrderId();
        }
        return null;
    }

    /* renamed from: b */
    private String m24299b() {
        ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfInfoService != null) {
            return iSfInfoService.getCountryIsoCode();
        }
        return null;
    }

    public void getEmergencyInfo(final SfResponseListener<SfEmgInfo> sfResponseListener) {
        if (SafeToolKit.getIns().isVamosDriver()) {
            Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), SfUrls.BffAbilityId.ABILITY_SAFETOOLKIT_GET_EMERGENCY_INFO).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    sfResponseListener.onSuccess(SfEmgInfo.convertFrom((SfGetEmergencyInfo) new Gson().fromJson(jsonObject.toString(), SfGetEmergencyInfo.class)));
                }

                public void onFailure(IOException iOException) {
                    sfResponseListener.onFail(-1, iOException.getMessage());
                }
            }).build());
            return;
        }
        SfEmergencyInfoRequest sfEmergencyInfoRequest = new SfEmergencyInfoRequest();
        sfEmergencyInfoRequest.orderId = m24296a();
        sfEmergencyInfoRequest.countryCode = m24299b();
        sfEmergencyInfoRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfEmergencyInfoRequest, new SfRpcCallback<SfEmgInfo>(new SfResponseListener<SfEmgInfo>() {
            public void onSuccess(SfEmgInfo sfEmgInfo) {
                sfResponseListener.onSuccess(sfEmgInfo);
            }

            public void onError(SfEmgInfo sfEmgInfo) {
                if (sfEmgInfo != null) {
                    sfResponseListener.onFail(sfEmgInfo.errno, sfEmgInfo.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void getEmergencyStatus(final SfResponseListener<SfEmgStatus> sfResponseListener) {
        SfEmergencyStatusRequest sfEmergencyStatusRequest = new SfEmergencyStatusRequest();
        sfEmergencyStatusRequest.orderId = m24296a();
        sfEmergencyStatusRequest.countryCode = m24299b();
        sfEmergencyStatusRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfEmergencyStatusRequest, new SfRpcCallback<SfEmgStatus>(new SfResponseListener<SfEmgStatus>() {
            public void onSuccess(SfEmgStatus sfEmgStatus) {
                sfResponseListener.onSuccess(sfEmgStatus);
                if (sfEmgStatus.data.isOnEmergencyCallStatus > 0) {
                    SfEmergencyAssistanceStore.this.m24298a(true);
                    SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                }
            }

            public void onError(SfEmgStatus sfEmgStatus) {
                if (sfEmgStatus != null) {
                    sfResponseListener.onFail(sfEmgStatus.errno, sfEmgStatus.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void startEmergencyCall(final SfResponseListener<SfBaseObject> sfResponseListener) {
        if (SafeToolKit.getIns().isVamosDriver()) {
            HashMap hashMap = new HashMap();
            hashMap.put("order_id", m24296a());
            Bff.call(new IBffProxy.Ability.Builder(SfContextHelper.getContext(), SfUrls.BffAbilityId.ABILITY_SAFETOOLKIT_REPORT_EMERGENCY_INFO).setParams(hashMap).setCallback(new RpcService.Callback<JsonObject>() {
                public void onSuccess(JsonObject jsonObject) {
                    sfResponseListener.onSuccess((SfEmgStatus) new Gson().fromJson(jsonObject.toString(), SfEmgStatus.class));
                    SfEmergencyAssistanceStore.this.m24298a(true);
                    SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                }

                public void onFailure(IOException iOException) {
                    sfResponseListener.onFail(-1, iOException.getMessage());
                }
            }).build());
            return;
        }
        SfStartEmergencyCallRequest sfStartEmergencyCallRequest = new SfStartEmergencyCallRequest();
        sfStartEmergencyCallRequest.orderId = m24296a();
        sfStartEmergencyCallRequest.countryCode = m24299b();
        sfStartEmergencyCallRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStartEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistanceStore.this.m24298a(true);
                SfOmegaUtil.addEventId("gp_safetyToolkit_inHelp_sw").report();
                sfResponseListener.onSuccess(sfBaseObject);
            }

            public void onError(SfBaseObject sfBaseObject) {
                if (sfBaseObject != null) {
                    sfResponseListener.onFail(sfBaseObject.errno, sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }

    public void stopEmergencyCall(final SfResponseListener<SfBaseObject> sfResponseListener) {
        SfStopEmergencyCallRequest sfStopEmergencyCallRequest = new SfStopEmergencyCallRequest();
        sfStopEmergencyCallRequest.orderId = m24296a();
        sfStopEmergencyCallRequest.countryCode = m24299b();
        sfStopEmergencyCallRequest.productId = SafeToolKit.getIns().getProductId();
        SfHttpManager.getInstance(SfContextHelper.getContext()).performRequest(sfStopEmergencyCallRequest, new SfRpcCallback<SfBaseObject>(new SfResponseListener<SfBaseObject>() {
            public void onSuccess(SfBaseObject sfBaseObject) {
                SfEmergencyAssistanceStore.this.m24298a(false);
                sfResponseListener.onSuccess(sfBaseObject);
            }

            public void onError(SfBaseObject sfBaseObject) {
                if (sfBaseObject != null) {
                    sfResponseListener.onFail(sfBaseObject.errno, sfBaseObject.errmsg);
                }
            }

            public void onFail(int i, String str) {
                sfResponseListener.onFail(i, str);
            }
        }) {
        });
    }
}

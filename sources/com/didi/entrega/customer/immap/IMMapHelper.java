package com.didi.entrega.customer.immap;

import android.content.Context;
import android.net.Uri;
import com.didi.entrega.customer.app.GlobalContext;
import com.didi.entrega.customer.flutter.FlutterEngineStore;
import com.didi.entrega.customer.flutter.plugin.HttpPlugin;
import com.didi.entrega.customer.foundation.log.util.LogUtil;
import com.didi.entrega.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.entrega.customer.foundation.tracker.error.ErrorConst;
import com.didi.entrega.customer.foundation.tracker.error.ErrorTracker;
import com.didi.entrega.customer.foundation.util.LoginUtil;
import com.didi.entrega.customer.service.CustomerServiceManager;
import com.didi.entrega.customer.service.ILocaleService;
import com.didi.sdk.util.AnalysisAPK;
import com.rider.rlab_im_map_plugin.ImMapActivity;
import com.rider.rlab_im_map_plugin.bean.ImBusinessBean;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.engine.OmegaParamsCallback;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import java.util.HashMap;

public final class IMMapHelper {
    public static final String TAG = "IMMapHelper";

    public static void init(Context context) {
        ImMapConfig.getInstance().setImCallFrom(ImCallFrom.IMMAP_RLAB_C).setNavType(1).setZoomLevel(16).setUserNewMap(true).setDowngradeMap(false).setIsDebug(false).setHmsService(AnalysisAPK.isGlobalHmsApk(context)).setNachoAction(FlutterEngineStore.getInstance().getBizMainEngineAction()).setToken(LoginUtil.getToken()).setImFavorFrom(GlobalContext.getBrand() == 2 ? ImFavorFrom.IMMAP_BRAZIL : ImFavorFrom.IMMAP_GLOBAL).setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang()).setOmegaParamsCallback(new OmegaParamsCallback() {
            public HashMap<String, Object> getOmegaParams() {
                return (HashMap) OmegaCommonParamHelper.getCommonParam();
            }
        }).build(context);
    }

    public static void startSendIMMap() {
        if (GlobalContext.getContext() == null) {
            LogUtil.m14765i(TAG, "startSendIMMap GlobalContext.getContext is null");
        } else if (FlutterEngineStore.getInstance().getBizMainEngineAction() == null || FlutterEngineStore.getInstance().getBizMainEngineAction().getEngine() == null) {
            LogUtil.m14765i(TAG, "startSendIMMap FlutterEngineStore.getInstance().getBizMainEngineAction() is null");
            m14859a();
        } else {
            init(GlobalContext.getContext());
            ImBusinessBean imBusinessBean = new ImBusinessBean();
            imBusinessBean.setType(0);
            HashMap hashMap = new HashMap();
            hashMap.put(ImCommons.BUNDLE_NET_PARAMS, HttpPlugin.getFlutterRequestCommonParams());
            imBusinessBean.setMap(hashMap);
            ImMapConfig.getInstance().setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang());
            ImMapActivity.show(GlobalContext.getContext(), imBusinessBean);
        }
    }

    public static void startNavIMMap(String str) {
        if (GlobalContext.getContext() == null) {
            LogUtil.m14765i(TAG, "startNavIMMap GlobalContext.getContext is null");
        } else if (FlutterEngineStore.getInstance().getBizMainEngineAction() == null) {
            LogUtil.m14765i(TAG, "startNavIMMap FlutterEngineStore.getInstance().getBizMainEngineAction() is null");
            m14859a();
        } else {
            init(GlobalContext.getContext());
            Uri parse = Uri.parse(str);
            String queryParameter = parse.getQueryParameter("toName");
            String queryParameter2 = parse.getQueryParameter("toAddress");
            String queryParameter3 = parse.getQueryParameter("toLat");
            String queryParameter4 = parse.getQueryParameter("toLng");
            double parseDouble = ImMapUtils.parseDouble(queryParameter3);
            double parseDouble2 = ImMapUtils.parseDouble(queryParameter4);
            ImBusinessBean imBusinessBean = new ImBusinessBean();
            imBusinessBean.setType(1);
            imBusinessBean.setLat(parseDouble);
            imBusinessBean.setLng(parseDouble2);
            imBusinessBean.setAddressName(queryParameter2);
            imBusinessBean.setSectionName(queryParameter);
            HashMap hashMap = new HashMap();
            hashMap.put(ImCommons.BUNDLE_NET_PARAMS, HttpPlugin.getFlutterRequestCommonParams());
            imBusinessBean.setMap(hashMap);
            ImMapConfig.getInstance().setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang());
            ImMapActivity.show(GlobalContext.getContext(), imBusinessBean);
        }
    }

    /* renamed from: a */
    private static void m14859a() {
        ErrorTracker.create(ErrorConst.ErrorName.TECH_C_IM_MAP_PLUGIN_ERROR).addModuleName("order").addErrorType("no engine").addErrorMsg("unable get nacho engine").build().trackError();
    }
}

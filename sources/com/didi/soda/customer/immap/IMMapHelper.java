package com.didi.soda.customer.immap;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import com.didi.beatles.p099im.module.entity.IMBusinessParam;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.soda.customer.apk.CustomerAnalysisApk;
import com.didi.soda.customer.app.GlobalContext;
import com.didi.soda.customer.downgrade.CustomerDowngradeHelper;
import com.didi.soda.customer.flutter.CustomerFlutterEngineManager;
import com.didi.soda.customer.flutter.plugin.HttpPlugin;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.MapData;
import com.didi.soda.customer.foundation.rpc.entity.OrderLayoutEntity;
import com.didi.soda.customer.foundation.tracker.OmegaCommonParamHelper;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.LoginUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.ILocaleService;
import com.didi.soda.manager.CustomerManagerLoader;
import com.didi.soda.manager.base.ICustomerOrderManager;
import com.didi.universal.pay.sdk.util.JsonUtil;
import com.rider.rlab_im_map_plugin.ImMapActivity;
import com.rider.rlab_im_map_plugin.bean.ImBusinessBean;
import com.rider.rlab_im_map_plugin.channel.MapIMPluginHelper;
import com.rider.rlab_im_map_plugin.engine.CustomerConfigListener;
import com.rider.rlab_im_map_plugin.engine.ImMapConfig;
import com.rider.rlab_im_map_plugin.engine.OmegaParamsCallback;
import com.rider.rlab_im_map_plugin.tool.ImCallFrom;
import com.rider.rlab_im_map_plugin.tool.ImCommons;
import com.rider.rlab_im_map_plugin.tool.ImFavorFrom;
import com.rider.rlab_im_map_plugin.tool.ImMapUtils;
import java.util.HashMap;

public final class IMMapHelper {

    /* renamed from: a */
    private static final String f41355a = "IMMapHelper";

    public static void init(Context context) {
        ImMapConfig.getInstance().setImCallFrom(ImCallFrom.IMMAP_RLAB_C).setNavType(1).setZoomLevel(16).setUserNewMap(true).setDowngradeMap(CustomerDowngradeHelper.isDowngradeMap()).setIsDebug(false).setNachoAction(CustomerFlutterEngineManager.getInstance().getBizFoodEngineAction()).setHmsService(CustomerAnalysisApk.INSTANCE.isHmsApk()).setToken(LoginUtil.getToken()).setImFavorFrom(GlobalContext.isBrazil() ? ImFavorFrom.IMMAP_BRAZIL : ImFavorFrom.IMMAP_GLOBAL).setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang()).setOmegaParamsCallback(new OmegaParamsCallback() {
            public HashMap<String, Object> getOmegaParams() {
                return (HashMap) OmegaCommonParamHelper.getCommonParam();
            }
        }).setCustomerConfigListener(new CustomerConfigListener() {
            public void getCustomerOrderInfo(String str) {
                OrderLayoutEntity orderLayoutById = ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).getOrderLayoutById(str);
                if (orderLayoutById != null) {
                    IMMapHelper.m29302b(orderLayoutById);
                } else {
                    ((ICustomerOrderManager) CustomerManagerLoader.loadManager(ICustomerOrderManager.class)).requestOrderLayoutById(str, 0, $$Lambda$IMMapHelper$1$FDPh3MMdAZMvdQcCpscy0jJ1yo.INSTANCE);
                }
            }
        }).build(context);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m29302b(OrderLayoutEntity orderLayoutEntity) {
        if (orderLayoutEntity == null || orderLayoutEntity.getOrderData() == null || orderLayoutEntity.getOrderData().getMapData() == null) {
            MapIMPluginHelper.setCustomerOrderInfo((String) null);
            return;
        }
        MapData mapData = orderLayoutEntity.getOrderData().getMapData();
        HashMap hashMap = new HashMap();
        hashMap.put("customerLat", Double.valueOf(mapData.getUserLat()));
        hashMap.put("customerLng", Double.valueOf(mapData.getUserLng()));
        hashMap.put("maxDistance", Integer.valueOf(CustomerApolloUtil.getImMapMaxDistance()));
        MapIMPluginHelper.setCustomerOrderInfo(JsonUtil.jsonFromObject(hashMap));
    }

    public static void startSendIMMap(IMBusinessParam iMBusinessParam, IMSession iMSession) {
        if (GlobalContext.getContext() == null) {
            LogUtil.m29104i("IMMapHelper", "startSendIMMap GlobalContext.getContext is null");
        } else if (CustomerFlutterEngineManager.getInstance().getBizFoodEngineAction() == null) {
            LogUtil.m29104i("IMMapHelper", "startSendIMMap Flutter Engine is null");
        } else {
            init(GlobalContext.getContext());
            LogUtil.m29104i("IMMapHelper", "hasMapMaxDistance ---> " + CustomerApolloUtil.hasMapMaxDistance());
            ImBusinessBean imBusinessBean = new ImBusinessBean();
            imBusinessBean.setType(0);
            String a = m29300a(iMBusinessParam, iMSession);
            if (!TextUtils.isEmpty(a)) {
                imBusinessBean.setOrderId(a);
            }
            HashMap hashMap = new HashMap();
            hashMap.put(ImCommons.BUNDLE_NET_PARAMS, HttpPlugin.getFlutterRequestCommonParams());
            imBusinessBean.setMap(hashMap);
            ImMapConfig.getInstance().setLocale(((ILocaleService) CustomerServiceManager.getService(ILocaleService.class)).getLang());
            ImMapActivity.show(GlobalContext.getContext(), imBusinessBean);
        }
    }

    /* renamed from: a */
    private static String m29300a(IMBusinessParam iMBusinessParam, IMSession iMSession) {
        if (GlobalContext.isEmbed() && !CustomerApolloUtil.hasMapMaxDistance()) {
            return null;
        }
        if (iMBusinessParam != null && !TextUtils.isEmpty(iMBusinessParam.getsOrderId())) {
            return iMBusinessParam.getsOrderId();
        }
        if (iMSession == null || iMSession.getExtendSessionInfo() == null) {
            return null;
        }
        return iMSession.getExtendSessionInfo().orderId;
    }

    public static void startNavIMMap(String str) {
        if (GlobalContext.getContext() == null) {
            LogUtil.m29104i("IMMapHelper", "startNavIMMap GlobalContext.getContext is null");
        } else if (CustomerFlutterEngineManager.getInstance().getBizFoodEngineAction() == null) {
            LogUtil.m29104i("IMMapHelper", "startNavIMMap RNacho.getInstance().getEngine is null");
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
}

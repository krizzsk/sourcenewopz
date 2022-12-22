package com.didi.component.mapflow.presenter;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.ImageUtil;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.core.ComponentParams;
import com.didi.component.mapflow.view.widget.WalkingNavigationView;
import com.didi.map.global.flow.scene.ISceneController;
import com.didi.map.global.flow.scene.minibus.scene.over.MiniBusOrderOverSceneParam;
import com.didi.map.global.flow.scene.order.serving.param.ServiceOverParam;
import com.didi.map.global.flow.scene.param.CommonMarkerParam;
import com.didi.map.global.flow.scene.param.MapElementId;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.SystemUtil;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.DrivingMapInfo;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.List;

public class EndMapFlowDelegatePresenter extends AbsAfterOrderMapFlowDelegatePresenter {
    public static final int EXPRESS = 1;
    public static final int MINIBUS = 2;
    public static final int OTHERS = 3;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f14421a = 1;

    /* renamed from: b */
    private boolean f14422b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final Logger f14423c = LoggerFactory.getLogger(getClass());
    /* access modifiers changed from: private */

    /* renamed from: d */
    public DrivingMapInfo f14424d = new DrivingMapInfo();

    /* renamed from: e */
    private final XEResponseCallback f14425e = new XEResponseCallback() {
        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            if (xEngineData != null && xEngineData.jsonObject != null) {
                Logger a = EndMapFlowDelegatePresenter.this.f14423c;
                a.info("EndMapFlowDelegatePresenter >>mXELogicCallbackMapInfo" + xEngineData.jsonObject.toString(), new Object[0]);
                EndMapFlowDelegatePresenter.this.f14424d.parse(xEngineData.jsonObject.toString());
                if (EndMapFlowDelegatePresenter.this.f14424d != null && EndMapFlowDelegatePresenter.this.f14424d.mapConfig != null) {
                    EndMapFlowDelegatePresenter endMapFlowDelegatePresenter = EndMapFlowDelegatePresenter.this;
                    int unused = endMapFlowDelegatePresenter.f14421a = endMapFlowDelegatePresenter.f14424d.mapConfig.bizScene;
                    if (EndMapFlowDelegatePresenter.this.f14424d.mapConfig.bizScene == 2) {
                        EndMapFlowDelegatePresenter endMapFlowDelegatePresenter2 = EndMapFlowDelegatePresenter.this;
                        endMapFlowDelegatePresenter2.m10156b(endMapFlowDelegatePresenter2.f14424d.mapConfig);
                    }
                }
            }
        }

        public void onFailed(String str, EngineErrorException engineErrorException) {
            Logger a = EndMapFlowDelegatePresenter.this.f14423c;
            a.info("mXELogicCallbackMapInfo" + engineErrorException.toString(), new Object[0]);
        }
    };
    protected ISceneController mSceneController;

    public EndMapFlowDelegatePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_MAP_INFO, XERequestKey.SCENE_TRIP, this.f14425e);
        xERegisterModel.requestParams = new XEReqParamsCallback() {
            public Object getRequestParams() {
                HashMap hashMap = new HashMap();
                hashMap.put("oid", CarOrderHelper.getOrderId());
                hashMap.put("version", 1);
                return hashMap;
            }
        };
        XERegister.registerTemplate(xERegisterModel);
        m10155b();
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        XERegister.unregisterCallback(XERequestKey.REQUEST_KEY_MAP_INFO, this.f14425e);
    }

    /* renamed from: a */
    private MiniBusOrderOverSceneParam m10151a(DrivingMapInfo.MapConfig mapConfig) {
        if (mapConfig == null || mapConfig.lineData == null || mapConfig.lineData.lineInfos == null || mapConfig.lineData.markerInfos == null) {
            this.f14423c.error("getMiniBusOrderOverSceneParam>> mapConfig.lineData is null", new Object[0]);
            return null;
        }
        MiniBusOrderOverSceneParam.Builder builder = new MiniBusOrderOverSceneParam.Builder();
        builder.miniBusParamInterface(getMiniBusParam(mapConfig.lineData.lineInfos, mapConfig.lineData.markerInfos, mapConfig.mapStyle));
        builder.sceneType(MiniBusOrderOverSceneParam.SceneOverType.WALKING_TYPE);
        builder.context(this.mContext);
        if (mapConfig.stationBoardHint != null && mapConfig.mapStyle == 6) {
            WalkingNavigationView walkingNavigationView = new WalkingNavigationView(this.mContext);
            walkingNavigationView.setDate(mapConfig.stationBoardHint, false);
            builder.endNavView(walkingNavigationView);
            builder.sceneType(MiniBusOrderOverSceneParam.SceneOverType.WALKING_TYPE);
        } else if (mapConfig.mapStyle == 7) {
            CarOrder order = CarOrderHelper.getOrder();
            if (order != null) {
                long j = 0;
                if (order.carDriver != null) {
                    j = NumberUtil.strToLong(order.carDriver.did);
                }
                builder.commonTypeParam(new MiniBusOrderOverSceneParam.OrderOverCommonTypeParam(j, order.productid, order.startChargeTime / 1000, order.finishTime / 1000, order.oid, SystemUtil.getVersionName(this.mContext)));
                builder.sceneType(MiniBusOrderOverSceneParam.SceneOverType.COMMON_TYPE);
            } else {
                this.f14423c.error("getMiniBusOrderOverSceneParam>> carOrder is null", new Object[0]);
            }
        }
        return builder.build();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10156b(DrivingMapInfo.MapConfig mapConfig) {
        if (!this.f14422b) {
            doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
            if (m10151a(mapConfig) != null) {
                this.mSceneController = transformToMinibusOrderOverScene(m10151a(mapConfig));
                this.f14422b = true;
            }
        }
    }

    /* renamed from: b */
    private void m10155b() {
        doPublish(BaseEventKeys.OnService.EVENT_ON_SERVICE_HIDE_TOP_ADDRESS_AREA, true);
        this.f14423c.info("EndMapFlowDelegate enterEndScene..", new Object[0]);
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            LoggerFactory.getLogger(getClass()).error("EndMapFlowDelegate order is null", new Object[0]);
        } else if (order.startAddress == null || order.endAddress == null) {
            Logger logger = LoggerFactory.getLogger(getClass());
            logger.error("EndMapFlowDelegate address is null, startAddress=" + order.startAddress + " endAddress=" + order.endAddress, new Object[0]);
        } else {
            LatLng latLng = new LatLng(order.startAddress.latitude, order.startAddress.longitude);
            LatLng latLng2 = new LatLng(order.endAddress.latitude, order.endAddress.longitude);
            Drawable drawable = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_pick_up);
            Drawable drawable2 = ResourcesHelper.getDrawable(this.mContext, R.drawable.map_icon_destination);
            CommonMarkerParam commonMarkerParam = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng).addressName((String) null).markerIcon(ImageUtil.Drawable2Bitmap(drawable)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_START));
            CommonMarkerParam commonMarkerParam2 = new CommonMarkerParam(new CommonMarkerParam.Builder().point(latLng2).addressName((String) null).markerIcon(ImageUtil.Drawable2Bitmap(drawable2)).anchorU(0.5f).anchorV(0.5f).mo75597id(MapElementId.ID_MARKER_END));
            HashMap hashMap = new HashMap();
            hashMap.put(MapElementId.ID_MARKER_START, commonMarkerParam);
            hashMap.put(MapElementId.ID_MARKER_END, commonMarkerParam2);
            ServiceOverParam.Builder mapChangeListener = new ServiceOverParam.Builder().context(this.mContext).setNewVersion(true).setMarkerParams(hashMap).mapChangeListener(this.mMapChangeListener);
            long j = 0;
            if (order.carDriver != null) {
                j = NumberUtil.strToLong(order.carDriver.did);
            }
            mapChangeListener.setDriverId(j);
            mapChangeListener.setBiztype(order.productid);
            mapChangeListener.setStartTime(order.startChargeTime / 1000);
            mapChangeListener.setEndTime(order.finishTime / 1000);
            mapChangeListener.setClientVersion(SystemUtil.getVersionName(this.mContext));
            mapChangeListener.setToken(NationComponentDataUtil.getToken());
            mapChangeListener.setPassengerPhoneNumber(NationComponentDataUtil.getPhone());
            String imei = SystemUtil.getIMEI();
            if (TextUtils.isEmpty(imei)) {
                imei = "";
            }
            mapChangeListener.setImei(imei);
            this.mSceneController = transformToServiceOverScene(new ServiceOverParam(mapChangeListener));
        }
    }

    /* access modifiers changed from: protected */
    public ISceneController getSceneController() {
        return this.mSceneController;
    }
}

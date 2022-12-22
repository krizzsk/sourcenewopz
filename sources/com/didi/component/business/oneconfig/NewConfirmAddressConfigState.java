package com.didi.component.business.oneconfig;

import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.ConfirmListener;
import com.didi.component.business.oneconfig.AbsConfirmConfigState;
import com.didi.component.business.secondconf.RideConfIntercepter;
import com.didi.component.business.secondconf.RideConfRepository;
import com.didi.component.business.secondconf.RideConfRequest;
import com.didi.component.business.secondconf.model.RideConfBizModel;
import com.didi.component.business.secondconf.model.RideConfModel;
import com.didi.component.business.secondconf.model.RideConfRsp;
import com.didi.component.business.tracker.anycar.AnycarTrack;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.map.global.component.departure.model.DepartureAddress;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.HashSet;
import java.util.Map;

public class NewConfirmAddressConfigState extends AbsConfirmConfigState {

    /* renamed from: a */
    private final Logger f11325a = LoggerFactory.getLogger(getClass());

    /* renamed from: b */
    private RideConfIntercepter f11326b = new RideConfIntercepter();

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<DepartureAddress> f11327c = new BaseEventPublisher.OnEventListener<DepartureAddress>() {
        public void onEvent(String str, DepartureAddress departureAddress) {
            if (departureAddress != null) {
                NewConfirmAddressConfigState.this.dispatchInterceptStartAddress(departureAddress.getAddress());
            }
        }
    };
    protected boolean mPreCityOpen = true;

    public NewConfirmAddressConfigState(BusinessContext businessContext, AbsConfirmConfigState.IConfirmConfigCallback iConfirmConfigCallback) {
        super(businessContext, iConfirmConfigCallback);
    }

    public void subscribeConfig() {
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.f11327c);
    }

    public void unsubscribeConfig() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Confirm.EVENT_TO_FORM_DEPARTURE_LOAD_SUCCESS, this.f11327c);
    }

    public boolean dispatchInterceptStartAddress(Address address) {
        if (!this.f11326b.interceptAddress(address)) {
            return false;
        }
        getMisConfigFromNet(address);
        return true;
    }

    /* access modifiers changed from: protected */
    public void getMisConfigFromNet(final Address address) {
        if (this.mConfigCallback != null) {
            this.mConfigCallback.onNetStart();
        }
        new RideConfRequest((RideConfRepository) null).requestWithOutSave(address.longitude, address.latitude, new RpcService.Callback<RideConfRsp>() {
            public void onSuccess(RideConfRsp rideConfRsp) {
                if (rideConfRsp != null && rideConfRsp.getErrno() == 0 && rideConfRsp.getData() != null) {
                    if (NewConfirmAddressConfigState.this.mConfigCallback != null) {
                        NewConfirmAddressConfigState.this.mConfigCallback.onNetSuccess();
                    }
                    if (NewConfirmAddressConfigState.this.m7642a(rideConfRsp)) {
                        NewConfirmAddressConfigState.this.doCityOpen(address);
                    } else {
                        NewConfirmAddressConfigState.this.doCityNotOpen(address);
                    }
                } else if (NewConfirmAddressConfigState.this.mConfigCallback != null) {
                    NewConfirmAddressConfigState.this.mConfigCallback.onNetFail();
                }
            }

            public void onFailure(IOException iOException) {
                if (NewConfirmAddressConfigState.this.mConfigCallback != null) {
                    NewConfirmAddressConfigState.this.mConfigCallback.onNetFail();
                }
            }
        });
    }

    public void reGetMisConfigFromNet() {
        getMisConfigFromNet(FormStore.getInstance().getDepartureAddress());
    }

    /* access modifiers changed from: protected */
    public void doCityOpen(Address address) {
        if (!this.mPreCityOpen) {
            Logger logger = this.f11325a;
            logger.info("doCityOpen  >>> startAddress: " + address, new Object[0]);
            BaseEventPublisher.getPublisher().publish("event_confirm_boarding_enable_city", address);
            this.mPreCityOpen = true;
        }
    }

    /* access modifiers changed from: protected */
    public void doCityNotOpen(Address address) {
        if (this.mPreCityOpen) {
            Logger logger = this.f11325a;
            logger.info("doCityNotOpen  >>> startAddress: " + address, new Object[0]);
            BaseEventPublisher.getPublisher().publish(BaseEventKeys.Confirm.EVENT_CONFIRM_BOARDING_UNENABLE_CITY, address);
            this.mPreCityOpen = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m7642a(RideConfRsp rideConfRsp) {
        ConfirmListener confirmListener = PageCompDataTransfer.getInstance().getConfirmListener();
        if (confirmListener == null || !confirmListener.getIsAnyCar()) {
            RideConfModel data = rideConfRsp.getData();
            if (!(data == null || data.getSecondaryMenu() == null || data.getSecondaryMenu().size() <= 0)) {
                int carLevel = FormStore.getInstance().getCarLevel();
                for (RideConfBizModel carLevel2 : data.getSecondaryMenu()) {
                    if (carLevel == carLevel2.getCarLevel()) {
                        return true;
                    }
                }
            }
            return false;
        }
        RideConfModel data2 = rideConfRsp.getData();
        if (data2 == null || data2.getSecondaryMenu() == null || data2.getSecondaryMenu().size() <= 0) {
            XEngineReq.pageRequest(XERequestKey.SCENE_CONFIRM_ADDRESS);
            AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneConfirmNewSheet, (Map<String, Object>) null);
            return false;
        }
        HashSet hashSet = new HashSet();
        for (RideConfBizModel carLevel3 : data2.getSecondaryMenu()) {
            hashSet.add(Integer.valueOf(carLevel3.getCarLevel()));
        }
        AnyCarEstimateItemModel selectedSingleAnyCarItem = confirmListener.getSelectedSingleAnyCarItem();
        if (selectedSingleAnyCarItem == null || selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig == null || !hashSet.add(Integer.valueOf(selectedSingleAnyCarItem.mAnyCarEstimateNetItem.carConfig.carLevel))) {
            for (AnyCarEstimateItemModel next : confirmListener.getSelectedAnyCarItems()) {
                if (next != null && next.mAnyCarEstimateNetItem.carConfig != null && hashSet.add(Integer.valueOf(next.mAnyCarEstimateNetItem.carConfig.carLevel))) {
                    XEngineReq.pageRequest(XERequestKey.SCENE_CONFIRM_ADDRESS);
                    AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneConfirmNewSheet, (Map<String, Object>) null);
                    return false;
                }
            }
            return true;
        }
        XEngineReq.pageRequest(XERequestKey.SCENE_CONFIRM_ADDRESS);
        AnycarTrack.anycarMonitorTrack(AnycarTrack.mSceneConfirmNewSheet, (Map<String, Object>) null);
        return false;
    }
}

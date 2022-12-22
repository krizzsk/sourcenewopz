package com.didi.component.matchtogo20.wait.presenter;

import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.data.form.PageCompDataTransfer;
import com.didi.component.business.data.form.listener.TripListener;
import com.didi.component.business.xengine.XERequestKey;
import com.didi.component.business.xengine.XEngineReq;
import com.didi.component.business.xpanelnew.IXpCardBindDataReady;
import com.didi.component.business.xpanelnew.IXpCardBindDataReadyCallback;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.matchtogo20.wait.AbsMTGWaitAcceptPresenter;
import com.didi.component.matchtogo20.wait.model.WaitAcceptModel;
import com.didi.component.matchtogo20.wait.view.IMTGWaitAcceptView;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didi.travel.psnger.model.event.UpdateWaitTimeEvent;
import com.didi.travel.psnger.model.response.anycar.AnyCarEstimateItemModel;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.didi.xengine.register.XERegister;
import com.didiglobal.enginecore.callback.XEReqParamsCallback;
import com.didiglobal.enginecore.callback.XEResponseCallback;
import com.didiglobal.enginecore.component.XEComponent;
import com.didiglobal.enginecore.data.exception.EngineErrorException;
import com.didiglobal.enginecore.data.model.XEngineData;
import com.didiglobal.enginecore.register.XERegisterModel;
import java.util.HashMap;
import java.util.List;
import org.json.JSONObject;

public class MTGWaitAcceptPresenter extends AbsMTGWaitAcceptPresenter implements IXpCardBindDataReady {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public long f14562a = 0;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public boolean f14563b = false;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public int f14564c = 0;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public XEReqParamsCallback f14565d = new XEReqParamsCallback() {
        public JSONObject getRequestParams() {
            HashMap hashMap = new HashMap();
            hashMap.put("caller_stage", Integer.valueOf(MTGWaitAcceptPresenter.this.f14564c));
            TripListener tripListener = PageCompDataTransfer.getInstance().getTripListener();
            if (tripListener == null || tripListener.getSelectedSingleAnyCarItem() == null) {
                EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
                if (newEstimateItem != null) {
                    hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, newEstimateItem.estimateId);
                }
            } else {
                AnyCarEstimateItemModel selectedSingleAnyCarItem = tripListener.getSelectedSingleAnyCarItem();
                if (selectedSingleAnyCarItem != null) {
                    hashMap.put(ParamKeys.PARAM_ESTIMATE_ID, selectedSingleAnyCarItem.estimateId);
                }
            }
            return new JSONObject(hashMap);
        }
    };

    /* renamed from: e */
    private XEResponseCallback f14566e = new XEResponseCallback() {
        public void onFailed(String str, EngineErrorException engineErrorException) {
        }

        public void onSuccess(String str, XEngineData xEngineData, List<XEComponent> list) {
            for (XEComponent next : list) {
                if (XERequestKey.REQUEST_KEY_MATCH_TOGO.equals(next.getId())) {
                    WaitAcceptModel waitAcceptModel = new WaitAcceptModel();
                    waitAcceptModel.parse(next.getData().toString());
                    if (waitAcceptModel.isHasContent()) {
                        long unused = MTGWaitAcceptPresenter.this.f14562a = waitAcceptModel.call_match_on_trip_time;
                        ((IMTGWaitAcceptView) MTGWaitAcceptPresenter.this.mView).setWaitAccept(waitAcceptModel);
                        MTGWaitAcceptPresenter.this.addViewToXpanel();
                    }
                }
            }
        }
    };

    /* renamed from: f */
    private final BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent> f14567f = new BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent>() {
        public void onEvent(String str, UpdateWaitTimeEvent updateWaitTimeEvent) {
            if (updateWaitTimeEvent != null) {
                ((IMTGWaitAcceptView) MTGWaitAcceptPresenter.this.mView).updateWaitTime(updateWaitTimeEvent.intWaitTime);
                long currentTimeMillis = System.currentTimeMillis() / 1000;
                if (MTGWaitAcceptPresenter.this.f14562a > 0 && currentTimeMillis > MTGWaitAcceptPresenter.this.f14562a && !MTGWaitAcceptPresenter.this.f14563b) {
                    boolean unused = MTGWaitAcceptPresenter.this.f14563b = true;
                    MTGWaitAcceptPresenter mTGWaitAcceptPresenter = MTGWaitAcceptPresenter.this;
                    mTGWaitAcceptPresenter.doPublish(BaseEventKeys.WaitRsp.EVENT_MTG_MATCH_ON_TRIP_PANEL, Long.valueOf(mTGWaitAcceptPresenter.f14562a));
                }
            }
        }
    };

    /* renamed from: g */
    private final BaseEventPublisher.OnEventListener<String> f14568g = new BaseEventPublisher.OnEventListener<String>() {
        public void onEvent(String str, String str2) {
            int unused = MTGWaitAcceptPresenter.this.f14564c = 1;
            XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_MATCH_TOGO, XERequestKey.SCENE_TRIP, (XEResponseCallback) null);
            xERegisterModel.requestParams = MTGWaitAcceptPresenter.this.f14565d;
            XERegister.registerTemplate(xERegisterModel);
            MTGWaitAcceptPresenter.this.m10352b();
        }
    };

    public MTGWaitAcceptPresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        subscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f14567f);
        subscribe(BaseEventKeys.WaitRsp.EVENT_MTG_WAIT_ACCEPT_PANEL, this.f14568g);
        XERegister.registerCallback(XERequestKey.REQUEST_KEY_XPANEL, this.f14566e);
        XERegisterModel xERegisterModel = new XERegisterModel(XERequestKey.REQUEST_KEY_MATCH_TOGO, XERequestKey.SCENE_TRIP, (XEResponseCallback) null);
        xERegisterModel.requestParams = this.f14565d;
        XERegister.registerTemplate(xERegisterModel);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f14563b = false;
        unsubscribe(BaseEventKeys.WaitRsp.EVENT_MTG_WAIT_ACCEPT_PANEL, this.f14568g);
        unsubscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f14567f);
        XERegister.unregisterTemplate(XERequestKey.REQUEST_KEY_MATCH_TOGO);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m10352b() {
        XEngineReq.pageRequest(XERequestKey.SCENE_TRIP);
    }

    public void viewBindBizDataReady(IXpCardBindDataReadyCallback iXpCardBindDataReadyCallback) {
        this.mXpanelController = iXpCardBindDataReadyCallback;
    }
}

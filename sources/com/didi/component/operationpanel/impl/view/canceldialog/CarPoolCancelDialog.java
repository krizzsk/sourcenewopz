package com.didi.component.operationpanel.impl.view.canceldialog;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.event.WaitRspCancelEvent;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.common.util.LocationController;
import com.didi.component.common.util.SearchIdUploadManager;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.global.loading.Loading;
import com.didi.global.loading.LoadingRenderType;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.view.SimplePopupBase;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.model.event.UpdateWaitTimeEvent;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class CarPoolCancelDialog extends SimplePopupBase implements View.OnClickListener {
    public static final String KEY_SUB_TITLE = "key_sub_title";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public int f14829a = 0;

    /* renamed from: b */
    private View f14830b;

    /* renamed from: c */
    private String f14831c = "";

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent> f14832d = new BaseEventPublisher.OnEventListener<UpdateWaitTimeEvent>() {
        public void onEvent(String str, UpdateWaitTimeEvent updateWaitTimeEvent) {
            if (updateWaitTimeEvent != null) {
                int unused = CarPoolCancelDialog.this.f14829a = updateWaitTimeEvent.intWaitTime;
            }
        }
    };

    /* renamed from: e */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14833e = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (CarPoolCancelDialog.this.isAdded() && !CarPoolCancelDialog.this.isDetached() && !CarPoolCancelDialog.this.isRemoving()) {
                CarPoolCancelDialog.this.dismissAllowingStateLoss();
            }
        }
    };

    /* renamed from: f */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14834f = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            if (CarPoolCancelDialog.this.isAdded() && !CarPoolCancelDialog.this.isDetached() && !CarPoolCancelDialog.this.isRemoving()) {
                CarPoolCancelDialog.this.dismissAllowingStateLoss();
            }
        }
    };

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.global_carpool_waitrsp_cancel_dialog;
    }

    public void setArguments(Bundle bundle) {
        super.setArguments(bundle);
        if (bundle != null) {
            this.f14831c = bundle.getString("key_sub_title", "");
        }
    }

    public void onAttach(Context context) {
        super.onAttach(context);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f14832d);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE, this.f14834f);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.WaitRsp.EVENT_CANCEL_ORDER_FINISH, this.f14833e);
    }

    public void onDetach() {
        super.onDetach();
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.Map.EVENT_MAP_UPDATE_WAIT_TIME, this.f14832d);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_WAITRSP_LEAVE_PAGE, this.f14834f);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.WaitRsp.EVENT_CANCEL_ORDER_FINISH, this.f14833e);
    }

    /* access modifiers changed from: protected */
    public void initView() {
        TextView textView = (TextView) this.mRootView.findViewById(R.id.tv_carpool_dialog_tips);
        int globalCarPoolWaitRspCancelDialogFlag = GlobalApolloUtil.getGlobalCarPoolWaitRspCancelDialogFlag();
        String str = !TextUtils.isEmpty(this.f14831c) ? this.f14831c : "";
        if (globalCarPoolWaitRspCancelDialogFlag == 0) {
            str = getString(R.string.global_carpool_waitrsp_cancel_dialog_tips1);
        } else if (globalCarPoolWaitRspCancelDialogFlag == 1) {
            str = getString(R.string.global_carpool_waitrsp_cancel_dialog_tips2, "90%", 1);
        } else if (globalCarPoolWaitRspCancelDialogFlag == 2) {
            str = getString(R.string.global_carpool_waitrsp_cancel_dialog_tips3);
        }
        textView.setText(HighlightUtil.highlight(getContext(), str));
        this.mRootView.findViewById(R.id.btn_carpool_no).setOnClickListener(this);
        this.mRootView.findViewById(R.id.btn_carpool_cancel).setOnClickListener(this);
        this.f14830b = this.mRootView.findViewById(R.id.view_cancel_intercept_fallback);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (isAdded() && !isDetached() && !isRemoving()) {
            if (view.getId() == R.id.btn_carpool_no) {
                m10618a("gp_carpoolCancel_wait_ck");
                dismissAllowingStateLoss();
            } else if (view.getId() == R.id.btn_carpool_cancel) {
                m10617a();
            }
        }
    }

    /* renamed from: a */
    private void m10617a() {
        Loading.make(getContext(), LoadingRenderType.ANIMATION, this.f14830b, true, 48).show();
        BaseEventPublisher.getPublisher().publish(BaseEventKeys.Service.CancelOrder.EVENT_REQUEST_ACTION_CANCEL_ORDER, new WaitRspCancelEvent(true));
        m10618a("gp_carpoolCancel_cancel_ck");
    }

    /* renamed from: a */
    private void m10618a(String str) {
        HashMap hashMap = new HashMap();
        hashMap.put("bubble_id", SearchIdUploadManager.getInstance().getBubbleId());
        hashMap.put(ParamConst.PARAM_WAIT_TIME, Integer.valueOf(this.f14829a));
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Address address = order.startAddress;
            if (address != null) {
                hashMap.put("lng", Double.valueOf(address.longitude));
                hashMap.put("lat", Double.valueOf(address.latitude));
            }
            DIDILocation lastKnownLocation = LocationController.getInstance().getLastKnownLocation(getContext());
            if (lastKnownLocation != null) {
                hashMap.put("poi_lng", Double.valueOf(lastKnownLocation.getLongitude()));
                hashMap.put("poi_lat", Double.valueOf(lastKnownLocation.getLatitude()));
            }
        }
        GlobalOmegaUtils.trackEvent(str, (Map<String, Object>) hashMap);
    }
}

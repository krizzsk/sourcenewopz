package com.didi.component.imentrance.impl;

import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.OnlineHelpUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.imentrance.AbsIMEntrancePresenter;
import com.didi.component.imentrance.IIMEntranceView;
import com.didi.component.imentrance.model.DriverOptionData;
import com.didi.component.imentrance.model.IMInfo;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.view.dialog.AlertController;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class IMEntranceV2Presenter extends AbsIMEntrancePresenter {

    /* renamed from: b */
    private static final int f14147b = 200;

    /* renamed from: a */
    private BusinessContext f14148a;

    /* renamed from: c */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14149c = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ((IIMEntranceView) IMEntranceV2Presenter.this.mView).nearPickupShow();
        }
    };

    /* renamed from: d */
    private BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent> f14150d = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            IMEntranceV2Presenter.this.closeIMActivity();
        }
    };

    public IMEntranceV2Presenter(ComponentParams componentParams) {
        super(componentParams);
        this.f14148a = componentParams.bizCtx;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        if (this.mIMoption == null) {
            ((IIMEntranceView) this.mView).getView().setVisibility(4);
            return;
        }
        if (this.mIMoption.clickable == 1) {
            m9897a(this.mIMoption.data);
            ((IIMEntranceView) this.mView).show();
            ((IIMEntranceView) this.mView).setData(this.mIMoption);
        } else {
            ((IIMEntranceView) this.mView).hide();
        }
        subscribe(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK_SWITCH, this.f14149c);
        subscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_CLOSE_IM, this.f14150d);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        unsubscribe(BaseEventKeys.WaitRspNew.EVENT_DRIVER_CARD_NEAR_PICK_SWITCH, this.f14149c);
        unsubscribe(BaseEventKeys.BlueTooth.EVENT_BLUETOOTH_MEET_CLOSE_IM, this.f14150d);
    }

    public void notifyShowMsgBubble(boolean z) {
        super.notifyShowMsgBubble(z);
        doPublish(BaseEventKeys.C4621IM.EVENT_IM_MESSAGE_BUBBLE_SHOW, Boolean.valueOf(z));
    }

    /* renamed from: a */
    private void m9897a(DriverOptionData driverOptionData) {
        if (driverOptionData != null) {
            IMInfo iMInfo = new IMInfo();
            iMInfo.bid = driverOptionData.businessId;
            if (driverOptionData.imBusinessId > 0) {
                iMInfo.bid = driverOptionData.imBusinessId;
            }
            iMInfo.cid = String.valueOf(driverOptionData.area);
            iMInfo.oid = driverOptionData.oid;
            if (!TextUtil.isEmpty(driverOptionData.driverId)) {
                iMInfo.uid = TextUtil.paseLong(driverOptionData.driverId);
            }
            iMInfo.driverName = driverOptionData.name;
            iMInfo.driverPhoto = driverOptionData.avatar;
            iMInfo.secretString = driverOptionData.imKey;
            GLog.m7964d("imModel.uid : " + iMInfo.uid);
            bind(iMInfo);
            if (driverOptionData.isAvailableMsg == 0) {
                closeSession();
            }
        }
    }

    public void onIMEntranceClick() {
        if (this.mIMoption.data != null) {
            m9899b(this.mIMoption.data);
            if (this.mIMoption.action == 3) {
                NormalDialogInfo normalDialogInfo = new NormalDialogInfo(200);
                normalDialogInfo.setIcon(AlertController.IconType.INFO);
                normalDialogInfo.setTitle(this.mContext.getString(R.string.global_im_dialog_title));
                normalDialogInfo.setMessage(this.mContext.getString(R.string.global_im_dialog_content));
                normalDialogInfo.setPositiveText(this.mContext.getString(R.string.global_im_dialog_pos_text));
                normalDialogInfo.setNegativeText(this.mContext.getString(R.string.cancel));
                normalDialogInfo.setNeutralText(this.mContext.getString(R.string.global_im_dialog_neutral_text));
                normalDialogInfo.setCancelable(true);
                GlobalOmegaUtils.trackEvent("gd_endsIM_popup_sw");
                showDialog(normalDialogInfo);
                return;
            }
            startIMActivity();
        }
    }

    /* renamed from: b */
    private void m9899b(DriverOptionData driverOptionData) {
        if (driverOptionData != null) {
            int i = 0;
            if (this.mView instanceof IMEntranceV2FarView) {
                i = 2;
            }
            if (this.mView instanceof IMEntranceV2NearView) {
                i = 1;
            }
            HashMap hashMap = new HashMap();
            hashMap.put("unread", Integer.valueOf(getUnreadCount()));
            if (i > 0) {
                hashMap.put("type", String.valueOf(i));
            }
            GlobalOmegaUtils.trackEvent("pas_drivercard_im_ck", (Map<String, Object>) hashMap);
        }
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        if (i == 200) {
            dismissDialog(200);
            if (i2 == 2) {
                GlobalOmegaUtils.trackEvent("gd_endsIMhelp_btn_ck");
                if (!TextUtils.isEmpty(this.mIMoption.scheme)) {
                    OnlineHelpUtil.startOnServiceHelp(this.mContext, this.mIMoption.scheme);
                } else {
                    OnlineHelpUtil.startOnServiceHelp(this.mContext);
                }
            } else if (i2 == 3) {
                GlobalOmegaUtils.trackEvent("gd_endsIMsh_btn_ck");
                startIMActivity();
            } else if (i2 == 1) {
                GlobalOmegaUtils.trackEvent("gd_endsIMcancel_btn_ck");
            }
        }
    }
}

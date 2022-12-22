package com.didi.component.openride;

import android.app.Activity;
import android.os.Bundle;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.GlobalSPUtil;
import com.didi.component.core.ComponentParams;
import com.didi.component.openride.newscan.GlobalQRScanActivity;
import com.didi.component.openride.widget.OpenRideIntroPopWin;

public class NewOpenRidePresenter extends AbsNewOpenRidePresenter {
    public NewOpenRidePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
    }

    public void onOpenRideEntranceClick() {
        FormStore.getInstance().setIsFromOpenRide(true);
        if (FormStore.getInstance().getOpenRideHasOnlinePayAbility()) {
            if (GlobalSPUtil.isClickedOpenRide(this.mContext)) {
                startActivity(GlobalQRScanActivity.getIntent(this.mContext));
                ((Activity) this.mContext).overridePendingTransition(0, 0);
            } else if (getParent() != null && getParent().getView() != null && getParent().getView().getView() != null) {
                GlobalSPUtil.setClickedOpenRide(this.mContext);
                OpenRideIntroPopWin openRideIntroPopWin = new OpenRideIntroPopWin(this.mContext, getParent().getView().getView(), 1);
                openRideIntroPopWin.setOnClickListener(new OpenRideIntroPopWin.OnBtnClickListener() {
                    public void btnClick() {
                        NewOpenRidePresenter newOpenRidePresenter = NewOpenRidePresenter.this;
                        newOpenRidePresenter.startActivity(GlobalQRScanActivity.getIntent(newOpenRidePresenter.mContext));
                    }

                    public void closeBtnClick() {
                        FormStore.getInstance().setIsFromOpenRide(false);
                    }
                });
                openRideIntroPopWin.show();
            } else {
                return;
            }
        } else if (getParent() != null && getParent().getView() != null && getParent().getView().getView() != null) {
            GlobalSPUtil.setClickedOpenRide(this.mContext);
            OpenRideIntroPopWin openRideIntroPopWin2 = new OpenRideIntroPopWin(this.mContext, getParent().getView().getView(), 2);
            openRideIntroPopWin2.setOnClickListener(new OpenRideIntroPopWin.OnBtnClickListener() {
                public void btnClick() {
                    NewOpenRidePresenter.this.addOnlineCreditCard();
                }

                public void closeBtnClick() {
                    FormStore.getInstance().setIsFromOpenRide(false);
                }
            });
            openRideIntroPopWin2.show();
        } else {
            return;
        }
        GlobalOmegaUtils.trackEvent("ibt_gp_home_fastboarding_ck");
    }

    /* access modifiers changed from: protected */
    public void onBackHome(Bundle bundle) {
        super.onBackHome(bundle);
        subscribe(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, this.mDeepLinkReceiver);
    }

    /* access modifiers changed from: protected */
    public void onLeaveHome() {
        super.onLeaveHome();
        unsubscribe(BaseEventKeys.OpenRide.EVENT_HAND_OPEN_RIDE_DEEP_LINK, this.mDeepLinkReceiver);
    }
}

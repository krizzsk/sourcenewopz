package com.didi.component.driverbar.impl;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.core.IViewContainer;
import com.didi.component.driverbar.AbsDriverBarPresenter;
import com.didi.component.driverbar.IDriverBarView;
import com.didi.component.driverbar.model.DriverBarCardInfo;
import com.didi.component.driverbar.model.DriverBarStyle;
import com.didi.component.driverbar.model.DriverBarV2Model;
import com.didi.map.global.flow.model.EtaEda;
import com.didiglobal.travel.util.Preconditions;
import com.taxis99.R;
import kotlin.Pair;

public abstract class DriverBarFieldBase implements IViewContainer, IDriverBarView {
    protected String driverProfileUrl;
    protected View mContainerView;
    protected Context mContext;
    protected ViewGroup mIMContainer = ((ViewGroup) findView(R.id.driver_card_im_container));
    protected ViewGroup mPhoneContainer = ((ViewGroup) findView(R.id.driver_card_phone_container));
    protected AbsDriverBarPresenter mPresenter;

    public void handleBluetoothMeetEntranceShow(Boolean bool) {
    }

    public void hideBlueMeetGuide() {
    }

    public void hideCarUpdateInfo() {
    }

    /* access modifiers changed from: protected */
    public abstract void inflateView(Context context, ViewGroup viewGroup);

    public boolean isPhoneVisible() {
        return false;
    }

    public void nearPickupShow(EtaEda etaEda) {
    }

    public void newMessageBubbleShow(boolean z) {
    }

    public void setDriverBarStyle(DriverBarStyle driverBarStyle) {
    }

    public void setPhoneVisible(boolean z) {
    }

    public void showCarUpdateInfo(String str, String str2, String str3, String str4) {
    }

    public void showPhoneGuide(String str) {
    }

    public DriverBarFieldBase(Context context, ViewGroup viewGroup) {
        inflateView(context, viewGroup);
        this.mContext = context;
    }

    /* access modifiers changed from: protected */
    public <T extends View> T findView(int i) {
        return this.mContainerView.findViewById(i);
    }

    public void setData(DriverBarV2Model driverBarV2Model) {
        this.driverProfileUrl = Preconditions.nonNull(driverBarV2Model) ? driverBarV2Model.driverHomeUrl : "";
    }

    public void setData(DriverBarCardInfo driverBarCardInfo) {
        this.driverProfileUrl = driverBarCardInfo.getDriverProfileUrl();
    }

    public ViewGroup getContainer(int i) {
        if (i == 1) {
            return this.mIMContainer;
        }
        if (i == 2) {
            return this.mPhoneContainer;
        }
        return null;
    }

    public View getView() {
        return this.mContainerView;
    }

    public void setPresenter(AbsDriverBarPresenter absDriverBarPresenter) {
        this.mPresenter = absDriverBarPresenter;
    }

    public void setComponentCreator(IViewContainer.IComponentCreator iComponentCreator) {
        this.mPresenter.setComponentCreator(iComponentCreator);
    }

    /* access modifiers changed from: protected */
    public void dispatchDriverClicked(Pair<String, String> pair) {
        if (Preconditions.isNull(pair)) {
            GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_drivername_ck");
        } else {
            GlobalOmegaUtils.trackEvent("ibt_gp_tripservice_drivername_ck", pair.getFirst(), pair.getSecond());
        }
        if (!TextUtils.isEmpty(this.driverProfileUrl) && Preconditions.nonNull(this.mPresenter)) {
            this.mPresenter.onDriverHeaderClick(this.driverProfileUrl);
        }
    }
}

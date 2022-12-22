package com.didi.component.business.deeplink;

import android.os.Bundle;
import com.didi.component.business.constant.BaseConstants;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.business.event.DeepLinkEvent;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.dialog.LoadingDialogInfo;
import com.didi.component.common.dialog.NormalDialogInfo;
import com.didi.component.common.loading.AbsLoadingPresenterGroup;
import com.didi.component.common.net.CarRequest;
import com.didi.component.core.IGroupView;
import com.didi.component.core.IPresenter;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.p170v2.TravelConstant;
import com.didi.travel.psnger.p170v2.TravelUtil;
import com.taxis99.R;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

public class DeeplinkDispatcherFragmentPresenter extends AbsLoadingPresenterGroup<IDeeplinkDispatcherFragmentView> {

    /* renamed from: a */
    private static final int f11293a = 100;

    /* renamed from: b */
    private static final int f11294b = 101;

    /* renamed from: c */
    private BusinessContext f11295c;

    /* renamed from: d */
    private DeepLinkEvent f11296d;

    public DeeplinkDispatcherFragmentPresenter(BusinessContext businessContext, Bundle bundle) {
        super(businessContext.getContext(), bundle);
        this.f11295c = businessContext;
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        DeepLinkEvent deepLinkEvent;
        super.onAdd(bundle);
        EventBus.getDefault().unregister(this);
        if (bundle != null && (deepLinkEvent = (DeepLinkEvent) bundle.getSerializable("deeplink_context")) != null && deepLinkEvent.mPickUpAddr != null) {
            this.f11296d = deepLinkEvent;
            EventBus.getDefault().register(this);
            m7619b();
            CarRequest.getMisConfigFromNet(deepLinkEvent.mPickUpAddr.getLatitude(), deepLinkEvent.mPickUpAddr.getLongitude(), deepLinkEvent.mPickUpAddr.getCityId());
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        if (carInfoUpdateEvent != null && EventKeys.MisConfig.CAR_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
            dismissDialog(100);
            if (carInfoUpdateEvent.result == 1) {
                if (this.f11296d != null) {
                    EventBus.getDefault().unregister(this);
                    FormStore instance = FormStore.getInstance();
                    instance.setStartAddress(this.f11296d.mPickUpAddr, false);
                    instance.setEndAddress(this.f11296d.mDropOffAddr);
                    if (this.f11296d.mBid != -1) {
                        instance.Bid = this.f11296d.mBid;
                    }
                    instance.setCarLevel(this.f11296d.mCarLevel);
                    instance.setTransportTime((long) this.f11296d.mTransportTime);
                    Bundle bundle = new Bundle();
                    bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
                    bundle.putInt(BaseConstants.ConfirmPageExtraKeys.DEFAULT_SELECT_BIZ_INT, this.f11296d.mBid);
                    bundle.putString("page_source", BaseConstants.ConfirmPageExtraKeys.PAGE_SOURCE_DEEPLINK);
                    forward(1030, TravelUtil.getBundleOnCreateSession(bundle, true, TravelConstant.SESSION_TAG_DEEP_LINK, false));
                }
            } else if (this.f11296d != null) {
                GlobalOmegaUtils.trackEvent("pas_onconffailure_sw");
                m7620c();
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        this.f11296d = null;
        EventBus.getDefault().unregister(this);
    }

    public boolean onBackPressed(IPresenter.BackType backType) {
        goBackRoot();
        return true;
    }

    /* renamed from: b */
    private void m7619b() {
        LoadingDialogInfo loadingDialogInfo = new LoadingDialogInfo(100);
        loadingDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.loading));
        loadingDialogInfo.setCancelable(false);
        showDialog(loadingDialogInfo);
    }

    /* renamed from: c */
    private void m7620c() {
        NormalDialogInfo normalDialogInfo = new NormalDialogInfo(101);
        normalDialogInfo.setMessage(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail));
        normalDialogInfo.setPositiveText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_retry));
        normalDialogInfo.setNegativeText(ResourcesHelper.getString(this.mContext, R.string.g_oneconf_fail_back));
        normalDialogInfo.setCancelable(false);
        showDialog(normalDialogInfo);
    }

    /* access modifiers changed from: protected */
    public void onDialogAction(int i, int i2) {
        super.onDialogAction(i, i2);
        if (i == 101) {
            if (i2 == 1) {
                goBack();
            } else if (i2 == 2 && this.f11296d != null) {
                m7619b();
                CarRequest.getMisConfigFromNet(this.f11296d.mPickUpAddr.getLatitude(), this.f11296d.mPickUpAddr.getLongitude(), this.f11296d.mPickUpAddr.getCityId());
            }
        }
    }
}

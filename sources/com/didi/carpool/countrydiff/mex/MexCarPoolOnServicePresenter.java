package com.didi.carpool.countrydiff.mex;

import android.content.Intent;
import android.os.Bundle;
import com.didi.carpool.onservice.CarPoolOnServicePresenter;
import com.didi.component.business.constant.BaseExtras;
import com.didi.component.business.constant.WebUrlConstants;
import com.didi.component.business.util.BusinessDataUtil;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IGroupView;
import com.didi.component.payentrance.utils.TextUtil;
import com.didi.component.service.activity.CancelTripConfirmWebActivity;
import com.didi.sdk.app.INavigation;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.store.DDTravelConfigStore;

public class MexCarPoolOnServicePresenter extends CarPoolOnServicePresenter {
    public MexCarPoolOnServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void startCancelTrip(boolean z) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.url = GlobalWebUrl.buildUrl(m7287b(), createURLParams());
        if (!TextUtil.isEmpty(webViewModel.url)) {
            Intent intent = new Intent(this.mContext, CancelTripConfirmWebActivity.class);
            webViewModel.isPostBaseParams = false;
            webViewModel.isSupportCache = false;
            intent.putExtra("web_view_model", webViewModel);
            intent.putExtra(CancelTripConfirmWebActivity.KEY_IS_FROM_DASH_CAM, z);
            startActivityForResult(intent, 100, (Bundle) null);
        }
    }

    /* renamed from: b */
    private String m7287b() {
        String cancelTripURL = DDTravelConfigStore.getInstance().getCancelTripURL();
        return TextUtil.isEmpty(cancelTripURL) ? WebUrlConstants.CANCEL_TRIP : cancelTripURL;
    }

    /* access modifiers changed from: protected */
    public void forwardCancelServicePage(boolean z) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            Bundle bundle = new Bundle();
            bundle.putBoolean(INavigation.BUNDLE_KEY_MAP_NEED, true);
            bundle.putBoolean(BaseExtras.EndService.EXTRA_SHOW_ORDER_CANCEL, true);
            if (BusinessDataUtil.isOrderHasCancelFee(order)) {
                bundle.putInt(BaseExtras.EndService.EXTRA_FIRST_VIEW, 2);
            }
            bundle.putBoolean(IGroupView.BACK_VISIBILITY, true);
            forwardNew(1015, bundle);
        }
    }
}

package com.didiglobal.passenger.brz.component;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.widget.loading.TopupLoadingBar;
import com.didi.component.core.ComponentParams;
import com.didi.component.service.ConfirmServicePresenter;
import com.didi.component.service.util.SendOrderTipDialogHelper;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.payment.wallet.global.model.WalletPageModel;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;

public class BrzConfirmServicePresenter extends ConfirmServicePresenter {
    public static final int REQUEST_CODE_PAY_FOR_CANCEL_FEE_BRZ = 200;

    /* renamed from: b */
    private final long f50290b = 2592000;

    /* renamed from: c */
    private final Logger f50291c = LoggerFactory.getLogger(getClass());

    /* renamed from: d */
    private long f50292d = 0;

    /* renamed from: e */
    private boolean f50293e = false;

    /* renamed from: f */
    private GGKDrawer f50294f = null;

    /* renamed from: g */
    private WalletPageModel f50295g;

    /* renamed from: h */
    private TopupLoadingBar f50296h;

    public BrzConfirmServicePresenter(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onAdd(Bundle bundle) {
        super.onAdd(bundle);
        this.f50296h = new TopupLoadingBar((Activity) this.mContext);
    }

    /* access modifiers changed from: protected */
    public void onRemove() {
        super.onRemove();
        TopupLoadingBar topupLoadingBar = this.f50296h;
        if (topupLoadingBar != null) {
            topupLoadingBar.hideInfoDialog();
        }
    }

    /* access modifiers changed from: protected */
    public void onOrderCreateFail(CarOrder carOrder) {
        if (carOrder == null) {
            this.f50291c.info("onOrderCreateFail  order == null", new Object[0]);
            SendOrderTipDialogHelper.showOrderFailDialog(this.mContext, getHost().getFragmentManager(), this.mContext.getString(R.string.car_get_order_info_failed));
            return;
        }
        super.onOrderCreateFail(carOrder);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 200 && i2 == -1 && intent != null) {
            int intExtra = intent.getIntExtra("code", 0);
            int intExtra2 = intent.getIntExtra("errCode", 0);
            String stringExtra = intent.getStringExtra("message");
            Logger logger = this.f50291c;
            logger.info("Pay for cancel fee result:code:" + intExtra + ",errorcode:" + intExtra2 + ",message:" + stringExtra, new Object[0]);
        }
    }

    /* access modifiers changed from: protected */
    public String getCustomFeaturesParam() {
        EstimateItemModel newEstimateItem;
        if (!FormStore.getInstance().isAccessibleCar() || (newEstimateItem = FormStore.getInstance().getNewEstimateItem()) == null || newEstimateItem.extraChoice == null || TextUtils.isEmpty(newEstimateItem.extraChoice.selectedValue)) {
            return super.getCustomFeaturesParam();
        }
        return FormStore.getInstance().getNewEstimateItem().extraChoice.selectedValue;
    }

    /* access modifiers changed from: protected */
    public void gotoConfirmAddress() {
        super.gotoConfirmAddress();
        this.f50292d = 0;
    }

    /* access modifiers changed from: protected */
    public void backConfirmPricePage() {
        super.backConfirmPricePage();
        this.f50293e = false;
        TopupLoadingBar topupLoadingBar = this.f50296h;
        if (topupLoadingBar != null) {
            topupLoadingBar.hideInfoDialog();
        }
    }
}

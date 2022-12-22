package com.didiglobal.passenger.rus.component.newui;

import android.content.Intent;
import android.text.TextUtils;
import com.didi.component.business.web.GlobalWebUrl;
import com.didi.component.core.ComponentParams;
import com.didi.component.operationpanel.OperationPanelItemModel;
import com.didi.component.operationpanel.impl.newui.presenter.GlobalOnTripOperationPanelPresenterV2;
import com.didi.component.operationpanel.impl.view.ReceiptReceiveEmailActivity;
import com.didi.sdk.webview.WebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didi.travel.psnger.model.response.CarOrder;

public class RusOnTripOperationPanelPresenterV2 extends GlobalOnTripOperationPanelPresenterV2 {
    public RusOnTripOperationPanelPresenterV2(ComponentParams componentParams) {
        super(componentParams);
    }

    /* access modifiers changed from: protected */
    public void onInvoice(CarOrder carOrder) {
        if (carOrder.invoiceInfo != null) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.isSupportCache = true;
            webViewModel.url = GlobalWebUrl.buildUrl(carOrder.invoiceInfo.invoicePageUrl, getUrlParams(carOrder, false));
            webViewModel.title = "Receipt";
            Intent intent = new Intent(this.mContext, ReceiptReceiveEmailActivity.class);
            intent.putExtra("web_view_model", webViewModel);
            this.mContext.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onInvoiceV2(OperationPanelItemModel operationPanelItemModel, CarOrder carOrder) {
        if (!TextUtils.isEmpty(operationPanelItemModel.url)) {
            WebViewModel webViewModel = new WebViewModel();
            webViewModel.isSupportCache = true;
            String str = operationPanelItemModel.url;
            webViewModel.title = operationPanelItemModel.title == null ? "Receipt" : operationPanelItemModel.title.getContent();
            if (str.startsWith("http") || str.startsWith("https")) {
                webViewModel.url = GlobalWebUrl.buildUrl(str, getUrlParams(carOrder, true));
                Intent intent = new Intent(this.mContext, WebActivity.class);
                intent.putExtra("web_view_model", webViewModel);
                this.mContext.startActivity(intent);
            } else if (carOrder.invoiceInfo != null) {
                webViewModel.url = GlobalWebUrl.buildUrl(carOrder.invoiceInfo.invoicePageUrl, getUrlParams(carOrder, false));
                Intent intent2 = new Intent(this.mContext, ReceiptReceiveEmailActivity.class);
                intent2.putExtra("web_view_model", webViewModel);
                this.mContext.startActivity(intent2);
            }
        }
    }
}

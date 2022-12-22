package com.didi.soda.order.component.evaluatedetail;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.ImageView;
import androidx.core.view.ViewCompat;
import com.didi.soda.customer.app.constant.Const;
import com.didi.soda.customer.base.pages.RoutePath;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.entity.order.OrderEvaluationEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.util.DialogUtil;
import com.didi.soda.order.component.evaluatedetail.Contract;
import com.didi.soda.router.DiRouter;
import com.taxis99.R;

public class OrderEvaluateDetailPresenter extends Contract.AbsOrderEvaluateDetailPresenter {

    /* renamed from: a */
    private String f43402a;

    public void closePage() {
        getScopeContext().getNavigator().finish();
    }

    public void retryRequest() {
        m30727a();
    }

    public void onImageItemClick(ImageView imageView, String str) {
        String valueOf = String.valueOf(System.currentTimeMillis());
        String string = imageView.getContext().getString(R.string.customer_transition_tag_evaluate_preview_image_named, new Object[]{valueOf});
        int width = imageView.getWidth();
        ViewCompat.setTransitionName(imageView, string);
        if (!TextUtils.isEmpty(str)) {
            DiRouter.request().path(RoutePath.EVALUATE_PREVIEW_IMAGE).putString(Const.PageParams.TRANSITION_NAMES, string).putString(Const.PageParams.PREVIEW_IMAGE_URL, str).putInt(Const.PageParams.PREVIEW_IMAGE_WIDTH, width).open();
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        super.onCreate();
        Bundle bundle = getScopeContext().getBundle();
        String string = bundle.getString("orderid");
        this.f43402a = string;
        if (TextUtils.isEmpty(string)) {
            this.f43402a = bundle.getString("orderId");
        }
        m30727a();
    }

    /* renamed from: a */
    private void m30727a() {
        if (!TextUtils.isEmpty(this.f43402a)) {
            ((Contract.AbsOrderEvaluateDetailView) getLogicView()).hideAbnormalView();
            DialogUtil.showLoadingDialog(getScopeContext(), false);
            CustomerRpcManagerProxy.get().getEvaluationInfo(this.f43402a, new CustomerRpcCallback<OrderEvaluationEntity>() {
                public void onRpcFailure(SFRpcException sFRpcException) {
                    super.onRpcFailure(sFRpcException);
                    DialogUtil.hideLoadingDialog();
                    ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).showErrorNetView(sFRpcException.getMessage());
                }

                public void onRpcSuccess(OrderEvaluationEntity orderEvaluationEntity, long j) {
                    DialogUtil.hideLoadingDialog();
                    if (orderEvaluationEntity == null) {
                        ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).showErrorNetView((String) null);
                    } else {
                        ((Contract.AbsOrderEvaluateDetailView) OrderEvaluateDetailPresenter.this.getLogicView()).initEvaluationView(orderEvaluationEntity);
                    }
                }
            });
        }
    }
}

package com.didi.entrega.pay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.entrega.pay.Contract;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.didi.entrega.pay.pospay.PosListPage;
import com.didi.entrega.pay.widget.PayMethodInfoView;
import com.taxis99.R;
import java.util.List;

public class PayMethodView extends Contract.AbsPayMethodView {

    /* renamed from: a */
    private PayMethodInfoView.PayMethodListener f21008a = new PayMethodInfoView.PayMethodListener() {
        public void onClickPosListener(PayMethodInfoModel payMethodInfoModel) {
            PosListPage.toPosListPage(PayMethodView.this.getScopeContext(), payMethodInfoModel);
        }

        public void onClickPayPay(PayMethodInfoModel payMethodInfoModel) {
            ((Contract.AbsPayMethodPresenter) PayMethodView.this.getPresenter()).onClickPayPay(payMethodInfoModel);
        }

        public void onClick99Pay(PayMethodInfoModel payMethodInfoModel, int i) {
            ((Contract.AbsPayMethodPresenter) PayMethodView.this.getPresenter()).onClick99Pay(payMethodInfoModel, i);
        }

        public void onClickCashPay(PayMethodInfoModel payMethodInfoModel) {
            ((Contract.AbsPayMethodPresenter) PayMethodView.this.getPresenter()).onClickCashPay(payMethodInfoModel);
        }

        public void onClickCardPay(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel) {
            ((Contract.AbsPayMethodPresenter) PayMethodView.this.getPresenter()).onClickCardPay(payMethodInfoModel, cardInfoModel);
        }

        public void onClickDidiPay(PayMethodInfoModel payMethodInfoModel) {
            ((Contract.AbsPayMethodPresenter) PayMethodView.this.getPresenter()).onClickDidiCashPay(payMethodInfoModel);
        }
    };
    @BindView(16334)
    View mBackView;
    @BindView(16350)
    LinearLayout mPayMethodInfoContainer;

    public void updateView(List<PayMethodInfoModel> list) {
        if (list != null && !list.isEmpty()) {
            this.mPayMethodInfoContainer.removeAllViews();
            for (PayMethodInfoModel a : list) {
                View a2 = m15372a(a);
                LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                layoutParams.bottomMargin = DisplayUtils.dip2px(getContext(), 10.0f);
                this.mPayMethodInfoContainer.addView(a2, layoutParams);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        ButterKnife.bind((Object) this, getView());
        super.onCreate();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PayMethodView.this.m15374a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15374a(View view) {
        getScopeContext().getNavigator().finish();
        ((Contract.AbsPayMethodPresenter) getPresenter()).onClose();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.entrega_component_paymethod_container, viewGroup);
    }

    /* renamed from: a */
    private View m15372a(PayMethodInfoModel payMethodInfoModel) {
        PayMethodInfoView payMethodInfoView = new PayMethodInfoView(getContext(), this.f21008a);
        payMethodInfoView.setPayMethodInfo(payMethodInfoModel);
        return payMethodInfoView;
    }
}

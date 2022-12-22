package com.didi.soda.pay;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import butterknife.BindView;
import butterknife.ButterKnife;
import com.didi.soda.pay.Contract;
import com.didi.soda.pay.model.PayMethodInfoModel;
import com.didi.soda.pay.pospay.PosListPage;
import com.didi.soda.pay.widget.PayMethodInfoView;
import com.taxis99.R;
import java.util.List;

public class PayMethodView extends Contract.AbsPayMethodView {

    /* renamed from: a */
    private PayMethodInfoView.PayMethodListener f43636a = new PayMethodInfoView.PayMethodListener() {
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
    @BindView(18382)
    View mBackView;
    @BindView(18547)
    LinearLayout mPayMethodInfoContainer;

    public void updateView(List<PayMethodInfoModel> list) {
        if (list != null && !list.isEmpty()) {
            this.mPayMethodInfoContainer.removeAllViews();
            for (PayMethodInfoModel payMethodInfo : list) {
                PayMethodInfoView payMethodInfoView = new PayMethodInfoView(getContext(), this.f43636a);
                this.mPayMethodInfoContainer.addView(payMethodInfoView, new LinearLayout.LayoutParams(-1, -2));
                payMethodInfoView.setPayMethodInfo(payMethodInfo);
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate() {
        ButterKnife.bind((Object) this, getView());
        super.onCreate();
        this.mBackView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PayMethodView.this.m30937a(view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30937a(View view) {
        getScopeContext().getNavigator().finish();
        ((Contract.AbsPayMethodPresenter) getPresenter()).onClose();
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        return layoutInflater.inflate(R.layout.customer_component_paymethod_container, viewGroup);
    }
}

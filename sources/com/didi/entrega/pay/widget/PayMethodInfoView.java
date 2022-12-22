package com.didi.entrega.pay.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import com.didi.entrega.pay.model.PayMethodInfoModel;
import com.taxis99.R;

public class PayMethodInfoView extends LinearLayout {
    public static final int PAY_99_AVAILABLE = 0;
    public static final int PAY_99_NOT_DISPLAY = -1;
    public static final int PAY_99_NOT_ENABLE = 2;
    public static final int PAY_99_NOT_ENOUGH = 1;

    /* renamed from: a */
    private PayMethodListener f21014a;

    public interface PayMethodListener {
        void onClick99Pay(PayMethodInfoModel payMethodInfoModel, int i);

        void onClickCardPay(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel);

        void onClickCashPay(PayMethodInfoModel payMethodInfoModel);

        void onClickDidiPay(PayMethodInfoModel payMethodInfoModel);

        void onClickPayPay(PayMethodInfoModel payMethodInfoModel);

        void onClickPosListener(PayMethodInfoModel payMethodInfoModel);
    }

    public PayMethodInfoView(Context context, PayMethodListener payMethodListener) {
        super(context);
        this.f21014a = payMethodListener;
        m15384a();
    }

    public void setPayMethodInfo(PayMethodInfoModel payMethodInfoModel) {
        if (TextUtils.equals(String.valueOf(153), payMethodInfoModel.mChannelId)) {
            setCashInfo(payMethodInfoModel);
        } else if (TextUtils.equals(String.valueOf(150), payMethodInfoModel.mChannelId)) {
            setCreditInfo(payMethodInfoModel);
        } else if (TextUtils.equals(String.valueOf(154), payMethodInfoModel.mChannelId)) {
            setPosPayInfo(payMethodInfoModel);
        } else if (TextUtils.equals(String.valueOf(190), payMethodInfoModel.mChannelId)) {
            set99PayInfo(payMethodInfoModel);
        } else if (TextUtils.equals(String.valueOf(182), payMethodInfoModel.mChannelId)) {
            setPayPayInfo(payMethodInfoModel);
        } else if (TextUtils.equals(String.valueOf(120), payMethodInfoModel.mChannelId)) {
            setDidiCashInfo(payMethodInfoModel);
        }
    }

    private void setDidiCashInfo(PayMethodInfoModel payMethodInfoModel) {
        DidiCashSubItemView didiCashSubItemView = new DidiCashSubItemView(getContext());
        didiCashSubItemView.setPayInfo(payMethodInfoModel);
        didiCashSubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
        didiCashSubItemView.mo62608a(this.f21014a);
        addView(didiCashSubItemView);
        didiCashSubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m15389c(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m15389c(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f21014a;
        if (payMethodListener != null) {
            payMethodListener.onClickDidiPay(payMethodInfoModel);
        }
    }

    private void setPosPayInfo(PayMethodInfoModel payMethodInfoModel) {
        PosSubItemView posSubItemView = new PosSubItemView(getContext());
        posSubItemView.setPosPayInfo(payMethodInfoModel);
        posSubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
        posSubItemView.mo62608a(this.f21014a);
        addView(posSubItemView);
        posSubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m15388b(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m15388b(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f21014a;
        if (payMethodListener != null) {
            payMethodListener.onClickPosListener(payMethodInfoModel);
        }
    }

    private void set99PayInfo(PayMethodInfoModel payMethodInfoModel) {
        Pay99SubItemView pay99SubItemView = new Pay99SubItemView(getContext());
        pay99SubItemView.set99PayInfo(payMethodInfoModel);
        pay99SubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
        pay99SubItemView.mo62608a(this.f21014a);
        addView(pay99SubItemView);
    }

    private void setPayPayInfo(PayMethodInfoModel payMethodInfoModel) {
        PayPaySubItemView payPaySubItemView = new PayPaySubItemView(getContext());
        payPaySubItemView.setPayPayInfo(payMethodInfoModel);
        payPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
        payPaySubItemView.mo62608a(this.f21014a);
        addView(payPaySubItemView);
    }

    private void setCashInfo(PayMethodInfoModel payMethodInfoModel) {
        CashPaySubItemView cashPaySubItemView = new CashPaySubItemView(getContext());
        cashPaySubItemView.setCashInfo(payMethodInfoModel);
        cashPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
        cashPaySubItemView.mo62608a(this.f21014a);
        addView(cashPaySubItemView);
        cashPaySubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m15385a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15385a(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f21014a;
        if (payMethodListener != null) {
            payMethodListener.onClickCashPay(payMethodInfoModel);
        }
    }

    private void setCreditInfo(PayMethodInfoModel payMethodInfoModel) {
        if (m15387a(payMethodInfoModel)) {
            int size = payMethodInfoModel.mCardInfoList.size();
            for (int i = 0; i < payMethodInfoModel.mCardInfoList.size(); i++) {
                PayMethodInfoModel.CardInfoModel cardInfoModel = payMethodInfoModel.mCardInfoList.get(i);
                CardPaySubItemView cardPaySubItemView = new CardPaySubItemView(getContext());
                cardPaySubItemView.mo62600a(payMethodInfoModel, cardInfoModel);
                addView(cardPaySubItemView);
                if (size <= 1) {
                    cardPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item);
                } else if (i == 0) {
                    cardPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_top);
                } else if (i == size - 1) {
                    cardPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_below);
                } else {
                    cardPaySubItemView.setBackgroundResource(R.drawable.entrega_selector_paymethod_item_center);
                }
                if (i == 0) {
                    cardPaySubItemView.mo62609a(false);
                } else {
                    cardPaySubItemView.mo62609a(true);
                }
                cardPaySubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel, cardInfoModel) {
                    public final /* synthetic */ PayMethodInfoModel f$1;
                    public final /* synthetic */ PayMethodInfoModel.CardInfoModel f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        PayMethodInfoView.this.m15386a(this.f$1, this.f$2, view);
                    }
                });
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m15386a(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel, View view) {
        PayMethodListener payMethodListener = this.f21014a;
        if (payMethodListener != null) {
            payMethodListener.onClickCardPay(payMethodInfoModel, cardInfoModel);
        }
    }

    /* renamed from: a */
    private boolean m15387a(PayMethodInfoModel payMethodInfoModel) {
        return payMethodInfoModel.mCardInfoList != null && !payMethodInfoModel.mCardInfoList.isEmpty();
    }

    /* renamed from: a */
    private void m15384a() {
        setOrientation(1);
    }
}

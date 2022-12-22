package com.didi.soda.pay.widget;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.soda.customer.foundation.util.StringUtils;
import com.didi.soda.pay.model.PayMethodInfoModel;
import com.taxis99.R;

public class PayMethodInfoView extends FrameLayout {
    public static final int PAY_99_AVAILABLE = 0;
    public static final int PAY_99_NOT_DISPLAY = -1;
    public static final int PAY_99_NOT_ENABLE = 2;
    public static final int PAY_99_NOT_ENOUGH = 1;

    /* renamed from: a */
    View f43643a = null;

    /* renamed from: b */
    private PayMethodListener f43644b;

    /* renamed from: c */
    private int f43645c = 0;

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
        this.f43644b = payMethodListener;
        m30947a();
    }

    public void setPayMethodInfo(PayMethodInfoModel payMethodInfoModel) {
        if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
            marginLayoutParams.topMargin = this.f43645c;
            marginLayoutParams.bottomMargin = this.f43645c;
            setLayoutParams(marginLayoutParams);
        }
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
        didiCashSubItemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
        didiCashSubItemView.mo108721a(this.f43644b);
        addView(didiCashSubItemView);
        didiCashSubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m30952c(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public /* synthetic */ void m30952c(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f43644b;
        if (payMethodListener != null) {
            payMethodListener.onClickDidiPay(payMethodInfoModel);
        }
    }

    private void setPosPayInfo(PayMethodInfoModel payMethodInfoModel) {
        PosSubItemView posSubItemView = new PosSubItemView(getContext());
        posSubItemView.setPosPayInfo(payMethodInfoModel);
        posSubItemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
        posSubItemView.mo108721a(this.f43644b);
        addView(posSubItemView);
        posSubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m30951b(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public /* synthetic */ void m30951b(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f43644b;
        if (payMethodListener != null) {
            payMethodListener.onClickPosListener(payMethodInfoModel);
        }
    }

    private void set99PayInfo(PayMethodInfoModel payMethodInfoModel) {
        Pay99SubItemView pay99SubItemView = new Pay99SubItemView(getContext());
        pay99SubItemView.set99PayInfo(payMethodInfoModel);
        pay99SubItemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
        pay99SubItemView.mo108721a(this.f43644b);
        addView(pay99SubItemView);
    }

    private void setPayPayInfo(PayMethodInfoModel payMethodInfoModel) {
        PayPaySubItemView payPaySubItemView = new PayPaySubItemView(getContext());
        payPaySubItemView.setPayPayInfo(payMethodInfoModel);
        payPaySubItemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
        payPaySubItemView.mo108721a(this.f43644b);
        addView(payPaySubItemView);
    }

    private void setCashInfo(PayMethodInfoModel payMethodInfoModel) {
        CashPaySubItemView cashPaySubItemView = new CashPaySubItemView(getContext());
        cashPaySubItemView.setCashInfo(payMethodInfoModel);
        cashPaySubItemView.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
        cashPaySubItemView.mo108721a(this.f43644b);
        addView(cashPaySubItemView);
        cashPaySubItemView.setOnClickListener(new View.OnClickListener(payMethodInfoModel) {
            public final /* synthetic */ PayMethodInfoModel f$1;

            {
                this.f$1 = r2;
            }

            public final void onClick(View view) {
                PayMethodInfoView.this.m30948a(this.f$1, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30948a(PayMethodInfoModel payMethodInfoModel, View view) {
        PayMethodListener payMethodListener = this.f43644b;
        if (payMethodListener != null) {
            payMethodListener.onClickCashPay(payMethodInfoModel);
        }
    }

    private void setCreditInfo(PayMethodInfoModel payMethodInfoModel) {
        if (m30950a(payMethodInfoModel)) {
            if (getLayoutParams() instanceof ViewGroup.MarginLayoutParams) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) getLayoutParams();
                marginLayoutParams.topMargin = 0;
                marginLayoutParams.bottomMargin = 0;
                setLayoutParams(marginLayoutParams);
            }
            RelativeLayout relativeLayout = new RelativeLayout(getContext());
            addView(relativeLayout);
            int size = payMethodInfoModel.mCardInfoList.size();
            CardPaySubItemView cardPaySubItemView = null;
            int i = 0;
            while (i < payMethodInfoModel.mCardInfoList.size()) {
                PayMethodInfoModel.CardInfoModel cardInfoModel = payMethodInfoModel.mCardInfoList.get(i);
                CardPaySubItemView cardPaySubItemView2 = new CardPaySubItemView(getContext());
                cardPaySubItemView2.setId(generateViewId());
                cardPaySubItemView2.mo108713a(payMethodInfoModel, cardInfoModel);
                relativeLayout.addView(cardPaySubItemView2, new RelativeLayout.LayoutParams(-1, -2));
                RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) cardPaySubItemView2.getLayoutParams();
                if (cardPaySubItemView != null) {
                    layoutParams.addRule(3, cardPaySubItemView.getId());
                }
                if (size <= 1) {
                    layoutParams.topMargin = this.f43645c;
                    layoutParams.bottomMargin = this.f43645c;
                    cardPaySubItemView2.setBackgroundResource(R.drawable.customer_selector_paymethod_item);
                } else if (i == 0) {
                    layoutParams.topMargin = this.f43645c;
                    cardPaySubItemView2.setBackgroundResource(R.drawable.customer_selector_paymethod_item_top);
                } else if (i == size - 1) {
                    layoutParams.bottomMargin = this.f43645c;
                    cardPaySubItemView2.setBackgroundResource(R.drawable.customer_selector_paymethod_item_below);
                } else {
                    cardPaySubItemView2.setBackgroundResource(R.drawable.customer_selector_paymethod_item_center);
                }
                if (i == 0) {
                    cardPaySubItemView2.mo108722a(false);
                } else {
                    cardPaySubItemView2.mo108722a(true);
                }
                cardPaySubItemView2.setOnClickListener(new View.OnClickListener(payMethodInfoModel, cardInfoModel) {
                    public final /* synthetic */ PayMethodInfoModel f$1;
                    public final /* synthetic */ PayMethodInfoModel.CardInfoModel f$2;

                    {
                        this.f$1 = r2;
                        this.f$2 = r3;
                    }

                    public final void onClick(View view) {
                        PayMethodInfoView.this.m30949a(this.f$1, this.f$2, view);
                    }
                });
                if (cardInfoModel.mDataType == 2) {
                    if (StringUtils.isEmpty(payMethodInfoModel.mSaveString)) {
                        View view = this.f43643a;
                        if (view != null) {
                            view.setVisibility(8);
                        }
                    } else {
                        if (this.f43643a == null) {
                            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_paymethod_pop_layout, (ViewGroup) null);
                            this.f43643a = inflate;
                            relativeLayout.addView(inflate, new RelativeLayout.LayoutParams(-2, -2));
                            RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f43643a.getLayoutParams();
                            layoutParams2.addRule(6, cardPaySubItemView2.getId());
                            layoutParams2.topMargin = -DisplayUtils.dip2px(getContext(), 5.0f);
                            layoutParams2.leftMargin = DisplayUtils.dip2px(getContext(), 52.0f);
                            this.f43643a.setLayoutParams(layoutParams2);
                        }
                        this.f43643a.setVisibility(0);
                        ((TextView) this.f43643a.findViewById(R.id.customer_pay_method_pop_tv)).setText(payMethodInfoModel.mSaveString);
                    }
                }
                i++;
                cardPaySubItemView = cardPaySubItemView2;
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m30949a(PayMethodInfoModel payMethodInfoModel, PayMethodInfoModel.CardInfoModel cardInfoModel, View view) {
        PayMethodListener payMethodListener = this.f43644b;
        if (payMethodListener != null) {
            payMethodListener.onClickCardPay(payMethodInfoModel, cardInfoModel);
        }
    }

    /* renamed from: a */
    private boolean m30950a(PayMethodInfoModel payMethodInfoModel) {
        return payMethodInfoModel.mCardInfoList != null && !payMethodInfoModel.mCardInfoList.isEmpty();
    }

    /* renamed from: a */
    private void m30947a() {
        this.f43645c = DisplayUtils.dip2px(getContext(), 5.5f);
    }
}

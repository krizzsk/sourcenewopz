package com.didi.sdk.global.cardexpire;

import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class CardExpiredDialog extends SimplePopupBase {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f36095a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f36096b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View.OnClickListener f36097c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public View.OnClickListener f36098d;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.card_expire_intercept_dialog;
    }

    /* access modifiers changed from: protected */
    public void initView() {
        GlideUtils.with2load2into(getContext(), this.f36095a, (ImageView) this.mRootView.findViewById(R.id.iv_card_icon));
        ((TextView) this.mRootView.findViewById(R.id.tv_card_no)).setText(this.f36096b);
        ((TextView) this.mRootView.findViewById(R.id.tv_update_card)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardExpiredDialog.this.dismiss();
                if (CardExpiredDialog.this.f36097c != null) {
                    CardExpiredDialog.this.f36097c.onClick(view);
                }
            }
        });
        ((TextView) this.mRootView.findViewById(R.id.tv_change_payment_method)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CardExpiredDialog.this.dismiss();
                if (CardExpiredDialog.this.f36098d != null) {
                    CardExpiredDialog.this.f36098d.onClick(view);
                }
            }
        });
    }

    public static final class Builder {
        private String cardNo;
        private View.OnClickListener changePaymentMethodListener;
        private String icon;
        private View.OnClickListener updateCardListener;

        public Builder setIcon(String str) {
            this.icon = str;
            return this;
        }

        public Builder setCardNo(String str) {
            this.cardNo = str;
            return this;
        }

        public Builder setUpdateCardListener(View.OnClickListener onClickListener) {
            this.updateCardListener = onClickListener;
            return this;
        }

        public Builder setChangePaymentMethodListener(View.OnClickListener onClickListener) {
            this.changePaymentMethodListener = onClickListener;
            return this;
        }

        public CardExpiredDialog builder() {
            CardExpiredDialog cardExpiredDialog = new CardExpiredDialog();
            String unused = cardExpiredDialog.f36095a = this.icon;
            String unused2 = cardExpiredDialog.f36096b = this.cardNo;
            View.OnClickListener unused3 = cardExpiredDialog.f36097c = this.updateCardListener;
            View.OnClickListener unused4 = cardExpiredDialog.f36098d = this.changePaymentMethodListener;
            return cardExpiredDialog;
        }
    }
}

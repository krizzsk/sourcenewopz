package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import android.view.View;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardTypeSelectView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public class CheckViewHelper {

    /* renamed from: a */
    private Context f30439a;

    /* renamed from: b */
    private ICardBinRule f30440b;

    /* renamed from: c */
    private BlackCardRule f30441c;

    public CheckViewHelper(Context context, ICardBinRule iCardBinRule, BlackCardRule blackCardRule) {
        this.f30439a = context;
        this.f30440b = iCardBinRule;
        this.f30441c = blackCardRule;
    }

    public boolean checkBlackCard(String str) {
        return this.f30441c.isBlackCard(PaymentTextUtil.replaceAllSpace(str));
    }

    public boolean checkEditText(View view) {
        CardEditText cardEditText = view instanceof CardEditText ? (CardEditText) view : null;
        if (cardEditText == null) {
            return true;
        }
        int id = cardEditText.getId();
        String textString = cardEditText.getTextString();
        if (id == R.id.et_card) {
            if (checkBlackCard(textString)) {
                cardEditText.showError();
                Context context = this.f30439a;
                ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_not_support));
                return false;
            } else if (this.f30440b.getCardType(textString) == 3) {
                if (!GlobalCheckUtil.checkCreditCardNo(this.f30439a, textString)) {
                    cardEditText.showError();
                    return false;
                }
            } else if (!GlobalCheckUtil.checkCreditDebitCardNo(this.f30439a, textString)) {
                cardEditText.showError();
                return false;
            }
        } else if (id == R.id.et_date) {
            if (!GlobalCheckUtil.checkDate(textString)) {
                cardEditText.showError();
                return false;
            }
        } else if (id == R.id.et_cvv && !GlobalCheckUtil.checkCVV(this.f30439a, textString)) {
            cardEditText.showError();
            return false;
        }
        return true;
    }

    public void resetEditText(View view) {
        CardEditText cardEditText = view instanceof CardEditText ? (CardEditText) view : null;
        if (cardEditText != null) {
            if (cardEditText.getId() != R.id.et_card || !checkBlackCard(cardEditText.getTextWithoutSpace())) {
                cardEditText.resetError();
                return;
            }
            cardEditText.showError();
            Context context = this.f30439a;
            ToastHelper.showShortInfo(context, context.getString(R.string.one_payment_creditcard_global_error_not_support));
        }
    }

    public boolean checkSelectView(CardTypeSelectView cardTypeSelectView, CardEditText cardEditText) {
        if (this.f30440b.getCardType(cardEditText.getTextString()) != 1 || cardTypeSelectView.isTypeSelected()) {
            return true;
        }
        cardTypeSelectView.showError();
        return false;
    }

    public void resetDateEditText(CardEditText cardEditText) {
        if (GlobalCheckUtil.checkDate(cardEditText.getTextString())) {
            resetEditText(cardEditText);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x0021  */
    /* JADX WARNING: Removed duplicated region for block: B:17:0x003b  */
    /* JADX WARNING: Removed duplicated region for block: B:26:0x0064  */
    /* JADX WARNING: Removed duplicated region for block: B:28:? A[RETURN, SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean isCommitEnabled(com.didi.payment.creditcard.global.widget.CardEditText r6, com.didi.payment.creditcard.global.widget.CardEditText r7, com.didi.payment.creditcard.global.widget.CardEditText r8, com.didi.payment.creditcard.global.widget.CardTypeSelectView r9) {
        /*
            r5 = this;
            r0 = 1
            r1 = 0
            if (r6 == 0) goto L_0x001e
            java.lang.String r2 = r6.getTextWithoutSpace()
            boolean r3 = android.text.TextUtils.isEmpty(r2)
            if (r3 != 0) goto L_0x001c
            int r3 = r2.length()
            r4 = 13
            if (r3 < r4) goto L_0x001c
            boolean r2 = r5.checkBlackCard(r2)
            if (r2 == 0) goto L_0x001e
        L_0x001c:
            r2 = 0
            goto L_0x001f
        L_0x001e:
            r2 = 1
        L_0x001f:
            if (r7 == 0) goto L_0x0039
            java.lang.String r7 = r7.getTextString()
            boolean r3 = android.text.TextUtils.isEmpty(r7)
            if (r3 == 0) goto L_0x002d
        L_0x002b:
            r2 = 0
            goto L_0x0039
        L_0x002d:
            java.lang.String r7 = com.didi.payment.creditcard.global.utils.GlobalCreditCardFormatter.removeSymbols(r7)
            int r7 = r7.length()
            r3 = 4
            if (r7 == r3) goto L_0x0039
            goto L_0x002b
        L_0x0039:
            if (r8 == 0) goto L_0x004d
            java.lang.String r7 = r8.getTextString()
            boolean r8 = com.didi.sdk.util.TextUtil.isEmpty(r7)
            if (r8 != 0) goto L_0x004c
            int r7 = r7.length()
            r8 = 2
            if (r7 >= r8) goto L_0x004d
        L_0x004c:
            r2 = 0
        L_0x004d:
            com.didi.payment.creditcard.base.binrule.ICardBinRule r7 = r5.f30440b
            java.lang.String r6 = r6.getTextString()
            java.lang.String r6 = r6.trim()
            int r6 = r7.getCardType(r6)
            if (r6 != r0) goto L_0x0064
            boolean r6 = r9.isTypeSelected()
            if (r6 != 0) goto L_0x0064
            goto L_0x0065
        L_0x0064:
            r1 = r2
        L_0x0065:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.creditcard.global.utils.CheckViewHelper.isCommitEnabled(com.didi.payment.creditcard.global.widget.CardEditText, com.didi.payment.creditcard.global.widget.CardEditText, com.didi.payment.creditcard.global.widget.CardEditText, com.didi.payment.creditcard.global.widget.CardTypeSelectView):boolean");
    }
}

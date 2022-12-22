package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.payment.creditcard.base.binrule.BlackCardRule;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.base.utils.PaymentTextUtil;
import com.didi.payment.creditcard.global.omega.GlobalOmegaErrorCounter;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardTypeSelectOptView;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class CheckViewHelperOpt {

    /* renamed from: a */
    private static final int f30442a = 0;

    /* renamed from: b */
    private static final int f30443b = 1;

    /* renamed from: c */
    private Context f30444c;

    /* renamed from: d */
    private ICardBinRule f30445d;

    /* renamed from: e */
    private BlackCardRule f30446e;

    /* renamed from: f */
    private int f30447f;

    /* renamed from: g */
    private int f30448g;

    public CheckViewHelperOpt(Context context, ICardBinRule iCardBinRule, BlackCardRule blackCardRule) {
        this.f30444c = context;
        this.f30446e = blackCardRule;
        this.f30445d = iCardBinRule;
        this.f30447f = ContextCompat.getColor(context, R.color.one_payment_creditcard_text_black);
        this.f30448g = ContextCompat.getColor(context, R.color.one_payment_creditcard_text_red);
    }

    public void updateNumberIcon(ImageView imageView, String str) {
        if (this.f30445d == null || TextUtils.isEmpty(str)) {
            imageView.setImageResource(R.drawable.one_payment_creditcard_bank_default);
            imageView.setTag(0);
            return;
        }
        int cardOrg = this.f30445d.getCardOrg(str);
        if (!m21416a(imageView, cardOrg)) {
            imageView.setTag(Integer.valueOf(cardOrg));
            switch (cardOrg) {
                case 0:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_default);
                    return;
                case 1:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_visa);
                    return;
                case 2:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_mastercard);
                    return;
                case 3:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_elo);
                    return;
                case 4:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_amex);
                    return;
                case 5:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_unipay);
                    return;
                case 6:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_diners);
                    return;
                case 7:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_discover);
                    return;
                case 8:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_jcb);
                    return;
                case 9:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_hipercard);
                    return;
                case 10:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_hiper);
                    return;
                case 11:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_maestro);
                    return;
                case 12:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_mir);
                    return;
                default:
                    imageView.setImageResource(R.drawable.one_payment_creditcard_bank_default);
                    return;
            }
        }
    }

    public String checkCardNumErrorMsg(String str, EditText editText) {
        String str2;
        String str3 = null;
        if (str == null || str.length() != 19) {
            str2 = null;
        } else {
            str2 = CheckUtil.getCardNoCheckMsg(this.f30444c, str, this.f30445d);
            if (TextUtils.isEmpty(str2)) {
                editText.requestFocus();
            }
        }
        boolean checkBlackCard = checkBlackCard(str);
        if (checkBlackCard) {
            str3 = this.f30444c.getResources().getString(R.string.one_payment_creditcard_global_error_not_support);
        }
        if (checkBlackCard) {
            GlobalOmegaErrorCounter.addInvalidBlackCardCount();
        }
        return !TextUtils.isEmpty(str2) ? str2 : str3;
    }

    public boolean checkNumber(CardEditText cardEditText, TextView textView) {
        String cardNoCheckMsg = CheckUtil.getCardNoCheckMsg(this.f30444c, cardEditText.getTextWithoutSpace(), this.f30445d);
        if (!TextUtil.isEmpty(cardNoCheckMsg)) {
            textView.setText(cardNoCheckMsg);
            if (!m21416a(textView, 0)) {
                textView.setTextColor(this.f30448g);
                textView.setTag(0);
            }
            return false;
        }
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_number_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
        return true;
    }

    public void setCardNumErrorMsg(String str, TextView textView) {
        if (!TextUtil.isEmpty(str)) {
            textView.setText(str);
            if (!m21416a(textView, 0)) {
                textView.setTextColor(this.f30448g);
                textView.setTag(0);
            }
        } else if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_number_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
    }

    public void resetNumber(TextView textView) {
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_number_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
    }

    public boolean checkDate(CardEditText cardEditText, TextView textView) {
        String dateCheckMsg = CheckUtil.getDateCheckMsg(this.f30444c, cardEditText.getTextWithoutSpace());
        if (!TextUtil.isEmpty(dateCheckMsg)) {
            if (!m21416a(textView, 0)) {
                textView.setText(dateCheckMsg);
                textView.setTextColor(this.f30448g);
                textView.setTag(0);
            }
            return false;
        }
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_date_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
        return true;
    }

    public void resetDate(TextView textView) {
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_date_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
    }

    public boolean checkSafeCode(CardEditText cardEditText, CardEditText cardEditText2, TextView textView) {
        String safeCodeCheckMsg = CheckUtil.getSafeCodeCheckMsg(this.f30444c, cardEditText.getTextWithoutSpace(), cardEditText2.getTextWithoutSpace());
        if (!TextUtil.isEmpty(safeCodeCheckMsg)) {
            textView.setText(safeCodeCheckMsg);
            if (!m21416a(textView, 0)) {
                textView.setTextColor(this.f30448g);
                textView.setTag(0);
            }
            return false;
        }
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_code_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
        return true;
    }

    public void resetSafeCode(TextView textView) {
        if (!m21416a(textView, 1)) {
            textView.setText(R.string.one_payment_creditcard_global_code_title);
            textView.setTextColor(this.f30447f);
            textView.setTag(1);
        }
    }

    public boolean checkBlackCard(String str) {
        return this.f30446e.isBlackCard(PaymentTextUtil.replaceAllSpace(str));
    }

    public void checkCommitButton(CardEditText cardEditText, CardEditText cardEditText2, CardEditText cardEditText3, CardTypeSelectOptView cardTypeSelectOptView, TextView textView) {
        boolean checkAll = CheckUtil.checkAll(this.f30444c, cardEditText.getTextWithoutSpace(), cardEditText2.getTextWithoutSpace(), cardEditText3.getTextWithoutSpace(), this.f30445d, this.f30446e);
        if (this.f30445d.getCardType(cardEditText.getTextString().trim()) == 1 && !cardTypeSelectOptView.isTypeSelected()) {
            checkAll = false;
        }
        textView.setEnabled(checkAll);
    }

    /* renamed from: a */
    private boolean m21416a(View view, int i) {
        try {
            if (((Integer) view.getTag()).intValue() == i) {
                return true;
            }
            return false;
        } catch (Exception unused) {
        }
    }
}

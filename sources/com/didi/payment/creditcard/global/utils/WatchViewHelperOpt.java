package com.didi.payment.creditcard.global.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.p130v2.utils.BindCardApolloUtils;
import com.didi.payment.creditcard.global.p130v2.utils.CreditCardOmegaUtil;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardNoWatcher;
import com.didi.payment.creditcard.global.widget.CardTypeSelectOptView;
import com.didichuxing.diface.logger.DiFaceLogger;
import com.taxis99.R;

public class WatchViewHelperOpt {

    /* renamed from: a */
    private static final String f30494a = "2.0";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f30495b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardEditText f30496c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardEditText f30497d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CardEditText f30498e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f30499f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public TextView f30500g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public TextView f30501h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CardTypeSelectOptView f30502i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public TextView f30503j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public ImageView f30504k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public CheckViewHelperOpt f30505l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ICardBinRule f30506m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public CardTypeViewAnimator f30507n = new CardTypeViewAnimator();
    /* access modifiers changed from: private */

    /* renamed from: o */
    public IOnEditFocusChangeListener f30508o;

    /* renamed from: p */
    private TextWatcher f30509p = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WatchViewHelperOpt.this.f30505l.checkCommitButton(WatchViewHelperOpt.this.f30496c, WatchViewHelperOpt.this.f30497d, WatchViewHelperOpt.this.f30498e, WatchViewHelperOpt.this.f30502i, WatchViewHelperOpt.this.f30503j);
        }
    };

    /* renamed from: q */
    private View.OnFocusChangeListener f30510q = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            int id = view.getId();
            boolean z2 = true;
            if (id == R.id.et_card) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f30496c.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f30505l.checkNumber(WatchViewHelperOpt.this.f30496c, WatchViewHelperOpt.this.f30499f);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("1", z2);
                    return;
                }
                GlobalOmegaUtils.trackAddCardPageCardNumberCK(view.getContext(), WatchViewHelperOpt.f30494a);
            } else if (id == R.id.et_date) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f30497d.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f30505l.checkDate(WatchViewHelperOpt.this.f30497d, WatchViewHelperOpt.this.f30500g);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("2", z2);
                    return;
                }
                InputTools.hideKeyboard(view);
                if (WatchViewHelperOpt.this.f30508o != null) {
                    WatchViewHelperOpt.this.f30508o.onFocusChange(view, z);
                }
                GlobalOmegaUtils.trackAddCardPageExpirationCK(view.getContext(), WatchViewHelperOpt.f30494a);
            } else if (id == R.id.et_cvv) {
                if (!z) {
                    if (WatchViewHelperOpt.this.f30498e.getTextWithoutSpace().length() == 0) {
                        z2 = false;
                    }
                    if (z2) {
                        WatchViewHelperOpt.this.f30505l.checkSafeCode(WatchViewHelperOpt.this.f30496c, WatchViewHelperOpt.this.f30498e, WatchViewHelperOpt.this.f30501h);
                    }
                    CreditCardOmegaUtil.Companion.bindCardInputTrace("3", z2);
                } else {
                    GlobalOmegaUtils.trackAddCardPageCvvCK(view.getContext(), WatchViewHelperOpt.f30494a);
                }
                WatchViewHelperOpt watchViewHelperOpt = WatchViewHelperOpt.this;
                watchViewHelperOpt.m21446a(watchViewHelperOpt.f30496c.getTextWithoutSpace(), z);
            }
        }
    };

    /* renamed from: r */
    private CardTypeSelectOptView.OnCardTypeSelectChangeListener f30511r = new CardTypeSelectOptView.OnCardTypeSelectChangeListener() {
        public void onCardTypeSelect(int i) {
            WatchViewHelperOpt.this.f30505l.checkCommitButton(WatchViewHelperOpt.this.f30496c, WatchViewHelperOpt.this.f30497d, WatchViewHelperOpt.this.f30498e, WatchViewHelperOpt.this.f30502i, WatchViewHelperOpt.this.f30503j);
            if (i == 0) {
                GlobalOmegaUtils.trackAddCardPageCreditCK(WatchViewHelperOpt.this.f30496c.getContext());
            } else if (i == 1) {
                GlobalOmegaUtils.trackAddCardPageDebitCK(WatchViewHelperOpt.this.f30496c.getContext());
            }
            WatchViewHelperOpt.this.f30505l.setCardNumErrorMsg((String) null, WatchViewHelperOpt.this.f30499f);
        }
    };

    /* renamed from: s */
    private CardNoWatcher.CardBinCheckListener f30512s = new CardNoWatcher.CardBinCheckListener() {
        public void check(String str) {
            WatchViewHelperOpt.this.f30505l.resetNumber(WatchViewHelperOpt.this.f30499f);
            int cardType = WatchViewHelperOpt.this.f30506m.getCardType(str);
            if (cardType == 1) {
                WatchViewHelperOpt.this.f30496c.resetError();
                WatchViewHelperOpt.this.f30507n.showCardTypeSelectView(WatchViewHelperOpt.this.f30502i, (View) null);
            }
            String checkCardNumErrorMsg = WatchViewHelperOpt.this.f30505l.checkCardNumErrorMsg(str, WatchViewHelperOpt.this.f30497d);
            if (TextUtils.isEmpty(checkCardNumErrorMsg) && str != null && str.length() == 19 && cardType == 1 && !WatchViewHelperOpt.this.f30502i.isTypeSelected()) {
                checkCardNumErrorMsg = WatchViewHelperOpt.this.f30495b.getResources().getString(R.string.one_payment_creditcard_global_error_select_type);
            }
            WatchViewHelperOpt.this.f30505l.setCardNumErrorMsg(checkCardNumErrorMsg, WatchViewHelperOpt.this.f30499f);
            WatchViewHelperOpt.this.f30505l.updateNumberIcon(WatchViewHelperOpt.this.f30504k, str);
            WatchViewHelperOpt.this.m21446a(str, false);
            WatchViewHelperOpt.this.m21445a(str);
        }

        public void reset(String str) {
            check(str);
            WatchViewHelperOpt.this.f30502i.resetError();
            WatchViewHelperOpt.this.f30507n.hideCardTypeSelectView(WatchViewHelperOpt.this.f30502i, (View) null);
        }
    };

    /* renamed from: t */
    private TextWatcher f30513t = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            if (WatchViewHelperOpt.this.f30496c != null) {
                if (editable == null || editable.length() <= 18) {
                    WatchViewHelperOpt.this.f30496c.setTextSize(2, 18.0f);
                } else {
                    WatchViewHelperOpt.this.f30496c.setTextSize(2, 16.0f);
                }
            }
        }
    };

    /* renamed from: u */
    private TextWatcher f30514u = new TextWatcher() {
        private String mPreContent = "";

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            this.mPreContent = charSequence.toString();
        }

        public void afterTextChanged(Editable editable) {
            if (editable.length() >= 2 && this.mPreContent.length() < editable.length()) {
                String obj = editable.toString();
                if (!obj.contains("/")) {
                    StringBuilder sb = new StringBuilder(obj);
                    sb.insert(2, "/");
                    WatchViewHelperOpt.this.f30497d.setText(sb);
                    WatchViewHelperOpt.this.f30497d.setSelection(WatchViewHelperOpt.this.f30497d.getText().length());
                }
            }
            WatchViewHelperOpt.this.f30505l.resetDate(WatchViewHelperOpt.this.f30500g);
            if (editable != null && editable.toString().trim().length() == 5 && WatchViewHelperOpt.this.f30505l.checkDate(WatchViewHelperOpt.this.f30497d, WatchViewHelperOpt.this.f30500g)) {
                WatchViewHelperOpt.this.f30498e.requestFocus();
            }
        }
    };

    /* renamed from: v */
    private TextWatcher f30515v = new TextWatcher() {
        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void afterTextChanged(Editable editable) {
            WatchViewHelperOpt.this.f30505l.resetSafeCode(WatchViewHelperOpt.this.f30501h);
            if (editable != null && editable.toString().trim().length() == 4) {
                WatchViewHelperOpt.this.f30505l.checkSafeCode(WatchViewHelperOpt.this.f30496c, WatchViewHelperOpt.this.f30498e, WatchViewHelperOpt.this.f30501h);
            }
        }
    };

    public interface IOnEditFocusChangeListener {
        void onFocusChange(View view, boolean z);
    }

    public WatchViewHelperOpt(ICardBinRule iCardBinRule, CheckViewHelperOpt checkViewHelperOpt) {
        this.f30506m = iCardBinRule;
        this.f30505l = checkViewHelperOpt;
    }

    public void initView(CardEditText cardEditText, CardEditText cardEditText2, CardEditText cardEditText3, TextView textView, TextView textView2, TextView textView3, ImageView imageView, CardTypeSelectOptView cardTypeSelectOptView, TextView textView4) {
        this.f30496c = cardEditText;
        this.f30497d = cardEditText2;
        this.f30498e = cardEditText3;
        this.f30499f = textView;
        this.f30500g = textView2;
        this.f30501h = textView3;
        this.f30504k = imageView;
        this.f30502i = cardTypeSelectOptView;
        this.f30503j = textView4;
        this.f30495b = cardEditText.getContext();
    }

    public void resetView() {
        this.f30496c.setText("");
        this.f30496c.resetError();
        this.f30497d.setText("");
        this.f30497d.resetError();
        this.f30498e.setText("");
        this.f30498e.resetError();
        this.f30507n.hideCardTypeSelectView(this.f30502i, (View) null);
        this.f30503j.setEnabled(false);
    }

    public void watch() {
        m21442a();
        m21448b();
        m21450c();
        m21452d();
    }

    /* renamed from: a */
    private void m21442a() {
        CardNoWatcher cardNoWatcher = new CardNoWatcher(this.f30496c);
        cardNoWatcher.setCheckListener(this.f30512s);
        this.f30496c.addTextChangedListener(cardNoWatcher);
        this.f30496c.addTextChangedListener(this.f30509p);
        if (BindCardApolloUtils.useNewVersion()) {
            this.f30496c.addTextChangedListener(this.f30513t);
        }
        this.f30496c.setOnFocusChangeListener(this.f30510q);
    }

    /* renamed from: b */
    private void m21448b() {
        this.f30497d.addTextChangedListener(this.f30509p);
        this.f30497d.addTextChangedListener(this.f30514u);
        this.f30497d.setOnFocusChangeListener(this.f30510q);
    }

    /* renamed from: c */
    private void m21450c() {
        this.f30498e.addTextChangedListener(this.f30509p);
        this.f30498e.addTextChangedListener(this.f30515v);
        this.f30498e.setOnFocusChangeListener(this.f30510q);
    }

    /* renamed from: d */
    private void m21452d() {
        this.f30502i.setOnCardTypeSelectChangeListener(this.f30511r);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21446a(String str, boolean z) {
        String string = this.f30495b.getResources().getString(R.string.one_payment_creditcard_global_code_hint_cvv);
        String string2 = this.f30495b.getResources().getString(R.string.one_payment_creditcard_global_code_hint_cid);
        if (TextUtils.isEmpty(str) || str.length() < 6 || (!str.startsWith(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE) && !str.startsWith("37"))) {
            if (z) {
                this.f30498e.setHint("123");
            } else {
                this.f30498e.setHint(string);
            }
        } else if (z) {
            this.f30498e.setHint("1234");
        } else {
            this.f30498e.setHint(string2);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m21445a(String str) {
        String trim = this.f30501h.getText().toString().trim();
        String string = this.f30495b.getResources().getString(R.string.one_payment_creditcard_global_error_safe_code);
        String string2 = this.f30495b.getResources().getString(R.string.one_payment_creditcard_global_error_cid_code);
        if (TextUtils.isEmpty(str) || str.length() < 6 || (!str.startsWith(DiFaceLogger.EVENT_ID_APPEAL_DATA_SUBMIT_STOP_VIDEO_TAKE) && !str.startsWith("37"))) {
            if (trim.equals(string2)) {
                this.f30501h.setText(string);
            }
        } else if (trim.equals(string)) {
            this.f30501h.setText(string2);
        }
    }

    public void setOnFocusChangeListener(IOnEditFocusChangeListener iOnEditFocusChangeListener) {
        this.f30508o = iOnEditFocusChangeListener;
    }
}

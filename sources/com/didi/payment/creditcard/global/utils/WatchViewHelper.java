package com.didi.payment.creditcard.global.utils;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.TextView;
import com.didi.payment.creditcard.base.binrule.ICardBinRule;
import com.didi.payment.creditcard.global.omega.GlobalOmegaUtils;
import com.didi.payment.creditcard.global.widget.CardEditText;
import com.didi.payment.creditcard.global.widget.CardNoWatcher;
import com.didi.payment.creditcard.global.widget.CardTypeSelectView;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;

public class WatchViewHelper {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public CardEditText f30481a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public CardEditText f30482b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CardEditText f30483c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public CardTypeSelectView f30484d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f30485e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f30486f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public CheckViewHelper f30487g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public ICardBinRule f30488h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public CardTypeViewAnimator f30489i = new CardTypeViewAnimator();

    /* renamed from: j */
    private TextWatcher f30490j = new TextWatcher() {
        public void afterTextChanged(Editable editable) {
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            WatchViewHelper.this.f30486f.setEnabled(WatchViewHelper.this.f30487g.isCommitEnabled(WatchViewHelper.this.f30481a, WatchViewHelper.this.f30482b, WatchViewHelper.this.f30483c, WatchViewHelper.this.f30484d));
            WatchViewHelper.this.f30487g.resetDateEditText(WatchViewHelper.this.f30482b);
        }
    };

    /* renamed from: k */
    private View.OnFocusChangeListener f30491k = new View.OnFocusChangeListener() {
        public void onFocusChange(View view, boolean z) {
            if (!z) {
                WatchViewHelper.this.f30487g.checkEditText(view);
            } else {
                WatchViewHelper.this.f30487g.resetEditText(view);
            }
            if (z) {
                int id = view.getId();
                if (id == R.id.et_card) {
                    GlobalOmegaUtils.trackAddCardPageCardNumberCK(view.getContext(), "");
                } else if (id == R.id.et_date) {
                    GlobalOmegaUtils.trackAddCardPageExpirationCK(view.getContext(), "");
                } else if (id == R.id.et_cvv) {
                    GlobalOmegaUtils.trackAddCardPageCvvCK(view.getContext(), "");
                }
            }
        }
    };

    /* renamed from: l */
    private CardTypeSelectView.OnCardTypeSelectChangeListener f30492l = new CardTypeSelectView.OnCardTypeSelectChangeListener() {
        public void onCardTypeSelect(int i) {
            if (!GlobalCheckUtil.checkCreditDebitCardNo(WatchViewHelper.this.f30481a.getContext(), WatchViewHelper.this.f30481a.getTextString())) {
                WatchViewHelper.this.f30481a.showError();
            }
            WatchViewHelper.this.f30486f.setEnabled(WatchViewHelper.this.f30487g.isCommitEnabled(WatchViewHelper.this.f30481a, WatchViewHelper.this.f30482b, WatchViewHelper.this.f30483c, WatchViewHelper.this.f30484d));
            if (i == 0) {
                GlobalOmegaUtils.trackAddCardPageCreditCK(WatchViewHelper.this.f30481a.getContext());
            } else if (i == 1) {
                GlobalOmegaUtils.trackAddCardPageDebitCK(WatchViewHelper.this.f30481a.getContext());
            }
        }
    };

    /* renamed from: m */
    private CardNoWatcher.CardBinCheckListener f30493m = new CardNoWatcher.CardBinCheckListener() {
        public void check(String str) {
            if (WatchViewHelper.this.f30488h.getCardType(str) == 1) {
                WatchViewHelper.this.f30481a.resetError();
                WatchViewHelper.this.f30489i.showCardTypeSelectView(WatchViewHelper.this.f30484d, WatchViewHelper.this.f30485e);
            } else {
                reset(str);
            }
            if (WatchViewHelper.this.f30487g.checkBlackCard(str)) {
                WatchViewHelper.this.f30481a.showError();
                if (str.length() == 6) {
                    ToastHelper.showShortInfo(WatchViewHelper.this.f30481a.getContext(), WatchViewHelper.this.f30481a.getContext().getString(R.string.one_payment_creditcard_global_error_not_support));
                }
            }
        }

        public void reset(String str) {
            WatchViewHelper.this.f30481a.resetError();
            WatchViewHelper.this.f30484d.resetError();
            WatchViewHelper.this.f30489i.hideCardTypeSelectView(WatchViewHelper.this.f30484d, WatchViewHelper.this.f30485e);
        }
    };

    public WatchViewHelper(ICardBinRule iCardBinRule, CheckViewHelper checkViewHelper) {
        this.f30488h = iCardBinRule;
        this.f30487g = checkViewHelper;
    }

    public void initView(CardEditText cardEditText, CardEditText cardEditText2, CardEditText cardEditText3, CardTypeSelectView cardTypeSelectView, View view, TextView textView) {
        this.f30481a = cardEditText;
        this.f30482b = cardEditText2;
        this.f30483c = cardEditText3;
        this.f30484d = cardTypeSelectView;
        this.f30485e = view;
        this.f30486f = textView;
    }

    public void resetView() {
        this.f30481a.setText("");
        this.f30481a.resetError();
        this.f30482b.setText("");
        this.f30482b.resetError();
        this.f30483c.setText("");
        this.f30483c.resetError();
        this.f30489i.hideCardTypeSelectView(this.f30484d, this.f30485e);
        this.f30486f.setEnabled(false);
    }

    public void watch() {
        m21429a();
        m21431b();
        m21433c();
        m21435d();
    }

    /* renamed from: a */
    private void m21429a() {
        CardNoWatcher cardNoWatcher = new CardNoWatcher(this.f30481a);
        cardNoWatcher.setCheckListener(this.f30493m);
        this.f30481a.addTextChangedListener(cardNoWatcher);
        this.f30481a.addTextChangedListener(this.f30490j);
        this.f30481a.setOnFocusChangeListener(this.f30491k);
    }

    /* renamed from: b */
    private void m21431b() {
        this.f30482b.addTextChangedListener(this.f30490j);
        this.f30482b.setOnFocusChangeListener(this.f30491k);
    }

    /* renamed from: c */
    private void m21433c() {
        this.f30483c.addTextChangedListener(this.f30490j);
        this.f30483c.setOnFocusChangeListener(this.f30491k);
    }

    /* renamed from: d */
    private void m21435d() {
        this.f30484d.setOnCardTypeSelectChangeListener(this.f30492l);
    }
}

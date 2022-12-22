package com.didi.component.payentrance.view.impl;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.payentrance.utils.PEUtils;
import com.didi.component.payentrance.utils.TextUtil;
import com.didi.component.payentrance.view.IPayEntranceView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.unifiedPay.sdk.model.DeductionInfo;
import com.taxis99.R;
import java.util.regex.Pattern;

public class SelfInputView extends BasePayEntranceView {

    /* renamed from: a */
    private static final String f15083a = "(\\d+|\\d+\\.\\d{0,2})";

    /* renamed from: b */
    private static final double f15084b = 9999.99d;

    /* renamed from: c */
    private static final String f15085c = "SelfInputView";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public EditText f15086d;

    /* renamed from: e */
    private TextView f15087e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public TextView f15088f;

    /* renamed from: g */
    private ViewGroup f15089g;

    /* renamed from: h */
    private boolean f15090h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public IPayEntranceView.OnInputValueChangeListener f15091i;

    public int getLayoutId() {
        return R.layout.global_pe_pay_self_input_view;
    }

    public SelfInputView(Context context, LayoutInflater layoutInflater, ViewGroup viewGroup) {
        super(context, layoutInflater, viewGroup);
    }

    /* access modifiers changed from: protected */
    public void onViewCreated(View view) {
        EditText editText = (EditText) findView(R.id.oc_pay_entrance_input);
        this.f15086d = editText;
        PEUtils.setEditTextHint(editText, this.mContext.getText(R.string.pe_pay_entrance_hint_input).toString(), 14);
        this.f15086d.addTextChangedListener(new ValidTextWatcher(f15083a));
        this.f15086d.addOnAttachStateChangeListener(new View.OnAttachStateChangeListener() {
            public void onViewAttachedToWindow(View view) {
            }

            public void onViewDetachedFromWindow(View view) {
                SelfInputView.this.f15086d.clearFocus();
                if (SelfInputView.this.f15086d != null) {
                    PEUtils.closeInputMethod(SelfInputView.this.f15086d);
                }
            }
        });
        this.f15088f = (TextView) findView(R.id.oc_tv_one_price);
        TextView textView = (TextView) findView(R.id.oc_pay_entrance_goto_pay);
        this.f15087e = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SelfInputView.this.performOnPay(TextUtil.getFirstMoneyFromText(String.valueOf(SelfInputView.this.f15086d.getText())), TextUtil.getFirstMoneyFromText(String.valueOf(SelfInputView.this.f15088f.getText())));
            }
        });
        this.f15089g = (ViewGroup) findView(R.id.oc_pay_entrance_supplement_container);
    }

    public void setPrice(double d) {
        findView(R.id.oc_ll_one_price).setVisibility(0);
        Context context = this.mContext;
        setPrice(context.getString(R.string.pe_pay_entrance_one_price, new Object[]{"" + d}));
    }

    public void setPrice(String str) {
        findView(R.id.oc_ll_one_price).setVisibility(0);
        setMoneyWithUnit(this.f15088f, str);
    }

    public void setMessage(CharSequence charSequence) {
        ((TextView) findView(R.id.oc_pay_entrance_one_price_view)).setText(charSequence);
    }

    public void setInputLabel(CharSequence charSequence) {
        ((TextView) findView(R.id.oc_pay_entrance_input_label)).setText(charSequence);
    }

    public void setInputHint(CharSequence charSequence) {
        this.f15086d.setHint(charSequence);
    }

    public void setOnInputValueChangeListener(IPayEntranceView.OnInputValueChangeListener onInputValueChangeListener) {
        this.f15091i = onInputValueChangeListener;
    }

    public void addSupplement(DeductionInfo deductionInfo, String str) {
        if (deductionInfo != null) {
            View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_supplement_item, this.f15089g, false);
            TextView textView = (TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_name);
            if (!TextUtil.isEmpty(deductionInfo.name)) {
                textView.setText(deductionInfo.name);
            }
            ((TextView) inflate.findViewById(R.id.g_pay_entrance_supplement_value)).setText(deductionInfo.deduction);
            if (this.f15090h) {
                ViewGroup viewGroup = this.f15089g;
                viewGroup.addView(inflate, viewGroup.getChildCount() - 1);
                return;
            }
            this.f15089g.addView(inflate);
        }
    }

    public void removeSupplement() {
        this.f15089g.removeAllViews();
    }

    public void setActionText(String str) {
        this.f15087e.setText(str);
    }

    public void setActionButtonEnable(boolean z) {
        this.f15087e.setEnabled(z);
    }

    public void showTipsCheckbox(String str, boolean z, final IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener) {
        this.f15090h = true;
        View inflate = LayoutInflater.from(this.mContext).inflate(R.layout.global_pe_pay_tips_item, this.f15089g, false);
        final CheckBox checkBox = (CheckBox) inflate.findViewById(R.id.oc_pay_entrance_supplement_checkbox);
        final TextView textView = (TextView) inflate.findViewById(R.id.oc_pay_entrance_supplement_title);
        textView.setText(str);
        if (!z) {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
        } else {
            textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_FC9153));
        }
        checkBox.setChecked(z);
        ((RelativeLayout) inflate.findViewById(R.id.oc_rl_tips_item)).setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                CheckBox checkBox = checkBox;
                checkBox.setChecked(!checkBox.isChecked());
                if (!checkBox.isChecked()) {
                    TextView textView = textView;
                    textView.setTextColor(textView.getContext().getResources().getColor(R.color.pe_color_666666));
                } else {
                    TextView textView2 = textView;
                    textView2.setTextColor(textView2.getContext().getResources().getColor(R.color.pe_color_FC9153));
                }
                IPayEntranceView.OnTipsCheckChangeListener onTipsCheckChangeListener = onTipsCheckChangeListener;
                if (onTipsCheckChangeListener != null) {
                    onTipsCheckChangeListener.onTipsCheckChanged(checkBox.isChecked());
                }
            }
        });
        this.f15089g.addView(inflate);
    }

    public class ValidTextWatcher implements TextWatcher {
        private String pre = "";
        private String regularExpression;

        public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        }

        public ValidTextWatcher(String str) {
            this.regularExpression = str;
        }

        public final void afterTextChanged(Editable editable) {
            String obj = editable.toString();
            boolean matches = (obj.length() <= 0 || TextUtils.isEmpty(this.regularExpression)) ? true : Pattern.matches(this.regularExpression, obj);
            double d = 0.0d;
            try {
                d = Double.valueOf(TextUtil.getFirstMoneyFromText(String.valueOf(SelfInputView.this.f15086d.getText())).trim()).doubleValue();
            } catch (Exception e) {
                SystemUtils.log(6, SelfInputView.f15085c, e.getMessage(), (Throwable) null, "com.didi.component.payentrance.view.impl.SelfInputView$ValidTextWatcher", 217);
            }
            if (d > SelfInputView.f15084b) {
                matches = false;
            }
            if (!matches) {
                editable.replace(0, editable.length(), this.pre);
                return;
            }
            this.pre = obj;
            if (SelfInputView.this.f15091i != null) {
                SelfInputView.this.f15091i.onInputValueChanged(d);
            }
        }
    }
}

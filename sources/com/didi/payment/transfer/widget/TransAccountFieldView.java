package com.didi.payment.transfer.widget;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.passenger.C10448R;
import com.didi.payment.base.widget.CommonEditText;
import com.didi.payment.base.widget.DoubleCheckOnClickListener;
import com.taxis99.R;

public class TransAccountFieldView extends LinearLayout {

    /* renamed from: a */
    private TextView f31511a;

    /* renamed from: b */
    private CommonEditText f31512b;

    /* renamed from: c */
    private TextView f31513c;

    /* renamed from: d */
    private ImageView f31514d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public View f31515e;

    /* renamed from: f */
    private boolean f31516f = false;

    /* renamed from: g */
    private CharSequence f31517g = "";
    /* access modifiers changed from: private */

    /* renamed from: h */
    public OnExpandListener f31518h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public onLoseFocusListener f31519i;

    public interface OnExpandListener {
        void onExpandIconClick();
    }

    public interface onLoseFocusListener {
        void onLoseFocus(TransAccountFieldView transAccountFieldView);
    }

    public TransAccountFieldView(Context context) {
        super(context);
        m22267a();
    }

    public TransAccountFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22267a();
    }

    public TransAccountFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CommonEditText, 0, 0);
        this.f31516f = obtainStyledAttributes.getBoolean(0, false);
        this.f31517g = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        m22267a();
    }

    /* renamed from: a */
    private void m22267a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.trans_newaccount_item_lay, this, true);
        this.f31511a = (TextView) inflate.findViewById(R.id.trans_account_field_label_tv);
        CommonEditText commonEditText = (CommonEditText) inflate.findViewById(R.id.trans_account_field_input_et);
        this.f31512b = commonEditText;
        commonEditText.setHint(this.f31517g);
        this.f31512b.setMaxLines(1);
        this.f31513c = (TextView) inflate.findViewById(R.id.trans_account_field_hidden_info_tv);
        this.f31514d = (ImageView) inflate.findViewById(R.id.trans_expand_img);
        this.f31515e = inflate.findViewById(R.id.divider_line_bottom);
        if (this.f31516f) {
            m22270b();
        }
        this.f31512b.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (!z) {
                    if (TransAccountFieldView.this.f31519i != null) {
                        TransAccountFieldView.this.f31519i.onLoseFocus(TransAccountFieldView.this);
                    }
                    TransAccountFieldView.this.f31515e.setBackgroundColor(TransAccountFieldView.this.getContext().getResources().getColor(R.color.setting_item_divider));
                    return;
                }
                TransAccountFieldView.this.f31515e.setBackgroundColor(Color.parseColor("#FEA330"));
            }
        });
    }

    /* renamed from: b */
    private void m22270b() {
        this.f31514d.setVisibility(0);
        this.f31514d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (TransAccountFieldView.this.f31518h != null) {
                    TransAccountFieldView.this.f31518h.onExpandIconClick();
                }
            }
        });
    }

    public EditText getInputET() {
        return this.f31512b;
    }

    public void setType(CommonEditText.TYPE type) {
        this.f31512b.setType(type);
    }

    public void setLabel(String str) {
        setLabel(str, "");
    }

    public void setText(String str) {
        this.f31512b.setText(str);
    }

    public void setLabel(String str, String str2) {
        this.f31511a.setText(str);
        this.f31512b.setHint(str2);
    }

    public void setMaxLength(int i) {
        this.f31512b.setMaxLength(i);
    }

    public void setEnableExpand(boolean z) {
        this.f31516f = z;
        if (z) {
            m22270b();
        }
    }

    public void setInputEnable(boolean z) {
        this.f31512b.setEnabled(z);
    }

    public void showErrorInfo(String str) {
        this.f31513c.setVisibility(0);
        this.f31513c.setText(str);
        this.f31512b.setTextColor(getContext().getResources().getColor(R.color.transfer_color_failed_red));
    }

    public void hideErrorInfo() {
        this.f31513c.setVisibility(8);
        this.f31512b.setTextColor(getContext().getResources().getColor(R.color.transfer_color_title_black));
    }

    public void setOnTextChangeListener(CommonEditText.OnTextChangeListener onTextChangeListener) {
        this.f31512b.registeTextChangeListener(onTextChangeListener);
    }

    public String getInputValue() {
        return this.f31512b.getTextString();
    }

    public String unMaskInput() {
        String textString = this.f31512b.getTextString();
        if (textString != null) {
            return textString.trim().replaceAll("[.]", "").replaceAll("[-]", "").replaceAll("[ ]", "");
        }
        return "";
    }

    public boolean isValidInput() {
        return !TextUtils.isEmpty(this.f31512b.getTextWithoutSpace());
    }

    public boolean isCPFValidInput() {
        return m22268a(unMaskInput());
    }

    public boolean isAgencyCodeValidInput() {
        return this.f31512b.getTextWithoutSpace().length() == 4;
    }

    /* renamed from: a */
    private boolean m22268a(String str) {
        if (TextUtils.isEmpty(str) || str.length() != 11) {
            return false;
        }
        int[] iArr = new int[11];
        for (int i = 0; i < 11; i++) {
            iArr[i] = Character.getNumericValue(str.charAt(i));
        }
        int i2 = 100;
        int i3 = 0;
        for (int i4 = 0; i4 < 9; i4++) {
            i3 += iArr[i4] * i2;
            i2 -= 10;
        }
        int i5 = i3 % 11;
        if (i5 == 10) {
            i5 = 0;
        }
        if (i5 != iArr[9]) {
            return false;
        }
        int i6 = 110;
        int i7 = 0;
        for (int i8 = 0; i8 < 10; i8++) {
            i7 += iArr[i8] * i6;
            i6 -= 10;
        }
        int i9 = i7 % 11;
        if (i9 == 10) {
            i9 = 0;
        }
        if (i9 == iArr[10]) {
            return true;
        }
        return false;
    }

    public void setOnExpandListener(OnExpandListener onExpandListener) {
        this.f31518h = onExpandListener;
    }

    public void addBankCardInputListener() {
        this.f31512b.addTextChangedListener(new BankCardInputWatcher(this.f31512b));
    }

    public void addCPFCardInputListener() {
        this.f31512b.addTextChangedListener(new CPFInputWatcher(this.f31512b));
    }

    public void setLoseFocusListener(onLoseFocusListener onlosefocuslistener) {
        this.f31519i = onlosefocuslistener;
    }
}

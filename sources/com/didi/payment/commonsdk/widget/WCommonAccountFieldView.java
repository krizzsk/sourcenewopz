package com.didi.payment.commonsdk.widget;

import android.content.Context;
import android.content.res.TypedArray;
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

public class WCommonAccountFieldView extends LinearLayout {
    public static final int MODE_DISPLAY_ONLY = 1;
    public static final int MODE_EDITABLE = 0;

    /* renamed from: a */
    private TextView f30231a;

    /* renamed from: b */
    private CommonEditText f30232b;

    /* renamed from: c */
    private TextView f30233c;

    /* renamed from: d */
    private ImageView f30234d;

    /* renamed from: e */
    private boolean f30235e = false;

    /* renamed from: f */
    private CharSequence f30236f = "";

    /* renamed from: g */
    private TextView f30237g;

    /* renamed from: h */
    private int f30238h = 0;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public OnExpandListener f30239i;

    public interface OnExpandListener {
        void onExpandIconClick();
    }

    public WCommonAccountFieldView(Context context) {
        super(context);
        m21155a();
    }

    public WCommonAccountFieldView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m21155a();
    }

    public WCommonAccountFieldView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.WCommonEditText, 0, 0);
        this.f30235e = obtainStyledAttributes.getBoolean(0, false);
        this.f30236f = obtainStyledAttributes.getText(1);
        obtainStyledAttributes.recycle();
        m21155a();
    }

    /* renamed from: a */
    private void m21155a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.wcommon_account_field_lay, this, true);
        this.f30231a = (TextView) inflate.findViewById(R.id.common_account_field_label_tv);
        this.f30232b = (CommonEditText) inflate.findViewById(R.id.common_account_field_input_et);
        this.f30237g = (TextView) inflate.findViewById(R.id.common_account_field_input_tv);
        this.f30232b.setHint(this.f30236f);
        this.f30232b.setMaxLines(1);
        this.f30233c = (TextView) inflate.findViewById(R.id.common_account_field_hidden_info_tv);
        this.f30234d = (ImageView) inflate.findViewById(R.id.common_expand_img);
        if (this.f30235e) {
            enableExpandFunc();
        }
    }

    public void switchType(boolean z) {
        if (z) {
            this.f30232b.setVisibility(0);
            if (this.f30237g.getVisibility() == 0) {
                this.f30232b.setVisibility(8);
            }
            this.f30238h = 0;
            return;
        }
        this.f30232b.setVisibility(4);
        if (this.f30237g.getVisibility() != 0) {
            this.f30237g.setVisibility(0);
        }
        this.f30238h = 1;
    }

    public void enableExpandFunc() {
        this.f30234d.setVisibility(0);
        this.f30234d.setOnClickListener(new DoubleCheckOnClickListener() {
            public void doClick(View view) {
                if (WCommonAccountFieldView.this.f30239i != null) {
                    WCommonAccountFieldView.this.f30239i.onExpandIconClick();
                }
            }
        });
    }

    public EditText getInputET() {
        return this.f30232b;
    }

    public TextView getInputTv() {
        return this.f30237g;
    }

    @Deprecated
    public void setType(CommonEditText.TYPE type) {
        this.f30232b.setType(type);
    }

    public void setEditType(CommonEditText.TYPE type) {
        this.f30232b.setType(type);
    }

    public void setLabel(String str) {
        setLabel(str, "");
    }

    public void setExpandImg(int i) {
        this.f30234d.setImageResource(i);
    }

    public void setText(String str) {
        m21156b();
        if (this.f30238h == 0) {
            this.f30232b.setText(str);
        } else {
            this.f30237g.setText(str);
        }
    }

    /* renamed from: b */
    private void m21156b() {
        if (this.f30238h == 0) {
            this.f30232b.setVisibility(0);
            this.f30237g.setVisibility(8);
            return;
        }
        this.f30232b.setVisibility(4);
        this.f30237g.setVisibility(0);
    }

    public void setLabel(String str, String str2) {
        this.f30231a.setText(str);
        if (this.f30232b.getVisibility() == 0) {
            this.f30232b.setHint(str2);
        } else {
            this.f30237g.setHint(str2);
        }
    }

    public void setMaxLength(int i) {
        this.f30232b.setMaxLength(i);
    }

    public void setEnableExpand(boolean z) {
        this.f30235e = z;
        if (z) {
            enableExpandFunc();
        }
    }

    public void setInputEnable(boolean z) {
        this.f30232b.setEnabled(z);
    }

    public void showErrorInfo(String str) {
        this.f30233c.setVisibility(0);
        this.f30233c.setText(str);
    }

    public void setOnTextChangeListener(CommonEditText.OnTextChangeListener onTextChangeListener) {
        this.f30232b.registeTextChangeListener(onTextChangeListener);
    }

    public String getInputValue() {
        if (this.f30238h == 0) {
            return this.f30232b.getTextString();
        }
        return String.valueOf(this.f30237g.getText());
    }

    public boolean isValidInput() {
        return !TextUtils.isEmpty(this.f30232b.getTextWithoutSpace());
    }

    public void setOnExpandListener(OnExpandListener onExpandListener) {
        this.f30239i = onExpandListener;
    }
}

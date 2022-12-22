package com.didi.unifylogin.utils.customview;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.Editable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import com.didi.passenger.C10448R;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.unifylogin.utils.LoginDisplayMetrics;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.UiUtils;
import com.didi.unifylogin.utils.customview.CodeInputEditText;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class CodeInputView extends LinearLayout {

    /* renamed from: a */
    private static final String f44961a = "CodeInputView";

    /* renamed from: b */
    private static final int f44962b = 4;

    /* renamed from: c */
    private int f44963c;

    /* renamed from: d */
    private int f44964d;

    /* renamed from: e */
    private int f44965e;

    /* renamed from: f */
    private int f44966f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public List<CodeInputEditText> f44967g;

    /* renamed from: h */
    private Context f44968h;

    /* renamed from: i */
    private AttributeSet f44969i;

    /* renamed from: j */
    private InputCompleteListener f44970j;

    /* renamed from: k */
    private ClearCodeListener f44971k;

    public interface ClearCodeListener {
        void onClearCode();
    }

    public interface InputCompleteListener {
        void onInputComplete(String str);
    }

    public CodeInputView(Context context) {
        this(context, (AttributeSet) null);
    }

    public CodeInputView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public CodeInputView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f44968h = context;
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.MyCoedEdit);
        this.f44963c = obtainStyledAttributes.getInt(0, 4);
        obtainStyledAttributes.recycle();
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C10448R.styleable.CodeInputView);
        this.f44964d = obtainStyledAttributes2.getInt(0, -1);
        obtainStyledAttributes2.recycle();
    }

    /* renamed from: a */
    private void m32234a(int i) {
        if (i > 0) {
            for (CodeInputEditText inputType : this.f44967g) {
                inputType.setInputType(i);
            }
        }
    }

    /* renamed from: a */
    private void m32235a(Context context) {
        LinearLayout linearLayout = (LinearLayout) LayoutInflater.from(getContext()).inflate(R.layout.login_unify_view_code_input, this).findViewById(R.id.ll_code_layout);
        int width = (int) (((float) LoginDisplayMetrics.getWidth(context)) - (LoginDisplayMetrics.getDensity(context) * 40.0f));
        this.f44965e = UiUtils.dip2px(context, 48.0f);
        int dip2px = UiUtils.dip2px(context, 32.0f);
        this.f44966f = dip2px;
        int i = this.f44965e;
        int i2 = this.f44963c;
        int i3 = (i * i2) + (dip2px * (i2 - 1));
        if (i3 > width) {
            int dip2px2 = UiUtils.dip2px(context, 10.0f);
            while (true) {
                int i4 = this.f44966f;
                if (i4 >= dip2px2 && i3 > width) {
                    int i5 = i4 - 10;
                    this.f44966f = i5;
                    int i6 = this.f44965e;
                    int i7 = this.f44963c;
                    i3 = (i6 * i7) + (i5 * (i7 - 1));
                }
            }
            if (this.f44966f < dip2px2) {
                this.f44966f = dip2px2;
                int i8 = this.f44965e;
                int i9 = this.f44963c;
                int i10 = (i8 * i9) + (dip2px2 * (i9 - 1));
                while (true) {
                    int i11 = this.f44965e;
                    if (i11 <= 0 || i10 <= width) {
                        break;
                    }
                    int i12 = i11 - 10;
                    this.f44965e = i12;
                    int i13 = this.f44963c;
                    i10 = (i12 * i13) + (this.f44966f * (i13 - 1));
                }
            }
        }
        LoginLog.write("CodeInputView width:" + width);
        LoginLog.write("CodeInputView boxw :" + this.f44965e);
        LoginLog.write("CodeInputView margin:" + this.f44966f);
        if (this.f44965e > 0) {
            this.f44967g = new ArrayList();
            for (int i14 = 0; i14 < this.f44963c; i14++) {
                View inflate = LayoutInflater.from(getContext()).inflate(R.layout.login_unify_code_edit, (ViewGroup) null);
                CodeInputEditText codeInputEditText = (CodeInputEditText) inflate.findViewById(R.id.small_login_cod);
                codeInputEditText.setContentDescription(RavenKey.STACK + i14);
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) codeInputEditText.getLayoutParams();
                layoutParams.height = this.f44965e;
                layoutParams.width = this.f44965e;
                layoutParams.weight = 1.0f;
                if (i14 == this.f44963c - 1) {
                    layoutParams.setMargins(0, 0, 0, 0);
                } else {
                    layoutParams.setMargins(0, 0, this.f44966f, 0);
                    layoutParams.setMarginEnd(this.f44966f);
                }
                codeInputEditText.setVisibility(0);
                this.f44967g.add(codeInputEditText);
                linearLayout.addView(inflate);
            }
            CodeFocusChangeListener codeFocusChangeListener = new CodeFocusChangeListener();
            for (CodeInputEditText next : this.f44967g) {
                next.setOnFocusChangeListener(codeFocusChangeListener);
                next.addTextChangedListener(new CodeTextChangedListener(this.f44967g.indexOf(next)));
                next.setDelKeyEventListener(new CodeInputEditText.OnDelKeyEventListener() {
                    public void onDeleteClick(CodeInputEditText codeInputEditText) {
                        if (TextUtils.isEmpty(codeInputEditText.getText().toString())) {
                            CodeInputView.this.m32238b((EditText) codeInputEditText);
                        }
                    }
                });
            }
        }
    }

    public void setCode(final String str) {
        SystemUtils.log(3, f44961a, "[setCode] " + str, (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView", 153);
        if (!TextUtils.isEmpty(str) && str.length() == this.f44967g.size()) {
            UiThreadHandler.post(new Runnable() {
                public void run() {
                    int i = 0;
                    while (i < CodeInputView.this.f44967g.size() && i < str.length()) {
                        int i2 = i + 1;
                        ((CodeInputEditText) CodeInputView.this.f44967g.get(i)).setText(str.substring(i, i2));
                        i = i2;
                    }
                }
            });
        }
    }

    public String getCode() {
        StringBuilder sb = new StringBuilder();
        for (CodeInputEditText text : this.f44967g) {
            sb.append(text.getText().toString());
        }
        return sb.toString();
    }

    /* renamed from: a */
    private boolean m32237a(EditText editText) {
        return !TextUtils.isEmpty(editText.getText().toString());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32233a() {
        for (CodeInputEditText a : this.f44967g) {
            if (!m32237a((EditText) a)) {
                return;
            }
        }
        SystemUtils.log(4, f44961a, "checkComplete: ", (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView", 186);
        InputCompleteListener inputCompleteListener = this.f44970j;
        if (inputCompleteListener != null) {
            inputCompleteListener.onInputComplete(getCode());
        }
    }

    public void clearCode() {
        for (CodeInputEditText text : this.f44967g) {
            text.setText("");
        }
        this.f44967g.get(0).requestFocus();
        ClearCodeListener clearCodeListener = this.f44971k;
        if (clearCodeListener != null) {
            clearCodeListener.onClearCode();
        }
    }

    public EditText getCodeView(int i) {
        List<CodeInputEditText> list = this.f44967g;
        if (list != null && i < list.size()) {
            return this.f44967g.get(0);
        }
        return null;
    }

    class CodeFocusChangeListener implements View.OnFocusChangeListener {
        CodeFocusChangeListener() {
        }

        public void onFocusChange(View view, boolean z) {
            SystemUtils.log(3, "tom", "onFocusChange viewId: " + view.getId() + " focus: " + z, (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView$CodeFocusChangeListener", 216);
        }
    }

    class CodeTextChangedListener extends LoginTextWatcher {
        int index = 0;

        public CodeTextChangedListener(int i) {
            this.index = i;
        }

        public void afterTextChanged(Editable editable) {
            int i;
            SystemUtils.log(3, CodeInputView.f44961a, "afterTextChanged: " + editable.toString(), (Throwable) null, "com.didi.unifylogin.utils.customview.CodeInputView$CodeTextChangedListener", 238);
            int i2 = this.index;
            if (i2 >= 0 && i2 <= CodeInputView.this.f44967g.size() && !TextUtil.isEmpty(editable.toString())) {
                boolean z = ((CodeInputEditText) CodeInputView.this.f44967g.get(this.index)).getSelectionStart() == 1;
                if (editable.length() > 1) {
                    int length = editable.length();
                    String obj = editable.toString();
                    if (z) {
                        i = 0;
                    } else {
                        i = editable.length() - 1;
                    }
                    editable.replace(0, length, obj, i, z ? 1 : editable.length());
                    return;
                }
                if (this.index + 1 < CodeInputView.this.f44967g.size()) {
                    ((CodeInputEditText) CodeInputView.this.f44967g.get(this.index + 1)).requestFocus();
                }
                CodeInputView.this.m32233a();
            }
        }
    }

    public void setInputCompleteListener(InputCompleteListener inputCompleteListener) {
        this.f44970j = inputCompleteListener;
    }

    public void setClearCodeListener(ClearCodeListener clearCodeListener) {
        this.f44971k = clearCodeListener;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m32238b(EditText editText) {
        int indexOf = this.f44967g.indexOf(editText);
        if (indexOf > 0) {
            int i = indexOf - 1;
            this.f44967g.get(i).setText("");
            this.f44967g.get(i).requestFocus();
        }
    }

    public CodeInputView setCodeLength(int i) {
        if (i > 0) {
            this.f44963c = i;
        }
        return this;
    }

    public CodeInputView setInputyType(int i) {
        this.f44964d = i;
        return this;
    }

    public void build() {
        m32235a(this.f44968h);
        m32234a(this.f44964d);
    }
}

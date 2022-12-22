package com.didi.rfusion.widget.textfield;

import android.content.Context;
import android.content.res.TypedArray;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import com.didi.passenger.C10448R;
import com.didi.rfusion.utils.RFFontUtils;
import com.didi.rfusion.utils.RFResUtils;
import com.taxis99.R;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0002\b\u000e\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\b\u0010\r\u001a\u0004\u0018\u00010\u000eJ\u0018\u0010\u000f\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u0007H\u0014J\u0010\u0010\u0012\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fJ\u000e\u0010\u0013\u001a\u00020\n2\u0006\u0010\u0014\u001a\u00020\u0007J\u000e\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0016\u001a\u00020\u0007J\u0016\u0010\u0015\u001a\u00020\n2\u0006\u0010\u0017\u001a\u00020\u00072\u0006\u0010\u0018\u001a\u00020\u0007J\u0010\u0010\u0019\u001a\u00020\n2\b\u0010\u001a\u001a\u0004\u0018\u00010\u000eJ\u0010\u0010\u0019\u001a\u00020\n2\b\b\u0001\u0010\u001b\u001a\u00020\u0007¨\u0006\u001c"}, mo175978d2 = {"Lcom/didi/rfusion/widget/textfield/RFTextField;", "Lcom/didi/rfusion/widget/textfield/RFTextInputLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addTextChangedListener", "", "watcher", "Landroid/text/TextWatcher;", "getText", "", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "removeTextChangedListener", "setMaxLines", "maxLines", "setSelection", "selection", "start", "end", "setText", "text", "resId", "r-fusion_ninePhoneRelease"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: RFTextField.kt */
public final class RFTextField extends RFTextInputLayout {

    /* renamed from: c */
    private HashMap f33782c;

    public RFTextField(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    public RFTextField(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
    }

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f33782c;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f33782c == null) {
            this.f33782c = new HashMap();
        }
        View view = (View) this.f33782c.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f33782c.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ RFTextField(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public RFTextField(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        int i2;
        Intrinsics.checkParameterIsNotNull(context, "context");
        RFTextInputLayout.inflate(context, R.layout.rf_layout_text_field_edit_text, this);
        if (isPasswordVisibilityToggleEnabled()) {
            i2 = 129;
        } else {
            EditText editText = getEditText();
            i2 = editText != null ? editText.getInputType() : 1;
        }
        TypedArray obtainStyledAttributes = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFTextField);
        int i3 = obtainStyledAttributes.getInt(1, i2);
        String string = obtainStyledAttributes.getString(0);
        obtainStyledAttributes.recycle();
        EditText editText2 = getEditText();
        if (editText2 != null) {
            editText2.setInputType(i3);
        }
        if (string != null) {
            EditText editText3 = getEditText();
            if (editText3 != null) {
                editText3.setKeyListener(DigitsKeyListener.getInstance(string.toString()));
            }
            EditText editText4 = getEditText();
            if (editText4 != null) {
                editText4.setRawInputType(i3);
            }
        }
        TypedArray obtainStyledAttributes2 = context.obtainStyledAttributes(attributeSet, C10448R.styleable.RFTextInputLayout);
        int i4 = obtainStyledAttributes2.getInt(5, 1);
        boolean z = obtainStyledAttributes2.getBoolean(7, true);
        int i5 = obtainStyledAttributes2.getInt(8, -1);
        obtainStyledAttributes2.recycle();
        if (i4 == 2) {
            EditText editText5 = getEditText();
            if (editText5 != null) {
                editText5.setTextSize(0, RFResUtils.getDimens(R.dimen.f_10_app_28_pad_16));
            }
            EditText editText6 = getEditText();
            if (editText6 != null) {
                editText6.setTypeface(RFFontUtils.getFontTypeFace(context, 0));
            }
            if ((131072 & i3) != 0) {
                setErrorIconEnabled(false);
                setHintAnimationEnabled(false);
                setCollapsedHintEnabled(false);
                setCounterEnabled(z);
                if (i5 == -1) {
                    setCounterLocation(0);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        super.onMeasure(i, i2);
        int mode = View.MeasureSpec.getMode(i2);
        EditText editText = getEditText();
        if (editText == null) {
            Intrinsics.throwNpe();
        }
        Intrinsics.checkExpressionValueIsNotNull(editText, "getEditText()!!");
        ViewGroup.LayoutParams layoutParams = editText.getLayoutParams();
        if (mode == 1073741824) {
            if (layoutParams.height != -1) {
                layoutParams.height = -1;
                EditText editText2 = getEditText();
                if (editText2 == null) {
                    Intrinsics.throwNpe();
                }
                Intrinsics.checkExpressionValueIsNotNull(editText2, "getEditText()!!");
                editText2.setLayoutParams(layoutParams);
            }
        } else if (layoutParams.height != -2) {
            layoutParams.height = -2;
            EditText editText3 = getEditText();
            if (editText3 == null) {
                Intrinsics.throwNpe();
            }
            Intrinsics.checkExpressionValueIsNotNull(editText3, "getEditText()!!");
            editText3.setLayoutParams(layoutParams);
        }
    }

    public final void addTextChangedListener(TextWatcher textWatcher) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.addTextChangedListener(textWatcher);
        }
    }

    public final void removeTextChangedListener(TextWatcher textWatcher) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.removeTextChangedListener(textWatcher);
        }
    }

    public final void setSelection(int i) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.setSelection(i);
        }
    }

    public final void setSelection(int i, int i2) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.setSelection(i, i2);
        }
    }

    public final void setText(CharSequence charSequence) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.setText(charSequence);
        }
    }

    public final void setText(int i) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.setText(i);
        }
    }

    public final CharSequence getText() {
        EditText editText = getEditText();
        return editText != null ? editText.getText() : null;
    }

    public final void setMaxLines(int i) {
        EditText editText = getEditText();
        if (editText != null) {
            editText.setMaxLines(i);
        }
    }
}

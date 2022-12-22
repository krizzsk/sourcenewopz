package com.didi.payment.wallet_ui;

import android.graphics.Color;
import android.graphics.Paint;
import android.os.Build;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.widget.EditText;
import android.widget.TextView;
import com.google.android.material.shape.MaterialShapeDrawable;
import com.google.android.material.shape.RoundedCornerTreatment;
import com.google.android.material.shape.ShapeAppearanceModel;
import java.lang.reflect.Method;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000N\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0007\n\u0002\b\u0005\u001a\u0018\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002\u001a\u001e\u0010\u0012\u001a\u00020\r*\u0004\u0018\u00010\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u00152\u0006\u0010\u0016\u001a\u00020\u0017\u001a\f\u0010\u0018\u001a\u00020\r*\u0004\u0018\u00010\u0019\u001a\f\u0010\u001a\u001a\u00020\r*\u0004\u0018\u00010\u0013\u001a\f\u0010\u001b\u001a\u00020\r*\u0004\u0018\u00010\u001c\u001a\u0014\u0010\u001d\u001a\u00020\r*\u0004\u0018\u00010\u00192\u0006\u0010\u001d\u001a\u00020\u0011\u001a\u0014\u0010\u001e\u001a\u00020\r*\u0004\u0018\u00010\u00192\u0006\u0010\u0010\u001a\u00020\u0011\u001a\u001c\u0010\u001f\u001a\u00020\r*\u0004\u0018\u00010\u00192\u0006\u0010 \u001a\u00020\u00112\u0006\u0010\u0010\u001a\u00020\u0011\u001a@\u0010!\u001a\u00020\r*\u0004\u0018\u00010\u001c2\b\b\u0002\u0010\"\u001a\u00020#2\b\b\u0003\u0010$\u001a\u00020\u00172\b\b\u0002\u0010%\u001a\u00020#2\b\b\u0003\u0010&\u001a\u00020\u00172\b\b\u0002\u0010'\u001a\u00020\u0017H\u0007\"\u001a\u0010\u0000\u001a\u00020\u0001X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0002\u0010\u0003\"\u0004\b\u0004\u0010\u0005\"\u001c\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000b¨\u0006("}, mo175978d2 = {"switchWalletUIImpl", "", "getSwitchWalletUIImpl", "()Z", "setSwitchWalletUIImpl", "(Z)V", "walletUIImpl", "Lcom/didi/payment/wallet_ui/IWalletUI;", "getWalletUIImpl", "()Lcom/didi/payment/wallet_ui/IWalletUI;", "setWalletUIImpl", "(Lcom/didi/payment/wallet_ui/IWalletUI;)V", "checkDecimalNum", "", "editable", "Landroid/text/Editable;", "decimalText", "", "configTextLength", "Landroid/widget/TextView;", "content", "", "maxLength", "", "delete", "Landroid/widget/EditText;", "disableShowSoftInputOnFocus", "hideSystemInputMethod", "Landroid/view/View;", "insert", "insertDecimal", "insertNum", "num", "withCardBg", "cornerSize", "", "bgColor", "shadowSize", "shadowColor", "verticalOffset", "wallet-ui_globalRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: UiUtils.kt */
public final class UiUtilsKt {

    /* renamed from: a */
    private static boolean f32873a;

    /* renamed from: b */
    private static IWalletUI f32874b;

    public static final boolean getSwitchWalletUIImpl() {
        return f32873a;
    }

    public static final void setSwitchWalletUIImpl(boolean z) {
        f32873a = z;
    }

    public static final IWalletUI getWalletUIImpl() {
        return f32874b;
    }

    public static final void setWalletUIImpl(IWalletUI iWalletUI) {
        f32874b = iWalletUI;
    }

    public static /* synthetic */ void withCardBg$default(View view, float f, int i, float f2, int i2, int i3, int i4, Object obj) {
        if ((i4 & 1) != 0) {
            f = UiUtils.Companion.floatSize(20);
        }
        int i5 = (i4 & 2) != 0 ? -1 : i;
        float f3 = (i4 & 4) != 0 ? 0.0f : f2;
        if ((i4 & 8) != 0) {
            i2 = Color.parseColor("#0A212325");
        }
        int i6 = i2;
        if ((i4 & 16) != 0) {
            i3 = UiUtils.Companion.intSize(4);
        }
        withCardBg(view, f, i5, f3, i6, i3);
    }

    public static final void withCardBg(View view, float f, int i, float f2, int i2, int i3) {
        if (view != null) {
            ViewParent parent = view.getParent();
            ViewGroup viewGroup = parent instanceof ViewGroup ? (ViewGroup) parent : null;
            if (viewGroup != null) {
                viewGroup.setClipChildren(false);
            }
            MaterialShapeDrawable materialShapeDrawable = new MaterialShapeDrawable(ShapeAppearanceModel.builder().setAllCorners(new RoundedCornerTreatment()).setAllCornerSizes(f).build());
            materialShapeDrawable.setPaintStyle(Paint.Style.FILL);
            materialShapeDrawable.setTint(i);
            materialShapeDrawable.setShadowCompatibilityMode(2);
            materialShapeDrawable.initializeElevationOverlay(view.getContext());
            materialShapeDrawable.setElevation(f2);
            materialShapeDrawable.setShadowVerticalOffset(i3);
            materialShapeDrawable.setShadowColor(i2);
            Unit unit = Unit.INSTANCE;
            view.setBackground(materialShapeDrawable);
        }
    }

    public static final void configTextLength(TextView textView, CharSequence charSequence, int i) {
        if (textView != null) {
            if (charSequence == null || charSequence.length() <= i) {
                textView.setText(charSequence);
            } else {
                textView.setText(TextUtils.ellipsize(charSequence, textView.getPaint(), textView.getPaint().measureText(charSequence, 0, i + 1), TextUtils.TruncateAt.END));
            }
        }
    }

    public static final void insert(EditText editText, String str) {
        Editable text;
        Intrinsics.checkNotNullParameter(str, "insert");
        if (editText != null && (text = editText.getText()) != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, str);
            } else {
                text.insert(selectionStart, str);
            }
        }
    }

    public static final void insertNum(EditText editText, String str, String str2) {
        Editable text;
        Intrinsics.checkNotNullParameter(str, "num");
        Intrinsics.checkNotNullParameter(str2, "decimalText");
        if (editText != null && (text = editText.getText()) != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.replace(selectionStart, selectionEnd, str);
            } else {
                text.insert(selectionStart, str);
            }
            m23186a(text, str2);
        }
    }

    /* renamed from: a */
    private static final void m23186a(Editable editable, String str) {
        CharSequence charSequence = editable;
        if (StringsKt.startsWith$default(charSequence, (CharSequence) "0", false, 2, (Object) null)) {
            int i = -1;
            int i2 = 0;
            while (i2 < editable.length()) {
                char charAt = editable.charAt(i2);
                i2++;
                i++;
                if (charAt != '0') {
                    break;
                }
            }
            int i3 = i;
            int indexOf$default = StringsKt.indexOf$default(charSequence, str, 0, false, 6, (Object) null);
            if (indexOf$default < 0) {
                editable.replace(0, i3, "");
            } else if (indexOf$default > 1) {
                if (i3 == indexOf$default) {
                    i3--;
                }
                editable.replace(0, i3, "");
            }
        }
    }

    public static final void insertDecimal(EditText editText, String str) {
        Editable text;
        Intrinsics.checkNotNullParameter(str, "decimalText");
        if (editText != null && (text = editText.getText()) != null) {
            CharSequence charSequence = text;
            if (charSequence.length() > 0) {
                CharSequence charSequence2 = str;
                if (!StringsKt.contains$default(charSequence, charSequence2, false, 2, (Object) null)) {
                    int selectionStart = editText.getSelectionStart();
                    int selectionEnd = editText.getSelectionEnd();
                    if (selectionEnd > selectionStart) {
                        text.replace(selectionStart, selectionEnd, charSequence2);
                    } else {
                        text.insert(selectionStart, charSequence2);
                    }
                }
            }
            if (StringsKt.startsWith$default(charSequence, (CharSequence) "0", false, 2, (Object) null)) {
                m23186a(text, str);
            }
        }
    }

    public static final void delete(EditText editText) {
        Editable text;
        if (editText != null && (text = editText.getText()) != null) {
            int selectionStart = editText.getSelectionStart();
            int selectionEnd = editText.getSelectionEnd();
            if (selectionEnd > selectionStart) {
                text.delete(selectionStart, selectionEnd);
                return;
            }
            int i = selectionStart - 1;
            if (i < 0) {
                i = 0;
            }
            text.delete(i, selectionStart);
            editText.setSelection(i);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:3:0x0005, code lost:
        r1 = r3.getContext();
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void hideSystemInputMethod(android.view.View r3) {
        /*
            r0 = 0
            if (r3 != 0) goto L_0x0005
        L_0x0003:
            r1 = r0
            goto L_0x0012
        L_0x0005:
            android.content.Context r1 = r3.getContext()
            if (r1 != 0) goto L_0x000c
            goto L_0x0003
        L_0x000c:
            java.lang.String r2 = "input_method"
            java.lang.Object r1 = r1.getSystemService(r2)
        L_0x0012:
            boolean r2 = r1 instanceof android.view.inputmethod.InputMethodManager
            if (r2 == 0) goto L_0x0019
            r0 = r1
            android.view.inputmethod.InputMethodManager r0 = (android.view.inputmethod.InputMethodManager) r0
        L_0x0019:
            if (r0 != 0) goto L_0x001c
            goto L_0x0024
        L_0x001c:
            android.os.IBinder r3 = r3.getWindowToken()
            r1 = 0
            r0.hideSoftInputFromWindow(r3, r1)
        L_0x0024:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.wallet_ui.UiUtilsKt.hideSystemInputMethod(android.view.View):void");
    }

    public static final void disableShowSoftInputOnFocus(TextView textView) {
        if (textView != null) {
            if (Build.VERSION.SDK_INT < 21) {
                Class<EditText> cls = EditText.class;
                try {
                    Method method = cls.getMethod("setShowSoftInputOnFocus", new Class[]{Boolean.TYPE});
                    method.setAccessible(true);
                    method.invoke(textView, new Object[]{false});
                } catch (Exception unused) {
                    textView.setInputType(0);
                }
            } else {
                textView.setShowSoftInputOnFocus(false);
            }
        }
    }
}

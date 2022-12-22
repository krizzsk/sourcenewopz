package com.didi.soda.bill.component.cpf;

import android.content.Context;
import android.text.Editable;
import android.text.TextWatcher;
import android.text.method.DigitsKeyListener;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.raven.config.RavenKey;
import com.didi.rfusion.widget.RFTextView;
import com.didi.soda.customer.foundation.util.KeyboardUtils;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.MaxLengthEditText;
import com.facebook.appevents.internal.ViewHierarchyConstants;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0010\f\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u000b\u0018\u0000 *2\u00020\u0001:\u0002*+B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u001fJ\b\u0010 \u001a\u00020!H\u0002J8\u0010\"\u001a\u00020!2\u0018\u0010\u000b\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r0\f2\u0006\u0010#\u001a\u00020\t2\u0006\u0010$\u001a\u00020\u001f2\u0006\u0010%\u001a\u00020\u001fJ\u0006\u0010&\u001a\u00020!J\u000e\u0010'\u001a\u00020!2\u0006\u0010(\u001a\u00020\u001fJ\u000e\u0010)\u001a\u00020!2\u0006\u0010\u000f\u001a\u00020\u0010R\"\u0010\u000b\u001a\u0016\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\u000e0\r\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u0014X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0016X.¢\u0006\u0002\n\u0000R\u0011\u0010\u001a\u001a\u00020\u001b¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d¨\u0006,"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "keyMap", "", "Lkotlin/Pair;", "", "listener", "Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView$EditChangeListener;", "mCleanBtn", "Landroid/widget/ImageView;", "mEditText", "Lcom/didi/soda/customer/widget/MaxLengthEditText;", "mInfoText", "Lcom/didi/rfusion/widget/RFTextView;", "mLineView", "Landroid/view/View;", "mTitle", "watcher", "Landroid/text/TextWatcher;", "getWatcher", "()Landroid/text/TextWatcher;", "getEditText", "", "init", "", "initData", "maxNumber", "title", "hint", "postRequestFocus", "refresh", "info", "setEditChangeListener", "Companion", "EditChangeListener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CPFCheckEditItemView.kt */
public final class CPFCheckEditItemView extends ConstraintLayout {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String DIGITS = "0123456789abcdefghigklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ.-/";

    /* renamed from: a */
    private MaxLengthEditText f38914a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f38915b;

    /* renamed from: c */
    private RFTextView f38916c;

    /* renamed from: d */
    private View f38917d;

    /* renamed from: e */
    private RFTextView f38918e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public List<Pair<Integer, Character>> f38919f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditChangeListener f38920g;

    /* renamed from: h */
    private final TextWatcher f38921h = new CPFCheckEditItemView$watcher$1(this);

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView$EditChangeListener;", "", "afterTextChanged", "", "s", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CPFCheckEditItemView.kt */
    public interface EditChangeListener {
        void afterTextChanged(String str);
    }

    public void _$_clearFindViewByIdCache() {
    }

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/bill/component/cpf/CPFCheckEditItemView$Companion;", "", "()V", "DIGITS", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CPFCheckEditItemView.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPFCheckEditItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m27629a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPFCheckEditItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m27629a();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public CPFCheckEditItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        m27629a();
    }

    /* renamed from: a */
    private final void m27629a() {
        LayoutInflater.from(getContext()).inflate(R.layout.customer_component_cpf_check_item, this);
        View findViewById = findViewById(R.id.customer_component_cpf_check_cpf);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.custom…_component_cpf_check_cpf)");
        this.f38918e = (RFTextView) findViewById;
        View findViewById2 = findViewById(R.id.customer_component_cpf_check_edit);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.custom…component_cpf_check_edit)");
        this.f38914a = (MaxLengthEditText) findViewById2;
        View findViewById3 = findViewById(R.id.customer_component_cpf_check_edit_delete);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.custom…nt_cpf_check_edit_delete)");
        this.f38915b = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_component_cpf_check_line);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.custom…component_cpf_check_line)");
        this.f38917d = findViewById4;
        View findViewById5 = findViewById(R.id.customer_component_cpf_check_info);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…component_cpf_check_info)");
        this.f38916c = (RFTextView) findViewById5;
    }

    public final void initData(List<Pair<Integer, Character>> list, int i, String str, String str2) {
        Intrinsics.checkNotNullParameter(list, "keyMap");
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, ViewHierarchyConstants.HINT_KEY);
        this.f38919f = list;
        RFTextView rFTextView = this.f38918e;
        ImageView imageView = null;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitle");
            rFTextView = null;
        }
        rFTextView.setText(str);
        MaxLengthEditText maxLengthEditText = this.f38914a;
        if (maxLengthEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText = null;
        }
        maxLengthEditText.setHint(str2);
        MaxLengthEditText maxLengthEditText2 = this.f38914a;
        if (maxLengthEditText2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText2 = null;
        }
        maxLengthEditText2.setMaxNumber(i);
        MaxLengthEditText maxLengthEditText3 = this.f38914a;
        if (maxLengthEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText3 = null;
        }
        maxLengthEditText3.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public final void onFocusChange(View view, boolean z) {
                CPFCheckEditItemView.m27632a(CPFCheckEditItemView.this, view, z);
            }
        });
        MaxLengthEditText maxLengthEditText4 = this.f38914a;
        if (maxLengthEditText4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText4 = null;
        }
        maxLengthEditText4.addTextChangedListener(this.f38921h);
        MaxLengthEditText maxLengthEditText5 = this.f38914a;
        if (maxLengthEditText5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText5 = null;
        }
        maxLengthEditText5.setInputType(2);
        MaxLengthEditText maxLengthEditText6 = this.f38914a;
        if (maxLengthEditText6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText6 = null;
        }
        maxLengthEditText6.setKeyListener(DigitsKeyListener.getInstance(DIGITS));
        ImageView imageView2 = this.f38915b;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCleanBtn");
        } else {
            imageView = imageView2;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                CPFCheckEditItemView.m27631a(CPFCheckEditItemView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27632a(CPFCheckEditItemView cPFCheckEditItemView, View view, boolean z) {
        Intrinsics.checkNotNullParameter(cPFCheckEditItemView, "this$0");
        ImageView imageView = null;
        if (z) {
            MaxLengthEditText maxLengthEditText = cPFCheckEditItemView.f38914a;
            if (maxLengthEditText == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mEditText");
                maxLengthEditText = null;
            }
            Editable editableText = maxLengthEditText.getEditableText();
            if (editableText != null) {
                if (!(editableText.length() > 0)) {
                    editableText = null;
                }
                if (editableText != null) {
                    ImageView imageView2 = cPFCheckEditItemView.f38915b;
                    if (imageView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("mCleanBtn");
                    } else {
                        imageView = imageView2;
                    }
                    imageView.setVisibility(0);
                    return;
                }
                return;
            }
            return;
        }
        ImageView imageView3 = cPFCheckEditItemView.f38915b;
        if (imageView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mCleanBtn");
        } else {
            imageView = imageView3;
        }
        imageView.setVisibility(4);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27631a(CPFCheckEditItemView cPFCheckEditItemView, View view) {
        Intrinsics.checkNotNullParameter(cPFCheckEditItemView, "this$0");
        MaxLengthEditText maxLengthEditText = cPFCheckEditItemView.f38914a;
        if (maxLengthEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText = null;
        }
        maxLengthEditText.setText("");
    }

    public final void refresh(String str) {
        Intrinsics.checkNotNullParameter(str, "info");
        RFTextView rFTextView = this.f38916c;
        View view = null;
        if (rFTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mInfoText");
            rFTextView = null;
        }
        CharSequence charSequence = str;
        rFTextView.setText(charSequence);
        if (charSequence.length() == 0) {
            View view2 = this.f38917d;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mLineView");
            } else {
                view = view2;
            }
            view.setBackgroundColor(ResourceHelper.getColor(R.color.rf_color_gery_5_90_E5E5E5));
            return;
        }
        View view3 = this.f38917d;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mLineView");
        } else {
            view = view3;
        }
        view.setBackgroundColor(ResourceHelper.getColor(R.color.color_FF4E45));
    }

    public final void postRequestFocus() {
        post(new Runnable() {
            public final void run() {
                CPFCheckEditItemView.m27630a(CPFCheckEditItemView.this);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27630a(CPFCheckEditItemView cPFCheckEditItemView) {
        Intrinsics.checkNotNullParameter(cPFCheckEditItemView, "this$0");
        MaxLengthEditText maxLengthEditText = cPFCheckEditItemView.f38914a;
        MaxLengthEditText maxLengthEditText2 = null;
        if (maxLengthEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText = null;
        }
        maxLengthEditText.requestFocus();
        Context context = cPFCheckEditItemView.getContext();
        MaxLengthEditText maxLengthEditText3 = cPFCheckEditItemView.f38914a;
        if (maxLengthEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            maxLengthEditText2 = maxLengthEditText3;
        }
        KeyboardUtils.showSoftInput(context, maxLengthEditText2);
    }

    public final String getEditText() {
        MaxLengthEditText maxLengthEditText = this.f38914a;
        MaxLengthEditText maxLengthEditText2 = null;
        if (maxLengthEditText == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
            maxLengthEditText = null;
        }
        if (maxLengthEditText.getEditableText() == null) {
            return "";
        }
        MaxLengthEditText maxLengthEditText3 = this.f38914a;
        if (maxLengthEditText3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mEditText");
        } else {
            maxLengthEditText2 = maxLengthEditText3;
        }
        return maxLengthEditText2.getEditableText().toString();
    }

    public final void setEditChangeListener(EditChangeListener editChangeListener) {
        Intrinsics.checkNotNullParameter(editChangeListener, "listener");
        this.f38920g = editChangeListener;
    }

    public final TextWatcher getWatcher() {
        return this.f38921h;
    }
}

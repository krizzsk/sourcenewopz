package com.didi.payment.kycservice.widget;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;
import androidx.core.content.ContextCompat;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, mo175978d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.payment.kycservice.widget.NewPixInputView$initListener$$inlined$addTextChangedListener$default$1 */
/* compiled from: TextView.kt */
public final class C10760xbcdc2b75 implements TextWatcher {
    final /* synthetic */ NewPixInputView this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C10760xbcdc2b75(NewPixInputView newPixInputView) {
        this.this$0 = newPixInputView;
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(this.this$0.f30952b.getText().toString())) {
            this.this$0.f30953c.setVisibility(8);
        } else if (this.this$0.hasFocus()) {
            this.this$0.f30953c.setVisibility(0);
        }
        EditText access$getMInputEt$p = this.this$0.f30952b;
        Context context = this.this$0.getContext();
        Intrinsics.checkNotNull(context);
        access$getMInputEt$p.setTextColor(ContextCompat.getColor(context, R.color.wallet_color_000000));
    }
}

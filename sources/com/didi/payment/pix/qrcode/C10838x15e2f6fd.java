package com.didi.payment.pix.qrcode;

import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import kotlin.Metadata;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, mo175978d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.payment.pix.qrcode.PixQrInputActivity$initView$$inlined$addTextChangedListener$default$1 */
/* compiled from: TextView.kt */
public final class C10838x15e2f6fd implements TextWatcher {
    final /* synthetic */ PixQrInputActivity this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C10838x15e2f6fd(PixQrInputActivity pixQrInputActivity) {
        this.this$0 = pixQrInputActivity;
    }

    public void afterTextChanged(Editable editable) {
        if (TextUtils.isEmpty(editable == null ? null : StringsKt.trim(editable))) {
            this.this$0.getMClearView().setVisibility(4);
            this.this$0.getMSwitchView().setVisibility(0);
            this.this$0.getMSubmitBtn().setEnabled(false);
            return;
        }
        this.this$0.getMClearView().setVisibility(0);
        this.this$0.getMSwitchView().setVisibility(4);
        this.this$0.getMSubmitBtn().setEnabled(true);
    }
}

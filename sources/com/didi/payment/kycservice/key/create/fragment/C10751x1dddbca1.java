package com.didi.payment.kycservice.key.create.fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.ImageView;
import com.didi.payment.base.exts.ApplicationContextProvider;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000'\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0012\u0010\u0002\u001a\u00020\u00032\b\u0010\u0004\u001a\u0004\u0018\u00010\u0005H\u0016J*\u0010\u0006\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\n2\u0006\u0010\f\u001a\u00020\nH\u0016J*\u0010\r\u001a\u00020\u00032\b\u0010\u0007\u001a\u0004\u0018\u00010\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\nH\u0016¨\u0006\u000f¸\u0006\u0000"}, mo175978d2 = {"androidx/core/widget/TextViewKt$addTextChangedListener$textWatcher$1", "Landroid/text/TextWatcher;", "afterTextChanged", "", "s", "Landroid/text/Editable;", "beforeTextChanged", "text", "", "start", "", "count", "after", "onTextChanged", "before", "core-ktx_release"}, mo175979k = 1, mo175980mv = {1, 5, 1})
/* renamed from: com.didi.payment.kycservice.key.create.fragment.CreateKeyByPhoneFragment$initListener$$inlined$addTextChangedListener$default$1 */
/* compiled from: TextView.kt */
public final class C10751x1dddbca1 implements TextWatcher {
    final /* synthetic */ CreateKeyByPhoneFragment this$0;

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    public C10751x1dddbca1(CreateKeyByPhoneFragment createKeyByPhoneFragment) {
        this.this$0 = createKeyByPhoneFragment;
    }

    public void afterTextChanged(Editable editable) {
        EditText access$getEtPhoneNumber$p = this.this$0.f30656c;
        ImageView imageView = null;
        if (access$getEtPhoneNumber$p == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
            access$getEtPhoneNumber$p = null;
        }
        access$getEtPhoneNumber$p.setTextColor(ApplicationContextProvider.Companion.getContext().getResources().getColor(R.color.wallet_color_000000));
        CharSequence charSequence = editable;
        if (charSequence == null || charSequence.length() == 0) {
            ImageView access$getIvDelete$p = this.this$0.f30657d;
            if (access$getIvDelete$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            } else {
                imageView = access$getIvDelete$p;
            }
            imageView.setVisibility(8);
        } else {
            ImageView access$getIvDelete$p2 = this.this$0.f30657d;
            if (access$getIvDelete$p2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            } else {
                imageView = access$getIvDelete$p2;
            }
            imageView.setVisibility(0);
        }
        this.this$0.getBtnContinue().setEnabled(this.this$0.m21556b());
    }
}

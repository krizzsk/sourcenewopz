package com.didi.payment.kycservice.key.create.fragment;

import android.content.Context;
import android.widget.EditText;
import android.widget.ImageView;
import androidx.core.content.ContextCompat;
import com.didi.payment.commonsdk.utils.NKeyboardChangeListener;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\u0017\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u0016¨\u0006\u0006"}, mo175978d2 = {"com/didi/payment/kycservice/key/create/fragment/CreateKeyByPhoneFragment$initListener$6", "Lcom/didi/payment/commonsdk/utils/NKeyboardChangeListener$KeyBoardListener;", "onKeyboardChange", "", "isShow", "", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CreateKeyByPhoneFragment.kt */
public final class CreateKeyByPhoneFragment$initListener$6 implements NKeyboardChangeListener.KeyBoardListener {
    final /* synthetic */ CreateKeyByPhoneFragment this$0;

    CreateKeyByPhoneFragment$initListener$6(CreateKeyByPhoneFragment createKeyByPhoneFragment) {
        this.this$0 = createKeyByPhoneFragment;
    }

    public void onKeyboardChange(boolean z) {
        EditText editText = null;
        if (!z) {
            EditText access$getEtPhoneNumber$p = this.this$0.f30656c;
            if (access$getEtPhoneNumber$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
                access$getEtPhoneNumber$p = null;
            }
            access$getEtPhoneNumber$p.clearFocus();
            ImageView access$getIvDelete$p = this.this$0.f30657d;
            if (access$getIvDelete$p == null) {
                Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
                access$getIvDelete$p = null;
            }
            access$getIvDelete$p.setVisibility(8);
            if (!this.this$0.m21556b()) {
                EditText access$getEtPhoneNumber$p2 = this.this$0.f30656c;
                if (access$getEtPhoneNumber$p2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
                } else {
                    editText = access$getEtPhoneNumber$p2;
                }
                Context context = this.this$0.getContext();
                Intrinsics.checkNotNull(context);
                editText.setTextColor(ContextCompat.getColor(context, R.color.wallet_color_FF525D));
                Context context2 = this.this$0.getContext();
                Intrinsics.checkNotNull(context2);
                WalletToastNew.showFailedMsg(context2, this.this$0.getString(R.string.pix_create_key_by_phone_invalid_phone_num));
                return;
            }
            return;
        }
        ImageView access$getIvDelete$p2 = this.this$0.f30657d;
        if (access$getIvDelete$p2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("ivDelete");
            access$getIvDelete$p2 = null;
        }
        access$getIvDelete$p2.setVisibility(0);
        EditText access$getEtPhoneNumber$p3 = this.this$0.f30656c;
        if (access$getEtPhoneNumber$p3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("etPhoneNumber");
        } else {
            editText = access$getEtPhoneNumber$p3;
        }
        editText.requestFocus();
    }
}

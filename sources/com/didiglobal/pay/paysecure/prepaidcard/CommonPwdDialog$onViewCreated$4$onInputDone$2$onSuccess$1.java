package com.didiglobal.pay.paysecure.prepaidcard;

import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didiglobal.pay.paysecure.net.pojo.response.PaySecureResponse;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "invoke"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: CommonPwdDialog.kt */
final class CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ PaySecureResponse $value;
    final /* synthetic */ CommonPwdDialog$onViewCreated$4$onInputDone$2 this$0;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    CommonPwdDialog$onViewCreated$4$onInputDone$2$onSuccess$1(CommonPwdDialog$onViewCreated$4$onInputDone$2 commonPwdDialog$onViewCreated$4$onInputDone$2, PaySecureResponse paySecureResponse) {
        super(0);
        this.this$0 = commonPwdDialog$onViewCreated$4$onInputDone$2;
        this.$value = paySecureResponse;
    }

    public final void invoke() {
        TextView textView = this.this$0.this$0.$tvDesc;
        Intrinsics.checkExpressionValueIsNotNull(textView, "tvDesc");
        textView.setText(this.$value.getErrmsg());
        TextView textView2 = this.this$0.this$0.$tvDesc;
        TextView textView3 = this.this$0.this$0.$tvDesc;
        Intrinsics.checkExpressionValueIsNotNull(textView3, "tvDesc");
        textView2.setTextColor(ContextCompat.getColor(textView3.getContext(), R.color.color_ff4060));
    }
}

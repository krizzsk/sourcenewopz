package com.didi.entrega.customer.foundation.rpc.net;

import com.didi.entrega.customer.foundation.rpc.net.ExceptionFormator;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.app.constant.StringConst;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000!\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000*\u0001\u0000\b\n\u0018\u00002\u00020\u0001J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\tH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\n\u001a\u00020\tH\u0016R\u001a\u0010\u0002\u001a\u00020\u0003X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0004\u0010\u0005\"\u0004\b\u0006\u0010\u0007¨\u0006\r"}, mo175978d2 = {"com/didi/entrega/customer/foundation/rpc/net/ExceptionFormator$transformers$1$1", "Lcom/didi/entrega/customer/foundation/rpc/net/ExceptionFormator$Transform;", "priority", "", "getPriority", "()I", "setPriority", "(I)V", "doTransform", "", "origin", "shouldTransform", "", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ExceptionFormator.kt */
public final class ExceptionFormator$transformers$1$1 extends ExceptionFormator.Transform {
    private int priority;

    ExceptionFormator$transformers$1$1() {
    }

    public int getPriority() {
        return this.priority;
    }

    public void setPriority(int i) {
        this.priority = i;
    }

    public boolean shouldTransform(String str) {
        Intrinsics.checkNotNullParameter(str, "origin");
        return StringsKt.contains$default((CharSequence) str, (CharSequence) StringConst.JAVA, false, 2, (Object) null);
    }

    public String doTransform(String str) {
        Intrinsics.checkNotNullParameter(str, "origin");
        String string = ResourceHelper.getString(R.string.FoodC_orderlist3_No_service_laow);
        Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.FoodC…derlist3_No_service_laow)");
        return string;
    }
}

package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Lambda;
import kotlin.jvm.internal.Ref;

@Metadata(mo175977d1 = {"\u0000\u0006\n\u0000\n\u0002\u0010\u0002\u0010\u0000\u001a\u00020\u0001H\n"}, mo175978d2 = {"<anonymous>", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AppsFlyerHelper.kt */
final class AppsFlyerHelperKt$doDispatchAppLink$dispatch$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ Map<String, String> $extraParams;
    final /* synthetic */ boolean $isCold;
    final /* synthetic */ Ref.ObjectRef<String> $uriStr;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    AppsFlyerHelperKt$doDispatchAppLink$dispatch$1(Ref.ObjectRef<String> objectRef, Map<String, String> map, boolean z) {
        super(0);
        this.$uriStr = objectRef;
        this.$extraParams = map;
        this.$isCold = z;
    }

    public final void invoke() {
        Ref.ObjectRef<String> objectRef = this.$uriStr;
        T decode = Uri.decode((String) objectRef.element);
        if (decode == null) {
            decode = "";
        }
        objectRef.element = decode;
        Uri.Builder buildUpon = Uri.parse((String) this.$uriStr.element).buildUpon();
        for (Map.Entry next : this.$extraParams.entrySet()) {
            buildUpon.appendQueryParameter((String) next.getKey(), (String) next.getValue());
        }
        SchemeHelper.dispatchMsg(buildUpon.build(), this.$isCold);
    }
}

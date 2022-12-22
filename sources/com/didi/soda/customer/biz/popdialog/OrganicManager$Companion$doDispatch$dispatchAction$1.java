package com.didi.soda.customer.biz.popdialog;

import android.net.Uri;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Lambda;

@Metadata(mo175977d1 = {"\u0000\f\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\u0010\u0000\u001a\u00020\u00012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003H\n"}, mo175978d2 = {"<anonymous>", "", "url", ""}, mo175979k = 3, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrganicManager.kt */
final class OrganicManager$Companion$doDispatch$dispatchAction$1 extends Lambda implements Function1<String, Unit> {
    public static final OrganicManager$Companion$doDispatch$dispatchAction$1 INSTANCE = new OrganicManager$Companion$doDispatch$dispatchAction$1();

    OrganicManager$Companion$doDispatch$dispatchAction$1() {
        super(1);
    }

    public /* bridge */ /* synthetic */ Object invoke(Object obj) {
        invoke((String) obj);
        return Unit.INSTANCE;
    }

    public final void invoke(String str) {
        CharSequence charSequence = str;
        if (!(charSequence == null || charSequence.length() == 0)) {
            SchemeHelper.dispatchMsg(Uri.parse(str), true);
        }
    }
}

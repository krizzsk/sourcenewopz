package com.didi.soda.customer.helper;

import com.didi.soda.customer.compose.action.StrategyAction;
import com.didi.soda.customer.foundation.rpc.entity.bill.ToastEntity;
import com.didi.soda.customer.foundation.util.ToastUtil;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.functions.Function0;

@Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0002J\"\u0010\u0007\u001a\u00020\b2\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u000e\u0010\t\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\nH\u0007¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/soda/customer/helper/ToastActionHelper;", "", "()V", "needRefresh", "", "toast", "Lcom/didi/soda/customer/foundation/rpc/entity/bill/ToastEntity;", "toastAction", "", "block", "Lkotlin/Function0;", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ToastActionHelper.kt */
public final class ToastActionHelper {
    public static final ToastActionHelper INSTANCE = new ToastActionHelper();

    private ToastActionHelper() {
    }

    @JvmStatic
    public static final void toastAction(ToastEntity toastEntity, Function0<Unit> function0) {
        if (toastEntity != null) {
            CharSequence content = toastEntity.getContent();
            if (!(content == null || content.length() == 0)) {
                if (StrategyAction.doStrategy$default(StrategyAction.INSTANCE, toastEntity.getStrategy(), (String) null, 2, (Object) null)) {
                    ToastUtil.makeText(toastEntity.getContent());
                }
                if (INSTANCE.m29299a(toastEntity) && function0 != null) {
                    function0.invoke();
                }
            }
        }
    }

    /* renamed from: a */
    private final boolean m29299a(ToastEntity toastEntity) {
        return toastEntity != null && toastEntity.getNeedRefresh() == 1;
    }
}

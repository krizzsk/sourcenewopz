package com.didi.payment.commonsdk.utils;

import com.didi.payment.commonsdk.net.WBaseRespTemplate;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWHttpUtil;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NWHttpUtil.kt */
public final class NWHttpUtil {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0014\u0010\u0003\u001a\u00020\u00042\f\u0010\u0005\u001a\b\u0012\u0002\b\u0003\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NWHttpUtil$Companion;", "", "()V", "isRespValid", "", "template", "Lcom/didi/payment/commonsdk/net/WBaseRespTemplate;", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: NWHttpUtil.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isRespValid(WBaseRespTemplate<?> wBaseRespTemplate) {
            if (wBaseRespTemplate == null) {
                return false;
            }
            return wBaseRespTemplate.isValid();
        }
    }
}

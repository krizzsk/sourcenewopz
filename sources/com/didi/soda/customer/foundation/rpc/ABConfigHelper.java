package com.didi.soda.customer.foundation.rpc;

import com.didi.soda.customer.foundation.rpc.entity.ABConfigEntity;
import com.didi.soda.customer.foundation.storage.ServerConfigStorage;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/ABConfigHelper;", "", "()V", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ABConfigHelper.kt */
public final class ABConfigHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final Map<String, ABConfigEntity> f40962a = new LinkedHashMap();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static boolean f40963b;

    @Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0006\u0010\t\u001a\u00020\u0007J\u0010\u0010\n\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000b\u001a\u00020\u0007J\b\u0010\f\u001a\u00020\rH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/ABConfigHelper$Companion;", "", "()V", "isInit", "", "testConfigMap", "", "", "Lcom/didi/soda/customer/foundation/rpc/entity/ABConfigEntity;", "getAllConfig", "getConfigByName", "name", "initIfNeed", "", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ABConfigHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        private final void initIfNeed() {
            if (!ABConfigHelper.f40963b) {
                ABConfigHelper.f40963b = true;
                HashMap<String, ABConfigEntity> hashMap = ((ServerConfigStorage) SingletonFactory.get(ServerConfigStorage.class)).getData().testConfig;
                Map access$getTestConfigMap$cp = ABConfigHelper.f40962a;
                Intrinsics.checkNotNullExpressionValue(hashMap, "dataMap");
                access$getTestConfigMap$cp.putAll(hashMap);
            }
        }

        public final ABConfigEntity getConfigByName(String str) {
            Intrinsics.checkNotNullParameter(str, "name");
            return (ABConfigEntity) ABConfigHelper.f40962a.get(str);
        }

        public final String getAllConfig() {
            try {
                initIfNeed();
                String json = GsonUtil.toJson(ABConfigHelper.f40962a);
                Intrinsics.checkNotNullExpressionValue(json, "{\n            initIfNeed…(testConfigMap)\n        }");
                return json;
            } catch (Throwable unused) {
                return "";
            }
        }
    }
}

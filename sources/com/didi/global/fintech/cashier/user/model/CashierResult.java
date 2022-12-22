package com.didi.global.fintech.cashier.user.model;

import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010%\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00182\u00020\u0001:\u0001\u0018B\u0005¢\u0006\u0002\u0010\u0002J\u001b\u0010\u0010\u001a\u0004\u0018\u0001H\u0011\"\u0004\b\u0000\u0010\u00112\u0006\u0010\u0012\u001a\u00020\u0005¢\u0006\u0002\u0010\u0013J\u0018\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0012\u001a\u00020\u00052\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001J\b\u0010\u0017\u001a\u00020\u0005H\u0016R(\u0010\u0003\u001a\u0010\u0012\u0004\u0012\u00020\u0005\u0012\u0006\u0012\u0004\u0018\u00010\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000f¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/CashierResult;", "", "()V", "extras", "", "", "getExtras", "()Ljava/util/Map;", "setExtras", "(Ljava/util/Map;)V", "status", "", "getStatus", "()I", "setStatus", "(I)V", "getExtra", "T", "key", "(Ljava/lang/String;)Ljava/lang/Object;", "putExtra", "", "value", "toString", "Companion", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: CashierResult.kt */
public final class CashierResult {
    public static final String CODE = "code";
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String EXTRA_RETURN_URL = "return_url";

    /* renamed from: a */
    private int f22025a = 3;

    /* renamed from: b */
    private Map<String, Object> f22026b = new LinkedHashMap();

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/user/model/CashierResult$Companion;", "", "()V", "CODE", "", "EXTRA_RETURN_URL", "cashier_user_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: CashierResult.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    public final int getStatus() {
        return this.f22025a;
    }

    public final void setStatus(int i) {
        this.f22025a = i;
    }

    public final Map<String, Object> getExtras() {
        return this.f22026b;
    }

    public final void setExtras(Map<String, Object> map) {
        Intrinsics.checkNotNullParameter(map, "<set-?>");
        this.f22026b = map;
    }

    public final <T> T getExtra(String str) {
        Intrinsics.checkNotNullParameter(str, "key");
        return this.f22026b.get(str);
    }

    public final void putExtra(String str, Object obj) {
        Intrinsics.checkNotNullParameter(str, "key");
        getExtras().put(str, obj);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("status:", Integer.valueOf(this.f22025a)));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"status:$status\")");
        StringsKt.appendln(sb);
        sb.append(Intrinsics.stringPlus("extras:", this.f22026b));
        Intrinsics.checkNotNullExpressionValue(sb, "sb.append(\"extras:$extras\")");
        StringsKt.appendln(sb);
        String sb2 = sb.toString();
        Intrinsics.checkNotNullExpressionValue(sb2, "sb.toString()");
        return sb2;
    }
}

package com.didi.soda.customer.foundation.rpc.entity;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\f\u0018\u0000 \u000f2\u00020\u0001:\u0001\u000fB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\f\u001a\u0004\u0018\u00010\u00042\u0006\u0010\r\u001a\u00020\u00042\u0006\u0010\u000e\u001a\u00020\u0004R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\b¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AFGroupEntity;", "Lcom/didi/soda/customer/foundation/rpc/entity/IEntity;", "()V", "adGroupStr", "", "getAdGroupStr", "()Ljava/lang/String;", "setAdGroupStr", "(Ljava/lang/String;)V", "traceId", "getTraceId", "setTraceId", "findAimGroupInfo", "source", "targetId", "Companion", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: AFGroupIdEntity.kt */
public final class AFGroupEntity implements IEntity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String arrDelimiter = "|";
    private static final int arrMinSize = 3;
    private static final int groupIdIndex = 1;
    private static final String partDelimiter = ",";
    private static final long serialVersionUID = 8811587533138773858L;
    private static final int sourceIndex = 0;
    private static final int valueIndex = 2;
    private String adGroupStr;
    private String traceId;

    public final String getAdGroupStr() {
        return this.adGroupStr;
    }

    public final void setAdGroupStr(String str) {
        this.adGroupStr = str;
    }

    public final String getTraceId() {
        return this.traceId;
    }

    public final void setTraceId(String str) {
        this.traceId = str;
    }

    public final String findAimGroupInfo(String str, String str2) {
        Object obj;
        String str3;
        Intrinsics.checkNotNullParameter(str, "source");
        Intrinsics.checkNotNullParameter(str2, "targetId");
        String str4 = this.adGroupStr;
        if (str4 == null) {
            return null;
        }
        Collection arrayList = new ArrayList();
        for (Object next : StringsKt.split$default((CharSequence) str4, new String[]{"|"}, false, 0, 6, (Object) null)) {
            if (StringsKt.contains$default((CharSequence) (String) next, (CharSequence) str2, false, 2, (Object) null)) {
                arrayList.add(next);
            }
        }
        List arrayList2 = new ArrayList();
        for (String split$default : (List) arrayList) {
            List split$default2 = StringsKt.split$default((CharSequence) split$default, new String[]{","}, false, 0, 6, (Object) null);
            if (split$default2.size() >= 3 && Intrinsics.areEqual(split$default2.get(1), (Object) str2)) {
                arrayList2.add(split$default2);
            }
        }
        if (arrayList2.size() == 1) {
            str3 = (String) ((List) arrayList2.get(0)).get(2);
        } else if (arrayList2.size() > 1) {
            Iterator it = arrayList2.iterator();
            while (true) {
                if (!it.hasNext()) {
                    obj = null;
                    break;
                }
                obj = it.next();
                if (Intrinsics.areEqual(((List) obj).get(0), (Object) str)) {
                    break;
                }
            }
            List list = (List) obj;
            if (list == null) {
                return null;
            }
            str3 = (String) list.get(2);
        } else {
            LogUtil.m29104i("AFGroupEntity", "not find result");
            return null;
        }
        return str3;
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nXT¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000¨\u0006\r"}, mo175978d2 = {"Lcom/didi/soda/customer/foundation/rpc/entity/AFGroupEntity$Companion;", "", "()V", "arrDelimiter", "", "arrMinSize", "", "groupIdIndex", "partDelimiter", "serialVersionUID", "", "sourceIndex", "valueIndex", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: AFGroupIdEntity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }
}

package com.didi.entrega.bill;

import com.didi.entrega.customer.foundation.rpc.entity.BillComponentEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillEntity;
import com.didi.entrega.customer.foundation.rpc.entity.BillSectionEntity;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.ArraysKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000$\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0015\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\u001a\u001c\u0010\u0000\u001a\b\u0012\u0004\u0012\u00020\u00020\u0001*\u00020\u00032\n\u0010\u0004\u001a\u00020\u0005\"\u00020\u0006\u001a\u0011\u0010\u0007\u001a\u00020\u0006*\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\b\u001a\u0011\u0010\u0007\u001a\u00020\t*\u0004\u0018\u00010\t¢\u0006\u0002\u0010\n¨\u0006\u000b"}, mo175978d2 = {"findComponentEntitys", "", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillComponentEntity;", "Lcom/didi/entrega/customer/foundation/rpc/entity/BillEntity;", "viewTypes", "", "", "orZero", "(Ljava/lang/Integer;)I", "", "(Ljava/lang/Long;)J", "entrega-aar_brazilEmbedRelease"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BillExt.kt */
public final class BillExtKt {
    public static final List<BillComponentEntity> findComponentEntitys(BillEntity billEntity, int... iArr) {
        List<BillSectionEntity> sections;
        Intrinsics.checkNotNullParameter(billEntity, "<this>");
        Intrinsics.checkNotNullParameter(iArr, "viewTypes");
        List<BillComponentEntity> arrayList = new ArrayList<>();
        if (!(billEntity.getSections() == null || (sections = billEntity.getSections()) == null)) {
            for (BillSectionEntity components : sections) {
                List<BillComponentEntity> components2 = components.getComponents();
                if (components2 != null) {
                    for (BillComponentEntity billComponentEntity : components2) {
                        if (ArraysKt.contains(iArr, billComponentEntity.getType())) {
                            arrayList.add(billComponentEntity);
                        }
                    }
                }
            }
        }
        return arrayList;
    }

    public static final int orZero(Integer num) {
        if (num == null) {
            return 0;
        }
        return num.intValue();
    }

    public static final long orZero(Long l) {
        if (l == null) {
            return 0;
        }
        return l.longValue();
    }
}

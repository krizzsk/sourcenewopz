package com.didi.global.fintech.cashier.core.spi;

import android.app.Activity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IntIterator;
import kotlin.jvm.functions.Function1;
import kotlin.random.Random;
import kotlin.ranges.CharRange;
import kotlin.ranges.IntRange;
import org.bouncycastle.pqc.math.linearalgebra.Matrix;

@Metadata(mo175977d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\u001a\u0010\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u0003H\u0002¨\u0006\u0004"}, mo175978d2 = {"genUniqueId", "", "activity", "Landroid/app/Activity;", "cashier_core_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GlobalCashierProcessorImpl.kt */
public final class GlobalCashierProcessorImplKt {
    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final String m15747a(Activity activity) {
        List plus = CollectionsKt.plus(CollectionsKt.plus(CollectionsKt.plus(new CharRange('A', Matrix.MATRIX_TYPE_ZERO), new CharRange('a', 'z')), new CharRange('0', '9')), '_');
        Iterable intRange = new IntRange(1, 20);
        Collection arrayList = new ArrayList(CollectionsKt.collectionSizeOrDefault(intRange, 10));
        Iterator it = intRange.iterator();
        while (it.hasNext()) {
            ((IntIterator) it).nextInt();
            arrayList.add(Character.valueOf(((Character) CollectionsKt.random(plus, Random.Default)).charValue()));
        }
        String joinToString$default = CollectionsKt.joinToString$default((List) arrayList, "", (CharSequence) null, (CharSequence) null, 0, (CharSequence) null, (Function1) null, 62, (Object) null);
        activity.getClass().getSimpleName();
        return joinToString$default;
    }
}

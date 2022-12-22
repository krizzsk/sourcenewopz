package com.ddmap.sdk.degrade.gnav.crashrule;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\bf\u0018\u0000*\u0004\b\u0000\u0010\u00012\u00020\u0002J\u0015\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00028\u0000H&¢\u0006\u0002\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/ddmap/sdk/degrade/gnav/crashrule/ICrashRule;", "T", "", "needDegrade", "", "t", "(Ljava/lang/Object;)Z", "Degrade_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: ICrashRule.kt */
public interface ICrashRule<T> {
    boolean needDegrade(T t);
}

package com.didi.soda.compose.service;

import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u0004\u0018\u00010\u00012\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u0004H&J\u001c\u0010\u0005\u001a\u00020\u00062\n\u0010\u0003\u001a\u0006\u0012\u0002\b\u00030\u00042\u0006\u0010\u0007\u001a\u00020\u0001H&¨\u0006\b"}, mo175978d2 = {"Lcom/didi/soda/compose/service/ServiceManager;", "", "getService", "type", "Ljava/lang/Class;", "register", "", "service", "soda-compose-android_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: ServiceManager.kt */
public interface ServiceManager {
    Object getService(Class<?> cls);

    void register(Class<?> cls, Object obj);
}

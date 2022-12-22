package com.didi.sdk.p146ad;

import java.util.ArrayList;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u000e\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005J\u000e\u0010\u000f\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\u0005R\u001e\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006X\u0004¢\u0006\u0002\n\u0000¨\u0006\u0010"}, mo175978d2 = {"Lcom/didi/sdk/ad/AdManager;", "", "()V", "observerList", "Ljava/util/ArrayList;", "Lcom/didi/sdk/ad/IAdObserver;", "Lkotlin/collections/ArrayList;", "notifyObserver", "", "adResponseKey", "", "adConfigItem", "Lcom/didi/sdk/ad/model/AdConfigItem;", "registerObserver", "adObserver", "unregisterObserver", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.sdk.ad.AdManager */
/* compiled from: AdManager.kt */
public final class AdManager {
    public static final AdManager INSTANCE = new AdManager();

    /* renamed from: a */
    private static final ArrayList<IAdObserver> f34916a = new ArrayList<>();

    private AdManager() {
    }

    public final void registerObserver(IAdObserver iAdObserver) {
        Intrinsics.checkNotNullParameter(iAdObserver, "adObserver");
        if (!f34916a.contains(iAdObserver)) {
            f34916a.add(iAdObserver);
        }
    }

    public final void unregisterObserver(IAdObserver iAdObserver) {
        Intrinsics.checkNotNullParameter(iAdObserver, "adObserver");
        if (f34916a.contains(iAdObserver)) {
            f34916a.remove(iAdObserver);
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v0, resolved type: com.didi.sdk.ad.IAdObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v1, resolved type: com.didi.sdk.ad.IAdObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v2, resolved type: com.didi.sdk.ad.IAdObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r2v1, resolved type: java.lang.Object} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r3v0, resolved type: com.didi.sdk.ad.IAdObserver} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r1v4, resolved type: com.didi.sdk.ad.IAdObserver} */
    /* JADX WARNING: Multi-variable type inference failed */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final void notifyObserver(java.lang.String r5, com.didi.sdk.p146ad.model.AdConfigItem r6) {
        /*
            r4 = this;
            java.lang.String r0 = "adResponseKey"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r0)
            java.lang.String r0 = "adConfigItem"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r6, r0)
            java.util.ArrayList<com.didi.sdk.ad.IAdObserver> r0 = f34916a
            r1 = 0
            if (r0 != 0) goto L_0x0010
            goto L_0x0030
        L_0x0010:
            java.lang.Iterable r0 = (java.lang.Iterable) r0
            java.util.Iterator r0 = r0.iterator()
        L_0x0016:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x002e
            java.lang.Object r2 = r0.next()
            r3 = r2
            com.didi.sdk.ad.IAdObserver r3 = (com.didi.sdk.p146ad.IAdObserver) r3
            java.lang.String r3 = r3.type()
            boolean r3 = kotlin.jvm.internal.Intrinsics.areEqual((java.lang.Object) r3, (java.lang.Object) r5)
            if (r3 == 0) goto L_0x0016
            r1 = r2
        L_0x002e:
            com.didi.sdk.ad.IAdObserver r1 = (com.didi.sdk.p146ad.IAdObserver) r1
        L_0x0030:
            if (r1 != 0) goto L_0x0033
            goto L_0x0036
        L_0x0033:
            r1.observe(r6)
        L_0x0036:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.p146ad.AdManager.notifyObserver(java.lang.String, com.didi.sdk.ad.model.AdConfigItem):void");
    }
}

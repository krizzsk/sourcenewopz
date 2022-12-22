package com.didi.beatles.p099im.manager;

import androidx.fragment.app.FragmentActivity;
import com.didi.beatles.p099im.access.core.IMStageFeedBack;
import com.didi.beatles.p099im.utils.IMLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.TypeCastException;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.TypeIntrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005J \u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010J\u0010\u0010\u0011\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\u0005R\u0016\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/beatles/im/manager/IMStageFeedBackListerManager;", "", "()V", "mStageFeedBackListeners", "", "Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStageFeedBackListener;", "addFeedBackListener", "", "listener", "notifyListeners", "", "activity", "Landroidx/fragment/app/FragmentActivity;", "imStage", "Lcom/didi/beatles/im/access/core/IMStageFeedBack$IMStage;", "outFeedBackData", "Lcom/didi/beatles/im/access/core/IMStageFeedBack$OutFeedBackData;", "removeMessageListener", "im_library_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* renamed from: com.didi.beatles.im.manager.IMStageFeedBackListerManager */
/* compiled from: IMStageFeedBackListerManager.kt */
public final class IMStageFeedBackListerManager {
    public static final IMStageFeedBackListerManager INSTANCE = new IMStageFeedBackListerManager();

    /* renamed from: a */
    private static List<IMStageFeedBack.IMStageFeedBackListener> f9265a = new ArrayList();

    private IMStageFeedBackListerManager() {
    }

    /* JADX WARNING: Code restructure failed: missing block: B:19:0x0025, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public final synchronized void addFeedBackListener(com.didi.beatles.p099im.access.core.IMStageFeedBack.IMStageFeedBackListener r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 != 0) goto L_0x000a
            java.lang.String r2 = "[addFeedBackListener] listener is null"
            com.didi.beatles.p099im.utils.IMLog.m6630d(r2)     // Catch:{ all -> 0x0026 }
            monitor-exit(r1)
            return
        L_0x000a:
            java.lang.String r0 = "[addFeedBackListener]"
            com.didi.beatles.p099im.utils.IMLog.m6630d(r0)     // Catch:{ all -> 0x0026 }
            java.util.List<com.didi.beatles.im.access.core.IMStageFeedBack$IMStageFeedBackListener> r0 = f9265a     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            java.util.List<com.didi.beatles.im.access.core.IMStageFeedBack$IMStageFeedBackListener> r0 = f9265a     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            boolean r0 = r0.contains(r2)     // Catch:{ all -> 0x0026 }
            if (r0 != 0) goto L_0x0024
            java.util.List<com.didi.beatles.im.access.core.IMStageFeedBack$IMStageFeedBackListener> r0 = f9265a     // Catch:{ all -> 0x0026 }
            if (r0 == 0) goto L_0x0024
            r0.add(r2)     // Catch:{ all -> 0x0026 }
        L_0x0024:
            monitor-exit(r1)
            return
        L_0x0026:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.beatles.p099im.manager.IMStageFeedBackListerManager.addFeedBackListener(com.didi.beatles.im.access.core.IMStageFeedBack$IMStageFeedBackListener):void");
    }

    public final synchronized void removeMessageListener(IMStageFeedBack.IMStageFeedBackListener iMStageFeedBackListener) {
        IMLog.m6630d("[removeMessageListener]");
        List<IMStageFeedBack.IMStageFeedBackListener> list = f9265a;
        if (list != null) {
            Collection collection = list;
            if (collection != null) {
                TypeIntrinsics.asMutableCollection(collection).remove(iMStageFeedBackListener);
            } else {
                throw new TypeCastException("null cannot be cast to non-null type kotlin.collections.MutableCollection<T>");
            }
        }
    }

    public final boolean notifyListeners(FragmentActivity fragmentActivity, IMStageFeedBack.IMStage iMStage, IMStageFeedBack.OutFeedBackData outFeedBackData) {
        Intrinsics.checkParameterIsNotNull(fragmentActivity, "activity");
        Intrinsics.checkParameterIsNotNull(iMStage, "imStage");
        IMLog.m6630d("[notifyListeners]" + iMStage);
        List<IMStageFeedBack.IMStageFeedBackListener> list = f9265a;
        boolean z = false;
        if (list != null) {
            for (IMStageFeedBack.IMStageFeedBackListener onStageFeedBack : list) {
                if (Intrinsics.areEqual((Object) onStageFeedBack.onStageFeedBack(fragmentActivity, iMStage, outFeedBackData), (Object) true)) {
                    z = true;
                }
            }
        }
        return z;
    }
}

package com.android.didi.bfflib.task;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BffServiceProxyImpl extends BffBaseProxyImpl {
    private List<String> mAbilityIdsInThisService;

    protected BffServiceProxyImpl(Context context, Bff.BffConfig bffConfig, List<String> list) {
        super(context, bffConfig);
        CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
        this.mAbilityIdsInThisService = copyOnWriteArrayList;
        copyOnWriteArrayList.addAll(list);
    }

    public void setAbilityListInThisTask(List<String> list) {
        this.mAbilityIdsInThisService.addAll(list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:11:0x002f  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canAddAbilityInThisTask(com.android.didi.bfflib.IBffProxy.Ability r5) {
        /*
            r4 = this;
            int r0 = r4.mStatus
            r1 = 0
            r2 = -1
            if (r0 == r2) goto L_0x0007
            return r1
        L_0x0007:
            java.util.List<java.lang.String> r0 = r4.mAbilityIdsInThisService
            java.util.Iterator r0 = r0.iterator()
        L_0x000d:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0048
            java.lang.Object r2 = r0.next()
            java.lang.String r2 = (java.lang.String) r2
            java.lang.String r3 = r5.getId()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x000d
            java.util.List r0 = r4.mAbilityList
            java.util.Iterator r0 = r0.iterator()
        L_0x0029:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x0046
            java.lang.Object r2 = r0.next()
            com.android.didi.bfflib.IBffProxy$Ability r2 = (com.android.didi.bfflib.IBffProxy.Ability) r2
            if (r2 == r5) goto L_0x0045
            java.lang.String r2 = r2.getId()
            java.lang.String r3 = r5.getId()
            boolean r2 = r2.equals(r3)
            if (r2 == 0) goto L_0x0029
        L_0x0045:
            return r1
        L_0x0046:
            r5 = 1
            return r5
        L_0x0048:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.bfflib.task.BffServiceProxyImpl.canAddAbilityInThisTask(com.android.didi.bfflib.IBffProxy$Ability):boolean");
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        if (this.mAbilityList.size() == this.mAbilityIdsInThisService.size()) {
            this.mStatus = 0;
        }
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterRemoveAbility() {
        this.mStatus = 3;
    }
}

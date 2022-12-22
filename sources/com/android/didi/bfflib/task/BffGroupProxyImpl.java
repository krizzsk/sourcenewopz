package com.android.didi.bfflib.task;

import android.content.Context;
import com.android.didi.bfflib.Bff;
import java.util.ArrayList;
import java.util.List;

public abstract class BffGroupProxyImpl extends BffBaseProxyImpl {
    private List<String> abilitysInAGroup;

    protected BffGroupProxyImpl(Context context, Bff.BffConfig bffConfig, List<String> list) {
        super(context, bffConfig);
        ArrayList arrayList = new ArrayList();
        this.abilitysInAGroup = arrayList;
        arrayList.add(Bff.CONCURRENT_FORM_ABILITY_ID);
        this.abilitysInAGroup.addAll(list);
    }

    public void setAbilityListInThisTask(List<String> list) {
        this.abilitysInAGroup.add(Bff.CONCURRENT_FORM_ABILITY_ID);
        this.abilitysInAGroup.addAll(list);
    }

    /* JADX WARNING: Removed duplicated region for block: B:12:0x0034  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canAddAbilityInThisTask(com.android.didi.bfflib.IBffProxy.Ability r6) {
        /*
            r5 = this;
            int r0 = r5.mStatus
            r1 = 1
            r2 = 0
            if (r0 == r1) goto L_0x004c
            int r0 = r5.mStatus
            r3 = 2
            if (r0 != r3) goto L_0x000c
            goto L_0x004c
        L_0x000c:
            java.util.List<java.lang.String> r0 = r5.abilitysInAGroup
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004c
            java.lang.Object r3 = r0.next()
            java.lang.String r3 = (java.lang.String) r3
            java.lang.String r4 = r6.getId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0012
            java.util.List r0 = r5.mAbilityList
            java.util.Iterator r0 = r0.iterator()
        L_0x002e:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x004b
            java.lang.Object r3 = r0.next()
            com.android.didi.bfflib.IBffProxy$Ability r3 = (com.android.didi.bfflib.IBffProxy.Ability) r3
            if (r3 == r6) goto L_0x004a
            java.lang.String r3 = r3.getId()
            java.lang.String r4 = r6.getId()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x002e
        L_0x004a:
            return r2
        L_0x004b:
            return r1
        L_0x004c:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.android.didi.bfflib.task.BffGroupProxyImpl.canAddAbilityInThisTask(com.android.didi.bfflib.IBffProxy$Ability):boolean");
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        this.mStatus = 0;
    }
}

package com.didiglobal.enginecore.littleboy;

import android.content.Context;

public abstract class LBAnonymousTaskImpl extends LBBaseTask {
    protected LBAnonymousTaskImpl(Context context) {
        super(context);
    }

    /* JADX WARNING: Removed duplicated region for block: B:7:0x0018  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean canAddAbilityInThisTask(com.didiglobal.enginecore.littleboy.LBAbility r6) {
        /*
            r5 = this;
            int r0 = r5.mStatus
            r1 = 0
            r2 = 1
            if (r0 == r2) goto L_0x0030
            int r0 = r5.mStatus
            r3 = 2
            if (r0 != r3) goto L_0x000c
            goto L_0x0030
        L_0x000c:
            java.util.List r0 = r5.mAbilityList
            java.util.Iterator r0 = r0.iterator()
        L_0x0012:
            boolean r3 = r0.hasNext()
            if (r3 == 0) goto L_0x002f
            java.lang.Object r3 = r0.next()
            com.didiglobal.enginecore.littleboy.LBAbility r3 = (com.didiglobal.enginecore.littleboy.LBAbility) r3
            if (r3 == r6) goto L_0x002e
            java.lang.String r3 = r3.getRequestKey()
            java.lang.String r4 = r6.getRequestKey()
            boolean r3 = r3.equals(r4)
            if (r3 == 0) goto L_0x0012
        L_0x002e:
            return r1
        L_0x002f:
            return r2
        L_0x0030:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.enginecore.littleboy.LBAnonymousTaskImpl.canAddAbilityInThisTask(com.didiglobal.enginecore.littleboy.LBAbility):boolean");
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
        this.mStatus = 0;
    }
}

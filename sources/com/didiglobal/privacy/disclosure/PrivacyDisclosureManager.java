package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureManager extends PrivacyDisclosureBaseManager {

    /* renamed from: a */
    private static volatile PrivacyDisclosureManager f50492a;

    private PrivacyDisclosureManager() {
    }

    public static PrivacyDisclosureManager getInstance() {
        if (f50492a == null) {
            synchronized (PrivacyDisclosureManager.class) {
                if (f50492a == null) {
                    f50492a = new PrivacyDisclosureManager();
                }
            }
        }
        return f50492a;
    }

    public void uploadIfNeeded(Context context) {
        UploadParam b = DisclosureSpUtils.m36296b(context);
        if (b != null) {
            UploadUtils.upload(context, b);
        }
        DisclosureSpUtils.m36293a(context, false);
    }

    public void syncApolloToSp(Context context, IPrivacyType iPrivacyType) {
        DisclosureApolloUtils.m36287a(context);
        DisclosureApolloUtils.m36288a(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public boolean isEnabledByApollo(Context context, IPrivacyType iPrivacyType) {
        return DisclosureApolloUtils.m36288a(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public int getMostDisclosureTimes(Context context) {
        return DisclosureApolloUtils.m36287a(context);
    }

    /* access modifiers changed from: protected */
    public PrivacyDisclosureBaseDialog createDialog() {
        return initParam.getDialog();
    }
}

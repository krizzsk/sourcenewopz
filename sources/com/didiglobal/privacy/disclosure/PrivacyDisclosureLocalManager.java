package com.didiglobal.privacy.disclosure;

import android.content.Context;

public class PrivacyDisclosureLocalManager extends PrivacyDisclosureBaseManager {

    /* renamed from: a */
    private static volatile PrivacyDisclosureLocalManager f50491a;

    private PrivacyDisclosureLocalManager() {
    }

    public static PrivacyDisclosureLocalManager getInstance() {
        if (f50491a == null) {
            synchronized (PrivacyDisclosureLocalManager.class) {
                if (f50491a == null) {
                    f50491a = new PrivacyDisclosureLocalManager();
                }
            }
        }
        return f50491a;
    }

    /* access modifiers changed from: protected */
    public boolean isEnabledByApollo(Context context, IPrivacyType iPrivacyType) {
        return DisclosureSpUtils.m36303d(context, iPrivacyType);
    }

    /* access modifiers changed from: protected */
    public int getMostDisclosureTimes(Context context) {
        return DisclosureSpUtils.m36289a(context);
    }

    /* access modifiers changed from: protected */
    public PrivacyDisclosureBaseDialog createDialog() {
        return initParam.getLocalDialog();
    }
}

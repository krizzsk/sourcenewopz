package com.didi.addressold.vamos;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Build;
import android.os.ResultReceiver;
import com.didi.address.ISugControlCallback;
import com.didi.address.model.SugParams;
import com.didi.address.view.ISugViewController;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.view.CommonAddressActivity;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;

/* renamed from: com.didi.addressold.vamos.a */
/* compiled from: DidiAddressApiImpl */
class C3467a implements IDidiAddressApi {

    /* renamed from: a */
    private GlobalSugFragment f7822a;

    C3467a() {
    }

    public void selectAddress(Activity activity, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException {
        m5035a(activity != null ? activity.getFragmentManager() : null, i, sugParams, globalSugCallback);
    }

    public void selectAddress(Fragment fragment, int i, SugParams sugParams, GlobalSugCallback globalSugCallback) throws AddressException {
        FragmentManager fragmentManager = null;
        if (Build.VERSION.SDK_INT >= 17) {
            if (fragment != null) {
                fragmentManager = fragment.getChildFragmentManager();
            }
        } else if (fragment != null) {
            fragmentManager = fragment.getFragmentManager();
        }
        m5035a(fragmentManager, i, sugParams, globalSugCallback);
    }

    /* JADX WARNING: Can't wrap try/catch for region: R(5:2|3|5|6|18) */
    /* JADX WARNING: Code restructure failed: missing block: B:11:?, code lost:
        r10 = com.didi.sdk.logging.LoggerFactory.getLogger("sug-page-fragmnt");
        r0 = r7.getBackStackEntryCount();
        r10.warn("sug frament size = " + r0, new java.lang.Object[0]);
        r1 = 0;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0044, code lost:
        if (r1 < r0) goto L_0x0046;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0046, code lost:
        r3 = r7.getBackStackEntryAt(r1);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:14:0x004a, code lost:
        if (r3 != null) goto L_0x004c;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:15:0x004c, code lost:
        r10.warn("sug fragment " + r3.getName(), new java.lang.Object[0]);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:16:0x0066, code lost:
        r7.popBackStackImmediate();
        r1 = r1 + 1;
     */
    /* JADX WARNING: Code restructure failed: missing block: B:17:0x006c, code lost:
        m5034a(r7, r8);
     */
    /* JADX WARNING: Code restructure failed: missing block: B:7:0x0020, code lost:
        if (r7 != null) goto L_0x0022;
     */
    /* JADX WARNING: Failed to process nested try/catch */
    /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001c */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m5035a(android.app.FragmentManager r7, int r8, com.didi.address.model.SugParams r9, com.didi.addressold.vamos.GlobalSugCallback r10) {
        /*
            r6 = this;
            com.sdk.poibase.model.AddressParam r0 = r9.addressParam
            com.didi.address.FromType r1 = r9.fromType
            com.didi.addressold.util.CheckParamUtil.checkAddressParam(r0, r1)
            com.didi.addressold.vamos.GlobalSugFragment r9 = com.didi.addressold.vamos.GlobalSugFragment.getInstance(r9)
            r6.f7822a = r9
            r9.mo39683a((com.didi.addressold.vamos.GlobalSugCallback) r10)
            r6.m5033a(r7)
            java.lang.Class<com.didi.addressold.vamos.IDidiAddressApi> r9 = com.didi.addressold.vamos.IDidiAddressApi.class
            monitor-enter(r9)
            r6.m5034a(r7, r8)     // Catch:{ Exception -> 0x001c }
            goto L_0x006f
        L_0x001a:
            r7 = move-exception
            goto L_0x0071
        L_0x001c:
            r6.m5034a(r7, r8)     // Catch:{ Exception -> 0x0020 }
            goto L_0x006f
        L_0x0020:
            if (r7 == 0) goto L_0x006f
            java.lang.String r10 = "sug-page-fragmnt"
            com.didi.sdk.logging.Logger r10 = com.didi.sdk.logging.LoggerFactory.getLogger((java.lang.String) r10)     // Catch:{ all -> 0x001a }
            int r0 = r7.getBackStackEntryCount()     // Catch:{ all -> 0x001a }
            java.lang.StringBuilder r1 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r1.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r2 = "sug frament size = "
            r1.append(r2)     // Catch:{ all -> 0x001a }
            r1.append(r0)     // Catch:{ all -> 0x001a }
            java.lang.String r1 = r1.toString()     // Catch:{ all -> 0x001a }
            r2 = 0
            java.lang.Object[] r3 = new java.lang.Object[r2]     // Catch:{ all -> 0x001a }
            r10.warn((java.lang.String) r1, (java.lang.Object[]) r3)     // Catch:{ all -> 0x001a }
            r1 = 0
        L_0x0044:
            if (r1 >= r0) goto L_0x006c
            android.app.FragmentManager$BackStackEntry r3 = r7.getBackStackEntryAt(r1)     // Catch:{ all -> 0x001a }
            if (r3 == 0) goto L_0x0066
            java.lang.StringBuilder r4 = new java.lang.StringBuilder     // Catch:{ all -> 0x001a }
            r4.<init>()     // Catch:{ all -> 0x001a }
            java.lang.String r5 = "sug fragment "
            r4.append(r5)     // Catch:{ all -> 0x001a }
            java.lang.String r3 = r3.getName()     // Catch:{ all -> 0x001a }
            r4.append(r3)     // Catch:{ all -> 0x001a }
            java.lang.String r3 = r4.toString()     // Catch:{ all -> 0x001a }
            java.lang.Object[] r4 = new java.lang.Object[r2]     // Catch:{ all -> 0x001a }
            r10.warn((java.lang.String) r3, (java.lang.Object[]) r4)     // Catch:{ all -> 0x001a }
        L_0x0066:
            r7.popBackStackImmediate()     // Catch:{ all -> 0x001a }
            int r1 = r1 + 1
            goto L_0x0044
        L_0x006c:
            r6.m5034a(r7, r8)     // Catch:{ all -> 0x001a }
        L_0x006f:
            monitor-exit(r9)     // Catch:{ all -> 0x001a }
            return
        L_0x0071:
            monitor-exit(r9)     // Catch:{ all -> 0x001a }
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.addressold.vamos.C3467a.m5035a(android.app.FragmentManager, int, com.didi.address.model.SugParams, com.didi.addressold.vamos.GlobalSugCallback):void");
    }

    /* renamed from: a */
    private void m5034a(FragmentManager fragmentManager, int i) {
        if (fragmentManager != null) {
            FragmentTransaction beginTransaction = fragmentManager.beginTransaction();
            beginTransaction.add(i, this.f7822a);
            beginTransaction.addToBackStack((String) null);
            beginTransaction.commitAllowingStateLoss();
        }
    }

    /* renamed from: a */
    private void m5033a(FragmentManager fragmentManager) {
        if (fragmentManager != null) {
            Logger logger = LoggerFactory.getLogger("sug-page-fragmnt");
            int backStackEntryCount = fragmentManager.getBackStackEntryCount();
            logger.warn("log sug frament size = " + backStackEntryCount, new Object[0]);
            for (int i = 0; i < backStackEntryCount; i++) {
                FragmentManager.BackStackEntry backStackEntryAt = fragmentManager.getBackStackEntryAt(i);
                if (backStackEntryAt != null) {
                    logger.warn("log sug fragment " + backStackEntryAt.getName(), new Object[0]);
                }
            }
        }
    }

    public void setCommonAddress(Activity activity, SugParams sugParams) {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, sugParams.usrType);
        activity.startActivity(CommonAddressActivity.getIntent(activity, sugParams));
    }

    public void setCommonAddress(Activity activity, SugParams sugParams, ResultReceiver resultReceiver) {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, sugParams.usrType);
        activity.startActivity(CommonAddressActivity.getIntent(activity, sugParams, resultReceiver));
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        GlobalSugFragment globalSugFragment = this.f7822a;
        if (globalSugFragment != null) {
            globalSugFragment.setSugControlCallback(iSugControlCallback);
        }
    }

    public void enableCloseSugFragment(boolean z) {
        GlobalSugFragment globalSugFragment = this.f7822a;
        if (globalSugFragment != null) {
            globalSugFragment.enableCloseSugFragment(z);
        }
    }

    public ISugViewController getSugViewController() {
        GlobalSugFragment globalSugFragment = this.f7822a;
        if (globalSugFragment != null) {
            return globalSugFragment.getSugViewController();
        }
        return null;
    }

    public boolean onBackPressed() {
        boolean z;
        synchronized (IDidiAddressApi.class) {
            z = this.f7822a != null && this.f7822a.onBackPressed();
        }
        return z;
    }

    public void closeFragment() {
        if (this.f7822a != null) {
            synchronized (IDidiAddressApi.class) {
                this.f7822a.closeFragment();
            }
        }
    }
}

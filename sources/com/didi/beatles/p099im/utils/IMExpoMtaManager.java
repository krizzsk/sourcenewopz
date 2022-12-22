package com.didi.beatles.p099im.utils;

import android.text.TextUtils;
import com.didi.beatles.p099im.omega.IMTraceUtil;
import java.util.HashSet;
import java.util.Map;

/* renamed from: com.didi.beatles.im.utils.IMExpoMtaManager */
public class IMExpoMtaManager {

    /* renamed from: a */
    private HashSet<String> f9765a;

    public static IMExpoMtaManager getInstance() {
        return IMExpoMtaManagerHolder.mtaManager;
    }

    /* renamed from: com.didi.beatles.im.utils.IMExpoMtaManager$IMExpoMtaManagerHolder */
    static class IMExpoMtaManagerHolder {
        /* access modifiers changed from: private */
        public static IMExpoMtaManager mtaManager = new IMExpoMtaManager();

        IMExpoMtaManagerHolder() {
        }
    }

    private IMExpoMtaManager() {
        this.f9765a = new HashSet<>();
    }

    /* renamed from: a */
    private boolean m6616a(String str) {
        if (TextUtils.isEmpty(str)) {
            return true;
        }
        if (this.f9765a == null) {
            this.f9765a = new HashSet<>();
        }
        return this.f9765a.contains(str);
    }

    /* renamed from: b */
    private void m6617b(String str) {
        HashSet<String> hashSet;
        if (!TextUtils.isEmpty(str) && (hashSet = this.f9765a) != null) {
            hashSet.add(str);
        }
    }

    public void removeExpoEvent(String str) {
        HashSet<String> hashSet;
        if (!TextUtils.isEmpty(str) && (hashSet = this.f9765a) != null) {
            hashSet.remove(str);
        }
    }

    public void clearExpoEvents() {
        HashSet<String> hashSet = this.f9765a;
        if (hashSet != null) {
            hashSet.clear();
        }
    }

    public void mtaExpo(String str) {
        mtaExpo(str, (Map<String, String>) null);
    }

    public void mtaExpo(String str, Map<String, String> map) {
        if (!m6616a(str)) {
            if (map != null) {
                IMTraceUtil.addBusinessEvent(str).add(map).report();
            } else {
                IMTraceUtil.addBusinessEvent(str).report();
            }
            m6617b(str);
        }
    }
}

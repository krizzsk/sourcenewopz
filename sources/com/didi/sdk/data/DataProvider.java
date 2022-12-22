package com.didi.sdk.data;

import android.text.TextUtils;
import java.util.HashMap;
import java.util.Map;

public class DataProvider {

    /* renamed from: a */
    private static final DataProvider f35774a = new DataProvider();

    /* renamed from: b */
    private Map<String, DataGenerator> f35775b = new HashMap();

    public static DataProvider getInstance() {
        return f35774a;
    }

    private DataProvider() {
    }

    public synchronized DataGenerator addDataGenerator(DataGenerator dataGenerator) {
        if (!TextUtils.isEmpty(dataGenerator.getGeneratorName())) {
        } else {
            throw new NullPointerException("generator getName can't null");
        }
        return this.f35775b.put(dataGenerator.getGeneratorName(), dataGenerator);
    }

    public synchronized DataGenerator removeDataGenerator(DataGenerator dataGenerator) {
        if (!TextUtils.isEmpty(dataGenerator.getGeneratorName())) {
        } else {
            throw new NullPointerException("generator getName can't null");
        }
        return this.f35775b.remove(dataGenerator.getGeneratorName());
    }

    /* JADX WARNING: Code restructure failed: missing block: B:12:0x0016, code lost:
        return r0;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized <T extends com.didi.sdk.data.DataGenerator> T getDataGenerator(java.lang.String r2, java.lang.Class<T> r3) {
        /*
            r1 = this;
            monitor-enter(r1)
            boolean r3 = android.text.TextUtils.isEmpty(r2)     // Catch:{ all -> 0x0017 }
            r0 = 0
            if (r3 == 0) goto L_0x000a
            monitor-exit(r1)
            return r0
        L_0x000a:
            java.util.Map<java.lang.String, com.didi.sdk.data.DataGenerator> r3 = r1.f35775b     // Catch:{ all -> 0x0017 }
            java.lang.Object r2 = r3.get(r2)     // Catch:{ all -> 0x0017 }
            com.didi.sdk.data.DataGenerator r2 = (com.didi.sdk.data.DataGenerator) r2     // Catch:{ all -> 0x0017 }
            if (r2 == 0) goto L_0x0015
            r0 = r2
        L_0x0015:
            monitor-exit(r1)
            return r0
        L_0x0017:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.data.DataProvider.getDataGenerator(java.lang.String, java.lang.Class):com.didi.sdk.data.DataGenerator");
    }
}

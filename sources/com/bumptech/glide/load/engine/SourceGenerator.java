package com.bumptech.glide.load.engine;

import android.util.Log;
import com.bumptech.glide.load.DataSource;
import com.bumptech.glide.load.Key;
import com.bumptech.glide.load.data.DataFetcher;
import com.bumptech.glide.load.engine.DataFetcherGenerator;
import com.bumptech.glide.load.model.ModelLoader;
import com.didi.sdk.apm.SystemUtils;
import java.io.IOException;
import java.util.List;

class SourceGenerator implements DataFetcherGenerator, DataFetcherGenerator.FetcherReadyCallback {
    private static final String TAG = "SourceGenerator";

    /* renamed from: cb */
    private final DataFetcherGenerator.FetcherReadyCallback f2164cb;
    private volatile Object dataToCache;
    private final DecodeHelper<?> helper;
    private volatile ModelLoader.LoadData<?> loadData;
    private volatile int loadDataListIndex;
    private volatile DataCacheKey originalKey;
    private volatile DataCacheGenerator sourceCacheGenerator;

    SourceGenerator(DecodeHelper<?> decodeHelper, DataFetcherGenerator.FetcherReadyCallback fetcherReadyCallback) {
        this.helper = decodeHelper;
        this.f2164cb = fetcherReadyCallback;
    }

    public boolean startNext() {
        if (this.dataToCache != null) {
            Object obj = this.dataToCache;
            this.dataToCache = null;
            try {
                if (!cacheData(obj)) {
                    return true;
                }
            } catch (IOException e) {
                if (Log.isLoggable(TAG, 3)) {
                    SystemUtils.log(3, TAG, "Failed to properly rewind or write data to cache", e, "com.bumptech.glide.load.engine.SourceGenerator", 70);
                }
            }
        }
        if (this.sourceCacheGenerator != null && this.sourceCacheGenerator.startNext()) {
            return true;
        }
        this.sourceCacheGenerator = null;
        this.loadData = null;
        boolean z = false;
        while (!z && hasNextModelLoader()) {
            List<ModelLoader.LoadData<?>> loadData2 = this.helper.getLoadData();
            int i = this.loadDataListIndex;
            this.loadDataListIndex = i + 1;
            this.loadData = loadData2.get(i);
            if (this.loadData != null && (this.helper.getDiskCacheStrategy().isDataCacheable(this.loadData.fetcher.getDataSource()) || this.helper.hasLoadPath(this.loadData.fetcher.getDataClass()))) {
                startNextLoad(this.loadData);
                z = true;
            }
        }
        return z;
    }

    private void startNextLoad(final ModelLoader.LoadData<?> loadData2) {
        this.loadData.fetcher.loadData(this.helper.getPriority(), new DataFetcher.DataCallback<Object>() {
            public void onDataReady(Object obj) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onDataReadyInternal(loadData2, obj);
                }
            }

            public void onLoadFailed(Exception exc) {
                if (SourceGenerator.this.isCurrentRequest(loadData2)) {
                    SourceGenerator.this.onLoadFailedInternal(loadData2, exc);
                }
            }
        });
    }

    /* access modifiers changed from: package-private */
    public boolean isCurrentRequest(ModelLoader.LoadData<?> loadData2) {
        ModelLoader.LoadData<?> loadData3 = this.loadData;
        return loadData3 != null && loadData3 == loadData2;
    }

    private boolean hasNextModelLoader() {
        return this.loadDataListIndex < this.helper.getLoadData().size();
    }

    /* JADX WARNING: Removed duplicated region for block: B:25:0x00fd  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private boolean cacheData(java.lang.Object r26) throws java.io.IOException {
        /*
            r25 = this;
            r1 = r25
            r0 = r26
            java.lang.String r2 = "SourceGenerator"
            long r3 = com.bumptech.glide.util.LogTime.getLogTime()
            r5 = 1
            r6 = 0
            com.bumptech.glide.load.engine.DecodeHelper<?> r7 = r1.helper     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.data.DataRewinder r7 = r7.getRewinder(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.Object r8 = r7.rewindAndGet()     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r9 = r1.helper     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.Encoder r9 = r9.getSourceEncoder(r8)     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DataCacheWriter r10 = new com.bumptech.glide.load.engine.DataCacheWriter     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r11 = r1.helper     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.Options r11 = r11.getOptions()     // Catch:{ all -> 0x00f9 }
            r10.<init>(r9, r8, r11)     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DataCacheKey r8 = new com.bumptech.glide.load.engine.DataCacheKey     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r11 = r1.loadData     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.Key r11 = r11.sourceKey     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r12 = r1.helper     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.Key r12 = r12.getSignature()     // Catch:{ all -> 0x00f9 }
            r8.<init>(r11, r12)     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r11 = r1.helper     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.cache.DiskCache r11 = r11.getDiskCache()     // Catch:{ all -> 0x00f9 }
            r11.put(r8, r10)     // Catch:{ all -> 0x00f9 }
            r10 = 2
            boolean r10 = android.util.Log.isLoggable(r2, r10)     // Catch:{ all -> 0x00f9 }
            java.lang.String r12 = ", data: "
            if (r10 == 0) goto L_0x007f
            java.lang.String r14 = "SourceGenerator"
            java.lang.StringBuilder r10 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            r10.<init>()     // Catch:{ all -> 0x00f9 }
            java.lang.String r13 = "Finished encoding source to cache, key: "
            r10.append(r13)     // Catch:{ all -> 0x00f9 }
            r10.append(r8)     // Catch:{ all -> 0x00f9 }
            r10.append(r12)     // Catch:{ all -> 0x00f9 }
            r10.append(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r13 = ", encoder: "
            r10.append(r13)     // Catch:{ all -> 0x00f9 }
            r10.append(r9)     // Catch:{ all -> 0x00f9 }
            java.lang.String r9 = ", duration: "
            r10.append(r9)     // Catch:{ all -> 0x00f9 }
            double r3 = com.bumptech.glide.util.LogTime.getElapsedMillis(r3)     // Catch:{ all -> 0x00f9 }
            r10.append(r3)     // Catch:{ all -> 0x00f9 }
            java.lang.String r15 = r10.toString()     // Catch:{ all -> 0x00f9 }
            r13 = 2
            r16 = 0
            java.lang.String r17 = "com.bumptech.glide.load.engine.SourceGenerator"
            r18 = 143(0x8f, float:2.0E-43)
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00f9 }
        L_0x007f:
            java.io.File r3 = r11.get(r8)     // Catch:{ all -> 0x00f9 }
            if (r3 == 0) goto L_0x00a0
            r1.originalKey = r8     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DataCacheGenerator r0 = new com.bumptech.glide.load.engine.DataCacheGenerator     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r2 = r1.loadData     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.Key r2 = r2.sourceKey     // Catch:{ all -> 0x00f9 }
            java.util.List r2 = java.util.Collections.singletonList(r2)     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DecodeHelper<?> r3 = r1.helper     // Catch:{ all -> 0x00f9 }
            r0.<init>(r2, r3, r1)     // Catch:{ all -> 0x00f9 }
            r1.sourceCacheGenerator = r0     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r0 = r1.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r0 = r0.fetcher
            r0.cleanup()
            return r5
        L_0x00a0:
            r3 = 3
            boolean r2 = android.util.Log.isLoggable(r2, r3)     // Catch:{ all -> 0x00f9 }
            if (r2 == 0) goto L_0x00d1
            java.lang.String r14 = "SourceGenerator"
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch:{ all -> 0x00f9 }
            r2.<init>()     // Catch:{ all -> 0x00f9 }
            java.lang.String r3 = "Attempt to write: "
            r2.append(r3)     // Catch:{ all -> 0x00f9 }
            com.bumptech.glide.load.engine.DataCacheKey r3 = r1.originalKey     // Catch:{ all -> 0x00f9 }
            r2.append(r3)     // Catch:{ all -> 0x00f9 }
            r2.append(r12)     // Catch:{ all -> 0x00f9 }
            r2.append(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r0 = " to the disk cache failed, maybe the disk cache is disabled? Trying to decode the data directly..."
            r2.append(r0)     // Catch:{ all -> 0x00f9 }
            java.lang.String r15 = r2.toString()     // Catch:{ all -> 0x00f9 }
            r13 = 3
            r16 = 0
            java.lang.String r17 = "com.bumptech.glide.load.engine.SourceGenerator"
            r18 = 164(0xa4, float:2.3E-43)
            com.didi.sdk.apm.SystemUtils.log(r13, r14, r15, r16, r17, r18)     // Catch:{ all -> 0x00f9 }
        L_0x00d1:
            com.bumptech.glide.load.engine.DataFetcherGenerator$FetcherReadyCallback r0 = r1.f2164cb     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r2 = r1.loadData     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.Key r2 = r2.sourceKey     // Catch:{ all -> 0x00f7 }
            java.lang.Object r21 = r7.rewindAndGet()     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r3 = r1.loadData     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.data.DataFetcher<Data> r3 = r3.fetcher     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r4 = r1.loadData     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.data.DataFetcher<Data> r4 = r4.fetcher     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.DataSource r23 = r4.getDataSource()     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r4 = r1.loadData     // Catch:{ all -> 0x00f7 }
            com.bumptech.glide.load.Key r4 = r4.sourceKey     // Catch:{ all -> 0x00f7 }
            r19 = r0
            r20 = r2
            r22 = r3
            r24 = r4
            r19.onDataFetcherReady(r20, r21, r22, r23, r24)     // Catch:{ all -> 0x00f7 }
            return r6
        L_0x00f7:
            r0 = move-exception
            goto L_0x00fb
        L_0x00f9:
            r0 = move-exception
            r5 = 0
        L_0x00fb:
            if (r5 != 0) goto L_0x0104
            com.bumptech.glide.load.model.ModelLoader$LoadData<?> r2 = r1.loadData
            com.bumptech.glide.load.data.DataFetcher<Data> r2 = r2.fetcher
            r2.cleanup()
        L_0x0104:
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.SourceGenerator.cacheData(java.lang.Object):boolean");
    }

    public void cancel() {
        ModelLoader.LoadData<?> loadData2 = this.loadData;
        if (loadData2 != null) {
            loadData2.fetcher.cancel();
        }
    }

    /* access modifiers changed from: package-private */
    public void onDataReadyInternal(ModelLoader.LoadData<?> loadData2, Object obj) {
        DiskCacheStrategy diskCacheStrategy = this.helper.getDiskCacheStrategy();
        if (obj == null || !diskCacheStrategy.isDataCacheable(loadData2.fetcher.getDataSource())) {
            this.f2164cb.onDataFetcherReady(loadData2.sourceKey, obj, loadData2.fetcher, loadData2.fetcher.getDataSource(), this.originalKey);
            return;
        }
        this.dataToCache = obj;
        this.f2164cb.reschedule();
    }

    /* access modifiers changed from: package-private */
    public void onLoadFailedInternal(ModelLoader.LoadData<?> loadData2, Exception exc) {
        this.f2164cb.onDataFetcherFailed(this.originalKey, exc, loadData2.fetcher, loadData2.fetcher.getDataSource());
    }

    public void reschedule() {
        throw new UnsupportedOperationException();
    }

    public void onDataFetcherReady(Key key, Object obj, DataFetcher<?> dataFetcher, DataSource dataSource, Key key2) {
        this.f2164cb.onDataFetcherReady(key, obj, dataFetcher, this.loadData.fetcher.getDataSource(), key);
    }

    public void onDataFetcherFailed(Key key, Exception exc, DataFetcher<?> dataFetcher, DataSource dataSource) {
        this.f2164cb.onDataFetcherFailed(key, exc, dataFetcher, this.loadData.fetcher.getDataSource());
    }
}

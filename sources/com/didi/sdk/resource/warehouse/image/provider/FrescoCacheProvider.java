package com.didi.sdk.resource.warehouse.image.provider;

import android.net.Uri;
import android.os.SystemClock;
import com.didi.sdk.resource.warehouse.image.ICacheProvider;
import com.didi.sdk.resource.warehouse.image.IRetryStrategy;
import com.didi.sdk.resource.warehouse.image.PriorityType;
import com.didi.sdk.resource.warehouse.tools.HandlerUtil;
import com.didi.sdk.resource.warehouse.tools.LogUtil;
import com.didi.sdk.resource.warehouse.tools.OmegaUtil;
import com.facebook.cache.common.SimpleCacheKey;
import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.imagepipeline.common.Priority;
import com.facebook.imagepipeline.listener.RequestListener;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;
import java.util.Map;

public class FrescoCacheProvider implements ICacheProvider {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f37113a = FrescoCacheProvider.class.getSimpleName();

    public String getProviderKey() {
        return ICacheProvider.PROVIDER_KEY_FRESCO;
    }

    public boolean hasCache(String str) {
        boolean diskCheckSync = Fresco.getImagePipelineFactory().getMainBufferedDiskCache().diskCheckSync(new SimpleCacheKey(str));
        String str2 = f37113a;
        LogUtil.m26314i(str2, "hasCache:url = " + str + ", hasCache = " + diskCheckSync);
        return diskCheckSync;
    }

    public void cache(String str, PriorityType priorityType, IRetryStrategy iRetryStrategy) {
        String str2 = f37113a;
        LogUtil.m26314i(str2, "cache:url = " + str + ", priorityType = " + priorityType + ", listener = " + iRetryStrategy);
        m26306a(str, priorityType, 0, iRetryStrategy);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26306a(String str, PriorityType priorityType, int i, IRetryStrategy iRetryStrategy) {
        final boolean hasCache = hasCache(str);
        String str2 = f37113a;
        LogUtil.m26314i(str2, "retry:url = " + str + ", priorityType = " + priorityType + ", retryTime = " + i + ", listener = " + iRetryStrategy + ", hasCache = " + hasCache);
        final long elapsedRealtime = SystemClock.elapsedRealtime();
        if (!hasCache) {
            OmegaUtil.downloadUrlEvent(str, i);
        }
        final String str3 = str;
        final int i2 = i;
        final IRetryStrategy iRetryStrategy2 = iRetryStrategy;
        final PriorityType priorityType2 = priorityType;
        Fresco.getImagePipeline().prefetchToDiskCache(ImageRequestBuilder.newBuilderWithSource(Uri.parse(str)).disableMemoryCache().setRequestPriority(m26303a(priorityType)).setRequestListener(new RequestListener() {
            public void onRequestStart(ImageRequest imageRequest, Object obj, String str, boolean z) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onRequestStart:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", isPrefetch = " + z);
            }

            public void onRequestSuccess(ImageRequest imageRequest, String str, boolean z) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onRequestSuccess:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", isPrefetch = " + z);
                if (!hasCache) {
                    OmegaUtil.downloadUrlSuccessEvent(str3, i2, SystemClock.elapsedRealtime() - elapsedRealtime);
                }
            }

            public void onRequestFailure(ImageRequest imageRequest, String str, Throwable th, boolean z) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26313e(a, "retry.onRequestFailure:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", isPrefetch = " + z + ", throwable = " + th);
                int i = i2;
                final int i2 = 1;
                if (i > 0) {
                    i2 = 1 + i;
                }
                IRetryStrategy iRetryStrategy = iRetryStrategy2;
                if (iRetryStrategy != null && iRetryStrategy.isContinue(str3, i2, th)) {
                    int interval = iRetryStrategy2.interval(str3, i2, th);
                    if (interval < 0) {
                        interval = 0;
                    }
                    HandlerUtil.postRunnableDelayed(new Runnable() {
                        public void run() {
                            FrescoCacheProvider.this.m26306a(str3, priorityType2, i2, iRetryStrategy2);
                        }
                    }, (long) interval);
                }
                if (!hasCache) {
                    OmegaUtil.downloadUrlFailEvent(str3, i2, SystemClock.elapsedRealtime() - elapsedRealtime, th.toString());
                }
            }

            public void onRequestCancellation(String str) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onRequestCancellation:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str);
            }

            public void onProducerStart(String str, String str2) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onProducerStart:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2);
            }

            public void onProducerEvent(String str, String str2, String str3) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onProducerEvent:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2 + ", eventName = " + str3);
            }

            public void onProducerFinishWithSuccess(String str, String str2, Map<String, String> map) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onProducerFinishWithSuccess:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2);
            }

            public void onProducerFinishWithFailure(String str, String str2, Throwable th, Map<String, String> map) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26313e(a, "retry.onProducerFinishWithFailure:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2 + ", t = " + th);
            }

            public void onProducerFinishWithCancellation(String str, String str2, Map<String, String> map) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onProducerFinishWithCancellation:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2);
            }

            public void onUltimateProducerReached(String str, String str2, boolean z) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.onUltimateProducerReached:url = " + str3 + ", retryTime = " + i2 + ", requestId = " + str + ", producerName = " + str2 + ", successful = " + z);
            }

            public boolean requiresExtraMap(String str) {
                String a = FrescoCacheProvider.f37113a;
                LogUtil.m26314i(a, "retry.requiresExtraMap:url = " + str3 + ", ");
                return false;
            }
        }).build(), this, m26303a(priorityType));
    }

    /* renamed from: com.didi.sdk.resource.warehouse.image.provider.FrescoCacheProvider$2 */
    static /* synthetic */ class C130172 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$sdk$resource$warehouse$image$PriorityType;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.sdk.resource.warehouse.image.PriorityType[] r0 = com.didi.sdk.resource.warehouse.image.PriorityType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$sdk$resource$warehouse$image$PriorityType = r0
                com.didi.sdk.resource.warehouse.image.PriorityType r1 = com.didi.sdk.resource.warehouse.image.PriorityType.LOW     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$sdk$resource$warehouse$image$PriorityType     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.sdk.resource.warehouse.image.PriorityType r1 = com.didi.sdk.resource.warehouse.image.PriorityType.MEDIUM     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$sdk$resource$warehouse$image$PriorityType     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.sdk.resource.warehouse.image.PriorityType r1 = com.didi.sdk.resource.warehouse.image.PriorityType.HIGH     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.sdk.resource.warehouse.image.provider.FrescoCacheProvider.C130172.<clinit>():void");
        }
    }

    /* renamed from: a */
    private Priority m26303a(PriorityType priorityType) {
        Priority priority = Priority.MEDIUM;
        int i = C130172.$SwitchMap$com$didi$sdk$resource$warehouse$image$PriorityType[priorityType.ordinal()];
        if (i == 1) {
            return Priority.LOW;
        }
        if (i == 2) {
            return Priority.MEDIUM;
        }
        if (i != 3) {
            return priority;
        }
        return Priority.HIGH;
    }
}

package com.bumptech.glide.load.engine;

import androidx.core.util.Pools;
import com.bumptech.glide.load.Options;
import com.bumptech.glide.load.ResourceDecoder;
import com.bumptech.glide.load.data.DataRewinder;
import com.bumptech.glide.load.resource.transcode.ResourceTranscoder;
import com.bumptech.glide.util.Preconditions;
import java.util.List;

public class DecodePath<DataType, ResourceType, Transcode> {
    private static final String TAG = "DecodePath";
    private final Class<DataType> dataClass;
    private final List<? extends ResourceDecoder<DataType, ResourceType>> decoders;
    private final String failureMessage;
    private final Pools.Pool<List<Throwable>> listPool;
    private final ResourceTranscoder<ResourceType, Transcode> transcoder;

    interface DecodeCallback<ResourceType> {
        Resource<ResourceType> onResourceDecoded(Resource<ResourceType> resource);
    }

    public DecodePath(Class<DataType> cls, Class<ResourceType> cls2, Class<Transcode> cls3, List<? extends ResourceDecoder<DataType, ResourceType>> list, ResourceTranscoder<ResourceType, Transcode> resourceTranscoder, Pools.Pool<List<Throwable>> pool) {
        this.dataClass = cls;
        this.decoders = list;
        this.transcoder = resourceTranscoder;
        this.listPool = pool;
        this.failureMessage = "Failed DecodePath{" + cls.getSimpleName() + "->" + cls2.getSimpleName() + "->" + cls3.getSimpleName() + "}";
    }

    public Resource<Transcode> decode(DataRewinder<DataType> dataRewinder, int i, int i2, Options options, DecodeCallback<ResourceType> decodeCallback) throws GlideException {
        return this.transcoder.transcode(decodeCallback.onResourceDecoded(decodeResource(dataRewinder, i, i2, options)), options);
    }

    private Resource<ResourceType> decodeResource(DataRewinder<DataType> dataRewinder, int i, int i2, Options options) throws GlideException {
        List list = (List) Preconditions.checkNotNull(this.listPool.acquire());
        try {
            return decodeResourceWithList(dataRewinder, i, i2, options, list);
        } finally {
            this.listPool.release(list);
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:16:0x004f  */
    /* JADX WARNING: Removed duplicated region for block: B:19:0x0071 A[LOOP:0: B:1:0x0010->B:19:0x0071, LOOP_END] */
    /* JADX WARNING: Removed duplicated region for block: B:24:0x0074 A[EDGE_INSN: B:24:0x0074->B:20:0x0074 ?: BREAK  , SYNTHETIC] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private com.bumptech.glide.load.engine.Resource<ResourceType> decodeResourceWithList(com.bumptech.glide.load.data.DataRewinder<DataType> r17, int r18, int r19, com.bumptech.glide.load.Options r20, java.util.List<java.lang.Throwable> r21) throws com.bumptech.glide.load.engine.GlideException {
        /*
            r16 = this;
            r1 = r16
            r2 = r20
            r3 = r21
            java.util.List<? extends com.bumptech.glide.load.ResourceDecoder<DataType, ResourceType>> r0 = r1.decoders
            int r4 = r0.size()
            r0 = 0
            r5 = 0
            r5 = r0
            r6 = 0
        L_0x0010:
            if (r6 >= r4) goto L_0x0074
            java.util.List<? extends com.bumptech.glide.load.ResourceDecoder<DataType, ResourceType>> r0 = r1.decoders
            java.lang.Object r0 = r0.get(r6)
            r7 = r0
            com.bumptech.glide.load.ResourceDecoder r7 = (com.bumptech.glide.load.ResourceDecoder) r7
            java.lang.Object r0 = r17.rewindAndGet()     // Catch:{ IOException -> 0x0041, RuntimeException -> 0x003f, OutOfMemoryError -> 0x003d }
            boolean r0 = r7.handles(r0, r2)     // Catch:{ IOException -> 0x0041, RuntimeException -> 0x003f, OutOfMemoryError -> 0x003d }
            if (r0 == 0) goto L_0x0038
            java.lang.Object r0 = r17.rewindAndGet()     // Catch:{ IOException -> 0x0041, RuntimeException -> 0x003f, OutOfMemoryError -> 0x003d }
            r8 = r18
            r9 = r19
            com.bumptech.glide.load.engine.Resource r5 = r7.decode(r0, r8, r9, r2)     // Catch:{ IOException -> 0x0036, RuntimeException -> 0x0034, OutOfMemoryError -> 0x0032 }
            goto L_0x006e
        L_0x0032:
            r0 = move-exception
            goto L_0x0046
        L_0x0034:
            r0 = move-exception
            goto L_0x0046
        L_0x0036:
            r0 = move-exception
            goto L_0x0046
        L_0x0038:
            r8 = r18
            r9 = r19
            goto L_0x006e
        L_0x003d:
            r0 = move-exception
            goto L_0x0042
        L_0x003f:
            r0 = move-exception
            goto L_0x0042
        L_0x0041:
            r0 = move-exception
        L_0x0042:
            r8 = r18
            r9 = r19
        L_0x0046:
            r10 = 2
            java.lang.String r11 = "DecodePath"
            boolean r10 = android.util.Log.isLoggable(r11, r10)
            if (r10 == 0) goto L_0x006b
            java.lang.StringBuilder r10 = new java.lang.StringBuilder
            r10.<init>()
            java.lang.String r11 = "Failed to decode data for "
            r10.append(r11)
            r10.append(r7)
            java.lang.String r12 = r10.toString()
            r10 = 2
            r15 = 98
            java.lang.String r11 = "DecodePath"
            java.lang.String r14 = "com.bumptech.glide.load.engine.DecodePath"
            r13 = r0
            com.didi.sdk.apm.SystemUtils.log(r10, r11, r12, r13, r14, r15)
        L_0x006b:
            r3.add(r0)
        L_0x006e:
            if (r5 == 0) goto L_0x0071
            goto L_0x0074
        L_0x0071:
            int r6 = r6 + 1
            goto L_0x0010
        L_0x0074:
            if (r5 == 0) goto L_0x0077
            return r5
        L_0x0077:
            com.bumptech.glide.load.engine.GlideException r0 = new com.bumptech.glide.load.engine.GlideException
            java.lang.String r2 = r1.failureMessage
            java.util.ArrayList r4 = new java.util.ArrayList
            r4.<init>(r3)
            r0.<init>((java.lang.String) r2, (java.util.List<java.lang.Throwable>) r4)
            throw r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.bumptech.glide.load.engine.DecodePath.decodeResourceWithList(com.bumptech.glide.load.data.DataRewinder, int, int, com.bumptech.glide.load.Options, java.util.List):com.bumptech.glide.load.engine.Resource");
    }

    public String toString() {
        return "DecodePath{ dataClass=" + this.dataClass + ", decoders=" + this.decoders + ", transcoder=" + this.transcoder + '}';
    }
}

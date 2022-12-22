package com.google.android.gms.internal.ads;

import com.didi.soda.customer.foundation.rpc.ApiErrorConst;
import java.nio.ByteBuffer;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzjd {
    private static final int[] zzand = {1, 2, 2, 2, 2, 3, 3, 4, 4, 5, 6, 6, 6, 7, 8, 8};
    private static final int[] zzane = {-1, 8000, 16000, 32000, -1, -1, 11025, 22050, ApiErrorConst.Code.CREATE_ORDER_BILL_INFO_ERROR, -1, -1, 12000, 24000, 48000, -1, -1};
    private static final int[] zzanf = {64, 112, 128, 192, 224, 256, 384, 448, 512, 640, 768, 896, 1024, 1152, 1280, 1536, 1920, 2048, 2304, 2560, 2688, 2816, 2823, 2944, 3072, 3840, 4096, 6144, 7680};

    public static int zzo(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        return ((((byteBuffer.get(position + 5) & 252) >> 2) | ((byteBuffer.get(position + 4) & 1) << 6)) + 1) << 5;
    }
}

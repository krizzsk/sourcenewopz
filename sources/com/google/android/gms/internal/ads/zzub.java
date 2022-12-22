package com.google.android.gms.internal.ads;

import com.didi.beatles.p099im.access.utils.IMTextUtils;
import com.google.android.gms.internal.ads.zzena;
import kotlin.text.Typography;

/* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
public final class zzub {

    /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
    public static final class zza extends zzena<zza, C22025zza> implements zzeop {
        /* access modifiers changed from: private */
        public static final zza zzbwu;
        private static volatile zzeow<zza> zzek;

        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public enum zzb implements zzenf {
            UNKNOWN_EVENT_TYPE(0),
            AD_REQUEST(1),
            AD_LOADED(2),
            AD_IMPRESSION(5),
            AD_FIRST_CLICK(6),
            AD_SUBSEQUENT_CLICK(7),
            REQUEST_WILL_START(8),
            REQUEST_DID_END(9),
            REQUEST_WILL_UPDATE_SIGNALS(10),
            REQUEST_DID_UPDATE_SIGNALS(11),
            REQUEST_WILL_BUILD_URL(12),
            REQUEST_DID_BUILD_URL(13),
            REQUEST_WILL_MAKE_NETWORK_REQUEST(14),
            REQUEST_DID_RECEIVE_NETWORK_RESPONSE(15),
            REQUEST_WILL_PROCESS_RESPONSE(16),
            REQUEST_DID_PROCESS_RESPONSE(17),
            REQUEST_WILL_RENDER(18),
            REQUEST_DID_RENDER(19),
            AD_FAILED_TO_LOAD(3),
            AD_FAILED_TO_LOAD_NO_FILL(4),
            AD_FAILED_TO_LOAD_INVALID_REQUEST(100),
            AD_FAILED_TO_LOAD_NETWORK_ERROR(101),
            AD_FAILED_TO_LOAD_TIMEOUT(102),
            AD_FAILED_TO_LOAD_CANCELLED(103),
            AD_FAILED_TO_LOAD_NO_ERROR(104),
            AD_FAILED_TO_LOAD_NOT_FOUND(105),
            REQUEST_WILL_UPDATE_GMS_SIGNALS(1000),
            REQUEST_DID_UPDATE_GMS_SIGNALS(1001),
            REQUEST_FAILED_TO_UPDATE_GMS_SIGNALS(1002),
            REQUEST_FAILED_TO_BUILD_URL(1003),
            REQUEST_FAILED_TO_MAKE_NETWORK_REQUEST(1004),
            REQUEST_FAILED_TO_PROCESS_RESPONSE(1005),
            REQUEST_FAILED_TO_UPDATE_SIGNALS(1006),
            REQUEST_FAILED_TO_RENDER(1007),
            REQUEST_IS_PREFETCH(1100),
            REQUEST_SAVED_TO_CACHE(1101),
            REQUEST_LOADED_FROM_CACHE(1102),
            REQUEST_PREFETCH_INTERCEPTED(1103),
            REQUESTED_CACHE_KEY_FROM_SERVICE_SUCCEEDED(1104),
            REQUESTED_CACHE_KEY_FROM_SERVICE_FAILED(1105),
            NOTIFIED_CACHE_HIT_TO_SERVICE_SUCCEEDED(1106),
            NOTIFIED_CACHE_HIT_TO_SERVICE_FAILED(1107),
            REQUEST_FAILED_TO_LOAD_FROM_CACHE(1108),
            BANNER_SIZE_INVALID(10000),
            BANNER_SIZE_VALID(10001),
            ANDROID_WEBVIEW_CRASH(10002),
            OFFLINE_UPLOAD(10003),
            DELAY_PAGE_LOAD_CANCELLED_AD(10004);
            
            private static final zzene<zzb> zzes = null;
            private final int value;

            public final int zzv() {
                return this.value;
            }

            public final String toString() {
                return IMTextUtils.STREET_IMAGE_TAG_START + getClass().getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.value + " name=" + name() + Typography.greater;
            }

            private zzb(int i) {
                this.value = i;
            }

            static {
                zzes = new zzuc();
            }
        }

        private zza() {
        }

        /* renamed from: com.google.android.gms.internal.ads.zzub$zza$zza  reason: collision with other inner class name */
        /* compiled from: com.google.android.gms:play-services-ads@@19.8.0 */
        public static final class C22025zza extends zzena.zzb<zza, C22025zza> implements zzeop {
            private C22025zza() {
                super(zza.zzbwu);
            }

            /* synthetic */ C22025zza(zzua zzua) {
                this();
            }
        }

        /* access modifiers changed from: protected */
        public final Object zza(int i, Object obj, Object obj2) {
            switch (zzua.zzel[i - 1]) {
                case 1:
                    return new zza();
                case 2:
                    return new C22025zza((zzua) null);
                case 3:
                    return zza((zzeon) zzbwu, "\u0001\u0000", (Object[]) null);
                case 4:
                    return zzbwu;
                case 5:
                    zzeow<zza> zzeow = zzek;
                    if (zzeow == null) {
                        synchronized (zza.class) {
                            zzeow = zzek;
                            if (zzeow == null) {
                                zzeow = new zzena.zza<>(zzbwu);
                                zzek = zzeow;
                            }
                        }
                    }
                    return zzeow;
                case 6:
                    return (byte) 1;
                case 7:
                    return null;
                default:
                    throw new UnsupportedOperationException();
            }
        }

        static {
            zza zza = new zza();
            zzbwu = zza;
            zzena.zza(zza.class, zza);
        }
    }
}

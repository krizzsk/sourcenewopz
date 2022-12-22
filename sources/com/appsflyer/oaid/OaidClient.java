package com.appsflyer.oaid;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.appsflyer.internal.referrer.Payload;
import com.bun.miitmdid.core.JLibrary;
import com.bun.miitmdid.core.MdidSdkHelper;
import com.bun.supplier.IIdentifierListener;
import com.bun.supplier.IdSupplier;
import com.huawei.hms.ads.identifier.AdvertisingIdClient;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;
import java.util.logging.Logger;

public class OaidClient {
    private final Context context;
    /* access modifiers changed from: private */
    public final Logger logger;
    private final long timeout;
    private final TimeUnit unit;

    public OaidClient(Context context2, long j, TimeUnit timeUnit) {
        Logger logger2 = Logger.getLogger("AppsFlyerOaid5.4.0");
        this.logger = logger2;
        this.context = context2;
        this.timeout = j;
        this.unit = timeUnit;
        logger2.setLevel(Level.OFF);
    }

    public OaidClient(Context context2) {
        this(context2, 1, TimeUnit.SECONDS);
    }

    private static boolean isHuawei() {
        try {
            if (Build.BRAND.equalsIgnoreCase(Payload.SOURCE_HUAWEI) || ((Integer) Class.forName("com.huawei.android.os.BuildEx$VERSION").getDeclaredField("EMUI_SDK_INT").get((Object) null)).intValue() > 0) {
                return true;
            }
            return false;
        } catch (ClassNotFoundException | IllegalAccessException | NoSuchFieldException unused) {
            return false;
        }
    }

    public Info fetch() {
        try {
            long currentTimeMillis = System.currentTimeMillis();
            Info fetchHuawei = isHuawei() ? fetchHuawei() : fetchMsa();
            Logger logger2 = this.logger;
            logger2.info("Fetch " + (System.currentTimeMillis() - currentTimeMillis) + " ms");
            return fetchHuawei;
        } catch (Throwable th) {
            this.logger.log(Level.INFO, "Fetch", th);
            return null;
        }
    }

    private Info fetchMsa() throws Exception {
        String str;
        final LinkedBlockingQueue linkedBlockingQueue = new LinkedBlockingQueue();
        JLibrary.InitEntry(this.context);
        int InitSdk = MdidSdkHelper.InitSdk(this.context, this.logger.getLevel() == null, new IIdentifierListener() {
            public void OnSupport(boolean z, IdSupplier idSupplier) {
                try {
                    linkedBlockingQueue.offer(idSupplier == null ? "" : idSupplier.getOAID());
                } catch (Throwable th) {
                    OaidClient.this.logger.log(Level.INFO, "IIdentifierListener", th);
                }
            }
        });
        if (InitSdk != 0) {
            switch (InitSdk) {
                case 1008611:
                    str = "Unsupported manufacturer";
                    break;
                case 1008612:
                    str = "Unsupported device";
                    break;
                case 1008613:
                    str = "Error loading configuration file";
                    break;
                case 1008614:
                    str = "Callback will be executed in a different thread";
                    break;
                case 1008615:
                    str = "Reflection call error";
                    break;
                default:
                    str = String.valueOf(InitSdk);
                    break;
            }
            this.logger.warning(str);
        }
        String str2 = (String) linkedBlockingQueue.poll(this.timeout, this.unit);
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        return new Info(str2);
    }

    private Info fetchHuawei() {
        try {
            if (!AdvertisingIdClient.isAdvertisingIdAvailable(this.context)) {
                return null;
            }
            AdvertisingIdClient.Info advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(this.context);
            return new Info(advertisingIdInfo.getId(), Boolean.valueOf(advertisingIdInfo.isLimitAdTrackingEnabled()));
        } catch (Throwable th) {
            this.logger.log(Level.INFO, "Huawei", th);
            return null;
        }
    }

    public void setLogging(boolean z) {
        this.logger.setLevel(z ? null : Level.OFF);
    }

    public static class Info {

        /* renamed from: id */
        private final String f2049id;
        private final Boolean lat;

        public Info(String str, Boolean bool) {
            this.f2049id = str;
            this.lat = bool;
        }

        public Info(String str) {
            this(str, (Boolean) null);
        }

        public String getId() {
            return this.f2049id;
        }

        public Boolean getLat() {
            return this.lat;
        }
    }
}

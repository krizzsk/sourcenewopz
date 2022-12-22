package com.didi.payment.commonsdk.spi;

import android.app.Activity;
import com.didi.drouter.api.DRouter;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/spi/JumioService;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: JumioService.kt */
public final class JumioService {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @Metadata(mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J \u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u00062\u0006\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\f¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/spi/JumioService$Companion;", "", "()V", "checkPermissions", "", "ctx", "Landroid/app/Activity;", "isSupportedPlatform", "startDDCustomActivity", "", "activity", "token", "", "type", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: JumioService.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final boolean isSupportedPlatform(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "ctx");
            JumioServiceProvider service = DRouter.build(JumioServiceProvider.class).getService(new Object[0]);
            return service != null && service.isSupportedPlatform(activity);
        }

        public final boolean checkPermissions(Activity activity) {
            Intrinsics.checkNotNullParameter(activity, "ctx");
            JumioServiceProvider service = DRouter.build(JumioServiceProvider.class).getService(new Object[0]);
            return service != null && service.checkPermissions(activity);
        }

        public final void startDDCustomActivity(Activity activity, String str, String str2) {
            Intrinsics.checkNotNullParameter(activity, "activity");
            Intrinsics.checkNotNullParameter(str, "token");
            JumioServiceProvider service = DRouter.build(JumioServiceProvider.class).getService(new Object[0]);
            if (service != null) {
                service.startDDCustomActivity(activity, str, str2);
            }
        }
    }
}

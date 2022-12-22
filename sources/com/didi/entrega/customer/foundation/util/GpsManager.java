package com.didi.entrega.customer.foundation.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.entrega.uni_entrega_business.UniAPI;
import com.didi.entrega.uni_entrega_business.privacy.GLEUniPrivacyChangeService;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \f2\u00020\u0001:\u0002\f\rB\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0002J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bJ\u000e\u0010\u000b\u001a\u00020\n2\u0006\u0010\u0007\u001a\u00020\bR\u0014\u0010\u0003\u001a\b\u0018\u00010\u0004R\u00020\u0000X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/util/GpsManager;", "", "()V", "mGpsReceiver", "Lcom/didi/entrega/customer/foundation/util/GpsManager$GpsStatusReceiver;", "getGpsState", "", "context", "Landroid/content/Context;", "registerGpsReceiver", "", "unRegisterGpsReceiver", "Companion", "GpsStatusReceiver", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: GpsManager.kt */
public final class GpsManager {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static final GpsManager f20141b = new GpsManager();

    /* renamed from: a */
    private GpsStatusReceiver f20142a;

    public final void registerGpsReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        if (this.f20142a == null) {
            IntentFilter intentFilter = new IntentFilter();
            this.f20142a = new GpsStatusReceiver(this, context);
            intentFilter.addAction("android.location.MODE_CHANGED");
            intentFilter.addAction("android.location.PROVIDERS_CHANGED");
            try {
                context.registerReceiver(this.f20142a, intentFilter);
            } catch (Exception e) {
                Log.d("Context", "registerReceiver", e);
            }
        }
    }

    public final void unRegisterGpsReceiver(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        GpsStatusReceiver gpsStatusReceiver = this.f20142a;
        if (gpsStatusReceiver != null) {
            try {
                try {
                    context.unregisterReceiver(gpsStatusReceiver);
                } catch (Exception e) {
                    Log.d("Context", "unregisterReceiver", e);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            this.f20142a = null;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final boolean m14833a(Context context) {
        return CustomerSystemUtil.isGpsEnabled(context);
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0007\u001a\u00020\b2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0005\u001a\u00020\u0006X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/util/GpsManager$GpsStatusReceiver;", "Landroid/content/BroadcastReceiver;", "context", "Landroid/content/Context;", "(Lcom/didi/entrega/customer/foundation/util/GpsManager;Landroid/content/Context;)V", "mPreGpsState", "", "onReceive", "", "intent", "Landroid/content/Intent;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GpsManager.kt */
    private final class GpsStatusReceiver extends BroadcastReceiver {
        private boolean mPreGpsState;
        final /* synthetic */ GpsManager this$0;

        /* access modifiers changed from: private */
        /* renamed from: onReceive$lambda-0  reason: not valid java name */
        public static final void m46347onReceive$lambda0(Void voidR) {
        }

        public GpsStatusReceiver(GpsManager gpsManager, Context context) {
            Intrinsics.checkNotNullParameter(gpsManager, "this$0");
            Intrinsics.checkNotNullParameter(context, "context");
            this.this$0 = gpsManager;
            this.mPreGpsState = this.this$0.m14833a(context);
        }

        public void onReceive(Context context, Intent intent) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            String action = intent.getAction();
            if (Intrinsics.areEqual((Object) action, (Object) "android.location.PROVIDERS_CHANGED") || Intrinsics.areEqual((Object) action, (Object) "android.location.MODE_CHANGED")) {
                boolean access$getGpsState = this.this$0.m14833a(context);
                if (access$getGpsState != this.mPreGpsState) {
                    ((GLEUniPrivacyChangeService) UniAPI.get(GLEUniPrivacyChangeService.class)).locationPrivacyChanged(true, C8093xdf63d316.INSTANCE);
                }
                this.mPreGpsState = access$getGpsState;
            }
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u0011\u0010\u0003\u001a\u00020\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0005\u0010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/customer/foundation/util/GpsManager$Companion;", "", "()V", "instance", "Lcom/didi/entrega/customer/foundation/util/GpsManager;", "getInstance", "()Lcom/didi/entrega/customer/foundation/util/GpsManager;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: GpsManager.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final GpsManager getInstance() {
            return GpsManager.f20141b;
        }
    }
}

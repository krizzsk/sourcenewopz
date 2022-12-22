package com.didichuxing.comp.telecom.core.util;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.util.Log;
import com.didi.sdk.apm.SystemUtils;
import com.didichuxing.comp.telecom.core.CallLogUtil;
import com.didichuxing.comp.telecom.core.CallManagerAssist;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \t2\u00020\u0001:\u0001\tB\u0005¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\bH\u0016¨\u0006\n"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/VoipEnvSwitchHelper;", "Landroid/content/BroadcastReceiver;", "()V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* compiled from: VoipEnvSwitchHelper.kt */
public final class VoipEnvSwitchHelper extends BroadcastReceiver {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final Integer getEnvCache() {
        return Companion.getEnvCache();
    }

    @JvmStatic
    public static final void registerForDebug(Context context) {
        Companion.registerForDebug(context);
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u000f\u0010\u0003\u001a\u0004\u0018\u00010\u0004H\u0007¢\u0006\u0002\u0010\u0005J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0007J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\u000b\u001a\u00020\u0004¨\u0006\f"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/core/util/VoipEnvSwitchHelper$Companion;", "", "()V", "getEnvCache", "", "()Ljava/lang/Integer;", "registerForDebug", "", "context", "Landroid/content/Context;", "writeCache", "type", "voip-core_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
    /* compiled from: VoipEnvSwitchHelper.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        @JvmStatic
        public final void registerForDebug(Context context) {
            if (context != null) {
                IntentFilter intentFilter = new IntentFilter();
                intentFilter.addAction("com.didichuxing.comp.voip.switch");
                try {
                    context.registerReceiver(new VoipEnvSwitchHelper(), intentFilter);
                } catch (Exception e) {
                    Log.d("Context", "registerReceiver", e);
                }
            }
        }

        @JvmStatic
        public final Integer getEnvCache() {
            int i;
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Context appContext = instance.getAppContext();
            if (appContext == null || (i = SystemUtils.getSharedPreferences(appContext, "VoipCall", 0).getInt("env_type", -1)) <= 0) {
                return null;
            }
            return Integer.valueOf(i);
        }

        public final void writeCache(int i) {
            CallManagerAssist instance = CallManagerAssist.getInstance();
            Intrinsics.checkExpressionValueIsNotNull(instance, "CallManagerAssist.getInstance()");
            Context appContext = instance.getAppContext();
            if (appContext != null) {
                SystemUtils.getSharedPreferences(appContext, "VoipCall", 0).edit().putInt("env_type", i).commit();
            }
        }
    }

    public void onReceive(Context context, Intent intent) {
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        String stringExtra = intent.getStringExtra("env_type");
        CallLogUtil.logI("VoipEvnReceiver", "new env : " + stringExtra);
        CallManagerAssist instance = CallManagerAssist.getInstance();
        CallManagerAssist.CallManagerConfig config = instance != null ? instance.getConfig() : null;
        if (stringExtra != null) {
            int hashCode = stringExtra.hashCode();
            if (hashCode != 3556498) {
                if (hashCode != 95458899) {
                    if (hashCode == 1090594823 && stringExtra.equals("release")) {
                        if (config != null) {
                            config.setEnv(3);
                        }
                        Companion.writeCache(3);
                    }
                } else if (stringExtra.equals("debug")) {
                    if (config != null) {
                        config.setEnv(2);
                    }
                    Companion.writeCache(2);
                }
            } else if (stringExtra.equals("test")) {
                if (config != null) {
                    config.setEnv(1);
                }
                Companion.writeCache(1);
            }
        }
    }
}

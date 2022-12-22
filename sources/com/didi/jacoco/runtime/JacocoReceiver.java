package com.didi.jacoco.runtime;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.SharedPreferences;
import com.didi.jacoco.runtime.module.role.Data;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jacoco.agent.p086rt.internal_8ff85ea.Offline;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u000b2\u00020\u0001:\u0001\u000bB\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0018\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\f"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/JacocoReceiver;", "Landroid/content/BroadcastReceiver;", "generator", "Lcom/didi/jacoco/runtime/JacocoGenerator;", "(Lcom/didi/jacoco/runtime/JacocoGenerator;)V", "onReceive", "", "context", "Landroid/content/Context;", "intent", "Landroid/content/Intent;", "Companion", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
/* compiled from: JacocoReceiver.kt */
public final class JacocoReceiver extends BroadcastReceiver {
    private static transient /* synthetic */ boolean[] $jacocoData = null;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    private static final String jacocoAction = jacocoAction;
    private static final IntentFilter jacocoIntentFilter = new IntentFilter(jacocoAction);
    private final JacocoGenerator generator;

    private static /* synthetic */ boolean[] $jacocoInit() {
        boolean[] zArr = $jacocoData;
        if (zArr != null) {
            return zArr;
        }
        boolean[] probes = Offline.getProbes(-208529479786738371L, "com/didi/jacoco/runtime/JacocoReceiver", 17);
        $jacocoData = probes;
        return probes;
    }

    public static final String getJacocoAction() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = jacocoAction;
        $jacocoInit[15] = true;
        return str;
    }

    public static final IntentFilter getJacocoIntentFilter() {
        boolean[] $jacocoInit = $jacocoInit();
        IntentFilter intentFilter = jacocoIntentFilter;
        $jacocoInit[16] = true;
        return intentFilter;
    }

    public JacocoReceiver(JacocoGenerator jacocoGenerator) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(jacocoGenerator, "generator");
        $jacocoInit[9] = true;
        this.generator = jacocoGenerator;
        $jacocoInit[10] = true;
    }

    public static final /* synthetic */ String access$getJacocoAction$cp() {
        boolean[] $jacocoInit = $jacocoInit();
        String str = jacocoAction;
        $jacocoInit[13] = true;
        return str;
    }

    public static final /* synthetic */ IntentFilter access$getJacocoIntentFilter$cp() {
        boolean[] $jacocoInit = $jacocoInit();
        IntentFilter intentFilter = jacocoIntentFilter;
        $jacocoInit[14] = true;
        return intentFilter;
    }

    public void onReceive(Context context, Intent intent) {
        boolean[] $jacocoInit = $jacocoInit();
        Intrinsics.checkParameterIsNotNull(context, "context");
        Intrinsics.checkParameterIsNotNull(intent, "intent");
        $jacocoInit[0] = true;
        SharedPreferences sharedPreferences = SystemUtils.getSharedPreferences(context, "data", 0);
        $jacocoInit[1] = true;
        String string = sharedPreferences.getString("id", (String) null);
        $jacocoInit[2] = true;
        String string2 = sharedPreferences.getString("name", (String) null);
        if (string == null) {
            $jacocoInit[3] = true;
        } else if (string2 == null) {
            $jacocoInit[4] = true;
        } else {
            $jacocoInit[5] = true;
            Data data = new Data(string, string2);
            $jacocoInit[6] = true;
            this.generator.generate(true, data);
            $jacocoInit[7] = true;
        }
        $jacocoInit[8] = true;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u00020\u00048\u0006XD¢\u0006\u000e\n\u0000\u0012\u0004\b\u0005\u0010\u0002\u001a\u0004\b\u0006\u0010\u0007R\u001c\u0010\b\u001a\u00020\t8\u0006X\u0004¢\u0006\u000e\n\u0000\u0012\u0004\b\n\u0010\u0002\u001a\u0004\b\u000b\u0010\f¨\u0006\r"}, mo175978d2 = {"Lcom/didi/jacoco/runtime/JacocoReceiver$Companion;", "", "()V", "jacocoAction", "", "jacocoAction$annotations", "getJacocoAction", "()Ljava/lang/String;", "jacocoIntentFilter", "Landroid/content/IntentFilter;", "jacocoIntentFilter$annotations", "getJacocoIntentFilter", "()Landroid/content/IntentFilter;", "jacoco-runtime_release"}, mo175979k = 1, mo175980mv = {1, 1, 16})
    /* compiled from: JacocoReceiver.kt */
    public static final class Companion {
        private static transient /* synthetic */ boolean[] $jacocoData;

        private static /* synthetic */ boolean[] $jacocoInit() {
            boolean[] zArr = $jacocoData;
            if (zArr != null) {
                return zArr;
            }
            boolean[] probes = Offline.getProbes(4029281480769770250L, "com/didi/jacoco/runtime/JacocoReceiver$Companion", 6);
            $jacocoData = probes;
            return probes;
        }

        @JvmStatic
        public static /* synthetic */ void jacocoAction$annotations() {
            $jacocoInit()[0] = true;
        }

        @JvmStatic
        public static /* synthetic */ void jacocoIntentFilter$annotations() {
            $jacocoInit()[2] = true;
        }

        private Companion() {
            $jacocoInit()[4] = true;
        }

        /* JADX INFO: this call moved to the top of the method (can break code semantics) */
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
            boolean[] $jacocoInit = $jacocoInit();
            $jacocoInit[5] = true;
        }

        public final String getJacocoAction() {
            boolean[] $jacocoInit = $jacocoInit();
            String access$getJacocoAction$cp = JacocoReceiver.access$getJacocoAction$cp();
            $jacocoInit[1] = true;
            return access$getJacocoAction$cp;
        }

        public final IntentFilter getJacocoIntentFilter() {
            boolean[] $jacocoInit = $jacocoInit();
            IntentFilter access$getJacocoIntentFilter$cp = JacocoReceiver.access$getJacocoIntentFilter$cp();
            $jacocoInit[3] = true;
            return access$getJacocoIntentFilter$cp;
        }
    }

    static {
        boolean[] $jacocoInit = $jacocoInit();
        $jacocoInit[11] = true;
        $jacocoInit[12] = true;
    }
}

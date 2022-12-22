package com.didi.map.global.flow.utils;

import android.app.Activity;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.appcompat.app.AlertDialog;
import com.didi.map.google.config.Config;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \r2\u00020\u0001:\u0001\rB\u0005¢\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\u0007\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u000e\u0010\b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006J\u0012\u0010\t\u001a\u00020\u00042\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0014J\u000e\u0010\f\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006¨\u0006\u000e"}, mo175978d2 = {"Lcom/didi/map/global/flow/utils/SettingsActivity;", "Landroid/app/Activity;", "()V", "bluetoothScan", "", "view", "Landroid/view/View;", "debugLog", "debugOraUrl", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "recommendPointDismissTime", "Companion", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: SettingsActivity.kt */
public final class SettingsActivity extends Activity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    @JvmStatic
    public static final void startActivity(Context context) {
        Companion.startActivity(context);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView(R.layout.activity_setting_layout_map);
    }

    public final void bluetoothScan(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean z = Config.DEFAULT_BLUETOOTH_SCAN;
        builder.setSingleChoiceItems((CharSequence[]) new String[]{"关闭扫描", "开启扫描"}, z ? 1 : 0, (DialogInterface.OnClickListener) $$Lambda$SettingsActivity$fL1rIi9LK4pFBX2aioVBjLGGr0.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        SystemUtils.showDialog(create);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m19273a(DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        dialogInterface.dismiss();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Config.DEFAULT_BLUETOOTH_SCAN = z;
    }

    public final void recommendPointDismissTime(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        String[] strArr = {"apollo配置时间", "100s"};
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setSingleChoiceItems((CharSequence[]) strArr, Config.RecommendDuration != 0 ? 1 : 0, (DialogInterface.OnClickListener) $$Lambda$SettingsActivity$QXOzAivSR83GPOAup6pc_uiQTM.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        SystemUtils.showDialog(create);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m19274b(DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        dialogInterface.dismiss();
        if (i == 0) {
            Config.RecommendDuration = 0;
        } else {
            Config.RecommendDuration = 100;
        }
    }

    public final void debugLog(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean z = Config.DEBUG;
        builder.setSingleChoiceItems((CharSequence[]) new String[]{"正式", "DEBUG"}, z ? 1 : 0, (DialogInterface.OnClickListener) $$Lambda$SettingsActivity$B65jX0Ni5Es2ttm3JIB8NrKNClk.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        SystemUtils.showDialog(create);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m19275c(DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        dialogInterface.dismiss();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Config.DEBUG = z;
    }

    public final void debugOraUrl(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        boolean z = Config.DEBUG_ORA;
        builder.setSingleChoiceItems((CharSequence[]) new String[]{"正式", "DEBUG ORA URL"}, z ? 1 : 0, (DialogInterface.OnClickListener) $$Lambda$SettingsActivity$QTkkpD1SLKS39vMBtldxasOWHw.INSTANCE);
        AlertDialog create = builder.create();
        Intrinsics.checkNotNullExpressionValue(create, "builder.create()");
        SystemUtils.showDialog(create);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m19276d(DialogInterface dialogInterface, int i) {
        Intrinsics.checkNotNullParameter(dialogInterface, "dialog");
        dialogInterface.dismiss();
        boolean z = true;
        if (i != 1) {
            z = false;
        }
        Config.DEBUG_ORA = z;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/map/global/flow/utils/SettingsActivity$Companion;", "", "()V", "startActivity", "", "context", "Landroid/content/Context;", "sdk-mapflow_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: SettingsActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        @JvmStatic
        public final void startActivity(Context context) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intent intent = new Intent();
            intent.setClass(context, SettingsActivity.class);
            intent.setFlags(268435456);
            context.startActivity(intent);
        }
    }
}

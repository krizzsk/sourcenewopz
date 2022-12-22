package com.didi.payment.base.utils.ktx;

import android.app.Activity;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.apm.SystemUtils;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function3;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0015\n\u0002\b\u0003\u0018\u0000 \u00142\u00020\u0001:\u0001\u0014B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00062\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\n\u001a\u00020\u00042\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J-\u0010\r\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u000e\u0010\u000e\u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00100\u000f2\u0006\u0010\u0011\u001a\u00020\u0012H\u0016¢\u0006\u0002\u0010\u0013¨\u0006\u0015"}, mo175978d2 = {"Lcom/didi/payment/base/utils/ktx/RequestActivity;", "Landroidx/fragment/app/FragmentActivity;", "()V", "onActivityResult", "", "requestCode", "", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRequestPermissionsResult", "permissions", "", "", "grantResults", "", "(I[Ljava/lang/String;[I)V", "Companion", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: RequestActivity.kt */
public final class RequestActivity extends FragmentActivity {
    public static final int ACTIVITY_RESULT = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String KEY_PERMISSIONS = "permissions";
    public static final int PERMISSION_RESULT = 2;
    public static final String REQUEST_CODE = "request_code";
    public static final String TYPE = "type";
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static Function3<? super Integer, ? super Integer, ? super Intent, Unit> f30033a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static Function3<? super Integer, ? super String[], ? super int[], Unit> f30034b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public static Intent f30035c;

    @Metadata(mo175977d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0010\u0011\n\u0002\u0010\u0015\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J+\u0010\u001c\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010\u001f\u001a\u00020\u00042\u000e\u0010 \u001a\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0013¢\u0006\u0002\u0010!J\u001e\u0010\"\u001a\u00020\r2\u0006\u0010\u001d\u001a\u00020\u001e2\u0006\u0010#\u001a\u00020\f2\u0006\u0010\u001f\u001a\u00020\u0004R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0006XT¢\u0006\u0002\n\u0000R6\u0010\n\u001a\u001e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u0004\u0012\u0006\u0012\u0004\u0018\u00010\f\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R<\u0010\u0012\u001a$\u0012\u0004\u0012\u00020\u0004\u0012\f\u0012\n\u0012\u0006\b\u0001\u0012\u00020\u00060\u0013\u0012\u0004\u0012\u00020\u0014\u0012\u0004\u0012\u00020\r\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000f\"\u0004\b\u0016\u0010\u0011R\u001c\u0010\u0017\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001b¨\u0006$"}, mo175978d2 = {"Lcom/didi/payment/base/utils/ktx/RequestActivity$Companion;", "", "()V", "ACTIVITY_RESULT", "", "KEY_PERMISSIONS", "", "PERMISSION_RESULT", "REQUEST_CODE", "TYPE", "onActivityResult", "Lkotlin/Function3;", "Landroid/content/Intent;", "", "getOnActivityResult", "()Lkotlin/jvm/functions/Function3;", "setOnActivityResult", "(Lkotlin/jvm/functions/Function3;)V", "onRequestPermissionsResult", "", "", "getOnRequestPermissionsResult", "setOnRequestPermissionsResult", "requestIntent", "getRequestIntent", "()Landroid/content/Intent;", "setRequestIntent", "(Landroid/content/Intent;)V", "requestPermission", "context", "Landroid/app/Activity;", "requestCode", "permissions", "(Landroid/app/Activity;I[Ljava/lang/String;)V", "startForResult", "intent", "base_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: RequestActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final Function3<Integer, Integer, Intent, Unit> getOnActivityResult() {
            return RequestActivity.f30033a;
        }

        public final void setOnActivityResult(Function3<? super Integer, ? super Integer, ? super Intent, Unit> function3) {
            RequestActivity.f30033a = function3;
        }

        public final Function3<Integer, String[], int[], Unit> getOnRequestPermissionsResult() {
            return RequestActivity.f30034b;
        }

        public final void setOnRequestPermissionsResult(Function3<? super Integer, ? super String[], ? super int[], Unit> function3) {
            RequestActivity.f30034b = function3;
        }

        public final Intent getRequestIntent() {
            return RequestActivity.f30035c;
        }

        public final void setRequestIntent(Intent intent) {
            RequestActivity.f30035c = intent;
        }

        public final void startForResult(Activity activity, Intent intent, int i) {
            Intrinsics.checkNotNullParameter(activity, "context");
            Intrinsics.checkNotNullParameter(intent, "intent");
            setRequestIntent(intent);
            Intent intent2 = new Intent(activity, RequestActivity.class);
            intent2.putExtra("request_code", i);
            intent2.putExtra("type", 1);
            activity.startActivity(intent2);
        }

        public final void requestPermission(Activity activity, int i, String[] strArr) {
            Intrinsics.checkNotNullParameter(activity, "context");
            Intrinsics.checkNotNullParameter(strArr, "permissions");
            Intent intent = new Intent(activity, RequestActivity.class);
            intent.putExtra("request_code", i);
            intent.putExtra("type", 2);
            intent.putExtra("permissions", strArr);
            activity.startActivity(intent);
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        Intent intent = getIntent();
        if (intent != null) {
            int intExtra = intent.getIntExtra("request_code", 0);
            if (intent.getIntExtra("type", 0) == 1) {
                Intent intent2 = f30035c;
                if (intent2 != null) {
                    startActivityForResult(intent2, intExtra);
                }
            } else if (intent.getIntExtra("type", 0) == 2) {
                String[] stringArrayExtra = intent.getStringArrayExtra("permissions");
                if (Build.VERSION.SDK_INT >= 23 && stringArrayExtra != null) {
                    requestPermissions(stringArrayExtra, intExtra);
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        Function3<? super Integer, ? super Integer, ? super Intent, Unit> function3 = f30033a;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(i), Integer.valueOf(i2), intent);
        }
        f30033a = null;
        finish();
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        Intrinsics.checkNotNullParameter(strArr, "permissions");
        Intrinsics.checkNotNullParameter(iArr, "grantResults");
        super.onRequestPermissionsResult(i, strArr, iArr);
        Function3<? super Integer, ? super String[], ? super int[], Unit> function3 = f30034b;
        if (function3 != null) {
            function3.invoke(Integer.valueOf(i), strArr, iArr);
        }
        f30034b = null;
        finish();
    }
}

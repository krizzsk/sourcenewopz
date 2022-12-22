package com.didi.safetoolkit.business.triprecording;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.HashMap;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00132\u00020\u0001:\u0001\u0013B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010\t\u001a\u00020\nH\u0014J\b\u0010\u000b\u001a\u00020\fH\u0014J\b\u0010\r\u001a\u00020\nH\u0014J\b\u0010\u000e\u001a\u00020\nH\u0014J\u0012\u0010\u000f\u001a\u00020\n2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010\u0012\u001a\u00020\nH\u0014R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/triprecording/SfPermissionActivity;", "Lcom/didi/safetoolkit/base/BaseSafeToolkitActivity;", "()V", "oid", "", "getOid", "()Ljava/lang/String;", "setOid", "(Ljava/lang/String;)V", "findViews", "", "getBasicContentLayoutResId", "", "inflateContentView", "initData", "parseBundle", "bundle", "Landroid/os/Bundle;", "setListener", "Companion", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
/* compiled from: SfPermissionActivity.kt */
public final class SfPermissionActivity extends BaseSafeToolkitActivity {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private String f34471a = "";

    /* renamed from: b */
    private HashMap f34472b;

    public void _$_clearFindViewByIdCache() {
        HashMap hashMap = this.f34472b;
        if (hashMap != null) {
            hashMap.clear();
        }
    }

    public View _$_findCachedViewById(int i) {
        if (this.f34472b == null) {
            this.f34472b = new HashMap();
        }
        View view = (View) this.f34472b.get(Integer.valueOf(i));
        if (view != null) {
            return view;
        }
        View findViewById = findViewById(i);
        this.f34472b.put(Integer.valueOf(i), findViewById);
        return findViewById;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return 0;
    }

    /* access modifiers changed from: protected */
    public void inflateContentView() {
    }

    /* access modifiers changed from: protected */
    public void setListener() {
    }

    public final String getOid() {
        return this.f34471a;
    }

    public final void setOid(String str) {
        Intrinsics.checkParameterIsNotNull(str, "<set-?>");
        this.f34471a = str;
    }

    @Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0018\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\b¨\u0006\t"}, mo175978d2 = {"Lcom/didi/safetoolkit/business/triprecording/SfPermissionActivity$Companion;", "", "()V", "permission", "", "context", "Landroid/app/Activity;", "oid", "", "safe-toolkit_passengerRelease"}, mo175979k = 1, mo175980mv = {1, 1, 15})
    /* compiled from: SfPermissionActivity.kt */
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        public final boolean permission(Activity activity, String str) {
            Intrinsics.checkParameterIsNotNull(activity, "context");
            if (new PermissionToolsCompat(activity).checkPermissionsIsGranted(Permission.RECORD_AUDIO)) {
                return false;
            }
            Intent intent = new Intent(activity, SfPermissionActivity.class);
            intent.putExtra("SF_OID", str);
            activity.startActivity(intent);
            return true;
        }
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        String stringExtra = getIntent().getStringExtra("SF_OID");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f34471a = stringExtra;
    }

    /* access modifiers changed from: protected */
    public void initData() {
        requestPermission(new SfPermissionActivity$initData$1(this), Permission.RECORD_AUDIO);
    }
}

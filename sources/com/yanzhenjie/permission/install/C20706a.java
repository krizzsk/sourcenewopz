package com.yanzhenjie.permission.install;

import android.content.Intent;
import com.yanzhenjie.permission.Action;
import com.yanzhenjie.permission.AndPermission;
import com.yanzhenjie.permission.Rationale;
import com.yanzhenjie.permission.RequestExecutor;
import com.yanzhenjie.permission.source.Source;
import java.io.File;

/* renamed from: com.yanzhenjie.permission.install.a */
/* compiled from: BaseRequest */
abstract class C20706a implements InstallRequest {

    /* renamed from: a */
    private Source f56196a;

    /* renamed from: b */
    private File f56197b;

    /* renamed from: c */
    private Rationale<File> f56198c = new BaseRequest$1(this);

    /* renamed from: d */
    private Action<File> f56199d;

    /* renamed from: e */
    private Action<File> f56200e;

    C20706a(Source source) {
        this.f56196a = source;
    }

    public final InstallRequest file(File file) {
        this.f56197b = file;
        return this;
    }

    public final InstallRequest rationale(Rationale<File> rationale) {
        this.f56198c = rationale;
        return this;
    }

    public final InstallRequest onGranted(Action<File> action) {
        this.f56199d = action;
        return this;
    }

    public final InstallRequest onDenied(Action<File> action) {
        this.f56200e = action;
        return this;
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169075a(RequestExecutor requestExecutor) {
        this.f56198c.showRationale(this.f56196a.getContext(), null, requestExecutor);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public final void mo169074a() {
        Intent intent = new Intent("android.intent.action.INSTALL_PACKAGE");
        intent.setFlags(268435456);
        intent.addFlags(1);
        intent.setDataAndType(AndPermission.getFileUri(this.f56196a.getContext(), this.f56197b), "application/vnd.android.package-archive");
        this.f56196a.startActivity(intent);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public final void mo169076b() {
        Action<File> action = this.f56199d;
        if (action != null) {
            action.onAction(this.f56197b);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public final void mo169077c() {
        Action<File> action = this.f56200e;
        if (action != null) {
            action.onAction(this.f56197b);
        }
    }
}

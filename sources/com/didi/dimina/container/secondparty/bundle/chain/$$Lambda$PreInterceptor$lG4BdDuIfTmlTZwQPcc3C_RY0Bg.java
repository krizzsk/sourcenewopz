package com.didi.dimina.container.secondparty.bundle.chain;

import android.widget.Toast;
import com.didi.dimina.container.Dimina;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.dimina.container.secondparty.bundle.chain.-$$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg  reason: invalid class name */
/* compiled from: lambda */
public final /* synthetic */ class $$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg implements Runnable {
    public static final /* synthetic */ $$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg INSTANCE = new $$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg();

    private /* synthetic */ $$Lambda$PreInterceptor$lG4BdDuIfTmlTZwQPcc3C_RY0Bg() {
    }

    public final void run() {
        SystemUtils.showToast(Toast.makeText(Dimina.getConfig().getApp(), "错误:传入的jsAppId(或JsSdkId), 与 Asset 中读取的值不同", 1));
    }
}

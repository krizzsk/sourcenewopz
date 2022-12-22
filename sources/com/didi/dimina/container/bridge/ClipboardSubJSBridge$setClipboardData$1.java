package com.didi.dimina.container.bridge;

import com.didi.dimina.container.bridge.toast.ToastServiceManager;
import com.didi.dimina.container.bridge.toast.ToastType;
import com.didi.dimina.container.util.LogUtil;
import com.taxis99.R;
import kotlin.Metadata;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, mo175978d2 = {"<anonymous>", "", "run"}, mo175979k = 3, mo175980mv = {1, 1, 16})
/* compiled from: ClipboardSubJSBridge.kt */
final class ClipboardSubJSBridge$setClipboardData$1 implements Runnable {
    final /* synthetic */ ClipboardSubJSBridge this$0;

    ClipboardSubJSBridge$setClipboardData$1(ClipboardSubJSBridge clipboardSubJSBridge) {
        this.this$0 = clipboardSubJSBridge;
    }

    public final void run() {
        ToastServiceManager toastServiceManager = new ToastServiceManager(this.this$0.f16562b);
        String access$getTAG$p = this.this$0.f16563c;
        LogUtil.m13412i(access$getTAG$p, "setClipboardData, 弹出toast，toast内容： " + this.this$0.f16562b.getString(R.string.dimina_content_is_copied));
        toastServiceManager.showToast(ToastType.NONE, this.this$0.f16562b.getString(R.string.dimina_content_is_copied), 1500);
    }
}

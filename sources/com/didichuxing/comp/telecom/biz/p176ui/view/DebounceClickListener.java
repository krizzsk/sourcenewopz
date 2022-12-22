package com.didichuxing.comp.telecom.biz.p176ui.view;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175976bv = {1, 0, 3}, mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tH&J\u000e\u0010\n\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\tR\u000e\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u000e¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didichuxing/comp/telecom/biz/ui/view/DebounceClickListener;", "Landroid/view/View$OnClickListener;", "()V", "delayTime", "", "lastClickTime", "onBtnClick", "", "v", "Landroid/view/View;", "onClick", "voip-biz_release"}, mo175979k = 1, mo175980mv = {1, 1, 13})
/* renamed from: com.didichuxing.comp.telecom.biz.ui.view.DebounceClickListener */
/* compiled from: DebounceClickListener.kt */
public abstract class DebounceClickListener implements View.OnClickListener {
    private long delayTime = 800;
    private long lastClickTime;

    public abstract void onBtnClick(View view);

    public final void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        Intrinsics.checkParameterIsNotNull(view, RavenKey.VERSION);
        long currentTimeMillis = System.currentTimeMillis();
        if (Math.abs(currentTimeMillis - this.lastClickTime) >= this.delayTime) {
            onBtnClick(view);
            this.lastClickTime = currentTimeMillis;
        }
    }
}

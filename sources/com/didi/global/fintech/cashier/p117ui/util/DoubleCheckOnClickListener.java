package com.didi.global.fintech.cashier.p117ui.util;

import android.view.View;
import com.didi.autotracker.AutoTrackHelper;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b&\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\u0006\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH&J\u0012\u0010\n\u001a\u00020\u00072\b\u0010\b\u001a\u0004\u0018\u00010\tH\u0016R\u000e\u0010\u0005\u001a\u00020\u0003X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006\u000b"}, mo175978d2 = {"Lcom/didi/global/fintech/cashier/ui/util/DoubleCheckOnClickListener;", "Landroid/view/View$OnClickListener;", "waitTime", "", "(J)V", "lastClickTimestamp", "doClick", "", "v", "Landroid/view/View;", "onClick", "cashier_ui_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.global.fintech.cashier.ui.util.DoubleCheckOnClickListener */
/* compiled from: DoubleCheckOnClickListener.kt */
public abstract class DoubleCheckOnClickListener implements View.OnClickListener {
    private long lastClickTimestamp;
    private final long waitTime;

    public abstract void doClick(View view);

    public DoubleCheckOnClickListener(long j) {
        this.waitTime = j;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        long currentTimeMillis = System.currentTimeMillis();
        if (currentTimeMillis - this.lastClickTimestamp >= this.waitTime) {
            doClick(view);
            this.lastClickTimestamp = currentTimeMillis;
        }
    }
}

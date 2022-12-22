package com.didiglobal.xpanelnew.message;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.view.View;
import android.view.ViewGroup;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.didiglobal.xpanelnew.util.XpLog;
import com.didiglobal.xpanelnew.util.XpUtils;

public class XpMessageLayout extends RoundCornerRelativeLayout implements IXpMessageContainer {
    public static final String TAG = "XpMessageLayout";

    /* renamed from: b */
    private static final int f51611b = 1;

    /* renamed from: c */
    private static final int f51612c = 2;

    /* renamed from: d */
    private boolean f51613d;

    /* renamed from: e */
    private IMessageDataListener f51614e;

    /* renamed from: f */
    private XpMessageItem f51615f;

    /* renamed from: g */
    private View f51616g;

    public View getView() {
        return this;
    }

    public XpMessageLayout(Context context, int i) {
        super(context);
        setRadius(i);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) i);
        gradientDrawable.setColor(Color.parseColor("#F5F9FC"));
        setBackground(gradientDrawable);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:13:0x0016, code lost:
        return;
     */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public synchronized void addMessageItem(com.didiglobal.xpanelnew.message.XpMessageItem r2) {
        /*
            r1 = this;
            monitor-enter(r1)
            if (r2 == 0) goto L_0x0015
            android.view.View r0 = r2.getContentView()     // Catch:{ all -> 0x0012 }
            if (r0 != 0) goto L_0x000a
            goto L_0x0015
        L_0x000a:
            r1.f51615f = r2     // Catch:{ all -> 0x0012 }
            r2 = 1
            r1.m36911a((int) r2)     // Catch:{ all -> 0x0012 }
            monitor-exit(r1)
            return
        L_0x0012:
            r2 = move-exception
            monitor-exit(r1)
            throw r2
        L_0x0015:
            monitor-exit(r1)
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didiglobal.xpanelnew.message.XpMessageLayout.addMessageItem(com.didiglobal.xpanelnew.message.XpMessageItem):void");
    }

    public void setMessageDataListener(IMessageDataListener iMessageDataListener) {
        this.f51614e = iMessageDataListener;
    }

    /* renamed from: a */
    private void m36911a(int i) {
        if (i == 1) {
            m36912a(this.f51615f);
        }
    }

    /* renamed from: a */
    private synchronized void m36912a(XpMessageItem xpMessageItem) {
        setVisibility(0);
        View contentView = xpMessageItem.getContentView();
        this.f51616g = contentView;
        if (contentView.getParent() == null) {
            if (getChildCount() != 0) {
                removeAllViews();
            }
            ViewGroup.LayoutParams layoutParams = this.f51616g.getLayoutParams();
            if (layoutParams != null) {
                layoutParams.width = -1;
            } else {
                layoutParams = new ViewGroup.LayoutParams(-1, -2);
            }
            addView(this.f51616g, layoutParams);
            XpLog.m36924d("lxslxsMsg", "addMsg");
        } else if (!XpUtils.isDebug(getContext())) {
            XpLog.m36927e(TAG, "The specified child already has a parent.");
        } else {
            throw new IllegalStateException("The specified child already has a parent. You must call removeView() on the child's parent first.");
        }
    }

    public int getCurrentHeight() {
        return getMeasuredHeight();
    }

    /* access modifiers changed from: protected */
    public void onMeasure(int i, int i2) {
        IMessageDataListener iMessageDataListener;
        super.onMeasure(i, i2);
        XpLog.m36924d("lxslxsMsg", "onMeasure, height: " + getMeasuredHeight());
        if (!this.f51613d && (iMessageDataListener = this.f51614e) != null) {
            iMessageDataListener.notifyAdd();
            this.f51613d = true;
        }
    }
}

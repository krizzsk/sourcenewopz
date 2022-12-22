package com.didi.beatles.p099im.views.eggs.impl;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.os.SystemClock;
import android.util.AttributeSet;
import android.view.View;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.IMWindowUtil;
import com.didi.beatles.p099im.views.eggs.IIMEggsDrop;
import com.didi.beatles.p099im.views.eggs.IIMEggsView;
import com.didi.beatles.p099im.views.eggs.IMEggsDropFactory;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* renamed from: com.didi.beatles.im.views.eggs.impl.IMEggsView */
public class IMEggsView extends View implements IIMEggsView {

    /* renamed from: a */
    private static final String f10243a = IMEggsView.class.getSimpleName();

    /* renamed from: b */
    private static final int f10244b = 20;

    /* renamed from: c */
    private static final int f10245c = 20;

    /* renamed from: d */
    private int f10246d;

    /* renamed from: e */
    private int f10247e;

    /* renamed from: f */
    private List<IIMEggsDrop> f10248f;

    /* renamed from: g */
    private IIMEggsView.OnDrawCallback f10249g;

    public IMEggsView(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f10246d = 20;
        this.f10247e = 20;
        this.f10248f = new CopyOnWriteArrayList();
    }

    public void setFrameInterval(int i) {
        this.f10246d = i;
    }

    public void setMaxCount(int i) {
        this.f10247e = i;
    }

    public void displayEggs(IMConfig.EggsInfo eggsInfo, Bitmap bitmap) {
        String str = f10243a;
        IMLog.m6631d(str, "[displayEggs] count=" + eggsInfo.count + " |size=" + this.f10248f.size());
        if (getVisibility() == 0) {
            this.f10248f.clear();
            int min = Math.min(eggsInfo.count, this.f10247e);
            for (int i = 0; i < min; i++) {
                IIMEggsDrop create = IMEggsDropFactory.create(eggsInfo);
                if (create != null) {
                    create.init(bitmap, IMWindowUtil.dip2px((float) eggsInfo.width), IMWindowUtil.dip2px((float) eggsInfo.height));
                    this.f10248f.add(create);
                }
            }
            invalidate();
        }
    }

    public void setOnDrawCallback(IIMEggsView.OnDrawCallback onDrawCallback) {
        this.f10249g = onDrawCallback;
    }

    public void reset() {
        this.f10248f.clear();
    }

    /* access modifiers changed from: protected */
    public void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        long uptimeMillis = SystemClock.uptimeMillis();
        m6977a(canvas);
        List<IIMEggsDrop> list = this.f10248f;
        if (list != null && list.size() > 0) {
            long uptimeMillis2 = SystemClock.uptimeMillis() - uptimeMillis;
            int i = this.f10246d;
            if (uptimeMillis2 - ((long) i) < 0) {
                postInvalidateDelayed(((long) i) - uptimeMillis2);
            } else {
                postInvalidate();
            }
        }
    }

    /* renamed from: a */
    private void m6977a(Canvas canvas) {
        for (IIMEggsDrop next : this.f10248f) {
            next.draw(canvas);
            if (!next.isActive()) {
                this.f10248f.remove(next);
                IIMEggsView.OnDrawCallback onDrawCallback = this.f10249g;
                if (!(onDrawCallback == null || next == null)) {
                    onDrawCallback.onFinished(next);
                }
            }
        }
    }
}

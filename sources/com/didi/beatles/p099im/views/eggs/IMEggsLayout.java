package com.didi.beatles.p099im.views.eggs;

import android.content.Context;
import android.graphics.Bitmap;
import android.os.Build;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.beatles.p099im.api.entity.IMConfig;
import com.didi.beatles.p099im.utils.C4234I;
import com.didi.beatles.p099im.utils.IMLog;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.utils.imageloader.Callback;
import com.didi.beatles.p099im.views.eggs.IIMEggsView;
import com.didi.beatles.p099im.views.eggs.impl.IMEggsSurfaceView;
import com.didi.beatles.p099im.views.eggs.impl.IMEggsView;

/* renamed from: com.didi.beatles.im.views.eggs.IMEggsLayout */
public class IMEggsLayout extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static final String f10205a = IMEggsLayout.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: b */
    public IIMEggsView f10206b;

    public IMEggsLayout(Context context) {
        this(context, (AttributeSet) null);
    }

    public IMEggsLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMEggsLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6968b();
    }

    /* renamed from: b */
    private void m6968b() {
        if (Build.VERSION.SDK_INT >= 21) {
            this.f10206b = new IMEggsSurfaceView(getContext());
        } else {
            this.f10206b = new IMEggsView(getContext(), (AttributeSet) null);
        }
        String str = f10205a;
        IMLog.m6631d(str, "[initViews] IIMEggsView=>" + this.f10206b.getClass());
        ((View) this.f10206b).setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        post(new Runnable() {
            public void run() {
                if (IMEggsLayout.this.f10206b != null && (IMEggsLayout.this.f10206b instanceof View)) {
                    IMEggsLayout iMEggsLayout = IMEggsLayout.this;
                    iMEggsLayout.addView((View) iMEggsLayout.f10206b);
                }
            }
        });
        this.f10206b.setOnDrawCallback(new IIMEggsView.OnDrawCallback() {
            public void onFinished(IIMEggsDrop iIMEggsDrop) {
                iIMEggsDrop.recycle();
            }
        });
    }

    public void displayEggs(final IMConfig.EggsInfo eggsInfo) {
        if (eggsInfo.width <= 0 || eggsInfo.height <= 0) {
            IMLog.m6632e(f10205a, C4234I.m6591t("[displayEggs] invalid size info: w=", Integer.valueOf(eggsInfo.width), " |h=", Integer.valueOf(eggsInfo.height)));
            return;
        }
        BtsImageLoader.getInstance().download(eggsInfo.image, new Callback() {
            public void onStart() {
            }

            public void onSuccess(Bitmap bitmap) {
                if (bitmap != null) {
                    IMEggsLayout.this.f10206b.displayEggs(eggsInfo, bitmap);
                }
            }

            public void onFailed() {
                IMLog.m6632e(IMEggsLayout.f10205a, "[displayEggs] #loadEggsBitmap# onFailed");
            }
        });
    }
}

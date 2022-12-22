package com.didichuxing.diface.appeal.toolkit;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import com.didichuxing.dfbasesdk.utils.LogUtils;
import com.didichuxing.diface.utils.DisplayUtils;

public class ResizeTakePhoto {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final View f47084a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public final View f47085b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final View f47086c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f47087d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f47088e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public final int f47089f;

    public ResizeTakePhoto(Context context, View view, View view2, View view3) {
        this.f47084a = view;
        this.f47085b = view2;
        this.f47086c = view3;
        this.f47087d = DisplayUtils.dip2px(context, 245.0f);
        this.f47088e = DisplayUtils.getScreenWidth(context);
        this.f47089f = DisplayUtils.getScreenHeight(context);
    }

    public void resize(final int i, final int i2) {
        this.f47084a.post(new Runnable() {
            public void run() {
                int i;
                int width = ResizeTakePhoto.this.f47084a.getWidth();
                int i2 = (int) (((((float) width) * 1.0f) * ((float) i)) / ((float) i2));
                ResizeTakePhoto resizeTakePhoto = ResizeTakePhoto.this;
                resizeTakePhoto.m33743a(resizeTakePhoto.f47084a, width, i2);
                int b = ResizeTakePhoto.this.f47089f - i2;
                if (b < ResizeTakePhoto.this.f47087d) {
                    b = ResizeTakePhoto.this.f47087d;
                }
                ResizeTakePhoto resizeTakePhoto2 = ResizeTakePhoto.this;
                resizeTakePhoto2.m33743a(resizeTakePhoto2.f47085b, width, b);
                int height = ResizeTakePhoto.this.f47086c.getHeight();
                int b2 = ResizeTakePhoto.this.f47089f - b;
                if (height >= b2) {
                    height = b2;
                    i = 0;
                } else {
                    i = (b2 - height) / 2;
                }
                ResizeTakePhoto resizeTakePhoto3 = ResizeTakePhoto.this;
                resizeTakePhoto3.m33744a(resizeTakePhoto3.f47086c, width, height, i);
                LogUtils.m33563d("run: screen w * h " + ResizeTakePhoto.this.f47088e + " * " + ResizeTakePhoto.this.f47089f);
                LogUtils.m33563d("run: preview w * h " + i + " * " + i2);
                LogUtils.m33563d("run: flTop w * h " + width + " * " + i2);
                LogUtils.m33563d("run: flBottom w * h " + width + " * " + b);
                LogUtils.m33563d("run: vImg w * h " + height + " * " + width + "  marginTop  : " + i);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33743a(View view, int i, int i2) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = i;
        layoutParams.height = i2;
        view.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m33744a(View view, int i, int i2, int i3) {
        ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) view.getLayoutParams();
        marginLayoutParams.width = i;
        marginLayoutParams.height = i2;
        marginLayoutParams.topMargin = i3;
        view.setLayoutParams(marginLayoutParams);
    }
}

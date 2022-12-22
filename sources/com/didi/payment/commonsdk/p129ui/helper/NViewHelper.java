package com.didi.payment.commonsdk.p129ui.helper;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.view.View;
import com.didi.unifiedPay.util.UIUtils;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\u0018\u0000 \u00032\u00020\u0001:\u0001\u0003B\u0005¢\u0006\u0002\u0010\u0002¨\u0006\u0004"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/helper/NViewHelper;", "", "()V", "Companion", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.commonsdk.ui.helper.NViewHelper */
/* compiled from: NViewHelper.kt */
public final class NViewHelper {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    /* access modifiers changed from: private */

    /* renamed from: a */
    public static int f30196a = 3145728;

    @Metadata(mo175977d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J \u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u0010J(\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0004R\u001a\u0010\u0003\u001a\u00020\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/ui/helper/NViewHelper$Companion;", "", "()V", "IMAGE_LIMIT_3M", "", "getIMAGE_LIMIT_3M", "()I", "setIMAGE_LIMIT_3M", "(I)V", "genBitmap", "Landroid/graphics/Bitmap;", "context", "Landroid/content/Context;", "mRootView", "Landroid/view/View;", "needInflate", "", "limitSize", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.commonsdk.ui.helper.NViewHelper$Companion */
    /* compiled from: NViewHelper.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final int getIMAGE_LIMIT_3M() {
            return NViewHelper.f30196a;
        }

        public final void setIMAGE_LIMIT_3M(int i) {
            NViewHelper.f30196a = i;
        }

        public final Bitmap genBitmap(Context context, View view, boolean z) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "mRootView");
            return genBitmap(context, view, z, getIMAGE_LIMIT_3M());
        }

        public final Bitmap genBitmap(Context context, View view, boolean z, int i) {
            Intrinsics.checkNotNullParameter(context, "context");
            Intrinsics.checkNotNullParameter(view, "mRootView");
            int screenWidth = UIUtils.getScreenWidth(context);
            if (z) {
                view.measure(View.MeasureSpec.makeMeasureSpec(screenWidth, 1073741824), View.MeasureSpec.makeMeasureSpec(0, 0));
                view.layout(0, 0, view.getMeasuredWidth(), view.getMeasuredHeight());
            }
            Bitmap bitmap = null;
            try {
                if (view.getWidth() * view.getHeight() * 4 < i) {
                    bitmap = Bitmap.createBitmap(view.getWidth(), view.getHeight(), Bitmap.Config.ARGB_8888);
                }
            } catch (Throwable unused) {
            }
            if (bitmap == null) {
                float f = 0.8f;
                while (((float) view.getWidth()) * f * ((float) view.getHeight()) * f * ((float) 2) > ((float) i)) {
                    try {
                        f /= 2.0f;
                    } catch (Throwable unused2) {
                    }
                }
                bitmap = Bitmap.createBitmap((int) (((float) view.getWidth()) * f), (int) (((float) view.getHeight()) * f), Bitmap.Config.RGB_565);
                if (bitmap != null) {
                    Canvas canvas = new Canvas(bitmap);
                    Matrix matrix = new Matrix();
                    matrix.postScale(f, f);
                    canvas.setMatrix(matrix);
                    view.draw(canvas);
                }
            } else {
                view.draw(new Canvas(bitmap));
            }
            return bitmap;
        }
    }
}

package com.didi.soda.customer.blocks.widget.binder;

import android.content.Context;
import android.util.AttributeSet;
import com.didi.soda.blocks.sdk.BlocksEngine;
import com.didi.soda.blocks.utils.DPUtil;
import com.didi.soda.blocks.widget.TextBinder;
import com.didi.soda.blocks.widget.WidgetNameMeta;
import com.didi.soda.business.widget.TailIconTextView;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@WidgetNameMeta(widgetName = "ImageTailText")
@Metadata(mo175977d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u001e\u0010\u0005\u001a\u00020\u00062\u0014\u0010\u0007\u001a\u0010\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\n\u0018\u00010\bH\u0016J\u0010\u0010\u000b\u001a\u00020\f2\u0006\u0010\u0002\u001a\u00020\u0003H\u0016J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\tH\u0002J\u001a\u0010\u0010\u001a\u00020\u00062\b\u0010\u0011\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0012\u001a\u00020\tH\u0002J\u0011\u0010\u0013\u001a\u00020\u0014*\u00020\nH\u0000¢\u0006\u0002\b\u0015¨\u0006\u0016"}, mo175978d2 = {"Lcom/didi/soda/customer/blocks/widget/binder/TailIconTextBinder;", "Lcom/didi/soda/blocks/widget/TextBinder;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "bindProps", "", "props", "Ljava/util/HashMap;", "", "", "createView", "Lcom/didi/soda/business/widget/TailIconTextView;", "isRemoteImage", "", "imageSrc", "setImage", "src", "text", "convert2Num", "", "convert2Num$customer_aar_brazilEmbedRelease", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: TailIconTextBinder.kt */
public final class TailIconTextBinder extends TextBinder {
    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public TailIconTextBinder(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public TailIconTextView createView(Context context) {
        Intrinsics.checkNotNullParameter(context, "context");
        return new TailIconTextView(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
    }

    /* JADX WARNING: type inference failed for: r2v1, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public void bindProps(java.util.HashMap<java.lang.String, java.lang.Object> r5) {
        /*
            r4 = this;
            super.bindProps(r5)
            r0 = 0
            if (r5 != 0) goto L_0x0008
        L_0x0006:
            r1 = r0
            goto L_0x0016
        L_0x0008:
            java.lang.String r1 = "src"
            java.lang.Object r1 = r5.get(r1)
            if (r1 != 0) goto L_0x0012
            goto L_0x0006
        L_0x0012:
            java.lang.String r1 = r1.toString()
        L_0x0016:
            if (r5 != 0) goto L_0x001a
        L_0x0018:
            r2 = r0
            goto L_0x0028
        L_0x001a:
            java.lang.String r2 = "text"
            java.lang.Object r2 = r5.get(r2)
            if (r2 != 0) goto L_0x0024
            goto L_0x0018
        L_0x0024:
            java.lang.String r2 = r2.toString()
        L_0x0028:
            if (r2 != 0) goto L_0x002b
            return
        L_0x002b:
            r4.m28942a(r1, r2)
            if (r5 != 0) goto L_0x0031
            goto L_0x0050
        L_0x0031:
            java.lang.String r1 = "fontSize"
            java.lang.Object r1 = r5.get(r1)
            if (r1 != 0) goto L_0x003a
            goto L_0x0050
        L_0x003a:
            int r1 = r4.convert2Num$customer_aar_brazilEmbedRelease(r1)
            android.view.View r2 = r4.getView()
            boolean r3 = r2 instanceof com.didi.soda.business.widget.TailIconTextView
            if (r3 == 0) goto L_0x0049
            com.didi.soda.business.widget.TailIconTextView r2 = (com.didi.soda.business.widget.TailIconTextView) r2
            goto L_0x004a
        L_0x0049:
            r2 = r0
        L_0x004a:
            if (r2 != 0) goto L_0x004d
            goto L_0x0050
        L_0x004d:
            r2.setIconSize(r1)
        L_0x0050:
            if (r5 != 0) goto L_0x0053
            goto L_0x0072
        L_0x0053:
            java.lang.String r1 = "imageWidth"
            java.lang.Object r1 = r5.get(r1)
            if (r1 != 0) goto L_0x005c
            goto L_0x0072
        L_0x005c:
            int r1 = r4.convert2Num$customer_aar_brazilEmbedRelease(r1)
            android.view.View r2 = r4.getView()
            boolean r3 = r2 instanceof com.didi.soda.business.widget.TailIconTextView
            if (r3 == 0) goto L_0x006b
            com.didi.soda.business.widget.TailIconTextView r2 = (com.didi.soda.business.widget.TailIconTextView) r2
            goto L_0x006c
        L_0x006b:
            r2 = r0
        L_0x006c:
            if (r2 != 0) goto L_0x006f
            goto L_0x0072
        L_0x006f:
            r2.setImageWidth(r1)
        L_0x0072:
            if (r5 != 0) goto L_0x0075
            goto L_0x0093
        L_0x0075:
            java.lang.String r1 = "imageHeight"
            java.lang.Object r1 = r5.get(r1)
            if (r1 != 0) goto L_0x007e
            goto L_0x0093
        L_0x007e:
            int r1 = r4.convert2Num$customer_aar_brazilEmbedRelease(r1)
            android.view.View r2 = r4.getView()
            boolean r3 = r2 instanceof com.didi.soda.business.widget.TailIconTextView
            if (r3 == 0) goto L_0x008d
            r0 = r2
            com.didi.soda.business.widget.TailIconTextView r0 = (com.didi.soda.business.widget.TailIconTextView) r0
        L_0x008d:
            if (r0 != 0) goto L_0x0090
            goto L_0x0093
        L_0x0090:
            r0.setImageHeight(r1)
        L_0x0093:
            if (r5 != 0) goto L_0x0096
            goto L_0x00a3
        L_0x0096:
            java.lang.String r0 = "space"
            java.lang.Object r0 = r5.get(r0)
            if (r0 != 0) goto L_0x00a0
            goto L_0x00a3
        L_0x00a0:
            r0.toString()
        L_0x00a3:
            if (r5 != 0) goto L_0x00a6
            goto L_0x00b2
        L_0x00a6:
            java.lang.String r0 = "imageBaselineOffset"
            java.lang.Object r5 = r5.get(r0)
            if (r5 != 0) goto L_0x00af
            goto L_0x00b2
        L_0x00af:
            r5.toString()
        L_0x00b2:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.binder.TailIconTextBinder.bindProps(java.util.HashMap):void");
    }

    /* JADX WARNING: type inference failed for: r0v7, types: [android.view.View] */
    /* JADX WARNING: Multi-variable type inference failed */
    /* JADX WARNING: Unknown variable types count: 1 */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m28942a(java.lang.String r5, java.lang.String r6) {
        /*
            r4 = this;
            r0 = r5
            java.lang.CharSequence r0 = (java.lang.CharSequence) r0
            boolean r0 = android.text.TextUtils.isEmpty(r0)
            if (r0 != 0) goto L_0x0082
            android.graphics.drawable.ColorDrawable r0 = new android.graphics.drawable.ColorDrawable
            android.content.Context r1 = r4.getContext()
            android.content.res.Resources r1 = r1.getResources()
            r2 = 2131101845(0x7f060895, float:1.7816111E38)
            int r1 = r1.getColor(r2)
            r0.<init>(r1)
            android.view.View r1 = r4.getView()
            boolean r2 = r1 instanceof com.didi.soda.business.widget.TailIconTextView
            r3 = 0
            if (r2 == 0) goto L_0x0029
            com.didi.soda.business.widget.TailIconTextView r1 = (com.didi.soda.business.widget.TailIconTextView) r1
            goto L_0x002a
        L_0x0029:
            r1 = r3
        L_0x002a:
            if (r1 != 0) goto L_0x002d
            goto L_0x0032
        L_0x002d:
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r1.setTextTail(r6, r0)
        L_0x0032:
            boolean r0 = r4.m28943a(r5)
            if (r0 == 0) goto L_0x004d
            android.content.Context r0 = r4.getContext()
            com.didi.app.nova.skeleton.image.FitType r1 = com.didi.app.nova.skeleton.image.FitType.FIT_None
            com.didi.soda.customer.foundation.util.FlyImageLoader$ImageRequestWrapper r5 = com.didi.soda.customer.foundation.util.FlyImageLoader.loadImageDownLoadOnly((android.content.Context) r0, (com.didi.app.nova.skeleton.image.FitType) r1, (java.lang.String) r5)
            com.didi.soda.customer.blocks.widget.binder.TailIconTextBinder$setImage$1 r0 = new com.didi.soda.customer.blocks.widget.binder.TailIconTextBinder$setImage$1
            r0.<init>(r4, r6)
            com.didi.app.nova.skeleton.image.ImageDownloadListener r0 = (com.didi.app.nova.skeleton.image.ImageDownloadListener) r0
            r5.downloadOnly(r0)
            goto L_0x008d
        L_0x004d:
            java.lang.String r0 = "drawable"
            int r0 = com.didi.soda.blocks.utils.ResUtils.getResourceId(r5, r0, r3)
            android.content.Context r1 = r4.getContext()     // Catch:{ Exception -> 0x0060 }
            android.content.res.Resources r1 = r1.getResources()     // Catch:{ Exception -> 0x0060 }
            android.graphics.drawable.Drawable r5 = r1.getDrawable(r0)     // Catch:{ Exception -> 0x0060 }
            goto L_0x006e
        L_0x0060:
            java.lang.String r0 = "local image not found which src is "
            java.lang.String r5 = kotlin.jvm.internal.Intrinsics.stringPlus(r0, r5)
            java.lang.String r0 = "ImageTailText"
            com.didi.soda.customer.foundation.log.util.LogUtil.m29102e((java.lang.String) r0, (java.lang.String) r5)
            r5 = r3
            android.graphics.drawable.Drawable r5 = (android.graphics.drawable.Drawable) r5
        L_0x006e:
            if (r5 == 0) goto L_0x008d
            android.view.View r0 = r4.getView()
            boolean r1 = r0 instanceof com.didi.soda.business.widget.TailIconTextView
            if (r1 == 0) goto L_0x007b
            r3 = r0
            com.didi.soda.business.widget.TailIconTextView r3 = (com.didi.soda.business.widget.TailIconTextView) r3
        L_0x007b:
            if (r3 != 0) goto L_0x007e
            goto L_0x008d
        L_0x007e:
            r3.setTextTail(r6, r5)
            goto L_0x008d
        L_0x0082:
            android.view.View r5 = r4.getView()
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r5.setText(r6)
        L_0x008d:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.blocks.widget.binder.TailIconTextBinder.m28942a(java.lang.String, java.lang.String):void");
    }

    /* renamed from: a */
    private final boolean m28943a(String str) {
        if (str == null) {
            return false;
        }
        if (!StringsKt.startsWith$default(str, "//", false, 2, (Object) null)) {
            String lowerCase = str.toLowerCase();
            Intrinsics.checkNotNullExpressionValue(lowerCase, "(this as java.lang.String).toLowerCase()");
            return StringsKt.startsWith$default(lowerCase, "http", false, 2, (Object) null);
        }
    }

    public final int convert2Num$customer_aar_brazilEmbedRelease(Object obj) {
        float f;
        Intrinsics.checkNotNullParameter(obj, "<this>");
        String obj2 = obj.toString();
        if (StringsKt.endsWith$default(obj2, "px", false, 2, (Object) null)) {
            int length = obj2.length() - 2;
            if (obj2 != null) {
                String substring = obj2.substring(0, length);
                Intrinsics.checkNotNullExpressionValue(substring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                f = DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(substring) / 2.0f);
            } else {
                throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
            }
        } else {
            f = DPUtil.INSTANCE.dp2pxF(BlocksEngine.Companion.getInstance$default(BlocksEngine.Companion, (String) null, 1, (Object) null).getContext(), Float.parseFloat(obj2));
        }
        return (int) f;
    }
}

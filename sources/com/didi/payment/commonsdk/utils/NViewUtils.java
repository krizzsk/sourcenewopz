package com.didi.payment.commonsdk.utils;

import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.utils.TextHighlightUtil;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\bÆ\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u001e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u0016\u0010\n\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\t\u001a\u00020\bJ\u001e\u0010\u000b\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u00062\u0006\u0010\f\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\bJ\u001a\u0010\r\u001a\u00020\u00042\b\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011J\u001a\u0010\u0012\u001a\u00020\u00042\b\u0010\u0013\u001a\u0004\u0018\u00010\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0011J\u0018\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u0011J \u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\bJ(\u0010\u0016\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u0017\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\b¨\u0006\u001a"}, mo175978d2 = {"Lcom/didi/payment/commonsdk/utils/NViewUtils;", "", "()V", "incrementWidthHeight", "", "view", "Landroid/view/View;", "incrementWidth", "", "newHeight", "resetHeight", "resetWidthHeight", "newWidth", "setImage", "imageView", "Landroid/widget/ImageView;", "url", "", "setText", "textView", "Landroid/widget/TextView;", "content", "setText2HighLight", "txt", "defaultColor", "highLightColor", "wallet-service-commonsdk_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: NViewUtils.kt */
public final class NViewUtils {
    public static final NViewUtils INSTANCE = new NViewUtils();

    private NViewUtils() {
    }

    public final void setText(TextView textView, String str) {
        if (textView != null) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                textView.setVisibility(8);
                return;
            }
            textView.setVisibility(0);
            textView.setText(charSequence);
        }
    }

    public final void setImage(ImageView imageView, String str) {
        if (imageView != null) {
            CharSequence charSequence = str;
            if (charSequence == null || charSequence.length() == 0) {
                imageView.setVisibility(8);
                return;
            }
            imageView.setVisibility(0);
            GlideUtils.with2load2into(imageView.getContext(), str, imageView);
        }
    }

    public final void setText2HighLight(TextView textView, String str) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(TextHighlightUtil.highlight(str, Color.parseColor("#000000"), Color.parseColor("#FF8040")));
    }

    public final void setText2HighLight(TextView textView, String str, int i) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(TextHighlightUtil.highlight(str, i, Color.parseColor("#FF8040")));
    }

    public final void setText2HighLight(TextView textView, String str, int i, int i2) {
        Intrinsics.checkNotNullParameter(textView, "textView");
        CharSequence charSequence = str;
        if (charSequence == null || charSequence.length() == 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(TextHighlightUtil.highlight(str, i, i2));
    }

    public final void resetWidthHeight(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.width = i;
            layoutParams.height = i2;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void incrementWidthHeight(View view, int i, int i2) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            int i3 = 0;
            layoutParams.width = layoutParams.width + i > 0 ? layoutParams.width + i : 0;
            if (layoutParams.height + i2 > 0) {
                i3 = layoutParams.height + i2;
            }
            layoutParams.height = i3;
            view.setLayoutParams(layoutParams);
        }
    }

    public final void resetHeight(View view, int i) {
        Intrinsics.checkNotNullParameter(view, "view");
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        if (layoutParams != null) {
            layoutParams.height = i + layoutParams.height;
            view.setLayoutParams(layoutParams);
        }
    }
}

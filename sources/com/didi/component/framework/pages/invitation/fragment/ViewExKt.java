package com.didi.component.framework.pages.invitation.fragment;

import android.graphics.Color;
import android.text.TextUtils;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import kotlin.Metadata;

@Metadata(mo175977d1 = {"\u0000\u001a\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u0016\u0010\u0000\u001a\u00020\u0001*\u0004\u0018\u00010\u00022\b\u0010\u0003\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0005\u001a\u00020\u0001*\u0004\u0018\u00010\u00062\b\u0010\u0005\u001a\u0004\u0018\u00010\u0004\u001a\u0016\u0010\u0007\u001a\u00020\u0001*\u0004\u0018\u00010\u00062\b\u0010\b\u001a\u0004\u0018\u00010\u0004¨\u0006\t"}, mo175978d2 = {"loadImage", "", "Landroid/widget/ImageView;", "url", "", "text", "Landroid/widget/TextView;", "textColor", "color", "framework_release"}, mo175979k = 2, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ViewEx.kt */
public final class ViewExKt {
    public static final void loadImage(ImageView imageView, String str) {
        if (imageView != null && !TextUtils.isEmpty(str)) {
            Glide.with(imageView.getContext()).load(str).into(imageView);
        }
    }

    public static final void textColor(TextView textView, String str) {
        if (textView != null && !TextUtils.isEmpty(str)) {
            try {
                textView.setTextColor(Color.parseColor(str));
            } catch (Exception unused) {
            }
        }
    }

    public static final void text(TextView textView, String str) {
        if (textView != null) {
            CharSequence charSequence = str;
            if (!TextUtils.isEmpty(charSequence)) {
                textView.setText(charSequence);
            }
        }
    }
}

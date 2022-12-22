package com.didi.addressnew.view.enhance;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextPaint;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.didi.addressnew.util.ViewUtils;
import com.didi.common.map.util.DisplayUtils;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfoTag;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002J\"\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\u0006\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\nJ\"\u0010\u000b\u001a\u00020\f2\b\u0010\r\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\u0010\u001a\u00020\u0011H\u0004J(\u0010\u0012\u001a\u00020\u00042\u0006\u0010\u0013\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u000e2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u0010\u001a\u00020\u0011H\u0002¨\u0006\u0014"}, mo175978d2 = {"Lcom/didi/addressnew/view/enhance/DiscountAddressItemEnhancer;", "", "()V", "enhance", "", "view", "Landroid/view/View;", "position", "", "rpcPoi", "Lcom/sdk/poibase/model/RpcPoi;", "isInvadeOutside", "", "tag", "Landroid/widget/TextView;", "mainAddress", "displayMetrics", "Landroid/util/DisplayMetrics;", "subTagProcess", "sugTag", "global_sug_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: DiscountAddressItemEnhancer.kt */
public final class DiscountAddressItemEnhancer {
    public final void enhance(View view, int i, RpcPoi rpcPoi) {
        if (view != null && i >= 0 && rpcPoi != null && rpcPoi.base_info != null) {
            TextView textView = (TextView) view.findViewById(R.id.sub_item_tag);
            TextView textView2 = (TextView) view.findViewById(R.id.sub_item_content);
            DisplayMetrics displayMetrics = ViewUtils.getDisplayMetrics(view);
            Intrinsics.checkNotNullExpressionValue(textView, "subItemTag");
            Intrinsics.checkNotNullExpressionValue(textView2, "subItemContent");
            Intrinsics.checkNotNullExpressionValue(displayMetrics, "displayMetrics");
            m4810a(textView, textView2, rpcPoi, displayMetrics);
        }
    }

    /* renamed from: a */
    private final void m4810a(TextView textView, TextView textView2, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
        if (rpcPoi.base_info.poi_tag == null || rpcPoi.base_info.poi_tag.size() <= 0) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        RpcPoiBaseInfoTag rpcPoiBaseInfoTag = rpcPoi.base_info.poi_tag.get(0);
        textView.setText(rpcPoiBaseInfoTag.name);
        if (!isInvadeOutside(textView, textView2, displayMetrics)) {
            if (!TextUtils.isEmpty(rpcPoiBaseInfoTag.content_color)) {
                textView.setTextColor(Color.parseColor(rpcPoiBaseInfoTag.content_color));
            }
            Drawable background = textView.getBackground();
            if (!TextUtils.isEmpty(rpcPoiBaseInfoTag.background_color) && (background instanceof GradientDrawable)) {
                ((GradientDrawable) background).setColor(Color.parseColor(rpcPoiBaseInfoTag.background_color));
                textView.setBackgroundDrawable(background);
            }
        }
    }

    /* access modifiers changed from: protected */
    public final boolean isInvadeOutside(TextView textView, TextView textView2, DisplayMetrics displayMetrics) {
        Intrinsics.checkNotNullParameter(textView2, "mainAddress");
        Intrinsics.checkNotNullParameter(displayMetrics, "displayMetrics");
        int i = displayMetrics.widthPixels;
        Rect rect = new Rect();
        TextPaint paint = textView2.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint, "mainAddress.paint");
        paint.getTextBounds(textView2.getText().toString(), 0, textView2.getText().length(), rect);
        int width = rect.width();
        Intrinsics.checkNotNull(textView);
        TextPaint paint2 = textView.getPaint();
        Intrinsics.checkNotNullExpressionValue(paint2, "!!.paint");
        paint2.getTextBounds(textView.getText().toString(), 0, textView.getText().length(), rect);
        if (rect.width() + width > ((i * 3) / 4) - (textView.getContext() != null ? DisplayUtils.dp2px(textView.getContext(), 20.0f) : 20)) {
            textView.setVisibility(8);
            return true;
        }
        textView.setVisibility(0);
        return false;
    }
}

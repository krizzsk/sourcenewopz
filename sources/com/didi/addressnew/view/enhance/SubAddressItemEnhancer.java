package com.didi.addressnew.view.enhance;

import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.didi.addressnew.util.ViewUtils;
import com.didi.common.map.util.DisplayUtils;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfoTag;
import com.taxis99.R;

public class SubAddressItemEnhancer implements IAddressItemEnhancer {
    public void enhance(View view, int i, RpcPoi rpcPoi) {
        if (view != null && i >= 0 && rpcPoi != null && rpcPoi.base_info != null) {
            m4811a((TextView) view.findViewById(R.id.sub_item_tag), (TextView) view.findViewById(R.id.sub_item_content), rpcPoi, ViewUtils.getDisplayMetrics(view));
        }
    }

    /* renamed from: a */
    private void m4811a(TextView textView, TextView textView2, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
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
                GradientDrawable gradientDrawable = (GradientDrawable) background;
                gradientDrawable.setColor(Color.parseColor(rpcPoiBaseInfoTag.background_color));
                textView.setBackgroundDrawable(gradientDrawable);
            }
        }
    }

    /* access modifiers changed from: protected */
    public boolean isInvadeOutside(TextView textView, TextView textView2, DisplayMetrics displayMetrics) {
        int i = displayMetrics.widthPixels;
        Rect rect = new Rect();
        textView2.getPaint().getTextBounds(textView2.getText().toString(), 0, textView2.getText().length(), rect);
        int width = rect.width();
        textView.getPaint().getTextBounds(textView.getText().toString(), 0, textView.getText().length(), rect);
        if (rect.width() + width > ((i * 3) / 4) - ((textView == null || textView.getContext() == null) ? 20 : DisplayUtils.dp2px(textView.getContext(), 20.0f))) {
            textView.setVisibility(8);
            return true;
        }
        textView.setVisibility(0);
        return false;
    }
}

package com.didi.addressold.view.enhance;

import android.app.Activity;
import android.graphics.Color;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.TextView;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.RpcPoiBaseInfoTag;
import com.taxis99.R;

public class SugRecItemEnhancer implements IAddressItemEnhancer {

    /* renamed from: a */
    private boolean f7970a;

    /* renamed from: b */
    private boolean f7971b;

    public void enhance(View view, int i, RpcPoi rpcPoi) {
        if (view != null && i >= 0 && rpcPoi != null && rpcPoi.base_info != null) {
            TextView textView = (TextView) view.findViewById(R.id.rec_tag);
            TextView textView2 = (TextView) view.findViewById(R.id.cf_tag);
            TextView textView3 = (TextView) view.findViewById(R.id.sug_name);
            DisplayMetrics displayMetrics = new DisplayMetrics();
            ((Activity) view.getContext()).getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
            if (this.f7971b) {
                m5157a(textView2, textView3, rpcPoi, displayMetrics);
            }
            if (this.f7970a) {
                m5156a(textView, textView3, i, rpcPoi, displayMetrics);
            }
        }
    }

    /* renamed from: a */
    private void m5157a(TextView textView, TextView textView2, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
        if (rpcPoi.base_info.poi_tag == null || rpcPoi.base_info.poi_tag.size() <= 0) {
            textView.setVisibility(8);
            return;
        }
        RpcPoiBaseInfoTag rpcPoiBaseInfoTag = rpcPoi.base_info.poi_tag.get(0);
        if (rpcPoiBaseInfoTag != null && !TextUtils.isEmpty(rpcPoiBaseInfoTag.name)) {
            textView.setVisibility(0);
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
    }

    /* renamed from: a */
    private void m5156a(TextView textView, TextView textView2, int i, RpcPoi rpcPoi, DisplayMetrics displayMetrics) {
        if (i > 1) {
            textView.setVisibility(8);
        } else if (rpcPoi.extend_info == null || TextUtils.isEmpty(rpcPoi.extend_info.rec_tag_tittle)) {
            textView.setVisibility(8);
        } else {
            textView.setText(rpcPoi.extend_info.rec_tag_tittle);
            isInvadeOutside(textView, textView2, displayMetrics);
        }
    }

    /* access modifiers changed from: protected */
    public boolean isInvadeOutside(TextView textView, TextView textView2, DisplayMetrics displayMetrics) {
        int i = displayMetrics.widthPixels;
        Rect rect = new Rect();
        textView2.getPaint().getTextBounds(textView2.getText().toString(), 0, textView2.getText().length(), rect);
        int width = rect.width();
        textView.getPaint().getTextBounds(textView.getText().toString(), 0, textView.getText().length(), rect);
        if (rect.width() + width > (i * 3) / 4) {
            textView.setVisibility(8);
            return true;
        }
        textView.setVisibility(0);
        return false;
    }

    public void setRecSwitch(boolean z) {
        this.f7970a = z;
    }

    public void setSugSwitch(boolean z) {
        this.f7971b = z;
    }
}

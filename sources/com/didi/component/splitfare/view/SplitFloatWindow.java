package com.didi.component.splitfare.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.splitfare.model.NewSplitFareMsg;
import com.taxis99.R;

public class SplitFloatWindow implements View.OnClickListener {

    /* renamed from: a */
    private Context f16002a;

    /* renamed from: b */
    private View f16003b;

    /* renamed from: c */
    private TextView f16004c = ((TextView) this.f16003b.findViewById(R.id.split_float_content_view));

    /* renamed from: d */
    private ImageView f16005d;

    /* renamed from: e */
    private OnClickCallback f16006e;

    /* renamed from: f */
    private NewSplitFareMsg f16007f;

    public interface OnClickCallback {
        void onClick(View view);
    }

    public SplitFloatWindow(Context context, NewSplitFareMsg newSplitFareMsg) {
        this.f16007f = newSplitFareMsg;
        this.f16002a = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.split_float_view, (ViewGroup) null, false);
        this.f16003b = inflate;
        this.f16005d = (ImageView) inflate.findViewById(R.id.split_float_img);
        this.f16003b.setOnClickListener(this);
        m11767a();
    }

    /* renamed from: a */
    private void m11767a() {
        NewSplitFareMsg newSplitFareMsg = this.f16007f;
        if (newSplitFareMsg != null) {
            setContent(newSplitFareMsg.msg);
            setHeader(this.f16007f.iconUrl);
        }
    }

    public void setContent(String str) {
        this.f16004c.setText(str);
    }

    public void setHeader(String str) {
        if (!TextUtils.isEmpty(str)) {
            ((RequestBuilder) Glide.with(this.f16002a).load((Object) new GlideUrl(str)).placeholder((int) R.drawable.split_float_icon)).into(this.f16005d);
        }
    }

    public void setOnClickCallback(OnClickCallback onClickCallback) {
        this.f16006e = onClickCallback;
    }

    public View getView() {
        return this.f16003b;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        OnClickCallback onClickCallback = this.f16006e;
        if (onClickCallback != null) {
            onClickCallback.onClick(this.f16003b);
        }
    }
}

package com.didi.onekeyshare.view;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.taxis99.R;

public class ShareItemView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f29789a;

    /* renamed from: b */
    private TextView f29790b;
    protected OneKeyShareInfo mShareInfo;

    public ShareItemView(Context context) {
        super(context);
        m20903a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20903a();
    }

    public ShareItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20903a();
    }

    /* renamed from: a */
    private void m20903a() {
        inflate(getContext(), R.layout.tone_share_item, this);
        this.f29789a = (ImageView) findViewById(R.id.share_item_icon);
        this.f29790b = (TextView) findViewById(R.id.share_item_name);
    }

    /* access modifiers changed from: protected */
    public void setInfo(int i, String str) {
        this.f29789a.setImageResource(i);
        this.f29790b.setText(str);
    }

    public void setShareInfo(OneKeyShareInfo oneKeyShareInfo) {
        this.mShareInfo = oneKeyShareInfo;
        if (oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            setInfo(oneKeyShareInfo.platform.resId(), getContext().getString(oneKeyShareInfo.platform.productName()));
            setId(oneKeyShareInfo.platform.platformId());
        }
    }

    public SharePlatform getPlatform() {
        OneKeyShareInfo oneKeyShareInfo = this.mShareInfo;
        if (oneKeyShareInfo != null) {
            return oneKeyShareInfo.platform;
        }
        return null;
    }

    public OneKeyShareInfo getShareInfo() {
        return this.mShareInfo;
    }
}

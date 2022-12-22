package com.didi.onekeyshare.view.fragment;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.taxis99.R;

public class ShareFragmentItemView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f29826a;

    /* renamed from: b */
    private TextView f29827b;
    protected OneKeyShareInfo mShareInfo;

    public ShareFragmentItemView(Context context) {
        super(context);
        m20924a();
    }

    public ShareFragmentItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m20924a();
    }

    public ShareFragmentItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m20924a();
    }

    /* renamed from: a */
    private void m20924a() {
        inflate(getContext(), R.layout.fragment_share_item, this);
        this.f29826a = (ImageView) findViewById(R.id.share_item_icon);
        this.f29827b = (TextView) findViewById(R.id.share_item_name);
    }

    /* access modifiers changed from: protected */
    public void setInfo(int i, String str) {
        this.f29826a.setImageResource(i);
        this.f29827b.setText(str);
    }

    public void setShareInfo(OneKeyShareInfo oneKeyShareInfo) {
        this.mShareInfo = oneKeyShareInfo;
        if (oneKeyShareInfo.platform != null && oneKeyShareInfo.platform != SharePlatform.UNKNOWN) {
            setInfo(oneKeyShareInfo.platform.resId(), getContext().getString(oneKeyShareInfo.platform.productName()));
            setId(oneKeyShareInfo.platform.platformId() + oneKeyShareInfo.customName.hashCode());
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

package com.didi.global.globalgenerickit.view;

import android.content.Context;
import android.graphics.Color;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.model.ComponentConfigBannerModel;
import com.didi.global.globalgenerickit.utils.OmegaUtils;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.taxis99.R;

public class ComponentConfigBannerView extends RelativeLayout {

    /* renamed from: a */
    private ImageView f22337a;

    /* renamed from: b */
    private ImageView f22338b;

    /* renamed from: c */
    private TextView f22339c;

    /* renamed from: d */
    private RelativeLayout f22340d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ComponentConfigBannerModel f22341e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View.OnClickListener f22342f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public LEGORichInfo.RichInfoClickListener f22343g;

    /* renamed from: h */
    private TextView f22344h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public LEGORichInfo.RichInfoClickListener f22345i = new LEGORichInfo.RichInfoClickListener() {
        public void onClick(String str) {
            if (ComponentConfigBannerView.this.f22343g != null) {
                ComponentConfigBannerView.this.f22343g.onClick(str);
            }
        }
    };

    public ComponentConfigBannerView(Context context) {
        super(context);
        m16111a(context);
    }

    public ComponentConfigBannerView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m16111a(context);
    }

    public ComponentConfigBannerView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m16111a(context);
    }

    /* renamed from: a */
    private void m16111a(Context context) {
        inflate(context, R.layout.ggk_component_config_banner_view, this);
        this.f22339c = (TextView) findViewById(R.id.content);
        this.f22344h = (TextView) findViewById(R.id.sub_content);
        this.f22338b = (ImageView) findViewById(R.id.close);
        this.f22337a = (ImageView) findViewById(R.id.icon);
        this.f22340d = (RelativeLayout) findViewById(R.id.container);
        this.f22338b.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaUtils.trackComponentConfigBannerCK(ComponentConfigBannerView.this.f22341e, "banner_close");
                if (ComponentConfigBannerView.this.f22342f != null) {
                    ComponentConfigBannerView.this.f22342f.onClick(view);
                }
            }
        });
    }

    public void setData(final ComponentConfigBannerModel componentConfigBannerModel) {
        if (componentConfigBannerModel != null) {
            this.f22341e = componentConfigBannerModel;
            if (componentConfigBannerModel.businessData != null) {
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.iconUrl)) {
                    Glide.with(getContext()).load(componentConfigBannerModel.businessData.iconUrl).into(this.f22337a);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.closeUrl)) {
                    Glide.with(getContext()).load(componentConfigBannerModel.businessData.closeUrl).into(this.f22338b);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.title)) {
                    this.f22339c.setText(componentConfigBannerModel.businessData.title);
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.titleColor)) {
                    try {
                        this.f22339c.setTextColor(Color.parseColor(componentConfigBannerModel.businessData.titleColor));
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
                if (!TextUtils.isEmpty(componentConfigBannerModel.businessData.bgColor)) {
                    try {
                        this.f22340d.setBackgroundColor(Color.parseColor(componentConfigBannerModel.businessData.bgColor));
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                }
                if (componentConfigBannerModel.businessData.titleSize > 0) {
                    this.f22339c.setTextSize((float) componentConfigBannerModel.businessData.titleSize);
                }
                LEGORichInfo lEGORichInfo = componentConfigBannerModel.businessData.titleRich;
                LEGORichInfo lEGORichInfo2 = componentConfigBannerModel.businessData.subTitleRich;
                if (lEGORichInfo != null && !TextUtils.isEmpty(lEGORichInfo.getContent())) {
                    lEGORichInfo.bindTextView(this.f22339c);
                    lEGORichInfo.setOnClickListener(this.f22345i);
                }
                if (lEGORichInfo2 == null || TextUtils.isEmpty(lEGORichInfo2.getContent())) {
                    this.f22344h.setVisibility(8);
                } else {
                    this.f22344h.setVisibility(0);
                    this.f22339c.setMaxLines(1);
                    lEGORichInfo2.bindTextView(this.f22344h);
                    lEGORichInfo2.setOnClickListener(this.f22345i);
                }
                this.f22340d.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ComponentConfigBannerView.this.f22345i != null) {
                            ComponentConfigBannerView.this.f22345i.onClick(componentConfigBannerModel.businessData.link);
                        }
                    }
                });
            }
        }
    }

    public void setCloseClickListener(View.OnClickListener onClickListener) {
        this.f22342f = onClickListener;
    }

    public void setOnLinkClickListener(LEGORichInfo.RichInfoClickListener richInfoClickListener) {
        this.f22343g = richInfoClickListener;
    }
}

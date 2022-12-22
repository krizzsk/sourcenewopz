package com.didiglobal.eevee.mew.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.eevee.mew.widget.VpTemplateModel;
import com.didiglobal.mew.framework.MUIUtils;
import com.taxis99.R;

public class VpTemplateFrameLayout extends FrameLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f50079a;

    /* renamed from: b */
    private ImageView f50080b;

    /* renamed from: c */
    private TextView f50081c;

    /* renamed from: d */
    private View f50082d;

    /* renamed from: e */
    private TextView f50083e;

    /* renamed from: f */
    private ImageView f50084f;

    /* renamed from: g */
    private LinearLayout f50085g;

    public VpTemplateFrameLayout(Context context) {
        super(context);
        this.f50079a = context;
        m36088a();
    }

    public VpTemplateFrameLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f50079a = context;
        m36088a();
    }

    public VpTemplateFrameLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f50079a = context;
        m36088a();
    }

    /* renamed from: a */
    private void m36088a() {
        setLayoutParams(new FrameLayout.LayoutParams(-1, MUIUtils.getStatusBarHeight(getContext()) + MUIUtils.dip2pxInt(getContext(), 390.0f)));
        setPadding(0, MUIUtils.getStatusBarHeight(getContext()), 0, 0);
        LayoutInflater.from(getContext()).inflate(R.layout.vp_template_item_layout, this);
        this.f50080b = (ImageView) findViewById(R.id.vp_template_bg);
        this.f50081c = (TextView) findViewById(R.id.vp_template_title);
        this.f50082d = findViewById(R.id.vp_template_btn_layout);
        this.f50083e = (TextView) findViewById(R.id.vp_template_btn);
        this.f50084f = (ImageView) findViewById(R.id.vp_template_btn_arrow);
        this.f50085g = (LinearLayout) findViewById(R.id.vp_layout_title);
    }

    public void bindData(VpTemplateModel vpTemplateModel) {
        if (vpTemplateModel != null && vpTemplateModel.normal != null && vpTemplateModel.normal.data != null) {
            final VpTemplateModel.VpNormalData vpNormalData = vpTemplateModel.normal.data;
            if (!TextUtils.isEmpty(vpNormalData.background)) {
                Glide.with((View) this).load(vpNormalData.background).into(this.f50080b);
            }
            if (vpNormalData.title != null) {
                EeveeRichTextUtil.setText(this.f50081c, vpNormalData.title);
            }
            if (vpNormalData.buttonTitle != null) {
                this.f50082d.setVisibility(0);
                if (vpNormalData.buttonTitle.title != null) {
                    this.f50083e.setVisibility(0);
                    EeveeRichTextUtil.setText(this.f50083e, vpNormalData.buttonTitle.title);
                } else {
                    this.f50083e.setVisibility(8);
                }
                if (!TextUtils.isEmpty(vpNormalData.buttonTitle.url)) {
                    this.f50084f.setVisibility(0);
                    this.f50082d.setOnClickListener(new View.OnClickListener() {
                        public void onClick(View view) {
                            AutoTrackHelper.trackViewOnClick(view);
                            if (VpTemplateFrameLayout.this.f50079a != null) {
                                DRouter.build(vpNormalData.buttonTitle.url).start(VpTemplateFrameLayout.this.f50079a);
                            }
                        }
                    });
                    if (!TextUtils.isEmpty(vpNormalData.buttonArrow)) {
                        Glide.with((View) this).load(vpNormalData.buttonArrow).into(this.f50084f);
                        return;
                    }
                    return;
                }
                this.f50084f.setVisibility(8);
                return;
            }
            this.f50082d.setVisibility(8);
        }
    }
}

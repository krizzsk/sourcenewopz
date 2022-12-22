package com.didi.component.comp_new_xpanel.template;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.xpanelnew.OmegaXPTrack;
import com.didi.component.common.util.UIUtils;
import com.didi.component.comp_new_xpanel.template.XpTemplateBizModel;
import com.didi.drouter.api.DRouter;
import com.didiglobal.enginecore.template.temp.IXEView;
import com.taxis99.R;

public class XpTemplateBizView implements IXEView<XpTemplateBizModel> {

    /* renamed from: a */
    private View f12309a;

    /* renamed from: b */
    private View f12310b;

    /* renamed from: c */
    private TextView f12311c;

    /* renamed from: d */
    private TextView f12312d;

    /* renamed from: e */
    private View f12313e;

    /* renamed from: f */
    private TextView f12314f;

    /* renamed from: g */
    private TextView f12315g;

    /* renamed from: h */
    private View f12316h;

    /* renamed from: i */
    private TextView f12317i;

    /* renamed from: j */
    private TextView f12318j;

    /* renamed from: k */
    private ImageView f12319k;

    /* renamed from: l */
    private Context f12320l;

    public void initView(Context context) {
        this.f12320l = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.g_xp_template_biz, (ViewGroup) null);
        this.f12309a = inflate;
        this.f12310b = inflate.findViewById(R.id.xp_template_biz_layout_left_img);
        this.f12311c = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_title);
        this.f12312d = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_subtitle);
        this.f12313e = this.f12309a.findViewById(R.id.xp_template_biz_btn_horizontal);
        this.f12314f = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_btn_left);
        this.f12315g = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_btn_right);
        this.f12316h = this.f12309a.findViewById(R.id.xp_template_biz_btn_vertical);
        this.f12317i = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_btn_up);
        this.f12318j = (TextView) this.f12309a.findViewById(R.id.xp_template_biz_btn_bottom);
        this.f12319k = (ImageView) this.f12309a.findViewById(R.id.xp_template_biz_image);
    }

    public void bindData(final XpTemplateBizModel xpTemplateBizModel) {
        if (xpTemplateBizModel == null || xpTemplateBizModel.normal == null || xpTemplateBizModel.normal.data == null) {
            this.f12309a.setVisibility(8);
            return;
        }
        this.f12309a.setVisibility(0);
        final XpTemplateBizModel.BizTemplateData bizTemplateData = xpTemplateBizModel.normal.data;
        if (bizTemplateData.title != null) {
            this.f12311c.setVisibility(0);
            bizTemplateData.title.bindTextView(this.f12311c);
        } else {
            this.f12311c.setVisibility(8);
        }
        if (bizTemplateData.subtitle != null) {
            this.f12312d.setVisibility(0);
            bizTemplateData.subtitle.bindTextView(this.f12312d);
        } else {
            this.f12312d.setVisibility(8);
        }
        if (bizTemplateData.buttons != null) {
            if (bizTemplateData.buttons.style == 0 && bizTemplateData.buttons.buttonList != null && bizTemplateData.buttons.buttonList.size() > 0) {
                this.f12313e.setVisibility(0);
                this.f12316h.setVisibility(8);
                if (bizTemplateData.buttons.buttonList.size() == 1) {
                    this.f12314f.setVisibility(0);
                    if (this.f12314f.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                        ((LinearLayout.LayoutParams) this.f12314f.getLayoutParams()).weight = 0.0f;
                    }
                    this.f12315g.setVisibility(8);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f12314f.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f12314f, 15);
                    }
                } else if (bizTemplateData.buttons.buttonList.size() == 2) {
                    this.f12314f.setVisibility(0);
                    this.f12315g.setVisibility(0);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f12314f.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f12314f, 15);
                    }
                    if (bizTemplateData.buttons.buttonList.get(1) == null || bizTemplateData.buttons.buttonList.get(1).title == null) {
                        this.f12315g.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(1).bindTextView(xpTemplateBizModel, this.f12315g, 15);
                    }
                }
            } else if (bizTemplateData.buttons.style == 1 && bizTemplateData.buttons.buttonList != null && bizTemplateData.buttons.buttonList.size() > 0) {
                this.f12313e.setVisibility(8);
                this.f12316h.setVisibility(0);
                if (bizTemplateData.buttons.buttonList.size() == 1) {
                    this.f12317i.setVisibility(0);
                    this.f12318j.setVisibility(8);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f12317i.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f12317i, 15);
                    }
                } else if (bizTemplateData.buttons.buttonList.size() == 2) {
                    this.f12317i.setVisibility(0);
                    this.f12318j.setVisibility(0);
                    if (bizTemplateData.buttons.buttonList.get(0) == null || bizTemplateData.buttons.buttonList.get(0).title == null) {
                        this.f12317i.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(0).bindTextView(xpTemplateBizModel, this.f12317i, 15);
                    }
                    if (bizTemplateData.buttons.buttonList.get(1) == null || bizTemplateData.buttons.buttonList.get(1).title == null) {
                        this.f12318j.setVisibility(8);
                    } else {
                        bizTemplateData.buttons.buttonList.get(1).bindTextView(xpTemplateBizModel, this.f12318j, 15);
                    }
                }
            }
        }
        if (!(this.f12313e.getVisibility() == 0 || this.f12316h.getVisibility() == 0)) {
            if (this.f12312d.getVisibility() != 0) {
                this.f12311c.setLines(2);
                if (this.f12311c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                    ((LinearLayout.LayoutParams) this.f12311c.getLayoutParams()).bottomMargin = UIUtils.dip2pxInt(this.f12320l, 24.0f);
                }
            } else if (this.f12311c.getLayoutParams() instanceof LinearLayout.LayoutParams) {
                ((LinearLayout.LayoutParams) this.f12312d.getLayoutParams()).bottomMargin = UIUtils.dip2pxInt(this.f12320l, 24.0f);
            }
        }
        if (bizTemplateData.rightIcon == null || TextUtils.isEmpty(bizTemplateData.rightIcon.url)) {
            this.f12319k.setVisibility(8);
        } else {
            this.f12319k.setVisibility(0);
            RequestBuilder<Drawable> load = Glide.with(this.f12320l).load(bizTemplateData.rightIcon.url);
            int i = bizTemplateData.rightIcon.position;
            if (i == 0) {
                this.f12319k.setScaleType(ImageView.ScaleType.FIT_START);
                load.into(this.f12319k);
            } else if (i == 1) {
                ((RequestBuilder) load.fitCenter()).into(this.f12319k);
            } else if (i == 2) {
                this.f12319k.setScaleType(ImageView.ScaleType.FIT_END);
                load.into(this.f12319k);
            }
        }
        if (bizTemplateData.bgColor != null) {
            bizTemplateData.bgColor.bindView(this.f12309a, 0);
        }
        if (bizTemplateData.cardClick != null && !TextUtils.isEmpty(bizTemplateData.cardClick.url)) {
            this.f12309a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XpTemplateBizModel xpTemplateBizModel = xpTemplateBizModel;
                    if (xpTemplateBizModel != null) {
                        OmegaXPTrack.omegaTrackWhenClickCard(xpTemplateBizModel);
                    }
                    DRouter.build(bizTemplateData.cardClick.url).start();
                }
            });
        }
    }

    public View getView() {
        return this.f12309a;
    }
}

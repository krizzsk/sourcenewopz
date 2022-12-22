package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.cardview.widget.CardView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.eventtracker.Const;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.router.XBRouter;
import com.didiglobal.xbanner.template.mdel.XBannerArrowModel;
import com.didiglobal.xbanner.template.mdel.XBannerCardClick;
import com.didiglobal.xbanner.template.mdel.XBannerExtension;
import com.didiglobal.xbanner.template.mdel.XBannerModelContent;
import com.didiglobal.xbanner.template.mdel.expand.XBannerExpandBtn;
import com.didiglobal.xbanner.template.mdel.expand.XBannerExpandModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class XBannerExpandView extends FrameLayout implements XBCardView<XBannerExpandModel> {

    /* renamed from: a */
    private Context f51477a;

    /* renamed from: b */
    private ImageView f51478b;

    /* renamed from: c */
    private TextView f51479c;

    /* renamed from: d */
    private TextView f51480d;

    /* renamed from: e */
    private TextView f51481e;

    /* renamed from: f */
    private CardView f51482f;

    /* renamed from: g */
    private ConstraintLayout f51483g;

    /* renamed from: h */
    private ImageView f51484h;

    /* renamed from: i */
    private ImageView f51485i;

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
    }

    public XBannerExpandView(Context context) {
        super(context);
        init(context);
    }

    public XBannerExpandView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerExpandView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        this.f51477a = context;
        LayoutInflater.from(context).inflate(R.layout.xbanner_expand_template_item, this);
        this.f51478b = (ImageView) findViewById(R.id.expand_right_icon);
        this.f51479c = (TextView) findViewById(R.id.expand_btn_text);
        this.f51480d = (TextView) findViewById(R.id.expand_content);
        this.f51481e = (TextView) findViewById(R.id.expand_title);
        this.f51482f = (CardView) findViewById(R.id.expand_btn_view);
        this.f51483g = (ConstraintLayout) findViewById(R.id.expand_layout);
        this.f51484h = (ImageView) findViewById(R.id.expand_bg_view);
        this.f51485i = (ImageView) findViewById(R.id.right_arrow_icon);
    }

    public View createView(Context context, final XBannerExpandModel xBannerExpandModel, int i) {
        int i2;
        int i3;
        if (xBannerExpandModel == null) {
            return this;
        }
        XBannerArrowModel xBannerArrowModel = xBannerExpandModel.arrow;
        int i4 = 0;
        if (xBannerArrowModel != null) {
            i3 = xBannerArrowModel.position;
            i2 = xBannerArrowModel.type;
        } else {
            i2 = -1;
            i3 = 0;
        }
        if (!TextUtils.isEmpty(xBannerExpandModel.bg_image)) {
            ((RequestBuilder) Glide.with(context).load(xBannerExpandModel.bg_image).centerCrop()).into(this.f51484h);
        } else if (!TextUtils.isEmpty(xBannerExpandModel.bg_color)) {
            try {
                this.f51484h.setBackgroundColor(XBannerUtil.getColor(xBannerExpandModel.bg_color));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        XBannerModelContent xBannerModelContent = xBannerExpandModel.title;
        if (xBannerModelContent == null || xBannerModelContent.text == null) {
            this.f51481e.setVisibility(8);
        } else {
            this.f51481e.setVisibility(0);
            this.f51481e.setText(C17295b.m36858a(context, xBannerModelContent.text, i2, i3));
            if (xBannerModelContent.size > 0) {
                this.f51481e.setTextSize(2, (float) xBannerModelContent.size);
            }
            this.f51481e.setTextColor(XBannerUtil.getColor(xBannerModelContent.color));
            this.f51481e.setTypeface(Typeface.defaultFromStyle(xBannerModelContent.bold == 1 ? 1 : 0));
        }
        XBannerModelContent xBannerModelContent2 = xBannerExpandModel.subtitle;
        if (xBannerModelContent2 == null || xBannerModelContent2.text == null) {
            this.f51480d.setVisibility(8);
        } else {
            this.f51480d.setVisibility(0);
            this.f51480d.setText(C17295b.m36861b(context, xBannerModelContent2.text, i2, i3));
            if (xBannerModelContent2.size > 0) {
                this.f51480d.setTextSize(2, (float) xBannerModelContent2.size);
            }
            this.f51480d.setTextColor(XBannerUtil.getColor(xBannerModelContent2.color));
            this.f51480d.setTypeface(Typeface.defaultFromStyle(xBannerModelContent2.bold == 1 ? 1 : 0));
        }
        final XBannerCardClick xBannerCardClick = xBannerExpandModel.card_click;
        if (xBannerCardClick != null) {
            this.f51483g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBRouter.routerStart(xBannerCardClick.url, xBannerExpandModel.extension);
                    HashMap hashMap = new HashMap();
                    if (xBannerExpandModel.extension != null) {
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerExpandModel.extension.f51476id);
                        if (xBannerExpandModel.extension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExpandModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    hashMap.put("type", 0);
                    hashMap.put("rank", 0);
                    OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_ck", (Map<String, Object>) hashMap);
                }
            });
        }
        if (!TextUtils.isEmpty(xBannerExpandModel.right_icon)) {
            this.f51478b.setVisibility(0);
            Glide.with(context).load(xBannerExpandModel.right_icon).into(this.f51478b);
        } else {
            this.f51478b.setVisibility(4);
        }
        if (C17295b.m36863c(i3)) {
            this.f51485i.setVisibility(0);
            this.f51485i.setImageDrawable(C17295b.m36856a(context, i2));
        } else {
            this.f51485i.setVisibility(8);
        }
        final XBannerExpandBtn xBannerExpandBtn = xBannerExpandModel.button_click;
        if (xBannerExpandBtn == null || xBannerExpandBtn.text == null || TextUtils.isEmpty(xBannerExpandBtn.text.text)) {
            this.f51482f.setVisibility(8);
        } else {
            this.f51482f.setVisibility(0);
            this.f51479c.setBackgroundColor(XBannerUtil.getColor(xBannerExpandBtn.bg_color));
            this.f51479c.setText(xBannerExpandBtn.text.text);
            if (!TextUtils.isEmpty(xBannerExpandBtn.text.color)) {
                this.f51479c.setTextColor(XBannerUtil.getColor(xBannerExpandBtn.text.color));
            }
            if (xBannerExpandBtn.text.size > 0) {
                this.f51479c.setTextSize(2, (float) xBannerExpandBtn.text.size);
            }
            TextView textView = this.f51479c;
            if (xBannerExpandBtn.text.bold == 1) {
                i4 = 1;
            }
            textView.setTypeface(Typeface.defaultFromStyle(i4));
            if (!TextUtils.isEmpty(xBannerExpandBtn.url)) {
                this.f51482f.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        XBannerExtension xBannerExtension = xBannerExpandModel.extension;
                        XBRouter.routerStart(xBannerExpandBtn.url, xBannerExtension);
                        HashMap hashMap = new HashMap();
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerExtension.f51476id);
                        if (xBannerExtension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerExpandModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                        hashMap.put("type", 0);
                        hashMap.put(Const.BUTTON_ID, xBannerExpandBtn.optionId);
                        hashMap.put("rank", 0);
                        OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_button_ck", (Map<String, Object>) hashMap);
                    }
                });
            }
        }
        return this;
    }
}

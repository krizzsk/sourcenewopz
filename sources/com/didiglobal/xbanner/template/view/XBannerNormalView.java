package com.didiglobal.xbanner.template.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.xbanner.basemodel.XBCardView;
import com.didi.global.xbanner.utils.XBannerUtil;
import com.didi.global.xbanner.view.recycler.XbCardReloadListener;
import com.didi.soda.compose.card.BaseCard;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.xbanner.router.XBRouter;
import com.didiglobal.xbanner.template.mdel.XBannerArrowModel;
import com.didiglobal.xbanner.template.mdel.XBannerCardClick;
import com.didiglobal.xbanner.template.mdel.XBannerModelContent;
import com.didiglobal.xbanner.template.mdel.normal.XBannerNormalModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class XBannerNormalView extends FrameLayout implements XBCardView<XBannerNormalModel> {

    /* renamed from: a */
    private ImageView f51486a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ImageView f51487b;

    /* renamed from: c */
    private TextView f51488c;

    /* renamed from: d */
    private TextView f51489d;

    /* renamed from: e */
    private ConstraintLayout f51490e;

    /* renamed from: f */
    private ImageView f51491f;

    public void setReloadListener(XbCardReloadListener xbCardReloadListener) {
    }

    public XBannerNormalView(Context context) {
        super(context);
        init(context);
    }

    public XBannerNormalView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        init(context);
    }

    public XBannerNormalView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        init(context);
    }

    public void init(Context context) {
        LayoutInflater.from(context).inflate(R.layout.xbanner_normal_template_item, this);
        this.f51486a = (ImageView) findViewById(R.id.normal_right_icon);
        this.f51487b = (ImageView) findViewById(R.id.normal_bg_view);
        this.f51488c = (TextView) findViewById(R.id.normal_item_content);
        this.f51489d = (TextView) findViewById(R.id.normal_item_title);
        this.f51490e = (ConstraintLayout) findViewById(R.id.normal_item_cons_layout);
        this.f51491f = (ImageView) findViewById(R.id.right_arrow_icon);
    }

    public View createView(final Context context, final XBannerNormalModel xBannerNormalModel, final int i) {
        int i2;
        int i3;
        if (xBannerNormalModel == null) {
            return this;
        }
        XBannerArrowModel xBannerArrowModel = xBannerNormalModel.arrow;
        if (xBannerArrowModel != null) {
            i2 = xBannerArrowModel.position;
            i3 = xBannerArrowModel.type;
        } else {
            i3 = -1;
            i2 = 0;
        }
        if (!TextUtils.isEmpty(xBannerNormalModel.bg_image)) {
            Glide.with(context).asBitmap().load(xBannerNormalModel.bg_image).into(new CustomTarget<Bitmap>() {
                public void onLoadCleared(Drawable drawable) {
                }

                public void onResourceReady(Bitmap bitmap, Transition<? super Bitmap> transition) {
                    if (bitmap != null) {
                        Bitmap bitmapCut = BitmapCut.bitmapCut(bitmap, i, XBannerUtil.getItemHeight(context));
                        XBannerNormalView.this.f51487b.setScaleType(ImageView.ScaleType.FIT_XY);
                        ImageView a = XBannerNormalView.this.f51487b;
                        if (bitmapCut != null) {
                            bitmap = bitmapCut;
                        }
                        a.setImageBitmap(bitmap);
                    }
                }
            });
        } else if (!TextUtils.isEmpty(xBannerNormalModel.bg_color)) {
            try {
                this.f51487b.setBackgroundColor(XBannerUtil.getColor(xBannerNormalModel.bg_color));
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        XBannerModelContent xBannerModelContent = xBannerNormalModel.subtitle;
        int i4 = 1;
        if (xBannerModelContent == null || TextUtils.isEmpty(xBannerModelContent.text)) {
            this.f51488c.setVisibility(8);
        } else {
            this.f51488c.setVisibility(0);
            this.f51488c.setText(xBannerModelContent.text);
            if (xBannerModelContent.size > 0) {
                this.f51488c.setTextSize(2, (float) xBannerModelContent.size);
            }
            this.f51488c.setText(C17295b.m36861b(context, xBannerModelContent.text, i3, i2));
            this.f51488c.setTextColor(XBannerUtil.getColor(xBannerModelContent.color));
            this.f51488c.setTypeface(Typeface.defaultFromStyle(xBannerModelContent.bold == 1 ? 1 : 0));
        }
        XBannerModelContent xBannerModelContent2 = xBannerNormalModel.title;
        if (xBannerModelContent2 == null || xBannerModelContent2.text == null) {
            this.f51489d.setVisibility(8);
        } else {
            this.f51489d.setVisibility(0);
            int i5 = this.f51488c.getVisibility() == 0 ? 1 : 2;
            this.f51489d.setMaxLines(i5);
            if (xBannerModelContent2.size > 0) {
                this.f51489d.setTextSize(2, (float) xBannerModelContent2.size);
            }
            this.f51489d.setTextColor(XBannerUtil.getColor(xBannerModelContent2.color));
            TextView textView = this.f51489d;
            if (xBannerModelContent2.bold != 1) {
                i4 = 0;
            }
            textView.setTypeface(Typeface.defaultFromStyle(i4));
            this.f51489d.setText(C17295b.m36859a(context, xBannerModelContent2.text, i3, i2, i5));
        }
        final XBannerCardClick xBannerCardClick = xBannerNormalModel.card_click;
        if (xBannerCardClick != null) {
            this.f51490e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    XBRouter.routerStart(xBannerCardClick.url, xBannerNormalModel.extension);
                    HashMap hashMap = new HashMap();
                    if (xBannerNormalModel.extension != null) {
                        hashMap.put(BaseCard.KEY_CARD_ID, xBannerNormalModel.extension.f51476id);
                        hashMap.put("rank", Integer.valueOf(xBannerNormalModel.extension.index));
                        if (xBannerNormalModel.extension.log_data != null) {
                            try {
                                hashMap.putAll((Map) new Gson().fromJson((JsonElement) xBannerNormalModel.extension.log_data, new HashMap().getClass()));
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    }
                    hashMap.put("type", 1);
                    OmegaSDKAdapter.trackEvent("ibt_gp_operationcard_ck", (Map<String, Object>) hashMap);
                }
            });
        }
        Glide.with(context).load(xBannerNormalModel.right_icon).into(this.f51486a);
        if (C17295b.m36863c(i2)) {
            this.f51491f.setVisibility(0);
            this.f51491f.setImageDrawable(C17295b.m36856a(context, i3));
        } else {
            this.f51491f.setVisibility(8);
        }
        return this;
    }
}

package com.didiglobal.p205sa.biz.component.businesscard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.views.bottombar.IMSkinTextView;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.view.AbsBusinessItemView */
public abstract class AbsBusinessItemView extends ConstraintLayout {

    /* renamed from: a */
    BusinessCardModel.BusinessMenuModel f50822a;

    /* renamed from: b */
    private Logger f50823b = LoggerFactory.getLogger(getClass());
    protected ImageView hoticon;
    protected ImageView icon;
    protected ConstraintLayout itemContent;
    protected Context mContext;
    protected TextView tag_tv;
    protected TextView title;

    public abstract int getLayoutResId();

    public abstract int getRealWidth();

    public abstract float getWeight();

    public void log(String str) {
        this.f50823b.info(str, new Object[0]);
    }

    public AbsBusinessItemView(Context context) {
        super(context);
        m36478a(context);
    }

    public AbsBusinessItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36478a(context);
    }

    public AbsBusinessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36478a(context);
    }

    /* renamed from: a */
    private void m36478a(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(getLayoutResId(), this, true);
        this.title = (TextView) findViewById(R.id.tv_business_name);
        this.tag_tv = (TextView) findViewById(R.id.tv_business_tag);
        this.icon = (ImageView) findViewById(R.id.iv_business_icon);
        this.hoticon = (ImageView) findViewById(R.id.iv_hot_icon);
        this.itemContent = (ConstraintLayout) findViewById(R.id.item_content);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AbsBusinessItemView absBusinessItemView = AbsBusinessItemView.this;
                absBusinessItemView.log("scheme " + AbsBusinessItemView.this.f50822a.schema);
                AbsBusinessItemView absBusinessItemView2 = AbsBusinessItemView.this;
                absBusinessItemView2.m36479a(absBusinessItemView2.f50822a, true);
                Bundle bundle = new Bundle();
                bundle.putString("action_type", "diamond");
                HashMap hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_COMPLAIN_ENTRY, "sa");
                hashMap.put("entry_2", "sa_businesscard");
                bundle.putSerializable("sa_entry", hashMap);
                SaBusinessManager.Companion.getIns().switchBusiness(AbsBusinessItemView.this.f50822a.groupType, AbsBusinessItemView.this.f50822a.schema, bundle);
            }
        });
        setBackgroundResource(R.drawable.business_shadow_bg);
    }

    public void setData(BusinessCardModel.BusinessMenuModel businessMenuModel) {
        if (businessMenuModel != null) {
            log(businessMenuModel.toString());
            this.f50822a = businessMenuModel;
            businessMenuModel.name.bindTextView(this.title);
            if (!TextUtils.isEmpty(businessMenuModel.businessIcon)) {
                ((RequestBuilder) Glide.with(this.mContext.getApplicationContext()).load(businessMenuModel.businessIcon).placeholder((int) R.drawable.sa_business_default)).into(this.icon);
            }
            if (businessMenuModel.hotInfo == null || TextUtils.isEmpty(businessMenuModel.hotInfo.hotIcon)) {
                this.hoticon.setVisibility(8);
            } else {
                this.hoticon.setVisibility(0);
                Glide.with(this.mContext.getApplicationContext()).load(businessMenuModel.hotInfo.hotIcon).into(this.hoticon);
            }
            this.itemContent.setBackground(m36477a(this.mContext, businessMenuModel.backGroundColor));
            if (businessMenuModel.tags == null || businessMenuModel.tags.size() <= 0) {
                this.tag_tv.setVisibility(8);
            } else {
                this.tag_tv.setVisibility(0);
                this.tag_tv.setBackground(m36476a(this.mContext, businessMenuModel.tags.get(0)));
                businessMenuModel.tags.get(0).info.bindTextView(this.tag_tv);
            }
            m36479a(businessMenuModel, false);
        }
    }

    public void updateLayoutParams(boolean z, boolean z2) {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getRealWidth(), -2);
        int dip2px = UiUtils.dip2px(getContext(), -9.0f);
        if (z) {
            layoutParams.setMargins(0, 0, dip2px, 0);
        } else if (z2) {
            layoutParams.setMargins(dip2px, 0, 0, 0);
        } else {
            layoutParams.setMargins(dip2px, 0, dip2px, 0);
        }
        setLayoutParams(layoutParams);
    }

    /* renamed from: a */
    private GradientDrawable m36477a(Context context, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setShape(0);
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(context, 20.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        try {
            gradientDrawable.setColor(Color.parseColor(str));
        } catch (Exception e) {
            e.printStackTrace();
            gradientDrawable.setColor(Color.parseColor(ColorUtils.DIDI_GREY));
        }
        return gradientDrawable;
    }

    /* renamed from: a */
    private GradientDrawable m36476a(Context context, BusinessCardModel.ActivityTag activityTag) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(context, 10.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        if (activityTag == null || TextUtils.isEmpty(activityTag.color_start) || TextUtils.isEmpty(activityTag.color_end)) {
            gradientDrawable.setColor(Color.parseColor("#2FD79C"));
        } else {
            try {
                gradientDrawable.setColors(new int[]{Color.parseColor(activityTag.color_start), Color.parseColor(activityTag.color_end)});
            } catch (Exception e) {
                e.printStackTrace();
                gradientDrawable.setColor(Color.parseColor("#2FD79C"));
            }
        }
        return gradientDrawable;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36479a(BusinessCardModel.BusinessMenuModel businessMenuModel, boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "sa_page");
        hashMap.put("type", IMSkinTextView.IM_SKIN_COMMON);
        StringBuilder sb = new StringBuilder();
        if (businessMenuModel.tags != null && businessMenuModel.tags.size() > 0) {
            sb.append("label;");
        }
        if (businessMenuModel.hotInfo != null) {
            sb.append("bubble;");
        }
        hashMap.put("style", sb.toString());
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        hashMap.put("size", Integer.valueOf(businessMenuModel.style));
        try {
            HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) businessMenuModel.log_data, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        if (z) {
            OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_ck", (Map<String, Object>) hashMap);
        } else {
            OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_sw", (Map<String, Object>) hashMap);
        }
    }
}

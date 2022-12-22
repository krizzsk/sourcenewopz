package com.didiglobal.p205sa.biz.component.businesscard.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.FragmentActivity;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.dcrypto.util.ColorUtils;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.businesscard.BusinessMoreDialog;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.view.MoreBusinessItemView */
public class MoreBusinessItemView extends ConstraintLayout {

    /* renamed from: a */
    BusinessCardModel f50827a;

    /* renamed from: b */
    private Logger f50828b = LoggerFactory.getLogger(getClass());
    protected ConstraintLayout itemContent;
    protected ImageView iv_more_icon;
    protected Context mContext;

    public void log(String str) {
        this.f50828b.info(str, new Object[0]);
    }

    public MoreBusinessItemView(Context context) {
        super(context);
        m36486a(context);
    }

    public MoreBusinessItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m36486a(context);
    }

    public MoreBusinessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m36486a(context);
    }

    /* renamed from: a */
    private void m36486a(Context context) {
        this.mContext = context;
        LayoutInflater.from(context).inflate(R.layout.business_more_item, this, true);
        this.iv_more_icon = (ImageView) findViewById(R.id.iv_more_icon);
        this.itemContent = (ConstraintLayout) findViewById(R.id.item_content);
        setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                MoreBusinessItemView.this.addTrack(true);
                new BusinessMoreDialog(MoreBusinessItemView.this.f50827a).show(((FragmentActivity) MoreBusinessItemView.this.mContext).getSupportFragmentManager(), "business-more-dialog");
            }
        });
        setBackgroundResource(R.drawable.business_shadow_bg);
        updateLayoutParams();
    }

    public void updateLayoutParams() {
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(getRealWidth(), -2);
        layoutParams.setMargins(UiUtils.dip2px(getContext(), -9.0f), 0, 0, 0);
        setLayoutParams(layoutParams);
    }

    public int getRealWidth() {
        return (((com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE.getScreenWidth(DIDIApplication.getAppContext()) - (com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 16.0f) * 2)) - (com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 8.0f) * 3)) / 4) + com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 13.0f) + com.didiglobal.p205sa.biz.util.UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 13.0f);
    }

    public void setData(BusinessCardModel businessCardModel) {
        if (businessCardModel != null && businessCardModel.moreBusiness != null) {
            log(businessCardModel.toString());
            this.f50827a = businessCardModel;
            if (!TextUtils.isEmpty(businessCardModel.moreBusiness.moreIcon)) {
                ((RequestBuilder) Glide.with(this.mContext.getApplicationContext()).load(businessCardModel.moreBusiness.moreIcon).placeholder((int) R.drawable.sa_business_more_defalut)).into(this.iv_more_icon);
            }
            this.itemContent.setBackground(m36485a(this.mContext, businessCardModel.moreBusiness.backGroundColor));
            addTrack(false);
        }
    }

    /* renamed from: a */
    private GradientDrawable m36485a(Context context, String str) {
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

    public void addTrack(boolean z) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "sa_page");
        hashMap.put("type", "more");
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        if (z) {
            OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_ck", (Map<String, Object>) hashMap);
        } else {
            OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_sw", (Map<String, Object>) hashMap);
        }
    }
}

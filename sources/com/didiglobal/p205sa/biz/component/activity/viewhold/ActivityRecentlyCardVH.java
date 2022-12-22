package com.didiglobal.p205sa.biz.component.activity.viewhold;

import android.graphics.Color;
import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.drouter.api.DRouter;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didiglobal.p205sa.biz.component.activity.model.ActivityCardModel;
import com.didiglobal.p205sa.biz.component.activity.omega.ActivityOmegaTracker;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.Collection;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityRecentlyCardVH */
public class ActivityRecentlyCardVH extends BaseRecVH {

    /* renamed from: a */
    private View f50791a;

    /* renamed from: b */
    private Gson f50792b = new Gson();

    /* renamed from: c */
    private TextView f50793c;

    /* renamed from: d */
    private ImageView f50794d;

    /* renamed from: e */
    private TextView f50795e;

    /* renamed from: f */
    private TextView f50796f;

    /* renamed from: g */
    private TextView f50797g;

    /* renamed from: h */
    private TextView f50798h;

    public ActivityRecentlyCardVH(View view) {
        super(view);
        this.f50796f = (TextView) view.findViewById(R.id.order_status);
        this.f50797g = (TextView) view.findViewById(R.id.order_status_detail);
        this.f50795e = (TextView) view.findViewById(R.id.order_flag);
        this.f50798h = (TextView) view.findViewById(R.id.order_flag_tips);
        this.f50794d = (ImageView) view.findViewById(R.id.business_image);
        this.f50793c = (TextView) view.findViewById(R.id.pass_card_btn);
        this.f50791a = view.findViewById(R.id.pass_content);
    }

    public void bindView(final ActivityCardModel activityCardModel) {
        if (activityCardModel != null) {
            String bg_color = activityCardModel.getBg_color();
            View view = this.f50791a;
            if (view != null) {
                try {
                    view.setBackgroundColor(Color.parseColor(bg_color));
                } catch (Exception unused) {
                    this.f50791a.findViewById(R.id.ongoing_content).setBackgroundColor(Color.parseColor("#D9ffffff"));
                }
            }
            if (activityCardModel.getOrder_status() != null) {
                activityCardModel.getOrder_status().bindTextView(this.f50796f);
            }
            if (activityCardModel.getOrder_status_detail() == null || TextUtils.isEmpty(activityCardModel.getOrder_status_detail().getContent())) {
                this.f50797g.setVisibility(8);
            } else {
                this.f50797g.setVisibility(0);
                activityCardModel.getOrder_status_detail().bindTextView(this.f50797g);
            }
            if (activityCardModel.getOrder_flag() != null) {
                activityCardModel.getOrder_flag().bindTextView(this.f50795e);
            }
            if (activityCardModel.getOrder_flag_tips() != null) {
                activityCardModel.getOrder_flag_tips().bindTextView(this.f50798h);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) activityCardModel.getButtons())) {
                this.f50793c.setVisibility(0);
                final ActivityCardModel.ButtonsBean buttonsBean = activityCardModel.getButtons().get(0);
                if (buttonsBean != null) {
                    if (buttonsBean.getInfo() != null) {
                        buttonsBean.getInfo().bindTextView(this.f50793c);
                    }
                    this.f50793c.setBackground(UiUtils.INSTANCE.getRadiusBgDrawable(this.f50793c.getContext(), buttonsBean.getStart_color(), buttonsBean.getEnd_color(), "#FFFFFF", 15.0f));
                    if (!TextUtils.isEmpty(buttonsBean.getAction())) {
                        this.f50793c.setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                ActivityOmegaTracker.OmegaCardBtnClick(activityCardModel, buttonsBean);
                                DRouter.build(buttonsBean.getAction()).start();
                            }
                        });
                    } else {
                        ActivityOmegaTracker.OmegaError(5);
                    }
                }
            } else {
                this.f50793c.setVisibility(8);
            }
            this.itemView.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (!TextUtils.isEmpty(activityCardModel.getCard_url())) {
                        ActivityOmegaTracker.OmegaCardClick(activityCardModel);
                        DRouter.build(activityCardModel.getCard_url()).start();
                    }
                }
            });
            ((RequestBuilder) Glide.with(this.itemView.getContext()).load(activityCardModel.getBusiness_image()).placeholder((int) R.drawable.sa_business_default)).into(this.f50794d);
        }
    }
}

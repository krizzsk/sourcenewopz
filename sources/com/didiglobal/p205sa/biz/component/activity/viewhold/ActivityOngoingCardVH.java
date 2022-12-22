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
import com.taxis99.R;
import java.util.Collection;

/* renamed from: com.didiglobal.sa.biz.component.activity.viewhold.ActivityOngoingCardVH */
public class ActivityOngoingCardVH extends BaseRecVH {

    /* renamed from: a */
    private final View f50782a;

    /* renamed from: b */
    private TextView f50783b;

    /* renamed from: c */
    private ImageView f50784c;

    /* renamed from: d */
    private TextView f50785d;

    /* renamed from: e */
    private TextView f50786e;

    /* renamed from: f */
    private TextView f50787f;

    /* renamed from: g */
    private TextView f50788g;

    public ActivityOngoingCardVH(View view) {
        super(view);
        this.f50786e = (TextView) view.findViewById(R.id.order_status);
        this.f50787f = (TextView) view.findViewById(R.id.order_status_detail);
        this.f50785d = (TextView) view.findViewById(R.id.order_flag);
        this.f50788g = (TextView) view.findViewById(R.id.order_flag_tips);
        this.f50784c = (ImageView) view.findViewById(R.id.business_image);
        this.f50783b = (TextView) view.findViewById(R.id.ongoing_card_btn);
        this.f50782a = view.findViewById(R.id.ongoing_content);
    }

    public void bindView(final ActivityCardModel activityCardModel) {
        if (activityCardModel != null) {
            String bg_color = activityCardModel.getBg_color();
            View view = this.f50782a;
            if (view != null) {
                try {
                    view.setBackgroundColor(Color.parseColor(bg_color));
                } catch (Exception unused) {
                    this.f50782a.findViewById(R.id.ongoing_content).setBackgroundColor(Color.parseColor("#F3F4F8"));
                }
            }
            if (activityCardModel.getOrder_status() != null) {
                activityCardModel.getOrder_status().bindTextView(this.f50786e);
            }
            if (activityCardModel.getOrder_status_detail() == null || TextUtils.isEmpty(activityCardModel.getOrder_status_detail().getContent())) {
                this.f50787f.setVisibility(8);
            } else {
                activityCardModel.getOrder_status_detail().bindTextView(this.f50787f);
            }
            if (activityCardModel.getOrder_flag() != null) {
                activityCardModel.getOrder_flag().bindTextView(this.f50785d);
            }
            if (activityCardModel.getOrder_flag_tips() != null) {
                activityCardModel.getOrder_flag_tips().bindTextView(this.f50788g);
            }
            if (!CollectionUtil.isEmpty((Collection<?>) activityCardModel.getButtons())) {
                this.f50783b.setVisibility(0);
                final ActivityCardModel.ButtonsBean buttonsBean = activityCardModel.getButtons().get(0);
                if (buttonsBean != null) {
                    if (buttonsBean.getInfo() != null) {
                        buttonsBean.getInfo().bindTextView(this.f50783b);
                    }
                    this.f50783b.setBackground(UiUtils.INSTANCE.getRadiusBgDrawable(this.f50783b.getContext(), buttonsBean.getStart_color(), buttonsBean.getEnd_color(), "#E9ECF2", 15.0f));
                    if (!TextUtils.isEmpty(buttonsBean.getAction())) {
                        this.f50783b.setOnClickListener(new View.OnClickListener() {
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
                this.f50783b.setVisibility(8);
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
            ((RequestBuilder) Glide.with(this.itemView.getContext()).load(activityCardModel.getBusiness_image()).placeholder((int) R.drawable.sa_business_default)).into(this.f50784c);
        }
    }
}

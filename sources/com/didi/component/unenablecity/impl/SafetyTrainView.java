package com.didi.component.unenablecity.impl;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.core.IView;
import com.didi.component.unenablecity.AbsUnableCityPresenter;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.travel.psnger.model.response.SafetyTrainCardInfo;
import com.taxis99.R;

public class SafetyTrainView implements IView<AbsUnableCityPresenter> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsUnableCityPresenter f16192a;

    /* renamed from: b */
    private View f16193b;

    /* renamed from: c */
    private TextView f16194c;

    /* renamed from: d */
    private TextView f16195d = ((TextView) this.f16193b.findViewById(R.id.tv_safety_train_card_content));

    /* renamed from: e */
    private TextView f16196e = ((TextView) this.f16193b.findViewById(R.id.tv_safety_train_card_btn));

    /* renamed from: f */
    private ImageView f16197f = ((ImageView) this.f16193b.findViewById(R.id.iv_safety_train_card_icon));

    /* renamed from: g */
    private Context f16198g;

    public SafetyTrainView(Activity activity, ViewGroup viewGroup) {
        this.f16198g = activity;
        View inflate = ViewGroup.inflate(activity, R.layout.global_new_safety_train_card_view, viewGroup);
        this.f16193b = inflate;
        this.f16194c = (TextView) inflate.findViewById(R.id.tv_safety_train_card_title);
    }

    public void setPresenter(AbsUnableCityPresenter absUnableCityPresenter) {
        this.f16192a = absUnableCityPresenter;
    }

    public View getView() {
        return this.f16193b;
    }

    public void setSafetyTrainCardInfo(final SafetyTrainCardInfo safetyTrainCardInfo) {
        TextView textView = this.f16194c;
        if (textView != null) {
            textView.setText(safetyTrainCardInfo.title);
        }
        TextView textView2 = this.f16195d;
        if (textView2 != null) {
            textView2.setText(safetyTrainCardInfo.content);
        }
        if (this.f16196e != null && !TextUtils.isEmpty(safetyTrainCardInfo.detailUrl) && !TextUtils.isEmpty(safetyTrainCardInfo.descLabel)) {
            this.f16196e.setVisibility(0);
            this.f16196e.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SafetyTrainView.this.f16192a != null) {
                        SafetyTrainView.this.f16192a.gotoWebPage(safetyTrainCardInfo.detailUrl);
                    }
                }
            });
            this.f16196e.setText(safetyTrainCardInfo.descLabel);
            if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_color)) {
                this.f16196e.setTextColor(Color.parseColor(safetyTrainCardInfo.bg_color));
            }
        }
        if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_color)) {
            this.f16193b.setBackground(m11878a(this.f16198g, safetyTrainCardInfo.bg_color));
        } else {
            this.f16193b.setBackgroundResource(R.drawable.global_safety_train_card_bg);
        }
        if (!TextUtils.isEmpty(safetyTrainCardInfo.bg_image)) {
            Glide.with(this.f16198g).load(safetyTrainCardInfo.bg_image).into(this.f16197f);
        } else {
            this.f16197f.setImageResource(R.drawable.global_safety_train_card_icon);
        }
    }

    /* renamed from: a */
    private GradientDrawable m11878a(Context context, String str) {
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setCornerRadius((float) UiUtils.dip2px(context, 20.0f));
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColor(Color.parseColor(str));
        return gradientDrawable;
    }
}

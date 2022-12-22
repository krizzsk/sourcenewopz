package com.didi.component.comp_recommend_boarding_point.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.comp_recommend_boarding_point.AbsRecommendBoardingPointPresent;
import com.didi.component.comp_recommend_boarding_point.IRecommendBoardingPointView;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;

public class RecommendBoardingPointView implements View.OnClickListener, IRecommendBoardingPointView {

    /* renamed from: a */
    private final View f12370a;

    /* renamed from: b */
    private AbsRecommendBoardingPointPresent f12371b;

    /* renamed from: c */
    private final TextView f12372c;

    /* renamed from: d */
    private final TextView f12373d = ((TextView) this.f12370a.findViewById(R.id.tv_content));

    /* renamed from: e */
    private final TextView f12374e;

    /* renamed from: f */
    private Button f12375f;

    public RecommendBoardingPointView(Context context, ViewGroup viewGroup) {
        View inflate = LayoutInflater.from(context).inflate(R.layout.recommend_boarding_point_layout, viewGroup, false);
        this.f12370a = inflate;
        this.f12372c = (TextView) inflate.findViewById(R.id.tv_title);
        TextView textView = (TextView) this.f12370a.findViewById(R.id.tv_time);
        this.f12374e = textView;
        textView.setOnClickListener(this);
        Button button = (Button) this.f12370a.findViewById(R.id.btn_use);
        this.f12375f = button;
        button.setOnClickListener(this);
    }

    public View getView() {
        return this.f12370a;
    }

    public void setPresenter(AbsRecommendBoardingPointPresent absRecommendBoardingPointPresent) {
        this.f12371b = absRecommendBoardingPointPresent;
    }

    public void setTime(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f12374e.setText(str);
        }
    }

    public void setTitle(String str) {
        if (!TextUtil.isEmpty(str)) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setInfo(str);
            globalRichInfo.bindTextView(this.f12372c);
        }
    }

    public void setContent(String str) {
        if (!TextUtil.isEmpty(str)) {
            GlobalRichInfo globalRichInfo = new GlobalRichInfo();
            globalRichInfo.setInfo(str);
            globalRichInfo.bindTextView(this.f12373d);
        }
    }

    public void setButtonText(String str) {
        if (!TextUtil.isEmpty(str)) {
            this.f12375f.setText(str);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.btn_use) {
            this.f12371b.cardUseDismissClick(true);
        } else if (id == R.id.tv_time) {
            this.f12371b.cardUseDismissClick(false);
        }
    }

    public void hideView() {
        View view = this.f12370a;
        if (view != null) {
            view.setVisibility(8);
        }
    }
}

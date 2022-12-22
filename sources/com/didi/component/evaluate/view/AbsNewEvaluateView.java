package com.didi.component.evaluate.view;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.evaluate.presenter.AbsCommonEvaluatePresenter;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.taxis99.R;

public abstract class AbsNewEvaluateView implements IEvaluateView {
    protected AbsCommonEvaluatePresenter mAbsEvaluatePresenter;
    protected View mRootView;
    protected TextView mUnMatchDetail;
    protected ImageView mUnMatchIcon;
    protected RelativeLayout mUnMatchLayout;
    protected TextView mUnMatchResult;
    protected TextView mUnMatchSubmit;

    public int getStyle() {
        return 0;
    }

    public void showUnMatchSubmit(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z) {
        m9131a(unMatchInfo);
        this.mUnMatchDetail.setVisibility(0);
        this.mUnMatchSubmit.setVisibility(0);
        this.mUnMatchResult.setVisibility(4);
        this.mUnMatchIcon.setVisibility(4);
    }

    public void showUnMatchResult(UnevaluatedViewModel.UnMatchInfo unMatchInfo, boolean z) {
        m9131a(unMatchInfo);
        this.mUnMatchDetail.setVisibility(4);
        this.mUnMatchSubmit.setVisibility(4);
        this.mUnMatchResult.setVisibility(0);
        this.mUnMatchIcon.setVisibility(0);
    }

    /* renamed from: a */
    private void m9131a(UnevaluatedViewModel.UnMatchInfo unMatchInfo) {
        if (this.mUnMatchLayout == null) {
            RelativeLayout relativeLayout = (RelativeLayout) this.mRootView.findViewById(R.id.unmatch_layout);
            this.mUnMatchLayout = relativeLayout;
            relativeLayout.setVisibility(0);
            this.mUnMatchDetail = (TextView) this.mRootView.findViewById(R.id.unmatch_detail);
            this.mUnMatchSubmit = (TextView) this.mRootView.findViewById(R.id.unmatch_submit);
            this.mUnMatchResult = (TextView) this.mRootView.findViewById(R.id.unmatch_result_evaluate);
            this.mUnMatchIcon = (ImageView) this.mRootView.findViewById(R.id.unmatch_result_icon);
            this.mUnMatchSubmit.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    AbsNewEvaluateView.this.mAbsEvaluatePresenter.submitUnMatch();
                }
            });
            if (unMatchInfo.unMatchGuideMsg != null && !TextUtils.isEmpty(unMatchInfo.unMatchGuideMsg.showMsg) && !TextUtils.isEmpty(unMatchInfo.unMatchGuideMsg.buttonMsg)) {
                this.mUnMatchDetail.setText(unMatchInfo.unMatchGuideMsg.showMsg);
                this.mUnMatchSubmit.setText(unMatchInfo.unMatchGuideMsg.buttonMsg);
                this.mUnMatchResult.setText(unMatchInfo.unMatchGuideMsg.unMatchedMsg);
            }
        }
    }
}

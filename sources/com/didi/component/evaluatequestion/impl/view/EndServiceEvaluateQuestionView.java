package com.didi.component.evaluatequestion.impl.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.loading.LoadingWrapper;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.widget.QuestionEvaluatedView;
import com.didi.global.loading.ILoadingHolder;
import com.didi.global.loading.LoadingConfig;
import com.didi.global.loading.LoadingRenderType;
import com.taxis99.R;

public class EndServiceEvaluateQuestionView extends LoadingWrapper implements IEvaluatedView, ILoadingHolder {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public AbsEvaluateQuestionPresenter f13573a;

    /* renamed from: b */
    private Activity f13574b;

    /* renamed from: c */
    private ViewGroup f13575c;

    /* renamed from: d */
    private TextView f13576d = ((TextView) this.f13575c.findViewById(R.id.tv_global_unevaluate_title));

    /* renamed from: e */
    private TextView f13577e = ((TextView) this.f13575c.findViewById(R.id.tv_global_unevaluate_subtitle));

    /* renamed from: f */
    private TextView f13578f = ((TextView) this.f13575c.findViewById(R.id.tv_global_unevaluate_content));

    /* renamed from: g */
    private TextView f13579g = ((TextView) this.f13575c.findViewById(R.id.tv_global_unevaluate_question_content));

    /* renamed from: h */
    private IEvaluatedView f13580h;

    /* renamed from: i */
    private FrameLayout f13581i;

    /* renamed from: j */
    private View f13582j;

    /* renamed from: k */
    private FrameLayout f13583k;

    public EndServiceEvaluateQuestionView(Activity activity, ViewGroup viewGroup) {
        this.f13574b = activity;
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(activity).inflate(R.layout.global_endservice_evaluate_question_layout, viewGroup, false);
        this.f13575c = viewGroup2;
        this.f13582j = viewGroup2.findViewById(R.id.global_evaluate_question_close_button);
        FrameLayout frameLayout = (FrameLayout) this.f13575c.findViewById(R.id.fl_global_evaluate_container);
        this.f13581i = frameLayout;
        QuestionEvaluatedView questionEvaluatedView = new QuestionEvaluatedView(this.f13574b, frameLayout);
        this.f13580h = questionEvaluatedView;
        this.f13581i.addView(questionEvaluatedView.getView());
        this.f13580h.setPresenter(this.f13573a);
        this.f13583k = (FrameLayout) this.f13575c.findViewById(R.id.global_endservice_evaluate_loading);
        setLoadingShowOn(this);
    }

    public void setPresenter(AbsEvaluateQuestionPresenter absEvaluateQuestionPresenter) {
        this.f13573a = absEvaluateQuestionPresenter;
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.setPresenter(absEvaluateQuestionPresenter);
            this.f13582j.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    EndServiceEvaluateQuestionView.this.f13573a.close();
                }
            });
        }
    }

    public View getView() {
        return this.f13575c;
    }

    public void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel) {
        if (unevaluatedViewModel != null) {
            if (!TextUtils.isEmpty(unevaluatedViewModel.questionTitle)) {
                this.f13576d.setVisibility(0);
                this.f13576d.setText(unevaluatedViewModel.questionTitle);
            } else {
                this.f13576d.setVisibility(8);
            }
            if (!TextUtils.isEmpty(unevaluatedViewModel.subTitle)) {
                this.f13577e.setText(unevaluatedViewModel.subTitle);
                this.f13577e.setVisibility(0);
            } else {
                this.f13577e.setVisibility(8);
            }
            if (!TextUtils.isEmpty(unevaluatedViewModel.content)) {
                this.f13578f.setText(unevaluatedViewModel.content);
                this.f13578f.setVisibility(0);
            } else {
                this.f13578f.setVisibility(8);
            }
            if (TextUtils.isEmpty(unevaluatedViewModel.questionBody) || !TextUtils.isEmpty(unevaluatedViewModel.userReply)) {
                this.f13579g.setVisibility(8);
            } else {
                this.f13579g.setText(unevaluatedViewModel.questionBody);
                this.f13579g.setVisibility(0);
            }
            IEvaluatedView iEvaluatedView = this.f13580h;
            if (iEvaluatedView != null) {
                iEvaluatedView.showUnevaluated(unevaluatedViewModel);
            }
        }
    }

    public void showUnevaluated() {
        this.f13580h.showUnevaluated();
    }

    public void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel) {
        this.f13580h.showEvaluated(i, unevaluatedViewModel);
    }

    public void onEvaluateDialogClosed() {
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.onEvaluateDialogClosed();
        }
    }

    public void showLoading() {
        super.showLoading();
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.showLoading();
        }
    }

    public void hideLoading() {
        super.hideLoading();
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.hideLoading();
        }
    }

    public void showError() {
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.showError();
        }
    }

    public void hideError() {
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.hideError();
        }
    }

    public void close() {
        IEvaluatedView iEvaluatedView = this.f13580h;
        if (iEvaluatedView != null) {
            iEvaluatedView.close();
        }
    }

    public View getFallbackView() {
        return this.f13583k;
    }

    public LoadingConfig getLoadingConfig() {
        return LoadingConfig.create().setRenderType(LoadingRenderType.ANIMATION).build();
    }
}

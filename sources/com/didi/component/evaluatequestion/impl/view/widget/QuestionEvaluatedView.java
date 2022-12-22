package com.didi.component.evaluatequestion.impl.view.widget;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.view.DotLoadingView;
import com.didi.component.common.view.TextImageView;
import com.didi.component.evaluatequestion.AbsEvaluateQuestionPresenter;
import com.didi.component.evaluatequestion.UnevaluatedViewModel;
import com.didi.component.evaluatequestion.impl.view.IEvaluatedView;
import com.taxis99.R;

public class QuestionEvaluatedView implements View.OnClickListener, IEvaluatedView {

    /* renamed from: m */
    private static final int[] f13584m = {R.drawable.global_evaluate_face_pos_pressed, R.drawable.global_evaluate_face_neg_pressed};

    /* renamed from: a */
    private View f13585a;

    /* renamed from: b */
    private View f13586b;

    /* renamed from: c */
    private TextImageView f13587c;

    /* renamed from: d */
    private View f13588d;

    /* renamed from: e */
    private TextImageView f13589e;

    /* renamed from: f */
    private View f13590f;

    /* renamed from: g */
    private TextImageView f13591g;

    /* renamed from: h */
    private Context f13592h;

    /* renamed from: i */
    private View f13593i;

    /* renamed from: j */
    private View f13594j;

    /* renamed from: k */
    private DotLoadingView f13595k;

    /* renamed from: l */
    private int f13596l;

    /* renamed from: n */
    private AbsEvaluateQuestionPresenter f13597n;

    public void close() {
    }

    public void onEvaluateDialogClosed() {
    }

    public QuestionEvaluatedView(View view) {
        this.f13592h = view.getContext();
        this.f13585a = view;
        m9328a();
    }

    public QuestionEvaluatedView(Context context, ViewGroup viewGroup) {
        this.f13592h = context;
        this.f13585a = LayoutInflater.from(context).inflate(R.layout.global_evaluate_question_layout, viewGroup, false);
        m9328a();
    }

    /* renamed from: a */
    private void m9328a() {
        this.f13586b = this.f13585a.findViewById(R.id.rl_global_evaluate_pos_layout);
        this.f13588d = this.f13585a.findViewById(R.id.rl_global_evaluate_neg_layout);
        this.f13587c = (TextImageView) this.f13585a.findViewById(R.id.iv_global_evaluate_pos_button);
        this.f13589e = (TextImageView) this.f13585a.findViewById(R.id.iv_global_evaluate_neg_button);
        this.f13590f = this.f13585a.findViewById(R.id.rl_global_evaluated_layout);
        this.f13591g = (TextImageView) this.f13585a.findViewById(R.id.iv_global_evaluated_button);
        this.f13593i = this.f13585a.findViewById(R.id.global_evaluate_question_error_layout);
        this.f13595k = (DotLoadingView) this.f13585a.findViewById(R.id.global_evaluate_question_loading);
        this.f13594j = this.f13585a.findViewById(R.id.global_evaluate_question_loading_container);
        this.f13586b.setOnClickListener(this);
        this.f13588d.setOnClickListener(this);
        this.f13593i.setOnClickListener(this);
    }

    public View getView() {
        return this.f13585a;
    }

    public void setPresenter(AbsEvaluateQuestionPresenter absEvaluateQuestionPresenter) {
        this.f13597n = absEvaluateQuestionPresenter;
    }

    public void showUnevaluated() {
        this.f13586b.setVisibility(0);
        this.f13588d.setVisibility(0);
        this.f13590f.setVisibility(8);
    }

    public void showEvaluated(int i, UnevaluatedViewModel unevaluatedViewModel) {
        if (i < 2 && i >= 0 && unevaluatedViewModel != null && unevaluatedViewModel.answers != null && unevaluatedViewModel.answers.length >= 2) {
            this.f13586b.setVisibility(8);
            this.f13588d.setVisibility(8);
            this.f13590f.setVisibility(0);
            this.f13591g.setCompoundDrawablesWithIntrinsicBounds(this.f13592h.getResources().getDrawable(f13584m[i]), (Drawable) null, (Drawable) null, (Drawable) null);
            this.f13591g.setText(unevaluatedViewModel.answers[i]);
            this.f13591g.setDrawablesSize();
        }
    }

    public void showUnevaluated(UnevaluatedViewModel unevaluatedViewModel) {
        this.f13586b.setVisibility(0);
        this.f13588d.setVisibility(0);
        this.f13590f.setVisibility(8);
        if (unevaluatedViewModel.answers != null && unevaluatedViewModel.answers.length >= 2) {
            String str = unevaluatedViewModel.answers[0];
            String str2 = unevaluatedViewModel.answers[1];
            this.f13587c.setText(str);
            this.f13589e.setText(str2);
        }
    }

    public void showLoading() {
        this.f13594j.setVisibility(0);
    }

    public void hideLoading() {
        this.f13594j.setVisibility(8);
    }

    public void showError() {
        this.f13586b.setVisibility(8);
        this.f13588d.setVisibility(8);
        this.f13593i.setVisibility(0);
    }

    public void hideError() {
        this.f13593i.setVisibility(8);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.rl_global_evaluate_pos_layout) {
            this.f13596l = 0;
            this.f13597n.onEvaluatedClicked(0);
        } else if (id == R.id.rl_global_evaluate_neg_layout) {
            this.f13596l = 1;
            this.f13597n.onEvaluatedClicked(1);
        } else if (id == R.id.rl_global_evaluated_layout) {
            this.f13596l = -1;
            this.f13597n.onEvaluatedClicked(-1);
        } else if (id == R.id.global_evaluate_question_error_layout) {
            hideError();
            this.f13597n.onEvaluatedClicked(this.f13596l);
        }
    }
}

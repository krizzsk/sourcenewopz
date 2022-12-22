package com.didi.component.evaluateentrance.evaluate.view;

import android.content.Context;
import android.graphics.Rect;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionItemModel;
import com.didi.component.evaluateentrance.evaluate.model.EvaluateQuestionModel;
import com.didi.component.evaluateentrance.evaluate.toolkit.QuestionItemAnimator;
import com.didi.component.evaluateentrance.evaluate.toolkit.ViewToolKit;
import com.didi.component.evaluateentrance.evaluate.view.EvaluateQuestionItemAdapter;
import com.didi.travel.psnger.model.UnevaluatedViewModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EvaluateQuestionView extends AbsEvaluateQuestionView {

    /* renamed from: a */
    private static final int f13512a = 1;

    /* renamed from: b */
    private static final int f13513b = 3;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final ViewToolKit f13514c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RecyclerView f13515d;

    /* renamed from: e */
    private EvaluateQuestionItemAdapter f13516e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public View f13517f;

    /* renamed from: g */
    private FrameLayout f13518g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public GXPEvaluateTipPayDrawer f13519h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public EvaluateQuestionModel f13520i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public int f13521j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public boolean f13522k;

    /* renamed from: l */
    private LinearLayoutAnimator f13523l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f13524m = -1;

    public void hideLoading() {
    }

    public void showLoading() {
    }

    public EvaluateQuestionView(Context context) {
        super(context);
        this.parentView = (ViewGroup) LayoutInflater.from(context).inflate(R.layout.g_xp_evaluate_question_layout, (ViewGroup) null);
        this.f13514c = ViewToolKit.create(this.parentView);
        m9269a((View) this.parentView);
    }

    /* renamed from: a */
    private void m9269a(View view) {
        this.f13518g = (FrameLayout) view.findViewById(R.id.fl_evaluate_question_container);
        this.f13515d = (RecyclerView) view.findViewById(R.id.g_xp_evaluate_question_recyclerView);
        this.f13523l = (LinearLayoutAnimator) view.findViewById(R.id.ll_evaluate_question_container);
        EvaluateQuestionItemAdapter evaluateQuestionItemAdapter = new EvaluateQuestionItemAdapter();
        this.f13516e = evaluateQuestionItemAdapter;
        this.f13515d.setAdapter(evaluateQuestionItemAdapter);
        this.f13515d.setNestedScrollingEnabled(false);
        QuestionItemAnimator questionItemAnimator = new QuestionItemAnimator();
        questionItemAnimator.setMoveDuration(400);
        questionItemAnimator.setAddDuration(400);
        questionItemAnimator.setRemoveDuration(400);
        this.f13515d.setItemAnimator(questionItemAnimator);
        View findViewById = view.findViewById(R.id.global_new_question_retry_view);
        this.f13517f = findViewById;
        findViewById.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EvaluateQuestionView.this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (int) R.string.GR_Feedback_2020_uploading);
                if (EvaluateQuestionView.this.presenter != null) {
                    EvaluateQuestionView.this.presenter.onEvaluatedClicked(EvaluateQuestionView.this.f13524m, EvaluateQuestionView.this.f13520i);
                }
                EvaluateQuestionView.this.f13517f.setVisibility(4);
                EvaluateQuestionView.this.f13515d.setVisibility(0);
            }
        });
        this.f13516e.setOnSelectedListener(new EvaluateQuestionItemAdapter.OnSelectedListener() {
            public void onSelected(int i) {
                int unused = EvaluateQuestionView.this.f13524m = i;
                if (EvaluateQuestionView.this.presenter != null) {
                    EvaluateQuestionView.this.presenter.onEvaluatedClicked(i, EvaluateQuestionView.this.f13520i);
                }
            }
        });
    }

    public void initData(final EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null || !evaluateQuestionModel.hasQuestionaireInfo) {
            getView().setVisibility(8);
            return;
        }
        this.f13523l.setEnableAnimator(false);
        closeDrawer();
        this.f13520i = evaluateQuestionModel;
        m9272b(evaluateQuestionModel);
        ViewGroup.LayoutParams layoutParams = this.f13518g.getLayoutParams();
        if (evaluateQuestionModel.isVertical) {
            layoutParams.width = -1;
            int dip2px = UiUtils.dip2px(this.context, 17.0f);
            this.f13518g.setPadding(dip2px, 0, dip2px, 0);
            this.f13518g.setLayoutParams(layoutParams);
            this.f13515d.setLayoutManager(new LinearLayoutManager(this.context, 1, false));
        } else {
            layoutParams.width = -2;
            this.f13518g.setPadding(0, 0, 0, 0);
            this.f13518g.setLayoutParams(layoutParams);
            this.f13515d.setLayoutManager(new LinearLayoutManager(this.context, 0, false));
        }
        this.f13516e.setData(m9268a(evaluateQuestionModel), this.context, evaluateQuestionModel.isVertical);
        if (this.f13515d.getItemDecorationCount() == 0) {
            this.f13515d.addItemDecoration(new RecyclerView.ItemDecoration() {
                public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
                    if (!evaluateQuestionModel.isVertical) {
                        if (recyclerView.getAdapter().getItemCount() == 1) {
                            rect.setEmpty();
                            if (EvaluateQuestionView.this.f13521j == 0) {
                                if (recyclerView.getChildLayoutPosition(view) == 0) {
                                    rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                    rect.right = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                } else {
                                    rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 13.0f);
                                }
                            } else if (EvaluateQuestionView.this.f13522k) {
                                rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                                rect.right = UiUtils.dip2px(EvaluateQuestionView.this.context, 84.0f);
                            } else {
                                boolean unused = EvaluateQuestionView.this.f13522k = true;
                            }
                        } else if (recyclerView.getChildLayoutPosition(view) == 1) {
                            rect.setEmpty();
                            rect.left = UiUtils.dip2px(EvaluateQuestionView.this.context, 16.0f);
                        }
                        rect.bottom = UiUtils.dip2px(EvaluateQuestionView.this.context, 30.0f);
                    } else if (recyclerView.getChildLayoutPosition(view) > 0) {
                        rect.setEmpty();
                        rect.top = UiUtils.dip2px(EvaluateQuestionView.this.context, 15.0f);
                    }
                }
            });
        }
        this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
        this.f13514c.setTextViewTextWithEmptyGone(R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
        final EvaluateTipView evaluateTipView = (EvaluateTipView) this.f13514c.findViewById(R.id.eve_tip);
        evaluateTipView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluateQuestionView.this.f13519h == null) {
                    GXPEvaluateTipPayDrawer unused = EvaluateQuestionView.this.f13519h = new GXPEvaluateTipPayDrawer(evaluateTipView.getContext(), EvaluateQuestionView.this.presenter, evaluateQuestionModel.tipInfo, "question", evaluateQuestionModel.avatarIcon);
                }
                EvaluateQuestionView.this.f13519h.show();
                GlobalOmegaUtils.trackEvent("ibt_gp_tipentrance_btn_ck", "source", "question");
            }
        });
        evaluateTipView.initData(evaluateQuestionModel.tipInfo, "question");
    }

    public void showBeforeEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel != null && evaluateQuestionModel.style == 1) {
            ArrayList arrayList = new ArrayList();
            EvaluateQuestionItemModel evaluateQuestionItemModel = null;
            if (evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() > i) {
                UnevaluatedViewModel.QuestionDataOption questionDataOption = evaluateQuestionModel.questionOptions.get(i);
                EvaluateQuestionItemModel a = m9265a(questionDataOption.iconUrl, questionDataOption.text, true);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (CharSequence) questionDataOption.title, evaluateQuestionModel.questionTitle);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, (CharSequence) questionDataOption.description, evaluateQuestionModel.questionBody);
                evaluateQuestionItemModel = a;
            } else if (evaluateQuestionModel.answers == null || evaluateQuestionModel.answers.length <= i) {
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            } else {
                evaluateQuestionItemModel = m9265a("", evaluateQuestionModel.answers[i], false);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            }
            if (evaluateQuestionItemModel != null) {
                arrayList.add(evaluateQuestionItemModel);
                if (evaluateQuestionModel.isVertical) {
                    this.f13516e.updateData(arrayList);
                    return;
                }
                this.f13523l.setEnableAnimator(true);
                this.f13521j = i;
                this.f13522k = false;
                this.f13516e.updateHorizontalData(i);
            }
        }
    }

    public void showAfterEvaluated(int i, EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel.style == 1) {
            if (evaluateQuestionModel.questionOptions == null || evaluateQuestionModel.questionOptions.size() <= i) {
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, evaluateQuestionModel.questionTitle);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, evaluateQuestionModel.questionBody);
            } else {
                UnevaluatedViewModel.QuestionDataOption questionDataOption = evaluateQuestionModel.questionOptions.get(i);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (CharSequence) questionDataOption.title, evaluateQuestionModel.questionTitle);
                this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_content, (CharSequence) questionDataOption.description, evaluateQuestionModel.questionBody);
            }
        }
        getView().postDelayed(new Runnable() {
            public void run() {
                EvaluateQuestionView.this.presenter.refreshXpanel();
            }
        }, 1000);
    }

    public void showError() {
        this.f13517f.setVisibility(0);
        this.f13515d.setVisibility(4);
        this.f13514c.setTextViewText((int) R.id.g_xp_evaluate_question_view_title, (int) R.string.GR_Feedback_2020_uploadFail);
    }

    public void hideError() {
        this.f13517f.setVisibility(8);
        this.f13515d.setVisibility(0);
    }

    /* renamed from: a */
    private List<EvaluateQuestionItemModel> m9268a(EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        if (evaluateQuestionModel.style == 0) {
            if (evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() > 0) {
                for (UnevaluatedViewModel.QuestionDataOption next : evaluateQuestionModel.questionOptions) {
                    arrayList.add(m9265a(next.iconUrl, next.text, false));
                }
            } else if (evaluateQuestionModel.answers != null && evaluateQuestionModel.answers.length > 0 && evaluateQuestionModel.answerState != null && evaluateQuestionModel.answerState.length > 0) {
                for (String a : evaluateQuestionModel.answers) {
                    arrayList.add(m9265a("", a, false));
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private EvaluateQuestionItemModel m9265a(String str, String str2, boolean z) {
        return new EvaluateQuestionItemModel(str, str2, z);
    }

    /* renamed from: b */
    private void m9272b(EvaluateQuestionModel evaluateQuestionModel) {
        if (evaluateQuestionModel == null) {
            return;
        }
        if ((evaluateQuestionModel.questionOptions != null && evaluateQuestionModel.questionOptions.size() >= 3) || (evaluateQuestionModel.answers != null && evaluateQuestionModel.answers.length >= 3)) {
            evaluateQuestionModel.isVertical = true;
        }
    }

    public void closeDrawer() {
        GXPEvaluateTipPayDrawer gXPEvaluateTipPayDrawer = this.f13519h;
        if (gXPEvaluateTipPayDrawer != null && gXPEvaluateTipPayDrawer.isShowing()) {
            this.f13519h.dismiss();
        }
    }
}

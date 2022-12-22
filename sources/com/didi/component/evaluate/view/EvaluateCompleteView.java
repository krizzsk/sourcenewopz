package com.didi.component.evaluate.view;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.component.evaluate.util.ViewUtil;
import com.didi.component.evaluate.view.IEvaluateView;
import com.didi.component.evaluate.widget.CommentView;
import com.didi.component.evaluate.widget.EvaluateTagListView;
import com.didi.travel.psnger.model.response.CarTipInfo;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;

public class EvaluateCompleteView extends AbsEvaluateView {

    /* renamed from: a */
    private TextView f13329a;

    /* renamed from: b */
    private String f13330b;

    /* renamed from: c */
    private View f13331c;

    public void onAdd() {
    }

    public void onContentChange(CharSequence charSequence) {
    }

    public void onPause() {
    }

    public void onRemove() {
    }

    public void onResume() {
    }

    public void onStarChanged(int i) {
    }

    public void onTagSelectChange(View view, EvaluateTag evaluateTag, boolean z) {
    }

    public void onTouchWhenIntercept() {
    }

    public void setEvaluateListener(IEvaluateView.EvaluateListener evaluateListener) {
    }

    public void setOnCancelListener(IEvaluateView.OnCancelListener onCancelListener) {
    }

    public void setTagTitle(String str, String str2) {
    }

    public void showSubmitFail() {
    }

    public void showSubmitSuccess() {
    }

    public EvaluateCompleteView(Activity activity) {
        super(activity);
        this.mFiveStarEvaluatedView.setEnable(false);
        LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.mFiveStarEvaluatedView.getLayoutParams();
        layoutParams.setMargins(0, 0, 0, (int) activity.getResources().getDimension(R.dimen._15dip));
        this.mFiveStarEvaluatedView.setLayoutParams(layoutParams);
    }

    /* access modifiers changed from: protected */
    public void init() {
        super.init();
        this.f13329a = (TextView) findView(R.id.tv_tip);
        this.f13331c = findView(R.id.comment_area_margin);
        this.mIdentity.hideTipsView();
        hideContainer();
    }

    public void setTags(List<EvaluateTag> list) {
        if (!CollectionUtils.isEmpty((Collection) list)) {
            this.mTagList = list;
            if (this.mTagListView == null) {
                m9132a(true);
            } else {
                this.mTagListView.updateEvaluateTags(this.mTagList);
            }
        }
    }

    /* renamed from: a */
    private void m9132a(boolean z) {
        if (z) {
            if (this.mTagArea == null) {
                this.mTagArea = this.mTagAreaStub.inflate();
                this.mTagView = findView(R.id.oc_evaluate_tag_view);
                this.mTagListView = (EvaluateTagListView) this.mTagArea.findViewById(R.id.oc_evaluate_tags_view);
                if (this.mAbsEvaluatePresenter != null) {
                    this.mTagListView.setFlowStyle(this.mAbsEvaluatePresenter.isShowTagInFlow());
                }
            } else {
                this.mTagArea.setVisibility(0);
            }
            if (this.mTagList != null) {
                this.mTagListView.updateEvaluateTags(this.mTagList);
            }
            this.mTagListView.setTagSelectable(false);
            this.f13331c.setVisibility(0);
        } else if (this.mTagView != null) {
            this.mTagView.setVisibility(8);
        }
    }

    public void setCommentContent(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13330b = str;
            if (this.mCommentView == null) {
                setCommentAreaVisibility(true);
            } else {
                this.mCommentView.setContent(this.f13330b);
            }
        }
    }

    public void setCommentAreaVisibility(boolean z) {
        if (z) {
            if (this.mCommentView == null) {
                this.mCommentViewStub.inflate();
                this.mCommentView = (CommentView) findView(R.id.oc_evaluate_comment_area);
            } else {
                this.mCommentView.setVisibility(0);
            }
            this.mCommentView.setContent(this.f13330b);
        } else if (this.mCommentView != null) {
            this.mCommentView.setVisibility(8);
        }
    }

    public void close() {
        if (this.mOnCloseListener != null) {
            this.mOnCloseListener.onClose();
        }
    }

    public void closeWithoutOmega() {
        if (this.mOnCloseListener != null) {
            this.mOnCloseListener.onCloseWithOutOmega();
        }
    }

    public void refreshThanksTipData(CarTipInfo carTipInfo) {
        if (carTipInfo == null || !carTipInfo.isShow() || !carTipInfo.isPay()) {
            return;
        }
        if (TextUtils.isEmpty(carTipInfo.msg)) {
            this.f13329a.setVisibility(8);
            return;
        }
        this.f13329a.setVisibility(0);
        this.f13329a.setText(ViewUtil.handleTipString(this.mContext, ViewUtil.handleTipSymbolString(this.mContext, carTipInfo.msg)));
    }

    public void onCloseBtnClick() {
        close();
    }
}

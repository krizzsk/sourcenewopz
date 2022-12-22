package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;

public abstract class AbsBaseTagLayout extends FrameLayout {
    protected boolean mEnable = true;
    protected EvaluateTag mEvaluateTagModel;
    protected boolean mIsSelected = false;
    protected boolean mLoading = false;
    protected int mLoadingWidth;
    protected View.OnClickListener mOnClickListener;
    protected CarNoEvaluateData.EvaluateTagImpl mTagModel;

    public void setMarginRight(int i) {
    }

    public AbsBaseTagLayout(Context context) {
        super(context);
    }

    public AbsBaseTagLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public AbsBaseTagLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public void setTagModel(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl) {
        this.mTagModel = evaluateTagImpl;
    }

    public void setTagModel(EvaluateTag evaluateTag) {
        this.mEvaluateTagModel = evaluateTag;
    }

    public CarNoEvaluateData.EvaluateTagImpl getTagModel() {
        return this.mTagModel;
    }

    public boolean isSelected() {
        return this.mIsSelected;
    }

    public void setEnable(boolean z) {
        this.mEnable = z;
    }

    public void setLoading(boolean z) {
        this.mLoading = true;
    }

    public void setLoadingWidth(int i) {
        this.mLoadingWidth = i;
    }

    public void setOnClickListener(View.OnClickListener onClickListener) {
        this.mOnClickListener = onClickListener;
    }
}

package com.didi.component.evaluate.view.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.travel.psnger.model.response.CarNoEvaluateData;
import com.taxis99.R;

public class EvaluateTagTextLayout extends AbsBaseTagLayout {

    /* renamed from: a */
    private ViewGroup f13413a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public TextView f13414b;

    /* renamed from: c */
    private View f13415c;

    public EvaluateTagTextLayout(Context context) {
        super(context);
        m9194a();
    }

    public EvaluateTagTextLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9194a();
    }

    public EvaluateTagTextLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9194a();
    }

    public void setTagModel(CarNoEvaluateData.EvaluateTagImpl evaluateTagImpl) {
        super.setTagModel(evaluateTagImpl);
        if (evaluateTagImpl != null) {
            setText(evaluateTagImpl.getText());
        }
    }

    public void setTagModel(EvaluateTag evaluateTag) {
        super.setTagModel(evaluateTag);
        if (evaluateTag != null) {
            setText(evaluateTag.getText());
        }
    }

    /* renamed from: a */
    private void m9194a() {
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.global_new_evaluate_tag_text_layout, this, true);
        this.f13413a = viewGroup;
        TextView textView = (TextView) viewGroup.findViewById(R.id.tag_text_view);
        this.f13414b = textView;
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (EvaluateTagTextLayout.this.mEnable) {
                    EvaluateTagTextLayout evaluateTagTextLayout = EvaluateTagTextLayout.this;
                    evaluateTagTextLayout.mIsSelected = !evaluateTagTextLayout.mIsSelected;
                    EvaluateTagTextLayout.this.f13414b.setSelected(EvaluateTagTextLayout.this.mIsSelected);
                    if (EvaluateTagTextLayout.this.mOnClickListener != null) {
                        EvaluateTagTextLayout.this.mOnClickListener.onClick(EvaluateTagTextLayout.this.f13414b);
                    }
                }
            }
        });
        this.f13415c = this.f13413a.findViewById(R.id.tag_text_loading);
    }

    private void setText(String str) {
        this.f13414b.setText(str);
    }

    public void setSelected(boolean z) {
        this.f13414b.setSelected(z);
        this.mIsSelected = z;
    }

    public View getView() {
        return this.f13413a;
    }

    public void setLoading(boolean z) {
        super.setLoading(z);
        if (z) {
            this.f13415c.setVisibility(0);
            this.f13414b.setVisibility(8);
            return;
        }
        this.f13415c.setVisibility(8);
        this.f13414b.setVisibility(0);
    }

    public void setLoadingWidth(int i) {
        this.mLoadingWidth = i;
        this.f13415c.getLayoutParams().width = i;
    }
}

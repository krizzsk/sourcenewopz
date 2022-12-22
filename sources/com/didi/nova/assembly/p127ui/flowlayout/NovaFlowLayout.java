package com.didi.nova.assembly.p127ui.flowlayout;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import com.didi.autotracker.AutoTrackHelper;
import java.util.List;

/* renamed from: com.didi.nova.assembly.ui.flowlayout.NovaFlowLayout */
public class NovaFlowLayout extends FlowLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public View f29272a;
    public NovaFlowLayoutClickListener mCLickListener;

    /* renamed from: com.didi.nova.assembly.ui.flowlayout.NovaFlowLayout$NovaFlowLayoutClickListener */
    public interface NovaFlowLayoutClickListener<T> {
        void onClick(int i, T t, T t2);
    }

    public /* bridge */ /* synthetic */ ViewGroup.LayoutParams generateLayoutParams(AttributeSet attributeSet) {
        return super.generateLayoutParams(attributeSet);
    }

    public /* bridge */ /* synthetic */ int getChildSpacing() {
        return super.getChildSpacing();
    }

    public /* bridge */ /* synthetic */ int getChildSpacingForLastRow() {
        return super.getChildSpacingForLastRow();
    }

    public /* bridge */ /* synthetic */ int getDataMaxRows() {
        return super.getDataMaxRows();
    }

    public /* bridge */ /* synthetic */ int getHeightForRow(int i) {
        return super.getHeightForRow(i);
    }

    public /* bridge */ /* synthetic */ int getMaxRows() {
        return super.getMaxRows();
    }

    public /* bridge */ /* synthetic */ float getRowSpacing() {
        return super.getRowSpacing();
    }

    public /* bridge */ /* synthetic */ int getViewCountForRow(int i) {
        return super.getViewCountForRow(i);
    }

    public /* bridge */ /* synthetic */ int getVisibleViewCount() {
        return super.getVisibleViewCount();
    }

    public /* bridge */ /* synthetic */ boolean isFlow() {
        return super.isFlow();
    }

    public /* bridge */ /* synthetic */ void setChildSpacing(int i) {
        super.setChildSpacing(i);
    }

    public /* bridge */ /* synthetic */ void setChildSpacingForLastRow(int i) {
        super.setChildSpacingForLastRow(i);
    }

    public /* bridge */ /* synthetic */ void setFlow(boolean z) {
        super.setFlow(z);
    }

    public /* bridge */ /* synthetic */ void setMaxRows(int i) {
        super.setMaxRows(i);
    }

    public /* bridge */ /* synthetic */ void setRowSpacing(float f) {
        super.setRowSpacing(f);
    }

    public NovaFlowLayout(Context context) {
        super(context);
    }

    public NovaFlowLayout(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public void addView(List<? extends View> list) {
        removeAllViews();
        for (int i = 0; i < list.size(); i++) {
            View view = (View) list.get(i);
            view.setTag(Integer.valueOf(i));
            addView(view);
            view.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (NovaFlowLayout.this.mCLickListener != null) {
                        NovaFlowLayout.this.mCLickListener.onClick(((Integer) view.getTag()).intValue(), view, NovaFlowLayout.this.f29272a);
                    }
                }
            });
        }
    }

    public void setClickListener(NovaFlowLayoutClickListener novaFlowLayoutClickListener) {
        this.mCLickListener = novaFlowLayoutClickListener;
    }

    public void setEnabled(int i, boolean z) {
        View viewByIndex = getViewByIndex(i);
        if (viewByIndex != null) {
            viewByIndex.setEnabled(z);
        }
    }

    public void setChecked(int i, boolean z) {
        View viewByIndex = getViewByIndex(i);
        if (viewByIndex != null && (viewByIndex instanceof CheckedTextView)) {
            ((CheckedTextView) viewByIndex).setChecked(z);
        }
        if (z && viewByIndex != null) {
            this.f29272a = viewByIndex;
        }
    }

    public View getViewByIndex(int i) {
        return getChildAt(i);
    }
}

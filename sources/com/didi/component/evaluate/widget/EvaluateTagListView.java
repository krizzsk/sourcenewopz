package com.didi.component.evaluate.widget;

import android.content.Context;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.widget.AbsRecyclerAdapter;
import com.didi.component.common.widget.AbsViewBinder;
import com.didi.component.evaluate.model.EvaluateTag;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.google.android.flexbox.FlexboxLayoutManager;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class EvaluateTagListView extends RecyclerView {

    /* renamed from: a */
    private static final String f13446a = "EvaluateTag";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public OnTagSelectChangeListener f13447b;

    /* renamed from: c */
    private EvaluateTagListAdapter f13448c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f13449d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f13450e = false;
    protected final Logger mLogger = LoggerFactory.getLogger(getClass());

    public interface OnTagSelectChangeListener {
        void onTagSelectChange(View view, EvaluateTag evaluateTag, boolean z);
    }

    public EvaluateTagListView(Context context) {
        super(context);
        m9210a();
    }

    public EvaluateTagListView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9210a();
    }

    public EvaluateTagListView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9210a();
    }

    public void updateEvaluateTags(List<EvaluateTag> list) {
        this.f13448c.update(m9209a(list));
    }

    /* renamed from: a */
    private List<EvaluateTagWrapper> m9209a(List<EvaluateTag> list) {
        ArrayList arrayList = new ArrayList();
        for (EvaluateTag evaluateTagWrapper : list) {
            arrayList.add(new EvaluateTagWrapper(evaluateTagWrapper));
        }
        return arrayList;
    }

    /* renamed from: a */
    private void m9210a() {
        setFlowStyle(false);
        EvaluateTagListAdapter evaluateTagListAdapter = new EvaluateTagListAdapter(getContext());
        this.f13448c = evaluateTagListAdapter;
        setAdapter(evaluateTagListAdapter);
        addItemDecoration(new SpaceItemDecoration(UiUtils.dip2px(getContext(), 10.0f)));
        setOverScrollMode(2);
    }

    public void setFlowStyle(boolean z) {
        if (this.f13450e != z) {
            this.f13450e = z;
            if (z) {
                C56331 r3 = new FlexboxLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return false;
                    }
                };
                r3.setFlexDirection(0);
                r3.setFlexWrap(1);
                r3.setJustifyContent(0);
                setLayoutManager(r3);
            } else {
                setLayoutManager(new LinearLayoutManager(getContext()) {
                    public boolean canScrollVertically() {
                        return false;
                    }
                });
            }
            EvaluateTagListAdapter evaluateTagListAdapter = this.f13448c;
            if (evaluateTagListAdapter != null) {
                evaluateTagListAdapter.refresh();
            }
        }
    }

    public List<EvaluateTag> getSelectedTags() {
        List<EvaluateTagWrapper> data = this.f13448c.getData();
        ArrayList arrayList = new ArrayList();
        for (EvaluateTagWrapper evaluateTagWrapper : data) {
            if (evaluateTagWrapper.isSelected()) {
                arrayList.add(evaluateTagWrapper.mTag);
            }
        }
        return arrayList;
    }

    public void setTagSelectable(boolean z) {
        this.f13449d = z;
    }

    private class EvaluateTagListAdapter extends AbsRecyclerAdapter<EvaluateTagItemHolder, EvaluateTagWrapper> {
        public EvaluateTagListAdapter(Context context) {
            super(context);
        }

        /* access modifiers changed from: protected */
        public EvaluateTagItemHolder createViewHolder(View view) {
            return new EvaluateTagItemHolder(view);
        }

        /* access modifiers changed from: protected */
        public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
            View view;
            if (EvaluateTagListView.this.f13449d) {
                view = layoutInflater.inflate(R.layout.global_evaluate_item_view, viewGroup, false);
            } else {
                view = layoutInflater.inflate(R.layout.global_evaluate_item_non_select_view, viewGroup, false);
            }
            ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
            layoutParams.width = EvaluateTagListView.this.f13450e ? -2 : -1;
            view.setLayoutParams(layoutParams);
            return view;
        }
    }

    private class EvaluateTagItemHolder extends AbsViewBinder<EvaluateTagWrapper> {
        private TextViewAccessibleForCheck mTextView;

        public EvaluateTagItemHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mTextView = (TextViewAccessibleForCheck) getView(R.id.oc_evaluate_tag_text);
        }

        public void bind(EvaluateTagWrapper evaluateTagWrapper) {
            if (evaluateTagWrapper != null && evaluateTagWrapper.mTag != null && this.mTextView != null) {
                Logger logger = EvaluateTagListView.this.mLogger;
                logger.info("text : " + evaluateTagWrapper.getText(), new Object[0]);
                this.mTextView.setText(evaluateTagWrapper.getText());
                this.mTextView.setSelected(evaluateTagWrapper.isSelected());
            }
        }

        /* access modifiers changed from: protected */
        public void onViewClick(View view, EvaluateTagWrapper evaluateTagWrapper) {
            if (EvaluateTagListView.this.f13449d) {
                boolean z = !evaluateTagWrapper.isSelected();
                EvaluateTagListView.this.mLogger.info("set selected " + z, new Object[0]);
                evaluateTagWrapper.setSelected(z);
                this.mTextView.setSelected(z);
                if (EvaluateTagListView.this.f13447b != null) {
                    EvaluateTagListView.this.f13447b.onTagSelectChange(this.mTextView, evaluateTagWrapper.mTag, z);
                }
            }
        }
    }

    private class EvaluateTagWrapper {
        private boolean mSelected;
        /* access modifiers changed from: private */
        public EvaluateTag mTag;

        public EvaluateTagWrapper(EvaluateTag evaluateTag) {
            this.mTag = evaluateTag;
        }

        public String getText() {
            return this.mTag.getText();
        }

        public long getId() {
            return this.mTag.getId();
        }

        public void setSelected(boolean z) {
            this.mSelected = z;
            Logger logger = EvaluateTagListView.this.mLogger;
            logger.info("set selected " + z, new Object[0]);
        }

        public boolean isSelected() {
            return this.mSelected;
        }
    }

    public void clear() {
        this.f13448c.clear();
    }

    public void setOnTagSelectChangeListener(OnTagSelectChangeListener onTagSelectChangeListener) {
        this.f13447b = onTagSelectChangeListener;
    }

    class SpaceItemDecoration extends RecyclerView.ItemDecoration {
        int mSpace;

        public void getItemOffsets(Rect rect, View view, RecyclerView recyclerView, RecyclerView.State state) {
            super.getItemOffsets(rect, view, recyclerView, state);
            int i = 0;
            rect.left = 0;
            rect.top = 0;
            if (EvaluateTagListView.this.f13450e) {
                i = this.mSpace;
            }
            rect.right = i;
            rect.bottom = this.mSpace;
        }

        public SpaceItemDecoration(int i) {
            this.mSpace = i;
        }
    }
}

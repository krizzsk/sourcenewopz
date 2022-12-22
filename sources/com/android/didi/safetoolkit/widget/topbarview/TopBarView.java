package com.android.didi.safetoolkit.widget.topbarview;

import android.content.Context;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewTreeObserver;
import android.widget.RelativeLayout;
import com.android.didi.safetoolkit.MyObserver;
import com.android.didi.safetoolkit.widget.topbarview.adapter.BaseTopBarAdapter;

public class TopBarView extends RelativeLayout implements MyObserver {
    public static final int CENTER_VIEW_INDEX = 1;
    public static final int LEFT_VIEW_INDEX = 0;
    public static final int RIGHT_VIEW_INDEX = 2;
    /* access modifiers changed from: private */
    public BaseTopBarAdapter adapter = null;
    private View centerView = null;
    private View leftView = null;
    private View.OnClickListener mOnCenterClickHolder = null;
    private View.OnClickListener mOnLeftClickHolder = null;
    private View.OnClickListener mOnRightClickHolder = null;
    private View rightView = null;

    public TopBarView(Context context) {
        super(context);
    }

    public TopBarView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
    }

    public TopBarView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
    }

    public TopBarView(Context context, AttributeSet attributeSet, int i, int i2) {
        super(context, attributeSet, i, i2);
    }

    public void setAdapter(BaseTopBarAdapter baseTopBarAdapter) {
        BaseTopBarAdapter baseTopBarAdapter2 = this.adapter;
        if (baseTopBarAdapter2 != null) {
            baseTopBarAdapter2.unregisterObserver(this);
        }
        this.adapter = baseTopBarAdapter;
        if (baseTopBarAdapter != null) {
            baseTopBarAdapter.registerObserver(this);
        }
        getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
            public void onGlobalLayout() {
                TopBarView.this.getViewTreeObserver().removeGlobalOnLayoutListener(this);
                if (TopBarView.this.adapter != null) {
                    TopBarView.this.adapter.notifyDataSetChanged();
                }
            }
        });
        requestLayout();
        resetChildViews();
    }

    public BaseTopBarAdapter getAdapter() {
        return this.adapter;
    }

    public void onChanged(int i) {
        View view;
        View view2;
        if (getChildCount() > 3) {
            resetChildViews();
            i = -1;
        }
        View view3 = null;
        if (i == 0) {
            view2 = null;
            view3 = this.adapter.getLeftView(this.leftView, this);
            view = null;
        } else if (i == 1) {
            view = this.adapter.getCenterView(this.centerView, this);
            view2 = null;
        } else if (i != 2) {
            view3 = this.adapter.getLeftView(this.leftView, this);
            view = this.adapter.getCenterView(this.centerView, this);
            view2 = this.adapter.getRightView(this.rightView, this);
        } else {
            view2 = this.adapter.getRightView(this.rightView, this);
            view = null;
        }
        if (this.leftView == null && view3 != null) {
            this.leftView = view3;
            addView(view3, getChildParams(view3, 0));
        }
        if (this.centerView == null && view != null) {
            this.centerView = view;
            addView(view, getChildParams(view, 1));
        }
        if (this.rightView == null && view2 != null) {
            this.rightView = view2;
            addView(view2, getChildParams(view2, 2));
        }
        coverClickListener();
    }

    private void coverClickListener() {
        View view;
        View view2;
        View view3;
        View.OnClickListener onClickListener = this.mOnLeftClickHolder;
        if (!(onClickListener == null || (view3 = this.leftView) == null)) {
            view3.setOnClickListener(onClickListener);
        }
        View.OnClickListener onClickListener2 = this.mOnCenterClickHolder;
        if (!(onClickListener2 == null || (view2 = this.centerView) == null)) {
            view2.setOnClickListener(onClickListener2);
        }
        View.OnClickListener onClickListener3 = this.mOnRightClickHolder;
        if (onClickListener3 != null && (view = this.rightView) != null) {
            view.setOnClickListener(onClickListener3);
        }
    }

    public void onInvalidated(int i) {
        if (i == 0) {
            View view = this.leftView;
            if (view != null) {
                view.invalidate();
            }
        } else if (i == 1) {
            View view2 = this.centerView;
            if (view2 != null) {
                view2.invalidate();
            }
        } else if (i != 2) {
            View view3 = this.leftView;
            if (view3 != null) {
                view3.invalidate();
            }
            View view4 = this.centerView;
            if (view4 != null) {
                view4.invalidate();
            }
            View view5 = this.rightView;
            if (view5 != null) {
                view5.invalidate();
            }
        } else {
            View view6 = this.rightView;
            if (view6 != null) {
                view6.invalidate();
            }
        }
        invalidate();
    }

    private RelativeLayout.LayoutParams getChildParams(View view, int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) view.getLayoutParams();
        if (layoutParams == null) {
            layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        }
        if (i == 0) {
            layoutParams.addRule(9);
            layoutParams.addRule(15);
            view.setPadding(dip2px(15), 0, dip2px(15), 0);
        } else if (i == 1) {
            layoutParams.addRule(13);
        } else if (i == 2) {
            layoutParams.addRule(11);
            layoutParams.addRule(15);
            view.setPadding(dip2px(15), 0, dip2px(15), 0);
        }
        return layoutParams;
    }

    private void resetChildViews() {
        removeAllViews();
        this.leftView = null;
        this.centerView = null;
        this.rightView = null;
    }

    private int dip2px(int i) {
        if (getContext() == null || getResources() == null) {
            return 0;
        }
        return (int) TypedValue.applyDimension(1, (float) i, getResources().getDisplayMetrics());
    }

    public void setOnLeftClickListener(View.OnClickListener onClickListener) {
        this.mOnLeftClickHolder = onClickListener;
        View view = this.leftView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnCenterClickListener(View.OnClickListener onClickListener) {
        this.mOnCenterClickHolder = onClickListener;
        View view = this.centerView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public void setOnRightClickListener(View.OnClickListener onClickListener) {
        this.mOnRightClickHolder = onClickListener;
        View view = this.rightView;
        if (view != null) {
            view.setOnClickListener(onClickListener);
        }
    }

    public View getLeftView() {
        return this.leftView;
    }

    public View getCenterView() {
        return this.centerView;
    }

    public View getRightView() {
        return this.rightView;
    }
}

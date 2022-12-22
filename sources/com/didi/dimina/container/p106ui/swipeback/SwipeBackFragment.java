package com.didi.dimina.container.p106ui.swipeback;

import android.app.Activity;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import com.didi.dimina.container.p106ui.swipeback.SwipeBackLayout;
import com.taxis99.R;

/* renamed from: com.didi.dimina.container.ui.swipeback.SwipeBackFragment */
public class SwipeBackFragment extends Fragment {

    /* renamed from: a */
    private static final String f17797a = "SWIPEBACKFRAGMENT_STATE_SAVE_IS_HIDDEN";
    protected Activity _mActivity;

    /* renamed from: b */
    boolean f17798b = false;

    /* renamed from: c */
    private SwipeBackLayout f17799c;

    /* renamed from: d */
    private Animation f17800d;

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        this._mActivity = activity;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        if (bundle != null) {
            boolean z = bundle.getBoolean(f17797a);
            FragmentTransaction beginTransaction = getFragmentManager().beginTransaction();
            if (z) {
                beginTransaction.hide(this);
            } else {
                beginTransaction.show(this);
            }
            beginTransaction.commit();
        }
        this.f17800d = AnimationUtils.loadAnimation(getActivity(), R.anim.dimina_no_anim);
        m13293a();
    }

    public void onSaveInstanceState(Bundle bundle) {
        super.onSaveInstanceState(bundle);
        bundle.putBoolean(f17797a, isHidden());
    }

    /* renamed from: a */
    private void m13293a() {
        this.f17799c = new SwipeBackLayout(getActivity());
        this.f17799c.setLayoutParams(new ViewGroup.LayoutParams(-1, -1));
        this.f17799c.setBackgroundColor(0);
    }

    /* access modifiers changed from: protected */
    public View attachToSwipeBack(View view) {
        this.f17799c.attachToFragment(this, view);
        return this.f17799c;
    }

    /* access modifiers changed from: protected */
    public View attachToSwipeBack(View view, SwipeBackLayout.EdgeLevel edgeLevel) {
        this.f17799c.attachToFragment(this, view);
        this.f17799c.setEdgeLevel(edgeLevel);
        return this.f17799c;
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(SwipeBackLayout.EdgeLevel edgeLevel) {
        this.f17799c.setEdgeLevel(edgeLevel);
    }

    /* access modifiers changed from: protected */
    public void setEdgeLevel(int i) {
        this.f17799c.setEdgeLevel(i);
    }

    public void onHiddenChanged(boolean z) {
        SwipeBackLayout swipeBackLayout;
        super.onHiddenChanged(z);
        if (z && (swipeBackLayout = this.f17799c) != null) {
            swipeBackLayout.hiddenPreView();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        SwipeBackLayout swipeBackLayout = this.f17799c;
        if (swipeBackLayout != null) {
            swipeBackLayout.hiddenPreView();
        }
    }

    public void onActivityCreated(Bundle bundle) {
        super.onActivityCreated(bundle);
        View view = getView();
        m13294a(view);
        if (view != null) {
            view.setClickable(true);
        }
    }

    /* renamed from: a */
    private void m13294a(View view) {
        if (view instanceof SwipeBackLayout) {
            m13295b(((SwipeBackLayout) view).getChildAt(0));
        } else {
            m13295b(view);
        }
    }

    /* renamed from: b */
    private void m13295b(View view) {
        if (view != null && view.getBackground() == null) {
            int i = 0;
            Activity activity = this._mActivity;
            if (activity instanceof SwipeBackActivity) {
                i = ((SwipeBackActivity) activity).mo56703b();
            }
            if (i == 0) {
                view.setBackgroundResource(getWindowBackground());
            } else {
                view.setBackgroundResource(i);
            }
        }
    }

    public Animation onCreateAnimation(int i, boolean z, int i2) {
        if (this.f17798b) {
            return this.f17800d;
        }
        return super.onCreateAnimation(i, z, i2);
    }

    /* access modifiers changed from: protected */
    public int getWindowBackground() {
        TypedArray obtainStyledAttributes = getActivity().getTheme().obtainStyledAttributes(new int[]{16842836});
        int resourceId = obtainStyledAttributes.getResourceId(0, 0);
        obtainStyledAttributes.recycle();
        return resourceId;
    }

    public SwipeBackLayout getSwipeBackLayout() {
        return this.f17799c;
    }

    public void setSwipeBackEnable(boolean z) {
        this.f17799c.setEnableGesture(z);
    }
}

package com.didi.dimina.starbox.p107ui.base;

import android.app.Activity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;
import androidx.fragment.app.Fragment;
import com.didi.sdk.apm.SystemUtils;

/* renamed from: com.didi.dimina.starbox.ui.base.BaseFragment */
public class BaseFragment extends Fragment {

    /* renamed from: a */
    private View f18112a;

    /* renamed from: b */
    private int f18113b;

    /* access modifiers changed from: protected */
    public boolean interceptTouchEvents() {
        return false;
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressed() {
        return false;
    }

    /* access modifiers changed from: protected */
    public int onRequestLayout() {
        return 0;
    }

    public final <T extends View> T findViewById(int i) {
        return this.f18112a.findViewById(i);
    }

    public final View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View view;
        int onRequestLayout = onRequestLayout();
        if (onRequestLayout > 0) {
            this.f18112a = layoutInflater.inflate(onRequestLayout, viewGroup, false);
        }
        if (this.f18112a == null) {
            this.f18112a = onCreateView(bundle);
        }
        if (interceptTouchEvents() && (view = this.f18112a) != null) {
            view.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
        return this.f18112a;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        m13526a();
        try {
            if (view.getContext() instanceof Activity) {
                ((Activity) view.getContext()).getWindow().getDecorView().requestLayout();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* renamed from: a */
    private void m13526a() {
        View view;
        View view2 = this.f18112a;
        if (view2 != null && (view = (View) view2.getParent()) != null) {
            this.f18113b = view.getId();
        }
    }

    /* access modifiers changed from: protected */
    public View onCreateView(Bundle bundle) {
        return this.f18112a;
    }

    public int getContainer() {
        if (this.f18113b == 0) {
            m13526a();
        }
        return this.f18113b;
    }

    public void showToast(CharSequence charSequence) {
        SystemUtils.showToast(Toast.makeText(getContext(), charSequence, 0));
    }

    public void showContent(Class<? extends BaseFragment> cls, Bundle bundle) {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.showContent(cls, bundle);
        }
    }

    public void finish() {
        BaseActivity baseActivity = (BaseActivity) getActivity();
        if (baseActivity != null) {
            baseActivity.doBack(this);
        }
    }

    public void showContent(Class<? extends BaseFragment> cls) {
        showContent(cls, (Bundle) null);
    }

    public void onDestroyView() {
        super.onDestroyView();
    }
}

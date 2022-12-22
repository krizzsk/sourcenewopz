package com.didi.component.safetoolkit.views;

import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.view.SimplePopupBase;
import com.taxis99.R;

public class JarvisBeforeAcceptedFragment extends SimplePopupBase {

    /* renamed from: a */
    private TextView f15424a;

    /* renamed from: b */
    private TextView f15425b;

    /* access modifiers changed from: protected */
    public int getLayout() {
        return R.layout.jarvis_fragment;
    }

    public static JarvisBeforeAcceptedFragment newInstance() {
        return new JarvisBeforeAcceptedFragment();
    }

    /* access modifiers changed from: protected */
    public void initView() {
        if (this.mRootView != null) {
            this.f15424a = (TextView) this.mRootView.findViewById(R.id.drawer_title);
            this.f15425b = (TextView) this.mRootView.findViewById(R.id.drawer_btn_got_it);
            this.f15424a.setText(R.string.GRider_Global_Trip_share_czSq);
            this.f15425b.setText(R.string.global_new_guide_ok);
            this.f15425b.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    JarvisBeforeAcceptedFragment.this.dismissAllowingStateLoss();
                }
            });
        }
    }
}

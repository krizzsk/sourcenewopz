package com.didi.component.estimatepass;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.estimatepass.IEstimatePassView;
import com.didi.global.globaluikit.richinfo.LEGORichInfo;
import com.didi.global.globaluikit.toast.LEGOToastHelper;
import com.didi.sdk.app.BusinessContext;
import com.taxis99.R;

public class EstimateView implements View.OnClickListener, IEstimatePassView {

    /* renamed from: a */
    private EstimatePassPresenter f13297a;

    /* renamed from: b */
    private Context f13298b;

    /* renamed from: c */
    private final View f13299c;

    /* renamed from: d */
    private LinearLayout f13300d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final ImageView f13301e = ((ImageView) this.f13299c.findViewById(R.id.estimate_pass_check_iv));

    /* renamed from: f */
    private final TextView f13302f = ((TextView) this.f13299c.findViewById(R.id.estimate_pass_info_tv));

    /* renamed from: g */
    private ImageView f13303g = ((ImageView) this.f13299c.findViewById(R.id.estimate_pass_more_iv));
    /* access modifiers changed from: private */

    /* renamed from: h */
    public IEstimatePassView.OnCheckChangeListener f13304h;

    public EstimateView(BusinessContext businessContext, ViewGroup viewGroup) {
        Context context = businessContext.getContext();
        this.f13298b = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.estimate_pass_layout, viewGroup, false);
        this.f13299c = inflate;
        this.f13300d = (LinearLayout) inflate.findViewById(R.id.estimate_pass_ll);
        this.f13301e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = !EstimateView.this.f13301e.isSelected();
                EstimateView.this.setCheck(z);
                if (EstimateView.this.f13304h != null) {
                    EstimateView.this.f13304h.onCheckChange(z);
                }
            }
        });
        this.f13303g.setOnClickListener(this);
    }

    public void showPassToast(String str) {
        if (!TextUtils.isEmpty(str)) {
            LEGOToastHelper.showShortPosToast(this.f13298b, str);
        }
    }

    public void setOnCheckChangeListener(IEstimatePassView.OnCheckChangeListener onCheckChangeListener) {
        this.f13304h = onCheckChangeListener;
    }

    public View getView() {
        return this.f13299c;
    }

    public void setPresenter(EstimatePassPresenter estimatePassPresenter) {
        this.f13297a = estimatePassPresenter;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.estimate_pass_more_iv) {
            this.f13297a.openPassWebView();
        }
    }

    public void setPassInfo(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.f13302f.setText(str);
        }
    }

    public void setPassRichInfo(LEGORichInfo lEGORichInfo) {
        lEGORichInfo.bindTextView(this.f13302f);
    }

    public void setCheck(boolean z) {
        this.f13301e.setSelected(z);
    }

    public void setCheckBoxVisibility(int i) {
        this.f13301e.setVisibility(i);
    }

    public void setVisibility(int i) {
        this.f13299c.setVisibility(i);
    }

    public void setArrowVisibility(int i) {
        this.f13303g.setVisibility(i);
    }
}

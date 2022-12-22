package com.didi.component.company;

import android.app.Activity;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.util.StringUtil;
import com.didi.component.common.view.GlobalTipsContainer;
import com.didi.component.company.model.CompanyInfo;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.GlobalRichInfo;
import com.taxis99.R;

public class NewCompanyView implements View.OnClickListener, ICompanyView {

    /* renamed from: a */
    private View f12549a;

    /* renamed from: b */
    private TextView f12550b = ((TextView) this.f12549a.findViewById(R.id.tv_global_form_company_label));

    /* renamed from: c */
    private ImageView f12551c = ((ImageView) this.f12549a.findViewById(R.id.iv_global_form_company_icon));

    /* renamed from: d */
    private AbsCompanyPresenter f12552d;

    /* renamed from: e */
    private Activity f12553e;

    /* renamed from: f */
    private GlobalTipsContainer f12554f;

    public void clearTips() {
    }

    public void setCompany(CompanyInfo companyInfo) {
    }

    public void setEnable(boolean z) {
    }

    public NewCompanyView(Activity activity, ViewGroup viewGroup) {
        this.f12553e = activity;
        View inflate = activity.getLayoutInflater().inflate(R.layout.new_global_form_company_select, viewGroup, false);
        this.f12549a = inflate;
        inflate.setOnClickListener(this);
    }

    public View getView() {
        return this.f12549a;
    }

    public void setPresenter(AbsCompanyPresenter absCompanyPresenter) {
        this.f12552d = absCompanyPresenter;
    }

    public void setIcon(String str) {
        if (!StringUtil.isNullOrEmpty(str) && this.f12551c != null) {
            Glide.with(this.f12553e.getApplicationContext()).load(str).into(this.f12551c);
        }
    }

    public void setLabel(String str) {
        TextView textView = this.f12550b;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public void bindRichInfo(GlobalRichInfo globalRichInfo) {
        if (this.f12550b != null && !TextUtils.isEmpty(globalRichInfo.getContent())) {
            globalRichInfo.bindTextView(this.f12550b);
        }
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (!Utils.isFastDoubleClick()) {
            AbsCompanyPresenter absCompanyPresenter = this.f12552d;
            if (absCompanyPresenter != null) {
                absCompanyPresenter.showCompanySelectPage();
            }
            clearTips();
        }
    }
}

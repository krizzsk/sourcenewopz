package com.didi.soda.business.component.search;

import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckedTextView;
import android.widget.TextView;
import com.didi.app.nova.skeleton.mvp.IView;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.nova.assembly.p127ui.flowlayout.NovaFlowLayout;
import com.didi.soda.customer.foundation.util.CollectionsUtil;
import com.didi.soda.customer.service.CustomerServiceManager;
import com.didi.soda.customer.service.IToolsService;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class BusinessHotWordView extends IView<BusinessHotWordPresent> {

    /* renamed from: a */
    private View f39630a;

    /* renamed from: b */
    private NovaFlowLayout f39631b;

    /* renamed from: c */
    private TextView f39632c;

    BusinessHotWordView() {
    }

    public void setHotWords(List<String> list) {
        this.f39631b.removeAllViews();
        if (CollectionsUtil.isEmpty(list)) {
            this.f39632c.setVisibility(8);
            return;
        }
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            if (!TextUtils.isEmpty(next)) {
                arrayList.add(m28189a(next));
            }
        }
        if (CollectionsUtil.isEmpty(arrayList)) {
            this.f39632c.setVisibility(8);
        } else {
            this.f39632c.setVisibility(0);
            this.f39631b.addView(arrayList);
        }
        this.f39631b.setClickListener(new NovaFlowLayout.NovaFlowLayoutClickListener() {
            public final void onClick(int i, Object obj, Object obj2) {
                BusinessHotWordView.this.m28190a(i, obj, obj2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public /* synthetic */ void m28190a(int i, Object obj, Object obj2) {
        ((BusinessHotWordPresent) getPresenter()).clickWord(i);
    }

    /* access modifiers changed from: protected */
    public View inflateView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.customer_component_business_words_layout, viewGroup, true);
        this.f39630a = inflate;
        this.f39631b = (NovaFlowLayout) inflate.findViewById(R.id.customer_search_recommend_flow_layout);
        this.f39632c = (TextView) this.f39630a.findViewById(R.id.customer_tv_search_recommend_title);
        return this.f39630a;
    }

    /* renamed from: a */
    private CheckedTextView m28189a(String str) {
        CheckedTextView checkedTextView = new CheckedTextView(getContext());
        ((IToolsService) CustomerServiceManager.getService(IToolsService.class)).setTypeface(checkedTextView, IToolsService.FontType.LIGHT);
        checkedTextView.setText(str);
        checkedTextView.setTextColor(getContext().getResources().getColor(R.color.rf_color_gery_1_0_000000));
        checkedTextView.setGravity(17);
        checkedTextView.setTextSize(1, 14.0f);
        checkedTextView.setSingleLine();
        checkedTextView.setEllipsize(TextUtils.TruncateAt.END);
        checkedTextView.setBackgroundDrawable(getDrawable(R.drawable.customer_skin_selector_search_tag_ab_bg));
        checkedTextView.setLayoutParams(new ViewGroup.LayoutParams(-2, DisplayUtils.dip2px(getContext(), 30.0f)));
        int dip2px = DisplayUtils.dip2px(getContext(), 12.0f);
        checkedTextView.setPadding(dip2px, 0, dip2px, 0);
        return checkedTextView;
    }
}

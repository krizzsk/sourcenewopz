package com.didi.component.company.select.view;

import android.content.Context;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.widget.AbsRecyclerAdapter;
import com.didi.component.common.widget.AbsViewBinder;
import com.didi.component.company.model.CompanyInfo;
import com.didi.component.company.select.presenter.ICompanySelectPresenter;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.utils.TextUtil;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class CompanyListAdapter extends AbsRecyclerAdapter<CompanyItemHolder, CompanyItem> {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f12565a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICompanySelectPresenter f12566b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public boolean f12567c = true;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public final int f12568d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public final int f12569e;

    public static class CompanyItem {
        public CharSequence desc;
        public CharSequence extend;
        public CharSequence extendTop;
        public String extraDescIcon;
        public String iconUrl;

        /* renamed from: id */
        public String f12570id;
        public boolean isFreePickup;
        public CharSequence name;
        public boolean selected;
    }

    public CompanyListAdapter(Context context) {
        super(context);
        this.f12565a = context;
        this.f12568d = ResourcesHelper.getDimensionPixelSize(context, R.dimen.dp_3);
        this.f12569e = ResourcesHelper.getDimensionPixelSize(this.f12565a, R.dimen.dp_4);
    }

    public void setPresenter(ICompanySelectPresenter iCompanySelectPresenter) {
        this.f12566b = iCompanySelectPresenter;
    }

    public void setShowDefault(boolean z) {
        this.f12567c = z;
    }

    public void update(List<CompanyInfo> list, String str) {
        if (!CollectionUtils.isEmpty((Collection) list)) {
            ArrayList arrayList = new ArrayList();
            for (CompanyInfo next : list) {
                if (next != null) {
                    arrayList.add(m8550a(next, TextUtils.equals(str, next.companyId)));
                }
            }
            update(arrayList);
        }
    }

    /* renamed from: a */
    private CompanyItem m8550a(CompanyInfo companyInfo, boolean z) {
        CompanyItem companyItem = new CompanyItem();
        companyItem.f12570id = companyInfo.companyId;
        companyItem.extend = companyInfo.extend;
        companyItem.extendTop = companyInfo.extendTop;
        companyItem.iconUrl = companyInfo.companyIconUrl;
        companyItem.name = companyInfo.companyName;
        companyItem.desc = companyInfo.companyDesc;
        companyItem.selected = z;
        companyItem.isFreePickup = companyInfo.isPickupSvrFree;
        return companyItem;
    }

    /* access modifiers changed from: protected */
    public CompanyItemHolder createViewHolder(View view) {
        return new CompanyItemHolder(view);
    }

    /* access modifiers changed from: protected */
    public View createView(LayoutInflater layoutInflater, ViewGroup viewGroup, int i) {
        return layoutInflater.inflate(R.layout.global_company_item, viewGroup, false);
    }

    public class CompanyItemHolder extends AbsViewBinder<CompanyItem> {
        private ViewGroup mContentLayout;
        private ImageView mIvCheck;
        private ImageView mIvIcon;
        private TextView mTvDesc;
        private TextView mTvExtend;
        private TextView mTvExtendTop;
        private TextView mTvName;

        public CompanyItemHolder(View view) {
            super(view);
        }

        /* access modifiers changed from: protected */
        public void getViews() {
            this.mContentLayout = (ViewGroup) getView(R.id.rl_global_company_layout);
            this.mIvIcon = (ImageView) getView(R.id.iv_global_company_icon);
            this.mTvName = (TextView) getView(R.id.tv_global_company_name);
            this.mTvDesc = (TextView) getView(R.id.tv_global_company_desc);
            this.mTvExtend = (TextView) getView(R.id.tv_global_company_extend);
            this.mTvExtendTop = (TextView) getView(R.id.tv_global_company_extend_ontop);
            this.mIvCheck = (ImageView) getView(R.id.iv_global_company_check);
        }

        public void bind(CompanyItem companyItem) {
            CompanyListAdapter.this.m8551a(this.mTvExtendTop, companyItem.extendTop);
            CompanyListAdapter.this.m8551a(this.mTvName, companyItem.name);
            int i = 0;
            if (!companyItem.isFreePickup || TextUtil.isEmpty(companyItem.desc)) {
                this.mTvDesc.setBackgroundColor(CompanyListAdapter.this.f12565a.getResources().getColor(R.color.transparent));
                this.mTvDesc.setTextColor(CompanyListAdapter.this.f12565a.getResources().getColor(R.color.global_company_listitem_extra_text));
                this.mTvDesc.setCompoundDrawablesWithIntrinsicBounds(0, 0, 0, 0);
                this.mTvDesc.setPadding(0, 0, 0, 0);
                CompanyListAdapter.this.m8551a(this.mTvDesc, companyItem.desc);
            } else {
                this.mTvDesc.setBackgroundResource(R.drawable.global_company_item_desc_bg);
                this.mTvDesc.setTextColor(CompanyListAdapter.this.f12565a.getResources().getColor(R.color.global_company_listitem_extra_info));
                this.mTvDesc.setCompoundDrawablesWithIntrinsicBounds(R.drawable.company_type_icon_freepickup, 0, 0, 0);
                this.mTvDesc.setCompoundDrawablePadding(CompanyListAdapter.this.f12568d);
                this.mTvDesc.setPadding(CompanyListAdapter.this.f12569e, 0, CompanyListAdapter.this.f12569e, 0);
                CompanyListAdapter.this.m8551a(this.mTvDesc, companyItem.desc);
            }
            CompanyListAdapter.this.m8551a(this.mTvExtend, companyItem.extend);
            this.mIvCheck.setSelected(companyItem.selected);
            if ("0".equals(companyItem.f12570id)) {
                ViewGroup viewGroup = this.mContentLayout;
                if (!CompanyListAdapter.this.f12567c) {
                    i = 8;
                }
                viewGroup.setVisibility(i);
                this.mIvIcon.setImageResource(R.drawable.global_company_icon_any);
            } else if ("1".equalsIgnoreCase(companyItem.f12570id)) {
                ViewGroup viewGroup2 = this.mContentLayout;
                if (!CompanyListAdapter.this.f12567c) {
                    i = 8;
                }
                viewGroup2.setVisibility(i);
                this.mIvIcon.setImageResource(R.drawable.global_company_list_icon_freepickup);
            } else {
                this.mContentLayout.setVisibility(0);
                this.mIvIcon.setImageResource(R.drawable.global_company_icon_default);
                if (!TextUtils.isEmpty(companyItem.iconUrl)) {
                    Glide.with(CompanyListAdapter.this.f12565a).asBitmap().load((Object) new GlideUrl(companyItem.iconUrl)).into(this.mIvIcon);
                }
            }
        }

        /* access modifiers changed from: protected */
        public void onViewClick(View view, CompanyItem companyItem) {
            if (CompanyListAdapter.this.f12566b != null) {
                CompanyInfo companyInfo = new CompanyInfo();
                companyInfo.companyId = companyItem.f12570id;
                companyInfo.companyIconUrl = companyItem.iconUrl;
                companyInfo.companyName = companyItem.name;
                CompanyListAdapter.this.f12566b.onCompanySelected(companyInfo);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m8551a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
            return;
        }
        textView.setVisibility(0);
        textView.setText(charSequence);
    }
}

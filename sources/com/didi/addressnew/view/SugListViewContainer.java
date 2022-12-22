package com.didi.addressnew.view;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.URLSpan;
import android.text.style.UnderlineSpan;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.Scroller;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.address.view.IPoiChangeListener;
import com.didi.address.view.ISugViewController;
import com.didi.addressnew.view.SugTipsDesc;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class SugListViewContainer extends FrameLayout implements ISugViewController {

    /* renamed from: a */
    private ISugContainerOpCallback f7523a;

    /* renamed from: b */
    private Scroller f7524b;

    /* renamed from: c */
    private LinearLayout f7525c;

    /* renamed from: d */
    private SugListView f7526d;

    /* renamed from: e */
    private CommonAddressView f7527e;

    /* renamed from: f */
    private ViewGroup f7528f;

    /* renamed from: g */
    private ViewGroup f7529g;

    /* renamed from: h */
    private ViewGroup f7530h;

    /* renamed from: i */
    private ViewGroup f7531i;

    /* renamed from: j */
    private ViewGroup f7532j;

    /* renamed from: k */
    private int f7533k;

    /* renamed from: l */
    private int f7534l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public View.OnClickListener f7535m;
    public boolean mIsMapDragged;

    /* renamed from: n */
    private boolean f7536n;

    /* renamed from: o */
    private ViewGroup f7537o;

    /* renamed from: p */
    private ViewGroup f7538p;

    public IPoiChangeListener getPoiChangeListener() {
        return null;
    }

    public void onMapScroll() {
    }

    public void onMapTouch() {
    }

    public SugListViewContainer(Context context) {
        this(context, (AttributeSet) null);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public SugListViewContainer(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m4754a();
    }

    public ListView getListView() {
        return this.f7526d;
    }

    public ViewGroup getMapConfirmView() {
        return this.f7532j;
    }

    /* renamed from: a */
    private void m4754a() {
        LayoutInflater.from(getContext()).inflate(R.layout.layout_list_view, this);
        this.f7524b = new Scroller(getContext());
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.lv_root);
        this.f7525c = linearLayout;
        linearLayout.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        SugListView sugListView = (SugListView) findViewById(R.id.lv);
        this.f7526d = sugListView;
        sugListView.setHeaderDividersEnabled(false);
        this.f7526d.setDivider((Drawable) null);
        this.f7526d.setDividerHeight(0);
        ViewGroup viewGroup = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_address_list_header_view, this.f7526d, false);
        this.f7537o = viewGroup;
        this.f7527e = (CommonAddressView) viewGroup.findViewById(R.id.common_address_view);
        this.f7526d.addHeaderView(this.f7537o);
        this.f7528f = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_tips_info_header_view, this.f7526d, false);
        ViewGroup viewGroup2 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_map_confirm_header_view, this.f7526d, false);
        this.f7531i = viewGroup2;
        this.f7532j = (ViewGroup) viewGroup2.findViewById(R.id.layout_item);
        ViewGroup viewGroup3 = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_address_select_poi_view, this.f7526d, false);
        this.f7538p = viewGroup3;
        ViewGroup viewGroup4 = (ViewGroup) viewGroup3.findViewById(R.id.select_poi_layout);
        this.f7529g = viewGroup4;
        viewGroup4.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SugListViewContainer.this.f7535m != null) {
                    SugListViewContainer.this.f7535m.onClick(view);
                }
            }
        });
        this.f7526d.addFooterView(this.f7538p);
        this.f7530h = (ViewGroup) LayoutInflater.from(getContext()).inflate(R.layout.poi_one_address_address_power_by_google_view, this.f7526d, false);
        this.f7526d.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
    }

    public void onSingle(AddressParam addressParam) {
        SugListView sugListView;
        ViewGroup viewGroup;
        if (addressParam != null) {
            if ((addressParam.addressType == 3 || addressParam.addressType == 4 || addressParam.addressType == 5) && (sugListView = this.f7526d) != null && (viewGroup = this.f7537o) != null) {
                sugListView.removeHeaderView(viewGroup);
                requestLayout();
            }
        }
    }

    public Address getTargetAddress() {
        ISugContainerOpCallback iSugContainerOpCallback = this.f7523a;
        if (iSugContainerOpCallback == null) {
            return null;
        }
        return iSugContainerOpCallback.getTargetAddress();
    }

    public void setTopPadding(int i) {
        this.f7533k = i;
        SystemUtils.log(3, "xu", "mMapTopPadding:" + this.f7533k + ", mMapBottomPadding:" + this.f7534l, (Throwable) null, "com.didi.addressnew.view.SugListViewContainer", 179);
    }

    public void showCommonAddressHeaderView(boolean z) {
        this.f7527e.setVisibility(z ? 0 : 8);
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7526d.removeHeaderView(this.f7528f);
        if (tipsInfo != null && !TextUtils.isEmpty(tipsInfo.content)) {
            this.f7526d.addHeaderView(this.f7528f);
            TextView textView = (TextView) this.f7528f.findViewById(R.id.tips_info_view);
            textView.setText(tipsInfo.content);
            if (!TextUtils.isEmpty(tipsInfo.content_color)) {
                textView.setTextColor(Color.parseColor(tipsInfo.content_color));
            }
            if (!TextUtils.isEmpty(tipsInfo.background_color)) {
                View findViewById = this.f7528f.findViewById(R.id.bg);
                GradientDrawable gradientDrawable = (GradientDrawable) findViewById.getBackground();
                gradientDrawable.setColor(Color.parseColor(tipsInfo.background_color));
                findViewById.setBackground(gradientDrawable);
            }
        }
    }

    public void showSelectPoiFooterView(boolean z) {
        this.f7529g.setVisibility(z ? 0 : 8);
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
        this.f7526d.removeHeaderView(this.f7531i);
        if (tipsInfo != null && !TextUtils.isEmpty(tipsInfo.text_desc)) {
            this.f7526d.addHeaderView(this.f7531i);
            TextView textView = (TextView) this.f7531i.findViewById(R.id.tv_map_confirm);
            SugTipsDesc buildSugTipsDesc = SugTipsDesc.buildSugTipsDesc(tipsInfo.text_desc.toString());
            if (!(buildSugTipsDesc == null || buildSugTipsDesc.getText_info() == null)) {
                SugTipsDesc.Info text_info = buildSugTipsDesc.getText_info();
                String text = buildSugTipsDesc.getText();
                Integer valueOf = Integer.valueOf(text_info.getStart());
                Integer valueOf2 = Integer.valueOf(text_info.getLength());
                String color = text_info.getColor();
                int bold = text_info.getBold();
                int through = text_info.getThrough();
                String link = text_info.getLink();
                if (text != null && valueOf.intValue() >= 0 && valueOf2.intValue() >= 0 && valueOf.intValue() + valueOf2.intValue() < text.length()) {
                    SpannableString spannableString = new SpannableString(text);
                    if (bold != 0) {
                        spannableString.setSpan(new StyleSpan(Integer.valueOf(bold).intValue()), valueOf.intValue(), valueOf.intValue() + valueOf2.intValue(), 33);
                    }
                    if (through != 0) {
                        spannableString.setSpan(new UnderlineSpan(), valueOf.intValue(), valueOf.intValue() + valueOf2.intValue(), 33);
                    }
                    if (!TextUtils.isEmpty(link)) {
                        spannableString.setSpan(new URLSpan(link), valueOf.intValue(), valueOf.intValue() + valueOf2.intValue(), 33);
                    }
                    if (!TextUtils.isEmpty(color)) {
                        spannableString.setSpan(new ForegroundColorSpan(Color.parseColor(color)), valueOf.intValue(), valueOf.intValue() + valueOf2.intValue(), 33);
                    }
                    textView.setText(spannableString);
                }
            }
            ImageView imageView = (ImageView) this.f7531i.findViewById(R.id.map_confirm_locate);
            if (i == 1) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(tipsInfo.logo).placeholder((int) R.drawable.sug_icon_map_locate_start)).error((int) R.drawable.sug_icon_map_locate_start)).into(imageView);
            } else if (i == 2) {
                ((RequestBuilder) ((RequestBuilder) Glide.with(getContext()).load(tipsInfo.logo).placeholder((int) R.drawable.sug_icon_map_locate_end)).error((int) R.drawable.sug_icon_map_locate_end)).into(imageView);
            }
        }
    }

    public void setOnSelectPoiFooterViewClickListener(View.OnClickListener onClickListener) {
        this.f7535m = onClickListener;
    }

    public void onlyShowSelectPoiFooterView() {
        this.f7526d.setVisibility(0);
        this.f7526d.setAdapter(new ArrayAdapter(getContext(), 17367043, new String[0]));
        this.f7529g.setVisibility(0);
        this.f7526d.removeFooterView(this.f7530h);
    }

    public void updateLogoView(boolean z, String str, int i, int i2) {
        this.f7526d.removeFooterView(this.f7530h);
        if (z && i > 0 && i2 > 0) {
            TextView textView = (TextView) this.f7530h.findViewById(R.id.powered_by_text);
            textView.setText(String.format(textView.getText().toString(), new Object[]{""}));
            this.f7526d.addFooterView(this.f7530h, (Object) null, false);
        }
    }

    public void setHomeAddress(Address address) {
        this.f7527e.setHome(address);
    }

    public Address getHomeAddress() {
        return this.f7527e.getHomeAddress();
    }

    public void setCompanyAddress(Address address) {
        this.f7527e.setCompany(address);
    }

    public Address getCompanyAddress() {
        return this.f7527e.getCompanyAddress();
    }

    public void setCommonAddressViewClickListener(View.OnClickListener onClickListener, View.OnClickListener onClickListener2, View.OnClickListener onClickListener3) {
        this.f7527e.setHomeClickListener(onClickListener);
        this.f7527e.setCompanyClickListener(onClickListener2);
        this.f7527e.setCommonAddressClickListener(onClickListener3);
    }

    public void onDestory() {
        this.f7536n = true;
    }

    public ArrayList<Integer> getVisibleCountDetail() {
        ArrayList<Integer> arrayList = new ArrayList<>(2);
        arrayList.add(Integer.valueOf(this.f7526d.getFirstVisiblePosition()));
        arrayList.add(Integer.valueOf(this.f7526d.getLastVisiblePosition()));
        return arrayList;
    }

    public int getVisibleCount() {
        ArrayList<Integer> visibleCountDetail = getVisibleCountDetail();
        int headerViewsCount = this.f7526d.getHeaderViewsCount();
        int footerViewsCount = this.f7526d.getFooterViewsCount();
        if (visibleCountDetail.get(0).intValue() < headerViewsCount) {
            visibleCountDetail.set(0, Integer.valueOf(headerViewsCount));
        }
        if (this.f7526d.getCount() - footerViewsCount <= visibleCountDetail.get(1).intValue()) {
            visibleCountDetail.set(1, Integer.valueOf(this.f7526d.getCount() - footerViewsCount));
        }
        return visibleCountDetail.get(1).intValue() - visibleCountDetail.get(0).intValue();
    }

    public void onAddressOcupy(boolean z, boolean z2) {
        View findViewById;
        ViewGroup viewGroup = this.f7538p;
        if (viewGroup != null && (findViewById = viewGroup.findViewById(R.id.line_seperater)) != null) {
            if (z) {
                findViewById.setVisibility(8);
            } else {
                findViewById.setVisibility(0);
            }
        }
    }
}

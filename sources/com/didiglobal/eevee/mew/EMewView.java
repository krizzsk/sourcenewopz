package com.didiglobal.eevee.mew;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didiglobal.common.common.model.EeveeRichText;
import com.didiglobal.common.common.never.component.EeveeIView;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.didiglobal.mew.framework.MUIUtils;
import com.didiglobal.mew.framework.widget.p201ff.MFFCardProperty;
import com.didiglobal.mew.framework.widget.p201ff.MFallsFlow;
import com.didiglobal.mew.framework.widget.p202vp.MVPCardProperty;
import com.didiglobal.mew.framework.widget.p202vp.MViewPager;
import com.taxis99.R;
import java.util.List;

public class EMewView implements EeveeIView<C16805a> {

    /* renamed from: a */
    private View f50072a;

    /* renamed from: b */
    private C16805a f50073b;

    /* renamed from: c */
    private MFallsFlow f50074c;

    /* renamed from: d */
    private MViewPager f50075d;

    /* renamed from: e */
    private Context f50076e;

    public EMewView(Context context) {
        this.f50076e = context;
        View inflate = LayoutInflater.from(context).inflate(R.layout.layout_mew_comp, (ViewGroup) null);
        this.f50072a = inflate;
        this.f50074c = (MFallsFlow) inflate.findViewById(R.id.mew_mff);
        MViewPager mViewPager = new MViewPager(context);
        this.f50075d = mViewPager;
        this.f50074c.initHeaderView(mViewPager);
        this.f50074c.setVisibility(true);
    }

    public View getView() {
        return this.f50072a;
    }

    public void setPresenter(C16805a aVar) {
        this.f50073b = aVar;
        aVar.setIView(this);
    }

    public void setViewPagerTitle(EeveeRichText eeveeRichText, int i) {
        TextView textView = new TextView(this.f50076e);
        if (eeveeRichText != null) {
            EeveeRichTextUtil.setText(textView, eeveeRichText);
        }
        textView.setTextSize(20.0f);
        textView.setTextColor(-16777216);
        textView.setTypeface(Typeface.defaultFromStyle(1));
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(13);
        textView.setLayoutParams(layoutParams);
        this.f50075d.setViewPagerExtView(textView, MUIUtils.getStatusBarHeight(this.f50076e) + MUIUtils.dip2pxInt(this.f50076e, 20.0f));
    }

    public void pagerSetData(List<MVPCardProperty> list) {
        this.f50075d.setData(list);
    }

    public void flowSetData(List<MFFCardProperty> list) {
        this.f50074c.setData(list);
    }

    public void setOverlapSpace(int i) {
        this.f50074c.setOverlapSpace(i);
    }

    public void setListViewElevation(int i, int i2) {
        this.f50074c.setListViewElevation(i, i2);
    }

    public void setAlignOrientation(int i) {
        if (i == 1) {
            this.f50074c.setAlignBottom(true);
        } else {
            this.f50074c.setAlignBottom(false);
        }
    }

    public void setMarginBottom(int i) {
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) this.f50074c.getLayoutParams();
        layoutParams.bottomMargin = i;
        this.f50074c.setLayoutParams(layoutParams);
    }
}

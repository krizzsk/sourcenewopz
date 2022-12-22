package com.didi.unifiedPay.component.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.unifiedPay.component.model.PlatformDownGradeInfo;
import com.didi.unifiedPay.component.model.PlatformPayItem;
import com.didi.unifiedPay.util.HighlightUtil;
import com.didi.unifiedPay.util.UnipayTextUtil;
import com.didichuxing.bigdata.p173dp.locsdk.Const;
import com.taxis99.R;
import java.util.List;

public class PlatformPayView extends LinearLayout implements View.OnClickListener {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f44459a;

    /* renamed from: b */
    private BaseAdapter f44460b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<PlatformPayItem> f44461c;

    /* renamed from: d */
    private OnselectListener f44462d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public boolean f44463e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public int f44464f;

    public interface OnselectListener {
        void itemClicked(int i, PlatformPayItem platformPayItem);

        void onItemSelectChange(int i, boolean z, PlatformPayItem platformPayItem, boolean z2);
    }

    public PlatformPayView(Context context) {
        super(context);
        m31572a(context);
    }

    public PlatformPayView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m31572a(context);
    }

    /* renamed from: a */
    private void m31572a(Context context) {
        this.f44459a = context;
        setOrientation(1);
        this.f44464f = -1;
    }

    public void setData(List<PlatformPayItem> list, boolean z) {
        m31574a(list);
        this.f44461c = list;
        this.f44463e = z;
        if (this.f44460b == null) {
            this.f44460b = new BaseAdapter() {
                public long getItemId(int i) {
                    return 0;
                }

                public int getCount() {
                    if (PlatformPayView.this.f44461c == null) {
                        return 0;
                    }
                    return PlatformPayView.this.f44461c.size();
                }

                public Object getItem(int i) {
                    return PlatformPayView.this.f44461c.get(i);
                }

                public View getView(int i, View view, ViewGroup viewGroup) {
                    ViewHolder viewHolder;
                    View view2;
                    PlatformPayItem platformPayItem = (PlatformPayItem) PlatformPayView.this.f44461c.get(i);
                    if (view == null) {
                        viewHolder = new ViewHolder();
                        view2 = LayoutInflater.from(PlatformPayView.this.f44459a).inflate(R.layout.oc_unified_pay_platform_item, (ViewGroup) null);
                        viewHolder.payIcon = (ImageView) view2.findViewById(R.id.oc_iv_platform_pay_icon);
                        viewHolder.payTitleTv = (TextView) view2.findViewById(R.id.oc_tv_platform_pay_title);
                        viewHolder.balanceTv = (TextView) view2.findViewById(R.id.oc_tv_platform_pay_balance);
                        viewHolder.payStateTv = (TextView) view2.findViewById(R.id.oc_platform_pay_state);
                        viewHolder.payValueTv = (TextView) view2.findViewById(R.id.oc_tv_platform_pay_value);
                        viewHolder.checkbox = (ImageView) view2.findViewById(R.id.oc_iv_platform_pay_checkbox);
                        viewHolder.progressBar = (ProgressBar) view2.findViewById(R.id.oc_pb_platform_item_loading);
                        viewHolder.downgradleTv = (TextView) view2.findViewById(R.id.oc_tv_platform_pay_downgradle);
                        viewHolder.knowMoreIcon = (ImageView) view2.findViewById(R.id.oc_iv_platform_know_more);
                        view2.setTag(viewHolder);
                    } else {
                        view2 = view;
                        viewHolder = (ViewHolder) view.getTag();
                    }
                    if (platformPayItem.channelId == 123) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_chuxingcard);
                    } else if (platformPayItem.channelId == 126) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_balance);
                    } else if (platformPayItem.channelId == 121) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_company);
                    } else if (platformPayItem.channelId == 118) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_yufu);
                    } else if (platformPayItem.channelId == 161) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_dd_credit);
                    } else if (platformPayItem.channelId == 115) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_dd_thcz);
                    } else if (platformPayItem.channelId == 108) {
                        viewHolder.payIcon.setImageResource(R.mipmap.pay_icon_experience_card);
                    }
                    viewHolder.payTitleTv.setText(platformPayItem.name);
                    viewHolder.payValueTv.setText(platformPayItem.payMoney);
                    viewHolder.payValueTv.setVisibility(0);
                    if (UnipayTextUtil.isEmpty(platformPayItem.balanceDes)) {
                        viewHolder.balanceTv.setVisibility(8);
                    } else {
                        viewHolder.balanceTv.setText(platformPayItem.balanceDes);
                        viewHolder.balanceTv.setVisibility(0);
                    }
                    if (UnipayTextUtil.isEmpty(platformPayItem.payState)) {
                        viewHolder.payStateTv.setVisibility(8);
                    } else {
                        viewHolder.payStateTv.setText(platformPayItem.payState);
                        viewHolder.payStateTv.setVisibility(0);
                    }
                    if (!PlatformPayView.this.f44463e) {
                        viewHolder.progressBar.setVisibility(8);
                        handleCheckBoxView(viewHolder, platformPayItem);
                    } else if (PlatformPayView.this.f44464f == i) {
                        viewHolder.progressBar.setVisibility(0);
                        viewHolder.checkbox.setVisibility(8);
                    } else {
                        viewHolder.progressBar.setVisibility(8);
                        handleCheckBoxView(viewHolder, platformPayItem);
                    }
                    initDownGradle(viewHolder, platformPayItem);
                    view2.setTag(Integer.valueOf(i));
                    return view2;
                }

                private void initDownGradle(ViewHolder viewHolder, PlatformPayItem platformPayItem) {
                    if (platformPayItem.downGradeInfo != null) {
                        if (platformPayItem.downGradeInfo.type == PlatformDownGradeInfo.PlatformDownGrade.NOT_USEABLE) {
                            viewHolder.payValueTv.setVisibility(8);
                            viewHolder.checkbox.setVisibility(8);
                        }
                        if (!UnipayTextUtil.isEmpty(platformPayItem.downGradeInfo.url)) {
                            viewHolder.knowMoreIcon.setVisibility(0);
                            viewHolder.checkbox.setVisibility(8);
                        } else {
                            viewHolder.knowMoreIcon.setVisibility(8);
                        }
                        if (!UnipayTextUtil.isEmpty(platformPayItem.downGradeInfo.text)) {
                            viewHolder.downgradleTv.setText(platformPayItem.downGradeInfo.text);
                            viewHolder.downgradleTv.setVisibility(0);
                            return;
                        }
                        viewHolder.downgradleTv.setVisibility(8);
                        return;
                    }
                    viewHolder.downgradleTv.setVisibility(8);
                    viewHolder.knowMoreIcon.setVisibility(8);
                }

                private void handleCheckBoxView(ViewHolder viewHolder, PlatformPayItem platformPayItem) {
                    if (platformPayItem.canSelect) {
                        viewHolder.checkbox.setVisibility(0);
                        viewHolder.checkbox.setSelected(platformPayItem.selected);
                        return;
                    }
                    viewHolder.checkbox.setVisibility(8);
                }
            };
        }
        m31570a();
        setDownGradleClick(this.f44461c);
    }

    /* renamed from: a */
    private void m31570a() {
        removeAllViews();
        for (int i = 0; i < this.f44460b.getCount(); i++) {
            View view = this.f44460b.getView(i, (View) null, (ViewGroup) null);
            m31571a(i, view);
            addView(view);
        }
    }

    /* renamed from: a */
    private void m31571a(int i, View view) {
        PlatformPayItem platformPayItem = (PlatformPayItem) this.f44460b.getItem(i);
        if (platformPayItem != null) {
            if (platformPayItem.canSelect) {
                view.setOnClickListener(this);
            } else if (platformPayItem.downGradeInfo == null || UnipayTextUtil.isEmpty(platformPayItem.downGradeInfo.url)) {
                view.setOnClickListener((View.OnClickListener) null);
            } else {
                view.setOnClickListener(this);
            }
        }
    }

    public void onClick(View view) {
        OnselectListener onselectListener;
        AutoTrackHelper.trackViewOnClick(view);
        Integer num = (Integer) view.getTag();
        PlatformPayItem platformPayItem = (PlatformPayItem) this.f44460b.getItem(num.intValue());
        if (platformPayItem.downGradeInfo == null || UnipayTextUtil.isEmpty(platformPayItem.downGradeInfo.url) || (onselectListener = this.f44462d) == null) {
            m31573a(num, platformPayItem);
        } else {
            onselectListener.itemClicked(num.intValue(), platformPayItem);
        }
    }

    /* renamed from: a */
    private void m31573a(Integer num, PlatformPayItem platformPayItem) {
        if (!this.f44463e) {
            if (platformPayItem != null) {
                platformPayItem.selected = !platformPayItem.selected;
            }
            m31570a();
            OnselectListener onselectListener = this.f44462d;
            if (onselectListener != null) {
                onselectListener.onItemSelectChange(num.intValue(), platformPayItem.selected, platformPayItem, this.f44463e);
            }
        } else if (this.f44462d != null) {
            this.f44464f = num.intValue();
            m31570a();
            this.f44462d.onItemSelectChange(num.intValue(), !platformPayItem.selected, platformPayItem, this.f44463e);
        }
    }

    public void setOnSelectListener(OnselectListener onselectListener) {
        this.f44462d = onselectListener;
    }

    public void setItemEnable(boolean z) {
        int childCount = getChildCount();
        for (int i = 0; i < childCount; i++) {
            View childAt = getChildAt(i);
            if (childAt != null) {
                childAt.setEnabled(z);
            }
        }
        if (z) {
            setDownGradleClick(this.f44461c);
        }
    }

    private void setDownGradleClick(List<PlatformPayItem> list) {
        View childAt;
        if (list != null && list.size() > 0) {
            for (int i = 0; i < list.size(); i++) {
                PlatformPayItem platformPayItem = list.get(i);
                if (!(platformPayItem == null || platformPayItem.downGradeInfo == null || platformPayItem.downGradeInfo.type != PlatformDownGradeInfo.PlatformDownGrade.NOT_USEABLE || !UnipayTextUtil.isEmpty(platformPayItem.downGradeInfo.url) || (childAt = getChildAt(i)) == null)) {
                    childAt.setEnabled(false);
                }
            }
        }
    }

    public void setBlockChangeResult(boolean z) {
        if (hasLoadingStateItem()) {
            PlatformPayItem platformPayItem = (PlatformPayItem) this.f44460b.getItem(this.f44464f);
            if (z) {
                platformPayItem.selected = !platformPayItem.selected;
            }
            this.f44464f = -1;
            m31570a();
        }
    }

    public boolean hasLoadingStateItem() {
        return this.f44464f >= 0;
    }

    public boolean canUseEntraprisePay() {
        if (this.f44460b == null) {
            return false;
        }
        for (int i = 0; i < this.f44460b.getCount(); i++) {
            PlatformPayItem platformPayItem = (PlatformPayItem) this.f44460b.getItem(i);
            if (platformPayItem != null && platformPayItem.channelId == 121) {
                return platformPayItem.selected;
            }
        }
        return false;
    }

    public boolean isDDCreditSected() {
        if (this.f44460b == null) {
            return false;
        }
        for (int i = 0; i < this.f44460b.getCount(); i++) {
            PlatformPayItem platformPayItem = (PlatformPayItem) this.f44460b.getItem(i);
            if (platformPayItem != null && platformPayItem.channelId == 161) {
                return platformPayItem.selected;
            }
        }
        return false;
    }

    /* renamed from: a */
    private void m31574a(List<PlatformPayItem> list) {
        if (list != null && list.size() > 0) {
            for (PlatformPayItem next : list) {
                if (next != null && next.downGradeInfo != null && !UnipayTextUtil.isEmpty(next.downGradeInfo.url) && !UnipayTextUtil.isEmpty(next.downGradeInfo.text)) {
                    int color = this.f44459a.getResources().getColor(R.color.oc_color_999999);
                    int color2 = this.f44459a.getResources().getColor(R.color.orange);
                    PlatformDownGradeInfo platformDownGradeInfo = next.downGradeInfo;
                    platformDownGradeInfo.text = HighlightUtil.highlight(Const.joLeft + next.downGradeInfo.text.toString() + "}", color, color2);
                }
            }
        }
    }

    static class ViewHolder {
        TextView balanceTv;
        ImageView checkbox;
        TextView downgradleTv;
        ImageView knowMoreIcon;
        ImageView payIcon;
        TextView payStateTv;
        TextView payTitleTv;
        TextView payValueTv;
        ProgressBar progressBar;

        ViewHolder() {
        }
    }
}

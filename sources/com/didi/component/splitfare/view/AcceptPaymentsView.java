package com.didi.component.splitfare.view;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.component.common.util.UIUtils;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class AcceptPaymentsView extends LinearLayout {

    /* renamed from: a */
    private List<String> f15994a = new ArrayList();

    public AcceptPaymentsView(Context context) {
        super(context);
        m11765a();
    }

    public AcceptPaymentsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m11765a();
    }

    /* renamed from: a */
    private void m11765a() {
        setGravity(17);
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
    }

    public void updateLabel(List<PayWayModel.PayWayItem> list) {
        List<PayWayRenderItem> convertToRenderItem = convertToRenderItem(list);
        if (list != null && !list.isEmpty()) {
            int size = list.size();
        }
        m11766a(convertToRenderItem, false);
    }

    /* renamed from: a */
    private void m11766a(List<PayWayRenderItem> list, boolean z) {
        removeAllViews();
        if (list != null && list.size() != 0) {
            this.f15994a.clear();
            for (PayWayRenderItem next : list) {
                if (z || !next.hasIconUrl()) {
                    StringBuilder sb = new StringBuilder();
                    if (next.justSeparator()) {
                        sb.append("+ ");
                    }
                    if (!TextUtils.isEmpty(next.getLabel())) {
                        String card = next.getCard();
                        if (TextUtils.isEmpty(card)) {
                            card = next.getLabel();
                        }
                        sb.append(card);
                    }
                    TextView textView = new TextView(getContext());
                    textView.setGravity(17);
                    textView.setMaxLines(2);
                    textView.setText(sb);
                    textView.setEllipsize(TextUtils.TruncateAt.END);
                    textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen._12sp));
                    textView.setTextColor(getResources().getColor(R.color.g_color_666666));
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
                    int dip2px = (int) UIUtils.dip2px(getContext(), (next.justSeparator() || z) ? 2.0f : 10.0f);
                    layoutParams.setMargins(dip2px, 0, dip2px, 0);
                    addView(textView, layoutParams);
                } else {
                    if (!TextUtils.isEmpty(next.getIcon())) {
                        LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
                        layoutParams2.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.ms_5dp), 0);
                        ImageView imageView = new ImageView(getContext());
                        imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                        Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(next.getIcon())).into(imageView);
                        this.f15994a.add(next.getIcon());
                        addView(imageView, layoutParams2);
                    }
                    if (!TextUtils.isEmpty(next.getLabel())) {
                        TextView textView2 = new TextView(getContext());
                        String card2 = next.getCard();
                        if (TextUtils.isEmpty(card2)) {
                            card2 = next.getLabel();
                        }
                        textView2.setText(card2);
                        textView2.setTextSize(1, 12.0f);
                        textView2.setTextColor(getResources().getColor(R.color.g_color_666666));
                        textView2.setSingleLine(true);
                        addView(textView2, new LinearLayout.LayoutParams(-2, -2));
                    }
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public List<PayWayRenderItem> convertToRenderItem(List<PayWayModel.PayWayItem> list) {
        if (list == null || list.size() == 0) {
            return null;
        }
        ArrayList arrayList = new ArrayList();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            boolean z = list.get(i).hasCoupon;
            if (size > 1 && i != size - 1) {
                z = false;
            }
            arrayList.add(new PayWayRenderItem(list.get(i), Boolean.valueOf(z)));
        }
        if (size > 1) {
            arrayList.add(1, new PayWayRenderItem());
        }
        if (size > 3) {
            arrayList.add(3, new PayWayRenderItem());
        }
        return arrayList;
    }

    public String getContent() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < getChildCount(); i++) {
            View childAt = getChildAt(i);
            if (childAt instanceof TextView) {
                sb.append(((TextView) childAt).getText());
            }
        }
        return sb.toString();
    }

    public List<String> getIcon() {
        return this.f15994a;
    }

    protected class PayWayRenderItem {
        private boolean needShowCoupon;
        private PayWayModel.PayWayItem payWayItem;

        public PayWayRenderItem(PayWayModel.PayWayItem payWayItem2, Boolean bool) {
            this.payWayItem = payWayItem2;
            this.needShowCoupon = bool.booleanValue();
        }

        public PayWayRenderItem(PayWayModel.PayWayItem payWayItem2) {
            this.payWayItem = payWayItem2;
        }

        public PayWayRenderItem() {
        }

        public boolean justSeparator() {
            return this.payWayItem == null;
        }

        public String getLabel() {
            PayWayModel.PayWayItem payWayItem2 = this.payWayItem;
            if (payWayItem2 == null) {
                return "";
            }
            if (!this.needShowCoupon) {
                return payWayItem2.getLabel();
            }
            return this.payWayItem.getLabel() + "";
        }

        public String getIcon() {
            PayWayModel.PayWayItem payWayItem2 = this.payWayItem;
            if (payWayItem2 == null) {
                return "";
            }
            if (payWayItem2.extroInfoItemList == null || this.payWayItem.extroInfoItemList.size() <= 0 || TextUtils.isEmpty(this.payWayItem.getCardOrg())) {
                return this.payWayItem.getIconUrl();
            }
            return this.payWayItem.getCardOrg();
        }

        public String getCard() {
            PayWayModel.PayWayItem payWayItem2 = this.payWayItem;
            if (payWayItem2 == null || TextUtils.isEmpty(payWayItem2.getCard())) {
                return "";
            }
            if (!this.needShowCoupon) {
                return this.payWayItem.getCard();
            }
            return this.payWayItem.getCard() + "";
        }

        public boolean hasIconUrl() {
            PayWayModel.PayWayItem payWayItem2 = this.payWayItem;
            if (payWayItem2 == null) {
                return false;
            }
            return !TextUtils.isEmpty(payWayItem2.getIconUrl());
        }
    }
}

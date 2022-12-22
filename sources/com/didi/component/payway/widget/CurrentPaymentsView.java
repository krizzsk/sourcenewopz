package com.didi.component.payway.widget;

import android.content.Context;
import android.graphics.Typeface;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.component.common.util.ActivityUtil;
import com.didi.component.common.util.UIUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.travel.psnger.model.response.PayWayModel;
import com.didiglobal.font.DIDIFontUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class CurrentPaymentsView extends LinearLayout {

    /* renamed from: c */
    private static final int f15216c = 131072;

    /* renamed from: d */
    private static final int f15217d = 256;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f15218a;

    /* renamed from: b */
    private List<String> f15219b = new ArrayList();

    public CurrentPaymentsView(Context context) {
        super(context);
        m10903a();
    }

    public CurrentPaymentsView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m10903a();
    }

    /* renamed from: a */
    private void m10903a() {
        setGravity(17);
        this.f15218a = ResourcesHelper.getString(getContext(), R.string.pay_way_coupon_suffix);
    }

    /* renamed from: b */
    private boolean m10906b() {
        setLayoutParams(new LinearLayout.LayoutParams(-2, -1));
        setOrientation(0);
        return false;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (getVisibility() == 0) {
            View childAt = getChildAt(getChildCount() - 1);
            TextView textView = null;
            if (childAt instanceof TextView) {
                textView = (TextView) childAt;
            }
            if (textView != null) {
                ((View) getParent()).getWidth();
                textView.getText().toString();
            }
        }
    }

    public void updateLabel(List<PayWayModel.PayWayItem> list, String str) {
        m10905a(convertToRenderItem(list), false, str);
    }

    /* renamed from: a */
    private void m10905a(List<PayWayRenderItem> list, boolean z, String str) {
        removeAllViews();
        if (list != null && list.size() != 0) {
            boolean b = m10906b();
            this.f15219b.clear();
            if (list.size() != 3 || list.get(0) == null || list.get(0).payWayItem == null || list.get(0).payWayItem.can_combination_pay_type == null || list.get(2) == null || list.get(2).payWayItem == null) {
                for (PayWayRenderItem a : list) {
                    m10904a(a, z, str, true, b);
                }
                return;
            }
            View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pay_way_balance_card_adapter_layout, this, false);
            ImageView imageView = (ImageView) inflate.findViewById(R.id.pay_way_balance_icon);
            ImageView imageView2 = (ImageView) inflate.findViewById(R.id.pay_way_card_icon);
            StringBuilder sb = new StringBuilder();
            for (PayWayRenderItem next : list) {
                if (!z && next.hasIconUrl()) {
                    this.f15219b.add(next.getIcon());
                }
                if (!TextUtils.isEmpty(next.getLabel())) {
                    sb.append(m10902a(next.getLabel(), next.getCard(), str));
                }
                if (next.justSeparator()) {
                    sb.append("+");
                }
            }
            if (this.f15219b.size() == 2) {
                Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(this.f15219b.get(0))).into(imageView);
                Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(this.f15219b.get(1))).into(imageView2);
                addView(inflate);
            }
            TextView textView = new TextView(getContext());
            textView.setText(sb.toString());
            textView.setTextSize(1, 12.0f);
            textView.setTextColor(getResources().getColor(R.color.lego_color_000000));
            textView.setGravity(17);
            textView.setMaxLines(2);
            textView.setTypeface(Typeface.DEFAULT, 1);
            DIDIFontUtils.Companion.setTypeface(getContext(), textView);
            addView(textView, new LinearLayout.LayoutParams(-2, -2));
        }
    }

    /* renamed from: a */
    private void m10904a(PayWayRenderItem payWayRenderItem, boolean z, String str, boolean z2, boolean z3) {
        if (z || !payWayRenderItem.hasIconUrl()) {
            StringBuilder sb = new StringBuilder();
            if (payWayRenderItem.justSeparator()) {
                sb.append("+ ");
            }
            if (!TextUtils.isEmpty(payWayRenderItem.getLabel())) {
                sb.append(m10902a(payWayRenderItem.getLabel(), m10901a(payWayRenderItem.getCard()), str));
            }
            TextView textView = new TextView(getContext());
            textView.setGravity(17);
            textView.setMaxLines(2);
            textView.setText(sb);
            textView.setEllipsize(TextUtils.TruncateAt.END);
            textView.setTextSize(0, (float) getResources().getDimensionPixelSize(R.dimen._12sp));
            textView.setTextColor(getResources().getColor(R.color.lego_color_000000));
            if (z2) {
                textView.setTypeface(Typeface.DEFAULT, 1);
            }
            DIDIFontUtils.Companion.setTypeface(getContext(), textView);
            LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-2, -2);
            int dip2px = (int) UIUtils.dip2px(getContext(), (payWayRenderItem.justSeparator() || z) ? 2.0f : 10.0f);
            layoutParams.setMargins(dip2px, 0, dip2px, 0);
            addView(textView, layoutParams);
        } else if (!ActivityUtil.isActivityDestroyed(getContext())) {
            if (!TextUtils.isEmpty(payWayRenderItem.getIcon())) {
                this.f15219b.add(payWayRenderItem.getIcon());
                if (z3) {
                    View inflate = LayoutInflater.from(getContext()).inflate(R.layout.pay_way_balance_card_adapter_layout, this, false);
                    ((ImageView) inflate.findViewById(R.id.pay_way_balance_icon)).setVisibility(8);
                    Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(payWayRenderItem.getIcon())).into((ImageView) inflate.findViewById(R.id.pay_way_card_icon));
                    addView(inflate);
                } else {
                    LinearLayout.LayoutParams layoutParams2 = new LinearLayout.LayoutParams((int) TypedValue.applyDimension(1, 24.0f, getResources().getDisplayMetrics()), (int) TypedValue.applyDimension(1, 15.0f, getResources().getDisplayMetrics()));
                    layoutParams2.setMargins(0, 0, getResources().getDimensionPixelSize(R.dimen.ms_5dp), 0);
                    ImageView imageView = new ImageView(getContext());
                    imageView.setScaleType(ImageView.ScaleType.FIT_XY);
                    Glide.with(getContext()).asBitmap().load((Object) new GlideUrl(payWayRenderItem.getIcon())).into(imageView);
                    addView(imageView, layoutParams2);
                }
            }
            if (!TextUtils.isEmpty(payWayRenderItem.getLabel())) {
                TextView textView2 = new TextView(getContext());
                textView2.setText(m10902a(payWayRenderItem.getLabel(), m10901a(payWayRenderItem.getCard()), str));
                textView2.setTextSize(1, 12.0f);
                textView2.setTextColor(getResources().getColor(R.color.lego_color_000000));
                textView2.setGravity(17);
                textView2.setMaxLines(2);
                if (z2) {
                    textView2.setTypeface(Typeface.DEFAULT, 1);
                }
                DIDIFontUtils.Companion.setTypeface(getContext(), textView2);
                addView(textView2, new LinearLayout.LayoutParams(-2, -2));
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
        return this.f15219b;
    }

    protected class PayWayRenderItem {
        private boolean needShowCoupon;
        /* access modifiers changed from: private */
        public PayWayModel.PayWayItem payWayItem;

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
            return this.payWayItem.getLabel() + CurrentPaymentsView.this.f15218a;
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
            if (this.payWayItem.expired == 1) {
                return this.payWayItem.getCard() + "(" + this.payWayItem.expiredDesc + ")";
            } else if (!this.needShowCoupon) {
                return this.payWayItem.getCard();
            } else {
                return this.payWayItem.getCard() + CurrentPaymentsView.this.f15218a;
            }
        }

        public boolean hasIconUrl() {
            PayWayModel.PayWayItem payWayItem2 = this.payWayItem;
            if (payWayItem2 == null) {
                return false;
            }
            return !TextUtils.isEmpty(payWayItem2.getIconUrl());
        }
    }

    /* renamed from: a */
    private String m10902a(String str, String str2, String str3) {
        if (!TextUtils.isEmpty(str2)) {
            str = str2;
        }
        if (TextUtils.isEmpty(str3)) {
            return str;
        }
        return str + " + " + str3;
    }

    /* renamed from: a */
    private String m10901a(String str) {
        if (!TextUtils.isEmpty(str)) {
            return Pattern.compile("[.]").matcher(str).replaceAll("").trim();
        }
        return "";
    }
}

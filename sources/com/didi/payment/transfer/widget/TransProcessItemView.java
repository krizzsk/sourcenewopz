package com.didi.payment.transfer.widget;

import android.content.Context;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.sdk.util.TextUtil;
import com.taxis99.R;

public class TransProcessItemView extends LinearLayout {

    /* renamed from: a */
    private TextView f31520a;

    /* renamed from: b */
    private TextView f31521b;

    /* renamed from: c */
    private View f31522c;

    /* renamed from: d */
    private View f31523d;

    /* renamed from: e */
    private ImageView f31524e;

    public enum ItemType {
        TYPE_HEAD,
        TYPE_NORMAL,
        TYPE_FOOT
    }

    public TransProcessItemView(Context context) {
        super(context);
        m22272a();
    }

    public TransProcessItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m22272a();
    }

    public TransProcessItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m22272a();
    }

    /* renamed from: a */
    private void m22272a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.trans_process_item_lay, this, true);
        this.f31520a = (TextView) inflate.findViewById(R.id.trans_process_status_tv);
        this.f31521b = (TextView) inflate.findViewById(R.id.trans_process_status_subtitle);
        this.f31524e = (ImageView) inflate.findViewById(R.id.indicator_center_dot_img);
        this.f31522c = inflate.findViewById(R.id.indicator_half_above_line);
        this.f31523d = inflate.findViewById(R.id.indicator_half_below_line);
    }

    public void setData(ItemType itemType, String str, String str2, String str3) {
        int i;
        this.f31520a.setText(str);
        this.f31521b.setText(str3);
        int i2 = C110011.f31525x57e8c2f6[itemType.ordinal()];
        int i3 = R.color.transfer_color_subtitle_gray;
        if (i2 != 1) {
            if (i2 == 2) {
                i = getResources().getColor(R.color.transfer_color_subtitle_gray);
            } else if (i2 != 3) {
                i = -1;
            } else {
                this.f31523d.setVisibility(8);
                i = getResources().getColor(R.color.transfer_color_subtitle_gray);
            }
            this.f31524e.setBackground(UIUtil.getCircleColorDrawable(getContext(), 5, i));
            this.f31520a.setTextColor(getResources().getColor(i3));
            this.f31521b.setTextColor(getResources().getColor(i3));
        }
        this.f31522c.setVisibility(8);
        if (TextUtil.isEmpty(str2)) {
            str2 = "#333333";
        }
        try {
            i = Color.parseColor(str2);
        } catch (Exception unused) {
            i = -16777216;
        }
        i3 = R.color.transfer_color_title_black;
        this.f31524e.setBackground(UIUtil.getCircleColorDrawable(getContext(), 5, i));
        this.f31520a.setTextColor(getResources().getColor(i3));
        this.f31521b.setTextColor(getResources().getColor(i3));
    }

    /* renamed from: com.didi.payment.transfer.widget.TransProcessItemView$1 */
    static /* synthetic */ class C110011 {

        /* renamed from: $SwitchMap$com$didi$payment$transfer$widget$TransProcessItemView$ItemType */
        static final /* synthetic */ int[] f31525x57e8c2f6;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.payment.transfer.widget.TransProcessItemView$ItemType[] r0 = com.didi.payment.transfer.widget.TransProcessItemView.ItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f31525x57e8c2f6 = r0
                com.didi.payment.transfer.widget.TransProcessItemView$ItemType r1 = com.didi.payment.transfer.widget.TransProcessItemView.ItemType.TYPE_HEAD     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f31525x57e8c2f6     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.payment.transfer.widget.TransProcessItemView$ItemType r1 = com.didi.payment.transfer.widget.TransProcessItemView.ItemType.TYPE_NORMAL     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f31525x57e8c2f6     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.payment.transfer.widget.TransProcessItemView$ItemType r1 = com.didi.payment.transfer.widget.TransProcessItemView.ItemType.TYPE_FOOT     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.transfer.widget.TransProcessItemView.C110011.<clinit>():void");
        }
    }
}

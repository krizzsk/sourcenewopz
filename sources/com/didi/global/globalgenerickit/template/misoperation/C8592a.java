package com.didi.global.globalgenerickit.template.misoperation;

import android.text.TextUtils;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globalgenerickit.eventtracker.ImgLoadTracker;
import com.didi.global.globalgenerickit.template.yoga.EventListener;
import com.taxis99.R;
import java.util.HashMap;

/* renamed from: com.didi.global.globalgenerickit.template.misoperation.a */
/* compiled from: MisOperationBinder */
class C8592a {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public final EventListener f22197a;

    /* renamed from: b */
    private LinearLayout f22198b;

    /* renamed from: c */
    private TextView f22199c;

    /* renamed from: d */
    private TextView f22200d;

    /* renamed from: e */
    private ImageView f22201e;

    /* renamed from: f */
    private TextView[] f22202f;

    /* renamed from: g */
    private View[] f22203g;

    /* renamed from: h */
    private ImageView[] f22204h;

    /* renamed from: i */
    private View[] f22205i;

    /* renamed from: j */
    private final String f22206j = "notice";

    /* renamed from: k */
    private View f22207k;

    public C8592a(View view, EventListener eventListener) {
        this.f22207k = view;
        this.f22197a = eventListener;
        this.f22199c = (TextView) view.findViewById(R.id.oc_x_panel_operation_title);
        this.f22198b = (LinearLayout) view.findViewById(R.id.oc_x_panel_operation_text_layout);
        this.f22200d = (TextView) view.findViewById(R.id.oc_x_panel_operation_content);
        this.f22201e = (ImageView) view.findViewById(R.id.oc_x_panel_operation_image);
        this.f22202f = new TextView[]{(TextView) view.findViewById(R.id.txt0), (TextView) view.findViewById(R.id.txt1), (TextView) view.findViewById(R.id.txt2)};
        this.f22204h = new ImageView[]{(ImageView) view.findViewById(R.id.image0), (ImageView) view.findViewById(R.id.image1), (ImageView) view.findViewById(R.id.image2)};
        this.f22203g = new View[]{null, view.findViewById(R.id.divider0), view.findViewById(R.id.divider1)};
        this.f22205i = new View[]{view.findViewById(R.id.bottombar0), view.findViewById(R.id.bottombar1), view.findViewById(R.id.bottombar2)};
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo66613a(MisOperationData misOperationData) {
        String str = misOperationData.title;
        String str2 = misOperationData.content;
        String str3 = misOperationData.imageUrl;
        String str4 = misOperationData.link;
        if (!TextUtils.isEmpty(str)) {
            this.f22199c.setText(str);
            this.f22199c.setVisibility(0);
        } else {
            this.f22199c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f22200d.setText(str2);
            this.f22200d.setVisibility(0);
        } else {
            this.f22200d.setVisibility(8);
        }
        if (this.f22199c.getVisibility() == 0 || this.f22200d.getVisibility() == 0) {
            this.f22198b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3) || "notice".equals(misOperationData.type)) {
            this.f22201e.setVisibility(8);
        } else {
            this.f22201e.setImageDrawable(this.f22200d.getResources().getDrawable(R.drawable.oc_x_panel_operation_image));
            this.f22201e.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f22207k.setOnClickListener(new ViewHolder$1(this, str3));
        } else {
            this.f22207k.setOnClickListener((View.OnClickListener) null);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo66614b(MisOperationData misOperationData) {
        if (misOperationData.bottombarTxts != null) {
            for (int i = 0; i < this.f22205i.length; i++) {
                if (i >= misOperationData.bottombarTxts.length) {
                    this.f22205i[i].setVisibility(8);
                    View[] viewArr = this.f22203g;
                    if (viewArr[i] != null) {
                        viewArr[i].setVisibility(8);
                    }
                } else if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                    String str = misOperationData.bottombarLinks[i];
                    if (!TextUtils.isEmpty(str)) {
                        this.f22205i[i].setOnClickListener(new ViewHolder$2(this, i, str));
                    } else {
                        this.f22205i[i].setOnClickListener((View.OnClickListener) null);
                    }
                    if (TextUtils.isEmpty(misOperationData.bottombarImages[i])) {
                        this.f22204h[i].setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                        this.f22202f[i].setText(misOperationData.bottombarTxts[i]);
                        this.f22202f[i].setVisibility(0);
                    } else {
                        this.f22202f[i].setVisibility(8);
                    }
                    View[] viewArr2 = this.f22203g;
                    if (viewArr2[i] != null) {
                        viewArr2[i].setVisibility(0);
                    }
                    this.f22205i[i].setBackgroundResource(R.drawable.oc_x_panel_operation_selector);
                    this.f22205i[i].setVisibility(0);
                } else {
                    this.f22205i[i].setVisibility(8);
                }
            }
        }
    }

    /* renamed from: c */
    public void mo66615c(MisOperationData misOperationData) {
        mo66613a(misOperationData);
        mo66614b(misOperationData);
        String str = misOperationData.imageUrl;
        if (!TextUtils.isEmpty(str)) {
            HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(misOperationData.activityId)) {
                hashMap.put("act_id", misOperationData.activityId);
            }
            long currentTimeMillis = System.currentTimeMillis();
            ImgLoadTracker.loadUrlOmega(str, hashMap);
            ((RequestBuilder) Glide.with(this.f22207k.getContext()).load(str).error((int) R.drawable.oc_x_panel_operation_image)).listener(new ViewHolder$3(this, str, hashMap, currentTimeMillis)).into(this.f22201e);
        }
    }
}

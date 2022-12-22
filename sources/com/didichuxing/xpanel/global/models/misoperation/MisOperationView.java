package com.didichuxing.xpanel.global.models.misoperation;

import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.request.target.CustomTarget;
import com.bumptech.glide.request.transition.Transition;
import com.didi.autotracker.AutoTrackHelper;
import com.didichuxing.xpanel.agent.IXPanelAgentClickListener;
import com.didichuxing.xpanel.base.XPanelCardData;
import com.didichuxing.xpanel.models.AbsXPanelAgentModelView;
import com.taxis99.R;
import java.util.HashMap;

public class MisOperationView extends AbsXPanelAgentModelView<MisOperationData> {

    /* renamed from: a */
    private View f49504a;

    /* renamed from: b */
    private LinearLayout f49505b;

    /* renamed from: c */
    private TextView f49506c;

    /* renamed from: d */
    private TextView f49507d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public ImageView f49508e;

    /* renamed from: f */
    private TextView[] f49509f;

    /* renamed from: g */
    private View[] f49510g;

    /* renamed from: h */
    private ImageView[] f49511h;

    /* renamed from: i */
    private View[] f49512i;

    /* renamed from: j */
    private final String f49513j = "notice";

    public boolean contain(float f, float f2) {
        return false;
    }

    public int getMarginLeft() {
        return 0;
    }

    public int getMarginRight() {
        return 0;
    }

    /* renamed from: a */
    private void m35726a() {
        this.f49506c = (TextView) this.f49504a.findViewById(R.id.oc_x_panel_operation_title);
        this.f49505b = (LinearLayout) this.f49504a.findViewById(R.id.oc_x_panel_operation_text_layout);
        this.f49507d = (TextView) this.f49504a.findViewById(R.id.oc_x_panel_operation_content);
        this.f49508e = (ImageView) this.f49504a.findViewById(R.id.oc_x_panel_operation_image);
        this.f49509f = new TextView[]{(TextView) this.f49504a.findViewById(R.id.txt0), (TextView) this.f49504a.findViewById(R.id.txt1), (TextView) this.f49504a.findViewById(R.id.txt2)};
        this.f49511h = new ImageView[]{(ImageView) this.f49504a.findViewById(R.id.image0), (ImageView) this.f49504a.findViewById(R.id.image1), (ImageView) this.f49504a.findViewById(R.id.image2)};
        this.f49510g = new View[]{null, this.f49504a.findViewById(R.id.divider0), this.f49504a.findViewById(R.id.divider1)};
        this.f49512i = new View[]{this.f49504a.findViewById(R.id.bottombar0), this.f49504a.findViewById(R.id.bottombar1), this.f49504a.findViewById(R.id.bottombar2)};
    }

    public View getView() {
        return createBgContainer(this.f49504a);
    }

    public int halfHeight() {
        return this.f49504a.getMeasuredHeight() / 2;
    }

    public void bind(MisOperationData misOperationData) {
        m35730b(misOperationData);
        m35727a(misOperationData);
        final String str = misOperationData.imageUrl;
        if (!TextUtils.isEmpty(str)) {
            final HashMap hashMap = new HashMap();
            if (!TextUtils.isEmpty(misOperationData.activityId)) {
                hashMap.put("act_id", misOperationData.activityId);
            }
            final long currentTimeMillis = System.currentTimeMillis();
            loadUrlOmega(str, hashMap);
            ((RequestBuilder) Glide.with(this.mContext).load(str).error((int) R.drawable.oc_x_panel_operation_image)).into(new CustomTarget<Drawable>() {
                public void onResourceReady(Drawable drawable, Transition<? super Drawable> transition) {
                    MisOperationView.this.f49508e.setImageDrawable(drawable);
                    MisOperationView.this.loadUrlRetOmega(str, hashMap, 0, currentTimeMillis);
                }

                public void onLoadCleared(Drawable drawable) {
                    MisOperationView.this.loadUrlRetOmega(str, hashMap, 1, currentTimeMillis);
                }
            });
        }
    }

    /* renamed from: a */
    private void m35727a(MisOperationData misOperationData) {
        if (misOperationData.bottombarTxts != null) {
            for (final int i = 0; i < this.f49512i.length; i++) {
                if (i >= misOperationData.bottombarTxts.length) {
                    this.f49512i[i].setVisibility(8);
                    View[] viewArr = this.f49510g;
                    if (viewArr[i] != null) {
                        viewArr[i].setVisibility(8);
                    }
                } else if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                    final String str = misOperationData.bottombarLinks[i];
                    if (!TextUtils.isEmpty(str)) {
                        this.f49512i[i].setOnClickListener(new View.OnClickListener() {
                            public void onClick(View view) {
                                AutoTrackHelper.trackViewOnClick(view);
                                if (MisOperationView.this.mListener != null) {
                                    IXPanelAgentClickListener d = MisOperationView.this.mListener;
                                    String str = str;
                                    XPanelCardData c = MisOperationView.this.mCardData;
                                    if (!d.dispatchClickUri(str, c, "button_" + i)) {
                                        MisOperationView.this.mListener.clickUri(str, MisOperationView.this.mCardData);
                                    }
                                }
                                MisOperationView.this.clickButtonOmega();
                            }
                        });
                    } else {
                        this.f49512i[i].setOnClickListener((View.OnClickListener) null);
                    }
                    if (TextUtils.isEmpty(misOperationData.bottombarImages[i])) {
                        this.f49511h[i].setVisibility(8);
                    }
                    if (!TextUtils.isEmpty(misOperationData.bottombarTxts[i])) {
                        this.f49509f[i].setText(misOperationData.bottombarTxts[i]);
                        this.f49509f[i].setVisibility(0);
                    } else {
                        this.f49509f[i].setVisibility(8);
                    }
                    View[] viewArr2 = this.f49510g;
                    if (viewArr2[i] != null) {
                        viewArr2[i].setVisibility(0);
                    }
                    this.f49512i[i].setBackgroundResource(R.drawable.oc_x_panel_operation_selector);
                    this.f49512i[i].setVisibility(0);
                } else {
                    this.f49512i[i].setVisibility(8);
                }
            }
        }
    }

    public void initView() {
        this.f49504a = LayoutInflater.from(this.mContext).inflate(R.layout.oc_x_panel_operation_view, (ViewGroup) null);
        m35726a();
    }

    public void destroy() {
        super.destroy();
    }

    /* renamed from: b */
    private void m35730b(MisOperationData misOperationData) {
        String str = misOperationData.title;
        String str2 = misOperationData.content;
        String str3 = misOperationData.imageUrl;
        final String str4 = misOperationData.link;
        if (!TextUtils.isEmpty(str)) {
            this.f49506c.setText(str);
            this.f49506c.setVisibility(0);
        } else {
            this.f49506c.setVisibility(8);
        }
        if (!TextUtils.isEmpty(str2)) {
            this.f49507d.setText(str2);
            this.f49507d.setVisibility(0);
        } else {
            this.f49507d.setVisibility(8);
        }
        if (this.f49506c.getVisibility() == 0 || this.f49507d.getVisibility() == 0) {
            this.f49505b.setVisibility(0);
        }
        if (TextUtils.isEmpty(str3) || "notice".equals(misOperationData.type)) {
            this.f49508e.setVisibility(8);
        } else {
            this.f49508e.setImageDrawable(this.f49507d.getResources().getDrawable(R.drawable.oc_x_panel_operation_image));
            this.f49508e.setVisibility(0);
        }
        if (!TextUtils.isEmpty(str4)) {
            this.f49504a.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (MisOperationView.this.mListener != null && !MisOperationView.this.mListener.dispatchClickUri(str4, MisOperationView.this.mCardData, "card")) {
                        MisOperationView.this.mListener.clickUri(str4, MisOperationView.this.mCardData);
                    }
                    MisOperationView.this.clickCardOmega();
                }
            });
        } else {
            this.f49504a.setOnClickListener((View.OnClickListener) null);
        }
    }
}

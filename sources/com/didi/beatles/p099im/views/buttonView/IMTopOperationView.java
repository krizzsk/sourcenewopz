package com.didi.beatles.p099im.views.buttonView;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.beatles.p099im.access.IMEngine;
import com.didi.beatles.p099im.access.style.custom.IMCustomContext;
import com.didi.beatles.p099im.access.style.custom.IMCustomViewHelper;
import com.didi.beatles.p099im.access.style.custom.IMTopOperationCusView;
import com.didi.beatles.p099im.api.entity.IMTopOperationBody;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.resource.IMResource;
import com.didi.beatles.p099im.utils.IMCommonUtil;
import com.didi.beatles.p099im.utils.IMViewUtil;
import com.didi.beatles.p099im.utils.imageloader.BtsImageLoader;
import com.didi.beatles.p099im.views.widget.IMSimpleGuideView;
import com.taxis99.R;

/* renamed from: com.didi.beatles.im.views.buttonView.IMTopOperationView */
public class IMTopOperationView extends LinearLayout {

    /* renamed from: a */
    private View f10148a;

    /* renamed from: b */
    private ImageView f10149b;

    /* renamed from: c */
    private TextView f10150c;

    /* renamed from: d */
    private TextView f10151d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public IMSimpleGuideView f10152e;

    /* renamed from: f */
    private IMSession f10153f;

    /* renamed from: g */
    private IMCustomContext f10154g;

    /* renamed from: h */
    private View f10155h;

    /* renamed from: i */
    private IMTopOperationCusView f10156i;

    public IMTopOperationView(Context context) {
        this(context, (AttributeSet) null, 0);
    }

    public IMTopOperationView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public IMTopOperationView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m6924a();
    }

    /* renamed from: a */
    private void m6924a() {
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.bts_im_follow_layout, this, true);
        this.f10148a = inflate;
        this.f10151d = (TextView) inflate.findViewById(R.id.im_top_operation_btn);
        this.f10150c = (TextView) inflate.findViewById(R.id.im_top_operation_content);
        this.f10149b = (ImageView) inflate.findViewById(R.id.im_top_operation_icon);
    }

    public void init(IMSession iMSession, IMCustomContext iMCustomContext) {
        this.f10153f = iMSession;
        this.f10154g = iMCustomContext;
        View tryLoadCustomView = tryLoadCustomView(this);
        if (tryLoadCustomView != null) {
            IMViewUtil.hide(this.f10148a);
            addView(tryLoadCustomView);
        }
    }

    /* access modifiers changed from: protected */
    public final View tryLoadCustomView(ViewGroup viewGroup) {
        IMTopOperationCusView createTopOperationView;
        View layoutView;
        if (this.f10153f == null || (createTopOperationView = IMCustomViewHelper.createTopOperationView(IMEngine.getInstance(getContext()).getCurrentBusinessConfig(this.f10153f.getBusinessId()), this.f10154g)) == null || (layoutView = createTopOperationView.layoutView(viewGroup)) == null) {
            return null;
        }
        this.f10156i = createTopOperationView;
        this.f10155h = layoutView;
        return layoutView;
    }

    public void setData(IMTopOperationBody iMTopOperationBody) {
        IMTopOperationCusView iMTopOperationCusView = this.f10156i;
        if (iMTopOperationCusView == null || this.f10155h == null) {
            setDataImpl(iMTopOperationBody);
        } else {
            iMTopOperationCusView.bindData(iMTopOperationBody);
        }
    }

    private void setDataImpl(final IMTopOperationBody iMTopOperationBody) {
        if (iMTopOperationBody == null || TextUtils.isEmpty(iMTopOperationBody.btnText)) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (!TextUtils.isEmpty(iMTopOperationBody.icon)) {
            this.f10149b.setVisibility(0);
            BtsImageLoader.getInstance().loadInto(iMTopOperationBody.icon, this.f10149b);
        }
        this.f10150c.setText(iMTopOperationBody.tipText);
        if (TextUtils.isEmpty(iMTopOperationBody.btnLink)) {
            this.f10150c.setTextColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
            this.f10151d.setBackgroundColor(IMResource.getColor(R.color.bts_im_color_light_gray_s));
        } else {
            this.f10151d.setTextColor(IMResource.getColor(R.color.white));
            this.f10151d.setBackgroundColor(IMResource.getColor(R.color.im_nomix_detail_btn_color));
            this.f10151d.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    IMCommonUtil.startUriActivity(IMTopOperationView.this.getContext(), iMTopOperationBody.btnLink);
                }
            });
        }
        this.f10151d.setText(iMTopOperationBody.btnText);
    }

    public void showGuideView(String str) {
        IMTopOperationCusView iMTopOperationCusView = this.f10156i;
        if (iMTopOperationCusView == null || this.f10155h == null) {
            m6925a(str);
        } else {
            iMTopOperationCusView.showGuideView(str);
        }
    }

    /* renamed from: a */
    private void m6925a(String str) {
        if (this.f10152e == null) {
            this.f10152e = new IMSimpleGuideView.Builder(getContext()).isShowForkView(true).setGuideText(str).setTargetView(this.f10151d).setOutsideTouchable(true).setMaxWordNumSingleLine(16).setLayoutGravity(2).setGrivaty(3).create();
        }
        postDelayed(new Runnable() {
            public void run() {
                IMTopOperationView.this.f10152e.show();
            }
        }, 500);
    }
}

package com.didi.component.home_exception.widget;

import android.content.Context;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.home_exception.widget.ExceptionCardModel;
import com.didi.drouter.api.DRouter;
import com.didiglobal.common.common.util.EeveeRichTextUtil;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

public class ExceptionCardView extends LinearLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public Context f14083a;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ExceptionCardModel.Data f14084b;

    /* renamed from: c */
    private TextView f14085c;

    /* renamed from: d */
    private TextView f14086d;

    /* renamed from: e */
    private TextView f14087e;

    /* renamed from: f */
    private ImageView f14088f;

    /* renamed from: g */
    private ImageView f14089g;

    /* renamed from: h */
    private LinearLayout f14090h;

    /* renamed from: i */
    private TextView f14091i;

    public ExceptionCardView(Context context) {
        super(context);
        m9820a(context);
    }

    public ExceptionCardView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        m9820a(context);
    }

    public ExceptionCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        m9820a(context);
    }

    /* renamed from: a */
    private void m9820a(Context context) {
        this.f14083a = context;
        LayoutInflater.from(context).inflate(R.layout.home_exception_layout, this);
        setOrientation(1);
        this.f14085c = (TextView) findViewById(R.id.main_title_tv);
        this.f14086d = (TextView) findViewById(R.id.content_tv);
        this.f14088f = (ImageView) findViewById(R.id.no_position_iv);
        this.f14087e = (TextView) findViewById(R.id.enable_service_btn);
        this.f14090h = (LinearLayout) findViewById(R.id.open_sug_ll);
        this.f14091i = (TextView) findViewById(R.id.open_sug_tv);
        this.f14089g = (ImageView) findViewById(R.id.open_sug_arrow);
        this.f14087e.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExceptionCardView.this.f14084b != null && !TextUtils.isEmpty(ExceptionCardView.this.f14084b.btnScheme)) {
                    DRouter.build(ExceptionCardView.this.f14084b.btnScheme).start(ExceptionCardView.this.f14083a);
                }
            }
        });
        this.f14090h.setOnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                if (ExceptionCardView.this.f14084b != null && ExceptionCardView.this.f14084b.link != null && !TextUtils.isEmpty(ExceptionCardView.this.f14084b.link.url)) {
                    HashMap hashMap = new HashMap();
                    hashMap.put("action", 0);
                    GlobalOmegaUtils.trackEvent("map_loc_home_page_card_ck", (Map<String, Object>) hashMap);
                    DRouter.build(ExceptionCardView.this.f14084b.link.url).start(ExceptionCardView.this.f14083a);
                }
            }
        });
    }

    public void bindData(final ExceptionCardModel.Data data) {
        this.f14084b = data;
        if (data == null) {
            setVisibility(8);
            return;
        }
        setVisibility(0);
        if (data.title != null) {
            this.f14085c.setVisibility(0);
            EeveeRichTextUtil.setText(this.f14085c, data.title);
        } else {
            this.f14085c.setVisibility(8);
        }
        if (data.content != null) {
            this.f14086d.setVisibility(0);
            EeveeRichTextUtil.setText(this.f14086d, data.content);
        } else {
            this.f14086d.setVisibility(8);
        }
        if (TextUtils.isEmpty(data.img)) {
            this.f14088f.setVisibility(8);
        } else {
            this.f14088f.setVisibility(0);
            Glide.with((View) this).load(data.img).into(this.f14088f);
        }
        if (TextUtils.isEmpty(data.mainBtnText)) {
            this.f14087e.setVisibility(8);
        } else {
            this.f14087e.setVisibility(0);
            this.f14087e.setText(data.mainBtnText);
        }
        if (data.link != null) {
            this.f14090h.setVisibility(0);
            if (data.link.title != null) {
                this.f14091i.setVisibility(0);
                EeveeRichTextUtil.setText(this.f14091i, data.link.title);
            } else {
                this.f14091i.setVisibility(8);
            }
            if (!TextUtils.isEmpty(data.link.url)) {
                this.f14089g.setVisibility(0);
                this.f14090h.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (ExceptionCardView.this.f14083a != null) {
                            DRouter.build(data.link.url).start(ExceptionCardView.this.f14083a);
                        }
                    }
                });
                if (!TextUtils.isEmpty(data.linkArrow)) {
                    Glide.with((View) this).load(data.linkArrow).into(this.f14089g);
                    return;
                }
                return;
            }
            this.f14089g.setVisibility(8);
            return;
        }
        this.f14090h.setVisibility(8);
    }
}

package com.didi.global.globalgenerickit.drawer;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globalgenerickit.utils.GGKOnAntiShakeClickListener;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;

public final class GGKDrawer extends GGKAbsDrawer {

    /* renamed from: A */
    private TextView f22141A;

    /* renamed from: B */
    private TextView f22142B;

    /* renamed from: C */
    private TextView f22143C;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public GGKDrawerModel f22144a;

    /* renamed from: b */
    private View f22145b;

    /* renamed from: c */
    private View f22146c;

    /* renamed from: d */
    private View f22147d;

    /* renamed from: e */
    private View f22148e;

    /* renamed from: f */
    private View f22149f;

    /* renamed from: g */
    private View f22150g;

    /* renamed from: h */
    private View f22151h;

    /* renamed from: i */
    private View f22152i;

    /* renamed from: j */
    private LinearLayout f22153j;

    /* renamed from: k */
    private ImageView f22154k;

    /* renamed from: l */
    private TextView f22155l;

    /* renamed from: m */
    private TextView f22156m;

    /* renamed from: n */
    private FrameLayout f22157n;

    /* renamed from: o */
    private FrameLayout f22158o;

    /* renamed from: p */
    private ImageView f22159p;

    /* renamed from: q */
    private TextView f22160q;

    /* renamed from: r */
    private TextView f22161r;

    /* renamed from: s */
    private TextView f22162s;

    /* renamed from: t */
    private TextView f22163t;

    /* renamed from: u */
    private TextView f22164u;

    /* renamed from: v */
    private CheckBox f22165v;

    /* renamed from: w */
    private TextView f22166w;

    /* renamed from: x */
    private EditText f22167x;

    /* renamed from: y */
    private TextView f22168y;

    /* renamed from: z */
    private TextView f22169z;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.ggk_drawer_common_layout;
    }

    public GGKDrawer(Context context, GGKDrawerModel gGKDrawerModel) {
        super(context);
        this.f22144a = gGKDrawerModel;
        setLoadingEnable(gGKDrawerModel.isLoadingEnable);
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        m16030h();
        m16029g();
        m16020a();
        m16028f();
        m16027e();
        m16026d();
        m16025c();
        m16024b();
        if (this.f22144a.clickOutsideCanCancel) {
            setCanceledOnTouchOutside(true);
        }
        if (this.f22144a.backPressedEnabled) {
            setBackPressedEnabled(true);
        }
        return true;
    }

    /* renamed from: a */
    private void m16020a() {
        if (this.f22144a.extendedUpView != null) {
            this.f22157n.setVisibility(0);
            this.f22157n.addView(this.f22144a.extendedUpView);
        } else {
            this.f22157n.setVisibility(8);
        }
        if (this.f22144a.extendedBottomView != null) {
            this.f22158o.setVisibility(0);
            this.f22158o.addView(this.f22144a.extendedBottomView);
        } else {
            this.f22158o.setVisibility(8);
        }
        if (this.f22144a.extendedView != null) {
            this.f22157n.setVisibility(8);
            this.f22158o.setVisibility(8);
            this.f22145b.setVisibility(8);
            this.f22153j.addView(this.f22144a.extendedView);
        }
    }

    /* renamed from: b */
    private void m16024b() {
        if (this.f22144a.majorBtn != null && (this.f22144a.minorBtns == null || this.f22144a.minorBtns.size() == 0)) {
            m16022a(0, 8);
            m16023a(this.f22141A, this.f22144a.majorBtn.getText(), this.f22144a.majorBtn.getListener());
        } else if (this.f22144a.majorBtn != null && this.f22144a.minorBtns.size() == 1 && this.f22144a.isTwoBtnHorizontal) {
            m16022a(8, 0);
            m16023a(this.f22169z, this.f22144a.majorBtn.getText(), this.f22144a.majorBtn.getListener());
            m16023a(this.f22168y, this.f22144a.minorBtns.get(0).getText(), this.f22144a.minorBtns.get(0).getListener());
        } else if (this.f22144a.majorBtn != null && this.f22144a.minorBtns.size() == 1) {
            m16022a(0, 8);
            m16023a(this.f22141A, this.f22144a.majorBtn.getText(), this.f22144a.majorBtn.getListener());
            m16023a(this.f22142B, this.f22144a.minorBtns.get(0).getText(), this.f22144a.minorBtns.get(0).getListener());
        } else if (this.f22144a.majorBtn == null || this.f22144a.minorBtns.size() != 2) {
            m16022a(8, 8);
        } else {
            m16022a(0, 8);
            m16023a(this.f22141A, this.f22144a.majorBtn.getText(), this.f22144a.majorBtn.getListener());
            m16023a(this.f22142B, this.f22144a.minorBtns.get(0).getText(), this.f22144a.minorBtns.get(0).getListener());
            m16023a(this.f22143C, this.f22144a.minorBtns.get(1).getText(), this.f22144a.minorBtns.get(1).getListener());
        }
        if ((!TextUtils.isEmpty(this.f22144a.imgUrl) || this.f22144a.imgResId != 0) && !this.f22144a.isImgUp) {
            m16021a(15);
        } else if (this.f22144a.link != null && this.f22144a.link.linkModel != null && this.f22144a.link.listener != null) {
            m16021a(20);
        } else if (this.f22144a.checkbox != null && this.f22144a.checkbox.cbModel != null && this.f22144a.checkbox.listener != null) {
            m16021a(0);
        } else if (this.f22144a.edit != null && this.f22144a.edit.model != null && this.f22144a.edit.listener != null) {
            m16021a(20);
        } else if (this.f22144a.extendedUpView == null && this.f22144a.extendedBottomView == null) {
            m16021a(30);
        } else {
            m16021a(0);
        }
        if (this.f22144a.extendedView != null) {
            m16022a(8, 8);
        }
    }

    /* renamed from: a */
    private void m16021a(int i) {
        if (this.f22151h.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22151h.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f22151h.setLayoutParams(layoutParams);
        } else if (this.f22152i.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22152i.getLayoutParams();
            layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f22152i.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m16023a(TextView textView, String str, GGKOnAntiShakeClickListener gGKOnAntiShakeClickListener) {
        textView.setVisibility(0);
        textView.setText(str);
        textView.setOnClickListener(gGKOnAntiShakeClickListener);
    }

    /* renamed from: a */
    private void m16022a(int i, int i2) {
        this.f22152i.setVisibility(i);
        this.f22151h.setVisibility(i2);
    }

    /* renamed from: c */
    private void m16025c() {
        if (this.f22144a.edit == null || this.f22144a.edit.model == null || this.f22144a.edit.listener == null) {
            this.f22150g.setVisibility(8);
            return;
        }
        this.f22150g.setVisibility(0);
        this.f22144a.edit.model.bind(this.f22167x);
        this.f22167x.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                if (editable == null) {
                    GGKDrawer.this.f22144a.edit.listener.onInput((String) null);
                } else {
                    GGKDrawer.this.f22144a.edit.listener.onInput(editable.toString());
                }
            }
        });
    }

    /* renamed from: d */
    private void m16026d() {
        if (this.f22144a.checkbox == null || this.f22144a.checkbox.cbModel == null || this.f22144a.checkbox.listener == null) {
            this.f22149f.setVisibility(8);
            return;
        }
        this.f22149f.setVisibility(0);
        this.f22144a.checkbox.cbModel.bind(this.f22166w);
        this.f22165v.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                GGKDrawer.this.f22144a.checkbox.listener.onCheckedChanged(z);
            }
        });
    }

    /* renamed from: e */
    private void m16027e() {
        if (this.f22144a.link == null || this.f22144a.link.linkModel == null || this.f22144a.link.listener == null) {
            this.f22148e.setVisibility(8);
            return;
        }
        this.f22148e.setVisibility(0);
        this.f22144a.link.linkModel.bind(this.f22164u);
        this.f22164u.setOnClickListener(this.f22144a.link.listener);
    }

    /* renamed from: f */
    private void m16028f() {
        if (this.f22144a.selectedText == null || this.f22144a.changeBtn == null) {
            this.f22147d.setVisibility(8);
            return;
        }
        this.f22147d.setVisibility(0);
        this.f22144a.selectedText.bind(this.f22163t);
        this.f22162s.setText(this.f22144a.changeBtn.getText());
        this.f22162s.setOnClickListener(this.f22144a.changeBtn.getListener());
    }

    /* renamed from: g */
    private void m16029g() {
        Drawable drawable;
        Drawable drawable2;
        if (this.f22144a.isImgUp) {
            this.f22146c.setVisibility(8);
            this.f22145b.setVisibility(0);
            if (this.f22144a.imgPlaceHolder != 0) {
                drawable2 = this.mContext.getResources().getDrawable(this.f22144a.imgPlaceHolder);
            } else {
                drawable2 = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg);
            }
            if (!TextUtils.isEmpty(this.f22144a.imgUrl) || this.f22144a.imgResId != 0) {
                this.f22154k.setVisibility(0);
                ((RequestBuilder) Glide.with(this.mContext).load(!TextUtils.isEmpty(this.f22144a.imgUrl) ? this.f22144a.imgUrl : this.f22144a.imgResId != 0 ? Integer.valueOf(this.f22144a.imgResId) : DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg)).placeholder(drawable2)).into(this.f22154k);
            }
            this.f22144a.title.bind(this.f22155l);
            if (this.f22144a.subTitle != null) {
                this.f22156m.setVisibility(0);
                this.f22144a.subTitle.bind(this.f22156m);
                return;
            }
            this.f22156m.setVisibility(8);
            return;
        }
        this.f22145b.setVisibility(8);
        this.f22146c.setVisibility(0);
        if (this.f22144a.imgPlaceHolder != 0) {
            drawable = this.mContext.getResources().getDrawable(this.f22144a.imgPlaceHolder);
        } else {
            drawable = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_small_bg);
        }
        if (!TextUtils.isEmpty(this.f22144a.imgUrl) || this.f22144a.imgResId != 0) {
            this.f22159p.setVisibility(0);
            ((RequestBuilder) Glide.with(this.mContext).load(!TextUtils.isEmpty(this.f22144a.imgUrl) ? this.f22144a.imgUrl : this.f22144a.imgResId != 0 ? Integer.valueOf(this.f22144a.imgResId) : DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_small_bg)).placeholder(drawable)).into(this.f22159p);
        }
        this.f22144a.title.bind(this.f22160q);
        if (this.f22144a.subTitle != null) {
            this.f22161r.setVisibility(0);
            this.f22144a.subTitle.bind(this.f22161r);
            return;
        }
        this.f22161r.setVisibility(8);
    }

    /* renamed from: h */
    private void m16030h() {
        this.f22153j = (LinearLayout) findViewById(R.id.ll_drawer_common_container);
        this.f22145b = findViewById(R.id.ggk_drawer_title_include);
        this.f22146c = findViewById(R.id.ggk_drawer_img_right_include);
        this.f22147d = findViewById(R.id.ggk_drawer_selected_include);
        this.f22148e = findViewById(R.id.ggk_drawer_link_include);
        this.f22149f = findViewById(R.id.ggk_drawer_checkbox_include);
        this.f22150g = findViewById(R.id.ggk_drawer_edit_include);
        this.f22151h = findViewById(R.id.ggk_drawer_btn_horizontal_include);
        this.f22152i = findViewById(R.id.ggk_drawer_btn_vertical_include);
        this.f22154k = (ImageView) findViewById(R.id.ggk_drawer_up_img);
        this.f22155l = (TextView) findViewById(R.id.ggk_drawer_title);
        this.f22156m = (TextView) findViewById(R.id.ggk_drawer_sub_title);
        this.f22157n = (FrameLayout) findViewById(R.id.ggk_drawer_extended_up_view);
        this.f22158o = (FrameLayout) findViewById(R.id.ggk_drawer_extended_bottom_view);
        this.f22159p = (ImageView) findViewById(R.id.ggk_drawer_right_img);
        this.f22160q = (TextView) findViewById(R.id.ggk_drawer_left_title);
        this.f22161r = (TextView) findViewById(R.id.ggk_drawer_left_sub_title);
        this.f22162s = (TextView) findViewById(R.id.ggk_drawer_selected_btn);
        this.f22163t = (TextView) findViewById(R.id.ggk_drawer_selected_tv);
        this.f22164u = (TextView) findViewById(R.id.ggk_drawer_link_tv);
        this.f22165v = (CheckBox) findViewById(R.id.ggk_drawer_cb);
        this.f22166w = (TextView) findViewById(R.id.ggk_drawer_cb_desc);
        this.f22167x = (EditText) findViewById(R.id.ggk_drawer_edit);
        this.f22168y = (TextView) findViewById(R.id.ggk_drawer_btn_cancel);
        this.f22169z = (TextView) findViewById(R.id.ggk_drawer_btn_ok);
        this.f22141A = (TextView) findViewById(R.id.ggk_drawer_btn_v1);
        this.f22142B = (TextView) findViewById(R.id.ggk_drawer_btn_v2);
        this.f22143C = (TextView) findViewById(R.id.ggk_drawer_btn_v3);
    }
}

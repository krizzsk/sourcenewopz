package com.didi.global.globalgenerickit.dialog;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globalgenerickit.dialog.GGKRealUsedModel;
import com.didi.global.globalgenerickit.utils.UiUtils;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.global.globalgenerickit.dialog.a */
/* compiled from: GGKDialogView */
class C8583a {

    /* renamed from: A */
    private Context f22104A;

    /* renamed from: B */
    private View f22105B;

    /* renamed from: a */
    private GGKRealUsedModel f22106a;

    /* renamed from: b */
    private View f22107b;

    /* renamed from: c */
    private View f22108c;

    /* renamed from: d */
    private View f22109d;

    /* renamed from: e */
    private View f22110e;

    /* renamed from: f */
    private View f22111f;

    /* renamed from: g */
    private View f22112g;

    /* renamed from: h */
    private View f22113h;

    /* renamed from: i */
    private View f22114i;

    /* renamed from: j */
    private View f22115j;

    /* renamed from: k */
    private TextView f22116k;

    /* renamed from: l */
    private TextView f22117l;

    /* renamed from: m */
    private EditText f22118m;

    /* renamed from: n */
    private CheckBox f22119n;

    /* renamed from: o */
    private TextView f22120o;

    /* renamed from: p */
    private TextView f22121p;

    /* renamed from: q */
    private View f22122q;

    /* renamed from: r */
    private TextView f22123r;

    /* renamed from: s */
    private View f22124s;

    /* renamed from: t */
    private TextView f22125t;

    /* renamed from: u */
    private TextView f22126u;

    /* renamed from: v */
    private TextView f22127v;

    /* renamed from: w */
    private TextView f22128w;

    /* renamed from: x */
    private TextView f22129x;

    /* renamed from: y */
    private TextView f22130y;

    /* renamed from: z */
    private ImageView f22131z;

    public C8583a(Context context, GGKRealUsedModel gGKRealUsedModel) {
        this.f22104A = context;
        this.f22106a = gGKRealUsedModel;
        m16004b();
    }

    /* renamed from: b */
    private void m16004b() {
        if (this.f22105B == null) {
            this.f22105B = LayoutInflater.from(this.f22104A).inflate(R.layout.dialog_common_layout, (ViewGroup) null);
        }
    }

    /* renamed from: a */
    private <T extends View> T m16003a(int i) {
        View view = this.f22105B;
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }

    /* renamed from: a */
    public View mo66548a() {
        m16005c();
        return this.f22105B;
    }

    /* renamed from: c */
    private void m16005c() {
        m16006d();
        m16007e();
        m16008f();
        m16010h();
        m16009g();
        m16015m();
        m16011i();
        m16012j();
        m16013k();
        m16014l();
    }

    /* renamed from: d */
    private void m16006d() {
        this.f22107b = m16003a(R.id.ggk_dialog_title_include);
        this.f22108c = m16003a(R.id.ggk_dialog_content_include);
        this.f22109d = m16003a(R.id.ggk_dialog_checkbox_include);
        this.f22110e = m16003a(R.id.ggk_dialog_edit_include);
        this.f22111f = m16003a(R.id.ggk_dialog_btn_include);
        this.f22112g = m16003a(R.id.ggk_dialog_description_include);
        this.f22113h = m16003a(R.id.ggk_dialog_head_image_include);
        this.f22114i = m16003a(R.id.ggk_dialog_subtitle_include);
        this.f22115j = m16003a(R.id.ggk_dialog_subcontent_include);
        this.f22116k = (TextView) m16003a(R.id.ggk_dialog_title);
        this.f22117l = (TextView) m16003a(R.id.ggk_dialog_content);
        this.f22118m = (EditText) m16003a(R.id.ggk_dialog_edittext);
        this.f22119n = (CheckBox) m16003a(R.id.ggk_dialog_checkbox);
        this.f22120o = (TextView) m16003a(R.id.ggk_dialog_checkbox_content);
        this.f22121p = (TextView) m16003a(R.id.ggk_dialog_btn_main);
        this.f22123r = (TextView) m16003a(R.id.ggk_dialog_btn_other1);
        this.f22122q = m16003a(R.id.dialog_line2);
        this.f22125t = (TextView) m16003a(R.id.ggk_dialog_btn_other2);
        this.f22124s = m16003a(R.id.dialog_line3);
        this.f22126u = (TextView) m16003a(R.id.ggk_dialog_description_content);
        this.f22131z = (ImageView) m16003a(R.id.ggk_dialog_head_image);
        this.f22127v = (TextView) m16003a(R.id.ggk_dialog_subtitle);
        this.f22128w = (TextView) m16003a(R.id.ggk_dialog_subcontent_one);
        this.f22129x = (TextView) m16003a(R.id.ggk_dialog_subcontent_two);
        this.f22130y = (TextView) m16003a(R.id.ggk_dialog_subcontent_three);
    }

    /* renamed from: e */
    private void m16007e() {
        if (this.f22106a.f22085a != null) {
            this.f22107b.setVisibility(0);
            this.f22106a.f22085a.bind(this.f22116k);
        }
    }

    /* renamed from: f */
    private void m16008f() {
        if (this.f22106a.f22086b != null) {
            this.f22108c.setVisibility(0);
            if (this.f22106a.f22085a == null || TextUtils.isEmpty(this.f22106a.f22085a.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22117l.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f22104A, 16.0f);
                this.f22117l.setLayoutParams(layoutParams);
            }
            this.f22106a.f22086b.bind(this.f22117l);
        }
    }

    /* renamed from: g */
    private void m16009g() {
        if (this.f22106a.f22088d != null || this.f22106a.f22089e != null) {
            this.f22110e.setVisibility(0);
            this.f22118m.addTextChangedListener(this.f22106a.f22088d);
            this.f22118m.setHint(this.f22106a.f22089e);
        }
    }

    /* renamed from: h */
    private void m16010h() {
        if (this.f22106a.f22087c != null) {
            this.f22109d.setVisibility(0);
            this.f22106a.f22087c.bind(this.f22120o);
            this.f22119n.setOnCheckedChangeListener(this.f22106a.f22090f);
        }
    }

    /* renamed from: i */
    private void m16011i() {
        if (this.f22106a.f22092h != null) {
            this.f22112g.setVisibility(0);
            this.f22106a.f22092h.bind(this.f22126u);
            this.f22112g.setOnClickListener(this.f22106a.f22093i);
        }
    }

    /* renamed from: j */
    private void m16012j() {
        Drawable drawable;
        if (this.f22106a.f22094j != null) {
            this.f22113h.setVisibility(0);
            if (this.f22106a.f22094j.getImgPlaceHolder() != 0) {
                drawable = this.f22104A.getResources().getDrawable(this.f22106a.f22094j.getImgPlaceHolder());
            } else {
                drawable = DidiThemeManager.getIns().getResPicker(this.f22104A).getDrawable(R.attr.ggk_default_dialog_up_bg);
            }
            if (!TextUtils.isEmpty(this.f22106a.f22094j.getImgUrl()) || this.f22106a.f22094j.getImgResId() != 0) {
                ((RequestBuilder) Glide.with(this.f22104A).load(!TextUtils.isEmpty(this.f22106a.f22094j.getImgUrl()) ? this.f22106a.f22094j.getImgUrl() : this.f22106a.f22094j.getImgResId() != 0 ? Integer.valueOf(this.f22106a.f22094j.getImgResId()) : drawable).placeholder(drawable)).into(this.f22131z);
            }
        }
    }

    /* renamed from: k */
    private void m16013k() {
        if (this.f22106a.f22095k != null) {
            this.f22114i.setVisibility(0);
            this.f22106a.f22095k.bind(this.f22127v);
        }
    }

    /* renamed from: l */
    private void m16014l() {
        if (this.f22106a.f22096l != null) {
            this.f22115j.setVisibility(0);
            List<GGKRealUsedModel.TextWidgetModel> list = this.f22106a.f22096l;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    list.get(0).bind(this.f22128w);
                } else if (i == 1) {
                    list.get(1).bind(this.f22129x);
                } else if (i == 2) {
                    list.get(2).bind(this.f22130y);
                }
            }
        }
    }

    /* renamed from: m */
    private void m16015m() {
        if (this.f22106a.f22091g != null) {
            int size = this.f22106a.f22091g.size();
            if (this.f22106a.f22087c != null && !TextUtils.isEmpty(this.f22106a.f22087c.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22111f.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f22104A, 0.0f);
                this.f22111f.setLayoutParams(layoutParams);
            }
            if (size == 1) {
                this.f22111f.setVisibility(0);
                this.f22123r.setVisibility(8);
                this.f22122q.setVisibility(8);
                this.f22125t.setVisibility(8);
                this.f22124s.setVisibility(8);
                this.f22121p.setText(this.f22106a.f22091g.get(0).getText());
                this.f22121p.setBackground(this.f22104A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
                this.f22121p.setOnClickListener(this.f22106a.f22091g.get(0).getListener());
            } else if (size == 2) {
                this.f22111f.setVisibility(0);
                this.f22125t.setVisibility(8);
                this.f22124s.setVisibility(8);
                this.f22121p.setText(this.f22106a.f22091g.get(0).getText());
                this.f22123r.setText(this.f22106a.f22091g.get(1).getText());
                this.f22123r.setBackground(this.f22104A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
                this.f22121p.setOnClickListener(this.f22106a.f22091g.get(0).getListener());
                this.f22123r.setOnClickListener(this.f22106a.f22091g.get(1).getListener());
            } else if (size == 3) {
                this.f22111f.setVisibility(0);
                this.f22121p.setText(this.f22106a.f22091g.get(0).getText());
                this.f22123r.setText(this.f22106a.f22091g.get(1).getText());
                this.f22125t.setText(this.f22106a.f22091g.get(2).getText());
                this.f22121p.setOnClickListener(this.f22106a.f22091g.get(0).getListener());
                this.f22123r.setOnClickListener(this.f22106a.f22091g.get(1).getListener());
                this.f22125t.setOnClickListener(this.f22106a.f22091g.get(2).getListener());
                this.f22125t.setBackground(this.f22104A.getResources().getDrawable(R.drawable.ggk_dialog_last_btn_selector));
            }
        }
    }
}

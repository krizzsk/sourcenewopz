package com.didi.global.globaluikit.dialog;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.global.globaluikit.button.UnitUtils;
import com.didi.global.globaluikit.dialog.LEGORealUsedModel;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;
import java.util.List;

/* renamed from: com.didi.global.globaluikit.dialog.a */
/* compiled from: LEGODialogView */
class C8649a {

    /* renamed from: A */
    private View f22494A;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGORealUsedModel f22495a;

    /* renamed from: b */
    private RoundCornerRelativeLayout f22496b;

    /* renamed from: c */
    private View f22497c;

    /* renamed from: d */
    private View f22498d;

    /* renamed from: e */
    private View f22499e;

    /* renamed from: f */
    private View f22500f;

    /* renamed from: g */
    private View f22501g;

    /* renamed from: h */
    private View f22502h;

    /* renamed from: i */
    private View f22503i;

    /* renamed from: j */
    private View f22504j;

    /* renamed from: k */
    private TextView f22505k;

    /* renamed from: l */
    private TextView f22506l;

    /* renamed from: m */
    private CheckBox f22507m;

    /* renamed from: n */
    private TextView f22508n;

    /* renamed from: o */
    private TextView f22509o;

    /* renamed from: p */
    private View f22510p;

    /* renamed from: q */
    private TextView f22511q;

    /* renamed from: r */
    private View f22512r;

    /* renamed from: s */
    private TextView f22513s;

    /* renamed from: t */
    private TextView f22514t;

    /* renamed from: u */
    private TextView f22515u;

    /* renamed from: v */
    private TextView f22516v;

    /* renamed from: w */
    private TextView f22517w;

    /* renamed from: x */
    private TextView f22518x;

    /* renamed from: y */
    private LEGORoundImageView f22519y;

    /* renamed from: z */
    private Context f22520z;

    public C8649a(Context context, LEGORealUsedModel lEGORealUsedModel) {
        this.f22520z = context;
        this.f22495a = lEGORealUsedModel;
        m16189b();
    }

    /* renamed from: b */
    private void m16189b() {
        if (this.f22494A == null) {
            this.f22494A = LayoutInflater.from(this.f22520z).inflate(R.layout.lego_dialog_common_layout, (ViewGroup) null);
        }
    }

    /* renamed from: a */
    private <T extends View> T m16187a(int i) {
        View view = this.f22494A;
        if (view == null) {
            return null;
        }
        return view.findViewById(i);
    }

    /* renamed from: a */
    public View mo66913a() {
        m16190c();
        return this.f22494A;
    }

    /* renamed from: c */
    private void m16190c() {
        m16191d();
        m16192e();
        m16193f();
        m16194g();
        m16199l();
        m16195h();
        m16196i();
        m16197j();
        m16198k();
    }

    /* renamed from: d */
    private void m16191d() {
        RoundCornerRelativeLayout roundCornerRelativeLayout = (RoundCornerRelativeLayout) m16187a((int) R.id.lego_dialog_bg_layout);
        this.f22496b = roundCornerRelativeLayout;
        roundCornerRelativeLayout.setRadius(UnitUtils.dp2px(this.f22520z, 20.0f));
        this.f22497c = m16187a((int) R.id.lego_dialog_title_include);
        this.f22498d = m16187a((int) R.id.lego_dialog_content_include);
        this.f22499e = m16187a((int) R.id.lego_dialog_checkbox_include);
        this.f22500f = m16187a((int) R.id.lego_dialog_btn_include);
        this.f22501g = m16187a((int) R.id.lego_dialog_description_include);
        this.f22502h = m16187a((int) R.id.lego_dialog_head_image_include);
        this.f22503i = m16187a((int) R.id.lego_dialog_subtitle_include);
        this.f22504j = m16187a((int) R.id.lego_dialog_subcontent_include);
        this.f22505k = (TextView) m16187a((int) R.id.lego_dialog_title);
        this.f22506l = (TextView) m16187a((int) R.id.lego_dialog_content);
        this.f22507m = (CheckBox) m16187a((int) R.id.lego_dialog_checkbox);
        this.f22508n = (TextView) m16187a((int) R.id.lego_dialog_checkbox_content);
        this.f22509o = (TextView) m16187a((int) R.id.lego_dialog_btn_main);
        this.f22511q = (TextView) m16187a((int) R.id.lego_dialog_btn_other1);
        this.f22510p = m16187a((int) R.id.dialog_line2);
        this.f22513s = (TextView) m16187a((int) R.id.lego_dialog_btn_other2);
        this.f22512r = m16187a((int) R.id.dialog_line3);
        this.f22514t = (TextView) m16187a((int) R.id.lego_dialog_description_content);
        this.f22519y = (LEGORoundImageView) m16187a((int) R.id.lego_dialog_head_image);
        this.f22515u = (TextView) m16187a((int) R.id.lego_dialog_subtitle);
        this.f22516v = (TextView) m16187a((int) R.id.lego_dialog_subcontent_one);
        this.f22517w = (TextView) m16187a((int) R.id.lego_dialog_subcontent_two);
        this.f22518x = (TextView) m16187a((int) R.id.lego_dialog_subcontent_three);
    }

    /* renamed from: e */
    private void m16192e() {
        if (this.f22495a.mRichTitle != null) {
            this.f22497c.setVisibility(0);
            this.f22495a.mRichTitle.bindTextView(this.f22505k);
        } else if (this.f22495a.mTitle != null) {
            this.f22497c.setVisibility(0);
            this.f22495a.mTitle.bind(this.f22505k);
        }
    }

    /* renamed from: f */
    private void m16193f() {
        if (this.f22495a.mRichSubTitle != null) {
            this.f22498d.setVisibility(0);
            if (this.f22495a.mRichSubTitle == null || TextUtils.isEmpty(this.f22495a.mRichSubTitle.getContent())) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22506l.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f22520z, 16.0f);
                this.f22506l.setLayoutParams(layoutParams);
            }
            this.f22495a.mRichSubTitle.bindTextView(this.f22506l);
        } else if (this.f22495a.mContent != null) {
            this.f22498d.setVisibility(0);
            if (this.f22495a.mTitle == null || TextUtils.isEmpty(this.f22495a.mTitle.text)) {
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22506l.getLayoutParams();
                layoutParams2.topMargin = UiUtils.dip2px(this.f22520z, 16.0f);
                this.f22506l.setLayoutParams(layoutParams2);
            }
            this.f22495a.mContent.bind(this.f22506l);
        }
    }

    /* renamed from: g */
    private void m16194g() {
        if (this.f22495a.mRichCheckbox == null || this.f22495a.mCheckListener == null) {
            this.f22499e.setVisibility(8);
        } else {
            this.f22499e.setVisibility(0);
            this.f22495a.mRichCheckbox.bindTextView(this.f22508n);
            this.f22507m.setChecked(this.f22495a.mIsChecked);
            this.f22507m.setOnCheckedChangeListener(new LEGODialogView$1(this));
        }
        if (this.f22495a.mCheckContent != null) {
            this.f22499e.setVisibility(0);
            this.f22495a.mCheckContent.bind(this.f22508n);
            this.f22507m.setOnCheckedChangeListener(this.f22495a.mLEGOCheckboxListener);
        }
    }

    /* renamed from: h */
    private void m16195h() {
        if (this.f22495a.mDescription != null) {
            this.f22501g.setVisibility(0);
            this.f22495a.mDescription.bind(this.f22514t);
            this.f22501g.setOnClickListener(this.f22495a.mLinkClickedListener);
        }
    }

    /* renamed from: i */
    private void m16196i() {
        Drawable drawable;
        if (this.f22495a.mImageModel != null) {
            this.f22502h.setVisibility(0);
            if (this.f22495a.mImageModel.getImgPlaceHolder() != 0) {
                drawable = this.f22520z.getResources().getDrawable(this.f22495a.mImageModel.getImgPlaceHolder());
            } else {
                drawable = DidiThemeManager.getIns().getResPicker(this.f22520z).getDrawable(R.attr.ggk_default_dialog_up_bg);
            }
            Context context = this.f22520z;
            if (context instanceof FragmentActivity) {
                if (((FragmentActivity) context).isDestroyed()) {
                    return;
                }
            } else if ((context instanceof Activity) && ((Activity) context).isDestroyed()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f22495a.mImageModel.getImgUrl()) || this.f22495a.mImageModel.getImgResId() != 0) {
                ((RequestBuilder) Glide.with(this.f22520z).load(!TextUtils.isEmpty(this.f22495a.mImageModel.getImgUrl()) ? this.f22495a.mImageModel.getImgUrl() : this.f22495a.mImageModel.getImgResId() != 0 ? Integer.valueOf(this.f22495a.mImageModel.getImgResId()) : drawable).placeholder(drawable)).into((ImageView) this.f22519y);
            }
        }
    }

    /* renamed from: j */
    private void m16197j() {
        if (this.f22495a.mSubTitle != null) {
            this.f22503i.setVisibility(0);
            this.f22495a.mSubTitle.bind(this.f22515u);
        }
    }

    /* renamed from: k */
    private void m16198k() {
        if (this.f22495a.mSubContents != null) {
            this.f22504j.setVisibility(0);
            List<LEGORealUsedModel.TextWidgetModel> list = this.f22495a.mSubContents;
            for (int i = 0; i < list.size(); i++) {
                if (i == 0) {
                    list.get(0).bind(this.f22516v);
                } else if (i == 1) {
                    list.get(1).bind(this.f22517w);
                } else if (i == 2) {
                    list.get(2).bind(this.f22518x);
                }
            }
        }
    }

    /* renamed from: l */
    private void m16199l() {
        if (this.f22495a.mListOfBtns != null) {
            int size = this.f22495a.mListOfBtns.size();
            if (this.f22495a.mCheckContent != null && !TextUtils.isEmpty(this.f22495a.mCheckContent.text)) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22500f.getLayoutParams();
                layoutParams.topMargin = UiUtils.dip2px(this.f22520z, 0.0f);
                this.f22500f.setLayoutParams(layoutParams);
            }
            if (size == 1) {
                this.f22500f.setVisibility(0);
                this.f22511q.setVisibility(8);
                this.f22510p.setVisibility(8);
                this.f22513s.setVisibility(8);
                this.f22512r.setVisibility(8);
                this.f22509o.setText(this.f22495a.mListOfBtns.get(0).getText());
                this.f22509o.setBackground(this.f22520z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
                this.f22509o.setOnClickListener(this.f22495a.mListOfBtns.get(0).getListener());
            } else if (size == 2) {
                this.f22500f.setVisibility(0);
                this.f22513s.setVisibility(8);
                this.f22512r.setVisibility(8);
                this.f22509o.setText(this.f22495a.mListOfBtns.get(0).getText());
                this.f22511q.setText(this.f22495a.mListOfBtns.get(1).getText());
                this.f22511q.setBackground(this.f22520z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
                this.f22509o.setOnClickListener(this.f22495a.mListOfBtns.get(0).getListener());
                this.f22511q.setOnClickListener(this.f22495a.mListOfBtns.get(1).getListener());
            } else if (size == 3) {
                this.f22500f.setVisibility(0);
                this.f22509o.setText(this.f22495a.mListOfBtns.get(0).getText());
                this.f22511q.setText(this.f22495a.mListOfBtns.get(1).getText());
                this.f22513s.setText(this.f22495a.mListOfBtns.get(2).getText());
                this.f22509o.setOnClickListener(this.f22495a.mListOfBtns.get(0).getListener());
                this.f22511q.setOnClickListener(this.f22495a.mListOfBtns.get(1).getListener());
                this.f22513s.setOnClickListener(this.f22495a.mListOfBtns.get(2).getListener());
                this.f22513s.setBackground(this.f22520z.getResources().getDrawable(R.drawable.lego_dialog_last_btn_selector));
            }
        }
    }
}

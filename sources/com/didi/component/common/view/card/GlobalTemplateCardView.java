package com.didi.component.common.view.card;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.didi.component.business.util.HighlightUtil;
import com.didi.component.business.util.UiUtils;
import com.didi.component.common.util.GLog;
import com.didi.component.common.util.UIUtils;
import com.didi.component.common.view.card.GlobalTemplateCardModel;
import com.didi.sdk.log.Logger;
import com.taxis99.R;

public class GlobalTemplateCardView extends LinearLayout {

    /* renamed from: a */
    private static final String f11895a = "GlobalTemplateBaseCardView";

    /* renamed from: b */
    private TextView f11896b;

    /* renamed from: c */
    private TextView f11897c;

    /* renamed from: d */
    private TextView f11898d;

    /* renamed from: e */
    private TextView f11899e;

    /* renamed from: f */
    private TextView f11900f;

    /* renamed from: g */
    private TextView f11901g;

    /* renamed from: h */
    private ImageView f11902h;

    /* renamed from: i */
    private View f11903i;

    /* renamed from: j */
    private ViewStub f11904j;

    /* renamed from: k */
    private TextView f11905k;

    /* renamed from: l */
    private FrameLayout f11906l;

    /* renamed from: m */
    private FrameLayout f11907m;

    /* renamed from: n */
    private volatile boolean f11908n;

    /* renamed from: o */
    private ViewStub f11909o;

    /* renamed from: p */
    private TextView f11910p;

    /* access modifiers changed from: protected */
    public int getLayoutResId() {
        return R.layout.global_template_card_layout;
    }

    public GlobalTemplateCardView(Context context) {
        this(context, (AttributeSet) null);
    }

    public GlobalTemplateCardView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
    }

    public GlobalTemplateCardView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        this.f11908n = false;
    }

    /* renamed from: a */
    private void m8038a() {
        LayoutInflater.from(getContext()).inflate(getLayoutResId(), this, true);
        setOrientation(1);
        this.f11896b = (TextView) findViewById(R.id.global_template_card_main_title_tv);
        this.f11897c = (TextView) findViewById(R.id.global_template_card_sub_title_tv);
        this.f11898d = (TextView) findViewById(R.id.global_template_card_content_tv);
        this.f11899e = (TextView) findViewById(R.id.global_template_card_btn_describe);
        this.f11900f = (TextView) findViewById(R.id.global_template_card_right_btn);
        this.f11901g = (TextView) findViewById(R.id.global_template_card_left_btn);
        this.f11902h = (ImageView) findViewById(R.id.global_template_card_content_iv);
        this.f11906l = (FrameLayout) findViewById(R.id.global_template_card_big_extend_layout);
        this.f11907m = (FrameLayout) findViewById(R.id.global_template_card_small_extend_layout);
        this.f11903i = findViewById(R.id.global_template_card_btn_container);
        this.f11909o = (ViewStub) findViewById(R.id.global_template_card_btn_container_new_style);
        this.f11904j = (ViewStub) findViewById(R.id.global_template_card_link_btn_container);
    }

    public void setData(GlobalTemplateCardModel globalTemplateCardModel) {
        if (globalTemplateCardModel == null) {
            setVisibility(8);
            Logger.m25809e(f11895a, "data is null! view is gone!");
            return;
        }
        m8041b();
        setTextColorStyle(globalTemplateCardModel.getTextColorStyle());
        setTextAreaModel(globalTemplateCardModel.textAreaModel);
        setBtnModel(globalTemplateCardModel.btnModel);
        setLinkBtnModel(globalTemplateCardModel.linkBtnModel);
        setBigExtendsViewModel(globalTemplateCardModel.bigExtendsViewModel);
        setSmallExtendsViewModel(globalTemplateCardModel.smallExtendsViewModel);
        setImageModel(globalTemplateCardModel.imageModel);
        setNewBtnModel(globalTemplateCardModel.newBtnModel);
        if (globalTemplateCardModel.getCardBackGround() != 0) {
            setBackgroundResource(globalTemplateCardModel.getCardBackGround());
        }
    }

    /* renamed from: b */
    private void m8041b() {
        if (!this.f11908n) {
            m8038a();
            this.f11908n = true;
        }
    }

    public ViewGroup getBigExtendsContainer() {
        return this.f11906l;
    }

    public ViewGroup getSmallExtendsContainer() {
        return this.f11907m;
    }

    public void setTextAreaModel(GlobalTemplateCardModel.TextAreaModel textAreaModel) {
        if (textAreaModel != null) {
            m8041b();
            m8040a(this.f11896b, HighlightUtil.highlight(getContext(), textAreaModel.maintTitleText));
            m8040a(this.f11897c, (CharSequence) textAreaModel.subTitleText);
            m8040a(this.f11898d, HighlightUtil.highlight(getContext(), textAreaModel.contentText));
            setMainTitleMaxLine(textAreaModel.mainTitleMaxLine);
        }
    }

    public void setBigExtendsViewModel(GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        m8041b();
        m8039a((ViewGroup) this.f11906l, extendsViewModel);
        if (this.f11903i.getVisibility() == 8) {
            ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f11906l.getLayoutParams();
            marginLayoutParams.bottomMargin = UiUtils.dip2px(getContext(), 16.0f);
            this.f11906l.setLayoutParams(marginLayoutParams);
        }
    }

    public void setSmallExtendsViewModel(GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        m8041b();
        m8039a((ViewGroup) this.f11907m, extendsViewModel);
    }

    /* renamed from: a */
    private void m8039a(ViewGroup viewGroup, GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        if (extendsViewModel == null || extendsViewModel.view == null) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (extendsViewModel.layoutParams == null) {
            viewGroup.addView(extendsViewModel.view);
        } else {
            viewGroup.addView(extendsViewModel.view, extendsViewModel.layoutParams);
        }
    }

    /* renamed from: b */
    private void m8042b(ViewGroup viewGroup, GlobalTemplateCardModel.ExtendsViewModel extendsViewModel) {
        if (extendsViewModel == null || extendsViewModel.view == null) {
            viewGroup.setVisibility(8);
            return;
        }
        viewGroup.setVisibility(0);
        viewGroup.removeAllViews();
        if (extendsViewModel.layoutParams == null) {
            viewGroup.addView(extendsViewModel.view);
        } else {
            viewGroup.addView(extendsViewModel.view, extendsViewModel.layoutParams);
        }
    }

    public void setLinkBtnModel(GlobalTemplateCardModel.LinkBtnModel linkBtnModel) {
        if (linkBtnModel == null || TextUtils.isEmpty(linkBtnModel.linkText)) {
            this.f11904j.setVisibility(8);
            return;
        }
        if (this.f11905k == null) {
            this.f11904j.inflate();
            this.f11905k = (TextView) findViewById(R.id.global_template_card_link_btn);
        }
        this.f11904j.setVisibility(0);
        this.f11905k.setText(linkBtnModel.linkText);
        this.f11905k.setOnClickListener(linkBtnModel.listener);
    }

    public void setBtnModel(GlobalTemplateCardModel.BtnModel btnModel) {
        m8041b();
        if (btnModel == null) {
            this.f11903i.setVisibility(8);
        } else if (btnModel.type == 0) {
            this.f11903i.setVisibility(0);
            m8040a(this.f11899e, (CharSequence) btnModel.describeText);
            m8040a(this.f11900f, (CharSequence) btnModel.btnText);
            this.f11903i.setOnClickListener(btnModel.listener);
        } else if (btnModel.type == 1) {
            this.f11901g.setVisibility(0);
            m8040a(this.f11901g, (CharSequence) btnModel.btnText);
            this.f11901g.setOnClickListener(btnModel.listener);
        }
    }

    public void setNewBtnModel(GlobalTemplateCardModel.NewBtnModel newBtnModel) {
        m8041b();
        if (newBtnModel != null) {
            this.f11909o.inflate();
            TextView textView = (TextView) findViewById(R.id.global_template_card_btn_new_style);
            this.f11910p = textView;
            m8040a(textView, (CharSequence) newBtnModel.btnText);
            this.f11910p.setOnClickListener(newBtnModel.listener);
        }
    }

    public void setImageModel(GlobalTemplateCardModel.ImageModel imageModel) {
        m8041b();
        if (imageModel != null) {
            if (imageModel.width != 0 && imageModel.height != 0) {
                ViewGroup.LayoutParams layoutParams = this.f11902h.getLayoutParams();
                layoutParams.height = UIUtils.dip2pxInt(getContext(), (float) imageModel.height);
                layoutParams.width = UIUtils.dip2pxInt(getContext(), (float) imageModel.width);
                this.f11902h.setLayoutParams(layoutParams);
                this.f11902h.setVisibility(0);
            } else if (imageModel.drawableId == 0 && !TextUtils.isEmpty(imageModel.drawableUri)) {
                GLog.m7968e(f11895a, "imageView will not load net image while you not set the width or height!!!");
                return;
            }
            if (imageModel.drawableId != 0) {
                this.f11902h.setImageResource(imageModel.drawableId);
            } else if (!TextUtils.isEmpty(imageModel.drawableUri)) {
                ((RequestBuilder) Glide.with(getContext()).asBitmap().load(imageModel.drawableUri).placeholder(imageModel.defaultDrawableId)).into(this.f11902h);
            } else if (imageModel.defaultDrawableId != 0) {
                this.f11902h.setImageResource(imageModel.defaultDrawableId);
            }
            if (imageModel.style == 1) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f11902h.getLayoutParams();
                layoutParams2.rightMargin = UIUtils.dip2pxInt(getContext(), 0.0f);
                layoutParams2.addRule(11);
            } else if (imageModel.style == 4) {
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f11902h.getLayoutParams();
                layoutParams3.rightMargin = UIUtils.dip2pxInt(getContext(), 16.0f);
                layoutParams3.topMargin = UIUtils.dip2pxInt(getContext(), 18.0f);
                layoutParams3.addRule(11);
            } else if (imageModel.style == 2) {
                RelativeLayout.LayoutParams layoutParams4 = (RelativeLayout.LayoutParams) this.f11902h.getLayoutParams();
                layoutParams4.rightMargin = UIUtils.dip2pxInt(getContext(), 16.0f);
                layoutParams4.addRule(15);
            } else if (imageModel.style == 3) {
                RelativeLayout.LayoutParams layoutParams5 = (RelativeLayout.LayoutParams) this.f11902h.getLayoutParams();
                layoutParams5.rightMargin = UIUtils.dip2pxInt(getContext(), 0.0f);
                layoutParams5.addRule(15);
            }
        }
    }

    public void setTextColorStyle(int i) {
        if (i == 1) {
            this.f11900f.setTextColor(-1);
            this.f11896b.setTextColor(-1);
            this.f11897c.setTextColor(-1);
            this.f11899e.setTextColor(-1);
            this.f11898d.setTextColor(-1);
            this.f11900f.setCompoundDrawables((Drawable) null, (Drawable) null, getContext().getResources().getDrawable(R.drawable.global_template_card_arrow_white), (Drawable) null);
            this.f11903i.setBackgroundResource(R.drawable.global_template_btn_light_text_bg);
            return;
        }
        this.f11900f.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f11896b.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f11899e.setTextColor(getContext().getResources().getColor(R.color.g_color_333333));
        this.f11897c.setTextColor(getContext().getResources().getColor(R.color.g_color_999999));
        this.f11898d.setTextColor(getContext().getResources().getColor(R.color.g_color_999999));
        this.f11900f.setCompoundDrawablesWithIntrinsicBounds((Drawable) null, (Drawable) null, getContext().getResources().getDrawable(R.drawable.global_template_card_arrow_black), (Drawable) null);
        this.f11903i.setBackgroundResource(R.drawable.global_template_btn_dark_text_bg);
    }

    /* renamed from: a */
    private void m8040a(TextView textView, CharSequence charSequence) {
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else if (!TextUtils.equals(charSequence, textView.getText())) {
            textView.setText(charSequence);
            textView.setVisibility(0);
        }
    }

    private void setMainTitleMaxLine(int i) {
        this.f11896b.setMaxLines(i);
    }
}

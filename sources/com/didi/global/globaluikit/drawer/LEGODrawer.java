package com.didi.global.globaluikit.drawer;

import android.app.Activity;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import com.airbnb.lottie.LottieAnimationView;
import com.android.didi.theme.DidiThemeManager;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.integration.webp.decoder.WebpDrawable;
import com.bumptech.glide.integration.webp.decoder.WebpDrawableTransformation;
import com.bumptech.glide.load.resource.bitmap.FitCenter;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.global.globaluikit.LEGOUIKit;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener2;
import com.didi.global.globaluikit.config.LEGOUIConfig;
import com.didi.global.globaluikit.utils.UiUtils;
import com.didi.global.globaluikit.widget.RoundCornerRelativeLayout;
import com.taxis99.R;

public final class LEGODrawer extends LEGOAbsDrawer {

    /* renamed from: A */
    private TextView f22544A;

    /* renamed from: B */
    private View f22545B;

    /* renamed from: C */
    private boolean f22546C;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public LEGODrawerModel f22547a;

    /* renamed from: b */
    private View f22548b;

    /* renamed from: c */
    private View f22549c;

    /* renamed from: d */
    private View f22550d;

    /* renamed from: e */
    private View f22551e;

    /* renamed from: f */
    private View f22552f;

    /* renamed from: g */
    private View f22553g;

    /* renamed from: h */
    private ImageView f22554h;

    /* renamed from: i */
    private RoundCornerRelativeLayout f22555i;

    /* renamed from: j */
    private ImageView f22556j;

    /* renamed from: k */
    private TextView f22557k;

    /* renamed from: l */
    private TextView f22558l;

    /* renamed from: m */
    private FrameLayout f22559m;

    /* renamed from: n */
    private FrameLayout f22560n;

    /* renamed from: o */
    private FrameLayout f22561o;

    /* renamed from: p */
    private TextView f22562p;

    /* renamed from: q */
    private TextView f22563q;

    /* renamed from: r */
    private TextView f22564r;

    /* renamed from: s */
    private CheckBox f22565s;

    /* renamed from: t */
    private TextView f22566t;

    /* renamed from: u */
    private TextView f22567u;

    /* renamed from: v */
    private TextView f22568v;

    /* renamed from: w */
    private LottieAnimationView f22569w;

    /* renamed from: x */
    private TextView f22570x;

    /* renamed from: y */
    private LottieAnimationView f22571y;

    /* renamed from: z */
    private TextView f22572z;

    /* access modifiers changed from: protected */
    public int getCustomView() {
        return R.layout.lego_drawer_common_layout;
    }

    public LEGODrawer(Context context, LEGODrawerModel lEGODrawerModel) {
        super(context);
        this.f22547a = lEGODrawerModel;
        setLoadingEnable(lEGODrawerModel.isLoadingEnable);
    }

    /* access modifiers changed from: protected */
    public boolean onShowPrepare() {
        m16218g();
        m16217f();
        m16204a();
        m16216e();
        m16215d();
        m16214c();
        m16212b();
        setDismissListener(this.f22547a.dismissListener);
        if (this.f22547a.clickOutsideCanCancel) {
            setCanceledOnTouchOutside(true);
        }
        if (this.f22547a.backPressedEnabled) {
            setBackPressedEnabled(true);
        }
        if (this.f22547a.isShowCloseImg && this.f22547a.mCloseImgListener == null) {
            this.f22554h.setVisibility(0);
            this.f22554h.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    LEGODrawer.this.dismiss();
                }
            });
        } else if (this.f22547a.isShowCloseImg) {
            this.f22554h.setVisibility(0);
            this.f22554h.setOnClickListener(new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    LEGODrawer.this.f22547a.mCloseImgListener.onAntiShakeClick(view);
                    LEGODrawer.this.dismiss();
                }
            });
        } else {
            this.f22554h.setVisibility(8);
            this.f22554h.setOnClickListener((View.OnClickListener) null);
        }
        return true;
    }

    /* renamed from: a */
    private void m16204a() {
        if (this.f22547a.allExtendView != null) {
            this.f22561o.setVisibility(0);
            this.f22561o.addView(this.f22547a.allExtendView);
            this.f22548b.setVisibility(8);
            return;
        }
        this.f22561o.setVisibility(8);
        if (this.f22547a.extendedUpView != null) {
            this.f22559m.setVisibility(0);
            this.f22559m.addView(this.f22547a.extendedUpView);
        } else {
            this.f22559m.setVisibility(8);
        }
        if (this.f22547a.extendedBottomView != null) {
            this.f22560n.setVisibility(0);
            this.f22560n.addView(this.f22547a.extendedBottomView);
        } else {
            this.f22560n.setVisibility(8);
        }
        if (this.f22547a.extendedView != null) {
            this.f22561o.setVisibility(0);
            this.f22561o.addView(this.f22547a.extendedView);
            this.f22548b.setVisibility(0);
            this.f22557k.setVisibility(8);
            this.f22558l.setVisibility(8);
            return;
        }
        this.f22561o.setVisibility(8);
    }

    /* renamed from: b */
    private void m16212b() {
        if (this.f22547a.majorBtn != null && (this.f22547a.minorBtns == null || this.f22547a.minorBtns.size() == 0)) {
            m16206a(0, 8);
            m16207a(this.f22570x, this.f22547a.majorBtn);
        } else if (this.f22547a.majorBtn != null && this.f22547a.minorBtns.size() == 1 && this.f22547a.isTwoBtnHorizontal) {
            m16206a(8, 0);
            m16207a(this.f22568v, this.f22547a.majorBtn);
            m16207a(this.f22567u, this.f22547a.minorBtns.get(0));
        } else if (this.f22547a.majorBtn != null && this.f22547a.minorBtns.size() == 1) {
            m16206a(0, 8);
            m16207a(this.f22570x, this.f22547a.majorBtn);
            m16207a(this.f22572z, this.f22547a.minorBtns.get(0));
        } else if (this.f22547a.majorBtn == null || this.f22547a.minorBtns.size() != 2) {
            m16206a(8, 8);
        } else {
            m16206a(0, 8);
            m16207a(this.f22570x, this.f22547a.majorBtn);
            m16207a(this.f22572z, this.f22547a.minorBtns.get(0));
            m16207a(this.f22544A, this.f22547a.minorBtns.get(1));
        }
        if ((this.f22547a.checkbox == null || this.f22547a.checkbox.cbModel == null || this.f22547a.checkbox.listener == null) && (this.f22547a.mRichCheckbox == null || this.f22547a.mCheckListener == null)) {
            m16205a(40);
        } else {
            m16205a(22);
        }
        if (this.f22547a.allExtendView != null) {
            m16206a(8, 8);
        }
    }

    /* renamed from: a */
    private void m16205a(int i) {
        if (this.f22552f.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22552f.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f22552f.setLayoutParams(layoutParams);
        } else if (this.f22553g.getVisibility() == 0) {
            LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22553g.getLayoutParams();
            layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) i);
            this.f22553g.setLayoutParams(layoutParams2);
        }
    }

    /* renamed from: a */
    private void m16207a(TextView textView, final LEGOBtnModelAndCallback lEGOBtnModelAndCallback) {
        textView.setVisibility(0);
        lEGOBtnModelAndCallback.btnModel.bind(textView);
        textView.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODrawer.this.m16208a(lEGOBtnModelAndCallback, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m16208a(LEGOBtnModelAndCallback lEGOBtnModelAndCallback, View view) {
        if (lEGOBtnModelAndCallback.listener instanceof LEGOOnAntiShakeClickListener2) {
            ((LEGOOnAntiShakeClickListener2) lEGOBtnModelAndCallback.listener).onClick(this);
        } else {
            lEGOBtnModelAndCallback.listener.onClick(view);
        }
    }

    /* renamed from: a */
    private void m16206a(int i, int i2) {
        this.f22553g.setVisibility(i);
        this.f22552f.setVisibility(i2);
    }

    /* renamed from: c */
    private void m16214c() {
        if (this.f22547a.mRichCheckbox == null || this.f22547a.mCheckListener == null) {
            this.f22551e.setVisibility(8);
            if (this.f22547a.checkbox == null || this.f22547a.checkbox.cbModel == null || this.f22547a.checkbox.listener == null) {
                this.f22551e.setVisibility(8);
                return;
            }
            this.f22551e.setVisibility(0);
            this.f22547a.checkbox.cbModel.bind(this.f22566t);
            this.f22565s.setChecked(this.f22547a.checkbox.checked);
            this.f22565s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
                public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                    AutoTrackHelper.trackViewOnClick(compoundButton, z);
                    LEGODrawer.this.f22547a.checkbox.listener.onCheckedChanged(z);
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22551e.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 22.0f);
            this.f22551e.setLayoutParams(layoutParams);
            return;
        }
        this.f22551e.setVisibility(0);
        this.f22547a.mRichCheckbox.bindTextView(this.f22566t);
        this.f22565s.setChecked(this.f22547a.mIsChecked);
        this.f22565s.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                LEGODrawer.this.f22547a.mIsChecked = z;
                LEGODrawer.this.f22547a.mCheckListener.onCheckedChanged(z);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22551e.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 22.0f);
        this.f22551e.setLayoutParams(layoutParams2);
    }

    /* renamed from: d */
    private void m16215d() {
        if (this.f22547a.mRichLink == null || this.f22547a.mLinkListener == null) {
            this.f22550d.setVisibility(8);
            if (this.f22547a.link == null || this.f22547a.link.linkModel == null || this.f22547a.link.listener == null) {
                this.f22550d.setVisibility(8);
                return;
            }
            this.f22550d.setVisibility(0);
            this.f22547a.link.linkModel.bind(this.f22564r);
            this.f22564r.setOnClickListener(this.f22547a.link.listener);
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22550d.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 40.0f);
            this.f22550d.setLayoutParams(layoutParams);
            return;
        }
        this.f22550d.setVisibility(0);
        this.f22547a.mRichLink.bindTextView(this.f22564r);
        this.f22564r.setOnClickListener(this.f22547a.mLinkListener);
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22550d.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 40.0f);
        this.f22550d.setLayoutParams(layoutParams2);
    }

    /* renamed from: e */
    private void m16216e() {
        if (this.f22547a.mRichLeft == null || this.f22547a.mRightBtn == null || this.f22547a.mRightBtn.btnModel == null || this.f22547a.mRightBtn.listener == null) {
            this.f22549c.setVisibility(8);
            if (this.f22547a.leftText == null || this.f22547a.rightBtn == null) {
                this.f22549c.setVisibility(8);
                return;
            }
            this.f22549c.setVisibility(0);
            this.f22547a.leftText.bind(this.f22563q);
            this.f22547a.rightBtn.btnModel.bind(this.f22562p);
            this.f22562p.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    LEGODrawer lEGODrawer = LEGODrawer.this;
                    lEGODrawer.m16208a(lEGODrawer.f22547a.rightBtn, view);
                }
            });
            LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22549c.getLayoutParams();
            layoutParams.topMargin = UiUtils.dip2px(this.mContext, 30.0f);
            this.f22549c.setLayoutParams(layoutParams);
            return;
        }
        this.f22549c.setVisibility(0);
        this.f22547a.mRichLeft.bindTextView(this.f22563q);
        this.f22547a.mRightBtn.btnModel.bind(this.f22562p);
        this.f22562p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                LEGODrawer lEGODrawer = LEGODrawer.this;
                lEGODrawer.m16208a(lEGODrawer.f22547a.mRightBtn, view);
            }
        });
        LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) this.f22549c.getLayoutParams();
        layoutParams2.topMargin = UiUtils.dip2px(this.mContext, 30.0f);
        this.f22549c.setLayoutParams(layoutParams2);
    }

    /* renamed from: f */
    private void m16217f() {
        Drawable drawable;
        this.f22548b.setVisibility(0);
        this.f22557k.setVisibility(0);
        if (this.f22547a.mRichTitle != null) {
            this.f22547a.mRichTitle.bindTextView(this.f22557k);
        } else if (this.f22547a.title != null) {
            this.f22547a.title.bind(this.f22557k);
        } else {
            this.f22557k.setVisibility(8);
        }
        if (this.f22547a.mRichSubTitle != null) {
            this.f22558l.setVisibility(0);
            this.f22547a.mRichSubTitle.bindTextView(this.f22558l);
        } else if (this.f22547a.subTitle != null) {
            this.f22558l.setVisibility(0);
            this.f22547a.subTitle.bind(this.f22558l);
        } else {
            this.f22558l.setVisibility(8);
        }
        if (this.f22547a.imgPlaceHolder != 0) {
            drawable = this.mContext.getResources().getDrawable(this.f22547a.imgPlaceHolder);
        } else {
            drawable = DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg);
        }
        if (!TextUtils.isEmpty(this.f22547a.imgUrl) || this.f22547a.imgResId != 0) {
            this.f22556j.setVisibility(0);
            if (this.mContext instanceof FragmentActivity) {
                if (((FragmentActivity) this.mContext).isDestroyed()) {
                    return;
                }
            } else if ((this.mContext instanceof Activity) && ((Activity) this.mContext).isDestroyed()) {
                return;
            }
            if (!TextUtils.isEmpty(this.f22547a.imgUrl)) {
                String str = this.f22547a.imgUrl;
                if (str.endsWith("webp")) {
                    ((RequestBuilder) ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder(drawable)).optionalTransform(WebpDrawable.class, new WebpDrawableTransformation(new FitCenter()))).into(this.f22556j);
                    return;
                }
                ((RequestBuilder) Glide.with(this.mContext).load(str).placeholder(drawable)).into(this.f22556j);
                return;
            }
            int i = this.f22547a.imgResId;
            if (i != 0) {
                ((RequestBuilder) Glide.with(this.mContext).load(Integer.valueOf(i)).placeholder(drawable)).into(this.f22556j);
            } else {
                ((RequestBuilder) Glide.with(this.mContext).load(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.ggk_default_big_bg)).placeholder(drawable)).into(this.f22556j);
            }
        }
    }

    /* renamed from: g */
    private void m16218g() {
        this.f22548b = findViewById(R.id.lego_drawer_title_include);
        this.f22549c = findViewById(R.id.lego_drawer_selected_include);
        this.f22550d = findViewById(R.id.lego_drawer_link_include);
        this.f22551e = findViewById(R.id.lego_drawer_checkbox_include);
        this.f22552f = findViewById(R.id.lego_drawer_btn_horizontal_include);
        this.f22553g = findViewById(R.id.lego_drawer_btn_vertical_include);
        this.f22554h = (ImageView) findViewById(R.id.lego_drawer_close_img);
        this.f22545B = findViewById(R.id.g_bottom_pop_interval_view);
        this.f22556j = (ImageView) findViewById(R.id.lego_drawer_up_img);
        this.f22557k = (TextView) findViewById(R.id.lego_drawer_title);
        this.f22558l = (TextView) findViewById(R.id.lego_drawer_sub_title);
        this.f22559m = (FrameLayout) findViewById(R.id.lego_drawer_extended_up_view);
        this.f22560n = (FrameLayout) findViewById(R.id.lego_drawer_extended_bottom_view);
        this.f22561o = (FrameLayout) findViewById(R.id.lego_drawer_extended_view);
        this.f22555i = (RoundCornerRelativeLayout) findViewById(R.id.border_layout);
        this.f22562p = (TextView) findViewById(R.id.lego_drawer_right_btn);
        this.f22563q = (TextView) findViewById(R.id.ggk_drawer_left_tv);
        this.f22564r = (TextView) findViewById(R.id.lego_drawer_link_tv);
        this.f22565s = (CheckBox) findViewById(R.id.lego_drawer_cb);
        this.f22566t = (TextView) findViewById(R.id.lego_drawer_cb_desc);
        this.f22567u = (TextView) findViewById(R.id.ggk_drawer_btn_cancel);
        this.f22568v = (TextView) findViewById(R.id.ggk_drawer_btn_ok);
        this.f22569w = (LottieAnimationView) findViewById(R.id.ggk_drawer_btn_ok_lottie);
        this.f22570x = (TextView) findViewById(R.id.ggk_drawer_btn_v1);
        this.f22571y = (LottieAnimationView) findViewById(R.id.ggk_drawer_btn_v1_lottie);
        this.f22572z = (TextView) findViewById(R.id.ggk_drawer_btn_v2);
        this.f22544A = (TextView) findViewById(R.id.ggk_drawer_btn_v3);
        m16219h();
        LEGODrawerModel lEGODrawerModel = this.f22547a;
        if (lEGODrawerModel != null && lEGODrawerModel.drawerStyle > 0 && this.f22547a.drawerStyle == 5) {
            this.f22572z.setBackground(DidiThemeManager.getIns().getResPicker(this.mContext).getDrawable(R.attr.global_overall_main_button_selector));
            this.f22572z.setTextColor(DidiThemeManager.getIns().getResPicker(this.mContext).getColorStateList(R.attr.global_main_button_text_color_selector));
        }
    }

    /* renamed from: h */
    private void m16219h() {
        LEGOUIConfig lEGOUIConfig = LEGOUIKit.mConfig;
        if (lEGOUIConfig != null) {
            if (lEGOUIConfig.getDrawerTitleTextSize() > 0) {
                this.f22557k.setTextSize((float) lEGOUIConfig.getDrawerTitleTextSize());
            }
            if (lEGOUIConfig.getDrawerContentTextSize() > 0) {
                this.f22558l.setTextSize((float) lEGOUIConfig.getDrawerContentTextSize());
            }
            Rect drawerOutMargin = lEGOUIConfig.getDrawerOutMargin();
            if (drawerOutMargin != null) {
                ViewGroup.MarginLayoutParams marginLayoutParams = (ViewGroup.MarginLayoutParams) this.f22555i.getLayoutParams();
                if (drawerOutMargin.top > 0) {
                    marginLayoutParams.topMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.top);
                }
                if (drawerOutMargin.left > 0) {
                    marginLayoutParams.leftMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.left);
                }
                if (drawerOutMargin.right > 0) {
                    marginLayoutParams.rightMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.right);
                }
                if (drawerOutMargin.bottom > 0) {
                    marginLayoutParams.bottomMargin = UiUtils.dip2px(this.mContext, (float) drawerOutMargin.bottom);
                }
                this.f22555i.setLayoutParams(marginLayoutParams);
            }
            if (lEGOUIConfig.getDrawerCornerRadius() > 0) {
                this.f22555i.setRadius(UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerCornerRadius()));
            }
            if (lEGOUIConfig.getDrawerHoriBtnInterval() > 0) {
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) this.f22545B.getLayoutParams();
                layoutParams.width = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerHoriBtnInterval());
                this.f22545B.setLayoutParams(layoutParams);
            }
            if (lEGOUIConfig.getDrawerVertiBtnInterval() > 0) {
                RelativeLayout.LayoutParams layoutParams2 = (RelativeLayout.LayoutParams) this.f22572z.getLayoutParams();
                RelativeLayout.LayoutParams layoutParams3 = (RelativeLayout.LayoutParams) this.f22544A.getLayoutParams();
                layoutParams2.topMargin = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerVertiBtnInterval());
                layoutParams3.topMargin = UiUtils.dip2px(this.mContext, (float) lEGOUIConfig.getDrawerVertiBtnInterval());
                this.f22572z.setLayoutParams(layoutParams2);
                this.f22544A.setLayoutParams(layoutParams3);
            }
            Rect horiBtnLayoutOutMargin = lEGOUIConfig.getHoriBtnLayoutOutMargin();
            if (horiBtnLayoutOutMargin != null) {
                LinearLayout.LayoutParams layoutParams4 = (LinearLayout.LayoutParams) this.f22552f.getLayoutParams();
                if (horiBtnLayoutOutMargin.top > 0) {
                    layoutParams4.topMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.top);
                }
                if (horiBtnLayoutOutMargin.left > 0) {
                    layoutParams4.leftMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.left);
                }
                if (horiBtnLayoutOutMargin.right > 0) {
                    layoutParams4.rightMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.right);
                }
                if (horiBtnLayoutOutMargin.bottom > 0) {
                    layoutParams4.bottomMargin = UiUtils.dip2px(this.mContext, (float) horiBtnLayoutOutMargin.bottom);
                }
                this.f22552f.setLayoutParams(layoutParams4);
            }
            Rect vertiBtnLayoutOutMargin = lEGOUIConfig.getVertiBtnLayoutOutMargin();
            if (vertiBtnLayoutOutMargin != null) {
                LinearLayout.LayoutParams layoutParams5 = (LinearLayout.LayoutParams) this.f22553g.getLayoutParams();
                if (vertiBtnLayoutOutMargin.top > 0) {
                    layoutParams5.topMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.top);
                }
                if (vertiBtnLayoutOutMargin.left > 0) {
                    layoutParams5.leftMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.left);
                }
                if (vertiBtnLayoutOutMargin.right > 0) {
                    layoutParams5.rightMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.right);
                }
                if (vertiBtnLayoutOutMargin.bottom > 0) {
                    layoutParams5.bottomMargin = UiUtils.dip2px(this.mContext, (float) vertiBtnLayoutOutMargin.bottom);
                }
                this.f22553g.setLayoutParams(layoutParams5);
            }
        }
    }

    public void showLoading() {
        if (this.f22552f.getVisibility() == 0) {
            m16210a(true);
        } else if (this.f22553g.getVisibility() == 0) {
            m16210a(false);
        }
    }

    /* renamed from: a */
    private void m16210a(boolean z) {
        if (z) {
            this.f22569w.setVisibility(0);
            this.f22569w.setRepeatCount(-1);
            this.f22569w.playAnimation();
            this.f22568v.setVisibility(8);
        } else {
            this.f22571y.setVisibility(0);
            this.f22571y.setRepeatCount(-1);
            this.f22571y.playAnimation();
            this.f22570x.setVisibility(8);
        }
        m16211a(z, false);
    }

    /* renamed from: b */
    private void m16213b(boolean z) {
        if (z) {
            this.f22568v.setVisibility(0);
            this.f22569w.setVisibility(8);
            this.f22569w.cancelAnimation();
        } else {
            this.f22570x.setVisibility(0);
            this.f22571y.setVisibility(4);
            this.f22571y.cancelAnimation();
        }
        m16211a(z, true);
    }

    public void hideLoading() {
        if (this.f22571y.getVisibility() == 0) {
            m16213b(false);
        } else if (this.f22569w.getVisibility() == 0) {
            m16213b(true);
        }
    }

    /* renamed from: a */
    private void m16211a(boolean z, boolean z2) {
        if (z) {
            this.f22567u.setEnabled(z2);
            return;
        }
        this.f22572z.setEnabled(z2);
        this.f22544A.setEnabled(z2);
    }
}

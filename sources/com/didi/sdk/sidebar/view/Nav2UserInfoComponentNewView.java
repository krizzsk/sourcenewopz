package com.didi.sdk.sidebar.view;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.bumptech.glide.RequestBuilder;
import com.bumptech.glide.load.Transformation;
import com.bumptech.glide.load.model.GlideUrl;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.global.common.com.UiUtils;
import com.didi.sdk.sidebar.component.GlideRoundTransform;
import com.didi.sdk.sidebar.model.SidebarResponse;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\u0019\u001a\u00020\bH\u0016J\u0010\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001dH\u0002J\u0018\u0010\u001e\u001a\u00020\u001f2\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020#J\u0012\u0010$\u001a\u00020\u001f2\b\u0010%\u001a\u0004\u0018\u00010!H\u0016J\u000e\u0010&\u001a\u00020\u001f2\u0006\u0010'\u001a\u00020(R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\n\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0014\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0015\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0017\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000¨\u0006)"}, mo175978d2 = {"Lcom/didi/sdk/sidebar/view/Nav2UserInfoComponentNewView;", "Lcom/didi/sdk/sidebar/view/ComponentView;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "mAvatar", "Landroid/widget/ImageView;", "mBottomView", "Landroid/view/View;", "mBottomViewShadow", "mDidiPassButtonArrow", "mDidiPassButtonLayout", "Landroid/widget/LinearLayout;", "mDidiPassButtonText", "Landroid/widget/TextView;", "mDidiPassIcon", "mDidiPassLayout", "Landroid/widget/RelativeLayout;", "mDidiPassLayoutVb", "Landroid/view/ViewStub;", "mDidiPassSubtitle", "mDidiPassTitle", "mNameTv", "mTipsTv", "rootView", "createView", "isDestroy", "", "activity", "Landroid/app/Activity;", "loadImage", "", "url", "", "defaultResId", "", "setName", "displayName", "showDidiPass", "didiPass", "Lcom/didi/sdk/sidebar/model/SidebarResponse$GetProfile;", "TheOneSDKGlobal_release"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: Nav2UserInfoComponentNewView.kt */
public final class Nav2UserInfoComponentNewView extends ComponentView {

    /* renamed from: a */
    private View f37477a;

    /* renamed from: b */
    private ImageView f37478b;

    /* renamed from: c */
    private TextView f37479c;

    /* renamed from: d */
    private TextView f37480d;

    /* renamed from: e */
    private View f37481e;

    /* renamed from: f */
    private View f37482f;

    /* renamed from: g */
    private ViewStub f37483g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public RelativeLayout f37484h;

    /* renamed from: i */
    private ImageView f37485i;

    /* renamed from: j */
    private TextView f37486j;

    /* renamed from: k */
    private TextView f37487k;

    /* renamed from: l */
    private ImageView f37488l;

    /* renamed from: m */
    private TextView f37489m;

    /* renamed from: n */
    private LinearLayout f37490n;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public Nav2UserInfoComponentNewView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public View createView() {
        View inflate = LayoutInflater.from(this.context).inflate(R.layout.side_bar_head_layout, (ViewGroup) null);
        this.f37477a = inflate;
        if (inflate != null) {
            this.f37478b = (ImageView) inflate.findViewById(R.id.sidebar_head_avatar);
            this.f37479c = (TextView) inflate.findViewById(R.id.sidebar_head_name);
            this.f37480d = (TextView) inflate.findViewById(R.id.sidebar_head_tips);
            this.f37481e = inflate.findViewById(R.id.new_sidebar_bottom_view);
            this.f37482f = inflate.findViewById(R.id.new_sidebar_bottom_view_shadow);
            this.f37483g = (ViewStub) inflate.findViewById(R.id.new_ui_sidebar_didi_pass_info_layout_viewstub);
        }
        View view = this.f37477a;
        Intrinsics.checkNotNull(view);
        return view;
    }

    public void setName(String str) {
        TextView textView = this.f37479c;
        if (textView != null) {
            textView.setText(str);
        }
    }

    public final void loadImage(String str, int i) {
        ImageView imageView = this.f37478b;
        if (imageView != null) {
            imageView.setImageResource(i);
        }
        if (!TextUtils.isEmpty(str)) {
            ImageView imageView2 = this.f37478b;
            Intrinsics.checkNotNull(imageView2);
            ((RequestBuilder) ((RequestBuilder) Glide.with((Context) DIDIApplication.getAppContext()).asBitmap().load(str).placeholder(i)).transform((Transformation<Bitmap>) new GlideRoundTransform(this.context, 100))).into(imageView2);
        }
    }

    public final void showDidiPass(SidebarResponse.GetProfile getProfile) {
        TextView textView;
        TextView textView2;
        View view;
        Intrinsics.checkNotNullParameter(getProfile, "didiPass");
        ViewStub viewStub = this.f37483g;
        if (viewStub != null) {
            viewStub.setVisibility(0);
        }
        if (this.f37484h == null && (view = this.f37477a) != null) {
            this.f37484h = (RelativeLayout) view.findViewById(R.id.new_ui_sidebar_didi_pass_info_layout);
            this.f37485i = (ImageView) view.findViewById(R.id.new_ui_didi_pass_icon);
            this.f37486j = (TextView) view.findViewById(R.id.new_ui_didi_pass_title);
            this.f37487k = (TextView) view.findViewById(R.id.new_ui_didi_pass_subtitle);
            this.f37488l = (ImageView) view.findViewById(R.id.new_ui_didi_pass_guid_arrow);
            this.f37489m = (TextView) view.findViewById(R.id.new_ui_didi_pass_guid_text);
            this.f37490n = (LinearLayout) view.findViewById(R.id.new_ui_didi_pass_guid_fl);
        }
        View view2 = this.f37481e;
        if (view2 != null) {
            view2.setVisibility(8);
        }
        View view3 = this.f37482f;
        if (view3 != null) {
            view3.setVisibility(8);
        }
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setColors(new int[]{Color.parseColor(getProfile.bgStartColor), Color.parseColor(getProfile.bgEndColor)});
        View view4 = this.f37477a;
        if (view4 != null) {
            view4.setBackground(gradientDrawable);
        }
        Context context = this.context;
        if (context != null) {
            Activity activity = (Activity) context;
            if (!m26619a(activity)) {
                RequestBuilder<Bitmap> load = Glide.with(activity).asBitmap().load((Object) new GlideUrl(getProfile.levelIcon));
                ImageView imageView = this.f37485i;
                Intrinsics.checkNotNull(imageView);
                load.into(imageView);
                if (!TextUtils.isEmpty(getProfile.cardBgImage)) {
                    Glide.with(activity).asBitmap().load((Object) new GlideUrl(getProfile.cardBgImage)).into(new Nav2UserInfoComponentNewView$showDidiPass$2(this));
                } else {
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    int[] iArr = {Color.parseColor(getProfile.cardBgStartColor), Color.parseColor(getProfile.cardBgEndColor)};
                    gradientDrawable2.setOrientation(GradientDrawable.Orientation.TOP_BOTTOM);
                    gradientDrawable2.setColors(iArr);
                    gradientDrawable2.setCornerRadii(new float[]{20.0f, 20.0f, 20.0f, 20.0f, 0.0f, 0.0f, 0.0f, 0.0f});
                    RelativeLayout relativeLayout = this.f37484h;
                    if (relativeLayout != null) {
                        relativeLayout.setBackground(gradientDrawable2);
                    }
                }
                RequestBuilder<Bitmap> load2 = Glide.with(activity).asBitmap().load((Object) new GlideUrl(getProfile.cardArrowIcon));
                ImageView imageView2 = this.f37488l;
                Intrinsics.checkNotNull(imageView2);
                load2.into(imageView2);
            }
            if (!TextUtils.isEmpty(getProfile.cardTextColor)) {
                TextView textView3 = this.f37489m;
                if (textView3 != null) {
                    textView3.setTextColor(Color.parseColor(getProfile.cardTextColor));
                }
            } else if (!TextUtils.isEmpty(getProfile.fontColor) && (textView2 = this.f37489m) != null) {
                textView2.setTextColor(Color.parseColor(getProfile.fontColor));
            }
            TextView textView4 = this.f37489m;
            if (textView4 != null) {
                textView4.setText(getProfile.cardText);
            }
            GradientDrawable gradientDrawable3 = new GradientDrawable();
            gradientDrawable3.setCornerRadius((float) UiUtils.dip2px(this.context, 10.0f));
            if (!TextUtils.isEmpty(getProfile.cardTextBorderColor)) {
                gradientDrawable3.setStroke(UiUtils.dip2px(this.context, 1.0f), Color.parseColor(getProfile.cardTextBorderColor));
            } else if (!TextUtils.isEmpty(getProfile.fontColor)) {
                gradientDrawable3.setStroke(UiUtils.dip2px(this.context, 1.0f), Color.parseColor(getProfile.fontColor));
            }
            LinearLayout linearLayout = this.f37490n;
            if (linearLayout != null) {
                linearLayout.setBackground(gradientDrawable3);
            }
            if (!TextUtils.isEmpty(getProfile.levelName) && (textView = this.f37486j) != null) {
                textView.setText(getProfile.levelName);
            }
            if (getProfile.title != null && !TextUtils.isEmpty(getProfile.title.getContent())) {
                getProfile.title.bindTextView(this.f37486j);
            }
            if (getProfile.subTitle == null || TextUtils.isEmpty(getProfile.subTitle.getContent())) {
                TextView textView5 = this.f37487k;
                if (textView5 != null) {
                    textView5.setVisibility(8);
                }
            } else {
                TextView textView6 = this.f37487k;
                if (textView6 != null) {
                    textView6.setVisibility(0);
                }
                getProfile.subTitle.bindTextView(this.f37487k);
            }
            RelativeLayout relativeLayout2 = this.f37484h;
            if (relativeLayout2 != null) {
                relativeLayout2.setOnClickListener(new Nav2UserInfoComponentNewView$showDidiPass$3(getProfile, this));
                return;
            }
            return;
        }
        throw new NullPointerException("null cannot be cast to non-null type android.app.Activity");
    }

    /* renamed from: a */
    private final boolean m26619a(Activity activity) {
        return activity == null || activity.isFinishing() || (Build.VERSION.SDK_INT >= 17 && activity.isDestroyed());
    }
}

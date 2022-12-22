package com.didi.entrega.home.page;

import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.component.comp_xpanel.XPanelScene;
import com.didi.entrega.customer.base.pages.FloatingCustomerPage;
import com.didi.entrega.customer.base.pages.RoutePath;
import com.didi.entrega.customer.foundation.util.CustomerTypeFaceSpan;
import com.didi.entrega.customer.foundation.util.CustomerVerticalCenterSpan;
import com.didi.entrega.customer.foundation.util.FlyImageLoader;
import com.didi.entrega.customer.foundation.util.FontUtils;
import com.didi.entrega.customer.foundation.util.ResourceHelper;
import com.didi.entrega.customer.widget.MaxHeightScrollView;
import com.didi.entrega.customer.widget.text.RichTextView;
import com.didi.entrega.home.component.feed.entity.ServiceRuleEntity;
import com.didi.entrega.home.manager.HomeOtherOmegaHelper;
import com.didi.entrega.router.DiRouter;
import com.didi.entrega.router.annotations.Route;
import com.didi.rfusion.widget.button.RFMainButton;
import com.didi.rfusion.widget.floating.RFFloatingIconAttr;
import com.didi.rfusion.widget.floating.RFFloatingNavBar;
import com.didi.rfusion.widget.floating.RFFloatingTextAttr;
import com.taxis99.R;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0005¢\u0006\u0002\u0010\u0002J\u0012\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0006\u0010\u0014\u001a\u00020\u0015H\u0002J\b\u0010\u0016\u001a\u00020\u0017H\u0014J\b\u0010\u0018\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u00172\u0006\u0010\u001a\u001a\u00020\u000eH\u0016J\b\u0010\u001b\u001a\u00020\u0017H\u0016R\u000e\u0010\u0003\u001a\u00020\u0004X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u0010X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000¨\u0006\u001d"}, mo175978d2 = {"Lcom/didi/entrega/home/page/ServiceNotifyPage;", "Lcom/didi/entrega/customer/base/pages/FloatingCustomerPage;", "()V", "confirm", "Lcom/didi/rfusion/widget/button/RFMainButton;", "content", "Lcom/didi/entrega/customer/widget/text/RichTextView;", "entity", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "image", "Landroid/widget/ImageView;", "link", "Landroid/widget/TextView;", "mContentView", "Landroid/view/View;", "scrollView", "Lcom/didi/entrega/customer/widget/MaxHeightScrollView;", "shadowView", "getLinkText", "", "text", "", "initContentView", "", "initData", "onCreate", "view", "onResume", "Companion", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
@Route({"serviceNotifyPage"})
/* compiled from: ServiceNotifyPage.kt */
public final class ServiceNotifyPage extends FloatingCustomerPage {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);

    /* renamed from: a */
    private View f20716a;

    /* renamed from: b */
    private ImageView f20717b;

    /* renamed from: c */
    private RFMainButton f20718c;

    /* renamed from: d */
    private RichTextView f20719d;

    /* renamed from: e */
    private TextView f20720e;

    /* renamed from: f */
    private MaxHeightScrollView f20721f;

    /* renamed from: g */
    private View f20722g;

    /* renamed from: h */
    private ServiceRuleEntity f20723h;

    public void onCreate(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onCreate(view);
        View view2 = this.f20716a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        setContentView(view2);
        setType(1);
        m15157b();
    }

    public void onResume() {
        super.onResume();
        HomeOtherOmegaHelper.trackServiceNotifyFloatSW();
    }

    /* access modifiers changed from: protected */
    public void initContentView() {
        View inflate = LayoutInflater.from(getBaseContext()).inflate(R.layout.entrega_page_service_notify, (ViewGroup) getView(), false);
        Intrinsics.checkNotNullExpressionValue(inflate, "from(baseContext).inflat…view as ViewGroup, false)");
        this.f20716a = inflate;
        MaxHeightScrollView maxHeightScrollView = null;
        if (inflate == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            inflate = null;
        }
        View findViewById = inflate.findViewById(R.id.entrega_iv_service_notify);
        Intrinsics.checkNotNullExpressionValue(findViewById, "mContentView.findViewByI…ntrega_iv_service_notify)");
        this.f20717b = (ImageView) findViewById;
        View view = this.f20716a;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view = null;
        }
        View findViewById2 = view.findViewById(R.id.entrega_tv_common_confirm);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "mContentView.findViewByI…ntrega_tv_common_confirm)");
        this.f20718c = (RFMainButton) findViewById2;
        View view2 = this.f20716a;
        if (view2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view2 = null;
        }
        View findViewById3 = view2.findViewById(R.id.entrega_tv_service_notify_content);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "mContentView.findViewByI…v_service_notify_content)");
        this.f20719d = (RichTextView) findViewById3;
        View view3 = this.f20716a;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view3 = null;
        }
        View findViewById4 = view3.findViewById(R.id.entrega_tv_service_notify_link);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "mContentView.findViewByI…a_tv_service_notify_link)");
        this.f20720e = (TextView) findViewById4;
        View view4 = this.f20716a;
        if (view4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view4 = null;
        }
        View findViewById5 = view4.findViewById(R.id.entrega_sv_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "mContentView.findViewByI….id.entrega_sv_container)");
        this.f20721f = (MaxHeightScrollView) findViewById5;
        View view5 = this.f20716a;
        if (view5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view5 = null;
        }
        View findViewById6 = view5.findViewById(R.id.entrega_dialog_shadow);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "mContentView.findViewByI…id.entrega_dialog_shadow)");
        this.f20722g = findViewById6;
        RFMainButton rFMainButton = this.f20718c;
        if (rFMainButton == null) {
            Intrinsics.throwUninitializedPropertyAccessException(XPanelScene.SCENE_CONFIRM);
            rFMainButton = null;
        }
        rFMainButton.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                ServiceNotifyPage.m15155a(ServiceNotifyPage.this, view);
            }
        });
        MaxHeightScrollView maxHeightScrollView2 = this.f20721f;
        if (maxHeightScrollView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("scrollView");
        } else {
            maxHeightScrollView = maxHeightScrollView2;
        }
        maxHeightScrollView.setOnScrollChangeListener(new MaxHeightScrollView.OnScrollChangeListener() {
            public final void onScrollChanged(int i, int i2, int i3, int i4) {
                ServiceNotifyPage.m15154a(ServiceNotifyPage.this, i, i2, i3, i4);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15155a(ServiceNotifyPage serviceNotifyPage, View view) {
        Intrinsics.checkNotNullParameter(serviceNotifyPage, "this$0");
        serviceNotifyPage.dismiss();
        HomeOtherOmegaHelper.trackServiceNotifyFloatCK(21);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15154a(ServiceNotifyPage serviceNotifyPage, int i, int i2, int i3, int i4) {
        Intrinsics.checkNotNullParameter(serviceNotifyPage, "this$0");
        View view = null;
        if (i2 > 0) {
            View view2 = serviceNotifyPage.f20722g;
            if (view2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("shadowView");
            } else {
                view = view2;
            }
            view.setVisibility(0);
            return;
        }
        View view3 = serviceNotifyPage.f20722g;
        if (view3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("shadowView");
        } else {
            view = view3;
        }
        view.setVisibility(4);
    }

    /* renamed from: b */
    private final void m15157b() {
        Serializable serializable;
        View view = this.f20716a;
        ImageView imageView = null;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mContentView");
            view = null;
        }
        Drawable drawable = ContextCompat.getDrawable(view.getContext(), R.drawable.entrega_shape_default_grey_bg);
        ScopeContext scopeContext = getScopeContext();
        Bundle bundle = scopeContext == null ? null : scopeContext.getBundle();
        if (bundle == null) {
            serializable = null;
        } else {
            serializable = bundle.getSerializable("entity");
        }
        ServiceRuleEntity serviceRuleEntity = (ServiceRuleEntity) serializable;
        this.f20723h = serviceRuleEntity;
        if (serviceRuleEntity != null) {
            if (!TextUtils.isEmpty(serviceRuleEntity.title)) {
                RFFloatingNavBar navBar = getNavBar();
                if (navBar != null) {
                    navBar.setLeftIcon(new RFFloatingIconAttr.Builder(1).click(new View.OnClickListener() {
                        public final void onClick(View view) {
                            ServiceNotifyPage.m15158b(ServiceNotifyPage.this, view);
                        }
                    }).build());
                }
                RFFloatingNavBar navBar2 = getNavBar();
                if (navBar2 != null) {
                    navBar2.setTitle(new RFFloatingTextAttr.Builder(serviceRuleEntity.title).build());
                }
                RFFloatingNavBar navBar3 = getNavBar();
                if (navBar3 != null) {
                    navBar3.setBackground(ResourceHelper.getColor(R.color.rf_color_white_100_FFFFFF));
                }
            }
            if (!TextUtils.isEmpty(serviceRuleEntity.content)) {
                RichTextView richTextView = this.f20719d;
                if (richTextView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("content");
                    richTextView = null;
                }
                richTextView.setText(serviceRuleEntity.content);
            }
            if (!TextUtils.isEmpty(serviceRuleEntity.linkContent)) {
                TextView textView = this.f20720e;
                if (textView == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("link");
                    textView = null;
                }
                String str = serviceRuleEntity.linkContent;
                Intrinsics.checkNotNullExpressionValue(str, "it.linkContent");
                textView.setText(m15153a(str));
                String str2 = serviceRuleEntity.url;
                if (str2 != null) {
                    TextView textView2 = this.f20720e;
                    if (textView2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("link");
                        textView2 = null;
                    }
                    textView2.setOnClickListener(new View.OnClickListener(str2) {
                        public final /* synthetic */ String f$0;

                        {
                            this.f$0 = r1;
                        }

                        public final void onClick(View view) {
                            ServiceNotifyPage.m15156a(this.f$0, view);
                        }
                    });
                }
            }
            String str3 = serviceRuleEntity.imgUrl;
            if (str3 != null) {
                ScopeContext scopeContext2 = getScopeContext();
                Intrinsics.checkNotNull(scopeContext2);
                FlyImageLoader.ImageRequestWrapper centerCrop = FlyImageLoader.loadImageUnspecified(scopeContext2, str3).placeholder(drawable).error(drawable).centerCrop();
                ImageView imageView2 = this.f20717b;
                if (imageView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("image");
                } else {
                    imageView = imageView2;
                }
                centerCrop.into(imageView);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m15158b(ServiceNotifyPage serviceNotifyPage, View view) {
        Intrinsics.checkNotNullParameter(serviceNotifyPage, "this$0");
        HomeOtherOmegaHelper.trackServiceNotifyFloatCK(29);
        serviceNotifyPage.dismiss();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m15156a(String str, View view) {
        Intrinsics.checkNotNullParameter(str, "$url");
        HomeOtherOmegaHelper.trackServiceNotifyFloatCK(22);
        DiRouter.request().path("webPage").putString("url", str).open();
    }

    /* renamed from: a */
    private final CharSequence m15153a(String str) {
        CharSequence charSequence = str;
        if (TextUtils.isEmpty(charSequence)) {
            return "";
        }
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder();
        String string = ResourceHelper.getString(R.string.customer_common_icon_arrow);
        SpannableString spannableString = new SpannableString(charSequence);
        SpannableString spannableString2 = new SpannableString(string);
        spannableString2.setSpan(new CustomerTypeFaceSpan(FontUtils.getIconTypeface()), 0, string.length(), 33);
        spannableString2.setSpan(new CustomerVerticalCenterSpan(14), 0, string.length(), 33);
        spannableStringBuilder.append(spannableString).append(" ").append(spannableString2);
        return spannableStringBuilder;
    }

    @Metadata(mo175977d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¨\u0006\u0007"}, mo175978d2 = {"Lcom/didi/entrega/home/page/ServiceNotifyPage$Companion;", "", "()V", "showPage", "", "data", "Lcom/didi/entrega/home/component/feed/entity/ServiceRuleEntity;", "entrega-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: ServiceNotifyPage.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }

        public final void showPage(ServiceRuleEntity serviceRuleEntity) {
            DiRouter.request().path(RoutePath.SERVICE_NOTIFY_PAGE).putSerializable("entity", serviceRuleEntity).open();
        }
    }
}

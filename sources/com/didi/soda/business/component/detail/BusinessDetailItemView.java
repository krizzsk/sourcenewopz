package com.didi.soda.business.component.detail;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import androidx.constraintlayout.widget.ConstraintLayout;
import com.didi.raven.config.RavenKey;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.IconTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\r\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u000b\u0018\u00002\u00020\u0001:\u0001$B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0017\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006¢\u0006\u0002\u0010\u0007B\u001f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0006\u0010\u001e\u001a\u00020\u0011J\b\u0010\u001f\u001a\u00020\u0011H\u0002J\b\u0010 \u001a\u00020\u0011H\u0002J\b\u0010!\u001a\u00020\u0011H\u0002J\b\u0010\"\u001a\u00020\u0011H\u0002J\b\u0010#\u001a\u00020\u0011H\u0002R)\u0010\u000b\u001a\u001d\u0012\u0013\u0012\u00110\r¢\u0006\f\b\u000e\u0012\b\b\u000f\u0012\u0004\b\b(\u0010\u0012\u0004\u0012\u00020\u00110\fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u0015X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0018\u001a\u0004\u0018\u00010\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001d\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/business/component/detail/BusinessDetailItemView;", "Landroidx/constraintlayout/widget/ConstraintLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "addExpendViewAction", "Lkotlin/Function1;", "Landroid/widget/LinearLayout;", "Lkotlin/ParameterName;", "name", "layout", "", "content", "", "contentClickAction", "Lkotlin/Function0;", "icon", "", "iconUrl", "isContentLineSpacingMultiplier", "", "isShowContainer", "isShowLineHeight", "title", "initView", "setUpView", "setupContent", "setupExpend", "setupIcon", "setupTitle", "Builder", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: BusinessDetailItemView.kt */
public final class BusinessDetailItemView extends ConstraintLayout {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public String f39394a = "";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public String f39395b = "";
    /* access modifiers changed from: private */

    /* renamed from: c */
    public CharSequence f39396c = "";
    /* access modifiers changed from: private */

    /* renamed from: d */
    public boolean f39397d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public CharSequence f39398e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public boolean f39399f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Function0<Unit> f39400g = BusinessDetailItemView$contentClickAction$1.INSTANCE;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f39401h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Function1<? super LinearLayout, Unit> f39402i = BusinessDetailItemView$addExpendViewAction$1.INSTANCE;

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessDetailItemView(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessDetailItemView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public BusinessDetailItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        Intrinsics.checkNotNullParameter(attributeSet, RavenKey.ATTRS);
        initView();
    }

    public final void initView() {
        View.inflate(getContext(), R.layout.customer_component_business_detail_item, this);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m27876a() {
        m27878b();
        m27879c();
        m27880d();
        m27881e();
    }

    /* renamed from: b */
    private final void m27878b() {
        CharSequence charSequence = this.f39394a;
        boolean z = true;
        if (!(charSequence == null || charSequence.length() == 0)) {
            ((ImageView) findViewById(R.id.customer_network_iv)).setVisibility(8);
            ((IconTextView) findViewById(R.id.customer_iv)).setVisibility(0);
            ((IconTextView) findViewById(R.id.customer_iv)).setText(this.f39394a);
            return;
        }
        CharSequence charSequence2 = this.f39395b;
        if (!(charSequence2 == null || charSequence2.length() == 0)) {
            z = false;
        }
        if (!z) {
            ((ImageView) findViewById(R.id.customer_network_iv)).setVisibility(0);
            ((IconTextView) findViewById(R.id.customer_iv)).setVisibility(8);
            FlyImageLoader.loadImageUnspecified(getContext(), this.f39395b).centerCrop().into((ImageView) findViewById(R.id.customer_network_iv));
            return;
        }
        ((IconTextView) findViewById(R.id.customer_iv)).setVisibility(4);
        ((ImageView) findViewById(R.id.customer_network_iv)).setVisibility(8);
    }

    /* renamed from: c */
    private final void m27879c() {
        CharSequence charSequence = this.f39396c;
        if (charSequence == null || charSequence.length() == 0) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_title)).setVisibility(8);
            if (((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).getLayoutParams() instanceof ConstraintLayout.LayoutParams) {
                ViewGroup.LayoutParams layoutParams = ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).getLayoutParams();
                if (layoutParams != null) {
                    ((ConstraintLayout.LayoutParams) layoutParams).topMargin = 0;
                    return;
                }
                throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
            }
            return;
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_title)).setVisibility(0);
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_title)).setText(this.f39396c);
        if (this.f39397d) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_title)).setLineHeight(getContext().getResources().getDimensionPixelSize(R.dimen.customer_text_size_32px));
        }
    }

    /* renamed from: d */
    private final void m27880d() {
        CharSequence charSequence = this.f39398e;
        if (charSequence == null || charSequence.length() == 0) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).setVisibility(8);
            return;
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).setVisibility(0);
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).setText(this.f39398e);
        if (this.f39399f) {
            ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).setTextAppearance(getContext(), R.style.customer_business_line_multi_spc);
        }
        ((CustomerAppCompatTextView) findViewById(R.id.customer_tv_content)).setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                BusinessDetailItemView.m27877a(BusinessDetailItemView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m27877a(BusinessDetailItemView businessDetailItemView, View view) {
        Intrinsics.checkNotNullParameter(businessDetailItemView, "this$0");
        businessDetailItemView.f39400g.invoke();
    }

    /* renamed from: e */
    private final void m27881e() {
        if (this.f39401h) {
            Function1<? super LinearLayout, Unit> function1 = this.f39402i;
            LinearLayout linearLayout = (LinearLayout) findViewById(R.id.customer_ll_container);
            Intrinsics.checkNotNullExpressionValue(linearLayout, "customer_ll_container");
            function1.invoke(linearLayout);
        }
    }

    @Metadata(mo175977d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\r\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0005\u0018\u00002\u00020\u0001B\u000f\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0004J\b\u0010\f\u001a\u0004\u0018\u00010\u000bJ\u0006\u0010\r\u001a\u00020\u000eJ\u001a\u0010\u000f\u001a\u00020\u00002\u0012\u0010\u0010\u001a\u000e\u0012\u0004\u0012\u00020\u0012\u0012\u0004\u0012\u00020\u000e0\u0011J\u0010\u0010\u0013\u001a\u00020\u00002\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015J\u0014\u0010\u0016\u001a\u00020\u00002\f\u0010\u0017\u001a\b\u0012\u0004\u0012\u00020\u000e0\u0018J\u000e\u0010\u0019\u001a\u00020\u00002\u0006\u0010\u001a\u001a\u00020\u001bJ\u0010\u0010\u001c\u001a\u00020\u00002\b\u0010\u001d\u001a\u0004\u0018\u00010\u0006J\u000e\u0010\u001e\u001a\u00020\u00002\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010!\u001a\u00020\u00002\u0006\u0010\"\u001a\u00020 J\u0010\u0010#\u001a\u00020\u00002\b\u0010$\u001a\u0004\u0018\u00010\u0015R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0010\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0002\u001a\u0004\u0018\u00010\u0003X\u0004¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/business/component/detail/BusinessDetailItemView$Builder;", "", "container", "Landroid/view/ViewGroup;", "(Landroid/view/ViewGroup;)V", "TAG", "", "kotlin.jvm.PlatformType", "getTAG", "()Ljava/lang/String;", "businessDetailItemView", "Lcom/didi/soda/business/component/detail/BusinessDetailItemView;", "build", "buildAddView", "", "setAddExpendAction", "addExpendAction", "Lkotlin/Function1;", "Landroid/widget/LinearLayout;", "setContent", "content", "", "setContentClickAction", "clickAction", "Lkotlin/Function0;", "setIcon", "icon", "", "setIconUrl", "iconUrl", "setIsContentLineSpacingMultiplier", "isContentLineSpacingMultiplier", "", "setIsShowLineHeight", "isShowLineHeight", "setTitle", "title", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: BusinessDetailItemView.kt */
    public static final class Builder {
        private final String TAG = getClass().getSimpleName();
        private BusinessDetailItemView businessDetailItemView;
        private final ViewGroup container;

        public Builder(ViewGroup viewGroup) {
            Context context;
            this.container = viewGroup;
            ViewGroup viewGroup2 = this.container;
            if (viewGroup2 != null && (context = viewGroup2.getContext()) != null) {
                this.businessDetailItemView = new BusinessDetailItemView(context);
            }
        }

        public final String getTAG() {
            return this.TAG;
        }

        public final BusinessDetailItemView build() {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.m27876a();
            }
            return this.businessDetailItemView;
        }

        public final void buildAddView() {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.m27876a();
                ViewGroup viewGroup = this.container;
                if (viewGroup != null) {
                    viewGroup.addView(businessDetailItemView2);
                }
            }
        }

        public final Builder setIcon(int i) {
            try {
                BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
                if (businessDetailItemView2 != null) {
                    businessDetailItemView2.f39394a = ResourceHelper.getString(i);
                }
            } catch (Exception e) {
                String str = this.TAG;
                String message = e.getMessage();
                if (message == null) {
                    message = "";
                }
                LogUtil.m29100d(str, message);
            }
            return this;
        }

        public final Builder setIconUrl(String str) {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39395b = str;
            }
            return this;
        }

        public final Builder setTitle(CharSequence charSequence) {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39396c = charSequence;
            }
            return this;
        }

        public final Builder setIsShowLineHeight(boolean z) {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39397d = z;
            }
            return this;
        }

        public final Builder setContent(CharSequence charSequence) {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39398e = charSequence;
            }
            return this;
        }

        public final Builder setIsContentLineSpacingMultiplier(boolean z) {
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39399f = z;
            }
            return this;
        }

        public final Builder setContentClickAction(Function0<Unit> function0) {
            Intrinsics.checkNotNullParameter(function0, "clickAction");
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39400g = function0;
            }
            return this;
        }

        public final Builder setAddExpendAction(Function1<? super LinearLayout, Unit> function1) {
            Intrinsics.checkNotNullParameter(function1, "addExpendAction");
            BusinessDetailItemView businessDetailItemView2 = this.businessDetailItemView;
            if (businessDetailItemView2 != null) {
                businessDetailItemView2.f39401h = true;
            }
            BusinessDetailItemView businessDetailItemView3 = this.businessDetailItemView;
            if (businessDetailItemView3 != null) {
                businessDetailItemView3.f39402i = function1;
            }
            return this;
        }
    }
}

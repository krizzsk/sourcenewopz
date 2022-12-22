package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\u000e\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u000e\u0010\u0019\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007J\u0006\u0010\t\u001a\u00020\u0016J\b\u0010\u001b\u001a\u00020\u0016H\u0002J\u000e\u0010\u001c\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u001d\u001a\u00020\u0016J\u000e\u0010\u001e\u001a\u00020\u00162\u0006\u0010\u0010\u001a\u00020\u0011J\u0010\u0010\u001f\u001a\u00020\u00162\u0006\u0010\u001a\u001a\u00020\u0007H\u0002J0\u0010 \u001a\u00020\u00162\u0006\u0010!\u001a\u00020\n2\u0006\u0010\"\u001a\u00020\u00072\u0006\u0010#\u001a\u00020\u00072\u0006\u0010$\u001a\u00020\u00072\u0006\u0010%\u001a\u00020\u0007H\u0014J8\u0010&\u001a\u00020\u00162\u0006\u0010'\u001a\u00020(2\u0006\u0010)\u001a\u00020\n2\b\u0010*\u001a\u0004\u0018\u00010+2\b\u0010,\u001a\u0004\u0018\u00010+2\f\u0010-\u001a\b\u0012\u0004\u0012\u00020\u00160\fR\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\fX\u0004¢\u0006\u0002\n\u0000R\u0010\u0010\r\u001a\u0004\u0018\u00010\u000eX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0007X\u000e¢\u0006\u0002\n\u0000¨\u0006."}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/FeedHeaderLayout;", "Landroid/widget/FrameLayout;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "acceptScroll", "", "getItemHeight", "Lkotlin/Function0;", "imageView", "Landroid/widget/ImageView;", "isSpecialImage", "itemView", "Landroid/view/View;", "offsetHelper", "Lcom/didi/soda/home/topgun/widget/OffsetHelper;", "scrollOffset", "acceptRefreshAnchor", "", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "acceptRefreshOffset", "offset", "addImageView", "attachRecycleView", "banAcceptScroll", "bindItemView", "handleOffset", "onLayout", "changed", "left", "top", "right", "bottom", "updateImage", "scopeContext", "Lcom/didi/app/nova/skeleton/ScopeContext;", "isSpecial", "specialBgImageUrl", "", "ambientImg", "specialImageLoadFail", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: FeedHeaderLayout.kt */
public final class FeedHeaderLayout extends FrameLayout {

    /* renamed from: a */
    private ImageView f43048a;

    /* renamed from: b */
    private boolean f43049b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public View f43050c;

    /* renamed from: d */
    private int f43051d;

    /* renamed from: e */
    private boolean f43052e;

    /* renamed from: f */
    private final Function0<Integer> f43053f;

    /* renamed from: g */
    private final C14062c f43054g;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedHeaderLayout(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public FeedHeaderLayout(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ FeedHeaderLayout(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public FeedHeaderLayout(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f43052e = true;
        Function0<Integer> feedHeaderLayout$getItemHeight$1 = new FeedHeaderLayout$getItemHeight$1(this);
        this.f43053f = feedHeaderLayout$getItemHeight$1;
        this.f43054g = new C14062c(feedHeaderLayout$getItemHeight$1, new FeedHeaderLayout$offsetHelper$1(this));
    }

    public final void acceptScroll() {
        this.f43052e = true;
    }

    public final void banAcceptScroll() {
        this.f43052e = false;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m30458a(int i) {
        LogUtil.m29100d("TAG", Intrinsics.stringPlus(">>>>> handleOffset offset = ", Integer.valueOf(i)));
        if (this.f43052e) {
            this.f43051d = i;
            requestLayout();
            invalidate();
        }
    }

    /* renamed from: a */
    private final void m30457a() {
        if (this.f43048a == null) {
            ImageView imageView = new ImageView(getContext());
            imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
            Unit unit = Unit.INSTANCE;
            this.f43048a = imageView;
            ViewGroup.LayoutParams layoutParams = new ViewGroup.LayoutParams(-1, -2);
            ImageView imageView2 = this.f43048a;
            if (imageView2 != null) {
                imageView2.setLayoutParams(layoutParams);
            }
            addView(this.f43048a, 0);
        }
    }

    public final void bindItemView(View view) {
        Intrinsics.checkNotNullParameter(view, "itemView");
        this.f43050c = view;
    }

    /* access modifiers changed from: protected */
    public void onLayout(boolean z, int i, int i2, int i3, int i4) {
        super.onLayout(z, i, i2, i3, i4);
        if (this.f43049b) {
            View view = this.f43050c;
            if (view != null) {
                int i5 = this.f43051d;
                if (i5 < 0) {
                    ImageView imageView = this.f43048a;
                    if (imageView != null) {
                        imageView.layout(0, 0, i3, view.getHeight() - this.f43051d);
                    }
                } else {
                    if (i5 > view.getHeight()) {
                        i5 = view.getHeight();
                    }
                    ImageView imageView2 = this.f43048a;
                    if (imageView2 != null) {
                        int i6 = -i5;
                        imageView2.layout(0, i6, i3, view.getHeight() + i6);
                    }
                }
            }
        } else {
            ImageView imageView3 = this.f43048a;
            if (imageView3 != null) {
                imageView3.layout(0, 0, i3, (int) (((((float) i3) * 1.0f) * ((float) 3)) / ((float) 4)));
            }
        }
        ImageView imageView4 = this.f43048a;
        LogUtil.m29100d("TAG", Intrinsics.stringPlus(">>>> imageView h = ", imageView4 == null ? null : Integer.valueOf(imageView4.getHeight())));
    }

    public final void updateImage(ScopeContext scopeContext, boolean z, String str, String str2, Function0<Unit> function0) {
        Intrinsics.checkNotNullParameter(scopeContext, "scopeContext");
        Intrinsics.checkNotNullParameter(function0, "specialImageLoadFail");
        this.f43049b = z;
        m30457a();
        Object obj = null;
        if (this.f43049b) {
            ImageView imageView = this.f43048a;
            if (imageView != null) {
                obj = imageView.getTag();
            }
            if (!Intrinsics.areEqual((Object) str, obj)) {
                FlyImageLoader.loadImageUnspecified(scopeContext, str).dontAnimate().centerCrop().listener(new FeedHeaderLayout$updateImage$1(function0)).into(this.f43048a);
                ImageView imageView2 = this.f43048a;
                if (imageView2 != null) {
                    imageView2.setTag(str);
                }
            }
        } else {
            CharSequence charSequence = str2;
            if (charSequence == null || charSequence.length() == 0) {
                ImageView imageView3 = this.f43048a;
                if (imageView3 != null) {
                    imageView3.setImageResource(R.drawable.customer_home_header_bg);
                }
                ImageView imageView4 = this.f43048a;
                if (imageView4 != null) {
                    imageView4.setTag((Object) null);
                }
            } else {
                ImageView imageView5 = this.f43048a;
                if (imageView5 != null) {
                    obj = imageView5.getTag();
                }
                if (!Intrinsics.areEqual((Object) str2, obj)) {
                    FlyImageLoader.loadImageUnspecified(scopeContext, str2).dontAnimate().centerCrop().into(this.f43048a);
                    ImageView imageView6 = this.f43048a;
                    if (imageView6 != null) {
                        imageView6.setTag(str2);
                    }
                }
            }
        }
        requestLayout();
        invalidate();
    }

    public final void acceptRefreshOffset(int i) {
        LogUtil.m29100d("TAG", Intrinsics.stringPlus("acceptRefreshOffset offset = ", Integer.valueOf(i)));
        this.f43054g.mo108149a(i);
    }

    public final void attachRecycleView(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43054g.mo108150a(recyclerView);
    }

    public final void acceptRefreshAnchor(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "recyclerView");
        this.f43054g.mo108152b(recyclerView);
    }
}

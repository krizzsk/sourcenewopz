package com.didi.soda.customer.widget.tabbar;

import android.content.Context;
import android.content.res.ColorStateList;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.didi.soda.customer.foundation.rpc.entity.TagEntity;
import com.didi.soda.customer.foundation.util.CustomerApolloUtil;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.foundation.util.SingletonFactory;
import com.didi.soda.customer.service.IToolsService;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.didi.soda.customer.widget.text.RichTextView;
import com.didi.soda.home.manager.TagStorage;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u000e\n\u0002\b\u0004\b\u0002\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004J\u0012\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0016J\u0010\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014J)\u0010\u0015\u001a\u00020\u00122!\u0010\u0016\u001a\u001d\u0012\u0013\u0012\u00110\u0018¢\u0006\f\b\u0019\u0012\b\b\u001a\u0012\u0004\b\b(\u001b\u0012\u0004\u0012\u00020\u00120\u0017J\u0012\u0010\u001c\u001a\u00020\u000e2\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u0002J\u0010\u0010\u001d\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0014H\u0002J\u001a\u0010\u001f\u001a\u00020\u00122\b\u0010 \u001a\u0004\u0018\u00010!2\u0006\u0010\"\u001a\u00020\u000eH\u0002J\u000e\u0010#\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0014J\u0010\u0010$\u001a\u00020\u00122\u0006\u0010\u001e\u001a\u00020\u0014H\u0002R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000b\u001a\u0004\u0018\u00010\fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/soda/customer/widget/tabbar/TabBarItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "discountTagView", "Lcom/didi/soda/customer/widget/text/RichTextView;", "gestureDetector", "Landroid/view/GestureDetector;", "iconView", "Landroid/widget/ImageView;", "textView", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "onTouchEvent", "", "event", "Landroid/view/MotionEvent;", "saveClickTimeForDiscountTagView", "", "tabBarItemModel", "Lcom/didi/soda/customer/widget/tabbar/TabBarItemModel;", "setOnDoubleClickListener", "doubleClick", "Lkotlin/Function1;", "Landroid/view/View;", "Lkotlin/ParameterName;", "name", "view", "shouldShowTag", "updateDiscountTag", "model", "updateIconWithUrl", "imageUrl", "", "selected", "updateTabBarItem", "updateTextColor", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.soda.customer.widget.tabbar.b */
/* compiled from: TabBarController.kt */
final class C13884b extends LinearLayout {

    /* renamed from: a */
    private ImageView f42226a = ((ImageView) findViewById(R.id.customer_tabbar_icon));

    /* renamed from: b */
    private CustomerAppCompatTextView f42227b = ((CustomerAppCompatTextView) findViewById(R.id.customer_tabbar_text));

    /* renamed from: c */
    private RichTextView f42228c = ((RichTextView) findViewById(R.id.customer_tabbar_tag));

    /* renamed from: d */
    private GestureDetector f42229d;

    /* renamed from: a */
    public void mo106252a() {
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public C13884b(Context context) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        View.inflate(context, R.layout.customer_widget_tabbar_item_layout, this);
    }

    /* renamed from: a */
    private final void m29765a(String str, boolean z) {
        if (!TextUtils.isEmpty(str)) {
            ImageView imageView = this.f42226a;
            Drawable drawable = imageView == null ? null : imageView.getDrawable();
            if (CustomerApolloUtil.tabBarPlaceHolderSwitch()) {
                FlyImageLoader.loadImageUnspecified(getContext(), str).diskCacheStrategy(DiskCacheStrategy.DATA).fitCenter().dontAnimate().into(this.f42226a);
            } else {
                FlyImageLoader.loadImageUnspecified(getContext(), str).diskCacheStrategy(DiskCacheStrategy.DATA).placeholder(drawable).fitCenter().dontAnimate().into(this.f42226a);
            }
        }
    }

    /* renamed from: c */
    private final void m29766c(C13883a aVar) {
        if (aVar.mo106241a().getTextColor() == null || aVar.mo106241a().getTextColorSelected() == null) {
            ColorStateList colorStateList = ResourceHelper.getColorStateList(R.color.customer_selector_tab_item_text_color);
            CustomerAppCompatTextView customerAppCompatTextView = this.f42227b;
            if (customerAppCompatTextView != null) {
                customerAppCompatTextView.setTextColor(colorStateList);
                return;
            }
            return;
        }
        int[][] iArr = {new int[]{16842913}, new int[]{-16842913}};
        Integer textColorSelected = aVar.mo106241a().getTextColorSelected();
        Intrinsics.checkNotNull(textColorSelected);
        Integer textColor = aVar.mo106241a().getTextColor();
        Intrinsics.checkNotNull(textColor);
        ColorStateList colorStateList2 = new ColorStateList(iArr, new int[]{textColorSelected.intValue(), textColor.intValue()});
        CustomerAppCompatTextView customerAppCompatTextView2 = this.f42227b;
        if (customerAppCompatTextView2 != null) {
            customerAppCompatTextView2.setTextColor(colorStateList2);
        }
    }

    /* JADX WARNING: Code restructure failed: missing block: B:10:0x0020, code lost:
        r2 = r2.getMDiscountTag();
     */
    /* JADX WARNING: Removed duplicated region for block: B:67:0x00ea A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:75:0x0104 A[Catch:{ Exception -> 0x010f }] */
    /* JADX WARNING: Removed duplicated region for block: B:80:0x0118  */
    /* renamed from: d */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m29767d(com.didi.soda.customer.widget.tabbar.C13883a r7) {
        /*
            r6 = this;
            boolean r0 = r6.m29768e(r7)
            if (r0 == 0) goto L_0x0129
            r0 = 0
            r6.setClipChildren(r0)
            com.didi.soda.customer.widget.text.RichTextView r1 = r6.f42228c
            if (r1 != 0) goto L_0x000f
            goto L_0x0012
        L_0x000f:
            r1.setVisibility(r0)
        L_0x0012:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f42228c
            r1 = 0
            if (r0 != 0) goto L_0x0018
            goto L_0x0030
        L_0x0018:
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.mo106241a()
            if (r2 != 0) goto L_0x0020
        L_0x001e:
            r2 = r1
            goto L_0x002b
        L_0x0020:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()
            if (r2 != 0) goto L_0x0027
            goto L_0x001e
        L_0x0027:
            java.lang.String r2 = r2.getContent()
        L_0x002b:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            r0.setText(r2)
        L_0x0030:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f42228c
            if (r0 != 0) goto L_0x0036
        L_0x0034:
            r0 = r1
            goto L_0x006d
        L_0x0036:
            android.text.TextPaint r0 = r0.getPaint()
            if (r0 != 0) goto L_0x003d
            goto L_0x0034
        L_0x003d:
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.mo106241a()
            if (r2 != 0) goto L_0x0045
        L_0x0043:
            r2 = r1
            goto L_0x0050
        L_0x0045:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()
            if (r2 != 0) goto L_0x004c
            goto L_0x0043
        L_0x004c:
            java.lang.String r2 = r2.getContent()
        L_0x0050:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2
            java.lang.CharSequence r2 = com.didi.soda.customer.widget.text.RichTextParser.parseText(r2)
            java.lang.String r2 = r2.toString()
            float r0 = r0.measureText(r2)
            r2 = 2131168369(0x7f070c71, float:1.7951038E38)
            int r2 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r2)
            int r2 = r2 * 2
            float r2 = (float) r2
            float r0 = r0 + r2
            java.lang.Float r0 = java.lang.Float.valueOf(r0)
        L_0x006d:
            com.didi.soda.customer.widget.text.RichTextView r2 = r6.f42228c
            if (r2 != 0) goto L_0x0073
            r2 = r1
            goto L_0x0077
        L_0x0073:
            android.view.ViewGroup$LayoutParams r2 = r2.getLayoutParams()
        L_0x0077:
            boolean r3 = r2 instanceof androidx.constraintlayout.widget.ConstraintLayout.LayoutParams
            if (r3 == 0) goto L_0x007e
            androidx.constraintlayout.widget.ConstraintLayout$LayoutParams r2 = (androidx.constraintlayout.widget.ConstraintLayout.LayoutParams) r2
            goto L_0x007f
        L_0x007e:
            r2 = r1
        L_0x007f:
            if (r0 == 0) goto L_0x00a0
            if (r2 != 0) goto L_0x0084
            goto L_0x00a0
        L_0x0084:
            float r3 = r0.floatValue()
            r4 = 2131167468(0x7f0708ec, float:1.794921E38)
            int r5 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            float r5 = (float) r5
            int r3 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r3 <= 0) goto L_0x0099
            int r0 = com.didi.soda.customer.foundation.util.ResourceHelper.getDimensionPixelSize(r4)
            goto L_0x009e
        L_0x0099:
            float r0 = r0.floatValue()
            int r0 = (int) r0
        L_0x009e:
            r2.width = r0
        L_0x00a0:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f42228c
            if (r0 != 0) goto L_0x00a5
            goto L_0x00aa
        L_0x00a5:
            android.view.ViewGroup$LayoutParams r2 = (android.view.ViewGroup.LayoutParams) r2
            r0.setLayoutParams(r2)
        L_0x00aa:
            com.didi.soda.customer.widget.text.RichTextView r0 = r6.f42228c
            if (r0 != 0) goto L_0x00b0
        L_0x00ae:
            r0 = r1
            goto L_0x00c5
        L_0x00b0:
            android.content.Context r0 = r0.getContext()
            if (r0 != 0) goto L_0x00b7
            goto L_0x00ae
        L_0x00b7:
            android.content.res.Resources r0 = r0.getResources()
            if (r0 != 0) goto L_0x00be
            goto L_0x00ae
        L_0x00be:
            r2 = 2131232327(0x7f080647, float:1.808076E38)
            android.graphics.drawable.Drawable r0 = r0.getDrawable(r2)
        L_0x00c5:
            boolean r2 = r0 instanceof android.graphics.drawable.GradientDrawable
            if (r2 == 0) goto L_0x00cc
            android.graphics.drawable.GradientDrawable r0 = (android.graphics.drawable.GradientDrawable) r0
            goto L_0x00cd
        L_0x00cc:
            r0 = r1
        L_0x00cd:
            if (r0 == 0) goto L_0x011d
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.mo106241a()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00d7
        L_0x00d5:
            r2 = r1
            goto L_0x00e2
        L_0x00d7:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00de
            goto L_0x00d5
        L_0x00de:
            java.lang.String r2 = r2.getBackColor()     // Catch:{ Exception -> 0x010f }
        L_0x00e2:
            java.lang.CharSequence r2 = (java.lang.CharSequence) r2     // Catch:{ Exception -> 0x010f }
            boolean r2 = android.text.TextUtils.isEmpty(r2)     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x0104
            com.didi.soda.customer.widget.tabbar.TabBarItem r2 = r7.mo106241a()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00f1
            goto L_0x00fc
        L_0x00f1:
            com.didi.soda.customer.foundation.rpc.entity.TagEntity r2 = r2.getMDiscountTag()     // Catch:{ Exception -> 0x010f }
            if (r2 != 0) goto L_0x00f8
            goto L_0x00fc
        L_0x00f8:
            java.lang.String r1 = r2.getBackColor()     // Catch:{ Exception -> 0x010f }
        L_0x00fc:
            int r1 = android.graphics.Color.parseColor(r1)     // Catch:{ Exception -> 0x010f }
            r0.setColor(r1)     // Catch:{ Exception -> 0x010f }
            goto L_0x0113
        L_0x0104:
            r1 = 2131101596(0x7f06079c, float:1.7815606E38)
            int r1 = com.didi.soda.customer.foundation.util.ResourceHelper.getColor(r1)     // Catch:{ Exception -> 0x010f }
            r0.setColor(r1)     // Catch:{ Exception -> 0x010f }
            goto L_0x0113
        L_0x010f:
            r1 = move-exception
            r1.fillInStackTrace()
        L_0x0113:
            com.didi.soda.customer.widget.text.RichTextView r1 = r6.f42228c
            if (r1 != 0) goto L_0x0118
            goto L_0x011d
        L_0x0118:
            android.graphics.drawable.Drawable r0 = (android.graphics.drawable.Drawable) r0
            r1.setBackground(r0)
        L_0x011d:
            com.didi.soda.home.topgun.manager.HomeOmegaHelper r0 = com.didi.soda.home.topgun.manager.HomeOmegaHelper.getInstance()
            com.didi.soda.customer.widget.tabbar.TabBarItem r7 = r7.mo106241a()
            r0.trackTabBarRedFlagSW(r7)
            goto L_0x0133
        L_0x0129:
            com.didi.soda.customer.widget.text.RichTextView r7 = r6.f42228c
            if (r7 != 0) goto L_0x012e
            goto L_0x0133
        L_0x012e:
            r0 = 8
            r7.setVisibility(r0)
        L_0x0133:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.soda.customer.widget.tabbar.C13884b.m29767d(com.didi.soda.customer.widget.tabbar.a):void");
    }

    /* renamed from: e */
    private final boolean m29768e(C13883a aVar) {
        boolean z;
        TagEntity mDiscountTag = aVar == null ? null : aVar.mo106241a().getMDiscountTag();
        if (aVar != null && aVar.mo106249d()) {
            z = true;
        } else {
            z = false;
        }
        if (z || mDiscountTag == null || TextUtils.isEmpty(mDiscountTag.getContent())) {
            return false;
        }
        long j = ((TagStorage) SingletonFactory.get(TagStorage.class)).getLong(mDiscountTag.getCacheKey());
        if (TextUtils.isEmpty(mDiscountTag.getCacheKey()) || j == 0 || System.currentTimeMillis() - j > ((long) (mDiscountTag.getWaitTime() * 24 * 60 * 60)) * 1000) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    public final void mo106253a(C13883a aVar) {
        String str;
        TagEntity mDiscountTag;
        TagEntity mDiscountTag2;
        if (m29768e(aVar)) {
            String str2 = null;
            if (aVar == null || (mDiscountTag2 = aVar.mo106241a().getMDiscountTag()) == null) {
                str = null;
            } else {
                str = mDiscountTag2.getCacheKey();
            }
            if (!TextUtils.isEmpty(str)) {
                TagStorage tagStorage = (TagStorage) SingletonFactory.get(TagStorage.class);
                if (!(aVar == null || (mDiscountTag = aVar.mo106241a().getMDiscountTag()) == null)) {
                    str2 = mDiscountTag.getCacheKey();
                }
                tagStorage.putLong(str2, System.currentTimeMillis());
            }
        }
    }

    /* renamed from: b */
    public final void mo106254b(C13883a aVar) {
        Intrinsics.checkNotNullParameter(aVar, "model");
        TabBarItem a = aVar.mo106241a();
        setSelected(aVar.mo106250e());
        CustomerAppCompatTextView customerAppCompatTextView = this.f42227b;
        if (customerAppCompatTextView != null) {
            customerAppCompatTextView.setText(a.getText());
        }
        m29766c(aVar);
        m29767d(aVar);
        boolean z = false;
        boolean z2 = true;
        if (isSelected()) {
            CharSequence iconUrlSelected = a.getIconUrlSelected();
            if (iconUrlSelected == null || iconUrlSelected.length() == 0) {
                z = true;
            }
            if (z) {
                ImageView imageView = this.f42226a;
                if (imageView != null) {
                    imageView.setImageResource(a.getIconResSelected());
                }
            } else {
                m29765a(a.getIconUrlSelected(), true);
            }
            CustomerAppCompatTextView customerAppCompatTextView2 = this.f42227b;
            if (customerAppCompatTextView2 != null) {
                customerAppCompatTextView2.setFontType(IToolsService.FontType.BOLD);
                return;
            }
            return;
        }
        CharSequence iconUrl = a.getIconUrl();
        if (!(iconUrl == null || iconUrl.length() == 0)) {
            z2 = false;
        }
        if (z2) {
            ImageView imageView2 = this.f42226a;
            if (imageView2 != null) {
                imageView2.setImageResource(a.getIconRes());
            }
        } else {
            m29765a(a.getIconUrl(), false);
        }
        CustomerAppCompatTextView customerAppCompatTextView3 = this.f42227b;
        if (customerAppCompatTextView3 != null) {
            customerAppCompatTextView3.setFontType(IToolsService.FontType.NORMAL);
        }
    }

    public final void setOnDoubleClickListener(Function1<? super View, Unit> function1) {
        Intrinsics.checkNotNullParameter(function1, "doubleClick");
        this.f42229d = new GestureDetector(getContext(), new TabBarItemView$setOnDoubleClickListener$listener$1(function1, this));
    }

    public boolean onTouchEvent(MotionEvent motionEvent) {
        GestureDetector gestureDetector = this.f42229d;
        if (gestureDetector != null) {
            Intrinsics.checkNotNull(gestureDetector);
            if (gestureDetector.onTouchEvent(motionEvent)) {
                return true;
            }
        }
        return super.onTouchEvent(motionEvent);
    }
}

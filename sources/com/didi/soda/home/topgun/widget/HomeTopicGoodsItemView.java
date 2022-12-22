package com.didi.soda.home.topgun.widget;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.GradientDrawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.airbnb.lottie.LottieAnimationView;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.soda.business.model.BusinessGoodsItemRvModel;
import com.didi.soda.customer.foundation.rpc.entity.ButtonInfoEntity;
import com.didi.soda.customer.foundation.rpc.entity.ImageBottomTagEntity;
import com.didi.soda.customer.foundation.util.ExtentionsKt;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.taxis99.R;
import java.util.Collection;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u00002\u00020\u0001B%\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010(\u001a\u00020\u000bH\u0016J\u000e\u0010)\u001a\u00020*2\u0006\u0010\u001f\u001a\u00020 J\u000e\u0010+\u001a\u00020\u000b2\u0006\u0010,\u001a\u00020\u0007R\"\u0010\t\u001a\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R(\u0010\u0014\u001a\u0004\u0018\u00010\u00132\b\u0010\u0012\u001a\u0004\u0018\u00010\u0013@FX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u000e\u0010\u0019\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001aX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001c\u001a\u00020\u001dX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u001f\u001a\u0004\u0018\u00010 X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010!\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010%\u001a\u00020\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u000e¢\u0006\u0002\n\u0000¨\u0006-"}, mo175978d2 = {"Lcom/didi/soda/home/topgun/widget/HomeTopicGoodsItemView;", "Lcom/didi/soda/home/topgun/widget/HomeTopicBaseView;", "context", "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "appearListener", "Lkotlin/Function0;", "", "getAppearListener", "()Lkotlin/jvm/functions/Function0;", "setAppearListener", "(Lkotlin/jvm/functions/Function0;)V", "btn", "Landroid/widget/TextView;", "value", "Landroid/view/View$OnClickListener;", "btnClickListener", "getBtnClickListener", "()Landroid/view/View$OnClickListener;", "setBtnClickListener", "(Landroid/view/View$OnClickListener;)V", "image", "Landroid/widget/ImageView;", "logo", "lottieBanner", "Lcom/airbnb/lottie/LottieAnimationView;", "lottieText", "model", "Lcom/didi/soda/business/model/BusinessGoodsItemRvModel;", "nameTv", "originPriceTv", "priceLayout", "Landroid/widget/LinearLayout;", "priceTv", "rootView", "Landroid/view/ViewGroup;", "onAppear", "setData", "", "setMsgOrientation", "orientation", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: HomeTopicGoodsItemView.kt */
public final class HomeTopicGoodsItemView extends HomeTopicBaseView {

    /* renamed from: a */
    private ImageView f43140a;

    /* renamed from: b */
    private TextView f43141b;

    /* renamed from: c */
    private ImageView f43142c;

    /* renamed from: d */
    private TextView f43143d;

    /* renamed from: e */
    private TextView f43144e;

    /* renamed from: f */
    private TextView f43145f;

    /* renamed from: g */
    private LinearLayout f43146g;

    /* renamed from: h */
    private ViewGroup f43147h;

    /* renamed from: i */
    private TextView f43148i;

    /* renamed from: j */
    private LottieAnimationView f43149j;

    /* renamed from: k */
    private View.OnClickListener f43150k;

    /* renamed from: l */
    private Function0<Unit> f43151l;

    /* renamed from: m */
    private BusinessGoodsItemRvModel f43152m;

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemView(Context context) {
        this(context, (AttributeSet) null, 0, 6, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0, 4, (DefaultConstructorMarker) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public /* synthetic */ HomeTopicGoodsItemView(Context context, AttributeSet attributeSet, int i, int i2, DefaultConstructorMarker defaultConstructorMarker) {
        this(context, (i2 & 2) != 0 ? null : attributeSet, (i2 & 4) != 0 ? 0 : i);
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public HomeTopicGoodsItemView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        FrameLayout.inflate(context, R.layout.customer_home_item_topic_good_item, this);
        View findViewById = findViewById(R.id.customer_iv_efo_dish_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.customer_iv_efo_dish_image)");
        this.f43140a = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.customer_iv_home_efo_logo);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.customer_iv_home_efo_logo)");
        this.f43142c = (ImageView) findViewById2;
        View findViewById3 = findViewById(R.id.customer_tv_home_efo_dish_name);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.customer_tv_home_efo_dish_name)");
        this.f43141b = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.customer_tv_home_efo_price);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.customer_tv_home_efo_price)");
        this.f43143d = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.customer_tv_home_efo_orign_price);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.custom…_tv_home_efo_orign_price)");
        this.f43144e = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.customer_btn_home_efo_buy);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.customer_btn_home_efo_buy)");
        this.f43145f = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.customer_ll_home_efo_price);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.customer_ll_home_efo_price)");
        this.f43146g = (LinearLayout) findViewById7;
        View findViewById8 = findViewById(R.id.customer_cl_efo_item_root);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.customer_cl_efo_item_root)");
        this.f43147h = (ViewGroup) findViewById8;
        View findViewById9 = findViewById(R.id.customer_tv_home_efo_label);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.customer_tv_home_efo_label)");
        this.f43148i = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.customer_tv_home_efo_lottie);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.customer_tv_home_efo_lottie)");
        this.f43149j = (LottieAnimationView) findViewById10;
        this.f43147h.getLayoutParams().height = -1;
        setLayoutParams(new FrameLayout.LayoutParams(-2, -1));
    }

    public final View.OnClickListener getBtnClickListener() {
        return this.f43150k;
    }

    public final void setBtnClickListener(View.OnClickListener onClickListener) {
        this.f43145f.setOnClickListener(onClickListener);
    }

    public final Function0<Unit> getAppearListener() {
        return this.f43151l;
    }

    public final void setAppearListener(Function0<Unit> function0) {
        this.f43151l = function0;
    }

    public final void setMsgOrientation(int i) {
        this.f43146g.setOrientation(i);
    }

    public final boolean setData(BusinessGoodsItemRvModel businessGoodsItemRvModel) {
        Intrinsics.checkNotNullParameter(businessGoodsItemRvModel, "model");
        this.f43152m = businessGoodsItemRvModel;
        FlyImageLoader.loadImageUnspecified(getContext(), businessGoodsItemRvModel.mItemImg).error((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).placeholder((int) R.drawable.customer_skin_img_topgun_placeholder_business_item).transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_40), 0, RoundedCornersTransformation.CornerType.TOP, true)).into(this.f43140a);
        FlyImageLoader.loadImage1x1(getContext(), businessGoodsItemRvModel.mLogo).centerCrop().transform(new RoundedCornersTransformation(getContext(), ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18), 0, RoundedCornersTransformation.CornerType.ALL, true)).into(this.f43142c);
        this.f43141b.setText(businessGoodsItemRvModel.mGoodsName);
        ImageBottomTagEntity imageBottomTagEntity = businessGoodsItemRvModel.mBottomTagEntity;
        ViewGroup.MarginLayoutParams marginLayoutParams = null;
        CharSequence content = imageBottomTagEntity == null ? null : imageBottomTagEntity.getContent();
        if (!(content == null || content.length() == 0)) {
            TextView textView = this.f43148i;
            ImageBottomTagEntity imageBottomTagEntity2 = businessGoodsItemRvModel.mBottomTagEntity;
            textView.setText(imageBottomTagEntity2 == null ? null : imageBottomTagEntity2.getContent());
            this.f43148i.setVisibility(0);
            this.f43149j.setVisibility(0);
            List<String> color = businessGoodsItemRvModel.mBottomTagEntity.getColor();
            if (color != null) {
                LottieAnimationView lottieAnimationView = this.f43149j;
                GradientDrawable gradientDrawable = new GradientDrawable();
                try {
                    int[] iArr = new int[color.size()];
                    int i = 0;
                    for (Object next : color) {
                        int i2 = i + 1;
                        if (i < 0) {
                            CollectionsKt.throwIndexOverflow();
                        }
                        iArr[i] = Color.parseColor((String) next);
                        i = i2;
                    }
                    gradientDrawable.setColors(iArr);
                } catch (Exception unused) {
                }
                ImageBottomTagEntity imageBottomTagEntity3 = businessGoodsItemRvModel.mBottomTagEntity;
                gradientDrawable.setOrientation(ExtentionsKt.updateAngle(gradientDrawable, imageBottomTagEntity3 == null ? null : Integer.valueOf(imageBottomTagEntity3.getAngle())));
                Unit unit = Unit.INSTANCE;
                lottieAnimationView.setBackground(gradientDrawable);
            }
        } else {
            this.f43148i.setVisibility(8);
            this.f43149j.setVisibility(8);
        }
        this.f43143d.setText(businessGoodsItemRvModel.mPriceDesc);
        this.f43144e.setText(businessGoodsItemRvModel.mOriginalPriceDesc);
        this.f43144e.setVisibility(0);
        ButtonInfoEntity buttonInfoEntity = businessGoodsItemRvModel.mBtnInfo;
        CharSequence content2 = buttonInfoEntity == null ? null : buttonInfoEntity.getContent();
        if (!(content2 == null || content2.length() == 0)) {
            ButtonInfoEntity buttonInfoEntity2 = businessGoodsItemRvModel.mBtnInfo;
            this.f43145f.setText(buttonInfoEntity2.getContent());
            Collection color2 = buttonInfoEntity2.getColor();
            if (!(color2 == null || color2.isEmpty())) {
                List<String> color3 = buttonInfoEntity2.getColor();
                if (color3 != null) {
                    TextView textView2 = this.f43145f;
                    GradientDrawable gradientDrawable2 = new GradientDrawable();
                    try {
                        int[] iArr2 = new int[color3.size()];
                        int i3 = 0;
                        for (Object next2 : color3) {
                            int i4 = i3 + 1;
                            if (i3 < 0) {
                                CollectionsKt.throwIndexOverflow();
                            }
                            iArr2[i3] = Color.parseColor((String) next2);
                            i3 = i4;
                        }
                        gradientDrawable2.setColors(iArr2);
                    } catch (Exception unused2) {
                    }
                    gradientDrawable2.setOrientation(ExtentionsKt.updateAngle(gradientDrawable2, Integer.valueOf(buttonInfoEntity2.getAngle())));
                    gradientDrawable2.setCornerRadius((float) ResourceHelper.getDimensionPixelSize(R.dimen.rf_dimen_18));
                    Unit unit2 = Unit.INSTANCE;
                    textView2.setBackground(gradientDrawable2);
                }
            } else {
                this.f43145f.setBackgroundResource(R.drawable.customer_shape_bg_order_list_main_button);
            }
            this.f43145f.setVisibility(0);
        } else {
            this.f43145f.setVisibility(8);
        }
        this.f43146g.setOrientation(0);
        this.f43146g.measure(View.MeasureSpec.makeMeasureSpec(0, 0), View.MeasureSpec.makeMeasureSpec(0, 0));
        int i5 = this.f43140a.getLayoutParams().width;
        int measuredWidth = this.f43146g.getMeasuredWidth();
        ViewGroup.LayoutParams layoutParams = this.f43146g.getLayoutParams();
        if (!(layoutParams instanceof ViewGroup.MarginLayoutParams)) {
            layoutParams = null;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams2 = (ViewGroup.MarginLayoutParams) layoutParams;
        int i6 = measuredWidth + (marginLayoutParams2 != null ? marginLayoutParams2.leftMargin : 0);
        ViewGroup.LayoutParams layoutParams2 = this.f43146g.getLayoutParams();
        if (layoutParams2 instanceof ViewGroup.MarginLayoutParams) {
            marginLayoutParams = layoutParams2;
        }
        ViewGroup.MarginLayoutParams marginLayoutParams3 = marginLayoutParams;
        if (i5 < i6 + (marginLayoutParams3 != null ? marginLayoutParams3.rightMargin : 0)) {
            this.f43146g.setOrientation(1);
        }
        if (this.f43146g.getOrientation() == 1) {
            return true;
        }
        return false;
    }

    public void onAppear() {
        BusinessGoodsItemRvModel businessGoodsItemRvModel = this.f43152m;
        boolean z = false;
        if (businessGoodsItemRvModel != null && businessGoodsItemRvModel.isShowed) {
            z = true;
        }
        if (!z) {
            BusinessGoodsItemRvModel businessGoodsItemRvModel2 = this.f43152m;
            if (businessGoodsItemRvModel2 != null) {
                businessGoodsItemRvModel2.isShowed = true;
            }
            Function0<Unit> function0 = this.f43151l;
            if (function0 != null) {
                function0.invoke();
            }
            if (!this.f43149j.isAnimating() && this.f43149j.getVisibility() == 0) {
                this.f43149j.playAnimation();
            }
        }
    }
}

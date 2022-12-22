package com.didi.soda.order.view;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import com.didi.app.nova.skeleton.image.RoundedCornersTransformation;
import com.didi.app.nova.support.util.DisplayUtils;
import com.didi.rfusion.widget.RFIconView;
import com.didi.soda.customer.foundation.util.FlyImageLoader;
import com.didi.soda.customer.foundation.util.ResourceHelper;
import com.didi.soda.customer.widget.support.CustomerAppCompatTextView;
import com.taxis99.R;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001eB\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B#\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\bB-\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\nJ\b\u0010\u0016\u001a\u0004\u0018\u00010\u0006J\u0006\u0010\u0017\u001a\u00020\u0015J.\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u0002\u001a\u00020\u00032\b\u0010\u0005\u001a\u0004\u0018\u00010\u00062\b\u0010\u0007\u001a\u0004\u0018\u00010\u00062\b\u0010\t\u001a\u0004\u0018\u00010\u0006H\u0002J\u0006\u0010\u001a\u001a\u00020\u0019J\u000e\u0010\u001b\u001a\u00020\u00192\u0006\u0010\u0010\u001a\u00020\u0011J\u0006\u0010\u001c\u001a\u00020\u0019J\u0006\u0010\u001d\u001a\u00020\u0019R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X\u000e¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/soda/order/view/OrderEvaluateBusinessItemView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "itemId", "", "itemName", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;)V", "itemImg", "(Landroid/content/Context;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "itemIconPoor", "Lcom/didi/rfusion/widget/RFIconView;", "itemIconPraise", "itemPic", "Landroid/widget/ImageView;", "listener", "Lcom/didi/soda/order/view/OrderEvaluateBusinessItemView$itemEvaluateClickLisener;", "picName", "Lcom/didi/soda/customer/widget/support/CustomerAppCompatTextView;", "score", "", "getItemId", "getScore", "initView", "", "setClickListener", "setEvaluateclickLisener", "setPoorFilled", "setPraiseFilled", "itemEvaluateClickLisener", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderEvaluateBusinessItemView.kt */
public final class OrderEvaluateBusinessItemView extends LinearLayout {

    /* renamed from: a */
    private ImageView f43568a;

    /* renamed from: b */
    private CustomerAppCompatTextView f43569b;

    /* renamed from: c */
    private RFIconView f43570c;

    /* renamed from: d */
    private RFIconView f43571d;

    /* renamed from: e */
    private int f43572e;

    /* renamed from: f */
    private String f43573f;

    /* renamed from: g */
    private itemEvaluateClickLisener f43574g;

    @Metadata(mo175977d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\bf\u0018\u00002\u00020\u0001J\b\u0010\u0002\u001a\u00020\u0003H&J\b\u0010\u0004\u001a\u00020\u0003H&¨\u0006\u0005"}, mo175978d2 = {"Lcom/didi/soda/order/view/OrderEvaluateBusinessItemView$itemEvaluateClickLisener;", "", "clickPoor", "", "clickPraise", "customer-aar_brazilEmbedRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: OrderEvaluateBusinessItemView.kt */
    public interface itemEvaluateClickLisener {
        void clickPoor();

        void clickPraise();
    }

    public void _$_clearFindViewByIdCache() {
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrderEvaluateBusinessItemView(Context context) {
        this(context, (String) null, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrderEvaluateBusinessItemView(Context context, String str, String str2) {
        this(context, str, (String) null, (String) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderEvaluateBusinessItemView(Context context, String str, String str2, String str3) {
        super(context);
        Intrinsics.checkNotNullParameter(context, "context");
        m30876a(context, str, str2, str3);
    }

    /* renamed from: a */
    private final void m30876a(Context context, String str, String str2, String str3) {
        this.f43573f = str;
        View inflate = LayoutInflater.from(getContext()).inflate(R.layout.customer_widget_evaluate_business_item, this, true);
        View findViewById = inflate.findViewById(R.id.customer_item_evaluation_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "root.findViewById(R.id.c…er_item_evaluation_image)");
        this.f43568a = (ImageView) findViewById;
        View findViewById2 = inflate.findViewById(R.id.customer_item_evaluation_text);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "root.findViewById(R.id.c…mer_item_evaluation_text)");
        this.f43569b = (CustomerAppCompatTextView) findViewById2;
        View findViewById3 = inflate.findViewById(R.id.customer_item_evaluation_icon_praise);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "root.findViewById(R.id.c…m_evaluation_icon_praise)");
        this.f43570c = (RFIconView) findViewById3;
        View findViewById4 = inflate.findViewById(R.id.customer_item_evaluation_icon_poor);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "root.findViewById(R.id.c…tem_evaluation_icon_poor)");
        this.f43571d = (RFIconView) findViewById4;
        FlyImageLoader.ImageRequestWrapper transform = FlyImageLoader.loadImage1x1(context, str3).placeholder((int) R.drawable.customer_skin_img_business_goods_item_x11).transform(new RoundedCornersTransformation(context, DisplayUtils.dip2px(context, 4.0f), 0, RoundedCornersTransformation.CornerType.ALL, true));
        ImageView imageView = this.f43568a;
        RFIconView rFIconView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemPic");
            imageView = null;
        }
        transform.into(imageView);
        CustomerAppCompatTextView customerAppCompatTextView = this.f43569b;
        if (customerAppCompatTextView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("picName");
            customerAppCompatTextView = null;
        }
        customerAppCompatTextView.setText(str2);
        RFIconView rFIconView2 = this.f43570c;
        if (rFIconView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            rFIconView2 = null;
        }
        rFIconView2.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
        RFIconView rFIconView3 = this.f43570c;
        if (rFIconView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            rFIconView3 = null;
        }
        rFIconView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        RFIconView rFIconView4 = this.f43571d;
        if (rFIconView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
            rFIconView4 = null;
        }
        rFIconView4.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
        RFIconView rFIconView5 = this.f43571d;
        if (rFIconView5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
        } else {
            rFIconView = rFIconView5;
        }
        rFIconView.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        setClickListener();
    }

    public final void setEvaluateclickLisener(itemEvaluateClickLisener itemevaluateclicklisener) {
        Intrinsics.checkNotNullParameter(itemevaluateclicklisener, "listener");
        this.f43574g = itemevaluateclicklisener;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m30877a(OrderEvaluateBusinessItemView orderEvaluateBusinessItemView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateBusinessItemView, "this$0");
        itemEvaluateClickLisener itemevaluateclicklisener = orderEvaluateBusinessItemView.f43574g;
        if (itemevaluateclicklisener != null) {
            itemevaluateclicklisener.clickPraise();
        }
    }

    public final void setClickListener() {
        RFIconView rFIconView = this.f43570c;
        RFIconView rFIconView2 = null;
        if (rFIconView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            rFIconView = null;
        }
        rFIconView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateBusinessItemView.m30877a(OrderEvaluateBusinessItemView.this, view);
            }
        });
        RFIconView rFIconView3 = this.f43571d;
        if (rFIconView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
        } else {
            rFIconView2 = rFIconView3;
        }
        rFIconView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                OrderEvaluateBusinessItemView.m30878b(OrderEvaluateBusinessItemView.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m30878b(OrderEvaluateBusinessItemView orderEvaluateBusinessItemView, View view) {
        Intrinsics.checkNotNullParameter(orderEvaluateBusinessItemView, "this$0");
        itemEvaluateClickLisener itemevaluateclicklisener = orderEvaluateBusinessItemView.f43574g;
        if (itemevaluateclicklisener != null) {
            itemevaluateclicklisener.clickPoor();
        }
    }

    public final void setPraiseFilled() {
        int i = this.f43572e;
        RFIconView rFIconView = null;
        if (i == 0 || i == 2) {
            RFIconView rFIconView2 = this.f43571d;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
                rFIconView2 = null;
            }
            rFIconView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
            RFIconView rFIconView3 = this.f43570c;
            if (rFIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
                rFIconView3 = null;
            }
            rFIconView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_brand1_1_a100));
            RFIconView rFIconView4 = this.f43571d;
            if (rFIconView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
                rFIconView4 = null;
            }
            rFIconView4.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
            RFIconView rFIconView5 = this.f43570c;
            if (rFIconView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            } else {
                rFIconView = rFIconView5;
            }
            rFIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_praise));
            this.f43572e = 10;
            return;
        }
        RFIconView rFIconView6 = this.f43571d;
        if (rFIconView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
            rFIconView6 = null;
        }
        rFIconView6.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        RFIconView rFIconView7 = this.f43570c;
        if (rFIconView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            rFIconView7 = null;
        }
        rFIconView7.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        RFIconView rFIconView8 = this.f43571d;
        if (rFIconView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
            rFIconView8 = null;
        }
        rFIconView8.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
        RFIconView rFIconView9 = this.f43570c;
        if (rFIconView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
        } else {
            rFIconView = rFIconView9;
        }
        rFIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
        this.f43572e = 0;
    }

    public final void setPoorFilled() {
        int i = this.f43572e;
        RFIconView rFIconView = null;
        if (i == 0 || i == 10) {
            RFIconView rFIconView2 = this.f43570c;
            if (rFIconView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
                rFIconView2 = null;
            }
            rFIconView2.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
            RFIconView rFIconView3 = this.f43571d;
            if (rFIconView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
                rFIconView3 = null;
            }
            rFIconView3.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey1_3_a60));
            RFIconView rFIconView4 = this.f43571d;
            if (rFIconView4 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
                rFIconView4 = null;
            }
            rFIconView4.setText(ResourceHelper.getString(R.string.rf_icon_v3_filled_poor));
            RFIconView rFIconView5 = this.f43570c;
            if (rFIconView5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            } else {
                rFIconView = rFIconView5;
            }
            rFIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
            this.f43572e = 2;
            return;
        }
        RFIconView rFIconView6 = this.f43571d;
        if (rFIconView6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
            rFIconView6 = null;
        }
        rFIconView6.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        RFIconView rFIconView7 = this.f43570c;
        if (rFIconView7 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
            rFIconView7 = null;
        }
        rFIconView7.setTextColor(ResourceHelper.getColor(R.color.rf_color_v2_grey2_4_a100));
        RFIconView rFIconView8 = this.f43571d;
        if (rFIconView8 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPoor");
            rFIconView8 = null;
        }
        rFIconView8.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_poor));
        RFIconView rFIconView9 = this.f43570c;
        if (rFIconView9 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("itemIconPraise");
        } else {
            rFIconView = rFIconView9;
        }
        rFIconView.setText(ResourceHelper.getString(R.string.rf_icon_v3_outlined_praise));
        this.f43572e = 0;
    }

    public final String getItemId() {
        return this.f43573f;
    }

    public final int getScore() {
        return this.f43572e;
    }
}

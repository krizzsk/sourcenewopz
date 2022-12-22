package com.didi.payment.pix.qrpayee.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.orderdetail.widget.SectionSepretorLine;
import com.didi.sdk.util.collection.CollectionUtil;
import com.taxis99.R;
import java.util.Collection;
import java.util.Map;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

@Metadata(mo175977d1 = {"\u0000T\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\b\u0010 \u001a\u00020!H\u0002J\u000e\u0010\"\u001a\u00020!2\u0006\u0010#\u001a\u00020$R\u001a\u0010\u000b\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0001X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u001aX.¢\u0006\u0002\n\u0000R\u001a\u0010\u001b\u001a\u000e\u0012\u0004\u0012\u00020\t\u0012\u0004\u0012\u00020\t0\u001cX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u001d\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001e\u001a\u00020\u001fX\u000e¢\u0006\u0002\n\u0000¨\u0006%"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/widget/OrderDetail4ShareView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "itemsContainer", "getItemsContainer", "()Landroid/widget/LinearLayout;", "setItemsContainer", "(Landroid/widget/LinearLayout;)V", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "mainTitleTv", "Landroid/widget/TextView;", "sectionContainer", "statusImg", "Landroid/widget/ImageView;", "statusImgMap", "", "titleDescTv", "viewInflater", "Landroid/view/LayoutInflater;", "initConfig", "", "renderPageUI", "orderDetai", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderDetail4ShareView.kt */
public final class OrderDetail4ShareView extends LinearLayout {

    /* renamed from: a */
    private TextView f31186a;

    /* renamed from: b */
    private TextView f31187b;

    /* renamed from: c */
    private ImageView f31188c;

    /* renamed from: d */
    private LinearLayout f31189d;

    /* renamed from: e */
    private Map<Integer, Integer> f31190e;

    /* renamed from: f */
    private LayoutInflater f31191f;
    public LinearLayout itemsContainer;
    public View mRootView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public OrderDetail4ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        this.f31190e = MapsKt.mapOf(TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_SUCCESS()), Integer.valueOf(R.drawable.pix_transfer_icon_success)), TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_FAIL()), Integer.valueOf(R.drawable.pix_transfer_icon_failed)), TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_PENDING()), Integer.valueOf(R.drawable.pix_transfer_icon_processing)));
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.f31191f = from;
        m21947a();
    }

    public final LinearLayout getItemsContainer() {
        LinearLayout linearLayout = this.itemsContainer;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemsContainer");
        return null;
    }

    public final void setItemsContainer(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.itemsContainer = linearLayout;
    }

    public final View getMRootView() {
        View view = this.mRootView;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mRootView");
        return null;
    }

    public final void setMRootView(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mRootView = view;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrderDetail4ShareView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public OrderDetail4ShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final void m21947a() {
        View inflate = this.f31191f.inflate(R.layout.pix_orderdetail_content_lay, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "viewInflater.inflate(R.l…detail_content_lay, this)");
        setMRootView(inflate);
        getMRootView().setBackgroundColor(getResources().getColor(R.color.pix_page_light_shade_bg));
        View findViewById = findViewById(R.id.section_container_Ll);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.section_container_Ll)");
        setItemsContainer((LinearLayout) findViewById);
        View findViewById2 = findViewById(R.id.orderdetail_99logo_img);
        if (findViewById2 != null) {
            findViewById2.setVisibility(0);
        }
        View findViewById3 = findViewById(R.id.pix_order_status_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_order_status_tv)");
        this.f31186a = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.pix_order_amount_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_order_amount_tv)");
        this.f31187b = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.order_status_icon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.order_status_icon_img)");
        this.f31188c = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.section_container_Ll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.section_container_Ll)");
        this.f31189d = (LinearLayout) findViewById6;
    }

    public final void renderPageUI(PixOrderDetailResp.OrderDetail orderDetail) {
        Intrinsics.checkNotNullParameter(orderDetail, "orderDetai");
        TextView textView = this.f31186a;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mainTitleTv");
            textView = null;
        }
        textView.setText(orderDetail.getTitle());
        TextView textView2 = this.f31187b;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleDescTv");
            textView2 = null;
        }
        int indexOf$default = StringsKt.indexOf$default((CharSequence) orderDetail.getAmount(), "R$", 0, false, 6, (Object) null);
        textView2.setText(orderDetail.getAmount());
        ImageView imageView = this.f31188c;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("statusImg");
            imageView = null;
        }
        imageView.setImageResource(R.drawable.pix_transfer_icon_processing);
        int color = orderDetail.getStatus() == PixOrderDetailResp.Companion.getORDER_STATUS_SUCCESS() ? getResources().getColor(R.color.oc_color_00ccaa) : -16777216;
        TextView textView3 = this.f31187b;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleDescTv");
            textView3 = null;
        }
        textView3.setTextColor(color);
        Integer num = this.f31190e.get(Integer.valueOf(orderDetail.getStatus()));
        if (num != null) {
            int intValue = num.intValue();
            ImageView imageView2 = this.f31188c;
            if (imageView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("statusImg");
                imageView2 = null;
            }
            imageView2.setImageResource(intValue);
        }
        int size = orderDetail.getEntryList().size() - 1;
        if (size >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                PixOrderDetailResp.SectionEntry sectionEntry = orderDetail.getEntryList().get(i);
                CollectionUtil.isEmpty((Collection<?>) sectionEntry.getItems());
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setOrientation(1);
                int dip2px = UIUtil.dip2px(getContext(), 20.0f);
                int dip2px2 = UIUtil.dip2px(getContext(), 6.0f);
                if (i == 0) {
                    linearLayout.setPadding(dip2px, dip2px2, dip2px, 0);
                } else {
                    linearLayout.setPadding(dip2px, 0, dip2px, 0);
                }
                View inflate = this.f31191f.inflate(R.layout.pix_order_detail_section_title, (ViewGroup) null);
                if (inflate != null) {
                    TextView textView4 = (TextView) inflate;
                    textView4.setText(sectionEntry.getTitle());
                    linearLayout.addView(textView4);
                    for (PixOrderDetailResp.NameValuePair next : sectionEntry.getItems()) {
                        View inflate2 = this.f31191f.inflate(R.layout.pix_order_detail_item, (ViewGroup) null);
                        ((TextView) inflate2.findViewById(R.id.left_key_tv)).setText(next.getKey());
                        ((TextView) inflate2.findViewById(R.id.right_value_tv)).setText(next.getValue());
                        linearLayout.addView(inflate2);
                    }
                    LinearLayout linearLayout2 = this.f31189d;
                    if (linearLayout2 == null) {
                        Intrinsics.throwUninitializedPropertyAccessException("sectionContainer");
                        linearLayout2 = null;
                    }
                    linearLayout2.addView(linearLayout);
                    if (i < orderDetail.getEntryList().size() - 1) {
                        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                        int dip2px3 = UIUtil.dip2px(getContext(), 5.0f);
                        layoutParams.topMargin = dip2px3;
                        layoutParams.bottomMargin = dip2px3;
                        LinearLayout linearLayout3 = this.f31189d;
                        if (linearLayout3 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("sectionContainer");
                            linearLayout3 = null;
                        }
                        linearLayout3.addView(new SectionSepretorLine(getContext()));
                    }
                    if (i2 <= size) {
                        i = i2;
                    } else {
                        return;
                    }
                } else {
                    throw new NullPointerException("null cannot be cast to non-null type android.widget.TextView");
                }
            }
        }
    }
}

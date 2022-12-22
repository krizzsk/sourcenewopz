package com.didi.payment.pix.qrpayee.widget;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.commonsdk.p129ui.helper.NViewHelper;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.pix.net.response.PixQrCodeGenResp;
import com.didi.unifiedPay.util.UIUtils;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0002\u0018\u00002\u00020\u0001B\u000f\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004B\u0019\b\u0016\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006¢\u0006\u0002\u0010\u0007B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\u0006\u0010\b\u001a\u00020\t¢\u0006\u0002\u0010\nJ\u0014\u0010\u001d\u001a\u00020\u001e2\f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020!0 J\b\u0010\"\u001a\u0004\u0018\u00010#J\b\u0010$\u001a\u00020\u001eH\u0002J\u000e\u0010%\u001a\u00020\u001e2\u0006\u0010&\u001a\u00020#J\u0016\u0010'\u001a\u00020\u001e2\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020)R\u001a\u0010\u000b\u001a\u00020\tX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\u00020\u0001X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u000e\u0010\u0015\u001a\u00020\u0016X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0017\u001a\u00020\u0018X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u001a\"\u0004\b\u001b\u0010\u001c¨\u0006+"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/widget/ReceiveCode4ShareView;", "Landroid/widget/LinearLayout;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "attrs", "Landroid/util/AttributeSet;", "(Landroid/content/Context;Landroid/util/AttributeSet;)V", "defStyleAttr", "", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "IMAGE_LIMIT_3M", "getIMAGE_LIMIT_3M", "()I", "setIMAGE_LIMIT_3M", "(I)V", "itemsContainer", "getItemsContainer", "()Landroid/widget/LinearLayout;", "setItemsContainer", "(Landroid/widget/LinearLayout;)V", "layoutInflator", "Landroid/view/LayoutInflater;", "mRootView", "Landroid/view/View;", "getMRootView", "()Landroid/view/View;", "setMRootView", "(Landroid/view/View;)V", "appendItems", "", "items", "", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$KeyValuePair;", "genBitmap", "Landroid/graphics/Bitmap;", "initConfig", "loadLocalBmpIntoImg", "bmp", "setTitleDesc", "title", "", "d", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: ReceiveCode4ShareView.kt */
public final class ReceiveCode4ShareView extends LinearLayout {

    /* renamed from: a */
    private LayoutInflater f31192a;

    /* renamed from: b */
    private int f31193b;
    public LinearLayout itemsContainer;
    public View mRootView;

    /* JADX INFO: super call moved to the top of the method (can break code semantics) */
    public ReceiveCode4ShareView(Context context, AttributeSet attributeSet, int i) {
        super(context, attributeSet, i);
        Intrinsics.checkNotNullParameter(context, "context");
        LayoutInflater from = LayoutInflater.from(context);
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.f31192a = from;
        this.f31193b = 3145728;
        m21948a();
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

    public final int getIMAGE_LIMIT_3M() {
        return this.f31193b;
    }

    public final void setIMAGE_LIMIT_3M(int i) {
        this.f31193b = i;
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReceiveCode4ShareView(Context context) {
        this(context, (AttributeSet) null);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* JADX INFO: this call moved to the top of the method (can break code semantics) */
    public ReceiveCode4ShareView(Context context, AttributeSet attributeSet) {
        this(context, attributeSet, 0);
        Intrinsics.checkNotNullParameter(context, "context");
    }

    /* renamed from: a */
    private final void m21948a() {
        View inflate = this.f31192a.inflate(R.layout.pix_receive_code_share_card_view, this);
        Intrinsics.checkNotNullExpressionValue(inflate, "layoutInflator.inflate(R…de_share_card_view, this)");
        setMRootView(inflate);
        View findViewById = findViewById(R.id.append_info_items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.append_info_items_container)");
        setItemsContainer((LinearLayout) findViewById);
    }

    public final void setTitleDesc(String str, String str2) {
        Intrinsics.checkNotNullParameter(str, "title");
        Intrinsics.checkNotNullParameter(str2, "d");
        ((TextView) findViewById(R.id.main_title_tv)).setText(str);
        ((TextView) findViewById(R.id.desc_tv)).setText(str2);
    }

    public final void loadLocalBmpIntoImg(Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(bitmap, "bmp");
        RoundedImageView roundedImageView = (RoundedImageView) findViewById(R.id.receive_code_img);
        roundedImageView.setRectRedius((float) UIUtils.dip2px(getContext(), 10.0f));
        roundedImageView.setImageBitmap(bitmap);
    }

    public final void appendItems(List<PixQrCodeGenResp.KeyValuePair> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        getItemsContainer().removeAllViews();
        for (PixQrCodeGenResp.KeyValuePair next : list) {
            View inflate = this.f31192a.inflate(R.layout.pix_order_detail_item, (ViewGroup) null);
            TextView textView = (TextView) inflate.findViewById(R.id.left_key_tv);
            textView.setText(next.getTitle());
            textView.setTypeface(Typeface.defaultFromStyle(1));
            ((TextView) inflate.findViewById(R.id.right_value_tv)).setText(next.getValue());
            textView.setTypeface(Typeface.defaultFromStyle(0));
            getItemsContainer().addView(inflate);
        }
    }

    public final Bitmap genBitmap() {
        NViewHelper.Companion companion = NViewHelper.Companion;
        Context context = getContext();
        Intrinsics.checkNotNullExpressionValue(context, "context");
        return companion.genBitmap(context, this, true);
    }
}

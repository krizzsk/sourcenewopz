package com.didi.payment.pix.refund;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.response.PixRefundResultResp;
import com.didi.sdk.util.collection.CollectionUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.google.firebase.analytics.FirebaseAnalytics;
import com.taxis99.R;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0014\u0010'\u001a\u00020(2\f\u0010)\u001a\b\u0012\u0004\u0012\u00020+0*J\n\u0010,\u001a\u0004\u0018\u00010\u0013H\u0014J\u0010\u0010-\u001a\u00020(2\u0006\u0010.\u001a\u00020/H\u0016J\u0010\u00100\u001a\u00020(2\u0006\u00101\u001a\u00020\u0013H\u0016J\u0012\u00102\u001a\u00020(2\b\u00103\u001a\u0004\u0018\u000104H\u0016J&\u00105\u001a\u0004\u0018\u00010\u00132\u0006\u00106\u001a\u00020\u00112\b\u00107\u001a\u0004\u0018\u0001082\b\u00103\u001a\u0004\u0018\u000104H\u0016J\b\u00109\u001a\u00020:H\u0016J\u001a\u0010;\u001a\u00020(2\u0006\u00101\u001a\u00020\u00132\b\u00103\u001a\u0004\u0018\u000104H\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0014\u0010\u0015\"\u0004\b\u0016\u0010\u0017R\u001a\u0010\u0018\u001a\u00020\u0019X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001a\u0010\u001b\"\u0004\b\u001c\u0010\u001dR\u001a\u0010\u001e\u001a\u00020\u001fX.¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010!\"\u0004\b\"\u0010#R\u001a\u0010$\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\u0007\"\u0004\b&\u0010\t¨\u0006<"}, mo175978d2 = {"Lcom/didi/payment/pix/refund/OrderRefundDetailFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "()V", "descTv", "Landroid/widget/TextView;", "getDescTv", "()Landroid/widget/TextView;", "setDescTv", "(Landroid/widget/TextView;)V", "itemLlVp", "Landroid/widget/LinearLayout;", "getItemLlVp", "()Landroid/widget/LinearLayout;", "setItemLlVp", "(Landroid/widget/LinearLayout;)V", "mInflater", "Landroid/view/LayoutInflater;", "mTitlebar", "Landroid/view/View;", "getMTitlebar", "()Landroid/view/View;", "setMTitlebar", "(Landroid/view/View;)V", "refundItemInfoList", "Lcom/didi/payment/pix/net/response/PixRefundResultResp$OrderRefundDetails;", "getRefundItemInfoList", "()Lcom/didi/payment/pix/net/response/PixRefundResultResp$OrderRefundDetails;", "setRefundItemInfoList", "(Lcom/didi/payment/pix/net/response/PixRefundResultResp$OrderRefundDetails;)V", "statusIconImg", "Landroid/widget/ImageView;", "getStatusIconImg", "()Landroid/widget/ImageView;", "setStatusIconImg", "(Landroid/widget/ImageView;)V", "titleTv", "getTitleTv", "setTitleTv", "displayDetailItems", "", "items", "", "Lcom/didi/payment/pix/net/response/PixRefundResultResp$Entry;", "getTitleBarView", "initCommonTitlebar", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "inflater", "container", "Landroid/view/ViewGroup;", "onInflateLayout", "", "onViewCreated", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: OrderRefundDetailFragment.kt */
public final class OrderRefundDetailFragment extends AbsWBaseFragment<WBaseViewModel> {

    /* renamed from: a */
    private LayoutInflater f31194a;
    public TextView descTv;
    public LinearLayout itemLlVp;
    public View mTitlebar;
    public PixRefundResultResp.OrderRefundDetails refundItemInfoList;
    public ImageView statusIconImg;
    public TextView titleTv;

    public int onInflateLayout() {
        return R.layout.fragment_pix_order_refund_result;
    }

    public final View getMTitlebar() {
        View view = this.mTitlebar;
        if (view != null) {
            return view;
        }
        Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
        return null;
    }

    public final void setMTitlebar(View view) {
        Intrinsics.checkNotNullParameter(view, "<set-?>");
        this.mTitlebar = view;
    }

    public final ImageView getStatusIconImg() {
        ImageView imageView = this.statusIconImg;
        if (imageView != null) {
            return imageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("statusIconImg");
        return null;
    }

    public final void setStatusIconImg(ImageView imageView) {
        Intrinsics.checkNotNullParameter(imageView, "<set-?>");
        this.statusIconImg = imageView;
    }

    public final TextView getTitleTv() {
        TextView textView = this.titleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titleTv");
        return null;
    }

    public final void setTitleTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.titleTv = textView;
    }

    public final TextView getDescTv() {
        TextView textView = this.descTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("descTv");
        return null;
    }

    public final void setDescTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.descTv = textView;
    }

    public final LinearLayout getItemLlVp() {
        LinearLayout linearLayout = this.itemLlVp;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("itemLlVp");
        return null;
    }

    public final void setItemLlVp(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.itemLlVp = linearLayout;
    }

    public final PixRefundResultResp.OrderRefundDetails getRefundItemInfoList() {
        PixRefundResultResp.OrderRefundDetails orderRefundDetails = this.refundItemInfoList;
        if (orderRefundDetails != null) {
            return orderRefundDetails;
        }
        Intrinsics.throwUninitializedPropertyAccessException("refundItemInfoList");
        return null;
    }

    public final void setRefundItemInfoList(PixRefundResultResp.OrderRefundDetails orderRefundDetails) {
        Intrinsics.checkNotNullParameter(orderRefundDetails, "<set-?>");
        this.refundItemInfoList = orderRefundDetails;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return super.getTitleBarView();
    }

    public void onCreate(Bundle bundle) {
        Object obj;
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        if (!(arguments == null || (obj = arguments.get("refund_result")) == null)) {
            setRefundItemInfoList((PixRefundResultResp.OrderRefundDetails) obj);
        }
        LayoutInflater from = LayoutInflater.from(getActivity());
        Intrinsics.checkNotNullExpressionValue(from, "from(activity)");
        this.f31194a = from;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        Intrinsics.checkNotNullParameter(layoutInflater, "inflater");
        return super.onCreateView(layoutInflater, viewGroup, bundle);
    }

    public void onViewCreated(View view, Bundle bundle) {
        Intrinsics.checkNotNullParameter(view, "view");
        super.onViewCreated(view, bundle);
        HashMap hashMap = new HashMap();
        String str = getRefundItemInfoList().getStatus() == 1 ? "success" : getRefundItemInfoList().getStatus() == 2 ? "fail" : "pending";
        Map map = hashMap;
        Bundle arguments = getArguments();
        String str2 = null;
        map.put("order_id", String.valueOf(arguments == null ? null : arguments.getString("order_id")));
        Bundle arguments2 = getArguments();
        if (arguments2 != null) {
            str2 = arguments2.getString("pix_refund_amount");
        }
        map.put("pix_refund_amount", String.valueOf(str2));
        map.put("pix_refund_status", str);
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_refund_result_sw", map);
    }

    public void initContentView(View view) {
        Intrinsics.checkNotNullParameter(view, "view");
        View findViewById = view.findViewById(R.id.order_refund_result_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.o…r_refund_result_titlebar)");
        setMTitlebar(findViewById);
        View findViewById2 = view.findViewById(R.id.order_refund_status_icon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "view.findViewById(R.id.o…r_refund_status_icon_img)");
        setStatusIconImg((ImageView) findViewById2);
        View findViewById3 = view.findViewById(R.id.order_refund_status_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "view.findViewById(R.id.order_refund_status_tv)");
        setTitleTv((TextView) findViewById3);
        View findViewById4 = view.findViewById(R.id.order_refund_status_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "view.findViewById(R.id.o…er_refund_status_desc_tv)");
        setDescTv((TextView) findViewById4);
        View findViewById5 = view.findViewById(R.id.refund_detail_items_container);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "view.findViewById(R.id.r…d_detail_items_container)");
        setItemLlVp((LinearLayout) findViewById5);
        PixRefundResultResp.OrderRefundDetails refundItemInfoList2 = getRefundItemInfoList();
        int status = refundItemInfoList2.getStatus();
        if (status == 1) {
            getStatusIconImg().setImageResource(R.drawable.lego_toast_icon_success);
        } else if (status != 2) {
            getStatusIconImg().setImageResource(R.drawable.pix_icon_refund_in_progress);
        } else {
            getStatusIconImg().setImageResource(R.drawable.lego_toast_icon_failure);
        }
        getTitleTv().setText(refundItemInfoList2.getTitle());
        getDescTv().setText(refundItemInfoList2.subTitle());
        if (!CollectionUtil.isEmpty((Collection<?>) refundItemInfoList2.getEntryList())) {
            getItemLlVp().setVisibility(0);
            displayDetailItems(refundItemInfoList2.getEntryList());
        }
    }

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        ImageView imageView = new ImageView(getContext());
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-2, -2);
        layoutParams.addRule(11);
        layoutParams.addRule(15);
        layoutParams.rightMargin = UIUtil.dip2px(getContext(), 18.0f);
        commonTitleBar.addView(imageView, layoutParams);
        imageView.setOnClickListener(new OrderRefundDetailFragment$initCommonTitlebar$1());
        commonTitleBar.getLeftImgView().setOnClickListener(new OrderRefundDetailFragment$initCommonTitlebar$2(this));
        super.initCommonTitlebar(commonTitleBar);
    }

    public final void displayDetailItems(List<PixRefundResultResp.Entry> list) {
        Intrinsics.checkNotNullParameter(list, FirebaseAnalytics.Param.ITEMS);
        if (!CollectionUtil.isEmpty((Collection<?>) list)) {
            getItemLlVp().removeAllViews();
            for (PixRefundResultResp.Entry next : list) {
                LayoutInflater layoutInflater = this.f31194a;
                if (layoutInflater == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mInflater");
                    layoutInflater = null;
                }
                View inflate = layoutInflater.inflate(R.layout.title_desc_vertical, getItemLlVp(), false);
                ((TextView) inflate.findViewById(R.id.title_tv)).setText(next.getKey());
                ((TextView) inflate.findViewById(R.id.title_desc_tv)).setText(next.getValue());
                getItemLlVp().addView(inflate);
            }
        }
    }
}

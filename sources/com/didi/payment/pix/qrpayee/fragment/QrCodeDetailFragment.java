package com.didi.payment.pix.qrpayee.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.p129ui.AbsWBaseFragment;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.pix.net.response.PixQrCodeGenResp;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\u0010\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0016H\u0016J\u0010\u0010\u0017\u001a\u00020\u00142\u0006\u0010\u0018\u001a\u00020\u0019H\u0016J\u0012\u0010\u001a\u001a\u00020\u00142\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0016J\b\u0010\u001d\u001a\u00020\u001eH\u0016R\u001a\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\"\u0010\n\u001a\n\u0012\u0004\u0012\u00020\f\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010R\u000e\u0010\u0011\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006\u001f"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/fragment/QrCodeDetailFragment;", "Lcom/didi/payment/commonsdk/ui/AbsWBaseFragment;", "Lcom/didi/payment/commonsdk/ui/WBaseViewModel;", "()V", "contentParent", "Landroid/widget/LinearLayout;", "getContentParent", "()Landroid/widget/LinearLayout;", "setContentParent", "(Landroid/widget/LinearLayout;)V", "detailDatas", "", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$DetailItem;", "getDetailDatas", "()Ljava/util/List;", "setDetailDatas", "(Ljava/util/List;)V", "mLayoutInflator", "Landroid/view/LayoutInflater;", "initCommonTitlebar", "", "commonTitleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initContentView", "view", "Landroid/view/View;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInflateLayout", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QrCodeDetailFragment.kt */
public final class QrCodeDetailFragment extends AbsWBaseFragment<WBaseViewModel> {

    /* renamed from: a */
    private LayoutInflater f31176a;

    /* renamed from: b */
    private List<PixQrCodeGenResp.DetailItem> f31177b;
    public LinearLayout contentParent;

    public int onInflateLayout() {
        return R.layout.fragment_pix_qr_code_detail;
    }

    public final List<PixQrCodeGenResp.DetailItem> getDetailDatas() {
        return this.f31177b;
    }

    public final void setDetailDatas(List<PixQrCodeGenResp.DetailItem> list) {
        this.f31177b = list;
    }

    public final LinearLayout getContentParent() {
        LinearLayout linearLayout = this.contentParent;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentParent");
        return null;
    }

    public final void setContentParent(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.contentParent = linearLayout;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        Bundle arguments = getArguments();
        this.f31177b = arguments == null ? null : arguments.getParcelableArrayList("detail_data");
        LayoutInflater from = LayoutInflater.from(getContext());
        Intrinsics.checkNotNullExpressionValue(from, "from(context)");
        this.f31176a = from;
    }

    public void initContentView(View view) {
        int size;
        Intrinsics.checkNotNullParameter(view, "view");
        super.initContentView(view);
        View findViewById = view.findViewById(R.id.qr_code_detail_parent);
        Intrinsics.checkNotNullExpressionValue(findViewById, "view.findViewById(R.id.qr_code_detail_parent)");
        setContentParent((LinearLayout) findViewById);
        List<PixQrCodeGenResp.DetailItem> list = this.f31177b;
        if (list != null && list.size() - 1 >= 0) {
            int i = 0;
            while (true) {
                int i2 = i + 1;
                PixQrCodeGenResp.DetailItem detailItem = list.get(i);
                int dip2px = UIUtil.dip2px(getContext(), 20.0f);
                LinearLayout linearLayout = new LinearLayout(getContext());
                linearLayout.setBackgroundResource(R.drawable.pix_rectangle_white_corner20_bg);
                int dip2px2 = UIUtil.dip2px(getActivity(), 20.0f);
                linearLayout.setPadding(dip2px2, 0, dip2px2, 0);
                linearLayout.setOrientation(1);
                LayoutInflater layoutInflater = this.f31176a;
                if (layoutInflater == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("mLayoutInflator");
                    layoutInflater = null;
                }
                View inflate = layoutInflater.inflate(R.layout.pix_order_detail_section_title, (ViewGroup) null);
                if (inflate != null) {
                    TextView textView = (TextView) inflate;
                    textView.setPadding(0, dip2px, 0, dip2px);
                    textView.setText(detailItem.getTitle());
                    linearLayout.addView(textView);
                    View view2 = new View(getContext());
                    view2.setBackgroundColor(getResources().getColor(R.color.light_gray_ss));
                    linearLayout.addView(view2, new LinearLayout.LayoutParams(-1, 1));
                    for (PixQrCodeGenResp.KeyValuePair next : detailItem.getData()) {
                        LayoutInflater layoutInflater2 = this.f31176a;
                        if (layoutInflater2 == null) {
                            Intrinsics.throwUninitializedPropertyAccessException("mLayoutInflator");
                            layoutInflater2 = null;
                        }
                        View inflate2 = layoutInflater2.inflate(R.layout.pix_order_detail_item, (ViewGroup) null);
                        ((TextView) inflate2.findViewById(R.id.left_key_tv)).setText(next.getTitle());
                        ((TextView) inflate2.findViewById(R.id.right_value_tv)).setText(next.getValue());
                        linearLayout.addView(inflate2);
                    }
                    LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -2);
                    layoutParams.topMargin = UIUtil.dip2px(getContext(), 10.0f);
                    getContentParent().addView(linearLayout, layoutParams);
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

    public void initCommonTitlebar(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "commonTitleBar");
        commonTitleBar.setTitle(getString(R.string.GRider_payment_My_collection_mDdk));
        View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
        if (findViewById != null) {
            findViewById.setBackgroundColor(0);
        }
        commonTitleBar.getLeftImgView().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QrCodeDetailFragment.m21943a(QrCodeDetailFragment.this, view);
            }
        });
        super.initCommonTitlebar(commonTitleBar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21943a(QrCodeDetailFragment qrCodeDetailFragment, View view) {
        Intrinsics.checkNotNullParameter(qrCodeDetailFragment, "this$0");
        qrCodeDetailFragment.backToPrePage();
    }
}

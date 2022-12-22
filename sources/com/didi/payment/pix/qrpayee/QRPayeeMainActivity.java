package com.didi.payment.pix.qrpayee;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Base64;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.base.utils.MathUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.helper.NFloatInputHelper;
import com.didi.payment.commonsdk.push.PixTransferAction;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.commonsdk.utils.NPreviewCollectionUtils;
import com.didi.payment.commonsdk.view.RoundedImageView;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.pix.net.response.PixQrCodeGenResp;
import com.didi.payment.pix.qrpayee.adapter.PixTranferRealtimeAdapter;
import com.didi.payment.pix.qrpayee.fragment.QrCodeDetailFragment;
import com.didi.payment.pix.qrpayee.p139vm.QRPayeePageVm;
import com.didi.payment.pix.qrpayee.widget.ReceiveCode4ShareView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.didi.soda.customer.app.constant.Const;
import com.pay99.diff_base.model.ReceiveCodeMsg;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.StringCompanionObject;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\b\u0010N\u001a\u00020\u0005H\u0016J\n\u0010O\u001a\u0004\u0018\u00010\u0011H\u0014J\b\u0010P\u001a\u00020QH\u0016J\b\u0010R\u001a\u00020QH\u0016J\b\u0010S\u001a\u00020QH\u0002J\u0012\u0010T\u001a\u00020Q2\b\u0010U\u001a\u0004\u0018\u00010VH\u0014J\b\u0010W\u001a\u00020\u0005H\u0016J\u0012\u0010X\u001a\u00020Q2\b\u0010Y\u001a\u0004\u0018\u00010ZH\u0014J\u0010\u0010[\u001a\u00020Q2\u0006\u0010\\\u001a\u00020]H\u0007J\u0010\u0010[\u001a\u00020Q2\u0006\u0010^\u001a\u00020_H\u0007J\u0018\u0010`\u001a\u00020Q2\u0006\u0010a\u001a\u00020#2\u0006\u0010b\u001a\u00020cH\u0002J\b\u0010d\u001a\u00020eH\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X\u000e¢\u0006\u0002\n\u0000R\u0011\u0010\u0006\u001a\u00020\u0007¢\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u001a\u0010\n\u001a\u00020\u000bX.¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001a\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001c\u0010\"\u001a\u0004\u0018\u00010#X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b$\u0010%\"\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u001f\"\u0004\b*\u0010!R\u001a\u0010+\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b,\u0010\u001f\"\u0004\b-\u0010!R\u001a\u0010.\u001a\u00020/X.¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u000205X.¢\u0006\u000e\n\u0000\u001a\u0004\b6\u00107\"\u0004\b8\u00109R\u0010\u0010:\u001a\u0004\u0018\u00010;X\u000e¢\u0006\u0002\n\u0000R\u001a\u0010<\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b=\u0010\u001f\"\u0004\b>\u0010!R\u001a\u0010?\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010\u001f\"\u0004\bA\u0010!R\u001a\u0010B\u001a\u00020CX.¢\u0006\u000e\n\u0000\u001a\u0004\bD\u0010E\"\u0004\bF\u0010GR\u001a\u0010H\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\bI\u0010\u001f\"\u0004\bJ\u0010!R\u001a\u0010K\u001a\u00020\u001dX.¢\u0006\u000e\n\u0000\u001a\u0004\bL\u0010\u001f\"\u0004\bM\u0010!¨\u0006f"}, mo175978d2 = {"Lcom/didi/payment/pix/qrpayee/QRPayeeMainActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/qrpayee/vm/QRPayeePageVm;", "()V", "IMAGE_WIDTH", "", "NFloatParser", "Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "getNFloatParser", "()Lcom/didi/payment/commonsdk/ui/helper/NFloatInputHelper;", "adapter", "Lcom/didi/payment/pix/qrpayee/adapter/PixTranferRealtimeAdapter;", "getAdapter", "()Lcom/didi/payment/pix/qrpayee/adapter/PixTranferRealtimeAdapter;", "setAdapter", "(Lcom/didi/payment/pix/qrpayee/adapter/PixTranferRealtimeAdapter;)V", "contentContainer", "Landroid/view/View;", "getContentContainer", "()Landroid/view/View;", "setContentContainer", "(Landroid/view/View;)V", "contentLl", "Landroid/widget/LinearLayout;", "getContentLl", "()Landroid/widget/LinearLayout;", "setContentLl", "(Landroid/widget/LinearLayout;)V", "copyQrCodeBtnTv", "Landroid/widget/TextView;", "getCopyQrCodeBtnTv", "()Landroid/widget/TextView;", "setCopyQrCodeBtnTv", "(Landroid/widget/TextView;)V", "mQrPageData", "Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$QRCodePageData;", "getMQrPageData", "()Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$QRCodePageData;", "setMQrPageData", "(Lcom/didi/payment/pix/net/response/PixQrCodeGenResp$QRCodePageData;)V", "pixKeyTv", "getPixKeyTv", "setPixKeyTv", "pixTitleTv", "getPixTitleTv", "setPixTitleTv", "qrCodeImg", "Lcom/didi/payment/commonsdk/view/RoundedImageView;", "getQrCodeImg", "()Lcom/didi/payment/commonsdk/view/RoundedImageView;", "setQrCodeImg", "(Lcom/didi/payment/commonsdk/view/RoundedImageView;)V", "realtimeActionsLv", "Landroidx/recyclerview/widget/RecyclerView;", "getRealtimeActionsLv", "()Landroidx/recyclerview/widget/RecyclerView;", "setRealtimeActionsLv", "(Landroidx/recyclerview/widget/RecyclerView;)V", "receiveCodeView", "Lcom/didi/payment/pix/qrpayee/widget/ReceiveCode4ShareView;", "setAmountBtnTv", "getSetAmountBtnTv", "setSetAmountBtnTv", "shareBtnTv", "getShareBtnTv", "setShareBtnTv", "titlebarView", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "getTitlebarView", "()Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "setTitlebarView", "(Lcom/didi/sdk/view/titlebar/CommonTitleBar;)V", "userSetAmountTv", "getUserSetAmountTv", "setUserSetAmountTv", "viewDetailTv", "getViewDetailTv", "setViewDetailTv", "getFragmentContainer", "getTitleBarView", "initContentView", "", "initTitleBar", "initViewModel", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInflateContentLayout", "onNewIntent", "intent", "Landroid/content/Intent;", "onReceivePushMsg", "action", "Lcom/didi/payment/commonsdk/push/PixTransferAction;", "content", "Lcom/pay99/diff_base/model/ReceiveCodeMsg;", "prepareShareView", "qrCodeData", "bmp", "Landroid/graphics/Bitmap;", "registeBackstackEvent", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: QRPayeeMainActivity.kt */
public final class QRPayeeMainActivity extends WBaseActivity<QRPayeePageVm> {

    /* renamed from: a */
    private ReceiveCode4ShareView f31168a;
    public PixTranferRealtimeAdapter adapter;

    /* renamed from: b */
    private View f31169b;

    /* renamed from: c */
    private int f31170c = 400;
    public LinearLayout contentLl;
    public TextView copyQrCodeBtnTv;

    /* renamed from: d */
    private final NFloatInputHelper f31171d = new NFloatInputHelper();

    /* renamed from: e */
    private PixQrCodeGenResp.QRCodePageData f31172e;
    public TextView pixKeyTv;
    public TextView pixTitleTv;
    public RoundedImageView qrCodeImg;
    public RecyclerView realtimeActionsLv;
    public TextView setAmountBtnTv;
    public TextView shareBtnTv;
    public CommonTitleBar titlebarView;
    public TextView userSetAmountTv;
    public TextView viewDetailTv;

    public int getFragmentContainer() {
        return R.id.fragment_container;
    }

    public int onInflateContentLayout() {
        return R.layout.activity_qr_payee_main_lay;
    }

    public boolean registeBackstackEvent() {
        return true;
    }

    public final CommonTitleBar getTitlebarView() {
        CommonTitleBar commonTitleBar = this.titlebarView;
        if (commonTitleBar != null) {
            return commonTitleBar;
        }
        Intrinsics.throwUninitializedPropertyAccessException("titlebarView");
        return null;
    }

    public final void setTitlebarView(CommonTitleBar commonTitleBar) {
        Intrinsics.checkNotNullParameter(commonTitleBar, "<set-?>");
        this.titlebarView = commonTitleBar;
    }

    public final LinearLayout getContentLl() {
        LinearLayout linearLayout = this.contentLl;
        if (linearLayout != null) {
            return linearLayout;
        }
        Intrinsics.throwUninitializedPropertyAccessException("contentLl");
        return null;
    }

    public final void setContentLl(LinearLayout linearLayout) {
        Intrinsics.checkNotNullParameter(linearLayout, "<set-?>");
        this.contentLl = linearLayout;
    }

    public final TextView getPixTitleTv() {
        TextView textView = this.pixTitleTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pixTitleTv");
        return null;
    }

    public final void setPixTitleTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.pixTitleTv = textView;
    }

    public final TextView getPixKeyTv() {
        TextView textView = this.pixKeyTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("pixKeyTv");
        return null;
    }

    public final void setPixKeyTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.pixKeyTv = textView;
    }

    public final RoundedImageView getQrCodeImg() {
        RoundedImageView roundedImageView = this.qrCodeImg;
        if (roundedImageView != null) {
            return roundedImageView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("qrCodeImg");
        return null;
    }

    public final void setQrCodeImg(RoundedImageView roundedImageView) {
        Intrinsics.checkNotNullParameter(roundedImageView, "<set-?>");
        this.qrCodeImg = roundedImageView;
    }

    public final TextView getViewDetailTv() {
        TextView textView = this.viewDetailTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("viewDetailTv");
        return null;
    }

    public final void setViewDetailTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.viewDetailTv = textView;
    }

    public final TextView getSetAmountBtnTv() {
        TextView textView = this.setAmountBtnTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("setAmountBtnTv");
        return null;
    }

    public final void setSetAmountBtnTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.setAmountBtnTv = textView;
    }

    public final TextView getShareBtnTv() {
        TextView textView = this.shareBtnTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("shareBtnTv");
        return null;
    }

    public final void setShareBtnTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.shareBtnTv = textView;
    }

    public final TextView getCopyQrCodeBtnTv() {
        TextView textView = this.copyQrCodeBtnTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("copyQrCodeBtnTv");
        return null;
    }

    public final void setCopyQrCodeBtnTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.copyQrCodeBtnTv = textView;
    }

    public final TextView getUserSetAmountTv() {
        TextView textView = this.userSetAmountTv;
        if (textView != null) {
            return textView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("userSetAmountTv");
        return null;
    }

    public final void setUserSetAmountTv(TextView textView) {
        Intrinsics.checkNotNullParameter(textView, "<set-?>");
        this.userSetAmountTv = textView;
    }

    public final RecyclerView getRealtimeActionsLv() {
        RecyclerView recyclerView = this.realtimeActionsLv;
        if (recyclerView != null) {
            return recyclerView;
        }
        Intrinsics.throwUninitializedPropertyAccessException("realtimeActionsLv");
        return null;
    }

    public final void setRealtimeActionsLv(RecyclerView recyclerView) {
        Intrinsics.checkNotNullParameter(recyclerView, "<set-?>");
        this.realtimeActionsLv = recyclerView;
    }

    public final View getContentContainer() {
        return this.f31169b;
    }

    public final void setContentContainer(View view) {
        this.f31169b = view;
    }

    public final PixTranferRealtimeAdapter getAdapter() {
        PixTranferRealtimeAdapter pixTranferRealtimeAdapter = this.adapter;
        if (pixTranferRealtimeAdapter != null) {
            return pixTranferRealtimeAdapter;
        }
        Intrinsics.throwUninitializedPropertyAccessException("adapter");
        return null;
    }

    public final void setAdapter(PixTranferRealtimeAdapter pixTranferRealtimeAdapter) {
        Intrinsics.checkNotNullParameter(pixTranferRealtimeAdapter, "<set-?>");
        this.adapter = pixTranferRealtimeAdapter;
    }

    public final NFloatInputHelper getNFloatParser() {
        return this.f31171d;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m21931a();
    }

    public void initTitleBar() {
        View findViewById = findViewById(R.id.page_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.page_titlebar)");
        setTitlebarView((CommonTitleBar) findViewById);
        getTitlebarView().setTitle("");
        getTitlebarView().setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRPayeeMainActivity.m21934a(QRPayeeMainActivity.this, view);
            }
        });
        View findViewById2 = getTitlebarView().findViewById(R.id.title_bar_layout_above);
        if (findViewById2 != null) {
            findViewById2.setBackgroundColor(0);
        }
        decoretaTitlebar(getTitlebarView());
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21934a(QRPayeeMainActivity qRPayeeMainActivity, View view) {
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        qRPayeeMainActivity.finish();
    }

    public void initContentView() {
        initTitleBar();
        this.f31169b = findViewById(R.id.content_container_sv);
        View findViewById = findViewById(R.id.content_ll);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.content_ll)");
        setContentLl((LinearLayout) findViewById);
        View findViewById2 = findViewById(R.id.pix_tranfer_realtime_action_lv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_tranfer_realtime_action_lv)");
        setRealtimeActionsLv((RecyclerView) findViewById2);
        Context context = this;
        setAdapter(new PixTranferRealtimeAdapter(context));
        getRealtimeActionsLv().setLayoutManager(new LinearLayoutManager(context, 1, false));
        getRealtimeActionsLv().setAdapter(getAdapter());
        View findViewById3 = findViewById(R.id.qr_code_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.qr_code_title_tv)");
        setPixTitleTv((TextView) findViewById3);
        View findViewById4 = findViewById(R.id.your_pix_key_formator_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.your_pix_key_formator_tv)");
        setPixKeyTv((TextView) findViewById4);
        View findViewById5 = findViewById(R.id.receipt_code_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.receipt_code_img)");
        setQrCodeImg((RoundedImageView) findViewById5);
        getQrCodeImg().setRectRedius((float) UIUtil.dip2px(context, 10.0f));
        View findViewById6 = findViewById(R.id.user_set_amount_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.user_set_amount_tv)");
        setUserSetAmountTv((TextView) findViewById6);
        View findViewById7 = findViewById(R.id.view_detail_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.view_detail_tv)");
        setViewDetailTv((TextView) findViewById7);
        getViewDetailTv().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRPayeeMainActivity.m21937b(QRPayeeMainActivity.this, view);
            }
        });
        View findViewById8 = findViewById(R.id.setamount_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.setamount_btn_tv)");
        setSetAmountBtnTv((TextView) findViewById8);
        getSetAmountBtnTv().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRPayeeMainActivity.m21938c(QRPayeeMainActivity.this, view);
            }
        });
        View findViewById9 = findViewById(R.id.share_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.share_btn_tv)");
        setShareBtnTv((TextView) findViewById9);
        getShareBtnTv().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRPayeeMainActivity.m21939d(QRPayeeMainActivity.this, view);
            }
        });
        View findViewById10 = findViewById(R.id.copy_qr_code_btn_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.copy_qr_code_btn_tv)");
        setCopyQrCodeBtnTv((TextView) findViewById10);
        getCopyQrCodeBtnTv().setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                QRPayeeMainActivity.m21940e(QRPayeeMainActivity.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21937b(QRPayeeMainActivity qRPayeeMainActivity, View view) {
        ArrayList<PixQrCodeGenResp.DetailItem> detailItems;
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        PixQrCodeGenResp.QRCodePageData value = ((QRPayeePageVm) qRPayeeMainActivity.getVm()).getQrCodeData().getValue();
        if (value != null && (detailItems = value.getDetailItems()) != null) {
            QrCodeDetailFragment newInstance = QrCodeDetailFragment.class.newInstance();
            Bundle bundle = new Bundle();
            bundle.putParcelableArrayList("detail_data", detailItems);
            newInstance.setArguments(bundle);
            Intrinsics.checkNotNullExpressionValue(newInstance, "detailFragment");
            qRPayeeMainActivity.forwardFragment(newInstance, qRPayeeMainActivity.getFragmentContainer(), true, "code_detail_fragment_tag");
        }
    }

    /* access modifiers changed from: private */
    /* JADX WARNING: Code restructure failed: missing block: B:3:0x001b, code lost:
        r6 = r6.getQrDataInfo();
     */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public static final void m21938c(com.didi.payment.pix.qrpayee.QRPayeeMainActivity r5, android.view.View r6) {
        /*
            java.lang.String r6 = "this$0"
            kotlin.jvm.internal.Intrinsics.checkNotNullParameter(r5, r6)
            com.didi.payment.commonsdk.ui.WBaseViewModel r6 = r5.getVm()
            com.didi.payment.pix.qrpayee.vm.QRPayeePageVm r6 = (com.didi.payment.pix.qrpayee.p139vm.QRPayeePageVm) r6
            androidx.lifecycle.MutableLiveData r6 = r6.getQrCodeData()
            java.lang.Object r6 = r6.getValue()
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRCodePageData r6 = (com.didi.payment.pix.net.response.PixQrCodeGenResp.QRCodePageData) r6
            r0 = 0
            if (r6 != 0) goto L_0x001b
        L_0x0019:
            r6 = r0
            goto L_0x0026
        L_0x001b:
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRDataInfo r6 = r6.getQrDataInfo()
            if (r6 != 0) goto L_0x0022
            goto L_0x0019
        L_0x0022:
            java.lang.String r6 = r6.getAmount()
        L_0x0026:
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            boolean r6 = android.text.TextUtils.isEmpty(r6)
            r1 = 1
            java.lang.String r2 = "pix_payee_key"
            if (r6 == 0) goto L_0x008d
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRCodePageData r6 = r5.getMQrPageData()
            if (r6 != 0) goto L_0x0039
        L_0x0037:
            r6 = r0
            goto L_0x0044
        L_0x0039:
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRDataInfo r6 = r6.getQrDataInfo()
            if (r6 != 0) goto L_0x0040
            goto L_0x0037
        L_0x0040:
            java.lang.String r6 = r6.getKey()
        L_0x0044:
            java.lang.String r3 = "ibt_didipay_pix_receive_set_amount_ck"
            com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r3, r2, r6)
            java.lang.Class<com.didi.payment.pix.qrpayee.fragment.QrCodeSetAmountFragment> r6 = com.didi.payment.pix.qrpayee.fragment.QrCodeSetAmountFragment.class
            java.lang.Object r6 = r6.newInstance()
            com.didi.payment.pix.qrpayee.fragment.QrCodeSetAmountFragment r6 = (com.didi.payment.pix.qrpayee.fragment.QrCodeSetAmountFragment) r6
            android.os.Bundle r3 = new android.os.Bundle
            r3.<init>()
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRCodePageData r4 = r5.getMQrPageData()
            if (r4 != 0) goto L_0x005d
            goto L_0x0068
        L_0x005d:
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRDataInfo r4 = r4.getQrDataInfo()
            if (r4 != 0) goto L_0x0064
            goto L_0x0068
        L_0x0064:
            java.lang.String r0 = r4.getKey()
        L_0x0068:
            r3.putString(r2, r0)
            r6.setArguments(r3)
            java.lang.String r0 = "setAMountFragment"
            kotlin.jvm.internal.Intrinsics.checkNotNullExpressionValue(r6, r0)
            r0 = r6
            androidx.fragment.app.Fragment r0 = (androidx.fragment.app.Fragment) r0
            int r2 = r5.getFragmentContainer()
            java.lang.Class r6 = r6.getClass()
            java.lang.String r6 = r6.getCanonicalName()
            java.lang.String r3 = "_tag"
            java.lang.String r6 = kotlin.jvm.internal.Intrinsics.stringPlus(r6, r3)
            r5.forwardFragment(r0, r2, r1, r6)
            goto L_0x00b3
        L_0x008d:
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRCodePageData r6 = r5.getMQrPageData()
            if (r6 != 0) goto L_0x0094
            goto L_0x009f
        L_0x0094:
            com.didi.payment.pix.net.response.PixQrCodeGenResp$QRDataInfo r6 = r6.getQrDataInfo()
            if (r6 != 0) goto L_0x009b
            goto L_0x009f
        L_0x009b:
            java.lang.String r0 = r6.getKey()
        L_0x009f:
            java.lang.String r6 = "ibt_didipay_pix_receive_clear_amount_ck"
            com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r6, r2, r0)
            com.didi.payment.commonsdk.ui.WBaseViewModel r6 = r5.getVm()
            com.didi.payment.pix.qrpayee.vm.QRPayeePageVm r6 = (com.didi.payment.pix.qrpayee.p139vm.QRPayeePageVm) r6
            int r5 = r5.f31170c
            java.lang.String r0 = "0"
            java.lang.String r2 = ""
            r6.loadData(r0, r2, r1, r5)
        L_0x00b3:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.qrpayee.QRPayeeMainActivity.m21938c(com.didi.payment.pix.qrpayee.QRPayeeMainActivity, android.view.View):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m21939d(QRPayeeMainActivity qRPayeeMainActivity, View view) {
        PixQrCodeGenResp.QRDataInfo qrDataInfo;
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        PixQrCodeGenResp.QRCodePageData mQrPageData = qRPayeeMainActivity.getMQrPageData();
        String str = null;
        if (!(mQrPageData == null || (qrDataInfo = mQrPageData.getQrDataInfo()) == null)) {
            str = qrDataInfo.getKey();
        }
        FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_share_ck", "pix_payee_key", str);
        if (qRPayeeMainActivity.f31168a != null) {
            qRPayeeMainActivity.showLoading();
            Executors.newSingleThreadExecutor().submit(new Runnable() {
                public final void run() {
                    QRPayeeMainActivity.m21933a(QRPayeeMainActivity.this);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21933a(QRPayeeMainActivity qRPayeeMainActivity) {
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        ReceiveCode4ShareView receiveCode4ShareView = qRPayeeMainActivity.f31168a;
        new Handler(Looper.getMainLooper()).post(new Runnable(FileUtil.saveFile(qRPayeeMainActivity, receiveCode4ShareView == null ? null : receiveCode4ShareView.genBitmap(), Intrinsics.stringPlus(UUID.randomUUID().toString(), "_share_pic.png"), true), qRPayeeMainActivity) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ QRPayeeMainActivity f$1;

            {
                this.f$0 = r1;
                this.f$1 = r2;
            }

            public final void run() {
                QRPayeeMainActivity.m21936a(this.f$0, this.f$1);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21936a(String str, QRPayeeMainActivity qRPayeeMainActivity) {
        PixQrCodeGenResp.QRDataInfo qrDataInfo;
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        if (TextUtil.isEmpty(str)) {
            qRPayeeMainActivity.hideLoading();
        }
        PixQrCodeGenResp.QRCodePageData value = ((QRPayeePageVm) qRPayeeMainActivity.getVm()).getQrCodeData().getValue();
        if (!(value == null || (qrDataInfo = value.getQrDataInfo()) == null)) {
            StringCompanionObject stringCompanionObject = StringCompanionObject.INSTANCE;
            String string = qRPayeeMainActivity.getString(R.string.GRider_payment_Transfer_me_leTy);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRide…payment_Transfer_me_leTy)");
            String format = String.format(string, Arrays.copyOf(new Object[]{qrDataInfo.getQRCode()}, 1));
            Intrinsics.checkNotNullExpressionValue(format, "java.lang.String.format(format, *args)");
            NCommonShareManager.showCommonShareWindow(qRPayeeMainActivity, Intrinsics.stringPlus(format, "\n"), "https://rebrand.ly/99pay", str, new QRPayeeMainActivity$initContentView$3$task$1$1$1$1(qRPayeeMainActivity, str));
        }
        qRPayeeMainActivity.hideLoading();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public static final void m21940e(QRPayeeMainActivity qRPayeeMainActivity, View view) {
        PixQrCodeGenResp.QRDataInfo qrDataInfo;
        String qRCode;
        PixQrCodeGenResp.QRDataInfo qrDataInfo2;
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        PixQrCodeGenResp.QRCodePageData value = ((QRPayeePageVm) qRPayeeMainActivity.getVm()).getQrCodeData().getValue();
        if (value != null && (qrDataInfo = value.getQrDataInfo()) != null && (qRCode = qrDataInfo.getQRCode()) != null) {
            PixQrCodeGenResp.QRCodePageData mQrPageData = qRPayeeMainActivity.getMQrPageData();
            String str = null;
            if (!(mQrPageData == null || (qrDataInfo2 = mQrPageData.getQrDataInfo()) == null)) {
                str = qrDataInfo2.getKey();
            }
            FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_copy_qrcode_ck", "pix_payee_key", str);
            Context context = qRPayeeMainActivity;
            NClipBoardUtil.Companion.setClipboard(context, qRCode);
            WalletToastNew.showSuccessMsg(context, qRPayeeMainActivity.getString(R.string.GRider_payment_Successfully_copied_LsHi));
        }
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        Bundle extras;
        super.onNewIntent(intent);
        if (intent != null && (extras = intent.getExtras()) != null) {
            String str = (String) extras.get("amount");
            String str2 = (String) extras.get("note");
            if (str != null) {
                try {
                    int dollarToCent = MathUtil.dollarToCent(getNFloatParser().parseFloatValue(str));
                    getSetAmountBtnTv().setText(getString(R.string.GRider_payment_Purge_amount_sJty));
                    QRPayeePageVm qRPayeePageVm = (QRPayeePageVm) getVm();
                    String valueOf = String.valueOf(dollarToCent);
                    if (str2 == null) {
                        str2 = "";
                    }
                    qRPayeePageVm.loadData(valueOf, str2, true, this.f31170c);
                } catch (Exception unused) {
                }
            }
        }
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return getTitlebarView();
    }

    public final PixQrCodeGenResp.QRCodePageData getMQrPageData() {
        return this.f31172e;
    }

    public final void setMQrPageData(PixQrCodeGenResp.QRCodePageData qRCodePageData) {
        this.f31172e = qRCodePageData;
    }

    /* renamed from: a */
    private final void m21931a() {
        ViewModel viewModel = new ViewModelProvider(this).get(QRPayeePageVm.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…RPayeePageVm::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        ((QRPayeePageVm) getVm()).getQrCodeData().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                QRPayeeMainActivity.m21935a(QRPayeeMainActivity.this, (PixQrCodeGenResp.QRCodePageData) obj);
            }
        });
        ((QRPayeePageVm) getVm()).loadData("0", "", false, this.f31170c);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21935a(QRPayeeMainActivity qRPayeeMainActivity, PixQrCodeGenResp.QRCodePageData qRCodePageData) {
        CharSequence charSequence;
        Intrinsics.checkNotNullParameter(qRPayeeMainActivity, "this$0");
        qRPayeeMainActivity.setMQrPageData(qRCodePageData);
        PixQrCodeGenResp.QRDataInfo qrDataInfo = qRCodePageData.getQrDataInfo();
        FinOmegaSDK.trackEvent("ibt_didipay_pix_receive_sw", "pix_payee_key", qrDataInfo.getKey());
        View contentContainer = qRPayeeMainActivity.getContentContainer();
        if (contentContainer != null) {
            contentContainer.setVisibility(0);
        }
        if (!TextUtils.isEmpty(qrDataInfo.getTitle())) {
            qRPayeeMainActivity.getPixTitleTv().setText(qrDataInfo.getTitle());
        }
        if (!TextUtils.isEmpty(qrDataInfo.getSubTitle())) {
            qRPayeeMainActivity.getPixKeyTv().setVisibility(0);
            qRPayeeMainActivity.getPixKeyTv().setText(qrDataInfo.getSubTitle());
        }
        if (!TextUtils.isEmpty(qrDataInfo.getAmount())) {
            qRPayeeMainActivity.getUserSetAmountTv().setVisibility(0);
            qRPayeeMainActivity.getUserSetAmountTv().setText(qrDataInfo.getAmount());
        } else {
            qRPayeeMainActivity.getUserSetAmountTv().setVisibility(8);
        }
        try {
            Bitmap bytes2Bimap = NPreviewCollectionUtils.bytes2Bimap(Base64.decode(qrDataInfo.getQRImage(), 0));
            if (bytes2Bimap != null) {
                qRPayeeMainActivity.getQrCodeImg().setImageBitmap(bytes2Bimap);
            }
            Intrinsics.checkNotNullExpressionValue(qRCodePageData, Const.PageParams.PAGE_DATA);
            Intrinsics.checkNotNullExpressionValue(bytes2Bimap, "qrBmp");
            qRPayeeMainActivity.m21932a(qRCodePageData, bytes2Bimap);
        } catch (Exception unused) {
        }
        TextView setAmountBtnTv2 = qRPayeeMainActivity.getSetAmountBtnTv();
        if (TextUtils.isEmpty(qrDataInfo.getAmount())) {
            charSequence = qRPayeeMainActivity.getString(R.string.GRider_payment_Set_Up_BpQi);
        } else {
            charSequence = qRPayeeMainActivity.getString(R.string.GRider_payment_Purge_amount_sJty);
        }
        setAmountBtnTv2.setText(charSequence);
    }

    /* renamed from: a */
    private final void m21932a(PixQrCodeGenResp.QRCodePageData qRCodePageData, Bitmap bitmap) {
        ReceiveCode4ShareView receiveCode4ShareView;
        if (this.f31168a == null) {
            this.f31168a = new ReceiveCode4ShareView(this);
        }
        ReceiveCode4ShareView receiveCode4ShareView2 = this.f31168a;
        if (receiveCode4ShareView2 != null) {
            String string = getString(R.string.GRider_payment_My_collection_mDdk);
            Intrinsics.checkNotNullExpressionValue(string, "getString(R.string.GRide…yment_My_collection_mDdk)");
            String string2 = getString(R.string.GRider_payment_You_can_upze);
            Intrinsics.checkNotNullExpressionValue(string2, "getString(R.string.GRider_payment_You_can_upze)");
            receiveCode4ShareView2.setTitleDesc(string, string2);
        }
        ArrayList<PixQrCodeGenResp.DetailItem> detailItems = qRCodePageData.getDetailItems();
        if (detailItems.size() > 0 && (receiveCode4ShareView = this.f31168a) != null) {
            receiveCode4ShareView.appendItems(detailItems.get(detailItems.size() - 1).getData());
        }
        ReceiveCode4ShareView receiveCode4ShareView3 = this.f31168a;
        if (receiveCode4ShareView3 != null) {
            receiveCode4ShareView3.loadLocalBmpIntoImg(bitmap);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceivePushMsg(PixTransferAction pixTransferAction) {
        Intrinsics.checkNotNullParameter(pixTransferAction, "action");
        getRealtimeActionsLv().setVisibility(0);
        getAdapter().refreshOrAppendItem(pixTransferAction);
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceivePushMsg(ReceiveCodeMsg receiveCodeMsg) {
        Intrinsics.checkNotNullParameter(receiveCodeMsg, "content");
        PixTransferAction pixTransferAction = new PixTransferAction();
        pixTransferAction.payloadJson = receiveCodeMsg.getPushMsg();
        pixTransferAction.parseInner();
        getRealtimeActionsLv().setVisibility(0);
        getAdapter().refreshOrAppendItem(pixTransferAction);
    }
}

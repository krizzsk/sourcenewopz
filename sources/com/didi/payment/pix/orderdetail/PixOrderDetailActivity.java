package com.didi.payment.pix.orderdetail;

import android.content.Context;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.drouter.api.DRouter;
import com.didi.drouter.router.Request;
import com.didi.payment.base.finResource.CommonResourceState;
import com.didi.payment.base.finResource.FinResUtils;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.utils.FileUtil;
import com.didi.payment.base.utils.UIUtil;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.p129ui.helper.NViewHelper;
import com.didi.payment.commonsdk.utils.NCommonShareManager;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.net.response.PixOrderDetailResp;
import com.didi.payment.pix.orderdetail.p136vm.PixOrderDetailVM;
import com.didi.payment.pix.qrpayee.widget.OrderDetail4ShareView;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import java.util.concurrent.Executors;
import kotlin.Metadata;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001d\u001a\u0004\u0018\u00010\u0007H\u0014J\b\u0010\u001e\u001a\u00020\u001fH\u0016J\b\u0010 \u001a\u00020\u001fH\u0016J\b\u0010!\u001a\u00020\u001fH\u0002J\u0012\u0010\"\u001a\u00020\u001f2\b\u0010#\u001a\u0004\u0018\u00010$H\u0014J\b\u0010%\u001a\u00020\u001fH\u0014J\b\u0010&\u001a\u00020\u0018H\u0016J\b\u0010'\u001a\u00020\u001fH\u0002J\b\u0010(\u001a\u00020\u001fH\u0002J\u0010\u0010)\u001a\u00020\u001f2\u0006\u0010*\u001a\u00020\tH\u0002J\u0010\u0010+\u001a\u00020\u001f2\u0006\u0010,\u001a\u00020\tH\u0002J\u0010\u0010-\u001a\u00020\u001f2\u0006\u0010.\u001a\u00020\tH\u0002J\u0010\u0010/\u001a\u00020\u001f2\u0006\u00100\u001a\u00020\tH\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\b\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\tX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u0010\u0010\u0012\u001a\u0004\u0018\u00010\u0013X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u001a\u0010\u0016\u001a\u000e\u0012\u0004\u0012\u00020\u0018\u0012\u0004\u0012\u00020\u00180\u0017X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001a\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u001b\u001a\u00020\u001cX.¢\u0006\u0002\n\u0000¨\u00061"}, mo175978d2 = {"Lcom/didi/payment/pix/orderdetail/PixOrderDetailActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/pix/orderdetail/vm/PixOrderDetailVM;", "()V", "bottomFloatingBtn", "Landroid/widget/TextView;", "contentViewGroup", "Landroid/view/View;", "mOrderDetail", "Lcom/didi/payment/pix/net/response/PixOrderDetailResp$OrderDetail;", "mOrderIdPassIn", "", "mTitlebar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "mainTitleTv", "pixOrderDetailPassIn", "sectionContainer", "Landroid/widget/LinearLayout;", "shareView", "Lcom/didi/payment/pix/qrpayee/widget/OrderDetail4ShareView;", "statusImg", "Landroid/widget/ImageView;", "statusImgMap", "", "", "titleDescTv", "tvLimitInfo", "viewInflater", "Landroid/view/LayoutInflater;", "getTitleBarView", "initContentView", "", "initTitleBar", "initVMObserver", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onDestroy", "onInflateContentLayout", "parseIntent", "performShareAction", "prepareView4Share", "detail", "renderPageUI", "orderDetai", "resetPadding", "od", "showFinSysPopUpDlgIfNeed", "orderDetail", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixOrderDetailActivity.kt */
public final class PixOrderDetailActivity extends WBaseActivity<PixOrderDetailVM> {

    /* renamed from: a */
    private TextView f31091a;

    /* renamed from: b */
    private TextView f31092b;

    /* renamed from: c */
    private View f31093c;

    /* renamed from: d */
    private CommonTitleBar f31094d;

    /* renamed from: e */
    private PixOrderDetailResp.OrderDetail f31095e;

    /* renamed from: f */
    private LayoutInflater f31096f;

    /* renamed from: g */
    private TextView f31097g;

    /* renamed from: h */
    private TextView f31098h;

    /* renamed from: i */
    private ImageView f31099i;

    /* renamed from: j */
    private LinearLayout f31100j;

    /* renamed from: k */
    private OrderDetail4ShareView f31101k;

    /* renamed from: l */
    private String f31102l = "";

    /* renamed from: m */
    private PixOrderDetailResp.OrderDetail f31103m;

    /* renamed from: n */
    private Map<Integer, Integer> f31104n = MapsKt.mapOf(TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_SUCCESS()), Integer.valueOf(R.drawable.pix_transfer_icon_success)), TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_FAIL()), Integer.valueOf(R.drawable.pix_transfer_icon_failed)), TuplesKt.m42317to(Integer.valueOf(PixOrderDetailResp.Companion.getORDER_STATUS_PENDING()), Integer.valueOf(R.drawable.pix_transfer_icon_processing)));

    public int onInflateContentLayout() {
        return R.layout.pix_order_detail_activity;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        return this.f31094d;
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m21878c();
        m21874b();
    }

    public void initContentView() {
        View findViewById = findViewById(R.id.order_detail_scroll_layout);
        this.f31093c = findViewById;
        if (findViewById != null) {
            findViewById.setVisibility(8);
        }
        this.f31091a = (TextView) findViewById(R.id.btn_refund_retry);
        View findViewById2 = findViewById(R.id.tv_limit_info);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.tv_limit_info)");
        this.f31092b = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_order_status_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_order_status_tv)");
        this.f31097g = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.pix_order_amount_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_order_amount_tv)");
        this.f31098h = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.order_status_icon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.order_status_icon_img)");
        this.f31099i = (ImageView) findViewById5;
        View findViewById6 = findViewById(R.id.section_container_Ll);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.section_container_Ll)");
        this.f31100j = (LinearLayout) findViewById6;
        LayoutInflater from = LayoutInflater.from(this);
        Intrinsics.checkNotNullExpressionValue(from, "from(this)");
        this.f31096f = from;
    }

    public void initTitleBar() {
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById(R.id.pix_order_detail_titlebar);
        this.f31094d = commonTitleBar;
        if (commonTitleBar != null) {
            decoretaTitlebar(commonTitleBar);
            View findViewById = commonTitleBar.findViewById(R.id.title_bar_layout_above);
            if (findViewById != null) {
                findViewById.setBackgroundColor(0);
            }
        }
        CommonTitleBar commonTitleBar2 = this.f31094d;
        if (commonTitleBar2 != null) {
            ImageView imageView = (ImageView) commonTitleBar2.findViewById(R.id.img_web_title_more);
            if (imageView != null) {
                imageView.setImageResource(R.drawable.w_common_icon_share);
            }
            int dip2px = UIUtil.dip2px(this, -3.0f);
            NViewUtils nViewUtils = NViewUtils.INSTANCE;
            Intrinsics.checkNotNullExpressionValue(imageView, "more2ShareImg");
            nViewUtils.incrementWidthHeight(imageView, dip2px, dip2px);
            commonTitleBar2.getLeftImgView().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixOrderDetailActivity.m21869a(PixOrderDetailActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21869a(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        pixOrderDetailActivity.finish();
    }

    /* renamed from: a */
    private final void m21867a(PixOrderDetailResp.OrderDetail orderDetail) {
        if (this.f31101k == null) {
            this.f31101k = new OrderDetail4ShareView(this);
        }
        OrderDetail4ShareView orderDetail4ShareView = this.f31101k;
        if (orderDetail4ShareView != null) {
            orderDetail4ShareView.renderPageUI(orderDetail);
        }
    }

    /* renamed from: a */
    private final void m21866a() {
        OrderDetail4ShareView orderDetail4ShareView = this.f31101k;
        if (orderDetail4ShareView != null) {
            showLoading();
            Executors.newSingleThreadExecutor().submit(new Runnable(orderDetail4ShareView) {
                public final /* synthetic */ OrderDetail4ShareView f$1;

                {
                    this.f$1 = r2;
                }

                public final void run() {
                    PixOrderDetailActivity.m21872a(PixOrderDetailActivity.this, this.f$1);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21872a(PixOrderDetailActivity pixOrderDetailActivity, OrderDetail4ShareView orderDetail4ShareView) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        Context context = pixOrderDetailActivity;
        Bitmap genBitmap = NViewHelper.Companion.genBitmap(context, orderDetail4ShareView, true);
        new Handler(Looper.getMainLooper()).post(new Runnable(FileUtil.saveFile(context, genBitmap, Intrinsics.stringPlus(UUID.randomUUID().toString(), "_share_pic.png"), true), pixOrderDetailActivity, genBitmap) {
            public final /* synthetic */ String f$0;
            public final /* synthetic */ PixOrderDetailActivity f$1;
            public final /* synthetic */ Bitmap f$2;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
            }

            public final void run() {
                PixOrderDetailActivity.m21873a(this.f$0, this.f$1, this.f$2);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21873a(String str, PixOrderDetailActivity pixOrderDetailActivity, Bitmap bitmap) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (TextUtil.isEmpty(str)) {
            pixOrderDetailActivity.hideLoading();
        }
        NCommonShareManager.showCommonShareWindow(pixOrderDetailActivity, "", "https://rebrand.ly/99pay", str, new PixOrderDetailActivity$performShareAction$1$task$1$1$1(bitmap, pixOrderDetailActivity, str));
        pixOrderDetailActivity.hideLoading();
    }

    /* renamed from: b */
    private final void m21874b() {
        ViewModel viewModel = new ViewModelProvider(this).get(PixOrderDetailVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…rderDetailVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        LifecycleOwner lifecycleOwner = this;
        ((PixOrderDetailVM) getVm()).getErrObj().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderDetailActivity.m21870a(PixOrderDetailActivity.this, (WBaseResp) obj);
            }
        });
        ((PixOrderDetailVM) getVm()).getDetailSections().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixOrderDetailActivity.m21871a(PixOrderDetailActivity.this, (PixOrderDetailResp.OrderDetail) obj);
            }
        });
        ((PixOrderDetailVM) getVm()).loadDataByOid(this.f31102l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21870a(PixOrderDetailActivity pixOrderDetailActivity, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (pixOrderDetailActivity.f31095e == null) {
            if (wBaseResp.errno == -900) {
                pixOrderDetailActivity.displayError();
                return;
            }
            TextView textView = pixOrderDetailActivity.f31091a;
            if (!(textView != null && textView.getVisibility() == 0)) {
                TextView textView2 = pixOrderDetailActivity.f31091a;
                if (textView2 != null) {
                    textView2.setVisibility(0);
                }
                TextView textView3 = pixOrderDetailActivity.f31091a;
                if (textView3 != null) {
                    textView3.setOnClickListener(new View.OnClickListener() {
                        public final void onClick(View view) {
                            PixOrderDetailActivity.m21877b(PixOrderDetailActivity.this, view);
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21877b(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        ((PixOrderDetailVM) pixOrderDetailActivity.getVm()).loadDataByOid(pixOrderDetailActivity.f31102l);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21871a(PixOrderDetailActivity pixOrderDetailActivity, PixOrderDetailResp.OrderDetail orderDetail) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        if (orderDetail != null) {
            Map hashMap = new HashMap();
            hashMap.put("pix_order_status", orderDetail.getStatus() == 1 ? "success" : orderDetail.getStatus() == 2 ? "fail" : "pending");
            hashMap.put("order_id", !TextUtil.isEmpty(pixOrderDetailActivity.f31102l) ? pixOrderDetailActivity.f31102l : orderDetail.getOrderId());
            FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_status_sw", hashMap);
            pixOrderDetailActivity.f31095e = orderDetail;
            pixOrderDetailActivity.m21879c(orderDetail);
            pixOrderDetailActivity.m21867a(orderDetail);
            pixOrderDetailActivity.m21875b(orderDetail);
        }
    }

    /* renamed from: b */
    private final void m21875b(PixOrderDetailResp.OrderDetail orderDetail) {
        CommonResourceState commonResourceState = orderDetail.getCommonResourceState();
        if (commonResourceState != null) {
            FinResUtils.INSTANCE.showFinSysPopUpDlg(this, commonResourceState.getPopUpState());
        }
    }

    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r13v14, resolved type: android.view.LayoutInflater} */
    /* JADX DEBUG: Multi-variable search result rejected for TypeSearchVarInfo{r15v9, resolved type: android.view.LayoutInflater} */
    /* JADX WARNING: type inference failed for: r13v4, types: [android.view.LayoutInflater] */
    /* JADX WARNING: type inference failed for: r15v4, types: [android.view.LayoutInflater] */
    /* JADX WARNING: type inference failed for: r15v8 */
    /* JADX WARNING: type inference failed for: r13v13 */
    /* JADX WARNING: Multi-variable type inference failed */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private final void m21879c(com.didi.payment.pix.net.response.PixOrderDetailResp.OrderDetail r18) {
        /*
            r17 = this;
            r0 = r17
            r1 = r18
            android.view.View r2 = r0.f31093c
            r3 = 0
            if (r2 != 0) goto L_0x000a
            goto L_0x000d
        L_0x000a:
            r2.setVisibility(r3)
        L_0x000d:
            boolean r2 = r18.canShare()
            r4 = 1
            r5 = 0
            if (r2 == 0) goto L_0x0076
            com.didi.sdk.view.titlebar.CommonTitleBar r2 = r0.f31094d
            if (r2 != 0) goto L_0x001b
            r2 = r5
            goto L_0x0024
        L_0x001b:
            r6 = 2131431517(0x7f0b105d, float:1.8484765E38)
            android.view.View r2 = r2.findViewById(r6)
            android.widget.ImageView r2 = (android.widget.ImageView) r2
        L_0x0024:
            if (r2 != 0) goto L_0x0027
            goto L_0x0076
        L_0x0027:
            java.util.HashMap r6 = new java.util.HashMap
            r6.<init>()
            java.util.Map r6 = (java.util.Map) r6
            int r7 = r18.getStatus()
            if (r7 != r4) goto L_0x0037
            java.lang.String r7 = "success"
            goto L_0x0043
        L_0x0037:
            int r7 = r18.getStatus()
            r8 = 2
            if (r7 != r8) goto L_0x0041
            java.lang.String r7 = "fail"
            goto L_0x0043
        L_0x0041:
            java.lang.String r7 = "pending"
        L_0x0043:
            java.lang.String r8 = "pix_order_status"
            r6.put(r8, r7)
            java.lang.String r7 = r0.f31102l
            boolean r7 = com.didi.sdk.util.TextUtil.isEmpty(r7)
            if (r7 != 0) goto L_0x0053
            java.lang.String r7 = r0.f31102l
            goto L_0x0057
        L_0x0053:
            java.lang.String r7 = r18.getOrderId()
        L_0x0057:
            java.lang.String r8 = "order_id"
            r6.put(r8, r7)
            java.lang.String r7 = "ibt_didipay_pix_transfer_status_share_ck"
            com.didi.payment.base.tracker.FinOmegaSDK.trackEvent(r7, r6)
            r2.setVisibility(r3)
            r6 = 2131236031(0x7f0814bf, float:1.8088273E38)
            r2.setImageResource(r6)
            com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$zTtFeCeGKW1QEMM0oAHxXGc6pgc r6 = new com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$zTtFeCeGKW1QEMM0oAHxXGc6pgc
            r6.<init>()
            r2.setOnClickListener(r6)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0076:
            android.widget.TextView r2 = r0.f31097g
            if (r2 != 0) goto L_0x0080
            java.lang.String r2 = "mainTitleTv"
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r2 = r5
        L_0x0080:
            java.lang.String r6 = r18.getTitle()
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
            android.widget.TextView r2 = r0.f31098h
            java.lang.String r6 = "titleDescTv"
            if (r2 != 0) goto L_0x0093
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r2 = r5
        L_0x0093:
            java.lang.String r7 = r18.getAmount()
            r8 = r7
            java.lang.CharSequence r8 = (java.lang.CharSequence) r8
            r10 = 0
            r11 = 0
            r12 = 6
            r13 = 0
            java.lang.String r9 = "R$"
            int r7 = kotlin.text.StringsKt.indexOf$default((java.lang.CharSequence) r8, (java.lang.String) r9, (int) r10, (boolean) r11, (int) r12, (java.lang.Object) r13)
            java.lang.String r7 = r18.getAmount()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r2.setText(r7)
            android.widget.ImageView r2 = r0.f31099i
            java.lang.String r7 = "statusImg"
            if (r2 != 0) goto L_0x00b7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r2 = r5
        L_0x00b7:
            r8 = 2131235059(0x7f0810f3, float:1.8086301E38)
            r2.setImageResource(r8)
            int r2 = r18.getStatus()
            com.didi.payment.pix.net.response.PixOrderDetailResp$Companion r8 = com.didi.payment.pix.net.response.PixOrderDetailResp.Companion
            int r8 = r8.getORDER_STATUS_SUCCESS()
            if (r2 != r8) goto L_0x00d5
            android.content.res.Resources r2 = r17.getResources()
            r8 = 2131101201(0x7f060611, float:1.7814805E38)
            int r2 = r2.getColor(r8)
            goto L_0x00d7
        L_0x00d5:
            r2 = -16777216(0xffffffffff000000, float:-1.7014118E38)
        L_0x00d7:
            android.widget.TextView r8 = r0.f31098h
            if (r8 != 0) goto L_0x00df
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r6)
            r8 = r5
        L_0x00df:
            r8.setTextColor(r2)
            java.util.Map<java.lang.Integer, java.lang.Integer> r2 = r0.f31104n
            int r6 = r18.getStatus()
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r2 = r2.get(r6)
            java.lang.Integer r2 = (java.lang.Integer) r2
            if (r2 != 0) goto L_0x00f5
            goto L_0x010a
        L_0x00f5:
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            android.widget.ImageView r6 = r0.f31099i
            if (r6 != 0) goto L_0x0103
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r6 = r5
        L_0x0103:
            r6.setImageResource(r2)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x010a:
            java.util.List r2 = r18.getEntryList()
            android.widget.LinearLayout r6 = r0.f31100j
            java.lang.String r7 = "sectionContainer"
            if (r6 != 0) goto L_0x0118
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r6 = r5
        L_0x0118:
            r6.removeAllViews()
            int r2 = r2.size()
            r6 = -1
            int r2 = r2 + r6
            if (r2 < 0) goto L_0x0215
            r8 = 0
        L_0x0124:
            int r9 = r8 + 1
            java.util.List r10 = r18.getEntryList()
            java.lang.Object r10 = r10.get(r8)
            com.didi.payment.pix.net.response.PixOrderDetailResp$SectionEntry r10 = (com.didi.payment.pix.net.response.PixOrderDetailResp.SectionEntry) r10
            java.util.List r11 = r10.getItems()
            java.util.Collection r11 = (java.util.Collection) r11
            com.didi.sdk.util.collection.CollectionUtil.isEmpty((java.util.Collection<?>) r11)
            android.widget.LinearLayout r11 = new android.widget.LinearLayout
            r12 = r0
            android.content.Context r12 = (android.content.Context) r12
            r11.<init>(r12)
            r11.setOrientation(r4)
            r13 = 1101004800(0x41a00000, float:20.0)
            int r13 = com.didi.payment.base.utils.UIUtil.dip2px(r12, r13)
            r14 = 1086324736(0x40c00000, float:6.0)
            int r14 = com.didi.payment.base.utils.UIUtil.dip2px(r12, r14)
            if (r8 != 0) goto L_0x0156
            r11.setPadding(r13, r14, r13, r3)
            goto L_0x0159
        L_0x0156:
            r11.setPadding(r13, r3, r13, r3)
        L_0x0159:
            android.view.LayoutInflater r13 = r0.f31096f
            java.lang.String r14 = "viewInflater"
            if (r13 != 0) goto L_0x0163
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r13 = r5
        L_0x0163:
            r15 = 2131626124(0x7f0e088c, float:1.8879475E38)
            android.view.View r13 = r13.inflate(r15, r5)
            if (r13 == 0) goto L_0x020d
            android.widget.TextView r13 = (android.widget.TextView) r13
            java.lang.String r15 = r10.getTitle()
            java.lang.CharSequence r15 = (java.lang.CharSequence) r15
            r13.setText(r15)
            android.view.View r13 = (android.view.View) r13
            r11.addView(r13)
            java.util.List r10 = r10.getItems()
            java.util.Iterator r10 = r10.iterator()
        L_0x0184:
            boolean r13 = r10.hasNext()
            if (r13 == 0) goto L_0x01cb
            java.lang.Object r13 = r10.next()
            com.didi.payment.pix.net.response.PixOrderDetailResp$NameValuePair r13 = (com.didi.payment.pix.net.response.PixOrderDetailResp.NameValuePair) r13
            android.view.LayoutInflater r15 = r0.f31096f
            if (r15 != 0) goto L_0x0198
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r14)
            r15 = r5
        L_0x0198:
            r3 = 2131626123(0x7f0e088b, float:1.8879473E38)
            android.view.View r3 = r15.inflate(r3, r5)
            r15 = 2131432088(0x7f0b1298, float:1.8485924E38)
            android.view.View r15 = r3.findViewById(r15)
            android.widget.TextView r15 = (android.widget.TextView) r15
            java.lang.String r16 = r13.getKey()
            r5 = r16
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r15.setText(r5)
            r5 = 2131433754(0x7f0b191a, float:1.8489303E38)
            android.view.View r5 = r3.findViewById(r5)
            android.widget.TextView r5 = (android.widget.TextView) r5
            java.lang.String r13 = r13.getValue()
            java.lang.CharSequence r13 = (java.lang.CharSequence) r13
            r5.setText(r13)
            r11.addView(r3)
            r3 = 0
            r5 = 0
            goto L_0x0184
        L_0x01cb:
            android.widget.LinearLayout r3 = r0.f31100j
            if (r3 != 0) goto L_0x01d3
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r3 = 0
        L_0x01d3:
            android.view.View r11 = (android.view.View) r11
            r3.addView(r11)
            java.util.List r3 = r18.getEntryList()
            int r3 = r3.size()
            int r3 = r3 - r4
            if (r8 >= r3) goto L_0x0205
            android.widget.LinearLayout$LayoutParams r3 = new android.widget.LinearLayout$LayoutParams
            r5 = -2
            r3.<init>(r6, r5)
            r5 = 1084227584(0x40a00000, float:5.0)
            int r5 = com.didi.payment.base.utils.UIUtil.dip2px(r12, r5)
            r3.topMargin = r5
            r3.bottomMargin = r5
            android.widget.LinearLayout r3 = r0.f31100j
            if (r3 != 0) goto L_0x01fb
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r7)
            r3 = 0
        L_0x01fb:
            com.didi.payment.pix.orderdetail.widget.SectionSepretorLine r5 = new com.didi.payment.pix.orderdetail.widget.SectionSepretorLine
            r5.<init>(r12)
            android.view.View r5 = (android.view.View) r5
            r3.addView(r5)
        L_0x0205:
            if (r9 <= r2) goto L_0x0208
            goto L_0x0215
        L_0x0208:
            r8 = r9
            r3 = 0
            r5 = 0
            goto L_0x0124
        L_0x020d:
            java.lang.NullPointerException r1 = new java.lang.NullPointerException
            java.lang.String r2 = "null cannot be cast to non-null type android.widget.TextView"
            r1.<init>(r2)
            throw r1
        L_0x0215:
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            boolean r2 = r18.canRefund()
            r3 = 8
            if (r2 == 0) goto L_0x0252
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x0224
            goto L_0x0228
        L_0x0224:
            r5 = 0
            r2.setVisibility(r5)
        L_0x0228:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x022d
            goto L_0x0239
        L_0x022d:
            r5 = 2131952902(0x7f130506, float:1.954226E38)
            java.lang.String r5 = r0.getString(r5)
            java.lang.CharSequence r5 = (java.lang.CharSequence) r5
            r2.setText(r5)
        L_0x0239:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x023e
            goto L_0x0241
        L_0x023e:
            r2.setEnabled(r4)
        L_0x0241:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x0246
            goto L_0x0250
        L_0x0246:
            com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$phy229uLJUuOU_Pj9Zo0BQaLia0 r5 = new com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$phy229uLJUuOU_Pj9Zo0BQaLia0
            r5.<init>(r0)
            r2.setOnClickListener(r5)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
        L_0x0250:
            r5 = 0
            goto L_0x0296
        L_0x0252:
            boolean r2 = r18.canRetry()
            if (r2 == 0) goto L_0x028a
            android.widget.TextView r2 = r0.f31091a
            r5 = 0
            if (r2 != 0) goto L_0x025e
            goto L_0x0261
        L_0x025e:
            r2.setVisibility(r5)
        L_0x0261:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x0266
            goto L_0x0272
        L_0x0266:
            r6 = 2131952942(0x7f13052e, float:1.954234E38)
            java.lang.String r6 = r0.getString(r6)
            java.lang.CharSequence r6 = (java.lang.CharSequence) r6
            r2.setText(r6)
        L_0x0272:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x0277
            goto L_0x027a
        L_0x0277:
            r2.setEnabled(r4)
        L_0x027a:
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x027f
            goto L_0x0296
        L_0x027f:
            com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$sVpZwMB13hywS2utqgFKDEwyGf8 r6 = new com.didi.payment.pix.orderdetail.-$$Lambda$PixOrderDetailActivity$sVpZwMB13hywS2utqgFKDEwyGf8
            r6.<init>(r0)
            r2.setOnClickListener(r6)
            kotlin.Unit r2 = kotlin.Unit.INSTANCE
            goto L_0x0296
        L_0x028a:
            r5 = 0
            android.widget.TextView r2 = r0.f31091a
            if (r2 != 0) goto L_0x0290
            goto L_0x0293
        L_0x0290:
            r2.setVisibility(r3)
        L_0x0293:
            r17.m21881d(r18)
        L_0x0296:
            com.didi.payment.pix.net.response.PixOrderDetailResp$RuleLimitDetailVo r1 = r18.getRuleLimitDetail()
            java.lang.String r2 = "tvLimitInfo"
            if (r1 == 0) goto L_0x033d
            android.widget.TextView r6 = r0.f31092b
            if (r6 != 0) goto L_0x02a6
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = 0
        L_0x02a6:
            java.lang.String r7 = r1.getText()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            r6.setText(r7)
            android.widget.TextView r6 = r0.f31092b
            if (r6 != 0) goto L_0x02b7
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r6 = 0
        L_0x02b7:
            android.view.View r6 = (android.view.View) r6
            java.lang.String r7 = r1.getText()
            java.lang.CharSequence r7 = (java.lang.CharSequence) r7
            if (r7 == 0) goto L_0x02ca
            int r7 = r7.length()
            if (r7 != 0) goto L_0x02c8
            goto L_0x02ca
        L_0x02c8:
            r7 = 0
            goto L_0x02cb
        L_0x02ca:
            r7 = 1
        L_0x02cb:
            r7 = r7 ^ r4
            if (r7 == 0) goto L_0x02cf
            r3 = 0
        L_0x02cf:
            r6.setVisibility(r3)
            android.widget.TextView r3 = r0.f31092b
            if (r3 != 0) goto L_0x02da
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r3 = 0
        L_0x02da:
            android.view.View r3 = (android.view.View) r3
            int r3 = r3.getVisibility()
            if (r3 != 0) goto L_0x02e4
            r3 = 1
            goto L_0x02e5
        L_0x02e4:
            r3 = 0
        L_0x02e5:
            if (r3 == 0) goto L_0x0328
            java.util.HashMap r3 = new java.util.HashMap
            r3.<init>()
            java.util.Map r3 = (java.util.Map) r3
            java.lang.String r4 = "pub_page"
            java.lang.String r5 = "order_finish"
            r3.put(r4, r5)
            java.lang.String r4 = "pub_target"
            java.lang.String r5 = "text"
            r3.put(r4, r5)
            java.lang.String r4 = "pub_biz"
            java.lang.String r5 = "fintech"
            r3.put(r4, r5)
            r4 = 99996(0x1869c, float:1.40124E-40)
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "product_line"
            r3.put(r5, r4)
            java.lang.String r4 = "text_theme"
            java.lang.String r5 = "verify"
            r3.put(r4, r5)
            int r4 = com.didi.payment.wallet.global.utils.WalletSecuritySPUtils.getKycTag()
            java.lang.Integer r4 = java.lang.Integer.valueOf(r4)
            java.lang.String r5 = "kyc_tag"
            r3.put(r5, r4)
            java.lang.String r4 = "ibt_fintech_passenger_text_sw"
            com.didi.payment.base.tracker.PayTracker.trackEvent(r4, r3)
        L_0x0328:
            android.widget.TextView r3 = r0.f31092b
            if (r3 != 0) goto L_0x0331
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
            goto L_0x0332
        L_0x0331:
            r5 = r3
        L_0x0332:
            com.didi.payment.pix.orderdetail.PixOrderDetailActivity$renderPageUI$1$6 r2 = new com.didi.payment.pix.orderdetail.PixOrderDetailActivity$renderPageUI$1$6
            r2.<init>(r1, r0)
            android.view.View$OnClickListener r2 = (android.view.View.OnClickListener) r2
            r5.setOnClickListener(r2)
            goto L_0x034c
        L_0x033d:
            android.widget.TextView r1 = r0.f31092b
            if (r1 != 0) goto L_0x0346
            kotlin.jvm.internal.Intrinsics.throwUninitializedPropertyAccessException(r2)
            r5 = 0
            goto L_0x0347
        L_0x0346:
            r5 = r1
        L_0x0347:
            android.view.View r5 = (android.view.View) r5
            r5.setVisibility(r3)
        L_0x034c:
            kotlin.Unit r1 = kotlin.Unit.INSTANCE
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.payment.pix.orderdetail.PixOrderDetailActivity.m21879c(com.didi.payment.pix.net.response.PixOrderDetailResp$OrderDetail):void");
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21880c(PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        pixOrderDetailActivity.m21866a();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21868a(PixOrderDetailResp.OrderDetail orderDetail, PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(orderDetail, "$orderDetai");
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_success_refund_ck", "order_id", orderDetail.getOrderId());
        ((Request) DRouter.build(PixRouter.build("/pix_order_refund")).putExtra("order_id", pixOrderDetailActivity.f31102l)).start(pixOrderDetailActivity);
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21876b(PixOrderDetailResp.OrderDetail orderDetail, PixOrderDetailActivity pixOrderDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(orderDetail, "$it");
        Intrinsics.checkNotNullParameter(pixOrderDetailActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_pix_transfer_pending_retry_ck", "order_id", orderDetail.getOrderId());
        ((PixOrderDetailVM) pixOrderDetailActivity.getVm()).orderRetry(!TextUtil.isEmpty(pixOrderDetailActivity.f31102l) ? pixOrderDetailActivity.f31102l : orderDetail.getOrderId());
    }

    /* renamed from: d */
    private final void m21881d(PixOrderDetailResp.OrderDetail orderDetail) {
        View view;
        if (!orderDetail.canRefund() && !orderDetail.canRetry() && (view = this.f31093c) != null) {
            view.setPadding(view.getPaddingLeft(), view.getPaddingTop(), view.getPaddingRight(), 0);
        }
    }

    /* renamed from: c */
    private final void m21878c() {
        Intent intent = getIntent();
        if (intent != null) {
            String stringExtra = intent.getStringExtra("order_id");
            if (stringExtra == null) {
                stringExtra = "";
            }
            this.f31102l = stringExtra;
            Serializable serializableExtra = intent.getSerializableExtra("order_detail");
            if (serializableExtra != null) {
                PixOrderDetailResp.OrderDetail orderDetail = (PixOrderDetailResp.OrderDetail) serializableExtra;
                this.f31103m = orderDetail;
                if (orderDetail != null) {
                    this.f31102l = orderDetail.getOrderId();
                    m21879c(orderDetail);
                }
            }
        }
    }
}

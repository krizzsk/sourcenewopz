package com.didi.payment.kycservice.key.detail;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.commonsdk.net.WBaseResp;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.commonsdk.utils.NClipBoardUtil;
import com.didi.payment.commonsdk.utils.NViewUtils;
import com.didi.payment.commonsdk.widget.WalletToastNew;
import com.didi.payment.kycservice.key.detail.response.PixKeyDetailResp;
import com.didi.payment.wallet_ui.dialog.WalletDialog;
import com.didi.payment.wallet_ui.dialog.WalletDrawerContent;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\u0018\u0000 )2\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001)B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u001a\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u001b\u001a\u00020\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001cH\u0002J\u0012\u0010\u001e\u001a\u00020\u001c2\b\u0010\u001f\u001a\u0004\u0018\u00010 H\u0014J\u0010\u0010!\u001a\u00020\u001c2\u0006\u0010\"\u001a\u00020\u0002H\u0016J(\u0010#\u001a\u00020\u001c2\u0006\u0010$\u001a\u00020%2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010&\u001a\u00020'2\u0006\u0010(\u001a\u00020\nH\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX.¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000f\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u0010\u0010\u0011\u001a\u0004\u0018\u00010\u0012X\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0013\u001a\u0004\u0018\u00010\u0014X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0015\u001a\u00020\bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000eX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0019\u001a\u00020\u0012X.¢\u0006\u0002\n\u0000¨\u0006*"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/detail/PixKeyDetailActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/kycservice/key/detail/PixKeyDetailVM;", "()V", "btnSetDefault", "Landroid/widget/TextView;", "btnUnbind", "image", "Landroid/widget/ImageView;", "keyType", "", "keyVal", "", "llContentContainer", "Landroid/widget/LinearLayout;", "llDefaultKeyContainer", "llItems", "mCopyButton", "Landroid/view/View;", "mGuideDialogDrawer", "Lcom/didi/payment/wallet_ui/dialog/WalletDialog;", "toolbarBack", "toolbarContainer", "tvDefault", "tvKeyVal", "vLine", "getTitleBarView", "initListener", "", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "subscribeUi", "vm", "unbindKey", "dlgInfo", "Lcom/didi/payment/kycservice/key/detail/response/PixKeyDetailResp$UnbindingDlgInfo;", "default", "", "keyStatus", "Companion", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixKeyDetailActivity.kt */
public final class PixKeyDetailActivity extends WBaseActivity<PixKeyDetailVM> {
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final String PARAM_KEY_TYPE = "param_key_type";
    public static final String PARAM_KEY_VAL = "param_key_val";

    /* renamed from: a */
    private LinearLayout f30672a;

    /* renamed from: b */
    private ImageView f30673b;

    /* renamed from: c */
    private TextView f30674c;

    /* renamed from: d */
    private TextView f30675d;

    /* renamed from: e */
    private TextView f30676e;

    /* renamed from: f */
    private TextView f30677f;

    /* renamed from: g */
    private ImageView f30678g;

    /* renamed from: h */
    private LinearLayout f30679h;

    /* renamed from: i */
    private LinearLayout f30680i;

    /* renamed from: j */
    private LinearLayout f30681j;

    /* renamed from: k */
    private View f30682k;

    /* renamed from: l */
    private View f30683l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public WalletDialog f30684m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f30685n = -100;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public String f30686o;

    public static final /* synthetic */ PixKeyDetailVM access$getVm(PixKeyDetailActivity pixKeyDetailActivity) {
        return (PixKeyDetailVM) pixKeyDetailActivity.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/kycservice/key/detail/PixKeyDetailActivity$Companion;", "", "()V", "PARAM_KEY_TYPE", "", "PARAM_KEY_VAL", "kyc-service_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PixKeyDetailActivity.kt */
    public static final class Companion {
        public /* synthetic */ Companion(DefaultConstructorMarker defaultConstructorMarker) {
            this();
        }

        private Companion() {
        }
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_pix_key_detail_new);
        m21569b();
        m21563a();
        this.f30685n = getIntent().getIntExtra("param_key_type", 1);
        String stringExtra = getIntent().getStringExtra("param_key_val");
        if (stringExtra == null) {
            stringExtra = "";
        }
        this.f30686o = stringExtra;
        ViewModel viewModel = new ViewModelProvider(this).get(PixKeyDetailVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…xKeyDetailVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        PixKeyDetailVM pixKeyDetailVM = (PixKeyDetailVM) getVm();
        int i = this.f30685n;
        String str = this.f30686o;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyVal");
            str = null;
        }
        pixKeyDetailVM.reqPixKeyDetail(i, str);
        subscribeUi((PixKeyDetailVM) getVm());
    }

    /* renamed from: a */
    private final void m21563a() {
        ImageView imageView = this.f30673b;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarBack");
            imageView = null;
        }
        imageView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixKeyDetailActivity.m21564a(PixKeyDetailActivity.this, view);
            }
        });
        TextView textView2 = this.f30676e;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnSetDefault");
            textView2 = null;
        }
        textView2.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixKeyDetailActivity.m21570b(PixKeyDetailActivity.this, view);
            }
        });
        TextView textView3 = this.f30677f;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("btnUnbind");
        } else {
            textView = textView3;
        }
        textView.setOnClickListener(new PixKeyDetailActivity$initListener$3(this));
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixKeyDetailActivity.m21571c(PixKeyDetailActivity.this, view);
                }
            });
        }
        View view = this.f30683l;
        if (view != null) {
            view.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixKeyDetailActivity.m21572d(PixKeyDetailActivity.this, view);
                }
            });
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21564a(PixKeyDetailActivity pixKeyDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        pixKeyDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21570b(PixKeyDetailActivity pixKeyDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        PixKeyDetailVM pixKeyDetailVM = (PixKeyDetailVM) pixKeyDetailActivity.getVm();
        int i = pixKeyDetailActivity.f30685n;
        String str = pixKeyDetailActivity.f30686o;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyVal");
            str = null;
        }
        pixKeyDetailVM.reqPixKeyDefault(i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21571c(PixKeyDetailActivity pixKeyDetailActivity, View view) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        PixKeyDetailVM pixKeyDetailVM = (PixKeyDetailVM) pixKeyDetailActivity.getVm();
        int i = pixKeyDetailActivity.f30685n;
        String str = pixKeyDetailActivity.f30686o;
        if (str == null) {
            Intrinsics.throwUninitializedPropertyAccessException("keyVal");
            str = null;
        }
        pixKeyDetailVM.reqPixKeyDetail(i, str);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m21572d(PixKeyDetailActivity pixKeyDetailActivity, View view) {
        String obj;
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        TextView textView = pixKeyDetailActivity.f30674c;
        TextView textView2 = null;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvKeyVal");
            textView = null;
        }
        if (!TextUtils.isEmpty(textView.getText())) {
            TextView textView3 = pixKeyDetailActivity.f30674c;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvKeyVal");
            } else {
                textView2 = textView3;
            }
            CharSequence text = textView2.getText();
            if (!(text == null || (obj = text.toString()) == null)) {
                NClipBoardUtil.Companion companion = NClipBoardUtil.Companion;
                Context applicationContext = pixKeyDetailActivity.getApplicationContext();
                Intrinsics.checkNotNullExpressionValue(applicationContext, "applicationContext");
                companion.setClipboard(applicationContext, obj);
            }
            WalletToastNew.showSuccessMsg(pixKeyDetailActivity, pixKeyDetailActivity.getString(R.string.GRider_payment_Copy_successfully_Lycd));
            return;
        }
        WalletToastNew.showFailedMsg(pixKeyDetailActivity, pixKeyDetailActivity.getString(R.string.Others_platform_Copy_kszg));
    }

    /* renamed from: b */
    private final void m21569b() {
        View findViewById = findViewById(R.id.pix_key_detail_image);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.pix_key_detail_image)");
        this.f30678g = (ImageView) findViewById;
        View findViewById2 = findViewById(R.id.pix_toolbar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_toolbar)");
        this.f30672a = (LinearLayout) findViewById2;
        View findViewById3 = findViewById(R.id.pix_toolbar_left_back_iv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_toolbar_left_back_iv)");
        this.f30673b = (ImageView) findViewById3;
        View findViewById4 = findViewById(R.id.pix_key_detail_key_value_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_key_detail_key_value_tv)");
        this.f30674c = (TextView) findViewById4;
        View findViewById5 = findViewById(R.id.pix_key_detail_default_tip_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.pix_key_detail_default_tip_tv)");
        this.f30675d = (TextView) findViewById5;
        View findViewById6 = findViewById(R.id.pix_key_detail_set_default_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.pix_key_detail_set_default_btn)");
        this.f30676e = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.pix_key_detail_unbind_btn);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById(R.id.pix_key_detail_unbind_btn)");
        this.f30677f = (TextView) findViewById7;
        View findViewById8 = findViewById(R.id.pix_key_detail_ll_content_container);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.pix_ke…ail_ll_content_container)");
        this.f30679h = (LinearLayout) findViewById8;
        View findViewById9 = findViewById(R.id.pix_key_detail_ll_items);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.pix_key_detail_ll_items)");
        this.f30681j = (LinearLayout) findViewById9;
        View findViewById10 = findViewById(R.id.pix_key_detail_ll_items_below_line);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.pix_ke…tail_ll_items_below_line)");
        this.f30682k = findViewById10;
        View findViewById11 = findViewById(R.id.pix_key_detail_ll_default_area);
        Intrinsics.checkNotNullExpressionValue(findViewById11, "findViewById(R.id.pix_key_detail_ll_default_area)");
        this.f30680i = (LinearLayout) findViewById11;
        setErrViewContainer((ViewGroup) findViewById(R.id.pix_net_error_container));
        this.f30683l = findViewById(R.id.pix_key_detail_key_copy);
    }

    public void subscribeUi(PixKeyDetailVM pixKeyDetailVM) {
        Intrinsics.checkNotNullParameter(pixKeyDetailVM, "vm");
        super.subscribeUi(pixKeyDetailVM);
        LifecycleOwner lifecycleOwner = this;
        pixKeyDetailVM.getBizData().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyDetailActivity.m21567a(PixKeyDetailActivity.this, (PixKeyDetailResp.Data) obj);
            }
        });
        pixKeyDetailVM.getShowUnbindRetLD().observe(lifecycleOwner, new Observer(pixKeyDetailVM) {
            public final /* synthetic */ PixKeyDetailVM f$1;

            {
                this.f$1 = r2;
            }

            public final void onChanged(Object obj) {
                PixKeyDetailActivity.m21566a(PixKeyDetailActivity.this, this.f$1, (Boolean) obj);
            }
        });
        pixKeyDetailVM.getBizDefaultApiData().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixKeyDetailActivity.m21565a(PixKeyDetailActivity.this, (WBaseResp) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21567a(PixKeyDetailActivity pixKeyDetailActivity, PixKeyDetailResp.Data data) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        LinearLayout linearLayout = pixKeyDetailActivity.f30679h;
        ImageView imageView = null;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
            linearLayout = null;
        }
        linearLayout.setVisibility(0);
        NViewUtils nViewUtils = NViewUtils.INSTANCE;
        TextView textView = pixKeyDetailActivity.f30674c;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvKeyVal");
            textView = null;
        }
        nViewUtils.setText(textView, data.getKeyInfo());
        ArrayList<PixKeyDetailResp.Item> items = data.getItems();
        if (items != null) {
            LinearLayout linearLayout2 = pixKeyDetailActivity.f30681j;
            if (linearLayout2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llItems");
                linearLayout2 = null;
            }
            linearLayout2.removeAllViews();
            Iterator<PixKeyDetailResp.Item> it = items.iterator();
            while (it.hasNext()) {
                PixKeyDetailResp.Item next = it.next();
                LayoutInflater from = LayoutInflater.from(pixKeyDetailActivity);
                LinearLayout linearLayout3 = pixKeyDetailActivity.f30679h;
                if (linearLayout3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llContentContainer");
                    linearLayout3 = null;
                }
                View inflate = from.inflate(R.layout.pix_key_detail_item_new, linearLayout3, false);
                NViewUtils.INSTANCE.setText((TextView) inflate.findViewById(R.id.pix_key_detail_item_key), next.getItem());
                NViewUtils.INSTANCE.setText((TextView) inflate.findViewById(R.id.pix_key_detail_item_value), next.getValue());
                LinearLayout linearLayout4 = pixKeyDetailActivity.f30681j;
                if (linearLayout4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("llItems");
                    linearLayout4 = null;
                }
                linearLayout4.addView(inflate);
            }
        }
        View view = pixKeyDetailActivity.f30682k;
        if (view == null) {
            Intrinsics.throwUninitializedPropertyAccessException("vLine");
            view = null;
        }
        Collection items2 = data.getItems();
        view.setVisibility(items2 == null || items2.isEmpty() ? 8 : 0);
        if (data.getStatus() == 0) {
            LinearLayout linearLayout5 = pixKeyDetailActivity.f30680i;
            if (linearLayout5 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llDefaultKeyContainer");
                linearLayout5 = null;
            }
            linearLayout5.setVisibility(0);
            if (data.isDefault()) {
                TextView textView2 = pixKeyDetailActivity.f30675d;
                if (textView2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDefault");
                    textView2 = null;
                }
                textView2.setVisibility(0);
                TextView textView3 = pixKeyDetailActivity.f30676e;
                if (textView3 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSetDefault");
                    textView3 = null;
                }
                textView3.setVisibility(8);
            } else {
                TextView textView4 = pixKeyDetailActivity.f30675d;
                if (textView4 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("tvDefault");
                    textView4 = null;
                }
                textView4.setVisibility(8);
                TextView textView5 = pixKeyDetailActivity.f30676e;
                if (textView5 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("btnSetDefault");
                    textView5 = null;
                }
                textView5.setVisibility(0);
            }
            TextView textView6 = pixKeyDetailActivity.f30677f;
            if (textView6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnUnbind");
                textView6 = null;
            }
            textView6.setText(pixKeyDetailActivity.getString(R.string.GRider_Registration_Untied_Jjar));
        } else if (data.getStatus() == 1) {
            LinearLayout linearLayout6 = pixKeyDetailActivity.f30680i;
            if (linearLayout6 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("llDefaultKeyContainer");
                linearLayout6 = null;
            }
            linearLayout6.setVisibility(8);
            TextView textView7 = pixKeyDetailActivity.f30677f;
            if (textView7 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnUnbind");
                textView7 = null;
            }
            textView7.setText(pixKeyDetailActivity.getString(R.string.GRider_Registration_Delete_mApQ));
        }
        Context context = pixKeyDetailActivity;
        String imgUrl = data == null ? null : data.getImgUrl();
        ImageView imageView2 = pixKeyDetailActivity.f30678g;
        if (imageView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("image");
        } else {
            imageView = imageView2;
        }
        GlideUtils.with2load2into(context, imgUrl, imageView);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21566a(PixKeyDetailActivity pixKeyDetailActivity, PixKeyDetailVM pixKeyDetailVM, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        Intrinsics.checkNotNullParameter(pixKeyDetailVM, "$vm");
        WalletToastNew.showSuccessMsg(pixKeyDetailActivity, pixKeyDetailVM.getUnBindApiData().errmsg);
        pixKeyDetailActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21565a(PixKeyDetailActivity pixKeyDetailActivity, WBaseResp wBaseResp) {
        Intrinsics.checkNotNullParameter(pixKeyDetailActivity, "this$0");
        if (wBaseResp.errno == 0) {
            TextView textView = pixKeyDetailActivity.f30676e;
            TextView textView2 = null;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("btnSetDefault");
                textView = null;
            }
            textView.setVisibility(8);
            TextView textView3 = pixKeyDetailActivity.f30675d;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("tvDefault");
            } else {
                textView2 = textView3;
            }
            textView2.setVisibility(0);
            WalletToastNew.showSuccessMsg(pixKeyDetailActivity, wBaseResp.errmsg);
            return;
        }
        WalletToastNew.showFailedMsg(pixKeyDetailActivity, wBaseResp.errmsg);
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        LinearLayout linearLayout = this.f30672a;
        if (linearLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("toolbarContainer");
            linearLayout = null;
        }
        return linearLayout;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public final void m21568a(PixKeyDetailResp.UnbindingDlgInfo unbindingDlgInfo, String str, boolean z, int i) {
        WalletDrawerContent.Builder builder = new WalletDrawerContent.Builder();
        builder.setTitle(unbindingDlgInfo.getDeleteTitle());
        builder.setContent(unbindingDlgInfo.getDeleteSubTitle());
        builder.setFirstBtnText(unbindingDlgInfo.getDeleteButton());
        builder.setFirstClickListener(new PixKeyDetailActivity$unbindKey$1$1(this));
        builder.setSecondBtnText(unbindingDlgInfo.getCancelButton());
        builder.setSecondClickListener(new PixKeyDetailActivity$unbindKey$1$2(this));
        Unit unit = Unit.INSTANCE;
        WalletDialog configDrawer$default = WalletDialog.Companion.configDrawer$default(WalletDialog.Companion, this, builder, false, false, 12, (Object) null);
        this.f30684m = configDrawer$default;
        if (configDrawer$default != null) {
            SystemUtils.showDialog(configDrawer$default);
        }
    }
}

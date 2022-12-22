package com.didi.payment.pix.home;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelStoreOwner;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.drouter.api.DRouter;
import com.didi.payment.base.cons.WalletExtraConstant;
import com.didi.payment.base.tracker.FinOmegaSDK;
import com.didi.payment.base.tracker.PayTracker;
import com.didi.payment.base.utils.GlideUtils;
import com.didi.payment.base.web.WebBrowserUtil;
import com.didi.payment.commonsdk.activity.AutoDetectQRCodeActivity;
import com.didi.payment.commonsdk.constants.CommonConstants;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.kycservice.utils.ApolloSignUpUtil;
import com.didi.payment.kycservice.utils.KycRegisterUtils;
import com.didi.payment.pix.common.PageRefreshEvent;
import com.didi.payment.pix.constant.PixRouter;
import com.didi.payment.pix.home.PixChannelResp;
import com.didi.payment.pix.home.p135vm.ChannelEntryClickVM;
import com.didi.payment.pix.home.p135vm.PixChannelVM;
import com.didi.payment.pix.home.view.PixOperationBannerEntranceView;
import com.didi.payment.pix.utils.PixUT;
import com.didi.payment.transfer.utils.TransGlobalOmegaKey;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@Metadata(mo175977d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0003J\n\u0010\u0018\u001a\u0004\u0018\u00010\tH\u0014J\u0012\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cH\u0002J\b\u0010\u001d\u001a\u00020\u001aH\u0016J\b\u0010\u001e\u001a\u00020\u001aH\u0002J\u0010\u0010\u001f\u001a\u00020\u001a2\u0006\u0010 \u001a\u00020!H\u0002J\b\u0010\"\u001a\u00020\u001aH\u0016J\b\u0010#\u001a\u00020\u001aH\u0002J\u0012\u0010$\u001a\u00020\u001a2\b\u0010%\u001a\u0004\u0018\u00010&H\u0014J\b\u0010'\u001a\u00020(H\u0016J\b\u0010)\u001a\u00020\u001aH\u0014J\u0010\u0010*\u001a\u00020\u001a2\u0006\u0010+\u001a\u00020,H\u0007J\b\u0010-\u001a\u00020\u001aH\u0014J\b\u0010.\u001a\u00020/H\u0016R\u000e\u0010\u0004\u001a\u00020\u0005X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X.¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX.¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX.¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0013\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\u0017\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000¨\u00060"}, mo175978d2 = {"Lcom/didi/payment/pix/home/PixChannelHomeActivity;", "Lcom/didi/payment/commonsdk/activity/AutoDetectQRCodeActivity;", "Lcom/didi/payment/pix/home/vm/PixChannelVM;", "()V", "adapter", "Lcom/didi/payment/pix/home/PixChannelItemAdapter;", "channelContainer", "Landroidx/recyclerview/widget/RecyclerView;", "learnMoreAboutPix", "Landroid/view/View;", "learnMoreText", "Landroid/widget/TextView;", "mOperationView", "Lcom/didi/payment/pix/home/view/PixOperationBannerEntranceView;", "mTitlebar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "mgrKeyIcon", "Landroid/widget/ImageView;", "mgrKeyTitleDescTv", "mgrKeyTitleTv", "pageRootView", "Landroid/view/ViewGroup;", "pageTitleDescTv", "pageTitleTv", "getTitleBarView", "initChannelSection", "", "pixSelection", "Lcom/didi/payment/pix/home/PixChannelResp$PixSelection;", "initContentView", "initObserver", "initPixKeyMgrSection", "keyMgrSelection", "Lcom/didi/payment/pix/home/PixChannelResp$KeyMgrSelection;", "initTitleBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onInflateContentLayout", "", "onReceivePopbackEvent", "onReceiveRefreshCmd", "cmd", "Lcom/didi/payment/pix/common/PageRefreshEvent;", "onResume", "registeBackstackEvent", "", "wallet-service-pix_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PixChannelHomeActivity.kt */
public final class PixChannelHomeActivity extends AutoDetectQRCodeActivity<PixChannelVM> {

    /* renamed from: a */
    private ViewGroup f31059a;

    /* renamed from: b */
    private ImageView f31060b;

    /* renamed from: c */
    private CommonTitleBar f31061c;

    /* renamed from: d */
    private PixOperationBannerEntranceView f31062d;

    /* renamed from: e */
    private PixChannelItemAdapter f31063e;

    /* renamed from: f */
    private RecyclerView f31064f;

    /* renamed from: g */
    private TextView f31065g;

    /* renamed from: h */
    private TextView f31066h;

    /* renamed from: i */
    private TextView f31067i;

    /* renamed from: j */
    private TextView f31068j;

    /* renamed from: k */
    private View f31069k;

    /* renamed from: l */
    private TextView f31070l;

    public int onInflateContentLayout() {
        return R.layout.activity_pix_home;
    }

    public boolean registeBackstackEvent() {
        return true;
    }

    public static final /* synthetic */ PixChannelVM access$getVm(PixChannelHomeActivity pixChannelHomeActivity) {
        return (PixChannelVM) pixChannelHomeActivity.getVm();
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        m21852b();
        String stringExtra = getIntent().getStringExtra(WalletExtraConstant.Key.PAGE_REFER);
        if (Intrinsics.areEqual((Object) "wallet_home", (Object) stringExtra)) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "mypix_home_page");
        } else if (Intrinsics.areEqual((Object) "wallet_mainlist", (Object) stringExtra)) {
            PayTracker.putGlobal(TransGlobalOmegaKey.KEY_WALLET_PAGEID, "mypix_siderbar_page");
        }
        FinOmegaSDK.trackEvent("ibt_didipay_mypix_sw");
    }

    public void initContentView() {
        m21844a();
    }

    /* access modifiers changed from: protected */
    public void onReceivePopbackEvent() {
        finish();
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        ((PixChannelVM) getVm()).loadData();
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        CommonTitleBar commonTitleBar = this.f31061c;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
            commonTitleBar = null;
        }
        return commonTitleBar;
    }

    public void initTitleBar() {
        super.initTitleBar();
        View findViewById = findViewById(R.id.page_titlebar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.page_titlebar)");
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById;
        this.f31061c = commonTitleBar;
        CommonTitleBar commonTitleBar2 = null;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
            commonTitleBar = null;
        }
        commonTitleBar.setLeftVisible(0);
        CommonTitleBar commonTitleBar3 = this.f31061c;
        if (commonTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
            commonTitleBar3 = null;
        }
        commonTitleBar3.setLeftBackListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixChannelHomeActivity.m21845a(PixChannelHomeActivity.this, view);
            }
        });
        CommonTitleBar commonTitleBar4 = this.f31061c;
        if (commonTitleBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
            commonTitleBar4 = null;
        }
        commonTitleBar4.setRightText(getString(R.string.CS_payment_History_Details_vCjc), (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PixChannelHomeActivity.m21853b(PixChannelHomeActivity.this, view);
            }
        });
        CommonTitleBar commonTitleBar5 = this.f31061c;
        if (commonTitleBar5 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
            commonTitleBar5 = null;
        }
        commonTitleBar5.setRightTextColor(-16777216);
        CommonTitleBar commonTitleBar6 = this.f31061c;
        if (commonTitleBar6 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mTitlebar");
        } else {
            commonTitleBar2 = commonTitleBar6;
        }
        decoretaTitlebar(commonTitleBar2);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21845a(PixChannelHomeActivity pixChannelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_mypix_back_ck");
        pixChannelHomeActivity.finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static final void m21853b(PixChannelHomeActivity pixChannelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_mypix_detail_ck");
        DRouter.build(PixRouter.build("/pix_history")).start(pixChannelHomeActivity);
    }

    /* renamed from: a */
    private final void m21844a() {
        View findViewById = findViewById(R.id.page_root_container);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.page_root_container)");
        ViewGroup viewGroup = (ViewGroup) findViewById;
        this.f31059a = viewGroup;
        PixOperationBannerEntranceView pixOperationBannerEntranceView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
            viewGroup = null;
        }
        int childCount = viewGroup.getChildCount();
        int i = 2;
        if (2 < childCount) {
            while (true) {
                int i2 = i + 1;
                ViewGroup viewGroup2 = this.f31059a;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
                    viewGroup2 = null;
                }
                viewGroup2.getChildAt(i).setVisibility(8);
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
            }
        }
        setErrViewContainer((ViewGroup) findViewById(R.id.w_common_sdk_net_error_view_container));
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null) {
            errViewContainer.setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PixChannelHomeActivity.m21854c(PixChannelHomeActivity.this, view);
                }
            });
        }
        View findViewById2 = findViewById(R.id.pix_channel_main_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.pix_channel_main_title_tv)");
        this.f31065g = (TextView) findViewById2;
        View findViewById3 = findViewById(R.id.pix_channel_main_title_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.pix_channel_main_title_desc_tv)");
        this.f31066h = (TextView) findViewById3;
        View findViewById4 = findViewById(R.id.pix_channel_pix_main_entry);
        Intrinsics.checkNotNullExpressionValue(findViewById4, "findViewById(R.id.pix_channel_pix_main_entry)");
        RecyclerView recyclerView = (RecyclerView) findViewById4;
        this.f31064f = recyclerView;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContainer");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new GridLayoutManager(this, 3));
        this.f31063e = new PixChannelItemAdapter(this);
        RecyclerView recyclerView2 = this.f31064f;
        if (recyclerView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("channelContainer");
            recyclerView2 = null;
        }
        PixChannelItemAdapter pixChannelItemAdapter = this.f31063e;
        if (pixChannelItemAdapter == null) {
            Intrinsics.throwUninitializedPropertyAccessException("adapter");
            pixChannelItemAdapter = null;
        }
        recyclerView2.setAdapter(pixChannelItemAdapter);
        View findViewById5 = findViewById(R.id.pix_home_learn_more_entrance);
        Intrinsics.checkNotNullExpressionValue(findViewById5, "findViewById(R.id.pix_home_learn_more_entrance)");
        this.f31069k = findViewById5;
        View findViewById6 = findViewById(R.id.pix_channel_know_more_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById6, "findViewById(R.id.pix_channel_know_more_tv)");
        this.f31070l = (TextView) findViewById6;
        View findViewById7 = findViewById(R.id.mgr_key_lefticon_img);
        Intrinsics.checkNotNullExpressionValue(findViewById7, "findViewById<ImageView>(R.id.mgr_key_lefticon_img)");
        this.f31060b = (ImageView) findViewById7;
        View findViewById8 = findViewById(R.id.pix_channel_mgr_title_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById8, "findViewById(R.id.pix_channel_mgr_title_tv)");
        this.f31067i = (TextView) findViewById8;
        View findViewById9 = findViewById(R.id.pix_channel_mgr_title_desc_tv);
        Intrinsics.checkNotNullExpressionValue(findViewById9, "findViewById(R.id.pix_channel_mgr_title_desc_tv)");
        this.f31068j = (TextView) findViewById9;
        View findViewById10 = findViewById(R.id.pix_home_operation_section);
        Intrinsics.checkNotNullExpressionValue(findViewById10, "findViewById(R.id.pix_home_operation_section)");
        PixOperationBannerEntranceView pixOperationBannerEntranceView2 = (PixOperationBannerEntranceView) findViewById10;
        this.f31062d = pixOperationBannerEntranceView2;
        if (pixOperationBannerEntranceView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mOperationView");
        } else {
            pixOperationBannerEntranceView = pixOperationBannerEntranceView2;
        }
        pixOperationBannerEntranceView.setListener(new PixChannelHomeActivity$initView$2(this));
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public static final void m21854c(PixChannelHomeActivity pixChannelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        ((PixChannelVM) pixChannelHomeActivity.getVm()).loadData();
    }

    /* renamed from: b */
    private final void m21852b() {
        ViewModelStoreOwner viewModelStoreOwner = this;
        ViewModel viewModel = new ViewModelProvider(viewModelStoreOwner).get(PixChannelVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…PixChannelVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        subscribeUi(getVm());
        LifecycleOwner lifecycleOwner = this;
        ((PixChannelVM) getVm()).getPageRespLd().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixChannelHomeActivity.m21847a(PixChannelHomeActivity.this, (PixChannelResp.Data) obj);
            }
        });
        ((PixChannelVM) getVm()).isNetError().observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixChannelHomeActivity.m21848a(PixChannelHomeActivity.this, (Boolean) obj);
            }
        });
        ViewModel viewModel2 = new ViewModelProvider(viewModelStoreOwner).get(ChannelEntryClickVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel2, "ViewModelProvider(this).…EntryClickVM::class.java)");
        ((ChannelEntryClickVM) viewModel2).pixChannel.observe(lifecycleOwner, new Observer() {
            public final void onChanged(Object obj) {
                PixChannelHomeActivity.m21846a(PixChannelHomeActivity.this, (PixChannelResp.ChannelEntry) obj);
            }
        });
        initQRDetectVm();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21847a(PixChannelHomeActivity pixChannelHomeActivity, PixChannelResp.Data data) {
        PixChannelResp.PixSelection pixSelection;
        PixChannelResp.PanelSection panelSection;
        PixChannelResp.KeyMgrSelection keyMgrSelection;
        PixChannelResp.LearnMoreSection helpSection;
        PixChannelResp.PixSelection pixSelection2;
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        ViewGroup viewGroup = pixChannelHomeActivity.f31059a;
        PixOperationBannerEntranceView pixOperationBannerEntranceView = null;
        if (viewGroup == null) {
            Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
            viewGroup = null;
        }
        int childCount = viewGroup.getChildCount();
        int i = 2;
        if (2 < childCount) {
            while (true) {
                int i2 = i + 1;
                ViewGroup viewGroup2 = pixChannelHomeActivity.f31059a;
                if (viewGroup2 == null) {
                    Intrinsics.throwUninitializedPropertyAccessException("pageRootView");
                    viewGroup2 = null;
                }
                viewGroup2.getChildAt(i).setVisibility(0);
                if (i2 >= childCount) {
                    break;
                }
                i = i2;
            }
        }
        if (!(data == null || (pixSelection2 = data.getPixSelection()) == null)) {
            TextView textView = pixChannelHomeActivity.f31065g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitleTv");
                textView = null;
            }
            textView.setText(pixSelection2.getTitle());
            TextView textView2 = pixChannelHomeActivity.f31066h;
            if (textView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitleDescTv");
                textView2 = null;
            }
            textView2.setText(pixSelection2.getDescription());
        }
        if (data == null) {
            pixSelection = null;
        } else {
            pixSelection = data.getPixSelection();
        }
        pixChannelHomeActivity.m21851a(pixSelection);
        if (!(data == null || (helpSection = data.getHelpSection()) == null)) {
            TextView textView3 = pixChannelHomeActivity.f31070l;
            if (textView3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("learnMoreText");
                textView3 = null;
            }
            String name = helpSection.getName();
            if (name == null) {
                name = "";
            }
            textView3.setText(name);
            View view = pixChannelHomeActivity.f31069k;
            if (view == null) {
                Intrinsics.throwUninitializedPropertyAccessException("learnMoreAboutPix");
                view = null;
            }
            view.setOnClickListener(new View.OnClickListener(pixChannelHomeActivity) {
                public final /* synthetic */ PixChannelHomeActivity f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PixChannelHomeActivity.m21850a(PixChannelResp.LearnMoreSection.this, this.f$1, view);
                }
            });
        }
        if (!(data == null || (keyMgrSelection = data.getKeyMgrSelection()) == null)) {
            pixChannelHomeActivity.m21849a(keyMgrSelection);
        }
        if (data != null && (panelSection = data.getPanelSection()) != null) {
            PixOperationBannerEntranceView pixOperationBannerEntranceView2 = pixChannelHomeActivity.f31062d;
            if (pixOperationBannerEntranceView2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("mOperationView");
            } else {
                pixOperationBannerEntranceView = pixOperationBannerEntranceView2;
            }
            pixOperationBannerEntranceView.updateContent(panelSection);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21850a(PixChannelResp.LearnMoreSection learnMoreSection, PixChannelHomeActivity pixChannelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(learnMoreSection, "$helpSelection");
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        FinOmegaSDK.trackEvent("ibt_didipay_mypix_faq_ck");
        String linkUrl = learnMoreSection.getLinkUrl();
        if (linkUrl != null) {
            if (StringsKt.startsWith$default(linkUrl, "http", false, 2, (Object) null)) {
                WebBrowserUtil.startInternalWebActivity(pixChannelHomeActivity, learnMoreSection.getLinkUrl(), "");
            } else {
                DRouter.build(learnMoreSection.getLinkUrl()).start(pixChannelHomeActivity);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21848a(PixChannelHomeActivity pixChannelHomeActivity, Boolean bool) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        pixChannelHomeActivity.findViewById(R.id.w_common_sdk_net_error_view_container).setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m21846a(PixChannelHomeActivity pixChannelHomeActivity, PixChannelResp.ChannelEntry channelEntry) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        String str = CommonConstants.Router.PIX_REGISTER_PATH;
        Intrinsics.checkNotNullExpressionValue(str, "PIX_REGISTER_PATH");
        if (!StringsKt.contains$default((CharSequence) channelEntry.getLinkUrl(), (CharSequence) str, false, 2, (Object) null)) {
            DRouter.build(channelEntry.getLinkUrl()).start(pixChannelHomeActivity);
        } else if (ApolloSignUpUtil.Companion.getApolloExp()) {
            KycRegisterUtils.INSTANCE.go2SignUpActivity(pixChannelHomeActivity, "3", false, new PixChannelHomeActivity$initObserver$3$1(pixChannelHomeActivity));
        } else {
            DRouter.build(channelEntry.getLinkUrl()).start(pixChannelHomeActivity, new PixChannelHomeActivity$initObserver$3$2(pixChannelHomeActivity));
        }
    }

    /* renamed from: a */
    private final void m21851a(PixChannelResp.PixSelection pixSelection) {
        List<PixChannelResp.ChannelEntry> entryList;
        String title;
        PixChannelItemAdapter pixChannelItemAdapter = null;
        if (!(pixSelection == null || (title = pixSelection.getTitle()) == null)) {
            TextView textView = this.f31065g;
            if (textView == null) {
                Intrinsics.throwUninitializedPropertyAccessException("pageTitleTv");
                textView = null;
            }
            textView.setText(title);
        }
        if (!(pixSelection == null || (entryList = pixSelection.getEntryList()) == null)) {
            PixChannelItemAdapter pixChannelItemAdapter2 = this.f31063e;
            if (pixChannelItemAdapter2 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
                pixChannelItemAdapter2 = null;
            }
            pixChannelItemAdapter2.f31071a = entryList;
            PixChannelItemAdapter pixChannelItemAdapter3 = this.f31063e;
            if (pixChannelItemAdapter3 == null) {
                Intrinsics.throwUninitializedPropertyAccessException("adapter");
            } else {
                pixChannelItemAdapter = pixChannelItemAdapter3;
            }
            pixChannelItemAdapter.notifyDataSetChanged();
        }
        ViewGroup errViewContainer = getErrViewContainer();
        if (errViewContainer != null && errViewContainer.getVisibility() == 0) {
            errViewContainer.setVisibility(8);
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public final void onReceiveRefreshCmd(PageRefreshEvent pageRefreshEvent) {
        Intrinsics.checkNotNullParameter(pageRefreshEvent, "cmd");
        ((PixChannelVM) getVm()).refreshData(false);
    }

    /* renamed from: a */
    private final void m21849a(PixChannelResp.KeyMgrSelection keyMgrSelection) {
        Context context = this;
        String icon = keyMgrSelection.getIcon();
        ImageView imageView = this.f31060b;
        TextView textView = null;
        if (imageView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mgrKeyIcon");
            imageView = null;
        }
        GlideUtils.with2load2into(context, icon, imageView);
        TextView textView2 = this.f31067i;
        if (textView2 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mgrKeyTitleTv");
            textView2 = null;
        }
        textView2.setText(keyMgrSelection.getTitle());
        TextView textView3 = this.f31068j;
        if (textView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mgrKeyTitleDescTv");
            textView3 = null;
        }
        textView3.setText(keyMgrSelection.getName());
        TextView textView4 = this.f31068j;
        if (textView4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("mgrKeyTitleDescTv");
        } else {
            textView = textView4;
        }
        textView.setOnClickListener(new View.OnClickListener() {
            public final void onClick(View view) {
                PixChannelHomeActivity.m21855d(PixChannelHomeActivity.this, view);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public static final void m21855d(PixChannelHomeActivity pixChannelHomeActivity, View view) {
        Intrinsics.checkNotNullParameter(pixChannelHomeActivity, "this$0");
        DRouter.build(PixRouter.build("/pix_key_manager")).start(pixChannelHomeActivity);
        PixUT.INSTANCE.trackKeyManageCk();
    }
}

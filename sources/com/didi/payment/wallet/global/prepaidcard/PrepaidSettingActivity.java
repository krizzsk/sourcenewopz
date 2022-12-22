package com.didi.payment.wallet.global.prepaidcard;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.FragmentActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.payment.base.dialog.GlobalAlertDialog;
import com.didi.payment.wallet.global.prepaidcard.PrepaidSettingActivity;
import com.didi.payment.wallet.global.wallet.view.activity.WalletBaseActivity;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.payment.wallet.global.wallet.view.widget.WalletCommonBottomDialog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

@Metadata(mo175977d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0010\u000e\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001:\u0005789:;B\u0005¢\u0006\u0002\u0010\u0002J\b\u0010&\u001a\u00020'H\u0002J\b\u0010(\u001a\u00020'H\u0014J\b\u0010)\u001a\u00020'H\u0002J\u0012\u0010*\u001a\u00020'2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\b\u0010-\u001a\u00020'H\u0014JG\u0010.\u001a\u00020'2\b\u0010/\u001a\u0004\u0018\u00010\u001e2\u000e\b\u0002\u00100\u001a\b\u0012\u0004\u0012\u00020'012%\u00102\u001a!\u0012\u0015\u0012\u0013\u0018\u00010\u000b¢\u0006\f\b4\u0012\b\b5\u0012\u0004\b\b(6\u0012\u0004\u0012\u00020'\u0018\u000103R\u001e\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u000bX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\r\"\u0004\b\u0012\u0010\u000fR\u001a\u0010\u0013\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u0016\"\u0004\b\u0017\u0010\u0018R\u001e\u0010\u0019\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u0010\n\u0002\u0010\t\u001a\u0004\b\u001a\u0010\u0006\"\u0004\b\u001b\u0010\bR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u001e0\u001dX\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u00020\u0014X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b \u0010\u0016\"\u0004\b!\u0010\u0018R\u000e\u0010\"\u001a\u00020#X.¢\u0006\u0002\n\u0000R\u000e\u0010$\u001a\u00020%X.¢\u0006\u0002\n\u0000¨\u0006<"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity;", "Lcom/didi/payment/wallet/global/wallet/view/activity/WalletBaseActivity;", "()V", "activated", "", "getActivated", "()Ljava/lang/Boolean;", "setActivated", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "cardId", "", "getCardId", "()Ljava/lang/String;", "setCardId", "(Ljava/lang/String;)V", "cardListUrl", "getCardListUrl", "setCardListUrl", "currentNumberCards", "", "getCurrentNumberCards", "()I", "setCurrentNumberCards", "(I)V", "hidden", "getHidden", "setHidden", "list", "", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingResp;", "maximumNumberCards", "getMaximumNumberCards", "setMaximumNumberCards", "rvContent", "Landroidx/recyclerview/widget/RecyclerView;", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "initData", "", "initStatusBar", "initView", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "showDialog", "resp", "cancel", "Lkotlin/Function0;", "callback", "Lkotlin/Function1;", "Lkotlin/ParameterName;", "name", "url", "DialogResp", "IItemClickListener", "SettingAdapter", "SettingResp", "SettingViewHolder", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* compiled from: PrepaidSettingActivity.kt */
public final class PrepaidSettingActivity extends WalletBaseActivity {

    /* renamed from: a */
    private RecyclerView f31760a;

    /* renamed from: b */
    private CommonTitleBar f31761b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public final List<SettingResp> f31762c = new ArrayList();

    /* renamed from: d */
    private int f31763d;

    /* renamed from: e */
    private int f31764e = 3;

    /* renamed from: f */
    private String f31765f = "";

    /* renamed from: g */
    private Boolean f31766g = false;

    /* renamed from: h */
    private Boolean f31767h = false;

    /* renamed from: i */
    private String f31768i = "";

    @Metadata(mo175977d1 = {"\u0000\u0016\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\bf\u0018\u00002\u00020\u0001J\u0010\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H&¨\u0006\u0006"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;", "", "onItemClick", "", "position", "", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidSettingActivity.kt */
    public interface IItemClickListener {
        void onItemClick(int i);
    }

    public final int getCurrentNumberCards() {
        return this.f31763d;
    }

    public final void setCurrentNumberCards(int i) {
        this.f31763d = i;
    }

    public final int getMaximumNumberCards() {
        return this.f31764e;
    }

    public final void setMaximumNumberCards(int i) {
        this.f31764e = i;
    }

    public final String getCardId() {
        return this.f31765f;
    }

    public final void setCardId(String str) {
        this.f31765f = str;
    }

    public final Boolean getHidden() {
        return this.f31766g;
    }

    public final void setHidden(Boolean bool) {
        this.f31766g = bool;
    }

    public final Boolean getActivated() {
        return this.f31767h;
    }

    public final void setActivated(Boolean bool) {
        this.f31767h = bool;
    }

    public final String getCardListUrl() {
        return this.f31768i;
    }

    public final void setCardListUrl(String str) {
        this.f31768i = str;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_prepaid_setting);
        m22529b();
        m22526a();
    }

    /* access modifiers changed from: protected */
    public void initStatusBar() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, 0);
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        dismissLoadingDialog();
    }

    /* renamed from: a */
    private final void m22526a() {
        Intent intent = getIntent();
        if (intent != null) {
            setCurrentNumberCards(intent.getIntExtra("currentNumberCards", 0));
            setMaximumNumberCards(intent.getIntExtra("maximumNumberCards", 3));
            setCardId(intent.getStringExtra("cardId"));
            setHidden(Boolean.valueOf(intent.getBooleanExtra("hidden", false)));
            setActivated(Boolean.valueOf(intent.getBooleanExtra("activated", false)));
            setCardListUrl(intent.getStringExtra("cardListUrl"));
        }
        List<SettingResp> list = this.f31762c;
        SettingResp settingResp = new SettingResp();
        settingResp.setTitle(getString(R.string.Fintech_Payment_management_Old_card_Xzvx));
        settingResp.setLinkUrl("");
        settingResp.setShowDoubt(false);
        DialogResp dialogResp = new DialogResp();
        dialogResp.setTitle(getString(R.string.Fintech_Payment_management_to_apply_WttT));
        dialogResp.setContent(getString(R.string.Fintech_Payment_management_When_you_KVLD));
        dialogResp.setCommitStr(getString(R.string.Fintech_Payment_management_Confirmation_and_nIYK));
        dialogResp.setCancelStr(getString(R.string.Fintech_Payment_management_Not_now_GFLs));
        Unit unit = Unit.INSTANCE;
        settingResp.setDialog(dialogResp);
        Unit unit2 = Unit.INSTANCE;
        list.add(settingResp);
        List<SettingResp> list2 = this.f31762c;
        SettingResp settingResp2 = new SettingResp();
        settingResp2.setTitle(getString(R.string.Fintech_Payment_management_Write_off_wLOQ));
        settingResp2.setLinkUrl("");
        settingResp2.setShowDoubt(false);
        DialogResp dialogResp2 = new DialogResp();
        dialogResp2.setTitle(getString(R.string.Fintech_Payment_management_Are_you_UiIP));
        dialogResp2.setContent(getString(R.string.Fintech_Payment_management_Please_confirm_qdUU));
        dialogResp2.setCommitStr(getString(R.string.Fintech_Payment_management_Confirm_the_GAXi));
        dialogResp2.setCancelStr(getString(R.string.Fintech_Payment_management_Not_now_KBlF));
        Unit unit3 = Unit.INSTANCE;
        settingResp2.setDialog(dialogResp2);
        Unit unit4 = Unit.INSTANCE;
        list2.add(settingResp2);
        if (Intrinsics.areEqual((Object) this.f31767h, (Object) true)) {
            List<SettingResp> list3 = this.f31762c;
            SettingResp settingResp3 = new SettingResp();
            settingResp3.setTitle(getString(R.string.Fintech_Payment_management_Change_Password_Awzg));
            settingResp3.setLinkUrl("");
            settingResp3.setShowDoubt(true);
            Unit unit5 = Unit.INSTANCE;
            list3.add(settingResp3);
        }
        SettingAdapter settingAdapter = new SettingAdapter(this.f31762c, new PrepaidSettingActivity$initData$adapter$1(this));
        RecyclerView recyclerView = this.f31760a;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvContent");
            recyclerView = null;
        }
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        RecyclerView recyclerView3 = this.f31760a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvContent");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setAdapter(settingAdapter);
    }

    /* renamed from: b */
    private final void m22529b() {
        View findViewById = findViewById(R.id.rv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rv_content)");
        this.f31760a = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.title_bar)");
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById2;
        this.f31761b = commonTitleBar;
        CommonTitleBar commonTitleBar2 = null;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar = null;
        }
        commonTitleBar.setTitle(getString(R.string.Fintech_Payment_management_Set_oUUo));
        CommonTitleBar commonTitleBar3 = this.f31761b;
        if (commonTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            commonTitleBar2 = commonTitleBar3;
        }
        commonTitleBar2.setLeftImage((int) R.drawable.ic_pay_secure_back, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                PrepaidSettingActivity.m22527a(PrepaidSettingActivity.this, view);
            }
        });
        initLoadingDialog(this, R.id.title_bar);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22527a(PrepaidSettingActivity prepaidSettingActivity, View view) {
        Intrinsics.checkNotNullParameter(prepaidSettingActivity, "this$0");
        prepaidSettingActivity.finish();
    }

    public static /* synthetic */ void showDialog$default(PrepaidSettingActivity prepaidSettingActivity, SettingResp settingResp, Function0 function0, Function1 function1, int i, Object obj) {
        if ((i & 2) != 0) {
            function0 = PrepaidSettingActivity$showDialog$1.INSTANCE;
        }
        prepaidSettingActivity.showDialog(settingResp, function0, function1);
    }

    public final void showDialog(SettingResp settingResp, Function0<Unit> function0, Function1<? super String, Unit> function1) {
        String str;
        String str2;
        String str3;
        String str4;
        DialogResp dialog;
        DialogResp dialog2;
        DialogResp dialog3;
        DialogResp dialog4;
        Intrinsics.checkNotNullParameter(function0, "cancel");
        WalletCommonBottomDialog.Builder builder = new WalletCommonBottomDialog.Builder();
        if (settingResp == null || (dialog4 = settingResp.getDialog()) == null || (str = dialog4.getTitle()) == null) {
            str = "";
        }
        WalletCommonBottomDialog.Builder title = builder.setTitle(str);
        if (settingResp == null || (dialog3 = settingResp.getDialog()) == null || (str2 = dialog3.getContent()) == null) {
            str2 = "";
        }
        WalletCommonBottomDialog.Builder content = title.setContent(str2);
        if (settingResp == null || (dialog2 = settingResp.getDialog()) == null || (str3 = dialog2.getCancelStr()) == null) {
            str3 = "";
        }
        WalletCommonBottomDialog.Builder largeCancelStr = content.setLargeCancelStr(str3);
        if (settingResp == null || (dialog = settingResp.getDialog()) == null || (str4 = dialog.getCommitStr()) == null) {
            str4 = "";
        }
        WalletCommonBottomDialog build = largeCancelStr.setConfirmStr(str4).setClickListener(new PrepaidSettingActivity$showDialog$dialog$1(function1, settingResp, function0)).setShowCloseBtn(true).build();
        build.show(getSupportFragmentManager(), "");
        RecyclerView recyclerView = this.f31760a;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvContent");
            recyclerView = null;
        }
        recyclerView.postDelayed(new Runnable(this) {
            public final /* synthetic */ PrepaidSettingActivity f$1;

            {
                this.f$1 = r2;
            }

            public final void run() {
                PrepaidSettingActivity.m22528a(WalletCommonBottomDialog.this, this.f$1);
            }
        }, 300);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m22528a(WalletCommonBottomDialog walletCommonBottomDialog, PrepaidSettingActivity prepaidSettingActivity) {
        Intrinsics.checkNotNullParameter(walletCommonBottomDialog, "$dialog");
        Intrinsics.checkNotNullParameter(prepaidSettingActivity, "this$0");
        walletCommonBottomDialog.getContentView().setTextColor(ContextCompat.getColor(prepaidSettingActivity, R.color.wallet_color_FF4060));
        Dialog dialog = walletCommonBottomDialog.getDialog();
        if (dialog != null) {
            dialog.setCanceledOnTouchOutside(false);
        }
    }

    @Metadata(mo175977d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\t\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\u001e\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u000e¢\u0006\u0010\n\u0002\u0010\u0015\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\nX\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0017\u0010\f\"\u0004\b\u0018\u0010\u000e¨\u0006\u0019"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingResp;", "", "()V", "dialog", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$DialogResp;", "getDialog", "()Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$DialogResp;", "setDialog", "(Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$DialogResp;)V", "linkUrl", "", "getLinkUrl", "()Ljava/lang/String;", "setLinkUrl", "(Ljava/lang/String;)V", "showDoubt", "", "getShowDoubt", "()Ljava/lang/Boolean;", "setShowDoubt", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidSettingActivity.kt */
    public static final class SettingResp {
        private DialogResp dialog;
        private String linkUrl = "";
        private Boolean showDoubt = false;
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getLinkUrl() {
            return this.linkUrl;
        }

        public final void setLinkUrl(String str) {
            this.linkUrl = str;
        }

        public final Boolean getShowDoubt() {
            return this.showDoubt;
        }

        public final void setShowDoubt(Boolean bool) {
            this.showDoubt = bool;
        }

        public final DialogResp getDialog() {
            return this.dialog;
        }

        public final void setDialog(DialogResp dialogResp) {
            this.dialog = dialogResp;
        }
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u000e\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR\u001c\u0010\t\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u0006\"\u0004\b\u000b\u0010\bR\u001c\u0010\f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u0006\"\u0004\b\u000e\u0010\bR\u001c\u0010\u000f\u001a\u0004\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0006\"\u0004\b\u0011\u0010\b¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$DialogResp;", "", "()V", "cancelStr", "", "getCancelStr", "()Ljava/lang/String;", "setCancelStr", "(Ljava/lang/String;)V", "commitStr", "getCommitStr", "setCommitStr", "content", "getContent", "setContent", "title", "getTitle", "setTitle", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidSettingActivity.kt */
    public static final class DialogResp {
        private String cancelStr = "";
        private String commitStr = "";
        private String content = "";
        private String title = "";

        public final String getTitle() {
            return this.title;
        }

        public final void setTitle(String str) {
            this.title = str;
        }

        public final String getContent() {
            return this.content;
        }

        public final void setContent(String str) {
            this.content = str;
        }

        public final String getCancelStr() {
            return this.cancelStr;
        }

        public final void setCancelStr(String str) {
            this.cancelStr = str;
        }

        public final String getCommitStr() {
            return this.commitStr;
        }

        public final void setCommitStr(String str) {
            this.commitStr = str;
        }
    }

    @Metadata(mo175977d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B\u001d\u0012\u000e\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004\u0012\u0006\u0010\u0006\u001a\u00020\u0007¢\u0006\u0002\u0010\bJ\b\u0010\u0011\u001a\u00020\u0012H\u0016J\u0018\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u00022\u0006\u0010\u0016\u001a\u00020\u0012H\u0016J\u0018\u0010\u0017\u001a\u00020\u00022\u0006\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u0012H\u0016R\"\u0010\u0003\u001a\n\u0012\u0004\u0012\u00020\u0005\u0018\u00010\u0004X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\t\u0010\n\"\u0004\b\u000b\u0010\fR\u001a\u0010\u0006\u001a\u00020\u0007X\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\r\u0010\u000e\"\u0004\b\u000f\u0010\u0010¨\u0006\u001b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingViewHolder;", "list", "", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingResp;", "listener", "Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;", "(Ljava/util/List;Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;)V", "getList", "()Ljava/util/List;", "setList", "(Ljava/util/List;)V", "getListener", "()Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;", "setListener", "(Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$IItemClickListener;)V", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidSettingActivity.kt */
    public static final class SettingAdapter extends RecyclerView.Adapter<SettingViewHolder> {
        private List<SettingResp> list;
        private IItemClickListener listener;

        public SettingAdapter(List<SettingResp> list2, IItemClickListener iItemClickListener) {
            Intrinsics.checkNotNullParameter(iItemClickListener, "listener");
            this.list = list2;
            this.listener = iItemClickListener;
        }

        public final List<SettingResp> getList() {
            return this.list;
        }

        public final IItemClickListener getListener() {
            return this.listener;
        }

        public final void setList(List<SettingResp> list2) {
            this.list = list2;
        }

        public final void setListener(IItemClickListener iItemClickListener) {
            Intrinsics.checkNotNullParameter(iItemClickListener, "<set-?>");
            this.listener = iItemClickListener;
        }

        public SettingViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            Intrinsics.checkNotNullParameter(viewGroup, "parent");
            View inflate = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_prepaid_card_setting, viewGroup, false);
            Intrinsics.checkNotNullExpressionValue(inflate, "view");
            return new SettingViewHolder(inflate);
        }

        public void onBindViewHolder(SettingViewHolder settingViewHolder, int i) {
            Intrinsics.checkNotNullParameter(settingViewHolder, "holder");
            List<SettingResp> list2 = this.list;
            String str = null;
            SettingResp settingResp = list2 == null ? null : list2.get(i);
            TextView tvName = settingViewHolder.getTvName();
            if (settingResp != null) {
                str = settingResp.getTitle();
            }
            tvName.setText(str);
            int i2 = 0;
            settingViewHolder.getIvDoubt().setVisibility(settingResp == null ? false : Intrinsics.areEqual((Object) settingResp.getShowDoubt(), (Object) true) ? 0 : 8);
            settingViewHolder.getRoot().setOnClickListener(new View.OnClickListener(i) {
                public final /* synthetic */ int f$1;

                {
                    this.f$1 = r2;
                }

                public final void onClick(View view) {
                    PrepaidSettingActivity.SettingAdapter.m46616onBindViewHolder$lambda0(PrepaidSettingActivity.SettingAdapter.this, this.f$1, view);
                }
            });
            settingViewHolder.getIvDoubt().setOnClickListener(new View.OnClickListener() {
                public final void onClick(View view) {
                    PrepaidSettingActivity.SettingAdapter.m46617onBindViewHolder$lambda3(PrepaidSettingActivity.SettingViewHolder.this, view);
                }
            });
            List<SettingResp> list3 = this.list;
            if (list3 != null) {
                i2 = list3.size();
            }
            if (i == i2 - 1) {
                settingViewHolder.getLine().setVisibility(8);
            }
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-0  reason: not valid java name */
        public static final void m46616onBindViewHolder$lambda0(SettingAdapter settingAdapter, int i, View view) {
            Intrinsics.checkNotNullParameter(settingAdapter, "this$0");
            settingAdapter.getListener().onItemClick(i);
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-3  reason: not valid java name */
        public static final void m46617onBindViewHolder$lambda3(SettingViewHolder settingViewHolder, View view) {
            Intrinsics.checkNotNullParameter(settingViewHolder, "$holder");
            GlobalAlertDialog globalAlertDialog = new GlobalAlertDialog();
            List arrayList = new ArrayList();
            List arrayList2 = new ArrayList();
            arrayList.add(settingViewHolder.getIvDoubt().getContext().getString(R.string.Fintech_Payment_management_I_see_KrBP));
            arrayList2.add(C11101x4f2eebd7.INSTANCE);
            globalAlertDialog.setButtons(arrayList);
            globalAlertDialog.setListeners(arrayList2);
            globalAlertDialog.setTitle(view.getContext().getString(R.string.Fintech_Payment_management_About_the_hukh));
            globalAlertDialog.setMsg(view.getContext().getString(R.string.Fintech_Payment_management_The_card_oWLh));
            Context context = view.getContext();
            FragmentActivity fragmentActivity = context instanceof FragmentActivity ? (FragmentActivity) context : null;
            if (fragmentActivity != null) {
                globalAlertDialog.show(fragmentActivity.getSupportFragmentManager(), "");
            }
            WalletHomeTrackerManager.Companion.trackPrepaidSettingPwdIntroduce();
        }

        /* access modifiers changed from: private */
        /* renamed from: onBindViewHolder$lambda-3$lambda-1  reason: not valid java name */
        public static final void m46618onBindViewHolder$lambda3$lambda1(DialogFragment dialogFragment, int i) {
            WalletHomeTrackerManager.Companion.trackPrepaidSettingPwdIntroduceClick();
            if (dialogFragment != null) {
                dialogFragment.dismiss();
            }
        }

        public int getItemCount() {
            List<SettingResp> list2 = this.list;
            if (list2 == null) {
                return 0;
            }
            return list2.size();
        }
    }

    @Metadata(mo175977d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\f\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000bR\u0011\u0010\u000e\u001a\u00020\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011¨\u0006\u0012"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/prepaidcard/PrepaidSettingActivity$SettingViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "ivDoubt", "Landroid/widget/ImageView;", "getIvDoubt", "()Landroid/widget/ImageView;", "line", "getLine", "()Landroid/view/View;", "root", "getRoot", "tvName", "Landroid/widget/TextView;", "getTvName", "()Landroid/widget/TextView;", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* compiled from: PrepaidSettingActivity.kt */
    public static final class SettingViewHolder extends RecyclerView.ViewHolder {
        private final ImageView ivDoubt;
        private final View line;
        private final View root;
        private final TextView tvName;

        /* JADX INFO: super call moved to the top of the method (can break code semantics) */
        public SettingViewHolder(View view) {
            super(view);
            Intrinsics.checkNotNullParameter(view, "itemView");
            View findViewById = view.findViewById(R.id.tv_name);
            Intrinsics.checkNotNullExpressionValue(findViewById, "itemView.findViewById(R.id.tv_name)");
            this.tvName = (TextView) findViewById;
            View findViewById2 = view.findViewById(R.id.iv_doubt);
            Intrinsics.checkNotNullExpressionValue(findViewById2, "itemView.findViewById(R.id.iv_doubt)");
            this.ivDoubt = (ImageView) findViewById2;
            View findViewById3 = view.findViewById(R.id.line);
            Intrinsics.checkNotNullExpressionValue(findViewById3, "itemView.findViewById(R.id.line)");
            this.line = findViewById3;
            View findViewById4 = view.findViewById(R.id.root);
            Intrinsics.checkNotNullExpressionValue(findViewById4, "itemView.findViewById(R.id.root)");
            this.root = findViewById4;
        }

        public final TextView getTvName() {
            return this.tvName;
        }

        public final ImageView getIvDoubt() {
            return this.ivDoubt;
        }

        public final View getLine() {
            return this.line;
        }

        public final View getRoot() {
            return this.root;
        }
    }
}

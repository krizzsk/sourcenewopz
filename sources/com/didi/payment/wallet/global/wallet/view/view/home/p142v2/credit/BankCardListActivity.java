package com.didi.payment.wallet.global.wallet.view.view.home.p142v2.credit;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.payment.base.event.WalletRefreshDataEvent;
import com.didi.payment.base.proxy.LoadingProxyHolder;
import com.didi.payment.commonsdk.p129ui.WBaseActivity;
import com.didi.payment.commonsdk.p129ui.WBaseViewModel;
import com.didi.payment.creditcard.open.DidiCreditCardFactory;
import com.didi.payment.creditcard.open.DidiGlobalAddCardData;
import com.didi.payment.creditcard.open.DidiGlobalDeleteCardData;
import com.didi.payment.creditcard.open.DidiGlobalVerifyCardData;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.resp.WalletHomeModelKt;
import com.didi.payment.wallet.global.wallet.view.view.home.p142v2.tool.WalletHomeTrackerManager;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.greenrobot.eventbus.Subscribe;

@Metadata(mo175977d1 = {"\u0000\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 82\b\u0012\u0004\u0012\u00020\u00020\u00012\u00020\u0003:\u00018B\u0005¢\u0006\u0002\u0010\u0004J\n\u0010\u0018\u001a\u0004\u0018\u00010\u0019H\u0014J\b\u0010\u001a\u001a\u00020\u001bH\u0016J\b\u0010\u001c\u001a\u00020\u001bH\u0016J\u0018\u0010\u001d\u001a\u00020\u001b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0002J=\u0010\"\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010$\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000f2\b\u0010&\u001a\u0004\u0018\u00010!H\u0002¢\u0006\u0002\u0010'J$\u0010(\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\b\u0010#\u001a\u0004\u0018\u00010\u000f2\b\u0010%\u001a\u0004\u0018\u00010\u000fH\u0002J\"\u0010)\u001a\u00020\u001b2\u0006\u0010 \u001a\u00020!2\u0006\u0010*\u001a\u00020!2\b\u0010+\u001a\u0004\u0018\u00010,H\u0014J\u001a\u0010-\u001a\u00020\u001b2\u0006\u0010.\u001a\u00020!2\b\u0010/\u001a\u0004\u0018\u00010\tH\u0016J\u0012\u00100\u001a\u00020\u001b2\b\u00101\u001a\u0004\u0018\u000102H\u0014J\u0012\u00103\u001a\u00020\u001b2\b\u00104\u001a\u0004\u0018\u000105H\u0007J\b\u00106\u001a\u00020!H\u0016J\b\u00107\u001a\u00020\u001bH\u0014R\u0010\u0010\u0005\u001a\u0004\u0018\u00010\u0006X\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u0007\u001a\n\u0012\u0004\u0012\u00020\t\u0018\u00010\bX\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX.¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000e\u001a\u0004\u0018\u00010\u000fX\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0012\u001a\u00020\u0013X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0014\u001a\u00020\u0015X.¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X.¢\u0006\u0002\n\u0000¨\u00069"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardListActivity;", "Lcom/didi/payment/commonsdk/ui/WBaseActivity;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardVM;", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/IBankCardListener;", "()V", "adapter", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardAdapter;", "bankList", "", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/Entry;", "flDiscount", "Landroid/widget/FrameLayout;", "mRefresh", "", "mSource", "", "resp", "Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardResp;", "rvContent", "Landroidx/recyclerview/widget/RecyclerView;", "titleBar", "Lcom/didi/sdk/view/titlebar/CommonTitleBar;", "tvDiscount", "Landroid/widget/TextView;", "getTitleBarView", "Landroid/view/View;", "initContentView", "", "initTitleBar", "jumpToAddCreditCardPage", "activity", "Landroid/app/Activity;", "requestCode", "", "jumpToCreditCardDetailPage", "cardNo", "expiryDate", "cardIndex", "expired", "(ILjava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;)V", "jumpToVerifyBalancePage", "onActivityResult", "resultCode", "data", "Landroid/content/Intent;", "onBankCardClick", "position", "entry", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onEvent", "event", "Lcom/didi/payment/base/event/WalletRefreshDataEvent;", "onInflateContentLayout", "onResume", "Companion", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
/* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardListActivity */
/* compiled from: BankCardListActivity.kt */
public final class BankCardListActivity extends WBaseActivity<BankCardVM> implements IBankCardListener {
    public static final int CARD_STATUS_VERIFY = 1;
    public static final Companion Companion = new Companion((DefaultConstructorMarker) null);
    public static final int REQUEST_BIND_CARD = 1001;
    public static final int REQUEST_DETAIL_CARD = 1002;
    public static final int REQUEST_VERIFY_CARD = 1003;

    /* renamed from: a */
    private RecyclerView f32675a;

    /* renamed from: b */
    private CommonTitleBar f32676b;

    /* renamed from: c */
    private FrameLayout f32677c;

    /* renamed from: d */
    private TextView f32678d;

    /* renamed from: e */
    private BankCardAdapter f32679e;

    /* renamed from: f */
    private BankCardResp f32680f;

    /* renamed from: g */
    private List<Entry> f32681g = new ArrayList();

    /* renamed from: h */
    private String f32682h = "2";

    /* renamed from: i */
    private boolean f32683i;

    public int onInflateContentLayout() {
        return R.layout.activity_bank_card_list;
    }

    public static final /* synthetic */ BankCardVM access$getVm(BankCardListActivity bankCardListActivity) {
        return (BankCardVM) bankCardListActivity.getVm();
    }

    @Metadata(mo175977d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\b\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002¢\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004XT¢\u0006\u0002\n\u0000¨\u0006\b"}, mo175978d2 = {"Lcom/didi/payment/wallet/global/wallet/view/view/home/v2/credit/BankCardListActivity$Companion;", "", "()V", "CARD_STATUS_VERIFY", "", "REQUEST_BIND_CARD", "REQUEST_DETAIL_CARD", "REQUEST_VERIFY_CARD", "wallet_globalRelease"}, mo175979k = 1, mo175980mv = {1, 5, 1}, mo175982xi = 48)
    /* renamed from: com.didi.payment.wallet.global.wallet.view.view.home.v2.credit.BankCardListActivity$Companion */
    /* compiled from: BankCardListActivity.kt */
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
        Intent intent = getIntent();
        if (intent != null) {
            this.f32682h = intent.getStringExtra("resource_id");
        }
        this.f32679e = new BankCardAdapter(this.f32681g, this);
        RecyclerView recyclerView = this.f32675a;
        RecyclerView recyclerView2 = null;
        if (recyclerView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvContent");
            recyclerView = null;
        }
        recyclerView.setAdapter(this.f32679e);
        RecyclerView recyclerView3 = this.f32675a;
        if (recyclerView3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("rvContent");
        } else {
            recyclerView2 = recyclerView3;
        }
        recyclerView2.setLayoutManager(new LinearLayoutManager(this));
        ViewModel viewModel = new ViewModelProvider(this).get(BankCardVM.class);
        Intrinsics.checkNotNullExpressionValue(viewModel, "ViewModelProvider(this).…t(BankCardVM::class.java)");
        setVm((WBaseViewModel) viewModel);
        ((BankCardVM) getVm()).getRespData().observe(this, new Observer() {
            public final void onChanged(Object obj) {
                BankCardListActivity.m23120a(BankCardListActivity.this, (BankCardResp) obj);
            }
        });
        subscribeUi(getVm());
        ((BankCardVM) getVm()).loadData();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23120a(BankCardListActivity bankCardListActivity, BankCardResp bankCardResp) {
        List<Entry> entryList;
        List<Entry> list;
        Intrinsics.checkNotNullParameter(bankCardListActivity, "this$0");
        List<Entry> list2 = bankCardListActivity.f32681g;
        if (list2 != null) {
            list2.size();
        }
        List<Entry> list3 = bankCardListActivity.f32681g;
        if (list3 != null) {
            list3.clear();
        }
        BankCardAdapter bankCardAdapter = bankCardListActivity.f32679e;
        if (bankCardAdapter != null) {
            bankCardAdapter.notifyDataSetChanged();
        }
        Data data = bankCardResp.getData();
        if (!(data == null || (entryList = data.getEntryList()) == null || (list = bankCardListActivity.f32681g) == null)) {
            list.addAll(entryList);
        }
        Entry entry = new Entry();
        entry.setName(bankCardListActivity.getString(R.string.GRider_Cognition_Add_a_dpKu));
        List<Entry> list4 = bankCardListActivity.f32681g;
        if (list4 != null) {
            list4.add(entry);
        }
        BankCardAdapter bankCardAdapter2 = bankCardListActivity.f32679e;
        int i = 0;
        if (bankCardAdapter2 != null) {
            List<Entry> list5 = bankCardListActivity.f32681g;
            bankCardAdapter2.notifyItemRangeChanged(0, list5 == null ? 0 : list5.size());
        }
        FrameLayout frameLayout = bankCardListActivity.f32677c;
        String str = null;
        if (frameLayout == null) {
            Intrinsics.throwUninitializedPropertyAccessException("flDiscount");
            frameLayout = null;
        }
        Data data2 = bankCardResp.getData();
        if (TextUtils.isEmpty(data2 == null ? null : data2.getPromotionText())) {
            i = 8;
        }
        frameLayout.setVisibility(i);
        TextView textView = bankCardListActivity.f32678d;
        if (textView == null) {
            Intrinsics.throwUninitializedPropertyAccessException("tvDiscount");
            textView = null;
        }
        Data data3 = bankCardResp.getData();
        if (data3 != null) {
            str = data3.getPromotionText();
        }
        textView.setText(str);
        WalletHomeTrackerManager.Companion.trackerBankListPageSW(bankCardResp.getData());
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f32683i) {
            ((BankCardVM) getVm()).loadData();
            this.f32683i = false;
        }
    }

    public void initTitleBar() {
        View findViewById = findViewById(R.id.title_bar);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.title_bar)");
        CommonTitleBar commonTitleBar = (CommonTitleBar) findViewById;
        this.f32676b = commonTitleBar;
        CommonTitleBar commonTitleBar2 = null;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar = null;
        }
        decoretaTitlebar(commonTitleBar);
        CommonTitleBar commonTitleBar3 = this.f32676b;
        if (commonTitleBar3 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar3 = null;
        }
        commonTitleBar3.setLeftImage((int) R.drawable.common_title_back_arrow, (View.OnClickListener) new View.OnClickListener() {
            public final void onClick(View view) {
                BankCardListActivity.m23119a(BankCardListActivity.this, view);
            }
        });
        CommonTitleBar commonTitleBar4 = this.f32676b;
        if (commonTitleBar4 == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
        } else {
            commonTitleBar2 = commonTitleBar4;
        }
        commonTitleBar2.setTitle(getString(R.string.Fintech_Payment_redesign_My_bank_vTfS));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static final void m23119a(BankCardListActivity bankCardListActivity, View view) {
        Intrinsics.checkNotNullParameter(bankCardListActivity, "this$0");
        bankCardListActivity.onBackPressed();
    }

    public void initContentView() {
        View findViewById = findViewById(R.id.rv_content);
        Intrinsics.checkNotNullExpressionValue(findViewById, "findViewById(R.id.rv_content)");
        this.f32675a = (RecyclerView) findViewById;
        View findViewById2 = findViewById(R.id.fl_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById2, "findViewById(R.id.fl_discount)");
        this.f32677c = (FrameLayout) findViewById2;
        View findViewById3 = findViewById(R.id.tv_discount);
        Intrinsics.checkNotNullExpressionValue(findViewById3, "findViewById(R.id.tv_discount)");
        this.f32678d = (TextView) findViewById3;
    }

    /* access modifiers changed from: protected */
    public View getTitleBarView() {
        CommonTitleBar commonTitleBar = this.f32676b;
        if (commonTitleBar == null) {
            Intrinsics.throwUninitializedPropertyAccessException("titleBar");
            commonTitleBar = null;
        }
        return commonTitleBar;
    }

    public void onBankCardClick(int i, Entry entry) {
        WalletHomeTrackerManager.Companion.trackBankListPageClick(entry);
        if (entry != null) {
            if (TextUtils.isEmpty(entry.getCardIndex())) {
                m23118a((Activity) this, 1001);
                return;
            }
            String cardStatus = entry.getCardStatus();
            Integer num = null;
            if (cardStatus != null && WalletHomeModelKt.toDefaultInt$default(cardStatus, 0, 1, (Object) null) == 1) {
                m23116a(1003, entry.getName(), entry.getCardIndex());
                return;
            }
            String name = entry.getName();
            String expireDate = entry.getExpireDate();
            String cardIndex = entry.getCardIndex();
            String expired = entry.getExpired();
            if (expired != null) {
                num = Integer.valueOf(WalletHomeModelKt.toDefaultInt$default(expired, 0, 1, (Object) null));
            }
            m23117a(1002, name, expireDate, cardIndex, num);
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        switch (i) {
            case 1001:
            case 1002:
            case 1003:
                ((BankCardVM) getVm()).loadData();
                return;
            default:
                return;
        }
    }

    /* renamed from: a */
    private final void m23117a(int i, String str, String str2, String str3, Integer num) {
        int i2;
        DidiGlobalDeleteCardData.DeleteCardParam deleteCardParam = new DidiGlobalDeleteCardData.DeleteCardParam();
        deleteCardParam.expiryDate = str2;
        deleteCardParam.cardNo = str;
        deleteCardParam.cardIndex = str3;
        if (num == null) {
            i2 = 0;
        } else {
            i2 = num.intValue();
        }
        deleteCardParam.expired = i2;
        String str4 = this.f32682h;
        if (str4 == null) {
            str4 = "1";
        }
        deleteCardParam.resourceId = str4;
        DidiCreditCardFactory.createGlobalCreditCardApi().startCreditCardDetailActivity(this, i, deleteCardParam);
    }

    /* renamed from: a */
    private final void m23118a(Activity activity, int i) {
        DidiGlobalAddCardData.AddCardParam addCardParam = new DidiGlobalAddCardData.AddCardParam();
        addCardParam.bindType = 1;
        String str = this.f32682h;
        if (str == null) {
            str = "1";
        }
        addCardParam.resourceId = str;
        LoadingProxyHolder.setProxy(new BankCardListActivity$jumpToAddCreditCardPage$1(this));
        DidiCreditCardFactory.createGlobalCreditCardApi().startAddCreditCardActivity(activity, i, addCardParam);
    }

    /* renamed from: a */
    private final void m23116a(int i, String str, String str2) {
        DidiGlobalVerifyCardData.VerifyCardParam verifyCardParam = new DidiGlobalVerifyCardData.VerifyCardParam();
        verifyCardParam.cardNo = str;
        verifyCardParam.cardIndex = str2;
        DidiCreditCardFactory.createGlobalCreditCardApi().startVerifyBalanceActivity((FragmentActivity) this, i, verifyCardParam);
    }

    @Subscribe
    public final void onEvent(WalletRefreshDataEvent walletRefreshDataEvent) {
        this.f32683i = true;
    }
}

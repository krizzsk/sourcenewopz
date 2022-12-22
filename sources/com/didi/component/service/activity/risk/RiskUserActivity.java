package com.didi.component.service.activity.risk;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.component.business.data.form.FormStore;
import com.didi.component.common.dialog.CommonDialogHandler;
import com.didi.component.common.dialog.IDialog;
import com.didi.component.service.activity.risk.dialog.NormalDialog;
import com.didi.component.service.activity.risk.dialog.NormalDialogInfo;
import com.didi.component.service.activity.risk.items.CreditCardCustomItem;
import com.didi.component.service.activity.risk.items.CreditCardItem;
import com.didi.component.service.activity.risk.items.CustomWebListItem;
import com.didi.component.service.activity.risk.items.FacebookCustomItem;
import com.didi.component.service.activity.risk.items.FacebookItem;
import com.didi.component.service.activity.risk.items.ItemType;
import com.didi.component.service.activity.risk.items.MexicoCurpItem;
import com.didi.component.service.activity.risk.model.RiskVerifyListItem;
import com.didi.global.loading.app.AbsLoadingActivity;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.GlobalOmegaUtils;
import com.didi.sdk.view.GlobalTitleBar;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class RiskUserActivity extends AbsLoadingActivity implements IDialogDisplayer {
    public static final String EXTRA_KEY_4_FINISH_SELF = "extra_key_4_finish_self";
    public static final String RISK_USER_ACTIVITY_EXTRA_EXTENSION = "extension";
    public static final String RISK_USER_ACTIVITY_EXTRA_KEY = "itemTypes";
    public static final String RISK_USER_ACTIVITY_EXTRA_URL = "url";
    public static final String RISK_USER_ACTIVITY_EXTRA_VERIFY_LIST = "VERIFY_LIST";

    /* renamed from: a */
    private GlobalTitleBar f15679a;

    /* renamed from: b */
    private RecyclerView f15680b;

    /* renamed from: c */
    private RiskListAdapter f15681c;

    /* renamed from: d */
    private CommonDialogHandler f15682d;

    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        StatusBarLightingCompat.setStatusBarBgLightning((Activity) this, true);
        setContentView((int) R.layout.risk_user_activity_layout);
        m11439a();
        m11440b();
        m11443e();
        m11444f();
    }

    /* access modifiers changed from: protected */
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        if (intent != null && intent.getBooleanExtra(EXTRA_KEY_4_FINISH_SELF, false)) {
            finish();
        }
        m11442d();
    }

    /* renamed from: a */
    private void m11439a() {
        this.f15680b = (RecyclerView) findViewById(R.id.risk_user_list);
        this.f15679a = (GlobalTitleBar) findViewById(R.id.risk_user_title_bar);
    }

    /* renamed from: b */
    private void m11440b() {
        this.f15679a.setTitle((int) R.string.risk_page_title);
        this.f15679a.setTitleBarLineVisible(8);
        this.f15680b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        RiskListAdapter riskListAdapter = new RiskListAdapter(new ArrayList());
        this.f15681c = riskListAdapter;
        this.f15680b.setAdapter(riskListAdapter);
        m11441c();
    }

    /* renamed from: c */
    private void m11441c() {
        m11442d();
    }

    /* renamed from: d */
    private void m11442d() {
        Intent intent = getIntent();
        if (intent != null) {
            String[] stringArrayExtra = intent.getStringArrayExtra(RISK_USER_ACTIVITY_EXTRA_KEY);
            String stringExtra = intent.getStringExtra("url");
            String stringExtra2 = intent.getStringExtra("extension");
            ArrayList parcelableArrayListExtra = intent.getParcelableArrayListExtra(RISK_USER_ACTIVITY_EXTRA_VERIFY_LIST);
            if (parcelableArrayListExtra != null && !parcelableArrayListExtra.isEmpty()) {
                Iterator it = parcelableArrayListExtra.iterator();
                while (it.hasNext()) {
                    RiskVerifyListItem riskVerifyListItem = (RiskVerifyListItem) it.next();
                    String str = riskVerifyListItem.cell_click_scheme;
                    if (str.contains("facebook")) {
                        this.f15681c.addItem(new FacebookCustomItem(riskVerifyListItem.content, this.f15681c, this, riskVerifyListItem));
                    } else if (str.contains("bind_card")) {
                        this.f15681c.addItem(new CreditCardCustomItem(riskVerifyListItem.content, this.f15681c, this, riskVerifyListItem));
                    } else if (str.contains("openurl")) {
                        this.f15681c.addItem(new CustomWebListItem(riskVerifyListItem.content, this.f15681c, this, riskVerifyListItem, stringExtra2));
                    }
                }
            } else if (stringArrayExtra != null) {
                for (String str2 : stringArrayExtra) {
                    int i = C70122.f15683x3d9ebb3e[ItemType.getItemByType(str2).ordinal()];
                    if (i == 1) {
                        RiskListAdapter riskListAdapter = this.f15681c;
                        riskListAdapter.addItem(new FacebookItem(str2, riskListAdapter, this));
                    } else if (i == 2) {
                        RiskListAdapter riskListAdapter2 = this.f15681c;
                        riskListAdapter2.addItem(new CreditCardItem(str2, riskListAdapter2, this));
                    } else if (i == 3) {
                        RiskListAdapter riskListAdapter3 = this.f15681c;
                        riskListAdapter3.addItem(new MexicoCurpItem(str2, riskListAdapter3, this, stringExtra, stringExtra2));
                    }
                }
            }
        }
    }

    /* renamed from: com.didi.component.service.activity.risk.RiskUserActivity$2 */
    static /* synthetic */ class C70122 {

        /* renamed from: $SwitchMap$com$didi$component$service$activity$risk$items$ItemType */
        static final /* synthetic */ int[] f15683x3d9ebb3e;

        /* JADX WARNING: Can't wrap try/catch for region: R(6:0|1|2|3|4|(3:5|6|8)) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        static {
            /*
                com.didi.component.service.activity.risk.items.ItemType[] r0 = com.didi.component.service.activity.risk.items.ItemType.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                f15683x3d9ebb3e = r0
                com.didi.component.service.activity.risk.items.ItemType r1 = com.didi.component.service.activity.risk.items.ItemType.FACEBOOK     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = f15683x3d9ebb3e     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.component.service.activity.risk.items.ItemType r1 = com.didi.component.service.activity.risk.items.ItemType.CREDIT_CARD     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = f15683x3d9ebb3e     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.component.service.activity.risk.items.ItemType r1 = com.didi.component.service.activity.risk.items.ItemType.MEXICO_CURP     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.component.service.activity.risk.RiskUserActivity.C70122.<clinit>():void");
        }
    }

    /* renamed from: e */
    private void m11443e() {
        this.f15679a.getLeftImgView().setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                RiskUserActivity.this.finish();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        RiskListAdapter riskListAdapter = this.f15681c;
        if (riskListAdapter != null) {
            riskListAdapter.onActivityResult(i, i2, intent);
        }
        super.onActivityResult(i, i2, intent);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        RiskListAdapter riskListAdapter = this.f15681c;
        if (riskListAdapter != null) {
            riskListAdapter.onDestroy();
        }
    }

    public IDialog showDialog(NormalDialogInfo normalDialogInfo, IDialog.DialogListener dialogListener) {
        NormalDialog.DialogBuilder dialogBuilder = new NormalDialog.DialogBuilder(this);
        dialogBuilder.setListener(dialogListener);
        dialogBuilder.setDialogInfo(normalDialogInfo);
        NormalDialog build = dialogBuilder.build();
        build.show();
        return build;
    }

    public IDialog showLoading(String str) {
        showMaskLayerLoading();
        return null;
    }

    public void dismissLoading(IDialog iDialog) {
        hideLoading();
    }

    public View getFallbackView() {
        return this.f15679a;
    }

    /* renamed from: f */
    private void m11444f() {
        String str;
        EstimateItemModel newEstimateItem = FormStore.getInstance().getNewEstimateItem();
        HashMap hashMap = new HashMap();
        if (newEstimateItem == null) {
            str = "";
        } else {
            str = newEstimateItem.estimateId;
        }
        hashMap.put("bubble_id", str);
        GlobalOmegaUtils.trackEvent("gp_safetyvarify_options_sw", hashMap);
    }
}

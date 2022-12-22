package com.didi.sdk.sidebar.history;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Message;
import android.text.Html;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.core.content.ContextCompat;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.tracker.GPageIdConstant;
import com.didi.global.loading.app.AbsLoadingFragment;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.app.BusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.app.tap.BusinessConstants;
import com.didi.sdk.event.DefaultEvent;
import com.didi.sdk.event.EventReceiver;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.push.http.BaseObject;
import com.didi.sdk.sidebar.SidebarEvent;
import com.didi.sdk.sidebar.compatible.MsgAndEventUtil;
import com.didi.sdk.sidebar.history.adapter.InoiceCountListener;
import com.didi.sdk.sidebar.history.manager.HistoryRequestCallBack;
import com.didi.sdk.sidebar.history.manager.IBikeHistoryManager;
import com.didi.sdk.sidebar.history.manager.IFoodHistoryManager;
import com.didi.sdk.sidebar.history.manager.IHistoryManager;
import com.didi.sdk.sidebar.history.manager.IRideHistoryManager;
import com.didi.sdk.sidebar.history.manager.JPInvoiceManager;
import com.didi.sdk.sidebar.history.manager.impl.RideHistoryManagerImpl;
import com.didi.sdk.sidebar.history.manager.soda.FoodHistoryManagerImpl;
import com.didi.sdk.sidebar.history.model.AbsHistoryOrder;
import com.didi.sdk.sidebar.history.model.BikeHistoryOrder;
import com.didi.sdk.sidebar.history.model.FoodHistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrder;
import com.didi.sdk.sidebar.history.model.HistoryOrderCountryModel;
import com.didi.sdk.sidebar.history.model.HistoryOrdersResponse;
import com.didi.sdk.sidebar.history.model.InvoiceOrder;
import com.didi.sdk.sidebar.history.store.HistoryRecordStore;
import com.didi.sdk.sidebar.history.util.HistoryOmegaUtils;
import com.didi.sdk.sidebar.history.util.HistoryUtils;
import com.didi.sdk.sidebar.history.view.CountrySelectDialogFragment;
import com.didi.sdk.sidebar.history.view.HistoryListViewPager;
import com.didi.sdk.sidebar.sdk.api.model.CommonDispatchMessage;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.view.popup.PopupSelectView;
import com.didi.sdk.view.popup.model.PopupSelectModel;
import com.didi.sdk.webview.BaseWebActivity;
import com.didi.sdk.webview.WebViewModel;
import com.didichuxing.omega.sdk.init.OmegaSDK;
import com.didiglobal.domainservice.DomainServiceManager;
import com.didiglobal.domainservice.utils.DomainConstants;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.travel.ride.widget.GlobalTitleBar2;
import com.didiglobal.travel.util.CollectionUtils;
import com.google.android.material.tabs.TabLayout;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import org.greenrobot.eventbus.EventBus;

public class HistoryRecordFragment extends AbsLoadingFragment implements IComponent<BusinessContext>, IStatusBar {
    public static final String COUNTRY_CODE_AR = "AR";
    public static final String COUNTRY_CODE_AU = "AU";
    public static final String COUNTRY_CODE_BR = "BR";
    public static final String COUNTRY_CODE_CL = "CL";
    public static final String COUNTRY_CODE_CO = "CO";
    public static final String COUNTRY_CODE_CR = "CR";
    public static final String COUNTRY_CODE_DO = "DO";
    public static final String COUNTRY_CODE_JP = "JP";
    public static final String COUNTRY_CODE_MX = "MX";
    public static final String COUNTRY_CODE_NZ = "NZ";
    public static final String COUNTRY_CODE_PA = "PA";
    public static final String COUNTRY_CODE_PE = "PE";
    public static final String COUNTRY_CODE_PR = "PR";
    public static final String COUNTRY_CODE_ZA = "ZA";
    public static final String TAG = "HistoryRecordFragment";

    /* renamed from: d */
    private static final String f37303d = "MX";

    /* renamed from: A */
    private boolean f37304A = true;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f37305B = 0;

    /* renamed from: C */
    private View f37306C;

    /* renamed from: D */
    private boolean f37307D = false;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public CountrySelectDialogFragment f37308E;

    /* renamed from: F */
    private Object f37309F;

    /* renamed from: G */
    private String f37310G;

    /* renamed from: H */
    private InoiceCountListener f37311H = new InoiceCountListener() {
        public void onSelectCountChange() {
            if (HistoryRecordFragment.this.m26555v() != null && HistoryRecordFragment.this.m26555v().getFinishedOrderList() != null) {
                int i = 0;
                for (AbsHistoryOrder next : HistoryRecordFragment.this.m26555v().getFinishedOrderList()) {
                    if ((next instanceof HistoryOrder) && ((HistoryOrder) next).isInvoiceSelected()) {
                        i++;
                    }
                }
                if (i > 0) {
                    HistoryRecordFragment.this.m26530f();
                    HistoryRecordFragment.this.m26496a(i);
                    return;
                }
                HistoryRecordFragment.this.m26534g();
            }
        }
    };

    /* renamed from: a */
    private Logger f37312a = LoggerFactory.getLogger(TAG);
    /* access modifiers changed from: private */

    /* renamed from: b */
    public Context f37313b;

    /* renamed from: c */
    private BusinessContext f37314c;

    /* renamed from: e */
    private ViewStub f37315e;

    /* renamed from: f */
    private View f37316f;

    /* renamed from: g */
    private View f37317g;

    /* renamed from: h */
    private TextView f37318h;

    /* renamed from: i */
    private JPInvoiceManager f37319i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public boolean f37320j = false;

    /* renamed from: k */
    private boolean f37321k;

    /* renamed from: l */
    private TextView f37322l;

    /* renamed from: m */
    private TextView f37323m;

    /* renamed from: n */
    private View f37324n;

    /* renamed from: o */
    private View f37325o;

    /* renamed from: p */
    private InvoiceFragmentDialog f37326p;

    /* renamed from: q */
    private int f37327q;

    /* renamed from: r */
    private List<InvoiceOrder> f37328r = new ArrayList();
    /* access modifiers changed from: private */

    /* renamed from: s */
    public List<HistoryListFragmentModel> f37329s = new ArrayList();

    /* renamed from: t */
    private IFoodHistoryManager f37330t;
    protected GlobalTitleBar2 titleBar;
    protected Button tryAginBtn;

    /* renamed from: u */
    private IRideHistoryManager f37331u;

    /* renamed from: v */
    private IBikeHistoryManager f37332v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public HistoryListViewPager f37333w;

    /* renamed from: x */
    private HistoryListViewPagerAdapter f37334x;

    /* renamed from: y */
    private LinearLayout f37335y;

    /* renamed from: z */
    private TabLayout f37336z;

    /* access modifiers changed from: protected */
    public boolean isAllBusinessNetworkFinish() {
        return true;
    }

    public boolean showStatusBar() {
        return true;
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.f37313b = getActivity();
        this.f37309F = OmegaSDK.getGlobalAttr("g_PageId");
        OmegaSDK.putGlobalAttr("g_PageId", GPageIdConstant.G_PAGE_ID_MY_TRIP);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        if (this.f37306C == null) {
            this.f37306C = layoutInflater.inflate(R.layout.f_history_record, viewGroup, false);
            m26495a();
            m26543l();
            this.f37333w = (HistoryListViewPager) this.f37306C.findViewById(R.id.list_fragment_view_page);
            this.f37335y = (LinearLayout) this.f37306C.findViewById(R.id.list_fragment_tab_layout);
            this.f37336z = (TabLayout) this.f37306C.findViewById(R.id.list_fragment_tab);
            this.f37308E = new CountrySelectDialogFragment();
            initTitlebar();
            this.f37315e = (ViewStub) this.f37306C.findViewById(R.id.refresh_stub);
            m26498a(this.f37306C);
            m26542k();
        }
        HistoryRecordStore.getInstance().registerReceiver(this);
        return this.f37306C;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26496a(int i) {
        String str;
        this.f37327q = i;
        if (MultiLocaleStore.getInstance().isJapanese()) {
            str = "<font color=\"#FF7F41\">" + i + "</font>" + getString(R.string.history_fragment_voice_tip_prefix);
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append(getString(R.string.history_fragment_voice_tip_prefix));
            sb.append("<font color=\"#FF7F41\">");
            sb.append(i);
            sb.append("</font>");
            sb.append(getString(i <= 1 ? R.string.history_fragment_voice_tip_suffix_one : R.string.history_fragment_voice_tip_suffix));
            str = sb.toString();
        }
        this.f37323m.setText(Html.fromHtml(str));
    }

    public void onPause() {
        super.onPause();
        m26551r();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f37306C = null;
        OmegaSDK.putGlobalAttr("g_PageId", this.f37309F);
    }

    public void onStart() {
        super.onStart();
        JPInvoiceManager jPInvoiceManager = this.f37319i;
        if (jPInvoiceManager != null) {
            jPInvoiceManager.onStart();
        }
    }

    public void onStop() {
        super.onStop();
        JPInvoiceManager jPInvoiceManager = this.f37319i;
        if (jPInvoiceManager != null) {
            jPInvoiceManager.onStop();
        }
    }

    public void onDestroyView() {
        super.onDestroyView();
        InvoiceFragmentDialog invoiceFragmentDialog = this.f37326p;
        if (invoiceFragmentDialog != null) {
            invoiceFragmentDialog.dismiss();
        }
        IRideHistoryManager iRideHistoryManager = this.f37331u;
        if (iRideHistoryManager != null) {
            iRideHistoryManager.exitHistory();
        }
        IFoodHistoryManager iFoodHistoryManager = this.f37330t;
        if (iFoodHistoryManager != null) {
            iFoodHistoryManager.exitHistory();
        }
        IBikeHistoryManager iBikeHistoryManager = this.f37332v;
        if (iBikeHistoryManager != null) {
            iBikeHistoryManager.exitHistory();
        }
        View view = this.f37306C;
        if (!(view == null || view.getParent() == null)) {
            ((ViewGroup) this.f37306C.getParent()).removeView(this.f37306C);
        }
        HistoryRecordStore.getInstance().removeReceiver(this);
    }

    /* renamed from: a */
    private void m26495a() {
        this.f37305B = 0;
        this.f37320j = false;
        this.f37334x = null;
        this.f37329s.clear();
    }

    /* renamed from: a */
    private void m26498a(View view) {
        view.setFocusableInTouchMode(true);
        view.requestFocus();
        view.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (i != 4) {
                    return false;
                }
                HistoryRecordFragment.this.m26537i();
                return true;
            }
        });
    }

    /* access modifiers changed from: protected */
    public void initTitlebar() {
        GlobalTitleBar2 globalTitleBar2 = (GlobalTitleBar2) this.f37306C.findViewById(R.id.history_record_title_bar);
        this.titleBar = globalTitleBar2;
        globalTitleBar2.setTitle(m26556w());
        m26549p();
        this.titleBar.setLeftImage(ContextCompat.getDrawable(this.f37313b, R.drawable.webview_common_title_bar_btn_close_selector), (View.OnClickListener) new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean unused = HistoryRecordFragment.this.f37320j = true;
                HistoryRecordFragment.this.m26537i();
            }
        });
        m26552s();
        this.titleBar.setRightClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("pas_mytrip_invoice_ck");
                List<AbsHistoryOrder> finishedOrderList = HistoryRecordFragment.this.m26555v().getFinishedOrderList();
                if (!CollectionUtils.isEmpty((Collection<?>) finishedOrderList)) {
                    List a = HistoryRecordFragment.this.m26513b(finishedOrderList);
                    if (!CollectionUtils.isNotEmpty((Collection<?>) a)) {
                        return;
                    }
                    if (a.size() > 1) {
                        HistoryRecordFragment.this.m26506a((List<HistoryOrderCountryModel>) a);
                        return;
                    }
                    HistoryOrderCountryModel historyOrderCountryModel = (HistoryOrderCountryModel) a.get(0);
                    HistoryRecordFragment.this.m26504a(new PopupSelectModel(historyOrderCountryModel.getCountryCode(), historyOrderCountryModel.getCountryName(), historyOrderCountryModel.getInvoiceUrl(), historyOrderCountryModel.getInvoiceType()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26504a(PopupSelectModel popupSelectModel) {
        this.f37310G = popupSelectModel.f38171id;
        if (!popupSelectModel.isNeedGoToH5()) {
            m26518b(popupSelectModel.f38171id);
        } else if (TextUtils.isEmpty(popupSelectModel.invoiceUrl)) {
            OmegaSDK.trackError("enterInvoiceMode", new Throwable("invoiceUrl 为空"));
            m26518b(popupSelectModel.f38171id);
        } else {
            m26522c(popupSelectModel.invoiceUrl);
        }
    }

    /* renamed from: a */
    private void m26507a(boolean z) {
        HashMap hashMap = new HashMap();
        if (z) {
            hashMap.put("content", "single");
        } else {
            hashMap.put("content", "mutiple");
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_sw", (Map<String, Object>) hashMap);
    }

    /* renamed from: b */
    private void m26514b() {
        List<HistoryListFragmentModel> list = this.f37329s;
        if (list == null || list.size() < 2) {
            m26507a(false);
            return;
        }
        m26507a(true);
        int i = 0;
        while (i < this.f37329s.size()) {
            TabLayout.Tab text = this.f37336z.newTab().setCustomView((int) R.layout.history_tab_item_layout).setText((CharSequence) m26493a(this.f37329s.get(i).type));
            this.f37336z.addTab(text);
            m26508a(i == 0, text);
            i++;
        }
        this.f37333w.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(this.f37336z));
        this.f37336z.setOnTabSelectedListener((TabLayout.OnTabSelectedListener) new TabLayout.OnTabSelectedListener() {
            public void onTabReselected(TabLayout.Tab tab) {
            }

            public void onTabSelected(TabLayout.Tab tab) {
                HistoryOmegaUtils.sendTabClick(HistoryRecordFragment.this.f37305B, tab.getPosition(), HistoryRecordFragment.this.f37329s);
                int unused = HistoryRecordFragment.this.f37305B = tab.getPosition();
                HistoryRecordFragment.this.m26508a(true, tab);
                HistoryRecordFragment.this.f37333w.setCurrentItem(tab.getPosition());
                HistoryRecordFragment.this.m26552s();
            }

            public void onTabUnselected(TabLayout.Tab tab) {
                HistoryRecordFragment.this.m26508a(false, tab);
            }
        });
    }

    /* renamed from: a */
    private String m26493a(String str) {
        if (!TextUtils.isEmpty(str)) {
            if ("ride".equals(str)) {
                return getString(R.string.history_tab_title_ride);
            }
            if (BusinessConstants.TYPE_BIKE.equals(str)) {
                return getString(R.string.history_tab_title_bike);
            }
            if ("soda".equals(str)) {
                return getString(R.string.history_tab_title_food);
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26508a(boolean z, TabLayout.Tab tab) {
        View customView = tab.getCustomView();
        TextView textView = (TextView) customView.findViewById(R.id.tab_title);
        textView.setText(tab.getText());
        View findViewById = customView.findViewById(R.id.tab_line);
        findViewById.setBackgroundColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.caution_color));
        if (z) {
            textView.setTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.caution_color));
            findViewById.setVisibility(0);
            return;
        }
        textView.setTextColor(getResources().getColor(R.color.history_tab_item_nor));
        findViewById.setVisibility(8);
    }

    /* renamed from: b */
    private void m26518b(String str) {
        if (!this.f37321k) {
            HistoryListFragment v = m26555v();
            if (v != null) {
                OmegaSDKAdapter.trackEvent("pas_mytrip_invoice_ck");
                this.f37321k = true;
                m26519b(false);
                this.titleBar.setRightText(getResources().getString(R.string.cancel));
                v.openInvoiceMode(str);
                m26528e();
                m26496a(0);
                m26524d();
                if (this.f37335y.getVisibility() == 0) {
                    this.f37307D = true;
                } else {
                    this.f37307D = false;
                }
                this.f37335y.setVisibility(8);
                this.f37333w.setScrollable(false);
                return;
            }
            return;
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_cancel_ck");
        m26520c();
    }

    /* renamed from: c */
    private void m26522c(String str) {
        WebViewModel webViewModel = new WebViewModel();
        webViewModel.isSupportCache = true;
        webViewModel.url = str;
        webViewModel.title = getString(R.string.history_record_web_title);
        Intent intent = new Intent(this.f37313b, BaseWebActivity.class);
        intent.putExtra("web_view_model", webViewModel);
        this.f37313b.startActivity(intent);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m26520c() {
        this.f37321k = false;
        this.titleBar.setRightText(getResources().getString(R.string.history_record_title_bill));
        if (this.f37307D) {
            this.f37307D = false;
            this.f37335y.setVisibility(0);
            this.f37333w.setScrollable(true);
        }
        HistoryListFragment v = m26555v();
        if (v != null) {
            v.closeInvoiceMode();
        }
        m26534g();
        m26524d();
    }

    /* renamed from: d */
    private void m26524d() {
        if (m26555v() != null) {
            m26555v().updatePinnedHeader();
        }
    }

    /* renamed from: b */
    private void m26519b(boolean z) {
        if (m26555v() != null && m26555v().getFinishedOrderList() != null) {
            for (AbsHistoryOrder next : m26555v().getFinishedOrderList()) {
                if (next instanceof HistoryOrder) {
                    ((HistoryOrder) next).setInvoiceSelected(z);
                }
            }
        }
    }

    /* renamed from: e */
    private void m26528e() {
        this.f37324n = this.f37306C.findViewById(R.id.voice_tip);
        this.f37325o = this.f37306C.findViewById(R.id.navi_bar_shadow);
        this.f37322l = (TextView) this.f37324n.findViewById(R.id.send);
        this.f37323m = (TextView) this.f37324n.findViewById(R.id.tip);
        m26534g();
        this.f37322l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                OmegaSDKAdapter.trackEvent("pas_mytrip_email_ck");
                HistoryRecordFragment.this.m26535h();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m26530f() {
        this.f37324n.setVisibility(0);
        this.f37325o.setVisibility(0);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m26534g() {
        this.f37324n.setVisibility(8);
        this.f37325o.setVisibility(8);
        if (m26555v() != null) {
            m26555v().setMarginBottom(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m26506a(List<HistoryOrderCountryModel> list) {
        this.f37308E.setTitle(getContext().getString(R.string.history_country_select_view_title));
        this.f37308E.setContent(getContext().getString(R.string.history_country_select_view_content));
        final ArrayList arrayList = new ArrayList();
        for (HistoryOrderCountryModel next : list) {
            arrayList.add(new PopupSelectModel(next.getCountryCode(), next.getCountryName(), next.getInvoiceUrl(), next.getInvoiceType()));
        }
        this.f37308E.setItems(arrayList);
        this.f37308E.setOnPopupSelectListClickListener(new PopupSelectView.OnPopupSelectListClickListener() {
            public void onItemClick(int i) {
                HistoryRecordFragment.this.m26504a((PopupSelectModel) arrayList.get(i));
                HistoryRecordFragment.this.f37308E.dismissAllowingStateLoss();
            }

            public void onCloseButtonClick() {
                HistoryRecordFragment.this.f37308E.dismissAllowingStateLoss();
            }
        });
        if (this.f37308E != null && getFragmentManager() != null) {
            this.f37308E.show(getFragmentManager(), "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public List<HistoryOrderCountryModel> m26513b(List<AbsHistoryOrder> list) {
        ArrayList arrayList = new ArrayList();
        if (list != null && list.size() > 0) {
            for (AbsHistoryOrder next : list) {
                String countryCode = next.getExtraData().getCountryCode();
                if (!TextUtils.isEmpty(countryCode)) {
                    HistoryOrderCountryModel historyOrderCountryModel = new HistoryOrderCountryModel();
                    historyOrderCountryModel.setCountryCode(countryCode);
                    historyOrderCountryModel.setInvoiceUrl(next.getExtraData().getInvoiceUrl());
                    historyOrderCountryModel.setInvoiceType(next.getExtraData().getInvoiceType());
                    String countryName = next.getExtraData().getCountryName();
                    if (TextUtils.isEmpty(countryName)) {
                        historyOrderCountryModel.setCountryName(m26492a(getContext(), countryCode));
                    } else {
                        historyOrderCountryModel.setCountryName(countryName);
                    }
                    if (!arrayList.contains(historyOrderCountryModel) && !(next.getProductId() == 378 && next.getExtraData().getIsOfflinePay() == 1)) {
                        arrayList.add(historyOrderCountryModel);
                    }
                }
            }
        }
        return arrayList;
    }

    /* renamed from: a */
    private String m26492a(Context context, String str) {
        if (context != null) {
            if ("AU".equals(str)) {
                return context.getResources().getString(R.string.country_name_au);
            }
            if ("BR".equals(str)) {
                return context.getResources().getString(R.string.country_name_br);
            }
            if (COUNTRY_CODE_CL.equals(str)) {
                return context.getResources().getString(R.string.country_name_cl);
            }
            if (COUNTRY_CODE_CO.equals(str)) {
                return context.getResources().getString(R.string.country_name_co);
            }
            if (COUNTRY_CODE_CR.equals(str)) {
                return context.getResources().getString(R.string.country_name_cr);
            }
            if ("JP".equals(str)) {
                return context.getResources().getString(R.string.country_name_jp);
            }
            if ("MX".equals(str)) {
                return context.getResources().getString(R.string.country_name_mx);
            }
            if (COUNTRY_CODE_PA.equals(str)) {
                return context.getResources().getString(R.string.country_name_pa);
            }
            if (COUNTRY_CODE_PE.equals(str)) {
                return context.getResources().getString(R.string.country_name_pe);
            }
            if (COUNTRY_CODE_AR.equals(str)) {
                return context.getResources().getString(R.string.country_name_ar);
            }
            if (COUNTRY_CODE_DO.equals(str)) {
                return context.getResources().getString(R.string.country_name_do);
            }
            if (COUNTRY_CODE_PR.equals(str)) {
                return context.getResources().getString(R.string.country_name_pr);
            }
        }
        return "";
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m26535h() {
        this.f37328r.clear();
        for (AbsHistoryOrder next : m26555v().getFinishedOrderList()) {
            if (next instanceof HistoryOrder) {
                HistoryOrder historyOrder = (HistoryOrder) next;
                if (historyOrder.isInvoiceSelected()) {
                    InvoiceOrder invoiceOrder = new InvoiceOrder();
                    invoiceOrder.order = historyOrder.getOrder();
                    invoiceOrder.productid = historyOrder.getProductId();
                    invoiceOrder.countryCode = historyOrder.getExtraData().getCountryCode();
                    this.f37328r.add(invoiceOrder);
                }
            }
        }
        HashMap hashMap = new HashMap();
        try {
            hashMap.put("orderid", Integer.valueOf(this.f37328r.size()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("pas_mytrip_invoiceconfirm_ck", (Map<String, Object>) hashMap);
        if (this.f37328r.isEmpty()) {
            ToastHelper.showShortInfo(getContext(), getString(R.string.history_no_order));
            return;
        }
        if (this.f37319i == null) {
            this.f37319i = new JPInvoiceManager(this.f37313b, new JPInvoiceManager.ICallback() {
                public void showLoading() {
                    HistoryRecordFragment.this.showMaskLayerLoading();
                }

                public void onSuccess() {
                    ToastHelper.showShortCompleted(HistoryRecordFragment.this.f37313b, HistoryRecordFragment.this.f37313b.getString(R.string.history_email_send_ok));
                    HistoryRecordFragment.this.m26520c();
                }

                public void onFail() {
                    ToastHelper.showShortInfo(HistoryRecordFragment.this.f37313b, HistoryRecordFragment.this.f37313b.getString(R.string.history_email_send_fail));
                }

                public void hideLoading() {
                    HistoryRecordFragment.this.hideLoading();
                }
            }, 0);
        }
        this.f37319i.sendJPInvoice(getFragmentManager(), this.f37328r);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m26537i() {
        m26540j();
        EventBus.getDefault().post(new SidebarEvent(EventKeys.Sidebar.OPEN_SIDEBAR));
    }

    /* renamed from: j */
    private void m26540j() {
        getBusinessContext().getNavigation().popBackStack();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m26542k() {
        m26550q();
        getHistoryRecordByPage();
    }

    /* renamed from: l */
    private void m26543l() {
        if (!DomainConstants.DOMAIN_SUFFIX_RU.equalsIgnoreCase(DomainServiceManager.getInstance().getDomainSuffix(getContext()))) {
            this.f37330t = FoodHistoryManagerImpl.getFoodHistoryManager();
        }
        this.f37331u = RideHistoryManagerImpl.getRideHistoryManager();
        RideHistoryManagerImpl.getRideHistoryManager().setInoiceCountListener(this.f37311H);
        if (this.f37331u != null) {
            HistoryListFragmentModel historyListFragmentModel = new HistoryListFragmentModel();
            historyListFragmentModel.type = "ride";
            historyListFragmentModel.historyListFragment = m26523d("ride");
            this.f37329s.add(historyListFragmentModel);
        }
        if (this.f37330t != null) {
            HistoryListFragmentModel historyListFragmentModel2 = new HistoryListFragmentModel();
            historyListFragmentModel2.type = "soda";
            historyListFragmentModel2.historyListFragment = m26523d("soda");
            this.f37329s.add(historyListFragmentModel2);
        }
        if (this.f37332v != null) {
            HistoryListFragmentModel historyListFragmentModel3 = new HistoryListFragmentModel();
            historyListFragmentModel3.type = BusinessConstants.TYPE_BIKE;
            historyListFragmentModel3.historyListFragment = m26523d(BusinessConstants.TYPE_BIKE);
            this.f37329s.add(historyListFragmentModel3);
        }
    }

    /* renamed from: d */
    private HistoryListFragment m26523d(String str) {
        HistoryListFragment historyListFragment = new HistoryListFragment();
        historyListFragment.setHistoryFragment(this);
        historyListFragment.setType(str);
        return historyListFragment;
    }

    /* access modifiers changed from: protected */
    public void getHistoryRecordByPage() {
        if (m26555v() != null) {
            m26555v().showFooterButton(true);
        }
        this.f37304A = true;
        for (HistoryListFragmentModel historyListFragmentModel : this.f37329s) {
            getHistoryRecordByPage(historyListFragmentModel.type);
        }
    }

    /* access modifiers changed from: protected */
    public void getHistoryRecordByPage(String str) {
        if (m26555v() != null) {
            m26555v().showFooterButton(false);
        }
        if ("ride".equals(str)) {
            m26545m();
        } else if ("soda".equals(str)) {
            m26547n();
        } else if (BusinessConstants.TYPE_BIKE.equals(str)) {
            m26548o();
        }
        HistoryListFragmentModel e = m26527e(str);
        if (e != null) {
            e.requesting = true;
        }
    }

    /* renamed from: m */
    private void m26545m() {
        Map<String, Object> map;
        if (isAllBusinessNetworkFinish()) {
            boolean z = true;
            HistoryListFragmentModel e = m26527e("ride");
            if (e == null || e.historyListFragment == null) {
                map = null;
            } else {
                Map<String, Object> map2 = e.historyListFragment.params;
                boolean z2 = e.historyListFragment.mIsMoreHistoryRecords;
                map = map2;
                z = z2;
            }
            if (z) {
                this.f37331u.getHistoryDate(getContext(), map, (HistoryRequestCallBack) null);
            }
        }
    }

    /* renamed from: n */
    private void m26547n() {
        String str;
        HistoryListFragmentModel e = m26527e("soda");
        int i = 0;
        if (e == null || e.historyListFragment == null) {
            str = "";
        } else {
            str = e.historyListFragment.mTimeMode;
            boolean z = true;
            if (e.historyListFragment.mSodaOrder != null && e.historyListFragment.mSodaOrder.getHavenext() == 0) {
                z = false;
            }
            if (!z) {
                e.historyListFragment.mSodaPage = 0;
            }
            i = e.historyListFragment.mSodaPage;
        }
        if (this.f37330t != null) {
            HashMap hashMap = new HashMap();
            hashMap.put("timeMode", str);
            hashMap.put("pageNum", Integer.valueOf(i));
            this.f37330t.getHistoryDate(getContext(), hashMap, new HistoryRequestCallBack<FoodHistoryOrder>() {
                public void onSuccess(HistoryOrdersResponse<FoodHistoryOrder> historyOrdersResponse) {
                    if (historyOrdersResponse.errno == 0) {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(historyOrdersResponse));
                    } else {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                    }
                }

                public void onFailure(int i) {
                    HistoryOrdersResponse historyOrdersResponse = new HistoryOrdersResponse();
                    historyOrdersResponse.errno = i;
                    HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                }
            });
        }
    }

    /* renamed from: o */
    private void m26548o() {
        boolean z;
        HistoryListFragmentModel e = m26527e(BusinessConstants.TYPE_BIKE);
        if (e == null || e.historyListFragment == null) {
            z = true;
        } else {
            int i = e.historyListFragment.mPage;
            z = e.historyListFragment.mIsMoreHistoryRecords;
        }
        IBikeHistoryManager iBikeHistoryManager = this.f37332v;
        if (iBikeHistoryManager != null && z) {
            iBikeHistoryManager.getHistoryDate(getContext(), (Map<String, Object>) null, new HistoryRequestCallBack<BikeHistoryOrder>() {
                public void onSuccess(HistoryOrdersResponse<BikeHistoryOrder> historyOrdersResponse) {
                    if (historyOrdersResponse.errno == 0) {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getSuccessMessage(historyOrdersResponse));
                    } else {
                        HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                    }
                }

                public void onFailure(int i) {
                    HistoryOrdersResponse historyOrdersResponse = new HistoryOrdersResponse();
                    historyOrdersResponse.errno = i;
                    HistoryRecordStore.getInstance().dispatch(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS, CommonDispatchMessage.getErrorMessage(historyOrdersResponse));
                }
            });
        }
    }

    /* renamed from: p */
    private void m26549p() {
        this.titleBar.setRightText(getResources().getString(R.string.history_record_title_bill));
        this.titleBar.setRightTextColor(Color.parseColor("#FF8040"));
    }

    /* renamed from: q */
    private void m26550q() {
        showMaskLayerLoading();
    }

    /* renamed from: r */
    private void m26551r() {
        hideLoading();
    }

    /* access modifiers changed from: protected */
    public void setRefreshBtnStyle() {
        this.tryAginBtn.setTextColor(-42211);
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m26552s() {
        IHistoryManager g;
        List<AbsHistoryOrder> finishedOrderList;
        boolean z;
        HistoryListFragment v = m26555v();
        int i = 8;
        if (v == null || (g = m26532g(v.getType())) == null || !g.isSupportInvoice() || (finishedOrderList = v.getFinishedOrderList()) == null || finishedOrderList.size() <= 0) {
            this.titleBar.getRightTextView().setVisibility(8);
            return;
        }
        Iterator<AbsHistoryOrder> it = finishedOrderList.iterator();
        while (true) {
            if (it.hasNext()) {
                if (HistoryUtils.canInvoice(it.next())) {
                    z = true;
                    break;
                }
            } else {
                z = false;
                break;
            }
        }
        TextView rightTextView = this.titleBar.getRightTextView();
        if (z) {
            i = 0;
        }
        rightTextView.setVisibility(i);
    }

    /* renamed from: a */
    private void m26509a(boolean z, boolean z2, HistoryOrdersResponse historyOrdersResponse) {
        if (this.f37316f == null) {
            View inflate = this.f37315e.inflate();
            this.f37316f = inflate;
            this.f37317g = inflate.findViewById(R.id.go_call_car_tv);
            this.f37318h = (TextView) this.f37316f.findViewById(R.id.no_record_text);
            this.tryAginBtn = (Button) this.f37316f.findViewById(R.id.try_agin_btn);
            setRefreshBtnStyle();
        }
        this.f37316f.setVisibility(0);
        if (z2) {
            this.f37318h.setText(R.string.history_record_no_record);
            this.f37317g.setVisibility(0);
            this.f37316f.setOnClickListener((View.OnClickListener) null);
            this.tryAginBtn.setVisibility(8);
        } else {
            if (z) {
                this.f37318h.setText(R.string.history_record_faild);
            } else if (historyOrdersResponse != null) {
                this.f37318h.setText(historyOrdersResponse.errmsg);
            }
            this.f37317g.setVisibility(8);
            this.tryAginBtn.setVisibility(0);
            Button button = this.tryAginBtn;
            if (button != null) {
                button.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        HistoryRecordFragment.this.m26542k();
                    }
                });
            }
        }
        if (m26555v() != null) {
            m26555v().showHistoryList(false);
        }
    }

    /* renamed from: a */
    private void m26503a(HistoryOrdersResponse historyOrdersResponse, String str) {
        HistoryListFragmentModel e = m26527e(str);
        if (e != null && e.historyListFragment != null) {
            e.historyListFragment.showHistoryRecords(historyOrdersResponse);
        }
    }

    /* renamed from: a */
    private void m26499a(HistoryListFragment historyListFragment) {
        if (historyListFragment != null) {
            historyListFragment.setAutoLoadOnBottom(false);
            historyListFragment.showFooterButton(true);
        }
    }

    @EventReceiver
    public void onReceive(DefaultEvent defaultEvent) {
        if (defaultEvent != null) {
            int identifier = getResources().getIdentifier("status_bar_height", "dimen", "android");
            if (identifier > 0) {
                int dimensionPixelSize = getResources().getDimensionPixelSize(identifier);
                SystemUtils.log(6, "page-empty", "statusBarHeight = " + dimensionPixelSize, (Throwable) null, "com.didi.sdk.sidebar.history.HistoryRecordFragment", 1003);
            }
            Message EventToMsg = MsgAndEventUtil.EventToMsg(defaultEvent);
            String type = defaultEvent.getType();
            char c = 65535;
            switch (type.hashCode()) {
                case -2003198504:
                    if (type.equals(HistoryRecordStore.ACTION_GET_SODA_HISTORY_RECORDS)) {
                        c = 1;
                        break;
                    }
                    break;
                case -142557728:
                    if (type.equals(HistoryRecordStore.ACTION_GET_BIKE_HISTORY_RECORDS)) {
                        c = 2;
                        break;
                    }
                    break;
                case 759799346:
                    if (type.equals(HistoryRecordStore.ACTION_CLOSE_HISTORY_RECORDS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 805353488:
                    if (type.equals(HistoryRecordStore.ACTION_GET_HISTORY_RECORDS)) {
                        c = 0;
                        break;
                    }
                    break;
                case 1769327041:
                    if (type.equals(HistoryRecordStore.ACTION_DELETE_HISTORY_RECORDS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2006598232:
                    if (type.equals(HistoryRecordStore.ACTION_SHOW_LOADING)) {
                        c = 5;
                        break;
                    }
                    break;
            }
            if (c == 0) {
                m26505a("ride", EventToMsg);
            } else if (c == 1) {
                m26505a("soda", EventToMsg);
            } else if (c == 2) {
                m26505a(BusinessConstants.TYPE_BIKE, EventToMsg);
            } else if (c != 3) {
                if (c == 4) {
                    m26540j();
                } else if (c == 5) {
                    showLoading();
                }
            } else if (!this.f37320j) {
                m26497a(EventToMsg);
            } else {
                return;
            }
            if (this.f37321k) {
                this.titleBar.setRightText(getResources().getString(R.string.cancel));
            }
            m26552s();
        }
    }

    /* renamed from: t */
    private void m26553t() {
        int i;
        String string = getArguments().getString("groupType", "");
        if (!TextUtils.isEmpty(string)) {
            List<HistoryListFragmentModel> list = this.f37329s;
            if (list != null && list.size() > 0) {
                i = 0;
                while (true) {
                    if (i >= this.f37329s.size()) {
                        break;
                    } else if (string.equals(this.f37329s.get(i).type)) {
                        break;
                    } else {
                        i++;
                    }
                }
            }
            i = -1;
            if (i != -1) {
                this.f37333w.setCurrentItem(i);
            }
        }
    }

    /* renamed from: a */
    private void m26505a(String str, Message message) {
        if (this.f37320j) {
            return;
        }
        if ((message.obj instanceof HistoryOrdersResponse) || message.obj == null) {
            HistoryOrdersResponse historyOrdersResponse = (HistoryOrdersResponse) message.obj;
            if (!m26511a(historyOrdersResponse) || !this.f37304A || "ride".equals(str)) {
                HistoryListFragmentModel e = m26527e(str);
                if (e != null) {
                    e.requesting = false;
                    e.response = (HistoryOrdersResponse) message.obj;
                    e.responseType = message.what;
                }
            } else {
                m26531f(str);
            }
            if (m26554u()) {
                if (this.f37304A) {
                    List<HistoryListFragmentModel> list = this.f37329s;
                    if (list == null || list.size() <= 1) {
                        this.f37335y.setVisibility(8);
                        this.f37333w.setScrollable(false);
                        this.titleBar.setTitleBarLineVisible(0);
                        m26507a(false);
                    } else {
                        this.f37335y.setVisibility(0);
                        this.f37333w.setScrollable(true);
                        m26514b();
                        this.titleBar.setTitleBarLineVisible(8);
                    }
                    HistoryListViewPagerAdapter historyListViewPagerAdapter = new HistoryListViewPagerAdapter(getChildFragmentManager(), this.f37329s);
                    this.f37334x = historyListViewPagerAdapter;
                    this.f37333w.setAdapter(historyListViewPagerAdapter);
                    m26553t();
                }
                for (HistoryListFragmentModel next : this.f37329s) {
                    if (next.responseType == 2) {
                        if (!this.f37304A) {
                            m26499a(next.historyListFragment);
                        }
                        HistoryOmegaUtils.sendTabError(historyOrdersResponse.errno, str);
                    } else if (next.responseType == 3) {
                        if (!this.f37304A) {
                            m26499a(next.historyListFragment);
                        }
                        if (next.historyListFragment == m26555v()) {
                            ToastHelper.showShortError((Context) getActivity(), (int) R.string.history_record_faild);
                        }
                    } else if (next.responseType == 1) {
                        m26503a(next.response, next.type);
                    }
                }
                m26549p();
                m26551r();
                this.f37304A = false;
                List<HistoryListFragmentModel> list2 = this.f37329s;
                if (list2 != null && list2.size() > 0) {
                    HistoryOmegaUtils.sendTabShow(this.f37329s);
                }
            }
        }
    }

    /* renamed from: u */
    private boolean m26554u() {
        for (HistoryListFragmentModel historyListFragmentModel : this.f37329s) {
            if (historyListFragmentModel.requesting) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m26511a(HistoryOrdersResponse historyOrdersResponse) {
        if (historyOrdersResponse == null) {
            return true;
        }
        List waitingOrderList = historyOrdersResponse.getWaitingOrderList();
        List doneOrderList = historyOrdersResponse.getDoneOrderList();
        boolean z = waitingOrderList == null || waitingOrderList.size() == 0;
        boolean z2 = doneOrderList == null || doneOrderList.size() == 0;
        if (!z || !z2) {
            return false;
        }
        return true;
    }

    /* renamed from: a */
    private void m26497a(Message message) {
        m26549p();
        m26551r();
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                m26515b(message);
                return;
            } else if (i == 3) {
                if (getActivity() != null) {
                    ToastHelper.showShortError((Context) getActivity(), (int) R.string.history_record_faild);
                    return;
                }
                return;
            }
        } else if (getActivity() != null) {
            ToastHelper.showShortCompleted((Context) getActivity(), (int) R.string.history_record_delete_success);
        }
        HistoryListFragment v = m26555v();
        if (v != null) {
            v.removeItem();
            if (v.getOrderCount() <= 0) {
                m26509a(false, true, (HistoryOrdersResponse) null);
            }
        }
    }

    /* renamed from: b */
    private void m26515b(Message message) {
        if (message != null) {
            String str = null;
            if (message.obj instanceof BaseObject) {
                str = ((BaseObject) message.obj).getErrorMsg();
            }
            if (str != null && getActivity() != null) {
                ToastHelper.showShortError((Context) getActivity(), str);
            }
        }
    }

    public BusinessContext getBusinessContext() {
        return this.f37314c;
    }

    public void setBusinessContext(BusinessContext businessContext) {
        this.f37314c = businessContext;
    }

    public void onResume() {
        super.onResume();
        SystemUtils.log(3, TAG, "onResume", (Throwable) null, "com.didi.sdk.sidebar.history.HistoryRecordFragment", 1225);
        List<HistoryListFragmentModel> list = this.f37329s;
        if (list != null && list.size() > 0) {
            HistoryOmegaUtils.sendTabShow(this.f37329s);
        }
    }

    public View getFallbackView() {
        return this.titleBar.getContentView();
    }

    public class HistoryListFragmentModel {
        public HistoryListFragment historyListFragment;
        public boolean requesting;
        public HistoryOrdersResponse response;
        public int responseType;
        public String type;

        public HistoryListFragmentModel() {
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: v */
    public HistoryListFragment m26555v() {
        int i;
        List<HistoryListFragmentModel> list = this.f37329s;
        if (list == null || list.size() <= (i = this.f37305B)) {
            return null;
        }
        return this.f37329s.get(i).historyListFragment;
    }

    /* renamed from: e */
    private HistoryListFragmentModel m26527e(String str) {
        List<HistoryListFragmentModel> list;
        if (TextUtils.isEmpty(str) || (list = this.f37329s) == null) {
            return null;
        }
        for (HistoryListFragmentModel next : list) {
            if (str.equals(next.type)) {
                return next;
            }
        }
        return null;
    }

    /* renamed from: f */
    private boolean m26531f(String str) {
        List<HistoryListFragmentModel> list;
        if (TextUtils.isEmpty(str) || (list = this.f37329s) == null) {
            return false;
        }
        for (HistoryListFragmentModel next : list) {
            if (str.equals(next.type)) {
                this.f37329s.remove(next);
                return true;
            }
        }
        return false;
    }

    /* renamed from: g */
    private IHistoryManager m26532g(String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        if ("ride".equals(str)) {
            return this.f37331u;
        }
        if ("soda".equals(str)) {
            return this.f37330t;
        }
        if (BusinessConstants.TYPE_BIKE.equals(str)) {
            return this.f37332v;
        }
        return null;
    }

    /* renamed from: w */
    private String m26556w() {
        return getString(R.string.history_record_title_bar);
    }
}

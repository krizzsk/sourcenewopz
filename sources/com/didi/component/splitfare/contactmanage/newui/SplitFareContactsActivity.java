package com.didi.component.splitfare.contactmanage.newui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.Utils;
import com.didi.component.common.dialog.GlobalCommonBottomPop;
import com.didi.component.common.util.ApkUtils;
import com.didi.component.common.util.CollectionUtils;
import com.didi.component.common.util.OnAntiShakeClickListener;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.component.splitfare.areacode.AreaCodeMandatoryGuideActivity;
import com.didi.component.splitfare.contactmanage.GlobalContactsCallback;
import com.didi.component.splitfare.contactmanage.GlobalContactsModel;
import com.didi.component.splitfare.contactmanage.GlobalContactsStore;
import com.didi.component.splitfare.contactmanage.IGlobalContactsStore;
import com.didi.component.splitfare.contactmanage.newui.SplitFareContactsAdapter;
import com.didi.component.splitfare.event.SplitFareEventTracker;
import com.didi.component.splitfare.model.SplitFareManager;
import com.didi.component.splitfare.model.UpdateSplitFarePartner;
import com.didi.global.globalgenerickit.drawer.GGKDrawer;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel2;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.reactive.tracker.Attrs;
import com.didi.safetoolkit.business.contacts.SimpleDividerDecoration;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.travel.psnger.common.net.base.ITravelOrderListener;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.travel.psnger.core.model.response.DTSDKOrderDetail;
import com.didi.travel.psnger.core.model.response.DTSDKSplitFareInfo;
import com.didi.travel.psnger.core.service.CoreHttpRequest;
import com.didi.travel.psnger.model.response.CarOrder;
import com.google.gson.Gson;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class SplitFareContactsActivity extends AbsLoadingAppCompatActivity {

    /* renamed from: a */
    private static final String f15930a = "threshold";

    /* renamed from: q */
    private static final int f15931q = 4;

    /* renamed from: b */
    private ViewGroup f15932b;

    /* renamed from: c */
    private ViewGroup f15933c;

    /* renamed from: d */
    private TextView f15934d;

    /* renamed from: e */
    private TextView f15935e;

    /* renamed from: f */
    private RecyclerView f15936f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public EditText f15937g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public boolean f15938h;

    /* renamed from: i */
    private SfCommonTitleBar f15939i;

    /* renamed from: j */
    private GlobalContactsCallback f15940j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IGlobalContactsStore f15941k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SplitFareContactsAdapter f15942l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public CopyOnWriteArrayList<GlobalContactsModel> f15943m;

    /* renamed from: n */
    private boolean f15944n;

    /* renamed from: o */
    private TextView f15945o;

    /* renamed from: p */
    private PermissionToolsCompat f15946p;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f15947r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public GlobalContactsModel f15948s;

    /* renamed from: t */
    private boolean f15949t = true;

    /* renamed from: u */
    private boolean f15950u;

    /* renamed from: v */
    private GGKDrawer f15951v;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public LEGODrawer f15952w;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        this.f15946p = new PermissionToolsCompat(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.g_contacts_activity_layout_new_ui);
        findViews();
        setListener();
        m11653e();
        m11656f();
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SEARCH_VIEW_SW);
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f15932b = (ViewGroup) findViewById(R.id.no_permission_layout);
        this.f15934d = (TextView) findViewById(R.id.request_per_btn);
        ((TextView) findViewById(R.id.no_permission_main_title)).setText(String.format(getString(R.string.g_splitfare_contacts_cannot_access), new Object[]{ApkUtils.getAppName(this)}));
        this.f15935e = (TextView) findViewById(R.id.no_permission_sub_title);
        this.f15933c = (ViewGroup) findViewById(R.id.list_layout);
        this.f15939i = (SfCommonTitleBar) findViewById(R.id.share_title_bar);
        this.f15937g = (EditText) findViewById(R.id.search_et);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        this.f15936f = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f15936f.addItemDecoration(new SimpleDividerDecoration(this));
        this.f15937g.setHint(R.string.g_splitfare_contacts_search_hint);
        this.f15937g.setCursorVisible(true);
        TextView textView = (TextView) findViewById(R.id.share_bottom_btn);
        this.f15945o = textView;
        textView.setText(R.string.g_splitfare_contacts_send_btn_default);
        this.f15939i.setTitleText(getString(R.string.g_splitfare));
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11639a() {
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SENTREQUEST_BTN_CK);
        if (!CollectionUtils.isEmpty((Collection) this.f15943m)) {
            new SplitFareManager(this).startSplitFare(m11647b(), new ResponseListener<UpdateSplitFarePartner>() {
                public void onSuccess(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onSuccess(updateSplitFarePartner);
                    DTSDKOrderDetail dTSDKOrderDetail = updateSplitFarePartner.data.orderDetail;
                    if (dTSDKOrderDetail.isAvailable()) {
                        CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                    }
                    BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE);
                    SplitFareContactsActivity.this.finish();
                }

                public void onFail(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onFail(updateSplitFarePartner);
                    final List<UpdateSplitFarePartner.SplitFareFailGroup> list = updateSplitFarePartner.data.data;
                    if (!CollectionUtils.isEmpty((Collection) list)) {
                        int i = 0;
                        if (list.size() != 1 || list.get(0).contactList == null || list.get(0).contactList.size() <= 0) {
                            SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_FAIL_DLG_SW, new Attrs().attr("error_code", Integer.valueOf(updateSplitFarePartner.errno)));
                            StringBuilder sb = new StringBuilder();
                            while (i < list.size() - 1) {
                                sb.append(list.get(i).errmsg);
                                sb.append("\n");
                                i++;
                            }
                            sb.append(list.get(i).errmsg);
                            GlobalCommonBottomPop.BottomPopModel bottomPopModel = new GlobalCommonBottomPop.BottomPopModel();
                            bottomPopModel.title = updateSplitFarePartner.errmsg;
                            bottomPopModel.content = sb.toString();
                            bottomPopModel.positive = SplitFareContactsActivity.this.getString(R.string.car_me_known);
                            final GlobalCommonBottomPop globalCommonBottomPop = new GlobalCommonBottomPop(SplitFareContactsActivity.this, bottomPopModel);
                            globalCommonBottomPop.setCanceledOnTouchOutside(true);
                            globalCommonBottomPop.show();
                            globalCommonBottomPop.setBottomActionListener(new GlobalCommonBottomPop.GlobalBottomPopActionListener() {
                                public void onNegativeClick() {
                                }

                                public void onPositiveClick() {
                                    globalCommonBottomPop.dismiss();
                                    SplitFareContactsActivity.this.m11644a((List<UpdateSplitFarePartner.SplitFareFailGroup>) list);
                                }
                            });
                            return;
                        }
                        Intent intent = new Intent(SplitFareContactsActivity.this, AreaCodeMandatoryGuideActivity.class);
                        intent.putExtra(AreaCodeMandatoryGuideActivity.G_CONSTANT_MANAGER_KEY, list.get(0));
                        SplitFareContactsActivity.this.startActivityForResult(intent, 1);
                        return;
                    }
                    ToastHelper.showShortInfo((Context) SplitFareContactsActivity.this, updateSplitFarePartner.errmsg);
                }

                public void onError(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onError(updateSplitFarePartner);
                    ToastHelper.showShortInfo((Context) SplitFareContactsActivity.this, updateSplitFarePartner.errmsg);
                }

                public void onFinish(UpdateSplitFarePartner updateSplitFarePartner) {
                    super.onFinish(updateSplitFarePartner);
                    SplitFareContactsActivity.this.hideLoading();
                }
            });
            showLoading();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11644a(List<UpdateSplitFarePartner.SplitFareFailGroup> list) {
        for (UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup : list) {
            for (UpdateSplitFarePartner.SplitFareFailUser next : splitFareFailGroup.failUsers) {
                Iterator<GlobalContactsModel> it = this.f15943m.iterator();
                while (it.hasNext()) {
                    GlobalContactsModel next2 = it.next();
                    if (next2.phone.contains(next.originPhone)) {
                        this.f15943m.remove(next2);
                        next2.checked = false;
                        this.f15942l.updateSosContacts(next2);
                        this.f15942l.deleteSplitFareData(next2);
                        onSelectDateChanged(this.f15943m.size());
                    }
                }
            }
        }
    }

    /* renamed from: b */
    private Map<String, Object> m11647b() {
        HashMap hashMap = new HashMap();
        hashMap.put("order_id", CarOrderHelper.getOrder() == null ? "" : CarOrderHelper.getOrder().getOid());
        hashMap.put("users", new Gson().toJson((Object) this.f15943m));
        return hashMap;
    }

    public void onBackPressed() {
        m11649c();
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11649c() {
        if (this.f15937g.getText() != null && TextUtils.isEmpty(this.f15937g.getText().toString())) {
            this.f15947r = false;
        }
        if (this.f15947r) {
            this.f15937g.setText((CharSequence) null);
            this.f15937g.clearFocus();
            Utils.hideInputMethod(this, this.f15937g);
            this.f15942l.showDatas();
            this.f15947r = false;
            return;
        }
        finish();
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        C71312 r0 = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (view.getId() == R.id.share_bottom_btn) {
                    SplitFareContactsActivity.this.m11639a();
                } else if (view.getId() == R.id.request_per_btn) {
                    if (SplitFareContactsActivity.this.f15938h) {
                        SplitFareContactsActivity.this.gotoSystemPermissionPage();
                    } else {
                        SplitFareContactsActivity.this.m11656f();
                    }
                } else if (view.getId() == R.id.search_et) {
                    SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_SERCH_ET_CK);
                } else if (view.getId() == R.id.g_split_fare_guide_close) {
                    SplitFareContactsActivity.this.m11651d();
                }
            }
        };
        this.f15945o.setOnClickListener(r0);
        this.f15934d.setOnClickListener(r0);
        this.f15939i.setLeftBtnClickListener(new OnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                SplitFareContactsActivity.this.m11649c();
            }
        });
        this.f15937g.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                boolean unused = SplitFareContactsActivity.this.f15947r = true;
                final String obj = editable.toString();
                if (TextUtils.isEmpty(obj)) {
                    SplitFareContactsActivity.this.f15942l.showDatas();
                } else {
                    SplitFareContactsActivity.this.f15941k.getMatchList(obj, new GlobalContactsCallback() {
                        public void onFailed(String str) {
                        }

                        public void onSucceed(List<GlobalContactsModel> list) {
                            if (list.size() == 0) {
                                GlobalContactsModel unused = SplitFareContactsActivity.this.f15948s = SplitFareContactsActivity.this.m11637a(obj, list);
                            } else {
                                boolean z = false;
                                Iterator<GlobalContactsModel> it = list.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        if (it.next().phone.equals(obj)) {
                                            z = true;
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                if (!z) {
                                    GlobalContactsModel unused2 = SplitFareContactsActivity.this.f15948s = SplitFareContactsActivity.this.m11637a(obj, list);
                                }
                            }
                            SplitFareContactsActivity.this.findAddedContacts(list);
                            SplitFareContactsActivity.this.f15942l.updateSearchData(list);
                        }
                    });
                }
            }
        });
        this.f15937g.setOnClickListener(r0);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m11651d() {
        GlobalOmegaUtils.trackEvent("gp_split_search_tipcancel_ck");
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public GlobalContactsModel m11637a(String str, List<GlobalContactsModel> list) {
        if (!m11646a(str) && ((str.charAt(0) != '+' && str.charAt(0) != '+') || !m11646a(str.substring(1)))) {
            return null;
        }
        GlobalContactsModel globalContactsModel = new GlobalContactsModel();
        globalContactsModel.phone = str;
        list.add(globalContactsModel);
        return globalContactsModel;
    }

    /* renamed from: a */
    private boolean m11646a(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        for (int i = 0; i < str.length(); i++) {
            if (!Character.isDigit(str.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    /* access modifiers changed from: protected */
    public void gotoSystemPermissionPage() {
        this.f15946p.launchPermissionSettingPageOnThePhone(this);
        this.f15944n = true;
    }

    /* renamed from: e */
    private void m11653e() {
        CarOrderHelper.getOrder();
        this.f15941k = GlobalContactsStore.getInstance();
        SplitFareContactsAdapter splitFareContactsAdapter = new SplitFareContactsAdapter(m11657g());
        this.f15942l = splitFareContactsAdapter;
        this.f15936f.setAdapter(splitFareContactsAdapter);
        this.f15940j = new GlobalContactsCallback() {
            public void onSucceed(List<GlobalContactsModel> list) {
                SplitFareContactsActivity.this.hideLoading();
                if (!CollectionUtils.isEmpty((Collection) list)) {
                    SplitFareContactsActivity.this.findAddedContactsV2(list);
                    SplitFareContactsActivity.this.f15942l.addData(list);
                    for (GlobalContactsModel next : list) {
                        if (!next.canSelected) {
                            next.checked = true;
                            SplitFareContactsActivity.this.f15942l.addSplitFareData(next);
                        }
                    }
                    GlobalContactsModel globalContactsModel = new GlobalContactsModel();
                    if (CarOrderHelper.getOrder() != null) {
                        globalContactsModel.name = CarOrderHelper.getOrder().splitFareInfo.split_msg_content;
                    }
                    SplitFareContactsActivity.this.f15942l.addTipsData(globalContactsModel);
                }
            }

            public void onFailed(String str) {
                SplitFareContactsActivity.this.hideLoading();
            }
        };
        this.f15943m = new CopyOnWriteArrayList<>();
        this.f15942l.setListener(new SplitFareContactsAdapter.GlobalCheckedChangedListener() {
            public void onCheckedChanged(GlobalContactsModel globalContactsModel, boolean z) {
                SplitFareContactsActivity.this.f15937g.clearFocus();
                SplitFareContactsActivity splitFareContactsActivity = SplitFareContactsActivity.this;
                Utils.hideInputMethod(splitFareContactsActivity, splitFareContactsActivity.f15937g);
                if (!z) {
                    Iterator it = SplitFareContactsActivity.this.f15943m.iterator();
                    while (true) {
                        if (it.hasNext()) {
                            GlobalContactsModel globalContactsModel2 = (GlobalContactsModel) it.next();
                            if (globalContactsModel2 != null && globalContactsModel2.phone != null && globalContactsModel2.phone.equals(globalContactsModel.phone)) {
                                SplitFareContactsActivity.this.f15943m.remove(globalContactsModel);
                                break;
                            }
                        } else {
                            break;
                        }
                    }
                    SplitFareContactsActivity.this.f15942l.deleteSplitFareData(globalContactsModel);
                } else if (globalContactsModel.type == 2 && !globalContactsModel.canSelected) {
                    DTSDKSplitFareInfo.SplitUser findSplitUser = SplitFareContactsActivity.this.findSplitUser(globalContactsModel);
                    if (findSplitUser != null) {
                        SplitFareContactsActivity.this.m11643a(findSplitUser, globalContactsModel);
                    }
                } else if (globalContactsModel.type == 2) {
                    SplitFareContactsActivity.this.f15943m.add(globalContactsModel);
                    SplitFareContactsActivity.this.f15942l.updateSosContacts(globalContactsModel);
                } else {
                    SplitFareContactsActivity.this.f15943m.add(globalContactsModel);
                    SplitFareContactsActivity.this.f15942l.addSplitFareData(globalContactsModel);
                }
                SplitFareContactsActivity splitFareContactsActivity2 = SplitFareContactsActivity.this;
                splitFareContactsActivity2.onSelectDateChanged(splitFareContactsActivity2.f15943m.size());
            }

            public void onSearchContactsClick(boolean z) {
                SplitFareContactsActivity.this.f15937g.setText((CharSequence) null);
                SplitFareContactsActivity.this.f15937g.clearFocus();
                SplitFareContactsActivity splitFareContactsActivity = SplitFareContactsActivity.this;
                Utils.hideInputMethod(splitFareContactsActivity, splitFareContactsActivity.f15937g);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11643a(final DTSDKSplitFareInfo.SplitUser splitUser, final GlobalContactsModel globalContactsModel) {
        final CarOrder order = CarOrderHelper.getOrder();
        SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCELSB_BTN_CK);
        LEGODrawer lEGODrawer = this.f15952w;
        if (lEGODrawer == null || !(lEGODrawer == null || lEGODrawer.isShowing() || order == null)) {
            this.f15952w = LEGOUICreator.showDrawerTemplate(this, new LEGODrawerModel2(ResourcesHelper.getString(this, R.string.g_splitfare_owner_remove_user_title, splitUser.nick), new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.car_confirm), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCELSBYES_BTN_CK);
                    SplitFareContactsActivity.this.showLoading();
                    new SplitFareManager(SplitFareContactsActivity.this).deleteSplitFare(order, splitUser.pid, new ResponseListener<UpdateSplitFarePartner>() {
                        public void onSuccess(UpdateSplitFarePartner updateSplitFarePartner) {
                            SplitFareContactsActivity.this.hideLoading();
                            if (updateSplitFarePartner.data != null && updateSplitFarePartner.data.orderDetail != null) {
                                DTSDKOrderDetail dTSDKOrderDetail = updateSplitFarePartner.data.orderDetail;
                                if (dTSDKOrderDetail.isAvailable()) {
                                    CoreHttpRequest.doOrderDetailFetchSuccess(dTSDKOrderDetail, (ITravelOrderListener) null);
                                }
                                BaseEventPublisher.getPublisher().publish(BaseEventKeys.OnService.FARE_SUCCESS_UPDATE);
                                Iterator it = SplitFareContactsActivity.this.f15943m.iterator();
                                while (true) {
                                    if (it.hasNext()) {
                                        GlobalContactsModel globalContactsModel = (GlobalContactsModel) it.next();
                                        if (globalContactsModel != null && globalContactsModel.phone != null && globalContactsModel != null && globalContactsModel.phone.equals(globalContactsModel.phone)) {
                                            SplitFareContactsActivity.this.f15943m.remove(globalContactsModel);
                                            break;
                                        }
                                    } else {
                                        break;
                                    }
                                }
                                SplitFareContactsActivity.this.f15942l.deleteSplitFareData(globalContactsModel);
                            }
                        }

                        public void onError(UpdateSplitFarePartner updateSplitFarePartner) {
                            SplitFareContactsActivity.this.hideLoading();
                            ToastHelper.showShortInfo((Context) SplitFareContactsActivity.this, updateSplitFarePartner.errmsg);
                        }

                        public void onFail(UpdateSplitFarePartner updateSplitFarePartner) {
                            SplitFareContactsActivity.this.hideLoading();
                            ToastHelper.showShortInfo((Context) SplitFareContactsActivity.this, updateSplitFarePartner.errmsg);
                        }

                        public void onFinish(UpdateSplitFarePartner updateSplitFarePartner) {
                            super.onFinish(updateSplitFarePartner);
                        }
                    });
                    if (SplitFareContactsActivity.this.f15952w != null && SplitFareContactsActivity.this.f15952w.isShowing()) {
                        SplitFareContactsActivity.this.f15952w.dismiss();
                        LEGODrawer unused = SplitFareContactsActivity.this.f15952w = null;
                    }
                }
            }), new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.global_share_cancel_btn_text), new LEGOOnAntiShakeClickListener() {
                public void onAntiShakeClick(View view) {
                    SplitFareEventTracker.trackEvent(SplitFareEventTracker.EVENT_GP_SPLIT_CANCELSBNO_BTN_CK);
                    if (SplitFareContactsActivity.this.f15952w != null && SplitFareContactsActivity.this.f15952w.isShowing()) {
                        SplitFareContactsActivity.this.f15952w.dismiss();
                        LEGODrawer unused = SplitFareContactsActivity.this.f15952w = null;
                    }
                }
            })).setSubTitle(ResourcesHelper.getString(this, R.string.g_splitfare_owner_remove_user_sub_title)).setIsShowCloseImg(false).setClickOutsideCanCancel(false));
        }
    }

    public DTSDKSplitFareInfo.SplitUser findSplitUser(GlobalContactsModel globalContactsModel) {
        List<DTSDKSplitFareInfo.SplitUser> h = m11660h();
        if (h == null || h.size() <= 0) {
            return null;
        }
        for (DTSDKSplitFareInfo.SplitUser next : h) {
            if (!TextUtils.isEmpty(next.phone) && !TextUtils.isEmpty(globalContactsModel.phone)) {
                if (globalContactsModel.phone.contains(next.phone) || next.phone.contains(globalContactsModel.phone) || (globalContactsModel.phone.contains("+") && globalContactsModel.phone.length() >= 3 && next.phone.contains(globalContactsModel.phone.substring(3)))) {
                    return next;
                }
            }
        }
        return null;
    }

    public void findAddedContacts(List<GlobalContactsModel> list) {
        DTSDKSplitFareInfo.SplitUser next;
        List<DTSDKSplitFareInfo.SplitUser> h = m11660h();
        if (!CollectionUtils.isEmpty((Collection) h)) {
            for (GlobalContactsModel next2 : list) {
                Iterator<DTSDKSplitFareInfo.SplitUser> it = h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (TextUtils.isEmpty(next.phone) || TextUtils.isEmpty(next2.phone) || (!next2.phone.contains(next.phone) && !next.phone.contains(next2.phone) && (!next2.phone.contains("+") || next2.phone.length() < 3 || !next.phone.contains(next2.phone.substring(3))))) {
                        next2.canSelected = true;
                    }
                }
                next2.canSelected = false;
                GlobalContactsModel globalContactsModel = this.f15948s;
                if (globalContactsModel != null && globalContactsModel == next2 && !globalContactsModel.phone.equals(next.phone)) {
                    next2.canSelected = true;
                }
            }
        }
    }

    public void findAddedContactsV2(List<GlobalContactsModel> list) {
        DTSDKSplitFareInfo.SplitUser next;
        List<DTSDKSplitFareInfo.SplitUser> h = m11660h();
        if (!CollectionUtils.isEmpty((Collection) h)) {
            for (GlobalContactsModel next2 : list) {
                Iterator<DTSDKSplitFareInfo.SplitUser> it = h.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    next = it.next();
                    if (TextUtils.isEmpty(next.phone) || TextUtils.isEmpty(next2.phone) || (!next2.phone.contains(next.phone) && !next.phone.contains(next2.phone) && (!next2.phone.contains("+") || next2.phone.length() < 3 || !next.phone.contains(next2.phone.substring(3))))) {
                        next2.canSelected = true;
                    }
                }
                next2.canSelected = false;
                GlobalContactsModel globalContactsModel = this.f15948s;
                if (globalContactsModel != null && globalContactsModel == next2 && !globalContactsModel.phone.equals(next.phone)) {
                    next2.canSelected = true;
                }
            }
            if (h.size() > 1) {
                List<DTSDKSplitFareInfo.SplitUser> subList = h.subList(1, h.size());
                ArrayList arrayList = new ArrayList();
                boolean z = true;
                for (DTSDKSplitFareInfo.SplitUser next3 : subList) {
                    Iterator<GlobalContactsModel> it2 = list.iterator();
                    while (true) {
                        if (!it2.hasNext()) {
                            break;
                        }
                        GlobalContactsModel next4 = it2.next();
                        if (TextUtils.isEmpty(next3.phone) || TextUtils.isEmpty(next4.phone) || (!next4.phone.contains(next3.phone) && !next3.phone.contains(next4.phone) && (!next4.phone.contains("+") || next4.phone.length() < 3 || !next3.phone.contains(next4.phone.substring(3))))) {
                            if (!TextUtils.isEmpty(next3.phone)) {
                                z = false;
                            }
                        }
                    }
                    z = true;
                    if (!z) {
                        GlobalContactsModel globalContactsModel2 = new GlobalContactsModel();
                        globalContactsModel2.phone = next3.phone;
                        if (!TextUtils.isEmpty(next3.name)) {
                            globalContactsModel2.name = next3.name;
                        } else if (!TextUtils.isEmpty(next3.nick)) {
                            globalContactsModel2.name = next3.nick;
                        }
                        globalContactsModel2.canSelected = false;
                        globalContactsModel2.checked = true;
                        arrayList.add(globalContactsModel2);
                    }
                }
                list.addAll(arrayList);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m11656f() {
        this.f15946p.requestPermission(new PermissionCallback() {
            public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
                iPermissionRequest.proceed();
            }

            public void onGranted(List<AuthorizationInfo> list) {
                SplitFareContactsActivity.this.showContractList();
            }

            public void onRefuse(List<AuthorizationInfo> list) {
                AuthorizationInfo authorizationInfo;
                if (list != null && list.size() != 0 && (authorizationInfo = list.get(0)) != null) {
                    SplitFareContactsActivity.this.showNoPermissionPage(authorizationInfo.isDoNotAskAgain());
                }
            }
        }, Permission.READ_CONTACTS);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f15946p.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* renamed from: g */
    private int m11657g() {
        int i = 0;
        if (getIntent().getIntExtra("threshold", 0) != 0) {
            return getIntent().getIntExtra("threshold", 0);
        }
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null) {
            return 0;
        }
        if (!(order.splitFareInfo == null || order.splitFareInfo.split_user_list == null)) {
            i = order.splitFareInfo.split_user_list.size();
        }
        if (i != 0) {
            return order.passengerCount > 0 ? order.passengerCount - i : 4 - i;
        }
        if (order.passengerCount > 0) {
            return order.passengerCount - 1;
        }
        return 3;
    }

    /* renamed from: h */
    private List<DTSDKSplitFareInfo.SplitUser> m11660h() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order == null || order.splitFareInfo == null) {
            return null;
        }
        return CarOrderHelper.getOrder().splitFareInfo.split_user_list;
    }

    /* access modifiers changed from: protected */
    public void onResume() {
        super.onResume();
        if (this.f15944n) {
            m11656f();
            this.f15944n = false;
        }
    }

    /* access modifiers changed from: protected */
    public void showNoPermissionPage(boolean z) {
        this.f15938h = z;
        this.f15932b.setVisibility(0);
        this.f15933c.setVisibility(8);
        if (this.f15938h) {
            this.f15935e.setText(getString(R.string.g_splitfare_contacts_permissions));
            this.f15934d.setText(getString(R.string.g_splitfare_contacts_setting));
            return;
        }
        this.f15935e.setText(getString(R.string.g_splitfare_contacts_cannot_access_cont));
        this.f15934d.setText(getString(R.string.g_splitfare_contacts_use_phone_contacts));
    }

    /* access modifiers changed from: protected */
    public void showContractList() {
        this.f15932b.setVisibility(8);
        this.f15933c.setVisibility(0);
        showLoading();
        getDataList();
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f15941k.clearData();
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.f15941k.getSystemContacts(this.f15940j);
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            GlobalOmegaUtils.trackEvent("gp_split_search_request_sw");
            this.f15945o.setEnabled(true);
            this.f15945o.setText(String.format(getString(R.string.g_splitfare_contacts_send_btn_new), new Object[]{Integer.valueOf(i)}));
            this.f15950u = true;
            return;
        }
        this.f15945o.setEnabled(false);
        this.f15945o.setText(R.string.g_splitfare_contacts_send_btn_default);
    }

    public View getFallbackView() {
        return this.f15939i.getLoadingFallback();
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        ArrayList arrayList;
        String str;
        String str2;
        char c;
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 1 && (arrayList = (ArrayList) intent.getSerializableExtra("added_area_code_contacts")) != null && arrayList.size() != 0) {
            Iterator<GlobalContactsModel> it = this.f15943m.iterator();
            while (it.hasNext()) {
                GlobalContactsModel next = it.next();
                Iterator it2 = arrayList.iterator();
                while (true) {
                    str = "";
                    if (!it2.hasNext()) {
                        str2 = str;
                        c = 0;
                        break;
                    }
                    UpdateSplitFarePartner.AreaCodeUserInfo areaCodeUserInfo = (UpdateSplitFarePartner.AreaCodeUserInfo) it2.next();
                    if (!TextUtils.isEmpty(areaCodeUserInfo.phone) && !TextUtils.isEmpty(next.phone) && next.phone.contains(areaCodeUserInfo.originPhone)) {
                        int length = areaCodeUserInfo.phone.length();
                        if (areaCodeUserInfo.phone.contains("+") && length >= areaCodeUserInfo.countryCode.length()) {
                            String substring = areaCodeUserInfo.phone.substring(areaCodeUserInfo.countryCode.length());
                            if (substring.equals(next.phone)) {
                                areaCodeUserInfo.phone = substring;
                            }
                        }
                        if (areaCodeUserInfo.phone.length() > next.phone.length()) {
                            str = areaCodeUserInfo.phone;
                            str2 = areaCodeUserInfo.originPhone;
                            c = 1;
                        } else {
                            str = areaCodeUserInfo.phone;
                            str2 = areaCodeUserInfo.originPhone;
                            c = 2;
                        }
                    }
                }
                if (c == 1) {
                    next.checked = true;
                    next.phone = str;
                    next.originPhone = str2;
                    this.f15942l.updateSosContacts(next);
                } else if (c == 2) {
                    this.f15943m.remove(next);
                    next.checked = false;
                    next.originPhone = str2;
                    onSelectDateChanged(this.f15943m.size());
                    this.f15942l.updateSosContacts(next);
                }
            }
        }
    }
}

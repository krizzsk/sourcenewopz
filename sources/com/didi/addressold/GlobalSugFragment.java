package com.didi.addressold;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.address.AddressException;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.GlobalSugCallback;
import com.didi.address.ISugControlCallback;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.model.SugParams;
import com.didi.address.view.IPoiChangeListener;
import com.didi.address.view.ISugViewController;
import com.didi.addressold.delegate.SelectAddressByDraggedDelegate;
import com.didi.addressold.delegate.SoftKeyboardDelegate;
import com.didi.addressold.presenter.AddressPresenter;
import com.didi.addressold.util.AddressConvertUtil;
import com.didi.addressold.util.AddressTrack;
import com.didi.addressold.util.ApolloUtil;
import com.didi.addressold.util.CheckParamUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.LogUtils;
import com.didi.addressold.util.ViewUtils;
import com.didi.addressold.view.AddressAdapter;
import com.didi.addressold.view.CommonAddressActivity;
import com.didi.addressold.view.IAddressView;
import com.didi.addressold.view.ISearchViewCallback;
import com.didi.addressold.view.ISugContainerOpCallback;
import com.didi.addressold.view.ISugMapCtrlCallback;
import com.didi.addressold.view.SugListViewContainer;
import com.didi.addressold.view.SugSearchView;
import com.didi.addressold.widget.EditTextErasable;
import com.didi.addressold.widget.EmptyView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.model.Padding;
import com.didi.global.loading.app.AbsLoadingAppFragment;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class GlobalSugFragment extends AbsLoadingAppFragment implements IAddressView, ISearchViewCallback {
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;

    /* renamed from: a */
    private static final String f7711a = "GlobalSugFragment";

    /* renamed from: c */
    private static final String f7712c = "param";

    /* renamed from: A */
    private FrameLayout f7713A = null;

    /* renamed from: B */
    private EmptyView f7714B = null;

    /* renamed from: C */
    private boolean f7715C = true;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public AddressAdapter.OnItemSelectedListener f7716D = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi2 = rpcPoi;
            RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (GlobalSugFragment.this.f7733s == 1) {
                boolean unused = GlobalSugFragment.this.f7728n = true;
            }
            GlobalSugFragment.this.f7721g.addressParam.addressType = GlobalSugFragment.this.f7733s;
            int i3 = 2;
            int i4 = 3;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (GlobalSugFragment.this.f7733s == 1) {
                    if (GlobalSugFragment.this.f7737w) {
                        i3 = 3;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (GlobalSugFragment.this.f7733s == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                GlobalSugFragment.this.f7725k.getGeocodeResult(GlobalSugFragment.this.f7721g, rpcPoi, getSearchText(), trackParameterForChild, i, i2, GlobalSugFragment.this.f7733s);
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild);
            AddressTrack.trackAddressClick(GlobalSugFragment.this.f7721g, rpcPoi2.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, GlobalSugFragment.this.f7733s);
            if (GlobalSugFragment.this.f7733s == 3 || GlobalSugFragment.this.f7733s == 4) {
                GlobalSugFragment.this.f7718d.removeCommonWatcher(GlobalSugFragment.this.f7721g.addressParam);
                GlobalSugFragment.this.f7718d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                GlobalSugFragment.this.f7725k.setCommonAddress(GlobalSugFragment.this.f7721g, rpcPoi);
            } else {
                rpcPoi2.base_info.searchId = trackParameterForChild2.search_id;
                Address a = GlobalSugFragment.this.mo39505a(rpcPoi);
                if (!GlobalSugFragment.this.f7737w) {
                    i4 = 2;
                }
                a.operationType = i4;
                if (GlobalSugFragment.this.f7733s == 1) {
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7733s, a);
                    AddressTrack.trackRecItemSelect(i + 1);
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    GlobalSugFragment globalSugFragment2 = GlobalSugFragment.this;
                    globalSugFragment2.setResultBack(globalSugFragment2.f7733s, a);
                } else if (GlobalSugFragment.this.f7733s == 5) {
                    GlobalSugFragment.this.f7718d.removeCommonWatcher(GlobalSugFragment.this.f7721g.addressParam);
                    GlobalSugFragment.this.f7718d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                    GlobalSugFragment globalSugFragment3 = GlobalSugFragment.this;
                    globalSugFragment3.setResultBack(globalSugFragment3.f7733s, a);
                    AddressTrack.trackAddAddressItemClick();
                } else if (GlobalSugFragment.this.f7733s == 6) {
                    GlobalSugFragment globalSugFragment4 = GlobalSugFragment.this;
                    globalSugFragment4.setResultBack(globalSugFragment4.f7733s, a);
                }
            }
            GlobalSugFragment.this.f7725k.recordClickPoi(GlobalSugFragment.this.f7721g, rpcPoi2.base_info);
        }

        private String getSearchText() {
            if (GlobalSugFragment.this.f7733s == 1) {
                return GlobalSugFragment.this.f7718d.getStartEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f7733s == 2) {
                return GlobalSugFragment.this.f7718d.getEndEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f7733s == 3) {
                return GlobalSugFragment.this.f7718d.getCommonEditText().getText().toString();
            }
            return GlobalSugFragment.this.f7733s == 4 ? GlobalSugFragment.this.f7718d.getCommonEditText().getText().toString() : "";
        }
    };

    /* renamed from: b */
    private final int f7717b = 12;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SugSearchView f7718d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugListViewContainer f7719e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISugControlCallback f7720f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SugParams f7721g;

    /* renamed from: h */
    private Address f7722h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f7723i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f7724j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f7725k;

    /* renamed from: l */
    private Handler f7726l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f7727m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f7728n = true;

    /* renamed from: o */
    private boolean f7729o;

    /* renamed from: p */
    private boolean f7730p;

    /* renamed from: q */
    private boolean f7731q = true;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f7732r = 2;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public int f7733s = -1;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public SelectAddressByDraggedDelegate f7734t;

    /* renamed from: u */
    private SoftKeyboardDelegate f7735u;

    /* renamed from: v */
    private boolean f7736v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f7737w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f7738x = false;

    /* renamed from: y */
    private View.OnClickListener f7739y = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!GlobalSugFragment.this.f7734t.canSelectAddressByDragged()) {
                Address b = GlobalSugFragment.this.m4895h();
                b.operationType = 1;
                if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7721g.fromType) || CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f7721g.fromType)) {
                    GlobalSugFragment.this.setResultBack(1, b);
                    return;
                }
                GlobalSugFragment.this.m4908o();
                GlobalSugFragment.this.f7719e.scrollToTop();
                GlobalSugFragment.this.m4868a(2, "", false);
            } else if (!CommonUtils.isFromHomePage(GlobalSugFragment.this.f7721g.fromType) || GlobalSugFragment.this.f7733s != 1) {
                Address address = null;
                if (GlobalSugFragment.this.f7733s == 1) {
                    address = GlobalSugFragment.this.f7734t.getStartAddressByDragged();
                    GlobalSugFragment.this.f7718d.addWatcherForStart();
                    GlobalSugFragment.this.f7719e.setDragEnable(false);
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    address = GlobalSugFragment.this.f7734t.getEndAddressByDragged();
                    GlobalSugFragment.this.f7718d.addEndTextWatcher();
                    GlobalSugFragment.this.f7719e.setDragEnable(false);
                }
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7733s, address);
                    if (GlobalSugFragment.this.f7733s == 2) {
                        AddressTrack.trackSelectDestinationInMapConfirm(GlobalSugFragment.this.f7721g.addressParam, address, GlobalSugFragment.this.f7738x, true);
                    }
                }
            } else {
                GlobalSugFragment.this.m4908o();
                GlobalSugFragment.this.f7719e.scrollToTop();
                GlobalSugFragment.this.m4868a(2, "", false);
            }
        }
    };

    /* renamed from: z */
    private IPoiChangeListener f7740z = new IPoiChangeListener() {
        public void onPinLoading(double d, double d2) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.showLoading();
                GlobalSugFragment.this.f7719e.setConfirmBtnEnabled(false);
                Address address = new Address();
                address.latitude = d;
                address.longitude = d2;
                address.displayName = GlobalSugFragment.this.getString(R.string.global_sug_to_departure);
                address.operationType = 1;
                GlobalSugFragment.this.f7734t.onPinLoading(address);
                if (GlobalSugFragment.this.f7732r == 1) {
                    boolean unused = GlobalSugFragment.this.f7728n = false;
                    boolean unused2 = GlobalSugFragment.this.m4877a(address);
                }
            }
        }

        public void onPinPoiChanged(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f7719e.setConfirmBtnEnabled(true);
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment.this.f7734t.onPinPoiChanged(address);
                    if (GlobalSugFragment.this.f7732r == 1) {
                        boolean unused = GlobalSugFragment.this.f7728n = false;
                        boolean unused2 = GlobalSugFragment.this.m4877a(address);
                    } else if (GlobalSugFragment.this.f7732r == 2) {
                        Address unused3 = GlobalSugFragment.this.f7723i = address;
                    }
                }
            }
        }

        public void onPinFetchPoiFailed(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f7719e.setConfirmBtnEnabled(true);
                if (address != null) {
                    GlobalSugFragment.this.f7734t.onPinFetchPoiFailed(address);
                    address.operationType = 1;
                    if (GlobalSugFragment.this.f7732r == 1) {
                        boolean unused = GlobalSugFragment.this.f7728n = false;
                        boolean unused2 = GlobalSugFragment.this.m4877a(address);
                    } else if (GlobalSugFragment.this.f7732r == 2) {
                        Address unused3 = GlobalSugFragment.this.f7723i = address;
                    }
                }
            }
        }
    };

    public void onClearClick(int i) {
    }

    public void onHttpRequestSuccess() {
    }

    public void setSugTips(String str) {
    }

    public void showEmptyView() {
    }

    public void showHasCommonAddressButError() {
    }

    public void showToastError(String str, boolean z) {
    }

    public static GlobalSugFragment getInstance(SugParams sugParams) {
        GlobalSugFragment globalSugFragment = new GlobalSugFragment();
        Bundle bundle = new Bundle();
        bundle.putSerializable("param", sugParams);
        globalSugFragment.setArguments(bundle);
        return globalSugFragment;
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null) {
            this.f7721g = (SugParams) getArguments().getSerializable("param");
            AddressTrack.trackCheckAddressParam(activity.getApplicationContext(), this.f7721g.addressParam, this.f7721g.fromType);
            CheckParamUtil.rescueAddressParam(activity.getApplicationContext(), "GlobalSugFragment onAttach()", this.f7721g.addressParam);
            setCurrAddressType(this.f7721g.addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f7724j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f7721g;
            globalSugCallback.onAttach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f7721g.addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4865a();
    }

    /* renamed from: a */
    private void m4865a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, this.f7721g.usrType);
        this.f7725k = new AddressPresenter(getActivity(), this);
        this.f7729o = true;
        this.f7730p = false;
        ApolloUtil.initSugSearchInternalTime();
        this.f7734t = new SelectAddressByDraggedDelegate(this.f7721g.addressParam, this.f7721g.fromType);
        this.f7735u = new SoftKeyboardDelegate(getActivity(), this.f7721g.addressParam, this.f7721g.fromType);
        setCurrAddressType(this.f7721g.addressParam.addressType);
        this.f7726l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    GlobalSugFragment.this.m4868a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f7733s = i;
        SelectAddressByDraggedDelegate selectAddressByDraggedDelegate = this.f7734t;
        if (selectAddressByDraggedDelegate != null) {
            selectAddressByDraggedDelegate.setCurrAddressType(i);
        }
    }

    public void setSearchViewType(int i) {
        this.f7732r = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        int i3;
        Activity activity = getActivity();
        if (activity != null) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(activity, R.animator.old_poi_one_address_animate_exit);
            if (!z && loadAnimator != null && ((i3 = this.f7733s) == 1 || i3 == 2 || i3 == 6)) {
                return loadAnimator;
            }
        }
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.old_layout_sug_fragment, viewGroup, false);
        m4869a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m4869a(View view) {
        m4882b(view.findViewById(R.id.sug_close_btn));
        this.f7718d = (SugSearchView) view.findViewById(R.id.search_view);
        this.f7719e = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f7713A = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f7714B = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f7734t.setSugSearchView(this.f7718d);
        this.f7735u.hideOrShowSoftKeyboard(this.f7718d);
        this.f7735u.onCreateView();
        m4885c();
        m4881b();
        m4887d();
        m4889e();
    }

    /* renamed from: b */
    private void m4881b() {
        if (this.f7718d != null) {
            if (!CommonUtils.isFromSetting(this.f7721g.fromType) && !CommonUtils.isFromRouteEditor(this.f7721g.fromType)) {
                this.f7718d.addStatusBarHeightView();
            }
            this.f7718d.setSearchViewCallback(this);
            this.f7718d.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.getView());
                    if (GlobalSugFragment.this.f7724j != null) {
                        GlobalSugFragment.this.f7724j.onEnterWayPoint(GlobalSugFragment.this.m4895h(), GlobalSugFragment.this.f7723i);
                    }
                }
            });
            Address startPoiFromCache = this.f7725k.getStartPoiFromCache(this.f7721g.addressParam.targetAddress);
            if (startPoiFromCache != null && !TextUtils.isEmpty(startPoiFromCache.hideAddress)) {
                SystemUtils.log(3, f7711a, "set start poi info from cache --> Address startPoi:" + startPoiFromCache.toString(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 243);
                this.f7721g.addressParam.targetAddress = startPoiFromCache;
            }
            if (!this.f7731q && this.f7721g.fromType == FromType.HOME) {
                String string = getResources().getString(R.string.global_sug_current_location);
                this.f7721g.addressParam.targetAddress.address = string;
                this.f7721g.addressParam.targetAddress.displayName = string;
                this.f7721g.addressParam.targetAddress.fullName = string;
                this.f7725k.cacheStartPoiInfo(this.f7721g.addressParam.targetAddress);
            }
            this.f7718d.initSugSearchView(this.f7721g);
            if (CommonUtils.isFromHomePage(this.f7721g.fromType)) {
                m4917s();
            }
            this.f7718d.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    GlobalSugFragment.this.m4868a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(this.f7721g.fromType) || CommonUtils.isFromGetOnPage(this.f7721g.fromType)) && this.f7721g.addressParam.addressType == 1) {
                m4915r();
            }
            storeStartAddress(this.f7721g.addressParam);
            m4871a(this.f7721g);
            this.f7718d.setListener(this.f7721g);
            this.f7718d.makeStartTextFocusedWhenIsRed();
            this.f7718d.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7721g.fromType)) {
                        if (GlobalSugFragment.this.f7721g.addressParam.addressType == 1 && GlobalSugFragment.this.f7718d.isStartTextNeedScrollToBottomWhenFocused) {
                            GlobalSugFragment.this.m4902l();
                        }
                    } else if (CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f7721g.fromType) && GlobalSugFragment.this.f7721g.addressParam.addressType == 1) {
                        GlobalSugFragment.this.m4915r();
                        GlobalSugFragment.this.f7719e.scrollToTop();
                        GlobalSugFragment.this.f7718d.addWatcherForStart();
                        GlobalSugFragment.this.f7719e.setDragEnable(false);
                    }
                }
            });
            this.f7718d.postDelayed(new Runnable() {
                public void run() {
                    if (GlobalSugFragment.this.f7719e != null) {
                        GlobalSugFragment.this.f7719e.setTopPadding(GlobalSugFragment.this.f7718d.getMeasuredHeight());
                    }
                }
            }, 200);
        }
    }

    /* renamed from: a */
    private void m4871a(SugParams sugParams) {
        EditTextErasable endEditText;
        if ((sugParams.fromType != FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) && sugParams.addressParam.addressType == 2) {
            m4908o();
            if (sugParams.fromType == FromType.HOME && (endEditText = this.f7718d.getEndEditText()) != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (sugParams.fromType != FromType.ROUTE_EDITOR && sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR && sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR && sugParams.addressParam.addressType == 1) {
            m4907n();
        } else {
            m4905m();
            EditTextErasable commonEditText = this.f7718d.getCommonEditText();
            if (commonEditText != null) {
                commonEditText.setFocusable(true);
                commonEditText.sendAccessibilityEvent(128);
            }
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m4877a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f7733s;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4877a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 347);
        this.f7722h = address;
        if (address == null) {
            return false;
        }
        this.f7721g.addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m4885c() {
        this.f7719e.setOperCallback(new ISugMapCtrlCallback() {
            private boolean lastShow = false;

            public void onResetBtnClick() {
                if (GlobalSugFragment.this.f7720f != null) {
                    GlobalSugFragment.this.f7720f.onResetBtnClick();
                }
            }

            public void onDeparturePinShow(boolean z, Padding padding) {
                if (GlobalSugFragment.this.f7733s == 1) {
                    AddressTrack.isInSelectStart = z;
                    if (GlobalSugFragment.this.f7720f != null) {
                        GlobalSugFragment.this.f7720f.onDeparturePinShow(z, GlobalSugFragment.this.f7733s, GlobalSugFragment.this.m4895h(), padding);
                    }
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    AddressTrack.isInSelectDestination = z;
                    if (GlobalSugFragment.this.f7720f != null) {
                        GlobalSugFragment.this.f7720f.onDeparturePinShow(z, GlobalSugFragment.this.f7733s, GlobalSugFragment.this.m4897i(), padding);
                    }
                }
                if (z && this.lastShow != z) {
                    this.lastShow = z;
                    if (!CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7721g.fromType)) {
                        GlobalSugFragment.this.m4912q();
                    }
                }
            }
        });
        this.f7719e.setSugContainerOpCallback(new ISugContainerOpCallback() {
            public void hideInputWindow() {
                if (!GlobalSugFragment.this.isSugFragmentRemoved() && GlobalSugFragment.this.f7718d != null) {
                    GlobalSugFragment.this.f7718d.removeWatcherForStart();
                    GlobalSugFragment.this.f7718d.setStartText(GlobalSugFragment.this.f7721g);
                    ViewUtils.hideInputMethodForEditText(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f7718d.getStartEditText());
                }
            }

            public Address getTargetAddress() {
                if (GlobalSugFragment.this.f7721g == null || GlobalSugFragment.this.f7721g.addressParam == null) {
                    return null;
                }
                return GlobalSugFragment.this.f7721g.addressParam.targetAddress;
            }

            private void onSugContainerScrollToTop() {
                if (GlobalSugFragment.this.f7733s == 1) {
                    GlobalSugFragment.this.m4915r();
                    boolean unused = GlobalSugFragment.this.f7727m = true;
                    GlobalSugFragment.this.f7718d.getStartEditText().clearFocus();
                    GlobalSugFragment.this.f7718d.getStartEditText().setCursorVisible(true);
                    GlobalSugFragment.this.m4907n();
                    GlobalSugFragment.this.f7718d.addWatcherForStart();
                    boolean unused2 = GlobalSugFragment.this.f7727m = false;
                    GlobalSugFragment.this.m4910p();
                }
            }

            public void onSugContainerScrollChanged(int i, int i2, int i3, int i4) {
                if (i2 < -20) {
                    GlobalSugFragment.this.f7718d.getStartEditText().setCursorVisible(false);
                } else if (i2 == 0 && i4 > -100) {
                    onSugContainerScrollToTop();
                }
            }

            public void onScrollToTop() {
                GlobalSugFragment.this.f7719e.setDragEnable(false);
                if (GlobalSugFragment.this.f7733s == 1) {
                    GlobalSugFragment.this.f7718d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    GlobalSugFragment.this.f7718d.addEndTextWatcher();
                }
            }

            public void onScrollToBottom() {
                if (GlobalSugFragment.this.f7733s == 1) {
                    GlobalSugFragment.this.f7718d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    GlobalSugFragment.this.f7718d.removeEndTextWatcher();
                }
            }
        });
        this.f7719e.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, GlobalSugFragment.f7711a, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + GlobalSugFragment.this.f7732r + ", mCurrAddressType: " + GlobalSugFragment.this.f7733s, (Throwable) null, "com.didi.addressold.GlobalSugFragment$9", 510);
                if (GlobalSugFragment.this.f7733s == 1) {
                    GlobalSugFragment.this.f7718d.removeWatcherForStart();
                    GlobalSugFragment.this.f7719e.setDragEnable(true);
                } else if (GlobalSugFragment.this.f7733s == 2) {
                    GlobalSugFragment.this.f7718d.removeEndTextWatcher();
                    GlobalSugFragment.this.f7719e.setDragEnable(true);
                    AddressTrack.trackSelectDestinationInMap(GlobalSugFragment.this.f7721g.addressParam, GlobalSugFragment.this.f7718d.getEndEditText().getText().toString(), GlobalSugFragment.this.f7738x, true);
                }
            }
        });
        this.f7719e.setConfirmBtnClickListener(this.f7739y);
        if (this.f7734t.canSelectAddressByDragged()) {
            this.f7719e.addPoiListener(this.f7740z);
        }
        if (CommonUtils.isFromHomePage(this.f7721g.fromType)) {
            if (this.f7721g.addressParam.addressType != 1 && this.f7721g.addressParam.addressType == 2) {
                this.f7719e.setDragEnable(false);
                m4908o();
            }
        } else if (CommonUtils.isFromConfirmPage(this.f7721g.fromType)) {
            if (this.f7721g.addressParam.addressType != 1 && this.f7721g.addressParam.addressType == 2) {
                this.f7719e.setDragEnable(false);
                m4908o();
            }
        } else if (CommonUtils.isFromGetOnPage(this.f7721g.fromType)) {
            if (this.f7721g.addressParam.addressType == 1) {
                m4907n();
            } else if (this.f7721g.addressParam.addressType == 2) {
                this.f7719e.setDragEnable(false);
                m4908o();
            }
        } else if (CommonUtils.isFromRouteEditor(this.f7721g.fromType)) {
            int i = this.f7721g.addressParam.addressType;
        }
    }

    /* renamed from: d */
    private void m4887d() {
        this.f7713A.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f7714B.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f7714B.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
    }

    /* renamed from: b */
    private void m4882b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(GlobalSugFragment.this.f7733s == 3 && GlobalSugFragment.this.f7733s == 4)) {
                    AddressTrack.trackCloseButtonClick(GlobalSugFragment.this.f7721g, GlobalSugFragment.this.m4899j());
                }
                if (GlobalSugFragment.this.f7724j != null) {
                    z = GlobalSugFragment.this.f7724j.onCloseButtonIntercept();
                }
                if (!z) {
                    GlobalSugFragment.this.closeFragment();
                    if (GlobalSugFragment.this.f7724j != null) {
                        GlobalSugFragment.this.f7724j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m4889e() {
        this.f7719e.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(GlobalSugFragment.this.f7721g.addressParam);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address homeAddress = GlobalSugFragment.this.f7719e.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(GlobalSugFragment.this.f7721g, homeAddress, GlobalSugFragment.this.f7733s);
                    homeAddress.operationType = 4;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7733s, homeAddress);
                    return;
                }
                GlobalSugFragment.this.m4866a(3, GlobalSugFragment.this.f7721g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly();
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address companyAddress = GlobalSugFragment.this.f7719e.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(GlobalSugFragment.this.f7721g, companyAddress, GlobalSugFragment.this.f7733s);
                    companyAddress.operationType = 5;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7733s, companyAddress);
                    return;
                }
                GlobalSugFragment.this.m4866a(4, GlobalSugFragment.this.f7721g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(GlobalSugFragment.this.f7719e.getHomeAddress()), CommonUtils.isValidLocation(GlobalSugFragment.this.f7719e.getCompanyAddress()));
                Intent intent = CommonAddressActivity.getIntent(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f7721g.clone());
                intent.putExtra(CommonAddressActivity.BUNDLE_TYPE, 2);
                GlobalSugFragment.this.startActivityForResult(intent, 1);
            }
        });
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f7720f = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f7715C = z;
    }

    public ISugViewController getSugViewController() {
        return this.f7719e;
    }

    public String getStartAddressText() {
        return this.f7718d.getStartEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4868a(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, f7711a, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 758);
            SugParams clone = this.f7721g.clone();
            clone.addressParam.addressType = i;
            if (TextUtil.isEmpty(str) || getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f7725k.processDataRequire(clone, "", z, i);
                return;
            }
            if (clone.addressParam.addressType == 2) {
                this.f7738x = true;
            } else if (clone.addressParam.addressType == 1) {
                this.f7737w = true;
            }
            this.f7725k.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4866a(int i, SugParams sugParams) {
        sugParams.addressParam.addressType = i;
        if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(sugParams.fromType)) {
            this.f7727m = true;
            try {
                if (getActivity().findViewById(getId()) != null) {
                    DidiAddressApiFactory.createDidiAddress(getActivity()).selectAddress(getActivity(), getId(), sugParams, (GlobalSugCallback) new GlobalSugCallback() {
                        public void onAttach(int i) {
                        }

                        public void onCloseButtonClick() {
                            resetFocus();
                        }

                        private void resetFocus() {
                            if (GlobalSugFragment.this.f7733s == 1) {
                                GlobalSugFragment.this.m4907n();
                            } else if (GlobalSugFragment.this.f7733s == 2) {
                                GlobalSugFragment.this.m4908o();
                            }
                            boolean unused = GlobalSugFragment.this.f7727m = false;
                        }

                        public void setResult(AddressResult addressResult) {
                            if (addressResult.type == 3) {
                                GlobalSugFragment.this.f7719e.setHomeAddress(addressResult.home);
                            } else if (addressResult.type == 4) {
                                GlobalSugFragment.this.f7719e.setCompanyAddress(addressResult.company);
                            }
                            resetFocus();
                        }

                        public void onDetach(int i) {
                            if (i == 3 || i == 4) {
                                resetFocus();
                            }
                        }
                    });
                    getFragmentManager().executePendingTransactions();
                }
            } catch (AddressException e) {
                SystemUtils.log(6, f7711a, "addCommonAddressSelectFragment() " + e.getMessage(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 828);
            }
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        SystemUtils.log(6, f7711a, "onDestroyView()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 838);
        this.f7735u.onDestroyView();
        this.f7730p = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f7719e;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
        SystemUtils.log(6, f7711a, "onDestroy()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 854);
    }

    public boolean onBackPressed() {
        AddressTrack.isInSelectDestination = false;
        AddressTrack.isInSelectStart = false;
        if (!this.f7729o) {
            return true;
        }
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 1) {
            return false;
        }
        fragmentManager.popBackStackImmediate();
        return true;
    }

    public boolean closeFragment() {
        m4892g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                if (this.f7719e != null) {
                    this.f7719e.removePoiListener(this.f7740z);
                }
                fragmentManager.popBackStackImmediate();
                return false;
            } catch (Exception e) {
                LogUtils.m4964e("sfs", "GlobalSugFragment closeFragment() err msg: " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(this.f7721g, this.f7718d, this.f7719e);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (AddressPresenter.isQueryEverEdited() && !TextUtils.isEmpty(this.f7718d.getEndEditText().getText())) {
            this.f7738x = true;
        }
        m4868a(this.f7721g.addressParam.addressType, "", false);
        if ((CommonUtils.isFromGetOnPage(this.f7721g.fromType) || this.f7721g.addressParam.addressType != 1) && (CommonUtils.isFromRouteEditor(this.f7721g.fromType) || this.f7721g.addressParam.addressType != 2)) {
            this.f7719e.showSelectPoiFooterView(false);
        } else {
            this.f7719e.showSelectPoiFooterView(true);
        }
        if (CommonUtils.isFromHomePage(this.f7721g.fromType) && this.f7721g.addressParam.addressType == 2) {
            m4890f();
        }
    }

    /* renamed from: f */
    private void m4890f() {
        if (this.f7725k != null && CommonUtils.isValidLocation(this.f7721g.addressParam)) {
            this.f7725k.fetchStartPoiInfo(this.f7721g);
            this.f7731q = true;
        }
    }

    /* renamed from: g */
    private void m4892g() {
        AddressPresenter addressPresenter = this.f7725k;
        if (addressPresenter != null) {
            addressPresenter.stopRevertGeo();
            this.f7725k.stopFetchStartPoiInfo();
        }
    }

    public void onResume() {
        super.onResume();
        AddressPresenter addressPresenter = this.f7725k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        SystemUtils.log(6, f7711a, "onPause()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 956);
    }

    public void onStop() {
        super.onStop();
        SystemUtils.log(6, f7711a, "onStop()", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 962);
        AddressPresenter addressPresenter = this.f7725k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f7718d;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo39506a(GlobalSugCallback globalSugCallback) {
        this.f7724j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f7724j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f7721g;
            globalSugCallback.onDetach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f7721g.addressParam.addressType);
        }
    }

    public void showProgressDialog(String str, boolean z) {
        if (z) {
            showLoading();
        } else {
            showMaskLayerLoading();
        }
    }

    public void showProgressDialog(boolean z) {
        if (z) {
            showLoading();
        } else {
            showMaskLayerLoading();
        }
    }

    public void dismissProgressDialog() {
        hideLoading();
    }

    public void showToastComplete(String str) {
        ToastHelper.showShortCompleted((Context) getActivity(), str);
    }

    public void showToastError(String str) {
        ToastHelper.showShortError((Context) getActivity(), str);
    }

    public void showContentView() {
        this.f7714B.setVisibility(8);
        this.f7719e.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo39505a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList) {
        SugListViewContainer sugListViewContainer = this.f7719e;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7719e.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter(false);
                    addressAdapter.setOnItemSelectedListener(GlobalSugFragment.this.f7716D);
                    addressAdapter.updateAddress(arrayList, trackParameterForChild, GlobalSugFragment.this.f7733s);
                    GlobalSugFragment.this.f7719e.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (this.f7721g.addressParam.addressType == 3 || this.f7721g.addressParam.addressType == 4 || this.f7721g.addressParam.addressType == 5 || this.f7721g.addressParam.addressType == 6) {
            z = false;
        }
        this.f7719e.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7719e.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7719e.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        int i = 8;
        this.f7719e.findViewById(R.id.lv).setVisibility(8);
        this.f7714B.setVisibility(0);
        this.f7714B.showError(str);
        View findViewById = this.f7714B.findViewById(R.id.image_error);
        if (!TextUtils.isEmpty(str)) {
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    public void showNoSearchView() {
        int i;
        hideLoading();
        if (!this.f7734t.canSelectAddressByDragged() || !((i = this.f7733s) == 2 || i == 1)) {
            this.f7719e.setDragEnable(false);
            this.f7719e.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f7719e.setDragEnable(true);
            this.f7719e.onlyShowSelectPoiFooterView();
        }
        this.f7714B.setVisibility(0);
        this.f7714B.showError(getResources().getText(R.string.global_sug_no_result));
        this.f7714B.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1207);
            if (!m4874a(i, address)) {
                AddressResult addressResult = new AddressResult();
                addressResult.fromType = this.f7721g.fromType;
                addressResult.type = i;
                addressResult.isStartNeedNearRoad = this.f7728n;
                if (i == 4) {
                    addressResult.company = address;
                } else if (i == 3) {
                    addressResult.home = address;
                } else if (i == 1) {
                    if (CommonUtils.isFromRouteEditor(this.f7721g.fromType)) {
                        addressResult.common = address;
                    } else if (this.f7723i == null) {
                        m4908o();
                        m4877a(address);
                        this.f7718d.getStartEditText().setText(address.displayName);
                        this.f7718d.getEndEditText().setText("");
                        addressResult.start = address;
                        return;
                    } else if (!CommonUtils.isTwoAddressEqual(this.f7722h, address)) {
                        addressResult.start = address;
                        addressResult.end = this.f7723i;
                    } else {
                        try {
                            showToastError(getActivity().getString(R.string.GRider_1102_The_same_LaNx));
                            return;
                        } catch (Exception e) {
                            e.printStackTrace();
                            return;
                        }
                    }
                } else if (i == 2) {
                    if (CommonUtils.isFromRouteEditor(this.f7721g.fromType)) {
                        addressResult.common = address;
                    } else if (!CommonUtils.isValidLocation(this.f7722h)) {
                        m4907n();
                        this.f7723i = address;
                        this.f7718d.getEndEditText().setText(address.displayName);
                        return;
                    } else if (!CommonUtils.isTwoAddressEqual(this.f7722h, address)) {
                        addressResult.start = this.f7722h;
                        addressResult.end = address;
                    } else {
                        try {
                            showToastError(getActivity().getString(R.string.GRider_1102_The_same_LaNx));
                            return;
                        } catch (Exception e2) {
                            e2.printStackTrace();
                            return;
                        }
                    }
                } else if (i == 5) {
                    addressResult.common = address;
                } else if (i == 6) {
                    addressResult.common = address;
                }
                m4870a(addressResult);
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m4895h() {
        Address address = this.f7722h;
        return address == null ? this.f7721g.addressParam.targetAddress : address;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public Address m4897i() {
        Address address = this.f7723i;
        return address == null ? this.f7721g.addressParam.targetAddress : address;
    }

    /* renamed from: a */
    private boolean m4874a(int i, Address address) {
        if (!CommonUtils.isFromConfirmPage(this.f7721g.fromType) && !CommonUtils.isFromGetOnPage(this.f7721g.fromType)) {
            return false;
        }
        AddressResult addressResult = new AddressResult();
        addressResult.fromType = this.f7721g.fromType;
        addressResult.type = i;
        if (i == 1) {
            this.f7718d.getStartEditText().setText(address.displayName);
            addressResult.start = address;
            addressResult.isStartNeedNearRoad = this.f7728n;
            this.f7718d.addWatcherForStart();
            this.f7719e.setDragEnable(false);
        } else if (i == 2) {
            this.f7718d.removeEndTextWatcher();
            this.f7718d.getEndEditText().setText(address.displayName);
            addressResult.end = address;
            this.f7718d.addEndTextWatcher();
            this.f7719e.setDragEnable(false);
        } else {
            this.f7718d.getCommonEditText().setText(address.displayName);
            if (i == 3) {
                addressResult.home = address;
            } else if (i == 4) {
                addressResult.company = address;
            } else {
                throw new RuntimeException("Unknown address type with CONFIRM type");
            }
        }
        m4870a(addressResult);
        return true;
    }

    /* renamed from: a */
    private void m4870a(AddressResult addressResult) {
        if (this.f7715C) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f7724j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        SugParams sugParams;
        if (!isSugFragmentRemoved() && (sugParams = this.f7721g) != null && sugParams.managerCallback != null && this.f7721g.addressParam.currentAddress != null) {
            this.f7721g.managerCallback.toLogin(getActivity(), this.f7721g.addressParam.currentAddress.latitude, this.f7721g.addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7719e.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (CommonUtils.isFromHomePage(this.f7721g.fromType)) {
            int i = this.f7733s;
            if (i == 1 || i == 2) {
                this.f7719e.showSelectPoiFooterView(true);
            } else {
                this.f7719e.showSelectPoiFooterView(false);
            }
        } else if (CommonUtils.isFromGetOnPage(this.f7721g.fromType) || CommonUtils.isFromRouteEditor(this.f7721g.fromType)) {
            this.f7719e.showSelectPoiFooterView(false);
        } else if (CommonUtils.isFromConfirmPage(this.f7721g.fromType)) {
            int i2 = this.f7733s;
            if (i2 == 1 || i2 == 2) {
                this.f7719e.showSelectPoiFooterView(true);
            } else {
                this.f7719e.showSelectPoiFooterView(false);
            }
        } else {
            this.f7719e.showSelectPoiFooterView(z);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f7719e.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f7718d != null && !this.f7727m && !this.f7730p && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1402);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                String str = "";
                if (i == 1) {
                    m4892g();
                    m4900k();
                    if (this.f7718d.isStartTextNeedScrollToBottomWhenFocused) {
                        m4902l();
                    }
                    if (CommonUtils.isFromHomePage(this.f7721g.fromType)) {
                        m4917s();
                    }
                    m4868a(1, str, false);
                    this.f7719e.scrollToTop();
                    AddressTrack.trackStartPointViewClick(this.f7721g.addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(this.f7721g.fromType, this.f7721g.addressParam));
                    this.f7718d.addWatcherForStart();
                } else if (i == 2) {
                    this.f7719e.setDragEnable(false);
                    Editable text = this.f7718d.getEndEditText().getText();
                    if (text != null) {
                        str = text.toString();
                    }
                    m4868a(2, str, false);
                    m4908o();
                    this.f7719e.scrollToTop();
                }
                this.f7718d.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f7722h != null) {
                    this.f7718d.getStartEditText().setText(this.f7722h.displayName);
                    if (this.f7722h.displayName != null && this.f7722h.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
                        this.f7718d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                        m4890f();
                    } else if (CommonUtils.isFromHomePage(this.f7721g.fromType)) {
                        m4917s();
                    } else {
                        this.f7718d.getStartEditText().setTextColor(-16777216);
                    }
                }
            } else if (i == 2 && this.f7723i != null) {
                this.f7718d.getEndEditText().setText(this.f7723i.displayName);
            }
            this.f7719e.setDragEnable(false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m4899j() {
        return AddressTrack.getCurrPage(this.f7733s, this.f7718d, this.f7719e);
    }

    /* renamed from: k */
    private void m4900k() {
        this.f7718d.getEndEditText().setText("");
    }

    /* access modifiers changed from: private */
    /* renamed from: l */
    public void m4902l() {
        if (!this.f7730p) {
            this.f7719e.addPoiListener(this.f7740z);
            this.f7719e.setDragEnable(true);
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f7718d.getStartEditText());
            this.f7719e.scrollToBottom();
        }
    }

    /* renamed from: m */
    private void m4905m() {
        if (!this.f7730p) {
            this.f7718d.getCommonEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m4907n() {
        if (!this.f7730p) {
            this.f7718d.getStartEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m4908o() {
        AddressTrack.isInSelectDestination = false;
        if (!this.f7730p) {
            this.f7718d.getEndEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m4910p() {
        Editable text = this.f7718d.getStartEditText().getText();
        if (!TextUtils.isEmpty(text)) {
            Selection.setSelection(text, text.length(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m4912q() {
        this.f7718d.getStartEditText().setSelection(0);
    }

    public void onClick(int i) {
        if (this.f7718d != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, f7711a, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1504);
                m4892g();
                m4915r();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7718d.getStartEditText(), true ^ this.f7730p);
                this.f7719e.scrollToTop();
                this.f7718d.addWatcherForStart();
                this.f7719e.setDragEnable(false);
                AddressTrack.isInSelectStart = false;
            } else if (i == 2) {
                SystemUtils.log(3, f7711a, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressold.GlobalSugFragment", 1513);
                m4892g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7718d.getEndEditText(), true ^ this.f7730p);
                this.f7719e.scrollToTop();
                this.f7718d.addEndTextWatcher();
                this.f7719e.setDragEnable(false);
                AddressTrack.isInSelectDestination = false;
            }
            m4868a(i, "", false);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m4915r() {
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(this.f7721g.addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText())) {
            this.f7718d.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f7718d != null) {
            setSearchViewType(i);
            if (i == 2 && this.f7736v) {
                this.f7736v = false;
            } else if (view.hasFocus()) {
                m4867a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m4867a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f7726l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f7726l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m4878a(addressParam);
    }

    public void setStartPoiInfo(SugParams sugParams) {
        this.f7718d.setStartText(sugParams);
    }

    /* renamed from: a */
    private boolean m4878a(AddressParam addressParam) {
        if (addressParam == null || this.f7718d == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f7718d.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f7718d.getEndEditText().hasFocus();
        }
        return this.f7718d.getCommonEditText().hasFocus();
    }

    public View getFallbackView() {
        return this.f7713A;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f7733s, convertToAddress);
        }
    }

    /* renamed from: s */
    private void m4917s() {
        this.f7718d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
        this.f7718d.getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
    }
}

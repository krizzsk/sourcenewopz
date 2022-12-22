package com.didi.addressold.vamos;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.app.Activity;
import android.app.FragmentManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.Selection;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
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
import com.didi.addressold.util.CheckParamUtil;
import com.didi.addressold.util.CommonUtils;
import com.didi.addressold.util.LogUtils;
import com.didi.addressold.util.ViewUtils;
import com.didi.addressold.vamos.Util.ApolloUtil;
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
import com.didi.map.sdk.env.PointType;
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
    private static final String f7793a = "GlobalSugFragment";

    /* renamed from: c */
    private static final String f7794c = "param";

    /* renamed from: A */
    private EmptyView f7795A = null;

    /* renamed from: B */
    private boolean f7796B = true;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public AddressAdapter.OnItemSelectedListener f7797C = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi2 = rpcPoi;
            RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (GlobalSugFragment.this.f7813r == 1) {
                boolean unused = GlobalSugFragment.this.f7809n = true;
            }
            GlobalSugFragment.this.f7802g.addressParam.addressType = GlobalSugFragment.this.f7813r;
            int i3 = 2;
            int i4 = 3;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (GlobalSugFragment.this.f7813r == 1) {
                    if (GlobalSugFragment.this.f7817v) {
                        i3 = 3;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (GlobalSugFragment.this.f7813r == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                GlobalSugFragment.this.f7806k.getGeocodeResult(GlobalSugFragment.this.f7802g, rpcPoi, getSearchText(), trackParameterForChild, i, i2, GlobalSugFragment.this.f7813r);
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild);
            AddressTrack.trackAddressClick(GlobalSugFragment.this.f7802g, rpcPoi2.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, GlobalSugFragment.this.f7813r);
            if (GlobalSugFragment.this.f7813r == 3 || GlobalSugFragment.this.f7813r == 4) {
                GlobalSugFragment.this.f7799d.removeCommonWatcher(GlobalSugFragment.this.f7802g.addressParam);
                GlobalSugFragment.this.f7799d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                GlobalSugFragment.this.f7806k.setCommonAddress(GlobalSugFragment.this.f7802g, rpcPoi);
            } else {
                rpcPoi2.base_info.searchId = trackParameterForChild2.search_id;
                Address a = GlobalSugFragment.this.mo39682a(rpcPoi);
                if (!GlobalSugFragment.this.f7817v) {
                    i4 = 2;
                }
                a.operationType = i4;
                if (GlobalSugFragment.this.f7813r == 1) {
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7813r, a);
                    AddressTrack.trackRecItemSelect(i + 1);
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    GlobalSugFragment globalSugFragment2 = GlobalSugFragment.this;
                    globalSugFragment2.setResultBack(globalSugFragment2.f7813r, a);
                } else if (GlobalSugFragment.this.f7813r == 5) {
                    GlobalSugFragment.this.f7799d.removeCommonWatcher(GlobalSugFragment.this.f7802g.addressParam);
                    GlobalSugFragment.this.f7799d.getCommonEditText().setText(rpcPoi2.base_info.displayname);
                    GlobalSugFragment globalSugFragment3 = GlobalSugFragment.this;
                    globalSugFragment3.setResultBack(globalSugFragment3.f7813r, a);
                    AddressTrack.trackAddAddressItemClick();
                } else if (GlobalSugFragment.this.f7813r == 6) {
                    GlobalSugFragment globalSugFragment4 = GlobalSugFragment.this;
                    globalSugFragment4.setResultBack(globalSugFragment4.f7813r, a);
                }
            }
            GlobalSugFragment.this.f7806k.recordClickPoi(GlobalSugFragment.this.f7802g, rpcPoi2.base_info);
        }

        private String getSearchText() {
            if (GlobalSugFragment.this.f7813r == 1) {
                return GlobalSugFragment.this.f7799d.getStartEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f7813r == 2) {
                return GlobalSugFragment.this.f7799d.getEndEditText().getText().toString();
            }
            if (GlobalSugFragment.this.f7813r == 3) {
                return GlobalSugFragment.this.f7799d.getCommonEditText().getText().toString();
            }
            return GlobalSugFragment.this.f7813r == 4 ? GlobalSugFragment.this.f7799d.getCommonEditText().getText().toString() : "";
        }
    };

    /* renamed from: b */
    private final int f7798b = 12;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public SugSearchView f7799d;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugListViewContainer f7800e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public ISugControlCallback f7801f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SugParams f7802g;

    /* renamed from: h */
    private Address f7803h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f7804i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f7805j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f7806k;

    /* renamed from: l */
    private Handler f7807l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public boolean f7808m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public boolean f7809n = true;

    /* renamed from: o */
    private boolean f7810o;

    /* renamed from: p */
    private boolean f7811p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public int f7812q = 2;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public int f7813r = -1;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public SelectAddressByDraggedDelegate f7814s;

    /* renamed from: t */
    private SoftKeyboardDelegate f7815t;

    /* renamed from: u */
    private boolean f7816u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7817v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f7818w = false;

    /* renamed from: x */
    private View.OnClickListener f7819x = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (!GlobalSugFragment.this.f7814s.canSelectAddressByDragged()) {
                Address b = GlobalSugFragment.this.m5004h();
                b.operationType = 1;
                if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7802g.fromType) || CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f7802g.fromType)) {
                    GlobalSugFragment.this.setResultBack(1, b);
                    return;
                }
                GlobalSugFragment.this.m5019p();
                GlobalSugFragment.this.f7800e.scrollToTop();
                GlobalSugFragment.this.m4977a(2, "", false);
            } else if (!CommonUtils.isFromHomePage(GlobalSugFragment.this.f7802g.fromType) || GlobalSugFragment.this.f7813r != 1) {
                Address address = null;
                if (GlobalSugFragment.this.f7813r == 1) {
                    address = GlobalSugFragment.this.f7814s.getStartAddressByDragged();
                    GlobalSugFragment.this.f7799d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    address = GlobalSugFragment.this.f7814s.getEndAddressByDragged();
                    GlobalSugFragment.this.f7799d.addEndTextWatcher();
                }
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7813r, address);
                    if (GlobalSugFragment.this.f7813r == 2) {
                        AddressTrack.trackSelectDestinationInMapConfirm(GlobalSugFragment.this.f7802g.addressParam, address, GlobalSugFragment.this.f7818w, true);
                    }
                }
            } else {
                GlobalSugFragment.this.m5019p();
                GlobalSugFragment.this.f7800e.scrollToTop();
                GlobalSugFragment.this.m4977a(2, "", false);
            }
        }
    };

    /* renamed from: y */
    private IPoiChangeListener f7820y = new IPoiChangeListener() {
        public void onPinLoading(double d, double d2) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.showLoading();
                GlobalSugFragment.this.f7800e.setConfirmBtnEnabled(false);
                Address address = new Address();
                address.latitude = d;
                address.longitude = d2;
                address.displayName = GlobalSugFragment.this.getString(R.string.global_sug_to_departure);
                address.operationType = 1;
                GlobalSugFragment.this.f7814s.onPinLoading(address);
                if (GlobalSugFragment.this.f7812q == 1) {
                    boolean unused = GlobalSugFragment.this.f7809n = false;
                    boolean unused2 = GlobalSugFragment.this.m4986a(address);
                }
            }
        }

        public void onPinPoiChanged(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f7800e.setConfirmBtnEnabled(true);
                if (address != null) {
                    address.operationType = 1;
                    GlobalSugFragment.this.f7814s.onPinPoiChanged(address);
                    if (GlobalSugFragment.this.f7812q == 1) {
                        boolean unused = GlobalSugFragment.this.f7809n = false;
                        boolean unused2 = GlobalSugFragment.this.m4986a(address);
                    } else if (GlobalSugFragment.this.f7812q == 2) {
                        Address unused3 = GlobalSugFragment.this.f7804i = address;
                    }
                }
            }
        }

        public void onPinFetchPoiFailed(Address address) {
            if (GlobalSugFragment.this.isAdded()) {
                GlobalSugFragment.this.hideLoading();
                GlobalSugFragment.this.f7800e.setConfirmBtnEnabled(true);
                if (address != null) {
                    GlobalSugFragment.this.f7814s.onPinFetchPoiFailed(address);
                    address.operationType = 1;
                    if (GlobalSugFragment.this.f7812q == 1) {
                        boolean unused = GlobalSugFragment.this.f7809n = false;
                        boolean unused2 = GlobalSugFragment.this.m4986a(address);
                    } else if (GlobalSugFragment.this.f7812q == 2) {
                        Address unused3 = GlobalSugFragment.this.f7804i = address;
                    }
                }
            }
        }
    };

    /* renamed from: z */
    private FrameLayout f7821z = null;

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
            this.f7802g = (SugParams) getArguments().getSerializable("param");
            AddressTrack.trackCheckAddressParam(activity.getApplicationContext(), this.f7802g.addressParam, this.f7802g.fromType);
            CheckParamUtil.rescueAddressParam(activity.getApplicationContext(), "GlobalSugFragment onAttach()", this.f7802g.addressParam);
            setCurrAddressType(this.f7802g.addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f7805j;
        if (globalSugCallback != null) {
            SugParams sugParams = this.f7802g;
            globalSugCallback.onAttach((sugParams == null || sugParams.addressParam == null) ? Integer.MIN_VALUE : this.f7802g.addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4974a();
    }

    /* renamed from: a */
    private void m4974a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, this.f7802g.usrType);
        this.f7806k = new AddressPresenter(getActivity(), this);
        this.f7810o = true;
        this.f7811p = false;
        ApolloUtil.initSugSearchInternalTime();
        this.f7814s = new SelectAddressByDraggedDelegate(this.f7802g.addressParam, this.f7802g.fromType);
        this.f7815t = new SoftKeyboardDelegate(getActivity(), this.f7802g.addressParam, this.f7802g.fromType);
        setCurrAddressType(this.f7802g.addressParam.addressType);
        this.f7807l = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    GlobalSugFragment.this.m4977a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f7813r = i;
        SelectAddressByDraggedDelegate selectAddressByDraggedDelegate = this.f7814s;
        if (selectAddressByDraggedDelegate != null) {
            selectAddressByDraggedDelegate.setCurrAddressType(i);
        }
    }

    public void setSearchViewType(int i) {
        this.f7812q = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        int i3;
        Activity activity = getActivity();
        if (activity != null) {
            Animator loadAnimator = AnimatorInflater.loadAnimator(activity, R.animator.old_poi_one_address_animate_exit);
            if (!z && loadAnimator != null && ((i3 = this.f7813r) == 1 || i3 == 2 || i3 == 6)) {
                return loadAnimator;
            }
        }
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.old_layout_sug_fragment, viewGroup, false);
        m4978a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m4978a(View view) {
        m4991b(view.findViewById(R.id.sug_close_btn));
        this.f7799d = (SugSearchView) view.findViewById(R.id.search_view);
        this.f7800e = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f7821z = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f7795A = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f7814s.setSugSearchView(this.f7799d);
        this.f7815t.hideOrShowSoftKeyboard(this.f7799d);
        this.f7815t.onCreateView();
        m4994c();
        m4990b();
        m4996d();
        m4998e();
    }

    /* renamed from: b */
    private void m4990b() {
        if (this.f7799d != null) {
            if (!CommonUtils.isFromSetting(this.f7802g.fromType) && !CommonUtils.isFromRouteEditor(this.f7802g.fromType)) {
                this.f7799d.addStatusBarHeightView();
            }
            this.f7799d.setSearchViewCallback(this);
            this.f7799d.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.getView());
                    if (GlobalSugFragment.this.f7805j != null) {
                        GlobalSugFragment.this.f7805j.onEnterWayPoint(GlobalSugFragment.this.m5004h(), GlobalSugFragment.this.f7804i);
                    }
                }
            });
            Address startPoiFromCache = this.f7806k.getStartPoiFromCache(this.f7802g.addressParam.targetAddress);
            if (startPoiFromCache != null && !TextUtils.isEmpty(startPoiFromCache.hideAddress)) {
                SystemUtils.log(3, f7793a, "set start poi info from cache --> Address startPoi:" + startPoiFromCache.toString(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 239);
                this.f7802g.addressParam.targetAddress = startPoiFromCache;
            }
            if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
                String string = getResources().getString(R.string.global_sug_current_location);
                this.f7802g.addressParam.targetAddress.address = string;
                this.f7802g.addressParam.targetAddress.displayName = string;
                this.f7802g.addressParam.targetAddress.fullName = string;
                this.f7806k.cacheStartPoiInfo(this.f7802g.addressParam.targetAddress);
            }
            this.f7799d.initSugSearchView(this.f7802g);
            if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
                m5028t();
            }
            this.f7799d.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    GlobalSugFragment.this.m4977a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(this.f7802g.fromType) || CommonUtils.isFromGetOnPage(this.f7802g.fromType)) && this.f7802g.addressParam.addressType == 1) {
                m5026s();
            }
            storeStartAddress(this.f7802g.addressParam);
            m4980a(this.f7802g);
            this.f7799d.setListener(this.f7802g);
            this.f7799d.makeStartTextFocusedWhenIsRed();
            this.f7799d.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7802g.fromType)) {
                        if (GlobalSugFragment.this.f7802g.addressParam.addressType == 1 && GlobalSugFragment.this.f7799d.isStartTextNeedScrollToBottomWhenFocused) {
                            GlobalSugFragment.this.m5014m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(GlobalSugFragment.this.f7802g.fromType) && GlobalSugFragment.this.f7802g.addressParam.addressType == 1) {
                        GlobalSugFragment.this.m5026s();
                        GlobalSugFragment.this.f7800e.scrollToTop();
                        GlobalSugFragment.this.f7799d.addWatcherForStart();
                    }
                }
            });
            this.f7799d.postDelayed(new Runnable() {
                public void run() {
                    if (GlobalSugFragment.this.f7800e != null) {
                        GlobalSugFragment.this.f7800e.setTopPadding(GlobalSugFragment.this.f7799d.getMeasuredHeight());
                    }
                }
            }, 200);
        }
    }

    /* renamed from: a */
    private void m4980a(SugParams sugParams) {
        EditTextErasable endEditText;
        if ((sugParams.fromType != FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) && sugParams.addressParam.addressType == 2) {
            m5019p();
            if (sugParams.fromType == FromType.HOME && (endEditText = this.f7799d.getEndEditText()) != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.addressParam.addressType != 1) {
            m5016n();
            EditTextErasable commonEditText = this.f7799d.getCommonEditText();
            if (commonEditText != null) {
                commonEditText.setFocusable(true);
                commonEditText.sendAccessibilityEvent(128);
            }
        } else {
            m5017o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m4986a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f7813r;
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public boolean m4986a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 338);
        this.f7803h = address;
        if (address == null) {
            return false;
        }
        this.f7802g.addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m4994c() {
        this.f7800e.setOperCallback(new ISugMapCtrlCallback() {
            private boolean lastShow = false;

            public void onResetBtnClick() {
                if (GlobalSugFragment.this.f7801f != null) {
                    GlobalSugFragment.this.f7801f.onResetBtnClick();
                }
            }

            public void onDeparturePinShow(boolean z, Padding padding) {
                PointType pointType;
                if (GlobalSugFragment.this.f7813r == 1) {
                    pointType = PointType.START;
                    AddressTrack.isInSelectStart = z;
                    if (GlobalSugFragment.this.f7801f != null) {
                        GlobalSugFragment.this.f7801f.onDeparturePinShow(z, GlobalSugFragment.this.f7813r, GlobalSugFragment.this.m5004h(), padding);
                    }
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    pointType = PointType.END;
                    AddressTrack.isInSelectDestination = z;
                    if (GlobalSugFragment.this.f7801f != null) {
                        GlobalSugFragment.this.f7801f.onDeparturePinShow(z, GlobalSugFragment.this.f7813r, GlobalSugFragment.this.m5006i(), padding);
                    }
                } else {
                    pointType = PointType.OTHER;
                }
                PaxEnvironment.getInstance().setPointType(pointType);
                if (z && this.lastShow != z) {
                    this.lastShow = z;
                    if (!CommonUtils.isFromConfirmPage(GlobalSugFragment.this.f7802g.fromType)) {
                        GlobalSugFragment.this.m5024r();
                    }
                }
            }
        });
        this.f7800e.setSugContainerOpCallback(new ISugContainerOpCallback() {
            public void hideInputWindow() {
                if (!GlobalSugFragment.this.isSugFragmentRemoved() && GlobalSugFragment.this.f7799d != null) {
                    GlobalSugFragment.this.f7799d.removeWatcherForStart();
                    GlobalSugFragment.this.f7799d.setStartText(GlobalSugFragment.this.f7802g);
                    ViewUtils.hideInputMethodForEditText(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f7799d.getStartEditText());
                }
            }

            public Address getTargetAddress() {
                if (GlobalSugFragment.this.f7802g == null || GlobalSugFragment.this.f7802g.addressParam == null) {
                    return null;
                }
                return GlobalSugFragment.this.f7802g.addressParam.targetAddress;
            }

            private void onSugContainerScrollToTop() {
                if (GlobalSugFragment.this.f7813r == 1) {
                    GlobalSugFragment.this.m5026s();
                    boolean unused = GlobalSugFragment.this.f7808m = true;
                    GlobalSugFragment.this.f7799d.getStartEditText().clearFocus();
                    GlobalSugFragment.this.f7799d.getStartEditText().setCursorVisible(true);
                    GlobalSugFragment.this.m5017o();
                    GlobalSugFragment.this.f7799d.addWatcherForStart();
                    boolean unused2 = GlobalSugFragment.this.f7808m = false;
                    GlobalSugFragment.this.m5021q();
                }
            }

            public void onSugContainerScrollChanged(int i, int i2, int i3, int i4) {
                if (i2 < -20) {
                    GlobalSugFragment.this.f7799d.getStartEditText().setCursorVisible(false);
                } else if (i2 == 0 && i4 > -100) {
                    onSugContainerScrollToTop();
                }
            }

            public void onScrollToTop() {
                if (GlobalSugFragment.this.f7813r == 1) {
                    GlobalSugFragment.this.f7799d.addWatcherForStart();
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    GlobalSugFragment.this.f7799d.addEndTextWatcher();
                }
            }

            public void onScrollToBottom() {
                if (GlobalSugFragment.this.f7813r == 1) {
                    GlobalSugFragment.this.f7799d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    GlobalSugFragment.this.f7799d.removeEndTextWatcher();
                }
            }
        });
        this.f7800e.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, GlobalSugFragment.f7793a, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + GlobalSugFragment.this.f7812q + ", mCurrAddressType: " + GlobalSugFragment.this.f7813r, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment$9", 503);
                if (GlobalSugFragment.this.f7813r == 1) {
                    GlobalSugFragment.this.f7799d.removeWatcherForStart();
                } else if (GlobalSugFragment.this.f7813r == 2) {
                    GlobalSugFragment.this.f7799d.removeEndTextWatcher();
                    AddressTrack.trackSelectDestinationInMap(GlobalSugFragment.this.f7802g.addressParam, GlobalSugFragment.this.f7799d.getEndEditText().getText().toString(), GlobalSugFragment.this.f7818w, true);
                }
            }
        });
        this.f7800e.setConfirmBtnClickListener(this.f7819x);
        if (this.f7814s.canSelectAddressByDragged()) {
            this.f7800e.addPoiListener(this.f7820y);
        }
        if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
            if (this.f7802g.addressParam.addressType != 1 && this.f7802g.addressParam.addressType == 2) {
                m5019p();
            }
        } else if (CommonUtils.isFromConfirmPage(this.f7802g.fromType)) {
            if (this.f7802g.addressParam.addressType != 1 && this.f7802g.addressParam.addressType == 2) {
                m5019p();
            }
        } else if (CommonUtils.isFromGetOnPage(this.f7802g.fromType)) {
            if (this.f7802g.addressParam.addressType == 1) {
                m5017o();
            } else if (this.f7802g.addressParam.addressType == 2) {
                m5019p();
            }
        } else if (CommonUtils.isFromRouteEditor(this.f7802g.fromType)) {
            int i = this.f7802g.addressParam.addressType;
        }
    }

    /* renamed from: d */
    private void m4996d() {
        this.f7821z.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f7795A.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        });
        this.f7795A.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
    }

    /* renamed from: b */
    private void m4991b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(GlobalSugFragment.this.f7813r == 3 && GlobalSugFragment.this.f7813r == 4)) {
                    AddressTrack.trackCloseButtonClick(GlobalSugFragment.this.f7802g, GlobalSugFragment.this.m5008j());
                }
                if (GlobalSugFragment.this.f7805j != null) {
                    z = GlobalSugFragment.this.f7805j.onCloseButtonIntercept();
                }
                if (!z) {
                    GlobalSugFragment.this.closeFragment();
                    if (GlobalSugFragment.this.f7805j != null) {
                        GlobalSugFragment.this.f7805j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m4998e() {
        this.f7800e.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(GlobalSugFragment.this.f7802g.addressParam);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address homeAddress = GlobalSugFragment.this.f7800e.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(GlobalSugFragment.this.f7802g, homeAddress, GlobalSugFragment.this.f7813r);
                    homeAddress.operationType = 4;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7813r, homeAddress);
                    return;
                }
                GlobalSugFragment.this.m4975a(3, GlobalSugFragment.this.f7802g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly();
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                Address companyAddress = GlobalSugFragment.this.f7800e.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(GlobalSugFragment.this.f7802g, companyAddress, GlobalSugFragment.this.f7813r);
                    companyAddress.operationType = 5;
                    GlobalSugFragment globalSugFragment = GlobalSugFragment.this;
                    globalSugFragment.setResultBack(globalSugFragment.f7813r, companyAddress);
                    return;
                }
                GlobalSugFragment.this.m4975a(4, GlobalSugFragment.this.f7802g.clone());
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    GlobalSugFragment.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(GlobalSugFragment.this.f7800e.getHomeAddress()), CommonUtils.isValidLocation(GlobalSugFragment.this.f7800e.getCompanyAddress()));
                Intent intent = CommonAddressActivity.getIntent(GlobalSugFragment.this.getActivity(), GlobalSugFragment.this.f7802g.clone());
                intent.putExtra(CommonAddressActivity.BUNDLE_TYPE, 2);
                GlobalSugFragment.this.startActivityForResult(intent, 1);
            }
        });
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f7801f = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f7796B = z;
    }

    public ISugViewController getSugViewController() {
        return this.f7800e;
    }

    public String getStartAddressText() {
        return this.f7799d.getStartEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4977a(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, f7793a, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 746);
            SugParams clone = this.f7802g.clone();
            clone.addressParam.addressType = i;
            if (TextUtil.isEmpty(str) || getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f7806k.processDataRequire(clone, "", z, i);
                return;
            }
            if (clone.addressParam.addressType == 2) {
                this.f7818w = true;
            } else if (clone.addressParam.addressType == 1) {
                this.f7817v = true;
            }
            this.f7806k.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4975a(int i, SugParams sugParams) {
        sugParams.addressParam.addressType = i;
        if (sugParams.fromType == FromType.ROUTE_EDITOR || sugParams.fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || sugParams.fromType == FromType.FROM_HOME_ROUTE_EDITOR || sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM || CommonUtils.isGetOnFromType(sugParams.fromType)) {
            this.f7808m = true;
            try {
                if (getActivity().findViewById(getId()) != null) {
                    DidiAddressApiFactory.createDidiAddress(getActivity()).selectAddress(getActivity(), getId(), sugParams, (GlobalSugCallback) new GlobalSugCallback() {
                        public void onAttach(int i) {
                        }

                        public void onCloseButtonClick() {
                            resetFocus();
                        }

                        private void resetFocus() {
                            if (GlobalSugFragment.this.f7813r == 1) {
                                GlobalSugFragment.this.m5017o();
                            } else if (GlobalSugFragment.this.f7813r == 2) {
                                GlobalSugFragment.this.m5019p();
                            }
                            boolean unused = GlobalSugFragment.this.f7808m = false;
                        }

                        public void setResult(AddressResult addressResult) {
                            if (addressResult.type == 3) {
                                GlobalSugFragment.this.f7800e.setHomeAddress(addressResult.home);
                            } else if (addressResult.type == 4) {
                                GlobalSugFragment.this.f7800e.setCompanyAddress(addressResult.company);
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
                SystemUtils.log(6, f7793a, "addCommonAddressSelectFragment() " + e.getMessage(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 816);
            }
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f7815t.onDestroyView();
        this.f7811p = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f7800e;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        AddressTrack.isInSelectDestination = false;
        AddressTrack.isInSelectStart = false;
        if (!this.f7810o) {
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
        m5001g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                if (this.f7800e != null) {
                    this.f7800e.removePoiListener(this.f7820y);
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
        AddressTrack.onViewCreated(this.f7802g, this.f7799d, this.f7800e);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (AddressPresenter.isQueryEverEdited() && !TextUtils.isEmpty(this.f7799d.getEndEditText().getText())) {
            this.f7818w = true;
        }
        if (CommonUtils.isFromGetOnPage(this.f7802g.fromType)) {
            m4977a(this.f7802g.addressParam.addressType, "", false);
        } else {
            m4977a(this.f7802g.addressParam.addressType, "", false);
        }
        if ((CommonUtils.isFromGetOnPage(this.f7802g.fromType) || this.f7802g.addressParam.addressType != 1) && (CommonUtils.isFromRouteEditor(this.f7802g.fromType) || this.f7802g.addressParam.addressType != 2)) {
            this.f7800e.showSelectPoiFooterView(false);
        } else {
            this.f7800e.showSelectPoiFooterView(true);
        }
        if (CommonUtils.isFromHomePage(this.f7802g.fromType) && this.f7802g.addressParam.addressType == 2) {
            m4999f();
        }
    }

    /* renamed from: f */
    private void m4999f() {
        if (this.f7806k != null && CommonUtils.isValidLocation(this.f7802g.addressParam)) {
            this.f7806k.fetchStartPoiInfo(this.f7802g);
        }
    }

    /* renamed from: g */
    private void m5001g() {
        AddressPresenter addressPresenter = this.f7806k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f7806k.stopRevertGeo();
        }
    }

    public void onResume() {
        super.onResume();
        AddressPresenter addressPresenter = this.f7806k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
    }

    public void onPause() {
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f7806k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f7799d;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo39683a(GlobalSugCallback globalSugCallback) {
        this.f7805j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f7805j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach(this.f7802g.addressParam != null ? this.f7802g.addressParam.addressType : Integer.MIN_VALUE);
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
        this.f7795A.setVisibility(8);
        this.f7800e.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo39682a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList) {
        SugListViewContainer sugListViewContainer = this.f7800e;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7800e.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter(true);
                    addressAdapter.setOnItemSelectedListener(GlobalSugFragment.this.f7797C);
                    addressAdapter.updateAddress(arrayList, trackParameterForChild, GlobalSugFragment.this.f7813r);
                    GlobalSugFragment.this.f7800e.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (this.f7802g.addressParam.addressType == 3 || this.f7802g.addressParam.addressType == 4 || this.f7802g.addressParam.addressType == 5 || this.f7802g.addressParam.addressType == 6) {
            z = false;
        }
        this.f7800e.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7800e.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7800e.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        int i = 8;
        this.f7800e.findViewById(R.id.lv).setVisibility(8);
        this.f7795A.setVisibility(0);
        this.f7795A.showError(str);
        View findViewById = this.f7795A.findViewById(R.id.image_error);
        if (!TextUtils.isEmpty(str)) {
            i = 0;
        }
        findViewById.setVisibility(i);
    }

    public void showNoSearchView() {
        int i;
        hideLoading();
        if (!this.f7814s.canSelectAddressByDragged() || !((i = this.f7813r) == 2 || i == 1)) {
            this.f7800e.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f7800e.onlyShowSelectPoiFooterView();
        }
        this.f7795A.setVisibility(0);
        this.f7795A.showError(getResources().getText(R.string.global_sug_no_result));
        this.f7795A.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1191);
            if (!m4983a(i, address)) {
                AddressResult addressResult = new AddressResult();
                addressResult.fromType = this.f7802g.fromType;
                addressResult.type = i;
                addressResult.isStartNeedNearRoad = this.f7809n;
                if (i == 4) {
                    addressResult.company = address;
                } else if (i == 3) {
                    addressResult.home = address;
                } else if (i == 1) {
                    if (CommonUtils.isFromRouteEditor(this.f7802g.fromType)) {
                        addressResult.common = address;
                    } else if (this.f7804i != null) {
                        addressResult.start = address;
                        addressResult.end = this.f7804i;
                    } else {
                        m5019p();
                        m4986a(address);
                        this.f7799d.getStartEditText().setText(address.displayName);
                        this.f7799d.getEndEditText().setText("");
                        addressResult.start = address;
                        return;
                    }
                } else if (i == 2) {
                    if (CommonUtils.isFromRouteEditor(this.f7802g.fromType)) {
                        addressResult.common = address;
                    } else if (CommonUtils.isValidLocation(this.f7803h)) {
                        addressResult.start = this.f7803h;
                        addressResult.end = address;
                    } else {
                        m5017o();
                        this.f7804i = address;
                        this.f7799d.getEndEditText().setText(address.displayName);
                        return;
                    }
                } else if (i == 5) {
                    addressResult.common = address;
                } else if (i == 6) {
                    addressResult.common = address;
                }
                m4979a(addressResult);
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m5004h() {
        Address address = this.f7803h;
        return address == null ? this.f7802g.addressParam.targetAddress : address;
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public Address m5006i() {
        Address address = this.f7804i;
        return address == null ? this.f7802g.addressParam.targetAddress : address;
    }

    /* renamed from: a */
    private boolean m4983a(int i, Address address) {
        if (!CommonUtils.isFromConfirmPage(this.f7802g.fromType) && !CommonUtils.isFromGetOnPage(this.f7802g.fromType)) {
            return false;
        }
        AddressResult addressResult = new AddressResult();
        addressResult.fromType = this.f7802g.fromType;
        addressResult.type = i;
        if (i == 1) {
            this.f7799d.getStartEditText().setText(address.displayName);
            addressResult.start = address;
            addressResult.isStartNeedNearRoad = this.f7809n;
            this.f7799d.addWatcherForStart();
        } else if (i == 2) {
            this.f7799d.removeEndTextWatcher();
            this.f7799d.getEndEditText().setText(address.displayName);
            addressResult.end = address;
            this.f7799d.addEndTextWatcher();
        } else {
            this.f7799d.getCommonEditText().setText(address.displayName);
            if (i == 3) {
                addressResult.home = address;
            } else if (i == 4) {
                addressResult.company = address;
            } else {
                throw new RuntimeException("Unknown address type with CONFIRM type");
            }
        }
        m4979a(addressResult);
        return true;
    }

    /* renamed from: a */
    private void m4979a(AddressResult addressResult) {
        if (this.f7796B) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f7805j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && this.f7802g.addressParam != null && this.f7802g.managerCallback != null && this.f7802g.addressParam.currentAddress != null) {
            this.f7802g.managerCallback.toLogin(getActivity(), this.f7802g.addressParam.currentAddress.latitude, this.f7802g.addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7800e.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
            int i = this.f7813r;
            if (i == 1 || i == 2) {
                this.f7800e.showSelectPoiFooterView(true);
            } else {
                this.f7800e.showSelectPoiFooterView(false);
            }
        } else if (CommonUtils.isFromGetOnPage(this.f7802g.fromType) || CommonUtils.isFromRouteEditor(this.f7802g.fromType)) {
            this.f7800e.showSelectPoiFooterView(false);
        } else if (CommonUtils.isFromConfirmPage(this.f7802g.fromType)) {
            int i2 = this.f7813r;
            if (i2 == 1 || i2 == 2) {
                this.f7800e.showSelectPoiFooterView(true);
            } else {
                this.f7800e.showSelectPoiFooterView(false);
            }
        } else {
            this.f7800e.showSelectPoiFooterView(z);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f7800e.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f7799d != null && !this.f7808m && !this.f7811p && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1364);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                String str = "";
                if (i == 1) {
                    m5001g();
                    m5009k();
                    if (this.f7799d.isStartTextNeedScrollToBottomWhenFocused) {
                        m5014m();
                    }
                    if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
                        m5028t();
                    }
                    m4977a(1, str, false);
                    this.f7800e.scrollToTop();
                    AddressTrack.trackStartPointViewClick(this.f7802g.addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(this.f7802g.fromType, this.f7802g.addressParam));
                    this.f7799d.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f7799d.getEndEditText().getText();
                    if (text != null) {
                        str = text.toString();
                    }
                    m4977a(2, str, false);
                    m5019p();
                    this.f7800e.scrollToTop();
                }
                this.f7799d.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f7803h != null) {
                    this.f7799d.getStartEditText().setText(this.f7803h.displayName);
                    if (this.f7803h.displayName != null && this.f7803h.displayName.equals(getResources().getString(R.string.global_sug_to_departure))) {
                        this.f7799d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                        m4999f();
                    } else if (CommonUtils.isFromHomePage(this.f7802g.fromType)) {
                        m5028t();
                    } else {
                        this.f7799d.getStartEditText().setTextColor(-16777216);
                    }
                }
            } else if (i == 2 && this.f7804i != null) {
                this.f7799d.getEndEditText().setText(this.f7804i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m5008j() {
        return AddressTrack.getCurrPage(this.f7813r, this.f7799d, this.f7800e);
    }

    /* renamed from: k */
    private void m5009k() {
        this.f7799d.getEndEditText().setText("");
    }

    /* renamed from: l */
    private void m5011l() {
        if (this.f7802g.addressParam != null && this.f7802g.addressParam.targetAddress != null) {
            this.f7799d.getStartEditText().setText(this.f7802g.addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m5014m() {
        if (!this.f7811p) {
            this.f7800e.addPoiListener(this.f7820y);
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f7799d.getStartEditText());
            this.f7800e.scrollToBottom();
        }
    }

    /* renamed from: n */
    private void m5016n() {
        if (!this.f7811p) {
            this.f7799d.getCommonEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: o */
    public void m5017o() {
        if (!this.f7811p) {
            this.f7799d.getStartEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: p */
    public void m5019p() {
        AddressTrack.isInSelectDestination = false;
        if (!this.f7811p) {
            this.f7799d.getEndEditText().requestFocus();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m5021q() {
        Editable text = this.f7799d.getStartEditText().getText();
        if (!TextUtils.isEmpty(text)) {
            Selection.setSelection(text, text.length(), 0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: r */
    public void m5024r() {
        this.f7799d.getStartEditText().setSelection(0);
    }

    public void onClick(int i) {
        if (this.f7799d != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, f7793a, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1469);
                m5001g();
                m5026s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7799d.getStartEditText(), true ^ this.f7811p);
                this.f7800e.scrollToTop();
                this.f7799d.addWatcherForStart();
                AddressTrack.isInSelectStart = false;
                if (this.f7799d.getStartEditText() != null && TextUtils.isEmpty(this.f7799d.getStartEditText().getText())) {
                    m4977a(i, "", false);
                }
            } else if (i == 2) {
                SystemUtils.log(3, f7793a, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressold.vamos.GlobalSugFragment", 1481);
                m5001g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7799d.getEndEditText(), true ^ this.f7811p);
                this.f7800e.scrollToTop();
                this.f7799d.addEndTextWatcher();
                AddressTrack.isInSelectDestination = false;
                if (this.f7799d.getEndEditText() != null && TextUtils.isEmpty(this.f7799d.getEndEditText().getText())) {
                    m4977a(i, "", false);
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m5026s() {
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(this.f7802g.addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText())) {
            this.f7799d.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f7799d != null) {
            setSearchViewType(i);
            if (i == 2 && this.f7816u) {
                this.f7816u = false;
            } else if (view.hasFocus()) {
                m4976a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m4976a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f7807l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f7807l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m4987a(addressParam);
    }

    public void setStartPoiInfo(SugParams sugParams) {
        this.f7799d.setStartText(sugParams);
    }

    /* renamed from: a */
    private boolean m4987a(AddressParam addressParam) {
        if (addressParam == null || this.f7799d == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f7799d.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f7799d.getEndEditText().hasFocus();
        }
        return this.f7799d.getCommonEditText().hasFocus();
    }

    public View getFallbackView() {
        return this.f7821z;
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f7813r, convertToAddress);
        }
    }

    /* renamed from: t */
    private void m5028t() {
        this.f7799d.getStartEditText().setTextColor(getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
        this.f7799d.getStartEditText().setHighlightColor(getResources().getColor(R.color.poi_one_address_text_start_normal_hint));
    }
}

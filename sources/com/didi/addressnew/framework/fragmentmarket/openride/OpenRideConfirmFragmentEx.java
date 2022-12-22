package com.didi.addressnew.framework.fragmentmarket.openride;

import android.animation.Animator;
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
import android.widget.AbsListView;
import android.widget.FrameLayout;
import com.didi.address.AddressResult;
import com.didi.address.GlobalSugCallback;
import com.didi.address.ISugControlCallback;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.address.util.PoiidCompleteUtils;
import com.didi.address.view.ISugViewController;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch.FuzzyMatchParam;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.utils.AddressConverter;
import com.didi.addressnew.presenter.AddressPresenter;
import com.didi.addressnew.presenter.ISimpleCompanyHomePresenter;
import com.didi.addressnew.presenter.SimpleCompanyHomePresenter;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.SugAnimationConstants;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.AddressAdapter;
import com.didi.addressnew.view.IAddressView;
import com.didi.addressnew.view.ISearchViewCallback;
import com.didi.addressnew.view.IStationFetcherView;
import com.didi.addressnew.view.SugListViewContainer;
import com.didi.addressnew.view.SugSearchView;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.didi.addressnew.view.enhance.WaittingAdapter;
import com.didi.addressnew.widget.EditTextErasable;
import com.didi.addressnew.widget.EmptyView;
import com.didi.addressnew.widget.NetErrorView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
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
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class OpenRideConfirmFragmentEx extends FragmentImpl implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = OpenRideConfirmFragmentEx.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<RpcPoi> f7229A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f7230B;

    /* renamed from: C */
    private boolean f7231C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RpcRecSug.TrackParameterForChild f7232D;

    /* renamed from: E */
    private FrameLayout f7233E = null;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public EmptyView f7234F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public NetErrorView f7235G = null;

    /* renamed from: H */
    private boolean f7236H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AddressAdapter.OnItemSelectedListener f7237I = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                boolean unused = OpenRideConfirmFragmentEx.this.f7257r = true;
            }
            OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType = OpenRideConfirmFragmentEx.this.f7253n;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = OpenRideConfirmFragmentEx.this.f7253n == 1 ? OpenRideConfirmFragmentEx.this.f7261v : OpenRideConfirmFragmentEx.this.f7262w;
            }
            int i3 = 3;
            int i4 = z ? 3 : 2;
            if (OpenRideConfirmFragmentEx.this.f7230B == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f7253n, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.switchMapConfirm(openRideConfirmFragmentEx.getmParam(), rpcPoi, trackParameterForChild, OpenRideConfirmFragmentEx.this.getmResult(), OpenRideConfirmFragmentEx.this.f7230B);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !OpenRideConfirmFragmentEx.this.f7261v : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (OpenRideConfirmFragmentEx.this.f7253n == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                OpenRideConfirmFragmentEx.this.f7250k.getGeocodeResult(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, OpenRideConfirmFragmentEx.this.f7253n, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        OpenRideConfirmFragmentEx.this.setResultBack(OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType, address);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = OpenRideConfirmFragmentEx.this.mo38934a(rpcPoi3);
                a.operationType = i4;
                if (OpenRideConfirmFragmentEx.this.f7253n != 2 || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f7253n, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideConfirmFragmentEx.this.f7253n, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (OpenRideConfirmFragmentEx.this.f7253n == 3 || OpenRideConfirmFragmentEx.this.f7253n == 4) {
                    if (OpenRideConfirmFragmentEx.this.f7244e != null) {
                        OpenRideConfirmFragmentEx.this.f7244e.removeCommonWatcher(OpenRideConfirmFragmentEx.this.getmParam().addressParam);
                        OpenRideConfirmFragmentEx.this.f7244e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    OpenRideConfirmFragmentEx.this.f7250k.setCommonAddress(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3);
                } else if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                    if (OpenRideConfirmFragmentEx.this.getSugCallback() == null || OpenRideConfirmFragmentEx.this.getSugCallback().getSugBuild() == null || OpenRideConfirmFragmentEx.this.getSugCallback().getSugBuild().getVersion() != 1) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx2.setResultBack(openRideConfirmFragmentEx2.f7253n, address);
                        if (!z) {
                            boolean unused2 = OpenRideConfirmFragmentEx.this.f7264y = true;
                            AddressTrack.trackRecItemSelect(i + 1);
                        }
                    } else {
                        SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = OpenRideConfirmFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx3.onConfirm(openRideConfirmFragmentEx3.getmParam(), iAddressResult.clone());
                        OpenRideConfirmFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused3 = OpenRideConfirmFragmentEx.this.f7265z = 1;
                        return;
                    }
                } else if (OpenRideConfirmFragmentEx.this.f7253n == 2) {
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx4 = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx4.setResultBack(openRideConfirmFragmentEx4.f7253n, address);
                }
                OpenRideConfirmFragmentEx.this.f7250k.recordClickPoi(OpenRideConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info);
            }
        }

        private String getSearchText() {
            if (OpenRideConfirmFragmentEx.this.f7244e == null) {
                return "";
            }
            if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                return OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f7253n == 2) {
                return OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f7253n == 3) {
                return OpenRideConfirmFragmentEx.this.f7244e.getCommonEditText().getText().toString();
            }
            if (OpenRideConfirmFragmentEx.this.f7253n == 4) {
                return OpenRideConfirmFragmentEx.this.f7244e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public AddressAdapter.OnMapConfirmClickListener f7238J = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.switchMapConfirm(openRideConfirmFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, OpenRideConfirmFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public View.OnClickListener f7239K = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (OpenRideConfirmFragmentEx.this.f7238J != null) {
                OpenRideConfirmFragmentEx.this.f7238J.onMapConfirmClicked(OpenRideConfirmFragmentEx.this.f7229A, OpenRideConfirmFragmentEx.this.f7232D, OpenRideConfirmFragmentEx.this.f7253n, OpenRideConfirmFragmentEx.this.f7230B);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f7240a;

    /* renamed from: b */
    CommonAddressReactor f7241b = new CommonAddressReactor();

    /* renamed from: c */
    int f7242c = 0;

    /* renamed from: d */
    private final int f7243d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f7244e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f7245f;

    /* renamed from: g */
    private ISugControlCallback f7246g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f7247h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f7248i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f7249j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f7250k;

    /* renamed from: l */
    private Handler f7251l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f7252m = 2;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f7253n = -1;

    /* renamed from: o */
    private int f7254o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f7255p;

    /* renamed from: q */
    private boolean f7256q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f7257r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f7258s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f7259t = false;

    /* renamed from: u */
    private boolean f7260u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7261v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f7262w = false;

    /* renamed from: x */
    private boolean f7263x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f7264y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f7265z = -1;

    public boolean getDragHandlerEnable() {
        return true;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ String getStringVal(int i) {
        return IView.CC.$default$getStringVal(this, i);
    }

    public void onClearClick(int i, String str) {
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

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null) {
            setCurrAddressType(getmParam().addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f7249j;
        if (globalSugCallback != null) {
            globalSugCallback.onAttach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4387a();
    }

    /* renamed from: a */
    private void m4387a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f7250k = new AddressPresenter(getActivity(), this);
        this.f7240a = new SimpleCompanyHomePresenter(getActivity());
        this.f7258s = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f7251l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    OpenRideConfirmFragmentEx.this.m4389a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f7253n = i;
    }

    public void setSearchViewType(int i) {
        this.f7252m = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        getActivity();
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m4390a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m4390a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f7244e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f7245f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f7233E = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f7234F = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f7235G = (NetErrorView) view.findViewById(R.id.net_view_error);
        m4412c();
        m4400b();
        m4416d();
        m4418e();
    }

    /* renamed from: b */
    private void m4400b() {
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(OpenRideConfirmFragmentEx.this.getActivity(), OpenRideConfirmFragmentEx.this.getView());
                    if (OpenRideConfirmFragmentEx.this.getSugCallback() != null) {
                        OpenRideConfirmFragmentEx.this.getSugCallback().onStartEndAddressChanged(OpenRideConfirmFragmentEx.this.m4424h(), OpenRideConfirmFragmentEx.this.f7248i);
                    }
                    if (!(OpenRideConfirmFragmentEx.this.getmParam() == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || OpenRideConfirmFragmentEx.this.m4424h() == null)) {
                        OpenRideConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(OpenRideConfirmFragmentEx.this.m4424h());
                    }
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.onConfirm(openRideConfirmFragmentEx.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx2.switchOpenRideWayPointer(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                }
            });
            storeStartAddress(getmParam().addressParam);
            this.f7248i = getmParam().endAddress;
            this.f7244e.initSugSearchView(getmParam());
            this.f7244e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    OpenRideConfirmFragmentEx.this.m4389a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m4446s();
            }
            m4393a(getmParam().addressParam);
            this.f7244e.setListener(getmParam().addressParam);
            this.f7244e.makeStartTextFocusedWhenIsRed();
            this.f7244e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(OpenRideConfirmFragmentEx.this.getmParam().fromType)) {
                        if (OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType == 1 && OpenRideConfirmFragmentEx.this.f7244e.isStartTextNeedScrollToBottomWhenFocused) {
                            OpenRideConfirmFragmentEx.this.m4434m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(OpenRideConfirmFragmentEx.this.getmParam().fromType) && OpenRideConfirmFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        OpenRideConfirmFragmentEx.this.m4446s();
                        OpenRideConfirmFragmentEx.this.f7244e.addWatcherForStart();
                    }
                }
            });
            this.f7244e.postDelayed(new Runnable() {
                public void run() {
                    if (OpenRideConfirmFragmentEx.this.f7245f != null) {
                        OpenRideConfirmFragmentEx.this.f7245f.setTopPadding(OpenRideConfirmFragmentEx.this.f7244e.getMeasuredHeight());
                    }
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.m4393a(openRideConfirmFragmentEx.getmParam().addressParam);
                }
            }, 200);
            if (this.f7244e.getStartEditText() != null) {
                this.f7244e.getStartEditText().setEnabled(false);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4393a(AddressParam addressParam) {
        if (addressParam.addressType == 2) {
            m4440p();
            EditTextErasable endEditText = this.f7244e.getEndEditText();
            if (endEditText != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m4438o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m4396a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f7253n;
    }

    /* renamed from: a */
    private boolean m4396a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 350);
        this.f7247h = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m4412c() {
        this.f7245f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                String str = OpenRideConfirmFragmentEx.TAG;
                SystemUtils.log(3, str, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + OpenRideConfirmFragmentEx.this.f7252m + ", mCurrAddressType: " + OpenRideConfirmFragmentEx.this.f7253n, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx$6", 368);
                AddressTrack.trackMapSelect(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f7253n, AddressPresenter.isLastCachedRecommendCache(OpenRideConfirmFragmentEx.this.f7253n));
                OpenRideConfirmFragmentEx.this.f7244e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    z = false;
                    if (OpenRideConfirmFragmentEx.this.f7253n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        z = true;
                    }
                } else {
                    z = OpenRideConfirmFragmentEx.this.f7253n == 1 ? OpenRideConfirmFragmentEx.this.f7261v : OpenRideConfirmFragmentEx.this.f7262w;
                }
                if (OpenRideConfirmFragmentEx.this.getmResult().getResult(OpenRideConfirmFragmentEx.this.f7253n) != null) {
                    OpenRideConfirmFragmentEx.this.getmResult().getResult(OpenRideConfirmFragmentEx.this.f7253n).operationType = !z ? 2 : 3;
                }
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.onConfirm(openRideConfirmFragmentEx.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideConfirmFragmentEx.this.f7253n;
                AddressResult addressResult = OpenRideConfirmFragmentEx.this.getmResult().getAddressResult();
                if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused = OpenRideConfirmFragmentEx.this.f7265z = 1;
                } else if (OpenRideConfirmFragmentEx.this.f7253n == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.switchMapSelect(clone, openRideConfirmFragmentEx2.getmResult(), OpenRideConfirmFragmentEx.this.f7253n, bundle);
            }
        });
        this.f7245f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f7245f.getListView());
                    if (OpenRideConfirmFragmentEx.this.f7242c != absListView.getFirstVisiblePosition()) {
                        int j = OpenRideConfirmFragmentEx.this.f7253n;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(OpenRideConfirmFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(OpenRideConfirmFragmentEx.this.getmParam().fromType, OpenRideConfirmFragmentEx.this.f7253n);
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                        AddressTrack.trackScrollCK(j, isFromRouteEditor ? 1 : 0, pageLevel, openRideConfirmFragmentEx.m4383a(openRideConfirmFragmentEx.f7253n), OpenRideConfirmFragmentEx.this.f7232D, OpenRideConfirmFragmentEx.this.f7242c, absListView.getFirstVisiblePosition(), OpenRideConfirmFragmentEx.this.f7253n == 1 ? OpenRideConfirmFragmentEx.this.f7261v : OpenRideConfirmFragmentEx.this.f7262w);
                    }
                }
                if (i == 1 || i == 2) {
                    OpenRideConfirmFragmentEx.this.f7242c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m4416d() {
        this.f7233E.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f7234F.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f7244e.getStartEditText();
                } else {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f7253n == 2 ? OpenRideConfirmFragmentEx.this.f7244e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f7235G.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f7244e.getStartEditText();
                } else {
                    editTextErasable = OpenRideConfirmFragmentEx.this.f7253n == 2 ? OpenRideConfirmFragmentEx.this.f7244e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f7234F.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f7235G.getRetryBtn() != null) {
            this.f7235G.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    OpenRideConfirmFragmentEx.this.f7234F.setVisibility(8);
                    if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx.m4401b(openRideConfirmFragmentEx.f7253n, OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().getText().toString(), true);
                    } else if (OpenRideConfirmFragmentEx.this.f7253n == 2) {
                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                        openRideConfirmFragmentEx2.m4401b(openRideConfirmFragmentEx2.f7253n, OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().getText().toString(), true);
                    }
                    view.postDelayed(new Runnable() {
                        public void run() {
                            view.setClickable(true);
                        }
                    }, 500);
                }
            });
        }
    }

    /* renamed from: b */
    private void m4402b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(OpenRideConfirmFragmentEx.this.f7253n == 3 && OpenRideConfirmFragmentEx.this.f7253n == 4)) {
                    AddressTrack.trackCloseButtonClick(OpenRideConfirmFragmentEx.this.getmParam(), OpenRideConfirmFragmentEx.this.m4428j());
                }
                if (OpenRideConfirmFragmentEx.this.f7249j != null) {
                    z = OpenRideConfirmFragmentEx.this.f7249j.onCloseButtonIntercept();
                }
                if (!z) {
                    OpenRideConfirmFragmentEx.this.closeFragment();
                    if (OpenRideConfirmFragmentEx.this.f7249j != null) {
                        OpenRideConfirmFragmentEx.this.f7249j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m4418e() {
        this.f7245f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f7253n - 1, OpenRideConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = OpenRideConfirmFragmentEx.this.f7245f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(OpenRideConfirmFragmentEx.this.getmParam(), homeAddress, OpenRideConfirmFragmentEx.this.f7253n);
                    homeAddress.operationType = 4;
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.setResultBack(openRideConfirmFragmentEx.f7253n, homeAddress);
                    return;
                }
                OpenRideConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.onConfirm(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx3.switchSingle(openRideConfirmFragmentEx3.getmParam(), OpenRideConfirmFragmentEx.this.getmResult(), 3);
                int unused = OpenRideConfirmFragmentEx.this.f7265z = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(OpenRideConfirmFragmentEx.this.getmParam().addressParam, OpenRideConfirmFragmentEx.this.f7253n - 1, OpenRideConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = OpenRideConfirmFragmentEx.this.f7245f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(OpenRideConfirmFragmentEx.this.getmParam(), companyAddress, OpenRideConfirmFragmentEx.this.f7253n);
                    companyAddress.operationType = 5;
                    OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                    openRideConfirmFragmentEx.setResultBack(openRideConfirmFragmentEx.f7253n, companyAddress);
                    return;
                }
                OpenRideConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.onConfirm(openRideConfirmFragmentEx2.getmParam(), OpenRideConfirmFragmentEx.this.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx3.switchSingle(openRideConfirmFragmentEx3.getmParam(), OpenRideConfirmFragmentEx.this.getmResult(), 4);
                int unused = OpenRideConfirmFragmentEx.this.f7265z = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideConfirmFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(OpenRideConfirmFragmentEx.this.f7245f.getHomeAddress()), CommonUtils.isValidLocation(OpenRideConfirmFragmentEx.this.f7245f.getCompanyAddress()), OpenRideConfirmFragmentEx.this.f7253n - 1);
                SugParams clone = OpenRideConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideConfirmFragmentEx.this.f7253n;
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx.onConfirm(clone, openRideConfirmFragmentEx.getmResult());
                OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                openRideConfirmFragmentEx2.switchFavorite(clone, openRideConfirmFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m4384a(AddressResult addressResult) {
        String str;
        String str2;
        String str3;
        String str4;
        if (addressResult == null) {
            return "，";
        }
        if (addressResult.start != null) {
            str = "，" + "[起点:" + addressResult.start.displayName + "]\n";
        } else {
            str = "，[起点没设]\n";
        }
        if (addressResult.end != null) {
            str2 = str + "[终点:" + addressResult.end.displayName + "]\n";
        } else {
            str2 = str + "[终点没设]\n";
        }
        if (addressResult.home != null) {
            str3 = str2 + "[家:" + addressResult.home.displayName + "]\n";
        } else {
            str3 = str2 + "[家没设]\n";
        }
        if (addressResult.company != null) {
            str4 = str3 + "[公司点:" + addressResult.company.displayName + "]\n";
        } else {
            str4 = str3 + "[公司没设]\n";
        }
        if (addressResult.common != null) {
            return str4 + "[常点:" + addressResult.common.displayName + "]\n";
        }
        return str4 + "[常点没设]\n";
    }

    public void setSugControlCallback(ISugControlCallback iSugControlCallback) {
        this.f7246g = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f7236H = z;
    }

    public ISugViewController getSugViewController() {
        return this.f7245f;
    }

    public String getStartAddressText() {
        return this.f7244e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f7244e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f7244e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f7245f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7245f.getListView().setAdapter(waittingAdapter);
        }
    }

    public String getStringSafe(int i) {
        return getStringVal(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4389a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 699);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f7244e.post(new Runnable() {
                public void run() {
                    if (!OpenRideConfirmFragmentEx.this.f7258s && OpenRideConfirmFragmentEx.this.f7235G.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || OpenRideConfirmFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            OpenRideConfirmFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            if (m4397a(str)) {
                if (i == 2) {
                    this.f7262w = true;
                } else if (i == 1) {
                    this.f7261v = true;
                }
                this.f7250k.processDataRequire(clone, str, z, i);
                return;
            }
            this.f7250k.processDataRequire(clone, "", z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4401b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 737);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f7244e.post(new Runnable() {
                public void run() {
                    if (!OpenRideConfirmFragmentEx.this.f7258s) {
                        OpenRideConfirmFragmentEx.this.f7245f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(OpenRideConfirmFragmentEx.this.getActivity()) - OpenRideConfirmFragmentEx.this.f7244e.getHeight()) / DisplayUtils.dp2px(OpenRideConfirmFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            if (m4397a(str)) {
                if (i == 2) {
                    this.f7262w = true;
                } else if (i == 1) {
                    this.f7261v = true;
                }
                this.f7250k.getSuggestPoiList(clone, str, z, i, true);
                return;
            }
            this.f7250k.processDataRequire(clone, "", z, i);
        }
    }

    /* renamed from: a */
    private boolean m4397a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f7253n == 1 && (((address2 = this.f7247h) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f7253n != 2 || (address = this.f7248i) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f7258s = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f7245f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f7264y && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
            AddressTrack.trackRecItemSelect(0);
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public boolean closeFragment() {
        m4421g();
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager != null) {
            try {
                if (fragmentManager.getBackStackEntryCount() > 1) {
                    fragmentManager.popBackStackImmediate();
                    return true;
                }
                fragmentManager.popBackStackImmediate();
                return false;
            } catch (Exception e) {
                DLog.m7384d("sfs", "GlobalSugFragment closeFragment() err msg: " + e.getMessage(), new Object[0]);
            }
        }
        return false;
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(getmParam(), this.f7244e, this.f7245f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.setStartAddressDrawableLeftGrey();
            if (this.f7244e.getStartEditText() != null) {
                this.f7244e.getStartEditText().setTextColor(-3355444);
            }
        }
        m4389a(getmParam().addressParam.addressType, "", false);
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f7244e.getStartwithEndFullSize());
        m4419f();
    }

    /* renamed from: b */
    private void m4406b(RpcPoi rpcPoi) {
        if (this.f7250k != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f7250k.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m4419f() {
        if (this.f7250k != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f7250k.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m4421g() {
        AddressPresenter addressPresenter = this.f7250k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f7250k.stopRevertGeo();
        }
    }

    public void onResume() {
        this.f7259t = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f7250k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        this.f7259t = false;
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f7250k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38935a(GlobalSugCallback globalSugCallback) {
        this.f7249j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f7249j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach(getmParam() != null ? getmParam().addressParam.addressType : Integer.MIN_VALUE);
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
        this.f7234F.setVisibility(8);
        this.f7235G.setVisibility(8);
        this.f7245f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo38934a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f7245f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            boolean z = false;
            if (this.f7263x && !this.f7264y && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                AddressTrack.trackRecItemSelect(0);
            }
            this.f7264y = false;
            if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                z = true;
            }
            this.f7263x = z;
            this.f7245f.post(new Runnable() {
                public void run() {
                    if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                        ArrayList unused = OpenRideConfirmFragmentEx.this.f7229A = arrayList;
                        OpenRideConfirmFragmentEx.this.f7245f.getMapConfirmView().setOnClickListener(OpenRideConfirmFragmentEx.this.f7239K);
                    }
                    RpcRecSug.TrackParameterForChild unused2 = OpenRideConfirmFragmentEx.this.f7232D = trackParameterForChild;
                    int unused3 = OpenRideConfirmFragmentEx.this.f7230B = i;
                    AddressAdapter addressAdapter = new AddressAdapter();
                    addressAdapter.setOnItemSelectedListener(OpenRideConfirmFragmentEx.this.f7237I);
                    addressAdapter.updateAddress(arrayList, OpenRideConfirmFragmentEx.this.getmParam().clone(), trackParameterForChild, OpenRideConfirmFragmentEx.this.f7253n, i);
                    SugListViewContainer h = OpenRideConfirmFragmentEx.this.f7245f;
                    ArrayList arrayList = arrayList;
                    h.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                    OpenRideConfirmFragmentEx.this.f7245f.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f7245f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7245f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7245f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f7245f.onlyShowSelectPoiFooterView();
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f7234F.setVisibility(8);
        this.f7235G.setVisibility(0);
        this.f7235G.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        this.f7245f.onlyShowSelectPoiFooterView();
        this.f7235G.setVisibility(8);
        this.f7234F.setVisibility(0);
        this.f7234F.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f7234F.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f7235G;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f7234F;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1357);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f7257r;
            if (m4394a(i, address)) {
                closeSessionWithResult(getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m4424h() {
        Address address = this.f7247h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: i */
    private Address m4426i() {
        Address address = this.f7248i;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: b */
    private void m4403b(AddressResult addressResult) {
        if (this.f7236H) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getContext().getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f7249j;
        if (globalSugCallback != null) {
            globalSugCallback.setResult(addressResult);
        }
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && getmParam() != null && getmParam().managerCallback != null && getmParam().addressParam.currentAddress != null) {
            getmParam().managerCallback.toLogin(getActivity(), getmParam().addressParam.currentAddress.latitude, getmParam().addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7245f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        this.f7245f.showSelectPoiFooterView(true);
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f7231C = false;
        } else {
            this.f7231C = true;
        }
        this.f7245f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f7244e != null && !this.f7256q && !this.f7258s && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1477);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m4383a(i));
                if (i == 1) {
                    m4421g();
                    if (this.f7244e.isStartTextNeedScrollToBottomWhenFocused) {
                        m4434m();
                    }
                    m4389a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f7244e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f7244e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m4389a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f7244e.getEndEditText(), !this.f7258s);
                }
                this.f7244e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f7247h != null) {
                    this.f7244e.getStartEditText().setText(this.f7247h.displayName);
                    if (this.f7247h.displayName == null || !this.f7247h.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f7244e.getStartEditText().setTextColor(-16777216);
                        return;
                    }
                    this.f7244e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m4419f();
                }
            } else if (i == 2 && this.f7248i != null) {
                this.f7244e.getEndEditText().setText(this.f7248i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m4383a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f7244e.getEndEditText().getText().toString().trim();
        }
        return (this.f7244e.getCommonEditText() == null || TextUtils.isEmpty(this.f7244e.getCommonEditText().getText())) ? "" : this.f7244e.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m4428j() {
        return AddressTrack.getCurrPage(this.f7253n, this.f7244e, this.f7245f);
    }

    /* renamed from: k */
    private void m4429k() {
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* renamed from: l */
    private void m4431l() {
        if (getmParam() != null && getmParam().addressParam.targetAddress != null) {
            this.f7244e.getStartEditText().setText(getmParam().addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m4434m() {
        SugSearchView sugSearchView;
        if (!this.f7258s && (sugSearchView = this.f7244e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f7244e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f7244e.getStartEditText());
        }
    }

    /* renamed from: n */
    private void m4436n() {
        SugSearchView sugSearchView;
        if (!this.f7258s && (sugSearchView = this.f7244e) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: o */
    private void m4438o() {
        SugSearchView sugSearchView;
        if (!this.f7258s && (sugSearchView = this.f7244e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f7244e.setPressedState(true);
            }
            this.f7244e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: p */
    private void m4440p() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f7258s && (sugSearchView = this.f7244e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f7244e.setPressedState(true);
            }
            this.f7244e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: q */
    private void m4441q() {
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: r */
    private void m4444r() {
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f7244e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1654);
                m4421g();
                m4446s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7244e.getStartEditText(), true ^ this.f7258s);
                this.f7244e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideConfirmFragmentEx", 1661);
                m4421g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7244e.getEndEditText(), true ^ this.f7258s);
                this.f7244e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m4446s() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f7244e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f7244e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f7260u) {
                this.f7260u = false;
            } else if (view.hasFocus()) {
                m4388a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m4388a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f7251l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f7251l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m4409b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
            this.f7244e.getStartEditText().setTextColor(-3355444);
        }
    }

    /* renamed from: b */
    private boolean m4409b(AddressParam addressParam) {
        if (addressParam == null || this.f7244e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f7244e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f7244e.getEndEditText().hasFocus();
        }
        return this.f7244e.getCommonEditText().hasFocus();
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f7253n, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m4394a(int i, Address address) {
        if (!CommonUtils.isValidLocation(address)) {
            return false;
        }
        if (i == 1) {
            if (address != null) {
                if (TextUtils.isEmpty(address.displayName) && isFragmentOnDuty()) {
                    DLog.m7384d("SugAddress", "start address.displayName = null,address = " + address, new Object[0]);
                    address.displayName = getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                }
                PoiidCompleteUtils.completePoiid(address);
            }
            Address address2 = this.f7248i;
            if (address2 != null) {
                if (!CommonUtils.isTwoAddressEqual(address2, address)) {
                    getmResult().setStart(address);
                    getmResult().setEnd(this.f7248i);
                    onConfirm(getmParam(), getmResult());
                } else {
                    CommonUtils.showDuplicateAlert(getContext());
                    return false;
                }
            }
        } else if (i == 2 && CommonUtils.isValidLocation(this.f7247h)) {
            if (!CommonUtils.isTwoAddressEqual(this.f7247h, address)) {
                getmResult().setStart(this.f7247h);
                getmResult().setEnd(address);
                onConfirm(getmParam(), getmResult());
            } else {
                CommonUtils.showDuplicateAlert(getContext());
                return false;
            }
        }
        return true;
    }

    public void onPageEnter() {
        long j;
        SugSearchView sugSearchView;
        if (this.f7244e != null) {
            final int i = this.f7253n;
            final int i2 = this.f7265z;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f7253n;
                if (i3 == 1) {
                    getmResult().setStart(this.f7247h);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f7248i);
                }
            }
            super.onPageEnter();
            boolean z = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit;
            final boolean z2 = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Chose;
            final boolean z3 = getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.FuzzyMatch;
            boolean z4 = getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel;
            if (!z && !z2 && !z3 && !z4) {
                if (CommonUtils.isFromGetOnPage(getmParam().fromType) || CommonUtils.isFromNewConfirmPage(getmParam().fromType) || CommonUtils.isFromHomePage(getmParam().fromType)) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_one, 0);
                }
                if (CommonUtils.isFromRouteEditor(getmParam().fromType)) {
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f7253n);
                }
            }
            this.f7244e.setSearchViewCallback((ISearchViewCallback) null);
            this.f7244e.removeWatcherForStart();
            this.f7244e.removeEndTextWatcher();
            this.f7244e.hideShadow();
            SugSearchView sugSearchView2 = this.f7244e;
            if (sugSearchView2 != null) {
                sugSearchView2.getStartEditText().setFocusable(false);
                this.f7244e.getStartEditText().setFocusableInTouchMode(false);
                this.f7244e.getEndEditText().setFocusable(false);
                this.f7244e.getEndEditText().setFocusableInTouchMode(false);
                this.f7244e.postDelayed(new Runnable() {
                    public void run() {
                        OpenRideConfirmFragmentEx.this.f7244e.addWatcherForStart();
                        OpenRideConfirmFragmentEx.this.f7244e.addEndTextWatcher();
                        OpenRideConfirmFragmentEx.this.f7244e.setSearchViewCallback(OpenRideConfirmFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView3 = this.f7244e;
            if (sugSearchView3 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z2;
                final boolean z8 = z3;
                sugSearchView3.postDelayed(new Runnable() {
                    public void run() {
                        if (OpenRideConfirmFragmentEx.this.f7244e != null) {
                            OpenRideConfirmFragmentEx.this.f7244e.setSearchViewCallback(OpenRideConfirmFragmentEx.this);
                            OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setFocusable(true);
                            OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setFocusableInTouchMode(true);
                            OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().setFocusable(true);
                            OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (!OpenRideConfirmFragmentEx.this.isFirstEnter() && !z5 && !z6 && i2 == -1) {
                            return;
                        }
                        if (i4 == 1 && !z7 && !z8) {
                            OpenRideConfirmFragmentEx.this.f7244e.setPressedState(false);
                            if (OpenRideConfirmFragmentEx.this.f7244e != null) {
                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().requestFocus();
                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setTextIsSelectable(true);
                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setCursorVisible(false);
                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setCursorVisible(true);
                                if ((OpenRideConfirmFragmentEx.this.isFirstEnter() || !OpenRideConfirmFragmentEx.this.f7259t) && OpenRideConfirmFragmentEx.this.getmResult().getResult(i4) != null) {
                                    OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getResult(i4).displayName);
                                }
                                if (!TextUtils.isEmpty(OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().getText())) {
                                    OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setClearIconVisible(true);
                                }
                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().length());
                            }
                        } else if (i4 == 2) {
                            if (OpenRideConfirmFragmentEx.this.f7244e != null) {
                                OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().requestFocus();
                            }
                            OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f7244e.getEndEditText().length());
                        }
                    }
                }, 30);
                this.f7244e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !OpenRideConfirmFragmentEx.this.f7259t) {
                            return;
                        }
                        if (z3 && !OpenRideConfirmFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (OpenRideConfirmFragmentEx.this.f7253n == 1) {
                            ViewUtils.showInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f7244e.getStartEditText());
                            OpenRideConfirmFragmentEx.this.f7244e.resetShadow(OpenRideConfirmFragmentEx.this.f7244e.getStartEditText());
                        } else if (OpenRideConfirmFragmentEx.this.f7253n == 2) {
                            ViewUtils.showInputMethodForEditText(OpenRideConfirmFragmentEx.this.getContext(), OpenRideConfirmFragmentEx.this.f7244e.getEndEditText());
                            OpenRideConfirmFragmentEx.this.f7244e.resetShadow(OpenRideConfirmFragmentEx.this.f7244e.getEndEditText());
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !this.f7259t) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f7265z;
                        if (i5 == 3) {
                            if (this.f7245f != null && getmResult().getAddressResult().home != null) {
                                this.f7245f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone = getmParam().addressParam.clone();
                                clone.addressType = 3;
                                this.f7240a.setHomeCompany(clone, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f7241b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f7241b.onHomeUploadFailed();
                            }
                            this.f7265z = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f7245f != null && getmResult().getAddressResult().company != null) {
                                this.f7245f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone2 = getmParam().addressParam.clone();
                                clone2.addressType = 4;
                                this.f7240a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f7241b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f7241b.onCompanyUploadFailed();
                            }
                            this.f7265z = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().start != null) {
                                SugSearchView sugSearchView4 = this.f7244e;
                                if (sugSearchView4 != null) {
                                    sugSearchView4.postDelayed(new Runnable() {
                                        public void run() {
                                            if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                                OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                                OpenRideConfirmFragmentEx.this.m4389a(i, "", false);
                                            }
                                            OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().requestFocus();
                                            OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setSelection(0, OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().length());
                                            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                            String unused = openRideConfirmFragmentEx.f7255p = openRideConfirmFragmentEx.getmResult().getAddressResult().start.displayName;
                                        }
                                    }, j);
                                }
                            } else {
                                Address address = getmResult().getAddressResult().start;
                            }
                            this.f7265z = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f7265z;
                        if (i6 == 3) {
                            if (this.f7245f != null && getmResult().getAddressResult().home != null) {
                                this.f7245f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone3 = getmParam().addressParam.clone();
                                clone3.addressType = this.f7265z;
                                this.f7240a.setHomeCompany(clone3, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f7241b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f7241b.onHomeUploadFailed();
                            }
                            this.f7265z = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f7245f != null && getmResult().getAddressResult().company != null) {
                                this.f7245f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone4 = getmParam().addressParam.clone();
                                clone4.addressType = this.f7265z;
                                this.f7240a.setHomeCompany(clone4, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f7241b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f7241b.onCompanyUploadFailed();
                            }
                            this.f7265z = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f7244e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f7244e.postDelayed(new Runnable() {
                                public void run() {
                                    if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().setText(OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        OpenRideConfirmFragmentEx.this.m4389a(i, "", false);
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                        Address unused = openRideConfirmFragmentEx.f7247h = openRideConfirmFragmentEx.getmResult().getAddressResult().start;
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx2 = OpenRideConfirmFragmentEx.this;
                                        openRideConfirmFragmentEx2.onStartChoosen(openRideConfirmFragmentEx2.f7247h);
                                        OpenRideConfirmFragmentEx.this.f7244e.getStartEditText().requestFocus();
                                        OpenRideConfirmFragmentEx openRideConfirmFragmentEx3 = OpenRideConfirmFragmentEx.this;
                                        openRideConfirmFragmentEx3.setResultBack(i, openRideConfirmFragmentEx3.f7247h);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f7244e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f7244e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f7244e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            this.f7248i = getmResult().getAddressResult().end;
                            if (!isFirstEnter() && this.f7248i != null) {
                                this.f7244e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (OpenRideConfirmFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
                                            openRideConfirmFragmentEx.setResultBack(i, openRideConfirmFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f7248i != null) {
                            this.f7244e.getEndEditText().setText(this.f7248i.displayName);
                        } else {
                            m4429k();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        int i = 0;
        this.f7259t = false;
        SugSearchView sugSearchView = this.f7244e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f7244e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i2 = this.f7253n;
            if (i2 == 1) {
                if (this.f7247h == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f7247h);
                }
                if (this.f7244e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f7244e.getStartEditText());
                }
            } else if (i2 == 2) {
                if (this.f7248i != null) {
                    getmResult().setEnd(this.f7248i);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f7245f;
                    if (sugListViewContainer != null) {
                        i = sugListViewContainer.getVisibleCount();
                    }
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, i);
                }
                if (this.f7244e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f7244e.getEndEditText());
                }
            }
        }
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.FULL;
    }

    public SugSearchView getmSugSearchView() {
        return this.f7244e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f7253n == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m4407b(openRideConfirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m4414c(openRideConfirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m4414c(openRideConfirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            OpenRideConfirmFragmentEx openRideConfirmFragmentEx = OpenRideConfirmFragmentEx.this;
            openRideConfirmFragmentEx.m4407b(openRideConfirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !OpenRideConfirmFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4407b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4414c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        boolean z = false;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        if (this.f7253n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
            z = true;
        }
        int i2 = z ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f7229A);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f7231C);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f7253n;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f7265z = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f7265z = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        switchMapConfirm(clone, iAddressResult, this.f7253n, bundle);
        return true;
    }
}

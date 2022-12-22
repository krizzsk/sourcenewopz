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
import com.didi.addressnew.util.CheckParamUtil;
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

public class OpenRideFragmentEx extends FragmentImpl implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = "OpenRideFragmentEx";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public ArrayList<RpcPoi> f7266A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public int f7267B;

    /* renamed from: C */
    private boolean f7268C;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public RpcRecSug.TrackParameterForChild f7269D;

    /* renamed from: E */
    private FrameLayout f7270E = null;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public EmptyView f7271F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public NetErrorView f7272G = null;

    /* renamed from: H */
    private boolean f7273H = true;
    /* access modifiers changed from: private */

    /* renamed from: I */
    public AddressAdapter.OnItemSelectedListener f7274I = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (OpenRideFragmentEx.this.f7290n == 1) {
                boolean unused = OpenRideFragmentEx.this.f7294r = true;
            }
            OpenRideFragmentEx.this.getmParam().addressParam.addressType = OpenRideFragmentEx.this.f7290n;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = OpenRideFragmentEx.this.f7290n == 1 ? OpenRideFragmentEx.this.f7298v : OpenRideFragmentEx.this.f7299w;
            }
            int i3 = 3;
            int i4 = z ? 3 : 2;
            if (OpenRideFragmentEx.this.f7267B == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f7290n, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.switchMapConfirm(openRideFragmentEx.getmParam(), rpcPoi, trackParameterForChild, OpenRideFragmentEx.this.getmResult(), OpenRideFragmentEx.this.f7267B);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (OpenRideFragmentEx.this.f7290n == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !OpenRideFragmentEx.this.f7298v : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (OpenRideFragmentEx.this.f7290n == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                OpenRideFragmentEx.this.f7287k.getGeocodeResult(OpenRideFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, OpenRideFragmentEx.this.f7290n, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        OpenRideFragmentEx.this.setResultBack(OpenRideFragmentEx.this.getmParam().addressParam.addressType, address);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = OpenRideFragmentEx.this.mo38966a(rpcPoi3);
                a.operationType = i4;
                if (OpenRideFragmentEx.this.f7290n != 2 || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f7290n, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, OpenRideFragmentEx.this.f7290n, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (OpenRideFragmentEx.this.f7290n == 3 || OpenRideFragmentEx.this.f7290n == 4) {
                    if (OpenRideFragmentEx.this.f7281e != null) {
                        OpenRideFragmentEx.this.f7281e.removeCommonWatcher(OpenRideFragmentEx.this.getmParam().addressParam);
                        OpenRideFragmentEx.this.f7281e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    OpenRideFragmentEx.this.f7287k.setCommonAddress(OpenRideFragmentEx.this.getmParam(), rpcPoi3);
                } else if (OpenRideFragmentEx.this.f7290n == 1) {
                    if (OpenRideFragmentEx.this.getSugCallback() == null || OpenRideFragmentEx.this.getSugCallback().getSugBuild() == null || OpenRideFragmentEx.this.getSugCallback().getSugBuild().getVersion() != 1) {
                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                        openRideFragmentEx2.setResultBack(openRideFragmentEx2.f7290n, address);
                        if (!z) {
                            boolean unused2 = OpenRideFragmentEx.this.f7301y = true;
                            AddressTrack.trackRecItemSelect(i + 1);
                        }
                    } else {
                        SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = OpenRideFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                        openRideFragmentEx3.onConfirm(openRideFragmentEx3.getmParam(), iAddressResult.clone());
                        OpenRideFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused3 = OpenRideFragmentEx.this.f7302z = 1;
                        return;
                    }
                } else if (OpenRideFragmentEx.this.f7290n == 2) {
                    OpenRideFragmentEx openRideFragmentEx4 = OpenRideFragmentEx.this;
                    openRideFragmentEx4.setResultBack(openRideFragmentEx4.f7290n, address);
                }
                OpenRideFragmentEx.this.f7287k.recordClickPoi(OpenRideFragmentEx.this.getmParam(), rpcPoi3.base_info);
            }
        }

        private String getSearchText() {
            if (OpenRideFragmentEx.this.f7281e == null) {
                return "";
            }
            if (OpenRideFragmentEx.this.f7290n == 1) {
                return OpenRideFragmentEx.this.f7281e.getStartEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f7290n == 2) {
                return OpenRideFragmentEx.this.f7281e.getEndEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f7290n == 3) {
                return OpenRideFragmentEx.this.f7281e.getCommonEditText().getText().toString();
            }
            if (OpenRideFragmentEx.this.f7290n == 4) {
                return OpenRideFragmentEx.this.f7281e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: J */
    public AddressAdapter.OnMapConfirmClickListener f7275J = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.switchMapConfirm(openRideFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, OpenRideFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public View.OnClickListener f7276K = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (OpenRideFragmentEx.this.f7275J != null) {
                OpenRideFragmentEx.this.f7275J.onMapConfirmClicked(OpenRideFragmentEx.this.f7266A, OpenRideFragmentEx.this.f7269D, OpenRideFragmentEx.this.f7290n, OpenRideFragmentEx.this.f7267B);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f7277a;

    /* renamed from: b */
    CommonAddressReactor f7278b = new CommonAddressReactor();

    /* renamed from: c */
    int f7279c = 0;

    /* renamed from: d */
    private final int f7280d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f7281e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f7282f;

    /* renamed from: g */
    private ISugControlCallback f7283g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f7284h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f7285i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f7286j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f7287k;

    /* renamed from: l */
    private Handler f7288l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f7289m = 2;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f7290n = -1;

    /* renamed from: o */
    private int f7291o = -1;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public String f7292p;

    /* renamed from: q */
    private boolean f7293q;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f7294r = true;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f7295s;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f7296t = false;

    /* renamed from: u */
    private boolean f7297u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7298v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f7299w = false;

    /* renamed from: x */
    private boolean f7300x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f7301y = false;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f7302z = -1;

    public boolean getDragHandlerEnable() {
        return true;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ String getStringVal(int i) {
        return IView.CC.$default$getStringVal(this, i);
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
        if (getmParam() != null) {
            Context context = getContext();
            CheckParamUtil.rescueAddressParam(context, getClass().getSimpleName() + " onAttach", getmParam().addressParam);
            setCurrAddressType(getmParam().addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f7286j;
        if (globalSugCallback != null) {
            globalSugCallback.onAttach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4467a();
    }

    /* renamed from: a */
    private void m4467a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f7287k = new AddressPresenter(getActivity(), this);
        this.f7277a = new SimpleCompanyHomePresenter(getActivity());
        this.f7295s = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f7288l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    OpenRideFragmentEx.this.m4469a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f7290n = i;
    }

    public void setSearchViewType(int i) {
        this.f7289m = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        getActivity();
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m4470a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m4470a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f7281e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f7282f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f7270E = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f7271F = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f7272G = (NetErrorView) view.findViewById(R.id.net_view_error);
        m4492c();
        m4480b();
        m4496d();
        m4498e();
    }

    /* renamed from: b */
    private void m4480b() {
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(OpenRideFragmentEx.this.getActivity(), OpenRideFragmentEx.this.getView());
                    if (OpenRideFragmentEx.this.getSugCallback() != null) {
                        OpenRideFragmentEx.this.getSugCallback().onStartEndAddressChanged(OpenRideFragmentEx.this.m4504h(), OpenRideFragmentEx.this.f7285i);
                    }
                    if (!(OpenRideFragmentEx.this.getmParam() == null || OpenRideFragmentEx.this.getmParam().wayPointParam == null || OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || OpenRideFragmentEx.this.m4504h() == null)) {
                        OpenRideFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(OpenRideFragmentEx.this.m4504h());
                    }
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.onConfirm(openRideFragmentEx.getmParam(), OpenRideFragmentEx.this.getmResult());
                    OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                    openRideFragmentEx2.switchOpenRideWayPointer(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                }
            });
            storeStartAddress(getmParam().addressParam);
            this.f7285i = getmParam().endAddress;
            this.f7281e.initSugSearchView(getmParam());
            if (this.f7281e.getStartEditText() != null) {
                this.f7281e.getStartEditText().setEnabled(false);
            }
            this.f7281e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    OpenRideFragmentEx.this.m4469a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m4526s();
            }
            m4473a(getmParam().addressParam);
            this.f7281e.setListener(getmParam().addressParam);
            this.f7281e.makeStartTextFocusedWhenIsRed();
            this.f7281e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(OpenRideFragmentEx.this.getmParam().fromType)) {
                        if (OpenRideFragmentEx.this.getmParam().addressParam.addressType == 1 && OpenRideFragmentEx.this.f7281e.isStartTextNeedScrollToBottomWhenFocused) {
                            OpenRideFragmentEx.this.m4514m();
                        }
                    } else if (CommonUtils.isFromGetOnPage(OpenRideFragmentEx.this.getmParam().fromType) && OpenRideFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        OpenRideFragmentEx.this.m4526s();
                        OpenRideFragmentEx.this.f7281e.addWatcherForStart();
                    }
                }
            });
            this.f7281e.postDelayed(new Runnable() {
                public void run() {
                    if (OpenRideFragmentEx.this.f7282f != null) {
                        OpenRideFragmentEx.this.f7282f.setTopPadding(OpenRideFragmentEx.this.f7281e.getMeasuredHeight());
                    }
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.m4473a(openRideFragmentEx.getmParam().addressParam);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4473a(AddressParam addressParam) {
        if (addressParam.addressType == 2) {
            m4520p();
            EditTextErasable endEditText = this.f7281e.getEndEditText();
            if (endEditText != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m4518o();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m4476a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f7290n;
    }

    /* renamed from: a */
    private boolean m4476a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 350);
        this.f7284h = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m4492c() {
        this.f7282f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                SystemUtils.log(3, OpenRideFragmentEx.TAG, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + OpenRideFragmentEx.this.f7289m + ", mCurrAddressType: " + OpenRideFragmentEx.this.f7290n, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx$6", 368);
                AddressTrack.trackMapSelect(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f7290n, AddressPresenter.isLastCachedRecommendCache(OpenRideFragmentEx.this.f7290n));
                OpenRideFragmentEx.this.f7281e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    z = false;
                    if (OpenRideFragmentEx.this.f7290n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        z = true;
                    }
                } else {
                    z = OpenRideFragmentEx.this.f7290n == 1 ? OpenRideFragmentEx.this.f7298v : OpenRideFragmentEx.this.f7299w;
                }
                if (OpenRideFragmentEx.this.getmResult().getResult(OpenRideFragmentEx.this.f7290n) != null) {
                    OpenRideFragmentEx.this.getmResult().getResult(OpenRideFragmentEx.this.f7290n).operationType = !z ? 2 : 3;
                }
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.onConfirm(openRideFragmentEx.getmParam(), OpenRideFragmentEx.this.getmResult());
                SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideFragmentEx.this.f7290n;
                AddressResult addressResult = OpenRideFragmentEx.this.getmResult().getAddressResult();
                if (OpenRideFragmentEx.this.f7290n == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused = OpenRideFragmentEx.this.f7302z = 1;
                } else if (OpenRideFragmentEx.this.f7290n == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.switchMapSelect(clone, openRideFragmentEx2.getmResult(), OpenRideFragmentEx.this.f7290n, bundle);
            }
        });
        this.f7282f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f7282f.getListView());
                    if (OpenRideFragmentEx.this.f7279c != absListView.getFirstVisiblePosition()) {
                        int j = OpenRideFragmentEx.this.f7290n;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(OpenRideFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(OpenRideFragmentEx.this.getmParam().fromType, OpenRideFragmentEx.this.f7290n);
                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                        AddressTrack.trackScrollCK(j, isFromRouteEditor ? 1 : 0, pageLevel, openRideFragmentEx.m4463a(openRideFragmentEx.f7290n), OpenRideFragmentEx.this.f7269D, OpenRideFragmentEx.this.f7279c, absListView.getFirstVisiblePosition(), OpenRideFragmentEx.this.f7290n == 1 ? OpenRideFragmentEx.this.f7298v : OpenRideFragmentEx.this.f7299w);
                    }
                }
                if (i == 1 || i == 2) {
                    OpenRideFragmentEx.this.f7279c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m4496d() {
        this.f7270E.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f7271F.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideFragmentEx.this.f7290n == 1) {
                    editTextErasable = OpenRideFragmentEx.this.f7281e.getStartEditText();
                } else {
                    editTextErasable = OpenRideFragmentEx.this.f7290n == 2 ? OpenRideFragmentEx.this.f7281e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f7272G.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (OpenRideFragmentEx.this.f7290n == 1) {
                    editTextErasable = OpenRideFragmentEx.this.f7281e.getStartEditText();
                } else {
                    editTextErasable = OpenRideFragmentEx.this.f7290n == 2 ? OpenRideFragmentEx.this.f7281e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(OpenRideFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f7271F.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f7272G.getRetryBtn() != null) {
            this.f7272G.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    OpenRideFragmentEx.this.f7271F.setVisibility(8);
                    if (OpenRideFragmentEx.this.f7290n == 1) {
                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                        openRideFragmentEx.m4481b(openRideFragmentEx.f7290n, OpenRideFragmentEx.this.f7281e.getStartEditText().getText().toString(), true);
                    } else if (OpenRideFragmentEx.this.f7290n == 2) {
                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                        openRideFragmentEx2.m4481b(openRideFragmentEx2.f7290n, OpenRideFragmentEx.this.f7281e.getEndEditText().getText().toString(), true);
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
    private void m4482b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(OpenRideFragmentEx.this.f7290n == 3 && OpenRideFragmentEx.this.f7290n == 4)) {
                    AddressTrack.trackCloseButtonClick(OpenRideFragmentEx.this.getmParam(), OpenRideFragmentEx.this.m4508j());
                }
                if (OpenRideFragmentEx.this.f7286j != null) {
                    z = OpenRideFragmentEx.this.f7286j.onCloseButtonIntercept();
                }
                if (!z) {
                    OpenRideFragmentEx.this.closeFragment();
                    if (OpenRideFragmentEx.this.f7286j != null) {
                        OpenRideFragmentEx.this.f7286j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m4498e() {
        this.f7282f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f7290n - 1, OpenRideFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = OpenRideFragmentEx.this.f7282f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(OpenRideFragmentEx.this.getmParam(), homeAddress, OpenRideFragmentEx.this.f7290n);
                    homeAddress.operationType = 4;
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.setResultBack(openRideFragmentEx.f7290n, homeAddress);
                    return;
                }
                OpenRideFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.onConfirm(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                openRideFragmentEx3.switchSingle(openRideFragmentEx3.getmParam(), OpenRideFragmentEx.this.getmResult(), 3);
                int unused = OpenRideFragmentEx.this.f7302z = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(OpenRideFragmentEx.this.getmParam().addressParam, OpenRideFragmentEx.this.f7290n - 1, OpenRideFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = OpenRideFragmentEx.this.f7282f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(OpenRideFragmentEx.this.getmParam(), companyAddress, OpenRideFragmentEx.this.f7290n);
                    companyAddress.operationType = 5;
                    OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                    openRideFragmentEx.setResultBack(openRideFragmentEx.f7290n, companyAddress);
                    return;
                }
                OpenRideFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.onConfirm(openRideFragmentEx2.getmParam(), OpenRideFragmentEx.this.getmResult());
                OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                openRideFragmentEx3.switchSingle(openRideFragmentEx3.getmParam(), OpenRideFragmentEx.this.getmResult(), 4);
                int unused = OpenRideFragmentEx.this.f7302z = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    OpenRideFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(OpenRideFragmentEx.this.f7282f.getHomeAddress()), CommonUtils.isValidLocation(OpenRideFragmentEx.this.f7282f.getCompanyAddress()), OpenRideFragmentEx.this.getmParam().addressParam.addressType - 1);
                SugParams clone = OpenRideFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = OpenRideFragmentEx.this.f7290n;
                OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                openRideFragmentEx.onConfirm(clone, openRideFragmentEx.getmResult());
                OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                openRideFragmentEx2.switchFavorite(clone, openRideFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m4464a(AddressResult addressResult) {
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
        this.f7283g = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f7273H = z;
    }

    public ISugViewController getSugViewController() {
        return this.f7282f;
    }

    public String getStartAddressText() {
        return this.f7281e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f7281e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f7281e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f7282f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7282f.getListView().setAdapter(waittingAdapter);
        }
    }

    public String getStringSafe(int i) {
        return getStringVal(i);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4469a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 696);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f7281e.post(new Runnable() {
                public void run() {
                    if (!OpenRideFragmentEx.this.f7295s && OpenRideFragmentEx.this.f7272G.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || OpenRideFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            OpenRideFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            if (m4477a(str)) {
                if (i == 2) {
                    this.f7299w = true;
                } else if (i == 1) {
                    this.f7298v = true;
                }
                this.f7287k.processDataRequire(clone, str, z, i);
                return;
            }
            this.f7287k.processDataRequire(clone, "", z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4481b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 735);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f7281e.post(new Runnable() {
                public void run() {
                    if (!OpenRideFragmentEx.this.f7295s) {
                        OpenRideFragmentEx.this.f7282f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(OpenRideFragmentEx.this.getActivity()) - OpenRideFragmentEx.this.f7281e.getHeight()) / DisplayUtils.dp2px(OpenRideFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            if (m4477a(str)) {
                if (i == 2) {
                    this.f7299w = true;
                } else if (i == 1) {
                    this.f7298v = true;
                }
                this.f7287k.getSuggestPoiList(clone, str, z, i, true);
                return;
            }
            this.f7287k.processDataRequire(clone, "", z, i);
        }
    }

    /* renamed from: a */
    private boolean m4477a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f7290n == 1 && (((address2 = this.f7284h) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f7290n != 2 || (address = this.f7285i) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f7295s = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f7282f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f7301y && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
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
        m4501g();
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
        AddressTrack.onViewCreated(getmParam(), this.f7281e, this.f7282f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.setStartAddressDrawableLeftGrey();
            if (this.f7281e.getStartEditText() != null) {
                this.f7281e.getStartEditText().setTextColor(-3355444);
            }
        }
        m4469a(getmParam().addressParam.addressType, "", false);
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f7281e.getStartwithEndFullSize());
        if ((getmParam().addressParam.targetAddress != null && (getmParam().addressParam.targetAddress.displayName.equals(getString(R.string.GRider_Sug_2020_currentLoc)) || TextUtils.isEmpty(getmParam().addressParam.targetAddress.displayName))) || getmParam().addressParam.targetAddress.displayName == null) {
            this.f7287k.startRevertGeo(getmParam());
        }
    }

    /* renamed from: b */
    private void m4486b(RpcPoi rpcPoi) {
        if (this.f7287k != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f7287k.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m4499f() {
        if (this.f7287k != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f7287k.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m4501g() {
        AddressPresenter addressPresenter = this.f7287k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f7287k.stopRevertGeo();
        }
    }

    public void onResume() {
        this.f7296t = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f7287k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        this.f7296t = false;
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f7287k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo38967a(GlobalSugCallback globalSugCallback) {
        this.f7286j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f7286j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
        }
        Handler handler = this.f7288l;
        if (handler != null) {
            handler.removeMessages(12);
            this.f7288l = null;
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
        this.f7271F.setVisibility(8);
        this.f7272G.setVisibility(8);
        this.f7282f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo38966a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f7282f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            if (addressParam == null || addressParam.addressType == this.f7290n) {
                boolean z = false;
                if (this.f7300x && !this.f7301y && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    AddressTrack.trackRecItemSelect(0);
                }
                this.f7301y = false;
                if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    z = true;
                }
                this.f7300x = z;
                this.f7282f.post(new Runnable() {
                    public void run() {
                        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                            ArrayList unused = OpenRideFragmentEx.this.f7266A = arrayList;
                            OpenRideFragmentEx.this.f7282f.getMapConfirmView().setOnClickListener(OpenRideFragmentEx.this.f7276K);
                        }
                        RpcRecSug.TrackParameterForChild unused2 = OpenRideFragmentEx.this.f7269D = trackParameterForChild;
                        int unused3 = OpenRideFragmentEx.this.f7267B = i;
                        AddressAdapter addressAdapter = new AddressAdapter();
                        addressAdapter.setOnItemSelectedListener(OpenRideFragmentEx.this.f7274I);
                        addressAdapter.updateAddress(arrayList, OpenRideFragmentEx.this.getmParam().clone(), trackParameterForChild, OpenRideFragmentEx.this.f7290n, i);
                        SugListViewContainer h = OpenRideFragmentEx.this.f7282f;
                        ArrayList arrayList = arrayList;
                        h.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                        OpenRideFragmentEx.this.f7282f.getListView().setAdapter(addressAdapter);
                    }
                });
                hideLoading();
            }
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f7282f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7282f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7282f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f7282f.onlyShowSelectPoiFooterView();
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f7271F.setVisibility(8);
        this.f7272G.setVisibility(0);
        this.f7272G.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        this.f7282f.onlyShowSelectPoiFooterView();
        this.f7272G.setVisibility(8);
        this.f7271F.setVisibility(0);
        this.f7271F.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f7271F.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f7272G;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f7271F;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1366);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f7294r;
            if (m4474a(i, address)) {
                closeSessionWithResult(getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m4504h() {
        Address address = this.f7284h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: i */
    private Address m4506i() {
        Address address = this.f7285i;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: b */
    private void m4483b(AddressResult addressResult) {
        if (this.f7273H) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getContext().getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f7286j;
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
        this.f7282f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateSelectPoiFooters(boolean z) {
        this.f7282f.showSelectPoiFooterView(true);
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f7268C = false;
        } else {
            this.f7268C = true;
        }
        this.f7282f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f7281e != null && !this.f7293q && !this.f7295s && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1486);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m4463a(i));
                if (i == 1) {
                    m4501g();
                    if (this.f7281e.isStartTextNeedScrollToBottomWhenFocused) {
                        m4514m();
                    }
                    m4469a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f7281e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f7281e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m4469a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f7281e.getEndEditText(), !this.f7295s);
                }
                this.f7281e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f7284h != null) {
                    this.f7281e.getStartEditText().setText(this.f7284h.displayName);
                    if (this.f7284h.displayName == null || !this.f7284h.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f7281e.getStartEditText().setTextColor(-3355444);
                        return;
                    }
                    this.f7281e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m4499f();
                }
            } else if (i == 2 && this.f7285i != null) {
                this.f7281e.getEndEditText().setText(this.f7285i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m4463a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f7281e.getEndEditText().getText().toString().trim();
        }
        return (this.f7281e.getCommonEditText() == null || TextUtils.isEmpty(this.f7281e.getCommonEditText().getText())) ? "" : this.f7281e.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public String m4508j() {
        return AddressTrack.getCurrPage(this.f7290n, this.f7281e, this.f7282f);
    }

    /* renamed from: k */
    private void m4509k() {
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* renamed from: l */
    private void m4511l() {
        if (getmParam() != null && getmParam().addressParam.targetAddress != null) {
            this.f7281e.getStartEditText().setText(getmParam().addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public void m4514m() {
        SugSearchView sugSearchView;
        if (!this.f7295s && (sugSearchView = this.f7281e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f7281e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f7281e.getStartEditText());
        }
    }

    /* renamed from: n */
    private void m4516n() {
        SugSearchView sugSearchView;
        if (!this.f7295s && (sugSearchView = this.f7281e) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: o */
    private void m4518o() {
        SugSearchView sugSearchView;
        if (!this.f7295s && (sugSearchView = this.f7281e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f7281e.setPressedState(true);
            }
            this.f7281e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: p */
    private void m4520p() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f7295s && (sugSearchView = this.f7281e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f7281e.setPressedState(true);
            }
            this.f7281e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: q */
    private void m4521q() {
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: r */
    private void m4524r() {
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f7281e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1662);
                m4501g();
                m4526s();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7281e.getStartEditText(), true ^ this.f7295s);
                this.f7281e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.openride.OpenRideFragmentEx", 1669);
                m4501g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f7281e.getEndEditText(), true ^ this.f7295s);
                this.f7281e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: s */
    public void m4526s() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f7281e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f7281e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f7297u) {
                this.f7297u = false;
            } else if (view.hasFocus()) {
                m4468a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m4468a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f7288l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f7288l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m4489b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
            this.f7281e.getStartEditText().setTextColor(-3355444);
        }
    }

    /* renamed from: b */
    private boolean m4489b(AddressParam addressParam) {
        if (addressParam == null || this.f7281e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f7281e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f7281e.getEndEditText().hasFocus();
        }
        return this.f7281e.getCommonEditText().hasFocus();
    }

    public void onClearClick(int i, String str) {
        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
        AddressTrack.trackSugClear(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), str);
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (intent != null && 101 == i2) {
            Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug((RpcCommonPoi) intent.getSerializableExtra("result")));
            convertToAddress.operationType = 6;
            setResultBack(this.f7290n, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m4474a(int i, Address address) {
        if (!CommonUtils.isValidLocation(address)) {
            return false;
        }
        if (i != 2 || CommonUtils.isTwoAddressEqual(this.f7284h, address)) {
            return true;
        }
        getmResult().setStart(this.f7284h);
        getmResult().setEnd(address);
        onConfirm(getmParam(), getmResult());
        return true;
    }

    public void onPageEnter() {
        long j;
        SugSearchView sugSearchView;
        if (this.f7281e != null) {
            final int i = this.f7290n;
            final int i2 = this.f7302z;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f7290n;
                if (i3 == 1) {
                    getmResult().setStart(this.f7284h);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f7285i);
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
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f7290n);
                }
            }
            this.f7281e.setSearchViewCallback((ISearchViewCallback) null);
            this.f7281e.removeWatcherForStart();
            this.f7281e.removeEndTextWatcher();
            this.f7281e.hideShadow();
            SugSearchView sugSearchView2 = this.f7281e;
            if (sugSearchView2 != null) {
                sugSearchView2.getStartEditText().setFocusable(false);
                this.f7281e.getStartEditText().setFocusableInTouchMode(false);
                this.f7281e.getEndEditText().setFocusable(false);
                this.f7281e.getEndEditText().setFocusableInTouchMode(false);
                this.f7281e.postDelayed(new Runnable() {
                    public void run() {
                        OpenRideFragmentEx.this.f7281e.addWatcherForStart();
                        OpenRideFragmentEx.this.f7281e.addEndTextWatcher();
                        OpenRideFragmentEx.this.f7281e.setSearchViewCallback(OpenRideFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView3 = this.f7281e;
            if (sugSearchView3 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z2;
                final boolean z8 = z3;
                sugSearchView3.postDelayed(new Runnable() {
                    public void run() {
                        if (OpenRideFragmentEx.this.f7281e != null) {
                            OpenRideFragmentEx.this.f7281e.setSearchViewCallback(OpenRideFragmentEx.this);
                            OpenRideFragmentEx.this.f7281e.getStartEditText().setFocusable(true);
                            OpenRideFragmentEx.this.f7281e.getStartEditText().setFocusableInTouchMode(true);
                            OpenRideFragmentEx.this.f7281e.getEndEditText().setFocusable(true);
                            OpenRideFragmentEx.this.f7281e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (!OpenRideFragmentEx.this.isFirstEnter() && !z5 && !z6 && i2 == -1) {
                            return;
                        }
                        if (i4 == 1 && !z7 && !z8) {
                            OpenRideFragmentEx.this.f7281e.setPressedState(false);
                            if (OpenRideFragmentEx.this.f7281e != null) {
                                OpenRideFragmentEx.this.f7281e.getStartEditText().requestFocus();
                                OpenRideFragmentEx.this.f7281e.getStartEditText().setTextIsSelectable(true);
                                OpenRideFragmentEx.this.f7281e.getStartEditText().setCursorVisible(false);
                                OpenRideFragmentEx.this.f7281e.getStartEditText().setCursorVisible(true);
                                if ((OpenRideFragmentEx.this.isFirstEnter() || !OpenRideFragmentEx.this.f7296t) && OpenRideFragmentEx.this.getmResult().getResult(i4) != null) {
                                    OpenRideFragmentEx.this.f7281e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getResult(i4).displayName);
                                }
                                if (!TextUtils.isEmpty(OpenRideFragmentEx.this.f7281e.getStartEditText().getText())) {
                                    OpenRideFragmentEx.this.f7281e.getStartEditText().setClearIconVisible(true);
                                }
                                OpenRideFragmentEx.this.f7281e.getStartEditText().setSelection(0, OpenRideFragmentEx.this.f7281e.getStartEditText().length());
                            }
                        } else if (i4 == 2) {
                            if (OpenRideFragmentEx.this.f7281e != null) {
                                OpenRideFragmentEx.this.f7281e.getEndEditText().requestFocus();
                            }
                            OpenRideFragmentEx.this.f7281e.getEndEditText().setSelection(0, OpenRideFragmentEx.this.f7281e.getEndEditText().length());
                        }
                    }
                }, 30);
                this.f7281e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !OpenRideFragmentEx.this.f7296t) {
                            return;
                        }
                        if (z3 && !OpenRideFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (OpenRideFragmentEx.this.f7290n == 1) {
                            ViewUtils.showInputMethodForEditText(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f7281e.getStartEditText());
                            OpenRideFragmentEx.this.f7281e.resetShadow(OpenRideFragmentEx.this.f7281e.getStartEditText());
                        } else if (OpenRideFragmentEx.this.f7290n == 2) {
                            ViewUtils.showInputMethodForEditText(OpenRideFragmentEx.this.getContext(), OpenRideFragmentEx.this.f7281e.getEndEditText());
                            OpenRideFragmentEx.this.f7281e.resetShadow(OpenRideFragmentEx.this.f7281e.getEndEditText());
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !this.f7296t) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f7302z;
                        if (i5 == 3) {
                            if (this.f7282f != null && getmResult().getAddressResult().home != null) {
                                this.f7282f.setHomeAddress(getmResult().getAddressResult().home);
                                SugParams clone = getmParam().clone();
                                clone.addressParam.addressType = 3;
                                this.f7277a.setHomeCompany(clone.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f7278b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f7278b.onHomeUploadFailed();
                            }
                            this.f7302z = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f7282f != null && getmResult().getAddressResult().company != null) {
                                this.f7282f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone2 = getmParam().addressParam.clone();
                                clone2.addressType = 4;
                                this.f7277a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f7278b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f7278b.onCompanyUploadFailed();
                            }
                            this.f7302z = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().start != null) {
                                SugSearchView sugSearchView4 = this.f7281e;
                                if (sugSearchView4 != null) {
                                    sugSearchView4.postDelayed(new Runnable() {
                                        public void run() {
                                            if (OpenRideFragmentEx.this.getmResult().getAddressResult().start != null) {
                                                OpenRideFragmentEx.this.f7281e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                                OpenRideFragmentEx.this.m4469a(i, "", false);
                                            }
                                            OpenRideFragmentEx.this.f7281e.getStartEditText().requestFocus();
                                            OpenRideFragmentEx.this.f7281e.getStartEditText().setSelection(0, OpenRideFragmentEx.this.f7281e.getStartEditText().length());
                                            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                            String unused = openRideFragmentEx.f7292p = openRideFragmentEx.getmResult().getAddressResult().start.displayName;
                                        }
                                    }, j);
                                }
                            } else {
                                Address address = getmResult().getAddressResult().start;
                            }
                            this.f7302z = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f7302z;
                        if (i6 == 3) {
                            if (this.f7282f != null && getmResult().getAddressResult().home != null) {
                                this.f7282f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone3 = getmParam().addressParam.clone();
                                clone3.addressType = this.f7302z;
                                this.f7277a.setHomeCompany(clone3, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f7278b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f7278b.onHomeUploadFailed();
                            }
                            this.f7302z = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f7282f != null && getmResult().getAddressResult().company != null) {
                                this.f7282f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone4 = getmParam().addressParam.clone();
                                clone4.addressType = this.f7302z;
                                this.f7277a.setHomeCompany(clone4, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f7278b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f7278b.onCompanyUploadFailed();
                            }
                            this.f7302z = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f7281e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f7281e.postDelayed(new Runnable() {
                                public void run() {
                                    if (OpenRideFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        OpenRideFragmentEx.this.f7281e.getStartEditText().setText(OpenRideFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        OpenRideFragmentEx.this.m4469a(i, "", false);
                                        OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                        Address unused = openRideFragmentEx.f7284h = openRideFragmentEx.getmResult().getAddressResult().start;
                                        OpenRideFragmentEx openRideFragmentEx2 = OpenRideFragmentEx.this;
                                        openRideFragmentEx2.onStartChoosen(openRideFragmentEx2.f7284h);
                                        OpenRideFragmentEx.this.f7281e.getStartEditText().requestFocus();
                                        OpenRideFragmentEx openRideFragmentEx3 = OpenRideFragmentEx.this;
                                        openRideFragmentEx3.setResultBack(i, openRideFragmentEx3.f7284h);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f7281e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f7281e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f7281e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            this.f7285i = getmResult().getAddressResult().end;
                            if (!isFirstEnter() && this.f7285i != null) {
                                this.f7281e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (OpenRideFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
                                            openRideFragmentEx.setResultBack(i, openRideFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f7285i != null) {
                            this.f7281e.getEndEditText().setText(this.f7285i.displayName);
                        } else {
                            m4509k();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        int i = 0;
        this.f7296t = false;
        SugSearchView sugSearchView = this.f7281e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f7281e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i2 = this.f7290n;
            if (i2 == 1) {
                if (this.f7284h == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f7284h);
                }
                if (this.f7281e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f7281e.getStartEditText());
                }
            } else if (i2 == 2) {
                if (this.f7285i != null) {
                    getmResult().setEnd(this.f7285i);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f7282f;
                    if (sugListViewContainer != null) {
                        i = sugListViewContainer.getVisibleCount();
                    }
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, i);
                }
                if (this.f7281e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f7281e.getEndEditText());
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
        return this.f7281e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f7290n == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m4487b(openRideFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m4494c(openRideFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m4494c(openRideFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            OpenRideFragmentEx openRideFragmentEx = OpenRideFragmentEx.this;
            openRideFragmentEx.m4487b(openRideFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !OpenRideFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4487b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m4494c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public IFragment.ParentNode getNodeType() {
        return IFragment.ParentNode.FULL;
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        boolean z = false;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        if (this.f7290n != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
            z = true;
        }
        int i2 = z ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f7266A);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f7268C);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f7290n;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f7302z = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f7302z = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        switchMapConfirm(clone, iAddressResult, this.f7290n, bundle);
        return true;
    }
}

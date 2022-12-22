package com.didi.addressnew.framework.fragmentmarket.confirmnew;

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
import com.didi.address.FromType;
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
import com.didi.addressnew.framework.switcher.result.ParentAddress;
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

public class ConfirmFragmentEx extends FragmentImpl implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = ConfirmFragmentEx.class.getSimpleName();
    /* access modifiers changed from: private */

    /* renamed from: A */
    public boolean f4344A = false;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public ArrayList<RpcPoi> f4345B;
    /* access modifiers changed from: private */

    /* renamed from: C */
    public int f4346C;

    /* renamed from: D */
    private boolean f4347D;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public RpcRecSug.TrackParameterForChild f4348E;

    /* renamed from: F */
    private FrameLayout f4349F = null;
    /* access modifiers changed from: private */

    /* renamed from: G */
    public EmptyView f4350G = null;
    /* access modifiers changed from: private */

    /* renamed from: H */
    public NetErrorView f4351H = null;

    /* renamed from: I */
    private boolean f4352I = true;
    /* access modifiers changed from: private */

    /* renamed from: J */
    public AddressAdapter.OnItemSelectedListener f4353J = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (ConfirmFragmentEx.this.f4369n == 1) {
                boolean unused = ConfirmFragmentEx.this.f4372q = true;
            }
            ConfirmFragmentEx.this.getmParam().addressParam.addressType = ConfirmFragmentEx.this.f4369n;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = ConfirmFragmentEx.this.f4369n == 1 ? ConfirmFragmentEx.this.f4376u : ConfirmFragmentEx.this.f4377v;
            }
            int i3 = 3;
            if (ConfirmFragmentEx.this.getmResult().getResult(ConfirmFragmentEx.this.f4369n) != null) {
                ConfirmFragmentEx.this.getmResult().getResult(ConfirmFragmentEx.this.f4369n).operationType = !z ? 2 : 3;
            }
            int i4 = z ? 3 : 2;
            if (ConfirmFragmentEx.this.f4346C == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info != null && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(ConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, ConfirmFragmentEx.this.f4369n, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                confirmFragmentEx.switchMapConfirm(confirmFragmentEx.getmParam(), rpcPoi, trackParameterForChild, ConfirmFragmentEx.this.getmResult(), ConfirmFragmentEx.this.f4346C);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (ConfirmFragmentEx.this.f4369n == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !ConfirmFragmentEx.this.f4376u : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (ConfirmFragmentEx.this.f4369n == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                ConfirmFragmentEx.this.f4366k.getGeocodeResult(ConfirmFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, ConfirmFragmentEx.this.f4369n, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        ConfirmFragmentEx.this.setResultBack(ConfirmFragmentEx.this.getmParam().addressParam.addressType, address);
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = ConfirmFragmentEx.this.mo22934a(rpcPoi3);
                if (a != null) {
                    a.operationType = i4;
                }
                if (ConfirmFragmentEx.this.f4369n != 2 || a == null || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(ConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, ConfirmFragmentEx.this.f4369n, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(ConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, ConfirmFragmentEx.this.f4369n, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (ConfirmFragmentEx.this.f4369n == 3 || ConfirmFragmentEx.this.f4369n == 4) {
                    if (ConfirmFragmentEx.this.f4360e != null) {
                        ConfirmFragmentEx.this.f4360e.removeCommonWatcher(ConfirmFragmentEx.this.getmParam().addressParam);
                        ConfirmFragmentEx.this.f4360e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    ConfirmFragmentEx.this.f4366k.setCommonAddress(ConfirmFragmentEx.this.getmParam(), rpcPoi3);
                } else if (ConfirmFragmentEx.this.f4369n == 1) {
                    if (ConfirmFragmentEx.this.getSugCallback() == null || ConfirmFragmentEx.this.getSugCallback().getSugBuild() == null || ConfirmFragmentEx.this.getSugCallback().getSugBuild().getVersion() != 1) {
                        ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                        confirmFragmentEx2.setResultBack(confirmFragmentEx2.f4369n, address);
                        if (!z) {
                            boolean unused2 = ConfirmFragmentEx.this.f4379x = true;
                            AddressTrack.trackRecItemSelect(i + 1);
                        }
                    } else {
                        SugParams clone = ConfirmFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = ConfirmFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        ConfirmFragmentEx confirmFragmentEx3 = ConfirmFragmentEx.this;
                        confirmFragmentEx3.onConfirm(confirmFragmentEx3.getmParam(), iAddressResult.clone());
                        ConfirmFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused3 = ConfirmFragmentEx.this.f4380y = 1;
                        return;
                    }
                } else if (ConfirmFragmentEx.this.f4369n == 2) {
                    if (address != null && address.isDiscountPoi) {
                        ParentAddress parentAddress = new ParentAddress();
                        parentAddress.addressType = 2;
                        parentAddress.address = ConfirmFragmentEx.this.mo22934a(rpcPoi2);
                        ConfirmFragmentEx.this.getmResult().setParent(parentAddress);
                    }
                    if (address == null || (!address.enableConfirmDropoff && !address.isDiscountPoi)) {
                        ConfirmFragmentEx confirmFragmentEx4 = ConfirmFragmentEx.this;
                        confirmFragmentEx4.setResultBack(confirmFragmentEx4.f4369n, address);
                    } else {
                        ConfirmFragmentEx confirmFragmentEx5 = ConfirmFragmentEx.this;
                        confirmFragmentEx5.switchEndConfirm(confirmFragmentEx5.getmParam(), ConfirmFragmentEx.this.getmResult(), address);
                    }
                }
                if (rpcPoi3.extend_info != null && rpcPoi3.extend_info.enable_confirm_dropoff != 1) {
                    ConfirmFragmentEx.this.f4366k.recordClickPoi(ConfirmFragmentEx.this.getmParam(), rpcPoi3.base_info);
                }
            }
        }

        private String getSearchText() {
            if (ConfirmFragmentEx.this.f4360e == null) {
                return "";
            }
            if (ConfirmFragmentEx.this.f4369n == 1) {
                return ConfirmFragmentEx.this.f4360e.getStartEditText().getText().toString();
            }
            if (ConfirmFragmentEx.this.f4369n == 2) {
                return ConfirmFragmentEx.this.f4360e.getEndEditText().getText().toString();
            }
            if (ConfirmFragmentEx.this.f4369n == 3) {
                return ConfirmFragmentEx.this.f4360e.getCommonEditText().getText().toString();
            }
            if (ConfirmFragmentEx.this.f4369n == 4) {
                return ConfirmFragmentEx.this.f4360e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: K */
    public AddressAdapter.OnMapConfirmClickListener f4354K = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
            confirmFragmentEx.switchMapConfirm(confirmFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, ConfirmFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: L */
    public View.OnClickListener f4355L = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (ConfirmFragmentEx.this.f4354K != null) {
                ConfirmFragmentEx.this.f4354K.onMapConfirmClicked(ConfirmFragmentEx.this.f4345B, ConfirmFragmentEx.this.f4348E, ConfirmFragmentEx.this.f4369n, ConfirmFragmentEx.this.f4346C);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f4356a;

    /* renamed from: b */
    CommonAddressReactor f4357b = new CommonAddressReactor();

    /* renamed from: c */
    int f4358c = 0;

    /* renamed from: d */
    private final int f4359d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f4360e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f4361f;

    /* renamed from: g */
    private ISugControlCallback f4362g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f4363h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Address f4364i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public GlobalSugCallback f4365j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public AddressPresenter f4366k;

    /* renamed from: l */
    private Handler f4367l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f4368m = 2;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public int f4369n = -1;

    /* renamed from: o */
    private int f4370o = -1;

    /* renamed from: p */
    private boolean f4371p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f4372q = true;
    /* access modifiers changed from: private */

    /* renamed from: r */
    public boolean f4373r;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f4374s = false;

    /* renamed from: t */
    private boolean f4375t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f4376u = false;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f4377v = false;

    /* renamed from: w */
    private boolean f4378w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public boolean f4379x = false;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public int f4380y = -1;

    /* renamed from: z */
    private long f4381z = 0;

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

    public void onAttach(Activity activity) {
        if (this.f4381z == 0) {
            this.f4381z = System.currentTimeMillis();
        }
        super.onAttach(activity);
        if (getArguments() != null) {
            setCurrAddressType(getmParam().addressParam.addressType);
        }
        GlobalSugCallback globalSugCallback = this.f4365j;
        if (globalSugCallback != null) {
            globalSugCallback.onAttach(getmParam().addressParam != null ? getmParam().addressParam.addressType : Integer.MIN_VALUE);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2644a();
    }

    /* renamed from: a */
    private void m2644a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f4366k = new AddressPresenter(getActivity(), this);
        this.f4356a = new SimpleCompanyHomePresenter(getActivity());
        this.f4373r = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f4367l = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    ConfirmFragmentEx.this.m2646a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f4369n = i;
    }

    public void setSearchViewType(int i) {
        this.f4368m = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m2647a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m2647a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f4360e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f4361f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f4349F = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f4350G = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f4351H = (NetErrorView) view.findViewById(R.id.net_view_error);
        m2671c();
        m2659b();
        m2674d();
        m2676e();
    }

    /* renamed from: b */
    private void m2659b() {
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(ConfirmFragmentEx.this.getActivity(), ConfirmFragmentEx.this.getView());
                    if (ConfirmFragmentEx.this.getSugCallback() != null) {
                        ConfirmFragmentEx.this.getSugCallback().onStartEndAddressChanged(ConfirmFragmentEx.this.m2684i(), ConfirmFragmentEx.this.f4364i);
                    }
                    if (!(ConfirmFragmentEx.this.getmParam().addressParam == null || ConfirmFragmentEx.this.getmParam().wayPointParam == null || ConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || ConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || ConfirmFragmentEx.this.m2684i() == null)) {
                        ConfirmFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(ConfirmFragmentEx.this.m2684i());
                    }
                    ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                    confirmFragmentEx.onConfirm(confirmFragmentEx.getmParam(), ConfirmFragmentEx.this.getmResult());
                    ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                    confirmFragmentEx2.switchWayPointer(confirmFragmentEx2.getmParam(), ConfirmFragmentEx.this.getmResult());
                }
            });
            storeStartAddress(getmParam().addressParam);
            this.f4364i = getmParam().endAddress;
            this.f4360e.initSugSearchView(getmParam());
            this.f4360e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    ConfirmFragmentEx.this.m2646a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m2706t();
            }
            m2651a(getmParam().addressParam);
            this.f4360e.setListener(getmParam().addressParam);
            this.f4360e.makeStartTextFocusedWhenIsRed();
            this.f4360e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(ConfirmFragmentEx.this.getmParam().fromType)) {
                        if (ConfirmFragmentEx.this.getmParam().addressParam.addressType == 1 && ConfirmFragmentEx.this.f4360e.isStartTextNeedScrollToBottomWhenFocused) {
                            ConfirmFragmentEx.this.m2693n();
                        }
                    } else if (CommonUtils.isFromGetOnPage(ConfirmFragmentEx.this.getmParam().fromType) && ConfirmFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        ConfirmFragmentEx.this.m2706t();
                        ConfirmFragmentEx.this.f4360e.addWatcherForStart();
                    }
                }
            });
            this.f4360e.postDelayed(new Runnable() {
                public void run() {
                    if (ConfirmFragmentEx.this.f4361f != null) {
                        ConfirmFragmentEx.this.f4361f.setTopPadding(ConfirmFragmentEx.this.f4360e.getMeasuredHeight());
                    }
                    ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                    confirmFragmentEx.m2651a(confirmFragmentEx.getmParam().addressParam);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2651a(AddressParam addressParam) {
        if (addressParam.addressType == 2) {
            m2700q();
            EditTextErasable endEditText = this.f4360e.getEndEditText();
            if (endEditText != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m2698p();
        }
    }

    public boolean storeStartAddress(AddressParam addressParam) {
        if (addressParam == null) {
            return false;
        }
        return m2655a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f4369n;
    }

    /* renamed from: a */
    private boolean m2655a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 337);
        this.f4363h = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m2671c() {
        this.f4361f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                String str = ConfirmFragmentEx.TAG;
                SystemUtils.log(3, str, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + ConfirmFragmentEx.this.f4368m + ", mCurrAddressType: " + ConfirmFragmentEx.this.f4369n, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx$6", 355);
                AddressTrack.trackMapSelect(ConfirmFragmentEx.this.getmParam().addressParam, ConfirmFragmentEx.this.f4369n, AddressPresenter.isLastCachedRecommendCache(ConfirmFragmentEx.this.f4369n));
                ConfirmFragmentEx.this.f4360e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    if (ConfirmFragmentEx.this.f4369n == 1) {
                        AddressTrack.LIST_REQUEST_TYPE list_request_type = AddressTrack.getmCurrentListType();
                        AddressTrack.LIST_REQUEST_TYPE list_request_type2 = AddressTrack.LIST_REQUEST_TYPE.START_SUG;
                    } else {
                        AddressTrack.LIST_REQUEST_TYPE list_request_type3 = AddressTrack.getmCurrentListType();
                        AddressTrack.LIST_REQUEST_TYPE list_request_type4 = AddressTrack.LIST_REQUEST_TYPE.END_SUG;
                    }
                } else if (ConfirmFragmentEx.this.f4369n == 1) {
                    boolean unused = ConfirmFragmentEx.this.f4376u;
                } else {
                    boolean unused2 = ConfirmFragmentEx.this.f4377v;
                }
                ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                confirmFragmentEx.onConfirm(confirmFragmentEx.getmParam(), ConfirmFragmentEx.this.getmResult());
                SugParams clone = ConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = ConfirmFragmentEx.this.f4369n;
                AddressResult addressResult = ConfirmFragmentEx.this.getmResult().getAddressResult();
                if (ConfirmFragmentEx.this.f4369n == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused3 = ConfirmFragmentEx.this.f4380y = 1;
                } else if (ConfirmFragmentEx.this.f4369n == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                confirmFragmentEx2.switchMapSelect(clone, confirmFragmentEx2.getmResult(), ConfirmFragmentEx.this.f4369n, bundle);
            }
        });
        this.f4361f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(ConfirmFragmentEx.this.getContext(), ConfirmFragmentEx.this.f4361f.getListView());
                    if (ConfirmFragmentEx.this.f4358c != absListView.getFirstVisiblePosition()) {
                        int j = ConfirmFragmentEx.this.f4369n;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(ConfirmFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(ConfirmFragmentEx.this.getmParam().fromType, ConfirmFragmentEx.this.f4369n);
                        ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                        AddressTrack.trackScrollCK(j, isFromRouteEditor ? 1 : 0, pageLevel, confirmFragmentEx.m2641a(confirmFragmentEx.f4369n), ConfirmFragmentEx.this.f4348E, ConfirmFragmentEx.this.f4358c, absListView.getFirstVisiblePosition(), ConfirmFragmentEx.this.f4344A);
                    }
                }
                if (i == 1 || i == 2) {
                    ConfirmFragmentEx.this.f4358c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m2674d() {
        this.f4349F.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f4350G.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (ConfirmFragmentEx.this.f4369n == 1) {
                    editTextErasable = ConfirmFragmentEx.this.f4360e.getStartEditText();
                } else {
                    editTextErasable = ConfirmFragmentEx.this.f4369n == 2 ? ConfirmFragmentEx.this.f4360e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(ConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f4351H.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (ConfirmFragmentEx.this.f4369n == 1) {
                    editTextErasable = ConfirmFragmentEx.this.f4360e.getStartEditText();
                } else {
                    editTextErasable = ConfirmFragmentEx.this.f4369n == 2 ? ConfirmFragmentEx.this.f4360e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(ConfirmFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f4350G.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f4351H.getRetryBtn() != null) {
            this.f4351H.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    ConfirmFragmentEx.this.f4350G.setVisibility(8);
                    if (ConfirmFragmentEx.this.f4369n == 1) {
                        ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                        confirmFragmentEx.m2660b(confirmFragmentEx.f4369n, ConfirmFragmentEx.this.f4360e.getStartEditText().getText().toString(), true);
                    } else if (ConfirmFragmentEx.this.f4369n == 2) {
                        ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                        confirmFragmentEx2.m2660b(confirmFragmentEx2.f4369n, ConfirmFragmentEx.this.f4360e.getEndEditText().getText().toString(), true);
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
    private void m2661b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                boolean z = false;
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(ConfirmFragmentEx.this.f4369n == 3 && ConfirmFragmentEx.this.f4369n == 4)) {
                    AddressTrack.trackCloseButtonClick(ConfirmFragmentEx.this.getmParam(), ConfirmFragmentEx.this.m2687k());
                }
                if (ConfirmFragmentEx.this.f4365j != null) {
                    z = ConfirmFragmentEx.this.f4365j.onCloseButtonIntercept();
                }
                if (!z) {
                    ConfirmFragmentEx.this.closeFragment();
                    if (ConfirmFragmentEx.this.f4365j != null) {
                        ConfirmFragmentEx.this.f4365j.onCloseButtonClick();
                    }
                }
            }
        });
    }

    /* renamed from: e */
    private void m2676e() {
        this.f4361f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(ConfirmFragmentEx.this.getmParam().addressParam, ConfirmFragmentEx.this.f4369n - 1, ConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    ConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = ConfirmFragmentEx.this.f4361f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(ConfirmFragmentEx.this.getmParam(), homeAddress, ConfirmFragmentEx.this.f4369n);
                    homeAddress.operationType = 4;
                    ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                    confirmFragmentEx.setResultBack(confirmFragmentEx.f4369n, homeAddress);
                    return;
                }
                ConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                confirmFragmentEx2.onConfirm(confirmFragmentEx2.getmParam(), ConfirmFragmentEx.this.getmResult());
                ConfirmFragmentEx confirmFragmentEx3 = ConfirmFragmentEx.this;
                confirmFragmentEx3.switchSingle(confirmFragmentEx3.getmParam(), ConfirmFragmentEx.this.getmResult(), 3);
                int unused = ConfirmFragmentEx.this.f4380y = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(ConfirmFragmentEx.this.getmParam().addressParam, ConfirmFragmentEx.this.f4369n - 1, ConfirmFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    ConfirmFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = ConfirmFragmentEx.this.f4361f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(ConfirmFragmentEx.this.getmParam(), companyAddress, ConfirmFragmentEx.this.f4369n);
                    companyAddress.operationType = 5;
                    ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                    confirmFragmentEx.setResultBack(confirmFragmentEx.f4369n, companyAddress);
                    return;
                }
                ConfirmFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                confirmFragmentEx2.onConfirm(confirmFragmentEx2.getmParam(), ConfirmFragmentEx.this.getmResult());
                ConfirmFragmentEx confirmFragmentEx3 = ConfirmFragmentEx.this;
                confirmFragmentEx3.switchSingle(confirmFragmentEx3.getmParam(), ConfirmFragmentEx.this.getmResult(), 4);
                int unused = ConfirmFragmentEx.this.f4380y = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    ConfirmFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(ConfirmFragmentEx.this.f4361f.getHomeAddress()), CommonUtils.isValidLocation(ConfirmFragmentEx.this.f4361f.getCompanyAddress()), ConfirmFragmentEx.this.getmParam().addressParam.addressType - 1);
                SugParams clone = ConfirmFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = ConfirmFragmentEx.this.f4369n;
                ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                confirmFragmentEx.onConfirm(clone, confirmFragmentEx.getmResult());
                ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                confirmFragmentEx2.switchFavorite(clone, confirmFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m2642a(AddressResult addressResult) {
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
        this.f4362g = iSugControlCallback;
    }

    public void enableCloseSugFragment(boolean z) {
        this.f4352I = z;
    }

    public ISugViewController getSugViewController() {
        return this.f4361f;
    }

    public String getStartAddressText() {
        return this.f4360e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f4360e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f4360e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f4361f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f4361f.getListView().setAdapter(waittingAdapter);
        }
    }

    public String getStringSafe(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2646a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 687);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f4360e.post(new Runnable() {
                public void run() {
                    if (!ConfirmFragmentEx.this.f4373r && ConfirmFragmentEx.this.f4351H.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || ConfirmFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            ConfirmFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            boolean z2 = false;
            boolean z3 = true;
            if (m2656a(str)) {
                if (i == 2) {
                    this.f4377v = true;
                } else if (i == 1) {
                    this.f4376u = true;
                }
                if (m2653a(clone)) {
                    Address i2 = m2684i();
                    AddressParam addressParam = clone.addressParam;
                    if (i2 != null) {
                        z2 = true;
                    }
                    addressParam.needDiscount = z2;
                    clone.addressParam.startAddress = i2;
                } else {
                    clone.addressParam.needDiscount = false;
                }
                this.f4366k.processDataRequire(clone, str, z, i);
                this.f4344A = true;
                return;
            }
            if (m2653a(clone)) {
                Address i3 = m2684i();
                AddressParam addressParam2 = clone.addressParam;
                if (i3 == null) {
                    z3 = false;
                }
                addressParam2.needDiscount = z3;
                clone.addressParam.startAddress = i3;
            } else {
                clone.addressParam.needDiscount = false;
            }
            this.f4366k.processDataRequire(clone, "", z, i);
            this.f4344A = false;
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2660b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 744);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            this.f4360e.post(new Runnable() {
                public void run() {
                    if (!ConfirmFragmentEx.this.f4373r) {
                        ConfirmFragmentEx.this.f4361f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(ConfirmFragmentEx.this.getActivity()) - ConfirmFragmentEx.this.f4360e.getHeight()) / DisplayUtils.dp2px(ConfirmFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            boolean z2 = false;
            boolean z3 = true;
            if (m2656a(str)) {
                if (i == 2) {
                    this.f4377v = true;
                } else if (i == 1) {
                    this.f4376u = true;
                }
                if (m2653a(clone)) {
                    Address i2 = m2684i();
                    AddressParam addressParam = clone.addressParam;
                    if (i2 != null) {
                        z2 = true;
                    }
                    addressParam.needDiscount = z2;
                    clone.addressParam.startAddress = i2;
                } else {
                    clone.addressParam.needDiscount = false;
                }
                this.f4366k.getSuggestPoiList(clone, str, z, i, true);
                this.f4344A = true;
                return;
            }
            if (m2653a(clone)) {
                Address i3 = m2684i();
                AddressParam addressParam2 = clone.addressParam;
                if (i3 == null) {
                    z3 = false;
                }
                addressParam2.needDiscount = z3;
                clone.addressParam.startAddress = i3;
            } else {
                clone.addressParam.needDiscount = false;
            }
            this.f4366k.processDataRequire(clone, "", z, i);
            this.f4344A = false;
        }
    }

    /* renamed from: a */
    private boolean m2656a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f4369n == 1 && (((address2 = this.f4363h) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f4369n != 2 || (address = this.f4364i) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    /* renamed from: a */
    private boolean m2653a(SugParams sugParams) {
        if (sugParams.addressParam.addressType == 2) {
            return sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM_NEW;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f4373r = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f4361f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f4379x && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
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
        m2679g();
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
        AddressTrack.onViewCreated(getmParam(), this.f4360e, this.f4361f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        m2646a(getmParam().addressParam.addressType, "", false);
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f4360e.getStartwithEndFullSize());
    }

    /* renamed from: b */
    private void m2665b(RpcPoi rpcPoi) {
        if (this.f4366k != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f4366k.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m2677f() {
        if (this.f4366k != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f4366k.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m2679g() {
        AddressPresenter addressPresenter = this.f4366k;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f4366k.stopRevertGeo();
        }
    }

    public void onResume() {
        this.f4374s = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f4366k;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        this.f4374s = false;
        super.onPause();
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f4366k;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
        ViewUtils.hideInputWindow(getActivity(), getView());
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo22935a(GlobalSugCallback globalSugCallback) {
        this.f4365j = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f4365j;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach((getmParam() == null || getmParam().addressParam == null) ? Integer.MIN_VALUE : getmParam().addressParam.addressType);
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
        this.f4350G.setVisibility(8);
        this.f4351H.setVisibility(8);
        this.f4361f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo22934a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f4361f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            if (addressParam == null || addressParam.addressType == this.f4369n) {
                boolean z = false;
                if (this.f4378w && !this.f4379x && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    AddressTrack.trackRecItemSelect(0);
                }
                this.f4379x = false;
                if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    z = true;
                }
                this.f4378w = z;
                this.f4361f.post(new Runnable() {
                    public void run() {
                        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                            ArrayList unused = ConfirmFragmentEx.this.f4345B = arrayList;
                            ConfirmFragmentEx.this.f4361f.getMapConfirmView().setOnClickListener(ConfirmFragmentEx.this.f4355L);
                        }
                        RpcRecSug.TrackParameterForChild unused2 = ConfirmFragmentEx.this.f4348E = trackParameterForChild;
                        int unused3 = ConfirmFragmentEx.this.f4346C = i;
                        AddressAdapter addressAdapter = new AddressAdapter();
                        boolean z = true;
                        addressAdapter.setSupportConfirmDropOff(true);
                        addressAdapter.setOnItemSelectedListener(ConfirmFragmentEx.this.f4353J);
                        AddressAdapter addressAdapter2 = addressAdapter;
                        addressAdapter2.updateAddress(arrayList, ConfirmFragmentEx.this.getmParam().clone(), trackParameterForChild, ConfirmFragmentEx.this.f4369n, i);
                        SugListViewContainer h = ConfirmFragmentEx.this.f4361f;
                        ArrayList arrayList = arrayList;
                        if (arrayList != null) {
                            z = arrayList.isEmpty();
                        }
                        h.onAddressOcupy(z, false);
                        ConfirmFragmentEx.this.f4361f.getListView().setAdapter(addressAdapter);
                    }
                });
                hideLoading();
            }
        }
    }

    /* renamed from: h */
    private boolean m2682h() {
        if (getmParam().addressParam.addressType == 2) {
            return getmParam().fromType == FromType.HOME || getmParam().fromType == FromType.CONFIRM_NEW;
        }
        return false;
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f4361f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f4361f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f4361f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f4361f.onlyShowSelectPoiFooterView();
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f4350G.setVisibility(8);
        this.f4351H.setVisibility(0);
        this.f4351H.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        this.f4361f.onlyShowSelectPoiFooterView();
        this.f4351H.setVisibility(8);
        this.f4350G.setVisibility(0);
        this.f4350G.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f4350G.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f4351H;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f4350G;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 1419);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f4372q;
            if (m2652a(i, address)) {
                if (i == 1 && address != null) {
                    AddressTrack.trackFromConfirmSelectStart(getmParam().addressParam, System.currentTimeMillis() - this.f4381z, address.operationType);
                }
                closeSessionWithResult(getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public Address m2684i() {
        Address address = this.f4363h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: j */
    private Address m2686j() {
        Address address = this.f4364i;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: b */
    private void m2662b(AddressResult addressResult) {
        if (this.f4352I) {
            closeFragment();
        }
        if (addressResult != null && addressResult.start != null && !TextUtils.isEmpty(addressResult.start.displayName) && addressResult.start.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
            addressResult.start.displayName = getContext().getResources().getString(R.string.global_sug_current_location);
        }
        GlobalSugCallback globalSugCallback = this.f4365j;
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
        this.f4361f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
        this.f4361f.updateMapConfirmHeaderView(tipsInfo, i);
    }

    public void updateSelectPoiFooters(boolean z) {
        this.f4361f.showSelectPoiFooterView(true);
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f4347D = false;
        } else {
            this.f4347D = true;
        }
        this.f4361f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f4360e != null && !this.f4371p && !this.f4373r && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 1543);
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m2641a(i));
                if (i == 1) {
                    m2679g();
                    if (this.f4360e.isStartTextNeedScrollToBottomWhenFocused) {
                        m2693n();
                    }
                    m2646a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f4360e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f4360e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m2646a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f4360e.getEndEditText(), !this.f4373r);
                }
                this.f4360e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f4363h != null) {
                    this.f4360e.getStartEditText().setText(this.f4363h.displayName);
                    if (this.f4363h.displayName == null || !this.f4363h.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f4360e.getStartEditText().setTextColor(-16777216);
                        return;
                    }
                    this.f4360e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m2677f();
                }
            } else if (i == 2 && this.f4364i != null) {
                this.f4360e.getEndEditText().setText(this.f4364i.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m2641a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f4360e.getEndEditText().getText().toString().trim();
        }
        return (this.f4360e.getCommonEditText() == null || TextUtils.isEmpty(this.f4360e.getCommonEditText().getText())) ? "" : this.f4360e.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public String m2687k() {
        return AddressTrack.getCurrPage(this.f4369n, this.f4360e, this.f4361f);
    }

    /* renamed from: l */
    private void m2689l() {
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* renamed from: m */
    private void m2692m() {
        if (getmParam() != null && getmParam().addressParam.targetAddress != null) {
            this.f4360e.getStartEditText().setText(getmParam().addressParam.targetAddress.displayName);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: n */
    public void m2693n() {
        SugSearchView sugSearchView;
        if (!this.f4373r && (sugSearchView = this.f4360e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f4360e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f4360e.getStartEditText());
        }
    }

    /* renamed from: o */
    private void m2696o() {
        SugSearchView sugSearchView;
        if (!this.f4373r && (sugSearchView = this.f4360e) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: p */
    private void m2698p() {
        SugSearchView sugSearchView;
        if (!this.f4373r && (sugSearchView = this.f4360e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f4360e.setPressedState(true);
            }
            this.f4360e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: q */
    private void m2700q() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f4373r && (sugSearchView = this.f4360e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f4360e.setPressedState(true);
            }
            this.f4360e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: r */
    private void m2701r() {
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: s */
    private void m2704s() {
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f4360e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 1720);
                m2679g();
                m2706t();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f4360e.getStartEditText(), true ^ this.f4373r);
                this.f4360e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.confirmnew.ConfirmFragmentEx", 1727);
                m2679g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f4360e.getEndEditText(), true ^ this.f4373r);
                this.f4360e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: t */
    public void m2706t() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f4360e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f4360e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f4375t) {
                this.f4375t = false;
            } else if (view.hasFocus()) {
                m2645a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m2645a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f4367l.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f4367l;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m2668b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
        }
    }

    /* renamed from: b */
    private boolean m2668b(AddressParam addressParam) {
        if (addressParam == null || this.f4360e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f4360e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f4360e.getEndEditText().hasFocus();
        }
        return this.f4360e.getCommonEditText().hasFocus();
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
            setResultBack(this.f4369n, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m2652a(int i, Address address) {
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
            Address address2 = this.f4364i;
            if (address2 != null) {
                if (!CommonUtils.isTwoAddressEqual(address2, address)) {
                    getmResult().setStart(address);
                    getmResult().setEnd(this.f4364i);
                    onConfirm(getmParam(), getmResult());
                } else {
                    CommonUtils.showDuplicateAlert(getContext());
                    return false;
                }
            }
        } else if (i == 2 && CommonUtils.isValidLocation(this.f4363h)) {
            if (!CommonUtils.isTwoAddressEqual(this.f4363h, address)) {
                getmResult().setStart(this.f4363h);
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
        SugSearchView sugSearchView2;
        if (this.f4360e != null) {
            final int i = this.f4369n;
            final int i2 = this.f4380y;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f4369n;
                if (i3 == 1) {
                    getmResult().setStart(this.f4363h);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f4364i);
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
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f4369n);
                }
            }
            this.f4360e.setSearchViewCallback((ISearchViewCallback) null);
            this.f4360e.removeWatcherForStart();
            this.f4360e.removeEndTextWatcher();
            this.f4360e.hideShadow();
            SugSearchView sugSearchView3 = this.f4360e;
            if (sugSearchView3 != null) {
                sugSearchView3.getStartEditText().setFocusable(false);
                this.f4360e.getStartEditText().setFocusableInTouchMode(false);
                this.f4360e.getEndEditText().setFocusable(false);
                this.f4360e.getEndEditText().setFocusableInTouchMode(false);
                this.f4360e.postDelayed(new Runnable() {
                    public void run() {
                        ConfirmFragmentEx.this.f4360e.addWatcherForStart();
                        ConfirmFragmentEx.this.f4360e.addEndTextWatcher();
                        ConfirmFragmentEx.this.f4360e.setSearchViewCallback(ConfirmFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView4 = this.f4360e;
            if (sugSearchView4 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z3;
                final boolean z8 = z2;
                sugSearchView4.postDelayed(new Runnable() {
                    public void run() {
                        if (ConfirmFragmentEx.this.f4360e != null) {
                            ConfirmFragmentEx.this.f4360e.setSearchViewCallback(ConfirmFragmentEx.this);
                            ConfirmFragmentEx.this.f4360e.getStartEditText().setFocusable(true);
                            ConfirmFragmentEx.this.f4360e.getStartEditText().setFocusableInTouchMode(true);
                            ConfirmFragmentEx.this.f4360e.getEndEditText().setFocusable(true);
                            ConfirmFragmentEx.this.f4360e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (ConfirmFragmentEx.this.isFirstEnter() || z5 || z6 || i2 != -1) {
                            ConfirmFragmentEx.this.f4360e.setPressedState(false);
                            if (i4 == 1 && !z7 && (!z8 || ConfirmFragmentEx.this.getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || ConfirmFragmentEx.this.getmParam().fromType == FromType.ROUTE_EDITOR)) {
                                if (ConfirmFragmentEx.this.f4360e != null) {
                                    ConfirmFragmentEx.this.f4360e.getStartEditText().requestFocus();
                                    ConfirmFragmentEx.this.f4360e.getStartEditText().setTextIsSelectable(true);
                                    ConfirmFragmentEx.this.f4360e.getStartEditText().setCursorVisible(false);
                                    ConfirmFragmentEx.this.f4360e.getStartEditText().setCursorVisible(true);
                                    if ((ConfirmFragmentEx.this.isFirstEnter() || !ConfirmFragmentEx.this.f4374s) && ConfirmFragmentEx.this.getmResult().getResult(i4) != null) {
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().setText(ConfirmFragmentEx.this.getmResult().getResult(i4).displayName);
                                    }
                                    if (!TextUtils.isEmpty(ConfirmFragmentEx.this.f4360e.getStartEditText().getText())) {
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().setClearIconVisible(true);
                                    }
                                    ConfirmFragmentEx.this.f4360e.getStartEditText().setSelection(0, ConfirmFragmentEx.this.f4360e.getStartEditText().length());
                                }
                            } else if (i4 == 2) {
                                if (ConfirmFragmentEx.this.f4360e != null) {
                                    ConfirmFragmentEx.this.f4360e.getEndEditText().requestFocus();
                                }
                                ConfirmFragmentEx.this.f4360e.getEndEditText().setSelection(0, ConfirmFragmentEx.this.f4360e.getEndEditText().length());
                            }
                        }
                    }
                }, 30);
                this.f4360e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !ConfirmFragmentEx.this.f4374s) {
                            return;
                        }
                        if (z3 && !ConfirmFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (ConfirmFragmentEx.this.f4369n == 1) {
                            ViewUtils.showInputMethodForEditText(ConfirmFragmentEx.this.getContext(), ConfirmFragmentEx.this.f4360e.getStartEditText());
                            ConfirmFragmentEx.this.f4360e.resetShadow(ConfirmFragmentEx.this.f4360e.getStartEditText());
                        } else if (ConfirmFragmentEx.this.f4369n == 2) {
                            ViewUtils.showInputMethodForEditText(ConfirmFragmentEx.this.getContext(), ConfirmFragmentEx.this.f4360e.getEndEditText());
                            ConfirmFragmentEx.this.f4360e.resetShadow(ConfirmFragmentEx.this.f4360e.getEndEditText());
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !this.f4374s) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f4380y;
                        if (i5 == 3) {
                            if (this.f4361f != null && getmResult().getAddressResult().home != null) {
                                this.f4361f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone = getmParam().addressParam.clone();
                                clone.addressType = 3;
                                this.f4356a.setHomeCompany(clone, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f4357b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f4357b.onHomeUploadFailed();
                            }
                            this.f4380y = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f4361f != null && getmResult().getAddressResult().company != null) {
                                this.f4361f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone2 = getmParam().addressParam.clone();
                                clone2.addressType = 4;
                                this.f4356a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f4357b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f4357b.onCompanyUploadFailed();
                            }
                            this.f4380y = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (!(getmResult().getAddressResult().start == null || (sugSearchView2 = this.f4360e) == null)) {
                                sugSearchView2.postDelayed(new Runnable() {
                                    public void run() {
                                        if (ConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                            ConfirmFragmentEx.this.f4360e.getStartEditText().setText(ConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                            ConfirmFragmentEx.this.m2646a(i, "", false);
                                        }
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().requestFocus();
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().setSelection(0, ConfirmFragmentEx.this.f4360e.getStartEditText().length());
                                    }
                                }, j);
                            }
                            this.f4380y = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f4380y;
                        if (i6 == 3) {
                            if (this.f4361f != null && getmResult().getAddressResult().home != null) {
                                this.f4361f.setHomeAddress(getmResult().getAddressResult().home);
                                AddressParam clone3 = getmParam().addressParam.clone();
                                clone3.addressType = this.f4380y;
                                this.f4356a.setHomeCompany(clone3, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f4357b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f4357b.onHomeUploadFailed();
                            }
                            this.f4380y = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f4361f != null && getmResult().getAddressResult().company != null) {
                                this.f4361f.setCompanyAddress(getmResult().getAddressResult().company);
                                AddressParam clone4 = getmParam().addressParam.clone();
                                clone4.addressType = this.f4380y;
                                this.f4356a.setHomeCompany(clone4, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f4357b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f4357b.onCompanyUploadFailed();
                            }
                            this.f4380y = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f4360e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f4360e.postDelayed(new Runnable() {
                                public void run() {
                                    if (ConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().setText(ConfirmFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        if (ConfirmFragmentEx.this.f4364i == null && ConfirmFragmentEx.this.getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT) {
                                            ConfirmFragmentEx.this.m2646a(i, "", false);
                                        }
                                        ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                                        Address unused = confirmFragmentEx.f4363h = confirmFragmentEx.getmResult().getAddressResult().start;
                                        ConfirmFragmentEx confirmFragmentEx2 = ConfirmFragmentEx.this;
                                        confirmFragmentEx2.onStartChoosen(confirmFragmentEx2.f4363h);
                                    }
                                    if (ConfirmFragmentEx.this.f4364i == null && ConfirmFragmentEx.this.getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT) {
                                        ConfirmFragmentEx.this.f4360e.getStartEditText().requestFocus();
                                    }
                                    if (ConfirmFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        ConfirmFragmentEx confirmFragmentEx3 = ConfirmFragmentEx.this;
                                        confirmFragmentEx3.setResultBack(i, confirmFragmentEx3.getmResult().getAddressResult().start);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f4360e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f4360e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f4360e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            this.f4364i = getmResult().getAddressResult().end;
                            if (!isFirstEnter() && this.f4364i != null) {
                                this.f4360e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (ConfirmFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
                                            confirmFragmentEx.setResultBack(i, confirmFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f4364i != null) {
                            this.f4360e.getEndEditText().setText(this.f4364i.displayName);
                        } else {
                            m2689l();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        int i = 0;
        this.f4374s = false;
        SugSearchView sugSearchView = this.f4360e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f4360e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i2 = this.f4369n;
            if (i2 == 1) {
                if (this.f4363h == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f4363h);
                }
                if (this.f4360e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f4360e.getStartEditText());
                }
            } else if (i2 == 2) {
                if (this.f4364i != null) {
                    getmResult().setEnd(this.f4364i);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f4361f;
                    if (sugListViewContainer != null) {
                        i = sugListViewContainer.getVisibleCount();
                    }
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, i);
                }
                if (this.f4360e != null) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f4360e.getEndEditText());
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
        return this.f4360e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f4369n == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
            confirmFragmentEx.m2666b(confirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
            confirmFragmentEx.m2672c(confirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
            confirmFragmentEx.m2672c(confirmFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            ConfirmFragmentEx confirmFragmentEx = ConfirmFragmentEx.this;
            confirmFragmentEx.m2666b(confirmFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !ConfirmFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2666b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2672c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public boolean switchEndConfirm(SugParams sugParams, IAddressResult iAddressResult, Address address) {
        SugParams clone;
        if (sugParams == null || iAddressResult == null || address == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        address.operationType = this.f4344A ? 3 : 2;
        clone.addressParam.addressType = 2;
        iAddressResult.setEnd(address);
        onConfirm(getmParam(), iAddressResult.clone());
        Bundle bundle = new Bundle();
        this.f4380y = 2;
        if (!TextUtils.isEmpty(this.f4360e.getStartEditText().getText())) {
            this.f4360e.getStartEditText().setSelection(0, this.f4360e.getStartEditText().length());
        }
        this.f4360e.getEndEditText().setSelection(0);
        switchEndConfirm(clone, iAddressResult, 2, bundle);
        return true;
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        int i2 = this.f4344A ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f4345B);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f4347D);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f4369n;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f4380y = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f4380y = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        int i4 = this.f4369n;
        if (i4 == 1) {
            if (!TextUtils.isEmpty(this.f4360e.getStartEditText().getText())) {
                this.f4360e.getStartEditText().setSelection(0, this.f4360e.getStartEditText().length());
            }
            this.f4360e.getEndEditText().setSelection(0);
        } else if (i4 == 2) {
            if (!TextUtils.isEmpty(this.f4360e.getEndEditText().getText())) {
                this.f4360e.getEndEditText().setSelection(0, this.f4360e.getEndEditText().length());
            }
            this.f4360e.getEndEditText().setSelection(0);
        }
        switchMapConfirm(clone, iAddressResult, this.f4369n, bundle);
        return true;
    }
}

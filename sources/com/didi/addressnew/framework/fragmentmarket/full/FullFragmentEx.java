package com.didi.addressnew.framework.fragmentmarket.full;

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
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.address.util.PoiidCompleteUtils;
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
import com.didi.common.map.model.LatLng;
import com.didi.common.map.util.CollectionUtil;
import com.didi.common.map.util.DDSphericalUtil;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.global.model.omega.AppFluentOmega;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.didi.sdk.util.ToastHelper;
import com.global.didi.elvish.DistanceStyle;
import com.global.didi.elvish.Elvish;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.sdk.poibase.model.recsug.RpcRecSugInfo;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class FullFragmentEx extends FullFragment implements IAddressView, ISearchViewCallback, IStationFetcherView {
    public static final int ENTER_ANIMATION_INTERVAL = 750;
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = FullFragmentEx.class.getSimpleName();

    /* renamed from: A */
    private boolean f4432A;
    /* access modifiers changed from: private */

    /* renamed from: B */
    public RpcRecSug.TrackParameterForChild f4433B;

    /* renamed from: C */
    private FrameLayout f4434C = null;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public EmptyView f4435D = null;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public NetErrorView f4436E = null;
    /* access modifiers changed from: private */

    /* renamed from: F */
    public AddressAdapter.OnItemSelectedListener f4437F = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            boolean z;
            Address address;
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (FullFragmentEx.this.f4452m == 1) {
                boolean unused = FullFragmentEx.this.f4454o = true;
            }
            FullFragmentEx.this.getmParam().addressParam.addressType = FullFragmentEx.this.f4452m;
            if (ApolloUtil.getRecOmegaCKAB()) {
                z = AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG || AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG;
            } else {
                z = FullFragmentEx.this.f4452m == 1 ? FullFragmentEx.this.f4458s : FullFragmentEx.this.f4459t;
            }
            int i3 = 3;
            int i4 = z ? 3 : 2;
            if (FullFragmentEx.this.f4465z == RpcRecSugInfo.TYPE_EMPTY_RESULT && rpcPoi3.extend_info != null && rpcPoi3.extend_info.enable_confirm_dropoff == 0 && !rpcPoi3.isDiscountPoi && CollectionUtil.isEmpty((Collection<?>) rpcPoi3.discount_poi)) {
                AddressTrack.trackAddressClick(FullFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, FullFragmentEx.this.f4452m, AddressTrack.SUG_JUMP_TYPE.JUMP_POI, i4);
                FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                fullFragmentEx.switchMapConfirm(fullFragmentEx.getmParam(), rpcPoi, trackParameterForChild, FullFragmentEx.this.getmResult(), FullFragmentEx.this.f4465z);
            } else if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (FullFragmentEx.this.f4452m == 1) {
                    if (!ApolloUtil.getRecOmegaCKAB() ? !FullFragmentEx.this.f4458s : AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        i3 = 2;
                    }
                    AddressTrack.trackUserOperator(1, i3);
                } else if (FullFragmentEx.this.f4452m == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                FullFragmentEx.this.f4449j.getGeocodeResult(FullFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, FullFragmentEx.this.f4452m, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        FullFragmentEx.this.setResultBack(FullFragmentEx.this.getmParam().addressParam.addressType, address);
                    }
                });
            } else {
                SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi3, trackParameterForChild2);
                if (rpcPoi3.base_info != null) {
                    rpcPoi3.base_info.searchId = trackParameterForChild2.search_id;
                }
                Address a = FullFragmentEx.this.mo23045a(rpcPoi3);
                if (a != null) {
                    a.operationType = i4;
                }
                if (FullFragmentEx.this.f4452m != 2 || a == null || (!a.enableConfirmDropoff && !a.isDiscountPoi)) {
                    address = a;
                    AddressTrack.trackAddressClick(FullFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, FullFragmentEx.this.f4452m, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i4);
                } else {
                    address = a;
                    AddressTrack.trackAddressClick(FullFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2 + 1), trackParameterForChild, FullFragmentEx.this.f4452m, AddressTrack.SUG_JUMP_TYPE.JUMP_DROP_CONFIRM, i4);
                }
                if (FullFragmentEx.this.f4452m == 3 || FullFragmentEx.this.f4452m == 4) {
                    if (FullFragmentEx.this.f4444e != null) {
                        FullFragmentEx.this.f4444e.removeCommonWatcher(FullFragmentEx.this.getmParam().addressParam);
                        FullFragmentEx.this.f4444e.getCommonEditText().setText(rpcPoi3.base_info.displayname);
                    }
                    FullFragmentEx.this.f4449j.setCommonAddress(FullFragmentEx.this.getmParam(), rpcPoi3);
                } else if (FullFragmentEx.this.f4452m == 1) {
                    if ((FullFragmentEx.this.getmParam().fromType == FromType.HOME || FullFragmentEx.this.getmParam().fromType == FromType.CONFIRM || FullFragmentEx.this.getmParam().fromType == FromType.ROUTE_EDITOR || FullFragmentEx.this.getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || FullFragmentEx.this.getmParam().fromType == FromType.FROM_HOME_ROUTE_EDITOR) && FullFragmentEx.this.getSugCallback() != null && FullFragmentEx.this.getSugCallback().getSugBuild() != null && FullFragmentEx.this.getSugCallback().getSugBuild().getVersion() == 1) {
                        SugParams clone = FullFragmentEx.this.getmParam().clone();
                        clone.addressParam.addressType = 1;
                        IAddressResult iAddressResult = FullFragmentEx.this.getmResult();
                        iAddressResult.setStart(address);
                        FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                        fullFragmentEx2.onConfirm(fullFragmentEx2.getmParam(), iAddressResult.clone());
                        FullFragmentEx.this.switchMapSelect(clone, iAddressResult.clone(), 1);
                        int unused2 = FullFragmentEx.this.f4463x = 1;
                        return;
                    }
                    FullFragmentEx fullFragmentEx3 = FullFragmentEx.this;
                    fullFragmentEx3.setResultBack(fullFragmentEx3.f4452m, address);
                    if (!z) {
                        boolean unused3 = FullFragmentEx.this.f4462w = true;
                        AddressTrack.trackRecItemSelect(i + 1);
                    }
                } else if (FullFragmentEx.this.f4452m == 2) {
                    if (address != null && address.isDiscountPoi) {
                        ParentAddress parentAddress = new ParentAddress();
                        parentAddress.addressType = 2;
                        parentAddress.address = FullFragmentEx.this.mo23045a(rpcPoi2);
                        FullFragmentEx.this.getmResult().setParent(parentAddress);
                    }
                    if (address == null || (!address.enableConfirmDropoff && !address.isDiscountPoi)) {
                        FullFragmentEx fullFragmentEx4 = FullFragmentEx.this;
                        fullFragmentEx4.setResultBack(fullFragmentEx4.f4452m, address);
                    } else {
                        FullFragmentEx fullFragmentEx5 = FullFragmentEx.this;
                        fullFragmentEx5.switchEndConfirm(fullFragmentEx5.getmParam(), FullFragmentEx.this.getmResult(), address, rpcPoi3);
                    }
                } else if (FullFragmentEx.this.f4452m == 5) {
                    if (FullFragmentEx.this.f4444e != null) {
                        FullFragmentEx.this.f4444e.removeCommonWatcher(FullFragmentEx.this.getmParam().addressParam);
                        FullFragmentEx.this.f4444e.getCommonEditText().setText(rpcPoi3.base_info != null ? rpcPoi3.base_info.displayname : "");
                    }
                    FullFragmentEx fullFragmentEx6 = FullFragmentEx.this;
                    fullFragmentEx6.setResultBack(fullFragmentEx6.f4452m, address);
                    AddressTrack.trackAddAddressItemClick();
                } else if (FullFragmentEx.this.f4452m == 6) {
                    FullFragmentEx fullFragmentEx7 = FullFragmentEx.this;
                    fullFragmentEx7.setResultBack(fullFragmentEx7.f4452m, address);
                }
                if (rpcPoi3.extend_info != null && rpcPoi3.extend_info.enable_confirm_dropoff != 1) {
                    FullFragmentEx.this.f4449j.recordClickPoi(FullFragmentEx.this.getmParam(), rpcPoi3.base_info);
                }
            }
        }

        private String getSearchText() {
            if (FullFragmentEx.this.f4444e == null) {
                return "";
            }
            if (FullFragmentEx.this.f4452m == 1) {
                return FullFragmentEx.this.f4444e.getStartEditText().getText().toString();
            }
            if (FullFragmentEx.this.f4452m == 2) {
                return FullFragmentEx.this.f4444e.getEndEditText().getText().toString();
            }
            if (FullFragmentEx.this.f4452m == 3) {
                return FullFragmentEx.this.f4444e.getCommonEditText().getText().toString();
            }
            if (FullFragmentEx.this.f4452m == 4) {
                return FullFragmentEx.this.f4444e.getCommonEditText().getText().toString();
            }
            return "";
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: G */
    public AddressAdapter.OnMapConfirmClickListener f4438G = new AddressAdapter.OnMapConfirmClickListener() {
        public void onMapConfirmClicked(ArrayList<RpcPoi> arrayList, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            AddressTrack.trackMapConfirmTipClick(i2, trackParameterForChild.search_id, System.currentTimeMillis());
            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
            fullFragmentEx.switchMapConfirm(fullFragmentEx.getmParam(), (RpcPoi) null, trackParameterForChild, FullFragmentEx.this.getmResult(), i2);
        }
    };
    /* access modifiers changed from: private */

    /* renamed from: H */
    public View.OnClickListener f4439H = new View.OnClickListener() {
        public void onClick(View view) {
            AutoTrackHelper.trackViewOnClick(view);
            if (FullFragmentEx.this.f4438G != null) {
                FullFragmentEx.this.f4438G.onMapConfirmClicked(FullFragmentEx.this.f4464y, FullFragmentEx.this.f4433B, FullFragmentEx.this.f4452m, FullFragmentEx.this.f4465z);
            }
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f4440a;

    /* renamed from: b */
    CommonAddressReactor f4441b = new CommonAddressReactor();

    /* renamed from: c */
    int f4442c = 0;

    /* renamed from: d */
    private final int f4443d = 12;
    /* access modifiers changed from: private */

    /* renamed from: e */
    public SugSearchView f4444e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public SugListViewContainer f4445f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public Address f4446g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public Address f4447h;

    /* renamed from: i */
    private GlobalSugCallback f4448i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public AddressPresenter f4449j;

    /* renamed from: k */
    private Handler f4450k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public int f4451l = 2;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public int f4452m = -1;

    /* renamed from: n */
    private boolean f4453n;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public boolean f4454o = true;

    /* renamed from: p */
    private boolean f4455p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public boolean f4456q;

    /* renamed from: r */
    private boolean f4457r = false;
    /* access modifiers changed from: private */

    /* renamed from: s */
    public boolean f4458s = false;
    /* access modifiers changed from: private */

    /* renamed from: t */
    public boolean f4459t = false;
    /* access modifiers changed from: private */

    /* renamed from: u */
    public boolean f4460u = false;

    /* renamed from: v */
    private boolean f4461v = false;
    /* access modifiers changed from: private */

    /* renamed from: w */
    public boolean f4462w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f4463x = -1;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public ArrayList<RpcPoi> f4464y;
    /* access modifiers changed from: private */

    /* renamed from: z */
    public int f4465z;

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
        super.onAttach(activity);
        AppFluentOmega.getInstance().startCalculateTime(4, 5);
        if (getmParam() == null || getmParam().addressParam == null) {
            GlobalSugCallback globalSugCallback = this.f4448i;
            if (globalSugCallback != null) {
                globalSugCallback.onAttach(Integer.MIN_VALUE);
                return;
            }
            return;
        }
        setCurrAddressType(getmParam().addressParam.addressType);
        GlobalSugCallback globalSugCallback2 = this.f4448i;
        if (globalSugCallback2 != null) {
            globalSugCallback2.onAttach(getmParam().addressParam.addressType);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m2765a();
    }

    /* renamed from: a */
    private void m2765a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f4449j = new AddressPresenter(getActivity(), this);
        this.f4440a = new SimpleCompanyHomePresenter(getActivity());
        this.f4455p = true;
        this.f4456q = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        setCurrAddressType(getmParam().addressParam.addressType);
        this.f4450k = new Handler(Looper.getMainLooper()) {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    FullFragmentEx.this.m2767a(i, (String) message.obj, false);
                }
            }
        };
    }

    public void setCurrAddressType(int i) {
        this.f4452m = i;
    }

    public void setSearchViewType(int i) {
        this.f4451l = i;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_sug_fragment, viewGroup, false);
        m2768a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m2768a(View view) {
        view.findViewById(R.id.top_bar).setVisibility(8);
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f4444e = sugSearchView;
        sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        this.f4445f = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f4434C = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f4435D = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f4436E = (NetErrorView) view.findViewById(R.id.net_view_error);
        m2790c();
        m2780b();
        m2793d();
        m2795e();
    }

    /* renamed from: b */
    private void m2780b() {
        if (this.f4444e != null && getmParam() != null) {
            if (this.f4444e.getCancel(getmParam().addressParam.addressType) != null) {
                this.f4444e.getCancel(getmParam().addressParam.addressType).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                        fullFragmentEx.onCancel(fullFragmentEx.getmParam(), FullFragmentEx.this.getmResult());
                        FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                        fullFragmentEx2.switchBack(fullFragmentEx2.getmParam(), FullFragmentEx.this.getmResult());
                        if (FullFragmentEx.this.getSugCallback() != null) {
                            FullFragmentEx.this.getSugCallback().onCancelButtonPressed();
                        }
                        AddressTrack.trackSugCancelCK(FullFragmentEx.this.getmParam(), FullFragmentEx.this.f4452m);
                    }
                });
            }
            this.f4444e.setOnEnterWayPointViewClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    ViewUtils.hideInputWindow(FullFragmentEx.this.getActivity(), FullFragmentEx.this.getView());
                    if (FullFragmentEx.this.getSugCallback() != null) {
                        FullFragmentEx.this.getSugCallback().onStartEndAddressChanged(FullFragmentEx.this.m2801h(), FullFragmentEx.this.f4447h);
                    }
                    if (!(FullFragmentEx.this.getmParam() == null || FullFragmentEx.this.getmParam().wayPointParam == null || FullFragmentEx.this.getmParam().wayPointParam.getWayPoints() == null || FullFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0) == null || FullFragmentEx.this.m2801h() == null)) {
                        FullFragmentEx.this.getmParam().wayPointParam.getWayPoints().get(0).setAddress(FullFragmentEx.this.m2801h());
                    }
                    FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                    fullFragmentEx.onConfirm(fullFragmentEx.getmParam(), FullFragmentEx.this.getmResult());
                    FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                    fullFragmentEx2.switchWayPointer(fullFragmentEx2.getmParam(), FullFragmentEx.this.getmResult());
                }
            });
            if (getmParam().fromType == FromType.HOME) {
                String string = getContext().getResources().getString(R.string.global_sug_current_location);
                if (TextUtils.isEmpty(getmParam().addressParam.targetAddress.displayName)) {
                    getmParam().addressParam.targetAddress.displayName = string;
                }
            }
            this.f4444e.initSugSearchView(getmParam());
            this.f4444e.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    FullFragmentEx.this.m2767a(i, str, true);
                }
            });
            if ((CommonUtils.isFromConfirmPage(getmParam().fromType) || CommonUtils.isFromGetOnPage(getmParam().fromType)) && getmParam().addressParam.addressType == 1) {
                m2819q();
            }
            if (!getmParam().is_start_address_new_select) {
                if (getmParam().map_select_oper == SugParams.MapSelectOper.EDIT) {
                    getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Edit);
                    getmResult().setResult(1, getmParam().addressParam.targetAddress);
                }
                if (getmParam().map_select_oper == SugParams.MapSelectOper.CHOSE) {
                    getmParam().addressParam.addressType = 2;
                    setCurrAddressType(getmParam().addressParam.addressType);
                    storeStartAddress(getmParam().addressParam);
                } else {
                    storeStartAddress(getmParam().addressParam);
                }
                if (getmParam().fromType == FromType.CONFIRM && getmParam().addressParam.addressType == 2) {
                    getmResult().setResult(2, getmParam().addressParam.targetAddress);
                }
            }
            m2772a(getmParam().addressParam);
            this.f4444e.setListener(getmParam().addressParam);
            this.f4444e.makeStartTextFocusedWhenIsRed();
            this.f4444e.post(new Runnable() {
                public void run() {
                    if (CommonUtils.isFromConfirmPage(FullFragmentEx.this.getmParam().fromType)) {
                        if (FullFragmentEx.this.getmParam().addressParam.addressType == 1 && FullFragmentEx.this.f4444e.isStartTextNeedScrollToBottomWhenFocused) {
                            FullFragmentEx.this.m2807k();
                        }
                    } else if (CommonUtils.isFromGetOnPage(FullFragmentEx.this.getmParam().fromType) && FullFragmentEx.this.getmParam().addressParam.addressType == 1) {
                        FullFragmentEx.this.m2819q();
                    }
                }
            });
            this.f4444e.postDelayed(new Runnable() {
                public void run() {
                    if (FullFragmentEx.this.f4445f != null) {
                        FullFragmentEx.this.f4445f.setTopPadding(FullFragmentEx.this.f4444e.getMeasuredHeight());
                    }
                    FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                    fullFragmentEx.m2772a(fullFragmentEx.getmParam().addressParam);
                }
            }, 200);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m2772a(AddressParam addressParam) {
        EditTextErasable endEditText;
        if (addressParam.addressType == 2) {
            m2812n();
            if (getmParam().fromType == FromType.HOME && (endEditText = this.f4444e.getEndEditText()) != null) {
                endEditText.setFocusable(true);
                endEditText.sendAccessibilityEvent(128);
            }
        } else if (addressParam.addressType == 1) {
            m2810m();
        } else {
            m2809l();
            EditTextErasable commonEditText = this.f4444e.getCommonEditText();
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
        return m2776a(addressParam.targetAddress);
    }

    public int getCurrentDataAddressType() {
        return this.f4452m;
    }

    /* renamed from: a */
    private boolean m2776a(Address address) {
        SystemUtils.log(3, "ccc", "storeStartAddress = " + address, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 393);
        this.f4446g = address;
        onStartChoosen(address);
        if (address == null) {
            return false;
        }
        getmParam().addressParam.targetAddress = address.clone();
        return true;
    }

    /* renamed from: c */
    private void m2790c() {
        this.f4445f.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                boolean z;
                AutoTrackHelper.trackViewOnClick(view);
                String str = FullFragmentEx.TAG;
                SystemUtils.log(3, str, "setOnSelectPoiFooterViewClickListener() mSearchViewType: " + FullFragmentEx.this.f4451l + ", mCurrAddressType: " + FullFragmentEx.this.f4452m, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx$7", 410);
                AddressTrack.trackMapSelect(FullFragmentEx.this.getmParam().addressParam, FullFragmentEx.this.f4452m, AddressPresenter.isLastCachedRecommendCache(FullFragmentEx.this.f4452m));
                FullFragmentEx.this.f4444e.setSearchViewCallback((ISearchViewCallback) null);
                if (ApolloUtil.getRecOmegaCKAB()) {
                    z = false;
                    if (FullFragmentEx.this.f4452m != 1 ? AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.END_SUG : AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_SUG) {
                        z = true;
                    }
                } else {
                    z = FullFragmentEx.this.f4452m == 1 ? FullFragmentEx.this.f4458s : FullFragmentEx.this.f4459t;
                }
                if (FullFragmentEx.this.getmResult().getResult(FullFragmentEx.this.f4452m) != null) {
                    FullFragmentEx.this.getmResult().getResult(FullFragmentEx.this.f4452m).operationType = !z ? 2 : 3;
                }
                FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                fullFragmentEx.onConfirm(fullFragmentEx.getmParam(), FullFragmentEx.this.getmResult());
                SugParams clone = FullFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = FullFragmentEx.this.f4452m;
                AddressResult addressResult = FullFragmentEx.this.getmResult().getAddressResult();
                if (FullFragmentEx.this.f4452m == 1) {
                    if (addressResult.start != null) {
                        clone.addressParam.targetAddress = addressResult.start;
                    }
                    int unused = FullFragmentEx.this.f4463x = 1;
                } else if (FullFragmentEx.this.f4452m == 2 && addressResult.end != null) {
                    clone.addressParam.targetAddress = addressResult.end;
                }
                if (FullFragmentEx.this.getmParam().fromType == FromType.ROUTE_EDITOR) {
                    FullFragmentEx.this.setParentNodeType(IFragment.ParentNode.CHILD);
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                fullFragmentEx2.switchMapSelect(clone, fullFragmentEx2.getmResult(), FullFragmentEx.this.f4452m, bundle);
            }
        });
        this.f4445f.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(FullFragmentEx.this.getContext(), FullFragmentEx.this.f4445f.getListView());
                    if (FullFragmentEx.this.f4442c != absListView.getFirstVisiblePosition()) {
                        int c = FullFragmentEx.this.f4452m;
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(FullFragmentEx.this.getmParam().fromType);
                        int pageLevel = CommonUtils.getPageLevel(FullFragmentEx.this.getmParam().fromType, FullFragmentEx.this.f4452m);
                        FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                        AddressTrack.trackScrollCK(c, isFromRouteEditor ? 1 : 0, pageLevel, fullFragmentEx.m2762a(fullFragmentEx.f4452m), FullFragmentEx.this.f4433B, FullFragmentEx.this.f4442c, absListView.getFirstVisiblePosition(), FullFragmentEx.this.f4460u);
                    }
                }
                if (i == 1 || i == 2) {
                    FullFragmentEx.this.f4442c = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m2793d() {
        this.f4434C.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f4435D.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (FullFragmentEx.this.f4452m == 1) {
                    editTextErasable = FullFragmentEx.this.f4444e.getStartEditText();
                } else {
                    editTextErasable = FullFragmentEx.this.f4452m == 2 ? FullFragmentEx.this.f4444e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(FullFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f4436E.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                EditTextErasable editTextErasable;
                AutoTrackHelper.trackViewOnClick(view);
                if (FullFragmentEx.this.f4452m == 1) {
                    editTextErasable = FullFragmentEx.this.f4444e.getStartEditText();
                } else {
                    editTextErasable = FullFragmentEx.this.f4452m == 2 ? FullFragmentEx.this.f4444e.getEndEditText() : null;
                }
                ViewUtils.hideInputMethodForEditText(FullFragmentEx.this.getContext(), editTextErasable);
            }
        });
        this.f4435D.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f4436E.getRetryBtn() != null) {
            this.f4436E.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    view.setClickable(false);
                    FullFragmentEx.this.f4435D.setVisibility(8);
                    if (FullFragmentEx.this.f4452m == 1) {
                        FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                        fullFragmentEx.m2781b(fullFragmentEx.f4452m, FullFragmentEx.this.f4444e.getStartEditText().getText().toString(), true);
                    } else if (FullFragmentEx.this.f4452m == 2) {
                        FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                        fullFragmentEx2.m2781b(fullFragmentEx2.f4452m, FullFragmentEx.this.f4444e.getEndEditText().getText().toString(), true);
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

    /* renamed from: e */
    private void m2795e() {
        this.f4445f.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(FullFragmentEx.this.getmParam().addressParam, FullFragmentEx.this.f4452m - 1, FullFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    FullFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = FullFragmentEx.this.f4445f.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(FullFragmentEx.this.getmParam(), homeAddress, FullFragmentEx.this.f4452m);
                    homeAddress.operationType = 4;
                    FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                    fullFragmentEx.setResultBack(fullFragmentEx.f4452m, homeAddress);
                    return;
                }
                FullFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                fullFragmentEx2.onConfirm(fullFragmentEx2.getmParam(), FullFragmentEx.this.getmResult());
                FullFragmentEx fullFragmentEx3 = FullFragmentEx.this;
                fullFragmentEx3.switchSingle(fullFragmentEx3.getmParam(), FullFragmentEx.this.getmResult(), 3);
                int unused = FullFragmentEx.this.f4463x = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(FullFragmentEx.this.getmParam().addressParam, FullFragmentEx.this.f4452m - 1, FullFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    FullFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = FullFragmentEx.this.f4445f.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(FullFragmentEx.this.getmParam(), companyAddress, FullFragmentEx.this.f4452m);
                    companyAddress.operationType = 5;
                    FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                    fullFragmentEx.setResultBack(fullFragmentEx.f4452m, companyAddress);
                    return;
                }
                FullFragmentEx.this.setParentNodeType(IFragment.ParentNode.FULL);
                FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                fullFragmentEx2.onConfirm(fullFragmentEx2.getmParam(), FullFragmentEx.this.getmResult());
                FullFragmentEx fullFragmentEx3 = FullFragmentEx.this;
                fullFragmentEx3.switchSingle(fullFragmentEx3.getmParam(), FullFragmentEx.this.getmResult(), 4);
                int unused = FullFragmentEx.this.f4463x = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    FullFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(FullFragmentEx.this.f4445f.getHomeAddress()), CommonUtils.isValidLocation(FullFragmentEx.this.f4445f.getCompanyAddress()), FullFragmentEx.this.f4452m - 1);
                SugParams clone = FullFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = FullFragmentEx.this.f4452m;
                FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                fullFragmentEx.onConfirm(clone, fullFragmentEx.getmResult());
                FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                fullFragmentEx2.switchFavorite(clone, fullFragmentEx2.getmResult());
            }
        });
    }

    /* renamed from: a */
    private String m2763a(AddressResult addressResult) {
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

    public String getStartAddressText() {
        return this.f4444e.getStartEditText().getText().toString().trim();
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f4444e != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f4444e.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f4445f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f4445f.getListView().setAdapter(waittingAdapter);
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
    public void m2767a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 690);
            SugParams clone = getmParam().clone();
            boolean z2 = false;
            if (getmParam().fromType == FromType.HOME && AddressPresenter.getLastAddressType() == 2 && AddressPresenter.isLastCachedRecommendCache(2)) {
                AddressParam addressParam = getmParam().addressParam;
                SugListViewContainer sugListViewContainer = this.f4445f;
                AddressTrack.trackEndRecVisibleListItemCount(addressParam, sugListViewContainer != null ? sugListViewContainer.getVisibleCount() : 0);
            }
            clone.addressParam.addressType = i;
            this.f4444e.post(new Runnable() {
                public void run() {
                    if (!FullFragmentEx.this.f4456q && FullFragmentEx.this.f4436E.getVisibility() != 0) {
                        if (TextUtil.isEmpty(str) || FullFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                            FullFragmentEx.this.showWaittingList();
                        }
                    }
                }
            });
            boolean z3 = true;
            if (m2777a(str)) {
                if (i == 2) {
                    this.f4459t = true;
                } else if (i == 1) {
                    this.f4458s = true;
                }
                if (m2774a(clone)) {
                    Address h = m2801h();
                    AddressParam addressParam2 = clone.addressParam;
                    if (h != null) {
                        z2 = true;
                    }
                    addressParam2.needDiscount = z2;
                    clone.addressParam.startAddress = h;
                } else {
                    clone.addressParam.needDiscount = false;
                }
                this.f4449j.processDataRequire(clone, str, z, i);
                this.f4460u = true;
                return;
            }
            if (m2774a(clone)) {
                Address h2 = m2801h();
                AddressParam addressParam3 = clone.addressParam;
                if (h2 == null) {
                    z3 = false;
                }
                addressParam3.needDiscount = z3;
                clone.addressParam.startAddress = h2;
            } else {
                clone.addressParam.needDiscount = false;
            }
            this.f4449j.processDataRequire(clone, "", z, i);
            this.f4460u = false;
        }
    }

    /* renamed from: a */
    private boolean m2774a(SugParams sugParams) {
        if (sugParams.addressParam.addressType == 2) {
            return sugParams.fromType == FromType.HOME || sugParams.fromType == FromType.CONFIRM_NEW;
        }
        return false;
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2781b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            String str2 = TAG;
            SystemUtils.log(5, str2, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 762);
            SugParams clone = getmParam().clone();
            boolean z2 = false;
            if (getmParam().fromType == FromType.HOME && AddressPresenter.getLastAddressType() == 2 && AddressPresenter.isLastCachedRecommendCache(2)) {
                AddressParam addressParam = getmParam().addressParam;
                SugListViewContainer sugListViewContainer = this.f4445f;
                AddressTrack.trackEndRecVisibleListItemCount(addressParam, sugListViewContainer != null ? sugListViewContainer.getVisibleCount() : 0);
            }
            clone.addressParam.addressType = i;
            this.f4444e.post(new Runnable() {
                public void run() {
                    if (!FullFragmentEx.this.f4456q) {
                        FullFragmentEx.this.f4445f.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(FullFragmentEx.this.getActivity()) - FullFragmentEx.this.f4444e.getHeight()) / DisplayUtils.dp2px(FullFragmentEx.this.getActivity(), 66.0f)) - 1));
                    }
                }
            });
            boolean z3 = true;
            if (m2777a(str)) {
                if (i == 2) {
                    this.f4459t = true;
                } else if (i == 1) {
                    this.f4458s = true;
                }
                if (m2774a(clone)) {
                    Address h = m2801h();
                    AddressParam addressParam2 = clone.addressParam;
                    if (h != null) {
                        z2 = true;
                    }
                    addressParam2.needDiscount = z2;
                    clone.addressParam.startAddress = h;
                } else {
                    clone.addressParam.needDiscount = false;
                }
                this.f4449j.getSuggestPoiList(clone, str, z, i, true);
                this.f4460u = true;
                return;
            }
            if (m2774a(clone)) {
                Address h2 = m2801h();
                AddressParam addressParam3 = clone.addressParam;
                if (h2 == null) {
                    z3 = false;
                }
                addressParam3.needDiscount = z3;
                clone.addressParam.startAddress = h2;
            } else {
                clone.addressParam.needDiscount = false;
            }
            this.f4449j.processDataRequire(clone, "", z, i);
            this.f4460u = false;
        }
    }

    /* renamed from: a */
    private boolean m2777a(String str) {
        Address address;
        Address address2;
        if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
            return false;
        }
        if (this.f4452m == 1 && (((address2 = this.f4446g) != null && str.equals(address2.displayName)) || (getmParam().addressParam.targetAddress != null && str.equals(getmParam().addressParam.targetAddress.displayName)))) {
            return false;
        }
        if (this.f4452m != 2 || (address = this.f4447h) == null || !str.equals(address.displayName)) {
            return true;
        }
        return false;
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f4456q = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f4445f;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
        if (!this.f4462w && AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
            AddressTrack.trackRecItemSelect(0);
        }
        AppFluentOmega.getInstance().removeOmega(4, 5);
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public boolean closeFragment() {
        m2799g();
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
        AddressTrack.onViewCreated(getmParam(), this.f4444e, this.f4445f);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        m2767a(getmParam().addressParam.addressType, "", false);
        if (CommonUtils.isFromGetOnPage(getmParam().fromType) || getmParam().fromType == FromType.MAP_POINT_SELECT) {
            this.f4445f.showSelectPoiFooterView(false);
        } else {
            this.f4445f.showSelectPoiFooterView(true);
        }
        SugAnimationConstants.setSugSearchViewHeightWhenHomepage(this.f4444e.getStartwithEndFullSize());
        if (CommonUtils.isFromHomePage(getmParam().fromType) && getmParam().addressParam.addressType == 2) {
            m2797f();
        }
    }

    /* renamed from: b */
    private void m2784b(RpcPoi rpcPoi) {
        if (this.f4449j != null && CommonUtils.isValidLocation(getmParam().addressParam) && getSugCallback() != null && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            this.f4449j.verifyStationAddress(getmParam(), rpcPoi);
        }
    }

    /* renamed from: f */
    private void m2797f() {
        if (this.f4449j != null && CommonUtils.isValidLocation(getmParam().addressParam)) {
            this.f4449j.fetchStartPoiInfo(getmParam());
        }
    }

    /* renamed from: g */
    private void m2799g() {
        AddressPresenter addressPresenter = this.f4449j;
        if (addressPresenter != null) {
            addressPresenter.stopFetchStartPoiInfo();
            this.f4449j.stopRevertGeo();
        }
    }

    public void onResume() {
        super.onResume();
        AddressPresenter addressPresenter = this.f4449j;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        if (getView() != null) {
            ViewUtils.hideInputWindow(getActivity(), getView());
            getView().clearFocus();
        }
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f4449j;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo23046a(GlobalSugCallback globalSugCallback) {
        this.f4448i = globalSugCallback;
    }

    public void onDetach() {
        super.onDetach();
        GlobalSugCallback globalSugCallback = this.f4448i;
        if (globalSugCallback != null) {
            globalSugCallback.onDetach(getmParam().addressParam != null ? getmParam().addressParam.addressType : Integer.MIN_VALUE);
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
        this.f4435D.setVisibility(8);
        this.f4436E.setVisibility(8);
        this.f4445f.findViewById(R.id.lv).setVisibility(0);
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public Address mo23045a(RpcPoi rpcPoi) {
        return ModelConverter.convertToAddress(rpcPoi);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f4445f;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            if (addressParam == null || addressParam.addressType == this.f4452m) {
                boolean z = false;
                if (this.f4461v && !this.f4462w && AddressTrack.getmCurrentListType() != AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    AddressTrack.trackRecItemSelect(0);
                }
                this.f4462w = false;
                if (AddressTrack.getmCurrentListType() == AddressTrack.LIST_REQUEST_TYPE.START_REC) {
                    z = true;
                }
                this.f4461v = z;
                this.f4445f.post(new Runnable() {
                    public void run() {
                        if (i == RpcRecSugInfo.TYPE_EMPTY_RESULT || i == RpcRecSugInfo.TYPE_SIMILAR_SCENE) {
                            ArrayList unused = FullFragmentEx.this.f4464y = arrayList;
                            FullFragmentEx.this.f4445f.getMapConfirmView().setOnClickListener(FullFragmentEx.this.f4439H);
                        }
                        RpcRecSug.TrackParameterForChild unused2 = FullFragmentEx.this.f4433B = trackParameterForChild;
                        int unused3 = FullFragmentEx.this.f4465z = i;
                        AddressAdapter addressAdapter = new AddressAdapter();
                        boolean z = true;
                        addressAdapter.setSupportConfirmDropOff(true);
                        addressAdapter.setOnItemSelectedListener(FullFragmentEx.this.f4437F);
                        AddressAdapter addressAdapter2 = addressAdapter;
                        addressAdapter2.updateAddress(arrayList, FullFragmentEx.this.getmParam().clone(), trackParameterForChild, FullFragmentEx.this.f4452m, i);
                        SugListViewContainer k = FullFragmentEx.this.f4445f;
                        ArrayList arrayList = arrayList;
                        if (arrayList != null) {
                            z = arrayList.isEmpty();
                        }
                        k.onAddressOcupy(z, false);
                        FullFragmentEx.this.f4445f.getListView().setAdapter(addressAdapter);
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
        this.f4445f.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f4445f.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f4445f.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        if (CommonUtils.isFromGetOnPage(getmParam().fromType) || getmParam().fromType == FromType.WAITRSP) {
            this.f4445f.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f4445f.onlyShowSelectPoiFooterView();
        }
        updateSelectPoiFooters(true);
        showCommonAddressView(false);
        this.f4435D.setVisibility(8);
        this.f4436E.setVisibility(0);
        this.f4436E.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        if (CommonUtils.isFromGetOnPage(getmParam().fromType) || getmParam().fromType == FromType.WAITRSP) {
            this.f4445f.findViewById(R.id.lv).setVisibility(8);
        } else {
            this.f4445f.onlyShowSelectPoiFooterView();
        }
        this.f4436E.setVisibility(8);
        this.f4435D.setVisibility(0);
        this.f4435D.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f4435D.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f4436E;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f4435D;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 1452);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = this.f4454o;
            if (getmParam().fromType == FromType.HOME || getmParam().fromType == FromType.CONFIRM || getmParam().fromType == FromType.GET_ON) {
                if (m2773a(i, address)) {
                    closeSessionWithResult(getmResult());
                }
            } else if (getmParam().fromType == FromType.WAITRSP) {
                Address address2 = getmParam().addressParam.targetAddress;
                if (address == null || DDSphericalUtil.computeDistanceBetween(new LatLng(address2.latitude, address2.longitude), new LatLng(address.latitude, address.longitude)) >= 200.0d) {
                    SugSearchView sugSearchView = this.f4444e;
                    if (!(sugSearchView == null || sugSearchView.getStartEditText() == null)) {
                        this.f4444e.removeWatcherForStart();
                        this.f4444e.getStartEditText().setText(address.displayName);
                        this.f4444e.getStartEditText().setSelection(0, address.displayName.length());
                        this.f4444e.addWatcherForStart();
                    }
                    m2791c(getString(R.string.GDriver_map_You_can_fNKJ, new Object[]{Elvish.Companion.getInstance().formatDistance(200.0d, DistanceStyle.M, 0, false)}));
                } else if (m2773a(i, address)) {
                    closeSessionWithResult(getmResult());
                }
            } else if (m2773a(i, address)) {
                switchBack(getmParam(), getmResult());
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public Address m2801h() {
        Address address = this.f4446g;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    /* renamed from: i */
    private Address m2802i() {
        Address address = this.f4447h;
        return address == null ? getmParam().addressParam.targetAddress : address;
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && getmParam().addressParam != null && getmParam().managerCallback != null && getmParam().addressParam.currentAddress != null) {
            getmParam().managerCallback.toLogin(getActivity(), getmParam().addressParam.currentAddress.latitude, getmParam().addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f4445f.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
        this.f4445f.updateMapConfirmHeaderView(tipsInfo, i);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (CommonUtils.isFromGetOnPage(getmParam().fromType) || getmParam().fromType == FromType.WAITRSP) {
            this.f4445f.showSelectPoiFooterView(false);
        } else {
            this.f4445f.showSelectPoiFooterView(true);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        if (str == null || i == 0 || i2 == 0) {
            this.f4432A = false;
        } else {
            this.f4432A = true;
        }
        this.f4445f.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f4444e != null && !this.f4453n && !this.f4456q && getActivity() != null) {
            if (z) {
                setSearchViewType(i);
                setCurrAddressType(i);
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), m2762a(i));
                if (i == 1) {
                    m2799g();
                    m2804j();
                    if (this.f4444e.isStartTextNeedScrollToBottomWhenFocused) {
                        m2807k();
                    }
                    m2767a(1, "", false);
                    AddressTrack.trackStartPointViewClick(getmParam().addressParam, getStartAddressText(), CommonUtils.getFromPageTrack(getmParam()));
                    this.f4444e.addWatcherForStart();
                } else if (i == 2) {
                    Editable text = this.f4444e.getEndEditText().getText();
                    if (text != null) {
                        text.toString();
                    }
                    m2767a(2, "", false);
                    ViewUtils.showInputMethodForEditText(getContext(), this.f4444e.getEndEditText(), !this.f4456q);
                }
                this.f4444e.isStartTextRedColor = false;
            } else if (i == 1) {
                if (this.f4446g != null) {
                    this.f4444e.getStartEditText().setText(this.f4446g.displayName);
                    if (this.f4446g.displayName == null || !this.f4446g.displayName.equals(getContext().getResources().getString(R.string.global_sug_to_departure))) {
                        this.f4444e.getStartEditText().setTextColor(-16777216);
                        return;
                    }
                    this.f4444e.getStartEditText().setTextColor(getContext().getResources().getColor(R.color.poi_one_address_text_start_noname_hint));
                    m2797f();
                    return;
                }
                this.f4444e.getStartEditText().setText("");
            } else if (i == 2 && this.f4447h != null) {
                this.f4444e.getEndEditText().setText(this.f4447h.displayName);
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public String m2762a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f4444e.getEndEditText().getText().toString().trim();
        }
        return (this.f4444e.getCommonEditText() == null || TextUtils.isEmpty(this.f4444e.getCommonEditText().getText())) ? "" : this.f4444e.getCommonEditText().getText().toString().trim();
    }

    /* renamed from: j */
    private void m2804j() {
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.getEndEditText().setText("");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m2807k() {
        SugSearchView sugSearchView;
        if (!this.f4456q && (sugSearchView = this.f4444e) != null) {
            sugSearchView.getStartEditText().setSelection(0, this.f4444e.getStartEditText().length());
            ViewUtils.hideInputMethodForEditText(getActivity(), this.f4444e.getStartEditText());
        }
    }

    /* renamed from: l */
    private void m2809l() {
        SugSearchView sugSearchView;
        if (!this.f4456q && (sugSearchView = this.f4444e) != null) {
            if (!sugSearchView.getCommonEditText().isFocused()) {
                this.f4444e.setPressedState(true);
            }
            this.f4444e.getCommonEditText().requestFocus();
        }
    }

    /* renamed from: m */
    private void m2810m() {
        SugSearchView sugSearchView;
        if (!this.f4456q && (sugSearchView = this.f4444e) != null) {
            if (!sugSearchView.getStartEditText().isFocused()) {
                this.f4444e.setPressedState(true);
            }
            this.f4444e.getStartEditText().requestFocus();
        }
    }

    /* renamed from: n */
    private void m2812n() {
        SugSearchView sugSearchView;
        AddressTrack.isInSelectDestination = false;
        if (!this.f4456q && (sugSearchView = this.f4444e) != null) {
            if (!sugSearchView.getEndEditText().isFocused()) {
                this.f4444e.setPressedState(true);
            }
            this.f4444e.getEndEditText().requestFocus();
        }
    }

    /* renamed from: o */
    private void m2815o() {
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            Editable text = sugSearchView.getStartEditText().getText();
            if (!TextUtils.isEmpty(text)) {
                Selection.setSelection(text, text.length(), 0);
            }
        }
    }

    /* renamed from: p */
    private void m2816p() {
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.getStartEditText().setSelection(0);
        }
    }

    public void onClick(int i) {
        if (this.f4444e != null && !isSugFragmentRemoved()) {
            setSearchViewType(i);
            if (i == 1) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_START", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 1750);
                m2799g();
                m2819q();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f4444e.getStartEditText(), true ^ this.f4456q);
                this.f4444e.addWatcherForStart();
            } else if (i == 2) {
                SystemUtils.log(3, TAG, "onClick() SugSearchView.TYPE_END", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.full.FullFragmentEx", 1757);
                m2799g();
                ViewUtils.showInputMethodForEditText(getActivity(), this.f4444e.getEndEditText(), true ^ this.f4456q);
                this.f4444e.addEndTextWatcher();
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: q */
    public void m2819q() {
        SugSearchView sugSearchView;
        if (getActivity() == null) {
            return;
        }
        if (!CommonUtils.isValidLocation(getmParam().addressParam)) {
            ToastHelper.showLongInfoText(getActivity(), getContext().getResources().getString(R.string.global_sug_no_location));
        } else if (getString(R.string.global_sug_to_departure).equals(getStartAddressText()) && (sugSearchView = this.f4444e) != null) {
            sugSearchView.getStartEditText().setText("");
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f4444e != null) {
            setSearchViewType(i);
            if (i == 2 && this.f4457r) {
                this.f4457r = false;
            } else if (view.hasFocus()) {
                m2766a(i, editable.toString().trim());
            }
        }
    }

    /* renamed from: a */
    private void m2766a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f4450k.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f4450k;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m2787b(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
        }
    }

    /* renamed from: b */
    private boolean m2787b(AddressParam addressParam) {
        if (addressParam == null || this.f4444e == null) {
            return false;
        }
        if (addressParam.addressType == 1) {
            return this.f4444e.getStartEditText().hasFocus();
        }
        if (addressParam.addressType == 2) {
            return this.f4444e.getEndEditText().hasFocus();
        }
        return this.f4444e.getCommonEditText().hasFocus();
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
            setResultBack(this.f4452m, convertToAddress);
        }
    }

    /* renamed from: a */
    private boolean m2773a(int i, Address address) {
        if (getmParam().fromType == FromType.HOME) {
            if (i == 1) {
                if (address != null) {
                    if (TextUtils.isEmpty(address.displayName) && isFragmentOnDuty()) {
                        DLog.m7384d("SugAddress", "start address.displayName = null,address = " + address, new Object[0]);
                        address.displayName = getContext().getResources().getString(R.string.GRider_Sug_2020_currentLoc);
                    }
                    PoiidCompleteUtils.completePoiid(address);
                }
                Address address2 = this.f4447h;
                if (address2 == null) {
                    m2812n();
                    m2776a(address);
                    SugSearchView sugSearchView = this.f4444e;
                    if (sugSearchView != null) {
                        sugSearchView.getStartEditText().setText(address.displayName);
                        if (!TextUtils.isEmpty(this.f4444e.getEndEditText().getText())) {
                            this.f4444e.getEndEditText().setText("");
                        }
                    }
                    getmResult().setStart(address);
                    return false;
                } else if (!CommonUtils.isTwoAddressEqual(address2, address)) {
                    getmResult().setStart(address);
                    getmResult().setEnd(this.f4447h);
                    onConfirm(getmParam(), getmResult());
                } else {
                    CommonUtils.showDuplicateAlert(getContext());
                    return false;
                }
            } else if (i == 2) {
                if (!CommonUtils.isValidLocation(this.f4446g)) {
                    m2810m();
                    this.f4447h = address;
                    SugSearchView sugSearchView2 = this.f4444e;
                    if (sugSearchView2 != null) {
                        sugSearchView2.getEndEditText().setText(address.displayName);
                    }
                    return false;
                } else if (!CommonUtils.isTwoAddressEqual(this.f4446g, address)) {
                    getmResult().setStart(this.f4446g);
                    getmResult().setEnd(address);
                    onConfirm(getmParam(), getmResult());
                } else {
                    CommonUtils.showDuplicateAlert(getContext());
                    return false;
                }
            }
        } else if (i == 1) {
            getmResult().setStart(address);
            onConfirm(getmParam(), getmResult());
        } else if (i == 2) {
            getmResult().setEnd(address);
            onConfirm(getmParam(), getmResult());
        }
        return true;
    }

    public void onPageEnter() {
        long j;
        SugSearchView sugSearchView;
        SugSearchView sugSearchView2;
        if (this.f4444e != null) {
            final int i = this.f4452m;
            final int i2 = this.f4463x;
            if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                int i3 = this.f4452m;
                if (i3 == 1) {
                    getmResult().setStart(this.f4446g);
                } else if (i3 == 2) {
                    getmResult().setEnd(this.f4447h);
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
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, this.f4452m);
                }
            }
            this.f4444e.setSearchViewCallback((ISearchViewCallback) null);
            this.f4444e.removeWatcherForStart();
            this.f4444e.removeEndTextWatcher();
            this.f4444e.hideShadow();
            SugSearchView sugSearchView3 = this.f4444e;
            if (sugSearchView3 != null) {
                sugSearchView3.getStartEditText().setFocusable(false);
                this.f4444e.getStartEditText().setFocusableInTouchMode(false);
                this.f4444e.getEndEditText().setFocusable(false);
                this.f4444e.getEndEditText().setFocusableInTouchMode(false);
                this.f4444e.postDelayed(new Runnable() {
                    public void run() {
                        FullFragmentEx.this.f4444e.addWatcherForStart();
                        FullFragmentEx.this.f4444e.addEndTextWatcher();
                        FullFragmentEx.this.f4444e.setSearchViewCallback(FullFragmentEx.this);
                    }
                }, 750);
            }
            SugSearchView sugSearchView4 = this.f4444e;
            if (sugSearchView4 != null) {
                final boolean z5 = z;
                final boolean z6 = z4;
                final int i4 = i;
                j = 30;
                final boolean z7 = z3;
                final boolean z8 = z2;
                sugSearchView4.postDelayed(new Runnable() {
                    public void run() {
                        if (FullFragmentEx.this.f4444e != null) {
                            FullFragmentEx.this.f4444e.setSearchViewCallback(FullFragmentEx.this);
                            FullFragmentEx.this.f4444e.getStartEditText().setFocusable(true);
                            FullFragmentEx.this.f4444e.getStartEditText().setFocusableInTouchMode(true);
                            FullFragmentEx.this.f4444e.getEndEditText().setFocusable(true);
                            FullFragmentEx.this.f4444e.getEndEditText().setFocusableInTouchMode(true);
                        }
                        if (FullFragmentEx.this.isFirstEnter() || z5 || z6 || i2 != -1) {
                            FullFragmentEx.this.f4444e.setPressedState(false);
                            if (i4 == 1 && !z7 && (!z8 || FullFragmentEx.this.getmParam().fromType == FromType.FROM_HOME_ROUTE_EDITOR || FullFragmentEx.this.getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR || FullFragmentEx.this.getmParam().fromType == FromType.ROUTE_EDITOR)) {
                                if (FullFragmentEx.this.f4444e != null) {
                                    FullFragmentEx.this.f4444e.getStartEditText().requestFocus();
                                    FullFragmentEx.this.f4444e.getStartEditText().setTextIsSelectable(true);
                                    FullFragmentEx.this.f4444e.getStartEditText().setCursorVisible(false);
                                    FullFragmentEx.this.f4444e.getStartEditText().setCursorVisible(true);
                                    if (FullFragmentEx.this.getmResult().getResult(i4) != null && ((FullFragmentEx.this.isFirstEnter() || !FullFragmentEx.this.isResumeCalled()) && FullFragmentEx.this.getmResult().getResult(i4) != null)) {
                                        FullFragmentEx.this.f4444e.getStartEditText().setText(FullFragmentEx.this.getmResult().getResult(i4).displayName);
                                    }
                                    if (!TextUtils.isEmpty(FullFragmentEx.this.f4444e.getStartEditText().getText())) {
                                        FullFragmentEx.this.f4444e.getStartEditText().setClearIconVisible(true);
                                    }
                                    FullFragmentEx.this.f4444e.getStartEditText().setSelection(0, FullFragmentEx.this.f4444e.getStartEditText().length());
                                }
                            } else if (i4 == 2) {
                                if (FullFragmentEx.this.f4444e != null) {
                                    FullFragmentEx.this.f4444e.getEndEditText().requestFocus();
                                }
                                FullFragmentEx.this.f4444e.getEndEditText().setSelection(0, FullFragmentEx.this.f4444e.getEndEditText().length());
                            }
                        }
                    }
                }, 30);
                this.f4444e.postDelayed(new Runnable() {
                    public void run() {
                        if (z2 && !FullFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (z3 && !FullFragmentEx.this.isResumeCalled()) {
                            return;
                        }
                        if (FullFragmentEx.this.getmResult().getLastPageType() != FragmentFactory.FragmentType.FAVORITE || FullFragmentEx.this.getmResult().getLastOperType() != AddressResultEnhancer.OperType.Confirm) {
                            int i = i;
                            if (i == 1) {
                                ViewUtils.showInputMethodForEditText(FullFragmentEx.this.getContext(), FullFragmentEx.this.f4444e.getStartEditText());
                                FullFragmentEx.this.f4444e.resetShadow(FullFragmentEx.this.f4444e.getStartEditText());
                            } else if (i == 2) {
                                ViewUtils.showInputMethodForEditText(FullFragmentEx.this.getContext(), FullFragmentEx.this.f4444e.getEndEditText());
                                FullFragmentEx.this.f4444e.resetShadow(FullFragmentEx.this.f4444e.getEndEditText());
                            }
                        }
                    }
                }, 500);
            } else {
                j = 30;
            }
            if (getmResult().getLastOperType() != AddressResultEnhancer.OperType.Cancel && getmResult().getLastOperType() != AddressResultEnhancer.OperType.Other) {
                if (isFirstEnter() || !isResumeCalled()) {
                    if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT) {
                        int i5 = this.f4463x;
                        if (i5 == 3) {
                            if (this.f4445f != null && getmResult().getAddressResult().home != null) {
                                this.f4445f.setHomeAddress(getmResult().getAddressResult().home);
                                SugParams clone = getmParam().clone();
                                clone.addressParam.addressType = 3;
                                this.f4440a.setHomeCompany(clone.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f4441b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f4441b.onHomeUploadFailed();
                            }
                            this.f4463x = -1;
                            return;
                        } else if (i5 == 4) {
                            if (this.f4445f != null && getmResult().getAddressResult().company != null) {
                                this.f4445f.setCompanyAddress(getmResult().getAddressResult().company);
                                SugParams clone2 = getmParam().clone();
                                clone2.addressParam.addressType = 4;
                                this.f4440a.setHomeCompany(clone2.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f4441b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f4441b.onCompanyUploadFailed();
                            }
                            this.f4463x = -1;
                            return;
                        } else if (i5 == 1 && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().start != null) {
                                SugSearchView sugSearchView5 = this.f4444e;
                                if (sugSearchView5 != null) {
                                    sugSearchView5.postDelayed(new Runnable() {
                                        public void run() {
                                            if (FullFragmentEx.this.getmResult().getAddressResult().start != null) {
                                                FullFragmentEx.this.f4444e.getStartEditText().setText(FullFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                                FullFragmentEx.this.m2767a(i, "", false);
                                            }
                                            FullFragmentEx.this.f4444e.getStartEditText().requestFocus();
                                            FullFragmentEx.this.f4444e.getStartEditText().setSelection(0, FullFragmentEx.this.f4444e.getStartEditText().length());
                                        }
                                    }, j);
                                }
                            } else {
                                Address address = getmResult().getAddressResult().start;
                            }
                            this.f4463x = -1;
                            return;
                        }
                    } else {
                        int i6 = this.f4463x;
                        if (i6 == 3) {
                            if (this.f4445f != null && getmResult().getAddressResult().home != null) {
                                this.f4445f.setHomeAddress(getmResult().getAddressResult().home);
                                SugParams clone3 = getmParam().clone();
                                clone3.addressParam.addressType = this.f4463x;
                                this.f4440a.setHomeCompany(clone3.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f4441b);
                            } else if (getmResult().getAddressResult().home == null) {
                                this.f4441b.onHomeUploadFailed();
                            }
                            this.f4463x = -1;
                            return;
                        } else if (i6 == 4) {
                            if (this.f4445f != null && getmResult().getAddressResult().company != null) {
                                this.f4445f.setCompanyAddress(getmResult().getAddressResult().company);
                                SugParams clone4 = getmParam().clone();
                                clone4.addressParam.addressType = this.f4463x;
                                this.f4440a.setHomeCompany(clone4.addressParam, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f4441b);
                            } else if (getmResult().getAddressResult().company == null) {
                                this.f4441b.onCompanyUploadFailed();
                            }
                            this.f4463x = -1;
                            return;
                        }
                    }
                    if (i == 1) {
                        if (this.f4444e != null && !isFirstEnter() && getmResult().getAddressResult().start != null) {
                            this.f4444e.postDelayed(new Runnable() {
                                public void run() {
                                    if (FullFragmentEx.this.getmResult().getAddressResult().start != null) {
                                        FullFragmentEx.this.f4444e.getStartEditText().setText(FullFragmentEx.this.getmResult().getAddressResult().start.displayName);
                                        if (FullFragmentEx.this.f4447h == null && (!(FullFragmentEx.this.getmParam().fromType == FromType.GET_ON && FullFragmentEx.this.getmResult().getLastPageType() == FragmentFactory.FragmentType.FAVORITE) && !z2)) {
                                            FullFragmentEx.this.m2767a(i, "", false);
                                        }
                                        FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                                        Address unused = fullFragmentEx.f4446g = fullFragmentEx.getmResult().getAddressResult().start;
                                        FullFragmentEx fullFragmentEx2 = FullFragmentEx.this;
                                        fullFragmentEx2.onStartChoosen(fullFragmentEx2.f4446g);
                                        FullFragmentEx.this.f4444e.getStartEditText().requestFocus();
                                        FullFragmentEx fullFragmentEx3 = FullFragmentEx.this;
                                        fullFragmentEx3.setResultBack(i, fullFragmentEx3.f4446g);
                                    }
                                }
                            }, j);
                        }
                    } else if (i == 2 && (sugSearchView = this.f4444e) != null) {
                        sugSearchView.getEndEditText().requestFocus();
                        this.f4444e.addEndTextWatcher();
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.MAPSELECT && getmResult().getMapSelectOperType() == AddressResultEnhancer.MapSelectOper.Edit) {
                            if (getmResult().getAddressResult().end != null) {
                                this.f4444e.getEndEditText().setText(getmResult().getAddressResult().end.displayName);
                            }
                        } else if (getmResult().getLastPageType() != FragmentFactory.FragmentType.MAPSELECT || getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Other) {
                            Address address2 = getmResult().getAddressResult().end;
                            this.f4447h = address2;
                            if (!(address2 == null || (sugSearchView2 = this.f4444e) == null || sugSearchView2.getEndEditText() == null)) {
                                this.f4444e.getEndEditText().setText(this.f4447h.displayName);
                            }
                            if (!isFirstEnter() && this.f4447h != null) {
                                this.f4444e.postDelayed(new Runnable() {
                                    public void run() {
                                        if (FullFragmentEx.this.getmResult().getAddressResult().end != null) {
                                            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
                                            fullFragmentEx.setResultBack(i, fullFragmentEx.getmResult().getAddressResult().end);
                                        }
                                    }
                                }, j);
                            }
                        } else if (this.f4447h != null) {
                            this.f4444e.getEndEditText().setText(this.f4447h.displayName);
                        } else {
                            m2804j();
                        }
                    }
                }
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        SugSearchView sugSearchView = this.f4444e;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            this.f4444e.setSearchViewCallback((ISearchViewCallback) null);
        }
        if (getType() == FragmentFactory.FragmentType.FULL) {
            int i = this.f4452m;
            if (i == 1) {
                if (this.f4446g == null) {
                    getmResult().setStart(getmParam().addressParam.targetAddress);
                    onConfirm(getmParam(), getmResult());
                } else {
                    getmResult().setStart(this.f4446g);
                }
                if (this.f4444e != null && isFragmentOnDuty()) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f4444e.getStartEditText());
                }
            } else if (i == 2) {
                if (this.f4447h != null) {
                    getmResult().setEnd(this.f4447h);
                }
                if (AddressPresenter.isLastCachedRecommendCache(2)) {
                    AddressParam addressParam = getmParam().addressParam;
                    SugListViewContainer sugListViewContainer = this.f4445f;
                    AddressTrack.trackEndRecVisibleListItemCount(addressParam, sugListViewContainer != null ? sugListViewContainer.getVisibleCount() : 0);
                }
                if (this.f4444e != null && isFragmentOnDuty()) {
                    ViewUtils.hideInputMethodForEditText(getContext(), this.f4444e.getEndEditText());
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

    public boolean getDragHandlerEnable() {
        if (getmParam() == null || (getmParam().fromType != FromType.ROUTE_EDITOR && getmParam().fromType != FromType.FROM_HOME_ROUTE_EDITOR && getmParam().fromType != FromType.FROM_CONFIRM_ROUTE_EDITOR)) {
            return super.getDragHandlerEnable();
        }
        return false;
    }

    public SugSearchView getmSugSearchView() {
        return this.f4444e;
    }

    public void onStartChoosen(Address address) {
        super.onStartChoosen(address);
    }

    public void switchToStationMapSelect() {
        if (this.f4452m == 1 && !isRemoving() && !isSugFragmentRemoved()) {
            onConfirm(getmParam(), getmResult());
            switchMapSelect(getmParam().clone(), getmResult(), 1);
        }
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
            fullFragmentEx.m2785b(fullFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
            fullFragmentEx.m2791c(fullFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
            fullFragmentEx.m2791c(fullFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            FullFragmentEx fullFragmentEx = FullFragmentEx.this;
            fullFragmentEx.m2785b(fullFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !FullFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m2785b(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m2791c(String str) {
        if (isFragmentOnDuty()) {
            com.didi.addressnew.util.ToastHelper.showFail(getContext(), str);
        }
    }

    public boolean switchEndConfirm(SugParams sugParams, IAddressResult iAddressResult, Address address, RpcPoi rpcPoi) {
        SugParams clone;
        if (sugParams == null || iAddressResult == null || address == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        address.operationType = this.f4460u ? 3 : 2;
        clone.addressParam.addressType = 2;
        iAddressResult.setEnd(address);
        onConfirm(getmParam(), iAddressResult.clone());
        this.f4463x = 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable("end_confirm_data", rpcPoi);
        if (!TextUtils.isEmpty(this.f4444e.getEndEditText().getText())) {
            this.f4444e.getEndEditText().setSelection(0, this.f4444e.getEndEditText().length());
        }
        this.f4444e.getEndEditText().setSelection(0);
        switchEndConfirm(clone, iAddressResult, 2, bundle);
        return true;
    }

    public boolean switchMapConfirm(SugParams sugParams, RpcPoi rpcPoi, RpcRecSug.TrackParameterForChild trackParameterForChild, IAddressResult iAddressResult, int i) {
        SugParams clone;
        if (sugParams == null || iAddressResult == null || (clone = sugParams.clone()) == null) {
            return false;
        }
        int i2 = this.f4460u ? 3 : 2;
        Bundle bundle = new Bundle();
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_ADDRESS_LIST, this.f4464y);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SELECT_ADDRESS, rpcPoi);
        bundle.putSerializable(FuzzyMatchParam.FUZZY_PARAM_SUG_PARAM, trackParameterForChild);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_POI_TIP, i);
        bundle.putInt(FuzzyMatchParam.FUZZY_PARAM_SUG_OP_TYPE, i2);
        bundle.putBoolean(FuzzyMatchParam.FUZZY_PARAM_SHOW_DATA_PROVIDER, this.f4432A);
        if (rpcPoi != null) {
            Address convertToAddress = ModelConverter.convertToAddress(rpcPoi);
            convertToAddress.operationType = i2;
            int i3 = this.f4452m;
            if (i3 == 1) {
                clone.addressParam.addressType = 1;
                this.f4463x = 1;
                iAddressResult.setStart(convertToAddress);
            } else if (i3 == 2) {
                clone.addressParam.addressType = 2;
                this.f4463x = 2;
                iAddressResult.setEnd(convertToAddress);
            }
        }
        onConfirm(getmParam(), iAddressResult.clone());
        int i4 = this.f4452m;
        if (i4 == 1) {
            if (!TextUtils.isEmpty(this.f4444e.getStartEditText().getText())) {
                this.f4444e.getStartEditText().setSelection(0, this.f4444e.getStartEditText().length());
            }
            this.f4444e.getEndEditText().setSelection(0);
        } else if (i4 == 2) {
            if (!TextUtils.isEmpty(this.f4444e.getEndEditText().getText())) {
                this.f4444e.getEndEditText().setSelection(0, this.f4444e.getEndEditText().length());
            }
            this.f4444e.getEndEditText().setSelection(0);
        }
        switchMapConfirm(clone, iAddressResult, this.f4452m, bundle);
        return true;
    }
}

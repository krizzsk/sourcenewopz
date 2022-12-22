package com.didi.addressnew.framework.fragmentmarket.single;

import android.animation.Animator;
import android.app.Activity;
import android.content.Context;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;
import com.didi.address.FromType;
import com.didi.address.SugAlertOmegaUtil;
import com.didi.address.actors.GeoCodeReActor;
import com.didi.address.model.SugParams;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.utils.AddressConverter;
import com.didi.addressnew.framework.widget.loadingbutton.LoadableButton;
import com.didi.addressnew.presenter.AddressPresenter;
import com.didi.addressnew.presenter.CommonAddressPresenter;
import com.didi.addressnew.presenter.ISimpleCompanyHomePresenter;
import com.didi.addressnew.presenter.SimpleCompanyHomePresenter;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.ApolloUtil;
import com.didi.addressnew.util.CheckParamUtil;
import com.didi.addressnew.util.CommonUtils;
import com.didi.addressnew.util.ToastHelper;
import com.didi.addressnew.util.ViewUtils;
import com.didi.addressnew.view.AddressAdapter;
import com.didi.addressnew.view.IAddressView;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.addressnew.view.ISearchViewCallback;
import com.didi.addressnew.view.SugListViewContainer;
import com.didi.addressnew.view.SugSearchView;
import com.didi.addressnew.view.commonaddress.IHomeCompanyUploadRequestReactor;
import com.didi.addressnew.view.enhance.WaittingAdapter;
import com.didi.addressnew.widget.EmptyView;
import com.didi.addressnew.widget.NetErrorView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.common.map.util.DisplayUtils;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.TextUtil;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import com.taxis99.R;
import java.util.ArrayList;

public class SingleFragmentEx extends FragmentImpl implements IAddressView, ICommonAddressView, ISearchViewCallback {
    public static final String KEY_RESULT = "result";
    public static final int REQUEST_FAVORITE_PLACE_ADDRESS = 101;
    public static final String TAG = "SingleFragmentEx";
    /* access modifiers changed from: private */

    /* renamed from: A */
    public RpcRecSug.TrackParameterForChild f7355A;

    /* renamed from: B */
    private FrameLayout f7356B = null;

    /* renamed from: C */
    private EmptyView f7357C = null;
    /* access modifiers changed from: private */

    /* renamed from: D */
    public NetErrorView f7358D = null;
    /* access modifiers changed from: private */

    /* renamed from: E */
    public AddressAdapter.OnItemSelectedListener f7359E = new AddressAdapter.OnItemSelectedListener() {
        public void onItemSelected(RpcPoi rpcPoi, RpcPoi rpcPoi2, RpcRecSug.TrackParameterForChild trackParameterForChild, int i, int i2) {
            RpcPoi rpcPoi3 = rpcPoi;
            final RpcRecSug.TrackParameterForChild trackParameterForChild2 = trackParameterForChild;
            if (trackParameterForChild2 == null || !trackParameterForChild2.is_complete_poi) {
                if (SingleFragmentEx.this.getmParam().addressParam.addressType == 5) {
                    AddressTrack.trackAddAddressItemClick();
                }
                SingleFragmentEx.this.f7375p.getGeocodeResult(SingleFragmentEx.this.getmParam(), rpcPoi, getSearchText(), trackParameterForChild, i, i2, SingleFragmentEx.this.getmParam().addressParam.addressType, new GeoCodeReActor() {
                    public void onGeoCodeFailed(AddressParam addressParam, Exception exc) {
                    }

                    public void onGeoCodeSuccess(AddressParam addressParam, Address address, RpcPoi rpcPoi) {
                        SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
                        SingleFragmentEx.this.setResultBackOnSingle(SingleFragmentEx.this.getmParam().addressParam.addressType, address, rpcPoi);
                    }
                });
                return;
            }
            SugAlertOmegaUtil.trackSelectPoiInfoError(rpcPoi, trackParameterForChild2);
            int i3 = SingleFragmentEx.this.f7384y ? 3 : 2;
            AddressTrack.trackAddressClick(SingleFragmentEx.this.getmParam(), rpcPoi3.base_info, getSearchText(), String.valueOf(i), String.valueOf(i2), trackParameterForChild, SingleFragmentEx.this.getmParam().addressParam.addressType, AddressTrack.SUG_JUMP_TYPE.JUMP_NORMAL, i3);
            Address rpc2Address = AddressConverter.rpc2Address(rpcPoi);
            if (rpc2Address != null) {
                rpc2Address.operationType = i3;
            }
            if ((SingleFragmentEx.this.getmParam().addressParam.addressType == 3 || SingleFragmentEx.this.getmParam().addressParam.addressType == 4 || SingleFragmentEx.this.getmParam().addressParam.addressType == 5) && SingleFragmentEx.this.getSugCallback() != null && SingleFragmentEx.this.getSugCallback().getSugBuild() != null && SingleFragmentEx.this.getSugCallback().getSugBuild().getVersion() == 1) {
                SugParams clone = SingleFragmentEx.this.getmParam().clone();
                IAddressResult clone2 = SingleFragmentEx.this.getmResult().clone();
                clone2.setResult(clone.addressParam.addressType, rpc2Address);
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx.this.switchMapSelect(clone, clone2, clone.addressParam.addressType);
                int unused = SingleFragmentEx.this.f7383x = clone.addressParam.addressType;
                return;
            }
            SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
            singleFragmentEx2.setResultBackOnSingle(singleFragmentEx2.getmParam().addressParam.addressType, rpc2Address, rpcPoi);
            SingleFragmentEx.this.f7375p.recordClickPoi(SingleFragmentEx.this.getmParam(), rpcPoi3.base_info);
        }

        private String getSearchText() {
            if (SingleFragmentEx.this.f7371l == null) {
                return "";
            }
            if (SingleFragmentEx.this.getmParam().addressParam.addressType == 3) {
                return SingleFragmentEx.this.f7371l.getCommonEditText().getText().toString();
            }
            if (SingleFragmentEx.this.getmParam().addressParam.addressType == 4) {
                return SingleFragmentEx.this.f7371l.getCommonEditText().getText().toString();
            }
            return "";
        }
    };

    /* renamed from: a */
    ISimpleCompanyHomePresenter f7360a;

    /* renamed from: b */
    CommonAddressReactor f7361b = new CommonAddressReactor();

    /* renamed from: c */
    ImageView f7362c;

    /* renamed from: d */
    View f7363d;

    /* renamed from: e */
    View f7364e;

    /* renamed from: f */
    TextView f7365f;

    /* renamed from: g */
    TextView f7366g;

    /* renamed from: h */
    LoadableButton f7367h;

    /* renamed from: i */
    int f7368i = 0;

    /* renamed from: j */
    private final FragmentFactory.FragmentType f7369j = FragmentFactory.FragmentType.SINGLE;

    /* renamed from: k */
    private final int f7370k = 12;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SugSearchView f7371l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public SugListViewContainer f7372m;

    /* renamed from: n */
    private ImageView f7373n;

    /* renamed from: o */
    private TextView f7374o;
    /* access modifiers changed from: private */

    /* renamed from: p */
    public AddressPresenter f7375p;
    /* access modifiers changed from: private */

    /* renamed from: q */
    public CommonAddressPresenter f7376q;

    /* renamed from: r */
    private Handler f7377r;

    /* renamed from: s */
    private Address f7378s = null;

    /* renamed from: t */
    private boolean f7379t;

    /* renamed from: u */
    private boolean f7380u;
    /* access modifiers changed from: private */

    /* renamed from: v */
    public boolean f7381v;

    /* renamed from: w */
    private boolean f7382w = false;
    /* access modifiers changed from: private */

    /* renamed from: x */
    public int f7383x = -1;
    /* access modifiers changed from: private */

    /* renamed from: y */
    public boolean f7384y = false;

    /* renamed from: z */
    private boolean f7385z = false;

    /* renamed from: h */
    private void m4614h() {
    }

    public boolean getDragHandlerEnable() {
        return false;
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

    public boolean storeStartAddress(AddressParam addressParam) {
        return false;
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (getArguments() != null && getmParam() != null) {
            Context applicationContext = activity.getApplicationContext();
            CheckParamUtil.rescueAddressParam(applicationContext, getClass().getSimpleName() + " onAttach", getmParam().addressParam);
        }
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m4586a();
    }

    /* renamed from: a */
    private void m4586a() {
        AddressTrack.getInstance().collectAllVamosAttrs((SugParams) null, getmParam().usrType);
        this.f7375p = new AddressPresenter(getActivity(), this);
        this.f7376q = new CommonAddressPresenter(getActivity(), this);
        this.f7360a = new SimpleCompanyHomePresenter(getActivity());
        this.f7380u = true;
        this.f7381v = false;
        ApolloUtil.initSugSearchInternalTimeAccordingRegion(PaxEnvironment.getInstance().getCountryCode());
        this.f7377r = new Handler() {
            public void handleMessage(Message message) {
                super.handleMessage(message);
                if (message.what == 12) {
                    int i = message.arg1;
                    SingleFragmentEx.this.m4588a(i, (String) message.obj, false);
                }
            }
        };
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        return super.onCreateAnimator(i, z, i2);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.layout_single_sug_fragment, viewGroup, false);
        m4589a(inflate);
        return inflate;
    }

    /* renamed from: a */
    private void m4589a(View view) {
        m4600b(view.findViewById(R.id.sug_close_btn));
        this.f7362c = (ImageView) view.findViewById(R.id.sug_close_btn);
        this.f7373n = (ImageView) view.findViewById(R.id.delte_btn);
        this.f7374o = (TextView) view.findViewById(R.id.set_common_title);
        this.f7363d = view.findViewById(R.id.common_del_panel_mask);
        this.f7364e = view.findViewById(R.id.common_del_panel);
        this.f7365f = (TextView) view.findViewById(R.id.common_del_panel_title);
        this.f7366g = (TextView) view.findViewById(R.id.common_del_panel_cancel);
        LoadableButton loadableButton = (LoadableButton) view.findViewById(R.id.common_del_panel_confirm);
        this.f7367h = loadableButton;
        loadableButton.setText(getString(R.string.GRider_Sug_2020_confirm));
        this.f7367h.setTextSize(24);
        this.f7367h.setTextStyle(Typeface.DEFAULT_BOLD);
        this.f7367h.reset();
        SugSearchView sugSearchView = (SugSearchView) view.findViewById(R.id.search_view);
        this.f7371l = sugSearchView;
        if (sugSearchView != null) {
            sugSearchView.setmShadowView(view.findViewById(R.id.input_shadow));
        }
        m4609e();
        this.f7372m = (SugListViewContainer) view.findViewById(R.id.list_view);
        this.f7356B = (FrameLayout) view.findViewById(R.id.progressbar_layout);
        this.f7357C = (EmptyView) view.findViewById(R.id.empty_view_error);
        this.f7358D = (NetErrorView) view.findViewById(R.id.net_view_error);
        m4604c();
        m4598b();
        m4606d();
        m4623l();
    }

    /* renamed from: b */
    private void m4598b() {
        if (this.f7371l != null && getmParam() != null) {
            if (CommonUtils.isFromSetting(getmParam().fromType)) {
                this.f7371l.addStatusBarHeightView();
            }
            this.f7371l.setSearchViewCallback(this);
            this.f7371l.initSugSearchView(getmParam());
            this.f7371l.onSingle(getmParam().addressParam, getmResult());
            if (this.f7371l.getCancel(getmParam().addressParam.addressType) != null) {
                this.f7371l.getCancel(getmParam().addressParam.addressType).setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.onCancel(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                        singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                        AddressTrack.trackSugCancelCK(SingleFragmentEx.this.getmParam(), SingleFragmentEx.this.getmParam().addressParam.addressType);
                    }
                });
            }
            this.f7371l.setOnClickSearchButtonListener(new SugSearchView.OnClickSearchButtonListener() {
                public void onClickSearchButton(int i, String str) {
                    SingleFragmentEx.this.m4588a(i, str, true);
                }
            });
            this.f7371l.setListener(getmParam().addressParam);
            this.f7371l.makeStartTextFocusedWhenIsRed();
            this.f7371l.post(new Runnable() {
                public void run() {
                    if (SingleFragmentEx.this.f7372m != null) {
                        SingleFragmentEx.this.f7372m.setTopPadding(SingleFragmentEx.this.f7371l.getHeight());
                    }
                    SingleFragmentEx.this.m4613g();
                }
            });
        }
    }

    public int getCurrentDataAddressType() {
        return getmParam().addressParam.addressType;
    }

    /* renamed from: c */
    private void m4604c() {
        this.f7372m.onSingle(getmParam().addressParam);
        this.f7372m.setOnSelectPoiFooterViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackMapSelect(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.getmParam().addressParam.addressType, false);
                if (SingleFragmentEx.this.getmResult().getResult(SingleFragmentEx.this.getmParam().addressParam.addressType) != null) {
                    SingleFragmentEx.this.getmResult().getResult(SingleFragmentEx.this.getmParam().addressParam.addressType).operationType = !SingleFragmentEx.this.f7384y ? 2 : 3;
                }
                Bundle bundle = new Bundle();
                bundle.putBoolean(FragmentImpl.KEY_MAPSELECT_PIN_TYPE, true);
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchMapSelect(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult(), SingleFragmentEx.this.getmParam().addressParam.addressType, bundle);
            }
        });
        this.f7372m.getListView().setOnScrollListener(new AbsListView.OnScrollListener() {
            public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            }

            public void onScrollStateChanged(AbsListView absListView, int i) {
                if (i == 0) {
                    ViewUtils.hideInputWindow(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7372m.getListView());
                    if (SingleFragmentEx.this.f7368i != absListView.getFirstVisiblePosition()) {
                        int currentDataAddressType = SingleFragmentEx.this.getCurrentDataAddressType();
                        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(SingleFragmentEx.this.getmParam().fromType);
                        AddressTrack.trackScrollCK(currentDataAddressType, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(SingleFragmentEx.this.getmParam().fromType, SingleFragmentEx.this.getCurrentDataAddressType()), SingleFragmentEx.this.f7371l.getCommonEditText().getText().toString(), SingleFragmentEx.this.f7355A, SingleFragmentEx.this.f7368i, absListView.getFirstVisiblePosition(), SingleFragmentEx.this.f7384y);
                    }
                }
                if (i == 1 || i == 2) {
                    SingleFragmentEx.this.f7368i = absListView.getFirstVisiblePosition();
                }
            }
        });
    }

    /* renamed from: d */
    private void m4606d() {
        this.f7356B.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        this.f7357C.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SingleFragmentEx.this.f7371l != null) {
                    ViewUtils.hideInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                }
            }
        });
        this.f7358D.setEmptyClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SingleFragmentEx.this.f7371l != null) {
                    ViewUtils.hideInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                }
            }
        });
        this.f7357C.setSelectAddressListener(new EmptyView.OnSelectAddressListener() {
            public void onSelect(Object obj) {
            }
        });
        if (this.f7358D.getRetryBtn() != null) {
            this.f7358D.getRetryBtn().setOnClickListener(new View.OnClickListener() {
                public void onClick(final View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleFragmentEx.this.f7358D.setVisibility(8);
                    view.setClickable(false);
                    if (SingleFragmentEx.this.f7371l != null) {
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.m4599b(singleFragmentEx.getmParam().addressParam.addressType, SingleFragmentEx.this.f7371l.getCommonEditText().getText().toString(), false);
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
    private void m4600b(View view) {
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.isInSelectDestination = false;
                AddressTrack.isInSelectStart = false;
                if (!(SingleFragmentEx.this.getmParam().addressParam.addressType == 3 && SingleFragmentEx.this.getmParam().addressParam.addressType == 4)) {
                    AddressTrack.trackCloseButtonClick(SingleFragmentEx.this.getmParam(), SingleFragmentEx.this.m4611f());
                }
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onCancel(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
            }
        });
    }

    /* renamed from: e */
    private void m4609e() {
        ImageView imageView;
        if (getmParam().fromType == FromType.SETTING) {
            this.f7362c.setVisibility(0);
            this.f7374o.setVisibility(0);
            if (getmParam().addressParam.addressType == 4) {
                if (getmResult().getResult(4) != null) {
                    this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editwork));
                } else {
                    this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addwork));
                }
            } else if (getmParam().addressParam.addressType == 3) {
                if (getmResult().getResult(3) != null) {
                    this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editHome));
                } else {
                    this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addHome));
                }
            }
            if (getmResult().getResult(getmParam().addressParam.addressType) == null && (imageView = this.f7373n) != null) {
                imageView.setVisibility(8);
            }
            if (getmResult().getCommonAddress() != null) {
                if (getmParam().addressParam.addressType == 5) {
                    this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_editfavorite));
                    ImageView imageView2 = this.f7373n;
                    if (imageView2 != null) {
                        imageView2.setVisibility(0);
                    }
                }
            } else if (getmParam().addressParam.addressType == 5) {
                this.f7374o.setText(getString(R.string.GRider_Sug_2020_sidebar_title_addfavorite));
            }
            ImageView imageView3 = this.f7373n;
            if (imageView3 != null) {
                imageView3.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (SingleFragmentEx.this.f7371l != null) {
                            ViewUtils.hideInputWindow(SingleFragmentEx.this.getActivity(), SingleFragmentEx.this.f7371l.getCommonEditText());
                        }
                        SingleFragmentEx.this.m4618j();
                    }
                });
            }
            this.f7367h.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    RpcCommonPoi commonAddress;
                    AutoTrackHelper.trackViewOnClick(view);
                    if (SingleFragmentEx.this.f7367h.isReseted()) {
                        SingleFragmentEx.this.f7367h.playAnim();
                    }
                    AddressParam clone = SingleFragmentEx.this.getmParam().addressParam.clone();
                    if (SingleFragmentEx.this.getmParam().addressParam.addressType == 4) {
                        clone.addressType = 4;
                        SingleFragmentEx.this.getmResult().eraseAllAddress();
                        SingleFragmentEx.this.delSwitcherResultAddress(4);
                        SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                        singleFragmentEx.onConfirm(singleFragmentEx.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                        singleFragmentEx2.switchBack(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                    } else if (SingleFragmentEx.this.getmParam().addressParam.addressType == 3) {
                        clone.addressType = 3;
                        SingleFragmentEx.this.delSwitcherResultAddress(3);
                        SingleFragmentEx.this.getmResult().eraseAllAddress();
                        SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                        singleFragmentEx3.onConfirm(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult());
                        SingleFragmentEx singleFragmentEx4 = SingleFragmentEx.this;
                        singleFragmentEx4.switchBack(singleFragmentEx4.getmParam(), SingleFragmentEx.this.getmResult());
                    } else if (SingleFragmentEx.this.getmParam().addressParam.addressType == 5 && (commonAddress = SingleFragmentEx.this.getmResult().getCommonAddress()) != null && !TextUtils.isEmpty(commonAddress.primaryId)) {
                        clone.addressType = 5;
                        SingleFragmentEx.this.f7376q.deletFavoritePlace(clone, commonAddress.primaryId);
                        AddressTrack.trackFavoriteDeleteClick();
                    }
                }
            });
            this.f7366g.setOnClickListener(new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    SingleFragmentEx.this.m4620k();
                }
            });
            this.f7363d.setOnTouchListener(new View.OnTouchListener() {
                public boolean onTouch(View view, MotionEvent motionEvent) {
                    return true;
                }
            });
        }
    }

    public String getStartAddressText() {
        SugSearchView sugSearchView = this.f7371l;
        return sugSearchView != null ? sugSearchView.getStartEditText().getText().toString().trim() : "";
    }

    public void showWaittingList() {
        int i = 1;
        if (this.f7371l != null) {
            i = ((DisplayUtils.getWindowHeight(getActivity()) - this.f7371l.getHeight()) / DisplayUtils.dp2px(getActivity(), 66.0f)) - 1;
        }
        WaittingAdapter waittingAdapter = new WaittingAdapter(i);
        SugListViewContainer sugListViewContainer = this.f7372m;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7372m.getListView().setAdapter(waittingAdapter);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4588a(int i, final String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 544);
            SugParams clone = getmParam().clone();
            clone.addressParam.addressType = i;
            SugSearchView sugSearchView = this.f7371l;
            if (sugSearchView != null) {
                sugSearchView.post(new Runnable() {
                    public void run() {
                        if (SingleFragmentEx.this.f7358D.getVisibility() != 0) {
                            if (TextUtil.isEmpty(str) || SingleFragmentEx.this.getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                                SingleFragmentEx.this.showWaittingList();
                            }
                        }
                    }
                });
            }
            if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f7384y = false;
                this.f7375p.processDataRequire(clone, "", z, i);
                return;
            }
            this.f7384y = true;
            this.f7375p.processDataRequire(clone, str, z, i);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4599b(int i, String str, boolean z) {
        if (!isSugFragmentRemoved()) {
            SystemUtils.log(5, TAG, "reloadData() addressType: " + i + " queryKey: " + str + " isManSearch: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 579);
            SugParams clone = getmParam().clone();
            if (getmParam().fromType == FromType.HOME && AddressPresenter.getLastAddressType() == 2 && AddressPresenter.isLastCachedRecommendCache(2)) {
                AddressParam addressParam = clone.addressParam;
                SugListViewContainer sugListViewContainer = this.f7372m;
                AddressTrack.trackEndRecVisibleListItemCount(addressParam, sugListViewContainer != null ? sugListViewContainer.getVisibleCount() : 0);
            }
            clone.addressParam.addressType = i;
            SugSearchView sugSearchView = this.f7371l;
            if (sugSearchView != null) {
                sugSearchView.post(new Runnable() {
                    public void run() {
                        if (!SingleFragmentEx.this.f7381v) {
                            SingleFragmentEx.this.f7372m.getListView().setAdapter(new WaittingAdapter(((DisplayUtils.getWindowHeight(SingleFragmentEx.this.getActivity()) - SingleFragmentEx.this.f7371l.getHeight()) / DisplayUtils.dp2px(SingleFragmentEx.this.getActivity(), 66.0f)) - 1));
                        }
                    }
                });
            }
            if (TextUtil.isEmpty(str) || getContext().getResources().getString(R.string.global_sug_current_location).equals(str)) {
                this.f7384y = false;
                this.f7375p.processDataRequire(clone, "", z, i);
                return;
            }
            this.f7384y = true;
            this.f7375p.getSuggestPoiList(clone, str, z, i, true);
        }
    }

    public void onDestroyView() {
        dismissProgressDialog();
        AddressTrack.onDestroyView();
        super.onDestroyView();
        this.f7381v = true;
        View currentFocus = getActivity().getCurrentFocus();
        if (currentFocus != null) {
            currentFocus.clearFocus();
            ViewUtils.hideInputWindow(getActivity(), currentFocus);
        }
        SugListViewContainer sugListViewContainer = this.f7372m;
        if (sugListViewContainer != null) {
            sugListViewContainer.onDestory();
        }
    }

    public void onDestroy() {
        super.onDestroy();
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
        AddressTrack.onViewCreated(getmParam(), this.f7371l, this.f7372m);
        if (!TextUtils.isEmpty("")) {
            showCommonAddressView(false);
        }
        if (m4625m()) {
            m4588a(2, "", false);
        } else {
            m4588a(getmParam().addressParam.addressType, "", false);
        }
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f7372m.showSelectPoiFooterView(true);
        } else {
            this.f7372m.showSelectPoiFooterView(false);
        }
    }

    public void onResume() {
        this.f7385z = true;
        super.onResume();
        AddressPresenter addressPresenter = this.f7375p;
        if (addressPresenter != null) {
            addressPresenter.onResume();
        }
        SugSearchView sugSearchView = this.f7371l;
        if (sugSearchView != null) {
            sugSearchView.onResume();
        }
    }

    public void onPause() {
        super.onPause();
        this.f7385z = false;
        if (getView() != null) {
            ViewUtils.hideInputWindow(getActivity(), getView());
            getView().clearFocus();
        }
    }

    public void onStop() {
        super.onStop();
        AddressPresenter addressPresenter = this.f7375p;
        if (addressPresenter != null) {
            addressPresenter.onStop();
        }
        SugSearchView sugSearchView = this.f7371l;
        if (sugSearchView != null) {
            sugSearchView.dismissPopupTips();
        }
    }

    public void onDetach() {
        super.onDetach();
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
        this.f7382w = false;
        m4620k();
        this.f7367h.reset();
        onConfirm(getmParam(), getmResult());
        switchBack(getmParam(), getmResult());
    }

    public void showToastError(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getActivity(), str);
        }
        this.f7382w = false;
    }

    public void showToastError(String str, boolean z) {
        if (!isDetached()) {
            ToastHelper.showFail(getActivity(), str);
            m4620k();
            this.f7367h.reset();
        }
    }

    public void showContentView() {
        this.f7357C.setVisibility(8);
        this.f7358D.setVisibility(8);
        this.f7372m.findViewById(R.id.lv).setVisibility(0);
    }

    public void updateContentView(AddressParam addressParam, final RpcRecSug.TrackParameterForChild trackParameterForChild, final ArrayList<RpcPoi> arrayList, final int i) {
        SugListViewContainer sugListViewContainer = this.f7372m;
        if (sugListViewContainer != null && sugListViewContainer.getListView() != null) {
            this.f7355A = trackParameterForChild;
            this.f7372m.post(new Runnable() {
                public void run() {
                    AddressAdapter addressAdapter = new AddressAdapter();
                    addressAdapter.setOnItemSelectedListener(SingleFragmentEx.this.f7359E);
                    addressAdapter.updateAddress(arrayList, SingleFragmentEx.this.getmParam().clone(), trackParameterForChild, SingleFragmentEx.this.getmParam().addressParam.addressType, i);
                    SugListViewContainer a = SingleFragmentEx.this.f7372m;
                    ArrayList arrayList = arrayList;
                    a.onAddressOcupy(arrayList == null ? true : arrayList.isEmpty(), false);
                    SingleFragmentEx.this.f7372m.getListView().setAdapter(addressAdapter);
                }
            });
            hideLoading();
        }
    }

    public void showCommonAddressView(boolean z) {
        if (getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) {
            z = false;
        }
        this.f7372m.showCommonAddressHeaderView(z);
    }

    public void updateHomeAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7372m.setHomeAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void updateCompanyAddress(RpcCommonPoi rpcCommonPoi) {
        this.f7372m.setCompanyAddress(ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(rpcCommonPoi)));
    }

    public void showErrorView(String str) {
        hideLoading();
        this.f7372m.onlyShowSelectPoiFooterView();
        this.f7357C.setVisibility(8);
        this.f7358D.setVisibility(0);
        showCommonAddressView(false);
        this.f7358D.showError(str);
    }

    public void showNoSearchView() {
        hideLoading();
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f7372m.onlyShowSelectPoiFooterView();
        } else {
            this.f7372m.showSelectPoiFooterView(false);
        }
        this.f7358D.setVisibility(8);
        this.f7357C.setVisibility(0);
        this.f7357C.showError(getContext().getResources().getText(R.string.GRider_Sug_2020_noResult));
        this.f7357C.findViewById(R.id.image_error).setVisibility(0);
    }

    public void showProgressView() {
        NetErrorView netErrorView = this.f7358D;
        if (netErrorView != null) {
            netErrorView.setVisibility(8);
        }
        EmptyView emptyView = this.f7357C;
        if (emptyView != null) {
            emptyView.setVisibility(8);
        }
        showLoading();
    }

    public void setResultBack(int i, Address address) {
        if ((getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) && getSugCallback().getSugBuild() != null && getSugCallback().getSugBuild().getVersion() == 1) {
            SugParams clone = getmParam().clone();
            IAddressResult clone2 = getmResult().clone();
            clone2.setResult(clone.addressParam.addressType, address);
            onConfirm(getmParam(), getmResult());
            switchMapSelect(clone, clone2, clone.addressParam.addressType);
            this.f7383x = clone.addressParam.addressType;
            return;
        }
        setResultBackOnSingle(getmParam().addressParam.addressType, address, AddressConverter.address2Rpc(address));
    }

    public void setResultBackOnSingle(int i, Address address, RpcPoi rpcPoi) {
        if (address != null) {
            AddressTrack.trackUserOperator(i, address.operationType);
            SystemUtils.log(3, "ccc", "setResultBack : type=" + i + ",address = " + address.toString(), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 1020);
            getmResult().getAddressResult().fromType = getmParam().fromType;
            getmResult().getAddressResult().type = i;
            getmResult().getAddressResult().isStartNeedNearRoad = false;
            if (m4595a(i, address, rpcPoi)) {
                switchBack(getmParam(), getmResult());
                return;
            }
            return;
        }
        throw new RuntimeException("setResultBack with null address, type:" + i);
    }

    public void toLogin() {
        if (!isSugFragmentRemoved() && getmParam() != null && getmParam().managerCallback != null && getmParam().addressParam != null && getmParam().addressParam.currentAddress != null) {
            getmParam().managerCallback.toLogin(getActivity(), getmParam().addressParam.currentAddress.latitude, getmParam().addressParam.currentAddress.longitude, getActivity().getPackageName());
        }
    }

    public void updateTipsInfoHeaderView(RpcRecSug.TipsInfo tipsInfo) {
        this.f7372m.updateTipsInfoHeaderView(tipsInfo);
    }

    public void updateMapConfirmHeaderView(RpcRecSug.TipsInfo tipsInfo, int i) {
        this.f7372m.updateMapConfirmHeaderView(tipsInfo, i);
    }

    public void updateSelectPoiFooters(boolean z) {
        if (getmParam().fromType != FromType.MAP_POINT_SELECT) {
            this.f7372m.showSelectPoiFooterView(true);
        } else {
            this.f7372m.showSelectPoiFooterView(false);
        }
    }

    public void updateLogoFooters(boolean z, String str, int i, int i2) {
        this.f7372m.updateLogoView(z, str, i, i2);
    }

    public boolean isSugFragmentRemoved() {
        return getActivity() == null || isRemoving() || !isAdded();
    }

    public void focusChanged(int i, boolean z) {
        if (this.f7371l != null && !this.f7379t && !this.f7381v && getActivity() != null) {
            SystemUtils.log(3, "ccc", "focusChanged() type: " + i + ", hasFocus: " + z, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.single.SingleFragmentEx", 1097);
        }
    }

    /* renamed from: a */
    private String m4585a(int i) {
        if (i == 1) {
            return getStartAddressText();
        }
        if (i == 2) {
            return this.f7371l.getEndEditText().getText().toString().trim();
        }
        return (this.f7371l.getCommonEditText() == null || TextUtils.isEmpty(this.f7371l.getCommonEditText().getText())) ? "" : this.f7371l.getCommonEditText().getText().toString().trim();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public String m4611f() {
        return AddressTrack.getCurrPage(getmParam().addressParam.addressType, this.f7371l, this.f7372m);
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public void m4613g() {
        SugSearchView sugSearchView;
        if (!this.f7381v && (sugSearchView = this.f7371l) != null) {
            sugSearchView.getCommonEditText().requestFocus();
        }
    }

    public void onClick(int i) {
        if (this.f7371l == null || isSugFragmentRemoved()) {
        }
    }

    public void afterTextChanged(View view, int i, Editable editable) {
        if (view != null && editable != null && this.f7371l != null && view.hasFocus()) {
            m4587a(i, editable.toString().trim());
        }
    }

    /* renamed from: a */
    private void m4587a(int i, String str) {
        removePendingSugLoadingRequest();
        Message obtain = Message.obtain();
        obtain.obj = str;
        obtain.arg1 = i;
        obtain.what = 12;
        this.f7377r.sendMessageDelayed(obtain, (long) ApolloUtil.SUG_SEARCH_INTERVAL);
    }

    public boolean removePendingSugLoadingRequest() {
        Handler handler = this.f7377r;
        if (handler == null) {
            return false;
        }
        handler.removeMessages(12);
        return true;
    }

    public boolean isIntendSugRequest(AddressParam addressParam) {
        return m4596a(addressParam);
    }

    public void setStartPoiInfo(AddressParam addressParam) {
        SugSearchView sugSearchView = this.f7371l;
        if (sugSearchView != null) {
            sugSearchView.setStartText(addressParam);
        }
    }

    /* renamed from: a */
    private boolean m4596a(AddressParam addressParam) {
        SugSearchView sugSearchView;
        if (addressParam == null || (sugSearchView = this.f7371l) == null) {
            return false;
        }
        return sugSearchView.getCommonEditText().hasFocus();
    }

    public void onClearClick(int i, String str) {
        boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
        AddressTrack.trackSugClear(i, isFromRouteEditor ? 1 : 0, CommonUtils.getPageLevel(getmParam().fromType, i), str);
    }

    /* renamed from: a */
    private boolean m4595a(int i, Address address, RpcPoi rpcPoi) {
        if (address == null) {
            return false;
        }
        if (getmParam().fromType != FromType.SETTING) {
            if (i == 4) {
                getmResult().setCompany(address);
            } else if (i == 3) {
                getmResult().setHome(address);
            } else if (i == 5) {
                getmParam().addressParam.targetAddress = address;
                getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
                onConfirm(getmParam(), getmResult());
                switchEditFavorite(getmParam(), getmResult());
                return false;
            } else if (i != 101 && i != 102) {
                return false;
            } else {
                getmResult().setCommon(address);
            }
            onConfirm(getmParam(), getmResult());
        } else if (i == 4) {
            getmResult().eraseAllAddress();
            getmResult().setResult(i, address);
            onConfirm(getmParam(), getmResult());
            return true;
        } else if (i == 3) {
            getmResult().eraseAllAddress();
            getmResult().setResult(i, address);
            onConfirm(getmParam(), getmResult());
            return true;
        } else if (i == 5) {
            getmParam().addressParam.targetAddress = address;
            getmResult().setCommonAddress(AddressConvertUtil.addressToRpcCommonPoi(address, getmResult().getCommonAddress()));
            onConfirm(getmParam(), getmResult());
            switchEditFavorite(getmParam(), getmResult());
            return false;
        }
        return true;
    }

    public void onPageEnter() {
        super.onPageEnter();
        SugSearchView sugSearchView = this.f7371l;
        if (sugSearchView != null) {
            sugSearchView.postDelayed(new Runnable() {
                public void run() {
                    ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                }
            }, 500);
            if (isFirstEnter() || !this.f7385z) {
                this.f7371l.getCommonEditText().setFocusable(true);
                this.f7371l.getCommonEditText().setFocusableInTouchMode(true);
                setParentNodeType(IFragment.ParentNode.CHILD);
                int i = getmParam().addressParam.addressType;
                this.f7371l.removeCommonWatcher(getmParam().addressParam);
                if (getmParam().fromType == FromType.SETTING && getmResult().getLastPageType() == FragmentFactory.FragmentType.SETTING) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_two, i);
                    if (i == 4) {
                        if (getmResult().getAddressResult().company != null) {
                            m4617i();
                        }
                    } else if (i == 3) {
                        if (getmResult().getAddressResult().home != null) {
                            m4617i();
                        }
                    } else if (i == 5 && getmResult().getCommonAddress() != null) {
                        getmResult().setResultAllowNull(5, AddressConverter.commonRpc2Address(getmResult().getCommonAddress()));
                        m4617i();
                    }
                    this.f7378s = getmResult().getResult(getmParam().addressParam.addressType);
                } else if (!m4625m()) {
                    AddressTrack.trackSugPageSW(0, AddressTrack.page_level_two, i);
                    if (i == 4) {
                        m4592a(getmResult().getAddressResult().company);
                    } else if (i == 3) {
                        m4592a(getmResult().getAddressResult().home);
                    } else if (i == 5) {
                        if (getmResult().getLastPageType() == FragmentFactory.FragmentType.FAVORITE) {
                            m4593a(getmResult().getCommonAddress());
                            getmResult().setResultAllowNull(5, AddressConverter.commonRpc2Address(getmResult().getCommonAddress()));
                        } else {
                            m4592a(getmResult().getAddressResult().common);
                        }
                    } else if (i == 6) {
                        m4592a(getmResult().getAddressResult().common);
                    }
                    if (!isFirstEnter()) {
                        getmResult().setResultAllowNull(i, this.f7378s);
                        updataSwitcherResultAddressAllowNull(i, this.f7378s);
                    }
                } else if (getmResult().getLastOperType() == AddressResultEnhancer.OperType.Cancel) {
                    this.f7383x = -1;
                    this.f7371l.addCommonTextWatcher(getmParam().addressParam);
                    this.f7371l.postDelayed(new Runnable() {
                        public void run() {
                            ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                        }
                    }, 500);
                    return;
                } else {
                    m4592a(getmResult().getAddressResult().common);
                    getmResult().getMapSelectOperType();
                    AddressResultEnhancer.MapSelectOper mapSelectOper = AddressResultEnhancer.MapSelectOper.Edit;
                    AddressTrack.trackSugPageSW(1, AddressTrack.page_level_two, i);
                    int i2 = this.f7383x;
                    if (i2 == 3) {
                        if (this.f7372m != null && getmResult().getAddressResult().home != null) {
                            this.f7372m.setHomeAddress(getmResult().getAddressResult().home);
                            AddressParam clone = getmParam().addressParam.clone();
                            clone.addressType = 3;
                            this.f7360a.setHomeCompany(clone, AddressConverter.address2Rpc(getmResult().getAddressResult().home), this.f7361b);
                        } else if (getmResult().getAddressResult().home == null) {
                            this.f7361b.onHomeUploadFailed();
                        }
                        this.f7383x = -1;
                        this.f7371l.addCommonTextWatcher(getmParam().addressParam);
                        this.f7371l.postDelayed(new Runnable() {
                            public void run() {
                                ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                            }
                        }, 500);
                        return;
                    } else if (i2 == 4) {
                        if (this.f7372m != null && getmResult().getAddressResult().company != null) {
                            this.f7372m.setCompanyAddress(getmResult().getAddressResult().company);
                            AddressParam clone2 = getmParam().addressParam.clone();
                            clone2.addressType = 4;
                            this.f7360a.setHomeCompany(clone2, AddressConverter.address2Rpc(getmResult().getAddressResult().company), this.f7361b);
                        } else if (getmResult().getAddressResult().company == null) {
                            this.f7361b.onCompanyUploadFailed();
                        }
                        this.f7383x = -1;
                        this.f7371l.addCommonTextWatcher(getmParam().addressParam);
                        this.f7371l.postDelayed(new Runnable() {
                            public void run() {
                                ViewUtils.showInputMethodForEditText(SingleFragmentEx.this.getContext(), SingleFragmentEx.this.f7371l.getCommonEditText());
                            }
                        }, 500);
                        return;
                    } else if (!isFirstEnter()) {
                        getmResult().setResultAllowNull(getmParam().addressParam.addressType, this.f7378s);
                        updataSwitcherResultAddressAllowNull(getmParam().addressParam.addressType, this.f7378s);
                    }
                }
                this.f7371l.removeCommonWatcher(getmParam().addressParam);
                if (getmResult().getMapSelectOperType() != AddressResultEnhancer.MapSelectOper.Edit) {
                    if (i == 5) {
                        if (getmResult().getCommonAddress() != null) {
                            this.f7371l.getCommonEditText().setText(getmResult().getCommonAddress().displayName);
                            this.f7371l.getCommonEditText().selectAll();
                            this.f7371l.getCommonEditText().setClearIconVisible(true);
                        }
                    } else if (getmResult().getResult(getmParam().addressParam.addressType) != null) {
                        this.f7371l.getCommonEditText().setText(getmResult().getResult(getmParam().addressParam.addressType).displayName);
                        this.f7371l.getCommonEditText().selectAll();
                        this.f7371l.getCommonEditText().setClearIconVisible(true);
                    }
                }
                boolean isFromRouteEditor = CommonUtils.isFromRouteEditor(getmParam().fromType);
                AddressTrack.trackSugInputFocus(i, isFromRouteEditor ? 1 : 0, 2, m4585a(i));
                this.f7371l.addCommonTextWatcher(getmParam().addressParam);
                getmResult().setMapSelectOperType(AddressResultEnhancer.MapSelectOper.Other);
                if (!TextUtils.isEmpty(this.f7371l.getCommonEditText().getText())) {
                    this.f7371l.getCommonEditText().setClearIconVisible(true);
                }
                this.f7383x = -1;
            }
        }
    }

    public void onPageExit() {
        super.onPageExit();
        this.f7385z = false;
        SugSearchView sugSearchView = this.f7371l;
        if (sugSearchView != null) {
            sugSearchView.hideShadow();
            if (getActivity() != null && isFragmentOnDuty()) {
                ViewUtils.hideInputMethodForEditText(getContext(), this.f7371l.getCommonEditText());
            }
            this.f7371l.getCommonEditText().setFocusable(false);
            this.f7371l.getCommonEditText().setFocusableInTouchMode(false);
        }
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return this.f7369j;
    }

    /* renamed from: i */
    private void m4617i() {
        ImageView imageView = this.f7373n;
        if (imageView != null) {
            imageView.setVisibility(0);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: j */
    public void m4618j() {
        this.f7364e.setVisibility(0);
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_enter);
        this.f7364e.startAnimation(loadAnimation);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                SingleFragmentEx.this.f7363d.setVisibility(0);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: k */
    public void m4620k() {
        Animation loadAnimation = AnimationUtils.loadAnimation(getActivity(), R.anim.pop_exit);
        this.f7364e.startAnimation(loadAnimation);
        this.f7364e.setVisibility(4);
        loadAnimation.setAnimationListener(new Animation.AnimationListener() {
            public void onAnimationEnd(Animation animation) {
            }

            public void onAnimationRepeat(Animation animation) {
            }

            public void onAnimationStart(Animation animation) {
                SingleFragmentEx.this.f7363d.setVisibility(8);
            }
        });
    }

    class CommonAddressReactor implements IHomeCompanyUploadRequestReactor {
        CommonAddressReactor() {
        }

        public void onHomeUploadSuccess() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m4594a(singleFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public void onHomeUploadFailed() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m4603b(singleFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadFailed() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m4603b(singleFragmentEx.getString(R.string.global_sug_load_fail));
        }

        public void onCompanyUploadSuccess() {
            SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
            singleFragmentEx.m4594a(singleFragmentEx.getString(R.string.GRider_Sug_2020_common_addSuc));
        }

        public boolean isReactorOnDuty() {
            return !SingleFragmentEx.this.isSugFragmentRemoved();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m4594a(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showSuccessful(getContext(), str);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m4603b(String str) {
        if (isFragmentOnDuty()) {
            ToastHelper.showFail(getContext(), str);
        }
    }

    /* renamed from: a */
    private void m4592a(Address address) {
        SugSearchView sugSearchView;
        if (address != null) {
            SugSearchView sugSearchView2 = this.f7371l;
            if (sugSearchView2 != null) {
                sugSearchView2.removeCommonWatcher(getmParam().addressParam);
                if (address != null) {
                    this.f7371l.getCommonEditText().setText(address.displayName);
                    int i = getmParam().addressParam.addressType;
                    if (m4625m()) {
                        i = 2;
                    }
                    if (!isFirstEnter()) {
                        m4588a(i, "", false);
                    }
                }
                this.f7371l.getCommonEditText().requestFocus();
                this.f7371l.getCommonEditText().selectAll();
                this.f7371l.addCommonTextWatcher(getmParam().addressParam);
            }
        } else if (address == null && (sugSearchView = this.f7371l) != null) {
            sugSearchView.post(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(SingleFragmentEx.this.f7371l.getCommonEditText().getText()) && SingleFragmentEx.this.f7371l != null) {
                        SingleFragmentEx.this.f7371l.getCommonEditText().requestFocus();
                    }
                }
            });
        }
    }

    /* renamed from: a */
    private void m4593a(RpcCommonPoi rpcCommonPoi) {
        SugSearchView sugSearchView;
        if (rpcCommonPoi != null) {
            SugSearchView sugSearchView2 = this.f7371l;
            if (sugSearchView2 != null) {
                sugSearchView2.removeCommonWatcher(getmParam().addressParam);
                if (rpcCommonPoi != null) {
                    this.f7371l.getCommonEditText().setText(rpcCommonPoi.displayName);
                    int i = getmParam().addressParam.addressType;
                    if (m4625m()) {
                        i = 2;
                    }
                    m4588a(i, "", false);
                }
                this.f7371l.getCommonEditText().requestFocus();
                this.f7371l.getCommonEditText().selectAll();
                this.f7371l.addCommonTextWatcher(getmParam().addressParam);
            }
        } else if (rpcCommonPoi == null && (sugSearchView = this.f7371l) != null) {
            sugSearchView.post(new Runnable() {
                public void run() {
                    if (!TextUtils.isEmpty(SingleFragmentEx.this.f7371l.getCommonEditText().getText()) && SingleFragmentEx.this.f7371l != null) {
                        SingleFragmentEx.this.f7371l.getCommonEditText().requestFocus();
                    }
                }
            });
        }
    }

    /* renamed from: l */
    private void m4623l() {
        this.f7372m.setCommonAddressViewClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackHomeBtnClickDirectly(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.m4625m() ? 2 : 3, SingleFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                Address homeAddress = SingleFragmentEx.this.f7372m.getHomeAddress();
                if (CommonUtils.isValidLocation(homeAddress)) {
                    AddressTrack.trackHomeClick(SingleFragmentEx.this.getmParam(), homeAddress, SingleFragmentEx.this.getmParam().addressParam.addressType);
                    homeAddress.operationType = 4;
                    SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                    singleFragmentEx.setResultBackOnSingle(singleFragmentEx.getmParam().addressParam.addressType, homeAddress, AddressConverter.address2Rpc(homeAddress));
                    return;
                }
                SingleFragmentEx.this.setParentNodeType(IFragment.ParentNode.WAYPOINT_SELECTOR);
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.onConfirm(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                singleFragmentEx3.switchSingle(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult(), 3);
                int unused = SingleFragmentEx.this.f7383x = 3;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AddressTrack.trackWorkBtnClickDirectly(SingleFragmentEx.this.getmParam().addressParam, SingleFragmentEx.this.m4625m() ? 2 : 3, SingleFragmentEx.this.getmParam().fromType);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                Address companyAddress = SingleFragmentEx.this.f7372m.getCompanyAddress();
                if (CommonUtils.isValidLocation(companyAddress)) {
                    AddressTrack.trackCompanyClick(SingleFragmentEx.this.getmParam(), companyAddress, SingleFragmentEx.this.getmParam().addressParam.addressType);
                    companyAddress.operationType = 5;
                    SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                    singleFragmentEx.setResultBackOnSingle(singleFragmentEx.getmParam().addressParam.addressType, companyAddress, AddressConverter.address2Rpc(companyAddress));
                    return;
                }
                SingleFragmentEx.this.setParentNodeType(IFragment.ParentNode.WAYPOINT_SELECTOR);
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.onConfirm(singleFragmentEx2.getmParam(), SingleFragmentEx.this.getmResult());
                SingleFragmentEx singleFragmentEx3 = SingleFragmentEx.this;
                singleFragmentEx3.switchSingle(singleFragmentEx3.getmParam(), SingleFragmentEx.this.getmResult(), 4);
                int unused = SingleFragmentEx.this.f7383x = 4;
            }
        }, new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                    SingleFragmentEx.this.toLogin();
                    return;
                }
                AddressTrack.trackFavoritePlaceClick(CommonUtils.isValidLocation(SingleFragmentEx.this.f7372m.getHomeAddress()), CommonUtils.isValidLocation(SingleFragmentEx.this.f7372m.getCompanyAddress()), SingleFragmentEx.this.m4625m() ? 2 : 3);
                SugParams clone = SingleFragmentEx.this.getmParam().clone();
                clone.addressParam.addressType = SingleFragmentEx.this.getmParam().addressParam.addressType;
                SingleFragmentEx singleFragmentEx = SingleFragmentEx.this;
                singleFragmentEx.onConfirm(clone, singleFragmentEx.getmResult());
                SingleFragmentEx singleFragmentEx2 = SingleFragmentEx.this;
                singleFragmentEx2.switchFavorite(clone, singleFragmentEx2.getmResult());
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: m */
    public boolean m4625m() {
        return ((getmParam().fromType != FromType.ROUTE_EDITOR && getmParam().fromType != FromType.FROM_HOME_ROUTE_EDITOR && getmParam().fromType != FromType.FROM_CONFIRM_ROUTE_EDITOR) || getmParam().addressParam.addressType == 3 || getmParam().addressParam.addressType == 4 || getmParam().addressParam.addressType == 5) ? false : true;
    }

    public void setMenuVisibility(boolean z) {
        super.setMenuVisibility(z);
    }

    public void setUserVisibleHint(boolean z) {
        super.setUserVisibleHint(z);
    }

    public String getStringSafe(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }
}

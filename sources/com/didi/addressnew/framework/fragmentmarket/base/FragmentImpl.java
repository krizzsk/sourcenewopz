package com.didi.addressnew.framework.fragmentmarket.base;

import android.animation.Animator;
import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.Context;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import com.didi.address.AddressResult;
import com.didi.address.FromType;
import com.didi.address.GlobalSugCallback;
import com.didi.address.framework.fragmentmarket.animator.ISwitchAnimator;
import com.didi.address.model.SugParams;
import com.didi.address.model.WayPointParam;
import com.didi.addressnew.framework.ISugMainPageView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.IFragment;
import com.didi.addressnew.framework.switcher.IComponent;
import com.didi.addressnew.framework.switcher.ISwitcher;
import com.didi.addressnew.framework.switcher.result.AddressResultEnhancer;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.framework.switcher.scheduler.SwitcherImpl;
import com.didi.addressnew.util.AddressTrack;
import com.didi.addressnew.util.CheckParamUtil;
import com.didi.global.loading.app.AbsLoadingAppFragment;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.apm.SystemUtils;

public abstract class FragmentImpl extends AbsLoadingAppFragment implements IFragment {
    public static final String KEY_ADDRESS_TYPE = "KEY_TYPE";
    public static final String KEY_MAPSELECT_PIN_TYPE = "KEY_ENETER_MAPSELECT_BY_PIN";
    public static final String KEY_PARAM = "KEY_PARAM";
    public static final String Tag = "sugFragment";

    /* renamed from: a */
    private ISwitcher f4333a;

    /* renamed from: b */
    private GlobalSugCallback f4334b;

    /* renamed from: c */
    private SugParams f4335c;

    /* renamed from: d */
    private IAddressResult f4336d = new AddressResultEnhancer();

    /* renamed from: e */
    private boolean f4337e = false;

    /* renamed from: f */
    private boolean f4338f = false;

    /* renamed from: g */
    private boolean f4339g = true;

    /* renamed from: h */
    private boolean f4340h = false;

    /* renamed from: i */
    private IFragment.ParentNode f4341i = IFragment.ParentNode.CHILD;

    /* renamed from: j */
    private Context f4342j;

    /* renamed from: k */
    private boolean f4343k = false;
    protected ISugMainPageView mSugMainPage;

    public abstract boolean getDragHandlerEnable();

    public Fragment getFragment() {
        return this;
    }

    public void onActivityCloseBefore() {
    }

    public void onConfirmEnter(SugParams sugParams) {
    }

    public void onExit() {
    }

    public /* synthetic */ void onFragmentCancel(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher.CC.$default$onFragmentCancel(this, sugParams, iAddressResult);
    }

    public /* synthetic */ void onFragmentConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher.CC.$default$onFragmentConfirm(this, sugParams, iAddressResult);
    }

    public void onGetonEnter(SugParams sugParams) {
    }

    public void onHomeEnter(SugParams sugParams) {
    }

    public void onRegister(String str, IComponent iComponent) {
    }

    public void onSettingEnter(SugParams sugParams) {
    }

    public void onWaittingEnter(SugParams sugParams) {
    }

    public void startMainFragment(FragmentManager fragmentManager, int i) {
    }

    public void updateAddressToCurrentFragment(IFragment iFragment) {
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
        if (activity != null && (activity instanceof ISugMainPageView)) {
            this.mSugMainPage = (ISugMainPageView) activity;
        }
        this.f4342j = activity;
        if (getArguments() != null) {
            SugParams sugParams = (SugParams) getArguments().getSerializable(KEY_PARAM);
            this.f4335c = sugParams;
            if (sugParams != null) {
                Context applicationContext = activity.getApplicationContext();
                CheckParamUtil.rescueAddressParam(applicationContext, getClass().getSimpleName() + " onAttach", this.f4335c.addressParam);
            }
        }
        this.f4333a = SwitcherImpl.getInstance();
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onAttach:" + this.f4335c, (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 77);
        onCurrentFragmentAttached(this);
    }

    public void onCreate(Bundle bundle) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onCreate:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 83);
        super.onCreate(bundle);
        this.f4337e = true;
    }

    public void onDestroy() {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onDestroy:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 90);
        super.onDestroy();
        this.f4337e = false;
    }

    public void onResume() {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onResume:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 97);
        if (!isFragmentOnTop(this)) {
            super.onResume();
            return;
        }
        this.f4343k = true;
        super.onResume();
        if (this.f4333a == null) {
            this.f4333a = SwitcherImpl.getInstance();
        }
        if (!isFragmentOnTop(this)) {
            return;
        }
        if (getType() == FragmentFactory.FragmentType.FULL || getType() == FragmentFactory.FragmentType.SINGLE) {
            onPageEnter();
        } else if (this.f4339g) {
            onPageEnter();
        }
    }

    public void onPause() {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onPause:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 121);
        super.onPause();
        this.f4343k = false;
        this.f4339g = false;
    }

    /* access modifiers changed from: protected */
    public GlobalSugCallback getSugCallback() {
        if (this.f4334b == null) {
            this.f4334b = new GlobalSugCallback() {
                public void setResult(AddressResult addressResult) {
                    SystemUtils.log(6, "SugErr", "" + Log.getStackTraceString(new Throwable()), (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl$1", 132);
                }
            };
        }
        return this.f4334b;
    }

    public void setSugCallback(GlobalSugCallback globalSugCallback) {
        this.f4334b = globalSugCallback;
    }

    public Animator onCreateAnimator(int i, boolean z, int i2) {
        ISwitchAnimator switchAnimator;
        if (this.f4338f || (switchAnimator = getSwitchAnimator()) == null) {
            return null;
        }
        if (z) {
            if (getType() == FragmentFactory.FragmentType.SINGLE) {
                return switchAnimator.getSecondaryPageEnterAnimator();
            }
            if (getType() == FragmentFactory.FragmentType.FULL) {
                if (getmParam().fromType == FromType.ROUTE_EDITOR || getmParam().fromType == FromType.FROM_HOME_ROUTE_EDITOR || getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) {
                    return switchAnimator.getSecondaryPageEnterAnimator();
                }
                return null;
            } else if (getType() == FragmentFactory.FragmentType.WAYPOINT) {
                return switchAnimator.getSecondaryPageEnterAnimator();
            } else {
                return switchAnimator.getEnterAnimator();
            }
        } else if (getType() == FragmentFactory.FragmentType.SINGLE) {
            return switchAnimator.getSecondaryPageExitAnimator();
        } else {
            if (getType() == FragmentFactory.FragmentType.FULL) {
                if (getmParam().fromType == FromType.ROUTE_EDITOR || getmParam().fromType == FromType.FROM_HOME_ROUTE_EDITOR || getmParam().fromType == FromType.FROM_CONFIRM_ROUTE_EDITOR) {
                    return switchAnimator.getSecondaryPageExitAnimator();
                }
                return null;
            } else if (getType() == FragmentFactory.FragmentType.WAYPOINT) {
                return switchAnimator.getSecondaryPageExitAnimator();
            } else {
                return switchAnimator.getExitAnimator();
            }
        }
    }

    public void switchWayPointer(SugParams sugParams, IAddressResult iAddressResult) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchWayPointer:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 199);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchWayPointer(sugParams, iAddressResult);
        }
    }

    public void switchFull(SugParams sugParams, IAddressResult iAddressResult) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchFull:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 207);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchFull(sugParams, iAddressResult);
        }
    }

    public void switchSingle(SugParams sugParams, IAddressResult iAddressResult, int i) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchSingle:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 215);
        if (this.f4333a != null) {
            SugParams sugParams2 = null;
            if (sugParams != null) {
                sugParams2 = sugParams.clone();
                sugParams2.addressParam.addressType = i;
            }
            this.f4333a.switchSingle(sugParams2, iAddressResult, i);
        }
    }

    public void switchSetting(SugParams sugParams, IAddressResult iAddressResult) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchSetting:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 228);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchSetting(sugParams, iAddressResult);
        }
    }

    public void switchEndConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchEndConfirm:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 236);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchEndConfirm(sugParams, iAddressResult, i, bundle);
        }
    }

    public void switchFavorite(SugParams sugParams, IAddressResult iAddressResult) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchFavorite:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 244);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchFavorite(sugParams, iAddressResult);
        }
    }

    public void switchEditFavorite(SugParams sugParams, IAddressResult iAddressResult) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchEditFavorite:", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 252);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchEditFavorite(sugParams, iAddressResult);
        }
    }

    public void switchMapConfirm(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchMapConfirm", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 260);
        if (this.f4333a != null) {
            SugParams sugParams2 = null;
            if (sugParams != null) {
                sugParams2 = sugParams.clone();
                sugParams2.addressParam.addressType = i;
            }
            this.f4333a.switchMapConfirm(sugParams2, iAddressResult, i, bundle);
        }
    }

    public void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i, Bundle bundle) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchMapSelect1", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 273);
        if (this.f4333a != null) {
            SugParams sugParams2 = null;
            if (sugParams != null) {
                sugParams2 = sugParams.clone();
                sugParams2.addressParam.addressType = i;
            }
            this.f4333a.switchMapSelect(sugParams2, iAddressResult, i, bundle);
        }
    }

    public void switchMapSelect(SugParams sugParams, IAddressResult iAddressResult, int i) {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchMapSelect2", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 286);
        if (this.f4333a != null) {
            SugParams sugParams2 = null;
            if (sugParams != null) {
                sugParams2 = sugParams.clone();
                sugParams2.addressParam.addressType = i;
            }
            this.f4333a.switchMapSelect(sugParams2, iAddressResult, i);
        }
    }

    public void switchBack(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher iSwitcher;
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":switchBack", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 299);
        if (!this.f4340h && (iSwitcher = this.f4333a) != null) {
            iSwitcher.switchBack(sugParams, iAddressResult);
            this.f4340h = true;
        }
    }

    public boolean closeSessionImediately() {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher == null) {
            return false;
        }
        boolean closeSessionImediately = iSwitcher.closeSessionImediately();
        m2631a();
        return closeSessionImediately;
    }

    public boolean closeSessionWithResult(IAddressResult iAddressResult) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher == null) {
            return true;
        }
        boolean closeSessionWithResult = iSwitcher.closeSessionWithResult(iAddressResult);
        m2631a();
        return closeSessionWithResult;
    }

    /* renamed from: a */
    private void m2631a() {
        ISugMainPageView iSugMainPageView = this.mSugMainPage;
        if (iSugMainPageView != null) {
            iSugMainPageView.onCloseSugPage();
        }
    }

    public boolean setResultWithoutCloseSession(IAddressResult iAddressResult) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            return iSwitcher.setResultWithoutCloseSession(iAddressResult);
        }
        return true;
    }

    public ISwitchAnimator getSwitchAnimator() {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            return iSwitcher.getSwitchAnimator();
        }
        return null;
    }

    public boolean onBackPressed() {
        SystemUtils.log(4, Tag, getClass().getSimpleName() + ":onBackPressed", (Throwable) null, "com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl", 353);
        onCancel(getmParam(), getmResult());
        AddressTrack.isInSelectDestination = false;
        AddressTrack.isInSelectStart = false;
        Activity activity = getActivity();
        FragmentManager fragmentManager = activity != null ? activity.getFragmentManager() : null;
        if (fragmentManager == null || fragmentManager.getBackStackEntryCount() <= 1) {
            return false;
        }
        return true;
    }

    public void onStartChoosen(Address address) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.onStartChoosen(address);
        }
    }

    public View getView() {
        return super.getView();
    }

    public void onPageEnter() {
        if (getView() != null) {
            if (getType() != FragmentFactory.FragmentType.FULL) {
                getView().requestFocus();
            }
            getView().setImportantForAccessibility(0);
        }
        m2632b();
    }

    /* renamed from: b */
    private void m2632b() {
        ISugMainPageView iSugMainPageView = this.mSugMainPage;
        if (iSugMainPageView != null) {
            iSugMainPageView.setPageDragEnable(getDragHandlerEnable());
        }
    }

    public void onPageExit() {
        this.f4343k = false;
        this.f4339g = false;
        if (getView() != null) {
            getView().setImportantForAccessibility(4);
        }
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        this.f4336d.eraseAllAddress();
        resetOffset();
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.onFragmentCancel(sugParams, iAddressResult);
        }
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        updateAddressToSwitcher(this.f4335c, iAddressResult);
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.onFragmentConfirm(sugParams, iAddressResult);
        }
        computeOffset();
    }

    public WayPointParam getWaypointParam() {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            return iSwitcher.getWaypointParam();
        }
        return null;
    }

    public SugParams getmParam() {
        return this.f4335c;
    }

    public IAddressResult getmResult() {
        return this.f4336d;
    }

    public void updateAddressToSwitcher(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.updateAddressToSwitcher(sugParams, iAddressResult);
        }
    }

    public void onCurrentFragmentAttached(IFragment iFragment) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.onCurrentFragmentAttached(iFragment);
        }
    }

    public void updateAddressRetToFragment(SugParams sugParams, IAddressResult iAddressResult) {
        this.f4336d.updateAllAddressAllowNullable(iAddressResult);
    }

    public void disableAnimation(boolean z) {
        this.f4338f = z;
    }

    public void switchBack(SugParams sugParams, IAddressResult iAddressResult, int i) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchBack(sugParams, iAddressResult, i);
        }
    }

    public void setParentNodeType(IFragment.ParentNode parentNode) {
        this.f4341i = parentNode;
    }

    public IFragment.ParentNode getNodeType() {
        return this.f4341i;
    }

    public void computeOffset() {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.computeOffset();
        }
    }

    public void resetOffset() {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.resetOffset();
        }
    }

    public boolean isFirstEnter() {
        return this.f4339g;
    }

    public boolean isResumeCalled() {
        return this.f4343k;
    }

    public void delSwitcherResultAddress(int i) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.delSwitcherResultAddress(i);
        }
    }

    public Context getContext() {
        Context context = this.f4342j;
        return context != null ? context.getApplicationContext() : context;
    }

    public boolean isFragmentOnDuty() {
        return getActivity() != null && !isRemoving() && isAdded();
    }

    public void updataSwitcherResultAddressAllowNull(int i, Address address) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.updataSwitcherResultAddressAllowNull(i, address);
        }
    }

    public boolean isFragmentOnTop(IFragment iFragment) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            return iSwitcher.isFragmentOnTop(iFragment);
        }
        return false;
    }

    public boolean isCanFinishActivity() {
        return this.f4333a.isCanFinishActivity();
    }

    public void switchOpenRideWayPointer(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchOpenRideWayPointer(sugParams, iAddressResult);
        }
    }

    public void switchOpenRideConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        ISwitcher iSwitcher = this.f4333a;
        if (iSwitcher != null) {
            iSwitcher.switchOpenRideConfirm(sugParams, iAddressResult);
        }
    }
}

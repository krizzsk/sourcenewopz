package com.didi.soda.customer.biz.popdialog.natived;

import android.content.Context;
import android.text.TextUtils;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.app.nova.skeleton.repo.Action1;
import com.didi.app.nova.skeleton.repo.Event;
import com.didi.app.nova.skeleton.repo.Predicate;
import com.didi.app.nova.skeleton.repo.Subscription;
import com.didi.soda.customer.biz.scheme.SchemeHelper;
import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopUpParamsEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.util.LocationUtil;
import com.didi.soda.customer.repo.RepoFactory;
import com.didi.soda.home.manager.CustomerGuideManager;

public class PopDialogHelper {
    public static final int POSITION_BUSINESS = 6;
    public static final int POSITION_HOME = 1;
    public static final int POSITION_LOGIN = 3;
    public static final int POSITION_ORDER = 2;

    /* renamed from: a */
    private static final String f40488a = "PopDialogHelper";

    public static void triggerNAPopFetch(NAPopUpParamsEntity nAPopUpParamsEntity) {
        if (!TextUtils.isEmpty(LocationUtil.getPoiId())) {
            ((C13644b) RepoFactory.getRepo(C13644b.class)).mo102152a(nAPopUpParamsEntity);
            LogUtil.m29104i(f40488a, "triggerNAPopFetch = " + nAPopUpParamsEntity.position + ", orderID = " + nAPopUpParamsEntity.popUpExtEntity.orderId + ", business ID  = " + nAPopUpParamsEntity.popUpExtEntity.shopId);
        }
    }

    public static void fetchNAPopDialog(NAPopUpParamsEntity nAPopUpParamsEntity, CustomerRpcCallback<NAPopDialogEntity> customerRpcCallback) {
        ((C13643a) RepoFactory.getRepo(C13643a.class)).mo102150a(nAPopUpParamsEntity, customerRpcCallback);
        LogUtil.m29104i(f40488a, "fetchNAPopDialog = " + nAPopUpParamsEntity.position + ", orderID = " + nAPopUpParamsEntity.popUpExtEntity.orderId + ", business ID  = " + nAPopUpParamsEntity.popUpExtEntity.shopId);
    }

    public static Subscription subscribeNATriggerPopFetch(NAPopUpParamsEntity nAPopUpParamsEntity, ScopeContext scopeContext, Action1<NAPopUpParamsEntity> action1) {
        LogUtil.m29104i(f40488a, "subscribeNATriggerPopFetch = ");
        return ((C13644b) RepoFactory.getRepo(C13644b.class)).from().filter(new Predicate() {
            public final boolean test(Object obj) {
                return PopDialogHelper.m28718a(NAPopUpParamsEntity.this, (Event) obj);
            }
        }).subscribe(scopeContext, action1);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ boolean m28718a(NAPopUpParamsEntity nAPopUpParamsEntity, Event event) {
        boolean equals = nAPopUpParamsEntity.equals(event.newData);
        LogUtil.m29104i(f40488a, "subscribeNATriggerPopFetch test = " + equals);
        return equals;
    }

    public static PopDialogComponent creatComponent(ViewGroup viewGroup, NAPopDialogEntity nAPopDialogEntity) {
        return new PopDialogFactory().mo102135a(viewGroup, nAPopDialogEntity);
    }

    public static Subscription addComponent(ScopeContext scopeContext, Context context, ViewGroup viewGroup, NAPopUpParamsEntity nAPopUpParamsEntity, final PopDialogCallBack popDialogCallBack) {
        LogUtil.m29104i(f40488a, "addPopDailogComponent" + nAPopUpParamsEntity);
        if (nAPopUpParamsEntity == null) {
            return null;
        }
        final FrameLayout frameLayout = new FrameLayout(context);
        frameLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        viewGroup.addView(frameLayout);
        scopeContext.attach("pop_dialog_fragment", frameLayout);
        final long[] jArr = new long[1];
        final PopDialogOmageHelper popDialogOmageHelper = new PopDialogOmageHelper(scopeContext, (NAPopDialogEntity) null);
        return subscribeNATriggerPopFetch(nAPopUpParamsEntity, scopeContext, new Action1(jArr, popDialogOmageHelper, scopeContext, new CustomerRpcCallback<NAPopDialogEntity>() {
            public void onRpcSuccess(NAPopDialogEntity nAPopDialogEntity, long j) {
                StringBuilder sb = new StringBuilder();
                sb.append("fetch NA pop success = ");
                sb.append(nAPopDialogEntity != null ? Integer.valueOf(nAPopDialogEntity.popupType) : null);
                LogUtil.m29104i(PopDialogHelper.f40488a, sb.toString());
                if (nAPopDialogEntity == null || !nAPopDialogEntity.needPopup) {
                    CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
                } else if (PopupType.NO_TYPE_POP.getType() == nAPopDialogEntity.popupType && !TextUtils.isEmpty(nAPopDialogEntity.popupUrl)) {
                    SchemeHelper.dispatchMsg(nAPopDialogEntity.popupUrl);
                    CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
                } else if (nAPopDialogEntity.info != null && PopupType.getByValue(nAPopDialogEntity.popupType) != null) {
                    PopDialogOmageHelper.this.setEntity(nAPopDialogEntity);
                    PopDialogOmageHelper.this.mo102139a(EventConst.PopDialog.REDENVELOPE_FETCH, jArr[0], 1);
                    PopDialogComponent creatComponent = PopDialogHelper.creatComponent(frameLayout, nAPopDialogEntity);
                    CustomerGuideManager.Companion.getInstance().checkShouldHideGuideContainer();
                    popDialogCallBack.addPopDialogComponent(creatComponent);
                }
            }

            public void onRpcFailure(SFRpcException sFRpcException) {
                CustomerGuideManager.Companion.getInstance().syncAndTriggerCustomerGuideInfoShown();
                LogUtil.m29104i(PopDialogHelper.f40488a, "fetch NA pop fail = " + sFRpcException.getOriginalMessage());
                PopDialogOmageHelper.this.mo102139a(EventConst.PopDialog.REDENVELOPE_FETCH, jArr[0], 2);
            }
        }) {
            public final /* synthetic */ long[] f$0;
            public final /* synthetic */ PopDialogOmageHelper f$1;
            public final /* synthetic */ ScopeContext f$2;
            public final /* synthetic */ CustomerRpcCallback f$3;

            {
                this.f$0 = r1;
                this.f$1 = r2;
                this.f$2 = r3;
                this.f$3 = r4;
            }

            public final void call(Object obj) {
                PopDialogHelper.m28717a(this.f$0, this.f$1, this.f$2, this.f$3, (NAPopUpParamsEntity) obj);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public static /* synthetic */ void m28717a(long[] jArr, PopDialogOmageHelper popDialogOmageHelper, ScopeContext scopeContext, CustomerRpcCallback customerRpcCallback, NAPopUpParamsEntity nAPopUpParamsEntity) {
        String str;
        StringBuilder sb = new StringBuilder();
        sb.append("trigger NA pop success = ");
        if (nAPopUpParamsEntity != null) {
            str = "position==" + nAPopUpParamsEntity.position + ", orderID = " + nAPopUpParamsEntity.popUpExtEntity.orderId + ", business ID  = " + nAPopUpParamsEntity.popUpExtEntity.shopId;
        } else {
            str = null;
        }
        sb.append(str);
        LogUtil.m29104i(f40488a, sb.toString());
        if (nAPopUpParamsEntity != null) {
            jArr[0] = System.currentTimeMillis();
            popDialogOmageHelper.mo102139a(EventConst.PopDialog.REDENVELOPE_FETCH, jArr[0], 3);
            scopeContext.attach("duration_key", Long.valueOf(jArr[0]));
            fetchNAPopDialog(nAPopUpParamsEntity, customerRpcCallback);
            ((C13644b) RepoFactory.getRepo(C13644b.class)).setValue(null);
        }
    }

    public static void setPopDialogVisible(ScopeContext scopeContext, int i) {
        FrameLayout frameLayout = (FrameLayout) scopeContext.getObject("pop_dialog_fragment");
        if (frameLayout != null) {
            frameLayout.setVisibility(i);
        }
    }
}

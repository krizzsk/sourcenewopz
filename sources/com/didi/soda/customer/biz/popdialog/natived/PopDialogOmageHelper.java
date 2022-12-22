package com.didi.soda.customer.biz.popdialog.natived;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.ScopeContext;
import com.didi.soda.customer.foundation.rpc.entity.CouponEntity;
import com.didi.soda.customer.foundation.rpc.entity.NAPopDialogEntity;
import com.didi.soda.customer.foundation.tracker.OmegaTracker;
import com.didi.soda.customer.foundation.tracker.error.ErrorConst;
import com.didi.soda.customer.foundation.tracker.error.ErrorTracker;
import com.didi.soda.customer.foundation.tracker.event.EventConst;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.soda.customer.foundation.util.GsonUtil;
import com.didi.soda.customer.foundation.util.OnceActionUtil;
import java.util.ArrayList;
import java.util.HashMap;

public class PopDialogOmageHelper {
    public static final int FAIL = 2;
    public static final int NUKWON = -1;
    public static final int SUCCESS = 1;

    /* renamed from: a */
    static final int f40489a = 3;

    /* renamed from: b */
    static final String f40490b = "duration_key";

    /* renamed from: c */
    private NAPopDialogEntity f40491c;

    /* renamed from: d */
    private ScopeContext f40492d;

    /* renamed from: e */
    private OnceActionUtil.ActionPool f40493e = new OnceActionUtil.ActionPool();

    PopDialogOmageHelper(ScopeContext scopeContext, NAPopDialogEntity nAPopDialogEntity) {
        this.f40492d = scopeContext;
        this.f40491c = nAPopDialogEntity;
    }

    public void resetPool() {
        OnceActionUtil.ActionPool actionPool = this.f40493e;
        if (actionPool != null) {
            actionPool.reset();
        }
    }

    public void onClear() {
        this.f40493e = null;
    }

    public void setEntity(NAPopDialogEntity nAPopDialogEntity) {
        this.f40491c = nAPopDialogEntity;
    }

    public OmegaTracker.Builder create(String str) {
        if (this.f40491c != null) {
            return OmegaTracker.Builder.create(str, this.f40492d).addEventParam("activity_type", Integer.valueOf(this.f40491c.popupType)).addEventParam("activity_id", this.f40491c.f41041id);
        }
        return OmegaTracker.Builder.create(str, this.f40492d);
    }

    public void popRealRedEnvElope(String str, int i, String str2, int i2) {
        final int i3 = i;
        final String str3 = str;
        final int i4 = i2;
        final String str4 = str2;
        C136421 r0 = new OnceActionUtil.OnceAction(new Object[]{EventConst.PopDialog.REDENVELOPE_REAL_SW, str, Integer.valueOf(i), Integer.valueOf(i2)}) {
            public void run() {
                PopDialogOmageHelper.this.create(EventConst.PopDialog.REDENVELOPE_REAL_SW).addEventParam(ParamConst.PARAM_COUPON_TYPE, Integer.valueOf(i3)).addEventParam("coupon_id", str3).addEventParam("index", Integer.valueOf(i4)).addEventParam(ParamConst.PARAM_BATCH_ID, str4).build().track();
            }
        };
        OnceActionUtil.ActionPool actionPool = this.f40493e;
        if (actionPool != null) {
            actionPool.doAction(r0);
        }
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102137a(String str) {
        OmegaTracker.Builder addEventParam = create(EventConst.PopDialog.REDENVELOPE_SW).addEventParam(ParamConst.PARAM_COUPON_INFO, m28719a());
        NAPopDialogEntity nAPopDialogEntity = this.f40491c;
        Object obj = "";
        OmegaTracker.Builder addEventParam2 = addEventParam.addEventParam(ParamConst.PARAM_SHARE_TEST_GROUP, (nAPopDialogEntity == null || nAPopDialogEntity.info == null) ? obj : this.f40491c.info.treatmentGroup);
        if (TextUtils.isEmpty(str)) {
            str = obj;
        }
        OmegaTracker.Builder addEventParam3 = addEventParam2.addEventParam("activity_url", str).addEventParam(ParamConst.PARAM_DYNAMIC, Integer.valueOf(this.f40491c.animationEffect > 0 ? 2 : 1)).addEventParam("resource_id", this.f40491c.resourceId != null ? this.f40491c.resourceId : obj);
        if (PopupType.getByValue(this.f40491c.popupType) != null) {
            obj = Integer.valueOf(this.f40491c.popupType);
        }
        addEventParam3.addEventParam("popup_type", obj).build().track();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102138a(String str, int i) {
        OmegaTracker.Builder create = create(EventConst.PopDialog.REDENVELOPE_COUPON_CK);
        if (str == null) {
            str = "";
        }
        create.addEventParam("coupon_id", str).addEventParam("index", Integer.valueOf(i)).build().track();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102140a(String str, String str2, String str3) {
        ErrorTracker.create(str).addModuleName(ErrorConst.ModuleName.REDENVELOPE).addErrorType(str2).addErrorMsg(str3).build().trackError();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: b */
    public void mo102141b(String str) {
        create(str).build().track();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: c */
    public void mo102142c(String str) {
        OmegaTracker.Builder create = create(EventConst.PopDialog.REDENVELOPE_IMAGE_CK);
        if (TextUtils.isEmpty(str)) {
            str = "";
        }
        create.addEventParam("activity_url", str).build().track();
    }

    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public void mo102139a(String str, long j, int i) {
        create(str).addEventParam("duration", Long.valueOf(System.currentTimeMillis() - j)).addEventParam("is_suc", Integer.valueOf(i)).build().track();
    }

    /* renamed from: a */
    private String m28719a() {
        String str;
        NAPopDialogEntity nAPopDialogEntity = this.f40491c;
        if (nAPopDialogEntity == null || nAPopDialogEntity.info == null || this.f40491c.info.couponList == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < this.f40491c.info.couponList.size(); i++) {
            CouponEntity couponEntity = this.f40491c.info.couponList.get(i);
            if (couponEntity != null) {
                HashMap hashMap = new HashMap();
                if (couponEntity.couponId == null) {
                    str = "";
                } else {
                    str = couponEntity.couponId;
                }
                hashMap.put("coupon_id", str);
                hashMap.put(ParamConst.PARAM_COUPON_TYPE, Integer.valueOf(couponEntity.couponBusinessType));
                hashMap.put(ParamConst.PARAM_BATCH_ID, couponEntity.batchId);
                hashMap.put("index", Integer.valueOf(i));
                arrayList.add(hashMap);
            }
        }
        return GsonUtil.toJson(arrayList);
    }
}

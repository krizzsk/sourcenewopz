package com.didiglobal.enginecore.littleboy;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.didiglobal.enginecore.utils.XEngineLog;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class LBBaseTask implements ILBTask {
    public static final int CANCEL = 3;
    public static final int DOING = 1;
    public static final int FINISH = 2;
    public static final int PAUSE = -1;
    public static final int READY = 0;
    public List<LBAbility> mAbilityList = new CopyOnWriteArrayList();
    private Context mContext;
    private boolean mIsRequesting;
    protected int mStatus = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
    }

    public LBBaseTask(Context context) {
        this.mContext = context;
        this.mIsRequesting = false;
    }

    public void requestAbilityInLoop(List<LBAbility> list) {
        verify();
        LBCallBackProcessor lBCallBackProcessor = new LBCallBackProcessor(this, list);
        XEngineLog.m36181d("bffIdle: requestAbilityInLoop" + getAbilityListString(list));
        XEngineLog.m36181d("bffTime发起请求时间" + System.currentTimeMillis());
        Map<String, Object> assemblyParams = assemblyParams(list);
        Bff.call(new IBffProxy.Ability.Builder(this.mContext, "expo/passenger").setParams(assemblyParams).setCallback(lBCallBackProcessor).build());
        setStatus(1);
        setRequesting(true);
        XEngineLog.m36188fi("requestByLoop finalList :" + getAbilityListString(list));
        XEngineLog.m36188fi("requestByLoop param :" + assemblyParams.toString());
    }

    private String getAbilityListString(List<LBAbility> list) {
        if (list == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (LBAbility requestKey : list) {
            arrayList.add(requestKey.getRequestKey());
        }
        return arrayList.toString();
    }

    /* access modifiers changed from: protected */
    public void verify() {
        if (this.mAbilityList.isEmpty()) {
            throw new IllegalArgumentException("Bff的Ability不能不设置,现在size为0");
        }
    }

    /* access modifiers changed from: protected */
    public Map<String, Object> assemblyParams(List<LBAbility> list) {
        return getAbilityParam(list);
    }

    private Map<String, Object> getAbilityParam(List<LBAbility> list) {
        HashMap hashMap = new HashMap();
        for (LBAbility lBAbility : new ArrayList(list)) {
            hashMap.put(lBAbility.getRequestKey(), new HashMap(lBAbility.getRequestParam()));
        }
        return hashMap;
    }

    public boolean isRequesting() {
        return this.mIsRequesting;
    }

    public void setRequesting(boolean z) {
        this.mIsRequesting = z;
    }

    public ILBTask addAbility(LBAbility lBAbility) {
        if (lBAbility != null && !TextUtils.isEmpty(lBAbility.getRequestKey())) {
            XEngineLog.m36188fi("addAbility:" + lBAbility.getRequestKey());
            this.mAbilityList.add(lBAbility);
            setStatusAfterAddAbility();
        }
        return this;
    }

    public ILBTask removeAbility(String str) {
        XEngineLog.m36188fi("removeAbility:" + str);
        for (LBAbility next : this.mAbilityList) {
            if (next.getRequestKey().equals(str)) {
                this.mAbilityList.remove(next);
                setStatusAfterRemoveAbility();
            }
        }
        return this;
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterRemoveAbility() {
        if (this.mStatus == 0 && this.mAbilityList.size() == 1) {
            this.mStatus = 3;
            removeCache();
        }
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getStatus() {
        return this.mStatus;
    }
}

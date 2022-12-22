package com.android.didi.bfflib.task;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.bfflib.Bff;
import com.android.didi.bfflib.IBffProxy;
import com.android.didi.bfflib.net.BffCallbackProcesser;
import com.android.didi.bfflib.net.BffRequest;
import com.android.didi.bfflib.utils.BffLog;
import com.android.didi.bfflib.utils.BffThreadPool;
import com.didi.beatles.p099im.views.bottombar.IMSkinTextView;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class BffBaseProxyImpl implements IBffProxy {
    public static final int CANCEL = 3;
    public static final int DOING = 1;
    public static final int FINISH = 2;
    public static final int PAUSE = -1;
    public static final int READY = 0;
    public List<IBffProxy.Ability> mAbilityList = new CopyOnWriteArrayList();
    protected Bff.BffConfig mBffConfig;
    /* access modifiers changed from: private */
    public BffRequest mBffRequest;
    private boolean mIsRequesting = false;
    private String mServiceId;
    protected int mStatus = -1;

    @Retention(RetentionPolicy.SOURCE)
    public @interface Status {
    }

    /* access modifiers changed from: protected */
    public void setStatusAfterAddAbility() {
    }

    public BffBaseProxyImpl(Context context, Bff.BffConfig bffConfig) {
        this.mBffConfig = bffConfig;
        this.mBffRequest = new BffRequest(context.getApplicationContext(), this.mBffConfig);
    }

    public void requestAbilityInLoop(final List<IBffProxy.Ability> list) {
        verify();
        final BffCallbackProcesser bffCallbackProcesser = new BffCallbackProcesser(this, list);
        BffLog.m1480d("bffIdle: requestAbilityInLoop" + getAbilityListString(list));
        BffLog.m1480d("bffTime发起请求时间" + System.currentTimeMillis());
        IToggle toggle = Apollo.getToggle("bff_request_async");
        if (toggle == null || !toggle.allow() || ((Integer) toggle.getExperiment().getParam("requestType", 0)).intValue() != 2) {
            this.mBffRequest.requestAbilityV2(assemblyParams(list), bffCallbackProcesser);
            setStatus(1);
            setRequesting(true);
            return;
        }
        setStatus(1);
        setRequesting(true);
        BffThreadPool.execute((Runnable) new Runnable() {
            public void run() {
                BffBaseProxyImpl.this.mBffRequest.requestAbilityV2(BffBaseProxyImpl.this.assemblyParams(list), bffCallbackProcesser);
            }
        });
    }

    private String getAbilityListString(List<IBffProxy.Ability> list) {
        if (list == null) {
            return "";
        }
        ArrayList arrayList = new ArrayList();
        for (IBffProxy.Ability id : list) {
            arrayList.add(id.getId());
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
    public Map<String, Object> assemblyParams(List<IBffProxy.Ability> list) {
        Map<String, Object> commonParams = this.mBffConfig.getCommonParams();
        Map<String, Object> abilityParam = getAbilityParam(list);
        HashMap hashMap = new HashMap();
        if (!TextUtils.isEmpty(this.mServiceId)) {
            HashMap hashMap2 = new HashMap();
            hashMap2.put("id", this.mServiceId);
            businessHandleParams(commonParams, abilityParam, hashMap2);
            hashMap.put("service", hashMap2);
        } else {
            businessHandleParams(commonParams, abilityParam, (Map<String, Object>) null);
        }
        hashMap.put(IMSkinTextView.IM_SKIN_COMMON, commonParams);
        hashMap.put("abilities", abilityParam);
        return hashMap;
    }

    private void businessHandleParams(Map<String, Object> map, Map<String, Object> map2, Map<String, Object> map3) {
        IToggle toggle = Apollo.getToggle("bff_request_async");
        if (toggle != null && toggle.allow() && ((Integer) toggle.getExperiment().getParam("requestType", 0)).intValue() == 2) {
            Iterator<S> it = ServiceLoader.load(IBffParamsService.class).iterator();
            while (it.hasNext()) {
                ((IBffParamsService) it.next()).bffParams("https://api.didiglobal.com/halo/v1/multi/ability/", map, map2, map3);
            }
        }
    }

    private Map<String, Object> getAbilityParam(List<IBffProxy.Ability> list) {
        HashMap hashMap = new HashMap();
        for (IBffProxy.Ability ability : new ArrayList(list)) {
            hashMap.put(ability.getId(), new HashMap(ability.getRequestParam()));
        }
        return hashMap;
    }

    public int size() {
        List<IBffProxy.Ability> list = this.mAbilityList;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public boolean isRequesting() {
        return this.mIsRequesting;
    }

    public void setRequesting(boolean z) {
        this.mIsRequesting = z;
    }

    public String getServiceId() {
        return this.mServiceId;
    }

    public IBffProxy addAbility(IBffProxy.Ability ability) {
        if (ability != null && !TextUtils.isEmpty(ability.getId())) {
            BffLog.m1480d("addAbility:" + ability.getId());
            this.mAbilityList.add(ability);
            setStatusAfterAddAbility();
        }
        return this;
    }

    public IBffProxy removeAbility(String str) {
        BffLog.m1480d("removeAbility:" + str);
        for (IBffProxy.Ability next : this.mAbilityList) {
            if (next.getId().equals(str)) {
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

    public IBffProxy setServiceId(String str) {
        if (!TextUtils.isEmpty(str)) {
            this.mServiceId = str;
        }
        return this;
    }

    public void setStatus(int i) {
        this.mStatus = i;
    }

    public int getStatus() {
        return this.mStatus;
    }
}

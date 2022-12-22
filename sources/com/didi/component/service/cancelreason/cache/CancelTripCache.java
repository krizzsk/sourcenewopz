package com.didi.component.service.cancelreason.cache;

import com.didi.sdk.util.SingletonHolder;
import com.didi.travel.psnger.model.response.EstimateItem;
import com.didi.travel.psnger.model.response.estimate.EstimateItemModel;

public class CancelTripCache {

    /* renamed from: a */
    private boolean f15754a = false;

    /* renamed from: b */
    private EstimateItem f15755b = null;

    /* renamed from: c */
    private EstimateItemModel f15756c = null;

    /* renamed from: d */
    private String f15757d = "";

    /* renamed from: e */
    private String f15758e = "";

    /* renamed from: f */
    private long f15759f = 0;

    /* renamed from: g */
    private int f15760g = 0;

    /* renamed from: h */
    private boolean f15761h = false;

    private CancelTripCache() {
    }

    public static CancelTripCache getInstance() {
        return (CancelTripCache) SingletonHolder.getInstance(CancelTripCache.class);
    }

    public void setUsingCacheEstimateParams(boolean z) {
        this.f15754a = z;
    }

    public boolean isUsingCachedEstimateParams() {
        return this.f15754a;
    }

    public EstimateItem getEstimateModel() {
        return this.f15755b;
    }

    public void setEstimateModel(EstimateItem estimateItem) {
        this.f15755b = estimateItem;
    }

    public EstimateItemModel getNewEstimateModel() {
        return this.f15756c;
    }

    public void setEstimateModel(EstimateItemModel estimateItemModel) {
        this.f15756c = estimateItemModel;
    }

    public String getEstimateTraceId() {
        return this.f15757d;
    }

    public void setEstimateTraceId(String str) {
        this.f15757d = str;
    }

    public void setPayInfo(String str) {
        this.f15758e = str;
    }

    public String getPayInfo() {
        return this.f15758e;
    }

    public long getEstimateTime() {
        return this.f15759f;
    }

    public void setEstimateTime(long j) {
        this.f15759f = j;
    }

    public boolean isDriverArrived() {
        return this.f15761h;
    }

    public void setDriverArrived(boolean z) {
        this.f15761h = z;
    }

    public int getComboType() {
        return this.f15760g;
    }

    public void setComboType(int i) {
        this.f15760g = i;
    }

    public boolean isCarPool() {
        return this.f15760g == 4;
    }
}

package com.didi.addressnew.framework.fragmentmarket.map.fuzzymatch;

import com.sdk.poibase.model.RpcPoi;
import com.sdk.poibase.model.recsug.RpcRecSug;
import java.util.List;

public class FuzzyMatchParam {
    public static final String FUZZY_PARAM_ADDRESS_LIST = "addresses";
    public static final String FUZZY_PARAM_POI_TIP = "poiTipType";
    public static final String FUZZY_PARAM_SELECT_ADDRESS = "selectAddress";
    public static final String FUZZY_PARAM_SHOW_DATA_PROVIDER = "showDataProvider";
    public static final String FUZZY_PARAM_SUG_OP_TYPE = "opType";
    public static final String FUZZY_PARAM_SUG_PARAM = "sugparam";

    /* renamed from: a */
    private List<RpcPoi> f7159a;

    /* renamed from: b */
    private int f7160b;

    /* renamed from: c */
    private FuzzyMatchOperationCallback f7161c;

    /* renamed from: d */
    private RpcRecSug.TrackParameterForChild f7162d;

    /* renamed from: e */
    private RpcPoi f7163e;

    /* renamed from: f */
    private boolean f7164f;

    /* renamed from: g */
    private int f7165g;

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback) {
        this.f7159a = list;
        this.f7161c = fuzzyMatchOperationCallback;
        this.f7160b = i;
    }

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback, RpcRecSug.TrackParameterForChild trackParameterForChild) {
        this.f7159a = list;
        this.f7160b = i;
        this.f7161c = fuzzyMatchOperationCallback;
        this.f7162d = trackParameterForChild;
    }

    public FuzzyMatchParam(List<RpcPoi> list, int i, FuzzyMatchOperationCallback fuzzyMatchOperationCallback, RpcRecSug.TrackParameterForChild trackParameterForChild, RpcPoi rpcPoi) {
        this.f7159a = list;
        this.f7160b = i;
        this.f7161c = fuzzyMatchOperationCallback;
        this.f7162d = trackParameterForChild;
        this.f7163e = rpcPoi;
    }

    public RpcRecSug.TrackParameterForChild getmSugParam() {
        return this.f7162d;
    }

    public List<RpcPoi> getAddressData() {
        return this.f7159a;
    }

    public FuzzyMatchOperationCallback getCallback() {
        return this.f7161c;
    }

    public int getAddressType() {
        return this.f7160b;
    }

    public RpcPoi getSelectAddress() {
        return this.f7163e;
    }

    public void setSelectAddress(RpcPoi rpcPoi) {
        this.f7163e = rpcPoi;
    }

    public boolean isGroup() {
        return this.f7164f;
    }

    public void setGroup(boolean z) {
        this.f7164f = z;
    }

    public int getPageFrom() {
        return this.f7165g;
    }

    public void setPageFrom(int i) {
        this.f7165g = i;
    }
}

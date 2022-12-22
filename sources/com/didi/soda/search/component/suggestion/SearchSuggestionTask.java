package com.didi.soda.search.component.suggestion;

import com.didi.soda.customer.foundation.log.util.LogUtil;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.SearchSuggestionEntity;
import com.didi.soda.customer.foundation.rpc.net.CRpcResult;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.task.CustomerAsyncTask;
import org.json.JSONException;
import org.json.JSONObject;

public class SearchSuggestionTask extends CustomerAsyncTask<SearchSuggestionEntity> {

    /* renamed from: a */
    private static final String f43758a = "SearchAddressTask";

    /* renamed from: b */
    private static final String f43759b = "tag";

    /* renamed from: c */
    private int f43760c = 0;

    /* renamed from: d */
    private CustomerRpcService f43761d;

    /* renamed from: e */
    private String f43762e;

    /* renamed from: f */
    private String f43763f;

    public SearchSuggestionTask(CustomerRpcCallback customerRpcCallback, String str, String str2, int i) {
        super(customerRpcCallback);
        this.f43762e = str;
        this.f43763f = str2;
        this.f43760c = i;
        this.f43761d = CustomerRpcManagerProxy.get();
    }

    public void onCancel() {
        super.onCancel();
        LogUtil.m29104i(f43758a, toString() + "-onCancel");
    }

    public void onMainThread() {
        super.onMainThread();
        LogUtil.m29104i(f43758a, toString() + "-onMainThread");
    }

    public void onWorkThread() {
        super.onWorkThread();
        LogUtil.m29104i(f43758a, toString() + "-onWorkThread");
    }

    /* access modifiers changed from: protected */
    public CRpcResult<SearchSuggestionEntity> execute() {
        String str;
        try {
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("tag", this.f43762e);
            str = jSONObject.toString();
        } catch (JSONException unused) {
            str = "";
        }
        return this.f43761d.getSearchSuggestion(str, this.f43763f, this.f43760c);
    }
}

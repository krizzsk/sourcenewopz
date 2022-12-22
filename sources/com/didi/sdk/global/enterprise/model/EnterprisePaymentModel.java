package com.didi.sdk.global.enterprise.model;

import android.content.Context;
import com.didi.payment.base.utils.PayBaseParamUtil;
import com.didi.sdk.global.constant.GlobalServer;
import com.didi.sdk.global.enterprise.model.bean.CompanyListBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterListBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectListBean;
import com.didi.sdk.global.enterprise.model.bean.ResultBean;
import com.didichuxing.foundation.rpc.RpcService;
import com.didichuxing.foundation.rpc.RpcServiceFactory;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

@Deprecated
public class EnterprisePaymentModel {

    /* renamed from: a */
    private Context f36154a;

    /* renamed from: b */
    private EnterprisePaymentService f36155b;

    public EnterprisePaymentModel(Context context) {
        this.f36154a = context;
        GlobalServer.initUrl();
        this.f36155b = (EnterprisePaymentService) new RpcServiceFactory(context).newRpcService(EnterprisePaymentService.class, GlobalServer.GLOBAL_ENTERPRISE_HOST);
    }

    /* renamed from: a */
    private <T> RpcService.Callback<ResultBean<T>> m25548a(final RpcService.Callback<T> callback) {
        return new RpcService.Callback<ResultBean<T>>() {
            public void onSuccess(ResultBean<T> resultBean) {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onSuccess(resultBean.data);
                }
            }

            public void onFailure(IOException iOException) {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(iOException);
                }
            }
        };
    }

    /* renamed from: a */
    private <T> RpcService.Callback<String> m25549a(final RpcService.Callback<T> callback, final Type type) {
        return new RpcService.Callback<String>() {
            public void onSuccess(String str) {
                ResultBean resultBean = (ResultBean) new Gson().fromJson(str, type);
                if (callback == null) {
                    return;
                }
                if (resultBean.status == 0) {
                    callback.onSuccess(resultBean.data);
                } else {
                    callback.onFailure(new IOException(resultBean.msg));
                }
            }

            public void onFailure(IOException iOException) {
                RpcService.Callback callback = callback;
                if (callback != null) {
                    callback.onFailure(iOException);
                }
            }
        };
    }

    /* renamed from: a */
    private HashMap<String, Object> m25550a(Context context) {
        return PayBaseParamUtil.getHttpBaseParams(context);
    }

    public void getCompanyList(String str, String str2, RpcService.Callback<CompanyListBean> callback) {
        HashMap<String, Object> a = m25550a(this.f36154a);
        a.put(GlobalServer.PARAM_PHONE_NUMBER, str);
        a.put("require_level", str2);
        this.f36155b.getCompanyList(a, m25549a(callback, new TypeToken<ResultBean<CompanyListBean>>() {
        }.getType()));
    }

    public void getCostCenterList(String str, String str2, RpcService.Callback<CostCenterListBean> callback) {
        HashMap<String, Object> a = m25550a(this.f36154a);
        a.put(GlobalServer.PARAM_MEMBER_ID, str);
        a.put("company_id", str2);
        this.f36155b.getCostCenterList(a, m25549a(callback, new TypeToken<ResultBean<CostCenterListBean>>() {
        }.getType()));
    }

    public void getProjectList(String str, String str2, String str3, RpcService.Callback<ProjectListBean> callback) {
        HashMap<String, Object> a = m25550a(this.f36154a);
        a.put(GlobalServer.PARAM_MEMBER_ID, str);
        a.put("company_id", str2);
        a.put(GlobalServer.PARAM_COST_CONTER_ID, str3);
        this.f36155b.getProjectList(a, m25549a(callback, new TypeToken<ResultBean<ProjectListBean>>() {
        }.getType()));
    }
}

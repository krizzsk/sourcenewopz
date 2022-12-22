package com.didi.sdk.global.enterprise.presenter;

import android.text.TextUtils;
import com.didi.sdk.global.enterprise.contract.EnterprisePaymentListContract;
import com.didi.sdk.global.enterprise.model.EnterprisePaymentModel;
import com.didi.sdk.global.enterprise.model.bean.CompanyListBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterListBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectListBean;
import com.didi.sdk.global.enterprise.model.data.EnterpriseItem;
import com.didi.sdk.logging.LoggerFactory;
import com.didichuxing.foundation.rpc.RpcService;
import java.io.IOException;
import java.util.List;

@Deprecated
public class EnterprisePaymentListPresenter implements EnterprisePaymentListContract.Presenter {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public EnterprisePaymentListContract.View f36162a;

    /* renamed from: b */
    private EnterprisePaymentModel f36163b;

    public EnterprisePaymentListPresenter(EnterprisePaymentListContract.View view) {
        this.f36162a = view;
        this.f36163b = new EnterprisePaymentModel(view.getContext());
    }

    public void requestCompanyList(String str, String str2) {
        LoggerFactory.getLogger("Enterprise").info("requestCompanyList, %s", str);
        this.f36163b.getCompanyList(str, str2, new RpcService.Callback<CompanyListBean>() {
            public void onSuccess(CompanyListBean companyListBean) {
                LoggerFactory.getLogger("Enterprise").info("requestCompanyList onSuccess", new Object[0]);
                EnterprisePaymentListPresenter.this.f36162a.refreshList(EnterpriseItem.transformCompanyList(companyListBean.companyList));
            }

            public void onFailure(IOException iOException) {
                LoggerFactory.getLogger("Enterprise").info("requestCompanyList onFailure e: %s", iOException.toString());
                EnterprisePaymentListPresenter.this.f36162a.refreshList((List<EnterpriseItem>) null);
            }
        });
    }

    public void requestCostCenterList(String str, String str2) {
        LoggerFactory.getLogger("Enterprise").info("requestCostCenterList, %s, %s", str, str2);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2)) {
            this.f36162a.dismissLoadingDialog();
        } else {
            this.f36163b.getCostCenterList(str, str2, new RpcService.Callback<CostCenterListBean>() {
                public void onSuccess(CostCenterListBean costCenterListBean) {
                    LoggerFactory.getLogger("Enterprise").info("requestCostCenterList onSuccess", new Object[0]);
                    EnterprisePaymentListPresenter.this.f36162a.refreshList(EnterpriseItem.transformCostCenterList(costCenterListBean.costCenterList));
                }

                public void onFailure(IOException iOException) {
                    LoggerFactory.getLogger("Enterprise").info("requestCostCenterList onFailure e: %s", iOException.toString());
                    EnterprisePaymentListPresenter.this.f36162a.refreshList((List<EnterpriseItem>) null);
                }
            });
        }
    }

    public void requestProjectList(String str, String str2, String str3) {
        LoggerFactory.getLogger("Enterprise").info("requestProjectList, %s, %s, %s", str, str2, str3);
        if (TextUtils.isEmpty(str) || TextUtils.isEmpty(str2) || TextUtils.isEmpty(str3)) {
            this.f36162a.dismissLoadingDialog();
        } else {
            this.f36163b.getProjectList(str, str2, str3, new RpcService.Callback<ProjectListBean>() {
                public void onSuccess(ProjectListBean projectListBean) {
                    LoggerFactory.getLogger("Enterprise").info("requestProjectList onSuccess", new Object[0]);
                    EnterprisePaymentListPresenter.this.f36162a.refreshList(EnterpriseItem.transformProjectList(projectListBean.projectList));
                }

                public void onFailure(IOException iOException) {
                    LoggerFactory.getLogger("Enterprise").info("requestProjectList onFailure e: %s", iOException.toString());
                    EnterprisePaymentListPresenter.this.f36162a.refreshList((List<EnterpriseItem>) null);
                }
            });
        }
    }
}

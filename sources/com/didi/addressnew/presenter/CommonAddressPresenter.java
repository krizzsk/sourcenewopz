package com.didi.addressnew.presenter;

import android.content.Context;
import com.didi.address.util.NetUtil;
import com.didi.addressnew.model.ISelectAddressModel;
import com.didi.addressnew.model.SelectAddressModel;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.map.sdk.env.PaxEnvironment;
import com.sdk.poibase.ResultCallback;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.HttpResultBase;
import com.sdk.poibase.model.common.RpcCommon;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.io.IOException;

public class CommonAddressPresenter implements ICommonAddressPresenter {

    /* renamed from: a */
    private ISelectAddressModel f7464a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICommonAddressView f7465b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SelectAddressModel f7466c;

    public CommonAddressPresenter(Context context, ICommonAddressView iCommonAddressView) {
        this.f7464a = new SelectAddressModel(context);
        this.f7465b = iCommonAddressView;
        this.f7466c = new SelectAddressModel(context);
    }

    public void getCommonAddress(AddressParam addressParam) {
        if (addressParam == null) {
            this.f7465b.showEmptyView();
            return;
        }
        this.f7465b.showProgressDialog(true);
        this.f7464a.getCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
            public void success(RpcCommon rpcCommon) {
                CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                CommonAddressPresenter.this.f7465b.showContentView();
                CommonAddressPresenter.this.f7465b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                CommonAddressPresenter.this.f7466c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), rpcCommon);
            }

            public void failure(IOException iOException) {
                CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                CommonAddressPresenter.this.f7465b.showEmptyView();
                if (NetUtil.isNetException(iOException)) {
                    CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_check_network));
                } else {
                    CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_load_fail));
                }
            }
        });
    }

    public void getCommonAddressCache(AddressParam addressParam) {
        RpcCommon commonAddressCache = this.f7464a.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
        this.f7465b.updateCommonAddress(commonAddressCache == null ? null : commonAddressCache.commonAddresses);
    }

    public void deleteCommonAddress(AddressParam addressParam) {
        if (addressParam != null) {
            this.f7465b.showProgressDialog(true);
            this.f7464a.deleteCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                    CommonAddressPresenter.this.f7465b.showContentView();
                    CommonAddressPresenter.this.f7465b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f7465b.showToastComplete(CommonAddressPresenter.this.f7465b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void deletFavoritePlace(AddressParam addressParam, String str) {
        if (addressParam != null) {
            this.f7465b.showProgressDialog(true);
            this.f7464a.deleteFavoritePlace(addressParam, str, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                    CommonAddressPresenter.this.f7465b.showContentView();
                    CommonAddressPresenter.this.f7465b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f7465b.showToastComplete(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z) {
        if (addressParam != null) {
            this.f7465b.showProgressDialog(true);
            this.f7464a.updateFavoritePlace(addressParam, rpcCommonPoi, z, new ResultCallback<HttpResultBase>() {
                public void success(HttpResultBase httpResultBase) {
                    if (httpResultBase == null || httpResultBase.errno == 0) {
                        CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                        CommonAddressPresenter.this.f7465b.onHttpRequestSuccess();
                        return;
                    }
                    CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_load_fail));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7465b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7465b.showToastError(CommonAddressPresenter.this.f7465b.getStringVal(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }
}

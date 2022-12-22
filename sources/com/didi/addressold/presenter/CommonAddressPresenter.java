package com.didi.addressold.presenter;

import android.content.Context;
import com.didi.addressold.model.ISelectAddressModel;
import com.didi.addressold.model.SelectAddressModel;
import com.didi.addressold.util.NetUtil;
import com.didi.addressold.view.ICommonAddressView;
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
    private ISelectAddressModel f7773a = null;
    /* access modifiers changed from: private */

    /* renamed from: b */
    public ICommonAddressView f7774b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public SelectAddressModel f7775c;

    public CommonAddressPresenter(Context context, ICommonAddressView iCommonAddressView) {
        this.f7773a = new SelectAddressModel(context);
        this.f7774b = iCommonAddressView;
        this.f7775c = new SelectAddressModel(context);
    }

    public void getCommonAddress(AddressParam addressParam) {
        if (addressParam == null) {
            this.f7774b.showEmptyView();
            return;
        }
        this.f7774b.showProgressDialog(true);
        this.f7773a.getCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
            public void success(RpcCommon rpcCommon) {
                CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                CommonAddressPresenter.this.f7774b.showContentView();
                CommonAddressPresenter.this.f7774b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                CommonAddressPresenter.this.f7775c.setCommonAddressCache(PaxEnvironment.getInstance().getUid(), rpcCommon);
            }

            public void failure(IOException iOException) {
                CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                CommonAddressPresenter.this.f7774b.showEmptyView();
                if (NetUtil.isNetException(iOException)) {
                    CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_check_network));
                } else {
                    CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_load_fail));
                }
            }
        });
    }

    public void getCommonAddressCache(AddressParam addressParam) {
        RpcCommon commonAddressCache = this.f7773a.getCommonAddressCache(PaxEnvironment.getInstance().getUid());
        this.f7774b.updateCommonAddress(commonAddressCache == null ? null : commonAddressCache.commonAddresses);
    }

    public void deleteCommonAddress(AddressParam addressParam) {
        if (addressParam != null) {
            this.f7774b.showProgressDialog(true);
            this.f7773a.deleteCommonAddress(addressParam, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    CommonAddressPresenter.this.f7774b.showContentView();
                    CommonAddressPresenter.this.f7774b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f7774b.showToastComplete(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void deletFavoritePlace(AddressParam addressParam, String str) {
        if (addressParam != null) {
            this.f7774b.showProgressDialog(true);
            this.f7773a.deleteFavoritePlace(addressParam, str, new ResultCallback<RpcCommon>() {
                public void success(RpcCommon rpcCommon) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    CommonAddressPresenter.this.f7774b.showContentView();
                    CommonAddressPresenter.this.f7774b.updateCommonAddress(rpcCommon == null ? null : rpcCommon.commonAddresses);
                    CommonAddressPresenter.this.f7774b.showToastComplete(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_delete_success));
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }

    public void updateFavoritePlace(AddressParam addressParam, RpcCommonPoi rpcCommonPoi, boolean z) {
        if (addressParam != null) {
            this.f7774b.showProgressDialog(true);
            this.f7773a.updateFavoritePlace(addressParam, rpcCommonPoi, z, new ResultCallback<HttpResultBase>() {
                public void success(HttpResultBase httpResultBase) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    CommonAddressPresenter.this.f7774b.onHttpRequestSuccess();
                }

                public void failure(IOException iOException) {
                    CommonAddressPresenter.this.f7774b.dismissProgressDialog();
                    if (NetUtil.isNetException(iOException)) {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_check_network));
                    } else {
                        CommonAddressPresenter.this.f7774b.showToastError(CommonAddressPresenter.this.f7774b.getString(R.string.global_sug_load_fail));
                    }
                }
            });
        }
    }
}

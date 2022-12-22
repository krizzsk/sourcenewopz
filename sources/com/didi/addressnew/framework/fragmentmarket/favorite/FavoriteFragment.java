package com.didi.addressnew.framework.fragmentmarket.favorite;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.android.didi.theme.DidiThemeManager;
import com.didi.address.model.SugParams;
import com.didi.addressnew.fastframe.IView;
import com.didi.addressnew.framework.fragmentmarket.FragmentFactory;
import com.didi.addressnew.framework.fragmentmarket.base.FragmentImpl;
import com.didi.addressnew.framework.fragmentmarket.favorite.FavoriteAdapter;
import com.didi.addressnew.framework.switcher.result.IAddressResult;
import com.didi.addressnew.presenter.CommonAddressPresenter;
import com.didi.addressnew.presenter.ICommonAddressPresenter;
import com.didi.addressnew.util.AddressConvertUtil;
import com.didi.addressnew.util.SavedInstance;
import com.didi.addressnew.util.ToastHelper;
import com.didi.addressnew.view.ICommonAddressView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.address.address.entity.Address;
import com.sdk.poibase.ModelConverter;
import com.sdk.poibase.model.AddressParam;
import com.sdk.poibase.model.common.RpcCommonPoi;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Iterator;

public class FavoriteFragment extends FragmentImpl implements View.OnClickListener, ICommonAddressView {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public FavoriteListView f4414a;
    /* access modifiers changed from: private */
    @SavedInstance

    /* renamed from: b */
    public ArrayList<RpcCommonPoi> f4415b = new ArrayList<>();
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ICommonAddressPresenter f4416c;

    /* renamed from: d */
    private FavoriteAdapter.OnFavoriteItemClickListener f4417d = new FavoriteAdapter.OnFavoriteItemClickListener() {
        public void onItemClick(FavoriteAdapter.FavoriteAddressModel favoriteAddressModel, int i) {
            if (favoriteAddressModel != null) {
                Address convertToAddress = ModelConverter.convertToAddress(AddressConvertUtil.commonToRecSug(favoriteAddressModel.rpcCommonPoi));
                convertToAddress.operationType = 6;
                if (TextUtils.isEmpty(convertToAddress.coordinate_type)) {
                    convertToAddress.coordinate_type = "wgs84";
                }
                FavoriteFragment.this.getmResult().setResult(FavoriteFragment.this.getmParam().addressParam.addressType, convertToAddress);
                FavoriteFragment favoriteFragment = FavoriteFragment.this;
                favoriteFragment.onConfirm(favoriteFragment.getmParam(), FavoriteFragment.this.getmResult());
                FavoriteFragment favoriteFragment2 = FavoriteFragment.this;
                favoriteFragment2.switchBack(favoriteFragment2.getmParam(), FavoriteFragment.this.getmResult());
            }
        }

        public void onAddClick() {
            FavoriteFragment.this.getmResult().setCommonAddressList(FavoriteFragment.this.f4415b);
            SugParams clone = FavoriteFragment.this.getmParam().clone();
            IAddressResult clone2 = FavoriteFragment.this.getmResult().clone();
            clone2.setCommonAddress((RpcCommonPoi) null);
            clone2.setResultAllowNull(5, (Address) null);
            FavoriteFragment.this.onConfirm(clone, clone2);
            FavoriteFragment.this.switchSingle(clone, clone2, 5);
        }

        public void onDeleteClick(final FavoriteAdapter.FavoriteAddressModel favoriteAddressModel) {
            FavoriteFragment.this.f4414a.post(new Runnable() {
                public void run() {
                    AddressParam clone = FavoriteFragment.this.getmParam().addressParam.clone();
                    clone.addressType = 5;
                    FavoriteFragment.this.f4416c.deletFavoritePlace(clone, favoriteAddressModel.rpcCommonPoi.primaryId);
                }
            });
        }
    };

    public /* synthetic */ void dismissProgressDialog() {
        IView.CC.$default$dismissProgressDialog(this);
    }

    public boolean getDragHandlerEnable() {
        return false;
    }

    public View getFallbackView() {
        return null;
    }

    public /* synthetic */ void onHttpRequestSuccess() {
        IView.CC.$default$onHttpRequestSuccess(this);
    }

    public /* synthetic */ void showContentView() {
        IView.CC.$default$showContentView(this);
    }

    public /* synthetic */ void showEmptyView() {
        IView.CC.$default$showEmptyView(this);
    }

    public /* synthetic */ void showProgressDialog(String str, boolean z) {
        IView.CC.$default$showProgressDialog(this, str, z);
    }

    public /* synthetic */ void showProgressDialog(boolean z) {
        IView.CC.$default$showProgressDialog(this, z);
    }

    public /* synthetic */ void showToastError(String str, boolean z) {
        IView.CC.$default$showToastError(this, str, z);
    }

    public void onAttach(Activity activity) {
        super.onAttach(activity);
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.fragment_favorite_layout, viewGroup, false);
        this.f4414a = (FavoriteListView) inflate.findViewById(R.id.favorite_list);
        View findViewById = inflate.findViewById(R.id.favorite_add_btn);
        try {
            inflate.findViewById(R.id.favorite_add_btn_bg).setBackground(DidiThemeManager.getIns().getResPicker(getActivity()).getDrawable(R.attr.submit_btn_bg_new_selector));
        } catch (Throwable th) {
            th.printStackTrace();
        }
        findViewById.setOnClickListener(this);
        this.f4414a.setAddFavoriteBtn(findViewById);
        this.f4414a.setOnFavoriteItemClickListener(this.f4417d);
        inflate.findViewById(R.id.favorite_back).setOnClickListener(this);
        this.f4416c = new CommonAddressPresenter(getContext(), this);
        return inflate;
    }

    public boolean onBackPressed() {
        return super.onBackPressed();
    }

    public void onPageEnter() {
        super.onPageEnter();
        ICommonAddressPresenter iCommonAddressPresenter = this.f4416c;
        if (iCommonAddressPresenter != null) {
            iCommonAddressPresenter.getCommonAddress(getmParam().addressParam);
        }
    }

    public void onPageExit() {
        super.onPageExit();
    }

    public void onCancel(SugParams sugParams, IAddressResult iAddressResult) {
        super.onCancel(sugParams, iAddressResult);
    }

    public void onConfirm(SugParams sugParams, IAddressResult iAddressResult) {
        super.onConfirm(sugParams, iAddressResult);
    }

    public FragmentFactory.FragmentType getType() {
        return FragmentFactory.FragmentType.FAVORITE;
    }

    public void updateCommonAddress(ArrayList<RpcCommonPoi> arrayList) {
        this.f4415b = arrayList;
        ArrayList<RpcCommonPoi> arrayList2 = new ArrayList<>();
        if (arrayList != null) {
            Iterator<RpcCommonPoi> it = arrayList.iterator();
            while (it.hasNext()) {
                RpcCommonPoi next = it.next();
                if (next != null && next.type == 3) {
                    next.name = getString(R.string.GRider_Sug_2020_home);
                } else if (next != null && next.type == 4) {
                    next.name = getString(R.string.GRider_Sug_2020_work);
                } else if (next != null && next.type == 5) {
                    arrayList2.add(next);
                }
            }
            this.f4414a.setFavoriteItems(arrayList2);
            this.f4415b = arrayList2;
        }
    }

    public void showToastComplete(String str) {
        ToastHelper.showSuccessful(getContext(), str);
    }

    public String getStringVal(int i) {
        try {
            return getContext().getString(i);
        } catch (Exception unused) {
            return "";
        }
    }

    public void showToastError(String str) {
        ToastHelper.showFail(getContext(), str);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        int id = view.getId();
        if (id == R.id.favorite_back) {
            onCancel(getmParam(), getmResult());
            switchBack(getmParam(), getmResult());
        } else if (id != R.id.favorite_add_btn) {
        } else {
            if (this.f4414a.getTotalFavoriteCnt() >= 10) {
                ToastHelper.showFail(getContext(), getContext().getResources().getString(R.string.GRider_Sug_2020_favoritePage_limit));
                return;
            }
            getmResult().setCommonAddressList(this.f4415b);
            SugParams clone = getmParam().clone();
            IAddressResult clone2 = getmResult().clone();
            clone2.setCommonAddress((RpcCommonPoi) null);
            clone2.setResultAllowNull(5, (Address) null);
            onConfirm(clone, clone2);
            switchSingle(clone, clone2, 5);
        }
    }
}

package com.didi.safetoolkit.business.areaCode;

import android.content.Context;
import android.text.TextUtils;
import com.android.didi.safetoolkit.presenter.AbsPresenter;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.api.ISfInfoService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.model.SfShareResponse;
import com.didi.safetoolkit.business.share.store.SfContactsStore;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.util.BroadcastUtil;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.List;

public class MandatoryGuidePresenter extends AbsPresenter<SfGuideIView> {
    /* access modifiers changed from: private */
    public String code;
    private List<SfContactsModel> contactsList;
    /* access modifiers changed from: private */
    public Context context;

    public interface Callback {
        void onAddAreaSuccess();
    }

    public MandatoryGuidePresenter(SfGuideIView sfGuideIView) {
        super(sfGuideIView);
    }

    public void onCreate() {
        super.onCreate();
        this.context = ((SfGuideIView) this.mView).getContext();
    }

    public void setContactsList(List<SfContactsModel> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.contactsList = list;
    }

    public void setCode(String str) {
        this.code = str;
    }

    public void addAllOfThemAndShare(int i, Callback callback) {
        addContactAndShare(i, callback);
    }

    private void addContactAndShare(int i, Callback callback) {
        showPDialog();
        boolean z = false;
        final boolean z2 = i == 1;
        if (i != 0) {
            z = true;
        }
        final ArrayList<SfContactsModel> arrayList = new ArrayList<>(this.contactsList);
        for (SfContactsModel sfContactsModel : arrayList) {
            if (z) {
                sfContactsModel.origin_phone = sfContactsModel.phone;
            }
            sfContactsModel.phone = this.code + sfContactsModel.phone;
        }
        final int i2 = i;
        final Callback callback2 = callback;
        new SfContactsManageStore().addContact(z, new Gson().toJson((Object) arrayList), new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (z2) {
                    ISfInfoService iSfInfoService = (ISfInfoService) ServiceLoader.load(ISfInfoService.class, SafeToolKit.getIns().getBusinessType()).get();
                    if (iSfInfoService != null) {
                        String carOrderId = iSfInfoService.getCarOrderId();
                        if (!TextUtils.isEmpty(carOrderId)) {
                            SfContactsStore.getInstance().share(arrayList, carOrderId, new SfResponseListener<SfShareResponse>() {
                                public void onSuccess(SfShareResponse sfShareResponse) {
                                    super.onSuccess(sfShareResponse);
                                    MandatoryGuidePresenter.this.closePDialog();
                                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                                    if (sfShareResponse.data != null && sfShareResponse.data.shareSuccessCount > 0) {
                                        if (!TextUtils.isEmpty(sfShareResponse.data.successText)) {
                                            ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.data.successText);
                                        }
                                        ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, SafeToolKit.getIns().getBusinessType()).get();
                                        if (iSfContactCallbackService != null) {
                                            iSfContactCallbackService.onContactsShared();
                                        }
                                    }
                                }

                                public void onFail(int i, String str) {
                                    super.onFail(i, str);
                                    MandatoryGuidePresenter.this.closePDialog();
                                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), str);
                                }
                            });
                        }
                    }
                } else {
                    MandatoryGuidePresenter.this.closePDialog();
                    ((SfGuideIView) MandatoryGuidePresenter.this.mView).onAllNumberAdded();
                    int i = i2;
                    if (i == 0) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.context, MandatoryGuidePresenter.this.context.getResources().getString(R.string.sf_add_area_code_success_msg));
                    } else if (i == 2) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.context, MandatoryGuidePresenter.this.context.getResources().getString(R.string.sf_add_area_code_success_msg_by_stock, new Object[]{MandatoryGuidePresenter.this.code}));
                    }
                    Callback callback = callback2;
                    if (callback != null) {
                        callback.onAddAreaSuccess();
                    }
                }
                MandatoryGuidePresenter.this.track4AddAreaCodeSuccess(sfContactsManageModel);
                if (MandatoryGuidePresenter.this.getContext() != null) {
                    BroadcastUtil.sendBroadcast(MandatoryGuidePresenter.this.getContext(), SfConstant.SfAction.ACTION_ADD_CONTACTS_SUCCESS);
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (MandatoryGuidePresenter.this.getContext() != null) {
                    BroadcastUtil.sendBroadcast(MandatoryGuidePresenter.this.getContext(), SfConstant.SfAction.ACTION_ADD_CONTACTS_FAIL);
                    if (sfContactsManageModel != null && !TextUtils.isEmpty(sfContactsManageModel.errmsg)) {
                        ToastHelper.showLongCompleted(MandatoryGuidePresenter.this.getContext(), sfContactsManageModel.errmsg);
                    }
                }
                MandatoryGuidePresenter.this.closePDialog();
            }
        });
    }

    /* access modifiers changed from: private */
    public void track4AddAreaCodeSuccess(SfContactsManageModel sfContactsManageModel) {
        List<SfContactsModel> list;
        if (sfContactsManageModel != null && sfContactsManageModel.datas != null && sfContactsManageModel.datas.contacts != null && !sfContactsManageModel.datas.contacts.isEmpty() && (list = this.contactsList) != null && !list.isEmpty()) {
            for (SfContactsModel next : sfContactsManageModel.datas.contacts) {
                for (SfContactsModel sfContactsModel : this.contactsList) {
                    if (next.phone.equals(sfContactsModel.phone)) {
                        SfOmegaUtil.addEventId("gp_addAreaCode_success_rsp").addKeyValue("phone", next.phone).report();
                    }
                }
            }
        }
    }
}

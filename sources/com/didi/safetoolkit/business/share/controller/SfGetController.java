package com.didi.safetoolkit.business.share.controller;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.TextView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.SfIContactsView;
import com.didi.safetoolkit.util.BroadcastUtil;
import com.didi.safetoolkit.util.SfAppUtils;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.sdk.util.ToastHelper;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.google.gson.Gson;
import com.taxis99.R;
import java.util.ArrayList;

public class SfGetController extends SfBaseController {
    public static final int FROM_TRUST_CONTACTS = 1;
    public static final int FROM_TRUST_SHARE = 2;
    private TextView mBottomBtn;
    private View mBottomLayout;
    /* access modifiers changed from: private */
    public int whereFrom = 1;

    public SfGetController(SfIContactsView sfIContactsView) {
        super(sfIContactsView);
    }

    public SfGetController(SfIContactsView sfIContactsView, int i) {
        super(sfIContactsView);
        this.whereFrom = i;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        super.findViews();
        this.mBottomLayout = ((SfIContactsView) this.mView).findViewByIdImpl(R.id.get_layout);
        ((TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.get_layout_text)).setText(String.format(SfStringGetter.getString(R.string.sf_trusted_contacts_can_addnum), new Object[]{Integer.valueOf(((SfIContactsView) this.mView).getThreshold())}));
        this.mBottomBtn = (TextView) ((SfIContactsView) this.mView).findViewByIdImpl(R.id.get_layout_btn);
        this.mTitleBar.setTitleText(SfStringGetter.getString(R.string.sf_contacts));
        this.mBottomBtn.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfGetController.this.addContact();
            }
        });
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.mStore.getSystemContacts(this.mCallback);
    }

    /* access modifiers changed from: protected */
    public void onPermissionRefused(boolean z) {
        showNoPermissionPage(z);
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            this.mBottomLayout.setVisibility(0);
            this.mBottomBtn.setText(String.format(SfStringGetter.getString(R.string.sf_add_btn_text), new Object[]{Integer.valueOf(i)}));
            return;
        }
        this.mBottomLayout.setVisibility(8);
    }

    /* access modifiers changed from: private */
    public void addContact() {
        showPDialog();
        new SfContactsManageStore().addContact(false, new Gson().toJson((Object) this.selectList), new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                ISfContactCallbackService iSfContactCallbackService;
                if (!(SfGetController.this.mView instanceof BaseSafeToolkitActivity) || !((BaseSafeToolkitActivity) SfGetController.this.mView).isDestory()) {
                    SfGetController.this.closePDialog();
                    Intent intent = null;
                    if (!SfAppUtils.isBrazilPackage(SfGetController.this.getContext()) || sfContactsManageModel == null || sfContactsManageModel.datas == null || sfContactsManageModel.datas.needAreaCodeContacts == null || sfContactsManageModel.datas.needAreaCodeContacts.isEmpty()) {
                        intent = new Intent();
                        Bundle bundle = new Bundle();
                        if (!(sfContactsManageModel == null || sfContactsManageModel.datas == null || sfContactsManageModel.datas.contacts == null)) {
                            bundle.putSerializable("list", (ArrayList) sfContactsManageModel.datas.contacts);
                        }
                        intent.putExtra("data", bundle);
                    } else {
                        ((SfIContactsView) SfGetController.this.mView).startAddAreaCodeActivity(SfGetController.this.whereFrom == 2 ? 150 : 0, sfContactsManageModel);
                    }
                    if (SfGetController.this.whereFrom == 2 && (iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, SafeToolKit.getIns().getBusinessType()).get()) != null) {
                        iSfContactCallbackService.onNewTrustedContactAdded(true);
                    }
                    if (SfGetController.this.getContext() != null) {
                        BroadcastUtil.sendBroadcast(SfGetController.this.getContext(), SfConstant.SfAction.ACTION_ADD_CONTACTS_SUCCESS);
                    }
                    if (intent == null) {
                        intent = new Intent();
                    }
                    SfGetController.this.setResultAndFinish(intent);
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                SfGetController.this.closePDialog();
                if (sfContactsManageModel != null && SfGetController.this.getContext() != null && !TextUtils.isEmpty(sfContactsManageModel.errmsg)) {
                    ToastHelper.showShortCompleted(SfGetController.this.getContext(), sfContactsManageModel.errmsg);
                }
            }
        });
    }
}

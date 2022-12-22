package com.didi.safetoolkit.business.contacts.store;

import android.text.TextUtils;
import com.didi.safetoolkit.api.ISfContactCallbackService;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didichuxing.foundation.spi.ServiceLoader;
import java.util.List;

public class SfContactsManageStore {
    /* access modifiers changed from: private */

    /* renamed from: a */
    public List<SfContactsModel> f34318a;

    public interface Callback {
        void onError(SfContactsManageModel sfContactsManageModel);

        void onSuccess(SfContactsManageModel sfContactsManageModel);
    }

    public int getDataSize() {
        List<SfContactsModel> list = this.f34318a;
        if (list == null) {
            return 0;
        }
        return list.size();
    }

    public List<SfContactsModel> getData() {
        return this.f34318a;
    }

    public void getTrustedContacts(final Callback callback) {
        SfContactsRequestBiz.getTrustedContacts(new SfResponseListener<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (sfContactsManageModel.datas != null) {
                    List unused = SfContactsManageStore.this.f34318a = sfContactsManageModel.datas.contacts;
                }
                SfContactsManageStore.this.m24280a(sfContactsManageModel);
                callback.onSuccess(sfContactsManageModel);
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                callback.onError(sfContactsManageModel);
            }

            public void onFail(int i, String str) {
                callback.onError((SfContactsManageModel) null);
            }
        });
    }

    public void addContact(boolean z, String str, final Callback callback) {
        if (!TextUtils.isEmpty(str)) {
            C116802 r0 = new SfResponseListener<SfContactsManageModel>() {
                public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                    if (sfContactsManageModel.datas != null) {
                        List unused = SfContactsManageStore.this.f34318a = sfContactsManageModel.datas.contacts;
                    }
                    SfContactsManageStore.this.m24280a(sfContactsManageModel);
                    callback.onSuccess(sfContactsManageModel);
                }

                public void onError(SfContactsManageModel sfContactsManageModel) {
                    callback.onError(sfContactsManageModel);
                }

                public void onFail(int i, String str) {
                    callback.onError((SfContactsManageModel) null);
                }
            };
            if (z) {
                SfContactsRequestBiz.updateContact(str, r0);
            } else {
                SfContactsRequestBiz.addContact(str, r0);
            }
        }
    }

    public void deleteContact(String str, final Callback callback) {
        SfContactsRequestBiz.deleteContact(str, new SfResponseListener<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (sfContactsManageModel.datas != null) {
                    List unused = SfContactsManageStore.this.f34318a = sfContactsManageModel.datas.contacts;
                }
                SfContactsManageStore.this.m24280a(sfContactsManageModel);
                callback.onSuccess(sfContactsManageModel);
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                callback.onError(sfContactsManageModel);
            }

            public void onFail(int i, String str) {
                callback.onError((SfContactsManageModel) null);
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24280a(SfContactsManageModel sfContactsManageModel) {
        ISfContactCallbackService iSfContactCallbackService = (ISfContactCallbackService) ServiceLoader.load(ISfContactCallbackService.class, SafeToolKit.getIns().getBusinessType()).get();
        if (iSfContactCallbackService != null) {
            iSfContactCallbackService.onTrustedContactChanged(sfContactsManageModel);
        }
    }
}

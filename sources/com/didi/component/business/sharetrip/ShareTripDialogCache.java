package com.didi.component.business.sharetrip;

import android.content.Context;
import android.text.TextUtils;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.sdk.sidebar.setup.mutilocale.MultiLocaleStore;
import com.didi.travel.psnger.common.net.base.ResponseListener;
import com.didi.unifylogin.listener.LoginListeners;
import java.util.List;

public class ShareTripDialogCache implements LoginListeners.LoginOutListener {

    /* renamed from: a */
    private static volatile ShareTripDialogCache f11360a;

    /* renamed from: b */
    private CommonTripShareInfo f11361b;

    /* renamed from: c */
    private List<SfContactsModel> f11362c;

    /* renamed from: d */
    private SfContactsManageStore f11363d = new SfContactsManageStore();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public String f11364e = "";
    /* access modifiers changed from: private */

    /* renamed from: f */
    public String f11365f = "";
    /* access modifiers changed from: private */

    /* renamed from: g */
    public boolean f11366g = false;

    public interface RequestCallback<T> {
        void onFail(T t);

        void onSuccess(T t);
    }

    public static ShareTripDialogCache getInstance() {
        if (f11360a == null) {
            synchronized (ShareTripDialogCache.class) {
                if (f11360a == null) {
                    f11360a = new ShareTripDialogCache();
                }
            }
        }
        return f11360a;
    }

    private ShareTripDialogCache() {
        NationComponentDataUtil.addLoginOutlistener(this);
    }

    public void setShareInfo(CommonTripShareInfo commonTripShareInfo) {
        this.f11361b = commonTripShareInfo;
    }

    public CommonTripShareInfo getShareInfo() {
        return this.f11361b;
    }

    public List<SfContactsModel> getContacts() {
        return this.f11362c;
    }

    public void setContacts(List<SfContactsModel> list) {
        this.f11362c = list;
    }

    /* renamed from: a */
    private void m7690a(Context context, final String str, int i, final RequestCallback<CommonTripShareInfo> requestCallback, boolean z) {
        final String localeCode = MultiLocaleStore.getInstance().getLocaleCode();
        if (str != null) {
            if ((z || !TextUtils.equals(this.f11364e, str) || !TextUtils.equals(this.f11365f, localeCode)) && context != null) {
                CommonTripShareRequest.getInstance(context).getTripShareInfo(str, i, new ResponseListener<CommonTripShareInfo>() {
                    public void onSuccess(CommonTripShareInfo commonTripShareInfo) {
                        super.onSuccess(commonTripShareInfo);
                        ShareTripDialogCache.this.setShareInfo(commonTripShareInfo);
                        String unused = ShareTripDialogCache.this.f11364e = str;
                        String unused2 = ShareTripDialogCache.this.f11365f = localeCode;
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onSuccess(commonTripShareInfo);
                        }
                    }

                    public void onError(CommonTripShareInfo commonTripShareInfo) {
                        super.onError(commonTripShareInfo);
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onFail(commonTripShareInfo);
                        }
                    }

                    public void onFail(CommonTripShareInfo commonTripShareInfo) {
                        super.onFail(commonTripShareInfo);
                        RequestCallback requestCallback = requestCallback;
                        if (requestCallback != null) {
                            requestCallback.onFail(commonTripShareInfo);
                        }
                    }
                });
            }
        }
    }

    public void getTripShareInfo(Context context, String str, int i) {
        m7690a(context, str, i, (RequestCallback<CommonTripShareInfo>) null, false);
    }

    public void getTripShareInfoWithNoCache(Context context, String str, int i, RequestCallback<CommonTripShareInfo> requestCallback) {
        m7690a(context, str, i, requestCallback, true);
    }

    /* renamed from: a */
    private void m7691a(final RequestCallback<SfContactsManageModel> requestCallback, boolean z) {
        if (z || !this.f11366g) {
            this.f11363d.getTrustedContacts(new SfContactsManageStore.Callback() {
                public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                    if (!(sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || sfContactsManageModel.datas.contacts == null)) {
                        ShareTripDialogCache.this.setContacts(sfContactsManageModel.datas.contacts);
                        boolean unused = ShareTripDialogCache.this.f11366g = true;
                    }
                    RequestCallback requestCallback = requestCallback;
                    if (requestCallback != null) {
                        requestCallback.onSuccess(sfContactsManageModel);
                    }
                }

                public void onError(SfContactsManageModel sfContactsManageModel) {
                    RequestCallback requestCallback = requestCallback;
                    if (requestCallback != null) {
                        requestCallback.onFail(sfContactsManageModel);
                    }
                }
            });
        }
    }

    public void loadingTrustedContacts(RequestCallback<SfContactsManageModel> requestCallback) {
        m7691a(requestCallback, true);
    }

    public void loadingTrustedContactsWithNoCache() {
        m7691a((RequestCallback<SfContactsManageModel>) null, false);
    }

    public void onSuccess() {
        NationComponentDataUtil.removeLoginOutlistener(this);
        f11360a = null;
    }
}

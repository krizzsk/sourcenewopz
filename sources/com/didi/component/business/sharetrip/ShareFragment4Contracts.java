package com.didi.component.business.sharetrip;

import android.app.Activity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.constant.BaseEventKeys;
import com.didi.component.business.sharetrip.ShareTripDialogCache;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.business.util.UiUtils;
import com.didi.component.core.event.BaseEventPublisher;
import com.didi.onekeyshare.entity.OneKeyShareInfo;
import com.didi.onekeyshare.entity.ShareInfo;
import com.didi.onekeyshare.entity.SharePlatform;
import com.didi.onekeyshare.view.fragment.ShareFragment;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.model.SfShareResponse;
import com.didi.safetoolkit.business.share.store.SfContactsStore;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.net.SfResponseListener;
import com.didi.safetoolkit.util.SfCollectionUtil;
import com.didi.safetoolkit.util.SfContextHelper;
import com.didi.sdk.util.ToastHelper;
import com.didi.sdk.util.Utils;
import com.didi.travel.psnger.model.response.CarOrder;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

public class ShareFragment4Contracts extends ShareFragment {

    /* renamed from: c */
    private static final int f11352c = 5;

    /* renamed from: d */
    private static final int f11353d = 1;

    /* renamed from: e */
    private static final int f11354e = 2;

    /* renamed from: f */
    private static final int f11355f = 3;

    /* renamed from: g */
    private static final int f11356g = 4;

    /* renamed from: h */
    private static final int f11357h = 5;
    /* access modifiers changed from: private */

    /* renamed from: a */
    public RecyclerView f11358a;

    /* renamed from: b */
    private List<SfContactsModel> f11359b;
    protected BaseEventPublisher.OnEventListener newTrustedContactAddedListener = new BaseEventPublisher.OnEventListener<BaseEventPublisher.NullEvent>() {
        public void onEvent(String str, BaseEventPublisher.NullEvent nullEvent) {
            ShareFragment4Contracts.this.m7688a(ShareTripDialogCache.getInstance().getContacts());
        }
    };
    protected BaseEventPublisher.OnEventListener sharedListener = new BaseEventPublisher.OnEventListener<SfContactsModel>() {
        public void onEvent(String str, SfContactsModel sfContactsModel) {
            ShareFragment4Contracts.this.m7687a(sfContactsModel);
        }
    };

    public int getInflateId() {
        return R.layout.f_share_dialog_4_contracts;
    }

    public static ShareFragment newInstance(ShareInfo shareInfo) {
        Bundle bundle = new Bundle();
        bundle.putSerializable("ShareInfo", shareInfo);
        ShareFragment4Contracts shareFragment4Contracts = new ShareFragment4Contracts();
        shareFragment4Contracts.setArguments(bundle);
        return shareFragment4Contracts;
    }

    public void onClickPlatform(OneKeyShareInfo oneKeyShareInfo) {
        super.onClickPlatform(oneKeyShareInfo);
        if (oneKeyShareInfo.platform.value() == SharePlatform.CONTACTS_PLATFORM.value() && getActivity() != null) {
            SafeToolKit.getIns().startSharePage(getActivity(), 100);
        }
        m7686a(oneKeyShareInfo);
    }

    /* renamed from: a */
    private void m7686a(OneKeyShareInfo oneKeyShareInfo) {
        int i;
        HashMap hashMap = new HashMap();
        boolean z = true;
        if (oneKeyShareInfo.platform.value() == SharePlatform.MESSENGER_PLATFORM.value()) {
            i = 2;
        } else if (oneKeyShareInfo.platform.value() == SharePlatform.WHATSAPP_PLATFORM.value()) {
            i = 1;
        } else if (oneKeyShareInfo.platform.value() == SharePlatform.SYSTEM_MESSAGE.value() || oneKeyShareInfo.platform.value() == SharePlatform.CONTACTS_PLATFORM.value()) {
            i = 3;
        } else {
            i = oneKeyShareInfo.platform.value() == SharePlatform.COPY_LINK_PLATFORM.value() ? 4 : oneKeyShareInfo.platform.value() == SharePlatform.LINE_PLATFORM.value() ? 5 : -1;
        }
        hashMap.put("ck_type", Integer.valueOf(i));
        RecyclerView recyclerView = this.f11358a;
        boolean z2 = false;
        if (!(recyclerView == null || recyclerView.getAdapter() == null)) {
            if (this.f11358a.getAdapter().getItemCount() <= 1) {
                z = false;
            }
            z2 = z;
        }
        hashMap.put("has_trustedConcats", Boolean.valueOf(z2));
        GlobalOmegaUtils.trackEvent("gp_safetyShare_btn_ck", (Map<String, Object>) hashMap);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.SafeToolkit.EVENT_NEW_TRUSTED_CONTACT_ADDED_FROM_NEW_SHARE, this.newTrustedContactAddedListener);
        BaseEventPublisher.getPublisher().subscribe(BaseEventKeys.SafeToolkit.EVENT_TRUSTED_CONTACT_SHARED, this.sharedListener);
    }

    public void onDestroy() {
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.SafeToolkit.EVENT_NEW_TRUSTED_CONTACT_ADDED_FROM_NEW_SHARE, this.newTrustedContactAddedListener);
        BaseEventPublisher.getPublisher().unsubscribe(BaseEventKeys.SafeToolkit.EVENT_TRUSTED_CONTACT_SHARED, this.sharedListener);
        super.onDestroy();
    }

    public void initViews(View view) {
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(getActivity(), 0, false);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_contracts);
        this.f11358a = recyclerView;
        recyclerView.setLayoutManager(linearLayoutManager);
        List<SfContactsModel> contacts = ShareTripDialogCache.getInstance().getContacts();
        this.f11359b = contacts;
        if (contacts != null) {
            this.f11358a.setAdapter(new ContractsAdapter(getActivity(), this.f11359b));
        } else {
            this.f11358a.setAdapter(new ContractsAdapter(getActivity(), new ArrayList()));
            m7683a();
        }
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ShareFragment4Contracts.this.dismiss();
            }
        });
    }

    public void setContracts(List<SfContactsModel> list) {
        this.f11359b = list;
    }

    public static class ContractsAdapter extends RecyclerView.Adapter<C4653VH> {
        private static final int NORMAL_ICON = 1;
        private static final int PLUS_ICON = 2;
        /* access modifiers changed from: private */
        public Activity activity;
        /* access modifiers changed from: private */
        public List<SfContactsModel> contractsList;

        public ContractsAdapter(Activity activity2, List<SfContactsModel> list) {
            CopyOnWriteArrayList copyOnWriteArrayList = new CopyOnWriteArrayList();
            this.contractsList = copyOnWriteArrayList;
            this.activity = activity2;
            if (list != null) {
                copyOnWriteArrayList.addAll(list);
            } else {
                this.contractsList = new ArrayList();
            }
        }

        public C4653VH onCreateViewHolder(ViewGroup viewGroup, int i) {
            return new C4653VH(View.inflate(viewGroup.getContext(), R.layout.v_share_dialog_4_contracts_item, (ViewGroup) null));
        }

        public void onBindViewHolder(C4653VH vh, final int i) {
            String str = "";
            if (isPlusButton(i)) {
                vh.nameIcon.setText(str);
                vh.nameIcon.setBackgroundResource(R.drawable.global_share_add_contracts);
                vh.name.setText(R.string.global_share_add_contacts);
                vh.layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!Utils.isFastDoubleClick()) {
                            if (SfApolloUtil.isAddContactOpt()) {
                                SafeToolKit.getIns().startContactsManagerPageForResultByNewShare(ContractsAdapter.this.activity, 100, 5 - ContractsAdapter.this.contractsList.size());
                            } else {
                                SafeToolKit.getIns().startGetContactsPageByNewShare(ContractsAdapter.this.activity, 100, 5 - ContractsAdapter.this.contractsList.size());
                            }
                            ContractsAdapter.this.trackEvent4Contacts(i, true);
                        }
                    }
                });
                return;
            }
            final SfContactsModel sfContactsModel = this.contractsList.get(i);
            if (sfContactsModel != null) {
                if (!TextUtils.isEmpty(sfContactsModel.name) && sfContactsModel.name.length() > 0) {
                    str = sfContactsModel.name.substring(0, 1);
                }
                vh.nameIcon.setText(str);
                vh.nameIcon.setBackgroundResource(R.drawable.global_share_oval_bg_selector);
                vh.name.setText(sfContactsModel.name);
                vh.name.setEllipsize(TextUtils.TruncateAt.valueOf("END"));
                vh.layout.setOnClickListener(new View.OnClickListener() {
                    public void onClick(View view) {
                        AutoTrackHelper.trackViewOnClick(view);
                        if (!Utils.isFastDoubleClick()) {
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_TRUSTED_CONTACT_SHARED, sfContactsModel);
                            ContractsAdapter.this.trackEvent4Contacts(i, false);
                        }
                    }
                });
            }
        }

        /* access modifiers changed from: private */
        public void trackEvent4Contacts(int i, boolean z) {
            HashMap hashMap = new HashMap();
            hashMap.put("ck_type", Integer.valueOf(z ? 2 : 1));
            hashMap.put("ck_rank", Integer.valueOf(i + 1));
            GlobalOmegaUtils.trackEvent("gp_trustedConcats_btn_ck", (Map<String, Object>) hashMap);
        }

        public int getItemViewType(int i) {
            return isPlusButton(i) ? 2 : 1;
        }

        public int getItemCount() {
            List<SfContactsModel> list = this.contractsList;
            int size = list == null ? 0 : list.size();
            return size < 5 ? size + 1 : size;
        }

        private boolean isPlusButton(int i) {
            List<SfContactsModel> list = this.contractsList;
            int size = list == null ? 0 : list.size();
            return size < 5 && i == size;
        }

        /* renamed from: com.didi.component.business.sharetrip.ShareFragment4Contracts$ContractsAdapter$VH */
        private class C4653VH extends RecyclerView.ViewHolder {
            public LinearLayout layout;
            public TextView name;
            public TextView nameIcon;

            public C4653VH(View view) {
                super(view);
                this.name = (TextView) view.findViewById(R.id.share_item_name);
                this.nameIcon = (TextView) view.findViewById(R.id.share_name_icon);
                if (ContractsAdapter.this.activity != null) {
                    LinearLayout linearLayout = (LinearLayout) view.findViewById(R.id.layout);
                    this.layout = linearLayout;
                    ViewGroup.LayoutParams layoutParams = linearLayout.getLayoutParams();
                    double windowWidth = ((double) UiUtils.getWindowWidth(ContractsAdapter.this.activity)) / 4.5d;
                    layoutParams.width = (int) windowWidth;
                    double d = windowWidth / 3.0d;
                    layoutParams.height = (int) (4.0d * d);
                    this.layout.setLayoutParams(layoutParams);
                    if (UiUtils.getWindowWidth(ContractsAdapter.this.activity) <= 720) {
                        ViewGroup.LayoutParams layoutParams2 = this.nameIcon.getLayoutParams();
                        int i = (int) (d * 2.0d);
                        layoutParams2.width = i;
                        layoutParams2.height = i;
                        this.nameIcon.setLayoutParams(layoutParams2);
                        TextView textView = this.nameIcon;
                        textView.setTextSize((textView.getTextSize() / 3.0f) * 2.0f);
                        TextView textView2 = this.name;
                        textView2.setTextSize((textView2.getTextSize() / 3.0f) * 2.0f);
                    }
                }
            }
        }
    }

    /* renamed from: a */
    private void m7683a() {
        ShareTripDialogCache.getInstance().loadingTrustedContacts(new ShareTripDialogCache.RequestCallback<SfContactsManageModel>() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (ShareFragment4Contracts.this.getActivity() != null && ShareFragment4Contracts.this.f11358a != null) {
                    if (sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                        ShareFragment4Contracts.this.m7688a((List<SfContactsModel>) null);
                        return;
                    }
                    ShareFragment4Contracts.this.setContracts(sfContactsManageModel.datas.contacts);
                    ShareFragment4Contracts.this.m7688a(sfContactsManageModel.datas.contacts);
                }
            }

            public void onFail(SfContactsManageModel sfContactsManageModel) {
                if (sfContactsManageModel != null && ShareFragment4Contracts.this.getActivity() != null && ShareFragment4Contracts.this.f11358a != null) {
                    ShareFragment4Contracts.this.f11358a.setAdapter(new ContractsAdapter(ShareFragment4Contracts.this.getActivity(), new ArrayList()));
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7688a(List<SfContactsModel> list) {
        if (list != null) {
            this.f11358a.setAdapter(new ContractsAdapter(getActivity(), list));
        } else {
            this.f11358a.setAdapter(new ContractsAdapter(getActivity(), new ArrayList()));
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7687a(SfContactsModel sfContactsModel) {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null && order.getOid() != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(sfContactsModel);
            SfContactsStore.getInstance().share(arrayList, CarOrderHelper.getOrder().getOid(), new SfResponseListener<SfShareResponse>() {
                public void onSuccess(SfShareResponse sfShareResponse) {
                    if (sfShareResponse.data != null) {
                        if (sfShareResponse.data.needAreaCodeList == null || sfShareResponse.data.needAreaCodeList.isEmpty()) {
                            if (!TextUtils.isEmpty(sfShareResponse.data.successText)) {
                                ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.data.successText);
                            }
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_DISMISS_BUBBLE);
                            BaseEventPublisher.getPublisher().publish(BaseEventKeys.SafeToolkit.EVENT_REQUEST_JARVIS);
                        } else {
                            SfContactsManageModel sfContactsManageModel = new SfContactsManageModel();
                            sfContactsManageModel.datas = new SfContactsManageModel.SfContactsDatas();
                            sfContactsManageModel.datas.needAreaCodeContacts = sfShareResponse.data.needAreaCodeList;
                            sfContactsManageModel.datas.defaultAreaCode = sfShareResponse.data.defaultAreacode;
                            SafeToolKit.getIns().startAreaCodeAddPage(SfContextHelper.getContext(), 0, 1, sfContactsManageModel);
                        }
                    }
                    ShareFragment4Contracts.this.dismiss();
                }

                public void onFail(int i, String str) {
                    ToastHelper.showLongCompleted(SfContextHelper.getContext(), str);
                }

                public void onError(SfShareResponse sfShareResponse) {
                    if (sfShareResponse != null) {
                        ToastHelper.showLongCompleted(SfContextHelper.getContext(), sfShareResponse.errmsg);
                    }
                }
            });
        }
    }
}

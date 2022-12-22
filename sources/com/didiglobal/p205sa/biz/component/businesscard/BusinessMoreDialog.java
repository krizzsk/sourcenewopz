package com.didiglobal.p205sa.biz.component.businesscard;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.TextView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.raven.config.RavenKey;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.app.business.SaBusinessManager;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import com.didi.travel.psnger.common.net.base.ParamKeys;
import com.didiglobal.omegasdkadapter.OmegaSDKAdapter;
import com.didiglobal.p205sa.biz.component.ComponentType;
import com.didiglobal.p205sa.biz.component.businesscard.model.BusinessCardModel;
import com.didiglobal.p205sa.biz.component.businesscard.view.DialogAdapter;
import com.didiglobal.p205sa.biz.util.UiUtils;
import com.google.android.material.bottomsheet.BottomSheetBehavior;
import com.google.android.material.bottomsheet.BottomSheetDialog;
import com.google.android.material.bottomsheet.BottomSheetDialogFragment;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;
import com.taxis99.R;
import java.util.HashMap;
import java.util.Map;

/* renamed from: com.didiglobal.sa.biz.component.businesscard.BusinessMoreDialog */
public class BusinessMoreDialog extends BottomSheetDialogFragment {

    /* renamed from: a */
    BusinessCardModel f50815a;

    /* renamed from: b */
    int f50816b;

    /* renamed from: c */
    private TextView f50817c;

    /* renamed from: d */
    private RecyclerView f50818d;

    /* renamed from: e */
    private DialogAdapter f50819e;

    /* renamed from: f */
    private BottomSheetBehavior f50820f;

    /* renamed from: g */
    private long f50821g = 0;

    public void onViewCreated(View view, Bundle bundle) {
        super.onViewCreated(view, bundle);
    }

    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        setStyle(0, R.style.CustomBottomSheetDialogTheme);
    }

    public BusinessMoreDialog(BusinessCardModel businessCardModel) {
        this.f50815a = businessCardModel;
    }

    /* access modifiers changed from: protected */
    public void initView(View view) {
        this.f50817c = (TextView) view.findViewById(R.id.tv_title);
        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rv_business);
        this.f50818d = recyclerView;
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        DialogAdapter dialogAdapter = new DialogAdapter();
        this.f50819e = dialogAdapter;
        this.f50818d.setAdapter(dialogAdapter);
        this.f50819e.setOnItemClickListener(new DialogAdapter.OnItemClickListener() {
            public void onItemClick(int i, BusinessCardModel.BusinessMenuModel businessMenuModel) {
                BusinessMoreDialog.this.m36474a(businessMenuModel);
                Bundle bundle = new Bundle();
                bundle.putString("action_type", "diamond");
                HashMap hashMap = new HashMap();
                hashMap.put(ParamKeys.PARAM_COMPLAIN_ENTRY, "sa");
                hashMap.put("entry_2", "sa_businesscard");
                bundle.putSerializable("sa_entry", hashMap);
                SaBusinessManager.Companion.getIns().switchBusiness(businessMenuModel.groupType, businessMenuModel.schema, bundle);
                BusinessMoreDialog.this.dismiss();
            }
        });
        view.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                BusinessMoreDialog.this.dismiss();
            }
        });
        this.f50816b = (UiUtils.INSTANCE.getScreenHeight((Context) DIDIApplication.getAppContext()) - UiUtils.INSTANCE.dip2px(DIDIApplication.getAppContext(), 20.0f)) - UiUtils.INSTANCE.getStatusBarHeight(DIDIApplication.getAppContext());
        view.setLayoutParams(new FrameLayout.LayoutParams(-1, this.f50816b));
        m36475a(this.f50815a);
    }

    /* renamed from: a */
    private void m36475a(BusinessCardModel businessCardModel) {
        if (businessCardModel != null) {
            if (businessCardModel.config != null) {
                businessCardModel.config.title.bindTextView(this.f50817c);
            }
            this.f50819e.setData(businessCardModel.businessMenu);
        }
    }

    public Dialog onCreateDialog(Bundle bundle) {
        BottomSheetDialog bottomSheetDialog = (BottomSheetDialog) super.onCreateDialog(bundle);
        View inflate = View.inflate(getContext(), R.layout.business_more_dialog, (ViewGroup) null);
        bottomSheetDialog.setContentView(inflate);
        Window window = bottomSheetDialog.getWindow();
        if (window != null) {
            window.setWindowAnimations(R.style.BottomSheet);
        }
        initView(inflate);
        this.f50820f = BottomSheetBehavior.from((View) inflate.getParent());
        return bottomSheetDialog;
    }

    public void onStart() {
        super.onStart();
        this.f50820f.setPeekHeight(this.f50816b);
        this.f50820f.setState(3);
        this.f50821g = System.currentTimeMillis();
    }

    public void onStop() {
        super.onStop();
        addTrack();
    }

    public void addTrack() {
        HashMap hashMap = new HashMap();
        hashMap.put("k", "notice");
        hashMap.put(RavenKey.VERSION, "showtime");
        hashMap.put("time", Long.valueOf(System.currentTimeMillis() - this.f50821g));
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_businesscard_pullup_time_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m36474a(BusinessCardModel.BusinessMenuModel businessMenuModel) {
        HashMap hashMap = new HashMap();
        hashMap.put("tag", "sa_pullup");
        hashMap.put(ParamConst.PARAM_MODULE_ID, ComponentType.COMPONENT_BUSINESS_CARD);
        hashMap.put("size", Integer.valueOf(businessMenuModel.style));
        try {
            HashMap hashMap2 = (HashMap) new Gson().fromJson((JsonElement) businessMenuModel.log_data, new TypeToken<HashMap<String, Object>>() {
            }.getType());
            if (hashMap2 != null) {
                hashMap.putAll(hashMap2);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        OmegaSDKAdapter.trackEvent("ibt_gp_sa_icons_ck", (Map<String, Object>) hashMap);
    }
}

package com.didi.component.splitfare.areacode;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.fragment.BaseDialogFragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.splitfare.contactmanage.GlobalContactsModel;
import com.didi.component.splitfare.model.UpdateSplitFarePartner;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.safetoolkit.business.areaCode.AreaCodeAddDialog;
import com.didi.safetoolkit.business.areaCode.GuideHeadVH;
import com.didi.sdk.apm.SystemUtils;
import com.taxis99.R;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaCodeMandatoryGuideActivity extends AbsLoadingAppCompatActivity implements View.OnClickListener {
    public static final String ADDED_AREA_CODE_CONTACTS = "added_area_code_contacts";
    public static final int AREA_CODE_GUIDE_REQUEST_CODE = 1;
    public static final int AREA_CODE_GUIDE_RESULT_CODE = 1;
    public static final String G_CONSTANT_MANAGER_KEY = "g_constant_manager_key";

    /* renamed from: a */
    private RecyclerView f15867a;

    /* renamed from: b */
    private TextView f15868b;

    /* renamed from: c */
    private TextView f15869c;

    /* renamed from: d */
    private ImageView f15870d;

    /* renamed from: e */
    private UpdateSplitFarePartner.SplitFareFailGroup f15871e;

    /* renamed from: f */
    private AreaCodeAddDialog f15872f;

    /* renamed from: g */
    private List<UpdateSplitFarePartner.AreaCodeUserInfo> f15873g;

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        parseBundle(getIntent().getExtras());
        setContentView((int) R.layout.g_mandatory_guide_activity);
        findViews();
        setListener();
        initData();
        HashMap hashMap = new HashMap(1, 1.0f);
        hashMap.put("source", 2);
        GlobalOmegaUtils.trackEvent("gd_askAddAreaCode_view_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f15871e = (UpdateSplitFarePartner.SplitFareFailGroup) bundle.getSerializable(G_CONSTANT_MANAGER_KEY);
        }
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f15867a = (RecyclerView) findViewById(R.id.rv_contacts_view);
        this.f15868b = (TextView) findViewById(R.id.manually_add_button);
        this.f15869c = (TextView) findViewById(R.id.auto_add_button);
        this.f15870d = (ImageView) findViewById(R.id.sf_left_btn);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f15869c.setOnClickListener(this);
        this.f15868b.setOnClickListener(this);
        this.f15870d.setOnClickListener(this);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        if (i == 1 && i2 == 1) {
            setResult(1, intent);
            finish();
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        if (!m11578b(this.f15871e)) {
            this.f15869c.setText(getResources().getString(R.string.sf_add_automatic, new Object[]{this.f15871e.areaCode}));
            this.f15867a.setLayoutManager(new LinearLayoutManager(this, 1, false));
            this.f15867a.addItemDecoration(new AreaCodeDividerDecoration(this));
            this.f15867a.setAdapter(new MandatoryGuideAdapter(this, this.f15871e));
            setContactsList(this.f15871e.contactList);
        }
    }

    public void setContactsList(List<UpdateSplitFarePartner.AreaCodeUserInfo> list) {
        if (list == null) {
            list = new ArrayList<>();
        }
        this.f15873g = list;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.manually_add_button) {
            m11574a();
        } else if (view.getId() == R.id.auto_add_button) {
            m11577b();
        } else {
            onBackPressed();
        }
    }

    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("added_area_code_contacts", (Serializable) this.f15873g);
        setResult(1, intent);
        finish();
    }

    /* renamed from: a */
    private void m11574a() {
        Intent intent = new Intent(this, AreaCodeManuallyActivity.class);
        intent.putExtra("manually_add_code_key", this.f15871e);
        startActivityForResult(intent, 1);
    }

    /* renamed from: b */
    private void m11577b() {
        if (!m11578b(this.f15871e)) {
            AreaCodeAddDialog.Builder builder = new AreaCodeAddDialog.Builder(this);
            if (this.f15872f == null) {
                builder.setContent(getString(R.string.g_add_area_code_sec_confirm_hint, new Object[]{this.f15871e.areaCode})).setCancelable(false).setListener(new AreaCodeAddDialog.Builder.DialogListener() {
                    public void onNegativeClick(BaseDialogFragment baseDialogFragment) {
                        baseDialogFragment.dismiss();
                    }

                    public void onPositiveClick(BaseDialogFragment baseDialogFragment) {
                        AreaCodeMandatoryGuideActivity.this.m11579c();
                    }
                });
                this.f15872f = builder.create();
            }
            this.f15872f.show(getSupportFragmentManager(), "");
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m11579c() {
        showLoading();
        ArrayList<UpdateSplitFarePartner.AreaCodeUserInfo> arrayList = new ArrayList<>(this.f15873g);
        for (UpdateSplitFarePartner.AreaCodeUserInfo areaCodeUserInfo : arrayList) {
            StringBuilder sb = new StringBuilder();
            sb.append(TextUtils.isEmpty(areaCodeUserInfo.countryCode) ? "" : areaCodeUserInfo.countryCode);
            sb.append(this.f15871e.areaCode);
            sb.append(areaCodeUserInfo.originPhone);
            areaCodeUserInfo.phone = sb.toString();
        }
        Intent intent = new Intent();
        intent.putExtra("added_area_code_contacts", arrayList);
        setResult(1, intent);
        m11580d();
    }

    /* renamed from: d */
    private void m11580d() {
        AreaCodeAddDialog areaCodeAddDialog = this.f15872f;
        if (areaCodeAddDialog != null && areaCodeAddDialog.isShowing()) {
            this.f15872f.dismiss();
        }
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static boolean m11578b(UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup) {
        return splitFareFailGroup == null || splitFareFailGroup.contactList == null || splitFareFailGroup.contactList.isEmpty() || TextUtils.isEmpty(splitFareFailGroup.areaCode);
    }

    public View getFallbackView() {
        AreaCodeAddDialog areaCodeAddDialog = this.f15872f;
        if (areaCodeAddDialog == null || areaCodeAddDialog.getLoadingView() == null) {
            return null;
        }
        return this.f15872f.getLoadingView();
    }

    private static class MandatoryGuideAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
        private static final int CONTACTS = 2;
        private static final int HEAD = 1;
        private Context context;
        private UpdateSplitFarePartner.SplitFareFailGroup model;

        public int getItemViewType(int i) {
            return i == 0 ? 1 : 2;
        }

        public MandatoryGuideAdapter(Context context2, UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup) {
            this.context = context2;
            this.model = splitFareFailGroup;
        }

        public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
            if (i == 1) {
                return new GuideHeadVH(viewGroup);
            }
            return new GlobalContactInfoBaseVH4Guide(viewGroup);
        }

        public void onBindViewHolder(RecyclerView.ViewHolder viewHolder, int i) {
            if (getItemViewType(i) == 1) {
                if (!AreaCodeMandatoryGuideActivity.m11578b(this.model)) {
                    ((GuideHeadVH) viewHolder).setData(this.model.title, this.model.subTitle);
                }
            } else if (!AreaCodeMandatoryGuideActivity.m11578b(this.model) && this.model.contactList.size() > 0) {
                GlobalContactsModel globalContactsModel = new GlobalContactsModel();
                int i2 = i - 1;
                globalContactsModel.name = this.model.contactList.get(i2).name;
                globalContactsModel.phone = this.model.contactList.get(i2).phone;
                ((GlobalContactInfoBaseVH4Guide) viewHolder).setData(globalContactsModel);
            }
        }

        public int getItemCount() {
            UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup = this.model;
            if (splitFareFailGroup == null || splitFareFailGroup.contactList == null) {
                return 1;
            }
            return this.model.contactList.size() + 1;
        }
    }
}

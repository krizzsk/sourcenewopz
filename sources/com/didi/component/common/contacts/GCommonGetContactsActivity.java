package com.didi.component.common.contacts;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.android.didi.safetoolkit.activity.permisstion.AuthorizationInfo;
import com.android.didi.safetoolkit.activity.permisstion.PermissionToolsCompat;
import com.android.didi.safetoolkit.activity.permisstion.callback.IPermissionRequest;
import com.android.didi.safetoolkit.activity.permisstion.callback.PermissionCallback;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.common.contacts.GCommonContactsAdapter;
import com.didi.component.common.util.CollectionUtils;
import com.didi.global.globaluikit.LEGOUICreator;
import com.didi.global.globaluikit.callback.LEGOBtnTextAndCallback;
import com.didi.global.globaluikit.callback.LEGOOnAntiShakeClickListener;
import com.didi.global.globaluikit.drawer.LEGODrawer;
import com.didi.global.globaluikit.drawer.templatemodel.LEGODrawerModel1;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.safetoolkit.business.contacts.SimpleDividerDecoration;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ResourcesHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.taxis99.R;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class GCommonGetContactsActivity extends AbsLoadingAppCompatActivity {

    /* renamed from: a */
    private static final String f11501a = "GCommonGetContactsActivity";

    /* renamed from: b */
    private static final String f11502b = "threshold";

    /* renamed from: c */
    private static final String f11503c = "getcount";

    /* renamed from: d */
    private ViewGroup f11504d;

    /* renamed from: e */
    private RecyclerView f11505e;

    /* renamed from: f */
    private EditText f11506f;

    /* renamed from: g */
    private boolean f11507g = false;

    /* renamed from: h */
    private ImageView f11508h;

    /* renamed from: i */
    private TextView f11509i;

    /* renamed from: j */
    private GCommonContactsCallback f11510j;
    /* access modifiers changed from: private */

    /* renamed from: k */
    public IGCommonContactsStore f11511k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public GCommonContactsAdapter f11512l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public ArrayList<GCommonContactsModel> f11513m;
    /* access modifiers changed from: private */

    /* renamed from: n */
    public LEGODrawer f11514n;

    /* renamed from: o */
    private View f11515o;

    /* renamed from: p */
    private TextView f11516p;

    /* renamed from: q */
    private PermissionToolsCompat f11517q;

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m7791a(List<GCommonContactsModel> list) {
    }

    public View getFallbackView() {
        return null;
    }

    public static Intent getIntent(Context context, int i) {
        Intent intent = new Intent(context, GCommonGetContactsActivity.class);
        intent.putExtra(f11503c, i);
        return intent;
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        this.f11517q = new PermissionToolsCompat(this);
        super.onCreate(bundle);
        setContentView((int) R.layout.activity_g_common_get_contacts);
        m7788a();
        m7793b();
        m7795c();
        m7797d();
    }

    /* renamed from: a */
    private void m7788a() {
        this.f11504d = (ViewGroup) findViewById(R.id.list_layout);
        this.f11508h = (ImageView) findViewById(R.id.title_bar_back_img);
        this.f11509i = (TextView) findViewById(R.id.title_bar_text);
        this.f11506f = (EditText) findViewById(R.id.search_et);
        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.rv);
        this.f11505e = recyclerView;
        recyclerView.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f11505e.addItemDecoration(new SimpleDividerDecoration(this));
        try {
            this.f11509i.setText(getResources().getString(R.string.sf_contacts));
            this.f11506f.setHint(getResources().getString(R.string.sf_search_contacts));
        } catch (Exception e) {
            e.printStackTrace();
        }
        this.f11506f.setCursorVisible(true);
        this.f11515o = findViewById(R.id.bottom_layout);
        TextView textView = (TextView) findViewById(R.id.bottom_btn);
        this.f11516p = textView;
        textView.setText(getResources().getString(R.string.GRider_Req_Join_the_UucQ));
    }

    /* renamed from: b */
    private void m7793b() {
        this.f11516p.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GCommonGetContactsActivity.this.m7806i();
            }
        });
        this.f11508h.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                GCommonGetContactsActivity.this.finish();
            }
        });
        this.f11506f.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                GCommonGetContactsActivity.this.f11511k.getMatchList(editable.toString(), new GCommonContactsCallback() {
                    public void onFailed(String str) {
                    }

                    public void onSucceed(List<GCommonContactsModel> list) {
                        GCommonGetContactsActivity.this.f11512l.updateSystemData(list);
                    }
                });
            }
        });
    }

    /* renamed from: c */
    private void m7795c() {
        this.f11511k = GCommonContactsStore.getInstance();
        GCommonContactsAdapter gCommonContactsAdapter = new GCommonContactsAdapter();
        this.f11512l = gCommonContactsAdapter;
        this.f11505e.setAdapter(gCommonContactsAdapter);
        this.f11510j = new GCommonContactsCallback() {
            public void onSucceed(List<GCommonContactsModel> list) {
                GCommonGetContactsActivity.this.hideLoading();
                GCommonGetContactsActivity.this.m7791a(list);
                GCommonGetContactsActivity.this.f11512l.addData(list);
            }

            public void onFailed(String str) {
                GCommonGetContactsActivity.this.hideLoading();
                GCommonGetContactsActivity.this.m7791a((List<GCommonContactsModel>) null);
            }
        };
        this.f11513m = new ArrayList<>();
        this.f11512l.setListener(new GCommonContactsAdapter.GCommonCheckedChangedListener() {
            public void onCheckedChanged(GCommonContactsModel gCommonContactsModel, boolean z) {
                if (GCommonGetContactsActivity.this.m7802g() == 1) {
                    List<GCommonContactsModel> systemDatas = GCommonGetContactsActivity.this.f11512l.getSystemDatas();
                    if (!CollectionUtils.isEmpty((Collection) systemDatas)) {
                        for (int i = 0; i < systemDatas.size(); i++) {
                            GCommonContactsModel gCommonContactsModel2 = systemDatas.get(i);
                            if (gCommonContactsModel2 != null && !gCommonContactsModel2.equals(gCommonContactsModel) && gCommonContactsModel2.checked) {
                                gCommonContactsModel2.checked = false;
                                GCommonGetContactsActivity.this.f11512l.notifyItemChanged(i);
                                GCommonGetContactsActivity.this.f11513m.clear();
                            }
                        }
                    }
                }
                if (z) {
                    GCommonGetContactsActivity.this.f11513m.add(gCommonContactsModel);
                } else {
                    GCommonGetContactsActivity.this.f11513m.remove(gCommonContactsModel);
                }
                GCommonGetContactsActivity.this.m7799e();
                GCommonGetContactsActivity gCommonGetContactsActivity = GCommonGetContactsActivity.this;
                gCommonGetContactsActivity.onSelectDateChanged(gCommonGetContactsActivity.f11513m.size());
            }
        });
    }

    /* renamed from: d */
    private void m7797d() {
        final LEGODrawerModel1 lEGODrawerModel1 = new LEGODrawerModel1(ResourcesHelper.getString(this, R.string.GRider_adjustment_Privacy_Notice_ibyJ), new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.GRider_adjustment_Agree_tHbn), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GCommonGetContactsActivity.this.f11514n.dismiss();
                GCommonGetContactsActivity.this.m7804h();
            }
        }));
        lEGODrawerModel1.addMinorBtn(new LEGOBtnTextAndCallback(ResourcesHelper.getString(this, R.string.GRider_adjustment_Refusal_SMsG), new LEGOOnAntiShakeClickListener() {
            public void onAntiShakeClick(View view) {
                GCommonGetContactsActivity.this.finish();
            }
        }));
        lEGODrawerModel1.setSubTitle(ResourcesHelper.getString(this, R.string.GRider_adjustment_To_facilitate_pGOr)).setIsShowCloseImg(false).setClickOutsideCanCancel(false);
        lEGODrawerModel1.setmBackPressedEnabled(false);
        UiThreadHandler.getsUiHandler().postDelayed(new Runnable() {
            public void run() {
                GCommonGetContactsActivity gCommonGetContactsActivity = GCommonGetContactsActivity.this;
                LEGODrawer unused = gCommonGetContactsActivity.f11514n = LEGOUICreator.showDrawerTemplate(gCommonGetContactsActivity, lEGODrawerModel1);
            }
        }, 1000);
    }

    public void onResume() {
        super.onResume();
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m7799e() {
        ArrayList<GCommonContactsModel> arrayList = this.f11513m;
        if (arrayList != null) {
            if (arrayList.size() >= m7800f()) {
                this.f11512l.updateCheckable(false);
            } else {
                this.f11512l.updateCheckable(true);
            }
        }
    }

    /* renamed from: f */
    private int m7800f() {
        if (getIntent().getIntExtra("threshold", 0) != 0) {
            return getIntent().getIntExtra("threshold", Integer.MAX_VALUE);
        }
        return Integer.MAX_VALUE;
    }

    /* access modifiers changed from: private */
    /* renamed from: g */
    public int m7802g() {
        if (getIntent().getIntExtra(f11503c, 0) != 0) {
            return getIntent().getIntExtra(f11503c, 1);
        }
        return 1;
    }

    /* access modifiers changed from: protected */
    public void showNoPermissionPage(boolean z) {
        this.f11507g = z;
    }

    /* access modifiers changed from: protected */
    public void showContractList() {
        this.f11504d.setVisibility(0);
        showLoading();
        getDataList();
    }

    /* access modifiers changed from: private */
    /* renamed from: h */
    public void m7804h() {
        this.f11517q.requestPermission(new PermissionCallback() {
            public void onBeforeGranted(List<AuthorizationInfo> list, IPermissionRequest iPermissionRequest) {
                iPermissionRequest.proceed();
            }

            public void onGranted(List<AuthorizationInfo> list) {
                GCommonGetContactsActivity.this.showContractList();
            }

            public void onRefuse(List<AuthorizationInfo> list) {
                AuthorizationInfo authorizationInfo;
                if (list != null && list.size() != 0 && (authorizationInfo = list.get(0)) != null) {
                    GCommonGetContactsActivity.this.showNoPermissionPage(authorizationInfo.isDoNotAskAgain());
                }
            }
        }, Permission.READ_CONTACTS);
    }

    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) {
        super.onRequestPermissionsResult(i, strArr, iArr);
        this.f11517q.onRequestPermissionsResult(i, strArr, iArr);
    }

    /* access modifiers changed from: private */
    /* renamed from: i */
    public void m7806i() {
        Intent intent = new Intent();
        Bundle bundle = new Bundle();
        ArrayList<GCommonContactsModel> arrayList = this.f11513m;
        if (arrayList != null) {
            bundle.putSerializable("list", arrayList);
        }
        intent.putExtra("data", bundle);
        setResult(-1, intent);
        finish();
    }

    public void onDestroy() {
        super.onDestroy();
        this.f11511k.clearData();
    }

    /* access modifiers changed from: protected */
    public void getDataList() {
        this.f11511k.getSystemContacts(this.f11510j);
    }

    /* access modifiers changed from: protected */
    public void onPermissionRefused(boolean z) {
        showNoPermissionPage(z);
    }

    /* access modifiers changed from: protected */
    public void onSelectDateChanged(int i) {
        if (i > 0) {
            this.f11515o.setVisibility(0);
        } else {
            this.f11515o.setVisibility(8);
        }
    }
}

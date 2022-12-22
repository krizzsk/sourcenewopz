package com.didi.safetoolkit.business.contacts;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.api.SfConstant;
import com.didi.safetoolkit.apollo.SfApolloUtil;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfContactsManageStore;
import com.didi.safetoolkit.business.contacts.viewhoder.SfContactInfoShowVH;
import com.didi.safetoolkit.business.sdk.SafeToolKit;
import com.didi.safetoolkit.business.share.controller.SfShareOptController;
import com.didi.safetoolkit.model.SfContactsModel;
import com.didi.safetoolkit.util.SfCollectionUtil;
import com.didi.safetoolkit.util.SfLog;
import com.didi.safetoolkit.util.SfStringGetter;
import com.didi.safetoolkit.widget.SfCommonTitleBar;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Collection;

public class SfContactsManageActivity extends BaseSafeToolkitActivity {
    public static final int MAX_CONTACTS_NUM = 5;
    public static final int SF_GET_CONTACTS_REQUESTCODE = 1;
    public static final String TAG = "contact";

    /* renamed from: a */
    private SfCommonTitleBar f34284a;

    /* renamed from: b */
    private RecyclerView f34285b;

    /* renamed from: c */
    private View f34286c;

    /* renamed from: d */
    private TextView f34287d;

    /* renamed from: e */
    private TextView f34288e;

    /* renamed from: f */
    private TextView f34289f;
    /* access modifiers changed from: private */

    /* renamed from: g */
    public SfContactsManageAdapter f34290g;
    /* access modifiers changed from: private */

    /* renamed from: h */
    public SfContactsManageStore f34291h;

    /* renamed from: i */
    private View f34292i;

    /* renamed from: j */
    private View f34293j;

    /* renamed from: k */
    private TextView f34294k;
    /* access modifiers changed from: private */

    /* renamed from: l */
    public SfContactsManageModel f34295l;

    /* renamed from: m */
    private boolean f34296m = false;

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_layout_act_manage_contacts;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34284a = (SfCommonTitleBar) findViewById(R.id.sf_manage_contacts_title_bar);
        this.f34285b = (RecyclerView) findViewById(R.id.sf_added_trusted_contact_list);
        this.f34286c = findViewById(R.id.sf_trusted_contact_guide_view);
        this.f34287d = (TextView) findViewById(R.id.sf_add_trusted_contact_title);
        this.f34288e = (TextView) findViewById(R.id.sf_add_trusted_contact_intro);
        this.f34289f = (TextView) findViewById(R.id.sf_add_trusted_contact_btn);
        this.f34292i = findViewById(R.id.sf_trusted_contact_error_view);
        this.f34293j = findViewById(R.id.sf_error_try_again);
        this.f34294k = (TextView) findViewById(R.id.sf_error_again_text);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f34296m = bundle.getInt("target", 2) == 3;
        }
    }

    /* access modifiers changed from: protected */
    public void initObjects() {
        super.initObjects();
        this.f34285b.setLayoutManager(new LinearLayoutManager(this, 1, false));
        this.f34285b.addItemDecoration(new SimpleDividerDecoration(this));
        this.f34291h = new SfContactsManageStore();
        SfContactsManageAdapter sfContactsManageAdapter = new SfContactsManageAdapter();
        this.f34290g = sfContactsManageAdapter;
        this.f34285b.setAdapter(sfContactsManageAdapter);
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f34284a.setTitleText(SfStringGetter.getString(R.string.sf_trusted_contacts_title));
        this.f34287d.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_loved));
        this.f34288e.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_content));
        this.f34289f.setText(SfStringGetter.getString(R.string.sf_trusted_contacts_add));
        this.f34294k.setText(SfStringGetter.getString(R.string.sf_error_try_again));
        m24260a();
        showPDialog();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24260a() {
        showPDialog();
        this.f34291h.getTrustedContacts(new SfContactsManageStore.Callback() {
            public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageModel unused = SfContactsManageActivity.this.f34295l = sfContactsManageModel;
                    if (sfContactsManageModel == null || !sfContactsManageModel.isAvailable() || sfContactsManageModel.datas == null || SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                        SfContactsManageActivity.this.m24268d();
                        return;
                    }
                    SfContactsManageActivity.this.m24271e();
                    SfContactsManageActivity.this.f34290g.setData(sfContactsManageModel.datas.contacts);
                    SfContactsManageActivity.this.f34290g.notifyDataSetChanged();
                }
            }

            public void onError(SfContactsManageModel sfContactsManageModel) {
                if (!SfContactsManageActivity.this.isDestory()) {
                    SfContactsManageModel unused = SfContactsManageActivity.this.f34295l = null;
                    SfContactsManageActivity.this.closePDialog();
                    SfContactsManageActivity.this.m24266c();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public void m24265b() {
        this.f34292i.setVisibility(8);
        this.f34286c.setVisibility(8);
        this.f34285b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m24266c() {
        this.f34292i.setVisibility(0);
        this.f34286c.setVisibility(8);
        this.f34285b.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m24268d() {
        this.f34286c.setVisibility(0);
        this.f34285b.setVisibility(8);
        this.f34292i.setVisibility(8);
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m24271e() {
        this.f34285b.setVisibility(0);
        this.f34286c.setVisibility(8);
        this.f34292i.setVisibility(8);
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f34284a.setLeftBtnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.finish();
            }
        });
        this.f34289f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    SafeToolKit.getIns().startContactsManagerOptPage(SfContactsManageActivity.this, 1, 5);
                } else {
                    SafeToolKit.getIns().startGetContactsPage(SfContactsManageActivity.this, 1, 5);
                }
            }
        });
        this.f34290g.setAddContactVHClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (SfApolloUtil.isAddContactOpt()) {
                    SafeToolKit ins = SafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startContactsManagerOptPage(sfContactsManageActivity, 1, sfContactsManageActivity.m24272f());
                    return;
                }
                SafeToolKit ins2 = SafeToolKit.getIns();
                SfContactsManageActivity sfContactsManageActivity2 = SfContactsManageActivity.this;
                ins2.startGetContactsPage(sfContactsManageActivity2, 1, sfContactsManageActivity2.m24272f());
            }
        });
        this.f34290g.setDeleteListener(new SfContactInfoShowVH.Callback() {
            public void deleteDialogClickPerform(String str) {
                SfContactsManageActivity.this.showPDialog();
                SfContactsManageActivity.this.f34291h.deleteContact(str, new SfContactsManageStore.Callback() {
                    public void onSuccess(SfContactsManageModel sfContactsManageModel) {
                        if (!SfContactsManageActivity.this.isDestory()) {
                            SfContactsManageActivity.this.closePDialog();
                            SfContactsManageModel unused = SfContactsManageActivity.this.f34295l = sfContactsManageModel;
                            if (sfContactsManageModel.datas != null) {
                                SfContactsManageActivity.this.m24263a(SfConstant.SfAction.ACTION_DELETE_CONTACT_SUCCESS);
                                if (SfCollectionUtil.isEmpty((Collection) sfContactsManageModel.datas.contacts)) {
                                    SfContactsManageActivity.this.m24268d();
                                }
                                SfContactsManageActivity.this.f34290g.setData(sfContactsManageModel.datas.contacts);
                                SfContactsManageActivity.this.f34290g.notifyDataSetChanged();
                                SfLog.m24401d("lxs delete success!");
                            }
                        }
                    }

                    public void onError(SfContactsManageModel sfContactsManageModel) {
                        SfContactsManageModel unused = SfContactsManageActivity.this.f34295l = null;
                        SfContactsManageActivity.this.closePDialog();
                        SfContactsManageActivity.this.m24263a(SfConstant.SfAction.ACTION_DELETE_CONTACTS_FAIL);
                    }
                });
            }

            public void onAddAreaCodeClick(SfContactsModel sfContactsModel) {
                if (SfContactsManageActivity.this.f34295l != null && SfContactsManageActivity.this.f34295l.datas != null) {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(sfContactsModel);
                    SfContactsManageActivity.this.f34295l.datas.needAreaCodeContacts = arrayList;
                    SafeToolKit ins = SafeToolKit.getIns();
                    SfContactsManageActivity sfContactsManageActivity = SfContactsManageActivity.this;
                    ins.startAreaCodeAddPage(sfContactsManageActivity, 151, 2, sfContactsManageActivity.f34295l);
                    SfContactsManageModel unused = SfContactsManageActivity.this.f34295l = null;
                }
            }
        });
        this.f34293j.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfContactsManageActivity.this.m24265b();
                SfContactsManageActivity.this.m24260a();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public int m24272f() {
        int dataSize = this.f34291h.getDataSize();
        if (dataSize < 0 || dataSize > 5) {
            return 0;
        }
        return 5 - dataSize;
    }

    /* access modifiers changed from: protected */
    public boolean onActivityResult(int i, int i2, Intent intent, boolean z) {
        Bundle bundleExtra;
        if (i == 1 && i2 == -1) {
            if (intent == null || (bundleExtra = intent.getBundleExtra("data")) == null) {
                return false;
            }
            ArrayList arrayList = (ArrayList) bundleExtra.getSerializable("list");
            if (!SfCollectionUtil.isEmpty((Collection) arrayList)) {
                m24271e();
                this.f34290g.setData(arrayList);
                this.f34290g.notifyDataSetChanged();
                if (this.f34296m) {
                    new SfShareOptController().share(this);
                }
            }
        }
        return super.onActivityResult(i, i2, intent, z);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m24263a(String str) {
        Intent intent = new Intent();
        intent.setAction(str);
        LocalBroadcastManager.getInstance(getContext()).sendBroadcast(intent);
    }

    public View getFallbackView() {
        return this.f34284a.getLoadingFallback();
    }

    public static void startSfManageActivity(Activity activity) {
        Intent intent = new Intent(activity, SfContactsManageActivity.class);
        intent.setFlags(335544320);
        activity.startActivity(intent);
    }
}

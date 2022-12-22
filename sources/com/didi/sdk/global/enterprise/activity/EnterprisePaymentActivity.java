package com.didi.sdk.global.enterprise.activity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.InputFilter;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.commoninterfacelib.statuslightning.StatusBarLightingCompat;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.global.enterprise.activity.EnterprisePaymentListActivity;
import com.didi.sdk.global.enterprise.model.bean.CompanyBean;
import com.didi.sdk.global.enterprise.model.bean.CostCenterBean;
import com.didi.sdk.global.enterprise.model.bean.ProjectBean;
import com.didi.sdk.global.enterprise.model.data.EnterpriseInfo;
import com.didi.sdk.global.enterprise.util.EnterpriseUtil;
import com.didi.sdk.global.util.GlobalOmegaUtils;
import com.taxis99.R;
import java.io.Serializable;

public class EnterprisePaymentActivity extends FragmentActivity {
    public static final String EXTRA_ENTERPRISE_INFO = "ENTERPRISE_INFO";

    /* renamed from: a */
    private static final int f36108a = 1;

    /* renamed from: b */
    private TextView f36109b;

    /* renamed from: c */
    private ImageView f36110c;

    /* renamed from: d */
    private View f36111d;

    /* renamed from: e */
    private View f36112e;

    /* renamed from: f */
    private View f36113f;

    /* renamed from: g */
    private TextView f36114g;

    /* renamed from: h */
    private TextView f36115h;

    /* renamed from: i */
    private TextView f36116i;

    /* renamed from: j */
    private EditText f36117j;

    /* renamed from: k */
    private TextView f36118k;

    /* renamed from: l */
    private TextView f36119l;
    /* access modifiers changed from: private */

    /* renamed from: m */
    public EnterpriseInfo f36120m;

    /* renamed from: n */
    private boolean f36121n = true;
    /* access modifiers changed from: private */

    /* renamed from: o */
    public int f36122o = 1;

    public static void launch(Activity activity, int i) {
        activity.startActivityForResult(new Intent(activity, EnterprisePaymentActivity.class), i);
    }

    public static void launch(Fragment fragment, int i) {
        fragment.startActivityForResult(new Intent(fragment.getContext(), EnterprisePaymentActivity.class), i);
    }

    public static void launch(Activity activity, int i, EnterpriseInfo enterpriseInfo) {
        Intent intent = new Intent(activity, EnterprisePaymentActivity.class);
        intent.putExtra(EXTRA_ENTERPRISE_INFO, enterpriseInfo);
        activity.startActivityForResult(intent, i);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        m25512a();
        super.onCreate(bundle);
        overridePendingTransition(R.anim.one_payment_in_from_right, R.anim.one_payment_out_to_left);
        setContentView((int) R.layout.one_payment_activity_enterprise_payment);
        m25515b();
        m25517c();
    }

    public void finish() {
        super.finish();
        overridePendingTransition(R.anim.one_payment_in_from_left, R.anim.one_payment_out_to_right);
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        if (i2 == -1) {
            Serializable serializableExtra = intent.getSerializableExtra(EnterprisePaymentListActivity.EXTRA_RESULT);
            if (serializableExtra instanceof CompanyBean) {
                CompanyBean companyBean = (CompanyBean) serializableExtra;
                this.f36120m.setCompany(companyBean);
                if (companyBean.companyDefault != null) {
                    CostCenterBean costCenterBean = companyBean.companyDefault.costCenter;
                    if (costCenterBean != null) {
                        costCenterBean.isRequired = companyBean.costCenterRequired;
                        this.f36120m.setCostCenter(costCenterBean);
                    }
                    ProjectBean projectBean = companyBean.companyDefault.project;
                    if (projectBean != null) {
                        projectBean.isRequired = companyBean.projectRequired;
                        this.f36120m.setProject(projectBean);
                    }
                } else {
                    this.f36120m.getCostCenter().f36157id = null;
                    this.f36120m.getCostCenter().name = null;
                    this.f36120m.getProject().f36158id = null;
                    this.f36120m.getProject().name = null;
                }
                if (companyBean.comments != null) {
                    this.f36120m.setComment(companyBean.comments);
                }
            } else if (serializableExtra instanceof CostCenterBean) {
                this.f36120m.setCostCenter((CostCenterBean) serializableExtra);
                this.f36120m.getProject().f36158id = null;
                this.f36120m.getProject().name = null;
            } else if (serializableExtra instanceof ProjectBean) {
                this.f36120m.setProject((ProjectBean) serializableExtra);
            }
            m25519d();
        }
    }

    /* renamed from: a */
    private void m25512a() {
        setTheme(R.style.GlobalActivityTheme);
        StatusBarLightingCompat.setStatusBarBgLightning(this, true, getResources().getColor(R.color.white));
    }

    /* renamed from: b */
    private void m25515b() {
        EnterpriseInfo enterpriseInfo = EnterpriseUtil.getEnterpriseInfo();
        this.f36120m = enterpriseInfo;
        if (enterpriseInfo == null) {
            this.f36120m = (EnterpriseInfo) getIntent().getSerializableExtra(EXTRA_ENTERPRISE_INFO);
        }
        if (this.f36120m == null) {
            this.f36120m = new EnterpriseInfo();
        }
        this.f36121n = this.f36120m.isSigned();
    }

    /* renamed from: c */
    private void m25517c() {
        initTitleBar();
        this.f36111d = findViewById(R.id.layout_company);
        this.f36112e = findViewById(R.id.layout_cost_center);
        this.f36113f = findViewById(R.id.layout_project);
        this.f36114g = (TextView) findViewById(R.id.tv_company);
        this.f36115h = (TextView) findViewById(R.id.tv_cost_center);
        this.f36116i = (TextView) findViewById(R.id.tv_project);
        this.f36117j = (EditText) findViewById(R.id.et_comment);
        this.f36118k = (TextView) findViewById(R.id.tv_comment_count);
        this.f36119l = (TextView) findViewById(R.id.btn_continue);
        this.f36111d.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 1;
                launchInfo.phoneNumber = EnterprisePaymentActivity.this.f36120m.getPhone();
                launchInfo.carLevel = EnterprisePaymentActivity.this.f36120m.getCarLevel();
                launchInfo.checkedId = EnterprisePaymentActivity.this.f36120m.getCompany().f36156id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseCompanyBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f36122o);
            }
        });
        this.f36112e.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 2;
                launchInfo.memberId = EnterprisePaymentActivity.this.f36120m.getMemberId();
                launchInfo.companyId = EnterprisePaymentActivity.this.f36120m.getCompany().f36156id;
                launchInfo.checkedId = EnterprisePaymentActivity.this.f36120m.getCostCenter().f36157id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseCostcenterBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f36122o);
            }
        });
        this.f36113f.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentListActivity.LaunchInfo launchInfo = new EnterprisePaymentListActivity.LaunchInfo();
                launchInfo.launchType = 3;
                launchInfo.memberId = EnterprisePaymentActivity.this.f36120m.getMemberId();
                launchInfo.companyId = EnterprisePaymentActivity.this.f36120m.getCompany().f36156id;
                launchInfo.costCenterId = EnterprisePaymentActivity.this.f36120m.getCostCenter().f36157id;
                launchInfo.checkedId = EnterprisePaymentActivity.this.f36120m.getProject().f36158id;
                launchInfo.requestCode = 1;
                EnterprisePaymentListActivity.launch(EnterprisePaymentActivity.this, launchInfo);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseProjectBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f36122o);
            }
        });
        this.f36117j.setText(this.f36120m.getComment().comment);
        EditText editText = this.f36117j;
        editText.setSelection(editText.length());
        this.f36117j.addTextChangedListener(new TextWatcher() {
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
            }

            public void afterTextChanged(Editable editable) {
                EnterprisePaymentActivity.this.m25519d();
            }
        });
        this.f36119l.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentActivity enterprisePaymentActivity = EnterprisePaymentActivity.this;
                GlobalOmegaUtils.trackEnterpriseContinueBtnCK(enterprisePaymentActivity, enterprisePaymentActivity.f36122o);
                EnterprisePaymentActivity.this.m25523f();
            }
        });
        m25519d();
    }

    /* access modifiers changed from: protected */
    public void initTitleBar() {
        this.f36109b = (TextView) findViewById(R.id.tv_title);
        this.f36110c = (ImageView) findViewById(R.id.iv_left);
        this.f36109b.setText(R.string.one_payment_global_enterprise_title);
        this.f36110c.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                EnterprisePaymentActivity.this.m25521e();
            }
        });
    }

    public void onBackPressed() {
        m25521e();
    }

    /* access modifiers changed from: private */
    /* renamed from: d */
    public void m25519d() {
        boolean z = true;
        boolean z2 = !TextUtils.isEmpty(this.f36120m.getCompany().name);
        if (z2) {
            this.f36114g.setText(this.f36120m.getCompany().name);
            m25513a(true);
        } else {
            this.f36114g.setText(R.string.one_payment_global_enterprise_hint_company);
            m25513a(false);
            this.f36120m.getCostCenter().f36157id = null;
            this.f36120m.getCostCenter().name = null;
            this.f36120m.getProject().f36158id = null;
            this.f36120m.getProject().name = null;
        }
        boolean z3 = !TextUtils.isEmpty(this.f36120m.getCostCenter().name);
        if (z3) {
            this.f36115h.setText(this.f36120m.getCostCenter().name);
            m25516b(true);
        } else {
            this.f36115h.setText(R.string.one_payment_global_enterprise_hint_cost_center);
            m25516b(false);
            this.f36120m.getProject().f36158id = null;
            this.f36120m.getProject().name = null;
        }
        boolean z4 = !TextUtils.isEmpty(this.f36120m.getProject().name);
        if (z4) {
            this.f36116i.setText(this.f36120m.getProject().name);
        } else {
            this.f36116i.setText(R.string.one_payment_global_enterprise_hint_project);
        }
        int length = m25511a(this.f36117j.getText().toString()).length();
        int i = this.f36120m.getComment().maxSize;
        if (i > 0) {
            this.f36118k.setText(String.format("%d/%d", new Object[]{Integer.valueOf(length), Integer.valueOf(i)}));
            this.f36118k.setVisibility(0);
            this.f36117j.setFilters(new InputFilter[]{new InputFilter.LengthFilter(i)});
        } else {
            this.f36118k.setText("");
            this.f36118k.setVisibility(8);
        }
        if (!z2 || this.f36120m.getComment().required) {
            this.f36117j.setHint(R.string.one_payment_global_enterprise_hint_comments);
        } else {
            this.f36117j.setHint(getString(R.string.one_payment_global_enterprise_hint_comments) + getString(R.string.one_payment_global_enterprise_hint_comments_optional));
        }
        boolean z5 = !this.f36120m.getCompany().costCenterRequired || z3;
        boolean z6 = !this.f36120m.getCompany().projectRequired || z4;
        boolean z7 = !this.f36120m.getComment().required || (length >= this.f36120m.getComment().minSize && length <= this.f36120m.getComment().maxSize);
        TextView textView = this.f36119l;
        if (!z2 || !z5 || !z6 || !z7) {
            z = false;
        }
        textView.setEnabled(z);
    }

    /* renamed from: a */
    private String m25511a(String str) {
        if (TextUtils.isEmpty(str)) {
            return str;
        }
        return str.replaceFirst("\\s++$", "");
    }

    /* renamed from: a */
    private void m25513a(boolean z) {
        this.f36112e.setClickable(z);
        this.f36115h.setTextColor(z ? -16777216 : getResources().getColor(R.color.light_gray));
    }

    /* renamed from: b */
    private void m25516b(boolean z) {
        this.f36113f.setClickable(z);
        this.f36116i.setTextColor(z ? -16777216 : getResources().getColor(R.color.light_gray));
    }

    /* access modifiers changed from: private */
    /* renamed from: e */
    public void m25521e() {
        setResult(this.f36121n ? -1 : 0);
        finish();
    }

    /* access modifiers changed from: private */
    /* renamed from: f */
    public void m25523f() {
        String obj = this.f36117j.getText().toString();
        if (!TextUtils.isEmpty(obj)) {
            this.f36120m.getComment().comment = obj;
        }
        EnterpriseUtil.setEnterpriseInfo(this.f36120m);
        setResult(-1);
        finish();
    }
}

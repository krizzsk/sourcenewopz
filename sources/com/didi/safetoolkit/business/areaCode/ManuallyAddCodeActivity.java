package com.didi.safetoolkit.business.areaCode;

import android.os.Bundle;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.safetoolkit.base.BaseSafeToolkitActivity;
import com.didi.safetoolkit.business.areaCode.constant.AreaCodeConstant;
import com.didi.safetoolkit.business.areaCode.model.DialogInfo;
import com.didi.safetoolkit.business.contacts.model.SfContactsManageModel;
import com.didi.safetoolkit.business.contacts.store.SfAddAreaCodeQuitBiz;
import com.didi.safetoolkit.omega.SfOmegaUtil;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.taxis99.R;

public class ManuallyAddCodeActivity extends BaseSafeToolkitActivity implements TextWatcher, View.OnClickListener, View.OnKeyListener, SfManuallyIView {
    public static final int KEYBOARD_SHOW_DELAY_MILLIS = 100;
    public static final String MANUALLY_ADD_CODE_KEY = "manually_add_code_key";

    /* renamed from: a */
    private View f34234a;

    /* renamed from: b */
    private View f34235b;

    /* renamed from: c */
    private TextView f34236c;

    /* renamed from: d */
    private TextView f34237d;

    /* renamed from: e */
    private EditText f34238e;

    /* renamed from: f */
    private EditText f34239f;

    /* renamed from: g */
    private TextView f34240g;

    /* renamed from: h */
    private TextView f34241h;

    /* renamed from: i */
    private SfContactsManageModel f34242i;
    /* access modifiers changed from: private */

    /* renamed from: j */
    public ManuallyAddCodePresenter f34243j;

    /* renamed from: k */
    private boolean f34244k = false;

    /* renamed from: l */
    private int f34245l;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public int getBasicContentLayoutResId() {
        return R.layout.sf_manually_add_area_code_activity;
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f34234a = findViewById(R.id.sf_left_btn);
        this.f34235b = findViewById(R.id.sf_skip_btn);
        this.f34236c = (TextView) findViewById(R.id.number_added_name_text);
        this.f34237d = (TextView) findViewById(R.id.number_added_count_text);
        this.f34238e = (EditText) findViewById(R.id.first_area_code_text);
        this.f34239f = (EditText) findViewById(R.id.sec_area_code_text);
        this.f34240g = (TextView) findViewById(R.id.original_number);
        this.f34241h = (TextView) findViewById(R.id.manually_add_button);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f34242i = (SfContactsManageModel) bundle.getSerializable("manually_add_code_key");
            this.f34244k = bundle.getBoolean(AreaCodeConstant.PARAM_KEY_OPEN_FROM_SHARE_DIALOG, false);
            this.f34245l = bundle.getInt(AreaCodeConstant.PARAM_KEY_OPEN_WAY_SOURCE, 0);
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        this.f34243j = new ManuallyAddCodePresenter(this);
        SfContactsManageModel sfContactsManageModel = this.f34242i;
        if (!(sfContactsManageModel == null || sfContactsManageModel.datas == null || this.f34242i.datas.needAreaCodeContacts == null || this.f34242i.datas.needAreaCodeContacts.isEmpty())) {
            this.f34243j.setContactList(this.f34242i.datas.needAreaCodeContacts);
            if (!TextUtils.isEmpty(this.f34242i.datas.needAreaCodeContacts.get(0).phone_mask)) {
                this.f34240g.setText(this.f34242i.datas.needAreaCodeContacts.get(0).phone_mask);
            } else {
                this.f34240g.setText(this.f34242i.datas.needAreaCodeContacts.get(0).phone);
            }
            this.f34243j.setSpannableString();
            this.f34238e.requestFocus();
        }
        SfOmegaUtil.addEventId("gp_addAreaCode_entry_sw").report();
        if (!(getContext() == null || this.f34238e == null)) {
            m24217a(getContext(), this.f34238e);
        }
        int i = this.f34245l;
        if (i == 1) {
            this.f34241h.setText(R.string.sf_add_trusted_contacts_by_share);
        } else if (i != 2) {
            this.f34241h.setText(R.string.sf_add_trusted_contacts);
        } else {
            this.f34241h.setText(R.string.sf_add_trusted_contacts_by_stock);
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f34234a.setOnClickListener(this);
        this.f34235b.setOnClickListener(this);
        this.f34241h.setOnClickListener(this);
        this.f34238e.addTextChangedListener(this);
        this.f34239f.addTextChangedListener(this);
        this.f34239f.setOnKeyListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.sf_left_btn) {
            m24220b();
        } else if (view.getId() == R.id.sf_skip_btn) {
            SfOmegaUtil.addEventId("gp_addAreaCode_skip_ck").report();
            m24216a();
        } else if (view.getId() == R.id.manually_add_button) {
            String obj = this.f34238e.getText().toString();
            String obj2 = this.f34239f.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2)) {
                ManuallyAddCodePresenter manuallyAddCodePresenter = this.f34243j;
                int i = this.f34245l;
                manuallyAddCodePresenter.manuallyAddAreaCode(i, obj + obj2);
            }
        }
    }

    /* renamed from: a */
    private void m24216a() {
        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.title = getResources().getString(this.f34245l == 1 ? R.string.sf_add_area_code_skip_hint_by_share : R.string.sf_add_area_code_skip_hint);
        dialogInfo.posText = getResources().getString(R.string.sf_skip);
        dialogInfo.negText = getResources().getString(R.string.sf_cancel);
        dialogInfo.negListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfOmegaUtil.addEventId("gp_addAreaCodeSkip_cancel_ck").report();
            }
        };
        dialogInfo.posListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                SfOmegaUtil.addEventId("gp_addAreaCodeSkip_confirm_ck").report();
                ManuallyAddCodeActivity.this.f34243j.skip2Next();
            }
        };
        SfOmegaUtil.addEventId("gp_addAreaCodeSkip_popup_sw").report();
        m24218a(dialogInfo);
    }

    /* renamed from: b */
    private void m24220b() {
        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.title = getResources().getString(R.string.sf_add_area_code_quit_hint);
        dialogInfo.posText = getResources().getString(R.string.sf_exit);
        dialogInfo.negText = getResources().getString(R.string.sf_add_area_code_continue);
        dialogInfo.posListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                ManuallyAddCodeActivity.this.skipOut();
            }
        };
        m24218a(dialogInfo);
    }

    /* access modifiers changed from: protected */
    public boolean onBackPressedCall() {
        m24220b();
        return false;
    }

    /* renamed from: a */
    private void m24218a(final DialogInfo dialogInfo) {
        if (dialogInfo != null) {
            new SfBaseDialog.DialogBuilder(this).setTitle(dialogInfo.title).setTitleTypeface(1).setRightBtn(dialogInfo.posText, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogInfo.posListener != null) {
                        dialogInfo.posListener.onClick(view);
                    }
                }
            }).setRightBtnTypeface(1).setRightBtnTextColor(DidiThemeManager.getIns().getResPicker(getContext()).getColor(R.attr.recommend_text_color)).setLeftBtn(dialogInfo.negText, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogInfo.negListener != null) {
                        dialogInfo.negListener.onClick(view);
                    }
                }
            }).setCancelableWhenTouchOutside(false).build().show(getSupportFragmentManager(), "skip_dialog");
        }
    }

    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
        boolean z = true;
        if (charSequence.length() >= 1 && this.f34238e.isFocused()) {
            this.f34239f.requestFocus();
        }
        if (this.f34238e.getText().length() < 1 || this.f34239f.getText().length() < 1) {
            z = false;
        }
        m24219a(z);
    }

    /* renamed from: a */
    private void m24219a(boolean z) {
        this.f34241h.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f34238e.removeTextChangedListener(this);
        this.f34239f.removeTextChangedListener(this);
    }

    public void onAreaCodeAdded() {
        this.f34243j.skip2Next();
    }

    public void resetView() {
        this.f34238e.setText("");
        this.f34239f.setText("");
        m24219a(false);
        this.f34238e.requestFocus();
    }

    public void setNumberAddNameText(String str, SpannableString spannableString) {
        this.f34236c.setText(str);
        this.f34237d.setText(spannableString);
    }

    public void setPhoneNumber(String str) {
        this.f34240g.setText(str);
    }

    public void skipOut() {
        setResult(this.f34243j.isAnyoneAdded() ? 10 : 12);
        if (!this.f34244k) {
            SfAddAreaCodeQuitBiz.onAddAreaCodeQuit(this);
        }
        finish();
    }

    public View getFallbackView() {
        return findViewById(R.id.sf_loading);
    }

    /* JADX WARNING: Code restructure failed: missing block: B:2:0x0003, code lost:
        r3 = (android.view.inputmethod.InputMethodManager) r3.getSystemService("input_method");
     */
    /* renamed from: a */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private void m24217a(android.content.Context r3, final android.widget.EditText r4) {
        /*
            r2 = this;
            if (r3 != 0) goto L_0x0003
            return
        L_0x0003:
            java.lang.String r0 = "input_method"
            java.lang.Object r3 = r3.getSystemService(r0)
            android.view.inputmethod.InputMethodManager r3 = (android.view.inputmethod.InputMethodManager) r3
            if (r3 == 0) goto L_0x001c
            android.os.Handler r0 = new android.os.Handler
            r0.<init>()
            com.didi.safetoolkit.business.areaCode.ManuallyAddCodeActivity$6 r1 = new com.didi.safetoolkit.business.areaCode.ManuallyAddCodeActivity$6
            r1.<init>(r3, r4)
            r3 = 100
            r0.postDelayed(r1, r3)
        L_0x001c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.safetoolkit.business.areaCode.ManuallyAddCodeActivity.m24217a(android.content.Context, android.widget.EditText):void");
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 67 || this.f34239f.getText().length() != 0) {
            return false;
        }
        this.f34238e.setText("");
        this.f34238e.requestFocus();
        return false;
    }
}

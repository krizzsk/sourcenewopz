package com.didi.component.splitfare.areacode;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.Editable;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.text.style.ForegroundColorSpan;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import com.android.didi.theme.DidiThemeManager;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.component.business.util.GlobalOmegaUtils;
import com.didi.component.splitfare.model.UpdateSplitFarePartner;
import com.didi.global.loading.app.AbsLoadingAppCompatActivity;
import com.didi.safetoolkit.business.areaCode.model.DialogInfo;
import com.didi.safetoolkit.widget.SfBaseDialog;
import com.didi.sdk.apm.SystemUtils;
import com.didi.sdk.util.ToastHelper;
import com.taxis99.R;
import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class AreaCodeManuallyActivity extends AbsLoadingAppCompatActivity implements TextWatcher, View.OnClickListener, View.OnKeyListener {
    public static final String ADDED_AREA_CODE_CONTACTS = "added_area_code_contacts";
    public static final int AREA_CODE_REQUEST_CODE = 1;
    public static final int AREA_CODE_RESULT_CODE = 1;
    public static final int KEYBOARD_SHOW_DELAY_MILLIS = 100;
    public static final String MANUALLY_ADD_CODE_KEY = "manually_add_code_key";

    /* renamed from: a */
    private View f15874a;

    /* renamed from: b */
    private View f15875b;

    /* renamed from: c */
    private TextView f15876c;

    /* renamed from: d */
    private TextView f15877d;

    /* renamed from: e */
    private EditText f15878e;

    /* renamed from: f */
    private EditText f15879f;

    /* renamed from: g */
    private TextView f15880g;

    /* renamed from: h */
    private TextView f15881h;

    /* renamed from: i */
    private UpdateSplitFarePartner.SplitFareFailGroup f15882i;

    /* renamed from: j */
    private List<UpdateSplitFarePartner.AreaCodeUserInfo> f15883j;

    /* renamed from: k */
    private int f15884k = 0;

    public void afterTextChanged(Editable editable) {
    }

    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        parseBundle(getIntent().getExtras());
        setContentView((int) R.layout.g_manually_add_area_code_activity);
        findViews();
        initData();
        setListener();
        HashMap hashMap = new HashMap(1, 1.0f);
        hashMap.put("source", 2);
        GlobalOmegaUtils.trackEvent("gp_addAreaCode_entry_sw", (Map<String, Object>) hashMap);
    }

    /* access modifiers changed from: protected */
    public void findViews() {
        this.f15874a = findViewById(R.id.sf_left_btn);
        this.f15875b = findViewById(R.id.sf_skip_btn);
        this.f15876c = (TextView) findViewById(R.id.number_added_name_text);
        this.f15877d = (TextView) findViewById(R.id.number_added_count_text);
        this.f15878e = (EditText) findViewById(R.id.first_area_code_text);
        this.f15879f = (EditText) findViewById(R.id.sec_area_code_text);
        this.f15880g = (TextView) findViewById(R.id.original_number);
        this.f15881h = (TextView) findViewById(R.id.manually_add_button);
    }

    /* access modifiers changed from: protected */
    public void parseBundle(Bundle bundle) {
        if (bundle != null) {
            this.f15882i = (UpdateSplitFarePartner.SplitFareFailGroup) bundle.getSerializable("manually_add_code_key");
        }
    }

    /* access modifiers changed from: protected */
    public void initData() {
        UpdateSplitFarePartner.SplitFareFailGroup splitFareFailGroup = this.f15882i;
        if (!(splitFareFailGroup == null || splitFareFailGroup.contactList == null || this.f15882i.contactList.isEmpty())) {
            setContactList(this.f15882i.contactList);
            this.f15880g.setText(this.f15882i.contactList.get(0).originPhone);
            setSpannableString();
            this.f15878e.requestFocus();
        }
        EditText editText = this.f15878e;
        if (editText != null) {
            m11582a(editText);
        }
    }

    public void manuallyAddAreaCode(String str) {
        int i;
        List<UpdateSplitFarePartner.AreaCodeUserInfo> list = this.f15883j;
        if (list == null || list.size() <= (i = this.f15884k)) {
            ToastHelper.showLongCompleted((Context) this, "Add failed");
            return;
        }
        UpdateSplitFarePartner.AreaCodeUserInfo areaCodeUserInfo = this.f15883j.get(i);
        areaCodeUserInfo.phone = (TextUtils.isEmpty(this.f15883j.get(this.f15884k).countryCode) ? "" : this.f15883j.get(this.f15884k).countryCode) + str + this.f15883j.get(this.f15884k).originPhone;
        onAreaCodeAdded();
    }

    public void setContactList(List<UpdateSplitFarePartner.AreaCodeUserInfo> list) {
        if (list != null) {
            this.f15883j = list;
        }
    }

    public List<UpdateSplitFarePartner.AreaCodeUserInfo> getContactList() {
        return this.f15883j;
    }

    public void skip2Next() {
        if (getContactList() != null && !getContactList().isEmpty()) {
            int i = this.f15884k;
            this.f15884k = i + 1;
            if (i >= getContactList().size() - 1) {
                this.f15884k = 0;
                skipOut();
                return;
            }
            resetView();
            setPhoneNumber(this.f15883j.get(this.f15884k).originPhone);
            setSpannableString();
        }
    }

    public void setSpannableString() {
        List<UpdateSplitFarePartner.AreaCodeUserInfo> list = this.f15883j;
        if (list != null) {
            String str = list.get(this.f15884k).name;
            SpannableString spannableString = new SpannableString("(" + (this.f15884k + 1) + "/" + this.f15883j.size() + ")");
            try {
                spannableString.setSpan(new ForegroundColorSpan(Color.parseColor("#F5782D")), 1, String.valueOf(this.f15884k + 1).length() + 1, 34);
            } catch (Exception e) {
                e.printStackTrace();
            }
            setNumberAddNameText(str, spannableString);
        }
    }

    /* access modifiers changed from: protected */
    public void setListener() {
        this.f15874a.setOnClickListener(this);
        this.f15875b.setOnClickListener(this);
        this.f15881h.setOnClickListener(this);
        this.f15878e.addTextChangedListener(this);
        this.f15879f.addTextChangedListener(this);
        this.f15879f.setOnKeyListener(this);
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        if (view.getId() == R.id.sf_left_btn) {
            m11585b();
        } else if (view.getId() == R.id.sf_skip_btn) {
            m11581a();
        } else if (view.getId() == R.id.manually_add_button) {
            String obj = this.f15878e.getText().toString();
            String obj2 = this.f15879f.getText().toString();
            if (!TextUtils.isEmpty(obj) && !TextUtils.isEmpty(obj2)) {
                manuallyAddAreaCode(obj + obj2);
            }
        }
    }

    /* renamed from: a */
    private void m11581a() {
        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.title = getResources().getString(R.string.g_add_area_code_skip_hint);
        dialogInfo.posText = getResources().getString(R.string.g_skip);
        dialogInfo.negText = getResources().getString(R.string.sf_cancel);
        dialogInfo.negListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
            }
        };
        dialogInfo.posListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AreaCodeManuallyActivity.this.skip2Next();
            }
        };
        m11583a(dialogInfo);
    }

    /* renamed from: b */
    private void m11585b() {
        DialogInfo dialogInfo = new DialogInfo();
        dialogInfo.title = getResources().getString(R.string.g_add_area_code_quit_hint);
        dialogInfo.posText = getResources().getString(R.string.g_exit);
        dialogInfo.negText = getResources().getString(R.string.g_add_area_code_back);
        dialogInfo.posListener = new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                AreaCodeManuallyActivity.this.skipOut();
            }
        };
        m11583a(dialogInfo);
    }

    public void onBackPressed() {
        m11585b();
    }

    /* renamed from: a */
    private void m11583a(final DialogInfo dialogInfo) {
        if (dialogInfo != null) {
            new SfBaseDialog.DialogBuilder(this).setTitle(dialogInfo.title).setTitleTypeface(1).setRightBtn(dialogInfo.posText, (View.OnClickListener) new View.OnClickListener() {
                public void onClick(View view) {
                    AutoTrackHelper.trackViewOnClick(view);
                    if (dialogInfo.posListener != null) {
                        dialogInfo.posListener.onClick(view);
                    }
                }
            }).setRightBtnTypeface(1).setRightBtnTextColor(DidiThemeManager.getIns().getResPicker(this).getColor(R.attr.recommend_text_color)).setLeftBtn(dialogInfo.negText, (View.OnClickListener) new View.OnClickListener() {
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
        if (charSequence.length() >= 1 && this.f15878e.isFocused()) {
            this.f15879f.requestFocus();
        }
        if (this.f15878e.getText().length() < 1 || this.f15879f.getText().length() < 1) {
            z = false;
        }
        m11584a(z);
    }

    /* renamed from: a */
    private void m11584a(boolean z) {
        this.f15881h.setEnabled(z);
    }

    /* access modifiers changed from: protected */
    public void onDestroy() {
        super.onDestroy();
        this.f15878e.removeTextChangedListener(this);
        this.f15879f.removeTextChangedListener(this);
        this.f15884k = 0;
        skipOut();
    }

    public void onAreaCodeAdded() {
        skip2Next();
    }

    public void resetView() {
        this.f15878e.setText("");
        this.f15879f.setText("");
        m11584a(false);
        this.f15878e.requestFocus();
    }

    public void setNumberAddNameText(String str, SpannableString spannableString) {
        this.f15876c.setText(str);
        this.f15877d.setText(spannableString);
    }

    public void setPhoneNumber(String str) {
        this.f15880g.setText(str);
    }

    public void skipOut() {
        Intent intent = new Intent();
        intent.putExtra("added_area_code_contacts", (Serializable) this.f15883j);
        setResult(1, intent);
        finish();
    }

    public View getFallbackView() {
        return findViewById(R.id.sf_loading);
    }

    /* renamed from: a */
    private void m11582a(final EditText editText) {
        final InputMethodManager inputMethodManager = (InputMethodManager) getSystemService("input_method");
        if (inputMethodManager != null) {
            new Handler().postDelayed(new Runnable() {
                public void run() {
                    inputMethodManager.showSoftInput(editText, 0);
                }
            }, 100);
        }
    }

    public boolean onKey(View view, int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 67 || this.f15879f.getText().length() != 0) {
            return false;
        }
        this.f15878e.setText("");
        this.f15878e.requestFocus();
        return false;
    }
}

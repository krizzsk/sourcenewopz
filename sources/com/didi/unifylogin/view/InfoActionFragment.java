package com.didi.unifylogin.view;

import android.content.Intent;
import android.text.Editable;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import com.datadog.android.rum.internal.instrumentation.gestures.WindowCallbackWrapper;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.util.UiThreadHandler;
import com.didi.sdk.view.dialog.FreeDialog;
import com.didi.sdk.view.dialog.FreeDialogParam;
import com.didi.unifylogin.api.LoginPreferredConfig;
import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.base.net.pojo.response.SetEmailResponse;
import com.didi.unifylogin.base.view.AbsLoginBaseFillerFragment;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.listener.LoginListeners;
import com.didi.unifylogin.presenter.InputInfoPresenter;
import com.didi.unifylogin.utils.KeyboardHelper;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.utils.customview.LoginNextButton;
import com.didi.unifylogin.utils.simplifycode.LoginTextWatcher;
import com.didi.unifylogin.view.ability.IInputInfoView;
import com.didi.unifylogin.view.adpter.EmailSuffixListAdapter;
import com.taxis99.R;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.List;

public class InfoActionFragment extends AbsLoginBaseFillerFragment<InputInfoPresenter> implements IInputInfoView {
    /* access modifiers changed from: private */

    /* renamed from: b */
    public RecyclerView f45034b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public List<String> f45035c;

    /* renamed from: d */
    private EmailSuffixListAdapter f45036d;

    /* renamed from: e */
    private List<String> f45037e;
    protected EditText emailEt;
    protected TextView emailHintTv;
    protected EditText invitationEt;
    protected TextView invitationHintTV;
    protected EditText lastNameEt;
    protected TextView lastNameHintTv;
    protected EditText nameEt;
    protected TextView nameHintTv;
    protected LoginNextButton nextButton;

    /* access modifiers changed from: protected */
    public void setScrolLayoutChange(ScrollView scrollView) {
    }

    /* access modifiers changed from: protected */
    public InputInfoPresenter bindPresenter() {
        return new InputInfoPresenter(this, this.context);
    }

    public View initView(LayoutInflater layoutInflater, ViewGroup viewGroup) {
        View inflate = layoutInflater.inflate(R.layout.login_unify_fragment_input_info, viewGroup, false);
        this.nameHintTv = (TextView) inflate.findViewById(R.id.tv_name_hint);
        this.lastNameHintTv = (TextView) inflate.findViewById(R.id.tv_last_name_hint);
        this.emailHintTv = (TextView) inflate.findViewById(R.id.tv_email_hint);
        this.nameEt = (EditText) inflate.findViewById(R.id.et_name);
        this.lastNameEt = (EditText) inflate.findViewById(R.id.et_last_name);
        this.emailEt = (EditText) inflate.findViewById(R.id.et_email);
        this.invitationEt = (EditText) inflate.findViewById(R.id.et_invitation);
        this.invitationHintTV = (TextView) inflate.findViewById(R.id.tv_invitation_hint);
        this.subTitleTv = (TextView) inflate.findViewById(R.id.tv_sub_title);
        this.nextButton = (LoginNextButton) inflate.findViewById(R.id.btn_next);
        this.f45034b = (RecyclerView) inflate.findViewById(R.id.rv_email_suffix);
        return inflate;
    }

    /* access modifiers changed from: protected */
    public void updateView() {
        super.updateView();
        m32276a();
        m32283c();
        m32281b();
        LoginListeners.InfoAutoFillListener infoAutoFillListener = ListenerManager.getInfoAutoFillListener();
        if (infoAutoFillListener != null) {
            infoAutoFillListener.onEntryPage((Fragment) this);
        }
        LoginListeners.ShowEmailSuffixListener emailSuffixListener = ListenerManager.getEmailSuffixListener();
        if (emailSuffixListener != null) {
            emailSuffixListener.isShowEmailSuffix(new LoginListeners.ShowEmailSuffixCallBack() {
                public void showEmailSuffix(List<String> list) {
                    List unused = InfoActionFragment.this.f45035c = list;
                }
            });
        }
    }

    /* renamed from: a */
    private void m32276a() {
        ActionResponse.Action action = getAction();
        if (action == null) {
            LoginLog.write(this.TAG + getNowState() + " action is null");
            ((InputInfoPresenter) this.presenter).goFillNextInfo();
            return;
        }
        List<Integer> list = action.composition;
        if (list != null && list.size() > 0) {
            setInvitationVisibility(list.contains(8));
            setNameVisibility(list.contains(2));
            setLastNameVisibility(list.contains(2));
            setEmailVisibility(list.contains(1));
        }
    }

    /* renamed from: b */
    private void m32281b() {
        EditText editText;
        EditText editText2;
        if (LoginPreferredConfig.isExchangeNamePosition() && (editText = this.nameEt) != null && (editText2 = this.lastNameEt) != null) {
            this.nameEt = editText2;
            this.lastNameEt = editText;
            String charSequence = this.nameHintTv.getText().toString();
            this.nameHintTv.setText(this.lastNameHintTv.getText());
            this.lastNameHintTv.setText(charSequence);
        }
    }

    /* renamed from: c */
    private void m32283c() {
        if (this.messenger.isNeedBind() && this.messenger.getAuthInfo() != null) {
            if (!TextUtils.isEmpty(this.messenger.getAuthInfo().getEmail())) {
                this.emailEt.setText(this.messenger.getAuthInfo().getEmail());
            }
            if (!TextUtils.isEmpty(this.messenger.getAuthInfo().getFirstName())) {
                this.nameEt.setText(this.messenger.getAuthInfo().getFirstName());
            }
            if (!TextUtils.isEmpty(this.messenger.getAuthInfo().getLastName())) {
                this.lastNameEt.setText(this.messenger.getAuthInfo().getLastName());
            }
            this.nextButton.setEnabled(isfullInfo());
        }
    }

    public void initListener() {
        this.nextButton.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                AutoTrackHelper.trackViewOnClick(view);
                if (InfoActionFragment.this.emailEt.getVisibility() != 0 || InfoActionFragment.this.getEmail().contains("@")) {
                    new LoginOmegaUtil(LoginOmegaUtil.CONFM_CK).add("has_promoCode", Integer.valueOf(TextUtils.isEmpty(InfoActionFragment.this.getPromoCode()) ^ true ? 1 : 0)).send();
                    ((InputInfoPresenter) InfoActionFragment.this.presenter).fillInInfo();
                    return;
                }
                InfoActionFragment infoActionFragment = InfoActionFragment.this;
                infoActionFragment.showError(infoActionFragment.context.getString(R.string.login_unify_input_right_email));
            }
        });
        InfoTextWatcher infoTextWatcher = new InfoTextWatcher();
        this.nameEt.addTextChangedListener(infoTextWatcher);
        this.lastNameEt.addTextChangedListener(infoTextWatcher);
        this.emailEt.addTextChangedListener(infoTextWatcher);
        this.invitationEt.addTextChangedListener(infoTextWatcher);
        this.emailEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    InfoActionFragment infoActionFragment = InfoActionFragment.this;
                    infoActionFragment.scrollVertical(infoActionFragment.scrollView);
                }
                InfoActionFragment.this.emailEtFocusChange(z);
            }
        });
        this.invitationEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    InfoActionFragment infoActionFragment = InfoActionFragment.this;
                    infoActionFragment.scrollVertical(infoActionFragment.scrollView);
                    LoginOmegaUtil.trackEvent(LoginOmegaUtil.TONE_P_PROMO_INPUTBOX_CK);
                }
            }
        });
        this.nameEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_FNAME_INPUTBOX_CK).send();
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.GP_FIRSTNAME_INPUT_CONTEXT).add("context", InfoActionFragment.this.nameEt.getText().toString()).send();
                }
            }
        });
        this.lastNameEt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            public void onFocusChange(View view, boolean z) {
                if (z) {
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_LNAME_INPUTBOX_CK).send();
                } else {
                    new LoginOmegaUtil(LoginOmegaUtil.GP_LASTNAME_INPUT_CONTEXT).add("context", InfoActionFragment.this.lastNameEt.getText().toString()).send();
                }
            }
        });
        this.emailEt.addTextChangedListener(new LoginTextWatcher() {
            public void afterTextChanged(Editable editable) {
                if (ListenerManager.getEmailSuffixListener() == null || InfoActionFragment.this.emailEt.getVisibility() != 0) {
                    return;
                }
                if (InfoActionFragment.this.f45035c == null || InfoActionFragment.this.f45035c.size() == 0) {
                    InfoActionFragment.this.f45034b.setVisibility(8);
                } else if (editable == null) {
                    InfoActionFragment.this.f45034b.setVisibility(8);
                } else {
                    InfoActionFragment.this.m32279a(editable.toString());
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m32279a(String str) {
        if (TextUtils.isEmpty(str)) {
            this.f45034b.setVisibility(8);
            return;
        }
        scrollVertical(this.scrollView);
        boolean z = false;
        this.f45034b.setVisibility(0);
        this.f45034b.setLayoutManager(new LinearLayoutManager(this.context));
        if (this.f45036d == null) {
            EmailSuffixListAdapter emailSuffixListAdapter = new EmailSuffixListAdapter();
            this.f45036d = emailSuffixListAdapter;
            this.f45034b.setAdapter(emailSuffixListAdapter);
        }
        if (this.f45037e == null) {
            this.f45037e = new ArrayList();
        }
        this.f45037e.clear();
        if (!str.contains("@") || "@".equals(str)) {
            for (String str2 : this.f45035c) {
                List<String> list = this.f45037e;
                list.add(str + str2);
            }
        } else if (str.length() <= 1 || !str.endsWith("@")) {
            String substring = str.substring(0, str.lastIndexOf("@"));
            String substring2 = str.substring(str.lastIndexOf("@") + 1);
            for (String next : this.f45035c) {
                if (next.contains(substring2)) {
                    List<String> list2 = this.f45037e;
                    list2.add(substring + next);
                    z = true;
                }
            }
            if (!z) {
                this.f45034b.setVisibility(8);
            }
        } else {
            String substring3 = str.substring(0, str.length() - 1);
            for (String str3 : this.f45035c) {
                List<String> list3 = this.f45037e;
                list3.add(substring3 + str3);
            }
        }
        this.f45036d.setmEmailSuffix(this.f45037e);
        this.f45036d.setCallback(new EmailSuffixListAdapter.EmailSellectCallback() {
            public void emailSelect(String str) {
                InfoActionFragment.this.emailEt.setText(str);
                InfoActionFragment.this.emailEt.clearFocus();
                InfoActionFragment.this.f45034b.setVisibility(8);
                UiThreadHandler.postDelayed(new Runnable() {
                    public void run() {
                        KeyboardHelper.hideInputMethod(InfoActionFragment.this.context, InfoActionFragment.this.emailEt);
                    }
                }, 200);
            }
        });
    }

    /* access modifiers changed from: protected */
    public void emailEtFocusChange(boolean z) {
        if (z) {
            new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_EMAIL_INPUTBOX_CK).send();
        } else {
            new LoginOmegaUtil(LoginOmegaUtil.GP_EMAIL_INPUT_CONTEXT).add("context", this.emailEt.getText().toString()).send();
        }
        if (ListenerManager.getEmailSuffixListener() != null) {
            if (!z) {
                this.f45034b.setVisibility(8);
                return;
            }
            List<String> list = this.f45035c;
            if (list == null || list.size() == 0) {
                this.f45034b.setVisibility(8);
            } else if (!TextUtils.isEmpty(this.emailEt.getText().toString())) {
                m32279a(this.emailEt.getText().toString());
            }
        }
    }

    public LoginState getNowState() {
        return LoginState.STATE_INFO_ACTION;
    }

    public String getFirstName() {
        EditText editText = this.nameEt;
        if (editText == null || editText.getVisibility() != 0) {
            return null;
        }
        return this.nameEt.getText().toString().trim();
    }

    public String getLastName() {
        EditText editText = this.lastNameEt;
        if (editText == null || editText.getVisibility() != 0) {
            return null;
        }
        return this.lastNameEt.getText().toString().trim();
    }

    public String getEmail() {
        EditText editText = this.emailEt;
        if (editText == null || editText.getVisibility() != 0) {
            return null;
        }
        return this.emailEt.getText().toString().trim();
    }

    public String getPromoCode() {
        EditText editText = this.invitationEt;
        if (editText == null || editText.getVisibility() != 0) {
            return null;
        }
        return this.invitationEt.getText().toString();
    }

    public void showPromoDialog(SetEmailResponse.PromoConfig promoConfig) {
        FreeDialog.Builder buttonOrientation = new FreeDialog.Builder(this.context).setTitle(promoConfig.title).setMessage(promoConfig.msg).setCancelable(false).setCloseVisible(false).setButtonOrientation(FreeDialogParam.Orientation.VERTICAL);
        if (!TextUtils.isEmpty(promoConfig.continueBtn)) {
            buttonOrientation.addButton(promoConfig.continueBtn, true, new FreeDialogParam.OnClickListener() {
                public void onClick(FreeDialog freeDialog, View view) {
                    freeDialog.dismiss();
                    ((InputInfoPresenter) InfoActionFragment.this.presenter).goFillNextInfo();
                    new LoginOmegaUtil(LoginOmegaUtil.GP_EMAILREGISTERPROMO_DLG_CK).add("action", "continue").send();
                }
            });
        }
        if (!TextUtils.isEmpty(promoConfig.backBtn)) {
            buttonOrientation.addButton(new FreeDialogParam.Button.Builder(promoConfig.backBtn).setTextColor(-9539986).setClickListener(new FreeDialogParam.OnClickListener() {
                public void onClick(FreeDialog freeDialog, View view) {
                    InfoActionFragment.this.emailEt.setFocusable(false);
                    InfoActionFragment.this.emailEt.setFocusableInTouchMode(false);
                    freeDialog.dismiss();
                    new LoginOmegaUtil(LoginOmegaUtil.GP_EMAILREGISTERPROMO_DLG_CK).add("action", WindowCallbackWrapper.BACK_DEFAULT_TARGET_NAME).send();
                }
            }).build());
        }
        buttonOrientation.build().show(getFragmentManager(), "PromoDialog");
        new LoginOmegaUtil(LoginOmegaUtil.GP_EMAILREGISTERPROMO_DLG_SW).send();
    }

    /* access modifiers changed from: protected */
    public void scrollVertical(final ScrollView scrollView) {
        scrollView.postDelayed(new Runnable() {
            public void run() {
                ScrollView scrollView = scrollView;
                scrollView.scrollTo(0, scrollView.getHeight());
            }
        }, 200);
    }

    /* access modifiers changed from: protected */
    public boolean isfullInfo() {
        if (this.nameEt.getVisibility() == 0 && this.nameEt.getText() != null && TextUtils.isEmpty(this.nameEt.getText().toString().trim())) {
            return false;
        }
        if (this.lastNameEt.getVisibility() == 0 && this.lastNameEt.getText() != null && TextUtils.isEmpty(this.lastNameEt.getText().toString().trim())) {
            return false;
        }
        if (this.emailEt.getVisibility() != 0 || this.emailEt.getText() == null || !TextUtils.isEmpty(this.emailEt.getText().toString().trim())) {
            return true;
        }
        return false;
    }

    /* access modifiers changed from: protected */
    public void setNameVisibility(boolean z) {
        int i = z ? 0 : 8;
        m32277a((View) this.nameHintTv, i);
        m32277a((View) this.nameEt, i);
    }

    /* access modifiers changed from: protected */
    public void setLastNameVisibility(boolean z) {
        int i = z ? 0 : 8;
        m32277a((View) this.lastNameEt, i);
        m32277a((View) this.lastNameHintTv, i);
    }

    /* access modifiers changed from: protected */
    public void setEmailVisibility(boolean z) {
        int i = z ? 0 : 8;
        m32277a((View) this.emailHintTv, i);
        m32277a((View) this.emailEt, i);
    }

    /* access modifiers changed from: protected */
    public void setInvitationVisibility(boolean z) {
        int i = z ? 0 : 8;
        m32277a((View) this.invitationHintTV, i);
        m32277a((View) this.invitationEt, i);
    }

    /* renamed from: a */
    private void m32277a(View view, int i) {
        if (view != null) {
            view.setVisibility(i);
        }
    }

    class InfoTextWatcher extends LoginTextWatcher {
        InfoTextWatcher() {
        }

        public void afterTextChanged(Editable editable) {
            InfoActionFragment.this.nextButton.setEnabled(InfoActionFragment.this.isfullInfo());
        }
    }

    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        LoginListeners.InfoAutoFillListener infoAutoFillListener = ListenerManager.getInfoAutoFillListener();
        if (infoAutoFillListener != null) {
            ArrayList arrayList = new ArrayList();
            arrayList.add(new WeakReference(this.nameEt));
            arrayList.add(new WeakReference(this.lastNameEt));
            arrayList.add(new WeakReference(this.emailEt));
            infoAutoFillListener.onGetResult(i, i2, intent, arrayList);
        }
        if (this.presenter != null) {
            ((InputInfoPresenter) this.presenter).onActivityResult(i, i2, intent);
        }
    }
}

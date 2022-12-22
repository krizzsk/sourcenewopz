package com.didichuxing.gms.login;

import android.app.Activity;
import android.content.Intent;
import android.content.IntentSender;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.listener.LoginListeners;
import com.didichuxing.foundation.spi.ServiceLoader;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import com.didichuxing.login.ILoginInterface;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.credentials.Credential;
import com.google.android.gms.auth.api.credentials.CredentialPickerConfig;
import com.google.android.gms.auth.api.credentials.Credentials;
import com.google.android.gms.auth.api.credentials.CredentialsApi;
import com.google.android.gms.auth.api.credentials.HintRequest;
import com.google.android.gms.common.api.GoogleApiClient;
import java.lang.ref.WeakReference;
import java.util.List;
import org.json.JSONObject;

@ServiceProvider({LoginListeners.InfoAutoFillListener.class})
public class PersonInfoAutoFillListener implements LoginListeners.InfoAutoFillListener {
    private final Handler handler = new Handler(Looper.getMainLooper());
    private final ILoginInterface loginUtils = ((ILoginInterface) ServiceLoader.load(ILoginInterface.class).get());

    public void onGetResult(int i, int i2, Intent intent, List<WeakReference<EditText>> list) {
        CredentialsApi credentialsApi = Auth.CredentialsApi;
        if (2000 != i) {
            return;
        }
        if (i2 != -1 || intent == null) {
            CredentialsApi credentialsApi2 = Auth.CredentialsApi;
            if (i2 == 1001) {
                cannotObtainGoogleAccountFocus(list);
                trackEvent("login_credential_picker_other_ck");
                return;
            }
            CredentialsApi credentialsApi3 = Auth.CredentialsApi;
            if (i2 == 1002) {
                cannotObtainGoogleAccountFocus(list);
                trackEvent("login_credential_picker_no_hint");
            } else if (i2 == 0) {
                cannotObtainGoogleAccountFocus(list);
            }
        } else {
            try {
                Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
                if (credential == null || list == null || list.size() != 3) {
                    cannotObtainGoogleAccountFocus(list);
                    return;
                }
                fill(list.get(0), credential.getGivenName());
                fill(list.get(1), credential.getFamilyName());
                fill(list.get(2), credential.getId());
                editTextFocus(list, 2);
                ((EditText) list.get(2).get()).setSelection(credential.getId().length());
                trackEvent("login_credential_picker_ck");
            } catch (Exception e) {
                e.printStackTrace();
                cannotObtainGoogleAccountFocus(list);
            }
        }
    }

    public String onGetResult(int i, int i2, Intent intent) {
        if (i2 != -1 || intent == null) {
            CredentialsApi credentialsApi = Auth.CredentialsApi;
            if (i2 == 1001) {
                return "";
            }
            CredentialsApi credentialsApi2 = Auth.CredentialsApi;
            if (i2 == 1002) {
            }
            return "";
        }
        try {
            Credential credential = (Credential) intent.getParcelableExtra(Credential.EXTRA_KEY);
            if (credential == null) {
                return "";
            }
            JSONObject jSONObject = new JSONObject();
            jSONObject.put("errno", 0);
            jSONObject.put("error", "");
            jSONObject.put("firstName", credential.getGivenName());
            jSONObject.put("lastName", credential.getFamilyName());
            jSONObject.put("email", credential.getId());
            return jSONObject.toString();
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }

    public void onEntryPage(Activity activity) {
        try {
            IntentSender intentSender = Credentials.getClient(activity).getHintPickerIntent(new HintRequest.Builder().setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build()).setEmailAddressIdentifierSupported(true).build()).getIntentSender();
            CredentialsApi credentialsApi = Auth.CredentialsApi;
            activity.startIntentSenderForResult(intentSender, 2000, (Intent) null, 0, 0, 0, (Bundle) null);
        } catch (IntentSender.SendIntentException e) {
            e.printStackTrace();
        }
    }

    private void editTextFocus(final List<WeakReference<EditText>> list, final int i) {
        this.handler.postDelayed(new Runnable() {
            public void run() {
                List list = list;
                if (list != null && list.size() == 3 && list.get(i) != null) {
                    EditText editText = (EditText) ((WeakReference) list.get(i)).get();
                    editText.setFocusable(true);
                    editText.setFocusableInTouchMode(true);
                    editText.requestFocus();
                    InputMethodManager inputMethodManager = (InputMethodManager) editText.getContext().getSystemService("input_method");
                    if (inputMethodManager != null) {
                        inputMethodManager.showSoftInput(editText, 0);
                    }
                }
            }
        }, 200);
    }

    private void cannotObtainGoogleAccountFocus(List<WeakReference<EditText>> list) {
        editTextFocus(list, getPosition());
    }

    private void fill(WeakReference<EditText> weakReference, String str) {
        EditText editText = (EditText) weakReference.get();
        if (editText != null) {
            editText.setText(str);
        }
    }

    public void onEntryPage(Fragment fragment) {
        if (fragment != null && fragment.getContext() != null) {
            try {
                IntentSender intentSender = Auth.CredentialsApi.getHintPickerIntent(new GoogleApiClient.Builder(fragment.getContext()).addApi(Auth.CREDENTIALS_API).build(), new HintRequest.Builder().setHintPickerConfig(new CredentialPickerConfig.Builder().setShowCancelButton(true).build()).setEmailAddressIdentifierSupported(true).build()).getIntentSender();
                CredentialsApi credentialsApi = Auth.CredentialsApi;
                fragment.startIntentSenderForResult(intentSender, 2000, (Intent) null, 0, 0, 0, (Bundle) null);
                trackEvent("login_credential_picker_sw");
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    /* access modifiers changed from: package-private */
    public void trackEvent(String str) {
        ILoginInterface iLoginInterface = this.loginUtils;
        if (iLoginInterface != null) {
            iLoginInterface.trackEvent(str);
        }
    }

    /* access modifiers changed from: package-private */
    public int getPosition() {
        ILoginInterface iLoginInterface = this.loginUtils;
        if (iLoginInterface != null) {
            return iLoginInterface.getPosition();
        }
        return 0;
    }
}

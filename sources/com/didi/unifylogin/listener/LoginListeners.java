package com.didi.unifylogin.listener;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.didi.unifylogin.listener.pojo.FaceParam;
import com.didi.unifylogin.listener.pojo.WebViewModel;
import java.io.IOException;
import java.io.Serializable;
import java.lang.ref.WeakReference;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import org.json.JSONObject;

public class LoginListeners {

    public interface CancelAccFinishListener {
        void onCancel();

        void onSuccess(Activity activity);
    }

    public interface CustomStateFragment {
        Fragment getFragment(int i);
    }

    public interface EmailStatusListener {
        void onFail(IOException iOException);

        void onSucc(int i, String str);
    }

    public interface FaceCallback {
        void onResult(int i);
    }

    public interface FaceListener {
        void callFaceListener(FaceParam faceParam, FaceCallback faceCallback);
    }

    public interface FirstInstallListener {
        String reasonOfFirstInstall();
    }

    public interface GetParamsListener {
        Map<String, Object> getOmegaParams();
    }

    public interface GlobalizationListener {
        String getLanguage();

        Locale getSystemLocale();
    }

    public interface GuidePermissionsDelegate {
        void guidePermissions(FragmentActivity fragmentActivity, List<String> list);
    }

    public interface IPreLoginListener {
        void callback(String str);
    }

    public interface InfoAutoFillListener {
        void onEntryPage(Activity activity);

        void onEntryPage(Fragment fragment);

        String onGetResult(int i, int i2, Intent intent);

        void onGetResult(int i, int i2, Intent intent, List<WeakReference<EditText>> list);
    }

    public interface InputCPFListener {
        void onCancel();

        void onSuccess(Activity activity, String str, FaceParam faceParam);
    }

    public interface InterceptorCallback {
        void onFailed(int i, String str);

        void onSuccess();
    }

    public interface LoadingViewListener {
        void onCreate(Map<String, Object> map, LinearLayout linearLayout);
    }

    public interface LocationListener {
        int getCityId();

        double getLat();

        double getLng();

        String getMapType();

        int getUtcOffset();
    }

    public static class LoginBaseActivityDelegate {
        public Context getAttachBaseContext(Context context, FragmentActivity fragmentActivity) {
            return context;
        }

        public void onActivityResult(FragmentActivity fragmentActivity) {
        }

        public void onCreate(Bundle bundle, FragmentActivity fragmentActivity) {
        }

        public void onRestart(FragmentActivity fragmentActivity) {
        }

        public void onResume(FragmentActivity fragmentActivity) {
        }
    }

    public interface LoginInterceptor extends Serializable {
        void onInterceptor(String str, Activity activity, InterceptorCallback interceptorCallback);
    }

    public interface LoginJumpListener {
        void jump(Activity activity);
    }

    public interface LoginListener {
        void onCancel();

        void onSuccess(Activity activity, String str);
    }

    public interface LoginOutListener {
        void onSuccess();
    }

    public interface ModifyEmailListener {
        void onCancel();

        void onSuccess(Activity activity);
    }

    public interface ModifyPasswordListener {
        void onCancel();

        void onSuccess(Activity activity);
    }

    public interface NetParamListener {
        Map<String, Object> getExtraInfo();
    }

    public interface OttListener<T> {
        void onFail(Throwable th);

        void onSuccess(T t);
    }

    public interface PassportServerCallback {
        void onFail(IOException iOException);

        void onSucc(int i, JSONObject jSONObject);
    }

    public interface PasswordVerifyListener {
        void onFail(int i, String str);

        void onSucess();
    }

    public interface RiskParamListener {
        String getA3(Context context);

        String getIdfa(Context context);
    }

    public interface SetCellListener {
        void onCancel();

        void onSuccess(Activity activity);
    }

    public interface ShowEmailSuffixCallBack {
        void showEmailSuffix(List<String> list);
    }

    public interface ShowEmailSuffixListener {
        void isShowEmailSuffix(ShowEmailSuffixCallBack showEmailSuffixCallBack);
    }

    public interface ShowSkipCallBack {
        void showSkip();
    }

    public interface ShowSkipListener {
        void isShowSkip(ShowSkipCallBack showSkipCallBack);
    }

    public interface TokenListener {
        void onSuccess(String str);
    }

    public interface ValidateTicketListener {
        void onFail(String str);

        void onSucc();
    }

    public interface VerifyCodeListener {
        void onActivityCreated(Activity activity);

        void onActivityDestroy();

        void onFail();

        void onSuccess(FragmentActivity fragmentActivity, String str, String str2);
    }

    public interface WanderListener {
        void onFail(Throwable th);

        void onSuccess();
    }

    public interface WebViewListener {
        void callWebView(WebViewModel webViewModel);
    }

    public interface WhatsAppListener {
        boolean supportWhatsAppVerificationCode();

        boolean whatsAppInstalled();
    }

    public interface WriteBackListener {
        void onComplete();
    }
}

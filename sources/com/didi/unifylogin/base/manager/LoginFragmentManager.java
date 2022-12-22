package com.didi.unifylogin.base.manager;

import android.content.Context;
import android.os.SystemClock;
import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import com.didi.unifylogin.base.model.FragmentMessenger;
import com.didi.unifylogin.base.model.LoginModel;
import com.didi.unifylogin.base.net.LoginRpcCallbackV2;
import com.didi.unifylogin.base.net.pojo.request.CodeMtParam;
import com.didi.unifylogin.base.net.pojo.response.CodeMtResponse;
import com.didi.unifylogin.base.net.pojo.response.CountryListResponse;
import com.didi.unifylogin.base.view.ability.ILoginBaseFragment;
import com.didi.unifylogin.listener.ListenerManager;
import com.didi.unifylogin.utils.ApolloSwitch;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginOmegaUtil;
import com.didi.unifylogin.utils.LoginState;
import com.didi.unifylogin.view.CPFInputFragment;
import com.didi.unifylogin.view.CancelFragment;
import com.didi.unifylogin.view.CaptchaFragment;
import com.didi.unifylogin.view.CertificationFragment;
import com.didi.unifylogin.view.ConfirmPhoneFragment;
import com.didi.unifylogin.view.ConfirmSnatchCellFragment;
import com.didi.unifylogin.view.DeleteAccountFailedFragment;
import com.didi.unifylogin.view.DeleteAccountFailedTextStyleFragment;
import com.didi.unifylogin.view.DeleteAccountManualFragment;
import com.didi.unifylogin.view.DeleteAccountReasonsFragment;
import com.didi.unifylogin.view.EmailActionFragment;
import com.didi.unifylogin.view.EmailLoginPasswordFragment;
import com.didi.unifylogin.view.ForgetCellFragment;
import com.didi.unifylogin.view.InfoActionFragment;
import com.didi.unifylogin.view.InputEmailFragment;
import com.didi.unifylogin.view.InputNewEmailFragment;
import com.didi.unifylogin.view.InputPhoneFragment;
import com.didi.unifylogin.view.InputPhoneFragmentV2;
import com.didi.unifylogin.view.LoginPasswordFragment;
import com.didi.unifylogin.view.NameActionFragment;
import com.didi.unifylogin.view.NewPhoneFragment;
import com.didi.unifylogin.view.PreCertificationFragment;
import com.didi.unifylogin.view.PreFaceFragment;
import com.didi.unifylogin.view.PreRetrieveFragment;
import com.didi.unifylogin.view.PreSetCellFragment;
import com.didi.unifylogin.view.PreSetEmailFragment;
import com.didi.unifylogin.view.PreSetPwdFragment;
import com.didi.unifylogin.view.ResetPwdFragment;
import com.didi.unifylogin.view.SetCellErrorFragment;
import com.didi.unifylogin.view.SetPwdByEmailLoginFragment;
import com.didi.unifylogin.view.SetPwdFragment;
import com.didi.unifylogin.view.ThirdPartyPhoneFragment;
import com.didi.unifylogin.view.ThirdPartySetFragment;
import com.didi.unifylogin.view.VerifyCodeFragment;
import com.didi.unifylogin.view.VerifyEmailCodeFragment;
import com.didi.unifylogin.view.VerifyEmailFragment;
import com.didi.unifylogin.view.VerifyEmailRegisterCodeFragment;
import com.didi.unifylogin.view.VerifyNewCodeFragment;
import com.didichuxing.foundation.rpc.RpcRequest;
import com.didichuxing.foundation.rpc.RpcResponseProxy;
import com.taxis99.R;
import java.io.IOException;

public class LoginFragmentManager {

    /* renamed from: a */
    private static final String f44682a = "LoginFragmentManager";

    public static void transform(LoginState loginState, LoginState loginState2, ILoginBaseFragment iLoginBaseFragment) {
        LoginLog.write("LoginFragmentManager transform from:" + loginState + ", to: " + loginState2);
        try {
            if (!m31725c(loginState, loginState2, iLoginBaseFragment)) {
                m31724b(loginState, loginState2, iLoginBaseFragment);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: b */
    public static void m31724b(LoginState loginState, LoginState loginState2, ILoginBaseFragment iLoginBaseFragment) {
        if (iLoginBaseFragment.isViewAlive()) {
            iLoginBaseFragment.hideLoading();
            iLoginBaseFragment.getBaseActivity().transform(loginState, loginState2, iLoginBaseFragment.getMessenger());
        }
    }

    /* renamed from: com.didi.unifylogin.base.manager.LoginFragmentManager$2 */
    static /* synthetic */ class C145272 {
        static final /* synthetic */ int[] $SwitchMap$com$didi$unifylogin$utils$LoginState;

        /* JADX WARNING: Can't wrap try/catch for region: R(74:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|(3:73|74|76)) */
        /* JADX WARNING: Can't wrap try/catch for region: R(76:0|1|2|3|4|5|6|7|8|9|10|11|12|13|14|15|16|17|18|19|20|21|22|23|24|25|26|27|28|29|30|31|32|33|34|35|36|37|38|39|40|41|42|43|44|45|46|47|48|49|50|51|52|53|54|55|56|57|58|59|60|61|62|63|64|65|66|67|68|69|70|71|72|73|74|76) */
        /* JADX WARNING: Failed to process nested try/catch */
        /* JADX WARNING: Missing exception handler attribute for start block: B:11:0x003e */
        /* JADX WARNING: Missing exception handler attribute for start block: B:13:0x0049 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:15:0x0054 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:17:0x0060 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:19:0x006c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:21:0x0078 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:23:0x0084 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:25:0x0090 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:27:0x009c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:29:0x00a8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:31:0x00b4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:33:0x00c0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:35:0x00cc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:37:0x00d8 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:39:0x00e4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:3:0x0012 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:41:0x00f0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:43:0x00fc */
        /* JADX WARNING: Missing exception handler attribute for start block: B:45:0x0108 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:47:0x0114 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:49:0x0120 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:51:0x012c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:53:0x0138 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:55:0x0144 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:57:0x0150 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:59:0x015c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:5:0x001d */
        /* JADX WARNING: Missing exception handler attribute for start block: B:61:0x0168 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:63:0x0174 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:65:0x0180 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:67:0x018c */
        /* JADX WARNING: Missing exception handler attribute for start block: B:69:0x0198 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:71:0x01a4 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:73:0x01b0 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:7:0x0028 */
        /* JADX WARNING: Missing exception handler attribute for start block: B:9:0x0033 */
        static {
            /*
                com.didi.unifylogin.utils.LoginState[] r0 = com.didi.unifylogin.utils.LoginState.values()
                int r0 = r0.length
                int[] r0 = new int[r0]
                $SwitchMap$com$didi$unifylogin$utils$LoginState = r0
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CODE     // Catch:{ NoSuchFieldError -> 0x0012 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0012 }
                r2 = 1
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0012 }
            L_0x0012:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x001d }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_CODE     // Catch:{ NoSuchFieldError -> 0x001d }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x001d }
                r2 = 2
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x001d }
            L_0x001d:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0028 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_CODE     // Catch:{ NoSuchFieldError -> 0x0028 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0028 }
                r2 = 3
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0028 }
            L_0x0028:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0033 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_REGISTER_CODE     // Catch:{ NoSuchFieldError -> 0x0033 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0033 }
                r2 = 4
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0033 }
            L_0x0033:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x003e }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_INPUT_PHONE     // Catch:{ NoSuchFieldError -> 0x003e }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x003e }
                r2 = 5
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x003e }
            L_0x003e:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0049 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CONFIRM_PHONE     // Catch:{ NoSuchFieldError -> 0x0049 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0049 }
                r2 = 6
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0049 }
            L_0x0049:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0054 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_VERIFY_OLD_PWD     // Catch:{ NoSuchFieldError -> 0x0054 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0054 }
                r2 = 7
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0054 }
            L_0x0054:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0060 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_CELL     // Catch:{ NoSuchFieldError -> 0x0060 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0060 }
                r2 = 8
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0060 }
            L_0x0060:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x006c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PASSWORD     // Catch:{ NoSuchFieldError -> 0x006c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x006c }
                r2 = 9
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x006c }
            L_0x006c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0078 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_PWD     // Catch:{ NoSuchFieldError -> 0x0078 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0078 }
                r2 = 10
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0078 }
            L_0x0078:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0084 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_SET_PWD     // Catch:{ NoSuchFieldError -> 0x0084 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0084 }
                r2 = 11
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0084 }
            L_0x0084:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0090 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_RETRIEVE     // Catch:{ NoSuchFieldError -> 0x0090 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0090 }
                r2 = 12
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0090 }
            L_0x0090:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x009c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_FORGET_CELL     // Catch:{ NoSuchFieldError -> 0x009c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x009c }
                r2 = 13
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x009c }
            L_0x009c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00a8 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_PHONE     // Catch:{ NoSuchFieldError -> 0x00a8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00a8 }
                r2 = 14
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00a8 }
            L_0x00a8:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00b4 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CAPTCHA     // Catch:{ NoSuchFieldError -> 0x00b4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00b4 }
                r2 = 15
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00b4 }
            L_0x00b4:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00c0 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CANCEL     // Catch:{ NoSuchFieldError -> 0x00c0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00c0 }
                r2 = 16
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00c0 }
            L_0x00c0:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00cc }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_DELETE_ACCOUNT_MANUAL     // Catch:{ NoSuchFieldError -> 0x00cc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00cc }
                r2 = 17
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00cc }
            L_0x00cc:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00d8 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_DELETE_ACCOUNT_REASON     // Catch:{ NoSuchFieldError -> 0x00d8 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00d8 }
                r2 = 18
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00d8 }
            L_0x00d8:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00e4 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_DELETE_ACCOUNT_FAILED     // Catch:{ NoSuchFieldError -> 0x00e4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00e4 }
                r2 = 19
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00e4 }
            L_0x00e4:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00f0 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_DELETE_ACCOUNT_FAILED_TEXT_STYLE     // Catch:{ NoSuchFieldError -> 0x00f0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00f0 }
                r2 = 20
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00f0 }
            L_0x00f0:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x00fc }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_INFO_ACTION     // Catch:{ NoSuchFieldError -> 0x00fc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x00fc }
                r2 = 21
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x00fc }
            L_0x00fc:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0108 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NAME_ACTION     // Catch:{ NoSuchFieldError -> 0x0108 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0108 }
                r2 = 22
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0108 }
            L_0x0108:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0114 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_ACTION     // Catch:{ NoSuchFieldError -> 0x0114 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0114 }
                r2 = 23
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0114 }
            L_0x0114:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0120 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CERTIFICATION     // Catch:{ NoSuchFieldError -> 0x0120 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0120 }
                r2 = 24
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0120 }
            L_0x0120:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x012c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_VERIFY_EMAIL     // Catch:{ NoSuchFieldError -> 0x012c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x012c }
                r2 = 25
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x012c }
            L_0x012c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0138 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_SET_EMAIL     // Catch:{ NoSuchFieldError -> 0x0138 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0138 }
                r2 = 26
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0138 }
            L_0x0138:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0144 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_NEW_EMAIL     // Catch:{ NoSuchFieldError -> 0x0144 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0144 }
                r2 = 27
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0144 }
            L_0x0144:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0150 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_BIND_THIRD_PHONE     // Catch:{ NoSuchFieldError -> 0x0150 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0150 }
                r2 = 28
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0150 }
            L_0x0150:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x015c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_THIRD_PARTY_SET     // Catch:{ NoSuchFieldError -> 0x015c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x015c }
                r2 = 29
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x015c }
            L_0x015c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0168 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_CERTIFICATION     // Catch:{ NoSuchFieldError -> 0x0168 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0168 }
                r2 = 30
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0168 }
            L_0x0168:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0174 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_CONFIRM_SNATCH     // Catch:{ NoSuchFieldError -> 0x0174 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0174 }
                r2 = 31
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0174 }
            L_0x0174:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0180 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_SETCELL_ERROR     // Catch:{ NoSuchFieldError -> 0x0180 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0180 }
                r2 = 32
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0180 }
            L_0x0180:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x018c }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_PRE_FACE     // Catch:{ NoSuchFieldError -> 0x018c }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x018c }
                r2 = 33
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x018c }
            L_0x018c:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x0198 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_EMAIL_REGISTER_OR_LOGIN     // Catch:{ NoSuchFieldError -> 0x0198 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x0198 }
                r2 = 34
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x0198 }
            L_0x0198:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x01a4 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_SET_PWD_BY_EMAIL     // Catch:{ NoSuchFieldError -> 0x01a4 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01a4 }
                r2 = 35
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01a4 }
            L_0x01a4:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x01b0 }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_LOGIN_PWD_BY_EMAIL     // Catch:{ NoSuchFieldError -> 0x01b0 }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01b0 }
                r2 = 36
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01b0 }
            L_0x01b0:
                int[] r0 = $SwitchMap$com$didi$unifylogin$utils$LoginState     // Catch:{ NoSuchFieldError -> 0x01bc }
                com.didi.unifylogin.utils.LoginState r1 = com.didi.unifylogin.utils.LoginState.STATE_LOGIN_CHANGE_PHONE_INPUT_CPF     // Catch:{ NoSuchFieldError -> 0x01bc }
                int r1 = r1.ordinal()     // Catch:{ NoSuchFieldError -> 0x01bc }
                r2 = 37
                r0[r1] = r2     // Catch:{ NoSuchFieldError -> 0x01bc }
            L_0x01bc:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.didi.unifylogin.base.manager.LoginFragmentManager.C145272.<clinit>():void");
        }
    }

    /* renamed from: c */
    private static boolean m31725c(LoginState loginState, LoginState loginState2, ILoginBaseFragment iLoginBaseFragment) {
        FragmentMessenger messenger = iLoginBaseFragment.getMessenger();
        int i = C145272.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState2.ordinal()];
        if (i == 1) {
            if (loginState != LoginState.STATE_CAPTCHA) {
                messenger.setCodeType(0);
            }
            m31723a((String) null, messenger.getCell(), loginState, loginState2, messenger.getCodeType(), iLoginBaseFragment, (CountryListResponse.CountryRule) null);
            return true;
        } else if (i == 2) {
            if (loginState != LoginState.STATE_CAPTCHA) {
                messenger.setNewCodeType(0);
            }
            CountryListResponse.CountryRule newCellCountry = messenger.getNewCellCountry();
            m31723a((String) null, messenger.getNewCell(), loginState, loginState2, messenger.getNewCodeType(), iLoginBaseFragment, newCellCountry);
            return true;
        } else if (i == 3) {
            messenger.setCodeType(2);
            m31723a((String) null, messenger.getCell(), loginState, loginState2, messenger.getCodeType(), iLoginBaseFragment, (CountryListResponse.CountryRule) null);
            return true;
        } else if (i != 4) {
            return false;
        } else {
            messenger.setCodeType(2);
            m31723a(messenger.getEmail(), (String) null, loginState, loginState2, messenger.getCodeType(), iLoginBaseFragment, (CountryListResponse.CountryRule) null);
            return true;
        }
    }

    /* renamed from: a */
    private static void m31723a(String str, String str2, LoginState loginState, LoginState loginState2, int i, ILoginBaseFragment iLoginBaseFragment, CountryListResponse.CountryRule countryRule) {
        LoginLog.write("LoginFragmentManager requestSms phone:" + str2 + ", fromState: " + loginState + ",to: " + loginState2 + ", codeType:" + i);
        final FragmentMessenger messenger = iLoginBaseFragment.getMessenger();
        final Context applicationContext = iLoginBaseFragment.getBaseActivity().getApplicationContext();
        iLoginBaseFragment.showLoading((String) null);
        CodeMtParam codeType = new CodeMtParam(applicationContext, messenger.getSceneNum()).setEmail(str).setCell(str2).setCodeType(i);
        if (countryRule != null) {
            codeType.setCountryCallingCode(countryRule.calling_code);
            codeType.setCanonicalCountryCode(countryRule.area);
        }
        messenger.setLastCodeMTTime(SystemClock.uptimeMillis());
        final ILoginBaseFragment iLoginBaseFragment2 = iLoginBaseFragment;
        final LoginState loginState3 = loginState2;
        final LoginState loginState4 = loginState;
        final String str3 = str2;
        LoginModel.getNet(iLoginBaseFragment.getBaseActivity()).codeMt(codeType, new LoginRpcCallbackV2<CodeMtResponse>() {
            public void onSuccess(RpcResponseProxy<CodeMtResponse> rpcResponseProxy) {
                super.onSuccess(rpcResponseProxy);
                CodeMtResponse content = rpcResponseProxy.getContent();
                ILoginBaseFragment.this.hideLoading();
                if (content == null) {
                    ILoginBaseFragment.this.showError((int) R.string.login_unify_net_error);
                    return;
                }
                if (content.pattern != null) {
                    messenger.setCodeLength(content.pattern.codeLen);
                }
                int i = content.errno;
                if (i == 0) {
                    if (loginState3 == LoginState.STATE_NEW_CODE) {
                        messenger.setNewCodeType(content.code_type);
                    } else {
                        messenger.setCodeType(content.code_type);
                    }
                    messenger.setPrompt(content.prompt);
                    messenger.setVoiceSupport(content.voiceSupport);
                    if (content.code_type == 0) {
                        ILoginBaseFragment.this.showShortCompleted((int) R.string.login_unify_send_sms_code_success);
                    }
                    LoginFragmentManager.m31724b(loginState4, loginState3, ILoginBaseFragment.this);
                } else if (i != 41002) {
                    String string = TextUtils.isEmpty(content.error) ? applicationContext.getString(R.string.login_unify_net_error) : content.error;
                    ILoginBaseFragment.this.showError(string);
                    new LoginOmegaUtil(LoginOmegaUtil.TONE_P_X_TOAST_SW).add("err_code", Integer.valueOf(content.errno)).add("err_massage", string).send();
                } else {
                    messenger.setNextState(loginState3);
                    messenger.setCaptchaCell(str3);
                    LoginFragmentManager.m31724b(loginState4, LoginState.STATE_CAPTCHA, ILoginBaseFragment.this);
                }
            }

            public void onFailure(RpcRequest rpcRequest, IOException iOException) {
                super.onFailure(rpcRequest, iOException);
                ILoginBaseFragment.this.hideLoading();
                ILoginBaseFragment.this.showError((int) R.string.login_unify_net_error);
                iOException.printStackTrace();
            }
        });
    }

    public static Fragment getFragment(LoginState loginState) {
        Fragment a = m31721a(loginState);
        if (a != null) {
            LoginLog.write("LoginFragmentManager: getCustomFragment , state:" + loginState);
            return a;
        }
        switch (C145272.$SwitchMap$com$didi$unifylogin$utils$LoginState[loginState.ordinal()]) {
            case 1:
                return new VerifyCodeFragment();
            case 2:
                return new VerifyNewCodeFragment();
            case 3:
                return new VerifyEmailCodeFragment();
            case 4:
                return new VerifyEmailRegisterCodeFragment();
            case 5:
                if (ApolloSwitch.getInstance().passportSdkUpdate()) {
                    return new InputPhoneFragmentV2();
                }
                return new InputPhoneFragment();
            case 6:
                return new ConfirmPhoneFragment();
            case 7:
                return new ResetPwdFragment();
            case 8:
                return new PreSetCellFragment();
            case 9:
                return new LoginPasswordFragment();
            case 10:
                return new PreSetPwdFragment();
            case 11:
                return new SetPwdFragment();
            case 12:
                return new PreRetrieveFragment();
            case 13:
                return new ForgetCellFragment();
            case 14:
                return new NewPhoneFragment();
            case 15:
                return new CaptchaFragment();
            case 16:
                return new CancelFragment();
            case 17:
                return new DeleteAccountManualFragment();
            case 18:
                return new DeleteAccountReasonsFragment();
            case 19:
                return new DeleteAccountFailedFragment();
            case 20:
                return new DeleteAccountFailedTextStyleFragment();
            case 21:
                return new InfoActionFragment();
            case 22:
                return new NameActionFragment();
            case 23:
                return new EmailActionFragment();
            case 24:
                return new CertificationFragment();
            case 25:
                return new VerifyEmailFragment();
            case 26:
                return new PreSetEmailFragment();
            case 27:
                return new InputNewEmailFragment();
            case 28:
                return new ThirdPartyPhoneFragment();
            case 29:
                return new ThirdPartySetFragment();
            case 30:
                return new PreCertificationFragment();
            case 31:
                return new ConfirmSnatchCellFragment();
            case 32:
                return new SetCellErrorFragment();
            case 33:
                return new PreFaceFragment();
            case 34:
                return new InputEmailFragment();
            case 35:
                return new SetPwdByEmailLoginFragment();
            case 36:
                return new EmailLoginPasswordFragment();
            case 37:
                return new CPFInputFragment();
            default:
                return null;
        }
    }

    /* renamed from: a */
    private static Fragment m31721a(LoginState loginState) {
        Fragment fragment;
        if (ListenerManager.getCustomStateFragment() == null || (fragment = ListenerManager.getCustomStateFragment().getFragment(loginState.getStateNum())) == null) {
            return null;
        }
        return fragment;
    }
}

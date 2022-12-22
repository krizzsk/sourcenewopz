package com.didi.unifylogin.base.manager;

import com.didi.unifylogin.base.net.pojo.response.ActionResponse;
import com.didi.unifylogin.utils.LoginLog;
import com.didi.unifylogin.utils.LoginState;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class LoginFillerFragmentManager {
    public static final int FILL_CERTIFICATION = 6;
    public static final int FILL_COMPOSE = 7;
    public static final int FILL_EMAIL = 1;
    public static final int FILL_INVITATION = 8;
    public static final int FILL_NAME = 2;
    public static final int FILL_PASSWORD = 4;

    /* renamed from: a */
    private static final String f44679a = "LoginFillerFragmentManager - ";

    /* renamed from: b */
    private static List<LoginState> f44680b;

    /* renamed from: c */
    private static Map<LoginState, ActionResponse.Action> f44681c;

    public static void setFillers(List<ActionResponse.Action> list) {
        LoginState loginState;
        if (list == null || list.size() <= 0) {
            f44680b = null;
            return;
        }
        LoginLog.write("LoginFillerFragmentManager -  setFillers() fillerInfos " + list.size());
        f44680b = new ArrayList();
        f44681c = new HashMap();
        for (ActionResponse.Action next : list) {
            int i = next.action;
            if (i == 4) {
                LoginLog.write("LoginFillerFragmentManager - add setPassword " + next.action);
                loginState = LoginState.STATE_SET_PWD;
            } else if (i == 6) {
                LoginLog.write("LoginFillerFragmentManager - add fillCertification " + next.action);
                loginState = LoginState.STATE_PRE_CERTIFICATION;
            } else if (i != 7) {
                loginState = null;
            } else {
                LoginLog.write("LoginFillerFragmentManager - add setEmailAndName " + next.action);
                loginState = LoginState.STATE_INFO_ACTION;
            }
            if (loginState != null && !f44680b.contains(loginState)) {
                f44680b.add(loginState);
                f44681c.put(loginState, next);
            }
        }
        LoginLog.write("LoginFillerFragmentManager - fillerInfos : " + list.size());
    }

    public static void cleanFillers() {
        f44680b = null;
    }

    public static void removeState(LoginState loginState) {
        List<LoginState> list = f44680b;
        if (list != null) {
            list.remove(loginState);
        }
    }

    public static LoginState getNextState(LoginState loginState) {
        if (f44680b == null) {
            return null;
        }
        int i = -1;
        if (loginState != null) {
            LoginLog.write("LoginFillerFragmentManager - getNextState() nowState : " + loginState);
            i = f44680b.indexOf(loginState);
        }
        int i2 = i + 1;
        if (i2 < 0 || i2 >= f44680b.size()) {
            return null;
        }
        LoginState loginState2 = f44680b.get(i2);
        LoginLog.write("LoginFillerFragmentManager - getNextState() nextState : " + loginState2);
        return loginState2;
    }

    public static ActionResponse.Action getFillerInfo(LoginState loginState) {
        Map<LoginState, ActionResponse.Action> map = f44681c;
        if (map != null) {
            return map.get(loginState);
        }
        LoginLog.write("LoginFillerFragmentManager - fillerInfoMap is null : ");
        return null;
    }
}

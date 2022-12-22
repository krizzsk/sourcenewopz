package com.yanzhenjie.permission.checker;

import android.content.Context;
import android.os.Build;
import com.yanzhenjie.permission.runtime.Permission;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

public final class StrictChecker implements PermissionChecker {
    public boolean hasPermission(Context context, String... strArr) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : strArr) {
            if (!m40431a(context, a)) {
                return false;
            }
        }
        return true;
    }

    public boolean hasPermission(Context context, List<String> list) {
        if (Build.VERSION.SDK_INT < 21) {
            return true;
        }
        for (String a : list) {
            if (!m40431a(context, a)) {
                return false;
            }
        }
        return true;
    }

    /* renamed from: a */
    private boolean m40431a(Context context, String str) {
        char c = 65535;
        try {
            switch (str.hashCode()) {
                case -2062386608:
                    if (str.equals(Permission.READ_SMS)) {
                        c = 19;
                        break;
                    }
                    break;
                case -1928411001:
                    if (str.equals(Permission.READ_CALENDAR)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (str.equals(Permission.READ_CALL_LOG)) {
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (str.equals(Permission.ACCESS_FINE_LOCATION)) {
                        c = 7;
                        break;
                    }
                    break;
                case -1479758289:
                    if (str.equals(Permission.RECEIVE_WAP_PUSH)) {
                        c = 20;
                        break;
                    }
                    break;
                case -1238066820:
                    if (str.equals(Permission.BODY_SENSORS)) {
                        c = 16;
                        break;
                    }
                    break;
                case -895679497:
                    if (str.equals(Permission.RECEIVE_MMS)) {
                        c = 18;
                        break;
                    }
                    break;
                case -895673731:
                    if (str.equals(Permission.RECEIVE_SMS)) {
                        c = 21;
                        break;
                    }
                    break;
                case -406040016:
                    if (str.equals(Permission.READ_EXTERNAL_STORAGE)) {
                        c = 22;
                        break;
                    }
                    break;
                case -63024214:
                    if (str.equals(Permission.ACCESS_COARSE_LOCATION)) {
                        c = 6;
                        break;
                    }
                    break;
                case -5573545:
                    if (str.equals(Permission.READ_PHONE_STATE)) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (str.equals(Permission.SEND_SMS)) {
                        c = 17;
                        break;
                    }
                    break;
                case 112197485:
                    if (str.equals(Permission.CALL_PHONE)) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (str.equals(Permission.WRITE_CONTACTS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (str.equals(Permission.CAMERA)) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (str.equals(Permission.WRITE_CALENDAR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (str.equals(Permission.WRITE_CALL_LOG)) {
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (str.equals(Permission.USE_SIP)) {
                        c = 14;
                        break;
                    }
                    break;
                case 952819282:
                    if (str.equals(Permission.PROCESS_OUTGOING_CALLS)) {
                        c = 15;
                        break;
                    }
                    break;
                case 1271781903:
                    if (str.equals(Permission.GET_ACCOUNTS)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (str.equals(Permission.WRITE_EXTERNAL_STORAGE)) {
                        c = 23;
                        break;
                    }
                    break;
                case 1831139720:
                    if (str.equals(Permission.RECORD_AUDIO)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1977429404:
                    if (str.equals(Permission.READ_CONTACTS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2133799037:
                    if (str.equals(Permission.ADD_VOICEMAIL)) {
                        c = CharUtils.f5620CR;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                    return m40430a(context);
                case 1:
                    return m40433b(context);
                case 2:
                    return m40434c(context);
                case 3:
                    return m40435d(context);
                case 4:
                    return m40436e(context);
                case 6:
                    return m40437f(context);
                case 7:
                    return m40438g(context);
                case 8:
                    return m40439h(context);
                case 9:
                    return m40440i(context);
                case 11:
                    return m40441j(context);
                case 12:
                    return m40442k(context);
                case 13:
                    return m40443l(context);
                case 14:
                    return m40444m(context);
                case 16:
                    return m40445n(context);
                case 19:
                    return m40446o(context);
                case 22:
                    return m40429a();
                case 23:
                    return m40432b();
                default:
                    return true;
            }
        } catch (Throwable unused) {
            return false;
        }
    }

    /* renamed from: a */
    private static boolean m40430a(Context context) throws Throwable {
        return new C20690b(context).mo169065a();
    }

    /* renamed from: b */
    private static boolean m40433b(Context context) throws Throwable {
        return new C20691c(context).mo169065a();
    }

    /* renamed from: c */
    private static boolean m40434c(Context context) throws Throwable {
        return new C20694f(context).mo169065a();
    }

    /* renamed from: d */
    private static boolean m40435d(Context context) throws Throwable {
        return new C20695g(context).mo169065a();
    }

    /* renamed from: e */
    private static boolean m40436e(Context context) throws Throwable {
        return new C20696h(context.getContentResolver()).mo169065a();
    }

    /* renamed from: f */
    private static boolean m40437f(Context context) throws Throwable {
        return new C20697i(context).mo169065a();
    }

    /* renamed from: g */
    private static boolean m40438g(Context context) throws Throwable {
        return new C20698j(context).mo169065a();
    }

    /* renamed from: h */
    private static boolean m40439h(Context context) throws Throwable {
        return new C20700l(context).mo169065a();
    }

    /* renamed from: i */
    private static boolean m40440i(Context context) throws Throwable {
        return new C20699k(context).mo169065a();
    }

    /* renamed from: j */
    private static boolean m40441j(Context context) throws Throwable {
        return new C20692d(context).mo169065a();
    }

    /* renamed from: k */
    private static boolean m40442k(Context context) throws Throwable {
        return new C20693e(context).mo169065a();
    }

    /* renamed from: l */
    private static boolean m40443l(Context context) throws Throwable {
        return new C20689a(context).mo169065a();
    }

    /* renamed from: m */
    private static boolean m40444m(Context context) throws Throwable {
        return new C20702n(context).mo169065a();
    }

    /* renamed from: n */
    private static boolean m40445n(Context context) throws Throwable {
        return new C20701m(context).mo169065a();
    }

    /* renamed from: o */
    private static boolean m40446o(Context context) throws Throwable {
        return new C20703o(context).mo169065a();
    }

    /* renamed from: a */
    private static boolean m40429a() throws Throwable {
        return new C20704p().mo169065a();
    }

    /* renamed from: b */
    private static boolean m40432b() throws Throwable {
        return new C20705q().mo169065a();
    }
}

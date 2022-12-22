package com.yanzhenjie.permission.runtime;

import android.content.Context;
import android.os.Build;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.apache.commons.lang3.CharUtils;

public class Permission {
    public static final String ACCESS_COARSE_LOCATION = "android.permission.ACCESS_COARSE_LOCATION";
    public static final String ACCESS_FINE_LOCATION = "android.permission.ACCESS_FINE_LOCATION";
    public static final String ADD_VOICEMAIL = "com.android.voicemail.permission.ADD_VOICEMAIL";
    public static final String ANSWER_PHONE_CALLS = "android.permission.ANSWER_PHONE_CALLS";
    public static final String BODY_SENSORS = "android.permission.BODY_SENSORS";
    public static final String CALL_PHONE = "android.permission.CALL_PHONE";
    public static final String CAMERA = "android.permission.CAMERA";
    public static final String GET_ACCOUNTS = "android.permission.GET_ACCOUNTS";
    public static final String PROCESS_OUTGOING_CALLS = "android.permission.PROCESS_OUTGOING_CALLS";
    public static final String READ_CALENDAR = "android.permission.READ_CALENDAR";
    public static final String READ_CALL_LOG = "android.permission.READ_CALL_LOG";
    public static final String READ_CONTACTS = "android.permission.READ_CONTACTS";
    public static final String READ_EXTERNAL_STORAGE = "android.permission.READ_EXTERNAL_STORAGE";
    public static final String READ_PHONE_NUMBERS = "android.permission.READ_PHONE_NUMBERS";
    public static final String READ_PHONE_STATE = "android.permission.READ_PHONE_STATE";
    public static final String READ_SMS = "android.permission.READ_SMS";
    public static final String RECEIVE_MMS = "android.permission.RECEIVE_MMS";
    public static final String RECEIVE_SMS = "android.permission.RECEIVE_SMS";
    public static final String RECEIVE_WAP_PUSH = "android.permission.RECEIVE_WAP_PUSH";
    public static final String RECORD_AUDIO = "android.permission.RECORD_AUDIO";
    public static final String SEND_SMS = "android.permission.SEND_SMS";
    public static final String USE_SIP = "android.permission.USE_SIP";
    public static final String WRITE_CALENDAR = "android.permission.WRITE_CALENDAR";
    public static final String WRITE_CALL_LOG = "android.permission.WRITE_CALL_LOG";
    public static final String WRITE_CONTACTS = "android.permission.WRITE_CONTACTS";
    public static final String WRITE_EXTERNAL_STORAGE = "android.permission.WRITE_EXTERNAL_STORAGE";

    /* renamed from: a */
    static final String f56226a = "android.permission.ADD_VOICEMAIL";

    public static final class Group {
        public static final String[] CALENDAR = {Permission.READ_CALENDAR, Permission.WRITE_CALENDAR};
        public static final String[] CAMERA = {Permission.CAMERA};
        public static final String[] CONTACTS = {Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS};
        public static final String[] LOCATION = {Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION};
        public static final String[] MICROPHONE = {Permission.RECORD_AUDIO};
        public static final String[] PHONE;
        public static final String[] SENSORS = {Permission.BODY_SENSORS};
        public static final String[] SMS = {Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS};
        public static final String[] STORAGE = {Permission.READ_EXTERNAL_STORAGE, Permission.WRITE_EXTERNAL_STORAGE};

        static {
            if (Build.VERSION.SDK_INT >= 26) {
                PHONE = new String[]{Permission.READ_PHONE_STATE, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS, Permission.READ_PHONE_NUMBERS, Permission.ANSWER_PHONE_CALLS};
            } else {
                PHONE = new String[]{Permission.READ_PHONE_STATE, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS};
            }
        }
    }

    public static List<String> transformText(Context context, String... strArr) {
        return transformText(context, (List<String>) Arrays.asList(strArr));
    }

    public static List<String> transformText(Context context, String[]... strArr) {
        ArrayList arrayList = new ArrayList();
        for (String[] asList : strArr) {
            arrayList.addAll(Arrays.asList(asList));
        }
        return transformText(context, (List<String>) arrayList);
    }

    public static List<String> transformText(Context context, List<String> list) {
        ArrayList arrayList = new ArrayList();
        for (String next : list) {
            char c = 65535;
            switch (next.hashCode()) {
                case -2062386608:
                    if (next.equals(READ_SMS)) {
                        c = 22;
                        break;
                    }
                    break;
                case -1928411001:
                    if (next.equals(READ_CALENDAR)) {
                        c = 0;
                        break;
                    }
                    break;
                case -1921431796:
                    if (next.equals(READ_CALL_LOG)) {
                        c = 11;
                        break;
                    }
                    break;
                case -1888586689:
                    if (next.equals(ACCESS_FINE_LOCATION)) {
                        c = 6;
                        break;
                    }
                    break;
                case -1674700861:
                    if (next.equals(ANSWER_PHONE_CALLS)) {
                        c = 18;
                        break;
                    }
                    break;
                case -1479758289:
                    if (next.equals(RECEIVE_WAP_PUSH)) {
                        c = 23;
                        break;
                    }
                    break;
                case -1238066820:
                    if (next.equals(BODY_SENSORS)) {
                        c = 19;
                        break;
                    }
                    break;
                case -1164582768:
                    if (next.equals(READ_PHONE_NUMBERS)) {
                        c = 17;
                        break;
                    }
                    break;
                case -895679497:
                    if (next.equals(RECEIVE_MMS)) {
                        c = 24;
                        break;
                    }
                    break;
                case -895673731:
                    if (next.equals(RECEIVE_SMS)) {
                        c = 21;
                        break;
                    }
                    break;
                case -406040016:
                    if (next.equals(READ_EXTERNAL_STORAGE)) {
                        c = 25;
                        break;
                    }
                    break;
                case -63024214:
                    if (next.equals(ACCESS_COARSE_LOCATION)) {
                        c = 7;
                        break;
                    }
                    break;
                case -5573545:
                    if (next.equals(READ_PHONE_STATE)) {
                        c = 9;
                        break;
                    }
                    break;
                case 52602690:
                    if (next.equals(SEND_SMS)) {
                        c = 20;
                        break;
                    }
                    break;
                case 112197485:
                    if (next.equals(CALL_PHONE)) {
                        c = 10;
                        break;
                    }
                    break;
                case 214526995:
                    if (next.equals(WRITE_CONTACTS)) {
                        c = 4;
                        break;
                    }
                    break;
                case 463403621:
                    if (next.equals(CAMERA)) {
                        c = 2;
                        break;
                    }
                    break;
                case 603653886:
                    if (next.equals(WRITE_CALENDAR)) {
                        c = 1;
                        break;
                    }
                    break;
                case 610633091:
                    if (next.equals(WRITE_CALL_LOG)) {
                        c = 12;
                        break;
                    }
                    break;
                case 784519842:
                    if (next.equals(USE_SIP)) {
                        c = 15;
                        break;
                    }
                    break;
                case 952819282:
                    if (next.equals(PROCESS_OUTGOING_CALLS)) {
                        c = 16;
                        break;
                    }
                    break;
                case 1271781903:
                    if (next.equals(GET_ACCOUNTS)) {
                        c = 5;
                        break;
                    }
                    break;
                case 1365911975:
                    if (next.equals(WRITE_EXTERNAL_STORAGE)) {
                        c = 26;
                        break;
                    }
                    break;
                case 1831139720:
                    if (next.equals(RECORD_AUDIO)) {
                        c = 8;
                        break;
                    }
                    break;
                case 1897049163:
                    if (next.equals(f56226a)) {
                        c = 14;
                        break;
                    }
                    break;
                case 1977429404:
                    if (next.equals(READ_CONTACTS)) {
                        c = 3;
                        break;
                    }
                    break;
                case 2133799037:
                    if (next.equals(ADD_VOICEMAIL)) {
                        c = CharUtils.f5620CR;
                        break;
                    }
                    break;
            }
            switch (c) {
                case 0:
                case 1:
                    String string = context.getString(R.string.permission_name_calendar);
                    if (arrayList.contains(string)) {
                        break;
                    } else {
                        arrayList.add(string);
                        break;
                    }
                case 2:
                    String string2 = context.getString(R.string.permission_name_camera);
                    if (arrayList.contains(string2)) {
                        break;
                    } else {
                        arrayList.add(string2);
                        break;
                    }
                case 3:
                case 4:
                    String string3 = context.getString(R.string.permission_name_contacts);
                    if (arrayList.contains(string3)) {
                        break;
                    } else {
                        arrayList.add(string3);
                        break;
                    }
                case 5:
                    String string4 = context.getString(R.string.permission_name_accounts);
                    if (arrayList.contains(string4)) {
                        break;
                    } else {
                        arrayList.add(string4);
                        break;
                    }
                case 6:
                case 7:
                    String string5 = context.getString(R.string.permission_name_location);
                    if (arrayList.contains(string5)) {
                        break;
                    } else {
                        arrayList.add(string5);
                        break;
                    }
                case 8:
                    String string6 = context.getString(R.string.permission_name_microphone);
                    if (arrayList.contains(string6)) {
                        break;
                    } else {
                        arrayList.add(string6);
                        break;
                    }
                case 9:
                case 10:
                case 11:
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                case 18:
                    String string7 = context.getString(R.string.permission_name_phone);
                    if (arrayList.contains(string7)) {
                        break;
                    } else {
                        arrayList.add(string7);
                        break;
                    }
                case 19:
                    String string8 = context.getString(R.string.permission_name_sensors);
                    if (arrayList.contains(string8)) {
                        break;
                    } else {
                        arrayList.add(string8);
                        break;
                    }
                case 20:
                case 21:
                case 22:
                case 23:
                case 24:
                    String string9 = context.getString(R.string.permission_name_sms);
                    if (arrayList.contains(string9)) {
                        break;
                    } else {
                        arrayList.add(string9);
                        break;
                    }
                case 25:
                case 26:
                    String string10 = context.getString(R.string.permission_name_storage);
                    if (arrayList.contains(string10)) {
                        break;
                    } else {
                        arrayList.add(string10);
                        break;
                    }
            }
        }
        return arrayList;
    }
}

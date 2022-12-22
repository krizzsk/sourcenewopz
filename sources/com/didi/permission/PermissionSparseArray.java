package com.didi.permission;

import android.os.Build;
import android.util.SparseArray;
import com.yanzhenjie.permission.runtime.Permission;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

public class PermissionSparseArray extends SparseArray<String[]> {
    public static final int PERMISSION_CALENDAR = 4;
    public static final int PERMISSION_CAMERA = 2;
    public static final int PERMISSION_CONTACTS = 3;
    public static final int PERMISSION_LOCATION = 5;
    public static final int PERMISSION_MICROPHONE = 6;
    public static final int PERMISSION_PHONE = 7;
    public static final int PERMISSION_SENSORS = 8;
    public static final int PERMISSION_SMS = 9;
    public static final int PERMISSION_STORAGE = 1;

    /* renamed from: a */
    private static PermissionSparseArray f33031a = new PermissionSparseArray();

    @Retention(RetentionPolicy.SOURCE)
    public @interface PermissionRequestCode {
    }

    private PermissionSparseArray() {
        put(1, new String[]{Permission.WRITE_EXTERNAL_STORAGE, Permission.READ_EXTERNAL_STORAGE});
        put(2, new String[]{Permission.CAMERA});
        put(3, new String[]{Permission.READ_CONTACTS, Permission.WRITE_CONTACTS, Permission.GET_ACCOUNTS});
        put(4, new String[]{Permission.READ_CALENDAR, Permission.WRITE_CALENDAR});
        put(5, new String[]{Permission.ACCESS_FINE_LOCATION, Permission.ACCESS_COARSE_LOCATION});
        put(6, new String[]{Permission.RECORD_AUDIO});
        put(7, new String[]{Permission.READ_PHONE_STATE, Permission.CALL_PHONE, Permission.READ_CALL_LOG, Permission.WRITE_CALL_LOG, Permission.ADD_VOICEMAIL, Permission.USE_SIP, Permission.PROCESS_OUTGOING_CALLS});
        if (Build.VERSION.SDK_INT >= 20) {
            put(8, new String[]{Permission.BODY_SENSORS});
        }
        put(9, new String[]{Permission.SEND_SMS, Permission.RECEIVE_SMS, Permission.READ_SMS, Permission.RECEIVE_WAP_PUSH, Permission.RECEIVE_MMS});
    }

    public static PermissionSparseArray getInstance() {
        return f33031a;
    }

    public static String[] mergePermissionArrays(int... iArr) {
        int i = 0;
        for (int i2 : iArr) {
            i += ((String[]) getInstance().get(i2)).length;
        }
        String[] strArr = new String[i];
        int i3 = 0;
        for (int i4 : iArr) {
            String[] strArr2 = (String[]) getInstance().get(i4);
            System.arraycopy(strArr2, 0, strArr, i3, strArr2.length);
            i3 = strArr2.length;
        }
        return strArr;
    }
}

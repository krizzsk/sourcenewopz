package com.didichuxing.mas.sdk.quality.report.perforence;

import android.content.ContentProvider;
import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.text.TextUtils;
import com.didichuxing.mas.sdk.quality.report.utils.OLog;

public class ConfigProvider extends ContentProvider {
    private static Uri CONFIG_CONTENT_URI = null;
    private static String EXTRA_KEY = "key";
    private static String EXTRA_TYPE = "type";
    private static String EXTRA_VALUE = "value";
    private static int LENGTH_CONTENT_URI = 0;
    private static final int TYPE_BOOLEAN = 1;
    private static final int TYPE_INT = 2;
    private static final int TYPE_LONG = 3;
    private static final int TYPE_STRING = 4;

    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    public String getType(Uri uri) {
        return null;
    }

    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    public boolean onCreate() {
        Context context = getContext();
        if (context != null) {
            String packageName = context.getPackageName();
            Uri parse = Uri.parse("content://" + packageName + ".configprovider");
            CONFIG_CONTENT_URI = parse;
            LENGTH_CONTENT_URI = parse.toString().length() + 1;
        }
        return true;
    }

    public Uri insert(Uri uri, ContentValues contentValues) {
        RuntimeCheck.CheckProcess();
        int intValue = contentValues.getAsInteger(EXTRA_TYPE).intValue();
        String str = "";
        if (intValue == 1) {
            str = str + ServiceConfig.getInstanse().getBooleanValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsBoolean(EXTRA_VALUE).booleanValue());
        } else if (intValue == 4) {
            str = str + ServiceConfig.getInstanse().getStringValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsString(EXTRA_VALUE));
        } else if (intValue == 2) {
            str = str + ServiceConfig.getInstanse().getIntValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsInteger(EXTRA_VALUE).intValue());
        } else if (intValue == 3) {
            str = str + ServiceConfig.getInstanse().getLongValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsLong(EXTRA_VALUE).longValue());
        }
        return Uri.parse(getAuthorities().toString() + "/" + str);
    }

    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        RuntimeCheck.CheckProcess();
        int intValue = contentValues.getAsInteger(EXTRA_TYPE).intValue();
        if (intValue == 1) {
            ServiceConfig.getInstanse().setBooleanValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsBoolean(EXTRA_VALUE).booleanValue());
        } else if (intValue == 4) {
            ServiceConfig.getInstanse().setStringValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsString(EXTRA_VALUE));
        } else if (intValue == 2) {
            ServiceConfig.getInstanse().setIntValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsInteger(EXTRA_VALUE).intValue());
        } else if (intValue == 3) {
            ServiceConfig.getInstanse().setLongValue(contentValues.getAsString(EXTRA_KEY), contentValues.getAsLong(EXTRA_VALUE).longValue());
        }
        return 1;
    }

    public static void setBooleanValue(String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 1);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Boolean.valueOf(z));
        safeUpdate(contentValues);
    }

    public static void setLongValue(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 3);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Long.valueOf(j));
        safeUpdate(contentValues);
    }

    private static void safeUpdate(ContentValues contentValues) {
        try {
            RuntimeCheck.getContentResolver().update(getAuthorities(), contentValues, (String) null, (String[]) null);
        } catch (Exception e) {
            OLog.m34418e("safeUpdate() : " + e.getMessage());
        }
    }

    public static void setIntValue(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 2);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Integer.valueOf(i));
        safeUpdate(contentValues);
    }

    public static void setStringValue(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 4);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, str2);
        safeUpdate(contentValues);
    }

    public static long getLongValue(String str, long j) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 3);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Long.valueOf(j));
        Uri safeInsert = safeInsert(contentValues);
        if (safeInsert == null) {
            return j;
        }
        String substring = safeInsert.toString().substring(LENGTH_CONTENT_URI);
        if (TextUtils.isEmpty(substring)) {
            return j;
        }
        return Long.parseLong(substring);
    }

    public static boolean getBooleanValue(String str, boolean z) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 1);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Boolean.valueOf(z));
        Uri safeInsert = safeInsert(contentValues);
        if (safeInsert == null) {
            return z;
        }
        return Boolean.parseBoolean(safeInsert.toString().substring(LENGTH_CONTENT_URI));
    }

    private static Uri safeInsert(ContentValues contentValues) {
        try {
            return RuntimeCheck.getContentResolver().insert(getAuthorities(), contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            OLog.m34418e("safeInsert() : " + e.getMessage());
            return null;
        }
    }

    public static int getIntValue(String str, int i) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 2);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, Integer.valueOf(i));
        Uri safeInsert = safeInsert(contentValues);
        if (safeInsert == null) {
            return i;
        }
        String substring = safeInsert.toString().substring(LENGTH_CONTENT_URI);
        if (TextUtils.isEmpty(substring)) {
            return i;
        }
        return Integer.parseInt(substring);
    }

    public static String getStringValue(String str, String str2) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 4);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, str2);
        Uri safeInsert = safeInsert(contentValues);
        if (safeInsert == null) {
            return str2;
        }
        return String.valueOf(safeInsert.toString().substring(LENGTH_CONTENT_URI));
    }

    public static void removeKey(String str) {
        if (!TextUtils.isEmpty(str)) {
            new ContentValues().put(EXTRA_KEY, str);
            try {
                ContentResolver contentResolver = RuntimeCheck.getContentResolver();
                Uri authorities = getAuthorities();
                contentResolver.delete(authorities, EXTRA_KEY + "=?", new String[]{str});
            } catch (Exception e) {
                OLog.m34418e("removeKey() : " + e.getMessage());
            }
        }
    }

    public static boolean contains(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put(EXTRA_TYPE, 3);
        contentValues.put(EXTRA_KEY, str);
        contentValues.put(EXTRA_VALUE, 0);
        if (safeInsert(contentValues) == null) {
            return false;
        }
        return true;
    }

    private static Uri getAuthorities() {
        Uri uri = CONFIG_CONTENT_URI;
        if (uri != null) {
            return uri;
        }
        Uri parse = Uri.parse("content://" + RuntimeCheck.getApplicationId() + ".configprovider");
        CONFIG_CONTENT_URI = parse;
        LENGTH_CONTENT_URI = parse.toString().length() + 1;
        return CONFIG_CONTENT_URI;
    }
}

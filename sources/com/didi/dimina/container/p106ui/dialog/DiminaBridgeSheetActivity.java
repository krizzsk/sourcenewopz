package com.didi.dimina.container.p106ui.dialog;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.text.TextUtils;
import com.didi.component.common.base.ComponentType;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.bridge.base.CallbackFunction;
import com.didi.dimina.container.bridge.sheet.ISheetDialogItemClick;
import com.didi.dimina.container.util.CallBackUtil;
import com.didi.dimina.container.util.ToastUtil;
import com.didi.entrega.customer.app.constant.Const;
import com.didi.sdk.apm.SystemUtils;
import com.didi.security.uuid.share.ShareDBHelper;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* renamed from: com.didi.dimina.container.ui.dialog.DiminaBridgeSheetActivity */
public class DiminaBridgeSheetActivity extends Activity {
    public static final String MEDIA_MODE = "MediaMode";
    public static final String SOURCE = "source";

    /* renamed from: a */
    private static final String f17555a = "album";

    /* renamed from: b */
    private static final String f17556b = "camera";

    /* renamed from: c */
    private static final String f17557c = "video/*";

    /* renamed from: d */
    private static Map<String, CallbackFunction> f17558d = new ConcurrentHashMap();
    /* access modifiers changed from: private */

    /* renamed from: e */
    public static JSONObject f17559e;
    /* access modifiers changed from: private */

    /* renamed from: f */
    public static String f17560f;

    /* renamed from: g */
    private static boolean f17561g;

    /* renamed from: h */
    private static final String[] f17562h = {"_data", "_size"};

    /* renamed from: com.didi.dimina.container.ui.dialog.DiminaBridgeSheetActivity$RequestType */
    @interface RequestType {
        public static final int REQUEST_CODE_ADD_CONTACT = 236;
        public static final int REQUEST_CODE_CHOOSE_CONTACT = 234;
        public static final int REQUEST_CODE_CHOOSE_CONTACT_UPDATE = 235;
        public static final int REQUEST_CODE_CHOOSE_MEDIA = 240;
        public static final int REQUEST_CODE_CHOOSE_VIDEO = 238;
        public static final int REQUEST_CODE_TAKE_MEDIA = 242;
        public static final int REQUEST_CODE_TAKE_VIDEO = 239;
        public static final int REQUEST_CODE_UPDATE_CONTACT = 237;
    }

    /* renamed from: com.didi.dimina.container.ui.dialog.DiminaBridgeSheetActivity$SourceType */
    public @interface SourceType {
        public static final String CONTACT_SUBJSBRIDGE_ADD_PHONE_CONTACT = "ContactSubJSBridgeAddPhoneContact";
        public static final String CONTACT_SUBJSBRIDGE_CHOOSE_CONTACT = "ContactSubJSBridgeChooseContact";
        public static final String VIDEO_CHOOSE = "VideoJSBridgeModuleChooseVideo";
    }

    public static void navigateTo(String str, Activity activity, boolean z) {
        if (activity != null) {
            Intent intent = new Intent(activity, DiminaBridgeSheetActivity.class);
            intent.putExtra("source", str);
            intent.putExtra(MEDIA_MODE, z);
            activity.startActivity(intent);
        }
    }

    public static void navigateTo(String str, Activity activity) {
        navigateTo(str, activity, false);
    }

    /* access modifiers changed from: protected */
    public void onCreate(Bundle bundle) {
        SystemUtils.hookOnlyFullscreenOpaque(this);
        super.onCreate(bundle);
        f17560f = getIntent().getStringExtra("source");
        f17561g = getIntent().getBooleanExtra(MEDIA_MODE, false);
        if (SourceType.CONTACT_SUBJSBRIDGE_CHOOSE_CONTACT.equals(f17560f)) {
            Intent intent = new Intent("android.intent.action.PICK");
            intent.setType("vnd.android.cursor.dir/phone_v2");
            startActivityForResult(intent, 234);
        } else if (SourceType.CONTACT_SUBJSBRIDGE_ADD_PHONE_CONTACT.equals(f17560f)) {
            m13072a(f17560f);
        } else if (SourceType.VIDEO_CHOOSE.equals(f17560f)) {
            m13076b(f17560f);
        } else {
            ToastUtil.show(Dimina.getConfig().getApp(), "无法处理的类型");
            finish();
        }
    }

    /* renamed from: a */
    private void m13072a(String str) {
        ContactDialog contactDialog = new ContactDialog(this);
        final CallbackFunction callbackFunction = f17558d.get(str);
        contactDialog.setBottomDialogItemClick(new ISheetDialogItemClick() {
            public void onClickItemOne() {
                Intent intent = new Intent("android.intent.action.INSERT");
                intent.putExtra("finishActivityOnSaveCompleted", true);
                intent.setType("vnd.android.cursor.dir/raw_contact");
                DiminaBridgeSheetActivity.this.m13065a(intent, DiminaBridgeSheetActivity.f17559e);
                DiminaBridgeSheetActivity.this.startActivityForResult(intent, 236);
            }

            public void onClickItemTwo() {
                Intent intent = new Intent("android.intent.action.PICK");
                intent.setType("vnd.android.cursor.dir/phone_v2");
                DiminaBridgeSheetActivity.this.startActivityForResult(intent, 235);
            }

            public void onCancel() {
                CallBackUtil.onFail("用户取消了操作", callbackFunction);
                DiminaBridgeSheetActivity.removeCallback(DiminaBridgeSheetActivity.f17560f);
                DiminaBridgeSheetActivity.this.finish();
            }
        });
        contactDialog.show();
    }

    /* renamed from: b */
    private void m13076b(String str) {
        final CallbackFunction callbackFunction = f17558d.get(str);
        JSONObject jSONObject = f17559e;
        if (jSONObject == null) {
            if (callbackFunction != null) {
                CallBackUtil.onFail("视频处理失败", callbackFunction);
            }
            finish();
            return;
        }
        JSONArray optJSONArray = jSONObject.optJSONArray("sourceType");
        if (optJSONArray.length() == 1) {
            try {
                String optString = optJSONArray.optString(0);
                if ("album".equals(optString.trim())) {
                    m13078c();
                } else if ("camera".equals(optString.trim())) {
                    m13073a(f17559e);
                } else {
                    CallBackUtil.onFail("sourceType参数不能处理", callbackFunction);
                }
            } catch (Exception unused) {
                CallBackUtil.onFail("选择/拍摄视频失败", callbackFunction);
            }
        } else {
            VideoDialog videoDialog = new VideoDialog(this);
            videoDialog.setBottomDialogItemClick(new ISheetDialogItemClick() {
                public void onClickItemOne() {
                    DiminaBridgeSheetActivity.this.m13073a(DiminaBridgeSheetActivity.f17559e);
                }

                public void onClickItemTwo() {
                    DiminaBridgeSheetActivity.this.m13078c();
                }

                public void onCancel() {
                    CallBackUtil.onFail("用户取消了操作", callbackFunction);
                    DiminaBridgeSheetActivity.removeCallback(DiminaBridgeSheetActivity.f17560f);
                    DiminaBridgeSheetActivity.this.finish();
                }
            });
            videoDialog.show();
        }
    }

    /* access modifiers changed from: protected */
    public void onActivityResult(int i, int i2, Intent intent) {
        super.onActivityResult(i, i2, intent);
        CallbackFunction callbackFunction = f17558d.get(f17560f);
        if (i2 == -1) {
            switch (i) {
                case 234:
                    m13064a(intent, callbackFunction);
                    break;
                case 235:
                    m13066a(intent, f17559e, callbackFunction);
                    break;
                case 236:
                case 237:
                    CallBackUtil.onSuccess(new JSONObject(), callbackFunction);
                    break;
                case 238:
                    Uri data = intent.getData();
                    try {
                        if (f17561g) {
                            m13075b(data, callbackFunction);
                            break;
                        } else {
                            m13067a(data, callbackFunction);
                            break;
                        }
                    } catch (Exception unused) {
                        CallBackUtil.onFail("选择视频失败", callbackFunction);
                        break;
                    }
                case 239:
                    Uri data2 = intent.getData();
                    try {
                        if (f17561g) {
                            m13075b(data2, callbackFunction);
                            break;
                        } else {
                            m13067a(data2, callbackFunction);
                            break;
                        }
                    } catch (Exception unused2) {
                        CallBackUtil.onFail("拍摄视频失败", callbackFunction);
                        break;
                    }
            }
            if (i != 235) {
                removeCallback(f17560f);
                finish();
            }
        } else if (i == 235) {
            CallBackUtil.onFail("用户取消了操作", callbackFunction);
        } else {
            CallBackUtil.onFail("用户取消了操作", callbackFunction);
            removeCallback(f17560f);
            finish();
        }
    }

    public static void registerCallback(String str, JSONObject jSONObject, CallbackFunction callbackFunction) {
        if (!f17558d.containsKey(str)) {
            f17558d.put(str, callbackFunction);
        }
        f17559e = jSONObject;
    }

    public static void removeCallback(String str) {
        if (f17558d.containsKey(str)) {
            f17558d.remove(str);
        }
    }

    /* renamed from: a */
    private void m13064a(Intent intent, CallbackFunction callbackFunction) {
        if (callbackFunction == null) {
            finish();
            return;
        }
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
            cursor.moveToFirst();
            int columnIndex = cursor.getColumnIndex("data1");
            int columnIndex2 = cursor.getColumnIndex("display_name");
            String string = cursor.getString(columnIndex);
            String string2 = cursor.getString(columnIndex2);
            JSONObject jSONObject = new JSONObject();
            jSONObject.put(Const.PageParams.PHONE_NUMBER, string);
            jSONObject.put("displayName", string2);
            if (callbackFunction != null) {
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
            }
            if (cursor == null) {
                return;
            }
        } catch (Exception e) {
            CallBackUtil.onFail("联系人信息查询失败", callbackFunction);
            e.printStackTrace();
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13065a(Intent intent, JSONObject jSONObject) {
        if (jSONObject != null) {
            String optString = jSONObject.optString("mobilePhoneNumber");
            String optString2 = jSONObject.optString("firstName");
            String optString3 = jSONObject.optString("lastName");
            String optString4 = jSONObject.optString("organization");
            String optString5 = jSONObject.optString("title");
            String optString6 = jSONObject.optString("email");
            String optString7 = jSONObject.optString("workPhoneNumber");
            String optString8 = jSONObject.optString("homePhoneNumber");
            intent.putExtra("phone", optString);
            intent.putExtra("name", m13061a(optString2, optString3));
            if (!TextUtils.isEmpty(optString4)) {
                intent.putExtra(ComponentType.COMPANY, optString4);
            }
            if (!TextUtils.isEmpty(optString6)) {
                intent.putExtra("email", optString6);
            }
            if (!TextUtils.isEmpty(optString5)) {
                intent.putExtra("job_title", optString5);
            }
            if (!TextUtils.isEmpty(optString7)) {
                intent.putExtra("secondary_phone", optString7);
                intent.putExtra("secondary_phone_type", 3);
            }
            if (!TextUtils.isEmpty(optString8)) {
                intent.putExtra("tertiary_phone", optString7);
                intent.putExtra("tertiary_phone_type", 1);
            }
        }
    }

    /* renamed from: a */
    private String m13061a(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            return str;
        }
        return str2 + str;
    }

    /* renamed from: a */
    private void m13066a(Intent intent, JSONObject jSONObject, CallbackFunction callbackFunction) {
        Cursor cursor = null;
        try {
            cursor = getContentResolver().query(intent.getData(), (String[]) null, (String) null, (String[]) null, (String) null);
            cursor.moveToFirst();
            m13068a(ContactsContract.Contacts.getLookupUri(cursor.getLong(cursor.getColumnIndex(ShareDBHelper.ID_NAME)), cursor.getString(cursor.getColumnIndex("lookup"))), jSONObject);
            if (cursor == null) {
                return;
            }
        } catch (Exception e) {
            CallBackUtil.onFail("联系人信息更新失败，请检查是否申请了写入联系人权限", callbackFunction);
            e.printStackTrace();
            if (cursor == null) {
                return;
            }
        } catch (Throwable th) {
            if (cursor != null) {
                cursor.close();
            }
            throw th;
        }
        cursor.close();
    }

    /* renamed from: a */
    private void m13068a(Uri uri, JSONObject jSONObject) {
        Intent intent = new Intent("android.intent.action.EDIT");
        intent.putExtra("finishActivityOnSaveCompleted", true);
        intent.setDataAndType(uri, "vnd.android.cursor.item/contact");
        m13065a(intent, jSONObject);
        startActivityForResult(intent, 237);
    }

    /* access modifiers changed from: private */
    /* renamed from: c */
    public void m13078c() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType(f17557c);
        startActivityForResult(intent, 238);
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m13073a(JSONObject jSONObject) {
        int i;
        if (!f17561g) {
            i = Math.min(Math.max(jSONObject.optInt("maxDuration", 10), 3), 60);
        } else {
            i = jSONObject.optInt("maxDuration", 60);
        }
        Intent intent = new Intent("android.media.action.VIDEO_CAPTURE");
        intent.putExtra("android.intent.extra.videoQuality", 1);
        intent.putExtra("android.intent.extra.durationLimit", i);
        startActivityForResult(intent, 239);
    }

    /* renamed from: a */
    private void m13067a(Uri uri, CallbackFunction callbackFunction) throws Exception {
        Cursor query = getContentResolver().query(uri, f17562h, (String) null, (String[]) null, (String) null);
        JSONObject jSONObject = new JSONObject();
        try {
            if (query.getCount() > 0) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                do {
                    jSONObject.put("tempFilePath", query.getString(columnIndexOrThrow));
                } while (query.moveToNext());
            }
            if (!TextUtils.isEmpty(jSONObject.optString("tempFilePath", ""))) {
                JSONObject c = m13077c(jSONObject.optString("tempFilePath", ""));
                jSONObject.put("duration", c.optLong("duration"));
                jSONObject.put("height", c.optLong("height"));
                jSONObject.put("width", c.optLong("width"));
                jSONObject.put("size", c.optLong("size"));
                CallBackUtil.onSuccess(jSONObject, callbackFunction);
                return;
            }
            CallBackUtil.onFail("不存在该视频信息", callbackFunction);
        } catch (Exception unused) {
            CallBackUtil.onFail("读取视频信息异常", callbackFunction);
            if (query != null) {
                query.close();
            }
            throw new Exception("读取视频信息异常");
        }
    }

    /* JADX WARNING: Removed duplicated region for block: B:15:0x0089 A[Catch:{ Exception -> 0x00e9, all -> 0x00e4 }] */
    /* JADX WARNING: Removed duplicated region for block: B:16:0x0098 A[Catch:{ Exception -> 0x00e9, all -> 0x00e4 }] */
    /* renamed from: c */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    private org.json.JSONObject m13077c(java.lang.String r20) {
        /*
            r19 = this;
            r1 = r19
            r0 = r20
            org.json.JSONObject r2 = new org.json.JSONObject
            r2.<init>()
            android.media.MediaMetadataRetriever r3 = new android.media.MediaMetadataRetriever
            r3.<init>()
            boolean r4 = r19.m13080e(r20)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            if (r4 == 0) goto L_0x001c
            android.net.Uri r4 = android.net.Uri.parse(r20)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r3.setDataSource(r1, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            goto L_0x001f
        L_0x001c:
            r3.setDataSource(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
        L_0x001f:
            r4 = 24
            java.lang.String r4 = r3.extractMetadata(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r5 = "90"
            boolean r5 = android.text.TextUtils.equals(r5, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r6 = 19
            r7 = 18
            if (r5 != 0) goto L_0x004b
            java.lang.String r5 = "270"
            boolean r5 = android.text.TextUtils.equals(r5, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            if (r5 == 0) goto L_0x003a
            goto L_0x004b
        L_0x003a:
            java.lang.String r5 = r3.extractMetadata(r7)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            int r5 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toInt(r5)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r6 = r3.extractMetadata(r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            int r6 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toInt(r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            goto L_0x0060
        L_0x004b:
            java.lang.String r5 = r3.extractMetadata(r7)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            int r5 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toInt(r5)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r6 = r3.extractMetadata(r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            int r6 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toInt(r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r18 = r6
            r6 = r5
            r5 = r18
        L_0x0060:
            r7 = 12
            java.lang.String r7 = r3.extractMetadata(r7)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r8 = 20
            java.lang.String r8 = r3.extractMetadata(r8)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r9 = 25
            java.lang.String r9 = r3.extractMetadata(r9)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r10 = 9
            java.lang.String r10 = r3.extractMetadata(r10)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            long r10 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r10)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.io.File r12 = new java.io.File     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r12.<init>(r0)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            boolean r0 = r12.exists()     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r13 = 1024(0x400, double:5.06E-321)
            if (r0 == 0) goto L_0x0098
            java.lang.String r0 = "size"
            long r15 = r12.length()     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r12 = r8
            r17 = r9
            long r8 = r15 / r13
            r2.put(r0, r8)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            goto L_0x009b
        L_0x0098:
            r12 = r8
            r17 = r9
        L_0x009b:
            java.lang.String r0 = "orientation"
            java.lang.String r4 = r1.m13079d(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "type"
            r2.put(r0, r7)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "duration"
            java.lang.Long r4 = java.lang.Long.valueOf(r10)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            long r7 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2.put(r0, r7)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "height"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            long r6 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2.put(r0, r6)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "width"
            java.lang.Integer r4 = java.lang.Integer.valueOf(r5)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            long r4 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "fps"
            long r4 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r17)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            java.lang.String r0 = "bitrate"
            long r4 = com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.ValueOf.toLong(r12)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            long r4 = r4 / r13
            r2.put(r0, r4)     // Catch:{ Exception -> 0x00e9, all -> 0x00e4 }
            goto L_0x00e9
        L_0x00e4:
            r0 = move-exception
            r3.release()
            throw r0
        L_0x00e9:
            r3.release()
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.didi.dimina.container.p106ui.dialog.DiminaBridgeSheetActivity.m13077c(java.lang.String):org.json.JSONObject");
    }

    /* renamed from: d */
    private String m13079d(String str) {
        if (str.equals("90")) {
            return "right";
        }
        if (str.equals("270")) {
            return "left";
        }
        return str.equals("180") ? "down" : "up";
    }

    /* renamed from: e */
    private boolean m13080e(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.startsWith("content://");
    }

    /* renamed from: b */
    private void m13075b(Uri uri, CallbackFunction callbackFunction) throws Exception {
        CallbackFunction callbackFunction2 = callbackFunction;
        if (uri == null) {
            CallBackUtil.onFail("uri 资源路径为空", callbackFunction2);
            return;
        }
        Cursor query = getContentResolver().query(uri, f17562h, (String) null, (String[]) null, (String) null);
        JSONObject jSONObject = new JSONObject();
        try {
            if (query.getCount() > 0) {
                int columnIndexOrThrow = query.getColumnIndexOrThrow("_data");
                query.moveToFirst();
                do {
                    jSONObject.put("tempFilePath", query.getString(columnIndexOrThrow));
                } while (query.moveToNext());
            }
            if (TextUtils.isEmpty(jSONObject.optString("tempFilePath", ""))) {
                CallBackUtil.onFail("媒体文件路径不存在", callbackFunction2);
                return;
            }
            JSONObject c = m13077c(jSONObject.optString("tempFilePath", ""));
            CallBackUtil.onSuccess(m13063a(jSONObject.optString("tempFilePath", ""), c.optLong("duration"), c.optLong("height"), c.optLong("width"), c.optLong("size")), callbackFunction2);
        } catch (Exception unused) {
            CallBackUtil.onFail("读取媒体文件信息异常", callbackFunction2);
            if (query != null) {
                query.close();
            }
            throw new Exception("读取媒体文件信息异常");
        }
    }

    /* renamed from: a */
    private JSONObject m13063a(String str, long j, long j2, long j3, long j4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        JSONObject jSONObject2 = new JSONObject();
        jSONObject2.put("tempFilePath", str);
        jSONObject2.put("duration", j);
        jSONObject2.put("height", j2);
        jSONObject2.put("width", j3);
        jSONObject2.put("size", j4);
        JSONArray jSONArray = new JSONArray();
        jSONArray.put(jSONObject2);
        jSONObject.put("tempFiles", jSONArray);
        jSONObject.put("type", "video");
        return jSONObject;
    }

    /* renamed from: com.didi.dimina.container.ui.dialog.DiminaBridgeSheetActivity$ValueOf */
    public static class ValueOf {
        /* renamed from: to */
        public static <T> T m13081to(Object obj, T t) {
            return obj == null ? t : obj;
        }

        public static String toString(Object obj) {
            try {
                return obj.toString();
            } catch (Exception unused) {
                return "";
            }
        }

        public static long toLong(Object obj, long j) {
            long j2;
            if (obj == null) {
                return j;
            }
            try {
                String trim = obj.toString().trim();
                if (trim.contains(".")) {
                    j2 = Long.valueOf(trim.substring(0, trim.lastIndexOf("."))).longValue();
                } else {
                    j2 = Long.valueOf(trim).longValue();
                }
                return j2;
            } catch (Exception unused) {
                return j;
            }
        }

        public static long toLong(Object obj) {
            return toLong(obj, 0);
        }

        public static int toInt(Object obj, int i) {
            int i2;
            if (obj == null) {
                return i;
            }
            try {
                String trim = obj.toString().trim();
                if (trim.contains(".")) {
                    i2 = Integer.valueOf(trim.substring(0, trim.lastIndexOf("."))).intValue();
                } else {
                    i2 = Integer.valueOf(trim).intValue();
                }
                return i2;
            } catch (Exception unused) {
                return i;
            }
        }

        public static int toInt(Object obj) {
            return toInt(obj, 0);
        }
    }
}

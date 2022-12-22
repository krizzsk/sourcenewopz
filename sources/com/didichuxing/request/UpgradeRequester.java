package com.didichuxing.request;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import com.didichuxing.bean.UpdateResponse;
import com.didichuxing.util.HttpParamUtils;
import com.didichuxing.util.UpLogger;
import com.didichuxing.util.UpgradeSp;
import com.didiglobal.enginecore.data.parser.XEParseConst;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.Map;
import org.json.JSONException;
import org.json.JSONObject;

class UpgradeRequester extends UpgradeBaseRequest {

    /* renamed from: a */
    private static final String f48498a = "UpgradeSDK_InfoRequester";

    /* renamed from: b */
    private static final int f48499b = 999;

    /* renamed from: c */
    private HttpURLConnection f48500c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public RequestCallback f48501d;

    /* renamed from: e */
    private Map<String, String> f48502e = new HashMap();

    /* renamed from: f */
    private Handler f48503f = new Handler(Looper.getMainLooper()) {
        public void handleMessage(Message message) {
            if (UpgradeRequester.this.f48501d != null) {
                if (message == null) {
                    UpgradeRequester.this.f48501d.requestFailed(999);
                    return;
                }
                UpdateResponse updateResponse = (UpdateResponse) message.obj;
                if (updateResponse != null) {
                    UpgradeRequester.this.f48501d.requestSucceed(updateResponse);
                    return;
                }
                UpgradeRequester.this.f48501d.requestFailed(message.what);
                UpLogger.m35522d(UpgradeRequester.f48498a, "request update info failed. errCode = " + message.what);
            }
        }
    };

    public interface RequestCallback {
        void requestFailed(int i);

        void requestSucceed(UpdateResponse updateResponse);
    }

    public UpgradeRequester(Context context, RequestCallback requestCallback) {
        C16280a.m34792a(context, this.f48502e);
        C16280a.m34794b(context, this.f48502e);
        C16280a.m34793a(this.f48502e);
        Map<String, String> map = this.f48502e;
        map.put("gp_test", UpgradeSp.Companion.getInstance().getHasJoinedPlan() + "");
        this.f48501d = requestCallback;
    }

    /* renamed from: a */
    public void mo120186a() {
        StringBuilder sb = new StringBuilder(getHost() + "/muse/update/v2?");
        Map<String, String> map = this.f48502e;
        if (map != null) {
            sb.append(HttpParamUtils.getParamStrStr(map));
        }
        String sb2 = sb.toString();
        UpLogger.m35522d(f48498a, "request url = " + sb2);
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) new URL(sb2).openConnection();
            this.f48500c = httpURLConnection;
            httpURLConnection.setRequestMethod("GET");
            this.f48500c.setConnectTimeout(15000);
            this.f48500c.connect();
            int responseCode = this.f48500c.getResponseCode();
            if (responseCode == 200) {
                InputStream inputStream = this.f48500c.getInputStream();
                byte[] bArr = new byte[1024];
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                while (true) {
                    int read = inputStream.read(bArr);
                    if (read == -1) {
                        break;
                    }
                    byteArrayOutputStream.write(bArr, 0, read);
                }
                String byteArrayOutputStream2 = byteArrayOutputStream.toString("utf-8");
                inputStream.close();
                byteArrayOutputStream.close();
                UpdateResponse a = m34788a(byteArrayOutputStream2);
                if (a != null) {
                    this.f48501d.requestSucceed(a);
                    UpLogger.m35522d(f48498a, "request response = " + a.toString());
                } else {
                    this.f48501d.requestFailed(999);
                    UpLogger.m35522d(f48498a, "request fail code = " + responseCode);
                }
            } else {
                this.f48501d.requestFailed(responseCode);
                UpLogger.m35522d(f48498a, "request fail code = " + responseCode);
            }
        } catch (Exception e) {
            this.f48503f.sendEmptyMessage(999);
            e.printStackTrace();
        } catch (Throwable th) {
            this.f48500c.disconnect();
            throw th;
        }
        this.f48500c.disconnect();
    }

    /* renamed from: a */
    private static UpdateResponse m34788a(String str) {
        try {
            JSONObject jSONObject = new JSONObject(str);
            int optInt = jSONObject.optInt("err_no");
            String optString = jSONObject.optString("err_msg");
            if (optInt != 0) {
                return new UpdateResponse(optInt, optString);
            }
            JSONObject jSONObject2 = new JSONObject(jSONObject.optString("data"));
            String optString2 = jSONObject2.optString("abn_content");
            String optString3 = jSONObject2.optString("abn_ignore");
            String optString4 = jSONObject2.optString("abn_title");
            String optString5 = jSONObject2.optString("abn_update");
            boolean optBoolean = jSONObject2.optBoolean("is_force");
            boolean optBoolean2 = jSONObject2.optBoolean("need_update");
            int optInt2 = jSONObject2.optInt("task_id");
            int optInt3 = jSONObject2.optInt(XEParseConst.UPDATE_TYPE_TAG);
            String optString6 = jSONObject2.optString("update_url");
            String optString7 = jSONObject2.optString("version");
            int optInt4 = jSONObject2.optInt(ServerParam.PARAM_VERSION_CODE);
            int optInt5 = jSONObject2.optInt("version_id");
            UpdateResponse.Builder builder = new UpdateResponse.Builder();
            builder.errNum(optInt).errMsg(optString).updateDesc(optString2).ignoreBtn(optString3).updateTitle(optString4).isForce(optBoolean).updateBtn(optString5).needUpdate(optBoolean2).taskId(optInt2).updateType(optInt3).updateUrl(optString6).version(optString7).versionCode(optInt4).versionId(optInt5);
            return builder.builder();
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }
}

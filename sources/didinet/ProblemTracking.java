package didinet;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.util.HashMap;
import org.json.JSONObject;
import xcrash.TombstoneParser;

public class ProblemTracking {
    public static final int MSG_WHAT_EXCEPTION_LOG = 2;
    public static final int MSG_WHAT_NORMAL_LOG = 1;

    /* renamed from: a */
    private static final String f57130a = "/sdcard/.classloader_crash_dump.log";

    /* renamed from: b */
    private boolean f57131b;

    /* renamed from: c */
    private TrackingHandler f57132c;

    private static class SingletonHolder {
        /* access modifiers changed from: private */
        public static ProblemTracking INSTANCE = new ProblemTracking();

        private SingletonHolder() {
        }
    }

    public static ProblemTracking getInstance() {
        return SingletonHolder.INSTANCE;
    }

    private ProblemTracking() {
        boolean allow = NetEngine.getInstance().getApolloAPI().getToggle("networking_problem_tracking").allow();
        this.f57131b = allow;
        Logger.m40928d("networking", String.format("apollo allow => [%s]", new Object[]{Boolean.valueOf(allow)}));
        HandlerThread handlerThread = new HandlerThread("ProblemTracking");
        handlerThread.start();
        this.f57132c = new TrackingHandler(handlerThread.getLooper());
    }

    public void recordContextInfo(Class cls, boolean z, String str) {
        Logger.m40928d("networking", "call method recordContextInfo");
        if (this.f57131b) {
            int i = 1;
            if (!z) {
                this.f57132c.removeMessages(1);
            }
            Message message = new Message();
            if (z) {
                i = 2;
            }
            message.what = i;
            message.obj = new LogInfo(cls, z, str);
            this.f57132c.sendMessage(message);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m40953a(LogInfo logInfo) {
        LogInfo logInfo2 = logInfo;
        String str = "networking";
        if (logInfo2 != null && logInfo2.cls != null) {
            Class cls = logInfo2.cls;
            boolean z = logInfo2.omegaUp;
            String str2 = logInfo2.filePath;
            if (TextUtils.isEmpty(str2)) {
                str2 = f57130a;
            }
            try {
                String stackTraceString = Log.getStackTraceString(new Throwable());
                ClassLoader classLoader = cls.getClassLoader();
                String str3 = classLoader.getClass().getCanonicalName() + "@" + System.identityHashCode(classLoader);
                int myPid = Process.myPid();
                int myTid = Process.myTid();
                if (!z) {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("trace", stackTraceString).put("cl", str3).put("pid", myPid).put(TombstoneParser.keyThreadId, myTid);
                    FileOutputStream fileOutputStream = new FileOutputStream(str2);
                    String jSONObject2 = jSONObject.toString();
                    fileOutputStream.write(jSONObject2.getBytes());
                    fileOutputStream.close();
                    Logger.m40928d(str, "" + jSONObject2);
                    return;
                }
                FileInputStream fileInputStream = new FileInputStream(str2);
                ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
                byte[] bArr = new byte[1024];
                while (true) {
                    int read = fileInputStream.read(bArr);
                    if (read != -1) {
                        byteArrayOutputStream.write(bArr, 0, read);
                    } else {
                        fileInputStream.close();
                        byteArrayOutputStream.close();
                        String byteArrayOutputStream2 = byteArrayOutputStream.toString();
                        Logger.m40928d(str, "last json is =>" + byteArrayOutputStream2);
                        JSONObject jSONObject3 = new JSONObject(byteArrayOutputStream2);
                        String string = jSONObject3.getString("trace");
                        String string2 = jSONObject3.getString("cl");
                        int i = jSONObject3.getInt("pid");
                        int i2 = jSONObject3.getInt(TombstoneParser.keyThreadId);
                        OmegaAPI omegaAPI = NetEngine.getInstance().getOmegaAPI();
                        HashMap hashMap = new HashMap();
                        String str4 = str;
                        try {
                            hashMap.put("lastTrace", string);
                            hashMap.put("lastCl", string2);
                            hashMap.put("lastPid", Integer.valueOf(i));
                            hashMap.put("lastTid", Integer.valueOf(i2));
                            hashMap.put("trace", stackTraceString);
                            hashMap.put("cl", str3);
                            hashMap.put("pid", Integer.valueOf(myPid));
                            hashMap.put(TombstoneParser.keyThreadId, Integer.valueOf(myTid));
                            omegaAPI.trackEvent("networking_problem_tracking", "detail", hashMap);
                            str = str4;
                            Logger.m40928d(str, "" + hashMap);
                            Logger.m40928d(str, "upload omega success");
                            return;
                        } catch (Throwable th) {
                            th = th;
                            str = str4;
                            Logger.m40928d(str, Log.getStackTraceString(th));
                            return;
                        }
                    }
                }
            } catch (Throwable th2) {
                th = th2;
            }
        }
    }

    private class TrackingHandler extends Handler {
        public TrackingHandler(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            super.handleMessage(message);
            int i = message.what;
            if (i == 1 || i == 2) {
                ProblemTracking.this.m40953a((LogInfo) message.obj);
            }
        }
    }

    private static class LogInfo {
        Class cls;
        String filePath;
        boolean omegaUp;

        LogInfo(Class cls2, boolean z, String str) {
            this.cls = cls2;
            this.omegaUp = z;
            this.filePath = str;
        }
    }
}

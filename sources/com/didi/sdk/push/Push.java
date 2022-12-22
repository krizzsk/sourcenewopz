package com.didi.sdk.push;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.didi.sdk.push.IPushCallback;
import com.didi.sdk.push.PushItem;
import com.didi.sdk.push.log.LoadErrorEvent;

class Push {
    private static int retryNum;
    private volatile IPushCallback mPushCallback;

    public native int config(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, int i9, int i10, int i11, int i12, int i13, int i14, int i15, int i16, int i17, int i18);

    public native int configLite(int i, int i2, int i3);

    public native void destory();

    public native int init(Context context);

    public native boolean isConnected();

    public native int localIPStackDetect();

    public native void onAppEvent(int i, int i2);

    public native int request(int i, byte[] bArr, int i2, byte[] bArr2, boolean z);

    public native int restartConnChannel(String str, int i, int i2, String str2, String str3, byte[] bArr);

    public native void setBusinessType(int i);

    public native void setDebugMode(int i);

    public native int startConnChannel(String str, int i, int i2, String str2, String str3, byte[] bArr);

    public native int startLoop();

    public native int stopConnChannel();

    public native int stopLoop();

    Push() {
    }

    public static Push getInstance() {
        return InstanceHolder.PUSH;
    }

    private static class InstanceHolder {
        /* access modifiers changed from: private */
        public static final Push PUSH = new Push();

        private InstanceHolder() {
        }
    }

    private static void loadRecursive() {
        PushItem next = PushSelector.getDefault().next();
        if (next != null) {
            try {
                PushLog.m26280d("PushSelector", String.format("加载so[%s]", new Object[]{next.getLibNameOrAddress()}));
                PushLog.mLogger.info("PushSelector", String.format("加载so[%s]", new Object[]{next.getLibNameOrAddress()}));
                if (next.getLoadType() == PushItem.LoadType.LOAD_FROM_NAME) {
                    System.loadLibrary(next.getLibNameOrAddress());
                } else {
                    System.load(next.getLibNameOrAddress());
                }
            } catch (Throwable th) {
                PushLog.m26280d("PushSelector", String.format("crash happens with [%s],error is [%s]", new Object[]{next.getLibNameOrAddress(), Log.getStackTraceString(th)}));
                PushLog.mLogger.info("PushSelector", String.format("crash happens with [%s],error is [%s]", new Object[]{next.getLibNameOrAddress(), Log.getStackTraceString(th)}));
                LoadErrorEvent loadErrorEvent = new LoadErrorEvent();
                loadErrorEvent.setSoName(next.getLibNameOrAddress());
                loadErrorEvent.setError(th.getMessage());
                LogEventManager.getInstance().onPushLoadError(loadErrorEvent);
                loadRecursive();
            }
        }
    }

    static {
        loadRecursive();
    }

    public Object callback(int i, int i2, String str, byte[] bArr) {
        try {
            return callback0(i, i2, str, bArr);
        } catch (Throwable unused) {
            return null;
        }
    }

    private Object callback0(int i, int i2, String str, byte[] bArr) {
        IPushCallback iPushCallback = this.mPushCallback;
        if (iPushCallback == null) {
            return null;
        }
        switch (i) {
            case 0:
                int i3 = 1;
                if (!TextUtils.isEmpty(str)) {
                    try {
                        i3 = Integer.parseInt(str);
                    } catch (NumberFormatException unused) {
                    }
                }
                IPushCallback.Connection connection = new IPushCallback.Connection();
                connection.code = i2;
                connection.subCode = i3;
                iPushCallback.onConnection(connection);
                break;
            case 1:
                IPushCallback.Message fromBytes = IPushCallback.Message.fromBytes(bArr);
                iPushCallback.onRequested(i2, fromBytes.msgType, fromBytes.seqId);
                break;
            case 2:
                IPushCallback.Message fromBytes2 = IPushCallback.Message.fromBytes(bArr);
                iPushCallback.onReceive(fromBytes2.msgType, fromBytes2.seqId, fromBytes2.body);
                break;
            case 3:
                IPushCallback.Progress fromBytes3 = IPushCallback.Progress.fromBytes(bArr);
                iPushCallback.onProgress(fromBytes3.seqId, fromBytes3.state, fromBytes3.percent);
                break;
            case 4:
                iPushCallback.onLog(i2, str);
                break;
            case 6:
                return this.mPushCallback.onHandleHeader(bArr);
            case 8:
                iPushCallback.onTrackTransaction(IPushCallback.SocketTransactionEvent.fromBytes(bArr));
                break;
            case 9:
                iPushCallback.onTrackConnection(IPushCallback.SocketConnectionEvent.fromBytes(bArr));
                break;
            case 10:
                iPushCallback.onTrackAvailableRate(IPushCallback.AvailableRateEvent.formBytes(bArr));
                break;
            case 11:
                iPushCallback.onConnection(IPushCallback.Connection.fromBytes(bArr));
                break;
            case 12:
                iPushCallback.onTrackConnection(IPushCallback.SocketConnectionEventV2.fromBytes(bArr));
                break;
            case 13:
                iPushCallback.onTrackMsgAck(IPushCallback.MsgAckEvent.fromBytes(bArr));
                break;
            case 14:
                IPushCallback.Message fromBytes4 = IPushCallback.Message.fromBytes(bArr);
                iPushCallback.onRequested(0, fromBytes4.msgType, fromBytes4.seqId);
                break;
            case 15:
                iPushCallback.onTrackMsgFlux(IPushCallback.MsgFluxEvent.fromBytes(bArr));
                break;
            case 16:
                iPushCallback.onTrackPushQualityEvent(IPushCallback.PushQualityEvent.fromBytes(bArr));
                break;
        }
        return null;
    }

    public void setCallback(IPushCallback iPushCallback) {
        this.mPushCallback = iPushCallback;
    }
}

package com.didi.map.sdk.navtracker;

import android.content.Context;
import android.os.AsyncTask;
import com.didi.map.sdk.maprouter.global.PlatInfo;
import com.didi.map.sdk.navtracker.log.DLog;
import com.didi.map.sdk.proto.driver_gl.TgReq;
import com.didi.map.sdk.proto.driver_gl.TgRes;
import com.squareup.wire.Wire;
import java.util.UUID;

public class TripIdHelper {

    /* renamed from: a */
    private static final String f28572a = "TripIdHelper";
    /* access modifiers changed from: private */

    /* renamed from: b */
    public static String f28573b = "https://apimap.didiglobal.com/navi/google/tripid/sctx2/";

    public static void request(Context context, RequestTripIdInfo requestTripIdInfo, IFetchTripCallback iFetchTripCallback) {
        if (!TrackerNetUtils.isInitialized()) {
            TrackerNetUtils.init(context);
        }
        f28573b = PlatInfo.getInstance().getApiMapDomain() + "/navi/google/tripid/sctx2/";
        DLog.m20199d(f28572a, "url: " + f28573b, new Object[0]);
        new FetchTripIdTask(new TgReq.Builder().apiname(requestTripIdInfo.getApiName()).scenes(requestTripIdInfo.getScenes()).token(requestTripIdInfo.getTicket()).oidPidPairs(requestTripIdInfo.getOidPidPairList()).build(), iFetchTripCallback).execute(new Void[0]);
    }

    private static class FetchTripIdTask extends AsyncTask<Void, Void, TgRes> {
        private IFetchTripCallback mCallback;
        private TgReq mTgReq;

        FetchTripIdTask(TgReq tgReq, IFetchTripCallback iFetchTripCallback) {
            this.mTgReq = tgReq;
            this.mCallback = iFetchTripCallback;
        }

        /* access modifiers changed from: protected */
        public TgRes doInBackground(Void... voidArr) {
            try {
                return (TgRes) new Wire((Class<?>[]) new Class[0]).parseFrom(TrackerNetUtils.doPost(TripIdHelper.f28573b, this.mTgReq.toByteArray()), TgRes.class);
            } catch (Exception e) {
                DLog.m20199d(TripIdHelper.f28572a, " request exception = " + e, new Object[0]);
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(TgRes tgRes) {
            if (this.mCallback == null) {
                DLog.m20199d(TripIdHelper.f28572a, " request tripId callback is null", new Object[0]);
            } else if (tgRes == null) {
                String genRandomTripId = TripIdHelper.genRandomTripId();
                DLog.m20199d(TripIdHelper.f28572a, " request TripeId return null " + genRandomTripId, new Object[0]);
                this.mCallback.onResult(genRandomTripId);
            } else if (tgRes.ret.intValue() != 0) {
                String genRandomTripId2 = TripIdHelper.genRandomTripId();
                DLog.m20199d(TripIdHelper.f28572a, " request TripeId fail ret=%d , msg=%s " + genRandomTripId2, tgRes.ret, tgRes.msg);
                this.mCallback.onResult(genRandomTripId2);
            } else if (tgRes.tripIds.isEmpty()) {
                String genRandomTripId3 = TripIdHelper.genRandomTripId();
                DLog.m20199d(TripIdHelper.f28572a, " request TripeId fail tripId is empty " + genRandomTripId3, new Object[0]);
                this.mCallback.onResult(genRandomTripId3);
            } else {
                String str = tgRes.tripIds.get(0);
                DLog.m20199d(TripIdHelper.f28572a, "tripId fetch success: " + str, new Object[0]);
                this.mCallback.onResult(str);
            }
        }
    }

    public static String genRandomTripId() {
        return UUID.randomUUID().toString().replace("-", "");
    }
}

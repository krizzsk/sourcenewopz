package com.didi.map.global.component.line.data.route;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.didi.common.map.util.DLog;
import com.didi.common.map.util.NetUtils;
import com.didi.map.global.component.line.data.IRouteSearchResultCallback;
import com.didi.map.global.component.line.data.param.OrderTrajLineRequest;
import com.didi.map.global.model.URLHelper;
import com.didi.map.global.model.omega.AlarmOmegaUtil;
import com.didi.map.sdk.env.PaxEnvironment;
import com.didi.map.sdk.proto.driver_gl.MapDriver;
import com.didi.map.sdk.proto.driver_gl.OrderTrajRequest;
import com.didi.map.sdk.proto.driver_gl.OrderTrajResponse;
import com.squareup.wire.Wire;
import java.util.Collections;

public class OrderTrajRoute extends BaseLineRoute<OrderTrajLineRequest> {
    public static final String TAG = "OrderTrajRoute";

    public interface OrderTrajCallback {
        void onFailed();

        void onSuccess(OrderTrajResponse orderTrajResponse);
    }

    public void start(OrderTrajLineRequest orderTrajLineRequest, final IRouteSearchResultCallback iRouteSearchResultCallback) {
        if (checkCommonParamIsRight(orderTrajLineRequest, iRouteSearchResultCallback)) {
            new OrderTrajAyncTask(getContext(), new OrderTrajCallback() {
                public void onSuccess(OrderTrajResponse orderTrajResponse) {
                    if (!OrderTrajRoute.this.isDestroy() && orderTrajResponse != null) {
                        if (orderTrajResponse.ret.intValue() != 0) {
                            AlarmOmegaUtil.trackOrderTrajResultError(orderTrajResponse.ret.intValue(), orderTrajResponse.logId.longValue());
                        }
                        if (iRouteSearchResultCallback != null) {
                            iRouteSearchResultCallback.onGetRouteResult(OrderTrajRoute.this.packageResponse(orderTrajResponse));
                        }
                    }
                }

                public void onFailed() {
                    IRouteSearchResultCallback iRouteSearchResultCallback = iRouteSearchResultCallback;
                    if (iRouteSearchResultCallback != null) {
                        iRouteSearchResultCallback.onGetRouteResultError("TODO");
                    }
                }
            }).execute(new byte[][]{m18387a(orderTrajLineRequest)});
        }
    }

    /* renamed from: a */
    private byte[] m18387a(OrderTrajLineRequest orderTrajLineRequest) {
        if (orderTrajLineRequest == null) {
            return null;
        }
        OrderTrajRequest.Builder builder = new OrderTrajRequest.Builder();
        MapDriver.Builder builder2 = new MapDriver.Builder();
        builder2.driverId = Long.valueOf(orderTrajLineRequest.driverId);
        builder2.biztype = Integer.valueOf(orderTrajLineRequest.biztype);
        builder2.startTime = Long.valueOf(orderTrajLineRequest.startTime);
        builder2.endTime = Long.valueOf(orderTrajLineRequest.endTime);
        builder.drivers = Collections.singletonList(builder2.build());
        builder.didiVersion = orderTrajLineRequest.clientVersion;
        builder.source = TextUtils.isEmpty(orderTrajLineRequest.source) ? "passenger" : orderTrajLineRequest.source;
        builder.token = PaxEnvironment.getInstance().getToken();
        String str = "";
        builder.phoneNum = TextUtils.isEmpty(orderTrajLineRequest.passengerPhoneNumber) ? str : orderTrajLineRequest.passengerPhoneNumber;
        if (!TextUtils.isEmpty(orderTrajLineRequest.imei)) {
            str = orderTrajLineRequest.imei;
        }
        builder.imei = str;
        builder.callerId = TextUtils.isEmpty(orderTrajLineRequest.callerId) ? "OrderRouteAPI_dia_traj" : orderTrajLineRequest.callerId;
        try {
            OrderTrajRequest build = builder.build();
            if (orderTrajLineRequest.driverId == 0 || orderTrajLineRequest.driverId < 0) {
                AlarmOmegaUtil.trackOrderTrajParamError(2);
            } else if (orderTrajLineRequest.biztype == 0 || orderTrajLineRequest.biztype < 0) {
                AlarmOmegaUtil.trackOrderTrajParamError(1);
            } else if (TextUtils.isEmpty(PaxEnvironment.getInstance().getToken())) {
                AlarmOmegaUtil.trackOrderTrajParamError(3);
            }
            return build.toByteArray();
        } catch (Exception e) {
            DLog.m7384d(TAG, e.toString(), new Object[0]);
            return null;
        }
    }

    private static class OrderTrajAyncTask extends AsyncTask<byte[], Integer, OrderTrajResponse> {
        private String TAG = "OrderTrajAyncTask";
        private OrderTrajCallback mCallback;
        private Context mContext;

        public OrderTrajAyncTask(Context context, OrderTrajCallback orderTrajCallback) {
            this.mCallback = orderTrajCallback;
            this.mContext = context;
        }

        /* access modifiers changed from: protected */
        public OrderTrajResponse doInBackground(byte[]... bArr) {
            try {
                OrderTrajUrls.setOrderTrajHost(URLHelper.getUrlHost(this.mContext));
                byte[] doPost = NetUtils.doPost(OrderTrajUrls.getOrderTrajUrl(this.mContext), bArr[0]);
                if (doPost == null) {
                    DLog.m7384d(this.TAG, "OrderTrajAyncTask doInBackground() response == null", new Object[0]);
                    return null;
                }
                OrderTrajResponse orderTrajResponse = (OrderTrajResponse) new Wire((Class<?>[]) new Class[0]).parseFrom(doPost, OrderTrajResponse.class);
                if (orderTrajResponse != null && orderTrajResponse.ret.intValue() == 0) {
                    return orderTrajResponse;
                }
                return null;
            } catch (Exception e) {
                e.printStackTrace();
                return null;
            }
        }

        /* access modifiers changed from: protected */
        public void onPostExecute(OrderTrajResponse orderTrajResponse) {
            super.onPostExecute(orderTrajResponse);
            OrderTrajCallback orderTrajCallback = this.mCallback;
            if (orderTrajCallback == null) {
                return;
            }
            if (orderTrajResponse != null) {
                orderTrajCallback.onSuccess(orderTrajResponse);
            } else {
                orderTrajCallback.onFailed();
            }
        }
    }
}

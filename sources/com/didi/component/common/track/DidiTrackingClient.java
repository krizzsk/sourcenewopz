package com.didi.component.common.track;

import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import com.didi.component.business.util.CarOrderHelper;
import com.didi.component.business.util.GlobalApolloUtil;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.component.common.util.GLog;
import com.didi.sdk.app.DIDIApplication;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.messagecenter.p152pb.PassengerState;
import com.didi.sdk.nation.NationTypeUtil;
import com.didi.sdk.protobuf.BinaryMsg;
import com.didi.sdk.push.PushClient;
import com.didi.sdk.push.PushRequest;
import com.didi.sdk.push.PushRequestCallback;
import com.didi.sdk.util.SystemUtil;
import com.didi.trackupload.sdk.ICommonInfoDelegate;
import com.didi.trackupload.sdk.ITrackDataDelegate;
import com.didi.trackupload.sdk.TrackClient;
import com.didi.trackupload.sdk.TrackClientType;
import com.didi.trackupload.sdk.TrackInitParams;
import com.didi.trackupload.sdk.TrackManager;
import com.didi.trackupload.sdk.TrackOptions;
import com.didi.trackupload.sdk.datachannel.IDataChannel;
import com.didi.trackupload.sdk.datachannel.IDataChannelMsgCallback;
import com.didi.travel.psnger.model.response.CarOrder;
import com.didi.travel.psnger.p169pb.CollectSvrCoordinateReq;
import com.didi.travel.psnger.utils.NumberUtil;
import com.didi.travel.psnger.utils.TimeUtil;
import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import java.math.BigInteger;

public class DidiTrackingClient {

    /* renamed from: b */
    private static volatile DidiTrackingClient f11719b = null;

    /* renamed from: e */
    private static final int f11720e = 0;

    /* renamed from: f */
    private static final int f11721f = 1;

    /* renamed from: g */
    private static final int f11722g = 3;

    /* renamed from: h */
    private static final int f11723h = 9;

    /* renamed from: i */
    private static final int f11724i = 36;

    /* renamed from: j */
    private static final int f11725j = 72;

    /* renamed from: s */
    private static final int f11726s = 1;

    /* renamed from: t */
    private static final int f11727t = 2;
    public static final String trackID = "global_tracker";

    /* renamed from: a */
    private final Logger f11728a = LoggerFactory.getLogger(getClass());

    /* renamed from: c */
    private TrackClient f11729c;

    /* renamed from: d */
    private ILocation.ILocateStatusListener f11730d;

    /* renamed from: k */
    private boolean f11731k = false;

    /* renamed from: l */
    private int f11732l = 3;

    /* renamed from: m */
    private int f11733m = 0;

    /* renamed from: n */
    private int f11734n = -1;

    /* renamed from: o */
    private int f11735o;

    /* renamed from: p */
    private long f11736p = 0;

    /* renamed from: q */
    private int f11737q = GlobalApolloUtil.getUploadFrequencyThreshold();

    /* renamed from: r */
    private int f11738r = GlobalApolloUtil.getUploadFrequencyInterval();

    /* renamed from: u */
    private String f11739u = "oid";

    /* renamed from: v */
    private int f11740v = -1;

    private DidiTrackingClient() {
    }

    public static DidiTrackingClient getInstance() {
        if (f11719b == null) {
            synchronized (DidiTrackingClient.class) {
                if (f11719b == null) {
                    f11719b = new DidiTrackingClient();
                }
            }
        }
        return f11719b;
    }

    public boolean checkTrackingIsReduced() {
        CarOrder order;
        if (!(this.f11737q == 0 || this.f11738r == 0 || (order = CarOrderHelper.getOrder()) == null || (order.substatus != 4001 && order.substatus != 4002))) {
            TrackClient trackClient = this.f11729c;
            if (trackClient != null && trackClient.getTrackOptions() != null && this.f11729c.getTrackOptions().getUploadIntervalMode() != null && this.f11729c.getTrackOptions().getUploadIntervalMode().value() >= ((long) (this.f11738r * 1000))) {
                return true;
            }
            long currentTimeMillis = System.currentTimeMillis();
            long j = this.f11736p;
            if (j != 0 && this.f11735o == 1 && currentTimeMillis - j > ((long) this.f11737q)) {
                GLog.m7968e("checkTrackingIsReduced", "降低频率：threshold:" + this.f11737q + ",interval:" + this.f11738r);
                startTracking(1, this.f11738r);
                return true;
            }
        }
        return false;
    }

    public synchronized void startTracking(final int i, int i2) {
        TrackOptions.UploadIntervalMode uploadIntervalMode;
        if (i2 != 0) {
            if (i2 == 1) {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.ULTRAHIGH_FREQUENCY;
            } else if (i2 == 3) {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.HIGH_FREQUENCY;
            } else if (i2 == 9) {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.NORMAL;
            } else if (i2 == 36) {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.LOW_FREQUENCY;
            } else if (i2 != 72) {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.HIGH_FREQUENCY;
            } else {
                uploadIntervalMode = TrackOptions.UploadIntervalMode.BATTERY_SAVE;
            }
            if (this.f11735o != i) {
                stopTracking();
                this.f11735o = i;
            }
            if (this.f11729c == null) {
                TrackClient createTrackClient = TrackManager.getIntance().createTrackClient(TrackClientType.PASSENGER, trackID);
                this.f11729c = createTrackClient;
                createTrackClient.setTrackOptions(new TrackOptions(TrackOptions.GatherIntervalMode.NEVER, uploadIntervalMode));
                this.f11729c.setTrackDataDelegate(new ITrackDataDelegate() {
                    public byte[] getCustomData() {
                        return DidiTrackingClient.this.m7947a(i).build().toByteArray();
                    }
                });
                Logger logger = this.f11728a;
                logger.info("trackClient stop tracking now start:" + i2, new Object[0]);
                if (CarOrderHelper.getOrder() != null && (CarOrderHelper.getOrder().substatus == 4001 || CarOrderHelper.getOrder().substatus == 4002)) {
                    this.f11736p = System.currentTimeMillis();
                    GLog.m7968e("checkTrackingIsReduced", "开始时间 threshold:" + this.f11737q + ",interval:" + i2);
                }
            }
            if (this.f11734n != 0) {
                this.f11734n = this.f11729c.startTrack();
                if (this.f11730d == null) {
                    this.f11730d = new ILocation.ILocateStatusListener() {
                        public void onStatusUpdate(String str, int i, String str2) {
                        }
                    };
                    LocationPerformer.getInstance().addLocateStatusListener(this.f11730d);
                }
            }
            m7949a(uploadIntervalMode);
            return;
        }
        stopTracking();
    }

    /* renamed from: a */
    private void m7949a(TrackOptions.UploadIntervalMode uploadIntervalMode) {
        String str;
        TrackOptions.GatherIntervalMode gatherIntervalMode;
        if (m7946a() == 1) {
            str = "PickUpPassengersSamplingFrequency_Android";
        } else if (m7946a() == 2) {
            str = "SendPassengersSamplingFrequency_Android";
        } else {
            str = null;
            GLog.m7968e("DidiTrackingClient", "startTracking: getOrderStatus()==0");
        }
        if (!TextUtils.isEmpty(str)) {
            CarOrder order = CarOrderHelper.getOrder();
            int i = this.f11740v;
            if (order != null && !TextUtils.isEmpty(order.getOid()) && !this.f11739u.equals(order.getOid())) {
                i = GlobalApolloUtil.getTrackReportingFrequencyFor(str);
                this.f11739u = order.getOid();
                this.f11740v = i;
            }
            if (i == 1000) {
                gatherIntervalMode = TrackOptions.GatherIntervalMode.HIGH_FREQUENCY;
            } else if (i == 3000) {
                gatherIntervalMode = TrackOptions.GatherIntervalMode.NORMAL;
            } else if (i == 9000) {
                gatherIntervalMode = TrackOptions.GatherIntervalMode.LOW_FREQUENCY;
            } else if (i != 36000) {
                gatherIntervalMode = TrackOptions.GatherIntervalMode.NEVER;
            } else {
                gatherIntervalMode = TrackOptions.GatherIntervalMode.BATTERY_SAVE;
            }
            this.f11729c.setTrackOptions(new TrackOptions(gatherIntervalMode, uploadIntervalMode));
        }
    }

    /* renamed from: a */
    private int m7946a() {
        CarOrder order = CarOrderHelper.getOrder();
        if (order != null) {
            int i = order.status;
            int i2 = order.substatus;
            if (!((i != 4 && i != 1) || i2 == 2 || i2 == 7 || i2 == 4003 || i2 == 4004)) {
                if (i2 == 4006) {
                    return 2;
                }
                if (i2 != 4007) {
                    return 1;
                }
            }
        }
        return 0;
    }

    public void stopTracking() {
        TrackClient trackClient = this.f11729c;
        if (trackClient != null && this.f11734n == 0) {
            this.f11734n = -1;
            this.f11735o = 0;
            int stopTrack = trackClient.stopTrack();
            Logger logger = this.f11728a;
            logger.info("trackClient stop tracking code :" + stopTrack, new Object[0]);
            this.f11729c = null;
            this.f11736p = 0;
            if (this.f11730d != null) {
                LocationPerformer.getInstance().removeLocateStatusListener(this.f11730d);
            }
        }
    }

    public void initTrackSDK(Context context) {
        getTrackingApollo();
        TrackInitParams.Builder builder = new TrackInitParams.Builder();
        builder.dataChannel(new IDataChannel() {
            private PushRequestCallback mCallback;

            public boolean isConnected() {
                return PushClient.getClient().isConnected();
            }

            public void setMsgCallback(final IDataChannelMsgCallback iDataChannelMsgCallback) {
                if (iDataChannelMsgCallback != null) {
                    this.mCallback = new PushRequestCallback() {
                        public void onRequest(PushRequestCallback.CallbackInfo callbackInfo) {
                            if (callbackInfo != null) {
                                BigInteger bigInteger = new BigInteger(1, C48213.this.reverse(callbackInfo.seqId));
                                if (callbackInfo.retCode == 0) {
                                    iDataChannelMsgCallback.onSuccess(bigInteger);
                                } else {
                                    iDataChannelMsgCallback.onFail(bigInteger);
                                }
                            }
                        }
                    };
                } else {
                    this.mCallback = null;
                }
            }

            public BigInteger sendMessage(int i, BinaryMsg binaryMsg) {
                byte[] bArr = new byte[8];
                PushClient.getClient().sendRequest(new PushRequest.Builder().msgType(i).data(binaryMsg.toByteArray()).seqIdOut(bArr).build(), this.mCallback);
                return new BigInteger(1, reverse(bArr));
            }

            /* access modifiers changed from: private */
            public byte[] reverse(byte[] bArr) {
                int length = bArr.length >> 1;
                for (int i = 0; i < length; i++) {
                    byte b = bArr[i];
                    bArr[i] = bArr[(bArr.length - i) - 1];
                    bArr[(bArr.length - i) - 1] = b;
                }
                return bArr;
            }
        });
        builder.commonInfoDelegate(new ICommonInfoDelegate() {
            public String getPhone() {
                return NationComponentDataUtil.getPhone();
            }

            public String getUid() {
                return NationComponentDataUtil.getUid() + "";
            }

            public String getToken() {
                return NationComponentDataUtil.getToken();
            }

            public long getCityId() {
                try {
                    return Long.parseLong(NationComponentDataUtil.getLocCityId());
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }

            public long getCountryId() {
                try {
                    return Long.parseLong(NationComponentDataUtil.getLocCountry());
                } catch (Exception e) {
                    e.printStackTrace();
                    return 0;
                }
            }
        });
        TrackManager.getIntance().init(context, builder.build());
    }

    public void getTrackingApollo() {
        IExperiment experiment = Apollo.getToggle("global_track_upload_ab").getExperiment();
        this.f11732l = ((Integer) experiment.getParam("PickUpPassengersSendFrequency", 3)).intValue();
        boolean z = false;
        this.f11733m = ((Integer) experiment.getParam("SendPassengersSendFrequency", 0)).intValue();
        if (((Integer) experiment.getParam("foregroundNotificationEnabled", 0)).intValue() == 1) {
            z = true;
        }
        this.f11731k = z;
    }

    public int getPickUpFrequency() {
        return this.f11732l;
    }

    public int getSendFrequency() {
        return this.f11733m;
    }

    public boolean isBackgroundLocOpen() {
        return this.f11731k;
    }

    public void callTrackingAtOnce(final int i) {
        TrackManager.getIntance().startTrackOnce(TrackClientType.PASSENGER, trackID, new ITrackDataDelegate() {
            public byte[] getCustomData() {
                return DidiTrackingClient.this.m7947a(i).build().toByteArray();
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public CollectSvrCoordinateReq.Builder m7947a(int i) {
        CarOrder order = CarOrderHelper.getOrder();
        CollectSvrCoordinateReq.Builder builder = new CollectSvrCoordinateReq.Builder();
        builder.pull_peer(true).state(Integer.valueOf(PassengerState.PassengerStateNormal.getValue())).app_ver(SystemUtil.getVersionName(DIDIApplication.getAppContext())).system_ver(Build.VERSION.RELEASE).platform("android").country_id(Integer.valueOf(NationTypeUtil.getNationComponentData() == null ? 0 : NationTypeUtil.getNationComponentData().getLocCountryId())).attribution_type(Integer.valueOf(i)).utc_offset(Integer.valueOf(NumberUtil.parseInt(TimeUtil.getTimeZonID())));
        if (order != null) {
            if (order.startAddress != null) {
                builder.pre_lat(Double.valueOf(order.startAddress.getLatitude()));
                builder.pre_lng(Double.valueOf(order.startAddress.getLongitude()));
            }
            if (!TextUtils.isEmpty(order.oid)) {
                builder.order_id(order.oid);
            }
            if (order.status > 0) {
                builder.order_status(Integer.valueOf(order.status));
            }
        }
        GLog.m7968e("startTracking", builder.pre_lat + "......" + builder.pre_lng);
        return builder;
    }
}

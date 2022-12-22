package com.didi.map.utils;

public class AnalysisAbnormalError {

    /* renamed from: a */
    private int f29021a;

    /* renamed from: b */
    private int f29022b;

    /* renamed from: c */
    private AbnormalErrorCallBack f29023c;

    public interface AbnormalErrorCallBack {
        void errorInfo(int i);
    }

    public void setAnalysisAbnormalCallBack(AbnormalErrorCallBack abnormalErrorCallBack) {
        this.f29023c = abnormalErrorCallBack;
    }

    public void handle(CarAnimData carAnimData) {
        if (carAnimData != null) {
            m20427c(carAnimData);
            m20428d(carAnimData);
            m20425a(carAnimData);
            m20426b(carAnimData);
        }
    }

    /* renamed from: a */
    private void m20425a(CarAnimData carAnimData) {
        AbnormalErrorCallBack abnormalErrorCallBack;
        if (carAnimData.animDistance >= 100.0d && carAnimData.animDistance < 200.0d && (abnormalErrorCallBack = this.f29023c) != null) {
            abnormalErrorCallBack.errorInfo(2);
        }
    }

    /* renamed from: b */
    private void m20426b(CarAnimData carAnimData) {
        AbnormalErrorCallBack abnormalErrorCallBack;
        if (carAnimData.animDistance >= 200.0d && (abnormalErrorCallBack = this.f29023c) != null) {
            abnormalErrorCallBack.errorInfo(1);
        }
    }

    /* renamed from: c */
    private void m20427c(CarAnimData carAnimData) {
        if (carAnimData.ntpTimestamp - carAnimData.gpsTime > 10) {
            this.f29021a++;
        } else {
            this.f29021a = 0;
        }
        if (this.f29021a >= 3) {
            AbnormalErrorCallBack abnormalErrorCallBack = this.f29023c;
            if (abnormalErrorCallBack != null) {
                abnormalErrorCallBack.errorInfo(4);
            }
            this.f29021a = 0;
        }
    }

    /* renamed from: d */
    private void m20428d(CarAnimData carAnimData) {
        if ((carAnimData.type == 1 || carAnimData.type == 2) && carAnimData.animDistance == 0.0d) {
            this.f29022b++;
        } else {
            this.f29022b = 0;
        }
        if (this.f29022b >= 30) {
            AbnormalErrorCallBack abnormalErrorCallBack = this.f29023c;
            if (abnormalErrorCallBack != null) {
                abnormalErrorCallBack.errorInfo(3);
            }
            this.f29022b = 0;
        }
    }

    public static class CarAnimData {
        public double animDistance = -1.0d;
        public long gpsTime;
        public long ntpTimestamp;
        public int type;

        public CarAnimData(int i, long j, long j2, double d) {
            this.type = i;
            this.gpsTime = j;
            this.ntpTimestamp = j2;
            this.animDistance = d;
        }
    }
}

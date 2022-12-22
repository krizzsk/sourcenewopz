package com.didi.entrega.customer.foundation.tracker.param;

import android.text.TextUtils;
import com.didi.entrega.customer.foundation.tracker.performance.ConversionOmegaHelper;
import com.didi.entrega.customer.foundation.util.LocationUtil;
import com.didi.sdk.util.SystemUtil;
import com.didi.soda.customer.foundation.tracker.param.ParamConst;
import java.util.HashMap;
import java.util.Map;

public class GlobalParam {

    /* renamed from: a */
    private ExternalGlobalParam f20051a;

    public String getActivityId() {
        ExternalGlobalParam externalGlobalParam = this.f20051a;
        return externalGlobalParam != null ? externalGlobalParam.getActivityId() : "";
    }

    public String getChannelId() {
        ExternalGlobalParam externalGlobalParam = this.f20051a;
        return externalGlobalParam != null ? externalGlobalParam.getChannelId() : "";
    }

    public String getFirstActivityId() {
        ExternalGlobalParam externalGlobalParam = this.f20051a;
        return externalGlobalParam != null ? externalGlobalParam.getFirstActivityId() : "";
    }

    public String getFirstChannelId() {
        ExternalGlobalParam externalGlobalParam = this.f20051a;
        return externalGlobalParam != null ? externalGlobalParam.getFirstChannelId() : "";
    }

    public Map<String, Object> getParams(String str) {
        HashMap hashMap = new HashMap();
        ExternalGlobalParam externalGlobalParam = this.f20051a;
        if (externalGlobalParam != null) {
            hashMap.putAll(externalGlobalParam.getParams());
        }
        hashMap.putAll(new InternalGlobalParam(str).getParams());
        return hashMap;
    }

    public void setExternalGlobalParam(ExternalGlobalParam externalGlobalParam) {
        this.f20051a = externalGlobalParam;
    }

    public static class ExternalGlobalParam extends C8090a {
        private boolean mHasParam = false;

        public boolean fetchParam(String str, String str2, boolean z) {
            if (TextUtils.isEmpty(str)) {
                return false;
            }
            char c = 65535;
            int hashCode = str.hashCode();
            if (hashCode != -1589058723) {
                if (hashCode != 1372656773) {
                    if (hashCode == 1540307073 && str.equals("sailing_ext_param")) {
                        c = 2;
                    }
                } else if (str.equals("sailing_channel_id")) {
                    c = 0;
                }
            } else if (str.equals("sailing_activity_id")) {
                c = 1;
            }
            if (c == 0) {
                setSodaChannelId(str2);
                if (z) {
                    setFirstChannelId(str2);
                }
                return true;
            } else if (c == 1) {
                setActivityId(str2);
                if (z) {
                    setFirstActivityId(str2);
                }
                return true;
            } else if (c != 2) {
                return false;
            } else {
                setActivityParameter(str2);
                if (z) {
                    setFirstActivityParameter(str2);
                }
                return true;
            }
        }

        public boolean hasData() {
            return this.mHasParam;
        }

        /* access modifiers changed from: package-private */
        public void setFirstActivityParameter(String str) {
            this.mHasParam = true;
            putParam("first_ext_param", str);
        }

        /* access modifiers changed from: package-private */
        public void setSodaChannelId(String str) {
            this.mHasParam = true;
            putParam("sailing_channel_id", str);
        }

        /* access modifiers changed from: package-private */
        public void setActivityParameter(String str) {
            this.mHasParam = true;
            putParam("sailing_ext_param", str);
        }

        /* access modifiers changed from: package-private */
        public String getActivityId() {
            return getParam("sailing_activity_id");
        }

        /* access modifiers changed from: package-private */
        public void setActivityId(String str) {
            this.mHasParam = true;
            putParam("sailing_activity_id", str);
        }

        /* access modifiers changed from: package-private */
        public String getChannelId() {
            return getParam("sailing_channel_id");
        }

        /* access modifiers changed from: package-private */
        public String getFirstActivityId() {
            return getParam("first_activity_id");
        }

        /* access modifiers changed from: package-private */
        public void setFirstActivityId(String str) {
            this.mHasParam = true;
            putParam("first_activity_id", str);
        }

        /* access modifiers changed from: package-private */
        public String getFirstChannelId() {
            return getParam("first_channel_id");
        }

        /* access modifiers changed from: package-private */
        public void setFirstChannelId(String str) {
            this.mHasParam = true;
            putParam("first_channel_id", str);
        }
    }

    public class InternalGlobalParam extends C8090a {
        InternalGlobalParam(String str) {
            putParam("tabty", "sodaEntrega");
            putParam("current_page", str);
            putParam("internet_type", SystemUtil.getNetworkType());
            putParam("poi_id", LocationUtil.getPoiId());
            putParam(ParamConst.PARAM_POI_ID_CITY, String.valueOf(LocationUtil.getPoiCityId()));
            putParam("pub_poi_county_id", String.valueOf(LocationUtil.getPoiCountyId()));
            putParam("pub_poi_county_group_id", String.valueOf(LocationUtil.getPoiCountyGroupId()));
            putParam("poi_latitude", String.valueOf(LocationUtil.getPoiLat()));
            putParam("poi_longitude", String.valueOf(LocationUtil.getPoiLng()));
            putParam("pub_lifeid", ConversionOmegaHelper.getLifeId());
            putParam("pub_cost_time", ConversionOmegaHelper.getDuration());
            putParam("pub_sess_id", ConversionOmegaHelper.getSession());
            putParam("pub_location_city_id", String.valueOf(LocationUtil.getCityId()));
            putParam("pub_location_latitude", String.valueOf(LocationUtil.getCurrentLat()));
            putParam("pub_location_longitude", String.valueOf(LocationUtil.getCurrentLng()));
            putParam("pub_seq_id", ConversionOmegaHelper.getSequenceId());
            putParam("pub_interval_time", ConversionOmegaHelper.getTrackIntervalTime());
        }
    }
}

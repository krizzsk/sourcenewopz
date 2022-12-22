package com.didi.component.common.util;

import android.content.Context;
import com.didi.common.map.model.LatLng;
import com.didi.component.business.util.NationComponentDataUtil;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.component.express.ExpressShareStore;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationListener;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationManager;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocationUpdateOption;

public class LocationController {

    /* renamed from: a */
    private static final double f11772a = 6378.137d;

    /* renamed from: b */
    private static LocationController f11773b;

    public interface OneCarLocationListener extends DIDILocationListener {
    }

    public static class OneCarLocationUpdateOption extends DIDILocationUpdateOption {
    }

    /* renamed from: a */
    private static double m7990a(double d) {
        return (d * 3.141592653589793d) / 180.0d;
    }

    public static LocationController getInstance() {
        if (f11773b == null) {
            synchronized (LocationController.class) {
                if (f11773b == null) {
                    f11773b = new LocationController();
                }
            }
        }
        return f11773b;
    }

    private LocationController() {
    }

    public void requestLocationUpdateOnce(Context context, OneCarLocationListener oneCarLocationListener) {
        DIDILocationManager a = m7991a(context);
        if (a != null) {
            a.requestLocationUpdateOnce(oneCarLocationListener, LocationController.class.getName());
        }
    }

    public void requestLocationUpdates(Context context, OneCarLocationListener oneCarLocationListener) {
        DIDILocationManager a = m7991a(context);
        if (a != null) {
            a.requestLocationUpdates(oneCarLocationListener, a.getDefaultLocationUpdateOption());
        }
    }

    public void requestLocationUpdates(Context context, OneCarLocationListener oneCarLocationListener, OneCarLocationUpdateOption oneCarLocationUpdateOption) {
        DIDILocationManager a = m7991a(context);
        if (a != null) {
            a.requestLocationUpdates(oneCarLocationListener, oneCarLocationUpdateOption);
        }
    }

    public void removeLocationUpdates(Context context, OneCarLocationListener oneCarLocationListener) {
        DIDILocationManager a = m7991a(context);
        if (a != null) {
            a.removeLocationUpdates(oneCarLocationListener);
        }
    }

    public double getLat(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLatitude();
        }
        return 0.0d;
    }

    public double getLng(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return lastKnownLocation.getLongitude();
        }
        return 0.0d;
    }

    public LatLng getLatLng(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return new LatLng(lastKnownLocation.getLatitude(), lastKnownLocation.getLongitude());
        }
        return null;
    }

    public String getStringProvider(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation == null) {
            return "2";
        }
        String provider = lastKnownLocation.getProvider();
        if ("gps".equals(provider)) {
            return "0";
        }
        return (DIDILocation.WIFI_PROVIDER.equals(provider) || DIDILocation.CELL_PROVIDER.equals(provider) || DIDILocation.NLP_PROVIDER.equals(provider)) ? "1" : "2";
    }

    public String getProvider(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        return lastKnownLocation != null ? lastKnownLocation.getProvider() : "";
    }

    public double getAccuracy(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return (double) lastKnownLocation.getAccuracy();
        }
        return 0.0d;
    }

    public float getFloatAccuracy(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return lastKnownLocation.getAccuracy();
        }
        return 0.0f;
    }

    public float getSpeed(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return lastKnownLocation.getSpeed();
        }
        return 0.0f;
    }

    public float getBearing(Context context) {
        DIDILocation lastKnownLocation = getLastKnownLocation(context);
        if (lastKnownLocation != null) {
            return lastKnownLocation.getBearing();
        }
        return 0.0f;
    }

    public DIDILocation getLastKnownLocation(Context context) {
        return m7991a(context).getLastKnownLocation();
    }

    /* renamed from: a */
    private DIDILocationManager m7991a(Context context) {
        return DIDILocationManager.getInstance(context);
    }

    public String getReverseCityName() {
        return NationComponentDataUtil.getLocCityName();
    }

    public int getReverseCityId() {
        return Integer.valueOf(NationComponentDataUtil.getLocCityId()).intValue();
    }

    public Address getReverseAddress() {
        return ReverseLocationStore.getsInstance().getCurAddress();
    }

    public String getReverseDisplayName() {
        return getReverseAddress() != null ? getReverseAddress().getDisplayName() : "";
    }

    public String getReverseAddressName() {
        return getReverseAddress() != null ? getReverseAddress().getAddress() : "";
    }

    public String getReverseAddressUid() {
        return getReverseAddress() != null ? getReverseAddress().getAddress() : "";
    }

    public static int getCurrentLocationCityId() {
        return ReverseLocationStore.getsInstance().getCityId();
    }

    public static int getCurrentDepartureCityId(Context context) {
        Address fromAddress = ExpressShareStore.getInstance().getFromAddress();
        if (fromAddress == null || fromAddress.getCityId() == -1) {
            return getCurrentLocationCityId();
        }
        return fromAddress.getCityId();
    }

    public static String getCurrentAddressName() {
        Address curAddress = ReverseLocationStore.getsInstance().getCurAddress();
        return curAddress != null ? curAddress.getDisplayName() : "";
    }

    public static String getCurrentAddressCityName() {
        Address curAddress = ReverseLocationStore.getsInstance().getCurAddress();
        return curAddress != null ? curAddress.getCityName() : "";
    }

    public static Address getCurrentLocation() {
        Address curAddress = ReverseLocationStore.getsInstance().getCurAddress();
        if (curAddress != null) {
            return curAddress;
        }
        return null;
    }

    public static double getDistance(double d, double d2, double d3, double d4) {
        double a = m7990a(d);
        double a2 = m7990a(d3);
        return (((double) Math.round(((Math.asin(Math.sqrt(Math.pow(Math.sin((a - a2) / 2.0d), 2.0d) + ((Math.cos(a) * Math.cos(a2)) * Math.pow(Math.sin((m7990a(d2) - m7990a(d4)) / 2.0d), 2.0d)))) * 2.0d) * f11772a) * 10000.0d)) / 10000.0d) * 1000.0d;
    }
}

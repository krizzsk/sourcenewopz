package com.didi.sdk.app;

import android.app.Application;
import android.location.Location;
import android.os.Bundle;
import com.didi.sdk.logging.Logger;
import com.didi.sdk.logging.LoggerFactory;
import com.didi.sdk.map.ILocation;
import com.didi.sdk.map.LocationPerformer;
import com.didi.sdk.misconfig.store.ICityChangeListener;
import com.didi.sdk.nation.NationTypeUtil;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.swarm.launcher.SwarmLauncher;
import com.didichuxing.swarm.toolkit.CityChangeEvent;
import com.didichuxing.swarm.toolkit.LocationChangeEvent;
import com.didichuxing.swarm.toolkit.LocationService;
import com.didichuxing.swarm.toolkit.OnCityChangeListener;
import com.didichuxing.swarm.toolkit.OnLocationChangeListener;
import java.util.Vector;
import org.osgi.framework.BundleContext;

/* renamed from: com.didi.sdk.app.e */
/* compiled from: LocationServiceImpl */
class C12013e implements ILocation.ILocationChangedListener, ICityChangeListener, LocationService {

    /* renamed from: a */
    private static final Logger f35225a = LoggerFactory.getLogger("LocationService");

    /* renamed from: b */
    private final Vector<OnCityChangeListener> f35226b = new Vector<>();

    /* renamed from: c */
    private final Vector<OnLocationChangeListener> f35227c = new Vector<>();

    C12013e() {
        LocationPerformer.getInstance().addLocationListener(this);
    }

    public Location getLocation() {
        BundleContext bundleContext = SwarmLauncher.getInstance().getFramework().getBundleContext();
        Application application = (Application) bundleContext.getService(bundleContext.getServiceReference(Application.class));
        DIDILocation didiLocation = NationTypeUtil.getNationComponentData().getDidiLocation();
        if (didiLocation == null) {
            return null;
        }
        Bundle bundle = new Bundle();
        bundle.putString("city_id", NationTypeUtil.getNationComponentData().getCityId());
        Location location = new Location(didiLocation.getProvider());
        location.setLatitude(didiLocation.getLatitude());
        location.setLongitude(didiLocation.getLongitude());
        location.setAccuracy(didiLocation.getAccuracy());
        location.setBearing(didiLocation.getBearing());
        location.setExtras(bundle);
        location.setSpeed(didiLocation.getSpeed());
        location.setTime(didiLocation.getTime());
        return location;
    }

    public String getCityId() {
        String cityId = NationTypeUtil.getNationComponentData().getCityId();
        Logger logger = f35225a;
        logger.info("apollo get cityId:" + cityId, new Object[0]);
        return cityId;
    }

    public void addLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f35227c.add(onLocationChangeListener);
    }

    public void removeLocationChangeListener(OnLocationChangeListener onLocationChangeListener) {
        this.f35227c.remove(onLocationChangeListener);
    }

    public void addCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f35226b.add(onCityChangeListener);
    }

    public void removeCityChangeListener(OnCityChangeListener onCityChangeListener) {
        this.f35226b.remove(onCityChangeListener);
    }

    public void onCityChange(int i, int i2) {
        if (i != i2) {
            f35225a.debug("City changed: %s => %s", String.valueOf(i), String.valueOf(i2));
            if (!this.f35226b.isEmpty()) {
                CityChangeEvent cityChangeEvent = new CityChangeEvent(this, String.valueOf(i), String.valueOf(i2));
                Vector<OnCityChangeListener> vector = this.f35226b;
                for (OnCityChangeListener onCityChanged : (OnCityChangeListener[]) vector.toArray(new OnCityChangeListener[vector.size()])) {
                    onCityChanged.onCityChanged(cityChangeEvent);
                }
            }
        }
    }

    public void onLocationChanged(DIDILocation dIDILocation) {
        if (!this.f35227c.isEmpty()) {
            Location location = new Location(dIDILocation.getProvider());
            location.setAccuracy(dIDILocation.getAccuracy());
            location.setAltitude(dIDILocation.getAltitude());
            location.setBearing(dIDILocation.getBearing());
            location.setLatitude(dIDILocation.getLatitude());
            location.setLongitude(dIDILocation.getLongitude());
            location.setSpeed(dIDILocation.getSpeed());
            location.setTime(dIDILocation.getTime());
            LocationChangeEvent locationChangeEvent = new LocationChangeEvent(this, location);
            Vector<OnLocationChangeListener> vector = this.f35227c;
            for (OnLocationChangeListener onLocationChangeListener : (OnLocationChangeListener[]) vector.toArray(new OnLocationChangeListener[vector.size()])) {
                if (onLocationChangeListener != null) {
                    onLocationChangeListener.onLocationChanged(locationChangeEvent);
                }
            }
        }
    }
}

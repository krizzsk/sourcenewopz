package com.didi.component.safetoolkit.sodaentregaapi;

import android.content.Context;
import com.didi.component.common.util.LocationController;
import com.didi.component.core.ComponentParams;
import com.didi.component.core.IPresenter;
import com.didi.component.safetoolkit.presenter.AbsSafeToolkitPresenter;
import com.didi.component.safetoolkit.presenter.PresenterHolder;
import com.didi.safetoolkit.api.ISfLocationService;
import com.didi.safetoolkit.model.SfLocation;
import com.didi.sdk.address.address.entity.Address;
import com.didi.sdk.reversegeo.ReverseLocationStore;
import com.didi.sdk.store.FetchCallback;
import com.didichuxing.bigdata.p173dp.locsdk.DIDILocation;
import com.didichuxing.bigdata.p173dp.locsdk.ErrInfo;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;

@ServiceProvider(alias = "sodaEntrega", value = {ISfLocationService.class})
public class SodaEntregaLocationProvider implements ISfLocationService {
    public void getCurrentLocation(final Context context, final ISfLocationService.SfCallback sfCallback) {
        if (sfCallback != null) {
            if (context == null) {
                try {
                    sfCallback.onFailed("context is null");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                LocationController instance = LocationController.getInstance();
                final ComponentParams componentParams = null;
                IPresenter presenter = PresenterHolder.getIns().getPresenter();
                if (presenter == null || !(presenter instanceof AbsSafeToolkitPresenter) || (componentParams = ((AbsSafeToolkitPresenter) presenter).getComponentParams()) != null) {
                    if (componentParams == null) {
                        componentParams = new ComponentParams();
                    }
                    instance.requestLocationUpdateOnce(context, new LocationController.OneCarLocationListener() {
                        public void onStatusUpdate(String str, int i, String str2) {
                        }

                        public void onLocationChanged(DIDILocation dIDILocation) {
                            SfLocation a = SodaEntregaLocationProvider.this.m11105a(dIDILocation);
                            ComponentParams componentParams = componentParams;
                            if (componentParams != null) {
                                SodaEntregaLocationProvider.this.m11106a(context, a, dIDILocation, componentParams, sfCallback);
                            }
                        }

                        public void onLocationError(int i, ErrInfo errInfo) {
                            try {
                                ISfLocationService.SfCallback sfCallback = sfCallback;
                                sfCallback.onFailed("location error:" + errInfo.getErrMessage());
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
            }
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m11106a(Context context, final SfLocation sfLocation, DIDILocation dIDILocation, ComponentParams componentParams, final ISfLocationService.SfCallback sfCallback) {
        ReverseLocationStore.getsInstance().fetchReverseLocation(context, componentParams.bid, dIDILocation.getLatitude(), dIDILocation.getLongitude(), dIDILocation.getAccuracy(), dIDILocation.getProvider(), new FetchCallback<Address>() {
            public void onSuccess(Address address) {
                sfLocation.address = address.address;
                SfLocation sfLocation = sfLocation;
                sfLocation.cityId = address.cityId + "";
                sfLocation.cityName = address.cityName;
                sfLocation.coordinate_type = address.coordinate_type;
                sfLocation.displayName = address.displayName;
                sfLocation.fullName = address.fullName;
                sfLocation.name = address.name;
                try {
                    sfCallback.onSucceed(sfLocation);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }

            public void onFail(int i) {
                try {
                    ISfLocationService.SfCallback sfCallback = sfCallback;
                    sfCallback.onFailed("geo fail code:" + i);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public SfLocation m11105a(DIDILocation dIDILocation) {
        if (dIDILocation == null) {
            return null;
        }
        SfLocation sfLocation = new SfLocation();
        sfLocation.lat = dIDILocation.getLatitude();
        sfLocation.lng = dIDILocation.getLongitude();
        return sfLocation;
    }
}

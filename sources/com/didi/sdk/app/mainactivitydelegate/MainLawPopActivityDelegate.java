package com.didi.sdk.app.mainactivitydelegate;

import android.app.Activity;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.didi.sdk.app.delegate.ActivityDelegate;
import com.didi.sdk.lawpop.LawPreposeDialogHelper;
import com.didi.sdk.lawpop.LawUpdateDialogHelper;
import com.didi.sdk.misconfig.event.CarInfoUpdateEvent;
import com.didi.sdk.misconfig.model.CountryInfo;
import com.didi.sdk.misconfig.p153v2.ConfProxy;
import com.didi.sdk.util.EventKeys;
import com.didi.sdk.view.dialog.AlertDialogFragment;
import com.didichuxing.foundation.spi.annotation.ServiceProvider;
import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

@ServiceProvider({ActivityDelegate.class})
public class MainLawPopActivityDelegate extends ActivityDelegate {

    /* renamed from: a */
    private FragmentActivity f35240a;

    /* renamed from: b */
    private int f35241b;

    public void onCreate(Activity activity) {
        super.onCreate(activity);
        EventBus.getDefault().register(this);
        if (activity instanceof FragmentActivity) {
            this.f35240a = (FragmentActivity) activity;
        }
        if (this.f35240a == null) {
        }
    }

    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onReceive(CarInfoUpdateEvent carInfoUpdateEvent) {
        FragmentActivity fragmentActivity = this.f35240a;
        if (fragmentActivity != null && !fragmentActivity.isFinishing()) {
            if (EventKeys.MisConfig.CAR_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
                String countryIsoCodeFromLocation = LawPreposeDialogHelper.getCountryIsoCodeFromLocation();
                if (LawPreposeDialogHelper.isNeedShowLocationChangedLawDialog(this.f35240a, countryIsoCodeFromLocation)) {
                    LawPreposeDialogHelper.showLocationChangeLawDialog(this.f35240a, countryIsoCodeFromLocation, new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        }
                    }, new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            System.exit(0);
                        }
                    });
                    return;
                }
                CountryInfo countryInfo = ConfProxy.getInstance().getCountryInfo();
                if (countryInfo != null && this.f35241b != countryInfo.getCountryId()) {
                    LawUpdateDialogHelper.postTaskDelayed(this.f35240a);
                    this.f35241b = countryInfo.getCountryId();
                }
            } else if (EventKeys.MisConfig.LAW_INFO_UPDATE.equalsIgnoreCase(carInfoUpdateEvent.tag)) {
                String countryIsoCodeFromLocation2 = LawPreposeDialogHelper.getCountryIsoCodeFromLocation();
                if (LawPreposeDialogHelper.isNeedShowLocationChangedLawDialog(this.f35240a, countryIsoCodeFromLocation2)) {
                    LawPreposeDialogHelper.showLocationChangeLawDialog(this.f35240a, countryIsoCodeFromLocation2, new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                        }
                    }, new AlertDialogFragment.OnClickListener() {
                        public void onClick(AlertDialogFragment alertDialogFragment, View view) {
                            System.exit(0);
                        }
                    });
                    return;
                }
                ConfProxy.getInstance().getCountryInfo();
                LawUpdateDialogHelper.postTaskDelayed(this.f35240a);
            }
        }
    }

    public void onDestroy(Activity activity) {
        super.onDestroy(activity);
        LawUpdateDialogHelper.resetShowDialogStatus();
        EventBus.getDefault().unregister(this);
    }
}

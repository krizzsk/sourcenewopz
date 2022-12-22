package com.didi.sdk.sidebar.fragment;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CompoundButton;
import android.widget.Switch;
import androidx.fragment.app.Fragment;
import com.didi.autotracker.AutoTrackHelper;
import com.didi.sdk.app.BaseBusinessContext;
import com.didi.sdk.app.IComponent;
import com.didi.sdk.app.IStatusBar;
import com.didi.sdk.sidebar.travelsafe.TravelSafeManager;
import com.didi.sdk.sidebar.travelsafe.TravelSafetyState;
import com.didi.sdk.view.titlebar.CommonTitleBar;
import com.taxis99.R;

public class HideNumberFragment extends Fragment implements View.OnClickListener, IComponent<BaseBusinessContext>, IStatusBar {

    /* renamed from: a */
    private BaseBusinessContext f37261a;

    public boolean showStatusBar() {
        return true;
    }

    public View onCreateView(LayoutInflater layoutInflater, ViewGroup viewGroup, Bundle bundle) {
        View inflate = layoutInflater.inflate(R.layout.setting_trip_security, (ViewGroup) null);
        CommonTitleBar commonTitleBar = (CommonTitleBar) inflate.findViewById(R.id.title_bar);
        commonTitleBar.setLeftBackListener(this);
        commonTitleBar.setTitle((int) R.string.hide_phone_title);
        commonTitleBar.setTitleBarLineVisible(8);
        final Switch switchR = (Switch) inflate.findViewById(R.id.checkbox);
        switchR.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
                AutoTrackHelper.trackViewOnClick(compoundButton, z);
                if (compoundButton.isChecked()) {
                    TravelSafeManager.getInstance(HideNumberFragment.this.getContext()).getTravelSafeState().hidephone = true;
                    TravelSafeManager.getInstance(HideNumberFragment.this.getContext()).saveAndSync();
                    return;
                }
                TravelSafeManager.getInstance(HideNumberFragment.this.getContext()).getTravelSafeState().hidephone = false;
                TravelSafeManager.getInstance(HideNumberFragment.this.getContext()).saveAndSync();
            }
        });
        TravelSafeManager.getInstance(getContext()).init(new TravelSafeManager.IRefreshState() {
            public void dataRefresh(TravelSafetyState travelSafetyState) {
                switchR.setChecked(travelSafetyState.hidephone);
            }
        });
        return inflate;
    }

    public void onClick(View view) {
        AutoTrackHelper.trackViewOnClick(view);
        this.f37261a.getNavigation().popBackStack();
    }

    public BaseBusinessContext getBusinessContext() {
        return this.f37261a;
    }

    public void setBusinessContext(BaseBusinessContext baseBusinessContext) {
        this.f37261a = baseBusinessContext;
    }
}

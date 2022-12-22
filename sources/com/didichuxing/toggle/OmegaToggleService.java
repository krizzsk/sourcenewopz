package com.didichuxing.toggle;

import com.didichuxing.apollo.sdk.Apollo;
import com.didichuxing.apollo.sdk.IExperiment;
import com.didichuxing.apollo.sdk.IToggle;
import com.didichuxing.apollo.sdk.observer.OnToggleStateChangeListener;
import com.didichuxing.omega.sdk.init.impl.IOmegaToggleService;

public class OmegaToggleService implements IOmegaToggleService {
    public void removeToggleStateChangeListener(IOmegaToggleService.ToggleStateChangeListener toggleStateChangeListener) {
    }

    public boolean allow(String str) {
        return Apollo.getToggle(str).allow();
    }

    public <T> T getParams(String str, String str2, T t) {
        IExperiment experiment;
        IToggle toggle = Apollo.getToggle(str);
        if (toggle == null || (experiment = toggle.getExperiment()) == null) {
            return t;
        }
        return experiment.getParam(str2, t);
    }

    public void addToggleStateChangeListener(final IOmegaToggleService.ToggleStateChangeListener toggleStateChangeListener) {
        Apollo.addToggleStateChangeListener(new OnToggleStateChangeListener() {
            public void onStateChanged() {
                IOmegaToggleService.ToggleStateChangeListener toggleStateChangeListener = toggleStateChangeListener;
                if (toggleStateChangeListener != null) {
                    toggleStateChangeListener.onStateChanged();
                }
            }
        });
    }
}

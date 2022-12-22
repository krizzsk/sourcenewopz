package com.didi.rlab.uni_foundation.omega;

public interface RlabOmegaService {
    void traceEvent(EventTrackerModel eventTrackerModel);

    void trackError(ErrorTrackerModel errorTrackerModel);
}

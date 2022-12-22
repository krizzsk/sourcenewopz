package com.didi.rlab.uni_im_map.map;

public interface IMMapOmegaService {
    void traceEvent(IMMapEventTrackerModel iMMapEventTrackerModel);

    void trackError(IMMapErrorTrackerModel iMMapErrorTrackerModel);
}

package com.didi.hawaii.mapsdk.gesture;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AndroidGestureOption {
    public boolean applyDefaultThresholds = false;
    public List<Set<Integer>> exclusiveGestures = new ArrayList();
    public boolean useNNClassfy = false;
}

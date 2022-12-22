package com.didi.map.global.flow.scene.vamos.model;

import android.graphics.Color;
import com.didi.common.map.model.LatLng;
import java.util.List;

public class VamosMultiLineModel {
    public int mHomeLineColor = Color.parseColor("#989BB3");
    public List<LatLng> mHomePoints;
    public float mLineWidth = 4.0f;
    public int mPaxLineColor = Color.parseColor("#4A4C5B");
    public List<LatLng> mPaxPoints;
    public int mPickUpLineColor = Color.parseColor("#989BB3");
    public List<LatLng> mPickUpPoints;
}

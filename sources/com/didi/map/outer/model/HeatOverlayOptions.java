package com.didi.map.outer.model;

import java.util.ArrayList;
import java.util.List;

public class HeatOverlayOptions {
    public static final int DEFAULT_RADIUS = 18;

    /* renamed from: a */
    private ArrayList<HeatDataNode> f27930a;

    /* renamed from: b */
    private OnHeatMapReadyListener f27931b;

    /* renamed from: c */
    private IColorMapper f27932c;

    /* renamed from: d */
    private int f27933d = 18;

    /* renamed from: e */
    private HeatTileGenerator f27934e;

    public interface HeatTileGenerator {
        float[] generateFadeOutMatrix(int i);

        int[] generateHeatTile(List<HeatNode> list, float[] fArr, int i, int i2, IColorMapper iColorMapper);
    }

    public interface IColorMapper {
        int colorForValue(double d);
    }

    public interface OnHeatMapReadyListener {
        void onHeatMapReady();
    }

    public HeatOverlayOptions nodes(List<HeatDataNode> list) {
        ArrayList<HeatDataNode> arrayList = new ArrayList<>();
        this.f27930a = arrayList;
        arrayList.addAll(list);
        return this;
    }

    public HeatOverlayOptions colorMapper(IColorMapper iColorMapper) {
        this.f27932c = iColorMapper;
        return this;
    }

    public HeatOverlayOptions onHeatMapReadyListener(OnHeatMapReadyListener onHeatMapReadyListener) {
        this.f27931b = onHeatMapReadyListener;
        return this;
    }

    public HeatOverlayOptions radius(int i) {
        this.f27933d = i;
        return this;
    }

    public List<HeatDataNode> getNodes() {
        return this.f27930a;
    }

    public OnHeatMapReadyListener getOnHeatMapReadyListener() {
        return this.f27931b;
    }

    public int getRadius() {
        return this.f27933d;
    }

    public IColorMapper getColorMapper() {
        return this.f27932c;
    }

    public HeatOverlayOptions heatTileGenerator(HeatTileGenerator heatTileGenerator) {
        this.f27934e = heatTileGenerator;
        return this;
    }

    public HeatTileGenerator getHeatTileGenerator() {
        return this.f27934e;
    }
}

package com.github.mikephil.charting.data;

import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import java.util.Arrays;
import java.util.List;

public class RadarData extends ChartData<IRadarDataSet> {

    /* renamed from: a */
    private List<String> f52401a;

    public RadarData() {
    }

    public RadarData(List<IRadarDataSet> list) {
        super(list);
    }

    public RadarData(IRadarDataSet... iRadarDataSetArr) {
        super((T[]) iRadarDataSetArr);
    }

    public void setLabels(List<String> list) {
        this.f52401a = list;
    }

    public void setLabels(String... strArr) {
        this.f52401a = Arrays.asList(strArr);
    }

    public List<String> getLabels() {
        return this.f52401a;
    }

    public Entry getEntryForHighlight(Highlight highlight) {
        return ((IRadarDataSet) getDataSetByIndex(highlight.getDataSetIndex())).getEntryForIndex((int) highlight.getX());
    }
}

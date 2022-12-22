package com.github.mikephil.charting.renderer;

import android.graphics.Canvas;
import com.github.mikephil.charting.charts.RadarChart;
import com.github.mikephil.charting.components.XAxis;
import com.github.mikephil.charting.data.RadarData;
import com.github.mikephil.charting.interfaces.datasets.IRadarDataSet;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Transformer;
import com.github.mikephil.charting.utils.Utils;
import com.github.mikephil.charting.utils.ViewPortHandler;

public class XAxisRendererRadarChart extends XAxisRenderer {

    /* renamed from: b */
    private RadarChart f52489b;

    public void renderLimitLines(Canvas canvas) {
    }

    public XAxisRendererRadarChart(ViewPortHandler viewPortHandler, XAxis xAxis, RadarChart radarChart) {
        super(viewPortHandler, xAxis, (Transformer) null);
        this.f52489b = radarChart;
    }

    public void renderAxisLabels(Canvas canvas) {
        if (this.mXAxis.isEnabled() && this.mXAxis.isDrawLabelsEnabled()) {
            float labelRotationAngle = this.mXAxis.getLabelRotationAngle();
            MPPointF instance = MPPointF.getInstance(0.5f, 0.25f);
            this.mAxisLabelPaint.setTypeface(this.mXAxis.getTypeface());
            this.mAxisLabelPaint.setTextSize(this.mXAxis.getTextSize());
            this.mAxisLabelPaint.setColor(this.mXAxis.getTextColor());
            float sliceAngle = this.f52489b.getSliceAngle();
            float factor = this.f52489b.getFactor();
            MPPointF centerOffsets = this.f52489b.getCenterOffsets();
            MPPointF instance2 = MPPointF.getInstance(0.0f, 0.0f);
            for (int i = 0; i < ((IRadarDataSet) ((RadarData) this.f52489b.getData()).getMaxEntryCountSet()).getEntryCount(); i++) {
                float f = (float) i;
                String axisLabel = this.mXAxis.getValueFormatter().getAxisLabel(f, this.mXAxis);
                Utils.getPosition(centerOffsets, (this.f52489b.getYRange() * factor) + (((float) this.mXAxis.mLabelRotatedWidth) / 2.0f), ((f * sliceAngle) + this.f52489b.getRotationAngle()) % 360.0f, instance2);
                drawLabel(canvas, axisLabel, instance2.f52498x, instance2.f52499y - (((float) this.mXAxis.mLabelRotatedHeight) / 2.0f), instance, labelRotationAngle);
            }
            MPPointF.recycleInstance(centerOffsets);
            MPPointF.recycleInstance(instance2);
            MPPointF.recycleInstance(instance);
        }
    }
}

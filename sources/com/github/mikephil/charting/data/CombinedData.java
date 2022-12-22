package com.github.mikephil.charting.data;

import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.charts.Chart;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet;
import java.util.ArrayList;
import java.util.List;

public class CombinedData extends BarLineScatterCandleBubbleData<IBarLineScatterCandleBubbleDataSet<? extends Entry>> {

    /* renamed from: a */
    private LineData f52367a;

    /* renamed from: b */
    private BarData f52368b;

    /* renamed from: c */
    private ScatterData f52369c;

    /* renamed from: d */
    private CandleData f52370d;

    /* renamed from: e */
    private BubbleData f52371e;

    public void setData(LineData lineData) {
        this.f52367a = lineData;
        notifyDataChanged();
    }

    public void setData(BarData barData) {
        this.f52368b = barData;
        notifyDataChanged();
    }

    public void setData(ScatterData scatterData) {
        this.f52369c = scatterData;
        notifyDataChanged();
    }

    public void setData(CandleData candleData) {
        this.f52370d = candleData;
        notifyDataChanged();
    }

    public void setData(BubbleData bubbleData) {
        this.f52371e = bubbleData;
        notifyDataChanged();
    }

    public void calcMinMax() {
        if (this.mDataSets == null) {
            this.mDataSets = new ArrayList();
        }
        this.mDataSets.clear();
        this.mYMax = -3.4028235E38f;
        this.mYMin = Float.MAX_VALUE;
        this.mXMax = -3.4028235E38f;
        this.mXMin = Float.MAX_VALUE;
        this.mLeftAxisMax = -3.4028235E38f;
        this.mLeftAxisMin = Float.MAX_VALUE;
        this.mRightAxisMax = -3.4028235E38f;
        this.mRightAxisMin = Float.MAX_VALUE;
        for (ChartData next : getAllData()) {
            next.calcMinMax();
            this.mDataSets.addAll(next.getDataSets());
            if (next.getYMax() > this.mYMax) {
                this.mYMax = next.getYMax();
            }
            if (next.getYMin() < this.mYMin) {
                this.mYMin = next.getYMin();
            }
            if (next.getXMax() > this.mXMax) {
                this.mXMax = next.getXMax();
            }
            if (next.getXMin() < this.mXMin) {
                this.mXMin = next.getXMin();
            }
            if (next.mLeftAxisMax > this.mLeftAxisMax) {
                this.mLeftAxisMax = next.mLeftAxisMax;
            }
            if (next.mLeftAxisMin < this.mLeftAxisMin) {
                this.mLeftAxisMin = next.mLeftAxisMin;
            }
            if (next.mRightAxisMax > this.mRightAxisMax) {
                this.mRightAxisMax = next.mRightAxisMax;
            }
            if (next.mRightAxisMin < this.mRightAxisMin) {
                this.mRightAxisMin = next.mRightAxisMin;
            }
        }
    }

    public BubbleData getBubbleData() {
        return this.f52371e;
    }

    public LineData getLineData() {
        return this.f52367a;
    }

    public BarData getBarData() {
        return this.f52368b;
    }

    public ScatterData getScatterData() {
        return this.f52369c;
    }

    public CandleData getCandleData() {
        return this.f52370d;
    }

    public List<BarLineScatterCandleBubbleData> getAllData() {
        ArrayList arrayList = new ArrayList();
        LineData lineData = this.f52367a;
        if (lineData != null) {
            arrayList.add(lineData);
        }
        BarData barData = this.f52368b;
        if (barData != null) {
            arrayList.add(barData);
        }
        ScatterData scatterData = this.f52369c;
        if (scatterData != null) {
            arrayList.add(scatterData);
        }
        CandleData candleData = this.f52370d;
        if (candleData != null) {
            arrayList.add(candleData);
        }
        BubbleData bubbleData = this.f52371e;
        if (bubbleData != null) {
            arrayList.add(bubbleData);
        }
        return arrayList;
    }

    public BarLineScatterCandleBubbleData getDataByIndex(int i) {
        return getAllData().get(i);
    }

    public void notifyDataChanged() {
        LineData lineData = this.f52367a;
        if (lineData != null) {
            lineData.notifyDataChanged();
        }
        BarData barData = this.f52368b;
        if (barData != null) {
            barData.notifyDataChanged();
        }
        CandleData candleData = this.f52370d;
        if (candleData != null) {
            candleData.notifyDataChanged();
        }
        ScatterData scatterData = this.f52369c;
        if (scatterData != null) {
            scatterData.notifyDataChanged();
        }
        BubbleData bubbleData = this.f52371e;
        if (bubbleData != null) {
            bubbleData.notifyDataChanged();
        }
        calcMinMax();
    }

    /* JADX WARNING: Removed duplicated region for block: B:9:0x003d  */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public com.github.mikephil.charting.data.Entry getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight r6) {
        /*
            r5 = this;
            int r0 = r6.getDataIndex()
            java.util.List r1 = r5.getAllData()
            int r1 = r1.size()
            r2 = 0
            if (r0 < r1) goto L_0x0010
            return r2
        L_0x0010:
            int r0 = r6.getDataIndex()
            com.github.mikephil.charting.data.BarLineScatterCandleBubbleData r0 = r5.getDataByIndex(r0)
            int r1 = r6.getDataSetIndex()
            int r3 = r0.getDataSetCount()
            if (r1 < r3) goto L_0x0023
            return r2
        L_0x0023:
            int r1 = r6.getDataSetIndex()
            com.github.mikephil.charting.interfaces.datasets.IDataSet r0 = r0.getDataSetByIndex(r1)
            float r1 = r6.getX()
            java.util.List r0 = r0.getEntriesForXValue(r1)
            java.util.Iterator r0 = r0.iterator()
        L_0x0037:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L_0x005a
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.Entry r1 = (com.github.mikephil.charting.data.Entry) r1
            float r3 = r1.getY()
            float r4 = r6.getY()
            int r3 = (r3 > r4 ? 1 : (r3 == r4 ? 0 : -1))
            if (r3 == 0) goto L_0x0059
            float r3 = r6.getY()
            boolean r3 = java.lang.Float.isNaN(r3)
            if (r3 == 0) goto L_0x0037
        L_0x0059:
            return r1
        L_0x005a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.getEntryForHighlight(com.github.mikephil.charting.highlight.Highlight):com.github.mikephil.charting.data.Entry");
    }

    public IBarLineScatterCandleBubbleDataSet<? extends Entry> getDataSetByHighlight(Highlight highlight) {
        if (highlight.getDataIndex() >= getAllData().size()) {
            return null;
        }
        BarLineScatterCandleBubbleData dataByIndex = getDataByIndex(highlight.getDataIndex());
        if (highlight.getDataSetIndex() >= dataByIndex.getDataSetCount()) {
            return null;
        }
        return (IBarLineScatterCandleBubbleDataSet) dataByIndex.getDataSets().get(highlight.getDataSetIndex());
    }

    public int getDataIndex(ChartData chartData) {
        return getAllData().indexOf(chartData);
    }

    /* JADX WARNING: Removed duplicated region for block: B:1:0x0009 A[LOOP:0: B:1:0x0009->B:4:0x0019, LOOP_START, PHI: r1 
      PHI: (r1v1 boolean) = (r1v0 boolean), (r1v5 boolean) binds: [B:0:0x0000, B:4:0x0019] A[DONT_GENERATE, DONT_INLINE]] */
    /* Code decompiled incorrectly, please refer to instructions dump. */
    public boolean removeDataSet(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet<? extends com.github.mikephil.charting.data.Entry> r4) {
        /*
            r3 = this;
            java.util.List r0 = r3.getAllData()
            java.util.Iterator r0 = r0.iterator()
            r1 = 0
        L_0x0009:
            boolean r2 = r0.hasNext()
            if (r2 == 0) goto L_0x001b
            java.lang.Object r1 = r0.next()
            com.github.mikephil.charting.data.ChartData r1 = (com.github.mikephil.charting.data.ChartData) r1
            boolean r1 = r1.removeDataSet(r4)
            if (r1 == 0) goto L_0x0009
        L_0x001b:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.github.mikephil.charting.data.CombinedData.removeDataSet(com.github.mikephil.charting.interfaces.datasets.IBarLineScatterCandleBubbleDataSet):boolean");
    }

    @Deprecated
    public boolean removeDataSet(int i) {
        SystemUtils.log(6, Chart.LOG_TAG, "removeDataSet(int index) not supported for CombinedData", (Throwable) null, "com.github.mikephil.charting.data.CombinedData", 246);
        return false;
    }

    @Deprecated
    public boolean removeEntry(Entry entry, int i) {
        SystemUtils.log(6, Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData", (Throwable) null, "com.github.mikephil.charting.data.CombinedData", 253);
        return false;
    }

    @Deprecated
    public boolean removeEntry(float f, int i) {
        SystemUtils.log(6, Chart.LOG_TAG, "removeEntry(...) not supported for CombinedData", (Throwable) null, "com.github.mikephil.charting.data.CombinedData", 260);
        return false;
    }
}

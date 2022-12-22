package com.didi.dcrypto.chart;

import android.content.Context;
import android.graphics.Color;
import android.view.MotionEvent;
import android.view.View;
import androidx.core.content.ContextCompat;
import com.didi.dcrypto.DCryptoMainFragment;
import com.didi.dcrypto.cryptoprice.CryptoPriceCallback;
import com.didi.dcrypto.model.GraphDataPoint;
import com.didi.dcrypto.util.DCryptoUtils;
import com.didi.dcrypto.util.FileUtils;
import com.didi.dcrypto.util.network.GetGraphDataAsyncTask;
import com.didi.dcrypto.util.network.NetworkConstants;
import com.didi.sdk.apm.SystemUtils;
import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.components.IMarker;
import com.github.mikephil.charting.components.YAxis;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.formatter.IFillFormatter;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.interfaces.dataprovider.LineDataProvider;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.github.mikephil.charting.listener.OnChartValueSelectedListener;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.taxis99.R;
import java.util.ArrayList;
import java.util.Date;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class ChartUtil {
    public static final int GRAPH_CATEGORIES_DAY = 0;
    public static final int GRAPH_CATEGORIES_MONTH = 2;
    public static final int GRAPH_CATEGORIES_WEEK = 1;
    public static final int GRAPH_CATEGORIES_YEAR = 3;
    public static int currentSelectedGraphCategories;

    /* renamed from: a */
    private CryptoPriceCallback f16455a;

    /* renamed from: b */
    private ChartCallback f16456b;
    /* access modifiers changed from: private */

    /* renamed from: c */
    public ScrollViewCallback f16457c;
    /* access modifiers changed from: private */

    /* renamed from: d */
    public LineChart f16458d;

    /* renamed from: e */
    private GraphDataPoint[] f16459e;

    /* renamed from: f */
    private GraphDataPoint[] f16460f;

    /* renamed from: g */
    private GraphDataPoint[] f16461g;

    /* renamed from: h */
    private GraphDataPoint[] f16462h;
    /* access modifiers changed from: private */

    /* renamed from: i */
    public Context f16463i;

    /* renamed from: j */
    private FileUtils f16464j;

    /* renamed from: k */
    private DCryptoUtils f16465k;

    /* renamed from: l */
    private OnChartValueSelectedListener f16466l = new OnChartValueSelectedListener() {
        public void onNothingSelected() {
        }

        public void onValueSelected(Entry entry, Highlight highlight) {
            SystemUtils.log(4, "VAL SELECTED", "Value: " + entry.getY() + ", xIndex: " + entry.getX() + ", DataSet index: " + highlight.getDataSetIndex(), (Throwable) null, "com.didi.dcrypto.chart.ChartUtil$1", 79);
            ChartUtil.this.m12119a(entry);
        }
    };

    /* renamed from: m */
    private View.OnTouchListener f16467m = new View.OnTouchListener() {
        public boolean onTouch(View view, MotionEvent motionEvent) {
            if (ChartUtil.this.f16463i == null) {
                return false;
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                ChartUtil.this.f16457c.setInterceptTouch(true);
                DCryptoMainFragment.shouldUpdatePrice = false;
            } else if (action == 1 || action == 3) {
                ChartUtil.this.f16457c.setInterceptTouch(false);
                DCryptoMainFragment.shouldUpdatePrice = true;
            }
            return false;
        }
    };

    public ChartUtil(CryptoPriceCallback cryptoPriceCallback, ChartCallback chartCallback, ScrollViewCallback scrollViewCallback, Context context, View view) {
        this.f16455a = cryptoPriceCallback;
        this.f16456b = chartCallback;
        this.f16457c = scrollViewCallback;
        this.f16463i = context;
        m12117a(view);
        this.f16464j = new FileUtils();
        this.f16465k = new DCryptoUtils();
    }

    public LineChart getChart() {
        return this.f16458d;
    }

    /* renamed from: a */
    private void m12120a(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject(str);
        int optInt = jSONObject.optInt("errno");
        String optString = jSONObject.optString("errmsg");
        if (optInt == 0) {
            JSONObject optJSONObject = jSONObject.optJSONObject("data");
            JSONArray optJSONArray = optJSONObject.optJSONArray("day_chart");
            JSONArray optJSONArray2 = optJSONObject.optJSONArray("week_chart");
            JSONArray optJSONArray3 = optJSONObject.optJSONArray("month_chart");
            JSONArray optJSONArray4 = optJSONObject.optJSONArray("year_chart");
            m12116a(0, optJSONArray);
            m12116a(1, optJSONArray2);
            m12116a(2, optJSONArray3);
            m12116a(3, optJSONArray4);
            refreshGraph(0);
            this.f16456b.onInitChart();
            return;
        }
        SystemUtils.log(4, "getprice", "getprice error = " + optString, (Throwable) null, "com.didi.dcrypto.chart.ChartUtil", 148);
    }

    /* renamed from: a */
    private void m12116a(int i, JSONArray jSONArray) throws JSONException {
        if (i == 0) {
            this.f16459e = m12122a(jSONArray);
        } else if (i == 1) {
            this.f16460f = m12122a(jSONArray);
        } else if (i == 2) {
            this.f16461g = m12122a(jSONArray);
        } else if (i == 3) {
            this.f16462h = m12122a(jSONArray);
        }
    }

    /* renamed from: a */
    private GraphDataPoint[] m12122a(JSONArray jSONArray) throws JSONException {
        GraphDataPoint[] graphDataPointArr = new GraphDataPoint[jSONArray.length()];
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONArray optJSONArray = jSONArray.optJSONArray(i);
            long parseLong = Long.parseLong(optJSONArray.optString(0));
            graphDataPointArr[i] = new GraphDataPoint((float) parseLong, Float.parseFloat(optJSONArray.optString(1)), new Date(parseLong));
        }
        return graphDataPointArr;
    }

    public void updateData(String str, String str2) {
        try {
            m12120a(str);
            if (this.f16463i != null) {
                this.f16464j.onWriteToFile(this.f16463i, str, str2);
            }
            this.f16465k.setGraphTimestamp(this.f16463i, str2);
        } catch (JSONException e) {
            e.printStackTrace();
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void refreshGraph(int i) {
        this.f16458d.clear();
        if (i == 0) {
            currentSelectedGraphCategories = 0;
            m12121a(this.f16459e);
        } else if (i == 1) {
            currentSelectedGraphCategories = 1;
            m12121a(this.f16460f);
        } else if (i == 2) {
            currentSelectedGraphCategories = 2;
            m12121a(this.f16461g);
        } else if (i == 3) {
            currentSelectedGraphCategories = 3;
            m12121a(this.f16462h);
        }
    }

    public void startGraphChart(String str) {
        Context context = this.f16463i;
        if (context != null) {
            if (context != null) {
                String onReadFromFile = this.f16464j.onReadFromFile(context, str);
                if (!onReadFromFile.equalsIgnoreCase("")) {
                    try {
                        m12120a(onReadFromFile);
                    } catch (JSONException e) {
                        e.printStackTrace();
                        this.f16464j.onWriteToFile(this.f16463i, "", str);
                    } catch (Exception e2) {
                        e2.printStackTrace();
                    }
                } else if (onReadFromFile.equalsIgnoreCase("")) {
                    this.f16464j.onWriteToFile(this.f16463i, "", str);
                }
            }
            if (this.f16465k.shouldFetchGraphData(this.f16463i, str)) {
                new GetGraphDataAsyncTask(this.f16456b, str).execute(new String[]{""});
            }
        }
    }

    /* renamed from: a */
    private void m12117a(View view) {
        if (this.f16463i != null) {
            LineChart lineChart = (LineChart) view.findViewById(R.id.crypto_graph_chart);
            this.f16458d = lineChart;
            lineChart.setViewPortOffsets(0.0f, 0.0f, 0.0f, 0.0f);
            this.f16458d.getDescription().setEnabled(false);
            this.f16458d.setTouchEnabled(true);
            this.f16458d.setDragYEnabled(false);
            this.f16458d.setScaleYEnabled(false);
            this.f16458d.setDragXEnabled(true);
            this.f16458d.setScaleXEnabled(false);
            this.f16458d.setBackgroundColor(0);
            this.f16458d.setPinchZoom(false);
            this.f16458d.setDrawGridBackground(false);
            this.f16458d.setMaxHighlightDistance(300.0f);
            MyMarkerView myMarkerView = new MyMarkerView(this.f16463i, R.layout.custom_marker_view, currentSelectedGraphCategories);
            myMarkerView.setOffset(new MPPointF(0.0f, 300.0f));
            myMarkerView.setChartView(this.f16458d);
            this.f16458d.setMarker(myMarkerView);
            this.f16458d.getXAxis().setEnabled(false);
            YAxis axisLeft = this.f16458d.getAxisLeft();
            axisLeft.setDrawGridLines(false);
            axisLeft.setAxisLineColor(-1);
            this.f16458d.getAxisRight().setEnabled(false);
            this.f16458d.setOnTouchListener(this.f16467m);
            this.f16458d.setOnChartValueSelectedListener(this.f16466l);
            this.f16458d.getLegend().setEnabled(false);
            this.f16458d.animateXY(2000, 2000);
            this.f16458d.invalidate();
        }
    }

    /* renamed from: a */
    private void m12121a(GraphDataPoint[] graphDataPointArr) {
        if (graphDataPointArr != null && graphDataPointArr.length != 0) {
            ArrayList arrayList = new ArrayList();
            for (GraphDataPoint graphDataPoint : graphDataPointArr) {
                arrayList.add(new Entry(graphDataPoint.f16483x, graphDataPoint.f16484y, (Object) graphDataPoint.date));
            }
            if (this.f16458d.getData() == null || ((LineData) this.f16458d.getData()).getDataSetCount() <= 0) {
                LineDataSet lineDataSet = new LineDataSet(arrayList, "DataSet 1");
                lineDataSet.setMode(LineDataSet.Mode.CUBIC_BEZIER);
                lineDataSet.setCubicIntensity(0.2f);
                lineDataSet.setDrawFilled(true);
                lineDataSet.setDrawCircles(false);
                lineDataSet.setLineWidth(2.0f);
                lineDataSet.setCircleRadius(4.0f);
                lineDataSet.setCircleColor(-1);
                lineDataSet.setHighLightColor(-16777216);
                lineDataSet.setColor(Color.parseColor("#FF38CCE3"));
                lineDataSet.setFillAlpha(100);
                lineDataSet.setDrawHorizontalHighlightIndicator(false);
                lineDataSet.setFillFormatter(new IFillFormatter() {
                    public float getFillLinePosition(ILineDataSet iLineDataSet, LineDataProvider lineDataProvider) {
                        return ChartUtil.this.f16458d.getAxisLeft().getAxisMinimum();
                    }
                });
                this.f16458d.setBackgroundColor(0);
                if (Utils.getSDKInt() >= 18) {
                    Context context = this.f16463i;
                    if (context != null) {
                        lineDataSet.setFillDrawable(ContextCompat.getDrawable(context, R.drawable.fade_blue));
                    }
                } else {
                    lineDataSet.setFillColor(-16777216);
                }
                LineData lineData = new LineData(lineDataSet);
                lineData.setValueTextSize(9.0f);
                lineData.setDrawValues(false);
                this.f16458d.setData(lineData);
            } else {
                ((LineDataSet) ((LineData) this.f16458d.getData()).getDataSetByIndex(0)).setValues(arrayList);
                ((LineData) this.f16458d.getData()).notifyDataChanged();
                this.f16458d.notifyDataSetChanged();
            }
            this.f16458d.setDrawMarkers(false);
            this.f16458d.setMarker((IMarker) null);
            MyMarkerView myMarkerView = new MyMarkerView(this.f16463i, R.layout.custom_marker_view, currentSelectedGraphCategories);
            myMarkerView.setOffset(new MPPointF(0.0f, 300.0f));
            myMarkerView.setChartView(this.f16458d);
            this.f16458d.setMarker(myMarkerView);
            this.f16458d.setDrawMarkers(true);
            this.f16458d.invalidate();
        }
    }

    public void resetChart() {
        if (this.f16463i != null) {
            this.f16458d.clear();
            this.f16456b.onResetChart();
            this.f16465k.clearTimestamp(this.f16463i, NetworkConstants.CURRENCY_BTC);
            this.f16465k.clearTimestamp(this.f16463i, NetworkConstants.CURRENCY_ETH);
            this.f16465k.clearTimestamp(this.f16463i, NetworkConstants.CURRENCY_USDC);
            this.f16465k.clearTimestamp(this.f16463i, NetworkConstants.CURRENCY_SOLANA);
            this.f16465k.clearTimestamp(this.f16463i, NetworkConstants.CURRENCY_MANA);
        }
    }

    /* access modifiers changed from: private */
    /* renamed from: a */
    public void m12119a(Entry entry) {
        if (this.f16463i != null) {
            int i = currentSelectedGraphCategories;
            if (i == 0) {
                this.f16455a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f16459e[0].f16484y));
            } else if (i == 1) {
                this.f16455a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f16460f[0].f16484y));
            } else if (i == 2) {
                this.f16455a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f16461g[0].f16484y));
            } else if (i == 3) {
                this.f16455a.updateMainPriceTitle(String.valueOf(entry.getY()), String.valueOf(this.f16462h[0].f16484y));
            }
        }
    }
}

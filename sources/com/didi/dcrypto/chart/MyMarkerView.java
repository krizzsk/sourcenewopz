package com.didi.dcrypto.chart;

import android.content.Context;
import android.widget.TextView;
import com.didi.dimina.container.util.TraceUtil;
import com.github.mikephil.charting.components.MarkerView;
import com.github.mikephil.charting.data.CandleEntry;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.highlight.Highlight;
import com.github.mikephil.charting.utils.MPPointF;
import com.github.mikephil.charting.utils.Utils;
import com.taxis99.R;
import java.util.Calendar;
import java.util.Date;

public class MyMarkerView extends MarkerView {

    /* renamed from: a */
    private final TextView f16468a = ((TextView) findViewById(R.id.tvContent));

    /* renamed from: b */
    private int f16469b;

    public static String theDay(int i) {
        switch (i) {
            case 1:
                return "Sun";
            case 2:
                return "Mon";
            case 3:
                return "Tue";
            case 4:
                return "Wed";
            case 5:
                return "Thu";
            case 6:
                return "Fri";
            case 7:
                return "Sat";
            default:
                return "default";
        }
    }

    public MyMarkerView(Context context, int i, int i2) {
        super(context, i);
        this.f16469b = i2;
    }

    public void refreshContent(Entry entry, Highlight highlight) {
        if (entry instanceof CandleEntry) {
            this.f16468a.setText(Utils.formatNumber(((CandleEntry) entry).getHigh(), 0, true));
        } else {
            Calendar a = m12125a((Date) entry.getData());
            StringBuilder sb = new StringBuilder();
            String str = a.get(9) == 1 ? "PM" : "AM";
            int i = this.f16469b;
            String str2 = "0";
            if (i == 0) {
                StringBuilder sb2 = new StringBuilder();
                sb2.append(a.get(11));
                sb2.append(":");
                if (a.get(12) >= 10) {
                    str2 = "";
                }
                sb2.append(str2);
                sb2.append(a.get(12));
                sb2.append(" ");
                sb2.append(str);
                sb.append(sb2.toString());
            } else if (i == 1) {
                StringBuilder sb3 = new StringBuilder();
                sb3.append(theDay(a.get(7)));
                sb3.append(" ");
                sb3.append(a.get(11));
                sb3.append(":");
                if (a.get(12) >= 10) {
                    str2 = "";
                }
                sb3.append(str2);
                sb3.append(a.get(12));
                sb3.append(" ");
                sb3.append(str);
                sb.append(sb3.toString());
            } else if (i == 2) {
                sb.append(theMonth(a.get(2)) + " " + a.get(5) + " " + a.get(11) + " " + str);
            } else if (i == 3) {
                sb.append(theMonth(a.get(2)) + " " + a.get(5) + " " + a.get(1));
            }
            this.f16468a.setText(sb.toString());
        }
        super.refreshContent(entry, highlight);
    }

    public static String theMonth(int i) {
        return new String[]{"JAN", "FEB", "MAR", "APR", "MAY", "JUN", "JUL", "AUG", "SEP", "OCT", "NOV", "DEC"}[i];
    }

    /* renamed from: a */
    private Calendar m12125a(Date date) {
        Calendar instance = Calendar.getInstance();
        instance.setTime(date);
        return instance;
    }

    public MPPointF getOffset() {
        return new MPPointF((float) (-(getWidth() / 2)), (float) ((-getHeight()) + TraceUtil.MINA_INDEX_UN_KNOW));
    }
}

package com.didichuxing.bigdata.p173dp.locsdk;

import android.location.Location;
import android.util.Pair;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* renamed from: com.didichuxing.bigdata.dp.locsdk.EvilTransform */
public class EvilTransform {

    /* renamed from: a */
    private static final double f45697a = 3.141592653589793d;

    /* renamed from: b */
    private static final double f45698b = 6378245.0d;

    /* renamed from: c */
    private static final double f45699c = 0.006693421622965943d;

    /* renamed from: d */
    private static List<Pair<Double, Double>> f45700d = new ArrayList();

    /* renamed from: e */
    private static List<Pair<Double, Double>> f45701e = new ArrayList();

    /* renamed from: f */
    private static List<List<Pair<Double, Double>>> f45702f = new ArrayList();

    /* renamed from: g */
    private static List<Pair<Double, Double>> f45703g = new ArrayList();

    /* renamed from: h */
    private static List<List<Pair<Double, Double>>> f45704h = new ArrayList();

    public static boolean outOfChina(double d, double d2) {
        return d < 72.004d || d > 137.8347d || d2 < 0.8293d || d2 > 55.8271d;
    }

    public static double[] transform(double d, double d2) {
        double d3 = d - 105.0d;
        double d4 = d2 - 35.0d;
        double a = m32741a(d3, d4);
        double b = m32743b(d3, d4);
        double d5 = (d2 / 180.0d) * 3.141592653589793d;
        double sin = Math.sin(d5);
        double d6 = 1.0d - ((f45699c * sin) * sin);
        double sqrt = Math.sqrt(d6);
        return new double[]{d + ((b * 180.0d) / (((f45698b / sqrt) * Math.cos(d5)) * 3.141592653589793d)), d2 + ((a * 180.0d) / ((6335552.717000426d / (d6 * sqrt)) * 3.141592653589793d))};
    }

    public static double calcdistance(double d, double d2, double d3, double d4) {
        double d5 = (d2 * 3.141592653589793d) / 180.0d;
        double d6 = ((21412.0d * (90.0d - d2)) / 90.0d) + 6356725.0d;
        double cos = (((d3 * 3.141592653589793d) / 180.0d) - ((d * 3.141592653589793d) / 180.0d)) * Math.cos(d5) * d6;
        double d7 = (((d4 * 3.141592653589793d) / 180.0d) - d5) * d6;
        return Math.sqrt((cos * cos) + (d7 * d7));
    }

    public static double[] calcdistanceDxDy(double d, double d2, double d3, double d4) {
        double d5 = (d2 * 3.141592653589793d) / 180.0d;
        double d6 = ((21412.0d * (90.0d - d2)) / 90.0d) + 6356725.0d;
        return new double[]{(((d3 * 3.141592653589793d) / 180.0d) - ((d * 3.141592653589793d) / 180.0d)) * Math.cos(d5) * d6, (((d4 * 3.141592653589793d) / 180.0d) - d5) * d6};
    }

    /* renamed from: a */
    private static double m32741a(double d, double d2) {
        double d3 = d * 2.0d;
        double d4 = d2 * 3.141592653589793d;
        return -100.0d + d3 + (d2 * 3.0d) + (d2 * 0.2d * d2) + (0.1d * d * d2) + (Math.sqrt(Math.abs(d)) * 0.2d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin(d3 * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d4) * 20.0d) + (Math.sin((d2 / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d2 / 12.0d) * 3.141592653589793d) * 160.0d) + (Math.sin(d4 / 30.0d) * 320.0d)) * 2.0d) / 3.0d);
    }

    /* renamed from: b */
    private static double m32743b(double d, double d2) {
        double d3 = d * 0.1d;
        return d + 300.0d + (d2 * 2.0d) + (d3 * d) + (d3 * d2) + (Math.sqrt(Math.abs(d)) * 0.1d) + ((((Math.sin((6.0d * d) * 3.141592653589793d) * 20.0d) + (Math.sin((d * 2.0d) * 3.141592653589793d) * 20.0d)) * 2.0d) / 3.0d) + ((((Math.sin(d * 3.141592653589793d) * 20.0d) + (Math.sin((d / 3.0d) * 3.141592653589793d) * 40.0d)) * 2.0d) / 3.0d) + ((((Math.sin((d / 12.0d) * 3.141592653589793d) * 150.0d) + (Math.sin((d / 30.0d) * 3.141592653589793d) * 300.0d)) * 2.0d) / 3.0d);
    }

    static {
        f45700d.add(new Pair(Double.valueOf(121.600456d), Double.valueOf(25.522615d)));
        f45700d.add(new Pair(Double.valueOf(122.424431d), Double.valueOf(24.866503d)));
        f45700d.add(new Pair(Double.valueOf(121.336784d), Double.valueOf(21.053744d)));
        f45700d.add(new Pair(Double.valueOf(119.425163d), Double.valueOf(23.684774d)));
        f45701e.add(new Pair(Double.valueOf(118.187034d), Double.valueOf(24.435898d)));
        f45701e.add(new Pair(Double.valueOf(118.436286d), Double.valueOf(24.547123d)));
        f45701e.add(new Pair(Double.valueOf(118.520744d), Double.valueOf(24.42652d)));
        f45701e.add(new Pair(Double.valueOf(118.254325d), Double.valueOf(24.362735d)));
        f45702f.add(f45700d);
        f45702f.add(f45701e);
        List<Pair<Double, Double>> list = f45703g;
        Double valueOf = Double.valueOf(140.52269d);
        Double valueOf2 = Double.valueOf(45.644768d);
        list.add(new Pair(valueOf, valueOf2));
        f45703g.add(new Pair(Double.valueOf(149.179916d), valueOf2));
        f45703g.add(new Pair(Double.valueOf(144.785385d), Double.valueOf(35.817813d)));
        f45703g.add(new Pair(Double.valueOf(130.634995d), Double.valueOf(29.343875d)));
        f45703g.add(new Pair(Double.valueOf(127.470932d), Double.valueOf(32.7688d)));
        f45704h.add(f45703g);
    }

    public static boolean isInTaiWan(double d, double d2) {
        return m32742a(d, d2, f45702f);
    }

    public static boolean isInJapan(double d, double d2) {
        return m32742a(d, d2, f45704h);
    }

    /* renamed from: a */
    private static boolean m32742a(double d, double d2, List<List<Pair<Double, Double>>> list) {
        HashSet hashSet = new HashSet();
        for (List next : list) {
            int size = next.size();
            int i = 0;
            while (i < size) {
                int i2 = i + 1;
                int i3 = i == size + -1 ? 0 : i2;
                double doubleValue = ((Double) ((Pair) next.get(i3)).first).doubleValue();
                double doubleValue2 = ((Double) ((Pair) next.get(i)).first).doubleValue();
                double doubleValue3 = ((Double) ((Pair) next.get(i3)).second).doubleValue();
                double doubleValue4 = ((Double) ((Pair) next.get(i)).second).doubleValue();
                if (d2 < doubleValue4 || d2 < doubleValue3) {
                    double d3 = doubleValue - d;
                    double d4 = d - doubleValue2;
                    if (d3 * d4 >= 0.0d) {
                        double d5 = doubleValue - doubleValue2;
                        if (Math.abs(d5) >= 1.0000000116860974E-7d) {
                            double d6 = ((d4 * doubleValue3) + (d3 * doubleValue4)) / d5;
                            if (d6 > d2 && (doubleValue3 - d6) * (d6 - doubleValue4) >= 0.0d) {
                                hashSet.add(new Pair(Double.valueOf(d), Double.valueOf(d6)));
                            }
                        }
                    }
                }
                i = i2;
            }
        }
        if (hashSet.size() % 2 == 1) {
            return true;
        }
        return false;
    }

    public static boolean isOutOfMainLand(double d, double d2) {
        return outOfChina(d, d2) || isInTaiWan(d, d2) || isInJapan(d, d2);
    }

    public static boolean isOutOfMainLand(Location location) {
        return location != null && isOutOfMainLand(location.getLongitude(), location.getLatitude());
    }

    public static boolean isOutOfMainLand(OSLocationWrapper oSLocationWrapper) {
        return oSLocationWrapper != null && isOutOfMainLand(oSLocationWrapper.getLocation());
    }

    public static double[] transformFromGCJToWGS(double d, double d2) {
        DDLonLat dDLonLat = new DDLonLat(d, d2, (String) null);
        while (true) {
            double[] transform = transform(dDLonLat.lon, dDLonLat.lat);
            DDLonLat dDLonLat2 = new DDLonLat(transform[0], transform[1], (String) null);
            DDLonLat dDLonLat3 = new DDLonLat(d - dDLonLat2.lon, d2 - dDLonLat2.lat, (String) null);
            if (Math.abs(dDLonLat3.lat) >= 1.0E-7d || Math.abs(dDLonLat3.lon) >= 1.0E-7d) {
                dDLonLat.lat += dDLonLat3.lat;
                dDLonLat.lon += dDLonLat3.lon;
            } else {
                return new double[]{dDLonLat.lon, dDLonLat.lat};
            }
        }
    }
}

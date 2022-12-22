package com.didichuxing.nightmode.sdk;

class SunriseSunsetCalculator {
    private static double deg_to_rad(double d) {
        return d * 0.017453292519943295d;
    }

    private static double normalize_range(double d, double d2) {
        while (d < 0.0d) {
            d += d2;
        }
        while (d >= d2) {
            d -= d2;
        }
        return d;
    }

    private static double rad_to_deg(double d) {
        return d * 57.29577951308232d;
    }

    SunriseSunsetCalculator() {
    }

    private static double deg_sin(double d) {
        return Math.sin(deg_to_rad(d));
    }

    private static double deg_asin(double d) {
        return rad_to_deg(Math.asin(d));
    }

    private static double deg_atan(double d) {
        return rad_to_deg(Math.atan(d));
    }

    private static double deg_tan(double d) {
        return Math.tan(deg_to_rad(d));
    }

    private static double deg_cos(double d) {
        return Math.cos(deg_to_rad(d));
    }

    private static double deg_acos(double d) {
        return rad_to_deg(Math.acos(d));
    }

    public static double getSunriseDate(double d, double d2, int i, int i2, int i3) {
        return getDateForForSunEvent(NightModeState.DAY, 90.0d, d, d2, i, i2, i3);
    }

    public static double getSunsetDate(double d, double d2, int i, int i2, int i3) {
        return getDateForForSunEvent(NightModeState.NIGHT, 90.0d, d, d2, i, i2, i3);
    }

    private static double getDateForForSunEvent(NightModeState nightModeState, double d, double d2, double d3, int i, int i2, int i3) {
        double d4;
        NightModeState nightModeState2 = nightModeState;
        double d5 = (double) i2;
        double d6 = (double) i;
        double floor = ((Math.floor((275.0d * d5) / 9.0d) - (Math.floor((d5 + 9.0d) / 12.0d) * (Math.floor(((d6 - (Math.floor(d6 / 4.0d) * 4.0d)) + 2.0d) / 3.0d) + 1.0d))) + ((double) i3)) - 30.0d;
        double d7 = d3 / 15.0d;
        double d8 = floor + (((nightModeState2 == NightModeState.DAY ? 6.0d : 18.0d) - d7) / 24.0d);
        double d9 = (0.9856d * d8) - 3.289d;
        double normalize_range = normalize_range(d9 + (deg_sin(d9) * 1.916d) + (deg_sin(d9 * 2.0d) * 0.02d) + 282.634d, 360.0d);
        double normalize_range2 = normalize_range(deg_atan(deg_tan(normalize_range) * 0.91764d), 360.0d);
        double floor2 = (normalize_range2 + ((Math.floor(normalize_range / 90.0d) * 90.0d) - (Math.floor(normalize_range2 / 90.0d) * 90.0d))) / 15.0d;
        double deg_sin = deg_sin(normalize_range) * 0.39782d;
        double deg_cos = (deg_cos(d) - (deg_sin * deg_sin(d2))) / (deg_cos(deg_asin(deg_sin)) * deg_cos(d2));
        if (deg_cos > 1.0d || deg_cos < -1.0d) {
            return 0.0d;
        }
        if (nightModeState2 == NightModeState.DAY) {
            d4 = 360.0d - deg_acos(deg_cos);
        } else {
            d4 = deg_acos(deg_cos);
        }
        return normalize_range(normalize_range(((((d4 / 15.0d) + floor2) - (d8 * 0.06571d)) - 6.622d) - d7, 24.0d) + ((double) ((int) (d7 + ((double) (d3 >= 0.0d ? 1 : -1))))), 24.0d);
    }
}

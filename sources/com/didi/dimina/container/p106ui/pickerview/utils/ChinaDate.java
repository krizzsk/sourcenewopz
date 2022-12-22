package com.didi.dimina.container.p106ui.pickerview.utils;

import android.support.p003v4.media.session.PlaybackStateCompat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Locale;
import org.osgi.framework.VersionRange;

/* renamed from: com.didi.dimina.container.ui.pickerview.utils.ChinaDate */
public class ChinaDate {

    /* renamed from: a */
    private static final long[] f17588a = {19416, 19168, 42352, 21717, 53856, 55632, 91476, 22176, 39632, 21970, 19168, 42422, 42192, 53840, 119381, 46400, 54944, 44450, 38320, 84343, 18800, 42160, 46261, 27216, 27968, 109396, 11104, 38256, 21234, 18800, 25958, 54432, 59984, 28309, 23248, 11104, 100067, 37600, 116951, 51536, 54432, 120998, 46416, 22176, 107956, 9680, 37584, 53938, 43344, 46423, 27808, 46416, 86869, 19872, 42416, 83315, 21168, 43432, 59728, 27296, 44710, 43856, 19296, 43748, 42352, 21088, 62051, 55632, 23383, 22176, 38608, 19925, 19152, 42192, 54484, 53840, 54616, 46400, 46752, 103846, 38320, 18864, 43380, 42160, 45690, 27216, 27968, 44870, 43872, 38256, 19189, 18800, 25776, 29859, 59984, 27480, 21952, 43872, 38613, 37600, 51552, 55636, 54432, 55888, 30034, 22176, 43959, 9680, 37584, 51893, 43344, 46240, 47780, 44368, 21977, 19360, 42416, 86390, 21168, 43312, 31060, 27296, 44368, 23378, 19296, 42726, 42208, 53856, 60005, 54576, 23200, 30371, 38608, 19195, 19152, 42192, 118966, 53840, 54560, 56645, 46496, 22224, 21938, 18864, 42359, 42160, 43600, 111189, 27936, 44448, 84835, 37744, 18936, 18800, 25776, 92326, 59984, 27424, 108228, 43744, 41696, 53987, 51552, 54615, 54432, 55888, 23893, 22176, 42704, 21972, 21200, 43448, 43344, 46240, 46758, 44368, 21920, 43940, 42416, 21168, 45683, 26928, 29495, 27296, 44368, 84821, 19296, 42352, 21732, 53600, 59752, 54560, 55968, 92838, 22224, 19168, 43476, 41680, 53584, 62034, 54560};

    /* renamed from: b */
    private static final String[] f17589b = {"", "正", "二", "三", "四", "五", "六", "七", "八", "九", "十", "冬", "腊"};

    /* renamed from: c */
    private static final String[] f17590c = {"甲", "乙", "丙", "丁", "戊", "己", "庚", "辛", "壬", "癸"};

    /* renamed from: d */
    private static final String[] f17591d = {"子", "丑", "寅", "卯", "辰", "巳", "午", "未", "申", "酉", "戌", "亥"};

    /* renamed from: e */
    private static final String[] f17592e = {"鼠", "牛", "虎", "兔", "龙", "蛇", "马", "羊", "猴", "鸡", "狗", "猪"};

    /* renamed from: f */
    private static final SimpleDateFormat f17593f = new SimpleDateFormat("yyyy年M月d日 EEEEE");

    /* renamed from: a */
    private static int m13089a(int i) {
        int i2 = 348;
        for (int i3 = 32768; i3 > 8; i3 >>= 1) {
            if ((f17588a[i - 1900] & ((long) i3)) != 0) {
                i2++;
            }
        }
        return i2 + leapDays(i);
    }

    public static int leapDays(int i) {
        if (leapMonth(i) != 0) {
            return (f17588a[i + -1900] & PlaybackStateCompat.ACTION_PREPARE_FROM_SEARCH) != 0 ? 30 : 29;
        }
        return 0;
    }

    public static int leapMonth(int i) {
        return (int) (f17588a[i - 1900] & 15);
    }

    public static int monthDays(int i, int i2) {
        return (((long) (65536 >> i2)) & f17588a[i + -1900]) == 0 ? 29 : 30;
    }

    public static String AnimalsYear(int i) {
        return f17592e[(i - 4) % 12];
    }

    /* renamed from: b */
    private static String m13090b(int i) {
        return f17590c[i % 10] + f17591d[i % 12];
    }

    public static String cyclical(int i) {
        return m13090b((i - 1900) + 36);
    }

    public static long[] calElement(int i, int i2, int i3) {
        int i4;
        long j;
        long j2;
        long[] jArr = new long[7];
        int i5 = 1900;
        long time = (new GregorianCalendar(i, i2 - 1, i3).getTime().getTime() - new GregorianCalendar(1900, 0, 31).getTime().getTime()) / 86400000;
        jArr[5] = 40 + time;
        jArr[4] = 14;
        int i6 = 0;
        while (i5 < 2100 && time > 0) {
            i6 = m13089a(i5);
            time -= (long) i6;
            jArr[4] = jArr[4] + 12;
            i5++;
        }
        if (time < 0) {
            time += (long) i4;
            i5--;
            jArr[4] = jArr[4] - 12;
        }
        jArr[0] = (long) i5;
        jArr[3] = (long) (i5 - 1864);
        int leapMonth = leapMonth(i5);
        jArr[6] = 0;
        int i7 = 1;
        while (i7 < 13 && time > 0) {
            if (leapMonth > 0 && i7 == leapMonth + 1 && jArr[6] == 0) {
                i7--;
                jArr[6] = 1;
                j2 = time;
                i4 = leapDays((int) jArr[0]);
            } else {
                j2 = time;
                i4 = monthDays((int) jArr[0], i7);
            }
            if (jArr[6] == 1 && i7 == leapMonth + 1) {
                jArr[6] = 0;
            }
            time = j2 - ((long) i4);
            if (jArr[6] == 0) {
                jArr[4] = jArr[4] + 1;
            }
            i7++;
        }
        long j3 = time;
        int i8 = (j3 > 0 ? 1 : (j3 == 0 ? 0 : -1));
        if (i8 == 0 && leapMonth > 0 && i7 == leapMonth + 1) {
            if (jArr[6] == 1) {
                jArr[6] = 0;
            } else {
                jArr[6] = 1;
                i7--;
                jArr[4] = jArr[4] - 1;
            }
        }
        if (i8 < 0) {
            j = j3 + ((long) i4);
            i7--;
            jArr[4] = jArr[4] - 1;
        } else {
            j = j3;
        }
        jArr[1] = (long) i7;
        jArr[2] = j + 1;
        return jArr;
    }

    public static String getChinaDate(int i) {
        if (i == 10) {
            return "初十";
        }
        if (i == 20) {
            return "二十";
        }
        if (i == 30) {
            return "三十";
        }
        int i2 = i / 10;
        String str = i2 == 0 ? "初" : "";
        if (i2 == 1) {
            str = "十";
        }
        if (i2 == 2) {
            str = "廿";
        }
        if (i2 == 3) {
            str = "三";
        }
        switch (i % 10) {
            case 1:
                return str + "一";
            case 2:
                return str + "二";
            case 3:
                return str + "三";
            case 4:
                return str + "四";
            case 5:
                return str + "五";
            case 6:
                return str + "六";
            case 7:
                return str + "七";
            case 8:
                return str + "八";
            case 9:
                return str + "九";
            default:
                return str;
        }
    }

    public static String getCurrentLunarDate() {
        Calendar instance = Calendar.getInstance(Locale.SIMPLIFIED_CHINESE);
        int i = instance.get(1);
        long[] calElement = calElement(i, instance.get(2) + 1, instance.get(5));
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(f17593f.format(instance.getTime()));
        stringBuffer.append(" 农历");
        stringBuffer.append(cyclical(i));
        stringBuffer.append(VersionRange.LEFT_OPEN);
        stringBuffer.append(AnimalsYear(i));
        stringBuffer.append(")年");
        stringBuffer.append(f17589b[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }

    public static String oneDay(int i, int i2, int i3) {
        long[] calElement = calElement(i, i2, i3);
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append(" 农历");
        stringBuffer.append(cyclical(i));
        stringBuffer.append(VersionRange.LEFT_OPEN);
        stringBuffer.append(AnimalsYear(i));
        stringBuffer.append(")年");
        stringBuffer.append(f17589b[(int) calElement[1]]);
        stringBuffer.append("月");
        stringBuffer.append(getChinaDate((int) calElement[2]));
        return stringBuffer.toString();
    }

    public static String getLunarYearText(int i) {
        StringBuilder sb = new StringBuilder();
        int i2 = i - 4;
        sb.append(f17590c[i2 % 10]);
        sb.append(f17591d[i2 % 12]);
        sb.append("年");
        return sb.toString();
    }

    public static ArrayList<String> getYears(int i, int i2) {
        ArrayList<String> arrayList = new ArrayList<>();
        while (i < i2) {
            arrayList.add(String.format("%s(%d)", new Object[]{getLunarYearText(i), Integer.valueOf(i)}));
            i++;
        }
        return arrayList;
    }

    public static ArrayList<String> getMonths(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 < f17589b.length; i2++) {
            arrayList.add(f17589b[i2] + "月");
        }
        if (leapMonth(i) != 0) {
            int leapMonth = leapMonth(i);
            arrayList.add(leapMonth, "闰" + f17589b[leapMonth(i)] + "月");
        }
        return arrayList;
    }

    public static ArrayList<String> getLunarDays(int i) {
        ArrayList<String> arrayList = new ArrayList<>();
        for (int i2 = 1; i2 <= i; i2++) {
            arrayList.add(getChinaDate(i2));
        }
        return arrayList;
    }
}

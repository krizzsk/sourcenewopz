package com.didi.beatles.p099im.utils;

import android.content.Context;
import android.os.Build;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.resource.IMResource;
import com.taxis99.R;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

/* renamed from: com.didi.beatles.im.utils.IMDateUtil */
public class IMDateUtil {

    /* renamed from: a */
    private static final String f9752a = " ";

    public static boolean needDisplayTime(Long l, Long l2) {
        return Math.abs(l2.longValue() - l.longValue()) / 1000 >= 300;
    }

    public static String getNowDateToStr() {
        return new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date(System.currentTimeMillis()));
    }

    public static String getDateDetail(Context context, String str) {
        Calendar instance = Calendar.getInstance();
        Calendar instance2 = Calendar.getInstance();
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        try {
            instance.setTime(simpleDateFormat.parse(getNowDateToStr()));
            instance.set(9, 0);
            instance.set(10, 0);
            instance.set(12, 0);
            instance.set(13, 0);
            instance2.setTime(simpleDateFormat.parse(str));
            return m6596a(context, ((float) (instance2.getTimeInMillis() - instance.getTimeInMillis())) / 8.64E7f, instance2);
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
    }

    /* renamed from: a */
    private static String m6596a(Context context, float f, Calendar calendar) {
        Context context2 = context;
        Calendar calendar2 = calendar;
        int i = calendar2.get(2);
        int i2 = calendar2.get(5);
        int i3 = calendar2.get(11);
        int i4 = calendar2.get(12);
        String str = "0";
        String str2 = i3 < 10 ? str : "";
        if (i4 >= 10) {
            str = "";
        }
        if (f < 0.0f || f >= 1.0f) {
            if (f < -1.0f || f >= 0.0f) {
                if (f < 1.0f || f >= 2.0f) {
                    if (i3 < 6) {
                        return m6597a(context2, i + 1, i2) + " " + str2 + i3 + ":" + str + i4;
                    } else if (i3 < 12) {
                        return m6597a(context2, i + 1, i2) + " " + str2 + i3 + ":" + str + i4;
                    } else if (i3 < 13) {
                        return m6597a(context2, i + 1, i2) + " " + i3 + ":" + str + i4;
                    } else if (i3 < 19) {
                        return m6597a(context2, i + 1, i2) + " " + i3 + ":" + str + i4;
                    } else {
                        return m6597a(context2, i + 1, i2) + " " + i3 + ":" + str + i4;
                    }
                } else if (i3 < 6) {
                    return IMResource.getString(R.string.im_tomorrow) + " " + str2 + i3 + ":" + str + i4;
                } else if (i3 < 12) {
                    return IMResource.getString(R.string.im_tomorrow) + " " + str2 + i3 + ":" + str + i4;
                } else if (i3 < 13) {
                    return IMResource.getString(R.string.im_tomorrow) + " " + i3 + ":" + str + i4;
                } else if (i3 < 19) {
                    return IMResource.getString(R.string.im_tomorrow) + " " + i3 + ":" + str + i4;
                } else {
                    return IMResource.getString(R.string.im_tomorrow) + " " + i3 + ":" + str + i4;
                }
            } else if (i3 < 6) {
                return IMResource.getString(R.string.im_yesterday) + " " + str2 + i3 + ":" + str + i4;
            } else if (i3 < 12) {
                return IMResource.getString(R.string.im_yesterday) + " " + str2 + i3 + ":" + str + i4;
            } else if (i3 < 13) {
                return IMResource.getString(R.string.im_yesterday) + " " + i3 + ":" + str + i4;
            } else if (i3 < 19) {
                return IMResource.getString(R.string.im_yesterday) + " " + i3 + ":" + str + i4;
            } else {
                return IMResource.getString(R.string.im_yesterday) + " " + i3 + ":" + str + i4;
            }
        } else if (i3 < 6) {
            return IMResource.getString(R.string.im_today) + " " + str2 + i3 + ":" + str + i4;
        } else if (i3 < 12) {
            return IMResource.getString(R.string.im_today) + " " + str2 + i3 + ":" + str + i4;
        } else if (i3 < 13) {
            return IMResource.getString(R.string.im_today) + " " + i3 + ":" + str + i4;
        } else if (i3 < 19) {
            return IMResource.getString(R.string.im_today) + " " + i3 + ":" + str + i4;
        } else {
            return IMResource.getString(R.string.im_today) + " " + i3 + ":" + str + i4;
        }
    }

    /* renamed from: a */
    private static String m6597a(Context context, int i, int i2) {
        SimpleDateFormat simpleDateFormat;
        if (context == null) {
            return i + "/" + i2;
        }
        String string = context.getString(R.string.im_dates_day_format);
        Locale locale = IMContextInfoHelper.getLocale();
        if (locale == null) {
            simpleDateFormat = new SimpleDateFormat(string);
        } else {
            simpleDateFormat = new SimpleDateFormat(string, locale);
        }
        Calendar instance = Calendar.getInstance();
        instance.set(0, i - 1, i2);
        return simpleDateFormat.format(new Date(instance.getTimeInMillis()));
    }

    /* renamed from: a */
    private static String m6598a(Context context, Calendar calendar) {
        SimpleDateFormat simpleDateFormat;
        if (context == null || calendar == null) {
            return "";
        }
        String string = context.getString(R.string.im_dates_date_format);
        Locale locale = IMContextInfoHelper.getLocale();
        if (locale == null) {
            simpleDateFormat = new SimpleDateFormat(string);
        } else {
            simpleDateFormat = new SimpleDateFormat(string, locale);
        }
        return simpleDateFormat.format(new Date(calendar.getTimeInMillis()));
    }

    public static Locale getLocale() {
        if (Build.VERSION.SDK_INT < 24) {
            return IMContextInfoHelper.getContext().getResources().getConfiguration().locale;
        }
        return IMContextInfoHelper.getContext().getResources().getConfiguration().getLocales().get(0);
    }

    public static String getTimeDiffDesc(Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Date date2 = new Date();
        instance.setTime(date2);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        String[] stringArray = IMContextInfoHelper.getContext().getResources().getStringArray(R.array.bts_im_dates);
        int i = instance2.get(7) - 1;
        if (i < 0) {
            i = 0;
        }
        Calendar instance3 = Calendar.getInstance();
        Calendar instance4 = Calendar.getInstance();
        instance4.set(1, instance3.get(1));
        instance4.set(2, instance3.get(2));
        instance4.set(5, instance3.get(5));
        instance4.set(11, 0);
        instance4.set(12, 0);
        instance4.set(13, 0);
        Calendar instance5 = Calendar.getInstance();
        instance5.setTime(date2);
        instance5.add(5, -1);
        instance5.set(11, 0);
        instance5.set(12, 0);
        instance5.set(13, 0);
        Calendar instance6 = Calendar.getInstance();
        instance6.setTime(date2);
        instance6.add(5, -7);
        instance6.set(11, 0);
        instance6.set(12, 0);
        instance6.set(13, 0);
        instance2.get(2);
        instance2.get(5);
        int i2 = instance2.get(11);
        int i3 = instance2.get(12);
        String str = "0";
        String str2 = i2 < 10 ? str : "";
        if (i3 >= 10) {
            str = "";
        }
        if (instance2.after(instance4)) {
            if (i2 < 6) {
                return str2 + i2 + ":" + str + i3;
            } else if (i2 < 12) {
                return str2 + i2 + ":" + str + i3;
            } else if (i2 < 13) {
                return i2 + ":" + str + i3;
            } else if (i2 < 19) {
                return i2 + ":" + str + i3;
            } else {
                return i2 + ":" + str + i3;
            }
        } else if (!instance2.before(instance4) || !instance2.after(instance5)) {
            if (!instance2.before(instance5) || !instance2.after(instance6)) {
                return null;
            }
            if (i2 < 6) {
                return stringArray[i];
            }
            if (i2 < 12) {
                return stringArray[i];
            }
            if (i2 < 13) {
                return stringArray[i];
            }
            if (i2 < 19) {
                return stringArray[i];
            }
            return stringArray[i];
        } else if (i2 < 6) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " ";
        } else if (i2 < 12) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " ";
        } else if (i2 < 13) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " ";
        } else if (i2 < 19) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " ";
        } else {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " ";
        }
    }

    public static String getMsgTimeDiffDesc(Context context, Date date) {
        Context context2 = context;
        Date date2 = date;
        if (date2 == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Date date3 = new Date();
        instance.setTime(date3);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date2);
        String[] stringArray = IMContextInfoHelper.getContext().getResources().getStringArray(R.array.bts_im_dates);
        int i = instance2.get(7) - 1;
        if (i < 0) {
            i = 0;
        }
        Calendar instance3 = Calendar.getInstance();
        Calendar instance4 = Calendar.getInstance();
        instance4.set(1, instance3.get(1));
        instance4.set(2, instance3.get(2));
        instance4.set(5, instance3.get(5));
        instance4.set(11, 0);
        instance4.set(12, 0);
        instance4.set(13, 0);
        Calendar instance5 = Calendar.getInstance();
        instance5.setTime(date3);
        instance5.add(5, -1);
        instance5.set(11, 0);
        instance5.set(12, 0);
        instance5.set(13, 0);
        Calendar instance6 = Calendar.getInstance();
        instance6.setTime(date3);
        instance6.add(5, -7);
        instance6.set(11, 0);
        instance6.set(12, 0);
        instance6.set(13, 0);
        int i2 = instance2.get(2);
        int i3 = instance2.get(5);
        int i4 = instance2.get(11);
        int i5 = instance2.get(12);
        String str = "0";
        String str2 = i4 < 10 ? str : "";
        if (i5 >= 10) {
            str = "";
        }
        if (instance2.after(instance4)) {
            if (i4 < 6) {
                return str2 + i4 + ":" + str + i5;
            } else if (i4 < 12) {
                return str2 + i4 + ":" + str + i5;
            } else if (i4 < 13) {
                return i4 + ":" + str + i5;
            } else if (i4 < 19) {
                return i4 + ":" + str + i5;
            } else {
                return i4 + ":" + str + i5;
            }
        } else if (!instance2.before(instance4) || !instance2.after(instance5)) {
            if (!instance2.before(instance5) || !instance2.after(instance6)) {
                if (!instance2.before(instance5) || !instance2.after(instance6)) {
                    if (i4 < 6) {
                        return m6597a(context2, i2 + 1, i3) + " " + str2 + i4 + ":" + str + i5;
                    } else if (i4 < 12) {
                        return m6597a(context2, i2 + 1, i3) + " " + str2 + i4 + ":" + str + i5;
                    } else if (i4 < 13) {
                        return m6597a(context2, i2 + 1, i3) + " " + i4 + ":" + str + i5;
                    } else if (i4 < 19) {
                        return m6597a(context2, i2 + 1, i3) + " " + i4 + ":" + str + i5;
                    } else {
                        return m6597a(context2, i2 + 1, i3) + " " + i4 + ":" + str + i5;
                    }
                } else if (i4 < 6) {
                    return stringArray[i] + " " + str2 + i4 + ":" + str + i5;
                } else if (i4 < 12) {
                    return stringArray[i] + " " + str2 + i4 + ":" + str + i5;
                } else if (i4 < 13) {
                    return stringArray[i] + " " + i4 + ":" + str + i5;
                } else if (i4 < 19) {
                    return stringArray[i] + " " + i4 + ":" + str + i5;
                } else {
                    return stringArray[i] + " " + i4 + ":" + str + i5;
                }
            } else if (i4 < 6) {
                return stringArray[i] + " " + str2 + i4 + ":" + str + i5;
            } else if (i4 < 12) {
                return stringArray[i] + " " + str2 + i4 + ":" + str + i5;
            } else if (i4 < 13) {
                return stringArray[i] + " " + i4 + ":" + str + i5;
            } else if (i4 < 19) {
                return stringArray[i] + " " + i4 + ":" + str + i5;
            } else {
                return stringArray[i] + " " + i4 + ":" + str + i5;
            }
        } else if (i4 < 6) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " " + str2 + i4 + ":" + str + i5;
        } else if (i4 < 12) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " " + str2 + i4 + ":" + str + i5;
        } else if (i4 < 13) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " " + i4 + ":" + str + i5;
        } else if (i4 < 19) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " " + i4 + ":" + str + i5;
        } else {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday) + " " + i4 + ":" + str + i5;
        }
    }

    public static String getListTimeDiffDesc(Context context, Date date) {
        if (date == null) {
            return null;
        }
        Calendar instance = Calendar.getInstance();
        Date date2 = new Date();
        instance.setTime(date2);
        Calendar instance2 = Calendar.getInstance();
        instance2.setTime(date);
        Calendar instance3 = Calendar.getInstance();
        Calendar instance4 = Calendar.getInstance();
        instance4.set(1, instance3.get(1));
        instance4.set(2, instance3.get(2));
        instance4.set(5, instance3.get(5));
        instance4.set(11, 0);
        instance4.set(12, 0);
        instance4.set(13, 0);
        Calendar instance5 = Calendar.getInstance();
        instance5.setTime(date2);
        instance5.add(5, -1);
        instance5.set(11, 0);
        instance5.set(12, 0);
        instance5.set(13, 0);
        Calendar instance6 = Calendar.getInstance();
        instance6.setTime(date2);
        instance6.add(1, -1);
        instance6.set(11, 0);
        instance6.set(12, 0);
        instance6.set(13, 0);
        instance2.get(1);
        int i = instance2.get(2);
        int i2 = instance2.get(5);
        int i3 = instance2.get(11);
        int i4 = instance2.get(12);
        String str = "0";
        String str2 = i3 < 10 ? str : "";
        if (i4 >= 10) {
            str = "";
        }
        if (instance2.after(instance4)) {
            if (i3 < 6) {
                return str2 + i3 + ":" + str + i4;
            } else if (i3 < 12) {
                return str2 + i3 + ":" + str + i4;
            } else if (i3 < 13) {
                return i3 + ":" + str + i4;
            } else if (i3 < 19) {
                return i3 + ":" + str + i4;
            } else {
                return i3 + ":" + str + i4;
            }
        } else if (instance2.before(instance4) && instance2.after(instance5)) {
            return IMContextInfoHelper.getContext().getString(R.string.bts_im_yesterday);
        } else {
            if (!instance2.before(instance5) || !instance2.after(instance6)) {
                return m6598a(context, instance2);
            }
            return m6597a(context, i + 1, i2);
        }
    }

    public static String getFeedTimeDiffDesc(Date date) {
        if (date == null) {
            return null;
        }
        long timeInMillis = Calendar.getInstance().getTimeInMillis() - date.getTime();
        if (timeInMillis < 60000) {
            return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_sec);
        }
        if (timeInMillis < 3600000) {
            int ceil = (int) Math.ceil((double) (timeInMillis / 60000));
            if (ceil == 1) {
                return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_min_one);
            }
            return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_min, new Object[]{String.valueOf(ceil)});
        } else if (timeInMillis < 86400000) {
            int ceil2 = (int) Math.ceil((double) (timeInMillis / 3600000));
            if (ceil2 == 1) {
                return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_hour_one);
            }
            return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_hour, new Object[]{String.valueOf(ceil2)});
        } else {
            int ceil3 = (int) Math.ceil((double) (timeInMillis / 86400000));
            if (ceil3 == 1) {
                return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_day_one);
            }
            return IMContextInfoHelper.getContext().getString(R.string.im_feed_time_diff_day, new Object[]{String.valueOf(ceil3)});
        }
    }

    public static boolean isCurrentAfterDay(long j) {
        Calendar instance = Calendar.getInstance();
        instance.setTimeInMillis(j);
        instance.set(10, 23);
        instance.set(12, 59);
        instance.set(13, 59);
        return instance.getTimeInMillis() < System.currentTimeMillis();
    }
}

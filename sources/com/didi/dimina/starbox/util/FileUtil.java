package com.didi.dimina.starbox.util;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import androidx.core.content.FileProvider;
import com.didi.dimina.container.Dimina;
import com.didi.dynamic.manager.DownloadManager;
import com.didichuxing.mas.sdk.quality.report.utils.Constants;
import java.io.File;
import java.util.Locale;
import kotlin.text.Typography;
import org.apache.commons.lang3.CharUtils;
import org.osgi.framework.VersionRange;

public class FileUtil {
    public static final String JPG = "jpg";
    public static final String TXT = "txt";

    /* renamed from: a */
    private static final String f18154a = "*/*";

    /* renamed from: b */
    private static final String f18155b = "application/vnd.android.package-archive";

    /* renamed from: c */
    private static final String f18156c = "video/*";

    /* renamed from: d */
    private static final String f18157d = "audio/*";

    /* renamed from: e */
    private static final String f18158e = "text/html";

    /* renamed from: f */
    private static final String f18159f = "image/*";

    /* renamed from: g */
    private static final String f18160g = "application/vnd.ms-powerpoint";

    /* renamed from: h */
    private static final String f18161h = "application/vnd.ms-excel";

    /* renamed from: i */
    private static final String f18162i = "application/msword";

    /* renamed from: j */
    private static final String f18163j = "application/x-chm";

    /* renamed from: k */
    private static final String f18164k = "text/plain";

    /* renamed from: l */
    private static final String f18165l = "application/pdf";

    /* renamed from: m */
    private static final String f18166m = "application/rtf";

    private FileUtil() {
    }

    public static String getSuffix(File file) {
        return (file == null || !file.exists()) ? "" : file.getName().substring(file.getName().lastIndexOf(".") + 1).toLowerCase(Locale.getDefault());
    }

    public static void systemShare(Context context, File file) {
        if (file != null && file.exists()) {
            String suffix = getSuffix(file);
            char c = 65535;
            switch (suffix.hashCode()) {
                case 1827:
                    if (suffix.equals("7z")) {
                        c = '$';
                        break;
                    }
                    break;
                case 3401:
                    if (suffix.equals("js")) {
                        c = 28;
                        break;
                    }
                    break;
                case 3669:
                    if (suffix.equals("sh")) {
                        c = 24;
                        break;
                    }
                    break;
                case 52316:
                    if (suffix.equals("3gp")) {
                        c = 10;
                        break;
                    }
                    break;
                case 96796:
                    if (suffix.equals("apk")) {
                        c = VersionRange.LEFT_OPEN;
                        break;
                    }
                    break;
                case 97669:
                    if (suffix.equals("bmp")) {
                        c = 22;
                        break;
                    }
                    break;
                case 98472:
                    if (suffix.equals("chm")) {
                        c = 29;
                        break;
                    }
                    break;
                case 98819:
                    if (suffix.equals(Constants.JSON_KEY_CUR_CPU_STAT)) {
                        c = '#';
                        break;
                    }
                    break;
                case 98822:
                    if (suffix.equals("csv")) {
                        c = '\'';
                        break;
                    }
                    break;
                case 99640:
                    if (suffix.equals("doc")) {
                        c = 0;
                        break;
                    }
                    break;
                case 102340:
                    if (suffix.equals("gif")) {
                        c = 18;
                        break;
                    }
                    break;
                case 104987:
                    if (suffix.equals("jar")) {
                        c = ' ';
                        break;
                    }
                    break;
                case 105441:
                    if (suffix.equals(JPG)) {
                        c = 19;
                        break;
                    }
                    break;
                case 106458:
                    if (suffix.equals("m4a")) {
                        c = 12;
                        break;
                    }
                    break;
                case 108104:
                    if (suffix.equals("mid")) {
                        c = 14;
                        break;
                    }
                    break;
                case 108272:
                    if (suffix.equals("mp3")) {
                        c = CharUtils.f5620CR;
                        break;
                    }
                    break;
                case 108273:
                    if (suffix.equals("mp4")) {
                        c = 11;
                        break;
                    }
                    break;
                case 108324:
                    if (suffix.equals("mpg")) {
                        c = 8;
                        break;
                    }
                    break;
                case 109967:
                    if (suffix.equals("ogg")) {
                        c = 16;
                        break;
                    }
                    break;
                case 110834:
                    if (suffix.equals("pdf")) {
                        c = 2;
                        break;
                    }
                    break;
                case 111145:
                    if (suffix.equals("png")) {
                        c = 21;
                        break;
                    }
                    break;
                case 111220:
                    if (suffix.equals("ppt")) {
                        c = 3;
                        break;
                    }
                    break;
                case 113234:
                    if (suffix.equals("rss")) {
                        c = 27;
                        break;
                    }
                    break;
                case 113252:
                    if (suffix.equals("rtf")) {
                        c = 7;
                        break;
                    }
                    break;
                case 114306:
                    if (suffix.equals("swf")) {
                        c = '%';
                        break;
                    }
                    break;
                case 114597:
                    if (suffix.equals("tar")) {
                        c = Typography.quote;
                        break;
                    }
                    break;
                case 115312:
                    if (suffix.equals("txt")) {
                        c = 23;
                        break;
                    }
                    break;
                case 117484:
                    if (suffix.equals("wav")) {
                        c = 17;
                        break;
                    }
                    break;
                case 118783:
                    if (suffix.equals("xls")) {
                        c = 5;
                        break;
                    }
                    break;
                case 118801:
                    if (suffix.equals("xmf")) {
                        c = 15;
                        break;
                    }
                    break;
                case 118807:
                    if (suffix.equals("xml")) {
                        c = 26;
                        break;
                    }
                    break;
                case 120609:
                    if (suffix.equals(DownloadManager.MODULE_DIR_ZIP)) {
                        c = Typography.amp;
                        break;
                    }
                    break;
                case 3088960:
                    if (suffix.equals("docx")) {
                        c = 1;
                        break;
                    }
                    break;
                case 3183070:
                    if (suffix.equals("gtar")) {
                        c = '!';
                        break;
                    }
                    break;
                case 3213227:
                    if (suffix.equals("html")) {
                        c = 25;
                        break;
                    }
                    break;
                case 3268712:
                    if (suffix.equals("jpeg")) {
                        c = 20;
                        break;
                    }
                    break;
                case 3271912:
                    if (suffix.equals("json")) {
                        c = 30;
                        break;
                    }
                    break;
                case 3358085:
                    if (suffix.equals("mpeg")) {
                        c = 9;
                        break;
                    }
                    break;
                case 3447940:
                    if (suffix.equals("pptx")) {
                        c = 4;
                        break;
                    }
                    break;
                case 3682393:
                    if (suffix.equals("xlsx")) {
                        c = 6;
                        break;
                    }
                    break;
                case 94742904:
                    if (suffix.equals("class")) {
                        c = 31;
                        break;
                    }
                    break;
            }
            String str = "application/x-7z-compressed";
            switch (c) {
                case 0:
                case 1:
                    str = f18162i;
                    break;
                case 2:
                    str = f18165l;
                    break;
                case 3:
                case 4:
                    str = f18160g;
                    break;
                case 5:
                case 6:
                    str = f18161h;
                    break;
                case 7:
                    str = f18166m;
                    break;
                case 8:
                case 9:
                case 10:
                case 11:
                    str = f18156c;
                    break;
                case 12:
                case 13:
                case 14:
                case 15:
                case 16:
                case 17:
                    str = f18157d;
                    break;
                case 18:
                case 19:
                case 20:
                case 21:
                case 22:
                    str = "image/*";
                    break;
                case 23:
                case 24:
                    str = "text/plain";
                    break;
                case 25:
                    str = f18158e;
                    break;
                case 26:
                case 27:
                    str = "application/rss+xml";
                    break;
                case 28:
                    str = "application/javascript";
                    break;
                case 29:
                    str = f18163j;
                    break;
                case 30:
                    str = "application/json";
                    break;
                case 31:
                    str = "application/java-vm";
                    break;
                case ' ':
                    str = "application/java-archive";
                    break;
                case '!':
                    str = "application/x-gtar";
                    break;
                case '\"':
                    str = "application/x-tar";
                    break;
                case '#':
                    str = "text/css";
                    break;
                case '$':
                case '%':
                    break;
                case '&':
                    str = "application/zip";
                    break;
                case '\'':
                    str = "text/csv";
                    break;
                case '(':
                    str = f18155b;
                    break;
                default:
                    str = "*/*";
                    break;
            }
            Intent intent = new Intent("android.intent.action.VIEW");
            Uri uriForFile = FileProvider.getUriForFile(context, Dimina.getConfig().getAdapterConfig().getWsgService().getPackageName(context) + ".debugfileprovider", file);
            intent.addFlags(1);
            intent.setDataAndType(uriForFile, str);
            if (intent.resolveActivity(context.getPackageManager()) == null) {
                intent.setDataAndType(uriForFile, "*/*");
            }
            context.startActivity(intent);
        }
    }

    public static boolean isImage(File file) {
        if (file == null) {
            return false;
        }
        String suffix = getSuffix(file);
        if (JPG.equals(suffix) || "jpeg".equals(suffix) || "png".equals(suffix) || "bmp".equals(suffix)) {
            return true;
        }
        return false;
    }
}

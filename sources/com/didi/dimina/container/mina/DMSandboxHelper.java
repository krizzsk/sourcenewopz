package com.didi.dimina.container.mina;

import android.text.TextUtils;
import com.didi.dimina.container.DMConfig;
import com.didi.dimina.container.Dimina;
import com.didi.dimina.container.util.FileUtil;
import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;

public class DMSandboxHelper {
    public static final String DIMINA = "dimina";
    public static final String DIMINA_FONT = "file:///dimina/font";
    public static final String SANDBOX = "sandbox";
    public static final String VIRTUAL_DOMAIN_URL = "difile://";

    /* renamed from: a */
    private final String f16936a;

    /* renamed from: b */
    private final String f16937b;

    /* renamed from: c */
    private final String f16938c = (this.f16936a + "/tmp");

    public DMSandboxHelper(DMConfig dMConfig) {
        this.f16936a = (Dimina.getConfig().getApp().getFilesDir().getAbsolutePath() + File.separator + DIMINA + File.separator + SANDBOX) + File.separator + dMConfig.getLaunchConfig().getAppId();
        String str = this.f16936a + "/store";
        this.f16937b = str;
        FileUtil.mkdirs(this.f16936a, this.f16938c, str);
    }

    public String filepath2url(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f16936a) && str.startsWith(this.f16936a)) {
            String substring = str.substring(this.f16936a.length());
            if (!TextUtils.isEmpty(substring) && substring.startsWith("/") && substring.length() > 1) {
                return VIRTUAL_DOMAIN_URL + substring;
            }
        }
        return "";
    }

    public String url2filepath(String str) {
        if (!TextUtils.isEmpty(str) && !TextUtils.isEmpty(this.f16936a) && str.startsWith(VIRTUAL_DOMAIN_URL)) {
            String substring = str.substring(9);
            if (!TextUtils.isEmpty(substring) && substring.startsWith("/") && substring.length() > 1) {
                return this.f16936a + substring;
            }
        }
        return "";
    }

    public String url2filepathWithoutDifile(String str) {
        String str2;
        try {
            str2 = new URI(str).getPath();
        } catch (URISyntaxException e) {
            e.printStackTrace();
            str2 = "";
        }
        if (TextUtils.isEmpty(str2) || !str2.startsWith("/") || str2.length() <= 1 || TextUtils.isEmpty(this.f16936a)) {
            return "";
        }
        return this.f16936a + str2;
    }

    public String getSandboxTmpDir() {
        return this.f16938c;
    }

    public String getSandboxStoreDir() {
        return this.f16937b;
    }

    public String extractFilename(String str) {
        if (TextUtils.isEmpty(str)) {
            return "";
        }
        String[] split = str.split("/");
        return split[split.length - 1];
    }

    public void clearTmpFile() {
        try {
            FileUtil.delete(this.f16938c);
        } catch (Exception unused) {
        }
    }

    public long getFileSize(String str) {
        return FileUtil.getFileSize(str);
    }
}

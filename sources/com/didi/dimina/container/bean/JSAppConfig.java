package com.didi.dimina.container.bean;

import android.graphics.Color;
import android.text.TextUtils;
import com.didi.dimina.container.DMMina;
import com.didi.dimina.container.bean.Constant;
import com.didi.dimina.container.bundle.BundleManager;
import com.didi.dimina.container.util.ColorUtil;
import com.didi.dimina.container.util.HttpUtil;
import com.google.gson.annotations.SerializedName;
import java.io.File;
import java.io.Serializable;
import java.util.List;
import java.util.Map;

public class JSAppConfig implements Serializable {
    @SerializedName("app")
    public String app;
    @SerializedName("didiPageFrame")
    public List<DidiPageFrameItem> didiPageFrame;
    @SerializedName("entryPagePath")
    public String entryPagePath;
    @SerializedName("global")
    public GlobalConfig globalConfig;
    @SerializedName("page")
    public Map<String, PageConfig> pageConfigs;
    @SerializedName("pages")
    public List<String> pages;
    @SerializedName("snapshotAllow")
    public boolean snapshotAllow;
    @SerializedName("subPackages")
    public List<SubPackage> subPackages;
    @SerializedName("subpackagesDir")
    public Map<String, String> subpackagesDir;
    @SerializedName("tabBar")
    public TabBar tabBar;

    public static class SubPackage {
        @SerializedName("pages")
        public List<String> pages;
        @SerializedName("root")
        public String root;
    }

    public static class WindowConfig {
        @SerializedName("backgroundColor")
        public String backgroundColor;
        @SerializedName("backgroundTextStyle")
        public String backgroundTextStyle;
        @SerializedName("enablePullDownRefresh")
        public String enablePullDownRefresh;
        @SerializedName("navigationBarBackgroundColor")
        public String navigationBarBackgroundColor;
        @SerializedName("navigationBarTextStyle")
        public String navigationBarTextStyle;
        @SerializedName("navigationBarTitleText")
        public String navigationBarTitleText;
    }

    public boolean containPath(String str) {
        String splitPath = HttpUtil.splitPath(str);
        if (!TextUtils.isEmpty(splitPath) && splitPath.startsWith("/")) {
            splitPath = splitPath.substring(1);
        }
        return this.pages.contains(splitPath);
    }

    public PageConfig getPageConfig(String str) {
        String splitPath = HttpUtil.splitPath(str);
        if (!TextUtils.isEmpty(splitPath) && splitPath.startsWith("/")) {
            splitPath = splitPath.substring(1);
        }
        return this.pageConfigs.get(splitPath);
    }

    public static class TabBar implements Serializable {
        @SerializedName("backgroundColor")
        public String backgroundColor;
        @SerializedName("borderStyle")
        public String borderStyle;
        @SerializedName("color")
        public String color;
        @SerializedName("custom")
        public boolean custom;
        @SerializedName("list")
        public List<Item> list;
        @SerializedName("selectedColor")
        public String selectedColor;

        public static class Item {
            @SerializedName("iconPath")
            public String iconPath;
            @SerializedName("pagePath")
            public String pagePath;
            @SerializedName("selectedIconPath")
            public String selectedIconPath;
            @SerializedName("text")
            public String text;
        }

        public TabBar parseTabItemIconPath(DMMina dMMina) {
            List<Item> list2 = this.list;
            if (!(list2 == null || list2.size() == 0 || dMMina == null)) {
                for (Item next : this.list) {
                    if (next.iconPath != null && !next.iconPath.startsWith("http") && !new File(next.iconPath).exists()) {
                        next.iconPath = BundleManager.getInstance().transformUrl(dMMina, "app", next.iconPath);
                        next.iconPath = next.iconPath.replace("file://", "");
                        next.selectedIconPath = BundleManager.getInstance().transformUrl(dMMina, "app", next.selectedIconPath);
                        next.selectedIconPath = next.selectedIconPath.replace("file://", "");
                    }
                }
            }
            return this;
        }

        public int getNormalColor() {
            try {
                return Color.parseColor(ColorUtil.convert3To6(this.color));
            } catch (Exception unused) {
                return Color.parseColor("#3C4248");
            }
        }

        public int getSelectedColor() {
            try {
                return Color.parseColor(ColorUtil.convert3To6(this.selectedColor));
            } catch (Exception unused) {
                return Color.parseColor("#FA5E2B");
            }
        }

        public int getBackgroundColor() {
            try {
                return Color.parseColor(ColorUtil.convert3To6(this.backgroundColor));
            } catch (Exception unused) {
                return Color.parseColor("#ffffff");
            }
        }

        public int getBorderColor() {
            if (TextUtils.equals(this.borderStyle, "black")) {
                return Color.parseColor("#33000000");
            }
            return -1;
        }
    }

    public static class GlobalConfig {
        @SerializedName("window")
        public WindowConfig window;

        public boolean enablePullDownRefresh() {
            WindowConfig windowConfig = this.window;
            return windowConfig != null && TextUtils.equals(windowConfig.enablePullDownRefresh, "true");
        }
    }

    public static class DidiPageFrameItem {
        @SerializedName("fileName")
        public String fileName;
        @SerializedName("root")
        public String root;
        @SerializedName("url")
        public String url;

        public String getJSName() {
            return File.separator + "page-webview." + this.url.replaceAll("/", "_") + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_JAVASCRIPT_SUFFIX;
        }

        public String getCSSName() {
            return File.separator + "page-webview." + this.url.replaceAll("/", "_") + Constant.LAUNCHER_JS.PAGE_WEB_VIEW_STYLE_SUFFIX;
        }

        public String getModelName() {
            return File.separator + this.fileName + ".html";
        }

        public String getFileName(String str) {
            return File.separator + this.fileName + "_" + str + ".html";
        }

        public boolean isEmpty() {
            return TextUtils.isEmpty(this.root) || TextUtils.isEmpty(this.url) || TextUtils.isEmpty(this.fileName);
        }
    }

    public static class PageConfig {
        public static final String PAGE_TYPE_MAP = "map";
        public static final String PAGE_TYPE_NORMAL = "normal";
        @SerializedName("backgroundColor")
        public String backgroundColor;
        @SerializedName("backgroundTextStyle")
        public String backgroundTextStyle;
        @SerializedName("capsuleButton")
        public String capsuleButton;
        @SerializedName("enablePullDownRefresh")
        public String enablePullDownRefresh;
        @SerializedName("navigationBarBackgroundColor")
        public String navigationBarBackgroundColor;
        @SerializedName("navigationBarTextStyle")
        public String navigationBarTextStyle;
        @SerializedName("navigationBarTitleText")
        public String navigationBarTitleText;
        @SerializedName("navigationStyle")
        public String navigationStyle;
        @SerializedName("type")
        public String type;

        public boolean enablePullDownRefresh() {
            if (TextUtils.equals(this.type, "map")) {
                return false;
            }
            return TextUtils.equals(this.enablePullDownRefresh, "true");
        }
    }
}

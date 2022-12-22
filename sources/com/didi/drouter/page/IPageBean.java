package com.didi.drouter.page;

import android.os.Bundle;

public interface IPageBean {
    Bundle getPageInfo();

    String getPageName();

    String getPageUri();

    public static class DefPageBean implements IPageBean {
        private final Bundle info;
        private final String name;
        private final String uri;

        public DefPageBean(String str) {
            this(str, "");
        }

        public DefPageBean(String str, String str2) {
            this(str, str2, (Bundle) null);
        }

        public DefPageBean(String str, Bundle bundle) {
            this(str, "", bundle);
        }

        public DefPageBean(String str, String str2, Bundle bundle) {
            this.uri = str;
            this.name = str2;
            this.info = bundle;
        }

        public String getPageUri() {
            return this.uri;
        }

        public String getPageName() {
            return this.name;
        }

        public Bundle getPageInfo() {
            return this.info;
        }
    }

    public static class EmptyPageBean extends DefPageBean {
        public EmptyPageBean() {
            super("");
        }
    }
}

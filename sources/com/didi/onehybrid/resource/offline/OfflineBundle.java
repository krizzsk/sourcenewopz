package com.didi.onehybrid.resource.offline;

import android.text.TextUtils;
import com.google.gson.annotations.SerializedName;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class OfflineBundle {
    public static final int INVALID = 0;
    public static final int VALID = 1;
    private int dbOperation;
    private String md5;
    private String name;
    @SerializedName("resource")
    private CopyOnWriteArrayList<ResourceInfo> resource;
    HashMap<String, ResourceInfo> resourceInfoHashMap = new HashMap<>();
    private int state = 1;
    private int type = 1;
    private String url;
    private String version;

    public static class ACTION {
        public static final int ADDORUPDATE = 1;
        public static final int DELETE = 2;
    }

    public static class DBOperation {
        public static final int ADD = 1;
        public static final int DELETE = 3;
        public static final int UPDATE = 2;
    }

    public static class TYPE {
        public static final int ALL = 1;
        public static final int INCREMENT = 2;
    }

    public int getDbOperation() {
        return this.dbOperation;
    }

    public void setDbOperation(int i) {
        this.dbOperation = i;
    }

    public int getType() {
        return this.type;
    }

    public void setType(int i) {
        this.type = i;
    }

    public void setName(String str) {
        this.name = str;
    }

    public void setVersion(String str) {
        this.version = str;
    }

    public void setResource(CopyOnWriteArrayList<ResourceInfo> copyOnWriteArrayList) {
        this.resource = copyOnWriteArrayList;
        if (copyOnWriteArrayList != null) {
            Iterator<ResourceInfo> it = copyOnWriteArrayList.iterator();
            while (it.hasNext()) {
                ResourceInfo next = it.next();
                this.resourceInfoHashMap.put(next.getUrl(), next);
            }
        }
    }

    public void updateInfo(OfflineBundle offlineBundle) {
        this.url = offlineBundle.url;
        this.version = offlineBundle.version;
        this.md5 = offlineBundle.md5;
        this.state = offlineBundle.state;
        if (offlineBundle.getType() == 1) {
            this.resource = offlineBundle.resource;
            return;
        }
        Iterator<ResourceInfo> it = offlineBundle.resource.iterator();
        while (it.hasNext()) {
            ResourceInfo next = it.next();
            if (next.getAction() == 1) {
                HashMap<String, ResourceInfo> hashMap = this.resourceInfoHashMap;
                if (hashMap != null && hashMap.containsKey(next.getUrl())) {
                    this.resource.remove(this.resourceInfoHashMap.get(next.getUrl()));
                }
                this.resource.add(next);
            } else {
                this.resource.remove(next);
            }
        }
    }

    public void setResourceInfoHashMap(HashMap<String, ResourceInfo> hashMap) {
        this.resourceInfoHashMap = hashMap;
    }

    public void setUrl(String str) {
        this.url = str;
    }

    public void setMd5(String str) {
        this.md5 = str;
    }

    public int getState() {
        return this.state;
    }

    public void setState(int i) {
        this.state = i;
    }

    public String getName() {
        return this.name;
    }

    public String getVersion() {
        return this.version;
    }

    public List<ResourceInfo> getResouceInfoList() {
        return this.resource;
    }

    public String getUrl() {
        return this.url;
    }

    public String getMD5() {
        return this.md5;
    }

    public class ResourceInfo {
        private int action;
        private String bundleName;
        private String file;
        private String fileType;
        private String md5;
        private String url;

        public ResourceInfo() {
        }

        public void setUrl(String str) {
            this.url = str;
        }

        public void setFile(String str) {
            this.file = str;
        }

        public String getUrl() {
            return this.url;
        }

        public String getFile() {
            return this.file;
        }

        public int getAction() {
            return this.action;
        }

        public void setAction(int i) {
            this.action = i;
        }

        public String getMd5() {
            return this.md5;
        }

        public void setMd5(String str) {
            this.md5 = str;
        }

        public String getBundleName() {
            return this.bundleName;
        }

        public void setBundleName(String str) {
            this.bundleName = str;
        }

        public String getFileType() {
            if (TextUtils.isEmpty(this.file)) {
                return "";
            }
            String str = this.file;
            return str.substring(str.lastIndexOf("."));
        }
    }
}

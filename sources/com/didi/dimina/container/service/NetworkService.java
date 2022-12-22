package com.didi.dimina.container.service;

import java.util.Map;
import org.json.JSONObject;

public interface NetworkService {

    public static abstract class ITaskCallback {
        public void onComplete() {
        }

        public abstract void onFailure(Exception exc);

        public void onProgressUpdate(long j, float f) {
        }

        public abstract void onSuccess(JSONObject jSONObject);
    }

    public static class NetworkTaskModel {
        public Map<String, String> headers;
        public long timeout;
        public String url;

        public static class Download extends NetworkTaskModel {
            public String filePath;
        }

        public static class Request extends NetworkTaskModel {
            public static final String DATA_TYPE_JSON = "json";
            public static final String DATA_TYPE_TEXT = "text";
            public static final String METHOD_GET = "GET";
            public static final String METHOD_POST = "POST";
            public static final String METHOD_PUT = "PUT";
            public Map<String, Object> data;
            public Object data2;
            public String dataType = "json";
            public String method = "GET";

            public @interface DataType {
            }

            public @interface METHOD {
            }
        }

        public static class Upload extends NetworkTaskModel {
            public String fileName;
            public String filePath;
            public Map<String, Object> formData;
        }
    }

    void createDownloadTask(String str, NetworkTaskModel.Download download, ITaskCallback iTaskCallback);

    void createRequestTask(String str, NetworkTaskModel.Request request, ITaskCallback iTaskCallback);

    void createUploadTask(String str, NetworkTaskModel.Upload upload, ITaskCallback iTaskCallback);

    void downloadFile(NetworkTaskModel.Download download, ITaskCallback iTaskCallback);

    void operateDownloadTask(String str, String str2, JSONObject jSONObject, ITaskCallback iTaskCallback);

    void operateRequestTask(String str, String str2, JSONObject jSONObject, ITaskCallback iTaskCallback);

    void operateUploadTask(String str, String str2, JSONObject jSONObject, ITaskCallback iTaskCallback);

    void request(NetworkTaskModel.Request request, ITaskCallback iTaskCallback);

    void uploadFile(NetworkTaskModel.Upload upload, ITaskCallback iTaskCallback);
}

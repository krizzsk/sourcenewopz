package com.didi.dimina.starbox.module.jsbridge.gift;

import com.didi.dimina.container.secondparty.bundle.util.PmFileUtil;
import com.didi.dimina.starbox.util.DHttpUtil;
import com.didi.dimina.starbox.util.LocalDevUtil;
import java.io.File;
import java.util.HashMap;
import java.util.List;

public class FileDownloadInterceptor extends Interceptor<HashMap, File> {
    /* access modifiers changed from: package-private */
    /* renamed from: a */
    public InterceptorResult<File> onExecute(HashMap hashMap) throws Exception {
        String str = (String) hashMap.get("downUrl");
        String str2 = (String) hashMap.get("dirPath");
        File file = new File((String) hashMap.get("zipFilePath"));
        DHttpUtil.download(str, file);
        if (!file.exists() || !file.isFile()) {
            throw new Exception("ZIP 下载失败：" + str);
        }
        List<File> unzipFile = LocalDevUtil.unzipFile(file, new File(str2));
        if (unzipFile == null || unzipFile.size() <= 0) {
            throw new Exception("ZIP 解压失败：" + str);
        }
        PmFileUtil.deleteFile(file);
        return new InterceptorResult<>(file);
    }
}

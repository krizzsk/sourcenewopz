package com.didichuxing.omega.sdk.corelink.node;

import com.didi.component.framework.pages.invitation.fragment.InvitationTrackFragment;
import com.didichuxing.omega.sdk.analysis.Security;
import com.didichuxing.omega.sdk.analysis.Tracker;
import com.didichuxing.omega.sdk.common.OmegaConfig;
import com.didichuxing.omega.sdk.common.backend.UploadStrategy;
import com.didichuxing.omega.sdk.common.collector.PersistentInfoCollector;
import com.didichuxing.omega.sdk.common.record.Record;
import com.didichuxing.omega.sdk.common.transport.FileTooLargeException;
import com.didichuxing.omega.sdk.common.transport.HttpSender;
import com.didichuxing.omega.sdk.common.utils.ZipUtil;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EventUploadNode {
    public static String sendRecord(Record record, List<Map.Entry<String, byte[]>> list, String str) throws Throwable {
        ByteArrayInputStream byteArrayInputStream;
        String omegaId = PersistentInfoCollector.getOmegaId();
        ByteArrayOutputStream byteArrayOutputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream2 = new ByteArrayOutputStream();
            try {
                ZipUtil.writeZipOutputStream(list, byteArrayOutputStream2);
                byte[] byteArray = byteArrayOutputStream2.toByteArray();
                byteArrayInputStream = new ByteArrayInputStream(byteArray);
                try {
                    HashMap hashMap = new HashMap();
                    hashMap.put("msgid", record.getRecordId());
                    hashMap.put("oid", omegaId);
                    hashMap.put("seq", String.valueOf(record.getSeq()));
                    boolean z = true;
                    hashMap.put("cts", String.format(InvitationTrackFragment.INVITE_DATE, new Object[]{Long.valueOf(System.currentTimeMillis())}));
                    Security.setHeaderCityIdEncrypt(hashMap, omegaId);
                    String uploadEventsUrl = UploadStrategy.getUploadEventsUrl();
                    if (byteArray.length <= 1048576) {
                        z = false;
                    }
                    String post = HttpSender.post(uploadEventsUrl, byteArrayInputStream, hashMap, z, OmegaConfig.HTTP_SENDER_RETRY_TIMES);
                    try {
                        byteArrayOutputStream2.close();
                        byteArrayInputStream.close();
                    } catch (IOException unused) {
                    }
                    return post;
                } catch (FileTooLargeException e) {
                    e = e;
                    ByteArrayOutputStream byteArrayOutputStream3 = byteArrayOutputStream2;
                    Tracker.trackGood("type: e  oid:" + omegaId + ": upload file too large", e);
                    throw e;
                } catch (Throwable th) {
                    th = th;
                    byteArrayOutputStream = byteArrayOutputStream2;
                    throw th;
                }
            } catch (FileTooLargeException e2) {
                e = e2;
                ByteArrayOutputStream byteArrayOutputStream32 = byteArrayOutputStream2;
                Tracker.trackGood("type: e  oid:" + omegaId + ": upload file too large", e);
                throw e;
            } catch (Throwable th2) {
                th = th2;
                byteArrayInputStream = null;
                byteArrayOutputStream = byteArrayOutputStream2;
                throw th;
            }
        } catch (FileTooLargeException e3) {
            e = e3;
            Tracker.trackGood("type: e  oid:" + omegaId + ": upload file too large", e);
            throw e;
        } catch (Throwable th3) {
            if (byteArrayOutputStream != null) {
                try {
                    byteArrayOutputStream.close();
                } catch (IOException unused2) {
                    throw th3;
                }
            }
            if (byteArrayInputStream != null) {
                byteArrayInputStream.close();
            }
            throw th3;
        }
    }
}

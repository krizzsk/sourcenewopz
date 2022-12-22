package com.didi.beatles.p099im.module.entity;

import android.text.TextUtils;
import com.didi.beatles.p099im.IMContextInfoHelper;
import com.didi.beatles.p099im.api.entity.IMSessionClientExtendInfo;
import com.didi.beatles.p099im.api.entity.IMSessionExtendInfo;
import com.didi.beatles.p099im.api.entity.IMSessionRecentMessages;
import com.didi.beatles.p099im.api.entity.IMSessionServiceExtendInfo;
import com.didi.beatles.p099im.api.entity.IMTopOperationBody;
import com.didi.beatles.p099im.omega.IMTraceError;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.p100db.entity.IMSessionDaoEntity;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import com.didi.beatles.p099im.utils.IMLog;
import java.io.Serializable;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

/* renamed from: com.didi.beatles.im.module.entity.IMSession */
public class IMSession implements Serializable, Cloneable, Comparable<IMSession> {
    public static final int DRIVER_CHAT = 16;
    public static final int HELPER_CHAT = 4;
    private static final String LIST_SPLITTER = "_";
    public static final int MULTI_CHAT = 2;
    public static final int SESSION_STATUS_OVER_DUE = 2;
    public static final int SESSION_STATUS_VALID = 1;
    public static final int SINGLE_CHAT = 1;
    private static final String TAG = IMSession.class.getSimpleName();
    private IMSessionDaoEntity entity = new IMSessionDaoEntity();
    public boolean isChecked;
    public boolean isSelect;
    private long lastMessageId;
    private IMSessionClientExtendInfo mClientExtendInfo;
    private IMSessionRecentMessages mRecentMessages;
    private IMSessionServiceExtendInfo mServiceExtendInfo;
    private IMSessionExtendInfo mSessionExtendInfo;
    private List<IMUser> mUserInfos;
    public IMTopOperationBody operationBody;
    public String recommendString;
    public int sessionEnable;
    public boolean supportMsgReadStatus;
    public boolean supportTranslate;
    private String tipFol;
    private String tipText;

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.module.entity.IMSession$IMSessionStatus */
    public @interface IMSessionStatus {
    }

    @Retention(RetentionPolicy.SOURCE)
    /* renamed from: com.didi.beatles.im.module.entity.IMSession$IMSessionType */
    public @interface IMSessionType {
    }

    public String getTipText() {
        return this.tipText;
    }

    public void setTipText(String str) {
        this.tipText = str;
    }

    public String getTipFol() {
        return this.tipFol;
    }

    public void setTipFol(String str) {
        this.tipFol = str;
    }

    public List<IMUser> getUserInfos() {
        return this.mUserInfos;
    }

    public void setUserInfos(List<IMUser> list) {
        this.mUserInfos = list;
    }

    public String getOid() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.orderId;
        }
        return null;
    }

    public void setOid(String str) {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            iMSessionExtendInfo.orderId = str;
        }
    }

    public String getRid() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.routeId;
        }
        return null;
    }

    public void setRid(String str) {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            iMSessionExtendInfo.routeId = str;
        }
    }

    public static IMSession structureSession(IMBusinessParam iMBusinessParam) {
        IMSession iMSession = new IMSession();
        iMSession.setSessionId(iMBusinessParam.getSessionId());
        iMSession.setBusinessId(iMBusinessParam.getProductId());
        long uid = IMContextInfoHelper.getUid();
        long peerUid = iMBusinessParam.getPeerUid();
        iMSession.setUsers(new long[]{uid, peerUid});
        ArrayList arrayList = new ArrayList();
        IMUser iMUser = new IMUser();
        iMUser.setUid(uid);
        iMUser.setNickName(iMBusinessParam.getSelfUserName());
        iMUser.setAvatarUrl(iMBusinessParam.getSelfUserAvatar());
        arrayList.add(iMUser);
        IMUser iMUser2 = new IMUser();
        iMUser2.setUid(peerUid);
        iMUser2.setNickName(iMBusinessParam.getPeerUserName());
        iMUser2.setAvatarUrl(iMBusinessParam.getPeerUserAvatar());
        arrayList.add(iMUser2);
        iMSession.setUserInfos(arrayList);
        if (!TextUtils.isEmpty(iMBusinessParam.getPeerUserName())) {
            OmegaUtil.trackTitleNamePath((String) null, iMSession, 1);
            iMSession.setSessionName(iMBusinessParam.getPeerUserName());
        }
        if (iMBusinessParam.getSessionType() != 0) {
            iMSession.setType(iMBusinessParam.getSessionType());
        }
        return iMSession;
    }

    public void setSessionId(long j) {
        this.entity.setSession_id(j);
    }

    public long getSessionId() {
        return this.entity.getSession_id();
    }

    public IMSessionDaoEntity getDaoEntity() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            this.entity.setReserveStr3(IMJsonUtil.jsonFromObject(iMSessionExtendInfo));
        }
        IMSessionClientExtendInfo iMSessionClientExtendInfo = this.mClientExtendInfo;
        if (iMSessionClientExtendInfo != null) {
            this.entity.setClientExtends(IMJsonUtil.jsonFromObject(iMSessionClientExtendInfo));
        }
        IMSessionServiceExtendInfo iMSessionServiceExtendInfo = this.mServiceExtendInfo;
        if (iMSessionServiceExtendInfo != null) {
            this.entity.setServiceExtends(IMJsonUtil.jsonFromObject(iMSessionServiceExtendInfo));
        }
        return this.entity;
    }

    public void setDaoEntity(IMSessionDaoEntity iMSessionDaoEntity) {
        this.entity = iMSessionDaoEntity;
        resolveExtendInfo();
        resolveRecentMessages();
    }

    public void setSessionName(String str) {
        this.entity.setSession_name(str);
    }

    public String getSessionName() {
        return this.entity.getSession_name();
    }

    public void setSessionImg(String str) {
        this.entity.setSession_img(str);
    }

    public String getSessionImg() {
        return this.entity.getSession_img();
    }

    public void setDraft(String str) {
        this.entity.setDraft(str);
    }

    public String getDraft() {
        return this.entity.getDraft();
    }

    public void setType(int i) {
        this.entity.setType(i);
    }

    public int getType() {
        return this.entity.getType();
    }

    public long getLastModifyTime() {
        return this.entity.getLast_modify_time();
    }

    public void setLastModifyTime(long j) {
        this.entity.setLast_modify_time(j);
    }

    public void setLastMsgStatus(int i) {
        this.entity.setReserveInt1(i);
    }

    public int getLastMsgStatus() {
        return this.entity.getReserveInt1();
    }

    public String getLastMessageId() {
        return this.entity.getLast_modify_id();
    }

    public void setLastMessageId(String str) {
        this.entity.setLast_modify_id(str);
    }

    public void setLastMessage(String str) {
        this.entity.setLast_message(str);
    }

    public String getLastMessage() {
        return this.entity.getLast_message();
    }

    public void setUnreadCount(int i) {
        this.entity.setUnread_count(i);
    }

    public int getUnreadCount() {
        return this.entity.getUnread_count();
    }

    public void setUsers(List<Long> list) {
        if (list == null || list.isEmpty()) {
            this.entity.setUid_list("");
        }
        StringBuilder sb = new StringBuilder();
        int size = list.size();
        for (int i = 0; i < size; i++) {
            sb.append(list.get(i));
            if (i != size - 1) {
                sb.append("_");
            }
        }
        this.entity.setUid_list(sb.toString());
    }

    public static Long getPeerId(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                if (longValue2 != IMContextInfoHelper.getUid()) {
                    return Long.valueOf(longValue2);
                }
            }
        }
        return 0L;
    }

    public long getPeerUid() {
        List<IMUser> list = this.mUserInfos;
        if (list != null && list.size() > 0) {
            for (IMUser next : this.mUserInfos) {
                if (next != null && next.getUid() != IMContextInfoHelper.getUid()) {
                    return next.getUid();
                }
            }
        }
        String uid_list = this.entity.getUid_list();
        if (TextUtils.isEmpty(uid_list)) {
            return 0;
        }
        String[] split = uid_list.split("_");
        for (int i = 0; i < split.length; i++) {
            if (!TextUtils.isEmpty(split[i]) && Long.parseLong(split[i]) != IMContextInfoHelper.getUid()) {
                return Long.parseLong(split[i]);
            }
        }
        return 0;
    }

    public static Long getSelfId(List<Long> list) {
        if (list != null && list.size() > 0) {
            for (Long longValue : list) {
                long longValue2 = longValue.longValue();
                if (longValue2 == IMContextInfoHelper.getUid()) {
                    return Long.valueOf(longValue2);
                }
            }
        }
        return 0L;
    }

    public IMUser getSelfUser() {
        List<IMUser> list = this.mUserInfos;
        if (list != null && list.size() > 0) {
            for (IMUser next : this.mUserInfos) {
                if (next.getUid() == IMContextInfoHelper.getUid()) {
                    return next;
                }
            }
        }
        return new IMUser();
    }

    public IMUser getPeerUser() {
        List<IMUser> list = this.mUserInfos;
        if (list != null && list.size() > 0) {
            for (IMUser next : this.mUserInfos) {
                if (next.getUid() != IMContextInfoHelper.getUid()) {
                    return next;
                }
            }
        }
        return new IMUser();
    }

    public void setUsers(Long... lArr) {
        setUsers((List<Long>) Arrays.asList(lArr));
    }

    public void setUsers(long[] jArr) {
        ArrayList arrayList = new ArrayList(r0);
        for (long valueOf : jArr) {
            arrayList.add(Long.valueOf(valueOf));
        }
        setUsers((List<Long>) arrayList);
    }

    public List<Long> getUserIds() {
        String uid_list = this.entity.getUid_list();
        if (TextUtils.isEmpty(uid_list)) {
            return Collections.EMPTY_LIST;
        }
        String[] split = uid_list.split("_");
        ArrayList arrayList = new ArrayList(split.length);
        for (int i = 0; i < split.length; i++) {
            try {
                arrayList.add(Long.valueOf(Long.parseLong(split[i])));
            } catch (NumberFormatException e) {
                IMTraceError.trackError("IMSession#parseUserIds#", e);
            }
        }
        return arrayList;
    }

    public void setUid_list(String str) {
        this.entity.setUid_list(str);
    }

    public String getUid_list() {
        return this.entity.getUid_list();
    }

    public int compareTo(IMSession iMSession) {
        if (isTop(this) && !isTop(iMSession)) {
            return -1;
        }
        if (isTop(this) || !isTop(iMSession)) {
            return compareLastModifyTime(iMSession);
        }
        return 1;
    }

    private boolean isTop(IMSession iMSession) {
        return (iMSession == null || iMSession.getExtendSessionInfo() == null || iMSession.getExtendSessionInfo().istop != 1) ? false : true;
    }

    public int compareLastModifyTime(IMSession iMSession) {
        if (getLastModifyTime() > iMSession.getLastModifyTime()) {
            return -1;
        }
        return getLastModifyTime() < iMSession.getLastModifyTime() ? 1 : 0;
    }

    public int getRedDotCount() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            return iMSessionDaoEntity.getReserveInt2();
        }
        return 0;
    }

    public void setRedDotCount(int i) {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            iMSessionDaoEntity.setReserveInt2(i);
        }
    }

    public int getBusinessId() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            return iMSessionDaoEntity.getBusiness_id();
        }
        return 0;
    }

    public void setBusinessId(int i) {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null && i != 0) {
            iMSessionDaoEntity.setBusiness_id(i);
        }
    }

    public boolean getSessionEnable() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            return iMSessionDaoEntity.getIs_info_loaded().booleanValue();
        }
        return false;
    }

    public void setSessionEnable(boolean z) {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            iMSessionDaoEntity.setIs_info_loaded(Boolean.valueOf(z));
        }
    }

    public IMSessionClientExtendInfo getClientExtendSessionInfo() {
        resolveClientExtendInfo();
        return this.mClientExtendInfo;
    }

    public IMSessionServiceExtendInfo getServiceExtendSessionInfo() {
        resolveServiceExtendInfo();
        return this.mServiceExtendInfo;
    }

    public IMSessionExtendInfo getExtendSessionInfo() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo;
        }
        resolveExtendInfo();
        return this.mSessionExtendInfo;
    }

    public void setExtendSessionInfo(IMSessionExtendInfo iMSessionExtendInfo) {
        if (iMSessionExtendInfo != null) {
            this.mSessionExtendInfo = iMSessionExtendInfo;
        }
    }

    public void setClientExtendInfo(IMSessionClientExtendInfo iMSessionClientExtendInfo) {
        if (iMSessionClientExtendInfo != null) {
            this.mClientExtendInfo = iMSessionClientExtendInfo;
        }
    }

    public void setServiceExtendInfo(IMSessionServiceExtendInfo iMSessionServiceExtendInfo) {
        if (iMSessionServiceExtendInfo != null) {
            this.mServiceExtendInfo = iMSessionServiceExtendInfo;
        }
    }

    public IMSessionRecentMessages getRecentMessages() {
        resolveRecentMessages();
        return this.mRecentMessages;
    }

    public List<IMFeedMessage> getRecentMessageList() {
        IMSessionRecentMessages iMSessionRecentMessages = this.mRecentMessages;
        if (iMSessionRecentMessages != null) {
            return iMSessionRecentMessages.getMessages();
        }
        return null;
    }

    public <T extends List<IMMessage>> void setRecentMessages(T t) {
        if (getType() == 4) {
            this.mRecentMessages = null;
            IMSessionRecentMessages iMSessionRecentMessages = new IMSessionRecentMessages();
            this.mRecentMessages = iMSessionRecentMessages;
            iMSessionRecentMessages.initRecentMessages(getSessionId());
            ArrayList arrayList = new ArrayList();
            Iterator it = t.iterator();
            while (it.hasNext()) {
                arrayList.add(new IMFeedMessage((IMMessage) it.next()));
            }
            this.mRecentMessages.appendMessages(arrayList);
            try {
                if (this.entity != null) {
                    this.entity.setRecentMessages(IMJsonUtil.jsonFromObject(this.mRecentMessages));
                }
            } catch (Exception e) {
                IMLog.m6633e(e);
            }
        }
    }

    public <T extends List<IMMessage>> void addRecentMessages(T t) {
        if (getType() == 4) {
            resolveRecentMessages();
            if (this.mRecentMessages == null) {
                IMSessionRecentMessages iMSessionRecentMessages = new IMSessionRecentMessages();
                this.mRecentMessages = iMSessionRecentMessages;
                iMSessionRecentMessages.initRecentMessages(getSessionId());
            }
            ArrayList arrayList = new ArrayList();
            Iterator it = t.iterator();
            while (it.hasNext()) {
                arrayList.add(new IMFeedMessage((IMMessage) it.next()));
            }
            this.mRecentMessages.appendMessages(arrayList);
            IMSessionDaoEntity iMSessionDaoEntity = this.entity;
            if (iMSessionDaoEntity != null) {
                try {
                    iMSessionDaoEntity.setRecentMessages(IMJsonUtil.jsonFromObject(this.mRecentMessages));
                } catch (Exception e) {
                    IMLog.m6633e(e);
                }
            }
        }
    }

    public void addRecentMessage(IMMessage iMMessage) {
        if (getType() == 4) {
            resolveRecentMessages();
            if (this.mRecentMessages == null) {
                IMSessionRecentMessages iMSessionRecentMessages = new IMSessionRecentMessages();
                this.mRecentMessages = iMSessionRecentMessages;
                iMSessionRecentMessages.initRecentMessages(getSessionId());
            }
            this.mRecentMessages.appendMessage(new IMFeedMessage(iMMessage));
            IMSessionDaoEntity iMSessionDaoEntity = this.entity;
            if (iMSessionDaoEntity != null) {
                try {
                    iMSessionDaoEntity.setRecentMessages(IMJsonUtil.jsonFromObject(this.mRecentMessages));
                } catch (Exception e) {
                    IMLog.m6633e(e);
                }
            }
        }
    }

    public void setRecentMessages(IMSessionRecentMessages iMSessionRecentMessages) {
        if (iMSessionRecentMessages != null) {
            this.mRecentMessages = iMSessionRecentMessages;
        }
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            try {
                iMSessionDaoEntity.setRecentMessages(IMJsonUtil.jsonFromObject(iMSessionRecentMessages));
            } catch (Exception e) {
                IMLog.m6633e(e);
            }
        }
    }

    public long getLastFlushTime() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.flush_time;
        }
        return 0;
    }

    public boolean getIsForbid() {
        if (this.mSessionExtendInfo != null && getType() == 2 && this.mSessionExtendInfo.forbid == 1) {
            return true;
        }
        return false;
    }

    public void setIsfForbid(boolean z) {
        if (this.mSessionExtendInfo != null && getType() == 2) {
            this.mSessionExtendInfo.forbid = z ? 1 : 0;
            setExtendSessionInfo(this.mSessionExtendInfo);
        }
    }

    public boolean getIsHelperForbid() {
        if (this.mSessionExtendInfo != null && getType() == 4 && this.mSessionExtendInfo.forbid == 1) {
            return true;
        }
        return false;
    }

    public void setHelperForbid(boolean z) {
        if (this.mSessionExtendInfo != null && getType() == 4) {
            this.mSessionExtendInfo.forbid = z ? 1 : 0;
            setExtendSessionInfo(this.mSessionExtendInfo);
        }
    }

    public boolean getIsHelperCanForbid() {
        if (this.mSessionExtendInfo != null && getType() == 4 && this.mSessionExtendInfo.can_forbid == 2) {
            return false;
        }
        return true;
    }

    public void setGroupNum(int i) {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            iMSessionExtendInfo.groupNum = i;
        }
    }

    public List<Integer> getActionIds() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.actionIds;
        }
        return null;
    }

    public int getGroupNum() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.groupNum;
        }
        return 0;
    }

    public String getTag() {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            return iMSessionExtendInfo.stag;
        }
        return null;
    }

    public void setTag(String str) {
        IMSessionExtendInfo iMSessionExtendInfo = this.mSessionExtendInfo;
        if (iMSessionExtendInfo != null) {
            iMSessionExtendInfo.stag = str;
        }
    }

    private void resolveExtendInfo() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            this.mSessionExtendInfo = (IMSessionExtendInfo) IMJsonUtil.objectFromJson(iMSessionDaoEntity.getReserveStr3(), IMSessionExtendInfo.class);
        }
        resolveClientExtendInfo();
        resolveServiceExtendInfo();
    }

    private void resolveClientExtendInfo() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            this.mClientExtendInfo = (IMSessionClientExtendInfo) IMJsonUtil.objectFromJson(iMSessionDaoEntity.getClientExtends(), IMSessionClientExtendInfo.class);
        }
        if (this.mClientExtendInfo == null) {
            IMLog.m6631d(TAG, "resolveClientExtendInfo()->mClientExtendInfo==null");
            this.mClientExtendInfo = new IMSessionClientExtendInfo();
        }
    }

    private void resolveServiceExtendInfo() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null) {
            this.mServiceExtendInfo = (IMSessionServiceExtendInfo) IMJsonUtil.objectFromJson(iMSessionDaoEntity.getServiceExtends(), IMSessionServiceExtendInfo.class);
        }
        if (this.mServiceExtendInfo == null) {
            IMLog.m6631d(TAG, "resolveServiceExtendInfo()->mServiceExtendInfo==null");
            this.mServiceExtendInfo = new IMSessionServiceExtendInfo();
        }
    }

    private void resolveRecentMessages() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null && this.mRecentMessages == null) {
            IMSessionRecentMessages iMSessionRecentMessages = (IMSessionRecentMessages) IMJsonUtil.objectFromJson(iMSessionDaoEntity.getRecentMessages(), IMSessionRecentMessages.class);
            this.mRecentMessages = iMSessionRecentMessages;
            if (iMSessionRecentMessages != null) {
                iMSessionRecentMessages.initRecentMessages(getSessionId());
            }
        }
    }

    private void resolveClientServiceExtendMessages() {
        IMSessionDaoEntity iMSessionDaoEntity = this.entity;
        if (iMSessionDaoEntity != null && this.mRecentMessages == null) {
            IMSessionRecentMessages iMSessionRecentMessages = (IMSessionRecentMessages) IMJsonUtil.objectFromJson(iMSessionDaoEntity.getRecentMessages(), IMSessionRecentMessages.class);
            this.mRecentMessages = iMSessionRecentMessages;
            if (iMSessionRecentMessages != null) {
                iMSessionRecentMessages.initRecentMessages(getSessionId());
            }
        }
    }

    public Object clone() throws CloneNotSupportedException {
        IMSession iMSession = (IMSession) super.clone();
        if (this.mRecentMessages != null) {
            IMSessionRecentMessages iMSessionRecentMessages = new IMSessionRecentMessages();
            iMSession.mRecentMessages = iMSessionRecentMessages;
            iMSessionRecentMessages.initRecentMessages(iMSession.getSessionId());
            iMSession.mRecentMessages.appendReverseMessages(this.mRecentMessages.getMessages());
        }
        return iMSession;
    }
}

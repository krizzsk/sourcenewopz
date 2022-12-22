package com.didi.beatles.p099im.api;

import com.didi.beatles.p099im.api.entity.IMDetailBody;
import com.didi.beatles.p099im.api.entity.IMGetUserInfoResponse;
import com.didi.beatles.p099im.api.entity.IMMessageDown;
import com.didi.beatles.p099im.api.entity.IMMessageDownExtend;
import com.didi.beatles.p099im.api.entity.IMMessageUp;
import com.didi.beatles.p099im.api.entity.IMSessionInfo;
import com.didi.beatles.p099im.module.entity.IMMessage;
import com.didi.beatles.p099im.module.entity.IMSession;
import com.didi.beatles.p099im.module.entity.IMUser;
import com.didi.beatles.p099im.omega.OmegaUtil;
import com.didi.beatles.p099im.utils.IMJsonUtil;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* renamed from: com.didi.beatles.im.api.IMApiParser */
public class IMApiParser {
    public static IMMessage parseDownMessage(IMMessageDown iMMessageDown, int i) {
        IMMessage iMMessage = new IMMessage(iMMessageDown.msg_type);
        if (iMMessageDown.msg_type == 524289) {
            iMMessage.setActionId(iMMessageDown.body.event_id);
        } else {
            iMMessage.setActionId("");
        }
        iMMessage.setBusinessId(iMMessageDown.product);
        iMMessage.setCategory(i);
        iMMessage.setSenderUid(iMMessageDown.uid);
        iMMessage.setFakeUid(iMMessageDown.peer_uid);
        iMMessage.setUniqueId(iMMessageDown.uid, (long) iMMessageDown.mid);
        iMMessage.setCloudUniqueMsgId(iMMessageDown.uniq_msg_id);
        iMMessage.setSid(iMMessageDown.sid);
        iMMessage.setCreateTime(iMMessageDown.time);
        iMMessage.setSidType(iMMessageDown.session_type);
        iMMessage.setNickName(iMMessageDown.nick);
        iMMessage.setHeadUrl(iMMessageDown.head_url);
        iMMessage.setMattr(iMMessageDown.mattr);
        iMMessage.setContent(iMMessageDown.body.cont);
        iMMessage.setSize(iMMessageDown.body.size);
        iMMessage.setNs(iMMessageDown.body.f9126ns);
        iMMessage.setFtoken(iMMessageDown.body.ftoken);
        iMMessage.setFid(iMMessageDown.body.fid);
        iMMessage.setFile_name(iMMessageDown.body.voice);
        iMMessage.setWidth(iMMessageDown.body.width);
        iMMessage.setHeight(iMMessageDown.body.height);
        iMMessage.setSec(iMMessageDown.body.sec);
        iMMessage.btns = iMMessageDown.body.btns;
        iMMessage.batcheid = iMMessageDown.body.batcheid;
        IMMessageDownExtend iMMessageDownExtend = new IMMessageDownExtend(iMMessageDown.body.activity_id, iMMessageDown.body.list_text);
        iMMessageDownExtend.setMsgUniqueId(iMMessageDown.body.msg_unique_id);
        iMMessageDownExtend.setEid(iMMessageDown.body.eid);
        iMMessageDownExtend.setPluginId(iMMessageDown.body.pluginId);
        if (iMMessageDown.msg_type == 393217) {
            iMMessageDownExtend.setSystemHiglitTetx(iMMessageDown.body.light_str, iMMessageDown.body.light_link);
        }
        iMMessageDownExtend.setTrans(iMMessageDown.body.trans);
        iMMessageDownExtend.downExt = iMMessageDown.body.ext != null ? String.valueOf(iMMessageDown.body.ext) : null;
        iMMessage.setMessageExtendInfo(iMMessageDownExtend);
        iMMessage.setTopText(iMMessageDown.body.top_text);
        iMMessage.setTopContent(iMMessageDown.body.top_content);
        iMMessage.mact = iMMessageDown.mact;
        iMMessage.dmcCardInfo = iMMessageDown.dmcCardInfo;
        iMMessage.isSend = false;
        iMMessage.setIsRead(false);
        return iMMessage;
    }

    public static List<IMMessage> parseDownMessage(List<IMMessageDown> list, int i) {
        if (list == null || list.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(parseDownMessage(list.get(i2), i));
        }
        return arrayList;
    }

    public static IMMessageUp parseUpMessage(IMMessage iMMessage, long j) {
        IMMessageUp iMMessageUp = new IMMessageUp();
        iMMessageUp.local_id = j;
        iMMessageUp.sid = iMMessage.getSid();
        iMMessageUp.order_id = iMMessage.getoId();
        iMMessageUp.route_id = iMMessage.getRouteId();
        iMMessageUp.msg_type = iMMessage.getType();
        iMMessageUp.body.cont = iMMessage.getContent();
        iMMessageUp.body.size = iMMessage.getSize();
        iMMessageUp.body.width = iMMessage.getWidth();
        iMMessageUp.body.height = iMMessage.getHeight();
        iMMessageUp.body.sec = iMMessage.getSec();
        iMMessageUp.body.fid = iMMessage.getFid();
        iMMessageUp.body.ftoken = iMMessage.getFtoken();
        iMMessageUp.body.f9126ns = iMMessage.getNs();
        IMMessageDownExtend messageExtendInfo = iMMessage.getMessageExtendInfo();
        if (messageExtendInfo != null) {
            iMMessageUp.body.desc = messageExtendInfo.getEmoji_desc();
            iMMessageUp.body.emojiId = messageExtendInfo.getEmoji_id();
            iMMessageUp.is_qk = messageExtendInfo.is_qk;
            iMMessageUp.msg_source = messageExtendInfo.getMsgSource();
            iMMessageUp.body.ext = messageExtendInfo.getExt();
            iMMessageUp.body.eid = messageExtendInfo.getEid();
            iMMessageUp.body.pluginId = messageExtendInfo.getPluginId();
        }
        return iMMessageUp;
    }

    public static IMMessageUp parseUpMessage(IMMessage iMMessage, IMDetailBody iMDetailBody, long j) {
        IMMessageUp iMMessageUp = new IMMessageUp();
        iMMessageUp.local_id = j;
        iMMessageUp.sid = iMMessage.getSid();
        iMMessageUp.order_id = iMMessage.getoId();
        iMMessageUp.route_id = iMMessage.getRouteId();
        iMMessageUp.msg_type = iMMessage.getType();
        iMMessageUp.is_qk = iMMessage.getMessageExtendInfo().is_qk;
        iMMessageUp.body = iMDetailBody;
        return iMMessageUp;
    }

    public static List<IMMessageUp> parseUpMessage(List<IMMessage> list, int i) {
        if (list == null || list.size() == 0) {
            return Collections.EMPTY_LIST;
        }
        ArrayList arrayList = new ArrayList(list.size());
        for (int i2 = 0; i2 < list.size(); i2++) {
            arrayList.add(parseUpMessage(list.get(i2), (long) i));
        }
        return arrayList;
    }

    public static IMUser parseIMUser(IMGetUserInfoResponse.UserInfo userInfo) {
        if (userInfo == null) {
            return null;
        }
        IMUser iMUser = new IMUser();
        iMUser.setAvatarUrl(userInfo.pic);
        iMUser.setNickName(userInfo.name);
        iMUser.setUid(userInfo.uid);
        iMUser.setMIcon(userInfo.m_icon);
        iMUser.setExtendInfo(IMJsonUtil.jsonFromObject(userInfo.extend));
        return iMUser;
    }

    public static List<IMUser> parseIMUser(List<IMGetUserInfoResponse.UserInfo> list) {
        if (list == null) {
            return Collections.emptyList();
        }
        int size = list.size();
        ArrayList arrayList = new ArrayList(list.size());
        for (int i = 0; i < size; i++) {
            arrayList.add(parseIMUser(list.get(i)));
        }
        return arrayList;
    }

    public static IMSession parseIMSession(IMSessionInfo iMSessionInfo) {
        IMSession iMSession = new IMSession();
        iMSession.setSessionId(iMSessionInfo.sid);
        iMSession.setType(iMSessionInfo.sty);
        OmegaUtil.trackTitleNamePath((String) null, iMSession, 2);
        iMSession.setSessionName(iMSessionInfo.name);
        iMSession.setSessionImg(iMSessionInfo.img);
        boolean z = false;
        iMSession.supportMsgReadStatus = iMSessionInfo.extend != null && iMSessionInfo.extend.ack == 1;
        iMSession.supportTranslate = (iMSessionInfo.extend == null || iMSessionInfo.extend.lag_ty == null) ? false : true;
        if (iMSessionInfo.enable != 0) {
            z = true;
        }
        iMSession.setSessionEnable(z);
        iMSession.setBusinessId(iMSessionInfo.product);
        iMSession.setTipText(iMSessionInfo.tip_txt);
        iMSession.setTipFol(iMSessionInfo.tip_fol);
        iMSession.operationBody = iMSessionInfo.tip;
        iMSession.setExtendSessionInfo(iMSessionInfo.extend);
        StringBuffer stringBuffer = new StringBuffer();
        List<IMSessionInfo.UserInfo> list = iMSessionInfo.users;
        ArrayList arrayList = new ArrayList();
        if (iMSession.getType() != 2) {
            for (IMSessionInfo.UserInfo next : list) {
                stringBuffer.append(next.uid + "_");
                arrayList.add(m6193a(next));
            }
            iMSession.setUid_list(stringBuffer.toString());
        } else if (!(list == null || list.size() == 0)) {
            for (IMSessionInfo.UserInfo a : list) {
                arrayList.add(m6193a(a));
            }
        }
        iMSession.setUserInfos(arrayList);
        return iMSession;
    }

    /* renamed from: a */
    private static IMUser m6193a(IMSessionInfo.UserInfo userInfo) {
        IMUser iMUser = new IMUser();
        iMUser.setUid(userInfo.uid);
        iMUser.setAvatarUrl(userInfo.img);
        iMUser.setNickName(userInfo.nick);
        iMUser.setMIcon(userInfo.m_icon);
        iMUser.setExtendInfo(IMJsonUtil.jsonFromObject(userInfo.extend));
        return iMUser;
    }
}

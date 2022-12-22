package com.didi.beatles.p099im.access.msg;

import com.didi.beatles.p099im.module.entity.IMMessage;
import java.io.Serializable;

/* renamed from: com.didi.beatles.im.access.msg.IMMsg */
public class IMMsg implements Serializable {
    public String batcheId;
    public int businessId;
    public long createTime;
    public String fileName;
    public boolean isRead;
    public long messageId;
    public int sec;
    public long sendUid;
    public long sessionId;
    public String textContent;
    public IMMsgType type;

    public IMMsg(IMMessage iMMessage) {
        this.messageId = iMMessage.getMid();
        this.sessionId = iMMessage.getSid();
        this.type = IMMsgType.parseType(iMMessage.getType());
        this.sendUid = iMMessage.getSenderUid();
        this.createTime = iMMessage.getCreateTime();
        this.businessId = iMMessage.getBusinessId();
        this.textContent = iMMessage.getContent();
        this.fileName = iMMessage.getFile_name();
        this.sec = iMMessage.getSec();
        this.isRead = iMMessage.isRead();
        this.batcheId = iMMessage.batcheid;
    }
}

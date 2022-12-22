package com.didi.sdk.messagecenter.subscribe;

import com.didi.sdk.messagecenter.interfaces.IHandler;
import com.didi.sdk.messagecenter.model.PushMessage;

public class Subscription {
    public final IHandler messageHandler;
    public final Object subscriber;
    public final Class<? extends PushMessage> subscriberMessageClz;
    public final String subscriberTopic;
    public final int subscriberUnifyId;
    public final String type;

    public Subscription(Object obj, String str, int i, String str2, IHandler iHandler, Class<? extends PushMessage> cls) {
        this.subscriber = obj;
        this.subscriberTopic = str;
        this.subscriberUnifyId = i;
        this.type = str2;
        this.messageHandler = iHandler;
        this.subscriberMessageClz = cls;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof Subscription)) {
            return false;
        }
        Subscription subscription = (Subscription) obj;
        if (this.subscriber == subscription.subscriber && this.subscriberTopic.equals(subscription.subscriberTopic) && this.subscriberUnifyId == subscription.subscriberUnifyId && this.type.equals(subscription.type) && this.messageHandler == subscription.messageHandler && this.subscriberMessageClz == subscription.subscriberMessageClz) {
            return true;
        }
        return false;
    }

    public int hashCode() {
        return this.subscriber.hashCode() + this.subscriberTopic.hashCode() + this.subscriberUnifyId + this.type.hashCode() + this.messageHandler.hashCode() + this.subscriberMessageClz.hashCode();
    }
}

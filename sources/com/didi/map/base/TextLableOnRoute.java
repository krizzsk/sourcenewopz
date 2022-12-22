package com.didi.map.base;

import android.graphics.Point;
import com.didi.map.core.point.DoublePoint;

public class TextLableOnRoute {
    public String chargeInfo = "";
    public int chargeInfoCount;
    public int diffDistance;
    public int diffTime;
    public int diffTrafficLights;
    public long eventId;
    public int flag;
    public int index;
    public String lable;
    public String name;
    public int nameCount;
    public int posX;
    public int posY;
    public final DoublePoint position = new DoublePoint();
    public long routeID;
    public final Point screenPosition = new Point();
    public int type;

    public String toString() {
        return "posX: " + this.posX + " posY: " + this.posY + " nameCout: " + this.nameCount + " name: " + this.name + " type: " + this.type + " position: " + this.position + " screenPosition " + this.screenPosition;
    }

    public static boolean isDataValid(TextLableOnRoute textLableOnRoute) {
        if (textLableOnRoute != null && Math.abs(textLableOnRoute.diffDistance) / 1000 <= 9999 && Math.abs(textLableOnRoute.diffTime) <= 9999) {
            return true;
        }
        return false;
    }
}

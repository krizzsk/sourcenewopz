package com.didi.entrega.customer.biz.sliding;

import com.didi.entrega.customer.biz.sliding.SlidingLooperService;
import com.didi.entrega.order.data.model.OrderMapStatusModel;

public interface ISlidingLooperService {
    void addDriverSlidingListener(SlidingLooperService.DriverSlidingListener driverSlidingListener);

    void removeDriverSlidingListener(SlidingLooperService.DriverSlidingListener driverSlidingListener);

    void start(OrderMapStatusModel orderMapStatusModel);

    void stop();
}

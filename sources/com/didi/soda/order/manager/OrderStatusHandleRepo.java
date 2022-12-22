package com.didi.soda.order.manager;

import android.text.TextUtils;
import com.didi.app.nova.skeleton.repo.Repo;
import com.didi.app.nova.skeleton.repo.Resource;
import com.didi.soda.customer.foundation.rpc.CustomerRpcManagerProxy;
import com.didi.soda.customer.foundation.rpc.CustomerRpcService;
import com.didi.soda.customer.foundation.rpc.entity.OrderCancelEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderHandleEntity;
import com.didi.soda.customer.foundation.rpc.entity.OrderReminderEntity;
import com.didi.soda.customer.foundation.rpc.net.CustomerRpcCallback;
import com.didi.soda.customer.foundation.rpc.net.SFRpcException;
import com.didi.soda.customer.repo.CustomerResource;

public class OrderStatusHandleRepo extends Repo<Resource<OrderHandleEntity>> {
    public CustomerRpcService mRpcService = CustomerRpcManagerProxy.get();

    public OrderStatusHandleRepo cancelOrder(String str, String str2) {
        this.mRpcService.doCancelOrder(str, str2, new CustomerRpcCallback<OrderCancelEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                OrderStatusHandleRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }

            public void onRpcSuccess(OrderCancelEntity orderCancelEntity, long j) {
                if (orderCancelEntity != null) {
                    if (orderCancelEntity.status == 901) {
                        OrderStatusHandleRepo.this.setValue(CustomerResource.success(new OrderHandleEntity(101, true)));
                    } else {
                        OrderStatusHandleRepo.this.setValue(CustomerResource.success(new OrderHandleEntity(101, false)));
                    }
                }
            }
        });
        return this;
    }

    public OrderStatusHandleRepo cancelOrder(String str, String str2, final CustomerRpcCallback<OrderCancelEntity> customerRpcCallback) {
        this.mRpcService.doCancelOrder(str, str2, new CustomerRpcCallback<OrderCancelEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                CustomerRpcCallback customerRpcCallback = customerRpcCallback;
                if (customerRpcCallback != null) {
                    customerRpcCallback.onRpcFailure(sFRpcException);
                }
                OrderStatusHandleRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }

            public void onRpcSuccess(OrderCancelEntity orderCancelEntity, long j) {
                CustomerRpcCallback customerRpcCallback = customerRpcCallback;
                if (customerRpcCallback != null) {
                    customerRpcCallback.onRpcSuccess(orderCancelEntity, j);
                }
                if (orderCancelEntity != null) {
                    if (orderCancelEntity.status == 901) {
                        OrderStatusHandleRepo.this.setValue(CustomerResource.success(new OrderHandleEntity(101, true)));
                    } else {
                        OrderStatusHandleRepo.this.setValue(CustomerResource.success(new OrderHandleEntity(101, false)));
                    }
                }
            }
        });
        return this;
    }

    public OrderStatusHandleRepo confirmFinishOrder(String str) {
        this.mRpcService.doConfirmFinishOrder(str, new CustomerRpcCallback<Object>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                OrderStatusHandleRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
            }

            public void onRpcSuccess(Object obj, long j) {
                OrderStatusHandleRepo.this.setValue(CustomerResource.success(new OrderHandleEntity(102, true)));
            }
        });
        return this;
    }

    public void onReminderOrder(String str) {
        CustomerRpcManagerProxy.get().doReminderOrder(str, new CustomerRpcCallback<OrderReminderEntity>() {
            public void onRpcFailure(SFRpcException sFRpcException) {
                super.onRpcFailure(sFRpcException);
                if (sFRpcException.getCode() == -1) {
                    OrderStatusHandleRepo.this.setValue(CustomerResource.error(0, ""));
                } else {
                    OrderStatusHandleRepo.this.setValue(CustomerResource.error(sFRpcException.getCode(), sFRpcException.getMessage()));
                }
            }

            public void onRpcSuccess(OrderReminderEntity orderReminderEntity, long j) {
                OrderHandleEntity orderHandleEntity = new OrderHandleEntity(103, false);
                if (orderReminderEntity != null && !TextUtils.isEmpty(orderReminderEntity.tip)) {
                    orderHandleEntity.setTip(orderReminderEntity.tip);
                }
                OrderStatusHandleRepo.this.setValue(CustomerResource.success(orderHandleEntity));
            }
        });
    }

    public static final class OrderHandleType {
        public static final int TYPE_CANCEL = 101;
        public static final int TYPE_CONFIRM = 102;
        public static final int TYPE_REMINDER = 103;

        private OrderHandleType() {
        }
    }
}

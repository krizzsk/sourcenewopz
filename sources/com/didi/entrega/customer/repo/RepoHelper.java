package com.didi.entrega.customer.repo;

public class RepoHelper {
    public static boolean checkDataValid(CustomerResource customerResource) {
        return (customerResource == null || customerResource.data == null) ? false : true;
    }
}

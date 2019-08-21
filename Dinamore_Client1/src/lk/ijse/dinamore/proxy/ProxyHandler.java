/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.proxy;

import java.rmi.Naming;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinamore.service.ServiceFactory;
import lk.ijse.dinamore.service.SuperService;
import lk.ijse.dinamore.service.custom.OrderService;

/**
 *
 * @author Ravindu
 */
public class ProxyHandler implements ServiceFactory{
    private static ProxyHandler proxyHandler;
    private OrderService orderService;
    private ServiceFactory serviceFactory;

    public ProxyHandler() {
        try {
            serviceFactory = (ServiceFactory) 
                    Naming.lookup("rmi://localhost:1010/POS");
            orderService = (OrderService) 
                    serviceFactory.getService(ServiceType.ORDERS);
            
        } catch (Exception ex) {
            Logger.getLogger(ProxyHandler.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
     public static ProxyHandler getInstance(){
        if (proxyHandler == null) {
            proxyHandler = new ProxyHandler();
        }
        return proxyHandler;
    }
    
    @Override
    public SuperService getService(ServiceType serviceType) throws Exception {
        switch(serviceType){
            case ORDERS: return orderService;
            default: return null;
        }
    }
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.controller;

import java.util.List;
import lk.ijse.dinamore.dto.OrderDTO;
import lk.ijse.dinamore.observer.Subject;
import lk.ijse.dinamore.proxy.ProxyHandler;
import lk.ijse.dinamore.service.ServiceFactory;
import lk.ijse.dinamore.service.custom.OrderService;

/**
 *
 * @author Ravindu
 */
public class ManageOrderController {
    public static boolean placeOrder(OrderDTO orderDTO) throws Exception{
         OrderService orderService = (OrderService) ProxyHandler.getInstance()
                .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.placeOrder(orderDTO);
}

    public static boolean removeOrder(String cid) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.deleteOrder(cid);
    }
    
    public static boolean updateCustomer(OrderDTO orderDTO) throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.updateStatus(orderDTO);
    }
    
    public static List<OrderDTO> getAllCustomers() throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance()
                        .getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.getAllOrder();
    }
    
    public static Subject getSubeject() throws Exception{
        return (Subject) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
    }


}

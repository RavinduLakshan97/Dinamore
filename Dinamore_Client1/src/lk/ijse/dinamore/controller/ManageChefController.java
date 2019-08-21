/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.controller;

import java.util.List;
import lk.ijse.dinamore.dto.OrderDTO;
import lk.ijse.dinamore.proxy.ProxyHandler;
import lk.ijse.dinamore.service.ServiceFactory;
import lk.ijse.dinamore.service.custom.OrderService;

/**
 *
 * @author Ravindu
 */
public class ManageChefController {

    public static boolean updateCustomer(OrderDTO orderDTO)throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.updateStatus(orderDTO);
    }

    public static List<OrderDTO> getAllCustomers()throws Exception{
        OrderService orderService = (OrderService) ProxyHandler.getInstance().getService(ServiceFactory.ServiceType.ORDERS);
        return orderService.getAllOrder();
    }

}

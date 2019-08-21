/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.service.custom.impl;

import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import lk.ijse.dinamore.buisness.BOFactory;
import lk.ijse.dinamore.buisness.custom.OrderBO;
import lk.ijse.dinamore.dto.OrderDTO;
import lk.ijse.dinamore.observer.Observer;
import lk.ijse.dinamore.observer.Subject;
import lk.ijse.dinamore.service.custom.OrderService;

/**
 *
 * @author Ravindu
 */
public class OrderServiceImpl extends UnicastRemoteObject implements  OrderService,Subject{
    
   private OrderBO orderBO;
    private static ArrayList<Observer> alObservers = new ArrayList<>();

    public OrderServiceImpl()throws Exception{
              orderBO = (OrderBO) BOFactory.getInstance().getBO(BOFactory.BOTypes.ORDERS);     
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws Exception {
         boolean placeOrder = orderBO.placeOrder(orderDTO);
        notifyObservers();
        return placeOrder;
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
 boolean deleteCustomer = orderBO.deleteOrder(oid);
        notifyObservers();
        return deleteCustomer;    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        return orderBO.searchOrder(oid);
    }

    @Override
    public boolean updateStatus(OrderDTO orderDTO) throws Exception {
 boolean updateCustomer = orderBO.updateStatus(orderDTO);
        notifyObservers();
        return updateCustomer;    }

    @Override
    public List<OrderDTO> getAllOrder() throws Exception {
        return orderBO.getAllOrder();
    }

    @Override
    public void registerObserver(Observer observer) throws Exception {
        alObservers.add(observer);
    }

    @Override
    public void unregisterObserver(Observer observer) throws Exception {
        alObservers.remove(observer);
    }

    @Override
    public void notifyObservers() throws Exception {
 new Thread(()->{
            for (Observer observer : alObservers) {
                try {
                    observer.updateObservers();
                } catch (Exception ex) {
                    Logger.getLogger(OrderServiceImpl.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        }).start();    }
    
    
}

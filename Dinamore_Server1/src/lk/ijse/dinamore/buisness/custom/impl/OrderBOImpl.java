/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.buisness.custom.impl;

import java.util.ArrayList;
import java.util.List;
import lk.ijse.dinamore.buisness.custom.OrderBO;
import lk.ijse.dinamore.dto.OrderDTO;
import lk.ijse.dinamore.entity.Orders;
import lk.ijse.dinamore.repository.RepositoryFactory;
import lk.ijse.dinamore.repository.custom.OrderRepository;
import lk.ijse.dinamore.resource.HibernateUtil;
import org.hibernate.Session;

/**
 *
 * @author Ravindu
 */
public class OrderBOImpl implements OrderBO{
    private OrderRepository orderRepository;

    public OrderBOImpl() {
        orderRepository = (OrderRepository) RepositoryFactory.getInstance().getRepository(RepositoryFactory.RepositoryTypes.ORDERS);
    }

    @Override
    public boolean placeOrder(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders order = new Orders(
                    orderDTO.getOrderId(),
                    orderDTO.getReceptionId(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCustName(),
                    orderDTO.getTpNo(),
                    orderDTO.getQty(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.save(order);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public boolean deleteOrder(String oid) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders orders = orderRepository.findByID(oid);
            boolean result = false;
            if (orders != null) {
                result = orderRepository.delete(orders);
            }
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public OrderDTO searchOrder(String oid) throws Exception {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean updateStatus(OrderDTO orderDTO) throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            Orders orders = new Orders(
                    orderDTO.getOrderId(),
                    orderDTO.getReceptionId(),
                    orderDTO.getDate(),
                    orderDTO.getTime(),
                    orderDTO.getCustName(),
                    orderDTO.getTpNo(),
                    orderDTO.getQty(),
                    orderDTO.getStatus()
            );
            boolean result = orderRepository.update(orders);
            session.getTransaction().commit();
            return result;
        }
    }

    @Override
    public List<OrderDTO> getAllOrder() throws Exception {
        try (Session session = HibernateUtil.getSessionFactory().openSession()) {
            orderRepository.setSesstion(session);
            session.beginTransaction();
            List<Orders> orderses = orderRepository.findAll();
            session.getTransaction().commit();
            if (orderses != null) {
                System.out.println("Not Null");
                List<OrderDTO> alorder = new ArrayList<>();
                for (Orders orders : orderses) {
                    OrderDTO orderDTO = new OrderDTO(
                            orders.getOrder_id(),
                            orders.getReception_id(),
                            orders.getDate(),
                            orders.getTime(),
                            orders.getCus_name(),
                            orders.getTp_no(),
                            orders.getQty(),
                            orders.getStatus()
                    );

                    System.out.println("Hello :" + orders.getOrder_id());
                    alorder.add(orderDTO);
                }
                return alorder;
            } else {
                return null;
            }
        }
    }
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.buisness.custom;

import java.util.List;
import lk.ijse.dinamore.buisness.SuperBO;
import lk.ijse.dinamore.dto.OrderDTO;


/**
 *
 * @author Ravindu
 */
public interface OrderBO extends SuperBO{
    public boolean placeOrder(OrderDTO orderDTO)throws Exception;
    
    public boolean deleteOrder(String oid)throws Exception;
    
    public OrderDTO searchOrder(String oid)throws Exception;
    
    public boolean updateStatus(OrderDTO orderDTO)throws Exception;
    
    public List<OrderDTO> getAllOrder() throws Exception;
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.dto;

import java.io.Serializable;

/**
 *
 * @author Ravindu
 */
public class OrderDTO implements Serializable{
    private String orderId;
    private String receptionId;
    private String date;
    private String time;
    private String custName;
    private String tpNo;
    private int qty;
    private String status;

    public OrderDTO() {
    }
    
    public OrderDTO(String orderId,int qty){
        this.orderId = orderId;
        this.qty = qty;
    }
    
    public OrderDTO(String orderId, String status){
        this.orderId = orderId;
        this.status = status;
        
    }

    public OrderDTO(String orderId, String receptionId, String date, String time, String custName, String tpNo, int qty, String status) {
        this.orderId = orderId;
        this.receptionId = receptionId;
        this.date = date;
        this.time = time;
        this.custName = custName;
        this.tpNo = tpNo;
        this.qty = qty;
        this.status = status;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getReceptionId() {
        return receptionId;
    }

    public void setReceptionId(String receptionId) {
        this.receptionId = receptionId;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getTpNo() {
        return tpNo;
    }

    public void setTpNo(String tpNo) {
        this.tpNo = tpNo;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
    
    

    

    
   
    
    
}

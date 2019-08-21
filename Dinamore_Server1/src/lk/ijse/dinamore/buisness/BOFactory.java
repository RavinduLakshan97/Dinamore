/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.buisness;

import lk.ijse.dinamore.buisness.custom.impl.OrderBOImpl;

/**
 *
 * @author Ravindu
 */
public class BOFactory {
  public enum BOTypes{
      ORDERS
  }
  
  private static BOFactory bOFactory;

    private BOFactory() {
    }
  
  public static BOFactory getInstance(){
      if(bOFactory == null){
          bOFactory = new BOFactory();
      }
      return bOFactory;
  }
  
  public SuperBO getBO(BOTypes bOTypes){
      switch(bOTypes){
          case ORDERS:
              return new OrderBOImpl();
          default:return null;
              
      }
  }
}

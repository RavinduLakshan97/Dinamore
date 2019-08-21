/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package lk.ijse.dinamore.repository;

import org.hibernate.Session;
import java.util.List;

/**
 *
 * @author Ravindu
 */
public interface SuperRepository <T,ID>{
    public void setSesstion(Session session);
    
    public boolean save(T t)throws Exception;
    
    public boolean delete(T t)throws Exception;
    
    public boolean update(T t)throws Exception;
    
    public T findByID(ID id)throws Exception;
    
    public List<T> findAll()throws Exception;
    
}

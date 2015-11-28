/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.qrcode.dao.UpdateLengthDao;
import com.qrcode.model.UpdateLength;

/**
 * @author harikrishna.trivedi
 *
 */
@Service("updateLengthService")

@Transactional
public class UpdateLengthServiceImpl implements UpdateLengthService {
 
    @Autowired
    private UpdateLengthDao dao;
     
    public UpdateLength findByBarCode (String barCode) {
        return dao.findByBarCode(barCode);
    }
 
    public void saveUpdateLength(UpdateLength updateLength) {
        dao.saveUpdateLength(updateLength);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateUpdateLength(UpdateLength updateLength) {
    	//Need to write update code
    	dao.saveUpdateLength(updateLength);
    }
 
    public void deleteUpdateLengthByBarCode(String barCode) {
        dao.deleteUpdateLengthByBarCode(barCode);
    }
     
    public List<UpdateLength> findAllUpdateLength() {
        return dao.findAllLengthUpdateDtls();
    }

}

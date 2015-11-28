/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.qrcode.dao.StoreInventoryDtlDao;
import com.qrcode.model.StoreInventoryDtl;

/**
 * @author harikrishna.trivedi
 *
 */
@Service("storeInventoryDtlService")
@Transactional
public class StoreInventoryDtlServiceImpl implements StoreInventoryDtlService {
 
    @Autowired
    private StoreInventoryDtlDao dao;
     
    public StoreInventoryDtl findByBarCode(String barCode) {
        return dao.findByBarCode(barCode);
    }
 
    public void saveStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl) {
        dao.saveStoreInventoryDtl(storeInventoryDtl);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl) {
    	StoreInventoryDtl entity = dao.findByBarCode(storeInventoryDtl.getBarCode());
        if(entity!=null){
            entity.setBarCode(storeInventoryDtl.getBarCode());
            entity.setControl(storeInventoryDtl.getControl());
            entity.setHeat(storeInventoryDtl.getHeat());;
            entity.setItem(storeInventoryDtl.getItem());
            entity.setQtyPc(storeInventoryDtl.getQtyPc());
            entity.setSidCode(storeInventoryDtl.getSidCode());
        }
    }
 
    public void deleteStoreInventoryDtlByBarCode(String barCode) {
        dao.deleteStoreInventoryDtlByBarCode(barCode);
    }
     
    public List<StoreInventoryDtl> findAllStoreInventoryDtls() {
        return dao.findAllStoreInventoryDtls();
    }
 
    public StoreInventoryDtl findStoreInventoryDtlByBarCode(String barCode) {
        return dao.findStoreInventoryDtlByBarCode(barCode);
    }
 
    public boolean isStoreInventoryDtlBarCodeUnique(String barCode) {
    	StoreInventoryDtl storeInventoryDtl = findStoreInventoryDtlByBarCode(barCode);
        return ( storeInventoryDtl == null || (storeInventoryDtl.getBarCode().isEmpty()));
    }
     
}

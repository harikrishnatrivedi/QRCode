/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import com.qrcode.model.StoreInventoryDtl;

/**
 * @author harikrishna.trivedi
 *
 */
public interface StoreInventoryDtlDao {
 
	StoreInventoryDtl findByBarCode(String barCode);
 
    void saveStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl);
     
    void deleteStoreInventoryDtlByBarCode(String barCode);
     
    List<StoreInventoryDtl> findAllStoreInventoryDtls();
 
    StoreInventoryDtl findStoreInventoryDtlByBarCode(String barCode);
 
}
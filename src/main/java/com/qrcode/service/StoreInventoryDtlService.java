/**
 * 
 */
package com.qrcode.service;

import java.util.List;

import com.qrcode.model.StoreInventoryDtl;

/**
 * @author harikrishna.trivedi
 *
 */
 
public interface StoreInventoryDtlService {
 
	StoreInventoryDtl findByBarCode(String barCode);
     
    void saveStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl);
     
    void updateStoreInventoryDtl(StoreInventoryDtl storeInventoryDtl);
     
    void deleteStoreInventoryDtlByBarCode(String barCode);
 
    List<StoreInventoryDtl> findAllStoreInventoryDtls(); 
     
    StoreInventoryDtl findStoreInventoryDtlByBarCode(String barCode);
 
    boolean isStoreInventoryDtlBarCodeUnique(String barCode);
     
}
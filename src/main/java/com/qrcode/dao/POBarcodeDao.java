/**
 * 
 */
package com.qrcode.dao;

import java.math.BigDecimal;
import java.util.List;
import com.qrcode.model.POBarcode;

/**
 * @author harikrishna.trivedi
 *
 */
public interface POBarcodeDao {
 
	POBarcode findByBarCode(String barCode);
 
    void savePOBarcode(POBarcode pOBarcode);
     
    void deletePOBarcodeByBarCode(String barCode);
     
    List<POBarcode> findAllPOBarcode();
    
    public BigDecimal countBarcodeByDocNo(Integer docNo);
}
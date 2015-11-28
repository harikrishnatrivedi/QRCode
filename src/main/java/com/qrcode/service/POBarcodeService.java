/**
 * 
 */
package com.qrcode.service;

import java.math.BigDecimal;
import java.util.List;

import com.qrcode.model.POBarcode;

/**
 * @author harikrishna.trivedi
 *
 */
 
public interface POBarcodeService {
 
	POBarcode findByBarCode(String barCode);
     
    void savePOBarcode(POBarcode pOBarcode);
     
    void updatePOBarcode(POBarcode pOBarcode);
     
    void deletePOBarcodeByBarCode(String barCode);
 
    List<POBarcode> findAllPOBarcode(); 
     
    boolean isPOBarcodeBarCodeUnique(String barCode);
 
    BigDecimal countBarcodeByDocNo(int docNo);
}
/**
 * 
 */
package com.qrcode.service;

import java.math.BigDecimal;
import java.util.List;

import com.qrcode.model.MainGRN;

/**
 * @author harikrishna.trivedi
 *
 */
 
public interface MainGRNService {
 
	MainGRN findByDocNo(int docNo);
     
    void saveMainGRN(MainGRN mainGRN);
     
    void updateMainGRN(MainGRN mainGRN);
     
    void deleteMainGRNByBarCode(String barCode);
 
    List<MainGRN> findAllMainGRN();
     
}
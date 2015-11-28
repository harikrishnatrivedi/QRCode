/**
 * 
 */
package com.qrcode.dao;

import java.math.BigDecimal;
import java.util.List;
import com.qrcode.model.MainGRN;

/**
 * @author harikrishna.trivedi
 *
 */
public interface MainGRNDao {
 
	MainGRN findByDocNo(Integer id);
 
    void saveMainGRN(MainGRN mainGRN);
     
    void deleteMainGRNByBarCode(String barCode);
     
    List<MainGRN> findAllMainGRN();
 
    MainGRN findMainGRNByBarCode(String barCode);
 
}
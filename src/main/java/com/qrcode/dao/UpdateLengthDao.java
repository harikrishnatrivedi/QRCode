/**
 * 
 */
package com.qrcode.dao;

import java.util.List;
import com.qrcode.model.UpdateLength;

/**
 * @author harikrishna.trivedi
 *
 */
public interface UpdateLengthDao {
 
	UpdateLength findByBarCode(String barCode);
 
    void saveUpdateLength(UpdateLength lengthUpdate);
     
    void deleteUpdateLengthByBarCode(String barCode);
     
    List<UpdateLength> findAllLengthUpdateDtls();
 
}
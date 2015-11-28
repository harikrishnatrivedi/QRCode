/**
 * 
 */
package com.qrcode.service;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 
import com.qrcode.dao.MainGRNDao;
import com.qrcode.model.MainGRN;

/**
 * @author harikrishna.trivedi
 *
 */
@Service("mainGRNService")
@Transactional
public class MainGRNServiceImpl implements MainGRNService {
 
    @Autowired
    private MainGRNDao dao;
     
    public MainGRN findByDocNo(int docNo) {
        return dao.findByDocNo(docNo);
    }
 
    public void saveMainGRN(MainGRN mainGRN) {
        dao.saveMainGRN(mainGRN);
    }
 
    /*
     * Since the method is running with Transaction, No need to call hibernate update explicitly.
     * Just fetch the entity from db and update it with proper values within transaction.
     * It will be updated in db once transaction ends. 
     */
    public void updateMainGRN(MainGRN mainGRN) {
    	MainGRN entity = dao.findByDocNo(mainGRN.getDocNo());
        if(entity!=null){
            entity.setBarCodeGenDate(mainGRN.getBarCodeGenDate());
            entity.setBarCodeUserId(mainGRN.getBarCodeUserId());
            entity.setDate(mainGRN.getDate());
            entity.setDocNo(mainGRN.getDocNo());
            entity.setGrnNo(mainGRN.getGrnNo());
            entity.setItemCode(mainGRN.getItemCode());
            entity.setItemDesc(mainGRN.getItemDesc());
            entity.setLineNo(mainGRN.getLineNo());
            entity.setManualIssueFlag(mainGRN.getManualIssueFlag());
            entity.setMrnReceiveQty(mainGRN.getMrnReceiveQty());
            entity.setMrnUpdateFlag(mainGRN.getMrnUpdateFlag());
            entity.setPieces(mainGRN.getPieces());
            entity.setPoNo(mainGRN.getPoNo());
            entity.setQtyUpdateFlag(mainGRN.getQtyUpdateFlag());
            entity.setQuantity(mainGRN.getQuantity());
            entity.setQuantityWT(mainGRN.getQuantityWT());
            entity.setStatus(mainGRN.getStatus());
            entity.setTotalKG(mainGRN.getTotalKG());
            entity.setType(mainGRN.getType());
            entity.setVendorNo(mainGRN.getVendorNo());
        }
    }
 
    public void deleteMainGRNByBarCode(String barCode) {
        dao.deleteMainGRNByBarCode(barCode);
    }
     
    public List<MainGRN> findAllMainGRN() {
        return dao.findAllMainGRN();
    }
 
    
     
}

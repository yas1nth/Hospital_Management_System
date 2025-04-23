package com.example.hms.service;

import com.example.hms.models.Bill;
import com.example.hms.repository.BillRepository;
import java.util.List;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BillService {

  @Autowired
  private BillRepository billRepository;

  private static final Logger logger = LoggerFactory.getLogger(BillService.class);

   public List<Bill> getAllBills() {
       return billRepository.findAll();
   }

   public Bill getBillById(Long id) {
       return billRepository.findById(id).orElse(null);
   }

   public Bill saveBill(Bill bill) {
       return billRepository.save(bill);
   }

   public void deleteBill(Long id) {
       billRepository.deleteById(id);
   }

   public Bill updateBillById(Long Id,Bill bill){
        Bill existingBill = billRepository.findById(Id).orElse(null);
        if (existingBill != null) {
            existingBill.setAmount(bill.getAmount());
            existingBill.setStatus(bill.getStatus());
            existingBill.setPatientId(bill.getPatientId());
            return billRepository.save(existingBill);
        }
        return null;
   }
}

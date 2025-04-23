package com.example.hms.controllers;

import com.example.hms.models.Bill;
import com.example.hms.service.BillService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/bills")
public class BillController {

  @Autowired
  private BillService billService;

  @PostMapping
  public Bill createBill(@RequestBody Bill bill){
    System.out.println("Creating Bill");
    return billService.saveBill(bill);
  }

  @GetMapping
  public List<Bill> getAllBills(){
    System.out.println("Fetching all bills");
    return billService.getAllBills();
  }

  @GetMapping("/{id}")
  public Bill getBillById(@PathVariable Long id){
    System.out.println("Fetching bill by id");
    return billService.getBillById(id);
  }

  @PutMapping("/{id}")
  public Bill updateBillById(@PathVariable Long id, @RequestBody Bill bill){
    System.out.println("Updating bill by id");
    return billService.updateBillById(id, bill);
  }

  @DeleteMapping("/{id}")
  public void deleteBillById(@PathVariable Long id){
    System.out.println("Deleting bill by id");
    billService.deleteBill(id);
  }
}

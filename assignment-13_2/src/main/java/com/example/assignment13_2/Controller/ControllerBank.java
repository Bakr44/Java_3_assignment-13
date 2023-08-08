package com.example.assignment13_2.Controller;

import com.example.assignment13_2.Model.Customers;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/v1/bank")
public class ControllerBank {

ArrayList<Customers> customers=new ArrayList<>();

@GetMapping("/get")
public ArrayList<Customers> getAll(){
    return customers;
}
@PostMapping("/add")
public String addCustomer(@RequestBody Customers customer){
    customers.add(customer);
    return "Added";

}

@PutMapping("/update/{index}")
public String updateCustomer(@PathVariable int index,@RequestBody Customers customer){
    customers.set(index,customer);
    return "Updated";

}

@DeleteMapping("/delete/{index}")
public String deleteCustomer(@PathVariable int index){
    customers.remove(index);
    return "Deleted";

}

@PutMapping("/deposit/{index}")
public String DepositMoneyToCustomer(@PathVariable int index,@RequestBody int amount){
   Customers customer=customers.get(index);
//  int currentBalance=customer.getBalance();
  customer.setBalance(customer.getBalance()+amount);
  return "Deposited";
}


    @PutMapping("/withdraw/{index}")
    public String withdrawMoneyFromCustomer(@PathVariable int index, @RequestBody int amount) {
    Customers customer=customers.get(index);
    if(customer.getBalance()>=amount){
        customer.setBalance(customer.getBalance()-amount);
        return "withdraw";
    }else return "not enough money";
    }



}

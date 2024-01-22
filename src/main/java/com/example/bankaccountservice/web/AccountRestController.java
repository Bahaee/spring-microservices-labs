package com.example.bankaccountservice.web;

import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import java.util.List;
import java.util.UUID;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
  private BankAccountRepository bankAccountRepository;

  public AccountRestController(BankAccountRepository bankAccountRepository){
    this.bankAccountRepository = bankAccountRepository;
  }

  @GetMapping("/bankAccounts")
  public List<BankAccount> bankAccounts(){
    return bankAccountRepository.findAll();
  }

  @GetMapping("/bankAccounts/{id}")
  public BankAccount bankAccounts(@PathVariable String id){
    return bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));
  }

  @PostMapping("/bankAccounts")
  public BankAccount saveBankAccount(@RequestBody BankAccount bankAccount){
    if (bankAccount.getId() == null)bankAccount.setId(UUID.randomUUID().toString());
    return bankAccountRepository.save(bankAccount);
  }

  @PutMapping("/bankAccounts/{id}")
  public BankAccount updateBankAccount(@PathVariable String id, @RequestBody BankAccount bankAccount){
    BankAccount account = bankAccountRepository.findById(id).orElseThrow(()-> new RuntimeException(String.format("Account %s not found", id)));
    if(bankAccount.getBalance() != null) bankAccount.setBalance(account.getBalance());
    if(bankAccount.getType() != null)bankAccount.setType(account.getType());
    if(bankAccount.getCurrency() != null)bankAccount.setCurrency(account.getCurrency());
    if(bankAccount.getCreatedAt() != null)bankAccount.setCreatedAt(account.getCreatedAt());
    return bankAccountRepository.save(account);
  }

  @DeleteMapping("/bankAccounts/{id}")
  public void deleteBankAccount(@PathVariable String id){
    bankAccountRepository.deleteById(id);
  }
}

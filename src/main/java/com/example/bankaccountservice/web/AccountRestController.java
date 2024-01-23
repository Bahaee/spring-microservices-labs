package com.example.bankaccountservice.web;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import com.example.bankaccountservice.services.BankAccountService;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountRestController {
  private BankAccountRepository bankAccountRepository;
  private BankAccountService bankAccountService;

  public AccountRestController(BankAccountRepository bankAccountRepository,
      BankAccountService bankAccountService){
    this.bankAccountRepository = bankAccountRepository;
    this.bankAccountService = bankAccountService;
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
  public ResponseEntity<BankAccountResponseDTO> saveBankAccount(@RequestBody BankAccountRequestDTO bankAccountRequestDTO) {
    BankAccountResponseDTO responseDTO = bankAccountService.addAccount(bankAccountRequestDTO);
    return ResponseEntity.ok(responseDTO);
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

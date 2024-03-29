package com.example.bankaccountservice.mappers;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Component;

@Component
public class BankAccountMapper {

    public BankAccount fromBankAccountRequestDTO(BankAccountRequestDTO bankAccountRequestDTO){
      BankAccount bankAccount = new BankAccount();
      BeanUtils.copyProperties(bankAccountRequestDTO, bankAccount);
      return bankAccount;
    }
    public BankAccountResponseDTO fromBankAccount(BankAccount bankAccount){
      BankAccountResponseDTO bankAccountResponseDTO = new BankAccountResponseDTO();
      BeanUtils.copyProperties(bankAccount, bankAccountResponseDTO);
      return  bankAccountResponseDTO;
    }
}

package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import org.springframework.stereotype.Service;

@Service
public interface BankAccountService {
  BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO);

}

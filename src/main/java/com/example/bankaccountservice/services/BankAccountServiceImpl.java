package com.example.bankaccountservice.services;

import com.example.bankaccountservice.dto.BankAccountRequestDTO;
import com.example.bankaccountservice.dto.BankAccountResponseDTO;
import com.example.bankaccountservice.entities.BankAccount;
import com.example.bankaccountservice.mappers.BankAccountMapper;
import com.example.bankaccountservice.repositories.BankAccountRepository;
import java.util.Date;
import java.util.UUID;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class BankAccountServiceImpl implements
    BankAccountService {
  private BankAccountRepository bankAccountRepository;
  private BankAccountMapper bankAccountMapper;

  public BankAccountServiceImpl(BankAccountRepository bankAccountRepository,
      BankAccountMapper bankAccountMapper) {
    this.bankAccountRepository = bankAccountRepository;
    this.bankAccountMapper = bankAccountMapper;
  }


  @Override
  public BankAccountResponseDTO addAccount(BankAccountRequestDTO bankAccountRequestDTO) {
    BankAccount bankAccount = bankAccountMapper.fromBankAccountRequestDTO(bankAccountRequestDTO);
    BankAccount savedBankAccount = bankAccountRepository.save(bankAccount);
    BankAccountResponseDTO bankAccountResponseDTO = bankAccountMapper.fromBankAccount(savedBankAccount);
    return bankAccountResponseDTO;
  }
}

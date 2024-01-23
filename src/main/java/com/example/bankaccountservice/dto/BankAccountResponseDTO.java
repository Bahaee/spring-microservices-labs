package com.example.bankaccountservice.dto;

import com.example.bankaccountservice.enums.AccountType;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccountResponseDTO {
  private String id;
  private Date createdAt;
  private Double balance;
  private String currency;
  private AccountType type;
}

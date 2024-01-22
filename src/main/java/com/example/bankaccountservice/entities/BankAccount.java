package com.example.bankaccountservice.entities;

import com.example.bankaccountservice.enums.AccountType;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data @NoArgsConstructor @AllArgsConstructor @Builder
public class BankAccount {
  @Id
  private String id;
  private Date createdAt;
  private Double balance;
  private String currency;
  @Enumerated(EnumType.STRING)
  private AccountType type;
}

package com.kouskefil.fraud;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class FraudCheckService {

    private  final FraudCheckHistoryRepository fraudCheckHistoryRepository;
    public boolean isFraudulentCustomer(Integer customerId) {
        fraudCheckHistoryRepository.save(
                FraudCheckHistory.builder()
                        .customerId(customerId)
                        .isFraudster(false)
                        .createdAt(LocalDate.from(LocalDateTime.now()))
                        .build()
        );
        return false;
    }


}

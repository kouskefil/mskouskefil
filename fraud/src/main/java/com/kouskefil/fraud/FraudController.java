package com.kouskefil.fraud;

import com.kouskefil.clients.fraud.FraudCheckResponse;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/fraud-check")
@AllArgsConstructor
@Slf4j
public class FraudController {

    FraudCheckService fraudCheckService;

    @GetMapping(path = "/{customerId}")
    public FraudCheckResponse isFraudster(@PathVariable Integer customerId) {
        boolean isFraudulentCustomer =  fraudCheckService.isFraudulentCustomer(customerId);
        log.info("fraud check response for customer {} is {}", customerId, isFraudulentCustomer);
        return new FraudCheckResponse(isFraudulentCustomer);

    }
}

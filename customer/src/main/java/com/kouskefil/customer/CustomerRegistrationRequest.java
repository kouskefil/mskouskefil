package com.kouskefil.customer;

public record CustomerRegistrationRequest(
        String firstName,
        String lastName,
        String email
) {
}

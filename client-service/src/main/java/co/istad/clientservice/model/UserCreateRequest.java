package co.istad.clientservice.model;

import jakarta.validation.constraints.NotBlank;

public record UserCreateRequest(
        @NotBlank(message = "Name is required!")
        String name,
        @NotBlank(message = "Email is required!")
        String email,
        @NotBlank(message = "Phone is required!")
        String phone,
        @NotBlank(message = "Gender is required!")
        String gender,
        @NotBlank(message = "Address is required!")
        String address
) {
}

package co.istad.clientservice.model;

public record UserResponse(
        String id,
        String name,
        String email,
        String phone,
        String gender,
        String address
) {
}

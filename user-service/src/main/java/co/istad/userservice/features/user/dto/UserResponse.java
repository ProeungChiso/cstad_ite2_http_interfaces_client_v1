package co.istad.userservice.features.user.dto;

public record UserResponse(
        String id,
        String name,
        String email,
        String phone,
        String gender,
        String address
) {
}

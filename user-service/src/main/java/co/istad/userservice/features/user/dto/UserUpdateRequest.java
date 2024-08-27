package co.istad.userservice.features.user.dto;

public record UserUpdateRequest(
        String name,
        String phone,
        String gender,
        String address
) {
}

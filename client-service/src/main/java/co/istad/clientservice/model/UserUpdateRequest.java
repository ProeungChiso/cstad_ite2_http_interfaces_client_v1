package co.istad.clientservice.model;

public record UserUpdateRequest(
        String name,
        String phone,
        String gender,
        String address
) {
}

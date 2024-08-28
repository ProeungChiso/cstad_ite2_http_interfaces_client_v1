package co.istad.clientservice.model;

import java.util.List;

public record UserResponseList(
        List<UserResponse> content,
        PageInfoResponse page
) {
}

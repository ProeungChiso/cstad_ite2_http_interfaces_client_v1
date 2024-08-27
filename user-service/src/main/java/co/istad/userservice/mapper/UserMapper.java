package co.istad.userservice.mapper;

import co.istad.userservice.domain.User;
import co.istad.userservice.features.user.dto.UserCreateRequest;
import co.istad.userservice.features.user.dto.UserResponse;
import co.istad.userservice.features.user.dto.UserUpdateRequest;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {
    User userCreateRequestToUser(UserCreateRequest userCreateRequest);
    UserResponse userToUserResponse(User user);
    User userUpdateRequestToUser(UserUpdateRequest userUpdateRequest);
}

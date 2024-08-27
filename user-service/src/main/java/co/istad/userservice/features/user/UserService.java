package co.istad.userservice.features.user;

import co.istad.userservice.features.user.dto.UserCreateRequest;
import co.istad.userservice.features.user.dto.UserResponse;
import co.istad.userservice.features.user.dto.UserUpdateRequest;
import org.springframework.data.domain.Page;

public interface UserService {
    void createUser(UserCreateRequest request);
    Page<UserResponse> findAllUsers(int page, int size);
    void deleteUser(String id);
    void updateUser(String id, UserUpdateRequest request);
    UserResponse findUserById(String id);
}

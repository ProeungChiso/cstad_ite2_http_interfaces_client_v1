package co.istad.userservice.features.user;

import co.istad.userservice.domain.User;
import co.istad.userservice.features.user.dto.UserCreateRequest;
import co.istad.userservice.features.user.dto.UserResponse;
import co.istad.userservice.features.user.dto.UserUpdateRequest;
import co.istad.userservice.mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService{

    private final UserRepository userRepository;
    private final UserMapper userMapper;

    @Override
    public void createUser(UserCreateRequest request) {
        if(userRepository.existsByName(request.name())){
            throw new ResponseStatusException(
                    HttpStatus.CONFLICT,
                    "User name already exists"
            );
        }

        User user = userMapper.userCreateRequestToUser(request);
        userRepository.save(user);
    }

    @Override
    public Page<UserResponse> findAllUsers(int page, int size) {
        Pageable pageable = PageRequest.of(page, size);

        if(userRepository.findAll().isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No users found"
            );
        }

        List<User> users = userRepository.findAll();
        List<UserResponse> userResponses = users
                .stream()
                .map(userMapper::userToUserResponse)
                .toList();

        return new PageImpl<>(userResponses, pageable, users.size());
    }

    @Override
    public void deleteUser(String id) {
        userRepository.deleteById(id);
    }

    @Override
    public void updateUser(String id, UserUpdateRequest request) {
        if(userRepository.findById(id).isEmpty()){
            throw new ResponseStatusException(
                    HttpStatus.NOT_FOUND,
                    "No user found"
            );
        }

        User user = userRepository.findById(id).get();
        user.setName(request.name());
        user.setPhone(request.phone());
        user.setGender(request.gender());
        user.setAddress(request.address());

        userRepository.save(user);
    }

    @Override
    public UserResponse findUserById(String id) {

        User user = userRepository.findById(id).orElseThrow(
                () -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        "No user found"
                )
        );

        return userMapper.userToUserResponse(user);
    }
}

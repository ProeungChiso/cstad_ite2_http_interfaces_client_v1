package co.istad.userservice.features.user;

import co.istad.userservice.features.user.dto.UserCreateRequest;
import co.istad.userservice.features.user.dto.UserResponse;
import co.istad.userservice.features.user.dto.UserUpdateRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/users")
@RequiredArgsConstructor
public class UserController {

    private final UserService userService;

    @GetMapping
    public Page<UserResponse> findAllUsers(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size
    ){
        return userService.findAllUsers(page, size);
    }

    @GetMapping("/{id}")
    public UserResponse findUserById(@PathVariable String id){
        return userService.findUserById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public void createUser(@RequestBody UserCreateRequest userCreateRequest){
        userService.createUser(userCreateRequest);
    }

    @PutMapping("{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable String id, @RequestBody UserUpdateRequest userUpdateRequest){
        userService.updateUser(id, userUpdateRequest);
    }

    @DeleteMapping("{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userService.deleteUser(id);
    }
}

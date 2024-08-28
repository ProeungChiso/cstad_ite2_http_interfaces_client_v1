package co.istad.clientservice.controller;

import co.istad.clientservice.model.UserCreateRequest;
import co.istad.clientservice.model.UserResponse;
import co.istad.clientservice.model.UserResponseList;
import co.istad.clientservice.model.UserUpdateRequest;
import co.istad.clientservice.service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class UserClientController {

    public final UserClientService userClientService;

    @GetMapping("/users")
    public UserResponseList getUsers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size)
    {
        return userClientService.getUsers(page, size);
    }

    @GetMapping("/users/{id}")
    public Mono<UserResponse> getUser(@PathVariable String id) {
        return userClientService.getUserById(id);
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void postUser(@RequestBody UserCreateRequest request){
        userClientService.postUser(request);
    }

    @PutMapping("/users/{id}")
    @ResponseStatus(HttpStatus.OK)
    public void updateUser(@PathVariable String id, @RequestBody UserUpdateRequest request){
        userClientService.putUserById(id, request);
    }

    @DeleteMapping("/users/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteUser(@PathVariable String id){
        userClientService.deleteUserById(id);
    }
}

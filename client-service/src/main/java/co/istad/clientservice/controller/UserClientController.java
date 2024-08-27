package co.istad.clientservice.controller;

import co.istad.clientservice.model.UserCreateRequest;
import co.istad.clientservice.model.UserResponse;
import co.istad.clientservice.model.UserUpdateRequest;
import co.istad.clientservice.service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class UserClientController {

    public final UserClientService userClientService;

    @GetMapping("/users")
    public Object getUsers() {
        return userClientService.getUsers();
    }

    @GetMapping("/users/{id}")
    public Object getUser(@PathVariable String id) {
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

package co.istad.clientservice.service;

import co.istad.clientservice.model.UserCreateRequest;
import co.istad.clientservice.model.UserResponse;
import co.istad.clientservice.model.UserResponseList;
import co.istad.clientservice.model.UserUpdateRequest;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;
import reactor.core.publisher.Mono;

public interface UserClientService {

    @GetExchange
    UserResponseList getUsers(
            @RequestParam(name = "page", defaultValue = "0") int page,
            @RequestParam(name = "size", defaultValue = "10") int size
    );

    @GetExchange("/{id}")
    Mono<UserResponse> getUserById(@PathVariable("id") String id);

    @PostExchange
    void postUser(@RequestBody UserCreateRequest userCreateRequest);

    @PutExchange("/{id}")
    void putUserById(@PathVariable("id") String id, @RequestBody UserUpdateRequest request);

    @DeleteExchange("/{id}")
    void deleteUserById(@PathVariable("id") String id);
}

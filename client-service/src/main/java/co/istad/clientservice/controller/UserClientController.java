package co.istad.clientservice.controller;

import co.istad.clientservice.model.UserResponse;
import co.istad.clientservice.service.UserClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/client")
@RequiredArgsConstructor
public class UserClientController {

    public final UserClientService userClientService;

    @GetMapping("/users")
    public List<UserResponse> getUsers() {
        return userClientService.getUsers();
    }
}

package co.istad.clientservice.service;

import co.istad.clientservice.model.UserResponse;
import org.springframework.web.service.annotation.GetExchange;

import java.util.List;

public interface UserClientService {
    @GetExchange
    List<UserResponse> getUsers();
}

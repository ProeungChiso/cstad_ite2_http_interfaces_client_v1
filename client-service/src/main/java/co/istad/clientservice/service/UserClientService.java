package co.istad.clientservice.service;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.service.annotation.DeleteExchange;
import org.springframework.web.service.annotation.GetExchange;
import org.springframework.web.service.annotation.PostExchange;
import org.springframework.web.service.annotation.PutExchange;

public interface UserClientService {
    @GetExchange
    Object getUsers();

    @GetExchange("/{id}")
    Object getUserById(@PathVariable("id") String id);

    @PostExchange
    Object postUser(@RequestBody Object object);

    @PutExchange("/{id}")
    Object putUserById(@PathVariable("id") String id, @RequestBody Object object);

    @DeleteExchange("/{id}")
    Object deleteUserById(@PathVariable("id") String id);
}

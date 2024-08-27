package co.istad.clientservice.config;

import co.istad.clientservice.service.UserClientService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.support.WebClientAdapter;
import org.springframework.web.service.invoker.HttpServiceProxyFactory;

@Configuration
public class ClientConfig {

    @Bean
    UserClientService userClientService() {
        WebClient client = WebClient.builder()
                .baseUrl("http://localhost:8081/api/users")
                .build();

        WebClientAdapter adapter = WebClientAdapter.create(client);
        HttpServiceProxyFactory factory = HttpServiceProxyFactory.builderFor(adapter).build();

        return factory.createClient(UserClientService.class);
    }
}

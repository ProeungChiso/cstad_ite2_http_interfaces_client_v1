package co.istad.userservice.base;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasedResponse<T> {
    private T payload;
}

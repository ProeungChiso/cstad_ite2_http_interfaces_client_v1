package co.istad.userservice.base;

import lombok.*;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class BasedError<T> {
    private String code;
    private T description;
}

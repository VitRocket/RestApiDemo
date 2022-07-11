package com.github.vitrocket.restapidemo.order.dto;

import lombok.*;
import org.springframework.lang.Nullable;

import java.util.Optional;

@NoArgsConstructor(access = AccessLevel.PRIVATE)
@AllArgsConstructor
@Builder
@Getter
@ToString
public class ClientUpdatePatch {

    private Optional<String> name;
    private Optional<String> email;

    public boolean isPresentName() {
        return name.isPresent();
    }

    public boolean isPresentEmail() {
        return email.isPresent();
    }

    @Nullable
    public String getNameData() {
        return name.orElse(null);
    }

    @Nullable
    public String getEmailData() {
        return email.orElse(null);
    }
}

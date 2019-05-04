package de.vkb.komposit.platform.vorschlag.model;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

import java.util.UUID;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
@ToString
public class VorschlagId {
    UUID id;

    @JsonIgnore
    public boolean isValid() {
        if(id != null) return true;
        return false;
    }
}

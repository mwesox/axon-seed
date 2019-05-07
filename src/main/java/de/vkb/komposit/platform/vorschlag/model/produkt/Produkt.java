package de.vkb.komposit.platform.vorschlag.model.produkt;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class Produkt {

    private String id;
    private String name;
    private List<Produktbaustein> produktbaustein;

}

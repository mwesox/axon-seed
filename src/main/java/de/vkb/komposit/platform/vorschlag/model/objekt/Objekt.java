package de.vkb.komposit.platform.vorschlag.model.objekt;

import com.fasterxml.jackson.annotation.JsonCreator;
import lombok.*;

import java.util.List;

@AllArgsConstructor(onConstructor = @__(@JsonCreator))
@Getter
@Builder
public class Objekt {

    ObjektTyp objektTyp;
    int baujahr;
    Anschrift anschrift;
    List<Sanierung> sanierung;
    Vermietung vermietung;
    boolean fertighaus;
    Bauart bauart;
    AnzahlObergeschosse anzahlObergeschosse;
}

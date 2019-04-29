package de.vkb.komposit.platform.produkt.projections;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduktEntityRepository extends MongoRepository<ProduktEntity, String> {
}

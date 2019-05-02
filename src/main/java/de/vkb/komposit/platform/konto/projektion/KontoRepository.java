package de.vkb.komposit.platform.konto.projektion;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KontoRepository extends MongoRepository<KontoDokument, String> {

}

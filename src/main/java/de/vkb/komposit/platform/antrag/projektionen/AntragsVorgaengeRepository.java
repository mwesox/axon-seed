package de.vkb.komposit.platform.antrag.projektionen;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AntragsVorgaengeRepository extends MongoRepository<AntragsVorgang, String> {
}

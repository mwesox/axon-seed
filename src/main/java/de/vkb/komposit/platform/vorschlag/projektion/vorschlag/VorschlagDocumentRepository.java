package de.vkb.komposit.platform.vorschlag.projektion.vorschlag;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VorschlagDocumentRepository extends MongoRepository<VorschlagDocument, String> {
}

package de.vkb.komposit.platform.vorschlag.projections;

import org.springframework.stereotype.Repository;

@Repository
public interface VorschlagEntityRepository extends org.springframework.data.mongodb.repository.MongoRepository<VorschlagEntity, String> {

}

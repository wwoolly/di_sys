package ru.nsu.fit.kn.repository;


import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import ru.nsu.fit.kn.entity.HashStatus;


public interface HashRepository extends MongoRepository<HashStatus, String> {

    @Query("{uuid:'?0'}")
    HashStatus findStatusByUuid(String uuid);

    long count();
}
package ru.nsu.fit.kn.repository;

import ru.nsu.fit.kn.entity.HashStatus;

public interface CustomHashRepositoryInterface
{

    void registerHash(String uuid, Integer toDo);

    void commitHashUpdate(HashStatus status);
}

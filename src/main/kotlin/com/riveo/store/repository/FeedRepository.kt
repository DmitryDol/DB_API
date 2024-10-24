package com.riveo.store.repository

import com.riveo.store.entities.Feed
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

// Я перенес это класс внутрь пакета проекта
@MongoRepository
interface FeedRepository : CrudRepository<Feed, String>
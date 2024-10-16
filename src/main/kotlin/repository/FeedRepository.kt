package repository

import com.riveo.model.Feed
import io.micronaut.data.mongodb.annotation.MongoRepository
import io.micronaut.data.repository.CrudRepository

@MongoRepository
interface FeedRepository : CrudRepository<Feed, String>
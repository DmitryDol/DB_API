package com.riveo.feed.repository

import com.riveo.feed.model.Feed
import org.springframework.data.mongodb.repository.MongoRepository

interface FeedRepository : MongoRepository<Feed, String>
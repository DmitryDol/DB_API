package com.riveo.service

import com.riveo.model.Feed
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton
import repository.FeedRepository

@Singleton
class FeedService(
    private val feedRepository: FeedRepository
) {
    fun create(feed: Feed): Feed =
        feedRepository.save(feed)

    fun getAll(): List<Feed> =
        feedRepository.findAll()
            .toList()

    fun getById(id: String): Feed =
        feedRepository.findById(id)
            .orElseThrow { HttpStatusException(HttpStatus.NOT_FOUND, "Post with that id $id was not found.") }

    fun update(id: String, feed: Feed): Feed {
        val found = getById(id)
        val updated = feed.copy(id = found.id)
        return feedRepository.update(updated)
    }
}
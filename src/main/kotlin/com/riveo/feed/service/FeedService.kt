package com.riveo.feed.service

import com.riveo.feed.model.Feed
import org.springframework.http.HttpStatus
import org.springframework.stereotype.Service
import org.springframework.web.server.ResponseStatusException
import com.riveo.feed.repository.FeedRepository

@Service
class FeedService(
    private val feedRepository: FeedRepository
) {
    fun create(feed: Feed): Feed =
        feedRepository.save(feed)

    fun getAll(): List<Feed> =
        feedRepository.findAll().toList()

    fun getById(id: String): Feed =
        feedRepository.findById(id)
            .orElseThrow { ResponseStatusException(HttpStatus.NOT_FOUND, "Post with that id $id was not found.") }

    fun update(id: String, feed: Feed): Feed {
        val found = getById(id)
        val updated = feed.copy(id = found.id)
        return feedRepository.save(updated)
    }
}

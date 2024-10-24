package com.riveo.service

import com.riveo.store.entities.Feed
import io.micronaut.http.HttpStatus
import io.micronaut.http.exceptions.HttpStatusException
import jakarta.inject.Singleton
import com.riveo.store.repository.FeedRepository

//Не совсем понимаю, зачем тебе сервис, который содержит методы
//В одну строчку, можно просто импортировать Репозиторий с контроллер
//И все эту логику продолжить уже там
//Немного не понятен слой Сервисов (как по мне лишняя прослойка)
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

    // Разве нет какого-нибудь saveAndFlush()???
    fun update(id: String, feed: Feed): Feed {
        val found = getById(id)
        val updated = feed.copy(id = found.id)
        return feedRepository.update(updated)
    }
}
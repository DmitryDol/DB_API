package com.riveo.store.entities

import io.micronaut.data.annotation.GeneratedValue
import io.micronaut.data.annotation.Id
import io.micronaut.data.annotation.MappedEntity
import java.time.Instant

@MappedEntity
data class Feed(
    @field:Id
    @field:GeneratedValue
    val id: String? = null,
    val author_id: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    val date: Instant = Instant.now(),
    val comment: List<Comment>
)

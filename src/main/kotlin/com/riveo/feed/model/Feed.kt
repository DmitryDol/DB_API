package com.riveo.feed.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import java.time.Instant

@Document
data class Feed(
    @Id
    val id: String? = null,
    val author_id: String,
    val text: String?,
    val file_url: List<String>?,
    val like: List<String>?,
    val date: Instant = Instant.now(),
    val comment: List<Comment>?

)
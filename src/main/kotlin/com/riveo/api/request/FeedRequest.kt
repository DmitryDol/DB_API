package com.riveo.api.request

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.core.annotation.Introspected
import io.micronaut.serde.annotation.Serdeable
import java.time.Instant

@Introspected
@Serdeable
data class FeedRequest(
    val author_id: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant,
    val comment: List<CommentRequest>
)

@Serdeable
data class CommentRequest(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant,
    val re_comment: List<Re_commentRequest>
)

@Serdeable
data class Re_commentRequest(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant
)

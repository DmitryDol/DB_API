package com.riveo.feed.model.request

import com.fasterxml.jackson.annotation.JsonFormat

import java.time.Instant

// may need @data and
// @JsonSerialize
// @JsonDeserialize
data class FeedRequest(
    val author_id: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant = Instant.now(),
    val comment: List<CommentRequest>
)

data class CommentRequest(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant = Instant.now(),
    val re_comment: List<Re_commentRequest>
)

data class Re_commentRequest(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant = Instant.now()
)

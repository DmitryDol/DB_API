package com.riveo.store.entities

import com.fasterxml.jackson.annotation.JsonFormat
import io.micronaut.serde.annotation.Serdeable.Deserializable
import io.micronaut.serde.annotation.Serdeable.Serializable
import java.time.Instant

@Serializable
@Deserializable
data class Comment(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant = Instant.now(),
    val re_comment: List<Re_comment>
)


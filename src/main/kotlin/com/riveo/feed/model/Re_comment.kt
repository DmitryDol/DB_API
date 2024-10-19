package com.riveo.feed.model

import com.fasterxml.jackson.annotation.JsonFormat
import com.fasterxml.jackson.databind.annotation.JsonDeserialize
import com.fasterxml.jackson.databind.annotation.JsonSerialize
import java.time.Instant

@JsonSerialize
@JsonDeserialize
data class Re_comment(
    val author: String,
    val text: String,
    val file_url: List<String>,
    val like: List<String>,
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX", timezone = "UTC")
    val date: Instant = Instant.now()
)

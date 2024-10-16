package com.riveo.model.controller

import com.riveo.model.Comment
import com.riveo.model.Feed
import com.riveo.model.Re_comment
import com.riveo.model.request.FeedRequest
import com.riveo.service.FeedService
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.Body
import io.micronaut.http.annotation.Controller
import io.micronaut.http.annotation.Get
import io.micronaut.http.annotation.Header
import io.micronaut.http.annotation.Post
import io.micronaut.http.annotation.Put
import io.micronaut.http.annotation.Status

@Controller("/feed")
class FeedController(
    private val feedService: FeedService
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body feedRequest: FeedRequest) =
        feedService.create(
            feed = feedRequest.toModel()
        )

    @Get
    fun getAll() =
        feedService.getAll()

    @Get("/{id}")
    fun getById(id: String) =
        feedService.getById(id)

    @Put("/{id}")
    fun update(
        id: String,
        @Body request: FeedRequest,
        @Header("X-Foo") header: String?
    ): Feed {
        println("Updating feed with id: $id")
        println("Request: $request")
        println("Header: $header")
        return feedService.update(id, request.toModel())
    }

    private fun FeedRequest.toModel(): Feed {
        val comments = this.comment.map { comment ->
            Comment(
                author = comment.author,
                text = comment.text,
                file_url = comment.file_url.toList(),
                like = comment.like.toList(),
                date = comment.date,
                re_comment = comment.re_comment.map { reComment ->
                    Re_comment(
                        author = reComment.author,
                        text = reComment.text,
                        file_url = reComment.file_url.toList(),
                        like = reComment.like.toList(),
                        date = reComment.date
                    )
                }
            )
        }

        return Feed(
            author_id = this.author_id,
            text = this.text,
            file_url = this.file_url.toList(),
            like = this.like.toList(),
            date = this.date,
            comment = comments
        )
    }
}

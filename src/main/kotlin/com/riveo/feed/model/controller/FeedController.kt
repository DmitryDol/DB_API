package com.riveo.feed.model.controller

import com.riveo.feed.model.Comment
import com.riveo.feed.model.Feed
import com.riveo.feed.model.Re_comment
import com.riveo.feed.model.request.FeedRequest
import com.riveo.feed.service.FeedService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/feed")
class FeedController(
    private val feedService: FeedService
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun create(@RequestBody feedRequest: FeedRequest) =
        feedService.create(
            feed = feedRequest.toModel()
        )

    @GetMapping
    fun getAll() =
        feedService.getAll()

    @GetMapping("/{id}")
    fun getById(@PathVariable id: String) =
        feedService.getById(id)

    @PutMapping("/{id}")
    fun update(
        @PathVariable id: String,
        @RequestBody request: FeedRequest,
        @RequestHeader("X-Foo") header: String?
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

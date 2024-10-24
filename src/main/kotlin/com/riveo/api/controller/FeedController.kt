package com.riveo.api.controller

import com.riveo.api.request.FeedRequest
import com.riveo.service.FeedService
import com.riveo.store.entities.Comment
import com.riveo.store.entities.Feed
import com.riveo.store.entities.Re_comment
import io.micronaut.http.HttpStatus
import io.micronaut.http.annotation.*

//Неймин советую начинать с riveo/api/
//Ознакокомься с библиотекой Lombok
// @TODO(Lombok): @Getter и @Setter
@Controller("/riveo/api/feed")
class FeedController(
    private val feedService: FeedService
) {

    @Post
    @Status(HttpStatus.CREATED)
    fun create(@Body feedRequest: FeedRequest) =
        feedService.create(
            feed = feedRequest.toModel()
        )

    //Ну вот о чем я и говорил, у тебя тут появляется просто использование репозитория
    //Сервис тут не обязателен
    //Просто бесполезная обертка
    @Get
    fun getAll() =
        feedService.getAll()

    @Get("/{id}")
    fun getById(id: String) =
        feedService.getById(id)

    // Request param по-хорошему бы использовать
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

    //
    private fun FeedRequest.toModel(): Feed {
        //Перенеси все такие ответы в отдельные классы DTO ()
        //Это будет лучше читаться, и выглядеть понятнее
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

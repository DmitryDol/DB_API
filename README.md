src/main/resources/application.yml в 6 строке нужно указать строку для подключения к бд.  

Пример POST запроса:

```json
{
    "author_id": "some id",
    "text": "some shit post",
    "file_url": [
        "shitpost.png",
        "img.png"
    ],
    "like": [
        "user1",
        "user2",
        "user3"
    ],
    "comment": [
        {
            "author": "user1",
            "text": "comment1",
            "file_url": [
                "meme.png"
            ],
            "like": [
                "user1",
                "user2",
                "user3",
                "user4",
                "user5"
            ],
            "re_comment": [
                {
                    "author": "user2",
                    "text": "reply1",
                    "file_url": [
                        "cat.png"
                    ],
                    "like": [
                        "user1"
                    ]
                },
                {
                    "author": "user3",
                    "text": "reply2",
                    "file_url": [
                        "cat2.png"
                    ],
                    "like": [
                        "user1"
                    ]
                }
            ]
        }
    ]
}
```
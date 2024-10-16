src/main/resources/application.yml в 17 строке нужно указать строку для подключения к бд.  

Пример POST запроса:

```json
{
    "id": "670ea34b9c339f5f219bea91",
    "author_id": "some равid2",
    "text": "some shрвit post upd",
    "file_url": [
        "shitpost.png",
        "img.png"
    ],
    "like": [
        "usмer1",
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

делался по [этому](https://youtube.com/playlist?list=PLvN8k8yxjoetVCPwyc9KyS4zZMjD9X3do&si=t5x5eSk6Z9U-1nem) туториалу

package ru.netology.pusher
// на компе работает
import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream





fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)
    val token = "fQCRdk3rSEKuD-V_SuzdlM:APA91bG_yAWY3zoVhvZMH2evkA6COoj5BuXfd4X5TO5y9vmUwtwhXFPu2W5PY8MR3v1PfwWsZA5kPG6j0gzNsMA8AfzWqixU0tJRXYwX3Ix_b4xgtz4YDBKxl46LGrdFdjNVaIggkLhM"

    val message = Message.builder()
        .putData("action", "LIKE")
        .putData("content", """{
          "userId": 1,
          "userName": "Vasiliy",
          "postId": 2,
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(message)

    val messagePost = Message.builder()
        .putData("action", "POST")
        .putData("content", """{
          "userId": 2,
          "userName": "Aleksandr",
          "postId": "ривет всем!",
          "postAuthor": "Netology"
        }""".trimIndent())
        .setToken(token)
        .build()

    FirebaseMessaging.getInstance().send(messagePost)

}

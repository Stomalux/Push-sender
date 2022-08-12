package ru.netology.pusher

import com.google.auth.oauth2.GoogleCredentials
import com.google.firebase.FirebaseApp
import com.google.firebase.FirebaseOptions
import com.google.firebase.messaging.FirebaseMessaging
import com.google.firebase.messaging.Message
import java.io.FileInputStream


val token = "fQCRdk3rSEKuD-V_SuzdlM:APA91bG_yAWY3zoVhvZMH2evkA6COoj5BuXfd4X5TO5y9vmUwtwhXFPu2W5PY8MR3v1PfwWsZA5kPG6j0gzNsMA8AfzWqixU0tJRXYwX3Ix_b4xgtz4YDBKxl46LGrdFdjNVaIggkLhM"
// 1111222222222222222222222
//555555555
fun main() {
    val options = FirebaseOptions.builder()
        .setCredentials(GoogleCredentials.fromStream(FileInputStream("fcm.json")))
        .build()

    FirebaseApp.initializeApp(options)

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
}

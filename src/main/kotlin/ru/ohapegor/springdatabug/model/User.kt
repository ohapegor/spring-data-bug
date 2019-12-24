package ru.ohapegor.springdatabug.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document("users")
data class User (
    @Id
    val id: String = ObjectId().toHexString(),
    val name : String
)
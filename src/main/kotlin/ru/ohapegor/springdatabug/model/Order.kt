package ru.ohapegor.springdatabug.model

import org.bson.types.ObjectId
import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document
import org.springframework.data.mongodb.core.mapping.Field
import org.springframework.data.mongodb.core.mapping.FieldType

@Document("orders")
data class Order(
    @Id
    val id : String = ObjectId().toHexString(),

    val userId : String,

    @Field(targetType = FieldType.OBJECT_ID)
    val userObjectId : String = userId
)
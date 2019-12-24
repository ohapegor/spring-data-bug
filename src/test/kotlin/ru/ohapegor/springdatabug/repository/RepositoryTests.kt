package ru.ohapegor.springdatabug.repository

import org.bson.types.ObjectId
import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.data.mongodb.core.MongoTemplate
import org.springframework.data.mongodb.core.query.Criteria
import org.springframework.data.mongodb.core.query.Query
import ru.ohapegor.springdatabug.model.Order
import ru.ohapegor.springdatabug.model.User

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
class RepositoryTests @Autowired constructor(
    val orderRepo: OrderRepository,
    val userRepo: UserRepository,
    val mongoTemplate: MongoTemplate
) {

    @Test
    fun `verify in condition works by userId field`() {
        val user = userRepo.save(User(name = "John Doe"))
        val order = orderRepo.save(Order(userId = user.id))

        val foundOrder = mongoTemplate.findOne(
            //query example from logs : { "userId" : { "$in" : ["5e022598003eb818a151df3f", "5e022598003eb818a151df41"]}}
            Query.query(Criteria.where(Order::userId.name).`in`(user.id, ObjectId().toHexString())),
            Order::class.java
        )

        assertEquals(order, foundOrder)
    }

	@Test// Fails with MongoQueryException
	fun `verify in condition works by userObjectId field`() {
		val user = userRepo.save(User(name = "John Doe"))
		val order = orderRepo.save(Order(userId = user.id))

		val foundOrder = mongoTemplate.findOne(
            //query example from logs : to { "userObjectId" : { "$in" : { "$oid" : "5e022598003eb818a151df42"}}}
			Query.query(Criteria.where(Order::userObjectId.name).`in`(user.id, ObjectId().toHexString())),
			Order::class.java
		)

		assertEquals(order, foundOrder)
	}

}

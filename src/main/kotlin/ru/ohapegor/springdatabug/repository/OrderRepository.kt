package ru.ohapegor.springdatabug.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.ohapegor.springdatabug.model.Order
import ru.ohapegor.springdatabug.model.User

interface OrderRepository : MongoRepository<Order, String>

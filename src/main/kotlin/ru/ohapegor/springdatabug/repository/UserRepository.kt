package ru.ohapegor.springdatabug.repository

import org.springframework.data.mongodb.repository.MongoRepository
import ru.ohapegor.springdatabug.model.User

interface UserRepository : MongoRepository<User, String>

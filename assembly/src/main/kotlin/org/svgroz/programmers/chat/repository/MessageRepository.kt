package org.svgroz.programmers.chat.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.svgroz.programmers.chat.model.Message
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface MessageRepository {
    fun save(message: Message): Mono<Message>
    fun findByChannelId(channelId: Long): Flux<Message>
}

@Repository
interface MongoMessageRepository: MessageRepository, ReactiveMongoRepository<Message, String>
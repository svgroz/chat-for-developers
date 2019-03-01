package org.svgroz.programmers.chat.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.svgroz.programmers.chat.model.Message
import reactor.core.publisher.Flux

@Repository
interface MessageRepository: ReactiveMongoRepository<Message, String> {
    fun findByChannelId(channelId: Long): Flux<Message>
}
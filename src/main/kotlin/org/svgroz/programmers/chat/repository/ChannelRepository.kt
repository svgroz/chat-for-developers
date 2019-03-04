package org.svgroz.programmers.chat.repository

import org.springframework.data.mongodb.repository.ReactiveMongoRepository
import org.springframework.stereotype.Repository
import org.svgroz.programmers.chat.model.Channel
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

interface ChannelRepository {
    fun save(channel: Channel): Mono<Channel>
    fun findByMembers(userId: String): Flux<Channel>
}

@Repository
interface MongoChannelRepository: ReactiveMongoRepository<Channel, String>, ChannelRepository
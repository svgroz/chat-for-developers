package org.svgroz.programmers.chat.service

import org.springframework.stereotype.Service
import org.svgroz.programmers.chat.model.Channel
import org.svgroz.programmers.chat.repository.ChannelRepository
import org.svgroz.programmers.chat.view.ChannelVO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

interface ChannelService {
    fun save(channel: ChannelVO): Mono<ChannelVO>
    fun findByUserIdInMembers(userId: String): Flux<ChannelVO>
}

@Service
class ChannelServiceImpl(private val channelRepository: ChannelRepository) : ChannelService {
    override fun save(channel: ChannelVO): Mono<ChannelVO> {
        return channelRepository.save(Channel(id = null, name = channel.name, members = channel.members))
                .map { savedChannel -> ChannelVO(id = savedChannel.id, name = savedChannel.name, members = savedChannel.members) }
    }

    override fun findByUserIdInMembers(userId: String): Flux<ChannelVO> {
        return channelRepository.findByMembers(userId)
                .filter(Objects::nonNull)
                .map { channel -> ChannelVO(id = channel.id, name = channel.name, members = channel.members) }
    }
}

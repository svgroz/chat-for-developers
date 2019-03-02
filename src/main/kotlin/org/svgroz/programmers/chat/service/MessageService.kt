package org.svgroz.programmers.chat.service

import org.springframework.stereotype.Service
import org.svgroz.programmers.chat.model.Message
import org.svgroz.programmers.chat.view.MessageVO
import org.svgroz.programmers.chat.repository.MessageRepository
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.time.ZonedDateTime

interface MessageService {
    fun findByChannelId(channelId: Long): Flux<MessageVO>
    fun postMessage(message: MessageVO): Mono<MessageVO>
}

@Service
class MessageServiceImpl(private val messageRepository: MessageRepository) : MessageService {
    override fun findByChannelId(channelId: Long): Flux<MessageVO> {
        return messageRepository.findByChannelId(channelId)
                .map { message -> MessageVO(message.userId, message.channelId, message.text) }
    }

    override fun postMessage(message: MessageVO): Mono<MessageVO> {
        return messageRepository.save(Message(id = null, userId = message.userId, channelId = message.channelId, text = message.text, createdAt = ZonedDateTime.now().toEpochSecond()))
                .map { savedMessage -> MessageVO(savedMessage.userId, channelId = savedMessage.channelId, text = message.text) }
    }
}
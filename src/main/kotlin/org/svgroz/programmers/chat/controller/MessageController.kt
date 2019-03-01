package org.svgroz.programmers.chat.controller

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController
import org.svgroz.programmers.chat.dto.MessageDto
import org.svgroz.programmers.chat.dto.mapMessageToDto
import org.svgroz.programmers.chat.repository.MessageRepository
import reactor.core.publisher.Flux

@RestController
class MessageController(val messageRepository: MessageRepository) {
    @GetMapping("/message/channel/{id}")
    fun getMessageByChannelId(@PathVariable("id") channelId: Long): Flux<MessageDto> {
        return messageRepository.findByChannelId(channelId).map(::mapMessageToDto)
    }
}
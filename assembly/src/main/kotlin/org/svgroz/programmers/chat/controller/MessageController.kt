package org.svgroz.programmers.chat.controller

import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import org.svgroz.programmers.chat.dto.CreateMessageRequest
import org.svgroz.programmers.chat.dto.GetMessageResponse
import org.svgroz.programmers.chat.service.MessageService
import org.svgroz.programmers.chat.view.MessageVO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
class MessageController(val messageService: MessageService) {
    @GetMapping("/message/channel/{id}")
    fun getMessageByChannelId(@PathVariable("id") channelId: Long): Flux<GetMessageResponse> {
        return messageService.findByChannelId(channelId)
                .map { messageVO -> GetMessageResponse(messageVO.userId, messageVO.text) }
    }

    @PostMapping("/message/channel/{id}")
    fun postMessageToChannelWithId(@PathVariable("id") channelId: Long, @RequestBody() request: CreateMessageRequest): Mono<ResponseEntity<*>> {
        return messageService.saveMessage(MessageVO(userId = request.userId, channelId = channelId, text = request.text))
                .map { ResponseEntity.status(HttpStatus.CREATED).build<Any>() }
    }
}

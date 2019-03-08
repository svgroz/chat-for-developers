package org.svgroz.programmers.chat.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.svgroz.programmers.chat.dto.CreateChannelRequest
import org.svgroz.programmers.chat.dto.CreateChannelResponse
import org.svgroz.programmers.chat.service.ChannelService
import org.svgroz.programmers.chat.view.ChannelVO
import reactor.core.publisher.Mono

@RestController
@RequestMapping(path = ["/api/channel"])
class ChannelController(private val channelService: ChannelService) {
    @PostMapping(path = ["/create"], produces = [MediaType.APPLICATION_JSON_UTF8_VALUE])
    fun createChannel(@RequestBody request: CreateChannelRequest): Mono<CreateChannelResponse> {
        return channelService.save(ChannelVO(name = request.name, members = request.members))
                .map { savedChannel -> CreateChannelResponse(savedChannel.id!!) }
    }
}

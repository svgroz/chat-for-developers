package org.svgroz.programmers.chat.controller

import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*
import org.svgroz.programmers.chat.dto.CreateChannelRequest
import org.svgroz.programmers.chat.dto.CreateChannelResponse
import org.svgroz.programmers.chat.dto.UserChannel
import org.svgroz.programmers.chat.service.ChannelService
import org.svgroz.programmers.chat.view.ChannelVO
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping(path = ["/api/channel"])
class ChannelController(private val channelService: ChannelService) {
    @PostMapping(path = ["/create"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createChannel(@RequestBody request: CreateChannelRequest): Mono<CreateChannelResponse> {
        return channelService.save(ChannelVO(name = request.name, members = request.members + request.userId))
                .map { savedChannel -> CreateChannelResponse(savedChannel.id!!) }
    }

    @GetMapping(path = ["/list"], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getUserChannels(@RequestParam("userId") userId: String): Flux<UserChannel> {
        return channelService.findByUserIdInMembers(userId)
                .map { channel -> UserChannel(channelId = channel.id!!, name = channel.name) }
    }
}

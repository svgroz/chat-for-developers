package org.svgroz.programmers.chat.dto

data class GetUserChannelsResponse(val channelsIdAndName: Map<String, String>)

data class CreateChannelRequest(val name: String, val members: Set<String>)
data class CreateChannelResponse(val channelId: String)

data class AddMemberToChannelRequest(val memberId: String, val channelId: String)

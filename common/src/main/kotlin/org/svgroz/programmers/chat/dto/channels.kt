package org.svgroz.programmers.chat.dto

data class UserChannel(val channelId: String, val name: String)

data class CreateChannelRequest(val userId: String, val name: String, val members: Set<String>)
data class CreateChannelResponse(val channelId: String)

data class AddMemberToChannelRequest(val userId: String, val memberId: String, val channelId: String)

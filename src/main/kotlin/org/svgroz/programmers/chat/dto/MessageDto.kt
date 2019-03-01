package org.svgroz.programmers.chat.dto

import org.svgroz.programmers.chat.model.Message

data class MessageDto(val id: String, val channelId: Long, val text: String)

fun mapMessageToDto(message: Message): MessageDto {
    return MessageDto(message.id, message.channelId, message.text)
}
package org.svgroz.programmers.chat.view

import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "message")
data class MessageVO(val userId: String, val channelId: Long, val text: String)
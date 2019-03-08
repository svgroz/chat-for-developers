package org.svgroz.programmers.chat.model

import org.springframework.data.annotation.Id
import org.springframework.data.mongodb.core.mapping.Document

@Document(collection = "channels") data class Channel(@Id val id: String?, val name: String, val members: Set<String>)
@Document(collection = "messages") data class Message(@Id val id: String?, val userId: String, val channelId: Long, val text: String, val createdAt: Long)

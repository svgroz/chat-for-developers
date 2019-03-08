package org.svgroz.programmers.chat.view

data class MessageVO(val id: String? = null, val userId: String, val channelId: Long, val text: String)
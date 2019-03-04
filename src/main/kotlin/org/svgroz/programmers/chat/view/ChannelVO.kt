package org.svgroz.programmers.chat.view

data class ChannelVO(val id: String? = null, val name: String, val members: Set<String>)
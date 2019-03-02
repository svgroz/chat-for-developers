package org.svgroz.programmers.chat.dto

class CreateMessageRequest(val userId: String, val text: String)
class GetMessageResponse(val userId: String, val text: String)

package org.svgroz.programmers.chat

import org.junit.After
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.svgroz.programmers.chat.repository.MongoChannelRepository
import org.svgroz.programmers.chat.repository.MongoMessageRepository
import org.svgroz.programmers.chat.view.MessageVO
import java.util.*

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
@ActiveProfiles("development")
class ChatApplicationTests {

	@Autowired
	private lateinit var webTestClient: WebTestClient

	@Autowired
	private lateinit var channelRepository: MongoChannelRepository

	@Autowired
	private lateinit var messageRepository: MongoMessageRepository

	@After
	fun after() {
		channelRepository.deleteAll().block()
		messageRepository.deleteAll().block()
	}

	@Test
	fun contextLoads() {
		webTestClient.post().uri("/message/channel/1")
				.syncBody(MessageVO(userId = UUID.randomUUID().toString(), channelId = 1, text = "Hello mongo and rest"))
				.exchange()
				.expectStatus().is2xxSuccessful
	}
}

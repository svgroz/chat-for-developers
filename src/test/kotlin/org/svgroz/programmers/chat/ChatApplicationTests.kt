package org.svgroz.programmers.chat

import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner
import org.springframework.test.web.reactive.server.WebTestClient
import org.svgroz.programmers.chat.view.MessageVO

@RunWith(SpringRunner::class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class ChatApplicationTests {

	@Autowired
	private lateinit var webTestClient: WebTestClient

	@Test
	fun contextLoads() {
		webTestClient.post().uri("/message/channel/1")
				.syncBody(MessageVO(channelId = 1, text = "Hello mongo and rest"))
				.exchange()
				.expectStatus().is2xxSuccessful
	}
}

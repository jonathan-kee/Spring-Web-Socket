package com.socket.demo;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.messaging.Message;
import org.springframework.messaging.simp.stomp.StompCommand;
import org.springframework.messaging.simp.stomp.StompHeaderAccessor;
import org.springframework.messaging.support.AbstractSubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;

import java.util.HashMap;

/**
 * Tests for PortfolioController that rely on the Spring TestContext framework to
 * load the actual Spring configuration. The test strategy here is to test the
 * behavior of controllers using the actual Spring configuration while using
 * the TestContext framework ensures that Spring configuration is loaded only
 * once per test class.
 *
 * <p>The test manually creates messages representing STOMP frames and sends them
 * to the "clientInboundChannel" simulating clients by setting the session id and
 * user headers of the message accordingly.
 *
 * <p>Test ChannelInterceptor implementations are installed on the "brokerChannel"
 * and the "clientOutboundChannel" in order to capture messages sent through
 * them. Although not the case here, often a controller method will
 * not send any messages at all. In such cases it might be necessary to inject
 * the controller with "mock" services in order to verify message handling.
 *
 * <p>Note the (optional) use of TestConfig, which removes MessageHandler
 * subscriptions to message channels except the handler that delegates to
 * annotated controller methods. This allows focusing on controllers.
 *
 * @author Rossen Stoyanchev
 */

@SpringBootTest
class DemoApplicationTests {



}

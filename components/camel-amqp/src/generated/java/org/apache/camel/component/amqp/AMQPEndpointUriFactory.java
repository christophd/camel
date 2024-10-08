/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.amqp;

import javax.annotation.processing.Generated;
import java.net.URISyntaxException;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import org.apache.camel.spi.EndpointUriFactory;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.GenerateEndpointUriFactoryMojo")
public class AMQPEndpointUriFactory extends org.apache.camel.support.component.EndpointUriFactorySupport implements EndpointUriFactory {

    private static final String BASE = ":destinationType:destinationName";

    private static final Set<String> PROPERTY_NAMES;
    private static final Set<String> SECRET_PROPERTY_NAMES;
    private static final Set<String> MULTI_VALUE_PREFIXES;
    static {
        Set<String> props = new HashSet<>(103);
        props.add("acceptMessagesWhileStopping");
        props.add("acknowledgementModeName");
        props.add("allowAdditionalHeaders");
        props.add("allowNullBody");
        props.add("allowReplyManagerQuickStop");
        props.add("allowSerializedHeaders");
        props.add("alwaysCopyMessage");
        props.add("artemisConsumerPriority");
        props.add("artemisStreamingEnabled");
        props.add("asyncConsumer");
        props.add("asyncStartListener");
        props.add("asyncStopListener");
        props.add("autoStartup");
        props.add("browseLimit");
        props.add("cacheLevel");
        props.add("cacheLevelName");
        props.add("clientId");
        props.add("concurrentConsumers");
        props.add("connectionFactory");
        props.add("consumerType");
        props.add("correlationProperty");
        props.add("defaultTaskExecutorType");
        props.add("deliveryDelay");
        props.add("deliveryMode");
        props.add("deliveryPersistent");
        props.add("destinationName");
        props.add("destinationResolver");
        props.add("destinationType");
        props.add("disableReplyTo");
        props.add("disableTimeToLive");
        props.add("durableSubscriptionName");
        props.add("eagerLoadingOfProperties");
        props.add("eagerPoisonBody");
        props.add("errorHandler");
        props.add("errorHandlerLogStackTrace");
        props.add("errorHandlerLoggingLevel");
        props.add("exceptionHandler");
        props.add("exceptionListener");
        props.add("exchangePattern");
        props.add("explicitQosEnabled");
        props.add("exposeListenerSession");
        props.add("forceSendOriginalMessage");
        props.add("formatDateHeadersToIso8601");
        props.add("headerFilterStrategy");
        props.add("idleConsumerLimit");
        props.add("idleReceivesPerTaskLimit");
        props.add("idleTaskExecutionLimit");
        props.add("includeAllJMSXProperties");
        props.add("includeSentJMSMessageID");
        props.add("jmsKeyFormatStrategy");
        props.add("jmsMessageType");
        props.add("lazyCreateTransactionManager");
        props.add("lazyStartProducer");
        props.add("mapJmsMessage");
        props.add("maxConcurrentConsumers");
        props.add("maxMessagesPerTask");
        props.add("messageConverter");
        props.add("messageCreatedStrategy");
        props.add("messageIdEnabled");
        props.add("messageListenerContainerFactory");
        props.add("messageTimestampEnabled");
        props.add("password");
        props.add("preserveMessageQos");
        props.add("priority");
        props.add("pubSubNoLocal");
        props.add("receiveTimeout");
        props.add("recoveryInterval");
        props.add("replyTo");
        props.add("replyToCacheLevelName");
        props.add("replyToConcurrentConsumers");
        props.add("replyToConsumerType");
        props.add("replyToDeliveryPersistent");
        props.add("replyToDestinationSelectorName");
        props.add("replyToMaxConcurrentConsumers");
        props.add("replyToOnTimeoutMaxConcurrentConsumers");
        props.add("replyToOverride");
        props.add("replyToSameDestinationAllowed");
        props.add("replyToType");
        props.add("requestTimeout");
        props.add("requestTimeoutCheckerInterval");
        props.add("selector");
        props.add("streamMessageTypeEnabled");
        props.add("subscriptionDurable");
        props.add("subscriptionName");
        props.add("subscriptionShared");
        props.add("synchronous");
        props.add("taskExecutor");
        props.add("temporaryQueueResolver");
        props.add("testConnectionOnStartup");
        props.add("timeToLive");
        props.add("transacted");
        props.add("transactedInOut");
        props.add("transactionManager");
        props.add("transactionName");
        props.add("transactionTimeout");
        props.add("transferException");
        props.add("transferExchange");
        props.add("useMessageIDAsCorrelationID");
        props.add("username");
        props.add("waitForProvisionCorrelationToBeUpdatedCounter");
        props.add("waitForProvisionCorrelationToBeUpdatedThreadSleepingTime");
        props.add("waitForTemporaryReplyToToBeUpdatedCounter");
        props.add("waitForTemporaryReplyToToBeUpdatedThreadSleepingTime");
        PROPERTY_NAMES = Collections.unmodifiableSet(props);
        Set<String> secretProps = new HashSet<>(2);
        secretProps.add("password");
        secretProps.add("username");
        SECRET_PROPERTY_NAMES = Collections.unmodifiableSet(secretProps);
        MULTI_VALUE_PREFIXES = Collections.emptySet();
    }

    @Override
    public boolean isEnabled(String scheme) {
        return "amqp".equals(scheme);
    }

    @Override
    public String buildUri(String scheme, Map<String, Object> properties, boolean encode) throws URISyntaxException {
        String syntax = scheme + BASE;
        String uri = syntax;

        Map<String, Object> copy = new HashMap<>(properties);

        uri = buildPathParameter(syntax, uri, "destinationType", "queue", false, copy);
        uri = buildPathParameter(syntax, uri, "destinationName", null, true, copy);
        uri = buildQueryParameters(uri, copy, encode);
        return uri;
    }

    @Override
    public Set<String> propertyNames() {
        return PROPERTY_NAMES;
    }

    @Override
    public Set<String> secretPropertyNames() {
        return SECRET_PROPERTY_NAMES;
    }

    @Override
    public Set<String> multiValuePrefixes() {
        return MULTI_VALUE_PREFIXES;
    }

    @Override
    public boolean isLenientProperties() {
        return false;
    }
}


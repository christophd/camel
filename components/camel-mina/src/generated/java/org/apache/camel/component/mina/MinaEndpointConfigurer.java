/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.mina;

import javax.annotation.processing.Generated;
import java.util.Map;

import org.apache.camel.CamelContext;
import org.apache.camel.spi.ExtendedPropertyConfigurerGetter;
import org.apache.camel.spi.PropertyConfigurerGetter;
import org.apache.camel.spi.ConfigurerStrategy;
import org.apache.camel.spi.GeneratedPropertyConfigurer;
import org.apache.camel.util.CaseInsensitiveMap;
import org.apache.camel.support.component.PropertyConfigurerSupport;

/**
 * Generated by camel build tools - do NOT edit this file!
 */
@Generated("org.apache.camel.maven.packaging.EndpointSchemaGeneratorMojo")
@SuppressWarnings("unchecked")
public class MinaEndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        MinaEndpoint target = (MinaEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "allowdefaultcodec":
        case "allowDefaultCodec": target.getConfiguration().setAllowDefaultCodec(property(camelContext, boolean.class, value)); return true;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "cachedaddress":
        case "cachedAddress": target.getConfiguration().setCachedAddress(property(camelContext, boolean.class, value)); return true;
        case "clientmode":
        case "clientMode": target.getConfiguration().setClientMode(property(camelContext, boolean.class, value)); return true;
        case "codec": target.getConfiguration().setCodec(property(camelContext, org.apache.mina.filter.codec.ProtocolCodecFactory.class, value)); return true;
        case "decodermaxlinelength":
        case "decoderMaxLineLength": target.getConfiguration().setDecoderMaxLineLength(property(camelContext, int.class, value)); return true;
        case "disconnect": target.getConfiguration().setDisconnect(property(camelContext, boolean.class, value)); return true;
        case "disconnectonnoreply":
        case "disconnectOnNoReply": target.getConfiguration().setDisconnectOnNoReply(property(camelContext, boolean.class, value)); return true;
        case "encodermaxlinelength":
        case "encoderMaxLineLength": target.getConfiguration().setEncoderMaxLineLength(property(camelContext, int.class, value)); return true;
        case "encoding": target.getConfiguration().setEncoding(property(camelContext, java.lang.String.class, value)); return true;
        case "exceptionhandler":
        case "exceptionHandler": target.setExceptionHandler(property(camelContext, org.apache.camel.spi.ExceptionHandler.class, value)); return true;
        case "exchangepattern":
        case "exchangePattern": target.setExchangePattern(property(camelContext, org.apache.camel.ExchangePattern.class, value)); return true;
        case "filters": target.getConfiguration().setFilters(property(camelContext, java.util.List.class, value)); return true;
        case "lazysessioncreation":
        case "lazySessionCreation": target.getConfiguration().setLazySessionCreation(property(camelContext, boolean.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "maximumpoolsize":
        case "maximumPoolSize": target.getConfiguration().setMaximumPoolSize(property(camelContext, int.class, value)); return true;
        case "minalogger":
        case "minaLogger": target.getConfiguration().setMinaLogger(property(camelContext, boolean.class, value)); return true;
        case "noreplyloglevel":
        case "noReplyLogLevel": target.getConfiguration().setNoReplyLogLevel(property(camelContext, org.apache.camel.LoggingLevel.class, value)); return true;
        case "objectcodecpattern":
        case "objectCodecPattern": target.getConfiguration().setObjectCodecPattern(property(camelContext, java.lang.String.class, value)); return true;
        case "orderedthreadpoolexecutor":
        case "orderedThreadPoolExecutor": target.getConfiguration().setOrderedThreadPoolExecutor(property(camelContext, boolean.class, value)); return true;
        case "sslcontextparameters":
        case "sslContextParameters": target.getConfiguration().setSslContextParameters(property(camelContext, org.apache.camel.support.jsse.SSLContextParameters.class, value)); return true;
        case "sync": target.getConfiguration().setSync(property(camelContext, boolean.class, value)); return true;
        case "textline": target.getConfiguration().setTextline(property(camelContext, boolean.class, value)); return true;
        case "textlinedelimiter":
        case "textlineDelimiter": target.getConfiguration().setTextlineDelimiter(property(camelContext, org.apache.camel.component.mina.MinaTextLineDelimiter.class, value)); return true;
        case "timeout": target.getConfiguration().setTimeout(property(camelContext, long.class, value)); return true;
        case "transferexchange":
        case "transferExchange": target.getConfiguration().setTransferExchange(property(camelContext, boolean.class, value)); return true;
        case "writetimeout":
        case "writeTimeout": target.getConfiguration().setWriteTimeout(property(camelContext, long.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "allowdefaultcodec":
        case "allowDefaultCodec": return boolean.class;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return boolean.class;
        case "cachedaddress":
        case "cachedAddress": return boolean.class;
        case "clientmode":
        case "clientMode": return boolean.class;
        case "codec": return org.apache.mina.filter.codec.ProtocolCodecFactory.class;
        case "decodermaxlinelength":
        case "decoderMaxLineLength": return int.class;
        case "disconnect": return boolean.class;
        case "disconnectonnoreply":
        case "disconnectOnNoReply": return boolean.class;
        case "encodermaxlinelength":
        case "encoderMaxLineLength": return int.class;
        case "encoding": return java.lang.String.class;
        case "exceptionhandler":
        case "exceptionHandler": return org.apache.camel.spi.ExceptionHandler.class;
        case "exchangepattern":
        case "exchangePattern": return org.apache.camel.ExchangePattern.class;
        case "filters": return java.util.List.class;
        case "lazysessioncreation":
        case "lazySessionCreation": return boolean.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "maximumpoolsize":
        case "maximumPoolSize": return int.class;
        case "minalogger":
        case "minaLogger": return boolean.class;
        case "noreplyloglevel":
        case "noReplyLogLevel": return org.apache.camel.LoggingLevel.class;
        case "objectcodecpattern":
        case "objectCodecPattern": return java.lang.String.class;
        case "orderedthreadpoolexecutor":
        case "orderedThreadPoolExecutor": return boolean.class;
        case "sslcontextparameters":
        case "sslContextParameters": return org.apache.camel.support.jsse.SSLContextParameters.class;
        case "sync": return boolean.class;
        case "textline": return boolean.class;
        case "textlinedelimiter":
        case "textlineDelimiter": return org.apache.camel.component.mina.MinaTextLineDelimiter.class;
        case "timeout": return long.class;
        case "transferexchange":
        case "transferExchange": return boolean.class;
        case "writetimeout":
        case "writeTimeout": return long.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        MinaEndpoint target = (MinaEndpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "allowdefaultcodec":
        case "allowDefaultCodec": return target.getConfiguration().isAllowDefaultCodec();
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "cachedaddress":
        case "cachedAddress": return target.getConfiguration().isCachedAddress();
        case "clientmode":
        case "clientMode": return target.getConfiguration().isClientMode();
        case "codec": return target.getConfiguration().getCodec();
        case "decodermaxlinelength":
        case "decoderMaxLineLength": return target.getConfiguration().getDecoderMaxLineLength();
        case "disconnect": return target.getConfiguration().isDisconnect();
        case "disconnectonnoreply":
        case "disconnectOnNoReply": return target.getConfiguration().isDisconnectOnNoReply();
        case "encodermaxlinelength":
        case "encoderMaxLineLength": return target.getConfiguration().getEncoderMaxLineLength();
        case "encoding": return target.getConfiguration().getEncoding();
        case "exceptionhandler":
        case "exceptionHandler": return target.getExceptionHandler();
        case "exchangepattern":
        case "exchangePattern": return target.getExchangePattern();
        case "filters": return target.getConfiguration().getFilters();
        case "lazysessioncreation":
        case "lazySessionCreation": return target.getConfiguration().isLazySessionCreation();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "maximumpoolsize":
        case "maximumPoolSize": return target.getConfiguration().getMaximumPoolSize();
        case "minalogger":
        case "minaLogger": return target.getConfiguration().isMinaLogger();
        case "noreplyloglevel":
        case "noReplyLogLevel": return target.getConfiguration().getNoReplyLogLevel();
        case "objectcodecpattern":
        case "objectCodecPattern": return target.getConfiguration().getObjectCodecPattern();
        case "orderedthreadpoolexecutor":
        case "orderedThreadPoolExecutor": return target.getConfiguration().isOrderedThreadPoolExecutor();
        case "sslcontextparameters":
        case "sslContextParameters": return target.getConfiguration().getSslContextParameters();
        case "sync": return target.getConfiguration().isSync();
        case "textline": return target.getConfiguration().isTextline();
        case "textlinedelimiter":
        case "textlineDelimiter": return target.getConfiguration().getTextlineDelimiter();
        case "timeout": return target.getConfiguration().getTimeout();
        case "transferexchange":
        case "transferExchange": return target.getConfiguration().isTransferExchange();
        case "writetimeout":
        case "writeTimeout": return target.getConfiguration().getWriteTimeout();
        default: return null;
        }
    }

    @Override
    public Object getCollectionValueType(Object target, String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "filters": return org.apache.mina.core.filterchain.IoFilter.class;
        default: return null;
        }
    }
}


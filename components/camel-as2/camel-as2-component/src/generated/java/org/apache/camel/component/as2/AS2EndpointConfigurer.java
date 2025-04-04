/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.as2;

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
public class AS2EndpointConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, ExtendedPropertyConfigurerGetter {

    private static final Map<String, Object> ALL_OPTIONS;
    static {
        Map<String, Object> map = new CaseInsensitiveMap();
        map.put("ApiName", org.apache.camel.component.as2.internal.AS2ApiName.class);
        map.put("MethodName", java.lang.String.class);
        map.put("As2From", java.lang.String.class);
        map.put("As2MessageStructure", org.apache.camel.component.as2.api.AS2MessageStructure.class);
        map.put("As2To", java.lang.String.class);
        map.put("As2Version", java.lang.String.class);
        map.put("AsyncMdnPortNumber", java.lang.Integer.class);
        map.put("AttachedFileName", java.lang.String.class);
        map.put("ClientFqdn", java.lang.String.class);
        map.put("CompressionAlgorithm", org.apache.camel.component.as2.api.AS2CompressionAlgorithm.class);
        map.put("DispositionNotificationTo", java.lang.String.class);
        map.put("EdiMessageCharset", java.lang.String.class);
        map.put("EdiMessageTransferEncoding", java.lang.String.class);
        map.put("EdiMessageType", java.lang.String.class);
        map.put("From", java.lang.String.class);
        map.put("HttpConnectionPoolSize", java.lang.Integer.class);
        map.put("HttpConnectionPoolTtl", java.time.Duration.class);
        map.put("HttpConnectionTimeout", java.time.Duration.class);
        map.put("HttpSocketTimeout", java.time.Duration.class);
        map.put("InBody", java.lang.String.class);
        map.put("MdnMessageTemplate", java.lang.String.class);
        map.put("ReceiptDeliveryOption", java.lang.String.class);
        map.put("RequestUri", java.lang.String.class);
        map.put("Server", java.lang.String.class);
        map.put("ServerFqdn", java.lang.String.class);
        map.put("ServerPortNumber", java.lang.Integer.class);
        map.put("Subject", java.lang.String.class);
        map.put("TargetHostname", java.lang.String.class);
        map.put("TargetPortNumber", java.lang.Integer.class);
        map.put("UserAgent", java.lang.String.class);
        map.put("ExceptionHandler", org.apache.camel.spi.ExceptionHandler.class);
        map.put("ExchangePattern", org.apache.camel.ExchangePattern.class);
        map.put("LazyStartProducer", boolean.class);
        map.put("AccessToken", java.lang.String.class);
        map.put("DecryptingPrivateKey", java.security.PrivateKey.class);
        map.put("EncryptingAlgorithm", org.apache.camel.component.as2.api.AS2EncryptionAlgorithm.class);
        map.put("EncryptingCertificateChain", java.security.cert.Certificate[].class);
        map.put("HostnameVerifier", javax.net.ssl.HostnameVerifier.class);
        map.put("MdnAccessToken", java.lang.String.class);
        map.put("MdnPassword", java.lang.String.class);
        map.put("MdnUserName", java.lang.String.class);
        map.put("Password", java.lang.String.class);
        map.put("SignedReceiptMicAlgorithms", java.lang.String.class);
        map.put("SigningAlgorithm", org.apache.camel.component.as2.api.AS2SignatureAlgorithm.class);
        map.put("SigningCertificateChain", java.security.cert.Certificate[].class);
        map.put("SigningPrivateKey", java.security.PrivateKey.class);
        map.put("SslContext", javax.net.ssl.SSLContext.class);
        map.put("UserName", java.lang.String.class);
        map.put("ValidateSigningCertificateChain", java.security.cert.Certificate[].class);
        ALL_OPTIONS = map;
    }

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        AS2Endpoint target = (AS2Endpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesstoken":
        case "accessToken": target.getConfiguration().setAccessToken(property(camelContext, java.lang.String.class, value)); return true;
        case "as2from":
        case "as2From": target.getConfiguration().setAs2From(property(camelContext, java.lang.String.class, value)); return true;
        case "as2messagestructure":
        case "as2MessageStructure": target.getConfiguration().setAs2MessageStructure(property(camelContext, org.apache.camel.component.as2.api.AS2MessageStructure.class, value)); return true;
        case "as2to":
        case "as2To": target.getConfiguration().setAs2To(property(camelContext, java.lang.String.class, value)); return true;
        case "as2version":
        case "as2Version": target.getConfiguration().setAs2Version(property(camelContext, java.lang.String.class, value)); return true;
        case "asyncmdnportnumber":
        case "asyncMdnPortNumber": target.getConfiguration().setAsyncMdnPortNumber(property(camelContext, java.lang.Integer.class, value)); return true;
        case "attachedfilename":
        case "attachedFileName": target.getConfiguration().setAttachedFileName(property(camelContext, java.lang.String.class, value)); return true;
        case "clientfqdn":
        case "clientFqdn": target.getConfiguration().setClientFqdn(property(camelContext, java.lang.String.class, value)); return true;
        case "compressionalgorithm":
        case "compressionAlgorithm": target.getConfiguration().setCompressionAlgorithm(property(camelContext, org.apache.camel.component.as2.api.AS2CompressionAlgorithm.class, value)); return true;
        case "decryptingprivatekey":
        case "decryptingPrivateKey": target.getConfiguration().setDecryptingPrivateKey(property(camelContext, java.security.PrivateKey.class, value)); return true;
        case "dispositionnotificationto":
        case "dispositionNotificationTo": target.getConfiguration().setDispositionNotificationTo(property(camelContext, java.lang.String.class, value)); return true;
        case "edimessagecharset":
        case "ediMessageCharset": target.getConfiguration().setEdiMessageCharset(property(camelContext, java.lang.String.class, value)); return true;
        case "edimessagetransferencoding":
        case "ediMessageTransferEncoding": target.getConfiguration().setEdiMessageTransferEncoding(property(camelContext, java.lang.String.class, value)); return true;
        case "edimessagetype":
        case "ediMessageType": target.getConfiguration().setEdiMessageType(property(camelContext, java.lang.String.class, value)); return true;
        case "encryptingalgorithm":
        case "encryptingAlgorithm": target.getConfiguration().setEncryptingAlgorithm(property(camelContext, org.apache.camel.component.as2.api.AS2EncryptionAlgorithm.class, value)); return true;
        case "encryptingcertificatechain":
        case "encryptingCertificateChain": target.getConfiguration().setEncryptingCertificateChain(property(camelContext, java.security.cert.Certificate[].class, value)); return true;
        case "exceptionhandler":
        case "exceptionHandler": target.setExceptionHandler(property(camelContext, org.apache.camel.spi.ExceptionHandler.class, value)); return true;
        case "exchangepattern":
        case "exchangePattern": target.setExchangePattern(property(camelContext, org.apache.camel.ExchangePattern.class, value)); return true;
        case "from": target.getConfiguration().setFrom(property(camelContext, java.lang.String.class, value)); return true;
        case "hostnameverifier":
        case "hostnameVerifier": target.getConfiguration().setHostnameVerifier(property(camelContext, javax.net.ssl.HostnameVerifier.class, value)); return true;
        case "httpconnectionpoolsize":
        case "httpConnectionPoolSize": target.getConfiguration().setHttpConnectionPoolSize(property(camelContext, java.lang.Integer.class, value)); return true;
        case "httpconnectionpoolttl":
        case "httpConnectionPoolTtl": target.getConfiguration().setHttpConnectionPoolTtl(property(camelContext, java.time.Duration.class, value)); return true;
        case "httpconnectiontimeout":
        case "httpConnectionTimeout": target.getConfiguration().setHttpConnectionTimeout(property(camelContext, java.time.Duration.class, value)); return true;
        case "httpsockettimeout":
        case "httpSocketTimeout": target.getConfiguration().setHttpSocketTimeout(property(camelContext, java.time.Duration.class, value)); return true;
        case "inbody":
        case "inBody": target.setInBody(property(camelContext, java.lang.String.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "mdnaccesstoken":
        case "mdnAccessToken": target.getConfiguration().setMdnAccessToken(property(camelContext, java.lang.String.class, value)); return true;
        case "mdnmessagetemplate":
        case "mdnMessageTemplate": target.getConfiguration().setMdnMessageTemplate(property(camelContext, java.lang.String.class, value)); return true;
        case "mdnpassword":
        case "mdnPassword": target.getConfiguration().setMdnPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "mdnusername":
        case "mdnUserName": target.getConfiguration().setMdnUserName(property(camelContext, java.lang.String.class, value)); return true;
        case "password": target.getConfiguration().setPassword(property(camelContext, java.lang.String.class, value)); return true;
        case "receiptdeliveryoption":
        case "receiptDeliveryOption": target.getConfiguration().setReceiptDeliveryOption(property(camelContext, java.lang.String.class, value)); return true;
        case "requesturi":
        case "requestUri": target.getConfiguration().setRequestUri(property(camelContext, java.lang.String.class, value)); return true;
        case "server": target.getConfiguration().setServer(property(camelContext, java.lang.String.class, value)); return true;
        case "serverfqdn":
        case "serverFqdn": target.getConfiguration().setServerFqdn(property(camelContext, java.lang.String.class, value)); return true;
        case "serverportnumber":
        case "serverPortNumber": target.getConfiguration().setServerPortNumber(property(camelContext, java.lang.Integer.class, value)); return true;
        case "signedreceiptmicalgorithms":
        case "signedReceiptMicAlgorithms": target.getConfiguration().setSignedReceiptMicAlgorithms(property(camelContext, java.lang.String.class, value)); return true;
        case "signingalgorithm":
        case "signingAlgorithm": target.getConfiguration().setSigningAlgorithm(property(camelContext, org.apache.camel.component.as2.api.AS2SignatureAlgorithm.class, value)); return true;
        case "signingcertificatechain":
        case "signingCertificateChain": target.getConfiguration().setSigningCertificateChain(property(camelContext, java.security.cert.Certificate[].class, value)); return true;
        case "signingprivatekey":
        case "signingPrivateKey": target.getConfiguration().setSigningPrivateKey(property(camelContext, java.security.PrivateKey.class, value)); return true;
        case "sslcontext":
        case "sslContext": target.getConfiguration().setSslContext(property(camelContext, javax.net.ssl.SSLContext.class, value)); return true;
        case "subject": target.getConfiguration().setSubject(property(camelContext, java.lang.String.class, value)); return true;
        case "targethostname":
        case "targetHostname": target.getConfiguration().setTargetHostname(property(camelContext, java.lang.String.class, value)); return true;
        case "targetportnumber":
        case "targetPortNumber": target.getConfiguration().setTargetPortNumber(property(camelContext, java.lang.Integer.class, value)); return true;
        case "useragent":
        case "userAgent": target.getConfiguration().setUserAgent(property(camelContext, java.lang.String.class, value)); return true;
        case "username":
        case "userName": target.getConfiguration().setUserName(property(camelContext, java.lang.String.class, value)); return true;
        case "validatesigningcertificatechain":
        case "validateSigningCertificateChain": target.getConfiguration().setValidateSigningCertificateChain(property(camelContext, java.security.cert.Certificate[].class, value)); return true;
        default: return false;
        }
    }

    @Override
    public Map<String, Object> getAllOptions(Object target) {
        return ALL_OPTIONS;
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesstoken":
        case "accessToken": return java.lang.String.class;
        case "as2from":
        case "as2From": return java.lang.String.class;
        case "as2messagestructure":
        case "as2MessageStructure": return org.apache.camel.component.as2.api.AS2MessageStructure.class;
        case "as2to":
        case "as2To": return java.lang.String.class;
        case "as2version":
        case "as2Version": return java.lang.String.class;
        case "asyncmdnportnumber":
        case "asyncMdnPortNumber": return java.lang.Integer.class;
        case "attachedfilename":
        case "attachedFileName": return java.lang.String.class;
        case "clientfqdn":
        case "clientFqdn": return java.lang.String.class;
        case "compressionalgorithm":
        case "compressionAlgorithm": return org.apache.camel.component.as2.api.AS2CompressionAlgorithm.class;
        case "decryptingprivatekey":
        case "decryptingPrivateKey": return java.security.PrivateKey.class;
        case "dispositionnotificationto":
        case "dispositionNotificationTo": return java.lang.String.class;
        case "edimessagecharset":
        case "ediMessageCharset": return java.lang.String.class;
        case "edimessagetransferencoding":
        case "ediMessageTransferEncoding": return java.lang.String.class;
        case "edimessagetype":
        case "ediMessageType": return java.lang.String.class;
        case "encryptingalgorithm":
        case "encryptingAlgorithm": return org.apache.camel.component.as2.api.AS2EncryptionAlgorithm.class;
        case "encryptingcertificatechain":
        case "encryptingCertificateChain": return java.security.cert.Certificate[].class;
        case "exceptionhandler":
        case "exceptionHandler": return org.apache.camel.spi.ExceptionHandler.class;
        case "exchangepattern":
        case "exchangePattern": return org.apache.camel.ExchangePattern.class;
        case "from": return java.lang.String.class;
        case "hostnameverifier":
        case "hostnameVerifier": return javax.net.ssl.HostnameVerifier.class;
        case "httpconnectionpoolsize":
        case "httpConnectionPoolSize": return java.lang.Integer.class;
        case "httpconnectionpoolttl":
        case "httpConnectionPoolTtl": return java.time.Duration.class;
        case "httpconnectiontimeout":
        case "httpConnectionTimeout": return java.time.Duration.class;
        case "httpsockettimeout":
        case "httpSocketTimeout": return java.time.Duration.class;
        case "inbody":
        case "inBody": return java.lang.String.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "mdnaccesstoken":
        case "mdnAccessToken": return java.lang.String.class;
        case "mdnmessagetemplate":
        case "mdnMessageTemplate": return java.lang.String.class;
        case "mdnpassword":
        case "mdnPassword": return java.lang.String.class;
        case "mdnusername":
        case "mdnUserName": return java.lang.String.class;
        case "password": return java.lang.String.class;
        case "receiptdeliveryoption":
        case "receiptDeliveryOption": return java.lang.String.class;
        case "requesturi":
        case "requestUri": return java.lang.String.class;
        case "server": return java.lang.String.class;
        case "serverfqdn":
        case "serverFqdn": return java.lang.String.class;
        case "serverportnumber":
        case "serverPortNumber": return java.lang.Integer.class;
        case "signedreceiptmicalgorithms":
        case "signedReceiptMicAlgorithms": return java.lang.String.class;
        case "signingalgorithm":
        case "signingAlgorithm": return org.apache.camel.component.as2.api.AS2SignatureAlgorithm.class;
        case "signingcertificatechain":
        case "signingCertificateChain": return java.security.cert.Certificate[].class;
        case "signingprivatekey":
        case "signingPrivateKey": return java.security.PrivateKey.class;
        case "sslcontext":
        case "sslContext": return javax.net.ssl.SSLContext.class;
        case "subject": return java.lang.String.class;
        case "targethostname":
        case "targetHostname": return java.lang.String.class;
        case "targetportnumber":
        case "targetPortNumber": return java.lang.Integer.class;
        case "useragent":
        case "userAgent": return java.lang.String.class;
        case "username":
        case "userName": return java.lang.String.class;
        case "validatesigningcertificatechain":
        case "validateSigningCertificateChain": return java.security.cert.Certificate[].class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        AS2Endpoint target = (AS2Endpoint) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "accesstoken":
        case "accessToken": return target.getConfiguration().getAccessToken();
        case "as2from":
        case "as2From": return target.getConfiguration().getAs2From();
        case "as2messagestructure":
        case "as2MessageStructure": return target.getConfiguration().getAs2MessageStructure();
        case "as2to":
        case "as2To": return target.getConfiguration().getAs2To();
        case "as2version":
        case "as2Version": return target.getConfiguration().getAs2Version();
        case "asyncmdnportnumber":
        case "asyncMdnPortNumber": return target.getConfiguration().getAsyncMdnPortNumber();
        case "attachedfilename":
        case "attachedFileName": return target.getConfiguration().getAttachedFileName();
        case "clientfqdn":
        case "clientFqdn": return target.getConfiguration().getClientFqdn();
        case "compressionalgorithm":
        case "compressionAlgorithm": return target.getConfiguration().getCompressionAlgorithm();
        case "decryptingprivatekey":
        case "decryptingPrivateKey": return target.getConfiguration().getDecryptingPrivateKey();
        case "dispositionnotificationto":
        case "dispositionNotificationTo": return target.getConfiguration().getDispositionNotificationTo();
        case "edimessagecharset":
        case "ediMessageCharset": return target.getConfiguration().getEdiMessageCharset();
        case "edimessagetransferencoding":
        case "ediMessageTransferEncoding": return target.getConfiguration().getEdiMessageTransferEncoding();
        case "edimessagetype":
        case "ediMessageType": return target.getConfiguration().getEdiMessageType();
        case "encryptingalgorithm":
        case "encryptingAlgorithm": return target.getConfiguration().getEncryptingAlgorithm();
        case "encryptingcertificatechain":
        case "encryptingCertificateChain": return target.getConfiguration().getEncryptingCertificateChain();
        case "exceptionhandler":
        case "exceptionHandler": return target.getExceptionHandler();
        case "exchangepattern":
        case "exchangePattern": return target.getExchangePattern();
        case "from": return target.getConfiguration().getFrom();
        case "hostnameverifier":
        case "hostnameVerifier": return target.getConfiguration().getHostnameVerifier();
        case "httpconnectionpoolsize":
        case "httpConnectionPoolSize": return target.getConfiguration().getHttpConnectionPoolSize();
        case "httpconnectionpoolttl":
        case "httpConnectionPoolTtl": return target.getConfiguration().getHttpConnectionPoolTtl();
        case "httpconnectiontimeout":
        case "httpConnectionTimeout": return target.getConfiguration().getHttpConnectionTimeout();
        case "httpsockettimeout":
        case "httpSocketTimeout": return target.getConfiguration().getHttpSocketTimeout();
        case "inbody":
        case "inBody": return target.getInBody();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "mdnaccesstoken":
        case "mdnAccessToken": return target.getConfiguration().getMdnAccessToken();
        case "mdnmessagetemplate":
        case "mdnMessageTemplate": return target.getConfiguration().getMdnMessageTemplate();
        case "mdnpassword":
        case "mdnPassword": return target.getConfiguration().getMdnPassword();
        case "mdnusername":
        case "mdnUserName": return target.getConfiguration().getMdnUserName();
        case "password": return target.getConfiguration().getPassword();
        case "receiptdeliveryoption":
        case "receiptDeliveryOption": return target.getConfiguration().getReceiptDeliveryOption();
        case "requesturi":
        case "requestUri": return target.getConfiguration().getRequestUri();
        case "server": return target.getConfiguration().getServer();
        case "serverfqdn":
        case "serverFqdn": return target.getConfiguration().getServerFqdn();
        case "serverportnumber":
        case "serverPortNumber": return target.getConfiguration().getServerPortNumber();
        case "signedreceiptmicalgorithms":
        case "signedReceiptMicAlgorithms": return target.getConfiguration().getSignedReceiptMicAlgorithms();
        case "signingalgorithm":
        case "signingAlgorithm": return target.getConfiguration().getSigningAlgorithm();
        case "signingcertificatechain":
        case "signingCertificateChain": return target.getConfiguration().getSigningCertificateChain();
        case "signingprivatekey":
        case "signingPrivateKey": return target.getConfiguration().getSigningPrivateKey();
        case "sslcontext":
        case "sslContext": return target.getConfiguration().getSslContext();
        case "subject": return target.getConfiguration().getSubject();
        case "targethostname":
        case "targetHostname": return target.getConfiguration().getTargetHostname();
        case "targetportnumber":
        case "targetPortNumber": return target.getConfiguration().getTargetPortNumber();
        case "useragent":
        case "userAgent": return target.getConfiguration().getUserAgent();
        case "username":
        case "userName": return target.getConfiguration().getUserName();
        case "validatesigningcertificatechain":
        case "validateSigningCertificateChain": return target.getConfiguration().getValidateSigningCertificateChain();
        default: return null;
        }
    }
}


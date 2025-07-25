/*
 * Camel EndpointConfiguration generated by camel-api-component-maven-plugin
 */
package org.apache.camel.component.google.mail;

import org.apache.camel.spi.ApiMethod;
import org.apache.camel.spi.ApiParam;
import org.apache.camel.spi.ApiParams;
import org.apache.camel.spi.Configurer;
import org.apache.camel.spi.UriParam;
import org.apache.camel.spi.UriParams;

/**
 * Camel endpoint configuration for {@link com.google.api.services.gmail.Gmail.Users.History}.
 */
@ApiParams(apiName = "history", 
           description = "The history collection of methods",
           apiMethods = {@ApiMethod(methodName = "list", description="Lists the history of all changes to the given mailbox", signatures={"com.google.api.services.gmail.Gmail$Users$History$List list(String userId)"})}, aliases = {})
@UriParams
@Configurer(extended = true)
public final class GmailUsersHistoryEndpointConfiguration extends GoogleMailConfiguration {
    @UriParam
    @ApiParam(optional = true, apiMethods = {@ApiMethod(methodName = "list", description="History types to be returned by the function")})
    private java.util.List historyTypes;
    @UriParam
    @ApiParam(optional = true, apiMethods = {@ApiMethod(methodName = "list", description="Only return messages with a label matching the ID")})
    private java.lang.String labelId;
    @UriParam
    @ApiParam(optional = true, apiMethods = {@ApiMethod(methodName = "list", description="Maximum number of history records to return")})
    private java.lang.Long maxResults;
    @UriParam
    @ApiParam(optional = true, apiMethods = {@ApiMethod(methodName = "list", description="Page token to retrieve a specific page of results in the list")})
    private java.lang.String pageToken;
    @UriParam
    @ApiParam(optional = true, apiMethods = {@ApiMethod(methodName = "list", description="Required")})
    private java.math.BigInteger startHistoryId;
    @UriParam
    @ApiParam(optional = false, apiMethods = {@ApiMethod(methodName = "list", description="The user's email address. The special value me can be used to indicate the authenticated user. default: me")})
    private String userId;

    public java.util.List getHistoryTypes() {
        return historyTypes;
    }

    public void setHistoryTypes(java.util.List historyTypes) {
        this.historyTypes = historyTypes;
    }

    public java.lang.String getLabelId() {
        return labelId;
    }

    public void setLabelId(java.lang.String labelId) {
        this.labelId = labelId;
    }

    public java.lang.Long getMaxResults() {
        return maxResults;
    }

    public void setMaxResults(java.lang.Long maxResults) {
        this.maxResults = maxResults;
    }

    public java.lang.String getPageToken() {
        return pageToken;
    }

    public void setPageToken(java.lang.String pageToken) {
        this.pageToken = pageToken;
    }

    public java.math.BigInteger getStartHistoryId() {
        return startHistoryId;
    }

    public void setStartHistoryId(java.math.BigInteger startHistoryId) {
        this.startHistoryId = startHistoryId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }
}

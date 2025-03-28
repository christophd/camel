/* Generated by camel build tools - do NOT edit this file! */
package org.apache.camel.component.sql;

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
public class SqlComponentConfigurer extends PropertyConfigurerSupport implements GeneratedPropertyConfigurer, PropertyConfigurerGetter {

    @Override
    public boolean configure(CamelContext camelContext, Object obj, String name, Object value, boolean ignoreCase) {
        SqlComponent target = (SqlComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": target.setAutowiredEnabled(property(camelContext, boolean.class, value)); return true;
        case "batchautocommitdisabled":
        case "batchAutoCommitDisabled": target.setBatchAutoCommitDisabled(property(camelContext, boolean.class, value)); return true;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": target.setBridgeErrorHandler(property(camelContext, boolean.class, value)); return true;
        case "datasource":
        case "dataSource": target.setDataSource(property(camelContext, javax.sql.DataSource.class, value)); return true;
        case "fetchsize":
        case "fetchSize": target.setFetchSize(property(camelContext, int.class, value)); return true;
        case "healthcheckconsumerenabled":
        case "healthCheckConsumerEnabled": target.setHealthCheckConsumerEnabled(property(camelContext, boolean.class, value)); return true;
        case "healthcheckproducerenabled":
        case "healthCheckProducerEnabled": target.setHealthCheckProducerEnabled(property(camelContext, boolean.class, value)); return true;
        case "lazystartproducer":
        case "lazyStartProducer": target.setLazyStartProducer(property(camelContext, boolean.class, value)); return true;
        case "rowmapperfactory":
        case "rowMapperFactory": target.setRowMapperFactory(property(camelContext, org.apache.camel.component.sql.RowMapperFactory.class, value)); return true;
        case "servicelocationenabled":
        case "serviceLocationEnabled": target.setServiceLocationEnabled(property(camelContext, boolean.class, value)); return true;
        case "useplaceholder":
        case "usePlaceholder": target.setUsePlaceholder(property(camelContext, boolean.class, value)); return true;
        default: return false;
        }
    }

    @Override
    public String[] getAutowiredNames() {
        return new String[]{"dataSource", "rowMapperFactory"};
    }

    @Override
    public Class<?> getOptionType(String name, boolean ignoreCase) {
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return boolean.class;
        case "batchautocommitdisabled":
        case "batchAutoCommitDisabled": return boolean.class;
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return boolean.class;
        case "datasource":
        case "dataSource": return javax.sql.DataSource.class;
        case "fetchsize":
        case "fetchSize": return int.class;
        case "healthcheckconsumerenabled":
        case "healthCheckConsumerEnabled": return boolean.class;
        case "healthcheckproducerenabled":
        case "healthCheckProducerEnabled": return boolean.class;
        case "lazystartproducer":
        case "lazyStartProducer": return boolean.class;
        case "rowmapperfactory":
        case "rowMapperFactory": return org.apache.camel.component.sql.RowMapperFactory.class;
        case "servicelocationenabled":
        case "serviceLocationEnabled": return boolean.class;
        case "useplaceholder":
        case "usePlaceholder": return boolean.class;
        default: return null;
        }
    }

    @Override
    public Object getOptionValue(Object obj, String name, boolean ignoreCase) {
        SqlComponent target = (SqlComponent) obj;
        switch (ignoreCase ? name.toLowerCase() : name) {
        case "autowiredenabled":
        case "autowiredEnabled": return target.isAutowiredEnabled();
        case "batchautocommitdisabled":
        case "batchAutoCommitDisabled": return target.isBatchAutoCommitDisabled();
        case "bridgeerrorhandler":
        case "bridgeErrorHandler": return target.isBridgeErrorHandler();
        case "datasource":
        case "dataSource": return target.getDataSource();
        case "fetchsize":
        case "fetchSize": return target.getFetchSize();
        case "healthcheckconsumerenabled":
        case "healthCheckConsumerEnabled": return target.isHealthCheckConsumerEnabled();
        case "healthcheckproducerenabled":
        case "healthCheckProducerEnabled": return target.isHealthCheckProducerEnabled();
        case "lazystartproducer":
        case "lazyStartProducer": return target.isLazyStartProducer();
        case "rowmapperfactory":
        case "rowMapperFactory": return target.getRowMapperFactory();
        case "servicelocationenabled":
        case "serviceLocationEnabled": return target.isServiceLocationEnabled();
        case "useplaceholder":
        case "usePlaceholder": return target.isUsePlaceholder();
        default: return null;
        }
    }
}


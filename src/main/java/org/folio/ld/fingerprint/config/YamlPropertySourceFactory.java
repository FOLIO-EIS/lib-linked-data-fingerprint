package org.folio.ld.fingerprint.config;

import lombok.NonNull;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

public class YamlPropertySourceFactory implements PropertySourceFactory {

  @Override
  @NonNull
  public PropertySource<?> createPropertySource(String name, @NonNull EncodedResource encodedResource) {
    var factory = new YamlPropertiesFactoryBean();
    factory.setResources(encodedResource.getResource());
    var properties = factory.getObject();
    return new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
  }
}

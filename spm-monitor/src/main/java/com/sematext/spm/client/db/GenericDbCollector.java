/*
 * Licensed to Sematext Group, Inc
 *
 * See the NOTICE file distributed with
 * this work for additional information regarding copyright
 * ownership. Sematext Group, Inc licenses this file to you under
 * the Apache License, Version 2.0 (the "License"); you may
 * not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 * http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing,
 * software distributed under the License is distributed on an
 * "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
 * KIND, either express or implied.  See the License for the
 * specific language governing permissions and limitations
 * under the License.
 */
package com.sematext.spm.client.db;

import java.util.Map;

import com.sematext.spm.client.ConfigurationFailedException;
import com.sematext.spm.client.GenericMultipleStatsCollector;
import com.sematext.spm.client.MonitorConfig;
import com.sematext.spm.client.Serializer;
import com.sematext.spm.client.StatsCollectorBadConfigurationException;

public class GenericDbCollector extends GenericMultipleStatsCollector<GenericDbExtractor, DbStatsExtractorConfig> {
  public GenericDbCollector(String collectorsGroup, Serializer serializer, MonitorConfig monitorConfig,
                            String configName, String realMonitoredBeanPath,
                            String configBeanName, String monitoredBeanConfigPath,
                            DbStatsExtractorConfig originalConfig, Map<String, String> beanPathTags)
      throws StatsCollectorBadConfigurationException, ConfigurationFailedException {
    super(collectorsGroup, serializer, monitorConfig, configName, realMonitoredBeanPath, configBeanName, monitoredBeanConfigPath, originalConfig, beanPathTags);
  }

  @Override
  protected GenericDbExtractor createExtractor(MonitorConfig monitorConfig, String realMonitoredBeanPath,
                                               String configBeanName,
                                               String monitoredBeanConfigPath, DbStatsExtractorConfig originalConfig,
                                               Map<String, String> beanPathTags)
      throws StatsCollectorBadConfigurationException, ConfigurationFailedException {

    return new GenericDbExtractor(realMonitoredBeanPath, configBeanName, originalConfig, beanPathTags, true);
  }
}

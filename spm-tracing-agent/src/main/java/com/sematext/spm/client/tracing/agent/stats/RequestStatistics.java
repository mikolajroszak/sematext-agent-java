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
package com.sematext.spm.client.tracing.agent.stats;

import com.sematext.spm.client.tracing.agent.model.Call;
import com.sematext.spm.client.tracing.agent.model.PartialTransaction;

public class RequestStatistics extends Statistics<String, RequestMetric> implements StatisticsProcessor {

  private final MutableVarProvider varProvider;

  public RequestStatistics(MutableVarProvider varProvider) {
    this.varProvider = varProvider;
  }

  @Override
  protected RequestMetric newMetric(String request) {
    return new RequestMetric(request, varProvider);
  }

  @Override
  public void process(PartialTransaction transaction) {
    for (Call call : transaction.getCalls()) {
      update(transaction.getRequest(), transaction, call);
    }
  }
}

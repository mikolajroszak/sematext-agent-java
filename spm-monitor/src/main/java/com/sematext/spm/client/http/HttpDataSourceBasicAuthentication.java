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
package com.sematext.spm.client.http;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.client.methods.HttpRequestBase;

public class HttpDataSourceBasicAuthentication implements HttpDataSourceAuthentication {
  private String encodedUsernamePassword;

  public HttpDataSourceBasicAuthentication(String username, String password) {
    encodedUsernamePassword = new String(Base64.encodeBase64((username + ":" + password).getBytes()));
  }

  @Override
  public void decorateRequest(HttpRequestBase request) {
    request.addHeader("Authorization", "Basic " + encodedUsernamePassword);
  }
}

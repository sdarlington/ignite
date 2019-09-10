/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.ignite.plugin.security;

import org.apache.ignite.IgniteCheckedException;

/**
 * Implementation for {@link SecurityCredentialsProvider}. Use it
 * when custom logic for storing security credentials is not required but it
 * is not OK to specify credentials directly in configuration.
 */
public class SecurityCredentialsEnvironmentProvider implements SecurityCredentialsProvider {
    private static final String IGNITE_USERNAME_ENVIRONMENT_VARIABLE = "IGNITE_USERNAME";
    private static final String IGNITE_PASSWORD_ENVIRONMENT_VARIABLE = "IGNITE_PASSWORD";

    /** {@inheritDoc} */
    @Override public SecurityCredentials credentials() throws IgniteCheckedException {
        String username = System.getenv(IGNITE_USERNAME_ENVIRONMENT_VARIABLE);
        String password = System.getenv(IGNITE_PASSWORD_ENVIRONMENT_VARIABLE);

        if (username == null || username.isEmpty()) {
            throw new IgniteCheckedException("Username environemnt variable " + IGNITE_USERNAME_ENVIRONMENT_VARIABLE + " not set.");
        }
        if (password == null || password.isEmpty()) {
            throw new IgniteCheckedException("Password environemnt variable " + IGNITE_PASSWORD_ENVIRONMENT_VARIABLE + " not set.");
        }

        return new SecurityCredentials(username, password);
    }
}

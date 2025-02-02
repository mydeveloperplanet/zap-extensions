/*
 * Zed Attack Proxy (ZAP) and its related class files.
 *
 * ZAP is an HTTP/HTTPS proxy for assessing web application security.
 *
 * Copyright 2021 The ZAP Development Team
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.zaproxy.addon.oast.services.boast;

import org.zaproxy.zap.common.VersionedAbstractParam;

public class BoastParam extends VersionedAbstractParam {

    private static final int PARAM_CURRENT_VERSION = 1;

    private static final String PARAM_BASE_KEY = "oast.boast";
    private static final String PARAM_BOAST_URI = PARAM_BASE_KEY + ".uri";

    private String boastUri;

    @Override
    protected void parseImpl() {
        boastUri = getString(PARAM_BOAST_URI, "https://odiss.eu:1337/events");
    }

    public String getBoastUri() {
        return boastUri;
    }

    public void setBoastUri(String boastUri) {
        this.boastUri = boastUri;
        getConfig().setProperty(PARAM_BOAST_URI, boastUri);
    }

    @Override
    protected String getConfigVersionKey() {
        return PARAM_BASE_KEY + VERSION_ATTRIBUTE;
    }

    @Override
    protected int getCurrentVersion() {
        return PARAM_CURRENT_VERSION;
    }

    @Override
    protected void updateConfigsImpl(int fileVersion) {}
}

/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.apache.shardingsphere.mode.manager.cluster.service;

import org.apache.shardingsphere.mode.manager.ContextManager;
import org.apache.shardingsphere.mode.service.persist.MetaDataManagerPersistService;
import org.apache.shardingsphere.mode.service.persist.PersistServiceBuilder;
import org.apache.shardingsphere.mode.service.persist.ProcessPersistService;

/**
 * Cluster persist service builder.
 */
public final class ClusterPersistServiceBuilder implements PersistServiceBuilder {
    
    @Override
    public MetaDataManagerPersistService buildMetaDataManagerPersistService(final ContextManager contextManager) {
        return new ClusterMetaDataManagerPersistService(contextManager);
    }
    
    @Override
    public ProcessPersistService buildProcessPersistService(final ContextManager contextManager) {
        return new ClusterProcessPersistService(contextManager.getRepository());
    }
    
    @Override
    public Object getType() {
        return "Cluster";
    }
}
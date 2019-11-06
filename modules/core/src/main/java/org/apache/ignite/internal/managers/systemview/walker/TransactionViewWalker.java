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

package org.apache.ignite.internal.managers.systemview.walker;

import java.util.UUID;
import org.apache.ignite.lang.IgniteUuid;
import org.apache.ignite.spi.systemview.view.SystemViewRowAttributeWalker;
import org.apache.ignite.spi.systemview.view.TransactionView;
import org.apache.ignite.transactions.TransactionConcurrency;
import org.apache.ignite.transactions.TransactionIsolation;
import org.apache.ignite.transactions.TransactionState;

/**
 * Generated by {@code org.apache.ignite.codegen.SystemViewRowAttributeWalkerGenerator}.
 * {@link TransactionView} attributes walker.
 * 
 * @see TransactionView
 */
public class TransactionViewWalker implements SystemViewRowAttributeWalker<TransactionView> {
    /** {@inheritDoc} */
    @Override public void visitAll(AttributeVisitor v) {
        v.accept(0, "originatingNodeId", UUID.class);
        v.accept(1, "state", TransactionState.class);
        v.accept(2, "xid", IgniteUuid.class);
        v.accept(3, "label", String.class);
        v.accept(4, "startTime", long.class);
        v.accept(5, "isolation", TransactionIsolation.class);
        v.accept(6, "concurrency", TransactionConcurrency.class);
        v.accept(7, "keysCount", int.class);
        v.accept(8, "cacheIds", String.class);
        v.accept(9, "colocated", boolean.class);
        v.accept(10, "dht", boolean.class);
        v.accept(11, "duration", long.class);
        v.accept(12, "implicit", boolean.class);
        v.accept(13, "implicitSingle", boolean.class);
        v.accept(14, "internal", boolean.class);
        v.accept(15, "local", boolean.class);
        v.accept(16, "localNodeId", UUID.class);
        v.accept(17, "near", boolean.class);
        v.accept(18, "onePhaseCommit", boolean.class);
        v.accept(19, "otherNodeId", UUID.class);
        v.accept(20, "subjectId", UUID.class);
        v.accept(21, "system", boolean.class);
        v.accept(22, "threadId", long.class);
        v.accept(23, "timeout", long.class);
        v.accept(24, "topVer", String.class);
    }

    /** {@inheritDoc} */
    @Override public void visitAll(TransactionView row, AttributeWithValueVisitor v) {
        v.accept(0, "originatingNodeId", UUID.class, row.originatingNodeId());
        v.accept(1, "state", TransactionState.class, row.state());
        v.accept(2, "xid", IgniteUuid.class, row.xid());
        v.accept(3, "label", String.class, row.label());
        v.acceptLong(4, "startTime", row.startTime());
        v.accept(5, "isolation", TransactionIsolation.class, row.isolation());
        v.accept(6, "concurrency", TransactionConcurrency.class, row.concurrency());
        v.acceptInt(7, "keysCount", row.keysCount());
        v.accept(8, "cacheIds", String.class, row.cacheIds());
        v.acceptBoolean(9, "colocated", row.colocated());
        v.acceptBoolean(10, "dht", row.dht());
        v.acceptLong(11, "duration", row.duration());
        v.acceptBoolean(12, "implicit", row.implicit());
        v.acceptBoolean(13, "implicitSingle", row.implicitSingle());
        v.acceptBoolean(14, "internal", row.internal());
        v.acceptBoolean(15, "local", row.local());
        v.accept(16, "localNodeId", UUID.class, row.localNodeId());
        v.acceptBoolean(17, "near", row.near());
        v.acceptBoolean(18, "onePhaseCommit", row.onePhaseCommit());
        v.accept(19, "otherNodeId", UUID.class, row.otherNodeId());
        v.accept(20, "subjectId", UUID.class, row.subjectId());
        v.acceptBoolean(21, "system", row.system());
        v.acceptLong(22, "threadId", row.threadId());
        v.acceptLong(23, "timeout", row.timeout());
        v.accept(24, "topVer", String.class, row.topVer());
    }

    /** {@inheritDoc} */
    @Override public int count() {
        return 25;
    }
}

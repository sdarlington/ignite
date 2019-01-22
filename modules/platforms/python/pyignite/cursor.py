# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

# Licensed to the Apache Software Foundation (ASF) under one or more
# contributor license agreements.  See the NOTICE file distributed with
# this work for additional information regarding copyright ownership.
# The ASF licenses this file to You under the Apache License, Version 2.0
# (the "License"); you may not use this file except in compliance with
# the License.  You may obtain a copy of the License at
#
#      http://www.apache.org/licenses/LICENSE-2.0
#
# Unless required by applicable law or agreed to in writing, software
# distributed under the License is distributed on an "AS IS" BASIS,
# WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
# See the License for the specific language governing permissions and
# limitations under the License.

"""
This module contains `Connection` class, that wraps TCP socket handling,
as well as Ignite protocol handshaking.
"""

import itertools

class Cursor:
  """Implements cursor class for DBAPI"""
    
  def __init__(self, client):
  	self.description = None
  	self.rowcount = -1
  	self.arraysize = 1
  	self.client = client
  	
  def close(self):
    self.client.close()

  def execute(self,operation, args=None):
    self.result = self.client.sql(operation, query_args=args)
    self.description = (operation, 'type_code', None, None, None, None, True)
  
  def executemany(self,operation,parameters):
    pass
  
  def fetchone(self):
    return next(self.result)
  
  def fetchmany(self,size=None):
    r = []
    for x in itertools.islice(self.result,size or self.arraysize):
      r.append(x)
    return r
  
  def fetchall(self):
    r = []
    for x in self.result:
      r.append(x)
    return r
  
  
  
  

/*
 * Copyright 2011-2021 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package org.springframework.data.neo4j.documentation.repositories.populators;

import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;

/**
 * @author Gerrit Meier
 * @author Michael J. Simons
 */
@Node("Person")
public class PersonEntity {

	@Id private final String name;

	private Long born;

	public PersonEntity(String name, Long born) {
		this.born = born;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public Long getBorn() {
		return born;
	}

	public void setBorn(Long born) {
		this.born = born;
	}
}

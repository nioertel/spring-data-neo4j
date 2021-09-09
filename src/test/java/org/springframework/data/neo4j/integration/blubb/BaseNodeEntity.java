package org.springframework.data.neo4j.integration.blubb;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.NonFinal;
import org.springframework.data.neo4j.core.schema.GeneratedValue;
import org.springframework.data.neo4j.core.schema.Id;
import org.springframework.data.neo4j.core.schema.Node;
import org.springframework.data.neo4j.core.schema.Relationship;

import static org.springframework.data.neo4j.core.schema.Relationship.Direction.OUTGOING;

@Node
@NonFinal
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BaseNodeEntity {
	@Id
	@GeneratedValue(GeneratedValue.UUIDGenerator.class)
	@EqualsAndHashCode.Include
	String nodeId;

	@Relationship(type = "CHILD_OF", direction = OUTGOING)
	BaseNodeEntity childOf;
}
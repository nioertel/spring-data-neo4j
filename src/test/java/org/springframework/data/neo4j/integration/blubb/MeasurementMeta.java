package org.springframework.data.neo4j.integration.blubb;

import lombok.Data;
import lombok.EqualsAndHashCode;

@org.springframework.data.neo4j.core.schema.Node
@Data
@EqualsAndHashCode(callSuper = true, onlyExplicitlyIncluded = true)
public class MeasurementMeta extends BaseNodeEntity {
}
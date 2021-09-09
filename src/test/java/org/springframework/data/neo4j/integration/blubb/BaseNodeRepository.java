package org.springframework.data.neo4j.integration.blubb;

import org.springframework.data.neo4j.repository.Neo4jRepository;

import java.util.Optional;

public interface BaseNodeRepository<T extends BaseNodeEntity> extends Neo4jRepository<T, String> {
	<R> Optional<R> findNodeByNodeId(String nodeId, Class<R> clazz);
}
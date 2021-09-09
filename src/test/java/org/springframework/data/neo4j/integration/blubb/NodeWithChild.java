package org.springframework.data.neo4j.integration.blubb;

import java.util.Set;

interface NodeWithChild extends NodeWithoutChild {
	Set<NodeWithoutChild> getChildNodes();
}
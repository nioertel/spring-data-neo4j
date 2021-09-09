package org.springframework.data.neo4j.integration.blubb;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.neo4j.driver.Driver;
import org.neo4j.driver.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.neo4j.config.AbstractNeo4jConfig;
import org.springframework.data.neo4j.core.DatabaseSelection;
import org.springframework.data.neo4j.repository.config.EnableNeo4jRepositories;
import org.springframework.data.neo4j.test.Neo4jExtension;
import org.springframework.test.context.junit.jupiter.SpringJUnitConfig;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@ExtendWith(Neo4jExtension.class)
@SpringJUnitConfig(Ding.Config.class)
class Ding {

	protected static Neo4jExtension.Neo4jConnectionSupport neo4jConnectionSupport;
	protected static DatabaseSelection databaseSelection = DatabaseSelection.undecided();

	private final Driver driver;
	private final BaseNodeRepository<Node> nodeRepository;

	@Autowired
	Ding(Driver driver, BaseNodeRepository<Node> nodeRepository) {
		this.driver = driver;
		this.nodeRepository = nodeRepository;
	}

	@BeforeEach
	void prepareData() {
		try (Session session = driver.session()) {
			session.run("MATCH (n) DETACH DELETE n");

			String query = "CREATE (root:Node:BaseNodeEntity{nodeId: 'root'})" +
					"CREATE (company:Node:BaseNodeEntity{nodeId: 'comp'})" +
					"CREATE (location1:Node:BaseNodeEntity{nodeId: 'location1'})" +
					"CREATE (location2:Node:BaseNodeEntity{nodeId: 'location2'})" +
					"CREATE (meter1:MeasurementMeta:BaseNodeEntity{nodeId: 'meter1'})" +
					"CREATE (meter2:MeasurementMeta:BaseNodeEntity{nodeId: 'meter2'})" +
					"CREATE (meter1)-[:CHILD_OF]->(location1)" +
					"CREATE (meter2)-[:CHILD_OF]->(location2)" +
					"CREATE (location1)-[:CHILD_OF]->(company)" +
					"CREATE (location2)-[:CHILD_OF]->(company)" +
					"CREATE (company)-[:CHILD_OF]->(root)";

			session.run(query);
		}
 	}

 	@Test
	void asd() {
		nodeRepository.findNodeByNodeId("root", NodeWithChild.class);
	}


	@Configuration
	@EnableNeo4jRepositories(considerNestedRepositories = true)
	@EnableTransactionManagement
	static class Config extends AbstractNeo4jConfig {

		@Bean
		public Driver driver() {
			return neo4jConnectionSupport.getDriver();
		}

	}
}

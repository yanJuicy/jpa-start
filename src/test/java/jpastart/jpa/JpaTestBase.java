package jpastart.jpa;

import org.junit.Rule;

import jpastart.util.DBTestResource;

public class JpaTestBase {

	@Rule
	public DBTestResource resource = new DBTestResource();
}

/*
 *  (c) tolina GmbH, 2015
 */
package de.tolina.sonar.plugins.vft.checks;

import org.junit.Before;
import org.junit.Test;
import org.sonar.java.checks.verifier.JavaCheckVerifier;

/**
 * Test: {@link UnexpectedAccessCheck}
 */
public class UnexpectedAccessCheckTest {

	private UnexpectedAccessCheck check;

	@SuppressWarnings("javadoc")
	@Before
	public void initVerifier() {
		check = new UnexpectedAccessCheck();
	}

	@SuppressWarnings("javadoc")
	@Test
	public void test_InvokedFromOtherClass() {
		JavaCheckVerifier.verify("src/test/java/de/tolina/sonar/plugins/vft/checks/UnexpectedAccessCheckTestClassCaller.java", check);
	}

	@SuppressWarnings("javadoc")
	@Test
	public void test_InvokedFromSameClass() {
		JavaCheckVerifier.verifyNoIssue("src/test/java/de/tolina/sonar/plugins/vft/checks/UnexpectedAccessCheckTestClassCallee.java", check);
	}
}

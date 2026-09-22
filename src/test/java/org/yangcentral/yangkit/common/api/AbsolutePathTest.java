package org.yangcentral.yangkit.common.api;

import org.jaxen.NamespaceContext;
import org.junit.jupiter.api.Test;

import java.net.URI;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class AbsolutePathTest {
    private static final String NAMESPACE = "urn:example";
    private static final NamespaceContext NAMESPACE_CONTEXT =
            prefix -> "ex".equals(prefix) ? NAMESPACE : null;

    @Test
    void parsesAndRendersKeylessListPosition() {
        AbsolutePath path = AbsolutePath.parse(
                "/ex:stats/ex:port[3]", NAMESPACE_CONTEXT, URI.create(NAMESPACE));

        assertEquals(3, path.getSteps().get(1).getPosition());
        assertEquals("/ex:stats/ex:port[3]", path.toString());
    }

    @Test
    void positionMustBePositive() {
        assertThrows(IllegalArgumentException.class, () ->
                AbsolutePath.parse("/ex:stats/ex:port[0]",
                        NAMESPACE_CONTEXT, URI.create(NAMESPACE)));
    }

    @Test
    void positionalPredicateCannotBeCombinedWithKeyPredicates() {
        assertThrows(IllegalArgumentException.class, () ->
                AbsolutePath.parse("/ex:stats/ex:port[3][ex:name='eth0']",
                        NAMESPACE_CONTEXT, URI.create(NAMESPACE)));
    }
}

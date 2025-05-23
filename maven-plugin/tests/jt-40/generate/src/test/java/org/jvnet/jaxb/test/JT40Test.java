package org.jvnet.jaxb.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.jvnet.jaxb.main.AFail;
import org.jvnet.jaxb.main.ASuccess;

public class JT40Test {

    @Test
    public void testGeneratedTestSourcesNoClassRefTestInMain() throws Exception {
        ASuccess a = new ASuccess();
        Assertions.assertEquals("OK", a.getB().getB2());

        ASuccess aOther = new ASuccess("OK Too");
        Assertions.assertEquals("OK Too", aOther.getB().getB2());
    }

    @Test
    public void testGeneratedTestSourcesClassRefTestInMain() throws Exception {
        try {
            AFail a = new AFail();
            Assertions.assertEquals(generated.PurchaseOrderType.class.getName(), a.getB().getB2());
        } catch (ClassNotFoundException e) {
            Assertions.fail("Exception thrown (but should not)");
        }

        AFail aOther = new AFail("OK");
        Assertions.assertEquals("OK", aOther.getB().getB2());
    }
}

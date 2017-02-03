package core;

import org.junit.Test;
import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by davidsuarez on 1/30/17.
 */
public class ContainerTest {

    @Test
    public void calculateCostTest() {

        Map<String, HiearchyDefinition> hiearchyMap = new HashMap<>();
        hiearchyMap.put("DC1", new HiearchyDefinition(null, new String[]{"HV1"} ));
        hiearchyMap.put("HV1", new HiearchyDefinition(new String[]{"DC1"} , new String[]{"C1", "C2"} ));
        hiearchyMap.put("HV2", new HiearchyDefinition(new String[]{"DC1"} , new String[]{"C3", "C4"} ));

        Hierarchy hierarchy = new Hierarchy(hiearchyMap);
        Map<String, Container> containerMap = new HashMap<>();

        Container container1 = new ContainerImpl(hierarchy, "DC1");
        Container container2 = new ContainerImpl(hierarchy, "HV1");
        Container container3 = new ContainerImpl(hierarchy, "HV2");
        Container container4 = new ContainerImpl(hierarchy, "C1");
        Container container5 = new ContainerImpl(hierarchy, "C2");
        Container container6 = new ContainerImpl(hierarchy, "C3");
        Container container7 = new ContainerImpl(hierarchy, "C4");

        assertEquals(container2.calculateCost(), 30);

    }
}

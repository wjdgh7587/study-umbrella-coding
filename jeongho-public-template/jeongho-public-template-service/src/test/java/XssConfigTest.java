import com.navercorp.lucy.security.xss.servletfilter.XssEscapeFilterConfig;
import com.navercorp.lucy.security.xss.servletfilter.defender.XssFilterDefender;
import com.navercorp.lucy.security.xss.servletfilter.defender.XssPreventerDefender;
import com.navercorp.lucy.security.xss.servletfilter.defender.XssSaxFilterDefender;
import lombok.extern.slf4j.Slf4j;
import org.junit.BeforeClass;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;


@Slf4j
@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class XssConfigTest {

    static XssEscapeFilterConfig config;

    @BeforeClass
    public static void init() {
        config = new XssEscapeFilterConfig();
    }


    @Test
    void testWhenNotExistingConfigFile() {
        Assertions.assertThrows(IllegalStateException.class, () ->{
           new XssEscapeFilterConfig("UNKNOWN-FILE.xml");
        });
    }

    @Test
    public void testWhenUnknownDefenderClass() {
        Assertions.assertThrows(IllegalStateException.class, () ->{
            new XssEscapeFilterConfig("lucy-xss-servlet-filter-rule-unknown-class.xml");
        });
    }

    @Test
    void testWhenEmptyDefenderName(){
        Assertions.assertThrows(IllegalStateException.class, () ->{
            new XssEscapeFilterConfig("lucy-xss-servlet-filter-rule-empty-name.xml");
        });
    }

    @Test
    public void testGetDefaultDefender() {
        Assertions.assertThrows(NullPointerException.class, () -> {
            assertTrue(config.getDefaultDefender() instanceof XssPreventerDefender);
        });
    }

    @Test
    public void testGetDefenderMap() {

        assertThrows(NullPointerException.class, () -> {
            assertEquals(config.getDefenderMap().size(), 3);
        });

        assertTrue(config.getDefenderMap().get("xssPreventerDefender") instanceof XssPreventerDefender);
        assertTrue(config.getDefenderMap().get("xssFilterDefender") instanceof XssFilterDefender);
        assertTrue(config.getDefenderMap().get("xssSaxFilterDefender") instanceof XssSaxFilterDefender);

    }



}

import org.apache.log4j.BasicConfigurator;
import org.apache.log4j.Logger;
import org.apache.log4j.xml.DOMConfigurator;

public class TestLogs {

    private static Logger LOG = Logger.getLogger(TestLogs.class);

    public static void main(String[] args) {
        testLogger();
    }

    public static void testLogger(){
        BasicConfigurator.configure();
        DOMConfigurator.configure("loggerConfig.xml");
        LOG.trace("message from trace");
        LOG.debug("message from debug");
        LOG.info("message from info");
        LOG.warn("message from warn");
        LOG.error("message from error");
        LOG.fatal("message from fatal");
    }


}

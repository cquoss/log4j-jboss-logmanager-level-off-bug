package de.quoss.bug.jboss.logmananger.log4j;

import de.quoss.test.log.producer.log4j.Log4jLogMsgProducer;
import org.jboss.logging.Logger;
import org.jboss.logging.MDC;

public class Main {

    private static final Logger LOGGER = Logger.getLogger(Main.class);

    private static final String LOG_MSG_FMT = "JBoss Logger %s message";

    private static final String MDC_KEY = "qualifier";

    public void run() {
        final String methodName = "run()";
        LOGGER.tracef("%s start", methodName);
        printLogMsgs("before");
        MDC.put(MDC_KEY, "log4j");
        Log4jLogMsgProducer.run();
        printLogMsgs("after");
        LOGGER.tracef("%s end", methodName);
    }

    private void printLogMsgs(final String qualifier) {
        MDC.put(MDC_KEY, qualifier);
        LOGGER.tracef(LOG_MSG_FMT, "Trace");
        LOGGER.debugf(LOG_MSG_FMT, "Debug");
        LOGGER.infof(LOG_MSG_FMT, "Info");
        LOGGER.warnf(LOG_MSG_FMT, "Warn");
        LOGGER.errorf(LOG_MSG_FMT, "Error");
        LOGGER.fatalf(LOG_MSG_FMT, "Fatal");
    }

}

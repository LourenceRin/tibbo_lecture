
import com.tibbo.aggregate.common.Log;
import com.tibbo.aggregate.common.agent.Agent;
import com.tibbo.aggregate.common.agent.AgentContext;
import com.tibbo.aggregate.common.agent.HistoricalValue;
import com.tibbo.aggregate.common.context.*;
import com.tibbo.aggregate.common.data.Event;
import com.tibbo.aggregate.common.datatable.*;
import com.tibbo.aggregate.common.device.DisconnectionException;
import com.tibbo.aggregate.common.event.EventHandlingException;
import com.tibbo.aggregate.common.protocol.RemoteServer;
import com.tibbo.aggregate.common.util.SyntaxErrorException;
import com.tibbo.datatable.StaticDataTable;
import com.tibbo.datatable.StaticDataTableHelper;

import java.io.IOException;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.List;

import static com.tibbo.datatable.StaticDataTable.getSimpleTable;

public class DemoAgent {
    private static final String V_SETTING = "setting";
    private static final String V_PERIOD = "period";
    private static final String F_OPERATION = "operation";
    private static final String E_EVENT = "event";
    private static final String VF_SETTING_STRING = "string";
    private static final String VF_SETTING_INTEGER = "integer";
    private static final String VF_PERIOD_PERIOD = "period";
    private static final String FIF_OPERATION_LIMIT = "limit";
    private static final String FOF_OPERATION_RESULT = "result";
    private static final String EF_EVENT_DATA = "data";
    public static final TableFormat VFT_SETTING = new TableFormat(1, 100);
    private static final TableFormat VFT_PERIOD;
    public static final TableFormat FIFT_OPERATION;
    private static final TableFormat FOFT_OPERATION;
    private static final TableFormat EFT_EVENT;
    private static DataTable setting;
    private static long period;

    private static final TableFormat VFT_TEST = new TableFormat(1, 100);
    private static DataTable setting_SimpleTable;
    public static final TableFormat VFT_TEST2 = new TableFormat();


    public DemoAgent() {
    }

    public static void main(String[] args) {
        Log.start();
        beginDemo(period);
    }

    private static void beginDemo(final Long eventPeriod) {
        Thread eventGenerator = null;

        while(!Thread.currentThread().isInterrupted()) {
            try {
                final Agent agent = setUpDemoAgent(eventPeriod);
                agent.connect();
                eventGenerator = new Thread() {
                    public void run() {
                        while(!this.isInterrupted()) {
                            DemoAgent.setNewVariable(agent, eventPeriod);
                        }

                    }
                };
                runAgent(eventGenerator, agent);
            } catch (DisconnectionException var3) {
                var3.printStackTrace();
            } catch (Exception var4) {
                var4.printStackTrace();
            }

            pause();
            interruptThread(eventGenerator);
        }

    }

    public static Agent setUpDemoAgent(Long eventPeriod) {
        RemoteServer rls = new RemoteServer("104.248.243.143", 6480, "admin", "admin123");
        AgentContext agentContext = new DemoAgent.DemoAgentContext(rls, "LourenceRin", true);
        Agent agent = new Agent(agentContext, false, false, 0);
        initializeAgentContext(agent.getContext(), eventPeriod);
        return agent;
    }

    public static void setNewVariable(Agent agent, Long period) {
        try {
            Thread.currentThread();
            Thread.sleep(period);
        } catch (InterruptedException var5) {
            return;
        }

        if (agent.getContext().isSynchronized()) {
            DataTable eventData = new SimpleDataTable(agent.getContext().getEventDefinition("event").getFormat(), new Object[]{new Float(Math.random() * 1000000.0D)});
            agent.getContext().fireEvent("event", 2, eventData);
            if (Math.random() > 0.1D) {
                try {
                    agent.getContext().setVariable("setting", new Object[]{agent.getContext().getVariable("setting").rec().getString("string"), Math.random() * 1000.0D});
                } catch (ContextException var4) {
                    var4.printStackTrace();
                }
            }
        }

    }

    private static void runAgent(Thread eventGenerator, Agent agent) throws SyntaxErrorException, DisconnectionException, IOException {
        eventGenerator.setDaemon(true);
        eventGenerator.start();

        while(!Thread.currentThread().isInterrupted()) {
            agent.run();
        }

        agent.disconnect();
    }

    private static void pause() {
        try {
            Thread.currentThread();
            Thread.sleep(1000L);
        } catch (InterruptedException var1) {
            System.exit(0);
        }

    }

    private static void interruptThread(Thread eventGenerator) {
        if (eventGenerator != null) {
            eventGenerator.interrupt();
        }

    }

    private static void initializeAgentContext(AgentContext context, final Long eventPeriod) {
        VariableDefinition vd = new VariableDefinition("setting", VFT_SETTING, true, true, "Tabular Setting", "remote");
        vd.setGetter(new VariableGetter() {
            public DataTable get(Context con, VariableDefinition def, CallerController caller, RequestController request) throws ContextException {
                return DemoAgent.setting;
            }
        });
        vd.setSetter(new VariableSetter() {
            public boolean set(Context con, VariableDefinition def, CallerController caller, RequestController request, DataTable value) throws ContextException {
                DemoAgent.setting = value;
                return true;
            }
        });
        context.addVariableDefinition(vd);
        vd = new VariableDefinition("period", VFT_PERIOD, true, true, "Event Generation Period", "remote");
        vd.setGetter(new VariableGetter() {
            public DataTable get(Context con, VariableDefinition def, CallerController caller, RequestController request) throws ContextException {
                return (new DataRecord(DemoAgent.VFT_PERIOD)).addLong(eventPeriod).wrap();
            }
        });
        vd.setSetter(new VariableSetter() {
            public boolean set(Context con, VariableDefinition def, CallerController caller, RequestController request, DataTable value) throws ContextException {
                DemoAgent.period = value.rec().getLong("period");
                Log.DEVICE_AGENT.info("Server has changed event generation period to: " + DemoAgent.period);
                return true;
            }
        });
        context.addVariableDefinition(vd);
        vd = new VariableDefinition("SimpleDataTable", StaticDataTable.getSimpleTable().getFormat(), true, true, "SimpleDataTable", "remote");
        vd.setGetter(new VariableGetter() {
            public DataTable get(Context con, VariableDefinition def, CallerController caller, RequestController request) throws ContextException {
                return StaticDataTable.getSimpleTable();
            }
        });
        context.addVariableDefinition(vd);
        vd = new VariableDefinition("InnerTable", StaticDataTable.getInnerTable().getFormat(), true, true, "InnerTable", "remote");
        vd.setGetter(new VariableGetter() {
            public DataTable get(Context con, VariableDefinition def, CallerController caller, RequestController request) throws ContextException {
                return StaticDataTable.getInnerTable();
            }
        });
        context.addVariableDefinition(vd);
        vd = new VariableDefinition("BigTable", StaticDataTable.getBigTable().getFormat(), true, true, "BigTable", "remote");
        vd.setGetter(new VariableGetter() {
            public DataTable get(Context con, VariableDefinition def, CallerController caller, RequestController request) throws ContextException {
                return StaticDataTable.getBigTable();
            }
        });
        /*
        vd.setSetter(new VariableSetter() {
            public boolean set(Context con, VariableDefinition def, CallerController caller, RequestController request, DataTable value) throws ContextException {
                DemoAgent.setting_SimpleTable = value;
                return true;
            }
        });

         */
        context.addVariableDefinition(vd);
        FunctionDefinition fd = new FunctionDefinition("operation", FIFT_OPERATION, FOFT_OPERATION, "Agent Operation", "remote");
        fd.setImplementation(new FunctionImplementation() {
            public DataTable execute(Context con, FunctionDefinition def, CallerController caller, RequestController request, DataTable parameters) throws ContextException {
                int limit = parameters.rec().getInt("limit");
                int result = (int)(Math.random() * (double)limit);
                Log.DEVICE_AGENT.info("Server has executed random number generation operation with limit: " + limit + ", result: " + result);
                return (new DataRecord(def.getOutputFormat())).addInt(result).wrap();
            }
        });
        context.addFunctionDefinition(fd);
        EventDefinition ed = new EventDefinition("event", EFT_EVENT, "Agent Event", "remote");
        context.addEventDefinition(ed);
        context.addEventListener("eventConfirmed", new DefaultContextEventListener() {
            public void handle(Event event) throws EventHandlingException {
                Log.DEVICE_AGENT.info("Server has confirmed event with ID: " + event.getData().rec().getLong("id"));
            }
        });



    }

    static {
        VFT_SETTING.addField("<string><S><D=String Field>");
        VFT_SETTING.addField("<integer><I><D=Integer Field>");
        VFT_PERIOD = new TableFormat(1, 1, "<period><L><A=5000><D=Event Generation Period><V=<L=100 100000000>><E=period>");
        FIFT_OPERATION = new TableFormat(1, 1, "<limit><I><A=100><D=Limit>");
        FOFT_OPERATION = new TableFormat(1, 1, "<result><I><D=Result>");
        EFT_EVENT = new TableFormat(1, 1, "<data><F><D=Data>");
        setting = new SimpleDataTable(VFT_SETTING, true);
        period = 5000L;

        //VFT_TEST = new TableFormat(1, 1, "<period><L><A=5000><D=Event Generation Period><V=<L=100 100000000>><E=period>");
        //VFT_TEST = new TableFormat(FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, StaticDataTableHelper.DATATABLE_DESCRIPTION, getSimpleTable(), true));


        VFT_TEST.addField(FieldFormat.create(StaticDataTableHelper.FIELD_DATATABLE_FIELD, FieldFormat.DATATABLE_FIELD, StaticDataTableHelper.DATATABLE_DESCRIPTION, getSimpleTable(), true));
        setting_SimpleTable = new SimpleDataTable(VFT_TEST, true);
    }

    private static class DemoAgentContext extends AgentContext {
        private boolean sentHistory = false;

        public DemoAgentContext(RemoteServer server, String name, boolean eventConfirmation) {
            super(server, name, eventConfirmation);
        }

        protected List<HistoricalValue> getHistory() {
            if (this.sentHistory) {
                return Collections.emptyList();
            } else {
                this.sentHistory = true;
                Calendar cal = Calendar.getInstance();
                cal.setTime(new Date());
                cal.add(13, -1);
                DataTable historicalValue = new SimpleDataTable(DemoAgent.VFT_SETTING, new Object[]{"Historical Value", 456});
                HistoricalValue hv = new HistoricalValue("setting", cal.getTime(), historicalValue);
                return Collections.singletonList(hv);
            }
        }
    }
}
package helloadkjava;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;

import com.google.adk.agents.BaseAgent;
import com.google.adk.agents.LlmAgent;
import com.google.adk.tools.BaseTool;

public class HelloAssistant {

    private static final Logger logger = Logger.getLogger(HelloAssistant.class.getName());

    // --- Define Constants ---
    private static final String MODEL_NAME = "gemini-2.0-flash";

    // ROOT_AGENT needed for ADK Web UI.
    public static BaseAgent ROOT_AGENT = initAgent();

    public static BaseAgent initAgent() {
        // Set up MCP Toolbox connection to Cloud SQL
        try {

            List<BaseTool> allTools = new ArrayList<>();

            return LlmAgent.builder()
                    .model(MODEL_NAME)
                    .name("Friendly Assistant")
                    .description("Greets people")
                    .instruction(
                            """
                            You greet the person and say hello to them.
                            If they do not provide their name, you ask them for their name.
""")
                    .tools(allTools)
                    .outputKey("hello_result")
                    .build();
        } catch (Exception e) {
            logger.info("Error initializing MCP toolset and starting agent " + e.getMessage());
            return null;
        }
    }
}
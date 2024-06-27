import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class CommandGraph {
    private Map<String, Set<String>> graph = new HashMap<>();

    public void addCommand(String command, Set<String> synonyms) {
        graph.put(command, synonyms);
        for (String synonym : synonyms) {
            if (!graph.containsKey(synonym)) {
                graph.put(synonym, new HashSet<>());
            }
            graph.get(synonym).add(command);
        }
    }

    public String getCanonicalCommand(String input) {
        for (String command : graph.keySet()) {
            if (command.equals(input) || graph.get(command).contains(input)) {
                return command;
            }
        }
        return null;
    }
}
